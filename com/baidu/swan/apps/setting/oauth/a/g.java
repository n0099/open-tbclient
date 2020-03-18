package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> bUv = new HashMap();
    private String bUw;
    private JSONObject bUx;
    private boolean bUy;
    private boolean bUz;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aen() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            k(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.YZ().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.setting.oauth.c.c(iOException.toString(), false);
                g.this.k(new OAuthException(10002));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad response", true);
                    g.this.k(new OAuthException(10002));
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("empty response body", true);
                    g.this.k(new OAuthException(10001));
                    return;
                }
                g.this.lz(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e ade() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return acI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bk(String str, String str2) {
        this.bUv.put(str, str2);
        return this;
    }

    public Map<String, String> aeE() {
        return this.bUv;
    }

    public void aeF() {
        this.bUy = true;
    }

    public void aeG() {
        this.bUz = true;
    }

    protected void lz(String str) {
        int optInt;
        this.bUw = str;
        try {
            this.bUx = new JSONObject(this.bUw);
            optInt = this.bUx.optInt("errno");
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            k(new OAuthException(10005));
        }
        if ((this.bUy && optInt == 402) || (this.bUz && optInt == 401)) {
            this.bUy = false;
            this.bUz = false;
            lA(str);
        } else if (gp(optInt)) {
            if (com.baidu.swan.apps.c.a.e.bcB.Js()) {
                com.baidu.swan.apps.c.a.e.bcB.Jr();
                lA(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            N(aN(this.bUx));
            aeB();
            finish();
        }
    }

    private boolean gp(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void lA(final String str) {
        ade().acT().a(com.baidu.swan.apps.y.f.WV().WG(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kY();
                    g.this.ael();
                    return;
                }
                g.this.lz(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeB() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aem(), Integer.valueOf(this.bTm.getErrorCode()), this.bUw, this.bUx, this.bTm.mData, this.bTm.aeA());
    }
}
