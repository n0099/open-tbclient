package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity LR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbWebViewActivity tbWebViewActivity) {
        this.LR = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.LR.jsBridge;
        if (aVar != null) {
            aVar2 = this.LR.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
