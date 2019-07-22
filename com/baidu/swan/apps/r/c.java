package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
/* loaded from: classes2.dex */
public class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c axP;
    private EditText axQ;
    private b axR;
    private TextWatcher mTextWatcher;

    private c() {
    }

    public static c DU() {
        if (axP == null) {
            synchronized (c.class) {
                if (axP == null) {
                    axP = new c();
                }
            }
        }
        return axP;
    }

    public EditText ba(Context context) {
        this.axQ = new EditText(context);
        return this.axQ;
    }

    public EditText DV() {
        return this.axQ;
    }

    public void DW() {
        this.axQ = null;
    }

    public b DX() {
        return this.axR;
    }

    public void c(b bVar) {
        this.axR = bVar;
    }

    public TextWatcher DY() {
        return this.mTextWatcher;
    }

    public void a(TextWatcher textWatcher) {
        this.mTextWatcher = textWatcher;
    }
}
