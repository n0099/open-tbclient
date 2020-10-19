package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.os.Build;
/* loaded from: classes8.dex */
public final class ComponentUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "ComponentUtils";

    /* loaded from: classes8.dex */
    public enum ComponentType {
        ALL,
        ACTIVITY,
        SERVICE,
        RECEIVER,
        PROVIDER
    }

    private ComponentUtils() {
    }

    public static boolean isComponetEnable(Context context, ComponentType componentType, ComponentName componentName) {
        ComponentInfo componentInfo = getComponentInfo(context, componentType, componentName);
        if (componentInfo == null) {
            return false;
        }
        return componentInfo.enabled;
    }

    public static boolean isComponentEnabledSetting(Context context, ComponentName componentName) {
        return 1 == context.getPackageManager().getComponentEnabledSetting(componentName);
    }

    public static void setComponentEnabledSetting(Context context, ComponentType componentType, ComponentName componentName, boolean z) {
        boolean isComponetEnable = isComponetEnable(context, componentType, componentName);
        if (z) {
            if (!isComponetEnable) {
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        } else if (isComponetEnable) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        }
    }

    @SuppressLint({"NewApi"})
    private static ComponentInfo getComponentInfo(Context context, ComponentType componentType, ComponentName componentName) {
        switch (componentType) {
            case RECEIVER:
                return getReceiverInfo(context, componentName);
            case ACTIVITY:
                return getActivityInfo(context, componentName);
            case SERVICE:
                return getServiceInfo(context, componentName);
            case PROVIDER:
                return getProviderInfo(context, componentName);
            default:
                ComponentInfo receiverInfo = getReceiverInfo(context, componentName);
                if (receiverInfo == null) {
                    receiverInfo = getActivityInfo(context, componentName);
                }
                if (receiverInfo == null) {
                    receiverInfo = getServiceInfo(context, componentName);
                }
                if (receiverInfo == null) {
                    return getProviderInfo(context, componentName);
                }
                return receiverInfo;
        }
    }

    private static ComponentInfo getReceiverInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getReceiverInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private static ComponentInfo getActivityInfo(Context context, ComponentName componentName) {
        if (0 != 0) {
            return null;
        }
        try {
            return context.getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private static ComponentInfo getServiceInfo(Context context, ComponentName componentName) {
        if (0 != 0) {
            return null;
        }
        try {
            return context.getPackageManager().getServiceInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    private static ComponentInfo getProviderInfo(Context context, ComponentName componentName) {
        if (Build.VERSION.SDK_INT < 11 || 0 != 0) {
            return null;
        }
        try {
            return context.getPackageManager().getProviderInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }
}
