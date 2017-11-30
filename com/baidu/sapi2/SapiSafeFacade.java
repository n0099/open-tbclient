package com.baidu.sapi2;

import com.baidu.sapi2.callback.SafeFacadeCallback;
import com.baidu.sapi2.result.SafeFacadeResult;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiSafeFacade {
    public static final int SAPIWEBVIEW_AUTHORIZATION = 104;
    public static final int SAPIWEBVIEW_BACK = 102;
    public static final int SAPIWEBVIEW_BIND_WIDGET = 111;
    public static final int SAPIWEBVIEW_FAST_REG = 110;
    public static final int SAPIWEBVIEW_FINISH = 103;
    public static final int SAPIWEBVIEW_INITED = 101;
    public static final int SAPIWEBVIEW_LOGIN = 107;
    public static final int SAPIWEBVIEW_MODIFY_PWD = 106;
    public static final int SAPIWEBVIEW_REALNAME_AUTHENTICATE = 105;
    public static final int SAPIWEBVIEW_REG = 109;
    public static final int SAPIWEBVIEW_SMS_LOGIN = 108;
    public static final int SOFIRE_MODULE_ID = 1;
    private static SapiSafeFacade a;

    private SapiSafeFacade() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized SapiSafeFacade a() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (a == null) {
                a = new SapiSafeFacade();
            }
            sapiSafeFacade = a;
        }
        return sapiSafeFacade;
    }

    public void checkSafeAsync(String str, String str2, int i, SafeFacadeCallback safeFacadeCallback) {
        if (str == null) {
            throw new IllegalArgumentException("uid can't be null");
        }
        if (safeFacadeCallback == null) {
            throw new IllegalArgumentException(SafeFacadeResult.class.getSimpleName() + " can't be null");
        }
        SafeFacadeResult safeFacadeResult = new SafeFacadeResult();
        safeFacadeCallback.onStart();
        safeFacadeResult.safeItems = null;
        safeFacadeResult.setResultCode(-1);
        safeFacadeCallback.onFailure(safeFacadeResult);
        safeFacadeCallback.onFinish();
    }

    /* loaded from: classes.dex */
    public static class a {
        static final String a = "0";
        static final String b = "1";
        static final String c = "2";
        static final String d = "3";
        static final String e = "4";
        static final String f = "5";
        static final String g = "6";
        static final String h = "7";
        static final String i = "8";
        static final String j = "9";
        static final String k = "10";
        static final String l = "11";
        static final String m = "12";
        static final String n = "13";
        public String A;
        public String B;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.o = jSONObject.optString("0");
            aVar.p = jSONObject.optString("1");
            aVar.q = jSONObject.optString("2");
            aVar.r = jSONObject.optString("3");
            aVar.s = jSONObject.optString(e);
            aVar.t = jSONObject.optString(f);
            aVar.u = jSONObject.optString(g);
            aVar.v = jSONObject.optString(h);
            aVar.w = jSONObject.optString(i);
            aVar.x = jSONObject.optString(j);
            aVar.y = jSONObject.optString(k);
            aVar.z = jSONObject.optString(l);
            aVar.A = jSONObject.optString(m);
            aVar.B = jSONObject.optString(n);
            return aVar;
        }
    }
}
