package com.baidu.adp.plugin.proxy;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PackageManager {
    private PackageManager EB;
    private String mPackageName = null;
    private String EC = null;

    public a(PackageManager packageManager) {
        this.EB = null;
        this.EB = packageManager;
    }

    public void setPluginPackageName(String str) {
        this.EC = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageInfo(String str, int i) {
        com.baidu.adp.plugin.a plugin2;
        return (!TextUtils.equals(this.mPackageName, str) || (plugin2 = PluginCenter.getInstance().getPlugin(this.EC)) == null) ? this.EB.getPackageInfo(str, i) : plugin2.kt();
    }

    @Override // android.content.pm.PackageManager
    public Intent getLaunchIntentForPackage(String str) {
        return this.EB.getLaunchIntentForPackage(str);
    }

    @Override // android.content.pm.PackageManager
    public int[] getPackageGids(String str) {
        return this.EB.getPackageGids(str);
    }

    @Override // android.content.pm.PackageManager
    public PermissionInfo getPermissionInfo(String str, int i) {
        return this.EB.getPermissionInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionInfo> queryPermissionsByGroup(String str, int i) {
        return this.EB.queryPermissionsByGroup(str, i);
    }

    @Override // android.content.pm.PackageManager
    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) {
        return this.EB.getPermissionGroupInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        return this.EB.getAllPermissionGroups(i);
    }

    @Override // android.content.pm.PackageManager
    public ApplicationInfo getApplicationInfo(String str, int i) {
        return this.EB.getApplicationInfo(str, i);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        return this.EB.getActivityInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        return this.EB.getReceiverInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        return this.EB.getServiceInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getInstalledPackages(int i) {
        return this.EB.getInstalledPackages(i);
    }

    @Override // android.content.pm.PackageManager
    public int checkPermission(String str, String str2) {
        return this.EB.checkPermission(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public boolean addPermission(PermissionInfo permissionInfo) {
        return this.EB.addPermission(permissionInfo);
    }

    @Override // android.content.pm.PackageManager
    public void removePermission(String str) {
        this.EB.removePermission(str);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(String str, String str2) {
        return this.EB.checkSignatures(str, str2);
    }

    @Override // android.content.pm.PackageManager
    public int checkSignatures(int i, int i2) {
        return this.EB.checkSignatures(i, i2);
    }

    @Override // android.content.pm.PackageManager
    public String[] getPackagesForUid(int i) {
        return this.EB.getPackagesForUid(i);
    }

    @Override // android.content.pm.PackageManager
    public String getNameForUid(int i) {
        return this.EB.getNameForUid(i);
    }

    @Override // android.content.pm.PackageManager
    public List<ApplicationInfo> getInstalledApplications(int i) {
        return this.EB.getInstalledApplications(i);
    }

    @Override // android.content.pm.PackageManager
    public String[] getSystemSharedLibraryNames() {
        return this.EB.getSystemSharedLibraryNames();
    }

    @Override // android.content.pm.PackageManager
    public FeatureInfo[] getSystemAvailableFeatures() {
        return this.EB.getSystemAvailableFeatures();
    }

    @Override // android.content.pm.PackageManager
    public boolean hasSystemFeature(String str) {
        return this.EB.hasSystemFeature(str);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveActivity(Intent intent, int i) {
        return this.EB.resolveActivity(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        return this.EB.queryIntentActivities(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return this.EB.queryIntentActivityOptions(componentName, intentArr, intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        return this.EB.queryBroadcastReceivers(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public ResolveInfo resolveService(Intent intent, int i) {
        return this.EB.resolveService(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        return this.EB.queryIntentServices(intent, i);
    }

    @Override // android.content.pm.PackageManager
    public ProviderInfo resolveContentProvider(String str, int i) {
        return this.EB.resolveContentProvider(str, i);
    }

    @Override // android.content.pm.PackageManager
    public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
        return this.EB.queryContentProviders(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) {
        return this.EB.getInstrumentationInfo(componentName, i);
    }

    @Override // android.content.pm.PackageManager
    public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
        return null;
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        return this.EB.getDrawable(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(Intent intent) {
        return this.EB.getActivityIcon(intent);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getDefaultActivityIcon() {
        return this.EB.getDefaultActivityIcon();
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return this.EB.getApplicationIcon(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getApplicationIcon(String str) {
        return this.EB.getApplicationIcon(str);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        return this.EB.getText(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        return this.EB.getXml(str, i, applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return this.EB.getApplicationLabel(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForActivity(ComponentName componentName) {
        return this.EB.getResourcesForActivity(componentName);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) {
        return this.EB.getResourcesForApplication(applicationInfo);
    }

    @Override // android.content.pm.PackageManager
    public Resources getResourcesForApplication(String str) {
        return this.EB.getResourcesForApplication(str);
    }

    @Override // android.content.pm.PackageManager
    public String getInstallerPackageName(String str) {
        return this.EB.getInstallerPackageName(str);
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void addPackageToPreferred(String str) {
        this.EB.addPackageToPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void removePackageFromPreferred(String str) {
        this.EB.removePackageFromPreferred(str);
    }

    @Override // android.content.pm.PackageManager
    public List<PackageInfo> getPreferredPackages(int i) {
        return this.EB.getPreferredPackages(i);
    }

    @Override // android.content.pm.PackageManager
    @Deprecated
    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        this.EB.addPreferredActivity(intentFilter, i, componentNameArr, componentName);
    }

    @Override // android.content.pm.PackageManager
    public void clearPackagePreferredActivities(String str) {
        this.EB.clearPackagePreferredActivities(str);
    }

    @Override // android.content.pm.PackageManager
    public Drawable getActivityIcon(ComponentName componentName) {
        return this.EB.getActivityIcon(componentName);
    }

    @Override // android.content.pm.PackageManager
    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return this.EB.getPreferredActivities(list, list2, str);
    }

    @Override // android.content.pm.PackageManager
    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
        this.EB.setComponentEnabledSetting(componentName, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public int getComponentEnabledSetting(ComponentName componentName) {
        return this.EB.getComponentEnabledSetting(componentName);
    }

    @Override // android.content.pm.PackageManager
    public void setApplicationEnabledSetting(String str, int i, int i2) {
        this.EB.setApplicationEnabledSetting(str, i, i2);
    }

    @Override // android.content.pm.PackageManager
    public int getApplicationEnabledSetting(String str) {
        return this.EB.getApplicationEnabledSetting(str);
    }

    @Override // android.content.pm.PackageManager
    public boolean isSafeMode() {
        return this.EB.isSafeMode();
    }

    @Override // android.content.pm.PackageManager
    public PackageInfo getPackageArchiveInfo(String str, int i) {
        return this.EB.getPackageArchiveInfo(str, i);
    }
}
