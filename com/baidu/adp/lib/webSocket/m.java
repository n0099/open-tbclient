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
        public String Ai;
        public String Aj;
        public String mPath = "/";
        public String Ak = null;
        public String[] Al = null;
        public List<BasicNameValuePair> Am = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Ai = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Av;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.Av = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ap;

        public d(SocketException socketException) {
            this.Ap = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Aq;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Aq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Aq;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Aq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException At;

        public l(WebSocketException webSocketException) {
            this.At = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ar;

        public f(Exception exc) {
            this.Ar = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Aw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Aw = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009m extends h {
        public byte[] Ah;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009m(byte[] bArr) {
            this.Ah = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Ah;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.Ah = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c As;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.As = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int An;
        public String Ao;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.An = -1;
            this.Ao = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.An = i;
            this.Ao = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Ah;

        j() {
            this.Ah = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Ah = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] Ah;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.Ah = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.Ah = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Au;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Au = null;
            this.Au = cVar;
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
