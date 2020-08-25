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
/* loaded from: classes20.dex */
abstract class PackageParser {
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
    protected Context mContext;
    protected Object mPackageParser;

    public abstract void collectCertificates(int i) throws Exception;

    public abstract ActivityInfo generateActivityInfo(Object obj, int i) throws Exception;

    public abstract ApplicationInfo generateApplicationInfo(int i) throws Exception;

    public abstract InstrumentationInfo generateInstrumentationInfo(Object obj, int i) throws Exception;

    public abstract PackageInfo generatePackageInfo(int[] iArr, int i, long j, long j2, HashSet<String> hashSet) throws Exception;

    public abstract PermissionGroupInfo generatePermissionGroupInfo(Object obj, int i) throws Exception;

    public abstract PermissionInfo generatePermissionInfo(Object obj, int i) throws Exception;

    public abstract ProviderInfo generateProviderInfo(Object obj, int i) throws Exception;

    public abstract ServiceInfo generateServiceInfo(Object obj, int i) throws Exception;

    public abstract List getActivities() throws Exception;

    public abstract List getInstrumentations() throws Exception;

    public abstract String getPackageName() throws Exception;

    public abstract List getPermissionGroups() throws Exception;

    public abstract List getPermissions() throws Exception;

    public abstract List getProviders() throws Exception;

    public abstract List getReceivers() throws Exception;

    public abstract List getRequestedPermissions() throws Exception;

    public abstract List getServices() throws Exception;

    public abstract void parsePackage(File file, int i) throws Exception;

    public abstract List<IntentFilter> readIntentFilterFromComponent(Object obj) throws Exception;

    public abstract String readNameFromComponent(Object obj) throws Exception;

    public abstract void writeSignature(Signature[] signatureArr) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PackageParser(Context context) {
        this.mContext = context;
    }

    public static PackageParser newPluginParser(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 22) {
            return new PackageParserAPI22(context);
        }
        return null;
    }

    public ActivityInfo generateReceiverInfo(Object obj, int i) throws Exception {
        return generateActivityInfo(obj, i);
    }
}
