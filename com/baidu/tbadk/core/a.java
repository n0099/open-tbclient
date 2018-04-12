package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c TW;

    public void a(c cVar) {
        this.TW = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.TW == null) {
            this.TW = new c();
        }
        this.TW.b(str, context, attributeSet);
        return null;
    }
}
