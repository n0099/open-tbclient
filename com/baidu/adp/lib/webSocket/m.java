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
    private static long RX = 0;
    private final Handler RU;
    private final ByteBuffer RV;
    private final d RW;
    private boolean RY;
    private int RZ;
    private final e.a Rk;
    private final l Rs;
    private a Sa;
    private int Sb;
    private final f Sc;
    private int Sd;
    private long Se;
    private long Sf;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Sg;
        public boolean Sh;
        public int Si;
        public int Sj;
        public int Sk;
        public int Sl;
        public byte[] Sm;
        public byte[] Sn;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.RY = false;
        this.Sc = new f();
        this.Sd = 0;
        this.Se = 0L;
        this.Sf = 0L;
        this.RU = handler;
        this.Rk = aVar;
        this.Rs = lVar;
        this.RV = ByteBuffer.allocateDirect(lVar.oq() + 14);
        this.RW = new d(lVar.or());
        this.Sa = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Se = 0L;
        this.Sf = 0L;
        Message obtainMessage = this.RU.obtainMessage();
        obtainMessage.obj = obj;
        this.RU.sendMessage(obtainMessage);
    }

    private boolean oy() throws Exception {
        String str;
        int i;
        long j;
        byte[] bArr = null;
        if (this.Sa == null) {
            if (this.RV.position() >= 2) {
                byte b2 = this.RV.get(0);
                boolean z = (b2 & 128) != 0;
                int i2 = (b2 & 112) >> 4;
                int i3 = b2 & 15;
                byte b3 = this.RV.get(1);
                boolean z2 = (b3 & 128) != 0;
                int i4 = b3 & Byte.MAX_VALUE;
                if (i2 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i3 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i4 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i3 != 8 && i3 != 9 && i3 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i3);
                    }
                    if (i3 == 8 && i4 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i3 != 0 && i3 != 1 && i3 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i3);
                } else {
                    if (!this.RY && i3 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.RY && i3 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i4 < 126) {
                    i = 2;
                } else if (i4 == 126) {
                    i = 4;
                } else if (i4 == 127) {
                    i = 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.RV.position() >= i) {
                    if (i4 == 126) {
                        j = ((this.RV.get(2) & 255) << 8) | (this.RV.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i4 == 127) {
                        if ((this.RV.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.RV.get(2) & 255) << 56) | ((this.RV.get(3) & 255) << 48) | ((this.RV.get(4) & 255) << 40) | ((this.RV.get(5) & 255) << 32) | ((this.RV.get(6) & 255) << 24) | ((this.RV.get(7) & 255) << 16) | ((this.RV.get(8) & 255) << 8) | (this.RV.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i4;
                    }
                    this.Sa = new a();
                    this.Sa.Sg = i3;
                    this.Sa.Sh = z;
                    this.Sa.Si = i2;
                    this.Sa.Sk = (int) j;
                    this.Sa.Sj = i;
                    this.Sa.Sl = this.Sa.Sj + this.Sa.Sk;
                    this.Sa.Sm = null;
                    int position = this.RV.position();
                    this.Sa.Sn = new byte[this.Sa.Sj];
                    this.RV.position(0);
                    this.RV.get(this.Sa.Sn, 0, this.Sa.Sj);
                    this.RV.position(this.Sa.Sj);
                    this.RV.limit(position);
                    this.RV.compact();
                    return this.Sa.Sk == 0 || this.RV.position() >= this.Sa.Sk;
                }
                return false;
            }
            return false;
        } else if (this.Sb >= this.Sa.Sk) {
            if (this.Sa.Sg > 7) {
                if (this.Sa.Sg == 8) {
                    int i5 = 1005;
                    if (this.Sa.Sk >= 2) {
                        i5 = (this.Sa.Sn[1] & 255) + ((this.Sa.Sn[0] & 255) * 256);
                        if (i5 < 1000 || ((i5 >= 1000 && i5 <= 2999 && i5 != 1000 && i5 != 1001 && i5 != 1002 && i5 != 1003 && i5 != 1007 && i5 != 1008 && i5 != 1009 && i5 != 1010 && i5 != 1011) || i5 >= 5000)) {
                            throw new WebSocketException("invalid close code " + i5);
                        }
                        if (this.Sa.Sk > 2) {
                            byte[] bArr2 = new byte[this.Sa.Sk - 2];
                            System.arraycopy(this.Sa.Sn, 2, bArr2, 0, this.Sa.Sk - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                            d(i5, str);
                        }
                    }
                    str = null;
                    d(i5, str);
                } else if (this.Sa.Sg == 9) {
                    n(this.RW.toByteArray());
                } else if (this.Sa.Sg == 10) {
                    o(this.RW.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.RY) {
                    this.RY = true;
                    this.RZ = this.Sa.Sg;
                    if (this.RZ == 1 && this.Rs.ov()) {
                        this.Sc.reset();
                    }
                }
                if (this.RZ == 1 && this.Rs.ov() && !this.Sc.l(this.RW.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Sa.Sh) {
                    if (this.RZ == 1) {
                        if (this.Rs.ov() && !this.Sc.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Rs.op()) {
                            m(this.RW.toByteArray());
                        } else {
                            onTextMessage(new String(this.RW.toByteArray(), "UTF-8"));
                        }
                    } else if (this.RZ == 2) {
                        p(this.RW.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.RY = false;
                    this.RW.reset();
                }
            }
            this.Sa = null;
            this.Sb = 0;
            return this.RV.position() > 0;
        } else {
            int position2 = this.RV.position();
            if (this.Sa.Sk - this.Sb < position2) {
                position2 = this.Sa.Sk - this.Sb;
            }
            int position3 = this.RV.position();
            if (this.Sa.Sk > 0) {
                bArr = new byte[position2];
                this.RV.position(0);
                this.RV.get(bArr, 0, position2);
            }
            this.RV.position(position2);
            this.RV.limit(position3);
            this.RV.compact();
            if (bArr != null) {
                this.RW.write(bArr);
            }
            this.Sb = position2 + this.Sb;
            return this.Sb >= this.Sa.Sk;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void d(int i, String str) {
        v(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        v(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        v(new k.C0019k(bArr));
    }

    protected void onTextMessage(String str) {
        v(new k.s(str));
    }

    protected void m(byte[] bArr) {
        v(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.Sf = System.currentTimeMillis();
        v(new k.a(bArr, this.Se, this.Sf));
    }

    private boolean oz() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.RV.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.RV.get(position + 0) != 13 || this.RV.get(position + 1) != 10 || this.RV.get(position + 2) != 13 || this.RV.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.RV.position();
                Map<String, String> map = null;
                if (this.RV.get(0) == 72 && this.RV.get(1) == 84 && this.RV.get(2) == 84 && this.RV.get(3) == 80) {
                    Pair<Integer, String> oA = oA();
                    if (((Integer) oA.first).intValue() >= 300) {
                        v(new k.p(((Integer) oA.first).intValue(), (String) oA.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.RV.position(0);
                        byte[] bArr = new byte[position];
                        this.RV.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.RV.position(position + 4);
                this.RV.limit(position2);
                this.RV.compact();
                if (this.Sd < this.Rk.nZ() && map.size() == 0) {
                    this.Sd++;
                    return true;
                }
                this.Sd = 0;
                if (!z) {
                    z2 = this.RV.position() > 0;
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

    private Pair<Integer, String> oA() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.RV.position() && this.RV.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.RV.position() && this.RV.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.RV.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.RV.position() && this.RV.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.RV.position(i6);
        this.RV.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean oB() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oy();
        }
        if (this.mState == 1) {
            return oz();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Rk.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.RV.clear();
            do {
                try {
                    int read = this.Rk.read(this.RV);
                    if (read > 0) {
                        if (this.Se <= 0) {
                            this.Se = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            RX += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (oB());
                    } else if (read < 0) {
                        v(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        v(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            v(new k.d(e2));
        } catch (WebSocketException e3) {
            v(new k.l(e3));
        } catch (Exception e4) {
            v(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void og() {
        synchronized (m.class) {
            RX = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = RX;
        }
        return j;
    }
}
