package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes6.dex */
public class IMConfigInternal {
    private static final String TAG = IMConfigInternal.class.getSimpleName();
    private static IMConfigInternal sConfig;
    private IIMConfig mConfig;

    public static IMConfigInternal getInstance() {
        synchronized (IMConfigInternal.class) {
            if (sConfig == null) {
                sConfig = new IMConfigInternal();
            }
        }
        return sConfig;
    }

    public boolean setProductLine(Context context, int i) {
        return Utility.writeIntData(context, Constants.KEY_PRODUCT_LINE, i);
    }

    public IIMConfig getIMConfig(Context context) {
        String str;
        if (this.mConfig == null) {
            synchronized (IMConfigInternal.class) {
                if (this.mConfig == null) {
                    switch (getProductLine(context)) {
                        case 1:
                            str = "com.baidu.android.imsdk.internal.DefaultConfig";
                            break;
                        case 2:
                        default:
                            str = "com.baidu.android.imsdk.internal.DefaultConfig";
                            break;
                        case 3:
                            str = "com.baidu.android.imsdk.box.BoxConfig";
                            break;
                    }
                    this.mConfig = createConfig(context, str);
                    if (this.mConfig == null) {
                        this.mConfig = new DefaultConfig();
                    }
                }
            }
        }
        return this.mConfig;
    }

    private IIMConfig createConfig(Context context, String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                try {
                    return (IIMConfig) cls.newInstance();
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    LogUtils.d(TAG, "Product line of jar is ERROR!");
                }
            }
            LogUtils.d(TAG, "Init ERROR!");
            return null;
        } catch (ClassNotFoundException e2) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            LogUtils.d(TAG, "Product line of jar is ERROR!");
            return null;
        }
    }

    public int getProductLine(Context context) {
        if (context == null) {
            return 1;
        }
        int readIntData = Utility.readIntData(context, Constants.KEY_PRODUCT_LINE, 1);
        if (readIntData == 3 || readIntData == 1 || readIntData == 6 || readIntData == 4) {
            return readIntData;
        }
        return 1;
    }

    public int getSDKVersionValue(Context context) {
        try {
            return Integer.valueOf("535" + String.format("%03d", Integer.valueOf(getProductLine(context))) + "6").intValue();
        } catch (Exception e) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            return 0;
        }
    }
}
