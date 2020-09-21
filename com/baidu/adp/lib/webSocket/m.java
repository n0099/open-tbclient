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
    private static long QL = 0;
    private final e.a PZ;
    private final Handler QI;
    private final ByteBuffer QJ;
    private final d QK;
    private boolean QM;
    private int QN;
    private a QO;
    private int QP;
    private final f QR;
    private int QS;
    private long QT;
    private long QU;
    private final l Qh;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int QV;
        public boolean QW;
        public int QX;
        public int QY;
        public int QZ;
        public int Ra;
        public byte[] Rb;
        public byte[] Rc;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.QM = false;
        this.QR = new f();
        this.QS = 0;
        this.QT = 0L;
        this.QU = 0L;
        this.QI = handler;
        this.PZ = aVar;
        this.Qh = lVar;
        this.QJ = ByteBuffer.allocateDirect(lVar.oR() + 14);
        this.QK = new d(lVar.oS());
        this.QO = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.QT = 0L;
        this.QU = 0L;
        Message obtainMessage = this.QI.obtainMessage();
        obtainMessage.obj = obj;
        this.QI.sendMessage(obtainMessage);
    }

    private boolean oY() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.QO == null) {
            if (this.QJ.position() >= 2) {
                byte b = this.QJ.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.QJ.get(1);
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
                    if (!this.QM && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.QM && i4 != 0) {
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
                if (this.QJ.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.QJ.get(2) & 255) << 8) | (this.QJ.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.QJ.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.QJ.get(2) & 255) << 56) | ((this.QJ.get(3) & 255) << 48) | ((this.QJ.get(4) & 255) << 40) | ((this.QJ.get(5) & 255) << 32) | ((this.QJ.get(6) & 255) << 24) | ((this.QJ.get(7) & 255) << 16) | ((this.QJ.get(8) & 255) << 8) | (this.QJ.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.QO = new a();
                    this.QO.QV = i4;
                    this.QO.QW = z;
                    this.QO.QX = i3;
                    this.QO.QZ = (int) j;
                    this.QO.QY = i2;
                    this.QO.Ra = this.QO.QY + this.QO.QZ;
                    this.QO.Rb = null;
                    int position = this.QJ.position();
                    this.QO.Rc = new byte[this.QO.QY];
                    this.QJ.position(0);
                    this.QJ.get(this.QO.Rc, 0, this.QO.QY);
                    this.QJ.position(this.QO.QY);
                    this.QJ.limit(position);
                    this.QJ.compact();
                    return this.QO.QZ == 0 || this.QJ.position() >= this.QO.QZ;
                }
                return false;
            }
            return false;
        } else if (this.QP >= this.QO.QZ) {
            if (this.QO.QV > 7) {
                if (this.QO.QV == 8) {
                    if (this.QO.QZ < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.QO.Rc[1] & 255) + ((this.QO.Rc[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.QO.QZ > 2) {
                            byte[] bArr2 = new byte[this.QO.QZ - 2];
                            System.arraycopy(this.QO.Rc, 2, bArr2, 0, this.QO.QZ - 2);
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
                } else if (this.QO.QV == 9) {
                    n(this.QK.toByteArray());
                } else if (this.QO.QV == 10) {
                    o(this.QK.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.QM) {
                    this.QM = true;
                    this.QN = this.QO.QV;
                    if (this.QN == 1 && this.Qh.oV()) {
                        this.QR.reset();
                    }
                }
                if (this.QN == 1 && this.Qh.oV() && !this.QR.l(this.QK.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.QO.QW) {
                    if (this.QN == 1) {
                        if (this.Qh.oV() && !this.QR.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Qh.oQ()) {
                            m(this.QK.toByteArray());
                        } else {
                            onTextMessage(new String(this.QK.toByteArray(), "UTF-8"));
                        }
                    } else if (this.QN == 2) {
                        p(this.QK.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.QM = false;
                    this.QK.reset();
                }
            }
            this.QO = null;
            this.QP = 0;
            return this.QJ.position() > 0;
        } else {
            int position2 = this.QJ.position();
            if (this.QO.QZ - this.QP < position2) {
                position2 = this.QO.QZ - this.QP;
            }
            int position3 = this.QJ.position();
            if (this.QO.QZ > 0) {
                bArr = new byte[position2];
                this.QJ.position(0);
                this.QJ.get(bArr, 0, position2);
            }
            this.QJ.position(position2);
            this.QJ.limit(position3);
            this.QJ.compact();
            if (bArr != null) {
                this.QK.write(bArr);
            }
            this.QP = position2 + this.QP;
            return this.QP >= this.QO.QZ;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void c(int i, String str) {
        z(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        z(new k.C0023k(bArr));
    }

    protected void onTextMessage(String str) {
        z(new k.s(str));
    }

    protected void m(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.QU = System.currentTimeMillis();
        z(new k.a(bArr, this.QT, this.QU));
    }

    private boolean oZ() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.QJ.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.QJ.get(position + 0) != 13 || this.QJ.get(position + 1) != 10 || this.QJ.get(position + 2) != 13 || this.QJ.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.QJ.position();
                Map<String, String> map = null;
                if (this.QJ.get(0) == 72 && this.QJ.get(1) == 84 && this.QJ.get(2) == 84 && this.QJ.get(3) == 80) {
                    Pair<Integer, String> pa = pa();
                    if (((Integer) pa.first).intValue() >= 300) {
                        z(new k.p(((Integer) pa.first).intValue(), (String) pa.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.QJ.position(0);
                        byte[] bArr = new byte[position];
                        this.QJ.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.QJ.position(position + 4);
                this.QJ.limit(position2);
                this.QJ.compact();
                if (this.QS < this.PZ.oB() && map.size() == 0) {
                    this.QS++;
                    return true;
                }
                this.QS = 0;
                if (!z) {
                    z2 = this.QJ.position() > 0;
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

    private Pair<Integer, String> pa() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.QJ.position() && this.QJ.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.QJ.position() && this.QJ.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.QJ.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.QJ.position() && this.QJ.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.QJ.position(i6);
        this.QJ.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean pb() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oY();
        }
        if (this.mState == 1) {
            return oZ();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.PZ.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.QJ.clear();
            do {
                try {
                    int read = this.PZ.read(this.QJ);
                    if (read > 0) {
                        if (this.QT <= 0) {
                            this.QT = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            QL += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pb());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        z(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            z(new k.d(e2));
        } catch (WebSocketException e3) {
            z(new k.l(e3));
        } catch (Exception e4) {
            z(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void oH() {
        synchronized (m.class) {
            QL = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = QL;
        }
        return j;
    }
}
