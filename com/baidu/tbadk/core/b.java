package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class b implements LayoutInflater.Factory {
    private d yd;

    public void a(d dVar) {
        this.yd = dVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.yd == null) {
            this.yd = new d();
        }
        this.yd.a(str, context, attributeSet);
        return null;
    }
}
