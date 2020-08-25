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
/* loaded from: classes8.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> cGJ = new HashMap();
    private String cWj;
    private JSONObject cWk;
    private boolean cWl;
    private boolean cWm;

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aBA() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aBV();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBV() {
        HttpRequest a = a(this);
        if (a != null) {
            a.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.apps.setting.oauth.a.h.2
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
        ra(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aBW() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return azI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cj(String str, String str2) {
        this.cGJ.put(str, str2);
        return this;
    }

    public Map<String, String> aBX() {
        return this.cGJ;
    }

    public void aBY() {
        this.cWl = true;
    }

    public void aBZ() {
        this.cWm = true;
    }

    protected void ra(String str) {
        int optInt;
        this.cWj = str;
        try {
            this.cWk = new JSONObject(this.cWj);
            optInt = this.cWk.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.cWl && optInt == 402) || (this.cWm && optInt == 401)) {
            this.cWl = false;
            this.cWm = false;
            if (com.baidu.swan.apps.d.a.f.bTS.abA()) {
                com.baidu.swan.apps.d.a.f.bTS.abz();
            }
            rb(str);
        } else if (jq(optInt)) {
            if (com.baidu.swan.apps.d.a.f.bTS.abA()) {
                com.baidu.swan.apps.d.a.f.bTS.abz();
                rb(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            V(bB(this.cWk));
            aBR();
            finish();
        }
    }

    private boolean jq(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void rb(final String str) {
        aBW().azV().a(com.baidu.swan.apps.v.f.arY().arI(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rz();
                    h.this.aBy();
                    return;
                }
                h.this.ra(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBR() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aBz(), Integer.valueOf(this.cUW.getErrorCode()), this.cWj, this.cWk, this.cUW.mData, this.cUW.aBQ());
    }
}
