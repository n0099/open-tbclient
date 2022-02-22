package c.a.s0.y.l.b.b;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.c1.d.k;
import c.a.s0.a.z2.q;
import c.a.s0.y.i;
import c.a.s0.y.l.b.c.c;
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
/* loaded from: classes6.dex */
public class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanVideoView a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12209b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f12210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12211d;

    /* renamed from: e  reason: collision with root package name */
    public int f12212e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12213f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12214g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12215h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12216i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.a.j1.g.c f12217j;
    public FrameLayout k;
    public k.d l;
    public k.b m;
    public k.a n;
    public k.e o;
    public k.f p;
    public k.c q;
    public boolean r;
    public int s;

    /* renamed from: c.a.s0.y.l.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0832a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f12219f;

        public RunnableC0832a(a aVar, Activity activity) {
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
            this.f12219f = aVar;
            this.f12218e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12218e.setRequestedOrientation(0);
                this.f12218e.getWindow().addFlags(1024);
                this.f12219f.Q(this.f12218e);
                SwanAppComponentContainerView G = this.f12219f.R().G();
                G.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                i.b(G);
                i.a(this.f12218e, G);
                c.a.s0.y.l.b.a.a.c(this.f12219f.f12217j.n, this.f12219f.f12217j.f5551g, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12220e;

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
            this.f12220e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.b(this.f12220e.R().G());
                this.f12220e.R().insert();
                c.a.s0.y.l.b.a.a.c(this.f12220e.f12217j.n, this.f12220e.f12217j.f5551g, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12221e;

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
            this.f12221e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12221e.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12222e;

        /* renamed from: c.a.s0.y.l.b.b.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0833a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f12223e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f12224f;

            public RunnableC0833a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12224f = dVar;
                this.f12223e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.s0.y.l.b.a.a.b(this.f12224f.f12222e.f12217j.n, this.f12224f.f12222e.f12217j.f5551g, this.f12223e, this.f12224f.f12222e.S().getWidth(), this.f12224f.f12222e.S().getHeight());
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12222e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.f12222e.f12217j.C, new HashMap());
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    mediaMetadataRetriever.release();
                    this.f12222e.S().post(new RunnableC0833a(this, extractMetadata));
                } catch (RuntimeException unused) {
                    boolean unused2 = a.t;
                    mediaMetadataRetriever.release();
                    c.a.s0.y.l.b.a.a.a(this.f12222e.f12217j.n, this.f12222e.f12217j.f5551g, "error", c.a.s0.y.l.a.b.a.c(0));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != -1) {
                    if (i2 != 1) {
                        return;
                    }
                    this.a.S().start();
                    return;
                }
                this.a.stop();
                this.a.e0();
                this.a.R().N(this.a.f12217j.p, this.a.f12217j.u);
            }
        }

        public /* synthetic */ e(a aVar, RunnableC0832a runnableC0832a) {
            this(aVar);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends c.a.s0.y.j.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.s0.y.j.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f12211d = false;
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.f12216i = true;
                this.a.S().updateTipState(MediaTipStateLayer.TipState.END);
                c.a.s0.a.e0.d.b("video", "onEnded call back");
            }
        }

        @Override // c.a.s0.y.j.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.f12217j.o = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e2) {
                    if (a.t) {
                        e2.printStackTrace();
                    }
                }
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "muted", jSONObject);
            }
        }

        @Override // c.a.s0.y.j.a
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    c.a.s0.a.e0.d.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "waiting", new JSONObject());
                    return;
                }
                c.a.s0.a.e0.d.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
            }
        }

        @Override // c.a.s0.y.j.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.f12217j.U = z;
                if (z) {
                    this.a.X();
                } else {
                    this.a.Y();
                }
            }
        }

        public final void e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i3));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i2));
                } catch (JSONException e2) {
                    if (a.t) {
                        e2.printStackTrace();
                    }
                }
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "timeupdate", jSONObject);
            }
        }

        @Override // c.a.s0.y.j.a
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
                this.a.f12211d = false;
                c.a.s0.a.e0.d.c("video", "errorCode :" + i2);
                this.a.R().J();
                this.a.R().K();
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "error", c.a.s0.y.l.a.b.a.c(i3));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i2, i3);
                }
                this.a.f12216i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                a aVar = this.a;
                if (currentPosition <= 0) {
                    currentPosition = aVar.s;
                }
                aVar.s = currentPosition;
                this.a.S().updateTipState(MediaTipStateLayer.TipState.ERROR);
                c.a.s0.a.e0.d.c("video", "onError what " + i2 + " ,extra " + i3);
            }
        }

        @Override // c.a.s0.y.j.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "pause", new JSONObject());
                c.a.s0.a.e0.d.b("video", "onPaused call back");
                this.a.f12211d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // c.a.s0.y.j.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                c.a.s0.a.e0.d.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }

        @Override // c.a.s0.y.j.b, c.a.s0.y.j.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "play", new JSONObject());
                this.a.f12216i = false;
                this.a.f12211d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // c.a.s0.y.j.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                c.a.s0.y.l.b.a.a.a(this.a.f12217j.n, this.a.f12217j.f5551g, "play", new JSONObject());
                this.a.f12216i = false;
                this.a.f12211d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        public /* synthetic */ f(a aVar, RunnableC0832a runnableC0832a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1230236601, "Lc/a/s0/y/l/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1230236601, "Lc/a/s0/y/l/b/b/a;");
                return;
            }
        }
        t = c.a.s0.a.k.a;
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
        this.f12214g = true;
        this.s = 0;
    }

    public final void M(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            c.a.s0.a.j1.g.c cVar2 = this.f12217j;
            if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f12217j.C, cVar.C)) {
                this.f12213f = true;
            } else {
                this.f12213f = false;
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
                S().updateTipState(MediaTipStateLayer.TipState.NO_NETWORK);
                return false;
            } else if (z) {
                if (SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._2G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._3G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._4G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._5G) {
                    R().J();
                    R().K();
                    S().updateTipState(MediaTipStateLayer.TipState.NO_WIFI);
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public a O(Context context, @NonNull c.a.s0.a.j1.g.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar)) == null) {
            this.f12209b = context;
            this.f12217j = cVar;
            R();
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f12214g) {
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
            if (this.f12217j == null) {
                c.a.s0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.f12210c == null) {
                this.f12210c = new VideoContainerManager(this.f12209b, this.f12217j);
            }
            return this.f12210c;
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
            c.a.s0.a.e0.d.i("video", "create player");
            this.a = new SwanVideoView(this.f12209b);
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
                c.a.s0.a.j1.g.c cVar = this.f12217j;
                c.a.s0.y.l.b.a.a.a(cVar.n, cVar.f5551g, "error", c.a.s0.y.l.a.b.a.c(0));
                return;
            }
            if (!this.f12217j.j() || !this.f12217j.p()) {
                U();
                i0(this.f12217j);
            }
            q.k(new d(this), "preloadVideoMetadata");
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            if (L == null || (activity = L.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new RunnableC0832a(this, activity));
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
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
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
        swanVideoView.stopPlayback();
        i.b(this.a);
        this.a = null;
    }

    @Override // c.a.s0.a.c1.d.k
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameLayout) == null) {
            this.k = frameLayout;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && k0()) {
            if (this.f12212e != 0) {
                S().seekTo(this.f12212e);
                this.f12212e = 0;
                return;
            }
            int i2 = this.f12217j.q;
            if (i2 != 0) {
                this.a.seekTo(i2 * 1000);
                this.f12217j.q = 0;
                return;
            }
            int i3 = this.s;
            if (i3 != 0) {
                this.a.seekTo(i3);
                this.s = 0;
            }
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void b0(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            if (cVar == null) {
                c.a.s0.a.e0.d.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.f12217j.C);
            c.a.s0.a.e0.d.b("video", "setDataSource url " + cVar.C);
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void c0(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            if (cVar.W) {
                S().showSilentPlay(true);
                S().showSilentMuteButton(cVar.Y);
                S().setSilentTips(cVar.Z);
                mute(true);
            } else {
                S().showSilentPlay(false);
                mute(cVar.o);
            }
            c.b bVar = new c.b();
            bVar.k(cVar.W);
            bVar.i(cVar.P);
            bVar.h(cVar.H);
            bVar.g(cVar.Q);
            bVar.j(cVar.L);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(cVar.B);
            S().setLooping(cVar.t);
            S().showFullscreenBtn(cVar.K);
            S().showMuteButton(cVar.n());
            S().showCenterPlayButton(cVar.l());
            S().showPlayButton(cVar.o());
            S().showRateButton(cVar.T);
            S().showDanmuButton(cVar.A);
            S().showSeekBar(cVar.I);
            S().showSettingButton(cVar.V);
            S().setTitle(cVar.O);
            if (TextUtils.equals(cVar.u, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(cVar.u, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(cVar.U, cVar.J);
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public final boolean d0(c.a.s0.a.j1.g.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, cVar)) == null) {
            c.a.s0.a.j1.g.c cVar2 = this.f12217j;
            if (cVar2 == null) {
                return false;
            }
            if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
                c.a.s0.a.j1.g.c cVar3 = this.f12217j;
                if (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.P == cVar.P && cVar3.W == cVar.W && cVar3.J == cVar.J && cVar3.T == cVar.T && cVar3.o() == cVar.o() && this.f12217j.l() == cVar.l() && this.f12217j.n() == cVar.n() && this.f12217j.m() == cVar.m() && TextUtils.equals(this.f12217j.O, cVar.O)) {
                    c.a.s0.a.j1.g.c cVar4 = this.f12217j;
                    if (cVar4.V == cVar.V && cVar4.U == cVar.U && cVar4.Q == cVar.Q && cVar4.t == cVar.t) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public /* bridge */ /* synthetic */ k e(Context context, @NonNull c.a.s0.a.j1.g.c cVar) {
        O(context, cVar);
        return this;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    @Override // c.a.s0.a.c1.d.k
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
            S().openVideo();
            c0(this.f12217j);
            h(this.f12217j, false);
            b0(this.f12217j);
            if (N(this.f12217j.N)) {
                S().startWithFocus();
            }
            this.f12213f = false;
        }
    }

    @Override // c.a.s0.a.c1.d.k
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
        swanVideoView.stopPlayback();
    }

    @Override // c.a.s0.a.c1.d.k
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? S().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? S().getDuration() : invokeV.intValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public void h(c.a.s0.a.j1.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, cVar, z) == null) {
            if (t) {
                String str = "fromUpdateAction=" + z + " params:" + cVar.toString();
            }
            c.a.s0.a.e0.d.b("video", "updatePlayerConfigInternal params: " + cVar.toString());
            if (d0(cVar)) {
                c0(cVar);
            }
            this.f12217j = cVar;
            if (z) {
                h0(cVar.p());
            }
            i0(cVar);
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (t) {
                String str = "updatePlayStateAfterVisibleChanged isVisible=" + z;
            }
            if (this.a == null || z || !isPlaying()) {
                return;
            }
            this.a.pause();
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    public void i0(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            R().O(cVar);
            j0();
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f12216i : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SwanVideoView swanVideoView = this.a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.k
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
        i.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // c.a.s0.a.c1.d.k
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
            c.a.s0.a.j1.g.c cVar = this.f12217j;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f12217j.n) || TextUtils.isEmpty(this.f12217j.f5550f)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public void l(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c.a.s0.y.m.a.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void m(k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void n(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, cVar) == null) {
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void o(c.a.s0.a.j1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, cVar) == null) {
            c.a.s0.a.e0.d.b("video", "Open Player " + cVar.n);
            M(cVar);
            this.f12217j = cVar;
            i0(cVar);
            boolean k = cVar.k();
            this.f12215h = k;
            if (k) {
                W();
            }
            if (cVar.j() && cVar.p()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(cVar.p, cVar.u);
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? V() && Y() : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public void p(k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().pause();
            this.f12211d = true;
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) ? S().setPlayBackRate(str) : invokeL.intValue;
    }

    @Override // c.a.s0.a.c1.d.k
    public void r(k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.f12211d && !this.f12213f) {
                S().start();
            } else {
                f0();
            }
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i2) == null) && k0()) {
            if (!this.f12213f) {
                S().seekTo(i2);
            } else {
                this.f12212e = i2;
            }
        }
    }

    @Override // c.a.s0.a.c1.d.k
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            c.a.s0.a.e0.d.b("video", IntentConfig.STOP);
            Z();
            S().release();
        }
    }
}
