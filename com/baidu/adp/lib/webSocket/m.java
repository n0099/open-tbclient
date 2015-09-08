package com.baidu.adp.lib.webSocket;

import java.net.SocketException;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {

    /* loaded from: classes.dex */
    public static class h {
    }

    /* loaded from: classes.dex */
    public static class b extends h {
        public String zY;
        public String zZ;
        public String mPath = "/";
        public String Aa = null;
        public String[] Ab = null;
        public List<BasicNameValuePair> Ac = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zY = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Am;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.Am = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ag;

        public d(SocketException socketException) {
            this.Ag = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ah;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ah = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ah;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ah = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ak;

        public l(WebSocketException webSocketException) {
            this.Ak = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ai;

        public f(Exception exc) {
            this.Ai = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String An;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.An = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Aj;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Aj = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int Ae;
        public String Af;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.Ae = -1;
            this.Af = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.Ae = i;
            this.Af = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zX;

        j() {
            this.zX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.zX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Al;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Al = null;
            this.Al = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class r extends o {
        public r(com.baidu.adp.lib.webSocket.c cVar) {
            super(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static class g extends o {
        public g(com.baidu.adp.lib.webSocket.c cVar) {
            super(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static class n extends o {
        public n(com.baidu.adp.lib.webSocket.c cVar) {
            super(cVar);
        }
    }
}
