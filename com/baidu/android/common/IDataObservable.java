package com.baidu.android.common;
/* loaded from: classes.dex */
public interface IDataObservable {
    public static final String TAG = "News";

    DataObservable getDataObservable();

    int queryUpdatesCount();

    void retractUpdates();
}
