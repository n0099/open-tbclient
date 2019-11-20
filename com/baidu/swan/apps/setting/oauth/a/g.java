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
    private final Map<String, String> bov = new HashMap();
    private String bow;
    private JSONObject box;
    private boolean boy;

    protected abstract Request a(g gVar);

    @Override // com.baidu.swan.apps.setting.oauth.b
    protected void Sm() {
        Request a = a(this);
        if (a == null) {
            k(new OAuthException("bad request", 10002));
        } else {
            com.baidu.swan.apps.setting.oauth.c.MM().newCall(a).enqueue(new Callback() { // from class: com.baidu.swan.apps.setting.oauth.a.g.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    g.this.k(new OAuthException(iOException, 10002));
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        g.this.k(new OAuthException("bad response", 10002));
                        return;
                    }
                    ResponseBody body = response.body();
                    if (body == null) {
                        g.this.k(new OAuthException("empty response body", 10002));
                    } else {
                        g.this.hS(body.string());
                    }
                }
            });
        }
    }

    @NonNull
    public com.baidu.swan.apps.ae.b Rs() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            throw new IllegalStateException("null SwanApp");
        }
        return Ra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g<ResultDataT> aI(String str, String str2) {
        this.bov.put(str, str2);
        return this;
    }

    public Map<String, String> Su() {
        return this.bov;
    }

    public void Sv() {
        this.boy = true;
    }

    protected void hS(String str) {
        this.bow = str;
        try {
            this.box = new JSONObject(this.bow);
        } catch (OAuthException e) {
            k(e);
        } catch (Exception e2) {
            if (this.box == null) {
                com.baidu.swan.apps.setting.oauth.c.aH("OAuthRequest", "ex: " + e2.toString() + " ,strResponse: " + str);
            } else {
                com.baidu.swan.apps.setting.oauth.c.aH("OAuthRequest", "ex: " + e2.toString());
            }
            k(new OAuthException(e2, 11001));
        }
        if (this.boy && this.box.optInt("errno") == 402) {
            this.boy = false;
            hT(str);
            return;
        }
        H(Y(this.box));
        IO();
        finish();
    }

    private void hT(final String str) {
        Rs().Rg().a(com.baidu.swan.apps.w.e.LE().Lq(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.oauth.a.g.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (i == 0) {
                    g.this.kr();
                    g.this.Sk();
                    return;
                }
                g.this.hS(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IO() {
    }

    public String toString() {
        return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), Sl(), Integer.valueOf(this.bnM.getErrorCode()), this.bow, this.box, this.bnM.mData, this.bnM.St());
    }
}
