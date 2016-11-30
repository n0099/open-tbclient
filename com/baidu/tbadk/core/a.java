package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c Nu;

    public void a(c cVar) {
        this.Nu = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.Nu == null) {
            this.Nu = new c();
        }
        this.Nu.a(str, context, attributeSet);
        return null;
    }
}
