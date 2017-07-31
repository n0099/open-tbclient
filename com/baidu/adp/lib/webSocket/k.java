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
        public String Ca;
        public String Cb;
        public String mPath = "/";
        public String Cc = null;
        public String[] Cd = null;
        public List<BasicNameValuePair> Ce = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Ca = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Cm;
        public Map<String, String> Cn;

        public q(boolean z, Map<String, String> map) {
            this.Cm = z;
            this.Cn = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Cg;

        public d(SocketException socketException) {
            this.Cg = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ch;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ch = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ch;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ch = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ck;

        public l(WebSocketException webSocketException) {
            this.Ck = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ci;

        public f(Exception exc) {
            this.Ci = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Co;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Co = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] BZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.BZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] BZ;
        public long qr;
        public long qs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.BZ = bArr;
            this.qr = j;
            this.qs = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Cj;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Cj = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Cf;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Cf = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Cf = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] BZ;

        j() {
            this.BZ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.BZ = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009k extends h {
        public byte[] BZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009k() {
            this.BZ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009k(byte[] bArr) {
            this.BZ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Cl;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Cl = null;
            this.Cl = cVar;
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
