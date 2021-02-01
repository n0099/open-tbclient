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
        public String[] RA = null;
        public List<BasicNameValuePair> RB = null;

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
        public SocketException RC;

        public d(SocketException socketException) {
            this.RC = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String RD;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.RD = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String RD;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.RD = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException RG;

        public l(WebSocketException webSocketException) {
            this.RG = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception RE;

        public f(Exception exc) {
            this.RE = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String RI;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.RI = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] Rz;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.Rz = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Rz;
        public long allDataReadTime;
        public long firstByteReachTime;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Rz = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c RF;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.RF = cVar;
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
        public byte[] Rz;

        j() {
            this.Rz = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Rz = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] Rz;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.Rz = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.Rz = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c RH;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.RH = null;
            this.RH = cVar;
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
