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
        public String EM;
        public String mQuery;
        public String mPath = "/";
        public String EN = null;
        public String[] EO = null;
        public List<BasicNameValuePair> EP = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.EM = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean EY;
        public Map<String, String> EZ;

        public q(boolean z, Map<String, String> map) {
            this.EY = z;
            this.EZ = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException ES;

        public d(SocketException socketException) {
            this.ES = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String ET;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.ET = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String ET;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.ET = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException EW;

        public l(WebSocketException webSocketException) {
            this.EW = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception EU;

        public f(Exception exc) {
            this.EU = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Fa;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Fa = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] EL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.EL = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] EL;
        public long tt;
        public long tu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.EL = bArr;
            this.tt = j;
            this.tu = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c EV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.EV = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String ER;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.ER = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.ER = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] EL;

        j() {
            this.EL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.EL = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018k extends h {
        public byte[] EL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k() {
            this.EL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k(byte[] bArr) {
            this.EL = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c EX;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.EX = null;
            this.EX = cVar;
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
