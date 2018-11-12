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
        public String[] HQ = null;
        public List<BasicNameValuePair> HR = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.mHost = str;
        }
    }

    /* loaded from: classes.dex */
    public static class q extends h {
        public boolean HZ;
        public Map<String, String> mHeaders;

        public q(boolean z, Map<String, String> map) {
            this.HZ = z;
            this.mHeaders = map;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h {
        public SocketException HU;

        public d(SocketException socketException) {
            this.HU = socketException;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends h {
        public String HV;
        public int mStatusCode;

        public e(int i, String str) {
            this.mStatusCode = i;
            this.HV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends h {
        public String HV;
        public int mStatusCode;

        public p(int i, String str) {
            this.mStatusCode = i;
            this.HV = str;
        }
    }

    /* loaded from: classes.dex */
    public static class l extends h {
        public WebSocketException HX;

        public l(WebSocketException webSocketException) {
            this.HX = webSocketException;
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
        public String Ia;

        /* JADX INFO: Access modifiers changed from: package-private */
        public s(String str) {
            this.Ia = str;
        }
    }

    /* loaded from: classes.dex */
    public static class m extends h {
        public byte[] HP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(byte[] bArr) {
            this.HP = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends h {
        public byte[] HP;
        public long wx;
        public long wy;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(byte[] bArr, long j, long j2) {
            this.HP = bArr;
            this.wx = j;
            this.wy = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        com.baidu.adp.lib.webSocket.c HW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(com.baidu.adp.lib.webSocket.c cVar) {
            this.HW = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {
        public String HS;
        public int mCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            this.mCode = -1;
            this.HS = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, String str) {
            this.mCode = i;
            this.HS = str;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h {
        public byte[] HP;

        j() {
            this.HP = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(byte[] bArr) {
            this.HP = bArr;
        }
    }

    /* renamed from: com.baidu.adp.lib.webSocket.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021k extends h {
        public byte[] HP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k() {
            this.HP = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0021k(byte[] bArr) {
            this.HP = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends h {
        com.baidu.adp.lib.webSocket.c HY;

        public o(com.baidu.adp.lib.webSocket.c cVar) {
            this.HY = null;
            this.HY = cVar;
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
