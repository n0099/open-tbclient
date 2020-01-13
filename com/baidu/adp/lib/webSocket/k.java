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
        public String[] vn = null;
        public List<BasicNameValuePair> vo = null;

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
        public SocketException vq;

        public d(SocketException socketException) {
            this.vq = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String vr;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.vr = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String vr;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.vr = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException vu;

        public l(WebSocketException webSocketException) {
            this.vu = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception vs;

        public f(Exception exc) {
            this.vs = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String vw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.vw = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] vm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.vm = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long allDataReadTime;
        public long firstByteReachTime;
        public byte[] vm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.vm = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c vt;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.vt = cVar;
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
        public byte[] vm;

        j() {
            this.vm = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.vm = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] vm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.vm = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.vm = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c vv;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.vv = null;
            this.vv = cVar;
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
