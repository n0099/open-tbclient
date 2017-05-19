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
        public String AA;
        public String AB;
        public String mPath = "/";
        public String AC = null;
        public String[] AD = null;
        public List<BasicNameValuePair> AE = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.AA = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean AM;
        public Map<String, String> AN;

        public q(boolean z, Map<String, String> map) {
            this.AM = z;
            this.AN = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException AG;

        public d(SocketException socketException) {
            this.AG = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String AH;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.AH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String AH;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.AH = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException AK;

        public l(WebSocketException webSocketException) {
            this.AK = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception AI;

        public f(Exception exc) {
            this.AI = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String AO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.AO = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] Az;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.Az = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Az;
        public long oJ;
        public long oK;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Az = bArr;
            this.oJ = j;
            this.oK = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c AJ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.AJ = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String AF;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.AF = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.AF = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Az;

        j() {
            this.Az = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Az = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] Az;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.Az = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.Az = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c AL;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.AL = null;
            this.AL = cVar;
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
