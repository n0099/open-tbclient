package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c Ra;

    public void a(c cVar) {
        this.Ra = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.Ra == null) {
            this.Ra = new c();
        }
        this.Ra.a(str, context, attributeSet);
        return null;
    }
}
