package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
/* loaded from: classes6.dex */
class e implements com.baidu.sapi2.callback.a.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.sapi2.callback.a.b
    public void a(String str, String str2) {
        Context context;
        f fVar = this.a;
        if (fVar.c) {
            Intent intent = new Intent(fVar.d, LoadExternalWebViewActivity.class);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
            String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
            if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                str3 = str3 + "&liveAbility=1";
            }
            intent.putExtra("extra_external_url", str3);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
            Context context2 = this.a.d;
            if (context2 instanceof Activity) {
                context2.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            context = this.a.e.E;
            context.startActivity(intent);
            return;
        }
        new com.baidu.sapi2.outsdk.c().a(this.a.a, -111, (String) null);
    }
}
