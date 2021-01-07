package com.baidu.mobstat;

import android.text.TextUtils;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class aj {
    private static final ByteBuffer c = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    private a f3693a;

    /* renamed from: b  reason: collision with root package name */
    private b f3694b;

    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    private Socket c() {
        SSLSocketFactory sSLSocketFactory;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (Exception e) {
            sSLSocketFactory = null;
        }
        if (sSLSocketFactory == null) {
            return null;
        }
        try {
            return sSLSocketFactory.createSocket();
        } catch (Exception e2) {
            return null;
        }
    }

    public aj(URI uri, a aVar) throws c {
        this.f3693a = aVar;
        try {
            this.f3694b = new b(uri, 5000, uri.toString().startsWith("wss://") ? c() : null);
            this.f3694b.c();
        } catch (InterruptedException e) {
            throw new c(e);
        }
    }

    public void a() {
        if (this.f3694b != null) {
            this.f3694b.d();
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        if (this.f3694b != null) {
            this.f3694b.a(jSONObject.toString().getBytes());
        }
    }

    public boolean b() {
        return (this.f3694b.f() || this.f3694b.g() || this.f3694b.e()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b extends cc {
        public b(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new cf(), null, i);
            a(socket);
        }

        @Override // com.baidu.mobstat.cc
        public void a(cz czVar) {
            if (bd.c().b()) {
                bd.c().a("onOpen");
            }
            if (aj.this.f3693a != null) {
                aj.this.f3693a.a();
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(String str) {
            JSONObject jSONObject;
            int i;
            String str2 = null;
            if (bd.c().b()) {
                bd.c().a("onMessage: " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception e) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        str2 = jSONObject.getString("type");
                    } catch (Exception e2) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.equals("deploy")) {
                            try {
                                aj.this.f3693a.a(((JSONObject) jSONObject.get("data")).toString());
                                return;
                            } catch (Exception e3) {
                                return;
                            }
                        }
                        try {
                            i = ((Integer) ((JSONObject) jSONObject.get("data")).get("status")).intValue();
                        } catch (Exception e4) {
                            i = -1;
                        }
                        switch (i) {
                            case 801020:
                                bc.c().a("autotrace: connect established");
                                am.a().a(2);
                                return;
                            case 801021:
                                bc.c().a("autotrace: connect failed, connect has been established");
                                am.a().a(5, "already connect");
                                return;
                            case 801022:
                            case 801023:
                            default:
                                return;
                            case 801024:
                                bc.c().a("autotrace: connect confirm");
                                am.a().a(3);
                                if (aj.this.f3693a != null) {
                                    aj.this.f3693a.b();
                                    return;
                                }
                                return;
                        }
                    }
                }
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(int i, String str, boolean z) {
            if (bd.c().b()) {
                bd.c().a("onClose,  reason:" + str + ", remote:" + z);
            }
            bc.c().a("autotrace: connect closed, server:" + z + " reason:" + str);
            am.a().a(5, "remote:" + z + "|reason:" + str);
            if (aj.this.f3693a != null) {
                aj.this.f3693a.a(z);
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(Exception exc) {
            if (bd.c().b()) {
                bd.c().a("onError");
            }
        }
    }

    /* loaded from: classes15.dex */
    public class c extends IOException {
        public c(Throwable th) {
            super(th.getMessage());
        }
    }
}
