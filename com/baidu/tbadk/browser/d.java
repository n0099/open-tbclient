package com.baidu.tbadk.browser;

import android.app.Activity;
/* loaded from: classes.dex */
class d implements e {
    final /* synthetic */ BaseWebViewActivity Nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebViewActivity baseWebViewActivity) {
        this.Nl = baseWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.e
    public Object o(Activity activity) {
        return new TbJsBridge(activity);
    }
}
