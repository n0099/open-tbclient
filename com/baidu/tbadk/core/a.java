package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c dkY;

    public void a(c cVar) {
        this.dkY = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.dkY == null) {
            this.dkY = new c();
        }
        this.dkY.initModeInfos(str, context, attributeSet);
        return null;
    }
}
