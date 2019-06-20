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
    private final Map<String, String> aUB = new HashMap();
    private String aUC;
    private JSONObject aUD;
    private boolean aUE;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void MC() {
        Request a = a(this);
        if (a == null) {
            l(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.Hc().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                        g.this.hg(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b LG() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return Lq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> aA(String str, String str2) {
        this.aUB.put(str, str2);
        return this;
    }

    public Map<String, String> MJ() {
        return this.aUB;
    }

    public void MK() {
        this.aUE = true;
    }

    protected void hg(String str) {
        this.aUC = str;
        try {
            this.aUD = new JSONObject(this.aUC);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            if (this.aUD == null) {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString() + " ,strResponse: " + str);
            } else {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString());
            }
            l(new OAuthException(e2, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
        }
        if (this.aUE && this.aUD.optInt("errno") == 402) {
            this.aUE = false;
            hh(str);
            return;
        }
        J(z(this.aUD));
        Dg();
        finish();
    }

    private void hh(final String str) {
        LG().Lv().a(com.baidu.swan.apps.w.e.FV().FH(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pa();
                    g.this.MA();
                    return;
                }
                g.this.hg(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dg() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), MB(), Integer.valueOf(this.aTS.getErrorCode()), this.aUC, this.aUD, this.aTS.mData, this.aTS.MI());
    }
}
