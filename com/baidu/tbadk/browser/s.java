package com.baidu.tbadk.browser;

import com.baidu.tbadk.plugins.BdBrowserDelegate;
/* loaded from: classes.dex */
class s implements BdBrowserDelegate.Callback {
    final /* synthetic */ WebBdActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WebBdActivity webBdActivity) {
        this.a = webBdActivity;
    }

    @Override // com.baidu.tbadk.plugins.BdBrowserDelegate.Callback
    public boolean shouldOverrideUrlLoading(String str) {
        return com.baidu.tbadk.c.e.a(this.a, str);
    }
}
