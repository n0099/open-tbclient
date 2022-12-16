package com.baidu.android.imsdk.media.listener;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes.dex */
public interface BIMValuesCallBack<T, K> extends IMListener {
    void onResult(int i, String str, T t, K k);
}
