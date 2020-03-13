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
    private final Map<String, String> bUk = new HashMap();
    private String bUl;
    private JSONObject bUm;
    private boolean bUn;
    private boolean bUo;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void aek() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            k(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.YW().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                g.this.lA(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e adb() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return acF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bl(String str, String str2) {
        this.bUk.put(str, str2);
        return this;
    }

    public Map<String, String> aeB() {
        return this.bUk;
    }

    public void aeC() {
        this.bUn = true;
    }

    public void aeD() {
        this.bUo = true;
    }

    protected void lA(String str) {
        int optInt;
        this.bUl = str;
        try {
            this.bUm = new JSONObject(this.bUl);
            optInt = this.bUm.optInt("errno");
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            k(new OAuthException(10005));
        }
        if ((this.bUn && optInt == 402) || (this.bUo && optInt == 401)) {
            this.bUn = false;
            this.bUo = false;
            lB(str);
        } else if (gp(optInt)) {
            if (com.baidu.swan.apps.c.a.e.bco.Jp()) {
                com.baidu.swan.apps.c.a.e.bco.Jo();
                lB(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            N(aN(this.bUm));
            aey();
            finish();
        }
    }

    private boolean gp(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void lB(final String str) {
        adb().acQ().a(com.baidu.swan.apps.y.f.WS().WD(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kY();
                    g.this.aei();
                    return;
                }
                g.this.lA(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aey() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), aej(), Integer.valueOf(this.bTb.getErrorCode()), this.bUl, this.bUm, this.bTb.mData, this.bTb.aex());
    }
}
