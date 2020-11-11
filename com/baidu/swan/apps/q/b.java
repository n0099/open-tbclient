package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes10.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cWZ;
    private SwanEditText cXa;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b awm() {
        if (cWZ == null) {
            synchronized (b.class) {
                if (cWZ == null) {
                    cWZ = new b();
                }
            }
        }
        return cWZ;
    }

    public SwanEditText cf(Context context) {
        this.cXa = new SwanEditText(context);
        return this.cXa;
    }

    public SwanEditText awn() {
        return this.cXa;
    }

    public void awo() {
        this.cXa = null;
    }

    public TextWatcher awp() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
