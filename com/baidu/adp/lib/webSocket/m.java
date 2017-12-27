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
    private static long aoH = 0;
    private final e.a anR;
    private final l anZ;
    private final Handler aoE;
    private final ByteBuffer aoF;
    private final d aoG;
    private boolean aoI;
    private int aoJ;
    private a aoK;
    private int aoL;
    private final f aoM;
    private int aoN;
    private long aoO;
    private long aoP;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aoQ;
        public boolean aoR;
        public int aoS;
        public int aoT;
        public int aoU;
        public int aoV;
        public byte[] aoW;
        public byte[] aoX;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.aoI = false;
        this.aoM = new f();
        this.aoN = 0;
        this.aoO = 0L;
        this.aoP = 0L;
        this.aoE = handler;
        this.anR = aVar;
        this.anZ = lVar;
        this.aoF = ByteBuffer.allocateDirect(lVar.pK() + 14);
        this.aoG = new d(lVar.pL());
        this.aoK = null;
        this.mState = 1;
    }

    protected void ax(Object obj) {
        this.aoO = 0L;
        this.aoP = 0L;
        Message obtainMessage = this.aoE.obtainMessage();
        obtainMessage.obj = obj;
        this.aoE.sendMessage(obtainMessage);
    }

    private boolean pR() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.aoK == null) {
            if (this.aoF.position() >= 2) {
                byte b = this.aoF.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.aoF.get(1);
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
                    if (!this.aoI && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.aoI && i4 != 0) {
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
                if (this.aoF.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.aoF.get(2) & 255) << 8) | (this.aoF.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.aoF.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.aoF.get(2) & 255) << 56) | ((this.aoF.get(3) & 255) << 48) | ((this.aoF.get(4) & 255) << 40) | ((this.aoF.get(5) & 255) << 32) | ((this.aoF.get(6) & 255) << 24) | ((this.aoF.get(7) & 255) << 16) | ((this.aoF.get(8) & 255) << 8) | (this.aoF.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.aoK = new a();
                    this.aoK.aoQ = i4;
                    this.aoK.aoR = z;
                    this.aoK.aoS = i3;
                    this.aoK.aoU = (int) j;
                    this.aoK.aoT = i2;
                    this.aoK.aoV = this.aoK.aoT + this.aoK.aoU;
                    this.aoK.aoW = null;
                    int position = this.aoF.position();
                    this.aoK.aoX = new byte[this.aoK.aoT];
                    this.aoF.position(0);
                    this.aoF.get(this.aoK.aoX, 0, this.aoK.aoT);
                    this.aoF.position(this.aoK.aoT);
                    this.aoF.limit(position);
                    this.aoF.compact();
                    return this.aoK.aoU == 0 || this.aoF.position() >= this.aoK.aoU;
                }
                return false;
            }
            return false;
        } else if (this.aoL >= this.aoK.aoU) {
            if (this.aoK.aoQ > 7) {
                if (this.aoK.aoQ == 8) {
                    if (this.aoK.aoU < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.aoK.aoX[1] & 255) + ((this.aoK.aoX[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.aoK.aoU > 2) {
                            byte[] bArr2 = new byte[this.aoK.aoU - 2];
                            System.arraycopy(this.aoK.aoX, 2, bArr2, 0, this.aoK.aoU - 2);
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
                } else if (this.aoK.aoQ == 9) {
                    p(this.aoG.toByteArray());
                } else if (this.aoK.aoQ == 10) {
                    q(this.aoG.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.aoI) {
                    this.aoI = true;
                    this.aoJ = this.aoK.aoQ;
                    if (this.aoJ == 1 && this.anZ.pO()) {
                        this.aoM.reset();
                    }
                }
                if (this.aoJ == 1 && this.anZ.pO() && !this.aoM.n(this.aoG.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.aoK.aoR) {
                    if (this.aoJ == 1) {
                        if (this.anZ.pO() && !this.aoM.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.anZ.pJ()) {
                            o(this.aoG.toByteArray());
                        } else {
                            J(new String(this.aoG.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.aoJ == 2) {
                        r(this.aoG.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.aoI = false;
                    this.aoG.reset();
                }
            }
            this.aoK = null;
            this.aoL = 0;
            return this.aoF.position() > 0;
        } else {
            int position2 = this.aoF.position();
            if (this.aoK.aoU - this.aoL < position2) {
                position2 = this.aoK.aoU - this.aoL;
            }
            int position3 = this.aoF.position();
            if (this.aoK.aoU > 0) {
                bArr = new byte[position2];
                this.aoF.position(0);
                this.aoF.get(bArr, 0, position2);
            }
            this.aoF.position(position2);
            this.aoF.limit(position3);
            this.aoF.compact();
            if (bArr != null) {
                this.aoG.write(bArr);
            }
            this.aoL = position2 + this.aoL;
            return this.aoL >= this.aoK.aoU;
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
        this.aoP = System.currentTimeMillis();
        ax(new k.a(bArr, this.aoO, this.aoP));
    }

    private boolean pS() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.aoF.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.aoF.get(position + 0) != 13 || this.aoF.get(position + 1) != 10 || this.aoF.get(position + 2) != 13 || this.aoF.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.aoF.position();
                Map<String, String> map = null;
                if (this.aoF.get(0) == 72 && this.aoF.get(1) == 84 && this.aoF.get(2) == 84 && this.aoF.get(3) == 80) {
                    Pair<Integer, String> pT = pT();
                    if (((Integer) pT.first).intValue() >= 300) {
                        ax(new k.p(((Integer) pT.first).intValue(), (String) pT.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.aoF.position(0);
                        byte[] bArr = new byte[position];
                        this.aoF.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.aoF.position(position + 4);
                this.aoF.limit(position2);
                this.aoF.compact();
                if (this.aoN < this.anR.ps() && map.size() == 0) {
                    this.aoN++;
                    return true;
                }
                this.aoN = 0;
                if (!z) {
                    z2 = this.aoF.position() > 0;
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
        while (i < this.aoF.position() && this.aoF.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.aoF.position() && this.aoF.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.aoF.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.aoF.position() && this.aoF.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.aoF.position(i6);
        this.aoF.get(bArr, 0, i8);
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
            this.anR.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.aoF.clear();
            do {
                try {
                    int read = this.anR.read(this.aoF);
                    if (read > 0) {
                        if (this.aoO <= 0) {
                            this.aoO = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            aoH += read;
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
            aoH = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = aoH;
        }
        return j;
    }
}
