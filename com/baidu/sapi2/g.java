package com.baidu.sapi2;

import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g extends WebAuthListener {
    final /* synthetic */ List a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ PassportSDK d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PassportSDK passportSDK, List list, String str, boolean z) {
        this.d = passportSDK;
        this.a = list;
        this.b = str;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(WebAuthResult webAuthResult) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(WebAuthResult webAuthResult) {
        this.a.add(webAuthResult);
        this.d.a(this.b + (this.b.indexOf("?") > 0 ? ETAG.ITEM_SEPARATOR : "?") + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.c);
    }
}
