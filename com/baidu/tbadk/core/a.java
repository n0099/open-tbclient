package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c aHr;

    public void a(c cVar) {
        this.aHr = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.aHr == null) {
            this.aHr = new c();
        }
        this.aHr.a(str, context, attributeSet);
        return null;
    }
}
