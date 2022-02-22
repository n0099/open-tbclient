package c.a.d0.v;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.layer.LayerContainer;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public abstract class e implements c.a.d0.v.i0.e {
    public static /* synthetic */ Interceptable $ic;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d0.v.m0.i a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public c.a.d0.v.j0.i f3276b;

    /* renamed from: c  reason: collision with root package name */
    public LayerContainer f3277c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d0.v.k0.c f3278d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3279e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d0.v.o0.f f3280f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f3281g;

    /* renamed from: h  reason: collision with root package name */
    public b f3282h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3283i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public String f3284j;
    public boolean k;
    public ViewGroup.LayoutParams l;
    public c.a.d0.v.z.n m;
    public final c.a.d0.v.c0.m n;
    public final c.a.d0.v.c0.h o;
    public final c.a.d0.v.c0.c p;
    public final c.a.d0.v.c0.e q;
    @NonNull
    public String r;
    public boolean s;
    public float t;
    public int u;
    public c.a.d0.v.f0.i v;
    public boolean w;
    public int x;
    public final c.a.d0.v.f0.h y;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f3285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f3286f;

        public a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3286f = eVar;
            this.f3285e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f3285e;
                if ((i2 == -2 || i2 == -1) && this.f3286f.Y()) {
                    this.f3286f.f0(2);
                    this.f3286f.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.d0(i2);
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.d0.v.f0.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.d0.v.f0.m
        public void a(c.a.d0.v.c0.p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                this.a.y().b(pVar);
            }
        }

        @Override // c.a.d0.v.f0.m
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public /* synthetic */ c(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-174866836, "Lc/a/d0/v/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-174866836, "Lc/a/d0/v/e;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.d0.v.f0.h hVar, @Nullable Context context) {
        this(hVar, context, new c.a.d0.v.j0.i(d.a()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.a.d0.v.f0.h) objArr2[0], (Context) objArr2[1], (c.a.d0.v.j0.i) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? z : invokeV.booleanValue;
    }

    @Nullable
    public c.a.d0.v.j0.i A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3276b : (c.a.d0.v.j0.i) invokeV.objValue;
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.w = z2;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c.a.d0.v.v0.h.g(M0("setVideoScalingMode(" + i2 + SmallTailInfo.EMOTION_SUFFIX));
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return;
            }
            this.x = i2;
            iVar.o0(i2);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return 0;
            }
            return iVar.O();
        }
        return invokeV.intValue;
    }

    public void C0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r = str;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return 0;
            }
            return iVar.P();
        }
        return invokeV.intValue;
    }

    public void D0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            E0(str, true);
        }
    }

    @NonNull
    public abstract c.a.d0.v.f0.i E();

    public void E0(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z2) == null) {
            c.a.d0.v.v0.h.g(M0("setVideoUrl = " + str));
            this.a.f3367b = str;
            z().o(this.a.f3367b, z2, B());
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.x : invokeV.intValue;
    }

    public void F0(@Nullable c.a.d0.v.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, iVar) == null) || iVar == null) {
            return;
        }
        e(iVar);
    }

    public float G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.floatValue;
    }

    public abstract void G0(@NonNull Context context);

    @NonNull
    public c.a.d0.v.c0.m H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : (c.a.d0.v.c0.m) invokeV.objValue;
    }

    public void H0(Context context, @Nullable c.a.d0.v.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, iVar) == null) {
            J0();
            F0(iVar);
            G0(context);
            I0(context);
        }
    }

    @NonNull
    public PlayerStatus I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            return iVar == null ? PlayerStatus.IDLE : iVar.Q();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
        }
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar != null) {
                return iVar.R();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            H().b(this.f3278d);
            z().b(this.f3278d);
            q().b(this.f3278d);
            t().b(this.f3278d);
        }
    }

    public c.a.d0.v.m0.i K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (c.a.d0.v.m0.i) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.d0.v.v0.h.g(M0("start()"));
            l();
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            return iVar == null ? "" : iVar.U();
        }
        return (String) invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.d0.v.v0.h.g(M0("stop()"));
            if (this.f3276b == null) {
                return;
            }
            a();
            q().i();
            t().g();
            H().j(w());
            c.a.d0.v.d0.l.a(getActivity(), false);
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar != null) {
                return iVar.V();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String M0(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(this.r)) {
                str2 = "Player@" + System.identityHashCode(this);
            } else {
                str2 = this.r;
            }
            sb.append(str2);
            sb.append("=>");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = new c.a.d0.v.z.n();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.d0.v.k0.c createMessenger = d.d().createMessenger();
            this.f3278d = createMessenger;
            createMessenger.b(new c(this, null));
            c.a.d0.v.q0.b.c().a(this);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? I() == PlayerStatus.COMPLETE : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? I() == PlayerStatus.ERROR : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f3283i : invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? I() == PlayerStatus.PAUSE : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? T() : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? I() == PlayerStatus.PLAYING : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? I() == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            AudioManager audioManager = this.f3281g;
            if (audioManager != null && (bVar = this.f3282h) != null) {
                audioManager.abandonAudioFocus(bVar);
                c.a.d0.v.v0.h.g(M0("abandonAudioFocus()"));
                this.f3281g = null;
                this.f3282h = null;
            }
            this.f3283i = false;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? I() == PlayerStatus.STOP : invokeV.booleanValue;
    }

    public void b(@NonNull c.a.d0.v.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bVar) == null) {
            this.f3277c.addLayer(bVar);
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public void c(@NonNull c.a.d0.v.j0.b bVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, bVar, layoutParams) == null) {
            this.f3277c.addLayer(bVar, layoutParams);
        }
    }

    public void c0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            c.a.d0.v.v0.h.g(M0("mute(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return;
            }
            iVar.W(z2);
        }
    }

    public void d(@NonNull c.a.d0.v.o0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, aVar) == null) {
            this.f3280f.a(aVar);
        }
    }

    public void d0(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || (activity = getActivity()) == null || X()) {
            return;
        }
        activity.runOnUiThread(new a(this, i2));
    }

    public void e(@NonNull c.a.d0.v.j0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, iVar) == null) {
            k();
            c.a.d0.v.v0.h.g(M0("attachKernelLayer(" + System.identityHashCode(iVar) + "), kernel = " + System.identityHashCode(iVar.S())));
            this.f3276b = iVar;
            iVar.h0(this);
            this.f3277c.attachKernelLayer(iVar);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            f0(0);
        }
    }

    public void f(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, viewGroup) == null) {
            g(viewGroup, true);
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            c.a.d0.v.v0.h.g(M0("pause(" + i2 + SmallTailInfo.EMOTION_SUFFIX));
            if (this.f3276b == null) {
                return;
            }
            a();
            q().d(i2);
            t().d();
            H().g();
        }
    }

    public void g(@NonNull ViewGroup viewGroup, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, viewGroup, z2) == null) {
            j(z2);
            c.a.d0.v.v0.h.g(M0("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.f3279e = viewGroup;
            viewGroup.addView(this.f3277c, this.l);
            z().j();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            c.a.d0.v.v0.h.g(M0("release()"));
            H().j(w());
            h0();
            c.a.d0.v.d0.l.a(getActivity(), false);
            y().r();
            a();
            j0();
            this.f3280f.c();
            this.f3277c.release();
            j(false);
            i0();
            this.f3279e = null;
        }
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            ViewGroup viewGroup = this.f3279e;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return null;
            }
            return (Activity) this.f3279e.getContext();
        }
        return (Activity) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, context) == null) {
            this.l = new ViewGroup.LayoutParams(-1, -1);
            this.a = new c.a.d0.v.m0.i();
            O();
            this.f3280f = new c.a.d0.v.o0.f(this);
            LayerContainer i2 = i(context);
            this.f3277c = i2;
            i2.bindPlayer(this);
            this.f3277c.setClickable(true);
            N();
        }
    }

    public void h0() {
        c.a.d0.v.j0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (iVar = this.f3276b) == null) {
            return;
        }
        iVar.X();
        this.f3276b.r0();
        this.f3276b.Z();
    }

    public LayerContainer i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, context)) == null) ? new LayerContainer(context) : (LayerContainer) invokeL.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            c.a.d0.v.q0.b.c().g(this);
            this.f3278d.release();
        }
    }

    public void j(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) && (this.f3277c.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f3277c.getParent();
            viewGroup.removeView(this.f3277c);
            c.a.d0.v.v0.h.g(M0("detachFromContainer(" + z2 + "), parent = " + System.identityHashCode(viewGroup)));
            if (z2) {
                this.f3277c.onContainerDetach();
                z().k();
            }
            this.f3279e = null;
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            H().a();
            z().a();
            q().a();
            t().a();
        }
    }

    @Nullable
    public c.a.d0.v.j0.i k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.f3276b != null) {
                c.a.d0.v.v0.h.g(M0("detachKernelLayer = " + System.identityHashCode(this.f3276b)));
                c.a.d0.v.j0.i iVar = this.f3276b;
                this.f3277c.detachLayer((c.a.d0.v.j0.b) iVar, true);
                iVar.h0(null);
                this.f3276b = null;
                return iVar;
            }
            return null;
        }
        return (c.a.d0.v.j0.i) invokeV.objValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.f3283i) {
            return;
        }
        if (this.f3281g == null) {
            this.f3281g = (AudioManager) m().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.f3281g != null) {
            if (this.f3282h == null) {
                this.f3282h = new b(this, null);
            }
            this.f3283i = this.f3281g.requestAudioFocus(this.f3282h, 3, 2) == 1;
            c.a.d0.v.v0.h.g(M0("requestAudioFocus()"));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            c.a.d0.v.v0.h.g(M0("doPlay(), status = " + I()));
            if (this.f3276b == null || W()) {
                return;
            }
            if (!X()) {
                k0();
            }
            c.a.d0.v.d0.l.a(getActivity(), true);
            q().h();
            t().f();
            c.a.d0.v.v0.h.g(M0("doPlay, url = " + L()));
            H().i();
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            c.a.d0.v.v0.h.g(M0("resume()"));
            if (this.f3276b != null && W()) {
                if (!X()) {
                    k0();
                }
                q().e();
                t().e();
                H().h();
            }
        }
    }

    @NonNull
    public Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? d.b() : (Context) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            c.a.d0.v.v0.h.g(M0("resumeFromError()"));
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar != null) {
                iVar.s0();
            }
            B0(F());
            D0(this.a.f3367b);
            n0(false);
        }
    }

    @Nullable
    public ViewGroup n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.f3279e : (ViewGroup) invokeV.objValue;
    }

    public void n0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            c.a.d0.v.v0.h.g(M0("resumePlayer(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return;
            }
            if (z2) {
                c.a.d0.v.m0.i iVar2 = this.a;
                iVar2.f3369d = 0;
                iVar2.f3370e = 0;
                iVar2.f3371f = 0;
            } else {
                this.a.f3369d = iVar.O();
                this.a.f3370e = this.f3276b.L();
                this.a.f3371f = this.f3276b.P();
            }
            if (W()) {
                l0();
            } else {
                K0();
            }
        }
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? "CyberNetPlayer" : (String) invokeV.objValue;
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            q().f(i2 * 1000, 3);
        }
    }

    @Override // c.a.d0.v.i0.e
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            z().f(i2);
        }
    }

    @Override // c.a.d0.v.i0.e
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            a();
            z().g();
            H().f(w());
        }
    }

    @Override // c.a.d0.v.i0.e
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048647, this, i2, i3, obj)) == null) {
            z().h(i2, i3, obj);
            H().d(i2, i3, obj);
            c.a.d0.v.d0.l.a(getActivity(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // c.a.d0.v.i0.e
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048648, this, i2, i3, obj)) == null) {
            z().i(i2, i3, obj);
            H().e(i2, i3, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // c.a.d0.v.i0.e
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            z().l();
        }
    }

    @Override // c.a.d0.v.i0.e
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            z().m();
        }
    }

    @Override // c.a.d0.v.i0.e
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048651, this, i2, i3, i4, i5) == null) {
            z().n(i2, i3, i4, i5);
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return 0;
            }
            return iVar.K();
        }
        return invokeV.intValue;
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            q().f(i2, 3);
        }
    }

    @NonNull
    public c.a.d0.v.c0.c q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.p : (c.a.d0.v.c0.c) invokeV.objValue;
    }

    public void q0(@NonNull c.a.d0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, pVar) == null) {
            this.f3278d.d(pVar);
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return this.a.f3370e;
            }
            return iVar.L();
        }
        return invokeV.intValue;
    }

    public void r0(@Nullable String str) {
        c.a.d0.v.j0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, str) == null) || (iVar = this.f3276b) == null) {
            return;
        }
        iVar.f0(str);
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar == null) {
                return this.a.f3370e * 1000;
            }
            return iVar.M();
        }
        return invokeV.intValue;
    }

    public void s0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            z = z2;
            w0(z2);
        }
    }

    @NonNull
    public final c.a.d0.v.c0.e t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.q : (c.a.d0.v.c0.e) invokeV.objValue;
    }

    public void t0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) && z2 && this.f3276b != null) {
            c.a.d0.v.v0.h.g(M0("setHasReplaceUrl(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.f3276b.t0(null);
        }
    }

    @Nullable
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.f3284j : (String) invokeV.objValue;
    }

    public void u0(@Nullable c.a.d0.v.f0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, kVar) == null) {
            this.f3278d.a(kVar);
        }
    }

    @NonNull
    public LayerContainer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.f3277c : (LayerContainer) invokeV.objValue;
    }

    public void v0(boolean z2) {
        c.a.d0.v.j0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) || (iVar = this.f3276b) == null) {
            return;
        }
        iVar.i0(z2);
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.u : invokeV.intValue;
    }

    public void w0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) {
            c.a.d0.v.v0.h.g(M0("setMuteMode(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.s = z2;
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar != null) {
                iVar.W(z2);
            }
            if (z2) {
                a();
            } else if (Y()) {
                k0();
            }
        }
    }

    public c.a.d0.v.k0.c x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.f3278d : (c.a.d0.v.k0.c) invokeV.objValue;
    }

    public void x0(@Nullable String str) {
        c.a.d0.v.j0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, str) == null) || (iVar = this.f3276b) == null) {
            return;
        }
        iVar.j0(str);
    }

    @NonNull
    public c.a.d0.v.z.n y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.m : (c.a.d0.v.z.n) invokeV.objValue;
    }

    public void y0(c.a.d0.v.z.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, hVar) == null) {
            y().s(hVar);
        }
    }

    public c.a.d0.v.c0.h z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.o : (c.a.d0.v.c0.h) invokeV.objValue;
    }

    public void z0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048673, this, f2) == null) {
            this.t = f2;
            c.a.d0.v.j0.i iVar = this.f3276b;
            if (iVar != null) {
                iVar.m0(f2);
                c.a.d0.v.v0.h.g(M0("setSpeed(" + f2 + SmallTailInfo.EMOTION_SUFFIX));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.d0.v.f0.h hVar, @Nullable Context context, @Nullable c.a.d0.v.j0.i iVar) {
        this(hVar, context, iVar, "", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, context, iVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.a.d0.v.f0.h) objArr2[0], (Context) objArr2[1], (c.a.d0.v.j0.i) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(@NonNull c.a.d0.v.f0.h hVar, @Nullable Context context, @Nullable c.a.d0.v.j0.i iVar, @NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, context, iVar, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = false;
        this.n = new c.a.d0.v.c0.m();
        this.o = new c.a.d0.v.c0.h();
        this.p = new c.a.d0.v.c0.c();
        this.q = new c.a.d0.v.c0.e();
        this.s = false;
        this.t = 1.0f;
        this.u = 0;
        this.w = false;
        this.x = 2;
        this.y = hVar;
        this.r = str;
        this.f3284j = str2;
        c.a.d0.v.v0.h.g(M0("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(iVar) + ", key@" + this.r + SmallTailInfo.EMOTION_SUFFIX));
        context = context == null ? m() : context;
        h(context);
        P();
        H0(context, iVar);
    }
}
