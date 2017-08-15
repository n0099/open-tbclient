package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c SN;

    public void a(c cVar) {
        this.SN = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.SN == null) {
            this.SN = new c();
        }
        this.SN.a(str, context, attributeSet);
        return null;
    }
}
