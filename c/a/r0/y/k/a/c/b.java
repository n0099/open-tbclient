package c.a.r0.y.k.a.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.h2.c.d;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.y0.k.g.a;
import c.a.r0.y.l.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes6.dex */
public class b extends c.a.r0.y.k.a.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.r0.y.l.a.a z;

    /* loaded from: classes6.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.y.l.a.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.a.z0();
            }
        }
    }

    /* renamed from: c.a.r0.y.k.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0819b implements c.a.r0.a.z2.g1.c<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12095e;

        public C0819b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12095e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 2) {
                    if (c.a.r0.y.k.a.c.a.x) {
                        String str = this.f12095e.f12080f + "-" + hashCode() + " authorize deny => onError 0";
                    }
                    a.InterfaceC0640a interfaceC0640a = this.f12095e.f12083i;
                    if (interfaceC0640a != null) {
                        interfaceC0640a.onError(0);
                        return;
                    }
                    return;
                }
                if (c.a.r0.y.k.a.c.a.x) {
                    String str2 = this.f12095e.f12080f + "-" + hashCode() + " real do prepareAsync";
                }
                b.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f12096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f12097f;

        public c(b bVar, c.a.r0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12097f = bVar;
            this.f12096e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean h2 = d.h(iVar);
                if (c.a.r0.y.k.a.c.a.x) {
                    String str = this.f12097f.f12080f + "-" + hashCode() + " authorize: " + h2;
                }
                this.f12097f.A = h2 ? 1 : 2;
                this.f12096e.onCallback(Integer.valueOf(this.f12097f.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 0;
        c.a.r0.y.l.a.a aVar = new c.a.r0.y.l.a.a();
        this.z = aVar;
        aVar.e(this.f12077c);
        this.z.f(new a(this));
    }

    @Override // c.a.r0.y.k.a.c.a
    public void C0(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // c.a.r0.y.k.a.c.a
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void M0(@NonNull Context context, @NonNull c.a.r0.a.z2.g1.c<Integer> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar) == null) {
            if (c.a.r0.y.k.a.c.a.x) {
                String str = this.f12080f + "-" + hashCode() + " start authorize";
            }
            e a0 = e.a0();
            if (a0 == null) {
                if (!c.a.r0.y.k.a.c.a.x) {
                    cVar.onCallback(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (c.a.r0.a.x1.a.a.r()) {
                this.A = 1;
                if (c.a.r0.y.k.a.c.a.x) {
                    String str2 = this.f12080f + "-" + hashCode() + " authorize debug: true";
                }
                cVar.onCallback(Integer.valueOf(this.A));
            } else {
                a0.d0().g(context, "mapp_i_live_player", new c(this, cVar));
            }
        }
    }

    @Override // c.a.r0.a.y0.k.g.a
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // c.a.r0.y.k.a.c.a, c.a.r0.a.y0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.y.k.a.c.a, c.a.r0.a.y0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // c.a.r0.y.k.a.c.a, c.a.r0.a.y0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // c.a.r0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // c.a.r0.y.k.a.c.a, c.a.r0.a.y0.k.g.a
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (c.a.r0.y.k.a.c.a.x) {
                String str = this.f12080f + "-" + hashCode() + " start prepareAsync";
            }
            M0(this.f12077c, new C0819b(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.y.k.a.c.a, c.a.r0.a.y0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            c.a.r0.y.l.a.a aVar = this.z;
            if (aVar != null) {
                aVar.g();
                this.z = null;
            }
        }
    }
}
