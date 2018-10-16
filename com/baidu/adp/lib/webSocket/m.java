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
    private static long Ii = 0;
    private final l HF;
    private final e.a Hx;
    private final Handler If;
    private final ByteBuffer Ig;
    private final d Ih;
    private boolean Ij;
    private int Ik;
    private a Il;
    private int Im;
    private final f In;
    private int Io;
    private long Ip;
    private long Iq;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Ir;
        public boolean Is;
        public int It;
        public int Iu;
        public int Iv;
        public int Iw;
        public byte[] Ix;
        public byte[] Iy;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Ij = false;
        this.In = new f();
        this.Io = 0;
        this.Ip = 0L;
        this.Iq = 0L;
        this.If = handler;
        this.Hx = aVar;
        this.HF = lVar;
        this.Ig = ByteBuffer.allocateDirect(lVar.lW() + 14);
        this.Ih = new d(lVar.lX());
        this.Il = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.Ip = 0L;
        this.Iq = 0L;
        Message obtainMessage = this.If.obtainMessage();
        obtainMessage.obj = obj;
        this.If.sendMessage(obtainMessage);
    }

    private boolean md() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Il == null) {
            if (this.Ig.position() >= 2) {
                byte b = this.Ig.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ig.get(1);
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
                    if (!this.Ij && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Ij && i4 != 0) {
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
                if (this.Ig.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ig.get(2) & 255) << 8) | (this.Ig.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ig.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ig.get(2) & 255) << 56) | ((this.Ig.get(3) & 255) << 48) | ((this.Ig.get(4) & 255) << 40) | ((this.Ig.get(5) & 255) << 32) | ((this.Ig.get(6) & 255) << 24) | ((this.Ig.get(7) & 255) << 16) | ((this.Ig.get(8) & 255) << 8) | (this.Ig.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Il = new a();
                    this.Il.Ir = i4;
                    this.Il.Is = z;
                    this.Il.It = i3;
                    this.Il.Iv = (int) j;
                    this.Il.Iu = i2;
                    this.Il.Iw = this.Il.Iu + this.Il.Iv;
                    this.Il.Ix = null;
                    int position = this.Ig.position();
                    this.Il.Iy = new byte[this.Il.Iu];
                    this.Ig.position(0);
                    this.Ig.get(this.Il.Iy, 0, this.Il.Iu);
                    this.Ig.position(this.Il.Iu);
                    this.Ig.limit(position);
                    this.Ig.compact();
                    return this.Il.Iv == 0 || this.Ig.position() >= this.Il.Iv;
                }
                return false;
            }
            return false;
        } else if (this.Im >= this.Il.Iv) {
            if (this.Il.Ir > 7) {
                if (this.Il.Ir == 8) {
                    if (this.Il.Iv < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Il.Iy[1] & 255) + ((this.Il.Iy[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Il.Iv > 2) {
                            byte[] bArr2 = new byte[this.Il.Iv - 2];
                            System.arraycopy(this.Il.Iy, 2, bArr2, 0, this.Il.Iv - 2);
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
                } else if (this.Il.Ir == 9) {
                    y(this.Ih.toByteArray());
                } else if (this.Il.Ir == 10) {
                    z(this.Ih.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Ij) {
                    this.Ij = true;
                    this.Ik = this.Il.Ir;
                    if (this.Ik == 1 && this.HF.ma()) {
                        this.In.reset();
                    }
                }
                if (this.Ik == 1 && this.HF.ma() && !this.In.w(this.Ih.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Il.Is) {
                    if (this.Ik == 1) {
                        if (this.HF.ma() && !this.In.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.HF.lV()) {
                            x(this.Ih.toByteArray());
                        } else {
                            aj(new String(this.Ih.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Ik == 2) {
                        A(this.Ih.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Ij = false;
                    this.Ih.reset();
                }
            }
            this.Il = null;
            this.Im = 0;
            return this.Ig.position() > 0;
        } else {
            int position2 = this.Ig.position();
            if (this.Il.Iv - this.Im < position2) {
                position2 = this.Il.Iv - this.Im;
            }
            int position3 = this.Ig.position();
            if (this.Il.Iv > 0) {
                bArr = new byte[position2];
                this.Ig.position(0);
                this.Ig.get(bArr, 0, position2);
            }
            this.Ig.position(position2);
            this.Ig.limit(position3);
            this.Ig.compact();
            if (bArr != null) {
                this.Ih.write(bArr);
            }
            this.Im = position2 + this.Im;
            return this.Im >= this.Il.Iv;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void f(int i, String str) {
        z(new k.c(i, str));
    }

    protected void y(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void z(byte[] bArr) {
        z(new k.C0021k(bArr));
    }

    protected void aj(String str) {
        z(new k.s(str));
    }

    protected void x(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void A(byte[] bArr) {
        this.Iq = System.currentTimeMillis();
        z(new k.a(bArr, this.Ip, this.Iq));
    }

    private boolean me() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ig.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ig.get(position + 0) != 13 || this.Ig.get(position + 1) != 10 || this.Ig.get(position + 2) != 13 || this.Ig.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ig.position();
                Map<String, String> map = null;
                if (this.Ig.get(0) == 72 && this.Ig.get(1) == 84 && this.Ig.get(2) == 84 && this.Ig.get(3) == 80) {
                    Pair<Integer, String> mf = mf();
                    if (((Integer) mf.first).intValue() >= 300) {
                        z(new k.p(((Integer) mf.first).intValue(), (String) mf.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ig.position(0);
                        byte[] bArr = new byte[position];
                        this.Ig.get(bArr);
                        map = B(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ig.position(position + 4);
                this.Ig.limit(position2);
                this.Ig.compact();
                if (this.Io < this.Hx.lF() && map.size() == 0) {
                    this.Io++;
                    return true;
                }
                this.Io = 0;
                if (!z) {
                    z2 = this.Ig.position() > 0;
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

    private Pair<Integer, String> mf() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Ig.position() && this.Ig.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ig.position() && this.Ig.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ig.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ig.position() && this.Ig.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ig.position(i6);
        this.Ig.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean mg() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return md();
        }
        if (this.mState == 1) {
            return me();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Hx.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ig.clear();
            do {
                try {
                    int read = this.Hx.read(this.Ig);
                    if (read > 0) {
                        if (this.Ip <= 0) {
                            this.Ip = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Ii += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (mg());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.kX()) {
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

    public void lM() {
        synchronized (m.class) {
            Ii = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Ii;
        }
        return j;
    }
}
