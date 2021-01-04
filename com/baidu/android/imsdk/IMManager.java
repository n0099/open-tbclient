package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes4.dex */
public final class IMManager extends BaseManager implements NoProGuard {
    public static boolean enableDebugMode(Context context, boolean z) {
        if (isNullContext(context)) {
            return false;
        }
        return IMSettings.enableDebugMode(context.getApplicationContext(), z);
    }

    public static boolean init(Context context, int i) {
        if (isNullContext(context)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        boolean productLine = IMConfigInternal.getInstance().setProductLine(applicationContext, i);
        IMManagerImpl.getInstance(applicationContext);
        BindStateManager.activeUnBind(context);
        return productLine;
    }

    public static String getVersion() {
        return IMManagerImpl.getVersion();
    }

    public static String getIMDeviceId(Context context) {
        return Utility.getIMDeviceId(context);
    }
}
