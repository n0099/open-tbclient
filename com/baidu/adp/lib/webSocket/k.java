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
        public String[] QG = null;
        public List<BasicNameValuePair> QH = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean QO;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.QO = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException QI;

        public d(SocketException socketException) {
            this.QI = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String QJ;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.QJ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String QJ;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.QJ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException QM;

        public l(WebSocketException webSocketException) {
            this.QM = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception QK;

        public f(Exception exc) {
            this.QK = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String QP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.QP = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] QF;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.QF = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] QF;
        public long allDataReadTime;
        public long firstByteReachTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.QF = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c QL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.QL = cVar;
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
        public byte[] QF;

        j() {
            this.QF = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.QF = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024k extends h {
        public byte[] QF;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0024k() {
            this.QF = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0024k(byte[] bArr) {
            this.QF = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c QN;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.QN = null;
            this.QN = cVar;
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
