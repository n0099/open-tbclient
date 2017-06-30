package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbWebViewActivity tbWebViewActivity) {
        this.Qm = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.Qm.jsBridge;
        if (aVar != null) {
            aVar2 = this.Qm.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
