package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c dUA;

    public void a(c cVar) {
        this.dUA = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.dUA == null) {
            this.dUA = new c();
        }
        this.dUA.initModeInfos(str, context, attributeSet);
        return null;
    }
}
