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
        public String aoi;
        public String aoj;
        public String mPath = "/";
        public String aok = null;
        public String[] aol = null;
        public List<BasicNameValuePair> aom = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.aoi = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean aou;
        public Map<String, String> aov;

        public q(boolean z, Map<String, String> map) {
            this.aou = z;
            this.aov = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException aoo;

        public d(SocketException socketException) {
            this.aoo = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String aop;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.aop = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String aop;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.aop = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException aos;

        public l(WebSocketException webSocketException) {
            this.aos = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception aoq;

        public f(Exception exc) {
            this.aoq = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String aow;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.aow = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] aoh;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.aoh = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long acL;
        public long acM;
        public byte[] aoh;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.aoh = bArr;
            this.acL = j;
            this.acM = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c aor;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.aor = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String aon;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.aon = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.aon = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] aoh;

        j() {
            this.aoh = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.aoh = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] aoh;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.aoh = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.aoh = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c aot;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.aot = null;
            this.aot = cVar;
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
