package com.baidu.android.imsdk.group;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes6.dex */
public interface BIMValueCallBack<T> extends IMListener {
    void onResult(int i, String str, T t);
}
