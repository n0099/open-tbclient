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
        public String rx;
        public String ry;
        public String mPath = "/";
        public String rz = null;
        public String[] rA = null;
        public List<BasicNameValuePair> rB = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.rx = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean rJ;
        public Map<String, String> rK;

        public q(boolean z, Map<String, String> map) {
            this.rJ = z;
            this.rK = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException rD;

        public d(SocketException socketException) {
            this.rD = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String rE;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.rE = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String rE;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.rE = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException rH;

        public l(WebSocketException webSocketException) {
            this.rH = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception rF;

        public f(Exception exc) {
            this.rF = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String rL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.rL = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010m extends h {
        public byte[] rw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010m(byte[] bArr) {
            this.rw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long fe;
        public long ff;
        public byte[] rw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.rw = bArr;
            this.fe = j;
            this.ff = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c rG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.rG = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String rC;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.rC = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.rC = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] rw;

        j() {
            this.rw = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.rw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] rw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.rw = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.rw = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c rI;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.rI = null;
            this.rI = cVar;
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
