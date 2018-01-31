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
        public String aoj;
        public String aok;
        public String mPath = "/";
        public String aol = null;
        public String[] aom = null;
        public List<BasicNameValuePair> aon = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.aoj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean aov;
        public Map<String, String> aow;

        public q(boolean z, Map<String, String> map) {
            this.aov = z;
            this.aow = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException aop;

        public d(SocketException socketException) {
            this.aop = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String aoq;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.aoq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String aoq;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.aoq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException aot;

        public l(WebSocketException webSocketException) {
            this.aot = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception aor;

        public f(Exception exc) {
            this.aor = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String aox;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.aox = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] aoi;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.aoi = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long acN;
        public long acO;
        public byte[] aoi;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.aoi = bArr;
            this.acN = j;
            this.acO = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c aos;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.aos = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String aoo;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.aoo = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.aoo = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] aoi;

        j() {
            this.aoi = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.aoi = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] aoi;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.aoi = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.aoi = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c aou;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.aou = null;
            this.aou = cVar;
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
