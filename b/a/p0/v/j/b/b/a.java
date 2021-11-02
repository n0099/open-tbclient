package b.a.p0.v.j.b.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.c1.d.j;
import b.a.p0.a.k;
import b.a.p0.v.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class a implements j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f11634a;

    /* renamed from: b  reason: collision with root package name */
    public Context f11635b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f11636c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11637d;

    /* renamed from: e  reason: collision with root package name */
    public int f11638e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11639f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11640g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11641h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.a.i1.g.c f11642i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;
    public int r;

    /* renamed from: b.a.p0.v.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0631a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f11643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11644f;

        public RunnableC0631a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11644f = aVar;
            this.f11643e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11643e.setRequestedOrientation(0);
                this.f11643e.getWindow().addFlags(1024);
                this.f11644f.N(this.f11643e);
                SwanAppComponentContainerView G = this.f11644f.O().G();
                G.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                g.b(G);
                g.a(this.f11643e, G);
                b.a.p0.v.j.b.a.a.c(this.f11644f.f11642i.n, this.f11644f.f11642i.f4057g, true, this.f11644f.O());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11645e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11645e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b(this.f11645e.O().G());
                this.f11645e.O().insert();
                b.a.p0.v.j.b.a.a.c(this.f11645e.f11642i.n, this.f11645e.f11642i.f4057g, false, this.f11645e.O());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11646e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11646e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11646e.a0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends b.a.p0.v.h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11647a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11647a = aVar;
        }

        @Override // b.a.p0.v.h.a
        public void a(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    b.a.p0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "waiting", new JSONObject());
                    return;
                }
                b.a.p0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                c(currentPosition, duration);
            }
        }

        @Override // b.a.p0.v.h.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f11647a.S();
                } else {
                    this.f11647a.T();
                }
            }
        }

        public final void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i3));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i2));
                } catch (JSONException e2) {
                    if (a.s) {
                        e2.printStackTrace();
                    }
                }
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "timeupdate", jSONObject);
            }
        }

        @Override // b.a.p0.v.h.a
        public void onEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f11647a.f11637d = false;
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "ended", new JSONObject());
                if (this.f11647a.m != null) {
                    this.f11647a.m.b(this.f11647a);
                }
                this.f11647a.f11641h = true;
                b.a.p0.a.e0.d.a("video", "onEnded call back");
            }
        }

        @Override // b.a.p0.v.h.a
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
                this.f11647a.f11637d = false;
                b.a.p0.a.e0.d.b("video", "errorCode :" + i2);
                this.f11647a.O().J();
                this.f11647a.O().K();
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "error", b.a.p0.v.j.a.b.a.c(i3));
                if (this.f11647a.l != null) {
                    this.f11647a.l.f(this.f11647a, i2, i3);
                }
                this.f11647a.f11641h = false;
                int currentPosition = this.f11647a.P().getCurrentPosition();
                a aVar = this.f11647a;
                if (currentPosition <= 0) {
                    currentPosition = aVar.r;
                }
                aVar.r = currentPosition;
                b.a.p0.a.e0.d.b("video", "onError what " + i2 + " ,extra " + i3);
            }
        }

        @Override // b.a.p0.v.h.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "pause", new JSONObject());
                b.a.p0.a.e0.d.a("video", "onPaused call back");
                this.f11647a.f11637d = true;
                if (this.f11647a.p != null) {
                    this.f11647a.p.c(this.f11647a);
                }
            }
        }

        @Override // b.a.p0.v.h.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                b.a.p0.a.e0.d.a("video", "onPrepared call back");
                this.f11647a.V();
                this.f11647a.M();
                if (this.f11647a.k != null) {
                    this.f11647a.k.e(this.f11647a);
                }
            }
        }

        @Override // b.a.p0.v.h.b, b.a.p0.v.h.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                super.onResume();
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "play", new JSONObject());
                this.f11647a.f11641h = false;
                this.f11647a.f11637d = false;
                this.f11647a.O().K();
                if (this.f11647a.n != null) {
                    this.f11647a.n.a(this.f11647a);
                }
            }
        }

        @Override // b.a.p0.v.h.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                b.a.p0.v.j.b.a.a.b(this.f11647a.f11642i.n, this.f11647a.f11642i.f4057g, "play", new JSONObject());
                this.f11647a.f11641h = false;
                this.f11647a.f11637d = false;
                this.f11647a.O().K();
                if (this.f11647a.o != null) {
                    this.f11647a.o.d(this.f11647a);
                }
            }
        }

        public /* synthetic */ d(a aVar, RunnableC0631a runnableC0631a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2138944230, "Lb/a/p0/v/j/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2138944230, "Lb/a/p0/v/j/b/b/a;");
                return;
            }
        }
        s = k.f6397a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11640g = true;
        this.r = 0;
    }

    public final void K(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            b.a.p0.a.i1.g.c cVar2 = this.f11642i;
            if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f11642i.C, cVar.C)) {
                this.f11639f = true;
            } else {
                this.f11639f = false;
            }
        }
    }

    public a L(Context context, @NonNull b.a.p0.a.i1.g.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar)) == null) {
            this.f11635b = context;
            this.f11642i = cVar;
            O();
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f11640g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final VideoContainerManager O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f11642i == null) {
                b.a.p0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.f11636c == null) {
                this.f11636c = new VideoContainerManager(this.f11635b, this.f11642i);
            }
            return this.f11636c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f11634a == null) {
                b.a.p0.a.e0.d.g("video", "create player");
                this.f11634a = new SwanVideoView(this.f11635b);
                Q();
            }
            return this.f11634a;
        }
        return (SwanVideoView) invokeV.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            P().setVideoPlayerCallback(new d(this, null));
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final boolean S() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e i2 = e.i();
            if (i2 == null || (activity = i2.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new RunnableC0631a(this, activity));
            this.q = true;
            this.f11634a.setIsLandscape(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            e i2 = e.i();
            if (i2 == null || (activity = i2.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            activity.runOnUiThread(new b(this));
            this.q = false;
            this.f11634a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (swanVideoView = this.f11634a) == null) {
            return;
        }
        swanVideoView.stopPlayback();
        g.b(this.f11634a);
        this.f11634a = null;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f0()) {
            if (this.f11638e != 0) {
                P().seekTo(this.f11638e);
                this.f11638e = 0;
                return;
            }
            int i2 = this.f11642i.q;
            if (i2 != 0) {
                this.f11634a.seekTo(i2 * 1000);
                this.f11642i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f11634a.seekTo(i3);
                this.r = 0;
            }
        }
    }

    public final void W(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (cVar == null) {
                b.a.p0.a.e0.d.b("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            P().setVideoPath(this.f11642i.C);
            b.a.p0.a.e0.d.a("video", "setDataSource url " + cVar.C);
        }
    }

    public final void X(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            P().setMuted(cVar.o);
            P().setMediaControllerEnabled(cVar.B);
            P().setLooping(cVar.t);
            if (TextUtils.equals(cVar.u, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                P().setVideoScalingMode(2);
            } else if (TextUtils.equals(cVar.u, "fill")) {
                P().setVideoScalingMode(3);
            } else {
                P().setVideoScalingMode(1);
            }
        }
    }

    public final boolean Y(b.a.p0.a.i1.g.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            b.a.p0.a.i1.g.c cVar2 = this.f11642i;
            if (cVar2 == null) {
                return false;
            }
            if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
                b.a.p0.a.i1.g.c cVar3 = this.f11642i;
                return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            O().M(new c(this));
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frameLayout) == null) {
            this.j = frameLayout;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && f0()) {
            O().J();
            U();
            P().openVideo();
            X(this.f11642i);
            h(this.f11642i, false);
            W(this.f11642i);
            P().start();
            this.f11639f = false;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void b0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (swanVideoView = this.f11634a) == null) {
            return;
        }
        swanVideoView.stopPlayback();
    }

    @Override // b.a.p0.a.c1.d.j
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public final void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (s) {
                String str = "updatePlayStateAfterVisibleChanged isVisible=" + z;
            }
            if (this.f11634a == null || z || !isPlaying()) {
                return;
            }
            this.f11634a.pause();
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void d0(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            O().O(cVar);
            e0();
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public /* bridge */ /* synthetic */ j e(Context context, @NonNull b.a.p0.a.i1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void e0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (swanVideoView = this.f11634a) == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f11634a);
        } else {
            O().H().addView(this.f11634a);
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            b.a.p0.a.i1.g.c cVar = this.f11642i;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f11642i.n) || TextUtils.isEmpty(this.f11642i.f4056f)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public void g(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.m = aVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? P().getCurrentPosition() : invokeV.intValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? P().getDuration() : invokeV.intValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public void h(b.a.p0.a.i1.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, cVar, z) == null) {
            if (s) {
                String str = "fromUpdateAction=" + z + " params:" + cVar.toString();
            }
            b.a.p0.a.e0.d.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
            if (Y(cVar)) {
                X(cVar);
            }
            this.f11642i = cVar;
            if (z) {
                c0(cVar.k());
            }
            d0(cVar);
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f11641h : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SwanVideoView swanVideoView = this.f11634a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public void j(j.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) {
            this.n = eVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void k(j.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.o = fVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void l(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                S();
            } else {
                T();
            }
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void m(j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
            this.k = dVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            P().setMuted(z);
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void n(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, cVar) == null) {
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void o(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cVar) == null) {
            b.a.p0.a.e0.d.a("video", "Open Player " + cVar.n);
            K(cVar);
            this.f11642i = cVar;
            d0(cVar);
            if (cVar.j() && cVar.k()) {
                a0();
                return;
            }
            b0();
            Z();
            O().N(cVar.p, cVar.u);
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? R() && T() : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.c1.d.j
    public void p(j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            P().pause();
            this.f11637d = true;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void q(j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, cVar) == null) {
            this.p = cVar;
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.f11637d && !this.f11639f) {
                P().start();
            } else {
                a0();
            }
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i2) == null) && f0()) {
            if (!this.f11639f) {
                P().seekTo(i2);
            } else {
                this.f11638e = i2;
            }
        }
    }

    @Override // b.a.p0.a.c1.d.j
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            b.a.p0.a.e0.d.a("video", IntentConfig.STOP);
            U();
            P().release();
        }
    }
}
