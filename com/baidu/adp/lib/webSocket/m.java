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
        public String tH;
        public String tI;
        public String mPath = "/";
        public String tJ = null;
        public String[] tK = null;
        public List<BasicNameValuePair> tL = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.tH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean tT;
        public Map<String, String> tU;

        public q(boolean z, Map<String, String> map) {
            this.tT = z;
            this.tU = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException tN;

        public d(SocketException socketException) {
            this.tN = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String tO;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.tO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String tO;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.tO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException tR;

        public l(WebSocketException webSocketException) {
            this.tR = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception tP;

        public f(Exception exc) {
            this.tP = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String tV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.tV = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009m extends h {
        public byte[] tG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0009m(byte[] bArr) {
            this.tG = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long hp;
        public long hq;
        public byte[] tG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.tG = bArr;
            this.hp = j;
            this.hq = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c tQ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.tQ = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String tM;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.tM = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.tM = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] tG;

        j() {
            this.tG = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.tG = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] tG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.tG = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.tG = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c tS;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.tS = null;
            this.tS = cVar;
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
