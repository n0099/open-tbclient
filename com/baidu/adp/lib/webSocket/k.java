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
        public String zV;
        public String zW;
        public String mPath = "/";
        public String zX = null;
        public String[] zY = null;
        public List<BasicNameValuePair> zZ = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Ai;
        public Map<String, String> Aj;

        public q(boolean z, Map<String, String> map) {
            this.Ai = z;
            this.Aj = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ab;

        public d(SocketException socketException) {
            this.Ab = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Ac;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Ac = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Ac;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Ac = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ag;

        public l(WebSocketException webSocketException) {
            this.Ag = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ae;

        public f(Exception exc) {
            this.Ae = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Ak;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Ak = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] zU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.zU = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long ob;
        public long oc;
        public byte[] zU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.zU = bArr;
            this.ob = j;
            this.oc = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Af;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Af = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Aa;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Aa = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Aa = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zU;

        j() {
            this.zU = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zU = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008k extends h {
        public byte[] zU;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k() {
            this.zU = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k(byte[] bArr) {
            this.zU = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Ah;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ah = null;
            this.Ah = cVar;
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
