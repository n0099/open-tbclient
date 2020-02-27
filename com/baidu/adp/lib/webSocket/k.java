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
        public String mHost;
        public String mQuery;
        public String mPath = "/";
        public String mOrigin = null;
        public String[] vF = null;
        public List<BasicNameValuePair> vG = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public Map<String, String> mHeaders;
        public boolean mSuccess;

        public q(boolean z, Map<String, String> map) {
            this.mSuccess = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException vH;

        public d(SocketException socketException) {
            this.vH = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String vI;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.vI = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String vI;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.vI = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException vL;

        public l(WebSocketException webSocketException) {
            this.vL = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception vJ;

        public f(Exception exc) {
            this.vJ = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String vN;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.vN = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] vE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.vE = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long allDataReadTime;
        public long firstByteReachTime;
        public byte[] vE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.vE = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c vK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.vK = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String mReason;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.mReason = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.mReason = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] vE;

        j() {
            this.vE = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.vE = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] vE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.vE = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.vE = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c vM;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.vM = null;
            this.vM = cVar;
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
