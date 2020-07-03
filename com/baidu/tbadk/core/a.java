package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c dFr;

    public void a(c cVar) {
        this.dFr = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.dFr == null) {
            this.dFr = new c();
        }
        this.dFr.initModeInfos(str, context, attributeSet);
        return null;
    }
}
