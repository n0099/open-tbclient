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
        public String Aa;
        public String Ab;
        public String mPath = "/";
        public String Ac = null;
        public String[] Ae = null;
        public List<BasicNameValuePair> Af = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Aa = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Ao;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.Ao = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ai;

        public d(SocketException socketException) {
            this.Ai = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Aj;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Aj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Aj;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Aj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Am;

        public l(WebSocketException webSocketException) {
            this.Am = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ak;

        public f(Exception exc) {
            this.Ak = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Ap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Ap = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] zZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.zZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] zZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.zZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Al;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Al = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int Ag;
        public String Ah;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.Ag = -1;
            this.Ah = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.Ag = i;
            this.Ah = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zZ;

        j() {
            this.zZ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] zZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.zZ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.zZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c An;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.An = null;
            this.An = cVar;
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
