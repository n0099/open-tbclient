package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ai {
    public static final ByteBuffer c = ByteBuffer.allocate(0);
    public a a;
    public b b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes3.dex */
    public class b extends ci {
        public b(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new cl(), null, i);
            a(socket);
        }

        @Override // com.baidu.mobstat.ci
        public void a(int i, String str, boolean z) {
            if (bc.c().b()) {
                bc c = bc.c();
                c.a("onClose,  reason:" + str + ", remote:" + z);
            }
            bb c2 = bb.c();
            c2.a("autotrace: connect closed, server:" + z + " reason:" + str);
            al a = al.a();
            a.a(5, "remote:" + z + "|reason:" + str);
            if (ai.this.a != null) {
                ai.this.a.a(z);
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(df dfVar) {
            if (bc.c().b()) {
                bc.c().a("onOpen");
            }
            if (ai.this.a != null) {
                ai.this.a.a();
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(Exception exc) {
            if (bc.c().b()) {
                bc.c().a(GameAssistConstKt.TYPE_CALLBACK_ERROR);
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(String str) {
            JSONObject jSONObject;
            if (bc.c().b()) {
                bc.c().a("onMessage: " + str);
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
                    ai.this.a.a(((JSONObject) jSONObject.get("data")).toString());
                    return;
                } catch (Exception unused3) {
                    return;
                }
            }
            int i = -1;
            try {
                i = ((Integer) ((JSONObject) jSONObject.get("data")).get("status")).intValue();
            } catch (Exception unused4) {
            }
            switch (i) {
                case 801020:
                    bb.c().a("autotrace: connect established");
                    al.a().a(2);
                    return;
                case 801021:
                    bb.c().a("autotrace: connect failed, connect has been established");
                    al.a().a(5, "already connect");
                    return;
                case 801022:
                case 801023:
                default:
                    return;
                case 801024:
                    bb.c().a("autotrace: connect confirm");
                    al.a().a(3);
                    if (ai.this.a != null) {
                        ai.this.a.b();
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends IOException {
        public c(Throwable th) {
            super(th.getMessage());
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

    public void a() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d();
        }
    }

    public boolean b() {
        if (!this.b.f() && !this.b.g() && !this.b.e()) {
            return true;
        }
        return false;
    }

    public ai(URI uri, a aVar) throws c {
        this.a = aVar;
        try {
            b bVar = new b(uri, 5000, uri.toString().startsWith("wss://") ? c() : null);
            this.b = bVar;
            bVar.c();
        } catch (InterruptedException e) {
            throw new c(e);
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        if (this.b != null) {
            this.b.a(jSONObject.toString().getBytes());
        }
    }
}
