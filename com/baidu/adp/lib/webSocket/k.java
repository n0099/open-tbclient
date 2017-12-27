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
        public String aoh;
        public String aoi;
        public String mPath = "/";
        public String aoj = null;
        public String[] aok = null;
        public List<BasicNameValuePair> aol = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.aoh = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean aot;
        public Map<String, String> aou;

        public q(boolean z, Map<String, String> map) {
            this.aot = z;
            this.aou = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException aon;

        public d(SocketException socketException) {
            this.aon = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String aoo;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.aoo = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String aoo;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.aoo = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException aor;

        public l(WebSocketException webSocketException) {
            this.aor = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception aop;

        public f(Exception exc) {
            this.aop = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String aov;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.aov = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] aog;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.aog = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long acN;
        public long acO;
        public byte[] aog;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.aog = bArr;
            this.acN = j;
            this.acO = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c aoq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.aoq = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String aom;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.aom = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.aom = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] aog;

        j() {
            this.aog = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.aog = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] aog;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.aog = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.aog = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c aos;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.aos = null;
            this.aos = cVar;
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
