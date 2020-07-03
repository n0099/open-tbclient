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
    private String cJW;
    private JSONObject cJX;
    private boolean cJY;
    private boolean cJZ;
    private final Map<String, String> cwC = new HashMap();

    protected abstract HttpRequest a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void arA() {
        arR();
    }

    private void arR() {
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
        ou(body.string());
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aqk() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return apM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bR(String str, String str2) {
        this.cwC.put(str, str2);
        return this;
    }

    public Map<String, String> arS() {
        return this.cwC;
    }

    public void arT() {
        this.cJY = true;
    }

    public void arU() {
        this.cJZ = true;
    }

    protected void ou(String str) {
        int optInt;
        this.cJW = str;
        try {
            this.cJX = new JSONObject(this.cJW);
            optInt = this.cJX.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            s(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            s(new OAuthException(10005));
            h.b(10005, null);
        }
        if ((this.cJY && optInt == 402) || (this.cJZ && optInt == 401)) {
            this.cJY = false;
            this.cJZ = false;
            if (com.baidu.swan.apps.c.a.f.bNE.UP()) {
                com.baidu.swan.apps.c.a.f.bNE.UO();
            }
            ov(str);
        } else if (ha(optInt)) {
            if (com.baidu.swan.apps.c.a.f.bNE.UP()) {
                com.baidu.swan.apps.c.a.f.bNE.UO();
                ov(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            S(bo(this.cJX));
            arO();
            finish();
        }
    }

    private boolean ha(int i) {
        return i == 600101 || i == 600102 || i == 600103 || i == 402 || i == 401;
    }

    private void ov(final String str) {
        aqk().apZ().a(com.baidu.swan.apps.w.f.ajb().aiL(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pZ();
                    g.this.ary();
                    return;
                }
                g.this.ou(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arO() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), arz(), Integer.valueOf(this.cIN.getErrorCode()), this.cJW, this.cJX, this.cIN.mData, this.cIN.arN());
    }
}
