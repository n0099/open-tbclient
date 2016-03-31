package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbWebViewActivity tbWebViewActivity) {
        this.PH = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.PH.jsBridge;
        if (aVar != null) {
            aVar2 = this.PH.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
