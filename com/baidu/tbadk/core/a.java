package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c SO;

    public void a(c cVar) {
        this.SO = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.SO == null) {
            this.SO = new c();
        }
        this.SO.a(str, context, attributeSet);
        return null;
    }
}
