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
/* loaded from: classes10.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> djm = new HashMap();
    private String dyR;
    private JSONObject dyS;
    private boolean dyT;
    private boolean dyU;

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aJn() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aJI();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
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
        sO(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aJJ() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aHu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cv(String str, String str2) {
        this.djm.put(str, str2);
        return this;
    }

    public Map<String, String> aJK() {
        return this.djm;
    }

    public void aJL() {
        this.dyT = true;
    }

    public void aJM() {
        this.dyU = true;
    }

    protected void sO(String str) {
        int optInt;
        this.dyR = str;
        try {
            this.dyS = new JSONObject(this.dyR);
            optInt = this.dyS.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dyT && optInt == 402) || (this.dyU && optInt == 401)) {
            this.dyT = false;
            this.dyU = false;
            if (com.baidu.swan.apps.d.a.f.cwK.ajp()) {
                com.baidu.swan.apps.d.a.f.cwK.ajo();
            }
            sP(str);
        } else if (kt(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cwK.ajp()) {
                com.baidu.swan.apps.d.a.f.cwK.ajo();
                sP(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            Z(bU(this.dyS));
            aJE();
            finish();
        }
    }

    private boolean kt(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sP(final String str) {
        aJJ().aHH().a(com.baidu.swan.apps.v.f.azO().azy(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rE();
                    h.this.aJl();
                    return;
                }
                h.this.sO(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJE() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aJm(), Integer.valueOf(this.dxE.getErrorCode()), this.dyR, this.dyS, this.dxE.mData, this.dxE.aJD());
    }
}
