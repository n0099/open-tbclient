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
/* loaded from: classes9.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> bPt = new HashMap();
    private String bPu;
    private JSONObject bPv;
    private boolean bPw;
    private boolean bPx;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void abx() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            k(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.Wj().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                g.this.li(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e aao() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return ZS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bb(String str, String str2) {
        this.bPt.put(str, str2);
        return this;
    }

    public Map<String, String> abO() {
        return this.bPt;
    }

    public void abP() {
        this.bPw = true;
    }

    public void abQ() {
        this.bPx = true;
    }

    protected void li(String str) {
        int optInt;
        this.bPu = str;
        try {
            this.bPv = new JSONObject(this.bPu);
            optInt = this.bPv.optInt("errno");
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            k(new OAuthException(10005));
        }
        if ((this.bPw && optInt == 402) || (this.bPx && optInt == 401)) {
            this.bPw = false;
            this.bPx = false;
            lj(str);
        } else if (fX(optInt)) {
            if (com.baidu.swan.apps.c.a.e.aXk.GC()) {
                com.baidu.swan.apps.c.a.e.aXk.GB();
                lj(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            L(aN(this.bPv));
            abL();
            finish();
        }
    }

    private boolean fX(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void lj(final String str) {
        aao().aad().a(com.baidu.swan.apps.y.f.Uf().TQ(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kI();
                    g.this.abv();
                    return;
                }
                g.this.li(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abL() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), abw(), Integer.valueOf(this.bOk.getErrorCode()), this.bPu, this.bPv, this.bOk.mData, this.bOk.abK());
    }
}
