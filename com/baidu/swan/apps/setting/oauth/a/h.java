package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private String dEj;
    private JSONObject dEk;
    private boolean dEl;
    private boolean dEm;
    private final Map<String, String> doE = new HashMap();

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aLN() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aMi();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMi() {
        HttpRequest a2 = a(this);
        if (a2 != null) {
            a2.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.apps.setting.oauth.a.h.2
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public Object parseResponse(Response response, int i) throws Exception {
                    h.this.d(response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    com.baidu.swan.apps.setting.oauth.c.c(exc.toString(), false);
                    h.this.v(new OAuthException(10002));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Response response) throws IOException {
        if (!response.isSuccessful()) {
            com.baidu.swan.apps.setting.oauth.c.c("bad response", true);
            v(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            com.baidu.swan.apps.setting.oauth.c.c("empty response body", true);
            v(new OAuthException(10001));
            return;
        }
        tq(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aMj() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aJU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cB(String str, String str2) {
        this.doE.put(str, str2);
        return this;
    }

    public Map<String, String> aMk() {
        return this.doE;
    }

    public void aMl() {
        this.dEl = true;
    }

    public void aMm() {
        this.dEm = true;
    }

    protected void tq(String str) {
        int optInt;
        this.dEj = str;
        try {
            this.dEk = new JSONObject(this.dEj);
            optInt = this.dEk.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dEl && optInt == 402) || (this.dEm && optInt == 401)) {
            this.dEl = false;
            this.dEm = false;
            if (com.baidu.swan.apps.d.a.f.cBS.alP()) {
                com.baidu.swan.apps.d.a.f.cBS.alO();
            }
            tr(str);
        } else if (kN(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cBS.alP()) {
                com.baidu.swan.apps.d.a.f.cBS.alO();
                tr(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            Z(bQ(this.dEk));
            aMe();
            finish();
        }
    }

    private boolean kN(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void tr(final String str) {
        aMj().aKh().a(com.baidu.swan.apps.v.f.aCp().aBZ(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rG();
                    h.this.aLL();
                    return;
                }
                h.this.tq(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aMe() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aLM(), Integer.valueOf(this.dCW.getErrorCode()), this.dEj, this.dEk, this.dCW.mData, this.dCW.aMd());
    }
}
