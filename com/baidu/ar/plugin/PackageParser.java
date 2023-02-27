package com.baidu.ar.plugin;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Build;
import java.io.File;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public abstract class PackageParser {
    public static final int PARSE_CHATTY = 2;
    public static final int PARSE_COLLECT_CERTIFICATES = 256;
    public static final int PARSE_FORWARD_LOCK = 16;
    public static final int PARSE_IGNORE_PROCESSES = 8;
    public static final int PARSE_IS_PRIVILEGED = 128;
    public static final int PARSE_IS_SYSTEM = 1;
    public static final int PARSE_IS_SYSTEM_DIR = 64;
    public static final int PARSE_MUST_BE_APK = 4;
    public static final int PARSE_ON_SDCARD = 32;
    public static final int PARSE_TRUSTED_OVERLAY = 512;
    public Context mContext;
    public Object mPackageParser;

    public abstract void collectCertificates(int i);

    public abstract ActivityInfo generateActivityInfo(Object obj, int i);

    public abstract ApplicationInfo generateApplicationInfo(int i);

    public abstract InstrumentationInfo generateInstrumentationInfo(Object obj, int i);

    public abstract PackageInfo generatePackageInfo(int[] iArr, int i, long j, long j2, HashSet<String> hashSet);

    public abstract PermissionGroupInfo generatePermissionGroupInfo(Object obj, int i);

    public abstract PermissionInfo generatePermissionInfo(Object obj, int i);

    public abstract ProviderInfo generateProviderInfo(Object obj, int i);

    public abstract ServiceInfo generateServiceInfo(Object obj, int i);

    public abstract List getActivities();

    public abstract List getInstrumentations();

    public abstract String getPackageName();

    public abstract List getPermissionGroups();

    public abstract List getPermissions();

    public abstract List getProviders();

    public abstract List getReceivers();

    public abstract List getRequestedPermissions();

    public abstract List getServices();

    public abstract void parsePackage(File file, int i);

    public abstract List<IntentFilter> readIntentFilterFromComponent(Object obj);

    public abstract String readNameFromComponent(Object obj);

    public abstract void writeSignature(Signature[] signatureArr);

    public PackageParser(Context context) {
        this.mContext = context;
    }

    public static PackageParser newPluginParser(Context context) {
        if (Build.VERSION.SDK_INT >= 22) {
            return new PackageParserAPI22(context);
        }
        return null;
    }

    public ActivityInfo generateReceiverInfo(Object obj, int i) {
        return generateActivityInfo(obj, i);
    }
}
