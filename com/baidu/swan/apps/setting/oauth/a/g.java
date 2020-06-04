package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
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
/* loaded from: classes11.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private String cFm;
    private JSONObject cFn;
    private boolean cFo;
    private boolean cFp;
    private final Map<String, String> crO = new HashMap();

    protected abstract HttpRequest a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aqu() {
        aqL();
    }

    private void aqL() {
        HttpRequest a = a(this);
        if (a != null) {
            a.executeAsync(new ResponseCallback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
        ol(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e apd() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aoF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bP(String str, String str2) {
        this.crO.put(str, str2);
        return this;
    }

    public Map<String, String> aqM() {
        return this.crO;
    }

    public void aqN() {
        this.cFo = true;
    }

    public void aqO() {
        this.cFp = true;
    }

    protected void ol(String str) {
        int optInt;
        this.cFm = str;
        try {
            this.cFn = new JSONObject(this.cFm);
            optInt = this.cFn.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            s(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            s(new OAuthException(10005));
            h.b(10005, null);
        }
        if ((this.cFo && optInt == 402) || (this.cFp && optInt == 401)) {
            this.cFo = false;
            this.cFp = false;
            if (com.baidu.swan.apps.c.a.f.bIQ.TJ()) {
                com.baidu.swan.apps.c.a.f.bIQ.TI();
            }
            om(str);
        } else if (gP(optInt)) {
            if (com.baidu.swan.apps.c.a.f.bIQ.TJ()) {
                com.baidu.swan.apps.c.a.f.bIQ.TI();
                om(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            S(bh(this.cFn));
            aqI();
            finish();
        }
    }

    private boolean gP(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void om(final String str) {
        apd().aoS().a(com.baidu.swan.apps.w.f.ahV().ahF(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pI();
                    g.this.aqs();
                    return;
                }
                g.this.ol(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqI() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aqt(), Integer.valueOf(this.cEd.getErrorCode()), this.cFm, this.cFn, this.cEd.mData, this.cEd.aqH());
    }
}
