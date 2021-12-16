package c.a.s0.r3;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.r0.p0.d;
import c.a.s0.r3.b.b;
import c.a.s0.r3.b.e;
import c.a.s0.r3.b.f;
import c.a.s0.r3.b.g;
import c.a.s0.r3.d.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.r3.b.a f21960b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.r3.b.a f21961c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.r3.b.a f21962d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public d a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            if (dVar != null) {
                dVar.r(this.a.getAdSource());
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public void b(@NonNull BaseFragment baseFragment, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragment, viewGroup, i2) == null) || baseFragment.getActivity() == null) {
            return;
        }
        c(baseFragment, viewGroup, i2);
        d();
    }

    public final void c(@NonNull BaseFragment baseFragment, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, baseFragment, viewGroup, i2) == null) {
            f fVar = new f(baseFragment, viewGroup, i2);
            this.a = fVar;
            g gVar = new g(fVar);
            this.f21960b = new c.a.s0.r3.g.b(this.a, gVar);
            this.f21961c = new c(this.a, gVar);
            this.f21962d = new c.a.s0.r3.e.b(this.a, gVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            c.a.s0.u3.c.g().i(this.a.getUniqueId());
            baseFragment.registerListener(new e(this.a, gVar));
            baseFragment.registerListener(new c.a.s0.r3.d.a(this.f21962d));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21960b.b() || this.f21961c.b()) {
            return;
        }
        this.f21962d.b();
    }

    public void e(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            c.a.s0.r3.b.a aVar = this.f21961c;
            if (aVar != null) {
                aVar.onConfigurationChanged(configuration);
            }
            c.a.s0.r3.b.a aVar2 = this.f21962d;
            if (aVar2 != null) {
                aVar2.onConfigurationChanged(configuration);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.s0.r3.b.a aVar = this.f21960b;
            if (aVar != null) {
                aVar.onPause();
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.s0.r3.b.a aVar = this.f21960b;
            if (aVar != null) {
                aVar.onResume();
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(true);
                if (this.a.g()) {
                    c.a.s0.r3.c.a.e(this.a).a();
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.r3.b.a aVar = this.f21960b;
            if (aVar != null) {
                aVar.a();
            }
            c.a.s0.r3.b.a aVar2 = this.f21961c;
            if (aVar2 != null) {
                aVar2.a();
            }
            c.a.s0.r3.b.a aVar3 = this.f21962d;
            if (aVar3 != null) {
                aVar3.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}
