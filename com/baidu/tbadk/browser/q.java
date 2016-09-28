package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbWebViewActivity tbWebViewActivity) {
        this.MH = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.MH.jsBridge;
        if (aVar != null) {
            aVar2 = this.MH.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
