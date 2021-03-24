package com.baidu.android.imsdk;

import java.util.List;
/* loaded from: classes2.dex */
public interface IMSliceListener<T> extends IMListener {
    List<T> getResult();

    boolean isComplete();

    void mergeErrorCode(int i);

    void mergeErrorMsg(String str);

    void mergeSliceData(List<T> list);

    void onResult(int i, String str, List<T> list);
}
