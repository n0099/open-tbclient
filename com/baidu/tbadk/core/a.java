package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c cHw;

    public void a(c cVar) {
        this.cHw = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.cHw == null) {
            this.cHw = new c();
        }
        this.cHw.initModeInfos(str, context, attributeSet);
        return null;
    }
}
