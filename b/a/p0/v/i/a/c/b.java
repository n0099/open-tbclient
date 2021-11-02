package b.a.p0.v.i.a.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.d;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.y0.k.g.a;
import b.a.p0.v.j.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes4.dex */
public class b extends b.a.p0.v.i.a.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public b.a.p0.v.j.a.a z;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11611a;

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
            this.f11611a = bVar;
        }

        @Override // b.a.p0.v.j.a.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f11611a.y0();
            }
        }
    }

    /* renamed from: b.a.p0.v.i.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0628b implements b.a.p0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11612e;

        public C0628b(b bVar) {
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
            this.f11612e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 2) {
                    if (b.a.p0.v.i.a.c.a.x) {
                        String str = this.f11612e.f11595f + "-" + hashCode() + " authorize deny => onError 0";
                    }
                    a.InterfaceC0467a interfaceC0467a = this.f11612e.f11598i;
                    if (interfaceC0467a != null) {
                        interfaceC0467a.onError(0);
                        return;
                    }
                    return;
                }
                if (b.a.p0.v.i.a.c.a.x) {
                    String str2 = this.f11612e.f11595f + "-" + hashCode() + " real do prepareAsync";
                }
                b.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f11613e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f11614f;

        public c(b bVar, b.a.p0.a.v2.e1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11614f = bVar;
            this.f11613e = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean h2 = d.h(iVar);
                if (b.a.p0.v.i.a.c.a.x) {
                    String str = this.f11614f.f11595f + "-" + hashCode() + " authorize: " + h2;
                }
                this.f11614f.A = h2 ? 1 : 2;
                this.f11613e.onCallback(Integer.valueOf(this.f11614f.A));
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
        b.a.p0.v.j.a.a aVar = new b.a.p0.v.j.a.a();
        this.z = aVar;
        aVar.e(this.f11592c);
        this.z.f(new a(this));
    }

    @Override // b.a.p0.v.i.a.c.a
    public void B0(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // b.a.p0.v.i.a.c.a
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void L0(@NonNull Context context, @NonNull b.a.p0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            if (b.a.p0.v.i.a.c.a.x) {
                String str = this.f11595f + "-" + hashCode() + " start authorize";
            }
            e P = e.P();
            if (P == null) {
                if (!b.a.p0.v.i.a.c.a.x) {
                    bVar.onCallback(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (b.a.p0.a.u1.a.a.r()) {
                this.A = 1;
                if (b.a.p0.v.i.a.c.a.x) {
                    String str2 = this.f11595f + "-" + hashCode() + " authorize debug: true";
                }
                bVar.onCallback(Integer.valueOf(this.A));
            } else {
                P.S().g(context, "mapp_i_live_player", new c(this, bVar));
            }
        }
    }

    @Override // b.a.p0.a.y0.k.g.a
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // b.a.p0.v.i.a.c.a, b.a.p0.a.y0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // b.a.p0.v.i.a.c.a, b.a.p0.a.y0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // b.a.p0.v.i.a.c.a, b.a.p0.a.y0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // b.a.p0.v.i.a.c.a, b.a.p0.a.y0.k.g.a
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (b.a.p0.v.i.a.c.a.x) {
                String str = this.f11595f + "-" + hashCode() + " start prepareAsync";
            }
            L0(this.f11592c, new C0628b(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.v.i.a.c.a, b.a.p0.a.y0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            b.a.p0.v.j.a.a aVar = this.z;
            if (aVar != null) {
                aVar.g();
                this.z = null;
            }
        }
    }
}
