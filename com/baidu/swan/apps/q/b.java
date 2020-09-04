package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cuD;
    private SwanEditText cuE;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b aov() {
        if (cuD == null) {
            synchronized (b.class) {
                if (cuD == null) {
                    cuD = new b();
                }
            }
        }
        return cuD;
    }

    public SwanEditText ca(Context context) {
        this.cuE = new SwanEditText(context);
        return this.cuE;
    }

    public SwanEditText aow() {
        return this.cuE;
    }

    public void aox() {
        this.cuE = null;
    }

    public TextWatcher aoy() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
