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
/* loaded from: classes3.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> cIN = new HashMap();
    private String cYn;
    private JSONObject cYo;
    private boolean cYp;
    private boolean cYq;

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aCk() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aCF();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCF() {
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
        ru(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aCG() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aAr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cj(String str, String str2) {
        this.cIN.put(str, str2);
        return this;
    }

    public Map<String, String> aCH() {
        return this.cIN;
    }

    public void aCI() {
        this.cYp = true;
    }

    public void aCJ() {
        this.cYq = true;
    }

    protected void ru(String str) {
        int optInt;
        this.cYn = str;
        try {
            this.cYo = new JSONObject(this.cYn);
            optInt = this.cYo.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            v(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            v(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.cYp && optInt == 402) || (this.cYq && optInt == 401)) {
            this.cYp = false;
            this.cYq = false;
            if (com.baidu.swan.apps.d.a.f.bVX.acj()) {
                com.baidu.swan.apps.d.a.f.bVX.aci();
            }
            rv(str);
        } else if (jB(optInt)) {
            if (com.baidu.swan.apps.d.a.f.bVX.acj()) {
                com.baidu.swan.apps.d.a.f.bVX.aci();
                rv(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            W(bE(this.cYo));
            aCB();
            finish();
        }
    }

    private boolean jB(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void rv(final String str) {
        aCG().aAE().a(com.baidu.swan.apps.v.f.asJ().ast(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rE();
                    h.this.aCi();
                    return;
                }
                h.this.ru(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCB() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aCj(), Integer.valueOf(this.cXa.getErrorCode()), this.cYn, this.cYo, this.cXa.mData, this.cXa.aCA());
    }
}
