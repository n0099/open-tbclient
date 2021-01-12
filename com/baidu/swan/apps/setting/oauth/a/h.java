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
    private String dIb;
    private JSONObject dIc;
    private boolean dId;
    private boolean dIe;
    private final Map<String, String> doN = new HashMap();

    protected abstract HttpRequest a(h hVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aKk() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.setting.oauth.b.DEBUG) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                h.this.aKF();
            }
        }, "OAuthRequest-onExec", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKF() {
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
        sb(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aKG() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aIr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h<ResultDataT> cz(String str, String str2) {
        this.doN.put(str, str2);
        return this;
    }

    public Map<String, String> aKH() {
        return this.doN;
    }

    public void aKI() {
        this.dId = true;
    }

    public void aKJ() {
        this.dIe = true;
    }

    protected void sb(String str) {
        int optInt;
        this.dIb = str;
        try {
            this.dIc = new JSONObject(this.dIb);
            optInt = this.dIc.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            w(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            w(new OAuthException(10005));
            com.baidu.swan.apps.statistic.h.b(10005, null);
        }
        if ((this.dId && optInt == 402) || (this.dIe && optInt == 401)) {
            this.dId = false;
            this.dIe = false;
            if (com.baidu.swan.apps.d.a.f.cBW.ajg()) {
                com.baidu.swan.apps.d.a.f.cBW.ajf();
            }
            sc(str);
        } else if (jn(optInt)) {
            if (com.baidu.swan.apps.d.a.f.cBW.ajg()) {
                com.baidu.swan.apps.d.a.f.cBW.ajf();
                sc(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            aa(bY(this.dIc));
            aKB();
            finish();
        }
    }

    private boolean jn(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void sc(final String str) {
        aKG().aIE().a(com.baidu.swan.apps.v.f.azN().azx(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.h.3
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    h.this.rh();
                    h.this.aKi();
                    return;
                }
                h.this.sb(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKB() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aKj(), Integer.valueOf(this.dGO.getErrorCode()), this.dIb, this.dIc, this.dGO.mData, this.dGO.aKA());
    }
}
