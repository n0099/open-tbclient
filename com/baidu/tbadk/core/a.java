package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c TS;

    public void a(c cVar) {
        this.TS = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.TS == null) {
            this.TS = new c();
        }
        this.TS.b(str, context, attributeSet);
        return null;
    }
}
