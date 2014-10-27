package com.baidu.tbadk.browser;

import com.baidu.tbadk.plugins.BdBrowserDelegate;
/* loaded from: classes.dex */
class r implements BdBrowserDelegate.Callback {
    final /* synthetic */ WebBdActivity xF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(WebBdActivity webBdActivity) {
        this.xF = webBdActivity;
    }

    @Override // com.baidu.tbadk.plugins.BdBrowserDelegate.Callback
    public boolean shouldOverrideUrlLoading(String str) {
        return com.baidu.tbadk.util.i.r(this.xF, str);
    }
}
