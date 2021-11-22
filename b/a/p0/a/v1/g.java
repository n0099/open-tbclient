package b.a.p0.a.v1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9172c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f9173d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<a> f9174a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f9175b;

    /* loaded from: classes.dex */
    public interface a {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337524882, "Lb/a/p0/a/v1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337524882, "Lb/a/p0/a/v1/g;");
                return;
            }
        }
        f9172c = k.f6863a;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9174a = new SparseArray<>();
        this.f9175b = new HashSet();
    }

    @NonNull
    public static int[] b(@NonNull Activity activity, @Nullable String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, strArr)) == null) {
            if (strArr == null || strArr.length == 0) {
                return new int[0];
            }
            int[] iArr = new int[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                iArr[i2] = b.a.p0.x.d.c.a(activity, strArr[i2]) ? 0 : -1;
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public static g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9173d == null) {
                synchronized (g.class) {
                    if (f9173d == null) {
                        f9173d = new g();
                    }
                }
            }
            return f9173d;
        }
        return (g) invokeV.objValue;
    }

    @Nullable
    public static String d(@NonNull Activity activity, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, strArr)) == null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr[i2];
                if (!b.a.p0.x.d.c.a(activity, str) && (b.a.p0.r.a.a.a.j(activity, str) || !e(str))) {
                    return str;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            b.a.p0.a.o2.g.b a2 = h.a();
            return a2.getBoolean("first#" + str, false);
        }
        return invokeL.booleanValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            b.a.p0.a.o2.g.b a2 = h.a();
            a2.putBoolean("first#" + str, true);
        }
    }

    public final boolean a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.f9175b.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, i2, strArr, iArr) == null) {
            boolean z = !a(strArr);
            if (Build.VERSION.SDK_INT >= 23) {
                h(activity, strArr, iArr);
            }
            a aVar = this.f9174a.get(i2);
            if (aVar != null) {
                this.f9174a.remove(i2);
                if ((aVar instanceof b) && z) {
                    aVar = ((b) aVar).s();
                }
                aVar.onRequestPermissionsResult(i2, strArr, iArr);
            }
            if (f9172c) {
                String str = "onRequestPermissionsResult requestCode: " + i2 + " permissions: " + Arrays.toString(strArr);
                String str2 = "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr);
            }
        }
    }

    @RequiresApi(api = 23)
    public final void h(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, strArr, iArr) == null) || Build.VERSION.SDK_INT < 23 || activity == null || (length = strArr.length) != iArr.length || length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            String str = strArr[i2];
            if (!TextUtils.isEmpty(str) && i3 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                this.f9175b.add(str);
            }
        }
    }

    @TargetApi(23)
    public void requestPermissions(Activity activity, int i2, @NonNull String[] strArr, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048579, this, activity, i2, strArr, aVar) == null) || aVar == null || activity == null) {
            return;
        }
        String d2 = d(activity, strArr);
        if (d2 != null) {
            this.f9174a.put(i2, aVar);
            activity.requestPermissions(strArr, i2);
            g(d2);
        } else {
            aVar.onRequestPermissionsResult(i2, strArr, b(activity, strArr));
        }
        if (f9172c) {
            String str = "requestPermissions activity: " + activity + " requestCode: " + i2 + " permissions: " + Arrays.toString(strArr);
        }
    }
}
