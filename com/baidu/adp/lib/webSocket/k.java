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
        public String mHost;
        public String mQuery;
        public String mPath = "/";
        public String mOrigin = null;
        public String[] HM = null;
        public List<BasicNameValuePair> HN = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean HV;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.HV = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException HP;

        public d(SocketException socketException) {
            this.HP = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String HQ;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.HQ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String HQ;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.HQ = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException HS;

        public l(WebSocketException webSocketException) {
            this.HS = webSocketException;
        }
    }

    /* loaded from: classes.dex */
    public static class f extends h {
        public Exception mException;

        public f(Exception exc) {
            this.mException = exc;
        }
    }

    /* loaded from: classes.dex */
    public static class s extends h {
        public String HW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.HW = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] HL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.HL = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] HL;
        public long wu;
        public long wv;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.HL = bArr;
            this.wu = j;
            this.wv = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c HR;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.HR = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String HO;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.HO = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.HO = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] HL;

        j() {
            this.HL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.HL = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] HL;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.HL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.HL = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c HU;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.HU = null;
            this.HU = cVar;
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
