package com.baidu.browser.webkit;

import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
public class BdJsPromptResult {
    private JsPromptResult mSysJsPromptResult;
    private com.baidu.zeus.JsPromptResult mZeusJsPromptResult;

    public BdJsPromptResult(JsPromptResult jsPromptResult) {
        this.mSysJsPromptResult = jsPromptResult;
    }

    public BdJsPromptResult(com.baidu.zeus.JsPromptResult jsPromptResult) {
        this.mZeusJsPromptResult = jsPromptResult;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdJsPromptResult) && unwrap() == ((BdJsPromptResult) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusJsPromptResult != null ? this.mZeusJsPromptResult.hashCode() : this.mSysJsPromptResult.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusJsPromptResult != null ? this.mZeusJsPromptResult == obj : this.mSysJsPromptResult == obj;
    }

    public Object unwrap() {
        return this.mZeusJsPromptResult != null ? this.mZeusJsPromptResult : this.mSysJsPromptResult;
    }

    public final void cancel() {
        if (this.mZeusJsPromptResult != null) {
            this.mZeusJsPromptResult.cancel();
        } else {
            this.mSysJsPromptResult.cancel();
        }
    }

    public final void confirm() {
        if (this.mZeusJsPromptResult != null) {
            this.mZeusJsPromptResult.confirm();
        } else {
            this.mSysJsPromptResult.confirm();
        }
    }
}
