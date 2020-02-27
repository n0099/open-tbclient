package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class I implements SapiCallback<OAuthResult> {
    final /* synthetic */ Map a;
    final /* synthetic */ SapiAccount b;
    final /* synthetic */ SapiAccountService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(SapiAccountService sapiAccountService, Map map, SapiAccount sapiAccount) {
        this.c = sapiAccountService;
        this.a = map;
        this.b = sapiAccount;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: a */
    public void onFailure(OAuthResult oAuthResult) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: b */
    public void onSuccess(OAuthResult oAuthResult) {
        SapiConfiguration sapiConfiguration;
        if (TextUtils.isEmpty(oAuthResult.openid)) {
            return;
        }
        this.a.put(oAuthResult.openid, this.b.uid);
        sapiConfiguration = this.c.b;
        SapiContext.getInstance(sapiConfiguration.context).put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(this.a, false));
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }
}
