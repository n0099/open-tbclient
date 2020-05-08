package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bVI;
    private SwanEditText bVJ;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b abA() {
        if (bVI == null) {
            synchronized (b.class) {
                if (bVI == null) {
                    bVI = new b();
                }
            }
        }
        return bVI;
    }

    public SwanEditText bF(Context context) {
        this.bVJ = new SwanEditText(context);
        return this.bVJ;
    }

    public SwanEditText abB() {
        return this.bVJ;
    }

    public void abC() {
        this.bVJ = null;
    }

    public TextWatcher abD() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
