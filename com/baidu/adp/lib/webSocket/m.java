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
    private static long CC = 0;
    private final e.a BM;
    private final l BU;
    private final ByteBuffer CA;
    private final d CB;
    private boolean CD;
    private int CE;
    private a CF;
    private int CG;
    private final f CH;
    private int CI;
    private long CJ;
    private long CK;
    private final Handler Cz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int CL;
        public boolean CM;
        public int CN;
        public int CO;
        public int CP;
        public int CQ;
        public byte[] CR;
        public byte[] CS;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.CD = false;
        this.CH = new f();
        this.CI = 0;
        this.CJ = 0L;
        this.CK = 0L;
        this.Cz = handler;
        this.BM = aVar;
        this.BU = lVar;
        this.CA = ByteBuffer.allocateDirect(lVar.iu() + 14);
        this.CB = new d(lVar.iv());
        this.CF = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.CJ = 0L;
        this.CK = 0L;
        Message obtainMessage = this.Cz.obtainMessage();
        obtainMessage.obj = obj;
        this.Cz.sendMessage(obtainMessage);
    }

    private boolean iB() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.CF == null) {
            if (this.CA.position() >= 2) {
                byte b = this.CA.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.CA.get(1);
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
                    if (!this.CD && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.CD && i4 != 0) {
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
                if (this.CA.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.CA.get(2) & 255) << 8) | (this.CA.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.CA.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.CA.get(2) & 255) << 56) | ((this.CA.get(3) & 255) << 48) | ((this.CA.get(4) & 255) << 40) | ((this.CA.get(5) & 255) << 32) | ((this.CA.get(6) & 255) << 24) | ((this.CA.get(7) & 255) << 16) | ((this.CA.get(8) & 255) << 8) | (this.CA.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.CF = new a();
                    this.CF.CL = i4;
                    this.CF.CM = z;
                    this.CF.CN = i3;
                    this.CF.CP = (int) j;
                    this.CF.CO = i2;
                    this.CF.CQ = this.CF.CO + this.CF.CP;
                    this.CF.CR = null;
                    int position = this.CA.position();
                    this.CF.CS = new byte[this.CF.CO];
                    this.CA.position(0);
                    this.CA.get(this.CF.CS, 0, this.CF.CO);
                    this.CA.position(this.CF.CO);
                    this.CA.limit(position);
                    this.CA.compact();
                    return this.CF.CP == 0 || this.CA.position() >= this.CF.CP;
                }
                return false;
            }
            return false;
        } else if (this.CG >= this.CF.CP) {
            if (this.CF.CL > 7) {
                if (this.CF.CL == 8) {
                    if (this.CF.CP < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.CF.CS[1] & 255) + ((this.CF.CS[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.CF.CP > 2) {
                            byte[] bArr2 = new byte[this.CF.CP - 2];
                            System.arraycopy(this.CF.CS, 2, bArr2, 0, this.CF.CP - 2);
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
                } else if (this.CF.CL == 9) {
                    v(this.CB.toByteArray());
                } else if (this.CF.CL == 10) {
                    w(this.CB.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.CD) {
                    this.CD = true;
                    this.CE = this.CF.CL;
                    if (this.CE == 1 && this.BU.iy()) {
                        this.CH.reset();
                    }
                }
                if (this.CE == 1 && this.BU.iy() && !this.CH.t(this.CB.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.CF.CM) {
                    if (this.CE == 1) {
                        if (this.BU.iy() && !this.CH.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.BU.it()) {
                            u(this.CB.toByteArray());
                        } else {
                            J(new String(this.CB.toByteArray(), "UTF-8"));
                        }
                    } else if (this.CE == 2) {
                        x(this.CB.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.CD = false;
                    this.CB.reset();
                }
            }
            this.CF = null;
            this.CG = 0;
            return this.CA.position() > 0;
        } else {
            int position2 = this.CA.position();
            if (this.CF.CP - this.CG < position2) {
                position2 = this.CF.CP - this.CG;
            }
            int position3 = this.CA.position();
            if (this.CF.CP > 0) {
                bArr = new byte[position2];
                this.CA.position(0);
                this.CA.get(bArr, 0, position2);
            }
            this.CA.position(position2);
            this.CA.limit(position3);
            this.CA.compact();
            if (bArr != null) {
                this.CB.write(bArr);
            }
            this.CG = position2 + this.CG;
            return this.CG >= this.CF.CP;
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
        t(new k.C0008k(bArr));
    }

    protected void J(String str) {
        t(new k.s(str));
    }

    protected void u(byte[] bArr) {
        t(new k.m(bArr));
    }

    protected void x(byte[] bArr) {
        this.CK = System.currentTimeMillis();
        t(new k.a(bArr, this.CJ, this.CK));
    }

    private boolean iC() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.CA.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.CA.get(position + 0) != 13 || this.CA.get(position + 1) != 10 || this.CA.get(position + 2) != 13 || this.CA.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.CA.position();
                Map<String, String> map = null;
                if (this.CA.get(0) == 72 && this.CA.get(1) == 84 && this.CA.get(2) == 84 && this.CA.get(3) == 80) {
                    Pair<Integer, String> iD = iD();
                    if (((Integer) iD.first).intValue() >= 300) {
                        t(new k.p(((Integer) iD.first).intValue(), (String) iD.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.CA.position(0);
                        byte[] bArr = new byte[position];
                        this.CA.get(bArr);
                        map = y(bArr);
                    }
                } else {
                    z = false;
                }
                this.CA.position(position + 4);
                this.CA.limit(position2);
                this.CA.compact();
                if (this.CI < this.BM.ic() && map.size() == 0) {
                    this.CI++;
                    return true;
                }
                this.CI = 0;
                if (!z) {
                    z2 = this.CA.position() > 0;
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
        while (i < this.CA.position() && this.CA.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.CA.position() && this.CA.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.CA.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.CA.position() && this.CA.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.CA.position(i6);
        this.CA.get(bArr, 0, i8);
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
            this.BM.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.CA.clear();
            do {
                try {
                    int read = this.BM.read(this.CA);
                    if (read > 0) {
                        if (this.CJ <= 0) {
                            this.CJ = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            CC += read;
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
            CC = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = CC;
        }
        return j;
    }
}
