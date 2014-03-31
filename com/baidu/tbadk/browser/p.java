package com.baidu.tbadk.browser;

import com.baidu.tbadk.plugins.BdBrowserDelegate;
/* loaded from: classes.dex */
final class p implements BdBrowserDelegate.Callback {
    final /* synthetic */ WebBdActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WebBdActivity webBdActivity) {
        this.a = webBdActivity;
    }

    @Override // com.baidu.tbadk.plugins.BdBrowserDelegate.Callback
    public final boolean shouldOverrideUrlLoading(String str) {
        return com.baidu.tbadk.d.d.a(this.a, str);
    }
}
