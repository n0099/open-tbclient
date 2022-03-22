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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.plugin.helper.ComponentNameComparator;
import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class PluginPackageParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<ComponentName, ActivityInfo> mActivityInfoCache;
    public Map<ComponentName, List<IntentFilter>> mActivityIntentFilterCache;
    public Map<ComponentName, Object> mActivityObjCache;
    public final Context mHostContext;
    public final PackageInfo mHostPackageInfo;
    public Map<ComponentName, InstrumentationInfo> mInstrumentationInfoCache;
    public Map<ComponentName, Object> mInstrumentationObjCache;
    public final String mPackageName;
    public final PackageParser mParser;
    public Map<ComponentName, PermissionGroupInfo> mPermissionGroupInfoCache;
    public Map<ComponentName, Object> mPermissionGroupObjCache;
    public Map<ComponentName, PermissionInfo> mPermissionsInfoCache;
    public Map<ComponentName, Object> mPermissionsObjCache;
    public final File mPluginFile;
    public Map<ComponentName, ProviderInfo> mProviderInfoCache;
    public Map<ComponentName, List<IntentFilter>> mProviderIntentFilterCache;
    public Map<ComponentName, Object> mProviderObjCache;
    public Map<ComponentName, List<IntentFilter>> mReceiverIntentFilterCache;
    public Map<ComponentName, ActivityInfo> mReceiversInfoCache;
    public Map<ComponentName, Object> mReceiversObjCache;
    public ArrayList<String> mRequestedPermissionsCache;
    public Map<ComponentName, ServiceInfo> mServiceInfoCache;
    public Map<ComponentName, List<IntentFilter>> mServiceIntentFilterCache;
    public Map<ComponentName, Object> mServiceObjCache;

    public PluginPackageParser(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivityObjCache = new TreeMap(new ComponentNameComparator());
        this.mServiceObjCache = new TreeMap(new ComponentNameComparator());
        this.mProviderObjCache = new TreeMap(new ComponentNameComparator());
        this.mReceiversObjCache = new TreeMap(new ComponentNameComparator());
        this.mInstrumentationObjCache = new TreeMap(new ComponentNameComparator());
        this.mPermissionsObjCache = new TreeMap(new ComponentNameComparator());
        this.mPermissionGroupObjCache = new TreeMap(new ComponentNameComparator());
        this.mRequestedPermissionsCache = new ArrayList<>();
        this.mActivityIntentFilterCache = new TreeMap(new ComponentNameComparator());
        this.mServiceIntentFilterCache = new TreeMap(new ComponentNameComparator());
        this.mProviderIntentFilterCache = new TreeMap(new ComponentNameComparator());
        this.mReceiverIntentFilterCache = new TreeMap(new ComponentNameComparator());
        this.mActivityInfoCache = new TreeMap(new ComponentNameComparator());
        this.mServiceInfoCache = new TreeMap(new ComponentNameComparator());
        this.mProviderInfoCache = new TreeMap(new ComponentNameComparator());
        this.mReceiversInfoCache = new TreeMap(new ComponentNameComparator());
        this.mInstrumentationInfoCache = new TreeMap(new ComponentNameComparator());
        this.mPermissionGroupInfoCache = new TreeMap(new ComponentNameComparator());
        this.mPermissionsInfoCache = new TreeMap(new ComponentNameComparator());
        this.mHostContext = context;
        this.mPluginFile = file;
        PackageParser newPluginParser = PackageParser.newPluginParser(context);
        this.mParser = newPluginParser;
        newPluginParser.parsePackage(file, 0);
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
        if (requestedPermissions == null || requestedPermissions.size() <= 0) {
            return;
        }
        synchronized (this.mRequestedPermissionsCache) {
            this.mRequestedPermissionsCache.addAll(requestedPermissions);
        }
    }

    private ApplicationInfo fixApplicationInfo(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, applicationInfo)) == null) {
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
            } catch (Throwable unused) {
            }
            try {
                if (Build.VERSION.SDK_INT >= 21 && FieldUtils.readField((Object) applicationInfo, "scanPublicSourceDir", true) == null) {
                    FieldUtils.writeField((Object) applicationInfo, "scanPublicSourceDir", (Object) applicationInfo.dataDir, true);
                }
            } catch (Throwable unused2) {
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
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (i < 26) {
                    try {
                        FieldUtils.writeField(applicationInfo, "deviceEncryptedDataDir", applicationInfo.dataDir);
                        FieldUtils.writeField(applicationInfo, "credentialEncryptedDataDir", applicationInfo.dataDir);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                FieldUtils.writeField(applicationInfo, "deviceProtectedDataDir", applicationInfo.dataDir);
                FieldUtils.writeField(applicationInfo, "credentialProtectedDataDir", applicationInfo.dataDir);
            }
            if (TextUtils.isEmpty(applicationInfo.processName)) {
                applicationInfo.processName = applicationInfo.packageName;
            }
            return applicationInfo;
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    private PackageInfo fixPackageInfo(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, packageInfo)) == null) {
            packageInfo.gids = this.mHostPackageInfo.gids;
            fixApplicationInfo(packageInfo.applicationInfo);
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public void collectCertificates(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mParser.collectCertificates(i);
        }
    }

    public List<ActivityInfo> getActivities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ArrayList(this.mActivityInfoCache.values()) : (List) invokeV.objValue;
    }

    public ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, componentName, i)) == null) {
            synchronized (this.mActivityObjCache) {
                obj = this.mActivityObjCache.get(componentName);
            }
            if (obj != null) {
                ActivityInfo generateActivityInfo = this.mParser.generateActivityInfo(obj, i);
                fixApplicationInfo(generateActivityInfo.applicationInfo);
                if (TextUtils.isEmpty(generateActivityInfo.processName)) {
                    generateActivityInfo.processName = generateActivityInfo.packageName;
                }
                return generateActivityInfo;
            }
            return null;
        }
        return (ActivityInfo) invokeLI.objValue;
    }

    public List<IntentFilter> getActivityIntentFilter(ComponentName componentName) {
        InterceptResult invokeL;
        List<IntentFilter> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, componentName)) == null) {
            synchronized (this.mActivityIntentFilterCache) {
                list = this.mActivityIntentFilterCache.get(componentName);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public ApplicationInfo getApplicationInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ApplicationInfo generateApplicationInfo = this.mParser.generateApplicationInfo(i);
            fixApplicationInfo(generateApplicationInfo);
            if (TextUtils.isEmpty(generateApplicationInfo.processName)) {
                generateApplicationInfo.processName = generateApplicationInfo.packageName;
            }
            return generateApplicationInfo;
        }
        return (ApplicationInfo) invokeI.objValue;
    }

    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, componentName, i)) == null) {
            synchronized (this.mInstrumentationObjCache) {
                obj = this.mInstrumentationObjCache.get(componentName);
            }
            if (obj != null) {
                return this.mParser.generateInstrumentationInfo(obj, i);
            }
            return null;
        }
        return (InstrumentationInfo) invokeLI.objValue;
    }

    public List<InstrumentationInfo> getInstrumentationInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ArrayList(this.mInstrumentationInfoCache.values()) : (List) invokeV.objValue;
    }

    public PackageInfo getPackageInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            PackageInfo generatePackageInfo = this.mParser.generatePackageInfo(this.mHostPackageInfo.gids, i, this.mPluginFile.lastModified(), this.mPluginFile.lastModified(), new HashSet<>(getRequestedPermissions()));
            fixPackageInfo(generatePackageInfo);
            return generatePackageInfo;
        }
        return (PackageInfo) invokeI.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public PermissionGroupInfo getPermissionGroupInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, componentName, i)) == null) {
            synchronized (this.mPermissionGroupObjCache) {
                obj = this.mPermissionGroupObjCache.get(componentName);
            }
            if (obj != null) {
                return this.mParser.generatePermissionGroupInfo(obj, i);
            }
            return null;
        }
        return (PermissionGroupInfo) invokeLI.objValue;
    }

    public List<PermissionGroupInfo> getPermissionGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new ArrayList(this.mPermissionGroupInfoCache.values()) : (List) invokeV.objValue;
    }

    public PermissionInfo getPermissionInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, componentName, i)) == null) {
            synchronized (this.mPermissionsObjCache) {
                obj = this.mPermissionsObjCache.get(componentName);
            }
            if (obj != null) {
                return this.mParser.generatePermissionInfo(obj, i);
            }
            return null;
        }
        return (PermissionInfo) invokeLI.objValue;
    }

    public List<PermissionInfo> getPermissions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new ArrayList(this.mPermissionsInfoCache.values()) : (List) invokeV.objValue;
    }

    public File getPluginFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPluginFile : (File) invokeV.objValue;
    }

    public ProviderInfo getProviderInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, componentName, i)) == null) {
            synchronized (this.mProviderObjCache) {
                obj = this.mProviderObjCache.get(componentName);
            }
            if (obj != null) {
                ProviderInfo generateProviderInfo = this.mParser.generateProviderInfo(obj, i);
                fixApplicationInfo(generateProviderInfo.applicationInfo);
                if (TextUtils.isEmpty(generateProviderInfo.processName)) {
                    generateProviderInfo.processName = generateProviderInfo.packageName;
                }
                return generateProviderInfo;
            }
            return null;
        }
        return (ProviderInfo) invokeLI.objValue;
    }

    public List<IntentFilter> getProviderIntentFilter(ComponentName componentName) {
        InterceptResult invokeL;
        List<IntentFilter> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, componentName)) == null) {
            synchronized (this.mProviderObjCache) {
                list = this.mProviderIntentFilterCache.get(componentName);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public List<ProviderInfo> getProviders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new ArrayList(this.mProviderInfoCache.values()) : (List) invokeV.objValue;
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, componentName, i)) == null) {
            synchronized (this.mReceiversObjCache) {
                obj = this.mReceiversObjCache.get(componentName);
            }
            if (obj != null) {
                ActivityInfo generateReceiverInfo = this.mParser.generateReceiverInfo(obj, i);
                fixApplicationInfo(generateReceiverInfo.applicationInfo);
                if (TextUtils.isEmpty(generateReceiverInfo.processName)) {
                    generateReceiverInfo.processName = generateReceiverInfo.packageName;
                }
                return generateReceiverInfo;
            }
            return null;
        }
        return (ActivityInfo) invokeLI.objValue;
    }

    public Map<ActivityInfo, List<IntentFilter>> getReceiverIntentFilter() {
        InterceptResult invokeV;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.mReceiverIntentFilterCache) {
                hashMap = new HashMap();
                for (ComponentName componentName : this.mReceiverIntentFilterCache.keySet()) {
                    hashMap.put(this.mReceiversInfoCache.get(componentName), this.mReceiverIntentFilterCache.get(componentName));
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public List<ActivityInfo> getReceivers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new ArrayList(this.mReceiversInfoCache.values()) : (List) invokeV.objValue;
    }

    public List<String> getRequestedPermissions() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this.mRequestedPermissionsCache) {
                arrayList = new ArrayList(this.mRequestedPermissionsCache);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, componentName, i)) == null) {
            synchronized (this.mServiceObjCache) {
                obj = this.mServiceObjCache.get(componentName);
            }
            if (obj != null) {
                ServiceInfo generateServiceInfo = this.mParser.generateServiceInfo(obj, i);
                fixApplicationInfo(generateServiceInfo.applicationInfo);
                if (TextUtils.isEmpty(generateServiceInfo.processName)) {
                    generateServiceInfo.processName = generateServiceInfo.packageName;
                }
                return generateServiceInfo;
            }
            return null;
        }
        return (ServiceInfo) invokeLI.objValue;
    }

    public List<IntentFilter> getServiceIntentFilter(ComponentName componentName) {
        InterceptResult invokeL;
        List<IntentFilter> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, componentName)) == null) {
            synchronized (this.mServiceIntentFilterCache) {
                list = this.mServiceIntentFilterCache.get(componentName);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public List<ServiceInfo> getServices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? new ArrayList(this.mServiceInfoCache.values()) : (List) invokeV.objValue;
    }

    public void writeSignature(Signature[] signatureArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, signatureArr) == null) || signatureArr == null) {
            return;
        }
        this.mParser.writeSignature(signatureArr);
    }

    public List<IntentFilter> getReceiverIntentFilter(ActivityInfo activityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, activityInfo)) == null) {
            synchronized (this.mReceiverIntentFilterCache) {
                for (ComponentName componentName : this.mReceiverIntentFilterCache.keySet()) {
                    if (TextUtils.equals(activityInfo.name, this.mReceiversInfoCache.get(componentName).name)) {
                        return this.mReceiverIntentFilterCache.get(componentName);
                    }
                }
                return null;
            }
        }
        return (List) invokeL.objValue;
    }
}
