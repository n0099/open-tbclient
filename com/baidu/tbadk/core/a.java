package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c RQ;

    public void a(c cVar) {
        this.RQ = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.RQ == null) {
            this.RQ = new c();
        }
        this.RQ.a(str, context, attributeSet);
        return null;
    }
}
