package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class ComponentUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "ComponentUtils";

    /* renamed from: com.baidu.android.util.android.ComponentUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType;

        static {
            int[] iArr = new int[ComponentType.values().length];
            $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType = iArr;
            try {
                iArr[ComponentType.RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.SERVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum ComponentType {
        ALL,
        ACTIVITY,
        SERVICE,
        RECEIVER,
        PROVIDER
    }

    public static ComponentInfo getActivityInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static ComponentInfo getComponentInfo(Context context, ComponentType componentType, ComponentName componentName) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[componentType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        ComponentInfo receiverInfo = getReceiverInfo(context, componentName);
                        if (receiverInfo == null) {
                            receiverInfo = getActivityInfo(context, componentName);
                        }
                        if (receiverInfo == null) {
                            receiverInfo = getServiceInfo(context, componentName);
                        }
                        return receiverInfo == null ? getProviderInfo(context, componentName) : receiverInfo;
                    }
                    return getProviderInfo(context, componentName);
                }
                return getServiceInfo(context, componentName);
            }
            return getActivityInfo(context, componentName);
        }
        return getReceiverInfo(context, componentName);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public static ComponentInfo getProviderInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getProviderInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static ComponentInfo getReceiverInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getReceiverInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static ComponentInfo getServiceInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getServiceInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isComponentEnabledSetting(Context context, ComponentName componentName) {
        return 1 == context.getPackageManager().getComponentEnabledSetting(componentName);
    }

    public static boolean isComponetEnable(Context context, ComponentType componentType, ComponentName componentName) {
        ComponentInfo componentInfo = getComponentInfo(context, componentType, componentName);
        if (componentInfo != null) {
            return componentInfo.enabled;
        }
        return false;
    }

    public static void setComponentEnabledSetting(Context context, ComponentType componentType, ComponentName componentName, boolean z) {
        boolean isComponetEnable = isComponetEnable(context, componentType, componentName);
        if (z) {
            if (isComponetEnable) {
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } else if (isComponetEnable) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        }
    }
}
