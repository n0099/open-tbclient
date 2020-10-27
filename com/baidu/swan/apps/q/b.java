package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cRg;
    private SwanEditText cRh;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b atM() {
        if (cRg == null) {
            synchronized (b.class) {
                if (cRg == null) {
                    cRg = new b();
                }
            }
        }
        return cRg;
    }

    public SwanEditText cf(Context context) {
        this.cRh = new SwanEditText(context);
        return this.cRh;
    }

    public SwanEditText atN() {
        return this.cRh;
    }

    public void atO() {
        this.cRh = null;
    }

    public TextWatcher atP() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
