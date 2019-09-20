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
    private final Map<String, String> aVJ = new HashMap();
    private String aVK;
    private JSONObject aVL;
    private boolean aVM;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void Nu() {
        Request a = a(this);
        if (a == null) {
            l(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.HR().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                        g.this.hp(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b My() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return Mh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> aA(String str, String str2) {
        this.aVJ.put(str, str2);
        return this;
    }

    public Map<String, String> NC() {
        return this.aVJ;
    }

    public void ND() {
        this.aVM = true;
    }

    protected void hp(String str) {
        this.aVK = str;
        try {
            this.aVL = new JSONObject(this.aVK);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            if (this.aVL == null) {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString() + " ,strResponse: " + str);
            } else {
                com.baidu.swan.apps.setting.oauth.c.az("OAuthRequest", "ex: " + e2.toString());
            }
            l(new OAuthException(e2, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE));
        }
        if (this.aVM && this.aVL.optInt("errno") == 402) {
            this.aVM = false;
            hq(str);
            return;
        }
        J(z(this.aVL));
        DT();
        finish();
    }

    private void hq(final String str) {
        My().Mm().a(com.baidu.swan.apps.w.e.GJ().Gv(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.pw();
                    g.this.Ns();
                    return;
                }
                g.this.hp(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DT() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Nt(), Integer.valueOf(this.aVa.getErrorCode()), this.aVK, this.aVL, this.aVa.mData, this.aVa.NB());
    }
}
