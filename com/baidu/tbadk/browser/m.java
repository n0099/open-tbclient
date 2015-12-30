package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.tbadkCore.e.c {
    final /* synthetic */ TbWebViewActivity SS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.SS = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.c
    public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        aVar = this.SS.jsBridge;
        if (aVar != null) {
            aVar2 = this.SS.jsBridge;
            return aVar2.a(str, jsPromptResult);
        }
        return false;
    }
}
