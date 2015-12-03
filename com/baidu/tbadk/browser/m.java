package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity Su;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.Su = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.Su.jsBridge;
        if (aVar != null) {
            aVar2 = this.Su.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
