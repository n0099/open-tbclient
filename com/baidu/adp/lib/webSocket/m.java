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
        public String Ax;
        public String Ay;
        public String mPath = "/";
        public String Az = null;
        public String[] AA = null;
        public List<BasicNameValuePair> AB = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.Ax = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean AJ;
        public Map<String, String> AK;

        public q(boolean z, Map<String, String> map) {
            this.AJ = z;
            this.AK = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException AD;

        public d(SocketException socketException) {
            this.AD = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String AE;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.AE = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String AE;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.AE = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException AH;

        public l(WebSocketException webSocketException) {
            this.AH = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception AF;

        public f(Exception exc) {
            this.AF = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String AL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.AL = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] Aw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.Aw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] Aw;
        public long oI;
        public long oJ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.Aw = bArr;
            this.oI = j;
            this.oJ = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c AG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.AG = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String AC;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.AC = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.AC = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] Aw;

        j() {
            this.Aw = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.Aw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] Aw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.Aw = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.Aw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c AI;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.AI = null;
            this.AI = cVar;
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
