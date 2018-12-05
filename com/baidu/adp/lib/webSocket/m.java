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
    private static long Im = 0;
    private final e.a HB;
    private final l HJ;
    private final Handler Ij;
    private final ByteBuffer Ik;
    private final d Il;
    private boolean In;
    private int Io;
    private a Ip;
    private int Iq;
    private final f Ir;
    private int Is;
    private long It;
    private long Iu;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int IA;
        public byte[] IB;
        public byte[] IC;
        public int Iv;
        public boolean Iw;
        public int Ix;
        public int Iy;
        public int Iz;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.In = false;
        this.Ir = new f();
        this.Is = 0;
        this.It = 0L;
        this.Iu = 0L;
        this.Ij = handler;
        this.HB = aVar;
        this.HJ = lVar;
        this.Ik = ByteBuffer.allocateDirect(lVar.lT() + 14);
        this.Il = new d(lVar.lU());
        this.Ip = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.It = 0L;
        this.Iu = 0L;
        Message obtainMessage = this.Ij.obtainMessage();
        obtainMessage.obj = obj;
        this.Ij.sendMessage(obtainMessage);
    }

    private boolean ma() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Ip == null) {
            if (this.Ik.position() >= 2) {
                byte b = this.Ik.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ik.get(1);
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
                    if (!this.In && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.In && i4 != 0) {
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
                if (this.Ik.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ik.get(2) & 255) << 8) | (this.Ik.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ik.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ik.get(2) & 255) << 56) | ((this.Ik.get(3) & 255) << 48) | ((this.Ik.get(4) & 255) << 40) | ((this.Ik.get(5) & 255) << 32) | ((this.Ik.get(6) & 255) << 24) | ((this.Ik.get(7) & 255) << 16) | ((this.Ik.get(8) & 255) << 8) | (this.Ik.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Ip = new a();
                    this.Ip.Iv = i4;
                    this.Ip.Iw = z;
                    this.Ip.Ix = i3;
                    this.Ip.Iz = (int) j;
                    this.Ip.Iy = i2;
                    this.Ip.IA = this.Ip.Iy + this.Ip.Iz;
                    this.Ip.IB = null;
                    int position = this.Ik.position();
                    this.Ip.IC = new byte[this.Ip.Iy];
                    this.Ik.position(0);
                    this.Ik.get(this.Ip.IC, 0, this.Ip.Iy);
                    this.Ik.position(this.Ip.Iy);
                    this.Ik.limit(position);
                    this.Ik.compact();
                    return this.Ip.Iz == 0 || this.Ik.position() >= this.Ip.Iz;
                }
                return false;
            }
            return false;
        } else if (this.Iq >= this.Ip.Iz) {
            if (this.Ip.Iv > 7) {
                if (this.Ip.Iv == 8) {
                    if (this.Ip.Iz < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Ip.IC[1] & 255) + ((this.Ip.IC[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Ip.Iz > 2) {
                            byte[] bArr2 = new byte[this.Ip.Iz - 2];
                            System.arraycopy(this.Ip.IC, 2, bArr2, 0, this.Ip.Iz - 2);
                            f fVar = new f();
                            fVar.v(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.Ip.Iv == 9) {
                    x(this.Il.toByteArray());
                } else if (this.Ip.Iv == 10) {
                    y(this.Il.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.In) {
                    this.In = true;
                    this.Io = this.Ip.Iv;
                    if (this.Io == 1 && this.HJ.lX()) {
                        this.Ir.reset();
                    }
                }
                if (this.Io == 1 && this.HJ.lX() && !this.Ir.v(this.Il.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Ip.Iw) {
                    if (this.Io == 1) {
                        if (this.HJ.lX() && !this.Ir.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.HJ.lS()) {
                            w(this.Il.toByteArray());
                        } else {
                            aj(new String(this.Il.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Io == 2) {
                        z(this.Il.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.In = false;
                    this.Il.reset();
                }
            }
            this.Ip = null;
            this.Iq = 0;
            return this.Ik.position() > 0;
        } else {
            int position2 = this.Ik.position();
            if (this.Ip.Iz - this.Iq < position2) {
                position2 = this.Ip.Iz - this.Iq;
            }
            int position3 = this.Ik.position();
            if (this.Ip.Iz > 0) {
                bArr = new byte[position2];
                this.Ik.position(0);
                this.Ik.get(bArr, 0, position2);
            }
            this.Ik.position(position2);
            this.Ik.limit(position3);
            this.Ik.compact();
            if (bArr != null) {
                this.Il.write(bArr);
            }
            this.Iq = position2 + this.Iq;
            return this.Iq >= this.Ip.Iz;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void f(int i, String str) {
        z(new k.c(i, str));
    }

    protected void x(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void y(byte[] bArr) {
        z(new k.C0021k(bArr));
    }

    protected void aj(String str) {
        z(new k.s(str));
    }

    protected void w(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void z(byte[] bArr) {
        this.Iu = System.currentTimeMillis();
        z(new k.a(bArr, this.It, this.Iu));
    }

    private boolean mb() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ik.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ik.get(position + 0) != 13 || this.Ik.get(position + 1) != 10 || this.Ik.get(position + 2) != 13 || this.Ik.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ik.position();
                Map<String, String> map = null;
                if (this.Ik.get(0) == 72 && this.Ik.get(1) == 84 && this.Ik.get(2) == 84 && this.Ik.get(3) == 80) {
                    Pair<Integer, String> mc = mc();
                    if (((Integer) mc.first).intValue() >= 300) {
                        z(new k.p(((Integer) mc.first).intValue(), (String) mc.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ik.position(0);
                        byte[] bArr = new byte[position];
                        this.Ik.get(bArr);
                        map = A(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ik.position(position + 4);
                this.Ik.limit(position2);
                this.Ik.compact();
                if (this.Is < this.HB.lC() && map.size() == 0) {
                    this.Is++;
                    return true;
                }
                this.Is = 0;
                if (!z) {
                    z2 = this.Ik.position() > 0;
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

    private Map<String, String> A(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> mc() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Ik.position() && this.Ik.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ik.position() && this.Ik.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ik.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ik.position() && this.Ik.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ik.position(i6);
        this.Ik.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean md() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return ma();
        }
        if (this.mState == 1) {
            return mb();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.HB.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ik.clear();
            do {
                try {
                    int read = this.HB.read(this.Ik);
                    if (read > 0) {
                        if (this.It <= 0) {
                            this.It = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Im += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (md());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.kV()) {
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

    public void lJ() {
        synchronized (m.class) {
            Im = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Im;
        }
        return j;
    }
}
