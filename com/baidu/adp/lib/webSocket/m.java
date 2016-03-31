package com.baidu.adp.lib.webSocket;

import java.net.SocketException;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m {

    /* loaded from: classes.dex */
    public static class h {
    }

    /* loaded from: classes.dex */
    public static class b extends h {
        public String AI;
        public String AJ;
        public String mPath = "/";
        public String AK = null;
        public String[] AL = null;
        public List<BasicNameValuePair> AM = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.AI = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean AU;
        public Map<String, String> AV;

        public q(boolean z, Map<String, String> map) {
            this.AU = z;
            this.AV = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException AO;

        public d(SocketException socketException) {
            this.AO = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String AP;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.AP = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String AP;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.AP = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException AS;

        public l(WebSocketException webSocketException) {
            this.AS = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception AQ;

        public f(Exception exc) {
            this.AQ = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String AW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.AW = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010m extends h {
        public byte[] AH;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010m(byte[] bArr) {
            this.AH = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] AH;
        public long oL;
        public long oM;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.AH = bArr;
            this.oL = j;
            this.oM = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c AR;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.AR = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String AN;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.AN = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.AN = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] AH;

        j() {
            this.AH = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.AH = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] AH;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.AH = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.AH = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c AT;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.AT = null;
            this.AT = cVar;
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
