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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.ar.plugin.reflect.MethodUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class PackageParserAPI22 extends PackageParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PackageParserAPI22";
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(484978010, "Lcom/baidu/ar/plugin/PackageParserAPI22;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(484978010, "Lcom/baidu/ar/plugin/PackageParserAPI22;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackageParserAPI22(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initClasses();
    }

    public static int getCallingUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return ((Integer) MethodUtils.invokeStaticMethod(UserHandle.class, "getCallingUserId", new Object[0])).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    private void initClasses() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
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
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void collectCertificates(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (Build.VERSION.SDK_INT > 27) {
                MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Boolean.TYPE).invoke(this.mPackageParser, this.mPackage, Boolean.TRUE);
            } else {
                MethodUtils.getAccessibleMethod(this.sPackageParserClass, "collectCertificates", this.mPackage.getClass(), Integer.TYPE).invoke(this.mPackageParser, this.mPackage, Integer.valueOf(i2));
            }
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ActivityInfo generateActivityInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2)) == null) {
            Class<?> cls = this.sPackageParserClass;
            Class cls2 = Integer.TYPE;
            return (ActivityInfo) MethodUtils.getAccessibleMethod(cls, "generateActivityInfo", this.sActivityClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i2), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
        }
        return (ActivityInfo) invokeLI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ApplicationInfo generateApplicationInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Class<?> cls = this.sPackageParserClass;
            Class cls2 = Integer.TYPE;
            return (ApplicationInfo) MethodUtils.getAccessibleMethod(cls, "generateApplicationInfo", this.mPackage.getClass(), cls2, this.sPackageUserStateClass, cls2).invoke(null, this.mPackage, Integer.valueOf(i2), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
        }
        return (ApplicationInfo) invokeI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public InstrumentationInfo generateInstrumentationInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, obj, i2)) == null) ? (InstrumentationInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generateInstrumentationInfo", this.sInstrumentationClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i2)) : (InstrumentationInfo) invokeLI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x0054 */
    @Override // com.baidu.ar.plugin.PackageParser
    public PackageInfo generatePackageInfo(int[] iArr, int i2, long j2, long j3, HashSet<String> hashSet) {
        InterceptResult invokeCommon;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{iArr, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), hashSet})) == null) {
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
            return (PackageInfo) accessibleMethod.invoke(null, this.mPackage, iArr, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), obj, this.mDefaultPackageUserState);
        }
        return (PackageInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public PermissionGroupInfo generatePermissionGroupInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, obj, i2)) == null) ? (PermissionGroupInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generatePermissionGroupInfo", this.sPermissionGroupClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i2)) : (PermissionGroupInfo) invokeLI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public PermissionInfo generatePermissionInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, obj, i2)) == null) ? (PermissionInfo) MethodUtils.getAccessibleMethod(this.sPackageParserClass, "generatePermissionInfo", this.sPermissionClass, Integer.TYPE).invoke(null, obj, Integer.valueOf(i2)) : (PermissionInfo) invokeLI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ProviderInfo generateProviderInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, obj, i2)) == null) {
            Class<?> cls = this.sPackageParserClass;
            Class cls2 = Integer.TYPE;
            return (ProviderInfo) MethodUtils.getAccessibleMethod(cls, "generateProviderInfo", this.sProviderClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i2), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
        }
        return (ProviderInfo) invokeLI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public /* bridge */ /* synthetic */ ActivityInfo generateReceiverInfo(Object obj, int i2) {
        return super.generateReceiverInfo(obj, i2);
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public ServiceInfo generateServiceInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, obj, i2)) == null) {
            Class<?> cls = this.sPackageParserClass;
            Class cls2 = Integer.TYPE;
            return (ServiceInfo) MethodUtils.getAccessibleMethod(cls, "generateServiceInfo", this.sServiceClass, cls2, this.sPackageUserStateClass, cls2).invoke(null, obj, Integer.valueOf(i2), this.mDefaultPackageUserState, Integer.valueOf(this.mUserId));
        }
        return (ServiceInfo) invokeLI.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getActivities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "activities") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getInstrumentations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "instrumentation") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (String) FieldUtils.readField(this.mPackage, "packageName") : (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissionGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "permissionGroups") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getPermissions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "permissions") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getProviders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "providers") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getReceivers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "receivers") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getRequestedPermissions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "requestedPermissions") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List getServices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (List) FieldUtils.readField(this.mPackage, "services") : (List) invokeV.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void parsePackage(File file, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, file, i2) == null) {
            Object newInstance = this.sPackageParserClass.newInstance();
            this.mPackageParser = newInstance;
            this.mPackage = MethodUtils.invokeMethod(newInstance, "parsePackage", file, Integer.valueOf(i2));
        }
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public List<IntentFilter> readIntentFilterFromComponent(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? (List) FieldUtils.readField(obj, "intents") : (List) invokeL.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public String readNameFromComponent(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) ? (String) FieldUtils.readField(obj, PushClientConstants.TAG_CLASS_NAME) : (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.plugin.PackageParser
    public void writeSignature(Signature[] signatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, signatureArr) == null) {
            FieldUtils.writeField(this.mPackage, "mSignatures", signatureArr);
        }
    }
}
