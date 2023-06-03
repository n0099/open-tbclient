package com.baidu.searchbox.downloads;

import android.database.ContentObserver;
import android.os.Handler;
/* loaded from: classes3.dex */
public class DownloadManagerContentObserver extends ContentObserver {
    public ChangeProxy mChange;

    /* loaded from: classes3.dex */
    public interface ChangeProxy {
        void onChange(boolean z);
    }

    public DownloadManagerContentObserver() {
        super(new Handler());
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ChangeProxy changeProxy = this.mChange;
        if (changeProxy != null) {
            changeProxy.onChange(z);
        }
    }

    public void setChange(ChangeProxy changeProxy) {
        this.mChange = changeProxy;
    }
}
