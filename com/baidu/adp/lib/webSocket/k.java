package com.baidu.adp.lib.webSocket;

import java.net.SocketException;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class k {

    /* loaded from: classes.dex */
    public static class h {
    }

    /* loaded from: classes.dex */
    public static class b extends h {
        public String Cc;
        public String Cd;
        public String mPath = "/";
        public String Ce = null;
        public String[] Cf = null;
        public List<BasicNameValuePair> Cg = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Cc = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Co;
        public Map<String, String> Cp;

        public q(boolean z, Map<String, String> map) {
            this.Co = z;
            this.Cp = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ci;

        public d(SocketException socketException) {
            this.Ci = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Cj;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Cj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Cj;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Cj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Cm;

        public l(WebSocketException webSocketException) {
            this.Cm = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ck;

        public f(Exception exc) {
            this.Ck = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Cq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Cq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] Cb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.Cb = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Cb;
        public long qu;
        public long qv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Cb = bArr;
            this.qu = j;
            this.qv = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Cl;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Cl = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Ch;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Ch = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Ch = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Cb;

        j() {
            this.Cb = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Cb = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008k extends h {
        public byte[] Cb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k() {
            this.Cb = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k(byte[] bArr) {
            this.Cb = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Cn;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Cn = null;
            this.Cn = cVar;
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
