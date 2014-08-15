package com.baidu.tbadk.browser;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements u {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.u
    public Object a(Activity activity) {
        return new TbJsBridge(activity);
    }
}
