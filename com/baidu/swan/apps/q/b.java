package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ckR;
    private SwanEditText ckS;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b afK() {
        if (ckR == null) {
            synchronized (b.class) {
                if (ckR == null) {
                    ckR = new b();
                }
            }
        }
        return ckR;
    }

    public SwanEditText bR(Context context) {
        this.ckS = new SwanEditText(context);
        return this.ckS;
    }

    public SwanEditText afL() {
        return this.ckS;
    }

    public void afM() {
        this.ckS = null;
    }

    public TextWatcher afN() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
