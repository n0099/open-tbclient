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
        public String aog;
        public String aoh;
        public String mPath = "/";
        public String aoi = null;
        public String[] aoj = null;
        public List<BasicNameValuePair> aok = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.aog = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean aos;
        public Map<String, String> aot;

        public q(boolean z, Map<String, String> map) {
            this.aos = z;
            this.aot = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException aom;

        public d(SocketException socketException) {
            this.aom = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String aon;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.aon = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String aon;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.aon = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException aoq;

        public l(WebSocketException webSocketException) {
            this.aoq = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception aoo;

        public f(Exception exc) {
            this.aoo = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String aou;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.aou = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] aof;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.aof = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long acN;
        public long acO;
        public byte[] aof;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.aof = bArr;
            this.acN = j;
            this.acO = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c aop;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.aop = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String aol;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.aol = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.aol = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] aof;

        j() {
            this.aof = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.aof = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] aof;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.aof = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.aof = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c aor;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.aor = null;
            this.aor = cVar;
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
