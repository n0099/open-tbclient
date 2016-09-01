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
        public String tP;
        public String tQ;
        public String mPath = "/";
        public String tR = null;
        public String[] tS = null;
        public List<BasicNameValuePair> tT = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.tP = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean ub;
        public Map<String, String> uc;

        public q(boolean z, Map<String, String> map) {
            this.ub = z;
            this.uc = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException tV;

        public d(SocketException socketException) {
            this.tV = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String tW;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.tW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String tW;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.tW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException tZ;

        public l(WebSocketException webSocketException) {
            this.tZ = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception tX;

        public f(Exception exc) {
            this.tX = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String ud;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.ud = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010m extends h {
        public byte[] tO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010m(byte[] bArr) {
            this.tO = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long hr;
        public long hs;
        public byte[] tO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.tO = bArr;
            this.hr = j;
            this.hs = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c tY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.tY = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String tU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.tU = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.tU = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] tO;

        j() {
            this.tO = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.tO = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] tO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.tO = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.tO = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c ua;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.ua = null;
            this.ua = cVar;
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
