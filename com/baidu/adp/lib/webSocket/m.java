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
/* loaded from: classes.dex */
public class m extends Thread {
    private static long Qs = 0;
    private final e.a PD;
    private final l PN;
    private long QB;
    private final Handler Qp;
    private final ByteBuffer Qq;
    private final d Qr;
    private boolean Qt;
    private int Qu;
    private a Qv;
    private int Qw;
    private final f Qx;
    private int Qy;
    private long Qz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int QC;
        public boolean QD;
        public int QE;
        public int QF;
        public int QG;
        public int QH;
        public byte[] QI;
        public byte[] QJ;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Qt = false;
        this.Qx = new f();
        this.Qy = 0;
        this.Qz = 0L;
        this.QB = 0L;
        this.Qp = handler;
        this.PD = aVar;
        this.PN = lVar;
        this.Qq = ByteBuffer.allocateDirect(lVar.oM() + 14);
        this.Qr = new d(lVar.oN());
        this.Qv = null;
        this.mState = 1;
    }

    protected void y(Object obj) {
        this.Qz = 0L;
        this.QB = 0L;
        Message obtainMessage = this.Qp.obtainMessage();
        obtainMessage.obj = obj;
        this.Qp.sendMessage(obtainMessage);
    }

    private boolean oT() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Qv == null) {
            if (this.Qq.position() >= 2) {
                byte b = this.Qq.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Qq.get(1);
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
                    if (!this.Qt && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Qt && i4 != 0) {
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
                if (this.Qq.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Qq.get(2) & 255) << 8) | (this.Qq.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Qq.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Qq.get(2) & 255) << 56) | ((this.Qq.get(3) & 255) << 48) | ((this.Qq.get(4) & 255) << 40) | ((this.Qq.get(5) & 255) << 32) | ((this.Qq.get(6) & 255) << 24) | ((this.Qq.get(7) & 255) << 16) | ((this.Qq.get(8) & 255) << 8) | (this.Qq.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Qv = new a();
                    this.Qv.QC = i4;
                    this.Qv.QD = z;
                    this.Qv.QE = i3;
                    this.Qv.QG = (int) j;
                    this.Qv.QF = i2;
                    this.Qv.QH = this.Qv.QF + this.Qv.QG;
                    this.Qv.QI = null;
                    int position = this.Qq.position();
                    this.Qv.QJ = new byte[this.Qv.QF];
                    this.Qq.position(0);
                    this.Qq.get(this.Qv.QJ, 0, this.Qv.QF);
                    this.Qq.position(this.Qv.QF);
                    this.Qq.limit(position);
                    this.Qq.compact();
                    return this.Qv.QG == 0 || this.Qq.position() >= this.Qv.QG;
                }
                return false;
            }
            return false;
        } else if (this.Qw >= this.Qv.QG) {
            if (this.Qv.QC > 7) {
                if (this.Qv.QC == 8) {
                    if (this.Qv.QG < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Qv.QJ[1] & 255) + ((this.Qv.QJ[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Qv.QG > 2) {
                            byte[] bArr2 = new byte[this.Qv.QG - 2];
                            System.arraycopy(this.Qv.QJ, 2, bArr2, 0, this.Qv.QG - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    c(i, str);
                } else if (this.Qv.QC == 9) {
                    n(this.Qr.toByteArray());
                } else if (this.Qv.QC == 10) {
                    o(this.Qr.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Qt) {
                    this.Qt = true;
                    this.Qu = this.Qv.QC;
                    if (this.Qu == 1 && this.PN.oQ()) {
                        this.Qx.reset();
                    }
                }
                if (this.Qu == 1 && this.PN.oQ() && !this.Qx.l(this.Qr.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Qv.QD) {
                    if (this.Qu == 1) {
                        if (this.PN.oQ() && !this.Qx.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.PN.oL()) {
                            m(this.Qr.toByteArray());
                        } else {
                            onTextMessage(new String(this.Qr.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Qu == 2) {
                        p(this.Qr.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Qt = false;
                    this.Qr.reset();
                }
            }
            this.Qv = null;
            this.Qw = 0;
            return this.Qq.position() > 0;
        } else {
            int position2 = this.Qq.position();
            if (this.Qv.QG - this.Qw < position2) {
                position2 = this.Qv.QG - this.Qw;
            }
            int position3 = this.Qq.position();
            if (this.Qv.QG > 0) {
                bArr = new byte[position2];
                this.Qq.position(0);
                this.Qq.get(bArr, 0, position2);
            }
            this.Qq.position(position2);
            this.Qq.limit(position3);
            this.Qq.compact();
            if (bArr != null) {
                this.Qr.write(bArr);
            }
            this.Qw = position2 + this.Qw;
            return this.Qw >= this.Qv.QG;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        y(new k.q(z, map));
    }

    protected void c(int i, String str) {
        y(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        y(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        y(new k.C0022k(bArr));
    }

    protected void onTextMessage(String str) {
        y(new k.s(str));
    }

    protected void m(byte[] bArr) {
        y(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.QB = System.currentTimeMillis();
        y(new k.a(bArr, this.Qz, this.QB));
    }

    private boolean oU() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Qq.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Qq.get(position + 0) != 13 || this.Qq.get(position + 1) != 10 || this.Qq.get(position + 2) != 13 || this.Qq.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Qq.position();
                Map<String, String> map = null;
                if (this.Qq.get(0) == 72 && this.Qq.get(1) == 84 && this.Qq.get(2) == 84 && this.Qq.get(3) == 80) {
                    Pair<Integer, String> oV = oV();
                    if (((Integer) oV.first).intValue() >= 300) {
                        y(new k.p(((Integer) oV.first).intValue(), (String) oV.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Qq.position(0);
                        byte[] bArr = new byte[position];
                        this.Qq.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.Qq.position(position + 4);
                this.Qq.limit(position2);
                this.Qq.compact();
                if (this.Qy < this.PD.ow() && map.size() == 0) {
                    this.Qy++;
                    return true;
                }
                this.Qy = 0;
                if (!z) {
                    z2 = this.Qq.position() > 0;
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

    private Map<String, String> q(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> oV() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Qq.position() && this.Qq.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Qq.position() && this.Qq.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Qq.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Qq.position() && this.Qq.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Qq.position(i6);
        this.Qq.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean oW() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oT();
        }
        if (this.mState == 1) {
            return oU();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.PD.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Qq.clear();
            do {
                try {
                    int read = this.PD.read(this.Qq);
                    if (read > 0) {
                        if (this.Qz <= 0) {
                            this.Qz = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Qs += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (oW());
                    } else if (read < 0) {
                        y(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        y(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            y(new k.d(e2));
        } catch (WebSocketException e3) {
            y(new k.l(e3));
        } catch (Exception e4) {
            y(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void oC() {
        synchronized (m.class) {
            Qs = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Qs;
        }
        return j;
    }
}
