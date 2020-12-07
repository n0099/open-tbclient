package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes25.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dcl;
    private SwanEditText dcm;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b ayM() {
        if (dcl == null) {
            synchronized (b.class) {
                if (dcl == null) {
                    dcl = new b();
                }
            }
        }
        return dcl;
    }

    public SwanEditText cL(Context context) {
        this.dcm = new SwanEditText(context);
        return this.dcm;
    }

    public SwanEditText ayN() {
        return this.dcm;
    }

    public void ayO() {
        this.dcm = null;
    }

    public TextWatcher ayP() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
