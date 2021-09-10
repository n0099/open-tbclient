package c.a.p0.o.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.o.a.a.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends c.a.p0.o.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.o.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0624a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String[] f12064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f12065f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f12066g;

        public RunnableC0624a(String[] strArr, Activity activity, int i2) {
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
            this.f12064e = strArr;
            this.f12065f = activity;
            this.f12066g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[this.f12064e.length];
                PackageManager packageManager = this.f12065f.getPackageManager();
                String packageName = this.f12065f.getPackageName();
                int length = this.f12064e.length;
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = packageManager.checkPermission(this.f12064e[i2], packageName);
                }
                ((b) this.f12065f).onRequestPermissionsResult(this.f12066g, this.f12064e, iArr);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes3.dex */
    public static class c extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public s f12067a;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12067a = sVar;
        }

        @Override // c.a.p0.o.a.a.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view, matrix, rectF)) == null) ? this.f12067a.a(view, matrix, rectF) : (Parcelable) invokeLLL.objValue;
        }

        @Override // c.a.p0.o.a.a.b.a
        public View b(Context context, Parcelable parcelable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, parcelable)) == null) ? this.f12067a.b(context, parcelable) : (View) invokeLL.objValue;
        }

        @Override // c.a.p0.o.a.a.b.a
        public void c(List<String> list, Map<String, View> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
                this.f12067a.c(list, map);
            }
        }

        @Override // c.a.p0.o.a.a.b.a
        public void d(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f12067a.d(list);
            }
        }

        @Override // c.a.p0.o.a.a.b.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, list, list2, list3) == null) {
                this.f12067a.e(list, list2, list3);
            }
        }

        @Override // c.a.p0.o.a.a.b.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, list, list2, list3) == null) {
                this.f12067a.f(list, list2, list3);
            }
        }
    }

    public static b.a e(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sVar)) == null) {
            if (sVar != null) {
                return new c(sVar);
            }
            return null;
        }
        return (b.a) invokeL.objValue;
    }

    public static void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                c.a.p0.o.a.a.b.b(activity);
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
        c.a.p0.o.a.a.b.c(activity);
    }

    public static void h(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, activity, strArr, i2) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                c.a.p0.o.a.a.c.a(activity, strArr, i2);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0624a(strArr, activity, i2));
            }
        }
    }

    public static void i(Activity activity, s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, sVar) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        c.a.p0.o.a.a.b.d(activity, e(sVar));
    }

    public static void j(Activity activity, s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, activity, sVar) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        c.a.p0.o.a.a.b.e(activity, e(sVar));
    }

    public static boolean k(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return c.a.p0.o.a.a.c.b(activity, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void l(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        c.a.p0.o.a.a.b.f(activity);
    }
}
