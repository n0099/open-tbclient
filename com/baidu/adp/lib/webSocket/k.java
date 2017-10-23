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
        public String zY;
        public String zZ;
        public String mPath = "/";
        public String Aa = null;
        public String[] Ab = null;
        public List<BasicNameValuePair> Ac = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zY = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Al;
        public Map<String, String> Am;

        public q(boolean z, Map<String, String> map) {
            this.Al = z;
            this.Am = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Af;

        public d(SocketException socketException) {
            this.Af = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ag;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ag = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ag;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ag = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Aj;

        public l(WebSocketException webSocketException) {
            this.Aj = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ah;

        public f(Exception exc) {
            this.Ah = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String An;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.An = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long od;
        public long oe;
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.zX = bArr;
            this.od = j;
            this.oe = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ai;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ai = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Ae;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Ae = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Ae = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zX;

        j() {
            this.zX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008k extends h {
        public byte[] zX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k() {
            this.zX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k(byte[] bArr) {
            this.zX = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Ak;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ak = null;
            this.Ak = cVar;
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
