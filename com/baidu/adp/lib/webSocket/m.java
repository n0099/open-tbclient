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
        public String Aq;
        public String Ar;
        public String mPath = "/";
        public String As = null;
        public String[] At = null;
        public List<BasicNameValuePair> Au = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Aq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean AD;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.AD = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ax;

        public d(SocketException socketException) {
            this.Ax = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ay;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ay = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ay;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ay = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException AB;

        public l(WebSocketException webSocketException) {
            this.AB = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Az;

        public f(Exception exc) {
            this.Az = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String AE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.AE = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009m extends h {
        public byte[] Ap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009m(byte[] bArr) {
            this.Ap = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Ap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.Ap = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c AA;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.AA = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int Av;
        public String Aw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.Av = -1;
            this.Aw = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.Av = i;
            this.Aw = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Ap;

        j() {
            this.Ap = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Ap = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] Ap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.Ap = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.Ap = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c AC;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.AC = null;
            this.AC = cVar;
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
