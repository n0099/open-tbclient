package com.baidu.swan.apps.setting.oauth.a;

import android.support.annotation.NonNull;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
/* loaded from: classes2.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> aVl = new HashMap();
    private String aVm;
    private JSONObject aVn;
    private boolean aVo;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void Nq() {
        Request a = a(this);
        if (a == null) {
            l(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.HN().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    g.this.l(new OAuthException(iOException, 10002));
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        g.this.l(new OAuthException("bad response", 10002));
                        return;
                    }
                    ResponseBody body = response.body();
                    if (body == null) {
                        g.this.l(new OAuthException("empty response body", 10002));
                    } else {
                        g.this.hn(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b Mu() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return Md;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> aA(String str, String str2) {
        this.aVl.put(str, str2);
        return this;
    }

    public Map<String, String> Ny() {
        return this.aVl;
    }

    public void Nz() {
        this.aVo = true;
    }

    protected void hn(String str) {
        this.aVm = str;
        try {
            this.aVn = new JSONObject(this.aVm);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            if (this.aVn == null) {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString() + " ,strResponse: " + str);
            } else {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString());
            }
            l(new OAuthException(e2, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
        }
        if (this.aVo && this.aVn.optInt("errno") == 402) {
            this.aVo = false;
            ho(str);
            return;
        }
        J(z(this.aVn));
        DP();
        finish();
    }

    private void ho(final String str) {
        Mu().Mi().a(com.baidu.swan.apps.w.e.GF().Gr(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pv();
                    g.this.No();
                    return;
                }
                g.this.hn(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DP() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Np(), Integer.valueOf(this.aUC.getErrorCode()), this.aVm, this.aVn, this.aUC.mData, this.aUC.Nx());
    }
}
