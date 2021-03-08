package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes10.dex */
public abstract class b {
    protected View ccw;
    protected View contentView = getContentView();
    protected Context mContext;

    protected abstract int Zn();

    abstract void Zo();

    abstract void Zp();

    protected abstract View getContentView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
        this.ccw = LayoutInflater.from(context).inflate(Zn(), (ViewGroup) null, false);
        Zo();
        Zp();
    }
}
