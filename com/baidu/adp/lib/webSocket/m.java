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
    private static long vF = 0;
    private int mState;
    private boolean mStopped;
    private final e.a uU;
    private final Handler vC;
    private final ByteBuffer vD;
    private final d vE;
    private boolean vG;
    private int vH;
    private a vI;
    private int vJ;
    private final f vK;
    private int vL;
    private long vM;
    private long vN;
    private final l vc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int vO;
        public boolean vP;
        public int vQ;
        public int vR;
        public int vS;
        public int vT;
        public byte[] vU;
        public byte[] vV;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.vG = false;
        this.vK = new f();
        this.vL = 0;
        this.vM = 0L;
        this.vN = 0L;
        this.vC = handler;
        this.uU = aVar;
        this.vc = lVar;
        this.vD = ByteBuffer.allocateDirect(lVar.ib() + 14);
        this.vE = new d(lVar.ic());
        this.vI = null;
        this.mState = 1;
    }

    protected void u(Object obj) {
        this.vM = 0L;
        this.vN = 0L;
        Message obtainMessage = this.vC.obtainMessage();
        obtainMessage.obj = obj;
        this.vC.sendMessage(obtainMessage);
    }

    private boolean ii() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.vI == null) {
            if (this.vD.position() >= 2) {
                byte b = this.vD.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.vD.get(1);
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
                    if (!this.vG && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.vG && i4 != 0) {
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
                if (this.vD.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.vD.get(2) & 255) << 8) | (this.vD.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.vD.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.vD.get(2) & 255) << 56) | ((this.vD.get(3) & 255) << 48) | ((this.vD.get(4) & 255) << 40) | ((this.vD.get(5) & 255) << 32) | ((this.vD.get(6) & 255) << 24) | ((this.vD.get(7) & 255) << 16) | ((this.vD.get(8) & 255) << 8) | (this.vD.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.vI = new a();
                    this.vI.vO = i4;
                    this.vI.vP = z;
                    this.vI.vQ = i3;
                    this.vI.vS = (int) j;
                    this.vI.vR = i2;
                    this.vI.vT = this.vI.vR + this.vI.vS;
                    this.vI.vU = null;
                    int position = this.vD.position();
                    this.vI.vV = new byte[this.vI.vR];
                    this.vD.position(0);
                    this.vD.get(this.vI.vV, 0, this.vI.vR);
                    this.vD.position(this.vI.vR);
                    this.vD.limit(position);
                    this.vD.compact();
                    return this.vI.vS == 0 || this.vD.position() >= this.vI.vS;
                }
                return false;
            }
            return false;
        } else if (this.vJ >= this.vI.vS) {
            if (this.vI.vO > 7) {
                if (this.vI.vO == 8) {
                    if (this.vI.vS < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.vI.vV[1] & 255) + ((this.vI.vV[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.vI.vS > 2) {
                            byte[] bArr2 = new byte[this.vI.vS - 2];
                            System.arraycopy(this.vI.vV, 2, bArr2, 0, this.vI.vS - 2);
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
                } else if (this.vI.vO == 9) {
                    i(this.vE.toByteArray());
                } else if (this.vI.vO == 10) {
                    j(this.vE.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.vG) {
                    this.vG = true;
                    this.vH = this.vI.vO;
                    if (this.vH == 1 && this.vc.m9if()) {
                        this.vK.reset();
                    }
                }
                if (this.vH == 1 && this.vc.m9if() && !this.vK.g(this.vE.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.vI.vP) {
                    if (this.vH == 1) {
                        if (this.vc.m9if() && !this.vK.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.vc.ia()) {
                            h(this.vE.toByteArray());
                        } else {
                            onTextMessage(new String(this.vE.toByteArray(), "UTF-8"));
                        }
                    } else if (this.vH == 2) {
                        k(this.vE.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.vG = false;
                    this.vE.reset();
                }
            }
            this.vI = null;
            this.vJ = 0;
            return this.vD.position() > 0;
        } else {
            int position2 = this.vD.position();
            if (this.vI.vS - this.vJ < position2) {
                position2 = this.vI.vS - this.vJ;
            }
            int position3 = this.vD.position();
            if (this.vI.vS > 0) {
                bArr = new byte[position2];
                this.vD.position(0);
                this.vD.get(bArr, 0, position2);
            }
            this.vD.position(position2);
            this.vD.limit(position3);
            this.vD.compact();
            if (bArr != null) {
                this.vE.write(bArr);
            }
            this.vJ = position2 + this.vJ;
            return this.vJ >= this.vI.vS;
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
        this.vN = System.currentTimeMillis();
        u(new k.a(bArr, this.vM, this.vN));
    }

    private boolean ij() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.vD.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.vD.get(position + 0) != 13 || this.vD.get(position + 1) != 10 || this.vD.get(position + 2) != 13 || this.vD.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.vD.position();
                Map<String, String> map = null;
                if (this.vD.get(0) == 72 && this.vD.get(1) == 84 && this.vD.get(2) == 84 && this.vD.get(3) == 80) {
                    Pair<Integer, String> ik = ik();
                    if (((Integer) ik.first).intValue() >= 300) {
                        u(new k.p(((Integer) ik.first).intValue(), (String) ik.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.vD.position(0);
                        byte[] bArr = new byte[position];
                        this.vD.get(bArr);
                        map = l(bArr);
                    }
                } else {
                    z = false;
                }
                this.vD.position(position + 4);
                this.vD.limit(position2);
                this.vD.compact();
                if (this.vL < this.uU.hL() && map.size() == 0) {
                    this.vL++;
                    return true;
                }
                this.vL = 0;
                if (!z) {
                    z2 = this.vD.position() > 0;
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

    private Pair<Integer, String> ik() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.vD.position() && this.vD.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.vD.position() && this.vD.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.vD.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.vD.position() && this.vD.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.vD.position(i6);
        this.vD.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean il() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return ii();
        }
        if (this.mState == 1) {
            return ij();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.uU.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.vD.clear();
            do {
                try {
                    int read = this.uU.read(this.vD);
                    if (read > 0) {
                        if (this.vM <= 0) {
                            this.vM = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            vF += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (il());
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

    public void hR() {
        synchronized (m.class) {
            vF = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = vF;
        }
        return j;
    }
}
