package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c SQ;

    public void a(c cVar) {
        this.SQ = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.SQ == null) {
            this.SQ = new c();
        }
        this.SQ.a(str, context, attributeSet);
        return null;
    }
}
