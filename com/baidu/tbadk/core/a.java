package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c bDo;

    public void a(c cVar) {
        this.bDo = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.bDo == null) {
            this.bDo = new c();
        }
        this.bDo.initModeInfos(str, context, attributeSet);
        return null;
    }
}
