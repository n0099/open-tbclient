package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c anx;

    public void a(c cVar) {
        this.anx = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.anx == null) {
            this.anx = new c();
        }
        this.anx.initModeInfos(str, context, attributeSet);
        return null;
    }
}
