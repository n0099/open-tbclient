package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile c awC;
    private EditText awD;
    private b awE;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c Cl() {
        if (awC == null) {
            synchronized (c.class) {
                if (awC == null) {
                    awC = new c();
                }
            }
        }
        return awC;
    }

    public EditText bG(Context context) {
        this.awD = new EditText(context);
        return this.awD;
    }

    public EditText Cm() {
        return this.awD;
    }

    public void Cn() {
        this.awD = null;
    }

    public b Co() {
        return this.awE;
    }

    public void c(b bVar) {
        this.awE = bVar;
    }

    public TextWatcher Cp() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
