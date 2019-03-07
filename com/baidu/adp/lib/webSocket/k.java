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
        public String HR;
        public String mQuery;
        public String mPath = "/";
        public String HS = null;
        public String[] HU = null;
        public List<BasicNameValuePair> HV = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.HR = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Id;
        public Map<String, String> Ie;

        public q(boolean z, Map<String, String> map) {
            this.Id = z;
            this.Ie = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException HX;

        public d(SocketException socketException) {
            this.HX = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String HY;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.HY = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String HY;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.HY = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ib;

        public l(WebSocketException webSocketException) {
            this.Ib = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception HZ;

        public f(Exception exc) {
            this.HZ = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String If;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.If = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] HQ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.HQ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] HQ;
        public long wu;
        public long wv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.HQ = bArr;
            this.wu = j;
            this.wv = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ia;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ia = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String HW;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.HW = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.HW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] HQ;

        j() {
            this.HQ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.HQ = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] HQ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.HQ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.HQ = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Ic;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ic = null;
            this.Ic = cVar;
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
