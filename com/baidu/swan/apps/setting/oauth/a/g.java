package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private String cNn;
    private JSONObject cNo;
    private boolean cNp;
    private boolean cNq;
    private final Map<String, String> cyR = new HashMap();

    protected abstract HttpRequest a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void ats() {
        if (!com.baidu.swan.apps.performance.b.b.aon()) {
            atM();
        } else {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                        Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                    }
                    g.this.atM();
                }
            }, "OAuthRequest-onExec", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atM() {
        HttpRequest a = a(this);
        if (a != null) {
            a.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public Object parseResponse(Response response, int i) throws Exception {
                    g.this.d(response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    com.baidu.swan.apps.setting.oauth.c.c(exc.toString(), false);
                    g.this.s(new OAuthException(10002));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Response response) throws IOException {
        if (!response.isSuccessful()) {
            com.baidu.swan.apps.setting.oauth.c.c("bad response", true);
            s(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            com.baidu.swan.apps.setting.oauth.c.c("empty response body", true);
            s(new OAuthException(10001));
            return;
        }
        pd(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e atN() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return arv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bS(String str, String str2) {
        this.cyR.put(str, str2);
        return this;
    }

    public Map<String, String> atO() {
        return this.cyR;
    }

    public void atP() {
        this.cNp = true;
    }

    public void atQ() {
        this.cNq = true;
    }

    protected void pd(String str) {
        int optInt;
        this.cNn = str;
        try {
            this.cNo = new JSONObject(this.cNn);
            optInt = this.cNo.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            s(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            s(new OAuthException(10005));
            h.b(10005, null);
        }
        if ((this.cNp && optInt == 402) || (this.cNq && optInt == 401)) {
            this.cNp = false;
            this.cNq = false;
            if (com.baidu.swan.apps.c.a.f.bOu.Vu()) {
                com.baidu.swan.apps.c.a.f.bOu.Vt();
            }
            pe(str);
        } else if (hj(optInt)) {
            if (com.baidu.swan.apps.c.a.f.bOu.Vu()) {
                com.baidu.swan.apps.c.a.f.bOu.Vt();
                pe(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            S(bt(this.cNo));
            atJ();
            finish();
        }
    }

    private boolean hj(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void pe(final String str) {
        atN().arI().a(com.baidu.swan.apps.v.f.akr().akb(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.qa();
                    g.this.atq();
                    return;
                }
                g.this.pd(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atJ() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), atr(), Integer.valueOf(this.cLZ.getErrorCode()), this.cNn, this.cNo, this.cLZ.mData, this.cLZ.atI());
    }
}
