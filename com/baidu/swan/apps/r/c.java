package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c aRl;
    private EditText aRm;
    private b aRn;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c IT() {
        if (aRl == null) {
            synchronized (c.class) {
                if (aRl == null) {
                    aRl = new c();
                }
            }
        }
        return aRl;
    }

    public EditText bc(Context context) {
        this.aRm = new EditText(context);
        return this.aRm;
    }

    public EditText IU() {
        return this.aRm;
    }

    public void IV() {
        this.aRm = null;
    }

    public b IW() {
        return this.aRn;
    }

    public void c(b bVar) {
        this.aRn = bVar;
    }

    public TextWatcher IX() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
