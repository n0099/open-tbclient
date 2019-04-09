package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c awH;
    private EditText awI;
    private b awJ;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c Cj() {
        if (awH == null) {
            synchronized (c.class) {
                if (awH == null) {
                    awH = new c();
                }
            }
        }
        return awH;
    }

    public EditText bG(Context context) {
        this.awI = new EditText(context);
        return this.awI;
    }

    public EditText Ck() {
        return this.awI;
    }

    public void Cl() {
        this.awI = null;
    }

    public b Cm() {
        return this.awJ;
    }

    public void c(b bVar) {
        this.awJ = bVar;
    }

    public TextWatcher Cn() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
