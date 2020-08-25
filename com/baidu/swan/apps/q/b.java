package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cuz;
    private SwanEditText cuA;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b aov() {
        if (cuz == null) {
            synchronized (b.class) {
                if (cuz == null) {
                    cuz = new b();
                }
            }
        }
        return cuz;
    }

    public SwanEditText ca(Context context) {
        this.cuA = new SwanEditText(context);
        return this.cuA;
    }

    public SwanEditText aow() {
        return this.cuA;
    }

    public void aox() {
        this.cuA = null;
    }

    public TextWatcher aoy() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
