package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class D extends HttpHandlerWrap {
    final /* synthetic */ SapiCallBack a;
    final /* synthetic */ boolean b;
    final /* synthetic */ SapiDataEncryptor c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ L f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(L l, Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
        super(looper);
        this.f = l;
        this.a = sapiCallBack;
        this.b = z;
        this.c = sapiDataEncryptor;
        this.d = str;
        this.e = str2;
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
        if (!TextUtils.isEmpty(str)) {
            this.f.a(-100, this.a, str, this.b, this.c);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cert");
            this.f.a(this.a, optString, jSONObject.optString("cert_id"), this.d, this.e, this.b, this.c);
        } catch (Exception e) {
            this.f.a(-100, this.a, str, this.b, this.c);
            Log.e(e);
        }
    }
}
