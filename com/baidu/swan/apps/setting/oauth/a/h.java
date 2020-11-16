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
/* loaded from: classes7.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> dhC = new HashMap();
    private String dxk;
    private JSONObject dxl;
    private boolean dxm;
    private boolean dxn;

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aIF() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aJa();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJa() {
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
        sJ(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aJb() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aGM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cu(String str, String str2) {
        this.dhC.put(str, str2);
        return this;
    }

    public Map<String, String> aJc() {
        return this.dhC;
    }

    public void aJd() {
        this.dxm = true;
    }

    public void aJe() {
        this.dxn = true;
    }

    protected void sJ(String str) {
        int optInt;
        this.dxk = str;
        try {
            this.dxl = new JSONObject(this.dxk);
            optInt = this.dxl.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dxm && optInt == 402) || (this.dxn && optInt == 401)) {
            this.dxm = false;
            this.dxn = false;
            if (com.baidu.swan.apps.d.a.f.cva.aiH()) {
                com.baidu.swan.apps.d.a.f.cva.aiG();
            }
            sK(str);
        } else if (kp(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cva.aiH()) {
                com.baidu.swan.apps.d.a.f.cva.aiG();
                sK(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            Z(bO(this.dxl));
            aIW();
            finish();
        }
    }

    private boolean kp(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sK(final String str) {
        aJb().aGZ().a(com.baidu.swan.apps.v.f.azg().ayQ(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rE();
                    h.this.aID();
                    return;
                }
                h.this.sJ(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIW() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aIE(), Integer.valueOf(this.dvX.getErrorCode()), this.dxk, this.dxl, this.dvX.mData, this.dvX.aIV());
    }
}
