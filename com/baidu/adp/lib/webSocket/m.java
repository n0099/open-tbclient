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
    private static long Sb = 0;
    private final Handler RY;
    private final ByteBuffer RZ;
    private final e.a Ro;
    private final l Rw;
    private final d Sa;
    private boolean Sc;
    private int Sd;
    private a Se;
    private int Sf;
    private final f Sg;
    private int Sh;
    private long Si;
    private long Sj;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Sk;
        public boolean Sl;
        public int Sm;
        public int Sn;
        public int So;
        public int Sp;
        public byte[] Sq;
        public byte[] Sr;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Sc = false;
        this.Sg = new f();
        this.Sh = 0;
        this.Si = 0L;
        this.Sj = 0L;
        this.RY = handler;
        this.Ro = aVar;
        this.Rw = lVar;
        this.RZ = ByteBuffer.allocateDirect(lVar.os() + 14);
        this.Sa = new d(lVar.ot());
        this.Se = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Si = 0L;
        this.Sj = 0L;
        Message obtainMessage = this.RY.obtainMessage();
        obtainMessage.obj = obj;
        this.RY.sendMessage(obtainMessage);
    }

    private boolean oA() throws Exception {
        String str;
        int i;
        long j;
        byte[] bArr = null;
        if (this.Se == null) {
            if (this.RZ.position() >= 2) {
                byte b2 = this.RZ.get(0);
                boolean z = (b2 & 128) != 0;
                int i2 = (b2 & 112) >> 4;
                int i3 = b2 & 15;
                byte b3 = this.RZ.get(1);
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
                    if (!this.Sc && i3 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Sc && i3 != 0) {
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
                if (this.RZ.position() >= i) {
                    if (i4 == 126) {
                        j = ((this.RZ.get(2) & 255) << 8) | (this.RZ.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i4 == 127) {
                        if ((this.RZ.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.RZ.get(2) & 255) << 56) | ((this.RZ.get(3) & 255) << 48) | ((this.RZ.get(4) & 255) << 40) | ((this.RZ.get(5) & 255) << 32) | ((this.RZ.get(6) & 255) << 24) | ((this.RZ.get(7) & 255) << 16) | ((this.RZ.get(8) & 255) << 8) | (this.RZ.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i4;
                    }
                    this.Se = new a();
                    this.Se.Sk = i3;
                    this.Se.Sl = z;
                    this.Se.Sm = i2;
                    this.Se.So = (int) j;
                    this.Se.Sn = i;
                    this.Se.Sp = this.Se.Sn + this.Se.So;
                    this.Se.Sq = null;
                    int position = this.RZ.position();
                    this.Se.Sr = new byte[this.Se.Sn];
                    this.RZ.position(0);
                    this.RZ.get(this.Se.Sr, 0, this.Se.Sn);
                    this.RZ.position(this.Se.Sn);
                    this.RZ.limit(position);
                    this.RZ.compact();
                    return this.Se.So == 0 || this.RZ.position() >= this.Se.So;
                }
                return false;
            }
            return false;
        } else if (this.Sf >= this.Se.So) {
            if (this.Se.Sk > 7) {
                if (this.Se.Sk == 8) {
                    int i5 = 1005;
                    if (this.Se.So >= 2) {
                        i5 = (this.Se.Sr[1] & 255) + ((this.Se.Sr[0] & 255) * 256);
                        if (i5 < 1000 || ((i5 >= 1000 && i5 <= 2999 && i5 != 1000 && i5 != 1001 && i5 != 1002 && i5 != 1003 && i5 != 1007 && i5 != 1008 && i5 != 1009 && i5 != 1010 && i5 != 1011) || i5 >= 5000)) {
                            throw new WebSocketException("invalid close code " + i5);
                        }
                        if (this.Se.So > 2) {
                            byte[] bArr2 = new byte[this.Se.So - 2];
                            System.arraycopy(this.Se.Sr, 2, bArr2, 0, this.Se.So - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                            c(i5, str);
                        }
                    }
                    str = null;
                    c(i5, str);
                } else if (this.Se.Sk == 9) {
                    n(this.Sa.toByteArray());
                } else if (this.Se.Sk == 10) {
                    o(this.Sa.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Sc) {
                    this.Sc = true;
                    this.Sd = this.Se.Sk;
                    if (this.Sd == 1 && this.Rw.ox()) {
                        this.Sg.reset();
                    }
                }
                if (this.Sd == 1 && this.Rw.ox() && !this.Sg.l(this.Sa.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Se.Sl) {
                    if (this.Sd == 1) {
                        if (this.Rw.ox() && !this.Sg.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Rw.or()) {
                            m(this.Sa.toByteArray());
                        } else {
                            onTextMessage(new String(this.Sa.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Sd == 2) {
                        p(this.Sa.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Sc = false;
                    this.Sa.reset();
                }
            }
            this.Se = null;
            this.Sf = 0;
            return this.RZ.position() > 0;
        } else {
            int position2 = this.RZ.position();
            if (this.Se.So - this.Sf < position2) {
                position2 = this.Se.So - this.Sf;
            }
            int position3 = this.RZ.position();
            if (this.Se.So > 0) {
                bArr = new byte[position2];
                this.RZ.position(0);
                this.RZ.get(bArr, 0, position2);
            }
            this.RZ.position(position2);
            this.RZ.limit(position3);
            this.RZ.compact();
            if (bArr != null) {
                this.Sa.write(bArr);
            }
            this.Sf = position2 + this.Sf;
            return this.Sf >= this.Se.So;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void c(int i, String str) {
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
        this.Sj = System.currentTimeMillis();
        v(new k.a(bArr, this.Si, this.Sj));
    }

    private boolean oB() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.RZ.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.RZ.get(position + 0) != 13 || this.RZ.get(position + 1) != 10 || this.RZ.get(position + 2) != 13 || this.RZ.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.RZ.position();
                Map<String, String> map = null;
                if (this.RZ.get(0) == 72 && this.RZ.get(1) == 84 && this.RZ.get(2) == 84 && this.RZ.get(3) == 80) {
                    Pair<Integer, String> oC = oC();
                    if (((Integer) oC.first).intValue() >= 300) {
                        v(new k.p(((Integer) oC.first).intValue(), (String) oC.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.RZ.position(0);
                        byte[] bArr = new byte[position];
                        this.RZ.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.RZ.position(position + 4);
                this.RZ.limit(position2);
                this.RZ.compact();
                if (this.Sh < this.Ro.ob() && map.size() == 0) {
                    this.Sh++;
                    return true;
                }
                this.Sh = 0;
                if (!z) {
                    z2 = this.RZ.position() > 0;
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
        while (i < this.RZ.position() && this.RZ.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.RZ.position() && this.RZ.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.RZ.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.RZ.position() && this.RZ.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.RZ.position(i6);
        this.RZ.get(bArr, 0, i8);
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
            this.Ro.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.RZ.clear();
            do {
                try {
                    int read = this.Ro.read(this.RZ);
                    if (read > 0) {
                        if (this.Si <= 0) {
                            this.Si = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Sb += read;
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
            Sb = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Sb;
        }
        return j;
    }
}
