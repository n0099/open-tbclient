package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c aIM;

    public void a(c cVar) {
        this.aIM = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.aIM == null) {
            this.aIM = new c();
        }
        this.aIM.a(str, context, attributeSet);
        return null;
    }
}
