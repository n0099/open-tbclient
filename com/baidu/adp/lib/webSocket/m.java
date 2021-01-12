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
    private static long RZ = 0;
    private final Handler RW;
    private final ByteBuffer RX;
    private final d RY;
    private final e.a Rm;
    private final l Ru;
    private boolean Sa;
    private int Sb;
    private a Sc;
    private int Sd;
    private final f Se;
    private int Sf;
    private long Sg;
    private long Sh;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Si;
        public boolean Sj;
        public int Sk;
        public int Sl;
        public int Sm;
        public int Sn;
        public byte[] So;
        public byte[] Sp;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Sa = false;
        this.Se = new f();
        this.Sf = 0;
        this.Sg = 0L;
        this.Sh = 0L;
        this.RW = handler;
        this.Rm = aVar;
        this.Ru = lVar;
        this.RX = ByteBuffer.allocateDirect(lVar.os() + 14);
        this.RY = new d(lVar.ot());
        this.Sc = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Sg = 0L;
        this.Sh = 0L;
        Message obtainMessage = this.RW.obtainMessage();
        obtainMessage.obj = obj;
        this.RW.sendMessage(obtainMessage);
    }

    private boolean oA() throws Exception {
        String str;
        int i;
        long j;
        byte[] bArr = null;
        if (this.Sc == null) {
            if (this.RX.position() >= 2) {
                byte b2 = this.RX.get(0);
                boolean z = (b2 & 128) != 0;
                int i2 = (b2 & 112) >> 4;
                int i3 = b2 & 15;
                byte b3 = this.RX.get(1);
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
                    if (!this.Sa && i3 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Sa && i3 != 0) {
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
                if (this.RX.position() >= i) {
                    if (i4 == 126) {
                        j = ((this.RX.get(2) & 255) << 8) | (this.RX.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i4 == 127) {
                        if ((this.RX.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.RX.get(2) & 255) << 56) | ((this.RX.get(3) & 255) << 48) | ((this.RX.get(4) & 255) << 40) | ((this.RX.get(5) & 255) << 32) | ((this.RX.get(6) & 255) << 24) | ((this.RX.get(7) & 255) << 16) | ((this.RX.get(8) & 255) << 8) | (this.RX.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i4;
                    }
                    this.Sc = new a();
                    this.Sc.Si = i3;
                    this.Sc.Sj = z;
                    this.Sc.Sk = i2;
                    this.Sc.Sm = (int) j;
                    this.Sc.Sl = i;
                    this.Sc.Sn = this.Sc.Sl + this.Sc.Sm;
                    this.Sc.So = null;
                    int position = this.RX.position();
                    this.Sc.Sp = new byte[this.Sc.Sl];
                    this.RX.position(0);
                    this.RX.get(this.Sc.Sp, 0, this.Sc.Sl);
                    this.RX.position(this.Sc.Sl);
                    this.RX.limit(position);
                    this.RX.compact();
                    return this.Sc.Sm == 0 || this.RX.position() >= this.Sc.Sm;
                }
                return false;
            }
            return false;
        } else if (this.Sd >= this.Sc.Sm) {
            if (this.Sc.Si > 7) {
                if (this.Sc.Si == 8) {
                    int i5 = 1005;
                    if (this.Sc.Sm >= 2) {
                        i5 = (this.Sc.Sp[1] & 255) + ((this.Sc.Sp[0] & 255) * 256);
                        if (i5 < 1000 || ((i5 >= 1000 && i5 <= 2999 && i5 != 1000 && i5 != 1001 && i5 != 1002 && i5 != 1003 && i5 != 1007 && i5 != 1008 && i5 != 1009 && i5 != 1010 && i5 != 1011) || i5 >= 5000)) {
                            throw new WebSocketException("invalid close code " + i5);
                        }
                        if (this.Sc.Sm > 2) {
                            byte[] bArr2 = new byte[this.Sc.Sm - 2];
                            System.arraycopy(this.Sc.Sp, 2, bArr2, 0, this.Sc.Sm - 2);
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
                } else if (this.Sc.Si == 9) {
                    n(this.RY.toByteArray());
                } else if (this.Sc.Si == 10) {
                    o(this.RY.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Sa) {
                    this.Sa = true;
                    this.Sb = this.Sc.Si;
                    if (this.Sb == 1 && this.Ru.ox()) {
                        this.Se.reset();
                    }
                }
                if (this.Sb == 1 && this.Ru.ox() && !this.Se.l(this.RY.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Sc.Sj) {
                    if (this.Sb == 1) {
                        if (this.Ru.ox() && !this.Se.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ru.or()) {
                            m(this.RY.toByteArray());
                        } else {
                            onTextMessage(new String(this.RY.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Sb == 2) {
                        p(this.RY.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Sa = false;
                    this.RY.reset();
                }
            }
            this.Sc = null;
            this.Sd = 0;
            return this.RX.position() > 0;
        } else {
            int position2 = this.RX.position();
            if (this.Sc.Sm - this.Sd < position2) {
                position2 = this.Sc.Sm - this.Sd;
            }
            int position3 = this.RX.position();
            if (this.Sc.Sm > 0) {
                bArr = new byte[position2];
                this.RX.position(0);
                this.RX.get(bArr, 0, position2);
            }
            this.RX.position(position2);
            this.RX.limit(position3);
            this.RX.compact();
            if (bArr != null) {
                this.RY.write(bArr);
            }
            this.Sd = position2 + this.Sd;
            return this.Sd >= this.Sc.Sm;
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
        this.Sh = System.currentTimeMillis();
        v(new k.a(bArr, this.Sg, this.Sh));
    }

    private boolean oB() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.RX.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.RX.get(position + 0) != 13 || this.RX.get(position + 1) != 10 || this.RX.get(position + 2) != 13 || this.RX.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.RX.position();
                Map<String, String> map = null;
                if (this.RX.get(0) == 72 && this.RX.get(1) == 84 && this.RX.get(2) == 84 && this.RX.get(3) == 80) {
                    Pair<Integer, String> oC = oC();
                    if (((Integer) oC.first).intValue() >= 300) {
                        v(new k.p(((Integer) oC.first).intValue(), (String) oC.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.RX.position(0);
                        byte[] bArr = new byte[position];
                        this.RX.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.RX.position(position + 4);
                this.RX.limit(position2);
                this.RX.compact();
                if (this.Sf < this.Rm.ob() && map.size() == 0) {
                    this.Sf++;
                    return true;
                }
                this.Sf = 0;
                if (!z) {
                    z2 = this.RX.position() > 0;
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

    private Pair<Integer, String> oC() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.RX.position() && this.RX.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.RX.position() && this.RX.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.RX.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.RX.position() && this.RX.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.RX.position(i6);
        this.RX.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean oD() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oA();
        }
        if (this.mState == 1) {
            return oB();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Rm.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.RX.clear();
            do {
                try {
                    int read = this.Rm.read(this.RX);
                    if (read > 0) {
                        if (this.Sg <= 0) {
                            this.Sg = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            RZ += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (oD());
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

    public void oi() {
        synchronized (m.class) {
            RZ = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = RZ;
        }
        return j;
    }
}
