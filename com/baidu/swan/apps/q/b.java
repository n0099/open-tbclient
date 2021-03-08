package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dgf;
    private SwanEditText dgg;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b awL() {
        if (dgf == null) {
            synchronized (b.class) {
                if (dgf == null) {
                    dgf = new b();
                }
            }
        }
        return dgf;
    }

    public SwanEditText cQ(Context context) {
        this.dgg = new SwanEditText(context);
        return this.dgg;
    }

    public SwanEditText awM() {
        return this.dgg;
    }

    public void awN() {
        this.dgg = null;
    }

    public TextWatcher awO() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
