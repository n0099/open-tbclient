package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes2.dex */
public class BaseManager {
    public static final String TAG = "BaseManager";

    public static boolean isNullContext(Context context) {
        if (context == null) {
            LogUtils.e(LogUtils.TAG, "Context can't be null,BIMManager.init method should be called !");
            return true;
        }
        return false;
    }
}
