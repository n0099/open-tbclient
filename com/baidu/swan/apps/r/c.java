package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c awG;
    private EditText awH;
    private b awI;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c Cj() {
        if (awG == null) {
            synchronized (c.class) {
                if (awG == null) {
                    awG = new c();
                }
            }
        }
        return awG;
    }

    public EditText bG(Context context) {
        this.awH = new EditText(context);
        return this.awH;
    }

    public EditText Ck() {
        return this.awH;
    }

    public void Cl() {
        this.awH = null;
    }

    public b Cm() {
        return this.awI;
    }

    public void c(b bVar) {
        this.awI = bVar;
    }

    public TextWatcher Cn() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
