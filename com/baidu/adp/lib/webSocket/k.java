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
        public String FI;
        public String mQuery;
        public String wX = "/";
        public String FJ = null;
        public String[] FK = null;
        public List<BasicNameValuePair> FL = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.FI = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean FU;
        public Map<String, String> FV;

        public q(boolean z, Map<String, String> map) {
            this.FU = z;
            this.FV = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException FN;

        public d(SocketException socketException) {
            this.FN = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String FO;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.FO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String FO;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.FO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException FR;

        public l(WebSocketException webSocketException) {
            this.FR = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception FP;

        public f(Exception exc) {
            this.FP = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String FW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.FW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] FH;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.FH = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] FH;
        public long ud;
        public long ue;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.FH = bArr;
            this.ud = j;
            this.ue = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c FQ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.FQ = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String FM;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.FM = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.FM = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] FH;

        j() {
            this.FH = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.FH = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] FH;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.FH = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.FH = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c FT;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.FT = null;
            this.FT = cVar;
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
