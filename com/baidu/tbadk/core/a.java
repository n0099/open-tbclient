package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c Qo;

    public void a(c cVar) {
        this.Qo = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.Qo == null) {
            this.Qo = new c();
        }
        this.Qo.a(str, context, attributeSet);
        return null;
    }
}
