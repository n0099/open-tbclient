package com.baidu.tbadk.browser;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements q {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.q
    public Object a(Activity activity) {
        return new TbJsBridge(activity);
    }
}
