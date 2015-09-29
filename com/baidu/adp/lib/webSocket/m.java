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
        public String Aa;
        public String zZ;
        public String mPath = "/";
        public String Ab = null;
        public String[] Ac = null;
        public List<BasicNameValuePair> Ae = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zZ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean An;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.An = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ah;

        public d(SocketException socketException) {
            this.Ah = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ai;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ai = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ai;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ai = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Al;

        public l(WebSocketException webSocketException) {
            this.Al = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Aj;

        public f(Exception exc) {
            this.Aj = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Ao;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Ao = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] zY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.zY = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] zY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr) {
            this.zY = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ak;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ak = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int Af;
        public String Ag;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.Af = -1;
            this.Ag = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.Af = i;
            this.Ag = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zY;

        j() {
            this.zY = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zY = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] zY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.zY = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.zY = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Am;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Am = null;
            this.Am = cVar;
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
