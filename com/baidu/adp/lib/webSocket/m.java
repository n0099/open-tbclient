package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long CA = 0;
    private final e.a BK;
    private final l BS;
    private boolean CB;
    private int CC;
    private a CD;
    private int CE;
    private final f CF;
    private int CG;
    private long CH;
    private long CI;
    private final Handler Cx;
    private final ByteBuffer Cy;
    private final d Cz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int CJ;
        public boolean CK;
        public int CL;
        public int CM;
        public int CN;
        public int CO;
        public byte[] CP;
        public byte[] CQ;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.CB = false;
        this.CF = new f();
        this.CG = 0;
        this.CH = 0L;
        this.CI = 0L;
        this.Cx = handler;
        this.BK = aVar;
        this.BS = lVar;
        this.Cy = ByteBuffer.allocateDirect(lVar.iu() + 14);
        this.Cz = new d(lVar.iv());
        this.CD = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.CH = 0L;
        this.CI = 0L;
        Message obtainMessage = this.Cx.obtainMessage();
        obtainMessage.obj = obj;
        this.Cx.sendMessage(obtainMessage);
    }

    private boolean iB() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.CD == null) {
            if (this.Cy.position() >= 2) {
                byte b = this.Cy.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Cy.get(1);
                boolean z2 = (b2 & 128) != 0;
                int i5 = b2 & Byte.MAX_VALUE;
                if (i3 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i4 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i5 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i4 != 8 && i4 != 9 && i4 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i4);
                    }
                    if (i4 == 8 && i5 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i4 != 0 && i4 != 1 && i4 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i4);
                } else {
                    if (!this.CB && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.CB && i4 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i5 < 126) {
                    i2 = 2;
                } else if (i5 == 126) {
                    i2 = 4;
                } else if (i5 == 127) {
                    i2 = 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.Cy.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Cy.get(2) & 255) << 8) | (this.Cy.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Cy.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Cy.get(2) & 255) << 56) | ((this.Cy.get(3) & 255) << 48) | ((this.Cy.get(4) & 255) << 40) | ((this.Cy.get(5) & 255) << 32) | ((this.Cy.get(6) & 255) << 24) | ((this.Cy.get(7) & 255) << 16) | ((this.Cy.get(8) & 255) << 8) | (this.Cy.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.CD = new a();
                    this.CD.CJ = i4;
                    this.CD.CK = z;
                    this.CD.CL = i3;
                    this.CD.CN = (int) j;
                    this.CD.CM = i2;
                    this.CD.CO = this.CD.CM + this.CD.CN;
                    this.CD.CP = null;
                    int position = this.Cy.position();
                    this.CD.CQ = new byte[this.CD.CM];
                    this.Cy.position(0);
                    this.Cy.get(this.CD.CQ, 0, this.CD.CM);
                    this.Cy.position(this.CD.CM);
                    this.Cy.limit(position);
                    this.Cy.compact();
                    return this.CD.CN == 0 || this.Cy.position() >= this.CD.CN;
                }
                return false;
            }
            return false;
        } else if (this.CE >= this.CD.CN) {
            if (this.CD.CJ > 7) {
                if (this.CD.CJ == 8) {
                    if (this.CD.CN < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.CD.CQ[1] & 255) + ((this.CD.CQ[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.CD.CN > 2) {
                            byte[] bArr2 = new byte[this.CD.CN - 2];
                            System.arraycopy(this.CD.CQ, 2, bArr2, 0, this.CD.CN - 2);
                            f fVar = new f();
                            fVar.t(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.CD.CJ == 9) {
                    v(this.Cz.toByteArray());
                } else if (this.CD.CJ == 10) {
                    w(this.Cz.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.CB) {
                    this.CB = true;
                    this.CC = this.CD.CJ;
                    if (this.CC == 1 && this.BS.iy()) {
                        this.CF.reset();
                    }
                }
                if (this.CC == 1 && this.BS.iy() && !this.CF.t(this.Cz.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.CD.CK) {
                    if (this.CC == 1) {
                        if (this.BS.iy() && !this.CF.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.BS.it()) {
                            u(this.Cz.toByteArray());
                        } else {
                            I(new String(this.Cz.toByteArray(), "UTF-8"));
                        }
                    } else if (this.CC == 2) {
                        x(this.Cz.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.CB = false;
                    this.Cz.reset();
                }
            }
            this.CD = null;
            this.CE = 0;
            return this.Cy.position() > 0;
        } else {
            int position2 = this.Cy.position();
            if (this.CD.CN - this.CE < position2) {
                position2 = this.CD.CN - this.CE;
            }
            int position3 = this.Cy.position();
            if (this.CD.CN > 0) {
                bArr = new byte[position2];
                this.Cy.position(0);
                this.Cy.get(bArr, 0, position2);
            }
            this.Cy.position(position2);
            this.Cy.limit(position3);
            this.Cy.compact();
            if (bArr != null) {
                this.Cz.write(bArr);
            }
            this.CE = position2 + this.CE;
            return this.CE >= this.CD.CN;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        t(new k.q(z, map));
    }

    protected void e(int i, String str) {
        t(new k.c(i, str));
    }

    protected void v(byte[] bArr) {
        t(new k.j(bArr));
    }

    protected void w(byte[] bArr) {
        t(new k.C0009k(bArr));
    }

    protected void I(String str) {
        t(new k.s(str));
    }

    protected void u(byte[] bArr) {
        t(new k.m(bArr));
    }

    protected void x(byte[] bArr) {
        this.CI = System.currentTimeMillis();
        t(new k.a(bArr, this.CH, this.CI));
    }

    private boolean iC() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Cy.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Cy.get(position + 0) != 13 || this.Cy.get(position + 1) != 10 || this.Cy.get(position + 2) != 13 || this.Cy.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Cy.position();
                Map<String, String> map = null;
                if (this.Cy.get(0) == 72 && this.Cy.get(1) == 84 && this.Cy.get(2) == 84 && this.Cy.get(3) == 80) {
                    Pair<Integer, String> iD = iD();
                    if (((Integer) iD.first).intValue() >= 300) {
                        t(new k.p(((Integer) iD.first).intValue(), (String) iD.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Cy.position(0);
                        byte[] bArr = new byte[position];
                        this.Cy.get(bArr);
                        map = y(bArr);
                    }
                } else {
                    z = false;
                }
                this.Cy.position(position + 4);
                this.Cy.limit(position2);
                this.Cy.compact();
                if (this.CG < this.BK.ic() && map.size() == 0) {
                    this.CG++;
                    return true;
                }
                this.CG = 0;
                if (!z) {
                    z2 = this.Cy.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                z3 = z2;
            }
        }
        return z3;
    }

    private Map<String, String> y(byte[] bArr) throws UnsupportedEncodingException {
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (String str2 : split) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private Pair<Integer, String> iD() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Cy.position() && this.Cy.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Cy.position() && this.Cy.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Cy.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Cy.position() && this.Cy.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Cy.position(i6);
        this.Cy.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean iE() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return iB();
        }
        if (this.mState == 1) {
            return iC();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.BK.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Cy.clear();
            do {
                try {
                    int read = this.BK.read(this.Cy);
                    if (read > 0) {
                        if (this.CH <= 0) {
                            this.CH = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            CA += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (iE());
                    } else if (read < 0) {
                        t(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.hr()) {
                        this.mStopped = true;
                        t(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            t(new k.d(e2));
        } catch (WebSocketException e3) {
            t(new k.l(e3));
        } catch (Exception e4) {
            t(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void ik() {
        synchronized (m.class) {
            CA = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = CA;
        }
        return j;
    }
}
