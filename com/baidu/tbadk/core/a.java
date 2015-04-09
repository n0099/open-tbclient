package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c NI;

    public void a(c cVar) {
        this.NI = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.NI == null) {
            this.NI = new c();
        }
        this.NI.a(str, context, attributeSet);
        return null;
    }
}
