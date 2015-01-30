package com.baidu.tbadk.browser;

import android.app.Activity;
/* loaded from: classes.dex */
class k implements m {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.m
    public Object o(Activity activity) {
        return new TbJsBridge(activity);
    }
}
