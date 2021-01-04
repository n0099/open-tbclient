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
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class PackageParserAPI22 extends PackageParser {
    private static final String TAG = PackageParserAPI22.class.getSimpleName();
    protected Object mDefaultPackageUserState;
    protected Object mPackage;
    protected int mUserId;
    protected Class<?> sActivityClass;
    protected Class<?> sArraySetClass;
    protected Class<?> sInstrumentationClass;
    protected Class<?> sPackageParserClass;
    protected Class<?> sPackageUserStateClass;
    protected Class<?> sPermissionClass;
    protected Class<?> sPermissionGroupClass;
    protected Class<?> sProviderClass;
    protected Class<?> sServiceClass;

    @Override // com.baidu.ar.plugin.PackageParser
    public /* bridge */ /* synthetic */ ActivityInfo generateReceiverInfo(Object obj, int i) throws Exception {
        return super.generateReceiverInfo(obj, i);
    }

    public PackageParserAPI22(Context context) throws Exception {
        super(context);
        initClasses();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.ar.plugin.PackageParser
    public PackageInfo generatePackageInfo(int[] iArr, int i, long j, long j2, HashSet<String> hashSet) throws Exception {
        HashSet<String> hashSet2;
        Method accessibleMethod = MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generatePackageInfo", this.mPackage.getClass(), int[].class, Integer.TYPE, Long.TYPE, Long.TYPE, Class.forName("java.util.Set"), this.sPackageUserStateClass);
        try {
            hashSet2 = this.sArraySetClass.getConstructor(Collection.class).newInstance(hashSet);
        } catch (Exception e) {
            e.printStackTrace();
            hashSet2 = null;
        }
        if (hashSet2 != null) {
            hashSet = hashSet2;
        }
        return (PackageInfo) accessibleMethod.invoke(null, this.mPackage, iArr, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), hashSet, this.mDefaultPackageUserState);
    }

    public static int getCallingUserId() {
        try {
            return ((Integer) MethodUtils.invokeStaticMethod(UserHandle.class, "getCallingUserId", new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (ClassNotFoundException e) {
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.sPackageUserStateClass = Class.forName("android.content.pm.PackageUserState");
            this.mDefaultPackageUserState = this.sPackageUserStateClass.newInstance();
            this.mUserId = getCallingUserId();
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void parsePackage(File file, int i) throws Exception {
        this.mPackageParser = this.sPackageParserClass.newInstance();
        this.mPackage = MethodUtils.invokeMethod(this.mPackageParser, "parsePackage", file, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void collectCertificates(int i) throws Exception {
        if (Build.VERSION.SDK_INT > 27) {
            MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Boolean.TYPE).invoke(this.mPackageParser, this.mPackage, true);
        } else {
            MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Integer.TYPE).invoke(this.mPackageParser, this.mPackage, Integer.valueOf(i));
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ActivityInfo generateActivityInfo(Object obj, int i) throws Exception {
        return (ActivityInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateActivityInfo", this.sActivityClass, Integer.TYPE, this.sPackageUserStateClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ServiceInfo generateServiceInfo(Object obj, int i) throws Exception {
        return (ServiceInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateServiceInfo", this.sServiceClass, Integer.TYPE, this.sPackageUserStateClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ProviderInfo generateProviderInfo(Object obj, int i) throws Exception {
        return (ProviderInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateProviderInfo", this.sProviderClass, Integer.TYPE, this.sPackageUserStateClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public InstrumentationInfo generateInstrumentationInfo(Object obj, int i) throws Exception {
        return (InstrumentationInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateInstrumentationInfo", this.sInstrumentationClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ApplicationInfo generateApplicationInfo(int i) throws Exception {
        return (ApplicationInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateApplicationInfo", this.mPackage.getClass(), Integer.TYPE, this.sPackageUserStateClass, Integer.TYPE).invoke(null, this.mPackage, Integer.valueOf(i), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
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
    public List getActivities() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "activities");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getServices() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "services");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getProviders() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "providers");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissions() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "permissions");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissionGroups() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "permissionGroups");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getRequestedPermissions() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "requestedPermissions");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getReceivers() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "receivers");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getInstrumentations() throws Exception {
        return (List) FieldUtils.readField(this.mPackage, "instrumentation");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String getPackageName() throws Exception {
        return (String) FieldUtils.readField(this.mPackage, "packageName");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String readNameFromComponent(Object obj) throws Exception {
        return (String) FieldUtils.readField(obj, PushClientConstants.TAG_CLASS_NAME);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List<IntentFilter> readIntentFilterFromComponent(Object obj) throws Exception {
        return (List) FieldUtils.readField(obj, "intents");
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void writeSignature(Signature[] signatureArr) throws Exception {
        FieldUtils.writeField(this.mPackage, "mSignatures", signatureArr);
    }
}
