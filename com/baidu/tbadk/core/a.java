package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c ael;

    public void a(c cVar) {
        this.ael = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.ael == null) {
            this.ael = new c();
        }
        this.ael.initModeInfos(str, context, attributeSet);
        return null;
    }
}
