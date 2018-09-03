package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c abJ;

    public void a(c cVar) {
        this.abJ = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.abJ == null) {
            this.abJ = new c();
        }
        this.abJ.initModeInfos(str, context, attributeSet);
        return null;
    }
}
