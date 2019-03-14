package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c buL;

    public void a(c cVar) {
        this.buL = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.buL == null) {
            this.buL = new c();
        }
        this.buL.initModeInfos(str, context, attributeSet);
        return null;
    }
}
