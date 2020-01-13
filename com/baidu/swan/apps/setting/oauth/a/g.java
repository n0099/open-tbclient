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
/* loaded from: classes10.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> bQd = new HashMap();
    private String bQe;
    private JSONObject bQf;
    private boolean bQg;
    private boolean bQh;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void abU() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            k(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.WG().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                g.this.ll(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aaL() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return aap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bc(String str, String str2) {
        this.bQd.put(str, str2);
        return this;
    }

    public Map<String, String> acl() {
        return this.bQd;
    }

    public void acm() {
        this.bQg = true;
    }

    public void acn() {
        this.bQh = true;
    }

    protected void ll(String str) {
        int optInt;
        this.bQe = str;
        try {
            this.bQf = new JSONObject(this.bQe);
            optInt = this.bQf.optInt("errno");
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            k(new OAuthException(10005));
        }
        if ((this.bQg && optInt == 402) || (this.bQh && optInt == 401)) {
            this.bQg = false;
            this.bQh = false;
            lm(str);
        } else if (fY(optInt)) {
            if (com.baidu.swan.apps.c.a.e.aYc.GY()) {
                com.baidu.swan.apps.c.a.e.aYc.GX();
                lm(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            L(aN(this.bQf));
            aci();
            finish();
        }
    }

    private boolean fY(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void lm(final String str) {
        aaL().aaA().a(com.baidu.swan.apps.y.f.UC().Un(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kJ();
                    g.this.abS();
                    return;
                }
                g.this.ll(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aci() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), abT(), Integer.valueOf(this.bOU.getErrorCode()), this.bQe, this.bQf, this.bOU.mData, this.bOU.ach());
    }
}
