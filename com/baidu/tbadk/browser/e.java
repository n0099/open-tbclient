package com.baidu.tbadk.browser;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
/* loaded from: classes.dex */
class e implements BaseWebViewActivity.a {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity.a
    public Object b(TbPageContext<?> tbPageContext) {
        return new TbJsBridge(tbPageContext);
    }
}
