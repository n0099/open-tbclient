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
    private static long vI = 0;
    private int mState;
    private boolean mStopped;
    private final e.a uX;
    private final Handler vF;
    private final ByteBuffer vG;
    private final d vH;
    private boolean vJ;
    private int vK;
    private a vL;
    private int vM;
    private final f vN;
    private int vO;
    private long vP;
    private long vQ;
    private final l vf;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int vR;
        public boolean vS;
        public int vT;
        public int vU;
        public int vV;
        public int vW;
        public byte[] vX;
        public byte[] vY;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.vJ = false;
        this.vN = new f();
        this.vO = 0;
        this.vP = 0L;
        this.vQ = 0L;
        this.vF = handler;
        this.uX = aVar;
        this.vf = lVar;
        this.vG = ByteBuffer.allocateDirect(lVar.ia() + 14);
        this.vH = new d(lVar.ib());
        this.vL = null;
        this.mState = 1;
    }

    protected void u(Object obj) {
        this.vP = 0L;
        this.vQ = 0L;
        Message obtainMessage = this.vF.obtainMessage();
        obtainMessage.obj = obj;
        this.vF.sendMessage(obtainMessage);
    }

    private boolean ih() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.vL == null) {
            if (this.vG.position() >= 2) {
                byte b = this.vG.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.vG.get(1);
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
                    if (!this.vJ && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.vJ && i4 != 0) {
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
                if (this.vG.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.vG.get(2) & 255) << 8) | (this.vG.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.vG.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.vG.get(2) & 255) << 56) | ((this.vG.get(3) & 255) << 48) | ((this.vG.get(4) & 255) << 40) | ((this.vG.get(5) & 255) << 32) | ((this.vG.get(6) & 255) << 24) | ((this.vG.get(7) & 255) << 16) | ((this.vG.get(8) & 255) << 8) | (this.vG.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.vL = new a();
                    this.vL.vR = i4;
                    this.vL.vS = z;
                    this.vL.vT = i3;
                    this.vL.vV = (int) j;
                    this.vL.vU = i2;
                    this.vL.vW = this.vL.vU + this.vL.vV;
                    this.vL.vX = null;
                    int position = this.vG.position();
                    this.vL.vY = new byte[this.vL.vU];
                    this.vG.position(0);
                    this.vG.get(this.vL.vY, 0, this.vL.vU);
                    this.vG.position(this.vL.vU);
                    this.vG.limit(position);
                    this.vG.compact();
                    return this.vL.vV == 0 || this.vG.position() >= this.vL.vV;
                }
                return false;
            }
            return false;
        } else if (this.vM >= this.vL.vV) {
            if (this.vL.vR > 7) {
                if (this.vL.vR == 8) {
                    if (this.vL.vV < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.vL.vY[1] & 255) + ((this.vL.vY[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.vL.vV > 2) {
                            byte[] bArr2 = new byte[this.vL.vV - 2];
                            System.arraycopy(this.vL.vY, 2, bArr2, 0, this.vL.vV - 2);
                            f fVar = new f();
                            fVar.g(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.vL.vR == 9) {
                    i(this.vH.toByteArray());
                } else if (this.vL.vR == 10) {
                    j(this.vH.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.vJ) {
                    this.vJ = true;
                    this.vK = this.vL.vR;
                    if (this.vK == 1 && this.vf.ie()) {
                        this.vN.reset();
                    }
                }
                if (this.vK == 1 && this.vf.ie() && !this.vN.g(this.vH.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.vL.vS) {
                    if (this.vK == 1) {
                        if (this.vf.ie() && !this.vN.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.vf.hZ()) {
                            h(this.vH.toByteArray());
                        } else {
                            onTextMessage(new String(this.vH.toByteArray(), "UTF-8"));
                        }
                    } else if (this.vK == 2) {
                        k(this.vH.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.vJ = false;
                    this.vH.reset();
                }
            }
            this.vL = null;
            this.vM = 0;
            return this.vG.position() > 0;
        } else {
            int position2 = this.vG.position();
            if (this.vL.vV - this.vM < position2) {
                position2 = this.vL.vV - this.vM;
            }
            int position3 = this.vG.position();
            if (this.vL.vV > 0) {
                bArr = new byte[position2];
                this.vG.position(0);
                this.vG.get(bArr, 0, position2);
            }
            this.vG.position(position2);
            this.vG.limit(position3);
            this.vG.compact();
            if (bArr != null) {
                this.vH.write(bArr);
            }
            this.vM = position2 + this.vM;
            return this.vM >= this.vL.vV;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        u(new k.q(z, map));
    }

    protected void e(int i, String str) {
        u(new k.c(i, str));
    }

    protected void i(byte[] bArr) {
        u(new k.j(bArr));
    }

    protected void j(byte[] bArr) {
        u(new k.C0021k(bArr));
    }

    protected void onTextMessage(String str) {
        u(new k.s(str));
    }

    protected void h(byte[] bArr) {
        u(new k.m(bArr));
    }

    protected void k(byte[] bArr) {
        this.vQ = System.currentTimeMillis();
        u(new k.a(bArr, this.vP, this.vQ));
    }

    private boolean ii() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.vG.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.vG.get(position + 0) != 13 || this.vG.get(position + 1) != 10 || this.vG.get(position + 2) != 13 || this.vG.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.vG.position();
                Map<String, String> map = null;
                if (this.vG.get(0) == 72 && this.vG.get(1) == 84 && this.vG.get(2) == 84 && this.vG.get(3) == 80) {
                    Pair<Integer, String> ij = ij();
                    if (((Integer) ij.first).intValue() >= 300) {
                        u(new k.p(((Integer) ij.first).intValue(), (String) ij.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.vG.position(0);
                        byte[] bArr = new byte[position];
                        this.vG.get(bArr);
                        map = l(bArr);
                    }
                } else {
                    z = false;
                }
                this.vG.position(position + 4);
                this.vG.limit(position2);
                this.vG.compact();
                if (this.vO < this.uX.hK() && map.size() == 0) {
                    this.vO++;
                    return true;
                }
                this.vO = 0;
                if (!z) {
                    z2 = this.vG.position() > 0;
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

    private Map<String, String> l(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> ij() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.vG.position() && this.vG.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.vG.position() && this.vG.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.vG.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.vG.position() && this.vG.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.vG.position(i6);
        this.vG.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean ik() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return ih();
        }
        if (this.mState == 1) {
            return ii();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.uX.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.vG.clear();
            do {
                try {
                    int read = this.uX.read(this.vG);
                    if (read > 0) {
                        if (this.vP <= 0) {
                            this.vP = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            vI += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ik());
                    } else if (read < 0) {
                        u(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        u(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            u(new k.d(e2));
        } catch (WebSocketException e3) {
            u(new k.l(e3));
        } catch (Exception e4) {
            u(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void hQ() {
        synchronized (m.class) {
            vI = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = vI;
        }
        return j;
    }
}
