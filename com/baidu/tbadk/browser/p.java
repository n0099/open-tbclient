package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbWebViewActivity tbWebViewActivity) {
        this.MG = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.MG.jsBridge;
        if (aVar != null) {
            aVar2 = this.MG.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
