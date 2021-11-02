package com.baidu.adp.plugin.proxy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class PackageMangerProxy extends PackageManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mPackageName;
    public String mPluginPackageName;
    public PackageManager mPm;

    public PackageMangerProxy(PackageManager packageManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPm = null;
        this.mPackageName = null;
        this.mPluginPackageName = null;
        this.mPm = packageManager;
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void addPackageToPreferred(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mPm.addPackageToPreferred(str);
        }
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, permissionInfo)) == null) ? this.mPm.addPermission(permissionInfo) : invokeL.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, permissionInfo)) == null) ? this.mPm.addPermissionAsync(permissionInfo) : invokeL.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void addPreferredActivity(IntentFilter intentFilter, int i2, ComponentName[] componentNameArr, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, intentFilter, i2, componentNameArr, componentName) == null) {
            this.mPm.addPreferredActivity(intentFilter, i2, componentNameArr, componentName);
        }
    }

    @Override // android.content.pm.PackageManager
    public boolean canRequestPackageInstalls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) ? this.mPm.canonicalToCurrentPackageNames(strArr) : (String[]) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? this.mPm.checkPermission(str, str2) : invokeLL.intValue;
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) ? this.mPm.checkSignatures(str, str2) : invokeLL.intValue;
    }

    @Override // android.content.pm.PackageManager
    public void clearInstantAppCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mPm.clearPackagePreferredActivities(str);
        }
    }

    @Override // android.content.pm.PackageManager
    public String[] currentToCanonicalPackageNames(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, strArr)) == null) ? this.mPm.currentToCanonicalPackageNames(strArr) : (String[]) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public void extendVerificationTimeout(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
        }
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, componentName)) == null) {
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityBanner(Intent intent) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, intent)) == null) {
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, intent)) == null) ? this.mPm.getActivityIcon(intent) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, componentName, i2)) == null) ? this.mPm.getActivityInfo(componentName, i2) : (ActivityInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, componentName)) == null) ? this.mPm.getActivityLogo(componentName) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionGroupInfo> getAllPermissionGroups(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.mPm.getAllPermissionGroups(i2) : (List) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, applicationInfo)) == null) {
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationBanner(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? this.mPm.getApplicationEnabledSetting(str) : invokeL.intValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, applicationInfo)) == null) ? this.mPm.getApplicationIcon(applicationInfo) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i2)) == null) ? this.mPm.getApplicationInfo(str, i2) : (ApplicationInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, applicationInfo)) == null) ? this.mPm.getApplicationLabel(applicationInfo) : (CharSequence) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, applicationInfo)) == null) ? this.mPm.getApplicationLogo(applicationInfo) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ChangedPackages getChangedPackages(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            return null;
        }
        return (ChangedPackages) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, componentName)) == null) ? this.mPm.getComponentEnabledSetting(componentName) : invokeL.intValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPm.getDefaultActivityIcon() : (Drawable) invokeV.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i2, ApplicationInfo applicationInfo) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048609, this, str, i2, applicationInfo)) == null) ? this.mPm.getDrawable(str, i2, applicationInfo) : (Drawable) invokeLIL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ApplicationInfo> getInstalledApplications(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) ? this.mPm.getInstalledApplications(i2) : (List) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getInstalledPackages(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? this.mPm.getInstalledPackages(i2) : (List) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) ? this.mPm.getInstallerPackageName(str) : (String) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    @NonNull
    public byte[] getInstantAppCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? new byte[0] : (byte[]) invokeV.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int getInstantAppCookieMaxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, componentName, i2)) == null) ? this.mPm.getInstrumentationInfo(componentName, i2) : (InstrumentationInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) ? this.mPm.getLaunchIntentForPackage(str) : (Intent) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Intent getLeanbackLaunchIntentForPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) ? this.mPm.getNameForUid(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageArchiveInfo(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048619, this, str, i2)) == null) ? this.mPm.getPackageArchiveInfo(str, i2) : (PackageInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) ? this.mPm.getPackageGids(str) : (int[]) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048621, this, str, i2)) == null) ? new int[0] : (int[]) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048622, this, versionedPackage, i2)) == null) {
            return null;
        }
        return (PackageInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048623, this, str, i2)) == null) {
            if (TextUtils.equals(this.mPackageName, str) && (plugin2 = PluginCenter.getInstance().getPlugin(this.mPluginPackageName)) != null) {
                return plugin2.getPluginPackageInfo();
            }
            return this.mPm.getPackageInfo(str, i2);
        }
        return (PackageInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PackageInstaller getPackageInstaller() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (PackageInstaller) invokeV.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int getPackageUid(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048625, this, str, i2)) == null) {
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) ? this.mPm.getPackagesForUid(i2) : (String[]) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048627, this, strArr, i2)) == null) {
            return null;
        }
        return (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048628, this, str, i2)) == null) ? this.mPm.getPermissionGroupInfo(str, i2) : (PermissionGroupInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048629, this, str, i2)) == null) ? this.mPm.getPermissionInfo(str, i2) : (PermissionInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048630, this, list, list2, str)) == null) ? this.mPm.getPreferredActivities(list, list2, str) : invokeLLL.intValue;
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPreferredPackages(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) ? this.mPm.getPreferredPackages(i2) : (List) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo getProviderInfo(ComponentName componentName, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048632, this, componentName, i2)) == null) ? this.mPm.getProviderInfo(componentName, i2) : (ProviderInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048633, this, componentName, i2)) == null) ? this.mPm.getReceiverInfo(componentName, i2) : (ActivityInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, componentName)) == null) ? this.mPm.getResourcesForActivity(componentName) : (Resources) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, applicationInfo)) == null) ? this.mPm.getResourcesForApplication(applicationInfo) : (Resources) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048637, this, componentName, i2)) == null) ? this.mPm.getServiceInfo(componentName, i2) : (ServiceInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<SharedLibraryInfo> getSharedLibraries(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
            return null;
        }
        return (List) invokeI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mPm.getSystemAvailableFeatures() : (FeatureInfo[]) invokeV.objValue;
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mPm.getSystemSharedLibraryNames() : (String[]) invokeV.objValue;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i2, ApplicationInfo applicationInfo) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048641, this, str, i2, applicationInfo)) == null) ? this.mPm.getText(str, i2, applicationInfo) : (CharSequence) invokeLIL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048642, this, drawable, userHandle, rect, i2)) == null) {
            return null;
        }
        return (Drawable) invokeLLLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, drawable, userHandle)) == null) {
            return null;
        }
        return (Drawable) invokeLL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, charSequence, userHandle)) == null) {
            return null;
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i2, ApplicationInfo applicationInfo) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048645, this, str, i2, applicationInfo)) == null) ? this.mPm.getXml(str, i2, applicationInfo) : (XmlResourceParser) invokeLIL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, str)) == null) ? this.mPm.hasSystemFeature(str) : invokeL.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048647, this, str, i2)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean isInstantApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048650, this, str, str2)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.mPm.isSafeMode() : invokeV.booleanValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048652, this, intent, i2)) == null) ? this.mPm.queryBroadcastReceivers(intent, i2) : (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ProviderInfo> queryContentProviders(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048653, this, str, i2, i3)) == null) ? this.mPm.queryContentProviders(str, i2, i3) : (List) invokeLII.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<InstrumentationInfo> queryInstrumentation(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048654, this, str, i2)) == null) {
            return null;
        }
        return (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048655, this, intent, i2)) == null) ? this.mPm.queryIntentActivities(intent, i2) : (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048656, this, componentName, intentArr, intent, i2)) == null) ? this.mPm.queryIntentActivityOptions(componentName, intentArr, intent, i2) : (List) invokeLLLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048657, this, intent, i2)) == null) {
            return null;
        }
        return (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentServices(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048658, this, intent, i2)) == null) ? this.mPm.queryIntentServices(intent, i2) : (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionInfo> queryPermissionsByGroup(String str, int i2) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048659, this, str, i2)) == null) ? this.mPm.queryPermissionsByGroup(str, i2) : (List) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void removePackageFromPreferred(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.mPm.removePackageFromPreferred(str);
        }
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.mPm.removePermission(str);
        }
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048662, this, intent, i2)) == null) ? this.mPm.resolveActivity(intent, i2) : (ResolveInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048663, this, str, i2)) == null) ? this.mPm.resolveContentProvider(str, i2) : (ProviderInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048664, this, intent, i2)) == null) ? this.mPm.resolveService(intent, i2) : (ResolveInfo) invokeLI.objValue;
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationCategoryHint(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048665, this, str, i2) == null) {
        }
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048666, this, str, i2, i3) == null) {
            this.mPm.setApplicationEnabledSetting(str, i2, i3);
        }
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048667, this, componentName, i2, i3) == null) {
            this.mPm.setComponentEnabledSetting(componentName, i2, i3);
        }
    }

    @Override // android.content.pm.PackageManager
    public void setInstallerPackageName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, str, str2) == null) {
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.mPackageName = str;
        }
    }

    public void setPluginPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.mPluginPackageName = str;
        }
    }

    @Override // android.content.pm.PackageManager
    public void updateInstantAppCookie(@Nullable byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, bArr) == null) {
        }
    }

    @Override // android.content.pm.PackageManager
    public void verifyPendingInstall(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048672, this, i2, i3) == null) {
            this.mPm.verifyPendingInstall(i2, i3);
        }
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.mPm.checkSignatures(i2, i3) : invokeII.intValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, componentName)) == null) ? this.mPm.getActivityIcon(componentName) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityLogo(Intent intent) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, intent)) == null) ? this.mPm.getActivityLogo(intent) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? this.mPm.getApplicationIcon(str) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationLogo(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? this.mPm.getApplicationLogo(str) : (Drawable) invokeL.objValue;
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) ? this.mPm.getResourcesForApplication(str) : (Resources) invokeL.objValue;
    }
}
