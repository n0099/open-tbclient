package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private View f563a = null;

    public abstract View a();

    public abstract void onClick();

    public final View b() {
        if (this.f563a == null) {
            this.f563a = a();
        }
        return this.f563a;
    }
}
