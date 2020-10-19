package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cIK;
    private SwanEditText cIL;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b arR() {
        if (cIK == null) {
            synchronized (b.class) {
                if (cIK == null) {
                    cIK = new b();
                }
            }
        }
        return cIK;
    }

    public SwanEditText cf(Context context) {
        this.cIL = new SwanEditText(context);
        return this.cIL;
    }

    public SwanEditText arS() {
        return this.cIL;
    }

    public void arT() {
        this.cIL = null;
    }

    public TextWatcher arU() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
