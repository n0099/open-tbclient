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
/* loaded from: classes8.dex */
public abstract class h<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private String dLG;
    private JSONObject dLH;
    private boolean dLI;
    private boolean dLJ;
    private final Map<String, String> dsB = new HashMap();

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aKG() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aLb();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLb() {
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
                    com.baidu.swan.apps.setting.oauth.c.d(exc.toString(), false);
                    h.this.w(new OAuthException(10002));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Response response) throws IOException {
        if (!response.isSuccessful()) {
            com.baidu.swan.apps.setting.oauth.c.d("bad response", true);
            w(new OAuthException(10002));
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            com.baidu.swan.apps.setting.oauth.c.d("empty response body", true);
            w(new OAuthException(10001));
            return;
        }
        sC(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aLc() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aIN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> ct(String str, String str2) {
        this.dsB.put(str, str2);
        return this;
    }

    public Map<String, String> aLd() {
        return this.dsB;
    }

    public void aLe() {
        this.dLI = true;
    }

    public void aLf() {
        this.dLJ = true;
    }

    protected void sC(String str) {
        int optInt;
        this.dLG = str;
        try {
            this.dLH = new JSONObject(this.dLG);
            optInt = this.dLH.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            w(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.d(e2.toString(), true);
            w(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dLI && optInt == 402) || (this.dLJ && optInt == 401)) {
            this.dLI = false;
            this.dLJ = false;
            if (com.baidu.swan.apps.d.a.f.cFS.ajH()) {
                com.baidu.swan.apps.d.a.f.cFS.ajG();
            }
            sD(str);
        } else if (jr(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cFS.ajH()) {
                com.baidu.swan.apps.d.a.f.cFS.ajG();
                sD(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            ac(bX(this.dLH));
            aKX();
            finish();
        }
    }

    private boolean jr(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sD(final String str) {
        aLc().aJa().a(com.baidu.swan.apps.v.f.aAo().azY(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rf();
                    h.this.aKE();
                    return;
                }
                h.this.sC(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKX() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aKF(), Integer.valueOf(this.dKt.getErrorCode()), this.dLG, this.dLH, this.dKt.mData, this.dKt.aKW());
    }
}
