package com.baidu.sofire.ac;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.u;
import com.baidu.sofire.e;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JI {
    private static final int ERROR_METHOD_CALL_EXCEPTION = 106;
    private static final int ERROR_ONEND_EXCEPTION = 102;
    private static final int ERROR_ONEND_NULL = 101;
    private static final int ERROR_ONERROR_EXCEPTION = 104;
    private static final int ERROR_ONERROR_NULL = 103;
    private static final int ERROR_RESULT_NULL = 105;
    private static final String KEY_STATUS = "status";
    private static final String KEY_VALUE = "result";
    private Context mContext;
    private String mUrl;
    private WebView mWebView;

    public JI(WebView webView) {
        if (webView != null) {
            this.mWebView = webView;
            this.mContext = webView.getContext().getApplicationContext();
        }
    }

    private boolean checkAuthority() {
        if (this.mWebView == null || new e(this.mContext).a.getInt("appinv_js", 0) == 0) {
            return false;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mWebView.post(new Runnable() { // from class: com.baidu.sofire.ac.JI.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JI.this.mUrl = JI.this.mWebView.getUrl();
                    countDownLatch.countDown();
                } catch (Throwable th) {
                    new StringBuilder().append(th.getMessage());
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }
        new StringBuilder(" url ").append(this.mUrl);
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        if (!this.mUrl.toLowerCase().startsWith("http://") && !this.mUrl.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            this.mUrl = "http://" + this.mUrl;
        }
        try {
            String host = new URI(this.mUrl).getHost();
            if (!TextUtils.isEmpty(host) && host.toLowerCase().endsWith(".baidu.com") && com.baidu.sofire.b.e.d(this.mContext)) {
                int a = u.a().a(this.mUrl);
                if (a == 0) {
                    return true;
                }
                if (a != -3) {
                    String str = com.baidu.sofire.b.e.a() + "p/1/uck";
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(this.mUrl);
                    int i = new JSONArray(h.a(this.mContext, str, jSONArray.toString(), true, false)).getInt(0);
                    new StringBuilder("js-url-").append(Integer.toString(i));
                    u.a().a(this.mUrl, i);
                    return i == 1;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    @JavascriptInterface
    public String gzfi(String str, int i) {
        try {
            if (!checkAuthority()) {
                return "";
            }
            if (i != 0) {
                FH.call(1, "ice", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            }
            return FH.gz(this.mContext);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return "";
        }
    }

    @JavascriptInterface
    public String gz() {
        try {
            if (!checkAuthority()) {
                return "";
            }
            return FH.gz(this.mContext);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return "";
        }
    }

    @JavascriptInterface
    public void mqa(int i, String str, int i2, final String str2) {
        try {
            if (checkAuthority()) {
                new StringBuilder().append(i).append(" ").append(str).append(" ").append(i2).append(" ").append(str2);
                FH.call(1, "mqa", new Callback() { // from class: com.baidu.sofire.ac.JI.2
                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onEnd(Object... objArr) {
                        new StringBuilder().append(String.valueOf(objArr[0]));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (objArr[0] != null) {
                                jSONObject.put("status", 0);
                                jSONObject.put("result", String.valueOf(objArr[0]));
                            } else {
                                jSONObject.put("status", 101);
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                            try {
                                jSONObject.put("status", 102);
                            } catch (JSONException e) {
                            }
                        }
                        new StringBuilder().append(jSONObject.toString());
                        JI.this.javaCallJsFunction(str2, jSONObject.toString());
                        return null;
                    }

                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onError(Object... objArr) {
                        new StringBuilder().append(String.valueOf(objArr[0]));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (objArr[0] != null) {
                                jSONObject.put("status", Integer.valueOf(String.valueOf(objArr[0])));
                            } else {
                                jSONObject.put("status", 103);
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                            try {
                                jSONObject.put("status", 104);
                            } catch (JSONException e) {
                            }
                        }
                        new StringBuilder().append(jSONObject.toString());
                        JI.this.javaCallJsFunction(str2, jSONObject.toString());
                        return null;
                    }
                }, new Class[]{Integer.TYPE, String.class, Integer.TYPE}, Integer.valueOf(i), str, Integer.valueOf(i2));
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @JavascriptInterface
    public String mqaSync(int i, String str, int i2) {
        if (!checkAuthority()) {
            return "";
        }
        new StringBuilder().append(i).append(" ").append(str).append(" ").append(i2);
        JSONObject jSONObject = new JSONObject();
        try {
            Pair<Integer, Object> callSync = FH.callSync(1, "mqa", new Class[]{Integer.TYPE, String.class, Integer.TYPE}, Integer.valueOf(i), str, Integer.valueOf(i2));
            if (callSync != null) {
                jSONObject.put("status", callSync.first);
                jSONObject.put("result", callSync.second);
            } else {
                jSONObject.put("status", 105);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            try {
                jSONObject.put("status", 106);
            } catch (JSONException e) {
                com.baidu.sofire.b.e.a(th);
            }
        }
        new StringBuilder().append(jSONObject.toString());
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void ice(String str, int i, final String str2) {
        if (checkAuthority()) {
            new StringBuilder().append(str).append(" ").append(Integer.toString(i)).append(" ").append(str2);
            try {
                FH.call(1, "ice", new Callback() { // from class: com.baidu.sofire.ac.JI.3
                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onEnd(Object... objArr) {
                        new StringBuilder().append(String.valueOf(objArr[0]));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (objArr[0] != null) {
                                jSONObject.put("status", 0);
                                jSONObject.put("result", new JSONObject(String.valueOf(objArr[0])));
                            } else {
                                jSONObject.put("status", 101);
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                            try {
                                jSONObject.put("status", 102);
                            } catch (JSONException e) {
                            }
                        }
                        new StringBuilder().append(jSONObject.toString());
                        JI.this.javaCallJsFunction(str2, jSONObject.toString());
                        return null;
                    }

                    @Override // com.baidu.sofire.ac.Callback
                    public final Object onError(Object... objArr) {
                        new StringBuilder().append(String.valueOf(objArr[0]));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (objArr[0] != null) {
                                jSONObject.put("status", Integer.valueOf(String.valueOf(objArr[0])));
                            } else {
                                jSONObject.put("status", 103);
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.b.e.a(th);
                            try {
                                jSONObject.put("status", 104);
                            } catch (JSONException e) {
                            }
                        }
                        new StringBuilder().append(jSONObject.toString());
                        JI.this.javaCallJsFunction(str2, jSONObject.toString());
                        return null;
                    }
                }, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
            }
        }
    }

    @JavascriptInterface
    public String iceSync(String str, int i) {
        if (!checkAuthority()) {
            return "";
        }
        new StringBuilder().append(str).append(" ").append(Integer.toString(i));
        JSONObject jSONObject = new JSONObject();
        try {
            Pair<Integer, Object> callSync = FH.callSync(1, "ice", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            if (callSync != null) {
                jSONObject.put("status", callSync.first);
                jSONObject.put("result", callSync.second);
            } else {
                jSONObject.put("status", 105);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            try {
                jSONObject.put("status", 106);
            } catch (JSONException e) {
                com.baidu.sofire.b.e.a(th);
            }
        }
        new StringBuilder().append(jSONObject.toString());
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void call(int i, String str, String[] strArr, final String str2) {
        if (checkAuthority()) {
            new StringBuilder().append(Integer.valueOf(i)).append(" ").append(str).append(" ").append(str2);
            final JSONObject jSONObject = new JSONObject();
            if (strArr != null) {
                try {
                    int length = strArr.length;
                    Class[] clsArr = new Class[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        clsArr[i2] = String.class;
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                    return;
                }
            }
            FH.call(i, str, new Callback() { // from class: com.baidu.sofire.ac.JI.4
                @Override // com.baidu.sofire.ac.Callback
                public final Object onEnd(Object... objArr) {
                    new StringBuilder().append(String.valueOf(objArr[0]));
                    try {
                        if (objArr[0] != null) {
                            jSONObject.put("status", (Object) 0);
                            jSONObject.put("result", String.valueOf(objArr[0]));
                        } else {
                            jSONObject.put("status", 101);
                        }
                    } catch (Throwable th2) {
                        com.baidu.sofire.b.e.a(th2);
                        try {
                            jSONObject.put("status", 102);
                        } catch (JSONException e) {
                        }
                    }
                    new StringBuilder().append(jSONObject.toString());
                    JI.this.javaCallJsFunction(str2, jSONObject.toString());
                    return null;
                }

                @Override // com.baidu.sofire.ac.Callback
                public final Object onError(Object... objArr) {
                    new StringBuilder().append(String.valueOf(objArr[0]));
                    try {
                        if (objArr[0] != null) {
                            jSONObject.put("status", Integer.valueOf(String.valueOf(objArr[0])));
                        } else {
                            jSONObject.put("status", 103);
                        }
                    } catch (Throwable th2) {
                        com.baidu.sofire.b.e.a(th2);
                        try {
                            jSONObject.put("status", 104);
                        } catch (JSONException e) {
                        }
                    }
                    new StringBuilder().append(jSONObject.toString());
                    JI.this.javaCallJsFunction(str2, jSONObject.toString());
                    return null;
                }
            }, null, strArr);
        }
    }

    @JavascriptInterface
    public String callSync(int i, String str, String[] strArr) {
        if (!checkAuthority()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            new StringBuilder().append(Integer.valueOf(i)).append(" ").append(str);
            if (strArr != null) {
                int length = strArr.length;
                Class[] clsArr = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr[i2] = String.class;
                }
            }
            Pair<Integer, Object> callSync = FH.callSync(i, str, null, strArr);
            if (callSync != null) {
                jSONObject.put("status", callSync.first);
                jSONObject.put("result", callSync.second);
            } else {
                jSONObject.put("status", 105);
            }
        } catch (Throwable th) {
            try {
                jSONObject.put("status", 106);
            } catch (JSONException e) {
            }
        }
        new StringBuilder().append(jSONObject.toString());
        return jSONObject.toString();
    }

    public void javaCallJsFunction(final String str, final String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mWebView != null) {
                this.mWebView.post(new Runnable() { // from class: com.baidu.sofire.ac.JI.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        JI.this.mWebView.loadUrl("javascript:" + str + "('" + str2 + "')");
                    }
                });
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
