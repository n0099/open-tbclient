package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bxj;
    private SwanEditText bxk;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b TH() {
        if (bxj == null) {
            synchronized (b.class) {
                if (bxj == null) {
                    bxj = new b();
                }
            }
        }
        return bxj;
    }

    public SwanEditText ce(Context context) {
        this.bxk = new SwanEditText(context);
        return this.bxk;
    }

    public SwanEditText TI() {
        return this.bxk;
    }

    public void TJ() {
        this.bxk = null;
    }

    public TextWatcher TK() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
