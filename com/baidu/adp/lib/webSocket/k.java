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
        public String zX;
        public String zY;
        public String mPath = "/";
        public String zZ = null;
        public String[] Aa = null;
        public List<BasicNameValuePair> Ab = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.zX = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Ak;
        public Map<String, String> Al;

        public q(boolean z, Map<String, String> map) {
            this.Ak = z;
            this.Al = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Ae;

        public d(SocketException socketException) {
            this.Ae = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Af;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Af = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Af;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Af = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Ai;

        public l(WebSocketException webSocketException) {
            this.Ai = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Ag;

        public f(Exception exc) {
            this.Ag = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Am;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Am = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] zW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.zW = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long oc;
        public long od;
        public byte[] zW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.zW = bArr;
            this.oc = j;
            this.od = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Ah;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Ah = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Ac;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Ac = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Ac = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] zW;

        j() {
            this.zW = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.zW = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008k extends h {
        public byte[] zW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k() {
            this.zW = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008k(byte[] bArr) {
            this.zW = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Aj;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Aj = null;
            this.Aj = cVar;
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
