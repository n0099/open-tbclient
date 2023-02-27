package com.baidu.searchbox.crius;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.crius.CriusConstants;
import com.baidu.searchbox.crius.factory.ComponentFactory;
import com.baidu.searchbox.crius.factory.IComponentFactory;
import com.baidu.searchbox.crius.factory.INativeRenderFactory;
import com.baidu.searchbox.crius.factory.NativeRenderFactory;
/* loaded from: classes2.dex */
public class CriusLoader {
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_LOAD_BASE_EXCEPTION = 4;
    public static final int STATUS_LOAD_BASE_FAILED = 7;
    public static final int STATUS_LOAD_CRIUS_EXCEPTION = 5;
    public static final int STATUS_LOAD_CRIUS_FAILED = 8;
    public static final int STATUS_LOAD_STL_EXCEPTION = 3;
    public static final int STATUS_LOAD_STL_FAILED = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_OK = 1;
    public static int criusStatus;

    public static int criusStatus() {
        return criusStatus;
    }

    public static boolean isCriusNone() {
        if (criusStatus == 0) {
            return true;
        }
        return false;
    }

    public static boolean isCriusOk() {
        if (criusStatus == 1) {
            return true;
        }
        return false;
    }

    public static void init(Context context) {
        if (criusStatus != 0) {
            return;
        }
        CriusConstants.DEBUG = CriusRuntime.DEBUG;
        criusStatus = 2;
        if (!TextUtils.isEmpty("gnustl_shared")) {
            try {
                SoLoader.load(context, "gnustl_shared");
                if (!SoLoader.isSoLoadedSucc("gnustl_shared")) {
                    criusStatus = 6;
                    return;
                }
            } catch (Throwable unused) {
                if (!CriusRuntime.DEBUG) {
                    criusStatus = 3;
                    return;
                }
                throw new IllegalArgumentException("crius lib gnustl_shared load failed!");
            }
        }
        try {
            SoLoader.load(context, "criusbase");
            if (!SoLoader.isSoLoadedSucc("criusbase")) {
                criusStatus = 7;
                return;
            }
            try {
                SoLoader.load(context, "crius");
                if (!SoLoader.isSoLoadedSucc("crius")) {
                    criusStatus = 8;
                } else {
                    criusStatus = 1;
                }
            } catch (Throwable unused2) {
                if (!CriusRuntime.DEBUG) {
                    criusStatus = 5;
                    return;
                }
                throw new IllegalArgumentException("crius lib crius load failed!");
            }
        } catch (Throwable unused3) {
            if (!CriusRuntime.DEBUG) {
                criusStatus = 4;
                return;
            }
            throw new IllegalArgumentException("crius lib criusbase load failed!");
        }
    }

    public static void registerComponentFactory(IComponentFactory iComponentFactory) {
        ComponentFactory.getInstance().setComponentFactory(iComponentFactory);
    }

    public static void registerNativeRenderFactory(INativeRenderFactory iNativeRenderFactory) {
        NativeRenderFactory.getInstance().setNativeRenderFactory(iNativeRenderFactory);
    }
}
