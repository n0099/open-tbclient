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
    private final Map<String, String> ctq = new HashMap();
    private String ctr;
    private JSONObject cts;
    private boolean ctt;
    private boolean ctu;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void amr() {
        Request a = a(this);
        if (a == null) {
            com.baidu.swan.apps.setting.oauth.c.c("request is null", true);
            l(new OAuthException(10002));
            return;
        }
        com.baidu.swan.apps.setting.oauth.c.ahe().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                com.baidu.swan.apps.setting.oauth.c.c(iOException.toString(), false);
                g.this.l(new OAuthException(10002));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    com.baidu.swan.apps.setting.oauth.c.c("bad response", true);
                    g.this.l(new OAuthException(10002));
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    com.baidu.swan.apps.setting.oauth.c.c("empty response body", true);
                    g.this.l(new OAuthException(10001));
                    return;
                }
                g.this.mM(body.string());
            }
        });
    }

    @NonNull
    public com.baidu.swan.apps.runtime.e ali() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return akM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> bu(String str, String str2) {
        this.ctq.put(str, str2);
        return this;
    }

    public Map<String, String> amI() {
        return this.ctq;
    }

    public void amJ() {
        this.ctt = true;
    }

    public void amK() {
        this.ctu = true;
    }

    protected void mM(String str) {
        int optInt;
        this.ctr = str;
        try {
            this.cts = new JSONObject(this.ctr);
            optInt = this.cts.optInt(BaseJsonData.TAG_ERRNO);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            com.baidu.swan.apps.setting.oauth.c.c(e2.toString(), true);
            l(new OAuthException(10005));
        }
        if ((this.ctt && optInt == 402) || (this.ctu && optInt == 401)) {
            this.ctt = false;
            this.ctu = false;
            mN(str);
        } else if (gw(optInt)) {
            if (com.baidu.swan.apps.c.a.e.bAU.Rd()) {
                com.baidu.swan.apps.c.a.e.bAU.Rc();
                mN(str);
            } else if (DEBUG) {
                throw new RuntimeException("is not AllianceLogin, error number");
            }
        } else {
            P(aY(this.cts));
            amF();
            finish();
        }
    }

    private boolean gw(int i) {
        return i == 600101 || i == 600102 || i == 600103;
    }

    private void mN(final String str) {
        ali().akX().a(com.baidu.swan.apps.y.f.aeJ().aeu(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pC();
                    g.this.amp();
                    return;
                }
                g.this.mM(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amF() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), amq(), Integer.valueOf(this.csh.getErrorCode()), this.ctr, this.cts, this.csh.mData, this.csh.amE());
    }
}
