package b.a.p0.o.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.o.a.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends b.a.p0.o.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.o.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0619a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String[] f11252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f11253f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11254g;

        public RunnableC0619a(String[] strArr, Activity activity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, activity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11252e = strArr;
            this.f11253f = activity;
            this.f11254g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[this.f11252e.length];
                PackageManager packageManager = this.f11253f.getPackageManager();
                String packageName = this.f11253f.getPackageName();
                int length = this.f11252e.length;
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = packageManager.checkPermission(this.f11252e[i2], packageName);
                }
                ((b) this.f11253f).onRequestPermissionsResult(this.f11254g, this.f11252e, iArr);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes4.dex */
    public static class c extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public t f11255a;

        public c(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11255a = tVar;
        }

        @Override // b.a.p0.o.a.a.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view, matrix, rectF)) == null) ? this.f11255a.a(view, matrix, rectF) : (Parcelable) invokeLLL.objValue;
        }

        @Override // b.a.p0.o.a.a.b.a
        public View b(Context context, Parcelable parcelable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, parcelable)) == null) ? this.f11255a.b(context, parcelable) : (View) invokeLL.objValue;
        }

        @Override // b.a.p0.o.a.a.b.a
        public void c(List<String> list, Map<String, View> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
                this.f11255a.c(list, map);
            }
        }

        @Override // b.a.p0.o.a.a.b.a
        public void d(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f11255a.d(list);
            }
        }

        @Override // b.a.p0.o.a.a.b.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, list, list2, list3) == null) {
                this.f11255a.e(list, list2, list3);
            }
        }

        @Override // b.a.p0.o.a.a.b.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, list, list2, list3) == null) {
                this.f11255a.f(list, list2, list3);
            }
        }
    }

    public static b.a e(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tVar)) == null) {
            if (tVar != null) {
                return new c(tVar);
            }
            return null;
        }
        return (b.a) invokeL.objValue;
    }

    public static void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                b.a.p0.o.a.a.b.b(activity);
            } else {
                activity.finish();
            }
        }
    }

    public static void g(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        b.a.p0.o.a.a.b.c(activity);
    }

    public static void h(Activity activity, t tVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, activity, tVar) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        b.a.p0.o.a.a.b.d(activity, e(tVar));
    }

    public static void i(Activity activity, t tVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, tVar) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        b.a.p0.o.a.a.b.e(activity, e(tVar));
    }

    public static boolean j(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return b.a.p0.o.a.a.c.a(activity, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        b.a.p0.o.a.a.b.f(activity);
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, activity, strArr, i2) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                b.a.p0.o.a.a.c.requestPermissions(activity, strArr, i2);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0619a(strArr, activity, i2));
            }
        }
    }

    public static void startActivity(Activity activity, Intent intent, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, intent, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                e.startActivity(activity, intent, bundle);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65545, null, activity, intent, i2, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                e.startActivityForResult(activity, intent, i2, bundle);
            } else {
                activity.startActivityForResult(intent, i2);
            }
        }
    }
}
