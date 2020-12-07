package com.baidu.android.imsdk.group;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes9.dex */
public interface BIMValueCallBack<T> extends IMListener {
    void onResult(int i, String str, T t);
}
