package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class y extends HttpHandlerWrap {
    final /* synthetic */ SapiCallBack a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ SapiDataEncryptor e;
    final /* synthetic */ G f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(G g, Looper looper, SapiCallBack sapiCallBack, String str, String str2, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        super(looper);
        this.f = g;
        this.a = sapiCallBack;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = sapiDataEncryptor;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        if (i == -201) {
            this.a.onNetworkFailed();
        } else {
            this.a.onSystemError(i);
        }
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        super.onSuccess(i, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cert");
            this.f.a(this.a, optString, jSONObject.optString("cert_id"), this.b, this.c, this.d, this.e);
        } catch (Exception e) {
            this.f.a(-100, this.a, str, this.d, this.e);
            Log.e(e);
        }
    }
}
