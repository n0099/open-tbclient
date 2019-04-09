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
    private final Map<String, String> aRN = new HashMap();
    private String aRO;
    private JSONObject aRP;
    private boolean aRQ;

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
        this.aRN.put(str, str2);
        return this;
    }

    public Map<String, String> Kj() {
        return this.aRN;
    }

    public void Kk() {
        this.aRQ = true;
    }

    protected void gM(String str) {
        this.aRO = str;
        try {
            this.aRP = new JSONObject(this.aRO);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            l(new OAuthException(e2, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
        }
        if (this.aRQ && this.aRP.optInt("errno") == 402) {
            this.aRQ = false;
            gN(str);
            return;
        }
        J(C(this.aRP));
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
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Kb(), Integer.valueOf(this.aRe.getErrorCode()), this.aRO, this.aRP, this.aRe.mData, this.aRe.Ki());
    }
}
