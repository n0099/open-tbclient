package com.baidu.android.nebula.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class h {
    protected final String a;
    protected final int b;
    private ServerSocket c;
    private Set d = new HashSet();
    private Thread e;
    private g f;
    private b g;

    public h(String str, int i) {
        this.a = str;
        this.b = i;
        a(new q(this, null));
        a(new v());
    }

    private static final void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public c a(f fVar) {
        HashMap hashMap = new HashMap();
        k e = fVar.e();
        if (k.PUT.equals(e) || k.POST.equals(e)) {
            try {
                fVar.a(hashMap);
            } catch (o e2) {
                return new c(e2.a(), "text/plain", e2.getMessage());
            } catch (IOException e3) {
                return new c(u.INTERNAL_ERROR, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e3.getMessage());
            }
        }
        Map a = fVar.a();
        a.put("NanoHttpd.QUERY_STRING", fVar.d());
        return a(fVar.c(), e, fVar.b(), a, hashMap);
    }

    @Deprecated
    public c a(String str, k kVar, Map map, Map map2, Map map3) {
        return new c(u.NOT_FOUND, "text/plain", "Not Found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        try {
            return URLDecoder.decode(str, "utf8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public void a() {
        this.c = new ServerSocket();
        this.c.bind(this.a != null ? new InetSocketAddress(this.a, this.b) : new InetSocketAddress(this.b));
        this.e = new Thread(new i(this));
        this.e.setDaemon(true);
        this.e.setName("NanoHttpd Main Listener");
        this.e.start();
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public synchronized void a(Socket socket) {
        this.d.add(socket);
    }

    public void b() {
        try {
            a(this.c);
            c();
            this.e.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(Socket socket) {
        this.d.remove(socket);
    }

    public synchronized void c() {
        for (Socket socket : this.d) {
            d(socket);
        }
    }

    public final boolean d() {
        return (this.c == null || this.e == null) ? false : true;
    }

    public final boolean e() {
        return d() && !this.c.isClosed() && this.e.isAlive();
    }
}
