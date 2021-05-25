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
/* loaded from: classes2.dex */
public class aj {

    /* renamed from: c  reason: collision with root package name */
    public static final ByteBuffer f8489c = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    public a f8490a;

    /* renamed from: b  reason: collision with root package name */
    public b f8491b;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes2.dex */
    public class c extends IOException {
        public c(Throwable th) {
            super(th.getMessage());
        }
    }

    public aj(URI uri, a aVar) throws c {
        this.f8490a = aVar;
        try {
            b bVar = new b(uri, 5000, uri.toString().startsWith("wss://") ? c() : null);
            this.f8491b = bVar;
            bVar.c();
        } catch (InterruptedException e2) {
            throw new c(e2);
        }
    }

    private Socket c() {
        SSLSocketFactory sSLSocketFactory;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        } catch (Exception unused) {
            sSLSocketFactory = null;
        }
        if (sSLSocketFactory == null) {
            return null;
        }
        try {
            return sSLSocketFactory.createSocket();
        } catch (Exception unused2) {
            return null;
        }
    }

    public boolean b() {
        return (this.f8491b.f() || this.f8491b.g() || this.f8491b.e()) ? false : true;
    }

    public void a() {
        b bVar = this.f8491b;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends cc {
        public b(URI uri, int i2, Socket socket) throws InterruptedException {
            super(uri, new cf(), null, i2);
            a(socket);
        }

        @Override // com.baidu.mobstat.cc
        public void a(cz czVar) {
            if (bd.c().b()) {
                bd.c().a("onOpen");
            }
            if (aj.this.f8490a != null) {
                aj.this.f8490a.a();
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(String str) {
            JSONObject jSONObject;
            if (bd.c().b()) {
                bd.c().a("onMessage: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            try {
                str2 = jSONObject.getString("type");
            } catch (Exception unused2) {
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (str2.equals("deploy")) {
                try {
                    aj.this.f8490a.a(((JSONObject) jSONObject.get("data")).toString());
                    return;
                } catch (Exception unused3) {
                    return;
                }
            }
            int i2 = -1;
            try {
                i2 = ((Integer) ((JSONObject) jSONObject.get("data")).get("status")).intValue();
            } catch (Exception unused4) {
            }
            switch (i2) {
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
                    if (aj.this.f8490a != null) {
                        aj.this.f8490a.b();
                        return;
                    }
                    return;
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(int i2, String str, boolean z) {
            if (bd.c().b()) {
                bd c2 = bd.c();
                c2.a("onClose,  reason:" + str + ", remote:" + z);
            }
            bc c3 = bc.c();
            c3.a("autotrace: connect closed, server:" + z + " reason:" + str);
            am a2 = am.a();
            a2.a(5, "remote:" + z + "|reason:" + str);
            if (aj.this.f8490a != null) {
                aj.this.f8490a.a(z);
            }
        }

        @Override // com.baidu.mobstat.cc
        public void a(Exception exc) {
            if (bd.c().b()) {
                bd.c().a("onError");
            }
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        if (this.f8491b != null) {
            this.f8491b.a(jSONObject.toString().getBytes());
        }
    }
}
