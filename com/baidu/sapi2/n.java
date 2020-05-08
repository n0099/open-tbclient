package com.baidu.sapi2;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class n implements SapiCallback<SapiResult> {
    final /* synthetic */ int a;
    final /* synthetic */ ExtendSysWebViewMethodCallback b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ ExtendSysWebViewMethodResult d;
    final /* synthetic */ Context e;
    final /* synthetic */ PassportSDK f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PassportSDK passportSDK, int i, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, Context context) {
        this.f = passportSDK;
        this.a = i;
        this.b = extendSysWebViewMethodCallback;
        this.c = jSONObject;
        this.d = extendSysWebViewMethodResult;
        this.e = context;
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(SapiResult sapiResult) {
        this.d.setResultCode(sapiResult.getResultCode());
        this.d.setResultMsg(sapiResult.getResultMsg());
        this.b.onFinish(this.d);
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(SapiResult sapiResult) {
        int i = this.a;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.f.a(this.b, this.c, i, this.d);
                return;
            case 5:
                this.f.z = this.b;
                String optString = this.c.optString("url");
                String optString2 = this.c.optString("title");
                Intent intent = new Intent(this.e, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, optString2);
                intent.putExtra("extra_external_url", optString);
                intent.setFlags(268435456);
                this.e.startActivity(intent);
                return;
            case 6:
                JSONArray optJSONArray = this.c.optJSONArray("di_keys");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i2))) {
                        arrayList.add(optJSONArray.optString(i2));
                    }
                }
                String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                this.d.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                this.d.params.put("result", diCookieInfo);
                this.b.onFinish(this.d);
                return;
            default:
                this.d.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                this.d.params.put("retMsg", "action :" + this.a + " is not support");
                this.b.onFinish(this.d);
                return;
        }
    }
}
