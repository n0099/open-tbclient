package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b deE;
    private SwanEditText deF;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b awI() {
        if (deE == null) {
            synchronized (b.class) {
                if (deE == null) {
                    deE = new b();
                }
            }
        }
        return deE;
    }

    public SwanEditText cR(Context context) {
        this.deF = new SwanEditText(context);
        return this.deF;
    }

    public SwanEditText awJ() {
        return this.deF;
    }

    public void awK() {
        this.deF = null;
    }

    public TextWatcher awL() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
