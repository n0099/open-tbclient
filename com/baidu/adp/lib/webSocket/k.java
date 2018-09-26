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
        public String Hh;
        public String mQuery;
        public String yz = "/";
        public String Hi = null;
        public String[] Hj = null;
        public List<BasicNameValuePair> Hk = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Hh = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Hs;
        public Map<String, String> Ht;

        public q(boolean z, Map<String, String> map) {
            this.Hs = z;
            this.Ht = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Hm;

        public d(SocketException socketException) {
            this.Hm = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Hn;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Hn = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Hn;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Hn = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Hq;

        public l(WebSocketException webSocketException) {
            this.Hq = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ho;

        public f(Exception exc) {
            this.Ho = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Hu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Hu = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] Hg;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.Hg = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Hg;
        public long vH;
        public long vI;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Hg = bArr;
            this.vH = j;
            this.vI = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Hp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Hp = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Hl;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Hl = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Hl = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Hg;

        j() {
            this.Hg = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Hg = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018k extends h {
        public byte[] Hg;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k() {
            this.Hg = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k(byte[] bArr) {
            this.Hg = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Hr;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Hr = null;
            this.Hr = cVar;
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
