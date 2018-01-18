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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long aoG = 0;
    private final e.a anQ;
    private final l anY;
    private final Handler aoD;
    private final ByteBuffer aoE;
    private final d aoF;
    private boolean aoH;
    private int aoI;
    private a aoJ;
    private int aoK;
    private final f aoL;
    private int aoM;
    private long aoN;
    private long aoO;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aoP;
        public boolean aoQ;
        public int aoR;
        public int aoS;
        public int aoT;
        public int aoU;
        public byte[] aoV;
        public byte[] aoW;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.aoH = false;
        this.aoL = new f();
        this.aoM = 0;
        this.aoN = 0L;
        this.aoO = 0L;
        this.aoD = handler;
        this.anQ = aVar;
        this.anY = lVar;
        this.aoE = ByteBuffer.allocateDirect(lVar.pK() + 14);
        this.aoF = new d(lVar.pL());
        this.aoJ = null;
        this.mState = 1;
    }

    protected void ax(Object obj) {
        this.aoN = 0L;
        this.aoO = 0L;
        Message obtainMessage = this.aoD.obtainMessage();
        obtainMessage.obj = obj;
        this.aoD.sendMessage(obtainMessage);
    }

    private boolean pR() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.aoJ == null) {
            if (this.aoE.position() >= 2) {
                byte b = this.aoE.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.aoE.get(1);
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
                    if (!this.aoH && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.aoH && i4 != 0) {
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
                if (this.aoE.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.aoE.get(2) & 255) << 8) | (this.aoE.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.aoE.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.aoE.get(2) & 255) << 56) | ((this.aoE.get(3) & 255) << 48) | ((this.aoE.get(4) & 255) << 40) | ((this.aoE.get(5) & 255) << 32) | ((this.aoE.get(6) & 255) << 24) | ((this.aoE.get(7) & 255) << 16) | ((this.aoE.get(8) & 255) << 8) | (this.aoE.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.aoJ = new a();
                    this.aoJ.aoP = i4;
                    this.aoJ.aoQ = z;
                    this.aoJ.aoR = i3;
                    this.aoJ.aoT = (int) j;
                    this.aoJ.aoS = i2;
                    this.aoJ.aoU = this.aoJ.aoS + this.aoJ.aoT;
                    this.aoJ.aoV = null;
                    int position = this.aoE.position();
                    this.aoJ.aoW = new byte[this.aoJ.aoS];
                    this.aoE.position(0);
                    this.aoE.get(this.aoJ.aoW, 0, this.aoJ.aoS);
                    this.aoE.position(this.aoJ.aoS);
                    this.aoE.limit(position);
                    this.aoE.compact();
                    return this.aoJ.aoT == 0 || this.aoE.position() >= this.aoJ.aoT;
                }
                return false;
            }
            return false;
        } else if (this.aoK >= this.aoJ.aoT) {
            if (this.aoJ.aoP > 7) {
                if (this.aoJ.aoP == 8) {
                    if (this.aoJ.aoT < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.aoJ.aoW[1] & 255) + ((this.aoJ.aoW[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.aoJ.aoT > 2) {
                            byte[] bArr2 = new byte[this.aoJ.aoT - 2];
                            System.arraycopy(this.aoJ.aoW, 2, bArr2, 0, this.aoJ.aoT - 2);
                            f fVar = new f();
                            fVar.n(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.aoJ.aoP == 9) {
                    p(this.aoF.toByteArray());
                } else if (this.aoJ.aoP == 10) {
                    q(this.aoF.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.aoH) {
                    this.aoH = true;
                    this.aoI = this.aoJ.aoP;
                    if (this.aoI == 1 && this.anY.pO()) {
                        this.aoL.reset();
                    }
                }
                if (this.aoI == 1 && this.anY.pO() && !this.aoL.n(this.aoF.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.aoJ.aoQ) {
                    if (this.aoI == 1) {
                        if (this.anY.pO() && !this.aoL.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.anY.pJ()) {
                            o(this.aoF.toByteArray());
                        } else {
                            J(new String(this.aoF.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.aoI == 2) {
                        r(this.aoF.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.aoH = false;
                    this.aoF.reset();
                }
            }
            this.aoJ = null;
            this.aoK = 0;
            return this.aoE.position() > 0;
        } else {
            int position2 = this.aoE.position();
            if (this.aoJ.aoT - this.aoK < position2) {
                position2 = this.aoJ.aoT - this.aoK;
            }
            int position3 = this.aoE.position();
            if (this.aoJ.aoT > 0) {
                bArr = new byte[position2];
                this.aoE.position(0);
                this.aoE.get(bArr, 0, position2);
            }
            this.aoE.position(position2);
            this.aoE.limit(position3);
            this.aoE.compact();
            if (bArr != null) {
                this.aoF.write(bArr);
            }
            this.aoK = position2 + this.aoK;
            return this.aoK >= this.aoJ.aoT;
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
        this.aoO = System.currentTimeMillis();
        ax(new k.a(bArr, this.aoN, this.aoO));
    }

    private boolean pS() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.aoE.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.aoE.get(position + 0) != 13 || this.aoE.get(position + 1) != 10 || this.aoE.get(position + 2) != 13 || this.aoE.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.aoE.position();
                Map<String, String> map = null;
                if (this.aoE.get(0) == 72 && this.aoE.get(1) == 84 && this.aoE.get(2) == 84 && this.aoE.get(3) == 80) {
                    Pair<Integer, String> pT = pT();
                    if (((Integer) pT.first).intValue() >= 300) {
                        ax(new k.p(((Integer) pT.first).intValue(), (String) pT.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.aoE.position(0);
                        byte[] bArr = new byte[position];
                        this.aoE.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.aoE.position(position + 4);
                this.aoE.limit(position2);
                this.aoE.compact();
                if (this.aoM < this.anQ.ps() && map.size() == 0) {
                    this.aoM++;
                    return true;
                }
                this.aoM = 0;
                if (!z) {
                    z2 = this.aoE.position() > 0;
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
        String str = new String(bArr, HTTP.UTF_8);
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

    private Pair<Integer, String> pT() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.aoE.position() && this.aoE.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.aoE.position() && this.aoE.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.aoE.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.aoE.position() && this.aoE.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.aoE.position(i6);
        this.aoE.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean pU() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return pR();
        }
        if (this.mState == 1) {
            return pS();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.anQ.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.aoE.clear();
            do {
                try {
                    int read = this.anQ.read(this.aoE);
                    if (read > 0) {
                        if (this.aoN <= 0) {
                            this.aoN = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            aoG += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pU());
                    } else if (read < 0) {
                        ax(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.oI()) {
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

    public void pA() {
        synchronized (m.class) {
            aoG = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = aoG;
        }
        return j;
    }
}
