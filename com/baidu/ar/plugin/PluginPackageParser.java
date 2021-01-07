package com.baidu.ar.plugin;

import android.content.ComponentName;
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
import android.text.TextUtils;
import com.baidu.ar.plugin.helper.ComponentNameComparator;
import com.baidu.ar.plugin.reflect.FieldUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class PluginPackageParser {
    private final Context mHostContext;
    private final PackageInfo mHostPackageInfo;
    private final String mPackageName;
    private final PackageParser mParser;
    private final File mPluginFile;
    private Map<ComponentName, Object> mActivityObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mServiceObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mProviderObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mReceiversObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mInstrumentationObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mPermissionsObjCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, Object> mPermissionGroupObjCache = new TreeMap(new ComponentNameComparator());
    private ArrayList<String> mRequestedPermissionsCache = new ArrayList<>();
    private Map<ComponentName, List<IntentFilter>> mActivityIntentFilterCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, List<IntentFilter>> mServiceIntentFilterCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, List<IntentFilter>> mProviderIntentFilterCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, List<IntentFilter>> mReceiverIntentFilterCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, ActivityInfo> mActivityInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, ServiceInfo> mServiceInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, ProviderInfo> mProviderInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, ActivityInfo> mReceiversInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, InstrumentationInfo> mInstrumentationInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, PermissionGroupInfo> mPermissionGroupInfoCache = new TreeMap(new ComponentNameComparator());
    private Map<ComponentName, PermissionInfo> mPermissionsInfoCache = new TreeMap(new ComponentNameComparator());

    public PluginPackageParser(Context context, File file) throws Exception {
        this.mHostContext = context;
        this.mPluginFile = file;
        this.mParser = PackageParser.newPluginParser(context);
        this.mParser.parsePackage(file, 0);
        this.mPackageName = this.mParser.getPackageName();
        this.mHostPackageInfo = this.mHostContext.getPackageManager().getPackageInfo(this.mHostContext.getPackageName(), 0);
        for (Object obj : this.mParser.getActivities()) {
            ComponentName componentName = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj));
            synchronized (this.mActivityObjCache) {
                this.mActivityObjCache.put(componentName, obj);
            }
            synchronized (this.mActivityInfoCache) {
                ActivityInfo generateActivityInfo = this.mParser.generateActivityInfo(obj, 0);
                fixApplicationInfo(generateActivityInfo.applicationInfo);
                if (TextUtils.isEmpty(generateActivityInfo.processName)) {
                    generateActivityInfo.processName = generateActivityInfo.packageName;
                }
                this.mActivityInfoCache.put(componentName, generateActivityInfo);
            }
            List<IntentFilter> readIntentFilterFromComponent = this.mParser.readIntentFilterFromComponent(obj);
            synchronized (this.mActivityIntentFilterCache) {
                this.mActivityIntentFilterCache.remove(componentName);
                this.mActivityIntentFilterCache.put(componentName, new ArrayList(readIntentFilterFromComponent));
            }
        }
        for (Object obj2 : this.mParser.getServices()) {
            ComponentName componentName2 = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj2));
            synchronized (this.mServiceObjCache) {
                this.mServiceObjCache.put(componentName2, obj2);
            }
            synchronized (this.mServiceInfoCache) {
                ServiceInfo generateServiceInfo = this.mParser.generateServiceInfo(obj2, 0);
                fixApplicationInfo(generateServiceInfo.applicationInfo);
                if (TextUtils.isEmpty(generateServiceInfo.processName)) {
                    generateServiceInfo.processName = generateServiceInfo.packageName;
                }
                this.mServiceInfoCache.put(componentName2, generateServiceInfo);
            }
            List<IntentFilter> readIntentFilterFromComponent2 = this.mParser.readIntentFilterFromComponent(obj2);
            synchronized (this.mServiceIntentFilterCache) {
                this.mServiceIntentFilterCache.remove(componentName2);
                this.mServiceIntentFilterCache.put(componentName2, new ArrayList(readIntentFilterFromComponent2));
            }
        }
        for (Object obj3 : this.mParser.getProviders()) {
            ComponentName componentName3 = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj3));
            synchronized (this.mProviderObjCache) {
                this.mProviderObjCache.put(componentName3, obj3);
            }
            synchronized (this.mProviderInfoCache) {
                ProviderInfo generateProviderInfo = this.mParser.generateProviderInfo(obj3, 0);
                fixApplicationInfo(generateProviderInfo.applicationInfo);
                if (TextUtils.isEmpty(generateProviderInfo.processName)) {
                    generateProviderInfo.processName = generateProviderInfo.packageName;
                }
                this.mProviderInfoCache.put(componentName3, generateProviderInfo);
            }
            List<IntentFilter> readIntentFilterFromComponent3 = this.mParser.readIntentFilterFromComponent(obj3);
            synchronized (this.mProviderIntentFilterCache) {
                this.mProviderIntentFilterCache.remove(componentName3);
                this.mProviderIntentFilterCache.put(componentName3, new ArrayList(readIntentFilterFromComponent3));
            }
        }
        for (Object obj4 : this.mParser.getReceivers()) {
            ComponentName componentName4 = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj4));
            synchronized (this.mReceiversObjCache) {
                this.mReceiversObjCache.put(componentName4, obj4);
            }
            synchronized (this.mReceiversInfoCache) {
                ActivityInfo generateReceiverInfo = this.mParser.generateReceiverInfo(obj4, 0);
                fixApplicationInfo(generateReceiverInfo.applicationInfo);
                if (TextUtils.isEmpty(generateReceiverInfo.processName)) {
                    generateReceiverInfo.processName = generateReceiverInfo.packageName;
                }
                this.mReceiversInfoCache.put(componentName4, generateReceiverInfo);
            }
            List<IntentFilter> readIntentFilterFromComponent4 = this.mParser.readIntentFilterFromComponent(obj4);
            synchronized (this.mReceiverIntentFilterCache) {
                this.mReceiverIntentFilterCache.remove(componentName4);
                this.mReceiverIntentFilterCache.put(componentName4, new ArrayList(readIntentFilterFromComponent4));
            }
        }
        for (Object obj5 : this.mParser.getInstrumentations()) {
            ComponentName componentName5 = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj5));
            synchronized (this.mInstrumentationObjCache) {
                this.mInstrumentationObjCache.put(componentName5, obj5);
            }
        }
        for (Object obj6 : this.mParser.getPermissions()) {
            String readNameFromComponent = this.mParser.readNameFromComponent(obj6);
            if (readNameFromComponent != null) {
                ComponentName componentName6 = new ComponentName(this.mPackageName, readNameFromComponent);
                synchronized (this.mPermissionsObjCache) {
                    this.mPermissionsObjCache.put(componentName6, obj6);
                }
                synchronized (this.mPermissionsInfoCache) {
                    this.mPermissionsInfoCache.put(componentName6, this.mParser.generatePermissionInfo(obj6, 0));
                }
            }
        }
        for (Object obj7 : this.mParser.getPermissionGroups()) {
            ComponentName componentName7 = new ComponentName(this.mPackageName, this.mParser.readNameFromComponent(obj7));
            synchronized (this.mPermissionGroupObjCache) {
                this.mPermissionGroupObjCache.put(componentName7, obj7);
            }
        }
        List requestedPermissions = this.mParser.getRequestedPermissions();
        if (requestedPermissions != null && requestedPermissions.size() > 0) {
            synchronized (this.mRequestedPermissionsCache) {
                this.mRequestedPermissionsCache.addAll(requestedPermissions);
            }
        }
    }

    public File getPluginFile() {
        return this.mPluginFile;
    }

    public void collectCertificates(int i) throws Exception {
        this.mParser.collectCertificates(i);
    }

    public List<IntentFilter> getActivityIntentFilter(ComponentName componentName) {
        List<IntentFilter> list;
        synchronized (this.mActivityIntentFilterCache) {
            list = this.mActivityIntentFilterCache.get(componentName);
        }
        return list;
    }

    public List<IntentFilter> getServiceIntentFilter(ComponentName componentName) {
        List<IntentFilter> list;
        synchronized (this.mServiceIntentFilterCache) {
            list = this.mServiceIntentFilterCache.get(componentName);
        }
        return list;
    }

    public List<IntentFilter> getProviderIntentFilter(ComponentName componentName) {
        List<IntentFilter> list;
        synchronized (this.mProviderObjCache) {
            list = this.mProviderIntentFilterCache.get(componentName);
        }
        return list;
    }

    public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mActivityObjCache) {
            obj = this.mActivityObjCache.get(componentName);
        }
        if (obj != null) {
            ActivityInfo generateActivityInfo = this.mParser.generateActivityInfo(obj, i);
            fixApplicationInfo(generateActivityInfo.applicationInfo);
            if (TextUtils.isEmpty(generateActivityInfo.processName)) {
                generateActivityInfo.processName = generateActivityInfo.packageName;
                return generateActivityInfo;
            }
            return generateActivityInfo;
        }
        return null;
    }

    public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mServiceObjCache) {
            obj = this.mServiceObjCache.get(componentName);
        }
        if (obj != null) {
            ServiceInfo generateServiceInfo = this.mParser.generateServiceInfo(obj, i);
            fixApplicationInfo(generateServiceInfo.applicationInfo);
            if (TextUtils.isEmpty(generateServiceInfo.processName)) {
                generateServiceInfo.processName = generateServiceInfo.packageName;
                return generateServiceInfo;
            }
            return generateServiceInfo;
        }
        return null;
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mReceiversObjCache) {
            obj = this.mReceiversObjCache.get(componentName);
        }
        if (obj != null) {
            ActivityInfo generateReceiverInfo = this.mParser.generateReceiverInfo(obj, i);
            fixApplicationInfo(generateReceiverInfo.applicationInfo);
            if (TextUtils.isEmpty(generateReceiverInfo.processName)) {
                generateReceiverInfo.processName = generateReceiverInfo.packageName;
                return generateReceiverInfo;
            }
            return generateReceiverInfo;
        }
        return null;
    }

    public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mProviderObjCache) {
            obj = this.mProviderObjCache.get(componentName);
        }
        if (obj != null) {
            ProviderInfo generateProviderInfo = this.mParser.generateProviderInfo(obj, i);
            fixApplicationInfo(generateProviderInfo.applicationInfo);
            if (TextUtils.isEmpty(generateProviderInfo.processName)) {
                generateProviderInfo.processName = generateProviderInfo.packageName;
                return generateProviderInfo;
            }
            return generateProviderInfo;
        }
        return null;
    }

    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mInstrumentationObjCache) {
            obj = this.mInstrumentationObjCache.get(componentName);
        }
        if (obj != null) {
            return this.mParser.generateInstrumentationInfo(obj, i);
        }
        return null;
    }

    public ApplicationInfo getApplicationInfo(int i) throws Exception {
        ApplicationInfo generateApplicationInfo = this.mParser.generateApplicationInfo(i);
        fixApplicationInfo(generateApplicationInfo);
        if (TextUtils.isEmpty(generateApplicationInfo.processName)) {
            generateApplicationInfo.processName = generateApplicationInfo.packageName;
        }
        return generateApplicationInfo;
    }

    public PermissionGroupInfo getPermissionGroupInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mPermissionGroupObjCache) {
            obj = this.mPermissionGroupObjCache.get(componentName);
        }
        if (obj != null) {
            return this.mParser.generatePermissionGroupInfo(obj, i);
        }
        return null;
    }

    public PermissionInfo getPermissionInfo(ComponentName componentName, int i) throws Exception {
        Object obj;
        synchronized (this.mPermissionsObjCache) {
            obj = this.mPermissionsObjCache.get(componentName);
        }
        if (obj != null) {
            return this.mParser.generatePermissionInfo(obj, i);
        }
        return null;
    }

    public PackageInfo getPackageInfo(int i) throws Exception {
        PackageInfo generatePackageInfo = this.mParser.generatePackageInfo(this.mHostPackageInfo.gids, i, this.mPluginFile.lastModified(), this.mPluginFile.lastModified(), new HashSet<>(getRequestedPermissions()));
        fixPackageInfo(generatePackageInfo);
        return generatePackageInfo;
    }

    public List<ActivityInfo> getActivities() throws Exception {
        return new ArrayList(this.mActivityInfoCache.values());
    }

    public List<ServiceInfo> getServices() throws Exception {
        return new ArrayList(this.mServiceInfoCache.values());
    }

    public List<ProviderInfo> getProviders() throws Exception {
        return new ArrayList(this.mProviderInfoCache.values());
    }

    public List<ActivityInfo> getReceivers() throws Exception {
        return new ArrayList(this.mReceiversInfoCache.values());
    }

    public List<PermissionInfo> getPermissions() throws Exception {
        return new ArrayList(this.mPermissionsInfoCache.values());
    }

    public List<PermissionGroupInfo> getPermissionGroups() throws Exception {
        return new ArrayList(this.mPermissionGroupInfoCache.values());
    }

    public List<InstrumentationInfo> getInstrumentationInfos() {
        return new ArrayList(this.mInstrumentationInfoCache.values());
    }

    public List<String> getRequestedPermissions() throws Exception {
        ArrayList arrayList;
        synchronized (this.mRequestedPermissionsCache) {
            arrayList = new ArrayList(this.mRequestedPermissionsCache);
        }
        return arrayList;
    }

    public String getPackageName() throws Exception {
        return this.mPackageName;
    }

    private ApplicationInfo fixApplicationInfo(ApplicationInfo applicationInfo) {
        if (applicationInfo.sourceDir == null) {
            applicationInfo.sourceDir = this.mPluginFile.getPath();
        }
        if (applicationInfo.publicSourceDir == null) {
            applicationInfo.publicSourceDir = this.mPluginFile.getPath();
        }
        if (applicationInfo.dataDir == null) {
            applicationInfo.dataDir = PluginDirHelper.getPluginDataDir(this.mHostContext, applicationInfo.packageName);
        }
        try {
            if (Build.VERSION.SDK_INT >= 21 && FieldUtils.readField((Object) applicationInfo, "scanSourceDir", true) == null) {
                FieldUtils.writeField((Object) applicationInfo, "scanSourceDir", (Object) applicationInfo.dataDir, true);
            }
        } catch (Throwable th) {
        }
        try {
            if (Build.VERSION.SDK_INT >= 21 && FieldUtils.readField((Object) applicationInfo, "scanPublicSourceDir", true) == null) {
                FieldUtils.writeField((Object) applicationInfo, "scanPublicSourceDir", (Object) applicationInfo.dataDir, true);
            }
        } catch (Throwable th2) {
        }
        applicationInfo.uid = this.mHostPackageInfo.applicationInfo.uid;
        if (Build.VERSION.SDK_INT >= 9 && applicationInfo.nativeLibraryDir == null) {
            applicationInfo.nativeLibraryDir = PluginDirHelper.getPluginNativeLibraryDir(this.mHostContext, applicationInfo.packageName);
        }
        if (Build.VERSION.SDK_INT >= 21 && applicationInfo.splitSourceDirs == null) {
            applicationInfo.splitSourceDirs = new String[]{this.mPluginFile.getPath()};
        }
        if (Build.VERSION.SDK_INT >= 21 && applicationInfo.splitPublicSourceDirs == null) {
            applicationInfo.splitPublicSourceDirs = new String[]{this.mPluginFile.getPath()};
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (Build.VERSION.SDK_INT < 26) {
                    FieldUtils.writeField(applicationInfo, "deviceEncryptedDataDir", applicationInfo.dataDir);
                    FieldUtils.writeField(applicationInfo, "credentialEncryptedDataDir", applicationInfo.dataDir);
                }
                FieldUtils.writeField(applicationInfo, "deviceProtectedDataDir", applicationInfo.dataDir);
                FieldUtils.writeField(applicationInfo, "credentialProtectedDataDir", applicationInfo.dataDir);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(applicationInfo.processName)) {
            applicationInfo.processName = applicationInfo.packageName;
        }
        return applicationInfo;
    }

    private PackageInfo fixPackageInfo(PackageInfo packageInfo) {
        packageInfo.gids = this.mHostPackageInfo.gids;
        fixApplicationInfo(packageInfo.applicationInfo);
        return packageInfo;
    }

    public Map<ActivityInfo, List<IntentFilter>> getReceiverIntentFilter() {
        HashMap hashMap;
        synchronized (this.mReceiverIntentFilterCache) {
            hashMap = new HashMap();
            for (ComponentName componentName : this.mReceiverIntentFilterCache.keySet()) {
                hashMap.put(this.mReceiversInfoCache.get(componentName), this.mReceiverIntentFilterCache.get(componentName));
            }
        }
        return hashMap;
    }

    public List<IntentFilter> getReceiverIntentFilter(ActivityInfo activityInfo) {
        synchronized (this.mReceiverIntentFilterCache) {
            for (ComponentName componentName : this.mReceiverIntentFilterCache.keySet()) {
                if (TextUtils.equals(activityInfo.name, this.mReceiversInfoCache.get(componentName).name)) {
                    return this.mReceiverIntentFilterCache.get(componentName);
                }
            }
            return null;
        }
    }

    public void writeSignature(Signature[] signatureArr) throws Exception {
        if (signatureArr != null) {
            this.mParser.writeSignature(signatureArr);
        }
    }
}
