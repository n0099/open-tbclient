package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbWebViewActivity tbWebViewActivity) {
        this.Kx = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.Kx.jsBridge;
        if (aVar != null) {
            aVar2 = this.Kx.jsBridge;
            return aVar2.b(str, jsPromptResult);
        }
        return false;
    }
}
