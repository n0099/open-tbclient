package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class aq {
    private static final ByteBuffer c = ByteBuffer.allocate(0);
    private a a;
    private b b;

    /* loaded from: classes3.dex */
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

    public aq(URI uri, a aVar) throws c {
        this.a = aVar;
        try {
            this.b = new b(uri, UIMsg.m_AppUI.MSG_APP_GPS, uri.toString().startsWith("wss://") ? c() : null);
            this.b.c();
        } catch (InterruptedException e) {
            throw new c(e);
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.d();
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        if (this.b != null) {
            this.b.a(jSONObject.toString().getBytes());
        }
    }

    public boolean b() {
        return (this.b.f() || this.b.g() || this.b.e()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends ci {
        public b(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new cl(), null, i);
            a(socket);
        }

        @Override // com.baidu.mobstat.ci
        public void a(df dfVar) {
            if (bk.c().b()) {
                bk.c().a(WebSocketAction.PARAM_KEY_ONOPEN);
            }
            if (aq.this.a != null) {
                aq.this.a.a();
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(String str) {
            JSONObject jSONObject;
            int i;
            String str2 = null;
            if (bk.c().b()) {
                bk.c().a("onMessage: " + str);
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
                                aq.this.a.a(((JSONObject) jSONObject.get("data")).toString());
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
                                bj.c().a("autotrace: connect established");
                                at.a().a(2);
                                return;
                            case 801021:
                                bj.c().a("autotrace: connect failed, connect has been established");
                                at.a().a(5, "already connect");
                                return;
                            case 801022:
                            case 801023:
                            default:
                                return;
                            case 801024:
                                bj.c().a("autotrace: connect confirm");
                                at.a().a(3);
                                if (aq.this.a != null) {
                                    aq.this.a.b();
                                    return;
                                }
                                return;
                        }
                    }
                }
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(int i, String str, boolean z) {
            if (bk.c().b()) {
                bk.c().a("onClose,  reason:" + str + ", remote:" + z);
            }
            bj.c().a("autotrace: connect closed, server:" + z + " reason:" + str);
            at.a().a(5, "remote:" + z + "|reason:" + str);
            if (aq.this.a != null) {
                aq.this.a.a(z);
            }
        }

        @Override // com.baidu.mobstat.ci
        public void a(Exception exc) {
            if (bk.c().b()) {
                bk.c().a("onError");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends IOException {
        public c(Throwable th) {
            super(th.getMessage());
        }
    }
}
