package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes10.dex */
public abstract class b {
    protected View bWS;
    protected View contentView = getContentView();
    protected Context mContext;

    protected abstract int Xu();

    abstract void Xv();

    abstract void Xw();

    protected abstract View getContentView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
        this.bWS = LayoutInflater.from(context).inflate(Xu(), (ViewGroup) null, false);
        Xv();
        Xw();
    }
}
