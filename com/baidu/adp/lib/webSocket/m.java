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
    private static long aoC = 0;
    private final e.a anM;
    private final l anU;
    private final ByteBuffer aoA;
    private final d aoB;
    private boolean aoD;
    private int aoE;
    private a aoF;
    private int aoG;
    private final f aoH;
    private int aoI;
    private long aoJ;
    private long aoK;
    private final Handler aoz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aoL;
        public boolean aoM;
        public int aoN;
        public int aoO;
        public int aoP;
        public int aoQ;
        public byte[] aoR;
        public byte[] aoS;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.aoD = false;
        this.aoH = new f();
        this.aoI = 0;
        this.aoJ = 0L;
        this.aoK = 0L;
        this.aoz = handler;
        this.anM = aVar;
        this.anU = lVar;
        this.aoA = ByteBuffer.allocateDirect(lVar.pL() + 14);
        this.aoB = new d(lVar.pM());
        this.aoF = null;
        this.mState = 1;
    }

    protected void ax(Object obj) {
        this.aoJ = 0L;
        this.aoK = 0L;
        Message obtainMessage = this.aoz.obtainMessage();
        obtainMessage.obj = obj;
        this.aoz.sendMessage(obtainMessage);
    }

    private boolean pS() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.aoF == null) {
            if (this.aoA.position() >= 2) {
                byte b = this.aoA.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.aoA.get(1);
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
                    if (!this.aoD && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.aoD && i4 != 0) {
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
                if (this.aoA.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.aoA.get(2) & 255) << 8) | (this.aoA.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.aoA.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.aoA.get(2) & 255) << 56) | ((this.aoA.get(3) & 255) << 48) | ((this.aoA.get(4) & 255) << 40) | ((this.aoA.get(5) & 255) << 32) | ((this.aoA.get(6) & 255) << 24) | ((this.aoA.get(7) & 255) << 16) | ((this.aoA.get(8) & 255) << 8) | (this.aoA.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.aoF = new a();
                    this.aoF.aoL = i4;
                    this.aoF.aoM = z;
                    this.aoF.aoN = i3;
                    this.aoF.aoP = (int) j;
                    this.aoF.aoO = i2;
                    this.aoF.aoQ = this.aoF.aoO + this.aoF.aoP;
                    this.aoF.aoR = null;
                    int position = this.aoA.position();
                    this.aoF.aoS = new byte[this.aoF.aoO];
                    this.aoA.position(0);
                    this.aoA.get(this.aoF.aoS, 0, this.aoF.aoO);
                    this.aoA.position(this.aoF.aoO);
                    this.aoA.limit(position);
                    this.aoA.compact();
                    return this.aoF.aoP == 0 || this.aoA.position() >= this.aoF.aoP;
                }
                return false;
            }
            return false;
        } else if (this.aoG >= this.aoF.aoP) {
            if (this.aoF.aoL > 7) {
                if (this.aoF.aoL == 8) {
                    if (this.aoF.aoP < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.aoF.aoS[1] & 255) + ((this.aoF.aoS[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.aoF.aoP > 2) {
                            byte[] bArr2 = new byte[this.aoF.aoP - 2];
                            System.arraycopy(this.aoF.aoS, 2, bArr2, 0, this.aoF.aoP - 2);
                            f fVar = new f();
                            fVar.n(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.aoF.aoL == 9) {
                    p(this.aoB.toByteArray());
                } else if (this.aoF.aoL == 10) {
                    q(this.aoB.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.aoD) {
                    this.aoD = true;
                    this.aoE = this.aoF.aoL;
                    if (this.aoE == 1 && this.anU.pP()) {
                        this.aoH.reset();
                    }
                }
                if (this.aoE == 1 && this.anU.pP() && !this.aoH.n(this.aoB.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.aoF.aoM) {
                    if (this.aoE == 1) {
                        if (this.anU.pP() && !this.aoH.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.anU.pK()) {
                            o(this.aoB.toByteArray());
                        } else {
                            J(new String(this.aoB.toByteArray(), "UTF-8"));
                        }
                    } else if (this.aoE == 2) {
                        r(this.aoB.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.aoD = false;
                    this.aoB.reset();
                }
            }
            this.aoF = null;
            this.aoG = 0;
            return this.aoA.position() > 0;
        } else {
            int position2 = this.aoA.position();
            if (this.aoF.aoP - this.aoG < position2) {
                position2 = this.aoF.aoP - this.aoG;
            }
            int position3 = this.aoA.position();
            if (this.aoF.aoP > 0) {
                bArr = new byte[position2];
                this.aoA.position(0);
                this.aoA.get(bArr, 0, position2);
            }
            this.aoA.position(position2);
            this.aoA.limit(position3);
            this.aoA.compact();
            if (bArr != null) {
                this.aoB.write(bArr);
            }
            this.aoG = position2 + this.aoG;
            return this.aoG >= this.aoF.aoP;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        ax(new k.q(z, map));
    }

    protected void e(int i, String str) {
        ax(new k.c(i, str));
    }

    protected void p(byte[] bArr) {
        ax(new k.j(bArr));
    }

    protected void q(byte[] bArr) {
        ax(new k.C0021k(bArr));
    }

    protected void J(String str) {
        ax(new k.s(str));
    }

    protected void o(byte[] bArr) {
        ax(new k.m(bArr));
    }

    protected void r(byte[] bArr) {
        this.aoK = System.currentTimeMillis();
        ax(new k.a(bArr, this.aoJ, this.aoK));
    }

    private boolean pT() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.aoA.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.aoA.get(position + 0) != 13 || this.aoA.get(position + 1) != 10 || this.aoA.get(position + 2) != 13 || this.aoA.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.aoA.position();
                Map<String, String> map = null;
                if (this.aoA.get(0) == 72 && this.aoA.get(1) == 84 && this.aoA.get(2) == 84 && this.aoA.get(3) == 80) {
                    Pair<Integer, String> pU = pU();
                    if (((Integer) pU.first).intValue() >= 300) {
                        ax(new k.p(((Integer) pU.first).intValue(), (String) pU.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.aoA.position(0);
                        byte[] bArr = new byte[position];
                        this.aoA.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.aoA.position(position + 4);
                this.aoA.limit(position2);
                this.aoA.compact();
                if (this.aoI < this.anM.pt() && map.size() == 0) {
                    this.aoI++;
                    return true;
                }
                this.aoI = 0;
                if (!z) {
                    z2 = this.aoA.position() > 0;
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

    private Map<String, String> s(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> pU() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.aoA.position() && this.aoA.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.aoA.position() && this.aoA.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.aoA.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.aoA.position() && this.aoA.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.aoA.position(i6);
        this.aoA.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean pV() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return pS();
        }
        if (this.mState == 1) {
            return pT();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.anM.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.aoA.clear();
            do {
                try {
                    int read = this.anM.read(this.aoA);
                    if (read > 0) {
                        if (this.aoJ <= 0) {
                            this.aoJ = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            aoC += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pV());
                    } else if (read < 0) {
                        ax(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.oJ()) {
                        this.mStopped = true;
                        ax(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            ax(new k.d(e2));
        } catch (WebSocketException e3) {
            ax(new k.l(e3));
        } catch (Exception e4) {
            ax(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void pB() {
        synchronized (m.class) {
            aoC = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = aoC;
        }
        return j;
    }
}
