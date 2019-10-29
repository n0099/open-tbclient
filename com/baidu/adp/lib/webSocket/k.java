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
        public String mQuery;
        public String sT;
        public String mPath = "/";
        public String sU = null;
        public String[] sV = null;
        public List<BasicNameValuePair> sW = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.sT = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean tf;
        public Map<String, String> tg;

        public q(boolean z, Map<String, String> map) {
            this.tf = z;
            this.tg = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException sY;

        public d(SocketException socketException) {
            this.sY = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String sZ;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.sZ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String sZ;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.sZ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException td;

        public l(WebSocketException webSocketException) {
            this.td = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception tb;

        public f(Exception exc) {
            this.tb = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String th;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.th = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] sS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.sS = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long allDataReadTime;
        public long firstByteReachTime;
        public byte[] sS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.sS = bArr;
            this.firstByteReachTime = j;
            this.allDataReadTime = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c tc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.tc = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String sX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.sX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.sX = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] sS;

        j() {
            this.sS = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.sS = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019k extends h {
        public byte[] sS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k() {
            this.sS = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0019k(byte[] bArr) {
            this.sS = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c te;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.te = null;
            this.te = cVar;
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
