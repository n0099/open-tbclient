package com.baidu.android.imsdk;

import java.util.List;
/* loaded from: classes.dex */
public interface IMSliceListener extends IMListener {
    List getResult();

    boolean isComplete();

    void mergeErrorCode(int i);

    void mergeErrorMsg(String str);

    void mergeSliceData(List list);

    void onResult(int i, String str, List list);
}
