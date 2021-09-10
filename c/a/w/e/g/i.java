package c.a.w.e.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30528a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30529b;

    /* renamed from: c  reason: collision with root package name */
    public Window f30530c;

    /* renamed from: d  reason: collision with root package name */
    public View f30531d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f30532e;

        public a(i iVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30532e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View view = this.f30532e;
                view.setPadding(view.getPaddingLeft(), this.f30532e.getPaddingTop() + i.b(this.f30532e.getContext()), this.f30532e.getPaddingRight(), this.f30532e.getPaddingBottom());
                this.f30532e.getLayoutParams().height += i.b(this.f30532e.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Window f30533a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30534b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30535c;

        /* renamed from: d  reason: collision with root package name */
        public View f30536d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30534b = false;
            this.f30535c = false;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new i(this.f30533a, this.f30534b, this.f30535c, this.f30536d).d() : invokeV.booleanValue;
        }

        public b c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f30534b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f30535c = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final b e(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
                this.f30533a = activity.getWindow();
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public i(Window window, boolean z, boolean z2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {window, Boolean.valueOf(z), Boolean.valueOf(z2), view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30528a = z;
        this.f30529b = z2;
        this.f30530c = window;
        this.f30531d = view;
    }

    public static b a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            b bVar = new b();
            bVar.e(activity);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (!c() && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Build.VERSION.SDK_INT < 19 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (j() || h()) {
                if (i2 == 19) {
                    g();
                }
                e(this.f30531d);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || !this.f30529b || c()) {
            return;
        }
        view.post(new a(this, view));
    }

    public final boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            WindowManager.LayoutParams attributes = this.f30530c.getAttributes();
            try {
                Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
                int i2 = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
                Field declaredField = cls.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                int i3 = declaredField.getInt(attributes);
                if (z) {
                    declaredField.set(attributes, Integer.valueOf(i3 | i2));
                } else {
                    declaredField.set(attributes, Integer.valueOf((~i2) & i3));
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    @TargetApi(19)
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WindowManager.LayoutParams attributes = this.f30530c.getAttributes();
            if (this.f30529b) {
                attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            } else {
                attributes.flags &= -67108865;
            }
            this.f30530c.setAttributes(attributes);
        }
    }

    @TargetApi(21)
    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            int systemUiVisibility = this.f30530c.getDecorView().getSystemUiVisibility();
            if (this.f30528a) {
                systemUiVisibility |= -2147475456;
            }
            if (this.f30529b) {
                systemUiVisibility |= 1280;
            }
            this.f30530c.getDecorView().setSystemUiVisibility(systemUiVisibility);
            this.f30530c.setStatusBarColor(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            Class<?> cls = this.f30530c.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = this.f30530c;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i2 : 0);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f(this.f30528a) || i(this.f30528a) : invokeV.booleanValue;
    }
}
