package c.a.r0.r.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public abstract class l<E> extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f11812b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f11813c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11814d;

    /* renamed from: e  reason: collision with root package name */
    public final n f11815e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.r.a.c.f<String, q> f11816f;

    /* renamed from: g  reason: collision with root package name */
    public r f11817g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11818h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11819i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Context) objArr2[1], (Handler) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.r.a.a.j
    @Nullable
    public View a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // c.a.r0.r.a.a.j
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        r rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (rVar = this.f11817g) == null) {
            return;
        }
        rVar.b();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f11819i) {
            return;
        }
        this.f11819i = true;
        r rVar = this.f11817g;
        if (rVar != null) {
            rVar.f();
        } else if (!this.f11818h) {
            r i2 = i("(root)", true, false);
            this.f11817g = i2;
            if (i2 != null && !i2.f11854d) {
                i2.f();
            }
        }
        this.f11818h = true;
    }

    public void e(boolean z) {
        r rVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (rVar = this.f11817g) != null && this.f11819i) {
            this.f11819i = false;
            if (z) {
                rVar.e();
            } else {
                rVar.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f11819i);
            if (this.f11817g != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.f11817g)));
                printWriter.println(":");
                r rVar = this.f11817g;
                rVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public n g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11815e : (n) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11812b : (Context) invokeV.objValue;
    }

    public Handler h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11813c : (Handler) invokeV.objValue;
    }

    public r i(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f11816f == null) {
                this.f11816f = new c.a.r0.r.a.c.f<>();
            }
            r rVar = (r) this.f11816f.get(str);
            if (rVar != null) {
                rVar.k(this);
                return rVar;
            } else if (z2) {
                r rVar2 = new r(str, this, z);
                this.f11816f.put(str, rVar2);
                return rVar2;
            } else {
                return rVar;
            }
        }
        return (r) invokeCommon.objValue;
    }

    public r j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            r rVar = this.f11817g;
            if (rVar != null) {
                return rVar;
            }
            this.f11818h = true;
            r i2 = i("(root)", this.f11819i, true);
            this.f11817g = i2;
            return i2;
        }
        return (r) invokeV.objValue;
    }

    public void k(String str) {
        c.a.r0.r.a.c.f<String, q> fVar;
        r rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (fVar = this.f11816f) == null || (rVar = (r) fVar.get(str)) == null || rVar.f11855e) {
            return;
        }
        rVar.b();
        this.f11816f.remove(str);
    }

    public void l(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) {
        }
    }

    public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public LayoutInflater n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (LayoutInflater) this.f11812b.getSystemService("layout_inflater") : (LayoutInflater) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f11814d : invokeV.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void q(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, fragment, strArr, i2) == null) {
        }
    }

    public boolean r(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fragment)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, fragment, intent, i2) == null) {
            if (i2 == -1) {
                this.f11812b.startActivity(intent);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void u() {
        c.a.r0.r.a.c.f<String, q> fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (fVar = this.f11816f) == null) {
            return;
        }
        int size = fVar.size();
        r[] rVarArr = new r[size];
        for (int i2 = size - 1; i2 >= 0; i2--) {
            rVarArr[i2] = (r) this.f11816f.k(i2);
        }
        for (int i3 = 0; i3 < size; i3++) {
            r rVar = rVarArr[i3];
            rVar.i();
            rVar.d();
        }
    }

    public void v(c.a.r0.r.a.c.f<String, q> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) {
            this.f11816f = fVar;
        }
    }

    public c.a.r0.r.a.c.f<String, q> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            c.a.r0.r.a.c.f<String, q> fVar = this.f11816f;
            int i2 = 0;
            if (fVar != null) {
                int size = fVar.size();
                r[] rVarArr = new r[size];
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    rVarArr[i3] = (r) this.f11816f.k(i3);
                }
                int i4 = 0;
                while (i2 < size) {
                    r rVar = rVarArr[i2];
                    if (rVar.f11855e) {
                        i4 = 1;
                    } else {
                        rVar.b();
                        this.f11816f.remove(rVar.f11853c);
                    }
                    i2++;
                }
                i2 = i4;
            }
            if (i2 != 0) {
                return this.f11816f;
            }
            return null;
        }
        return (c.a.r0.r.a.c.f) invokeV.objValue;
    }

    public l(Activity activity, Context context, Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, context, handler, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11815e = new n();
        this.a = activity;
        this.f11812b = context;
        this.f11813c = handler;
        this.f11814d = i2;
    }
}
