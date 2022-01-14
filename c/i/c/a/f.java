package c.i.c.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
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
/* loaded from: classes9.dex */
public final class f extends ArCoreApk {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h */
    public static final f f29979h;
    public transient /* synthetic */ FieldHolder $fh;
    public Exception a;

    /* renamed from: b */
    public ArCoreApk.Availability f29980b;

    /* renamed from: c */
    public boolean f29981c;

    /* renamed from: d */
    public l f29982d;

    /* renamed from: e */
    public boolean f29983e;

    /* renamed from: f */
    public boolean f29984f;

    /* renamed from: g */
    public int f29985g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500210419, "Lc/i/c/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-500210419, "Lc/i/c/a/f;");
                return;
            }
        }
        f29979h = new f();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f29979h : (f) invokeV.objValue;
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
                int i2 = packageInfo.versionCode;
                if (i2 == 0) {
                    if (packageInfo.services != null) {
                        if (packageInfo.services.length == 0) {
                        }
                    }
                    return -1;
                }
                return i2;
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
                    if ((this.f29980b == null || this.f29980b.isUnknown()) && !this.f29981c) {
                        this.f29981c = true;
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
                    if (this.f29980b != null) {
                        return this.f29980b;
                    }
                    if (this.f29981c) {
                        return ArCoreApk.Availability.UNKNOWN_CHECKING;
                    }
                    return ArCoreApk.Availability.UNKNOWN_ERROR;
                }
            } catch (FatalException unused) {
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
                if (this.f29982d == null) {
                    l lVar2 = new l((byte) 0);
                    lVar2.d(context.getApplicationContext());
                    this.f29982d = lVar2;
                }
                lVar = this.f29982d;
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
                if (this.f29982d != null) {
                    this.f29982d.a();
                    this.f29982d = null;
                }
            }
        }
    }

    public final boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            l(context);
            return k(context) == 0 || k(context) >= this.f29985g;
        }
        return invokeL.booleanValue;
    }

    public final boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            l(context);
            return this.f29984f;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            synchronized (this) {
                if (this.f29983e) {
                    return;
                }
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                try {
                    Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
                    if (bundle.containsKey(XRSessionAnchor.apkinfo)) {
                        this.f29984f = bundle.getString(XRSessionAnchor.apkinfo).equals("required");
                        if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                            this.f29985g = bundle.getInt("com.google.ar.core.min_apk_version");
                            try {
                                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                                String canonicalName = InstallActivity.class.getCanonicalName();
                                int length = activityInfoArr.length;
                                boolean z = false;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        break;
                                    } else if (canonicalName.equals(activityInfoArr[i2].name)) {
                                        z = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (!z) {
                                    String valueOf = String.valueOf(canonicalName);
                                    throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                                } else {
                                    this.f29983e = true;
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
