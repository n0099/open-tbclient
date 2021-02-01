package com.baidu.swan.apps.setting.oauth.a;

import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private String dKf;
    private JSONObject dKg;
    private boolean dKh;
    private boolean dKi;
    private final Map<String, String> dqY = new HashMap();

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aKD() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aKY();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKY() {
        HttpRequest a2 = a(this);
        if (a2 != null) {
            a2.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.apps.setting.oauth.a.h.2
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public Object parseResponse(Response response, int i) throws Exception {
                    h.this.e(response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    com.baidu.swan.apps.setting.oauth.c.c(exc.toString(), false);
                    h.this.w(new OAuthException(10002));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Response response) throws IOException {
        if (!response.isSuccessful()) {
            com.baidu.swan.apps.setting.oauth.c.c("bad response", true);
            w(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            com.baidu.swan.apps.setting.oauth.c.c("empty response body", true);
            w(new OAuthException(10001));
            return;
        }
        sv(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aKZ() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aIK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> ct(String str, String str2) {
        this.dqY.put(str, str2);
        return this;
    }

    public Map<String, String> aLa() {
        return this.dqY;
    }

    public void aLb() {
        this.dKh = true;
    }

    public void aLc() {
        this.dKi = true;
    }

    protected void sv(String str) {
        int optInt;
        this.dKf = str;
        try {
            this.dKg = new JSONObject(this.dKf);
            optInt = this.dKg.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            w(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            w(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dKh && optInt == 402) || (this.dKi && optInt == 401)) {
            this.dKh = false;
            this.dKi = false;
            if (com.baidu.swan.apps.d.a.f.cEs.ajE()) {
                com.baidu.swan.apps.d.a.f.cEs.ajD();
            }
            sw(str);
        } else if (jq(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cEs.ajE()) {
                com.baidu.swan.apps.d.a.f.cEs.ajD();
                sw(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            aa(bV(this.dKg));
            aKU();
            finish();
        }
    }

    private boolean jq(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sw(final String str) {
        aKZ().aIX().a(com.baidu.swan.apps.v.f.aAl().azV(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rf();
                    h.this.aKB();
                    return;
                }
                h.this.sv(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKU() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aKC(), Integer.valueOf(this.dIS.getErrorCode()), this.dKf, this.dKg, this.dIS.mData, this.dIS.aKT());
    }
}
