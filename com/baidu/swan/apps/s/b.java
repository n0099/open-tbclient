package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bxw;
    private SwanEditText bxx;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b TM() {
        if (bxw == null) {
            synchronized (b.class) {
                if (bxw == null) {
                    bxw = new b();
                }
            }
        }
        return bxw;
    }

    public SwanEditText cd(Context context) {
        this.bxx = new SwanEditText(context);
        return this.bxx;
    }

    public SwanEditText TN() {
        return this.bxx;
    }

    public void TO() {
        this.bxx = null;
    }

    public TextWatcher TP() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
