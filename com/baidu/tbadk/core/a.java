package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c eJu;

    public void a(c cVar) {
        this.eJu = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.eJu == null) {
            this.eJu = new c();
        }
        this.eJu.initModeInfos(str, context, attributeSet);
        return null;
    }
}
