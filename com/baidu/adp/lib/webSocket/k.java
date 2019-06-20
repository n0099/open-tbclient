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
        public String FB;
        public String mQuery;
        public String wU = "/";
        public String FC = null;
        public String[] FD = null;
        public List<BasicNameValuePair> FE = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.FB = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean FM;
        public Map<String, String> FN;

        public q(boolean z, Map<String, String> map) {
            this.FM = z;
            this.FN = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException FG;

        public d(SocketException socketException) {
            this.FG = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String FH;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.FH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String FH;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.FH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException FK;

        public l(WebSocketException webSocketException) {
            this.FK = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception FI;

        public f(Exception exc) {
            this.FI = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String FO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.FO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] FA;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.FA = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] FA;
        public long tZ;
        public long ub;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.FA = bArr;
            this.tZ = j;
            this.ub = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c FJ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.FJ = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String FF;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.FF = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.FF = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] FA;

        j() {
            this.FA = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.FA = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] FA;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.FA = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.FA = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c FL;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.FL = null;
            this.FL = cVar;
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
