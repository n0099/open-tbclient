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
        public String[] Pn = null;
        public List<BasicNameValuePair> Po = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Pv;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.Pv = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Pp;

        public d(SocketException socketException) {
            this.Pp = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Pq;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Pq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Pq;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Pq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Pt;

        public l(WebSocketException webSocketException) {
            this.Pt = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Pr;

        public f(Exception exc) {
            this.Pr = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Pw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Pw = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] Pm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.Pm = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Pm;
        public long allDataReadTime;
        public long firstByteReachTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Pm = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ps;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ps = cVar;
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
        public byte[] Pm;

        j() {
            this.Pm = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Pm = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025k extends h {
        public byte[] Pm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0025k() {
            this.Pm = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0025k(byte[] bArr) {
            this.Pm = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Pu;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Pu = null;
            this.Pu = cVar;
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
