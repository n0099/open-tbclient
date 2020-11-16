package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes7.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cVp;
    private SwanEditText cVq;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b avE() {
        if (cVp == null) {
            synchronized (b.class) {
                if (cVp == null) {
                    cVp = new b();
                }
            }
        }
        return cVp;
    }

    public SwanEditText cf(Context context) {
        this.cVq = new SwanEditText(context);
        return this.cVq;
    }

    public SwanEditText avF() {
        return this.cVq;
    }

    public void avG() {
        this.cVq = null;
    }

    public TextWatcher avH() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
