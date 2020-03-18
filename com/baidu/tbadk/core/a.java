package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c cLM;

    public void a(c cVar) {
        this.cLM = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.cLM == null) {
            this.cLM = new c();
        }
        this.cLM.initModeInfos(str, context, attributeSet);
        return null;
    }
}
