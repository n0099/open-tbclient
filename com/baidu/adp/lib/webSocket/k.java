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
        public String EO;
        public String mQuery;
        public String mPath = "/";
        public String EP = null;
        public String[] ER = null;
        public List<BasicNameValuePair> ES = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.EO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Fa;
        public Map<String, String> Fb;

        public q(boolean z, Map<String, String> map) {
            this.Fa = z;
            this.Fb = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException EU;

        public d(SocketException socketException) {
            this.EU = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String EV;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.EV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String EV;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.EV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException EY;

        public l(WebSocketException webSocketException) {
            this.EY = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception EW;

        public f(Exception exc) {
            this.EW = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Fc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Fc = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] EN;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.EN = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] EN;
        public long tr;
        public long ts;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.EN = bArr;
            this.tr = j;
            this.ts = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c EX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.EX = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String ET;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.ET = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.ET = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] EN;

        j() {
            this.EN = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.EN = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018k extends h {
        public byte[] EN;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k() {
            this.EN = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k(byte[] bArr) {
            this.EN = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c EZ;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.EZ = null;
            this.EZ = cVar;
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
