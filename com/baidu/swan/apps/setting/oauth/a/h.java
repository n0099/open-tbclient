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
    private final Map<String, String> ddp = new HashMap();
    private String dsY;
    private JSONObject dsZ;
    private boolean dta;
    private boolean dtb;

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aGN() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aHi();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHi() {
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
        sA(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aHj() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aEU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cv(String str, String str2) {
        this.ddp.put(str, str2);
        return this;
    }

    public Map<String, String> aHk() {
        return this.ddp;
    }

    public void aHl() {
        this.dta = true;
    }

    public void aHm() {
        this.dtb = true;
    }

    protected void sA(String str) {
        int optInt;
        this.dsY = str;
        try {
            this.dsZ = new JSONObject(this.dsY);
            optInt = this.dsZ.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dta && optInt == 402) || (this.dtb && optInt == 401)) {
            this.dta = false;
            this.dtb = false;
            if (com.baidu.swan.apps.d.a.f.cqM.agP()) {
                com.baidu.swan.apps.d.a.f.cqM.agO();
            }
            sB(str);
        } else if (kj(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cqM.agP()) {
                com.baidu.swan.apps.d.a.f.cqM.agO();
                sB(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            Z(bO(this.dsZ));
            aHe();
            finish();
        }
    }

    private boolean kj(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sB(final String str) {
        aHj().aFh().a(com.baidu.swan.apps.v.f.axo().awY(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rE();
                    h.this.aGL();
                    return;
                }
                h.this.sA(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aHe() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aGM(), Integer.valueOf(this.drK.getErrorCode()), this.dsY, this.dsZ, this.drK.mData, this.drK.aHd());
    }
}
