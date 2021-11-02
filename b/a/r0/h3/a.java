package b.a.r0.h3;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.a.q0.o0.d;
import b.a.r0.h3.b.c;
import b.a.r0.h3.b.e;
import b.a.r0.h3.b.f;
import b.a.r0.h3.b.g;
import b.a.r0.h3.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f17730a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.h3.b.a f17731b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.h3.b.a f17732c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.h3.b.a f17733d;

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
                dVar.r(this.f17730a.getAdSource());
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
            this.f17730a = fVar;
            g gVar = new g(fVar);
            this.f17731b = new b(this.f17730a, gVar);
            this.f17732c = new b.a.r0.h3.d.c(this.f17730a, gVar);
            this.f17733d = new b.a.r0.h3.e.b(this.f17730a, gVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            b.a.r0.k3.c.g().i(this.f17730a.getUniqueId());
            baseFragment.registerListener(new e(this.f17730a, gVar));
            baseFragment.registerListener(new b.a.r0.h3.d.a(this.f17733d));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f17731b.b() || this.f17732c.b()) {
            return;
        }
        this.f17733d.b();
    }

    public void e(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            b.a.r0.h3.b.a aVar = this.f17732c;
            if (aVar != null) {
                aVar.onConfigurationChanged(configuration);
            }
            b.a.r0.h3.b.a aVar2 = this.f17733d;
            if (aVar2 != null) {
                aVar2.onConfigurationChanged(configuration);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.h3.b.a aVar = this.f17731b;
            if (aVar != null) {
                aVar.onPause();
            }
            c cVar = this.f17730a;
            if (cVar != null) {
                cVar.b(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.r0.h3.b.a aVar = this.f17731b;
            if (aVar != null) {
                aVar.onResume();
            }
            c cVar = this.f17730a;
            if (cVar != null) {
                cVar.b(true);
                if (this.f17730a.g()) {
                    b.a.r0.h3.c.a.e(this.f17730a).a();
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.r0.h3.b.a aVar = this.f17731b;
            if (aVar != null) {
                aVar.a();
            }
            b.a.r0.h3.b.a aVar2 = this.f17732c;
            if (aVar2 != null) {
                aVar2.a();
            }
            b.a.r0.h3.b.a aVar3 = this.f17733d;
            if (aVar3 != null) {
                aVar3.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}
