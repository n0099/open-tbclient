package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes11.dex */
public abstract class b {
    protected View cbF;
    protected View contentView = getContentView();
    protected Context mContext;

    protected abstract int abn();

    abstract void abo();

    abstract void abp();

    protected abstract View getContentView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
        this.cbF = LayoutInflater.from(context).inflate(abn(), (ViewGroup) null, false);
        abo();
        abp();
    }
}
