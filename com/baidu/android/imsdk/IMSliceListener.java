package com.baidu.android.imsdk;

import java.util.List;
/* loaded from: classes8.dex */
public interface IMSliceListener<T> extends IMListener {
    List<T> getResult();

    boolean isComplete();

    void mergeErrorCode(int i2);

    void mergeErrorMsg(String str);

    void mergeSliceData(List<T> list);

    void onResult(int i2, String str, List<T> list);
}
