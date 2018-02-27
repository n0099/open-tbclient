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
        public String aoc;
        public String aod;
        public String mPath = "/";
        public String aoe = null;
        public String[] aof = null;
        public List<BasicNameValuePair> aog = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.aoc = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean aoo;
        public Map<String, String> aop;

        public q(boolean z, Map<String, String> map) {
            this.aoo = z;
            this.aop = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException aoi;

        public d(SocketException socketException) {
            this.aoi = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String aoj;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.aoj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String aoj;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.aoj = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException aom;

        public l(WebSocketException webSocketException) {
            this.aom = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception aok;

        public f(Exception exc) {
            this.aok = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String aoq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.aoq = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] aob;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.aob = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public long acF;
        public long acG;
        public byte[] aob;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.aob = bArr;
            this.acF = j;
            this.acG = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c aol;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.aol = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String aoh;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.aoh = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.aoh = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] aob;

        j() {
            this.aob = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.aob = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] aob;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.aob = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.aob = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c aon;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.aon = null;
            this.aon = cVar;
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
