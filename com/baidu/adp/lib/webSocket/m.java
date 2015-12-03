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
        public String Ag;
        public String Ah;
        public String mPath = "/";
        public String Ai = null;
        public String[] Aj = null;
        public List<BasicNameValuePair> Ak = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Ag = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean At;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.At = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException An;

        public d(SocketException socketException) {
            this.An = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ao;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ao = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ao;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ao = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ar;

        public l(WebSocketException webSocketException) {
            this.Ar = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ap;

        public f(Exception exc) {
            this.Ap = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Au;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Au = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] Af;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.Af = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Af;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.Af = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Aq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Aq = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int Al;
        public String Am;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.Al = -1;
            this.Am = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.Al = i;
            this.Am = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Af;

        j() {
            this.Af = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Af = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] Af;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.Af = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.Af = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c As;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.As = null;
            this.As = cVar;
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
