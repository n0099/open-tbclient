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
import android.os.UserHandle;
import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.ar.plugin.reflect.MethodUtils;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class PackageParserAPI22 extends PackageParser {
    public static final String TAG = "PackageParserAPI22";
    public Object mDefaultPackageUserState;
    public Object mPackage;
    public int mUserId;
    public Class<?> sActivityClass;
    public Class<?> sArraySetClass;
    public Class<?> sInstrumentationClass;
    public Class<?> sPackageParserClass;
    public Class<?> sPackageUserStateClass;
    public Class<?> sPermissionClass;
    public Class<?> sPermissionGroupClass;
    public Class<?> sProviderClass;
    public Class<?> sServiceClass;

    public PackageParserAPI22(Context context) throws Exception {
        super(context);
        initClasses();
    }

    public static int getCallingUserId() {
        try {
            return ((Integer) MethodUtils.invokeStaticMethod(UserHandle.class, "getCallingUserId", new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void initClasses() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.sPackageParserClass = Class.forName("android.content.pm.PackageParser");
        this.sActivityClass = Class.forName("android.content.pm.PackageParser$Activity");
        this.sServiceClass = Class.forName("android.content.pm.PackageParser$Service");
        this.sProviderClass = Class.forName("android.content.pm.PackageParser$Provider");
        this.sInstrumentationClass = Class.forName("android.content.pm.PackageParser$Instrumentation");
        this.sPermissionClass = Class.forName("android.content.pm.PackageParser$Permission");
        this.sPermissionGroupClass = Class.forName("android.content.pm.PackageParser$PermissionGroup");
        try {
            this.sArraySetClass = Class.forName("android.util.ArraySet");
        } catch (ClassNotFoundException unused) {
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Class<?> cls = Class.forName("android.content.pm.PackageUserState");
            this.sPackageUserStateClass = cls;
            this.mDefaultPackageUserState = cls.newInstance();
            this.mUserId = getCallingUserId();
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void collectCertificates(int i) throws Exception {
        if (Build.VERSION.SDK_INT > 27) {
            MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Boolean.TYPE).invoke(this.mPackageParser, this.mPackage, Boolean.TRUE);
        } else {
            MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Integer.TYPE).invoke(this.mPackageParser, this.mPackage, Integer.valueOf(i));
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ActivityInfo generateActivityInfo(Object obj, int i) throws Exception {
        Class<?> cls = this.sPackageParserClass;
        Class cls2 = Integer.TYPE;
        return (ActivityInfo) MethodUtils.getAccessibleMethod(cls, "generateActivityInfo", this.sActivityClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ApplicationInfo generateApplicationInfo(int i) throws Exception {
        Class<?> cls = this.sPackageParserClass;
        Class cls2 = Integer.TYPE;
        return (ApplicationInfo) MethodUtils.getAccessibleMethod(cls, "generateApplicationInfo", this.mPackage.getClass(), cls2, this.sPackageUserStateClass, cls2).invoke(null, this.mPackage, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public InstrumentationInfo generateInstrumentationInfo(Object obj, int i) throws Exception {
        return (InstrumentationInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateInstrumentationInfo", this.sInstrumentationClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0050 */
    @Override // com.baidu.ar.plugin.PackageParser
    public PackageInfo generatePackageInfo(int[] iArr, int i, long j, long j2, HashSet<String> hashSet) throws Exception {
        Object obj;
        Class<?> cls = Class.forName("java.util.Set");
        Class<?> cls2 = this.sPackageParserClass;
        Class cls3 = Long.TYPE;
        Method accessibleMethod = MethodUtils.getAccessibleMethod(cls2, "generatePackageInfo", this.mPackage.getClass(), int[].class, Integer.TYPE, cls3, cls3, cls, this.sPackageUserStateClass);
        try {
            obj = this.sArraySetClass.getConstructor(Collection.class).newInstance(hashSet);
        } catch (Exception e2) {
            e2.printStackTrace();
            obj = null;
        }
        if (obj == null) {
            obj = hashSet;
        }
        return (PackageInfo) accessibleMethod.invoke(null, this.mPackage, iArr, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), obj, this.mDefaultPackageUserState);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public PermissionGroupInfo generatePermissionGroupInfo(Object obj, int i) throws Exception {
        return (PermissionGroupInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generatePermissionGroupInfo", this.sPermissionGroupClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public PermissionInfo generatePermissionInfo(Object obj, int i) throws Exception {
        return (PermissionInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generatePermissionInfo", this.sPermissionClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ProviderInfo generateProviderInfo(Object obj, int i) throws Exception {
        Class<?> cls = this.sPackageParserClass;
        Class cls2 = Integer.TYPE;
        return (ProviderInfo) MethodUtils.getAccessibleMethod(cls, "generateProviderInfo", this.sProviderClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public /* bridge */ /* synthetic */ ActivityInfo generateReceiverInfo(Object obj, int i) throws Exception {
        return super.generateReceiverInfo(obj, i);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ServiceInfo generateServiceInfo(Object obj, int i) throws Exception {
        Class<?> cls = this.sPackageParserClass;
        Class cls2 = Integer.TYPE;
        return (ServiceInfo) MethodUtils.getAccessibleMethod(cls, "generateServiceInfo", this.sServiceClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getActivities() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "activities");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getInstrumentations() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "instrumentation");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String getPackageName() throws Exception {
        return (String) FieldUtils.readField(this.mPackage, InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissionGroups() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "permissionGroups");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissions() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "permissions");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getProviders() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "providers");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getReceivers() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "receivers");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getRequestedPermissions() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "requestedPermissions");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getServices() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "services");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void parsePackage(File file, int i) throws Exception {
        Object newInstance = this.sPackageParserClass.newInstance();
        this.mPackageParser = newInstance;
        this.mPackage = MethodUtils.invokeMethod(newInstance, "parsePackage", file, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List<IntentFilter> readIntentFilterFromComponent(Object obj) throws Exception {
        return (List) FieldUtils.readField(obj, "intents");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String readNameFromComponent(Object obj) throws Exception {
        return (String) FieldUtils.readField(obj, PushClientConstants.TAG_CLASS_NAME);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void writeSignature(Signature[] signatureArr) throws Exception {
        FieldUtils.writeField(this.mPackage, "mSignatures", signatureArr);
    }
}
