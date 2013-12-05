package com.baidu.adp.lib.webSocket;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class an extends Thread {
    private static long f = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f532a;
    private final g b;
    private final am c;
    private final ByteBuffer d;
    private e e;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private ap k;
    private j l;

    public an(Handler handler, g gVar, am amVar, String str) {
        super(str);
        this.g = false;
        this.i = false;
        this.l = new j();
        this.f532a = handler;
        this.b = gVar;
        this.c = amVar;
        this.d = ByteBuffer.allocateDirect(amVar.b() + 14);
        this.e = new e(amVar.c());
        this.k = null;
        this.h = 1;
        if (h()) {
            com.baidu.adp.lib.h.e.d("created");
        }
    }

    protected void a(Object obj) {
        Message obtainMessage = this.f532a.obtainMessage();
        obtainMessage.obj = obj;
        this.f532a.sendMessage(obtainMessage);
    }

    private boolean d() {
        String str;
        int i;
        int i2;
        long j;
        int i3 = 2;
        if (this.k == null) {
            if (this.d.position() >= 2) {
                byte b = this.d.get(0);
                boolean z = (b & 128) != 0;
                int i4 = (b & 112) >> 4;
                int i5 = b & 15;
                byte b2 = this.d.get(1);
                boolean z2 = (b2 & 128) != 0;
                int i6 = b2 & Byte.MAX_VALUE;
                if (i4 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i5 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i6 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i5 != 8 && i5 != 9 && i5 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i5);
                    }
                    if (i5 == 8 && i6 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i5 != 0 && i5 != 1 && i5 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i5);
                } else {
                    if (!this.i && i5 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.i && i5 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                int i7 = z2 ? 4 : 0;
                if (i6 < 126) {
                    i2 = i7 + 2;
                } else if (i6 == 126) {
                    i2 = i7 + 4;
                } else if (i6 == 127) {
                    i2 = i7 + 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.d.position() >= i2) {
                    if (i6 == 126) {
                        j = ((this.d.get(2) & 255) << 8) | (this.d.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                        i3 = 4;
                    } else if (i6 == 127) {
                        if ((this.d.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.d.get(2) & 255) << 56) | ((this.d.get(3) & 255) << 48) | ((this.d.get(4) & 255) << 40) | ((this.d.get(5) & 255) << 32) | ((this.d.get(6) & 255) << 24) | ((this.d.get(7) & 255) << 16) | ((this.d.get(8) & 255) << 8) | (this.d.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                        i3 = 10;
                    } else {
                        j = i6;
                    }
                    if (j > this.c.b()) {
                        throw new WebSocketException("frame payload too large");
                    }
                    this.k = new ap();
                    this.k.f533a = i5;
                    this.k.b = z;
                    this.k.c = i4;
                    this.k.e = (int) j;
                    this.k.d = i2;
                    this.k.f = this.k.d + this.k.e;
                    if (z2) {
                        this.k.g = new byte[4];
                        for (int i8 = 0; i8 < 4; i8++) {
                            this.k.g[i3] = (byte) (this.d.get(i3 + i8) & 255);
                        }
                        int i9 = i3 + 4;
                    } else {
                        this.k.g = null;
                    }
                    return this.k.e == 0 || this.d.position() >= this.k.f;
                }
                return false;
            }
            return false;
        } else if (this.d.position() >= this.k.f) {
            byte[] bArr = null;
            int position = this.d.position();
            if (this.k.e > 0) {
                bArr = new byte[this.k.e];
                this.d.position(this.k.d);
                this.d.get(bArr, 0, this.k.e);
            }
            this.d.position(this.k.f);
            this.d.limit(position);
            this.d.compact();
            if (this.k.f533a > 7) {
                if (this.k.f533a == 8) {
                    int i10 = 1005;
                    if (this.k.e >= 2) {
                        i10 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
                        if (i10 < 1000 || ((i10 >= 1000 && i10 <= 2999 && i10 != 1000 && i10 != 1001 && i10 != 1002 && i10 != 1003 && i10 != 1007 && i10 != 1008 && i10 != 1009 && i10 != 1010 && i10 != 1011) || i10 >= 5000)) {
                            throw new WebSocketException("invalid close code " + i10);
                        }
                        if (this.k.e > 2) {
                            byte[] bArr2 = new byte[this.k.e - 2];
                            System.arraycopy(bArr, 2, bArr2, 0, this.k.e - 2);
                            j jVar = new j();
                            jVar.a(bArr2);
                            if (!jVar.b()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                            i = i10;
                            a(i, str);
                        }
                    }
                    str = null;
                    i = i10;
                    a(i, str);
                } else if (this.k.f533a == 9) {
                    a(bArr);
                } else if (this.k.f533a == 10) {
                    b(bArr);
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.i) {
                    this.i = true;
                    this.j = this.k.f533a;
                    if (this.j == 1 && this.c.g()) {
                        this.l.a();
                    }
                }
                if (bArr != null) {
                    if (this.e.size() + bArr.length > this.c.c()) {
                        throw new WebSocketException("message payload too large");
                    }
                    if (this.j == 1 && this.c.g() && !this.l.a(bArr)) {
                        throw new WebSocketException("invalid UTF-8 in text message payload");
                    }
                    this.e.write(bArr);
                }
                if (this.k.b) {
                    if (this.j == 1) {
                        if (this.c.g() && !this.l.b()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.c.a()) {
                            c(this.e.toByteArray());
                        } else {
                            a(new String(this.e.toByteArray(), "UTF-8"));
                        }
                    } else if (this.j == 2) {
                        d(this.e.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.i = false;
                    this.e.reset();
                }
            }
            this.k = null;
            return this.d.position() > 0;
        } else {
            return false;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        a(new aj(z, map));
    }

    protected void a(int i, String str) {
        a(new v(i, str));
    }

    protected void a(byte[] bArr) {
        a(new ac(bArr));
    }

    protected void b(byte[] bArr) {
        a(new ad(bArr));
    }

    protected void a(String str) {
        a(new al(str));
    }

    protected void c(byte[] bArr) {
        a(new af(bArr));
    }

    protected void d(byte[] bArr) {
        a(new t(bArr));
    }

    private boolean e() {
        boolean z;
        boolean z2;
        for (int position = this.d.position() - 4; position >= 0; position--) {
            if (this.d.get(position + 0) == 13 && this.d.get(position + 1) == 10 && this.d.get(position + 2) == 13 && this.d.get(position + 3) == 10) {
                int position2 = this.d.position();
                Map<String, String> map = null;
                if (this.d.get(0) == 72 && this.d.get(1) == 84 && this.d.get(2) == 84 && this.d.get(3) == 80) {
                    Pair<Integer, String> f2 = f();
                    if (((Integer) f2.first).intValue() >= 300) {
                        a(new ai(((Integer) f2.first).intValue(), (String) f2.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.d.position(0);
                        byte[] bArr = new byte[position];
                        this.d.get(bArr);
                        map = e(bArr);
                    }
                } else {
                    z = false;
                }
                this.d.position(position + 4);
                this.d.limit(position2);
                this.d.compact();
                if (!z) {
                    z2 = this.d.position() > 0;
                    this.h = 3;
                } else {
                    this.h = 0;
                    this.g = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                return z2;
            }
        }
        return false;
    }

    private Map<String, String> e(byte[] bArr) {
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (String str2 : split) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                    com.baidu.adp.lib.h.e.b(String.format("'%s'='%s'", split2[0], split2[1]));
                }
            }
        }
        return hashMap;
    }

    private Pair<Integer, String> f() {
        int i = 4;
        while (i < this.d.position() && this.d.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.d.position() && this.d.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.d.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.d.position() && this.d.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.d.position(i6);
        this.d.get(bArr, 0, i8);
        String str = new String(bArr, "UTF-8");
        if (h()) {
            com.baidu.adp.lib.h.e.b(String.format("Status: %d (%s)", Integer.valueOf(i4), str));
        }
        return new Pair<>(Integer.valueOf(i4), str);
    }

    private boolean g() {
        if (this.h == 3 || this.h == 2) {
            return d();
        }
        if (this.h == 1) {
            return e();
        }
        if (this.h == 0) {
        }
        return false;
    }

    public void a() {
        this.g = true;
        try {
            this.b.a();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("error:" + e.getMessage());
        }
        if (h()) {
            com.baidu.adp.lib.h.e.d("quit");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [735=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (h()) {
            com.baidu.adp.lib.h.e.d("running");
        }
        try {
            this.d.clear();
            do {
                try {
                    int a2 = this.b.a(this.d);
                    if (a2 > 0) {
                        synchronized (an.class) {
                            f += a2;
                        }
                    }
                    if (a2 > 0) {
                        do {
                        } while (g());
                    } else if (a2 < 0) {
                        if (h()) {
                            com.baidu.adp.lib.h.e.d("run() : ConnectionLost");
                        }
                        a(new w(new SocketException("len < 0")));
                        this.g = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!((ConnectivityManager) com.baidu.adp.a.b.a().getSystemService("connectivity")).getActiveNetworkInfo().isAvailable()) {
                        this.g = true;
                        a(new w(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.g);
        } catch (WebSocketException e2) {
            if (h()) {
                com.baidu.adp.lib.h.e.d("run() : WebSocketException (" + e2.toString() + ")");
            }
            a(new ae(e2));
        } catch (Exception e3) {
            if (h()) {
                com.baidu.adp.lib.h.e.d("run() : Exception (" + e3.toString() + ")");
                com.baidu.adp.lib.h.e.c("----WebSocketReader.handleMessage error. e:" + e3.getMessage());
            }
            a(new y(e3));
        } catch (SocketException e4) {
            if (h()) {
                com.baidu.adp.lib.h.e.d("run() : SocketException (" + e4.toString() + ")");
            }
            a(new w(e4));
        } finally {
            this.g = true;
        }
        if (h()) {
            com.baidu.adp.lib.h.e.d("quit");
        }
    }

    private boolean h() {
        return com.baidu.adp.a.b.a().b();
    }

    public void b() {
        synchronized (an.class) {
            f = 0L;
        }
    }

    public long c() {
        long j;
        synchronized (an.class) {
            j = f;
        }
        return j;
    }
}
