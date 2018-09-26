package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long HG = 0;
    private final e.a GP;
    private final l GZ;
    private final Handler HD;
    private final ByteBuffer HE;
    private final d HF;
    private boolean HH;
    private int HI;
    private a HJ;
    private int HK;
    private final f HL;
    private int HM;
    private long HN;
    private long HO;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int HP;
        public boolean HQ;
        public int HR;
        public int HS;
        public int HU;
        public int HV;
        public byte[] HW;
        public byte[] HX;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.HH = false;
        this.HL = new f();
        this.HM = 0;
        this.HN = 0L;
        this.HO = 0L;
        this.HD = handler;
        this.GP = aVar;
        this.GZ = lVar;
        this.HE = ByteBuffer.allocateDirect(lVar.lM() + 14);
        this.HF = new d(lVar.lN());
        this.HJ = null;
        this.mState = 1;
    }

    protected void w(Object obj) {
        this.HN = 0L;
        this.HO = 0L;
        Message obtainMessage = this.HD.obtainMessage();
        obtainMessage.obj = obj;
        this.HD.sendMessage(obtainMessage);
    }

    private boolean lT() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.HJ == null) {
            if (this.HE.position() >= 2) {
                byte b = this.HE.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.HE.get(1);
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
                    if (!this.HH && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.HH && i4 != 0) {
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
                if (this.HE.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.HE.get(2) & 255) << 8) | (this.HE.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.HE.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.HE.get(2) & 255) << 56) | ((this.HE.get(3) & 255) << 48) | ((this.HE.get(4) & 255) << 40) | ((this.HE.get(5) & 255) << 32) | ((this.HE.get(6) & 255) << 24) | ((this.HE.get(7) & 255) << 16) | ((this.HE.get(8) & 255) << 8) | (this.HE.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.HJ = new a();
                    this.HJ.HP = i4;
                    this.HJ.HQ = z;
                    this.HJ.HR = i3;
                    this.HJ.HU = (int) j;
                    this.HJ.HS = i2;
                    this.HJ.HV = this.HJ.HS + this.HJ.HU;
                    this.HJ.HW = null;
                    int position = this.HE.position();
                    this.HJ.HX = new byte[this.HJ.HS];
                    this.HE.position(0);
                    this.HE.get(this.HJ.HX, 0, this.HJ.HS);
                    this.HE.position(this.HJ.HS);
                    this.HE.limit(position);
                    this.HE.compact();
                    return this.HJ.HU == 0 || this.HE.position() >= this.HJ.HU;
                }
                return false;
            }
            return false;
        } else if (this.HK >= this.HJ.HU) {
            if (this.HJ.HP > 7) {
                if (this.HJ.HP == 8) {
                    if (this.HJ.HU < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.HJ.HX[1] & 255) + ((this.HJ.HX[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.HJ.HU > 2) {
                            byte[] bArr2 = new byte[this.HJ.HU - 2];
                            System.arraycopy(this.HJ.HX, 2, bArr2, 0, this.HJ.HU - 2);
                            f fVar = new f();
                            fVar.w(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.HJ.HP == 9) {
                    y(this.HF.toByteArray());
                } else if (this.HJ.HP == 10) {
                    z(this.HF.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.HH) {
                    this.HH = true;
                    this.HI = this.HJ.HP;
                    if (this.HI == 1 && this.GZ.lQ()) {
                        this.HL.reset();
                    }
                }
                if (this.HI == 1 && this.GZ.lQ() && !this.HL.w(this.HF.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.HJ.HQ) {
                    if (this.HI == 1) {
                        if (this.GZ.lQ() && !this.HL.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.GZ.lL()) {
                            x(this.HF.toByteArray());
                        } else {
                            aj(new String(this.HF.toByteArray(), "UTF-8"));
                        }
                    } else if (this.HI == 2) {
                        A(this.HF.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.HH = false;
                    this.HF.reset();
                }
            }
            this.HJ = null;
            this.HK = 0;
            return this.HE.position() > 0;
        } else {
            int position2 = this.HE.position();
            if (this.HJ.HU - this.HK < position2) {
                position2 = this.HJ.HU - this.HK;
            }
            int position3 = this.HE.position();
            if (this.HJ.HU > 0) {
                bArr = new byte[position2];
                this.HE.position(0);
                this.HE.get(bArr, 0, position2);
            }
            this.HE.position(position2);
            this.HE.limit(position3);
            this.HE.compact();
            if (bArr != null) {
                this.HF.write(bArr);
            }
            this.HK = position2 + this.HK;
            return this.HK >= this.HJ.HU;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        w(new k.q(z, map));
    }

    protected void f(int i, String str) {
        w(new k.c(i, str));
    }

    protected void y(byte[] bArr) {
        w(new k.j(bArr));
    }

    protected void z(byte[] bArr) {
        w(new k.C0018k(bArr));
    }

    protected void aj(String str) {
        w(new k.s(str));
    }

    protected void x(byte[] bArr) {
        w(new k.m(bArr));
    }

    protected void A(byte[] bArr) {
        this.HO = System.currentTimeMillis();
        w(new k.a(bArr, this.HN, this.HO));
    }

    private boolean lU() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.HE.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.HE.get(position + 0) != 13 || this.HE.get(position + 1) != 10 || this.HE.get(position + 2) != 13 || this.HE.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.HE.position();
                Map<String, String> map = null;
                if (this.HE.get(0) == 72 && this.HE.get(1) == 84 && this.HE.get(2) == 84 && this.HE.get(3) == 80) {
                    Pair<Integer, String> lV = lV();
                    if (((Integer) lV.first).intValue() >= 300) {
                        w(new k.p(((Integer) lV.first).intValue(), (String) lV.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.HE.position(0);
                        byte[] bArr = new byte[position];
                        this.HE.get(bArr);
                        map = B(bArr);
                    }
                } else {
                    z = false;
                }
                this.HE.position(position + 4);
                this.HE.limit(position2);
                this.HE.compact();
                if (this.HM < this.GP.lu() && map.size() == 0) {
                    this.HM++;
                    return true;
                }
                this.HM = 0;
                if (!z) {
                    z2 = this.HE.position() > 0;
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

    private Map<String, String> B(byte[] bArr) throws UnsupportedEncodingException {
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split(SystemInfoUtil.LINE_END);
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

    private Pair<Integer, String> lV() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.HE.position() && this.HE.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.HE.position() && this.HE.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.HE.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.HE.position() && this.HE.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.HE.position(i6);
        this.HE.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean lW() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return lT();
        }
        if (this.mState == 1) {
            return lU();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.GP.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.HE.clear();
            do {
                try {
                    int read = this.GP.read(this.HE);
                    if (read > 0) {
                        if (this.HN <= 0) {
                            this.HN = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            HG += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (lW());
                    } else if (read < 0) {
                        w(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.kK()) {
                        this.mStopped = true;
                        w(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            w(new k.d(e2));
        } catch (WebSocketException e3) {
            w(new k.l(e3));
        } catch (Exception e4) {
            w(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void lC() {
        synchronized (m.class) {
            HG = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = HG;
        }
        return j;
    }
}
