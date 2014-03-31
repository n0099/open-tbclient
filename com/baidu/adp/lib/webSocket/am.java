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
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class am extends Thread {
    private static long f = 0;
    private final Handler a;
    private final g b;
    private final al c;
    private final ByteBuffer d;
    private final e e;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private an k;
    private final i l;

    public am(Handler handler, g gVar, al alVar, String str) {
        super(str);
        this.g = false;
        this.i = false;
        this.l = new i();
        this.a = handler;
        this.b = gVar;
        this.c = alVar;
        this.d = ByteBuffer.allocateDirect(alVar.b() + 14);
        this.e = new e(alVar.c());
        this.k = null;
        this.h = 1;
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("created");
        }
    }

    private void a(Object obj) {
        Message obtainMessage = this.a.obtainMessage();
        obtainMessage.obj = obj;
        this.a.sendMessage(obtainMessage);
    }

    private boolean d() {
        boolean z;
        Map<String, String> map;
        boolean z2;
        for (int position = this.d.position() - 4; position >= 0; position--) {
            if (this.d.get(position + 0) == 13 && this.d.get(position + 1) == 10 && this.d.get(position + 2) == 13 && this.d.get(position + 3) == 10) {
                int position2 = this.d.position();
                if (this.d.get(0) != 72 || this.d.get(1) != 84 || this.d.get(2) != 84 || this.d.get(3) != 80) {
                    z = false;
                    map = null;
                } else {
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
                    if (com.baidu.adp.a.b.a().d()) {
                        com.baidu.adp.lib.util.f.c(String.format("Status: %d (%s)", Integer.valueOf(i4), str));
                    }
                    Pair pair = new Pair(Integer.valueOf(i4), str);
                    if (((Integer) pair.first).intValue() >= 300) {
                        a(new ah(((Integer) pair.first).intValue(), (String) pair.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position <= 0) {
                        map = null;
                    } else {
                        this.d.position(0);
                        byte[] bArr2 = new byte[position];
                        this.d.get(bArr2);
                        map = a(bArr2);
                    }
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
                a(new ai(z ? false : true, map));
                return z2;
            }
        }
        return false;
    }

    private static Map<String, String> a(byte[] bArr) {
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split(IOUtils.LINE_SEPARATOR_WINDOWS);
        for (String str2 : split) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                    com.baidu.adp.lib.util.f.c(String.format("'%s'='%s'", split2[0], split2[1]));
                }
            }
        }
        return hashMap;
    }

    public final void a() {
        this.g = true;
        try {
            this.b.a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("error:" + e.getMessage());
        }
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("quit");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [734=6, 696=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        boolean z;
        int i;
        String str;
        int i2;
        long j;
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("running");
        }
        try {
            this.d.clear();
            do {
                try {
                    int a = this.b.a(this.d);
                    if (a > 0) {
                        synchronized (am.class) {
                            f += a;
                        }
                    }
                    if (a > 0) {
                        do {
                            if (this.h == 3 || this.h == 2) {
                                if (this.k != null) {
                                    if (this.d.position() >= this.k.f) {
                                        int position = this.d.position();
                                        if (this.k.e > 0) {
                                            byte[] bArr2 = new byte[this.k.e];
                                            this.d.position(this.k.d);
                                            this.d.get(bArr2, 0, this.k.e);
                                            bArr = bArr2;
                                        } else {
                                            bArr = null;
                                        }
                                        this.d.position(this.k.f);
                                        this.d.limit(position);
                                        this.d.compact();
                                        if (this.k.a <= 7) {
                                            if (!this.i) {
                                                this.i = true;
                                                this.j = this.k.a;
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
                                                        a(new ae(this.e.toByteArray()));
                                                    } else {
                                                        a(new ak(new String(this.e.toByteArray(), "UTF-8")));
                                                    }
                                                } else if (this.j != 2) {
                                                    throw new Exception("BdLogic error");
                                                } else {
                                                    a(new s(this.e.toByteArray()));
                                                }
                                                this.i = false;
                                                this.e.reset();
                                            }
                                        } else if (this.k.a == 8) {
                                            if (this.k.e >= 2) {
                                                i = (bArr[1] & 255) + ((bArr[0] & 255) * 256);
                                                if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                                                    throw new WebSocketException("invalid close code " + i);
                                                }
                                                if (this.k.e > 2) {
                                                    byte[] bArr3 = new byte[this.k.e - 2];
                                                    System.arraycopy(bArr, 2, bArr3, 0, this.k.e - 2);
                                                    i iVar = new i();
                                                    iVar.a(bArr3);
                                                    if (!iVar.b()) {
                                                        throw new WebSocketException("invalid close reasons (not UTF-8)");
                                                    }
                                                    str = new String(bArr3, "UTF-8");
                                                } else {
                                                    str = null;
                                                }
                                            } else {
                                                i = 1005;
                                                str = null;
                                            }
                                            a(new u(i, str));
                                        } else if (this.k.a == 9) {
                                            a(new ab(bArr));
                                        } else if (this.k.a != 10) {
                                            throw new Exception("BdLogic error");
                                        } else {
                                            a(new ac(bArr));
                                        }
                                        this.k = null;
                                        if (this.d.position() > 0) {
                                            z = true;
                                            continue;
                                        } else {
                                            z = false;
                                            continue;
                                        }
                                    }
                                    z = false;
                                    continue;
                                } else if (this.d.position() >= 2) {
                                    byte b = this.d.get(0);
                                    boolean z2 = (b & 128) != 0;
                                    int i3 = (b & 112) >> 4;
                                    int i4 = b & 15;
                                    byte b2 = this.d.get(1);
                                    boolean z3 = (b2 & 128) != 0;
                                    int i5 = b2 & Byte.MAX_VALUE;
                                    if (i3 != 0) {
                                        throw new WebSocketException("RSV != 0 and no extension negotiated");
                                    }
                                    if (z3) {
                                        throw new WebSocketException("masked server frame");
                                    }
                                    if (i4 > 7) {
                                        if (!z2) {
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
                                        if (!this.i && i4 == 0) {
                                            throw new WebSocketException("received continuation data frame outside fragmented message");
                                        }
                                        if (this.i && i4 != 0) {
                                            throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                                        }
                                    }
                                    if (i5 < 126) {
                                        i2 = 2;
                                    } else if (i5 == 126) {
                                        i2 = 4;
                                    } else if (i5 != 127) {
                                        throw new Exception("BdLogic error");
                                    } else {
                                        i2 = 10;
                                    }
                                    if (this.d.position() >= i2) {
                                        if (i5 == 126) {
                                            j = ((this.d.get(2) & 255) << 8) | (this.d.get(3) & 255);
                                            if (j < 126) {
                                                throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                            }
                                        } else if (i5 != 127) {
                                            j = i5;
                                        } else if ((this.d.get(2) & 128) != 0) {
                                            throw new WebSocketException("invalid data frame length (> 2^63)");
                                        } else {
                                            j = ((this.d.get(2) & 255) << 56) | ((this.d.get(3) & 255) << 48) | ((this.d.get(4) & 255) << 40) | ((this.d.get(5) & 255) << 32) | ((this.d.get(6) & 255) << 24) | ((this.d.get(7) & 255) << 16) | ((this.d.get(8) & 255) << 8) | (this.d.get(9) & 255);
                                            if (j < 65536) {
                                                throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                            }
                                        }
                                        if (j > this.c.b()) {
                                            throw new WebSocketException("frame payload too large");
                                        }
                                        this.k = new an((byte) 0);
                                        this.k.a = i4;
                                        this.k.b = z2;
                                        this.k.c = i3;
                                        this.k.e = (int) j;
                                        this.k.d = i2;
                                        this.k.f = this.k.d + this.k.e;
                                        this.k.g = null;
                                        if (this.k.e == 0 || this.d.position() >= this.k.f) {
                                            z = true;
                                            continue;
                                        }
                                        z = false;
                                        continue;
                                    } else {
                                        z = false;
                                        continue;
                                    }
                                } else {
                                    z = false;
                                    continue;
                                }
                            } else if (this.h == 1) {
                                z = d();
                                continue;
                            } else {
                                int i6 = this.h;
                                z = false;
                                continue;
                            }
                        } while (z);
                    } else if (a < 0) {
                        if (com.baidu.adp.a.b.a().d()) {
                            com.baidu.adp.lib.util.f.e("run() : ConnectionLost");
                        }
                        a(new v(new SocketException("len < 0")));
                        this.g = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!((ConnectivityManager) com.baidu.adp.a.b.a().b().getSystemService("connectivity")).getActiveNetworkInfo().isAvailable()) {
                        this.g = true;
                        a(new v(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.g);
        } catch (WebSocketException e2) {
            if (com.baidu.adp.a.b.a().d()) {
                com.baidu.adp.lib.util.f.e("run() : WebSocketException (" + e2.toString() + ")");
            }
            a(new ad(e2));
        } catch (Exception e3) {
            if (com.baidu.adp.a.b.a().d()) {
                com.baidu.adp.lib.util.f.e("run() : Exception (" + e3.toString() + ")");
                com.baidu.adp.lib.util.f.d("----WebSocketReader.handleMessage error. e:" + e3.getMessage());
            }
            a(new x(e3));
        } catch (SocketException e4) {
            if (com.baidu.adp.a.b.a().d()) {
                com.baidu.adp.lib.util.f.e("run() : SocketException (" + e4.toString() + ")");
            }
            a(new v(e4));
        } finally {
            this.g = true;
        }
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("quit");
        }
    }

    public static void b() {
        synchronized (am.class) {
            f = 0L;
        }
    }

    public static long c() {
        long j;
        synchronized (am.class) {
            j = f;
        }
        return j;
    }
}
