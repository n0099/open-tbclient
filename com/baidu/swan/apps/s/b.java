package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bVC;
    private SwanEditText bVD;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b abB() {
        if (bVC == null) {
            synchronized (b.class) {
                if (bVC == null) {
                    bVC = new b();
                }
            }
        }
        return bVC;
    }

    public SwanEditText bR(Context context) {
        this.bVD = new SwanEditText(context);
        return this.bVD;
    }

    public SwanEditText abC() {
        return this.bVD;
    }

    public void abD() {
        this.bVD = null;
    }

    public TextWatcher abE() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
