package c.f.b.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.session.XRSessionAnchor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes3.dex */
public final class f extends ArCoreApk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h */
    public static final f f23295h;
    public transient /* synthetic */ FieldHolder $fh;
    public Exception a;

    /* renamed from: b */
    public ArCoreApk.Availability f23296b;

    /* renamed from: c */
    public boolean f23297c;

    /* renamed from: d */
    public l f23298d;

    /* renamed from: e */
    public boolean f23299e;

    /* renamed from: f */
    public boolean f23300f;

    /* renamed from: g */
    public int f23301g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1462303279, "Lc/f/b/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1462303279, "Lc/f/b/a/f;");
                return;
            }
        }
        f23295h = new f();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f23295h : (f) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(XRSessionAnchor.apkinfo, 4);
                int i = packageInfo.versionCode;
                if (i == 0) {
                    if (packageInfo.services != null) {
                        if (packageInfo.services.length == 0) {
                        }
                    }
                    return -1;
                }
                return i;
            } catch (PackageManager.NameNotFoundException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.google.ar.core.ArCoreApk
    public final ArCoreApk.Availability a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (!i()) {
                return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
            }
            try {
                if (h(context)) {
                    g();
                    return e.c(context);
                }
                synchronized (this) {
                    if ((this.f23296b == null || this.f23296b.isUnknown()) && !this.f23297c) {
                        this.f23297c = true;
                        e eVar = new e(this);
                        if (h(context)) {
                            eVar.a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                        } else if (k(context) != -1) {
                            eVar.a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                        } else if (j(context)) {
                            eVar.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                        } else {
                            e(context).e(context, eVar);
                        }
                    }
                    if (this.f23296b != null) {
                        return this.f23296b;
                    }
                    if (this.f23297c) {
                        return ArCoreApk.Availability.UNKNOWN_CHECKING;
                    }
                    Log.e("ARCore-ArCoreApk", "request not running but result is null?");
                    return ArCoreApk.Availability.UNKNOWN_ERROR;
                }
            } catch (FatalException e2) {
                Log.e("ARCore-ArCoreApk", "Error while checking app details and ARCore status", e2);
                return ArCoreApk.Availability.UNKNOWN_ERROR;
            }
        }
        return (ArCoreApk.Availability) invokeL.objValue;
    }

    public final synchronized l e(Context context) {
        InterceptResult invokeL;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            synchronized (this) {
                if (this.f23298d == null) {
                    l lVar2 = new l((byte) 0);
                    lVar2.d(context.getApplicationContext());
                    this.f23298d = lVar2;
                }
                lVar = this.f23298d;
            }
            return lVar;
        }
        return (l) invokeL.objValue;
    }

    public final synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Exception exc = this.a;
                if (this.f23298d != null) {
                    this.f23298d.a();
                    this.f23298d = null;
                }
            }
        }
    }

    public final boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            l(context);
            return k(context) == 0 || k(context) >= this.f23301g;
        }
        return invokeL.booleanValue;
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            l(context);
            return this.f23300f;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (this.f23299e) {
                    return;
                }
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                try {
                    Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
                    if (bundle.containsKey(XRSessionAnchor.apkinfo)) {
                        this.f23300f = bundle.getString(XRSessionAnchor.apkinfo).equals("required");
                        if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                            this.f23301g = bundle.getInt("com.google.ar.core.min_apk_version");
                            try {
                                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                                String canonicalName = InstallActivity.class.getCanonicalName();
                                int length = activityInfoArr.length;
                                boolean z = false;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                        z = true;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (!z) {
                                    String valueOf = String.valueOf(canonicalName);
                                    throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                                } else {
                                    this.f23299e = true;
                                    return;
                                }
                            } catch (PackageManager.NameNotFoundException e2) {
                                throw new FatalException("Could not load application package info", e2);
                            }
                        }
                        throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                    }
                    throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
                } catch (PackageManager.NameNotFoundException e3) {
                    throw new FatalException("Could not load application package metadata", e3);
                }
            }
        }
    }
}
