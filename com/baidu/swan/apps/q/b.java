package com.baidu.swan.apps.q;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes8.dex */
public class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dcq;
    private SwanEditText dcr;
    private TextWatcher mTextWatcher;

    private b() {
    }

    public static b awk() {
        if (dcq == null) {
            synchronized (b.class) {
                if (dcq == null) {
                    dcq = new b();
                }
            }
        }
        return dcq;
    }

    public SwanEditText cS(Context context) {
        this.dcr = new SwanEditText(context);
        return this.dcr;
    }

    public SwanEditText awl() {
        return this.dcr;
    }

    public void awm() {
        this.dcr = null;
    }

    public TextWatcher awn() {
        return this.mTextWatcher;
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
