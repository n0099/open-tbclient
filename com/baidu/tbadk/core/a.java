package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c ME;

    public void a(c cVar) {
        this.ME = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.ME == null) {
            this.ME = new c();
        }
        this.ME.a(str, context, attributeSet);
        return null;
    }
}
