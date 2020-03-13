package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bxl;
    private SwanEditText bxm;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b TJ() {
        if (bxl == null) {
            synchronized (b.class) {
                if (bxl == null) {
                    bxl = new b();
                }
            }
        }
        return bxl;
    }

    public SwanEditText ce(Context context) {
        this.bxm = new SwanEditText(context);
        return this.bxm;
    }

    public SwanEditText TK() {
        return this.bxm;
    }

    public void TL() {
        this.bxm = null;
    }

    public TextWatcher TM() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
