package c.a.r0.n1.h.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.e.m.d;
import c.a.q0.s.q.d2;
import c.a.r0.x2.r.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class c extends c.a.r0.x2.r.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e.m.d O0;
    public d2 P0;
    public boolean Q0;
    public boolean R0;
    public CustomMessageListener S0;
    public Runnable T0;

    /* loaded from: classes6.dex */
    public class a implements d.InterfaceC0101d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.e.m.d.InterfaceC0101d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.startPlay();
            }
        }

        @Override // c.a.e.m.d.InterfaceC0101d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0101d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0101d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.r0.x2.r.d.k
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.a.k0()) {
                return;
            }
            if (i3 >= i2) {
                this.a.O0.I(false, false, "NEWINDEX");
            } else if (i2 == 0 || this.a.U || (i3 * 100) / i2 < 80 || i2 <= 15000) {
            } else {
                c cVar = this.a;
                cVar.L0(cVar.P0);
            }
        }
    }

    /* renamed from: c.a.r0.n1.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1220c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1220c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.e.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.e.m.e.b) || (bVar = (c.a.e.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.a.P0 == null || !d2.equals(this.a.P0.g0())) {
                return;
            }
            c.a.e.m.d dVar = this.a.O0;
            c cVar = this.a;
            dVar.K(cVar.H0(cVar.P0, bVar));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20586e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20586e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20586e.O0 == null) {
                return;
            }
            c cVar = this.f20586e;
            cVar.R0 = false;
            cVar.O0.L();
            this.f20586e.O0.w();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q0 = false;
        this.S0 = new C1220c(this, 2921395);
        this.T0 = new d(this);
        p0(true);
        I0();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.e.m.a H0(d2 d2Var, c.a.e.m.e.b bVar) {
        InterceptResult invokeLL;
        int i2;
        VideoInfo t1;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d2Var, bVar)) == null) {
            if (d2Var == null || bVar == null) {
                return null;
            }
            int c2 = bVar.c();
            int b2 = bVar.b();
            int a2 = bVar.a();
            int i5 = -1;
            if (a2 != -1) {
                int i6 = c2 != -1 ? (a2 - c2) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a2) - 1;
                    t1 = d2Var.t1();
                    if (t1 == null) {
                        int intValue = t1.video_width.intValue();
                        i4 = t1.video_height.intValue();
                        i3 = intValue;
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", d2Var.g0());
                    hashMap.put("video_title", d2Var.getTitle());
                    hashMap.put("forum_id", String.valueOf(d2Var.U()));
                    hashMap.put("forum_name", d2Var.a0());
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    c.a.e.m.a h2 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            t1 = d2Var.t1();
            if (t1 == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", d2Var.g0());
            hashMap2.put("video_title", d2Var.getTitle());
            hashMap2.put("forum_id", String.valueOf(d2Var.U()));
            hashMap2.put("forum_name", d2Var.a0());
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.e.m.a h22 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.e.m.a) invokeLL.objValue;
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.m.d dVar = new c.a.e.m.d(this.P, (ViewGroup) getMainView());
            this.O0 = dVar;
            dVar.G(new a(this));
            q0(new b(this));
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void L0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) || d2Var == null || d2Var.g0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, d2Var.g0()));
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public boolean R(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            c.a.e.m.d dVar = this.O0;
            if (dVar != null) {
                if (z) {
                    if (dVar.r()) {
                        this.R0 = false;
                        this.O0.L();
                    }
                } else if (dVar.r()) {
                    this.Q0 = true;
                    this.O0.F(true);
                }
            }
            return super.R(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.r0.x2.r.d
    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.e.m.d dVar = this.O0;
            if (dVar == null || !dVar.r()) {
                return super.isPlaying();
            }
            return this.R0 || this.O0.t();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.x2.r.b, c.a.r0.x2.r.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.O0.I(false, false, "NEWINDEX")) {
            return;
        }
        startPlay();
    }

    @Override // c.a.r0.x2.r.b, c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, d2Var) == null) || d2Var == null) {
            return;
        }
        super.setData(d2Var);
        boolean z = this.P0 == d2Var;
        this.P0 = d2Var;
        if (this.O0 != null) {
            if (this.Q0 && z) {
                this.Q0 = false;
            } else {
                this.O0.B();
            }
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.S0.setTag(this.S);
            MessageManager.getInstance().registerListener(this.S0);
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.e.m.d dVar = this.O0;
            if (dVar != null && dVar.r()) {
                this.R0 = true;
                this.O0.E();
                return;
            }
            super.startPlay();
        }
    }

    @Override // c.a.r0.x2.r.d, c.a.r0.x2.r.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.stopPlay();
            c.a.e.m.d dVar = this.O0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            e.a().removeCallbacks(this.T0);
            e.a().post(this.T0);
        }
    }
}
