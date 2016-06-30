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
        public String qU;
        public String qV;
        public String mPath = "/";
        public String qW = null;
        public String[] qX = null;
        public List<BasicNameValuePair> qY = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.qU = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean rg;
        public Map<String, String> rh;

        public q(boolean z, Map<String, String> map) {
            this.rg = z;
            this.rh = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException ra;

        public d(SocketException socketException) {
            this.ra = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public int mStatusCode;
        public String rb;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.rb = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public int mStatusCode;
        public String rb;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.rb = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException re;

        public l(WebSocketException webSocketException) {
            this.re = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception rc;

        public f(Exception exc) {
            this.rc = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String ri;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.ri = str;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.m$m  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010m extends h {
        public byte[] qT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0010m(byte[] bArr) {
            this.qT = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long eC;
        public long eD;
        public byte[] qT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.qT = bArr;
            this.eC = j;
            this.eD = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c rd;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.rd = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public int mCode;
        public String qZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.qZ = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.qZ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] qT;

        j() {
            this.qT = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.qT = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends h {
        public byte[] qT;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k() {
            this.qT = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(byte[] bArr) {
            this.qT = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c rf;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.rf = null;
            this.rf = cVar;
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
