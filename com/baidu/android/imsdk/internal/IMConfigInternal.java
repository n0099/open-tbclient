package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes.dex */
public class IMConfigInternal {
    public static final String TAG = "IMConfigInternal";
    public static IMConfigInternal sConfig;
    public IIMConfig mConfig;

    private IIMConfig createConfig(Context context, String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                try {
                    return (IIMConfig) cls.newInstance();
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.d(TAG, "Product line of jar is ERROR!");
                }
            }
            LogUtils.d(TAG, "Init ERROR!");
            return null;
        } catch (ClassNotFoundException e3) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e3)).build();
            LogUtils.d(TAG, "Product line of jar is ERROR!");
            return null;
        }
    }

    public static IMConfigInternal getInstance() {
        synchronized (IMConfigInternal.class) {
            if (sConfig == null) {
                sConfig = new IMConfigInternal();
            }
        }
        return sConfig;
    }

    public IIMConfig getIMConfig(Context context) {
        if (this.mConfig == null) {
            synchronized (IMConfigInternal.class) {
                if (this.mConfig == null) {
                    int productLine = getProductLine(context);
                    IIMConfig createConfig = createConfig(context, productLine != 1 ? productLine != 3 ? "com.baidu.android.imsdk.internal.DefaultConfig" : "com.baidu.android.imsdk.box.BoxConfig" : "com.baidu.android.imsdk.internal.DefaultConfig");
                    this.mConfig = createConfig;
                    if (createConfig == null) {
                        this.mConfig = new DefaultConfig();
                    }
                }
            }
        }
        return this.mConfig;
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
            int productLine = getProductLine(context);
            return Integer.valueOf("740" + String.format("%03d", Integer.valueOf(productLine)) + "6").intValue();
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            return 0;
        }
    }

    public boolean setProductLine(Context context, int i2) {
        Utility.writeIntData(context, Constants.KEY_PRODUCT_LINE, i2);
        return true;
    }
}
