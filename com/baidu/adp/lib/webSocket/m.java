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
    private static long aoI = 0;
    private final e.a anS;
    private final Handler aoF;
    private final ByteBuffer aoG;
    private final d aoH;
    private boolean aoJ;
    private int aoK;
    private a aoL;
    private int aoM;
    private final f aoN;
    private int aoO;
    private long aoP;
    private long aoQ;
    private final l aoa;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aoR;
        public boolean aoS;
        public int aoT;
        public int aoU;
        public int aoV;
        public int aoW;
        public byte[] aoX;
        public byte[] aoY;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.aoJ = false;
        this.aoN = new f();
        this.aoO = 0;
        this.aoP = 0L;
        this.aoQ = 0L;
        this.aoF = handler;
        this.anS = aVar;
        this.aoa = lVar;
        this.aoG = ByteBuffer.allocateDirect(lVar.pL() + 14);
        this.aoH = new d(lVar.pM());
        this.aoL = null;
        this.mState = 1;
    }

    protected void ax(Object obj) {
        this.aoP = 0L;
        this.aoQ = 0L;
        Message obtainMessage = this.aoF.obtainMessage();
        obtainMessage.obj = obj;
        this.aoF.sendMessage(obtainMessage);
    }

    private boolean pS() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.aoL == null) {
            if (this.aoG.position() >= 2) {
                byte b = this.aoG.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.aoG.get(1);
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
                    if (!this.aoJ && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.aoJ && i4 != 0) {
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
                if (this.aoG.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.aoG.get(2) & 255) << 8) | (this.aoG.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.aoG.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.aoG.get(2) & 255) << 56) | ((this.aoG.get(3) & 255) << 48) | ((this.aoG.get(4) & 255) << 40) | ((this.aoG.get(5) & 255) << 32) | ((this.aoG.get(6) & 255) << 24) | ((this.aoG.get(7) & 255) << 16) | ((this.aoG.get(8) & 255) << 8) | (this.aoG.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.aoL = new a();
                    this.aoL.aoR = i4;
                    this.aoL.aoS = z;
                    this.aoL.aoT = i3;
                    this.aoL.aoV = (int) j;
                    this.aoL.aoU = i2;
                    this.aoL.aoW = this.aoL.aoU + this.aoL.aoV;
                    this.aoL.aoX = null;
                    int position = this.aoG.position();
                    this.aoL.aoY = new byte[this.aoL.aoU];
                    this.aoG.position(0);
                    this.aoG.get(this.aoL.aoY, 0, this.aoL.aoU);
                    this.aoG.position(this.aoL.aoU);
                    this.aoG.limit(position);
                    this.aoG.compact();
                    return this.aoL.aoV == 0 || this.aoG.position() >= this.aoL.aoV;
                }
                return false;
            }
            return false;
        } else if (this.aoM >= this.aoL.aoV) {
            if (this.aoL.aoR > 7) {
                if (this.aoL.aoR == 8) {
                    if (this.aoL.aoV < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.aoL.aoY[1] & 255) + ((this.aoL.aoY[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.aoL.aoV > 2) {
                            byte[] bArr2 = new byte[this.aoL.aoV - 2];
                            System.arraycopy(this.aoL.aoY, 2, bArr2, 0, this.aoL.aoV - 2);
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
                } else if (this.aoL.aoR == 9) {
                    p(this.aoH.toByteArray());
                } else if (this.aoL.aoR == 10) {
                    q(this.aoH.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.aoJ) {
                    this.aoJ = true;
                    this.aoK = this.aoL.aoR;
                    if (this.aoK == 1 && this.aoa.pP()) {
                        this.aoN.reset();
                    }
                }
                if (this.aoK == 1 && this.aoa.pP() && !this.aoN.n(this.aoH.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.aoL.aoS) {
                    if (this.aoK == 1) {
                        if (this.aoa.pP() && !this.aoN.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.aoa.pK()) {
                            o(this.aoH.toByteArray());
                        } else {
                            J(new String(this.aoH.toByteArray(), "UTF-8"));
                        }
                    } else if (this.aoK == 2) {
                        r(this.aoH.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.aoJ = false;
                    this.aoH.reset();
                }
            }
            this.aoL = null;
            this.aoM = 0;
            return this.aoG.position() > 0;
        } else {
            int position2 = this.aoG.position();
            if (this.aoL.aoV - this.aoM < position2) {
                position2 = this.aoL.aoV - this.aoM;
            }
            int position3 = this.aoG.position();
            if (this.aoL.aoV > 0) {
                bArr = new byte[position2];
                this.aoG.position(0);
                this.aoG.get(bArr, 0, position2);
            }
            this.aoG.position(position2);
            this.aoG.limit(position3);
            this.aoG.compact();
            if (bArr != null) {
                this.aoH.write(bArr);
            }
            this.aoM = position2 + this.aoM;
            return this.aoM >= this.aoL.aoV;
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
        this.aoQ = System.currentTimeMillis();
        ax(new k.a(bArr, this.aoP, this.aoQ));
    }

    private boolean pT() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.aoG.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.aoG.get(position + 0) != 13 || this.aoG.get(position + 1) != 10 || this.aoG.get(position + 2) != 13 || this.aoG.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.aoG.position();
                Map<String, String> map = null;
                if (this.aoG.get(0) == 72 && this.aoG.get(1) == 84 && this.aoG.get(2) == 84 && this.aoG.get(3) == 80) {
                    Pair<Integer, String> pU = pU();
                    if (((Integer) pU.first).intValue() >= 300) {
                        ax(new k.p(((Integer) pU.first).intValue(), (String) pU.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.aoG.position(0);
                        byte[] bArr = new byte[position];
                        this.aoG.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.aoG.position(position + 4);
                this.aoG.limit(position2);
                this.aoG.compact();
                if (this.aoO < this.anS.pt() && map.size() == 0) {
                    this.aoO++;
                    return true;
                }
                this.aoO = 0;
                if (!z) {
                    z2 = this.aoG.position() > 0;
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
        while (i < this.aoG.position() && this.aoG.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.aoG.position() && this.aoG.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.aoG.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.aoG.position() && this.aoG.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.aoG.position(i6);
        this.aoG.get(bArr, 0, i8);
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
            this.anS.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.aoG.clear();
            do {
                try {
                    int read = this.anS.read(this.aoG);
                    if (read > 0) {
                        if (this.aoP <= 0) {
                            this.aoP = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            aoI += read;
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
            aoI = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = aoI;
        }
        return j;
    }
}
