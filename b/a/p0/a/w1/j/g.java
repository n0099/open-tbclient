package b.a.p0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.publisher.view.SPSwitchRootLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8819a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements b.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f8820a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f8821b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f8822c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.d.c f8823d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f8824e;

        public a(int i2, boolean z, Activity activity, b.a.p0.a.i1.d.d.c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), activity, cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8820a = i2;
            this.f8821b = z;
            this.f8822c = activity;
            this.f8823d = cVar;
            this.f8824e = context;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanAppId", b.a.p0.a.a2.e.U());
                bundle.putInt("count", this.f8820a);
                bundle.putBoolean("compressed", this.f8821b);
                bundle.putString("launchType", "Image");
                bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
                b.a.p0.a.i1.d.c.d.l(this.f8822c, bundle, this.f8823d);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (g.f8819a) {
                    String str2 = str + "";
                }
                Toast.makeText(this.f8824e, str, 1).show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2053774872, "Lb/a/p0/a/w1/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2053774872, "Lb/a/p0/a/w1/j/g;");
                return;
            }
        }
        f8819a = k.f6397a;
    }

    public static View b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            View view2 = null;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof SPSwitchRootLinearLayout) {
                        view2 = childAt;
                    }
                    if (view2 != null) {
                        break;
                    }
                    view2 = b(childAt);
                }
            }
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            View b2 = b(activity.getWindow().getDecorView());
            if (b2 == null) {
                boolean z = f8819a;
                return false;
            }
            return b2.getFitsSystemWindows();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) ? (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }

    public static boolean g(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view, i2)) == null) {
            if (view.getHeight() == i2) {
                return false;
            }
            if (f8819a) {
                String str = "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i2;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
            } else {
                layoutParams.height = i2;
                view.requestLayout();
            }
            if (f8819a) {
                String str2 = "refreshHeight, newHeight: " + view.getHeight();
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void h(@NonNull Context context, @StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, context, i2) == null) {
            b.a.p0.a.z1.b.f.e.f(context, i2).F();
        }
    }

    public static void i(int i2, b.a.p0.a.i1.d.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i2, cVar) == null) {
            j(i2, false, cVar);
        }
    }

    public static void j(int i2, boolean z, b.a.p0.a.i1.d.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            Context appContext = AppRuntime.getAppContext();
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return;
            }
            SwanAppActivity x = P.x();
            b.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, x, new a(i2, z, x, cVar, appContext));
        }
    }
}
