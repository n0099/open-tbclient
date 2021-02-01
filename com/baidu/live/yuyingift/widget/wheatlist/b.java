package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes11.dex */
public abstract class b {
    protected View caU;
    protected View contentView = getContentView();
    protected Context mContext;

    protected abstract int Zk();

    abstract void Zl();

    abstract void Zm();

    protected abstract View getContentView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
        this.caU = LayoutInflater.from(context).inflate(Zk(), (ViewGroup) null, false);
        Zl();
        Zm();
    }
}
