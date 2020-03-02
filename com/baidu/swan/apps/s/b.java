package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bxk;
    private SwanEditText bxl;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b TJ() {
        if (bxk == null) {
            synchronized (b.class) {
                if (bxk == null) {
                    bxk = new b();
                }
            }
        }
        return bxk;
    }

    public SwanEditText ce(Context context) {
        this.bxl = new SwanEditText(context);
        return this.bxl;
    }

    public SwanEditText TK() {
        return this.bxl;
    }

    public void TL() {
        this.bxl = null;
    }

    public TextWatcher TM() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
