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
    private static long Ir = 0;
    private final e.a HB;
    private final l HJ;
    private final Handler Io;
    private final ByteBuffer Ip;
    private final d Iq;
    private boolean Is;
    private int It;
    private a Iu;
    private int Iv;
    private final f Iw;
    private int Ix;
    private long Iy;
    private long Iz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int IA;
        public boolean IB;
        public int IC;
        public int IE;
        public int IF;
        public int IG;
        public byte[] IH;
        public byte[] II;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Is = false;
        this.Iw = new f();
        this.Ix = 0;
        this.Iy = 0L;
        this.Iz = 0L;
        this.Io = handler;
        this.HB = aVar;
        this.HJ = lVar;
        this.Ip = ByteBuffer.allocateDirect(lVar.lY() + 14);
        this.Iq = new d(lVar.lZ());
        this.Iu = null;
        this.mState = 1;
    }

    protected void w(Object obj) {
        this.Iy = 0L;
        this.Iz = 0L;
        Message obtainMessage = this.Io.obtainMessage();
        obtainMessage.obj = obj;
        this.Io.sendMessage(obtainMessage);
    }

    private boolean mf() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Iu == null) {
            if (this.Ip.position() >= 2) {
                byte b = this.Ip.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ip.get(1);
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
                    if (!this.Is && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Is && i4 != 0) {
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
                if (this.Ip.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ip.get(2) & 255) << 8) | (this.Ip.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ip.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ip.get(2) & 255) << 56) | ((this.Ip.get(3) & 255) << 48) | ((this.Ip.get(4) & 255) << 40) | ((this.Ip.get(5) & 255) << 32) | ((this.Ip.get(6) & 255) << 24) | ((this.Ip.get(7) & 255) << 16) | ((this.Ip.get(8) & 255) << 8) | (this.Ip.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Iu = new a();
                    this.Iu.IA = i4;
                    this.Iu.IB = z;
                    this.Iu.IC = i3;
                    this.Iu.IF = (int) j;
                    this.Iu.IE = i2;
                    this.Iu.IG = this.Iu.IE + this.Iu.IF;
                    this.Iu.IH = null;
                    int position = this.Ip.position();
                    this.Iu.II = new byte[this.Iu.IE];
                    this.Ip.position(0);
                    this.Ip.get(this.Iu.II, 0, this.Iu.IE);
                    this.Ip.position(this.Iu.IE);
                    this.Ip.limit(position);
                    this.Ip.compact();
                    return this.Iu.IF == 0 || this.Ip.position() >= this.Iu.IF;
                }
                return false;
            }
            return false;
        } else if (this.Iv >= this.Iu.IF) {
            if (this.Iu.IA > 7) {
                if (this.Iu.IA == 8) {
                    if (this.Iu.IF < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Iu.II[1] & 255) + ((this.Iu.II[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Iu.IF > 2) {
                            byte[] bArr2 = new byte[this.Iu.IF - 2];
                            System.arraycopy(this.Iu.II, 2, bArr2, 0, this.Iu.IF - 2);
                            f fVar = new f();
                            fVar.w(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.Iu.IA == 9) {
                    y(this.Iq.toByteArray());
                } else if (this.Iu.IA == 10) {
                    z(this.Iq.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Is) {
                    this.Is = true;
                    this.It = this.Iu.IA;
                    if (this.It == 1 && this.HJ.mc()) {
                        this.Iw.reset();
                    }
                }
                if (this.It == 1 && this.HJ.mc() && !this.Iw.w(this.Iq.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Iu.IB) {
                    if (this.It == 1) {
                        if (this.HJ.mc() && !this.Iw.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.HJ.lX()) {
                            x(this.Iq.toByteArray());
                        } else {
                            aj(new String(this.Iq.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.It == 2) {
                        A(this.Iq.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Is = false;
                    this.Iq.reset();
                }
            }
            this.Iu = null;
            this.Iv = 0;
            return this.Ip.position() > 0;
        } else {
            int position2 = this.Ip.position();
            if (this.Iu.IF - this.Iv < position2) {
                position2 = this.Iu.IF - this.Iv;
            }
            int position3 = this.Ip.position();
            if (this.Iu.IF > 0) {
                bArr = new byte[position2];
                this.Ip.position(0);
                this.Ip.get(bArr, 0, position2);
            }
            this.Ip.position(position2);
            this.Ip.limit(position3);
            this.Ip.compact();
            if (bArr != null) {
                this.Iq.write(bArr);
            }
            this.Iv = position2 + this.Iv;
            return this.Iv >= this.Iu.IF;
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
        w(new k.C0019k(bArr));
    }

    protected void aj(String str) {
        w(new k.s(str));
    }

    protected void x(byte[] bArr) {
        w(new k.m(bArr));
    }

    protected void A(byte[] bArr) {
        this.Iz = System.currentTimeMillis();
        w(new k.a(bArr, this.Iy, this.Iz));
    }

    private boolean mg() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ip.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ip.get(position + 0) != 13 || this.Ip.get(position + 1) != 10 || this.Ip.get(position + 2) != 13 || this.Ip.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ip.position();
                Map<String, String> map = null;
                if (this.Ip.get(0) == 72 && this.Ip.get(1) == 84 && this.Ip.get(2) == 84 && this.Ip.get(3) == 80) {
                    Pair<Integer, String> mh = mh();
                    if (((Integer) mh.first).intValue() >= 300) {
                        w(new k.p(((Integer) mh.first).intValue(), (String) mh.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ip.position(0);
                        byte[] bArr = new byte[position];
                        this.Ip.get(bArr);
                        map = B(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ip.position(position + 4);
                this.Ip.limit(position2);
                this.Ip.compact();
                if (this.Ix < this.HB.lH() && map.size() == 0) {
                    this.Ix++;
                    return true;
                }
                this.Ix = 0;
                if (!z) {
                    z2 = this.Ip.position() > 0;
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

    private Pair<Integer, String> mh() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Ip.position() && this.Ip.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ip.position() && this.Ip.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ip.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ip.position() && this.Ip.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ip.position(i6);
        this.Ip.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean mi() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return mf();
        }
        if (this.mState == 1) {
            return mg();
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
            this.Ip.clear();
            do {
                try {
                    int read = this.HB.read(this.Ip);
                    if (read > 0) {
                        if (this.Iy <= 0) {
                            this.Iy = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Ir += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (mi());
                    } else if (read < 0) {
                        w(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.kY()) {
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

    public void lO() {
        synchronized (m.class) {
            Ir = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Ir;
        }
        return j;
    }
}
