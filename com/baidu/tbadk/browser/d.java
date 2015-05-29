package com.baidu.tbadk.browser;

import android.app.Activity;
/* loaded from: classes.dex */
class d implements e {
    final /* synthetic */ BaseWebViewActivity NB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebViewActivity baseWebViewActivity) {
        this.NB = baseWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.e
    public Object o(Activity activity) {
        return new TbJsBridge(activity);
    }
}
