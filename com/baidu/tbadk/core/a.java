package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c cLB;

    public void a(c cVar) {
        this.cLB = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.cLB == null) {
            this.cLB = new c();
        }
        this.cLB.initModeInfos(str, context, attributeSet);
        return null;
    }
}
