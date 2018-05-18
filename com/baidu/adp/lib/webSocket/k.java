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
        public String yE;
        public String yF;
        public String mPath = "/";
        public String yG = null;
        public String[] yH = null;
        public List<BasicNameValuePair> yI = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.yE = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean yQ;
        public Map<String, String> yR;

        public q(boolean z, Map<String, String> map) {
            this.yQ = z;
            this.yR = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException yK;

        public d(SocketException socketException) {
            this.yK = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String yL;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.yL = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String yL;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.yL = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException yO;

        public l(WebSocketException webSocketException) {
            this.yO = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception yM;

        public f(Exception exc) {
            this.yM = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String yS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.yS = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] yD;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.yD = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long mW;
        public long mZ;
        public byte[] yD;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.yD = bArr;
            this.mW = j;
            this.mZ = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c yN;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.yN = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String yJ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.yJ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.yJ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] yD;

        j() {
            this.yD = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.yD = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010k extends h {
        public byte[] yD;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010k() {
            this.yD = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010k(byte[] bArr) {
            this.yD = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c yP;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.yP = null;
            this.yP = cVar;
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
