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
    private final Map<String, String> aRM = new HashMap();
    private String aRN;
    private JSONObject aRO;
    private boolean aRP;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void Kc() {
        Request a = a(this);
        if (a == null) {
            l(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.EX().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                        g.this.gM(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b Jl() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return IV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> ay(String str, String str2) {
        this.aRM.put(str, str2);
        return this;
    }

    public Map<String, String> Kj() {
        return this.aRM;
    }

    public void Kk() {
        this.aRP = true;
    }

    protected void gM(String str) {
        this.aRN = str;
        try {
            this.aRO = new JSONObject(this.aRN);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            l(new OAuthException(e2, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
        }
        if (this.aRP && this.aRO.optInt("errno") == 402) {
            this.aRP = false;
            gN(str);
            return;
        }
        J(C(this.aRO));
        Ce();
        finish();
    }

    private void gN(final String str) {
        Jl().Ja().a(com.baidu.swan.apps.w.e.Ea().DM(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.qf();
                    g.this.Ka();
                    return;
                }
                g.this.gM(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ce() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Kb(), Integer.valueOf(this.aRd.getErrorCode()), this.aRN, this.aRO, this.aRd.mData, this.aRd.Ki());
    }
}
