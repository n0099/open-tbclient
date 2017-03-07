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
        public String AW;
        public String AX;
        public String mPath = "/";
        public String AY = null;
        public String[] AZ = null;
        public List<BasicNameValuePair> Ba = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.AW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean Bi;
        public Map<String, String> Bj;

        public q(boolean z, Map<String, String> map) {
            this.Bi = z;
            this.Bj = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException Bc;

        public d(SocketException socketException) {
            this.Bc = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String Bd;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.Bd = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String Bd;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.Bd = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException Bg;

        public l(WebSocketException webSocketException) {
            this.Bg = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception Be;

        public f(Exception exc) {
            this.Be = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String Bk;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Bk = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0008m extends h {
        public byte[] AV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0008m(byte[] bArr) {
            this.AV = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] AV;
        public long po;
        public long pp;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.AV = bArr;
            this.po = j;
            this.pp = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c Bf;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.Bf = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String Bb;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.Bb = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.Bb = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] AV;

        j() {
            this.AV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.AV = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] AV;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.AV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.AV = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c Bh;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.Bh = null;
            this.Bh = cVar;
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
