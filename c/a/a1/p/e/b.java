package c.a.a1.p.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.p.b;
import c.a.a1.p.f.a;
import c.a.a1.p.h.a;
import c.a.a1.p.i.b;
import c.a.a1.t.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import com.baidu.ugc.editvideo.record.renderer.ResolutionRenderer;
import com.baidu.ugc.editvideo.record.transition.VideoFollowData;
import com.faceunity.gles.GeneratedTexture;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener, MediaGLRenderer.OnMediaGLRendererStatusListener, b.f {
    public static /* synthetic */ Interceptable $ic;
    public static final c.a.a1.p.i.b A0;
    public transient /* synthetic */ FieldHolder $fh;
    public List<IEffectProcessor> A;
    public List<IMediaRenderer> B;
    public SurfaceTexture C;
    public int D;
    public c.a.a1.p.d.a E;
    public c.a.a1.p.d.f F;
    public c.a.a1.p.h.a G;
    public DuMixCallback H;
    public int I;
    public SurfaceTexture J;
    public float[] K;
    public b.c L;
    public float M;
    public c.a.a1.p.e.a N;
    public VideoFollowData O;
    public float P;
    public c.a.a1.p.d.d Q;
    public int R;
    public String S;
    public boolean T;
    public boolean U;
    public o V;
    public boolean W;
    public c.a.a1.p.e.c X;
    public int Y;
    public c.a.a1.f.b.a Z;
    public c.a.a1.f.b.a a0;
    public float[] b0;
    public float c0;
    public float d0;

    /* renamed from: e  reason: collision with root package name */
    public Context f1388e;
    public float e0;

    /* renamed from: f  reason: collision with root package name */
    public b.e f1389f;
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public b.d f1390g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceTexture.OnFrameAvailableListener f1391h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public GLSurfaceView f1392i;
    public volatile c.a.a1.p.g.a i0;

    /* renamed from: j  reason: collision with root package name */
    public int f1393j;

    /* renamed from: k  reason: collision with root package name */
    public int f1394k;
    public int k0;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public String q;
    public int q0;
    public b.InterfaceC0019b r;
    public c.a.a1.r.a r0;
    public boolean s;
    public boolean s0;
    public Handler t;
    public c.a.a1.p.c.a t0;
    public boolean u;
    public boolean u0;
    public int v;
    public float v0;
    public int w;
    public boolean w0;
    public boolean x;
    public boolean x0;
    public boolean y;
    public final c.a.a1.f.b.b y0;
    public MediaGLRenderer z;
    public c.a.a1.p.g.c z0;

    /* loaded from: classes.dex */
    public class a implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.a1.p.e.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0021a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f1395e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f1396f;

            public RunnableC0021a(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1396f = aVar;
                this.f1395e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1396f.a.f1389f == null) {
                    return;
                }
                this.f1396f.a.f1389f.d(this.f1395e);
            }
        }

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

        @Override // c.a.a1.p.h.a.l
        public void a(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) || this.a.f1389f == null) {
                return;
            }
            this.a.f1389f.a(iCaptureResult);
        }

        @Override // c.a.a1.p.h.a.l
        public void b(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture) == null) {
            }
        }

        @Override // c.a.a1.p.h.a.l
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f1389f == null) {
                return;
            }
            this.a.f1389f.c();
        }

        @Override // c.a.a1.p.h.a.l
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.a.t.post(new RunnableC0021a(this, i2));
            }
        }

        @Override // c.a.a1.p.h.a.l
        public void e(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) || this.a.r == null) {
                return;
            }
            if ((this.a.r.f() || this.a.h0()) && this.a.r.a()) {
                this.a.r.t(i2, i3, i4, i5);
            }
        }

        @Override // c.a.a1.p.h.a.l
        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 == this.a.r.o()) {
                return;
            }
            this.a.X();
        }

        @Override // c.a.a1.p.h.a.l
        public void onBeautyEnableChanged(c.a.b0.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || this.a.f1390g == null) {
                return;
            }
            this.a.f1390g.onBeautyEnableChanged(aVar);
        }

        @Override // c.a.a1.p.h.a.l
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.a.y = z;
                if (this.a.f1390g != null) {
                    this.a.f1390g.onChangeGender(z);
                }
            }
        }

        @Override // c.a.a1.p.h.a.l
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture) == null) {
            }
        }

        @Override // c.a.a1.p.h.a.l
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) || this.a.f1390g == null) {
                return;
            }
            this.a.f1390g.onLuaMessage(hashMap);
        }
    }

    /* renamed from: c.a.a1.p.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnTouchListenerC0022b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1397e;

        public View$OnTouchListenerC0022b(b bVar) {
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
            this.f1397e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? (this.f1397e.U(motionEvent) || this.f1397e.G == null || !this.f1397e.G.s(this.f1397e.f1392i, motionEvent)) ? false : true : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f1398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1399f;

        public c(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1399f = bVar;
            this.f1398e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1399f.z.setWaitingDrawFrame(this.f1398e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f1400e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f1401f;

        public d(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1401f = bVar;
            this.f1400e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1401f.f1389f == null) {
                return;
            }
            this.f1401f.f1389f.h(this.f1400e);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1402e;

        public e(b bVar) {
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
            this.f1402e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1402e.f1389f == null) {
                return;
            }
            this.f1402e.f1389f.g(this.f1402e.m, this.f1402e.n);
        }
    }

    /* loaded from: classes.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f1403e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1403e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1403e.a.f1389f == null) {
                    return;
                }
                this.f1403e.a.f1389f.onStartSuccess();
            }
        }

        /* renamed from: c.a.a1.p.e.b$f$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0023b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f1404e;

            public RunnableC0023b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1404e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1404e.a.f1389f == null) {
                    return;
                }
                this.f1404e.a.f1389f.onStopSuccess();
            }
        }

        public f(b bVar) {
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

        @Override // c.a.a1.p.f.a.b
        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || this.a.f1389f == null) {
                return;
            }
            this.a.f1389f.b(j2);
        }

        @Override // c.a.a1.p.f.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.t(i2, str);
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.N != null) {
                    this.a.N.e(7);
                }
                this.a.t.post(new a(this));
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.t.post(new RunnableC0023b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1405e;

        public g(b bVar) {
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
            this.f1405e = bVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                this.f1405e.f1392i.requestRender();
                if (this.f1405e.f1391h != null) {
                    this.f1405e.f1391h.onFrameAvailable(surfaceTexture);
                }
                if (this.f1405e.y0 != null) {
                    this.f1405e.y0.n();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f1406e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f1407f;

            public a(h hVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1407f = hVar;
                this.f1406e = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1407f.a.f1389f == null) {
                    return;
                }
                this.f1407f.a.f1389f.b(this.f1406e);
            }
        }

        public h(b bVar) {
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

        @Override // c.a.a1.p.f.a.e
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.a.t.post(new a(this, j2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.a1.p.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public i(b bVar) {
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

        @Override // c.a.a1.p.g.c
        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || this.a.G == null) {
                return;
            }
            this.a.G.r(c.a.a1.t.j.e(d2));
        }

        @Override // c.a.a1.p.g.c
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1409f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f1410g;

        public j(b bVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1410g = bVar;
            this.f1408e = i2;
            this.f1409f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1410g.f1389f == null) {
                return;
            }
            this.f1410g.f1389f.onError(this.f1408e, this.f1409f);
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f1412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f1413g;

        public k(b bVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1413g = bVar;
            this.f1411e = i2;
            this.f1412f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f1413g.f1389f == null) {
                return;
            }
            this.f1413g.f1389f.onError(this.f1411e, this.f1412f);
        }
    }

    /* loaded from: classes.dex */
    public class l implements c.a.a1.p.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public l(b bVar) {
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

        @Override // c.a.a1.p.g.c
        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || this.a.G == null) {
                return;
            }
            this.a.G.r(c.a.a1.t.j.e(d2));
        }

        @Override // c.a.a1.p.g.c
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements ARRenderFpsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public m(b bVar) {
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

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public int listenType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderFinished() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.y0 == null) {
                return;
            }
            this.a.y0.o();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderStarted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.y0 == null) {
                return;
            }
            this.a.y0.p();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void renderFps(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f1414e;

        public n(b bVar) {
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
            this.f1414e = bVar;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.f1414e.H == null) {
                return;
            }
            this.f1414e.H.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f1414e.H == null) {
                return;
            }
            this.f1414e.H.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.f1414e.H == null) {
                return;
            }
            this.f1414e.H.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f1414e.H == null) {
                return;
            }
            this.f1414e.H.onRelease();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) || this.f1414e.H == null) {
                return;
            }
            this.f1414e.H.onSetup(z, duMixInput, duMixOutput);
        }
    }

    /* loaded from: classes.dex */
    public class o implements b.InterfaceC0028b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public o(b bVar) {
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

        public void a() {
            c.a.a1.p.i.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = 1;
                if (b.A0.a() != 1) {
                    bVar = b.A0;
                } else {
                    bVar = b.A0;
                    i2 = 4;
                }
                bVar.b(i2);
            }
        }

        @Override // c.a.a1.p.i.b.InterfaceC0028b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.a.k();
                        return;
                    } else if (i2 == 3) {
                        this.a.l();
                        b.A0.c(null);
                        return;
                    } else if (i2 != 4) {
                        return;
                    }
                }
                this.a.j();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.A0.b(2);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.A0.b(3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2139849061, "Lc/a/a1/p/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2139849061, "Lc/a/a1/p/e/b;");
                return;
            }
        }
        A0 = new c.a.a1.p.i.b();
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1393j = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f1394k = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.l = 720;
        this.t = new Handler(Looper.getMainLooper());
        this.x = false;
        this.B = new CopyOnWriteArrayList();
        this.K = new float[16];
        this.M = 1.0f;
        this.P = 0.0f;
        this.Q = new c.a.a1.p.d.d();
        this.T = false;
        this.U = false;
        this.W = false;
        this.Y = -100;
        this.Z = null;
        this.a0 = null;
        this.c0 = 0.0f;
        this.d0 = 0.0f;
        this.e0 = 0.0f;
        this.f0 = 0.0f;
        this.u0 = false;
        this.w0 = true;
        this.z0 = new l(this);
        this.f1388e = context;
        this.y0 = new c.a.a1.f.b.b();
        f();
        this.X = new c.a.a1.p.e.c(this.f1388e);
    }

    public static Bitmap N(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i2, i3)) == null) {
            int i4 = i2 * i3 * 4;
            try {
                int[] iArr = new int[i4];
                IntBuffer allocate = IntBuffer.allocate(i4);
                GLES20.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, allocate);
                int[] array = allocate.array();
                for (int i5 = 0; i5 < i3; i5++) {
                    for (int i6 = 0; i6 < i2; i6++) {
                        iArr[(((i3 - i5) - 1) * i2) + i6] = array[(i5 * i2) + i6];
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    public void A(b.InterfaceC0019b interfaceC0019b, int i2, int i3, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{interfaceC0019b, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str}) == null) {
            this.u = false;
            if (!Q(str)) {
                t(1101, "设置输出路径错误outputDir:" + str);
                return;
            }
            this.v = i3;
            this.w = i2;
            this.r = interfaceC0019b;
            interfaceC0019b.g(this.f1393j, this.f1394k, i2, z);
            if (!(this.E instanceof c.a.a1.p.d.b)) {
                this.E = new c.a.a1.p.d.a();
            }
            g();
            this.B.add(new ResolutionRenderer());
            F(this.B);
            ArrayList arrayList = new ArrayList();
            try {
                c.a.a1.p.h.a aVar = new c.a.a1.p.h.a(this.f1392i.getContext().getApplicationContext(), new g(this));
                this.G = aVar;
                aVar.j(new m(this));
                this.G.i(new n(this));
                this.G.f(this.r.o() ? 1 : 0);
                this.G.p(new a(this));
                arrayList.add(this.G);
                arrayList.add(new AEffectProcessor());
            } catch (Exception unused) {
            }
            L(arrayList);
            this.x = true;
            b.e eVar = this.f1389f;
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public void B(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.L = cVar;
        }
    }

    public void C(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f1390g = dVar;
        }
    }

    public void D(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f1389f = eVar;
        }
    }

    public void F(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.B = list;
            this.z.setMediaRenderer(list);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.x0 = z;
        }
    }

    public boolean H(Sticker sticker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sticker, str)) == null) {
            c.a.a1.p.h.a aVar = this.G;
            if (aVar != null) {
                aVar.o(sticker);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void K(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.g0 = i2;
            this.h0 = i3;
        }
    }

    public void L(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.A = list;
            this.z.setEffectProcessor(list);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.r;
            if (interfaceC0019b != null) {
                return interfaceC0019b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f1392i.queueEvent(new c(this, z));
        }
    }

    public boolean Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            this.q = str;
            File file = new File(this.q);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.W = z;
        }
    }

    public boolean U(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            c.a.a1.p.d.a aVar = this.E;
            return (aVar instanceof c.a.a1.p.d.e) && ((c.a.a1.p.d.e) aVar).j(motionEvent) && !b();
        }
        return invokeL.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && r0()) {
            this.s = true;
            this.r.i(true ^ M());
            v(this.C, this.D);
            if (this.A != null) {
                boolean M = M();
                for (IEffectProcessor iEffectProcessor : this.A) {
                    if (iEffectProcessor instanceof c.a.a1.p.h.a) {
                        ((c.a.a1.p.h.a) iEffectProcessor).f(M ? 1 : 0);
                    }
                }
            }
            P(false);
        }
    }

    public void Y(boolean z) {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.J(z);
    }

    @Override // c.a.a1.p.b.f
    public void a(byte[] bArr, int i2) {
        c.a.a1.p.d.f fVar;
        c.a.a1.p.d.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, bArr, i2) == null) || i2 == 2 || bArr == null) {
            return;
        }
        c.a.a1.f.b.a aVar = this.Z;
        if (aVar != null) {
            aVar.b();
        }
        if (this.T && (fVar2 = this.F) != null && fVar2.r() && this.Q.e()) {
            this.Q.c(bArr);
        }
        if (this.W && (fVar = this.F) != null && fVar.r()) {
            this.X.h(bArr);
        }
        b.InterfaceC0019b interfaceC0019b = this.r;
        if (interfaceC0019b != null) {
            interfaceC0019b.d(bArr);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.a1.f.b.b bVar = this.y0;
            if (bVar != null) {
                bVar.r();
            }
            if (this.F == null) {
                c.a.a1.p.d.f fVar = new c.a.a1.p.d.f();
                this.F = fVar;
                if (this.w0) {
                    fVar.l(this.v * 2);
                    this.F.o(60);
                    this.F.q(0);
                } else {
                    fVar.l(this.v);
                }
                this.F.k(this.x0);
                this.F.b(this.P);
                this.F.f(new f(this));
                this.F.g(new h(this));
                this.F.i(new i(this));
            }
            this.F.e(this.C);
            this.F.c(this.l);
            VideoFollowData videoFollowData = this.O;
            if (videoFollowData != null && VideoFollowData.isLeftRightFollowType(videoFollowData.getFollowType()) && this.O.getOritation() == 0) {
                this.F.d(this.m, this.n / 2);
            } else {
                int i2 = (int) (this.m * this.v0);
                if (i2 == 0) {
                    i2 = this.n;
                }
                int i3 = i2 % 16;
                if (i3 != 0) {
                    i2 += 16 - i3;
                }
                this.F.d(this.m, i2);
            }
            this.F.t(this.M);
            this.F.h(this.E);
            this.F.s(this.Y);
            this.F.m(this.s0);
            this.F.p(this.u0);
            o();
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.q + "part_" + currentTimeMillis + ".mp4";
            this.p = str;
            this.F.j(str);
            if (this.T) {
                this.R = this.r.b();
                String str2 = this.q + "origin_part_" + currentTimeMillis + ".mp4";
                this.S = str2;
                if (this.Q.f(this.m, this.n, this.R, this.v, MediaEncodeParams.AUDIO_SAMPLE_RATE, 1, str2)) {
                    this.Q.b(M());
                }
            }
            if (this.W) {
                this.X.e(this.m, this.n, this.R, this.q, M());
                this.X.l();
            }
            c.a.a1.p.e.a aVar = this.N;
            if (aVar != null) {
                aVar.e(6);
            }
            return (this.F == null || this.f1389f == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.a1.p.d.a aVar = this.E;
            if (aVar instanceof c.a.a1.p.d.e) {
                return ((c.a.a1.p.d.e) aVar).k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.b0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c0() {
        InterceptResult invokeV;
        boolean z;
        c.a.a1.p.e.a aVar;
        c.a.a1.f.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.F.r()) {
                try {
                    this.F.a();
                    if (this.T) {
                        this.Q.j();
                    }
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aVar = this.N;
                if (aVar != null) {
                    aVar.e(10);
                }
                n();
                bVar = this.y0;
                if (bVar != null) {
                    bVar.s();
                }
                return z;
            }
            z = false;
            aVar = this.N;
            if (aVar != null) {
            }
            n();
            bVar = this.y0;
            if (bVar != null) {
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.e0();
    }

    public void e0() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loc", "recordMng.loadData");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.a1.f.a.b("aps_RecordMng_load", jSONObject.toString());
            b.InterfaceC0019b interfaceC0019b = this.r;
            if (interfaceC0019b != null && !interfaceC0019b.f() && (surfaceTexture = this.C) != null) {
                v(surfaceTexture, this.D);
            }
            m0(true);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            o oVar = new o(this);
            this.V = oVar;
            A0.c(oVar);
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.s0 = z;
            n();
            if (this.s0) {
                return;
            }
            o();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.B.clear();
            this.B.add(this.E);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cameraW", this.m);
                jSONObject.put("cameraH", this.n);
                jSONObject.put("glSfW", this.f1392i.getMeasuredWidth());
                jSONObject.put("glSfH", this.f1392i.getMeasuredHeight());
                jSONObject.put("sW", v.e());
                jSONObject.put("sH", v.d());
                jSONObject.put("vW:", this.f1392i.getWidth());
                jSONObject.put("vH:", this.f1392i.getHeight());
                if (this.r.e() != null) {
                    jSONObject.put("preSizes", this.r.e());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.a1.f.a.b("camera_view_size", jSONObject.toString());
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.a1.p.d.f fVar = this.F;
            if (fVar == null) {
                return false;
            }
            return fVar.r();
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.r;
            return interfaceC0019b != null && interfaceC0019b.f();
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.r == null || (i() && !this.s)) {
                return false;
            }
            this.s = false;
            b.e eVar = this.f1389f;
            if (eVar != null) {
                eVar.e();
            }
            boolean k2 = this.r.k(this.G.g0(), this);
            this.t.post(new d(this, k2));
            if (!k2) {
                t(1108, "camera预览失败2.cameraTextureId:1width:" + this.r.v() + "height:" + this.r.r());
                return k2;
            }
            this.G.f(this.r.o() ? 1 : 0);
            this.n = this.r.r();
            int v = this.r.v();
            this.m = v;
            K(v, this.n);
            List<IEffectProcessor> list = this.A;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    if (iEffectProcessor instanceof c.a.a1.p.h.a) {
                        ((c.a.a1.p.h.a) iEffectProcessor).g(this.m, this.n);
                    }
                }
            }
            this.t.post(new e(this));
            return k2;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (interfaceC0019b = this.r) == null) {
            return;
        }
        interfaceC0019b.q();
    }

    public void k0() {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.z();
    }

    public final void l() {
        b.InterfaceC0019b interfaceC0019b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (interfaceC0019b = this.r) == null) {
            return;
        }
        interfaceC0019b.release();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.i0 == null) {
            return;
        }
        this.z.setWaitingDrawFrame(true);
        Bitmap N = N(this.k0, this.q0);
        int i2 = this.g0;
        int i3 = this.h0;
        float f2 = this.v0;
        if (f2 != 0.0f && N != null) {
            int i4 = this.q0;
            int i5 = this.k0;
            N = c.a.a1.t.d.d(N, 0, (int) ((((i4 - ((int) (i5 * f2))) / 2) * 0.466f) / 0.5f), i5, (int) (i5 * f2), true);
            i3 = (int) (i2 * this.v0);
        }
        this.i0.a(c.a.a1.t.d.g(N, i2, i3, true));
        this.i0 = null;
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loc", "recordMng.onLoad");
                jSONObject.put("success", "success");
                if (c.a.b0.a.j.a.f1622h != null) {
                    jSONObject.put("assets", c.a.b0.a.j.a.f1622h);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.a1.f.a.b(z ? "aps_RecordMng_onLoad_succ" : "aps_RecordMng_onLoad_fail", jSONObject.toString());
            b.c cVar = this.L;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s0 && !h0()) {
            if (this.t0 == null) {
                c.a.a1.p.c.a aVar = new c.a.a1.p.c.a();
                this.t0 = aVar;
                aVar.d(this.z0);
            }
            if (this.t0.h()) {
                return;
            }
            this.t0.c();
        }
    }

    public final void o() {
        c.a.a1.p.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (aVar = this.t0) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            c.a.a1.p.e.a aVar = this.N;
            if (aVar != null) {
                aVar.f();
            }
            this.z.onDestroy();
            SurfaceTexture surfaceTexture = this.J;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.J = null;
            }
            int i2 = this.I;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.I = 0;
            }
            List<IEffectProcessor> list = this.A;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onDestroy();
                }
            }
            List<IMediaRenderer> list2 = this.B;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onDestroy();
                }
            }
            o oVar = this.V;
            if (oVar != null) {
                oVar.c();
                this.V = null;
            }
            c.a.a1.f.b.b bVar = this.y0;
            if (bVar != null) {
                bVar.m();
            }
            this.f1388e = null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, gl10) == null) {
            this.J.updateTexImage();
            this.J.getTransformMatrix(this.K);
            this.z.setUpdateTexture(this.I, this.K, 0);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnDrawFrameFrequencyListener
    public void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gLViewPortLocation) == null) {
            c.a.a1.f.b.a aVar = this.a0;
            if (aVar != null) {
                aVar.b();
            }
            z(gLViewPortLocation);
            m();
            c.a.a1.p.d.f fVar = this.F;
            if (fVar != null) {
                fVar.n();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048616, this, i2, str) == null) || this.f1389f == null) {
            return;
        }
        this.t.post(new k(this, i2, str));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, surfaceTexture) == null) && this.o) {
            System.nanoTime();
            this.o = false;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            c.a.a1.f.b.a aVar = this.Z;
            if (aVar != null) {
                aVar.a();
                this.Z = null;
            }
            c.a.a1.f.b.a aVar2 = this.a0;
            if (aVar2 != null) {
                aVar2.a();
                this.a0 = null;
            }
            if (this.x) {
                h();
                List<IEffectProcessor> list = this.A;
                if (list != null) {
                    for (IEffectProcessor iEffectProcessor : list) {
                        iEffectProcessor.onPause();
                    }
                }
                o oVar = this.V;
                if (oVar != null) {
                    oVar.b();
                }
                o();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.x) {
            System.nanoTime();
            this.o = true;
            SurfaceTexture g0 = this.G.g0();
            this.C = g0;
            v(g0, this.D);
            this.G.B(this.m, this.n);
            this.f1392i.onResume();
            this.z.onResume();
            List<IEffectProcessor> list = this.A;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onResume();
                }
            }
            List<IMediaRenderer> list2 = this.B;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onResume();
                }
            }
            c.a.a1.p.e.a aVar = this.N;
            if (aVar != null) {
                aVar.c();
            }
            this.f1392i.requestRender();
            n();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048620, this, gl10, i2, i3) == null) {
            this.k0 = i2;
            this.q0 = i3;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, gl10, eGLConfig) == null) || this.z.getFullScreenEXT() == null) {
            return;
        }
        this.I = this.z.getFullScreenEXT().createTextureObject();
        this.J = new SurfaceTexture(this.I);
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public void q(float f2) {
        List<IMediaRenderer> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048623, this, f2) == null) || (list = this.B) == null) {
            return;
        }
        this.v0 = f2;
        for (IMediaRenderer iMediaRenderer : list) {
            iMediaRenderer.setResolutionRatio(f2);
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public void r(int i2) {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.A(i2);
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            b.InterfaceC0019b interfaceC0019b = this.r;
            return interfaceC0019b != null && interfaceC0019b.f();
        }
        return invokeV.booleanValue;
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            this.f1393j = i2;
            this.f1394k = i3;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            this.M = f2;
            c.a.a1.p.d.f fVar = this.F;
            if (fVar != null) {
                fVar.t(f2);
            }
            c.a.a1.p.e.a aVar = this.N;
            if (aVar != null) {
                aVar.d(f2);
            }
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048629, this, i2, str) == null) || this.u) {
            return;
        }
        this.u = true;
        if (this.f1389f != null) {
            this.t.post(new j(this, i2, str));
        }
    }

    public void u(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onFrameAvailableListener) == null) {
            this.f1391h = onFrameAvailableListener;
        }
    }

    public synchronized void v(SurfaceTexture surfaceTexture, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, surfaceTexture, i2) == null) {
            synchronized (this) {
                this.D = i2;
                this.C = this.G.g0();
                if (surfaceTexture != null && this.x && this.V != null) {
                    this.V.a();
                }
            }
        }
    }

    public void w(GLSurfaceView gLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, gLSurfaceView) == null) {
            this.f1392i = gLSurfaceView;
            MediaGLRenderer mediaGLRenderer = new MediaGLRenderer();
            this.z = mediaGLRenderer;
            mediaGLRenderer.setRendererListener(this);
            this.z.setOnDrawFrameFrequencyListener(this);
            this.z.setOnMediaGLRendererStatusListener(this);
            this.z.setTextureReader(this.r0);
            this.z.setGlClearColor(0.102f, 0.102f, 0.102f, 0.0f);
            this.f1392i.setRenderer(this.z);
            this.f1392i.setOnTouchListener(new View$OnTouchListenerC0022b(this));
        }
    }

    public void x(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, duMixCallback) == null) {
            this.H = duMixCallback;
        }
    }

    public void y(Filter filter) {
        c.a.a1.p.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, filter) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.n(filter);
    }

    public final void z(GLViewPortLocation gLViewPortLocation) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, gLViewPortLocation) == null) || (fArr = this.b0) == null) {
            return;
        }
        float f2 = fArr[0];
        float f3 = 1.0f - fArr[3];
        float f4 = fArr[2];
        float f5 = 1.0f - fArr[1];
        if (f2 < 0.0f || f3 < 0.0f || f4 > 1.0f || f5 > 1.0f || f4 <= f2 || f5 <= f3) {
            return;
        }
        GLES20.glEnable(3089);
        GLES20.glScissor(0, 0, gLViewPortLocation.width, (int) (gLViewPortLocation.height * f3));
        GLES20.glClearColor(this.c0, this.d0, this.e0, this.f0);
        GLES20.glClear(16640);
        int i2 = gLViewPortLocation.height;
        GLES20.glScissor(0, (int) (i2 * f5), gLViewPortLocation.width, i2);
        GLES20.glClearColor(this.c0, this.d0, this.e0, this.f0);
        GLES20.glClear(16640);
        int i3 = gLViewPortLocation.height;
        float f6 = f5 - f3;
        GLES20.glScissor(0, (int) (i3 * f3), (int) (gLViewPortLocation.width * f2), (int) (i3 * f6));
        GLES20.glClearColor(this.c0, this.d0, this.e0, this.f0);
        GLES20.glClear(16640);
        int i4 = gLViewPortLocation.width;
        int i5 = gLViewPortLocation.height;
        GLES20.glScissor((int) (i4 * f4), (int) (i5 * f3), (int) (i4 * (1.0f - f4)), (int) (i5 * f6));
        GLES20.glClearColor(this.c0, this.d0, this.e0, this.f0);
        GLES20.glClear(16640);
        GLES20.glDisable(3089);
    }
}
