package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
/* loaded from: classes.dex */
class d implements BaseWebViewActivity.a {
    final /* synthetic */ BaseWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseWebViewActivity baseWebViewActivity) {
        this.Sl = baseWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity.a
    public Object b(TbPageContext<?> tbPageContext) {
        return new TbJsBridge(tbPageContext);
    }
}
