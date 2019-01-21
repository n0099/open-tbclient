package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c aoa;

    public void a(c cVar) {
        this.aoa = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.aoa == null) {
            this.aoa = new c();
        }
        this.aoa.initModeInfos(str, context, attributeSet);
        return null;
    }
}
