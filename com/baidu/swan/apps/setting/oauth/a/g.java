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
/* loaded from: classes2.dex */
public abstract class g<ResultDataT> extends com.baidu.swan.apps.setting.oauth.b<ResultDataT> {
    private final Map<String, String> boN = new HashMap();
    private String boO;
    private JSONObject boP;
    private boolean boQ;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void Sk() {
        Request a = a(this);
        if (a == null) {
            l(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.ML().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
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
                        g.this.hS(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b Rq() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return QZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> aI(String str, String str2) {
        this.boN.put(str, str2);
        return this;
    }

    public Map<String, String> Ss() {
        return this.boN;
    }

    public void St() {
        this.boQ = true;
    }

    protected void hS(String str) {
        this.boO = str;
        try {
            this.boP = new JSONObject(this.boO);
        } catch (OAuthException e) {
            l(e);
        } catch (Exception e2) {
            if (this.boP == null) {
                com.baidu.swan.apps.setting.oauth.c.aH("OAuthRequest", "ex: " + e2.toString() + " ,strResponse: " + str);
            } else {
                com.baidu.swan.apps.setting.oauth.c.aH("OAuthRequest", "ex: " + e2.toString());
            }
            l(new OAuthException(e2, 11001));
        }
        if (this.boQ && this.boP.optInt("errno") == 402) {
            this.boQ = false;
            hT(str);
            return;
        }
        H(X(this.boP));
        IN();
        finish();
    }

    private void hT(final String str) {
        Rq().Re().a(com.baidu.swan.apps.w.e.LD().Lp(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kr();
                    g.this.Si();
                    return;
                }
                g.this.hS(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IN() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Sj(), Integer.valueOf(this.boe.getErrorCode()), this.boO, this.boP, this.boe.mData, this.boe.Sr());
    }
}
