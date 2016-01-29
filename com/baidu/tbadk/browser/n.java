package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Sl = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.Sl.jsBridge;
        if (aVar != null) {
            aVar2 = this.Sl.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
