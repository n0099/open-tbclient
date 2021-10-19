package c.a.r0.h1.h.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.e;
import c.a.f.m.d;
import c.a.q0.s.q.d2;
import c.a.r0.q2.q.d;
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
/* loaded from: classes3.dex */
public class c extends c.a.r0.q2.q.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.f.m.d N0;
    public d2 O0;
    public boolean P0;
    public boolean Q0;
    public CustomMessageListener R0;
    public Runnable S0;

    /* loaded from: classes3.dex */
    public class a implements d.InterfaceC0068d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18575a;

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
            this.f18575a = cVar;
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18575a.startPlay();
            }
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.f.m.d.InterfaceC0068d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18576a;

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
            this.f18576a = cVar;
        }

        @Override // c.a.r0.q2.q.d.k
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f18576a.k0()) {
                return;
            }
            if (i3 >= i2) {
                this.f18576a.N0.I(false, false, "NEWINDEX");
            } else if (i2 == 0 || this.f18576a.U || (i3 * 100) / i2 < 80 || i2 <= 15000) {
            } else {
                c cVar = this.f18576a;
                cVar.L0(cVar.O0);
            }
        }
    }

    /* renamed from: c.a.r0.h1.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0898c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18577a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0898c(c cVar, int i2) {
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
            this.f18577a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.f.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.f.m.e.b) || (bVar = (c.a.f.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.f18577a.O0 == null || !d2.equals(this.f18577a.O0.f0())) {
                return;
            }
            c.a.f.m.d dVar = this.f18577a.N0;
            c cVar = this.f18577a;
            dVar.K(cVar.H0(cVar.O0, bVar));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18578e;

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
            this.f18578e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18578e.N0 == null) {
                return;
            }
            c cVar = this.f18578e;
            cVar.Q0 = false;
            cVar.N0.L();
            this.f18578e.N0.w();
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
        this.P0 = false;
        this.R0 = new C0898c(this, 2921395);
        this.S0 = new d(this);
        p0(true);
        I0();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.f.m.a H0(d2 d2Var, c.a.f.m.e.b bVar) {
        InterceptResult invokeLL;
        int i2;
        VideoInfo q1;
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
                    q1 = d2Var.q1();
                    if (q1 == null) {
                        int intValue = q1.video_width.intValue();
                        i4 = q1.video_height.intValue();
                        i3 = intValue;
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", d2Var.f0());
                    hashMap.put("video_title", d2Var.getTitle());
                    hashMap.put("forum_id", String.valueOf(d2Var.T()));
                    hashMap.put("forum_name", d2Var.Z());
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    c.a.f.m.a h2 = c.a.f.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            q1 = d2Var.q1();
            if (q1 == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", d2Var.f0());
            hashMap2.put("video_title", d2Var.getTitle());
            hashMap2.put("forum_id", String.valueOf(d2Var.T()));
            hashMap2.put("forum_name", d2Var.Z());
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.f.m.a h22 = c.a.f.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.f.m.a) invokeLL.objValue;
    }

    @Override // c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public boolean I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            c.a.f.m.d dVar = this.N0;
            if (dVar != null) {
                if (z) {
                    if (dVar.r()) {
                        this.Q0 = false;
                        this.N0.L();
                    }
                } else if (dVar.r()) {
                    this.P0 = true;
                    this.N0.F(true);
                }
            }
            return super.I(z);
        }
        return invokeZ.booleanValue;
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.f.m.d dVar = new c.a.f.m.d(this.P, (ViewGroup) getMainView());
            this.N0 = dVar;
            dVar.G(new a(this));
            q0(new b(this));
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void L0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) || d2Var == null || d2Var.f0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, d2Var.f0()));
    }

    @Override // c.a.r0.q2.q.d
    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.f.m.d dVar = this.N0;
            if (dVar == null || !dVar.r()) {
                return super.isPlaying();
            }
            return this.Q0 || this.N0.t();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.q2.q.b, c.a.r0.q2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.N0.I(false, false, "NEWINDEX")) {
            return;
        }
        startPlay();
    }

    @Override // c.a.r0.q2.q.b, c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, d2Var) == null) || d2Var == null) {
            return;
        }
        super.setData(d2Var);
        boolean z = this.O0 == d2Var;
        this.O0 = d2Var;
        if (this.N0 != null) {
            if (this.P0 && z) {
                this.P0 = false;
            } else {
                this.N0.B();
            }
        }
    }

    @Override // c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.R0.setTag(this.S);
            MessageManager.getInstance().registerListener(this.R0);
        }
    }

    @Override // c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.f.m.d dVar = this.N0;
            if (dVar != null && dVar.r()) {
                this.Q0 = true;
                this.N0.E();
                return;
            }
            super.startPlay();
        }
    }

    @Override // c.a.r0.q2.q.d, c.a.r0.q2.q.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.stopPlay();
            c.a.f.m.d dVar = this.N0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            e.a().removeCallbacks(this.S0);
            e.a().post(this.S0);
        }
    }
}
