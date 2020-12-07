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
    private static long RY = 0;
    private final Handler RV;
    private final ByteBuffer RW;
    private final d RX;
    private boolean RZ;
    private final e.a Rl;
    private final l Rt;
    private int Sa;
    private a Sb;
    private int Sc;
    private final f Sd;
    private int Se;
    private long Sf;
    private long Sg;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Sh;
        public boolean Si;
        public int Sj;
        public int Sk;
        public int Sl;
        public int Sm;
        public byte[] Sn;
        public byte[] So;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.RZ = false;
        this.Sd = new f();
        this.Se = 0;
        this.Sf = 0L;
        this.Sg = 0L;
        this.RV = handler;
        this.Rl = aVar;
        this.Rt = lVar;
        this.RW = ByteBuffer.allocateDirect(lVar.oR() + 14);
        this.RX = new d(lVar.oS());
        this.Sb = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.Sf = 0L;
        this.Sg = 0L;
        Message obtainMessage = this.RV.obtainMessage();
        obtainMessage.obj = obj;
        this.RV.sendMessage(obtainMessage);
    }

    private boolean oZ() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Sb == null) {
            if (this.RW.position() >= 2) {
                byte b = this.RW.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.RW.get(1);
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
                    if (!this.RZ && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.RZ && i4 != 0) {
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
                if (this.RW.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.RW.get(2) & 255) << 8) | (this.RW.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.RW.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.RW.get(2) & 255) << 56) | ((this.RW.get(3) & 255) << 48) | ((this.RW.get(4) & 255) << 40) | ((this.RW.get(5) & 255) << 32) | ((this.RW.get(6) & 255) << 24) | ((this.RW.get(7) & 255) << 16) | ((this.RW.get(8) & 255) << 8) | (this.RW.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Sb = new a();
                    this.Sb.Sh = i4;
                    this.Sb.Si = z;
                    this.Sb.Sj = i3;
                    this.Sb.Sl = (int) j;
                    this.Sb.Sk = i2;
                    this.Sb.Sm = this.Sb.Sk + this.Sb.Sl;
                    this.Sb.Sn = null;
                    int position = this.RW.position();
                    this.Sb.So = new byte[this.Sb.Sk];
                    this.RW.position(0);
                    this.RW.get(this.Sb.So, 0, this.Sb.Sk);
                    this.RW.position(this.Sb.Sk);
                    this.RW.limit(position);
                    this.RW.compact();
                    return this.Sb.Sl == 0 || this.RW.position() >= this.Sb.Sl;
                }
                return false;
            }
            return false;
        } else if (this.Sc >= this.Sb.Sl) {
            if (this.Sb.Sh > 7) {
                if (this.Sb.Sh == 8) {
                    if (this.Sb.Sl < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Sb.So[1] & 255) + ((this.Sb.So[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Sb.Sl > 2) {
                            byte[] bArr2 = new byte[this.Sb.Sl - 2];
                            System.arraycopy(this.Sb.So, 2, bArr2, 0, this.Sb.Sl - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    c(i, str);
                } else if (this.Sb.Sh == 9) {
                    n(this.RX.toByteArray());
                } else if (this.Sb.Sh == 10) {
                    o(this.RX.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.RZ) {
                    this.RZ = true;
                    this.Sa = this.Sb.Sh;
                    if (this.Sa == 1 && this.Rt.oW()) {
                        this.Sd.reset();
                    }
                }
                if (this.Sa == 1 && this.Rt.oW() && !this.Sd.l(this.RX.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Sb.Si) {
                    if (this.Sa == 1) {
                        if (this.Rt.oW() && !this.Sd.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Rt.oQ()) {
                            m(this.RX.toByteArray());
                        } else {
                            onTextMessage(new String(this.RX.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Sa == 2) {
                        p(this.RX.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.RZ = false;
                    this.RX.reset();
                }
            }
            this.Sb = null;
            this.Sc = 0;
            return this.RW.position() > 0;
        } else {
            int position2 = this.RW.position();
            if (this.Sb.Sl - this.Sc < position2) {
                position2 = this.Sb.Sl - this.Sc;
            }
            int position3 = this.RW.position();
            if (this.Sb.Sl > 0) {
                bArr = new byte[position2];
                this.RW.position(0);
                this.RW.get(bArr, 0, position2);
            }
            this.RW.position(position2);
            this.RW.limit(position3);
            this.RW.compact();
            if (bArr != null) {
                this.RX.write(bArr);
            }
            this.Sc = position2 + this.Sc;
            return this.Sc >= this.Sb.Sl;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void c(int i, String str) {
        z(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        z(new k.C0024k(bArr));
    }

    protected void onTextMessage(String str) {
        z(new k.s(str));
    }

    protected void m(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.Sg = System.currentTimeMillis();
        z(new k.a(bArr, this.Sf, this.Sg));
    }

    private boolean pa() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.RW.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.RW.get(position + 0) != 13 || this.RW.get(position + 1) != 10 || this.RW.get(position + 2) != 13 || this.RW.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.RW.position();
                Map<String, String> map = null;
                if (this.RW.get(0) == 72 && this.RW.get(1) == 84 && this.RW.get(2) == 84 && this.RW.get(3) == 80) {
                    Pair<Integer, String> pb = pb();
                    if (((Integer) pb.first).intValue() >= 300) {
                        z(new k.p(((Integer) pb.first).intValue(), (String) pb.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.RW.position(0);
                        byte[] bArr = new byte[position];
                        this.RW.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.RW.position(position + 4);
                this.RW.limit(position2);
                this.RW.compact();
                if (this.Se < this.Rl.oA() && map.size() == 0) {
                    this.Se++;
                    return true;
                }
                this.Se = 0;
                if (!z) {
                    z2 = this.RW.position() > 0;
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

    private Pair<Integer, String> pb() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.RW.position() && this.RW.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.RW.position() && this.RW.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.RW.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.RW.position() && this.RW.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.RW.position(i6);
        this.RW.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean pc() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oZ();
        }
        if (this.mState == 1) {
            return pa();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Rl.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.RW.clear();
            do {
                try {
                    int read = this.Rl.read(this.RW);
                    if (read > 0) {
                        if (this.Sf <= 0) {
                            this.Sf = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            RY += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pc());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        z(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            z(new k.d(e2));
        } catch (WebSocketException e3) {
            z(new k.l(e3));
        } catch (Exception e4) {
            z(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void oH() {
        synchronized (m.class) {
            RY = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = RY;
        }
        return j;
    }
}
