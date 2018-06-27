package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c ace;

    public void a(c cVar) {
        this.ace = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.ace == null) {
            this.ace = new c();
        }
        this.ace.initModeInfos(str, context, attributeSet);
        return null;
    }
}
