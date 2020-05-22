package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes11.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cgd;
    private SwanEditText cge;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b aeE() {
        if (cgd == null) {
            synchronized (b.class) {
                if (cgd == null) {
                    cgd = new b();
                }
            }
        }
        return cgd;
    }

    public SwanEditText bQ(Context context) {
        this.cge = new SwanEditText(context);
        return this.cge;
    }

    public SwanEditText aeF() {
        return this.cge;
    }

    public void aeG() {
        this.cge = null;
    }

    public TextWatcher aeH() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
