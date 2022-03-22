package c.a.n0.y.f.b.b;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q;
import c.a.n0.a.s0.d.k;
import c.a.n0.y.f.b.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanVideoView a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9550b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f9551c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9552d;

    /* renamed from: e  reason: collision with root package name */
    public int f9553e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9554f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9555g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9556h;
    public boolean i;
    public c.a.n0.a.z0.g.c j;
    public FrameLayout k;
    public k.d l;
    public k.b m;
    public k.a n;
    public k.e o;
    public k.f p;
    public k.c q;
    public boolean r;
    public int s;

    /* renamed from: c.a.n0.y.f.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0773a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f9557b;

        public RunnableC0773a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9557b = aVar;
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setRequestedOrientation(0);
                this.a.getWindow().addFlags(1024);
                this.f9557b.Q(this.a);
                SwanAppComponentContainerView G = this.f9557b.R().G();
                G.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                c.a.n0.y.c.b(G);
                c.a.n0.y.c.a(this.a, G);
                c.a.n0.y.f.b.a.a.c(this.f9557b.j.j, this.f9557b.j.f6097c, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.y.c.b(this.a.R().G());
                this.a.R().insert();
                c.a.n0.y.f.b.a.a.c(this.a.j.j, this.a.j.f6097c, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.y.f.b.b.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0774a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f9558b;

            public RunnableC0774a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9558b = dVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.y.f.b.a.a.b(this.f9558b.a.j.j, this.f9558b.a.j.f6097c, this.a, this.f9558b.a.S().getWidth(), this.f9558b.a.S().getHeight());
                }
            }
        }

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.a.j.y, new HashMap());
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    mediaMetadataRetriever.release();
                    this.a.S().post(new RunnableC0774a(this, extractMetadata));
                } catch (RuntimeException e2) {
                    if (a.t) {
                        Log.e("SwanAppVideoPlayer", "preloadVideoMetadata: ", e2);
                    }
                    mediaMetadataRetriever.release();
                    c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "error", c.a.n0.y.f.a.b.a.c(0));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -1) {
                    if (i != 1) {
                        return;
                    }
                    this.a.S().X();
                    return;
                }
                this.a.stop();
                this.a.e0();
                this.a.R().N(this.a.j.l, this.a.j.q);
            }
        }

        public /* synthetic */ e(a aVar, RunnableC0773a runnableC0773a) {
            this(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class f extends c.a.n0.y.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.y.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f9552d = false;
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.i = true;
                this.a.S().c0(MediaTipStateLayer.TipState.END);
                c.a.n0.a.u.d.b("video", "onEnded call back");
            }
        }

        @Override // c.a.n0.y.d.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.j.k = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e2) {
                    if (a.t) {
                        e2.printStackTrace();
                    }
                }
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "muted", jSONObject);
            }
        }

        @Override // c.a.n0.y.d.a
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    c.a.n0.a.u.d.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "waiting", new JSONObject());
                    return;
                }
                c.a.n0.a.u.d.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
            }
        }

        @Override // c.a.n0.y.d.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.j.Q = z;
                if (z) {
                    this.a.X();
                } else {
                    this.a.Y();
                }
            }
        }

        public final void e(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i2));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e2) {
                    if (a.t) {
                        e2.printStackTrace();
                    }
                }
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "timeupdate", jSONObject);
            }
        }

        @Override // c.a.n0.y.d.a
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
                this.a.f9552d = false;
                c.a.n0.a.u.d.c("video", "errorCode :" + i);
                this.a.R().J();
                this.a.R().K();
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "error", c.a.n0.y.f.a.b.a.c(i2));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i, i2);
                }
                this.a.i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                a aVar = this.a;
                if (currentPosition <= 0) {
                    currentPosition = aVar.s;
                }
                aVar.s = currentPosition;
                this.a.S().c0(MediaTipStateLayer.TipState.ERROR);
                c.a.n0.a.u.d.c("video", "onError what " + i + " ,extra " + i2);
            }
        }

        @Override // c.a.n0.y.d.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "pause", new JSONObject());
                c.a.n0.a.u.d.b("video", "onPaused call back");
                this.a.f9552d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // c.a.n0.y.d.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                c.a.n0.a.u.d.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }

        @Override // c.a.n0.y.d.b, c.a.n0.y.d.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "play", new JSONObject());
                this.a.i = false;
                this.a.f9552d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // c.a.n0.y.d.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                c.a.n0.y.f.b.a.a.a(this.a.j.j, this.a.j.f6097c, "play", new JSONObject());
                this.a.i = false;
                this.a.f9552d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        public /* synthetic */ f(a aVar, RunnableC0773a runnableC0773a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830324218, "Lc/a/n0/y/f/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(830324218, "Lc/a/n0/y/f/b/b/a;");
                return;
            }
        }
        t = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9555g = true;
        this.s = 0;
    }

    public final void M(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            c.a.n0.a.z0.g.c cVar2 = this.j;
            if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.y) && !TextUtils.isEmpty(cVar.y) && !TextUtils.equals(this.j.y, cVar.y)) {
                this.f9554f = true;
            } else {
                this.f9554f = false;
            }
        }
    }

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (!SwanAppNetworkUtils.h()) {
                R().J();
                R().K();
                S().c0(MediaTipStateLayer.TipState.NO_NETWORK);
                return false;
            } else if (z) {
                if (SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._2G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._3G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._4G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._5G) {
                    R().J();
                    R().K();
                    S().c0(MediaTipStateLayer.TipState.NO_WIFI);
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public a O(Context context, @NonNull c.a.n0.a.z0.g.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar)) == null) {
            this.f9550b = context;
            this.j = cVar;
            R();
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f9555g) {
            return;
        }
        pause();
    }

    public final void Q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final VideoContainerManager R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j == null) {
                c.a.n0.a.s.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.f9551c == null) {
                this.f9551c = new VideoContainerManager(this.f9550b, this.j);
            }
            return this.f9551c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            U();
            return this.a;
        }
        return (SwanVideoView) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S().setVideoPlayerCallback(new f(this, null));
            S().setAudioFocusListener(new e(this, null));
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a == null) {
            c.a.n0.a.u.d.i("video", "create player");
            this.a = new SwanVideoView(this.f9550b);
            T();
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!SwanAppNetworkUtils.h()) {
                c.a.n0.a.z0.g.c cVar = this.j;
                c.a.n0.y.f.b.a.a.a(cVar.j, cVar.f6097c, "error", c.a.n0.y.f.a.b.a.c(0));
                return;
            }
            if (!this.j.i() || !this.j.o()) {
                U();
                i0(this.j);
            }
            q.k(new d(this), "preloadVideoMetadata");
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            if (L == null || (activity = L.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new RunnableC0773a(this, activity));
            this.r = true;
            this.a.setIsLandscape(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            if (L == null || (activity = L.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            activity.runOnUiThread(new b(this));
            this.r = false;
            this.a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
        c.a.n0.y.c.b(this.a);
        this.a = null;
    }

    @Override // c.a.n0.a.s0.d.k
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameLayout) == null) {
            this.k = frameLayout;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && k0()) {
            if (this.f9553e != 0) {
                S().H(this.f9553e);
                this.f9553e = 0;
                return;
            }
            int i = this.j.m;
            if (i != 0) {
                this.a.H(i * 1000);
                this.j.m = 0;
                return;
            }
            int i2 = this.s;
            if (i2 != 0) {
                this.a.H(i2);
                this.s = 0;
            }
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void b0(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            if (cVar == null) {
                c.a.n0.a.u.d.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.j.y);
            c.a.n0.a.u.d.b("video", "setDataSource url " + cVar.y);
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void c0(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            if (cVar.S) {
                S().W(true);
                S().V(cVar.U);
                S().setSilentTips(cVar.V);
                mute(true);
            } else {
                S().W(false);
                mute(cVar.k);
            }
            c.b bVar = new c.b();
            bVar.k(cVar.S);
            bVar.i(cVar.L);
            bVar.h(cVar.D);
            bVar.g(cVar.M);
            bVar.j(cVar.H);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(cVar.x);
            S().setLooping(cVar.p);
            S().M(cVar.G);
            S().N(cVar.m());
            S().K(cVar.k());
            S().O(cVar.n());
            S().P(cVar.P);
            S().L(cVar.w);
            S().S(cVar.E);
            S().T(cVar.R);
            S().setTitle(cVar.K);
            if (TextUtils.equals(cVar.q, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(cVar.q, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(cVar.Q, cVar.F);
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public final boolean d0(c.a.n0.a.z0.g.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, cVar)) == null) {
            c.a.n0.a.z0.g.c cVar2 = this.j;
            if (cVar2 == null) {
                return false;
            }
            if (cVar2.k == cVar.k && cVar2.x == cVar.x && TextUtils.equals(cVar2.q, cVar.q)) {
                c.a.n0.a.z0.g.c cVar3 = this.j;
                if (cVar3.H == cVar.H && cVar3.D == cVar.D && cVar3.E == cVar.E && cVar3.G == cVar.G && cVar3.L == cVar.L && cVar3.S == cVar.S && cVar3.F == cVar.F && cVar3.P == cVar.P && cVar3.n() == cVar.n() && this.j.k() == cVar.k() && this.j.m() == cVar.m() && this.j.l() == cVar.l() && TextUtils.equals(this.j.K, cVar.K)) {
                    c.a.n0.a.z0.g.c cVar4 = this.j;
                    if (cVar4.R == cVar.R && cVar4.Q == cVar.Q && cVar4.M == cVar.M && cVar4.p == cVar.p) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public /* bridge */ /* synthetic */ k e(Context context, @NonNull c.a.n0.a.z0.g.c cVar) {
        O(context, cVar);
        return this;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && k0()) {
            R().J();
            Z();
            S().B();
            c0(this.j);
            h(this.j, false);
            b0(this.j);
            if (N(this.j.J)) {
                S().Y();
            }
            this.f9554f = false;
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void g(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final void g0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
    }

    @Override // c.a.n0.a.s0.d.k
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? S().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? S().getDuration() : invokeV.intValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public void h(c.a.n0.a.z0.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, cVar, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
            }
            c.a.n0.a.u.d.b("video", "updatePlayerConfigInternal params: " + cVar.toString());
            if (d0(cVar)) {
                c0(cVar);
            }
            this.j = cVar;
            if (z) {
                h0(cVar.o());
            }
            i0(cVar);
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
            }
            if (this.a == null || z || !isPlaying()) {
                return;
            }
            this.a.C();
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    public void i0(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            R().O(cVar);
            j0();
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SwanVideoView swanVideoView = this.a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.z();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public void j(k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public final void j0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        c.a.n0.y.c.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void k(k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            c.a.n0.a.z0.g.c cVar = this.j;
            return (cVar == null || TextUtils.isEmpty(cVar.y) || TextUtils.isEmpty(this.j.j) || TextUtils.isEmpty(this.j.f6096b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public void l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || c.a.n0.y.g.a.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void m(k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void n(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, cVar) == null) {
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void o(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, cVar) == null) {
            c.a.n0.a.u.d.b("video", "Open Player " + cVar.j);
            M(cVar);
            this.j = cVar;
            i0(cVar);
            boolean j = cVar.j();
            this.f9556h = j;
            if (j) {
                W();
            }
            if (cVar.i() && cVar.o()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(cVar.l, cVar.q);
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? V() && Y() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public void p(k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().C();
            this.f9552d = true;
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) ? S().I(str) : invokeL.intValue;
    }

    @Override // c.a.n0.a.s0.d.k
    public void r(k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.f9552d && !this.f9554f) {
                S().X();
            } else {
                f0();
            }
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i) == null) && k0()) {
            if (!this.f9554f) {
                S().H(i);
            } else {
                this.f9553e = i;
            }
        }
    }

    @Override // c.a.n0.a.s0.d.k
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            c.a.n0.a.u.d.b("video", IntentConfig.STOP);
            Z();
            S().D();
        }
    }
}
