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
        public String EL;
        public String mQuery;
        public String wg = "/";
        public String EM = null;
        public String[] EN = null;
        public List<BasicNameValuePair> EO = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.EL = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean EX;
        public Map<String, String> EY;

        public q(boolean z, Map<String, String> map) {
            this.EX = z;
            this.EY = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException ER;

        public d(SocketException socketException) {
            this.ER = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String ES;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.ES = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String ES;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.ES = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException EV;

        public l(WebSocketException webSocketException) {
            this.EV = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception ET;

        public f(Exception exc) {
            this.ET = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String EZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.EZ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] EK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.EK = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] EK;
        public long ti;
        public long tj;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.EK = bArr;
            this.ti = j;
            this.tj = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c EU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.EU = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String EP;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.EP = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.EP = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] EK;

        j() {
            this.EK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.EK = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018k extends h {
        public byte[] EK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k() {
            this.EK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0018k(byte[] bArr) {
            this.EK = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c EW;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.EW = null;
            this.EW = cVar;
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
