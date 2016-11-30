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
        public String tQ;
        public String tR;
        public String mPath = "/";
        public String tS = null;
        public String[] tT = null;
        public List<BasicNameValuePair> tU = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.tQ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean uc;
        public Map<String, String> ud;

        public q(boolean z, Map<String, String> map) {
            this.uc = z;
            this.ud = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException tW;

        public d(SocketException socketException) {
            this.tW = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String tX;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.tX = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String tX;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.tX = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException ua;

        public l(WebSocketException webSocketException) {
            this.ua = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception tY;

        public f(Exception exc) {
            this.tY = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String ue;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.ue = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010m extends h {
        public byte[] tP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010m(byte[] bArr) {
            this.tP = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long hs;
        public long ht;
        public byte[] tP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.tP = bArr;
            this.hs = j;
            this.ht = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c tZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.tZ = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String tV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.tV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.tV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] tP;

        j() {
            this.tP = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.tP = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] tP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.tP = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.tP = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c ub;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.ub = null;
            this.ub = cVar;
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
