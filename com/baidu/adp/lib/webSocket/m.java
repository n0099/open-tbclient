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
    private static long aoJ = 0;
    private final e.a anT;
    private final Handler aoG;
    private final ByteBuffer aoH;
    private final d aoI;
    private boolean aoK;
    private int aoL;
    private a aoM;
    private int aoN;
    private final f aoO;
    private int aoP;
    private long aoQ;
    private long aoR;
    private final l aob;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aoS;
        public boolean aoT;
        public int aoU;
        public int aoV;
        public int aoW;
        public int aoX;
        public byte[] aoY;
        public byte[] aoZ;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.aoK = false;
        this.aoO = new f();
        this.aoP = 0;
        this.aoQ = 0L;
        this.aoR = 0L;
        this.aoG = handler;
        this.anT = aVar;
        this.aob = lVar;
        this.aoH = ByteBuffer.allocateDirect(lVar.pL() + 14);
        this.aoI = new d(lVar.pM());
        this.aoM = null;
        this.mState = 1;
    }

    protected void ax(Object obj) {
        this.aoQ = 0L;
        this.aoR = 0L;
        Message obtainMessage = this.aoG.obtainMessage();
        obtainMessage.obj = obj;
        this.aoG.sendMessage(obtainMessage);
    }

    private boolean pS() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.aoM == null) {
            if (this.aoH.position() >= 2) {
                byte b = this.aoH.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.aoH.get(1);
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
                    if (!this.aoK && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.aoK && i4 != 0) {
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
                if (this.aoH.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.aoH.get(2) & 255) << 8) | (this.aoH.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.aoH.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.aoH.get(2) & 255) << 56) | ((this.aoH.get(3) & 255) << 48) | ((this.aoH.get(4) & 255) << 40) | ((this.aoH.get(5) & 255) << 32) | ((this.aoH.get(6) & 255) << 24) | ((this.aoH.get(7) & 255) << 16) | ((this.aoH.get(8) & 255) << 8) | (this.aoH.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.aoM = new a();
                    this.aoM.aoS = i4;
                    this.aoM.aoT = z;
                    this.aoM.aoU = i3;
                    this.aoM.aoW = (int) j;
                    this.aoM.aoV = i2;
                    this.aoM.aoX = this.aoM.aoV + this.aoM.aoW;
                    this.aoM.aoY = null;
                    int position = this.aoH.position();
                    this.aoM.aoZ = new byte[this.aoM.aoV];
                    this.aoH.position(0);
                    this.aoH.get(this.aoM.aoZ, 0, this.aoM.aoV);
                    this.aoH.position(this.aoM.aoV);
                    this.aoH.limit(position);
                    this.aoH.compact();
                    return this.aoM.aoW == 0 || this.aoH.position() >= this.aoM.aoW;
                }
                return false;
            }
            return false;
        } else if (this.aoN >= this.aoM.aoW) {
            if (this.aoM.aoS > 7) {
                if (this.aoM.aoS == 8) {
                    if (this.aoM.aoW < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.aoM.aoZ[1] & 255) + ((this.aoM.aoZ[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.aoM.aoW > 2) {
                            byte[] bArr2 = new byte[this.aoM.aoW - 2];
                            System.arraycopy(this.aoM.aoZ, 2, bArr2, 0, this.aoM.aoW - 2);
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
                } else if (this.aoM.aoS == 9) {
                    p(this.aoI.toByteArray());
                } else if (this.aoM.aoS == 10) {
                    q(this.aoI.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.aoK) {
                    this.aoK = true;
                    this.aoL = this.aoM.aoS;
                    if (this.aoL == 1 && this.aob.pP()) {
                        this.aoO.reset();
                    }
                }
                if (this.aoL == 1 && this.aob.pP() && !this.aoO.n(this.aoI.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.aoM.aoT) {
                    if (this.aoL == 1) {
                        if (this.aob.pP() && !this.aoO.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.aob.pK()) {
                            o(this.aoI.toByteArray());
                        } else {
                            J(new String(this.aoI.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.aoL == 2) {
                        r(this.aoI.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.aoK = false;
                    this.aoI.reset();
                }
            }
            this.aoM = null;
            this.aoN = 0;
            return this.aoH.position() > 0;
        } else {
            int position2 = this.aoH.position();
            if (this.aoM.aoW - this.aoN < position2) {
                position2 = this.aoM.aoW - this.aoN;
            }
            int position3 = this.aoH.position();
            if (this.aoM.aoW > 0) {
                bArr = new byte[position2];
                this.aoH.position(0);
                this.aoH.get(bArr, 0, position2);
            }
            this.aoH.position(position2);
            this.aoH.limit(position3);
            this.aoH.compact();
            if (bArr != null) {
                this.aoI.write(bArr);
            }
            this.aoN = position2 + this.aoN;
            return this.aoN >= this.aoM.aoW;
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
        this.aoR = System.currentTimeMillis();
        ax(new k.a(bArr, this.aoQ, this.aoR));
    }

    private boolean pT() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.aoH.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.aoH.get(position + 0) != 13 || this.aoH.get(position + 1) != 10 || this.aoH.get(position + 2) != 13 || this.aoH.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.aoH.position();
                Map<String, String> map = null;
                if (this.aoH.get(0) == 72 && this.aoH.get(1) == 84 && this.aoH.get(2) == 84 && this.aoH.get(3) == 80) {
                    Pair<Integer, String> pU = pU();
                    if (((Integer) pU.first).intValue() >= 300) {
                        ax(new k.p(((Integer) pU.first).intValue(), (String) pU.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.aoH.position(0);
                        byte[] bArr = new byte[position];
                        this.aoH.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.aoH.position(position + 4);
                this.aoH.limit(position2);
                this.aoH.compact();
                if (this.aoP < this.anT.pt() && map.size() == 0) {
                    this.aoP++;
                    return true;
                }
                this.aoP = 0;
                if (!z) {
                    z2 = this.aoH.position() > 0;
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

    private Pair<Integer, String> pU() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.aoH.position() && this.aoH.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.aoH.position() && this.aoH.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.aoH.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.aoH.position() && this.aoH.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.aoH.position(i6);
        this.aoH.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
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
            this.anT.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.aoH.clear();
            do {
                try {
                    int read = this.anT.read(this.aoH);
                    if (read > 0) {
                        if (this.aoQ <= 0) {
                            this.aoQ = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            aoJ += read;
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
            aoJ = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = aoJ;
        }
        return j;
    }
}
