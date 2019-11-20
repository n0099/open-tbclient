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
        public String mQuery;
        public String su;
        public String mPath = "/";
        public String sv = null;
        public String[] sw = null;
        public List<BasicNameValuePair> sx = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.su = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean sF;
        public Map<String, String> sG;

        public q(boolean z, Map<String, String> map) {
            this.sF = z;
            this.sG = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException sz;

        public d(SocketException socketException) {
            this.sz = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String sA;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.sA = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String sA;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.sA = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException sD;

        public l(WebSocketException webSocketException) {
            this.sD = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception sB;

        public f(Exception exc) {
            this.sB = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String sH;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.sH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] ss;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.ss = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long allDataReadTime;
        public long firstByteReachTime;
        public byte[] ss;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.ss = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c sC;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.sC = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String sy;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.sy = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.sy = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] ss;

        j() {
            this.ss = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.ss = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] ss;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.ss = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.ss = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c sE;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.sE = null;
            this.sE = cVar;
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
