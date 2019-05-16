package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c axk;
    private EditText axl;
    private b axm;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c Dl() {
        if (axk == null) {
            synchronized (c.class) {
                if (axk == null) {
                    axk = new c();
                }
            }
        }
        return axk;
    }

    public EditText ba(Context context) {
        this.axl = new EditText(context);
        return this.axl;
    }

    public EditText Dm() {
        return this.axl;
    }

    public void Dn() {
        this.axl = null;
    }

    public b Do() {
        return this.axm;
    }

    public void c(b bVar) {
        this.axm = bVar;
    }

    public TextWatcher Dp() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
