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
        public String zW;
        public String zX;
        public String mPath = "/";
        public String zY = null;
        public String[] zZ = null;
        public List<BasicNameValuePair> Aa = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Aj;
        public Map<String, String> Ak;

        public q(boolean z, Map<String, String> map) {
            this.Aj = z;
            this.Ak = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ac;

        public d(SocketException socketException) {
            this.Ac = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ae;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ae = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ae;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ae = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ah;

        public l(WebSocketException webSocketException) {
            this.Ah = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Af;

        public f(Exception exc) {
            this.Af = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Al;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Al = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] zV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.zV = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long od;
        public long oe;
        public byte[] zV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.zV = bArr;
            this.od = j;
            this.oe = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ag;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ag = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Ab;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Ab = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Ab = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zV;

        j() {
            this.zV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zV = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008k extends h {
        public byte[] zV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k() {
            this.zV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k(byte[] bArr) {
            this.zV = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Ai;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ai = null;
            this.Ai = cVar;
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
