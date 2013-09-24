package com.baidu.adp.widget.ListView;

import android.view.View;
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private View f483a = null;

    public abstract View a();

    public abstract void onClick();

    public final View b() {
        if (this.f483a == null) {
            this.f483a = a();
        }
        return this.f483a;
    }
}
