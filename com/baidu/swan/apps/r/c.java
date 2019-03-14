package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c awD;
    private EditText awE;
    private b awF;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c Cl() {
        if (awD == null) {
            synchronized (c.class) {
                if (awD == null) {
                    awD = new c();
                }
            }
        }
        return awD;
    }

    public EditText bG(Context context) {
        this.awE = new EditText(context);
        return this.awE;
    }

    public EditText Cm() {
        return this.awE;
    }

    public void Cn() {
        this.awE = null;
    }

    public b Co() {
        return this.awF;
    }

    public void c(b bVar) {
        this.awF = bVar;
    }

    public TextWatcher Cp() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
