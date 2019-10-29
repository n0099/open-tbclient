package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c aRD;
    private EditText aRE;
    private b aRF;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c IS() {
        if (aRD == null) {
            synchronized (c.class) {
                if (aRD == null) {
                    aRD = new c();
                }
            }
        }
        return aRD;
    }

    public EditText bc(Context context) {
        this.aRE = new EditText(context);
        return this.aRE;
    }

    public EditText IT() {
        return this.aRE;
    }

    public void IU() {
        this.aRE = null;
    }

    public b IV() {
        return this.aRF;
    }

    public void c(b bVar) {
        this.aRF = bVar;
    }

    public TextWatcher IW() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
