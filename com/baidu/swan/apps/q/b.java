package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes7.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cmW;
    private SwanEditText cmX;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b agV() {
        if (cmW == null) {
            synchronized (b.class) {
                if (cmW == null) {
                    cmW = new b();
                }
            }
        }
        return cmW;
    }

    public SwanEditText bU(Context context) {
        this.cmX = new SwanEditText(context);
        return this.cmX;
    }

    public SwanEditText agW() {
        return this.cmX;
    }

    public void agX() {
        this.cmX = null;
    }

    public TextWatcher agY() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
