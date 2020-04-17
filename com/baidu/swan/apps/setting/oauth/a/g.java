package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
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
    private final Map<String, String> ctk = new HashMap();
    private String ctl;
    private JSONObject ctm;
    private boolean ctn;
    private boolean cto;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void ams() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            k(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.ahf().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                g.this.mM(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e alj() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return akN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bu(String str, String str2) {
        this.ctk.put(str, str2);
        return this;
    }

    public Map<String, String> amJ() {
        return this.ctk;
    }

    public void amK() {
        this.ctn = true;
    }

    public void amL() {
        this.cto = true;
    }

    protected void mM(String str) {
        int optInt;
        this.ctl = str;
        try {
            this.ctm = new JSONObject(this.ctl);
            optInt = this.ctm.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            k(new OAuthException(10005));
        }
        if ((this.ctn && optInt == 402) || (this.cto && optInt == 401)) {
            this.ctn = false;
            this.cto = false;
            mN(str);
        } else if (gw(optInt)) {
            if (com.baidu.swan.apps.c.a.e.bAP.Re()) {
                com.baidu.swan.apps.c.a.e.bAP.Rd();
                mN(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            O(aY(this.ctm));
            amG();
            finish();
        }
    }

    private boolean gw(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void mN(final String str) {
        alj().akY().a(com.baidu.swan.apps.y.f.aeK().aev(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pC();
                    g.this.amq();
                    return;
                }
                g.this.mM(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amG() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), amr(), Integer.valueOf(this.csb.getErrorCode()), this.ctl, this.ctm, this.csb.mData, this.csb.amF());
    }
}
