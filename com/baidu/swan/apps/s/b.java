package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bsl;
    private SwanEditText bsm;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b QX() {
        if (bsl == null) {
            synchronized (b.class) {
                if (bsl == null) {
                    bsl = new b();
                }
            }
        }
        return bsl;
    }

    public SwanEditText ca(Context context) {
        this.bsm = new SwanEditText(context);
        return this.bsm;
    }

    public SwanEditText QY() {
        return this.bsm;
    }

    public void QZ() {
        this.bsm = null;
    }

    public TextWatcher Ra() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
