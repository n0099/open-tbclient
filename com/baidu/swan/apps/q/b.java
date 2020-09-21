package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes3.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cwE;
    private SwanEditText cwF;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b apf() {
        if (cwE == null) {
            synchronized (b.class) {
                if (cwE == null) {
                    cwE = new b();
                }
            }
        }
        return cwE;
    }

    public SwanEditText bZ(Context context) {
        this.cwF = new SwanEditText(context);
        return this.cwF;
    }

    public SwanEditText apg() {
        return this.cwF;
    }

    public void aph() {
        this.cwF = null;
    }

    public TextWatcher apj() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
