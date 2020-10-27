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
        public String[] QH = null;
        public List<BasicNameValuePair> QI = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean QP;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.QP = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException QJ;

        public d(SocketException socketException) {
            this.QJ = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String QK;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.QK = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String QK;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.QK = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException QN;

        public l(WebSocketException webSocketException) {
            this.QN = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception QL;

        public f(Exception exc) {
            this.QL = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String QR;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.QR = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] QG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.QG = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] QG;
        public long allDataReadTime;
        public long firstByteReachTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.QG = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c QM;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.QM = cVar;
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
        public byte[] QG;

        j() {
            this.QG = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.QG = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024k extends h {
        public byte[] QG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0024k() {
            this.QG = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0024k(byte[] bArr) {
            this.QG = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c QO;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.QO = null;
            this.QO = cVar;
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
