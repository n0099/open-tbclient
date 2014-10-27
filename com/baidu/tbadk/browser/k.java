package com.baidu.tbadk.browser;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements p {
    final /* synthetic */ TbWebViewActivity xA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbWebViewActivity tbWebViewActivity) {
        this.xA = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.p
    public Object g(Activity activity) {
        return new TbJsBridge(activity);
    }
}
