package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c bBS;

    public void a(c cVar) {
        this.bBS = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.bBS == null) {
            this.bBS = new c();
        }
        this.bBS.initModeInfos(str, context, attributeSet);
        return null;
    }
}
