package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bsZ;
    private SwanEditText bta;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b Rt() {
        if (bsZ == null) {
            synchronized (b.class) {
                if (bsZ == null) {
                    bsZ = new b();
                }
            }
        }
        return bsZ;
    }

    public SwanEditText ca(Context context) {
        this.bta = new SwanEditText(context);
        return this.bta;
    }

    public SwanEditText Ru() {
        return this.bta;
    }

    public void Rv() {
        this.bta = null;
    }

    public TextWatcher Rw() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
