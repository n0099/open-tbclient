package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c aji;

    public void a(c cVar) {
        this.aji = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.aji == null) {
            this.aji = new c();
        }
        this.aji.initModeInfos(str, context, attributeSet);
        return null;
    }
}
