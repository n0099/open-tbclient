package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c eLZ;

    public void a(c cVar) {
        this.eLZ = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.eLZ == null) {
            this.eLZ = new c();
        }
        this.eLZ.initModeInfos(str, context, attributeSet);
        return null;
    }
}
