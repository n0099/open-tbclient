package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c SP;

    public void a(c cVar) {
        this.SP = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.SP == null) {
            this.SP = new c();
        }
        this.SP.a(str, context, attributeSet);
        return null;
    }
}
