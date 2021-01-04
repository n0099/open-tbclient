package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes9.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dhf;
    private SwanEditText dhg;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b aAd() {
        if (dhf == null) {
            synchronized (b.class) {
                if (dhf == null) {
                    dhf = new b();
                }
            }
        }
        return dhf;
    }

    public SwanEditText cT(Context context) {
        this.dhg = new SwanEditText(context);
        return this.dhg;
    }

    public SwanEditText aAe() {
        return this.dhg;
    }

    public void aAf() {
        this.dhg = null;
    }

    public TextWatcher aAg() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
