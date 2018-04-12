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
        public String yF;
        public String yG;
        public String mPath = "/";
        public String yH = null;
        public String[] yI = null;
        public List<BasicNameValuePair> yJ = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.yF = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean yR;
        public Map<String, String> yS;

        public q(boolean z, Map<String, String> map) {
            this.yR = z;
            this.yS = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException yL;

        public d(SocketException socketException) {
            this.yL = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String yM;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.yM = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String yM;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.yM = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException yP;

        public l(WebSocketException webSocketException) {
            this.yP = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception yN;

        public f(Exception exc) {
            this.yN = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String yT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.yT = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] yE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.yE = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long mW;
        public long mZ;
        public byte[] yE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.yE = bArr;
            this.mW = j;
            this.mZ = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c yO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.yO = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String yK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.yK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.yK = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] yE;

        j() {
            this.yE = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.yE = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010k extends h {
        public byte[] yE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010k() {
            this.yE = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010k(byte[] bArr) {
            this.yE = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c yQ;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.yQ = null;
            this.yQ = cVar;
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
