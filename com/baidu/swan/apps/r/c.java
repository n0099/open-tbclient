package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c ayn;
    private EditText ayo;
    private b ayp;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c DY() {
        if (ayn == null) {
            synchronized (c.class) {
                if (ayn == null) {
                    ayn = new c();
                }
            }
        }
        return ayn;
    }

    public EditText ba(Context context) {
        this.ayo = new EditText(context);
        return this.ayo;
    }

    public EditText DZ() {
        return this.ayo;
    }

    public void Ea() {
        this.ayo = null;
    }

    public b Eb() {
        return this.ayp;
    }

    public void c(b bVar) {
        this.ayp = bVar;
    }

    public TextWatcher Ec() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
