package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public final class a implements LayoutInflater.Factory {
    private c a;

    public final void a(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.a == null) {
            this.a = new c();
        }
        this.a.a(str, context, attributeSet);
        return null;
    }
}
