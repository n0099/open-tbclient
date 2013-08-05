package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private View f454a = null;

    public abstract View a();

    public abstract void onClick();

    public final View b() {
        if (this.f454a == null) {
            this.f454a = a();
        }
        return this.f454a;
    }
}
