package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c erk;

    public void a(c cVar) {
        this.erk = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.erk == null) {
            this.erk = new c();
        }
        this.erk.initModeInfos(str, context, attributeSet);
        return null;
    }
}
