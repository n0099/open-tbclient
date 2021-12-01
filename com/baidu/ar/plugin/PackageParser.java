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
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class PackageParser {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Object mPackageParser;

    public PackageParser(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static PackageParser newPluginParser(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                return new PackageParserAPI22(context);
            }
            return null;
        }
        return (PackageParser) invokeL.objValue;
    }

    public abstract void collectCertificates(int i2);

    public abstract ActivityInfo generateActivityInfo(Object obj, int i2);

    public abstract ApplicationInfo generateApplicationInfo(int i2);

    public abstract InstrumentationInfo generateInstrumentationInfo(Object obj, int i2);

    public abstract PackageInfo generatePackageInfo(int[] iArr, int i2, long j2, long j3, HashSet<String> hashSet);

    public abstract PermissionGroupInfo generatePermissionGroupInfo(Object obj, int i2);

    public abstract PermissionInfo generatePermissionInfo(Object obj, int i2);

    public abstract ProviderInfo generateProviderInfo(Object obj, int i2);

    public ActivityInfo generateReceiverInfo(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) ? generateActivityInfo(obj, i2) : (ActivityInfo) invokeLI.objValue;
    }

    public abstract ServiceInfo generateServiceInfo(Object obj, int i2);

    public abstract List getActivities();

    public abstract List getInstrumentations();

    public abstract String getPackageName();

    public abstract List getPermissionGroups();

    public abstract List getPermissions();

    public abstract List getProviders();

    public abstract List getReceivers();

    public abstract List getRequestedPermissions();

    public abstract List getServices();

    public abstract void parsePackage(File file, int i2);

    public abstract List<IntentFilter> readIntentFilterFromComponent(Object obj);

    public abstract String readNameFromComponent(Object obj);

    public abstract void writeSignature(Signature[] signatureArr);
}
