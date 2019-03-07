package com.baidu.tbadk.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {
    private c buJ;

    public void a(c cVar) {
        this.buJ = cVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.buJ == null) {
            this.buJ = new c();
        }
        this.buJ.initModeInfos(str, context, attributeSet);
        return null;
    }
}
