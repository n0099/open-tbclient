package c.a.v0.o.e;

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
import c.a.v0.o.b;
import c.a.v0.o.f.a;
import c.a.v0.o.h.a;
import c.a.v0.o.i.b;
import c.a.v0.r.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
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
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
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
/* loaded from: classes3.dex */
public class b implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener, MediaGLRenderer.OnMediaGLRendererStatusListener, b.f {
    public static /* synthetic */ Interceptable $ic;
    public static final c.a.v0.o.i.b w0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.v0.o.d.a A;
    public c.a.v0.o.d.f B;
    public c.a.v0.o.h.a C;
    public DuMixCallback D;
    public int E;
    public SurfaceTexture F;
    public float[] G;
    public b.c H;
    public float I;
    public c.a.v0.o.e.a J;
    public VideoFollowData K;
    public float L;
    public c.a.v0.o.d.d M;
    public int N;
    public String O;
    public boolean P;
    public boolean Q;
    public o R;
    public boolean S;
    public c.a.v0.o.e.c T;
    public int U;
    public c.a.v0.f.b.a V;
    public c.a.v0.f.b.a W;
    public float[] X;
    public float Y;
    public float Z;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public b.e f21765b;

    /* renamed from: c  reason: collision with root package name */
    public b.d f21766c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture.OnFrameAvailableListener f21767d;

    /* renamed from: e  reason: collision with root package name */
    public GLSurfaceView f21768e;

    /* renamed from: f  reason: collision with root package name */
    public int f21769f;

    /* renamed from: g  reason: collision with root package name */
    public int f21770g;
    public float g0;

    /* renamed from: h  reason: collision with root package name */
    public int f21771h;
    public float h0;
    public int i;
    public int i0;
    public int j;
    public int j0;
    public boolean k;
    public volatile c.a.v0.o.g.a k0;
    public String l;
    public int l0;
    public String m;
    public int m0;
    public b.InterfaceC1607b n;
    public c.a.v0.p.a n0;
    public boolean o;
    public boolean o0;
    public Handler p;
    public c.a.v0.o.c.a p0;
    public boolean q;
    public boolean q0;
    public int r;
    public float r0;
    public int s;
    public boolean s0;
    public boolean t;
    public boolean t0;
    public boolean u;
    public final c.a.v0.f.b.b u0;
    public MediaGLRenderer v;
    public c.a.v0.o.g.c v0;
    public List<IEffectProcessor> w;
    public List<IMediaRenderer> x;
    public SurfaceTexture y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.v0.o.e.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1609a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f21772b;

            public RunnableC1609a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21772b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21772b.a.f21765b == null) {
                    return;
                }
                this.f21772b.a.f21765b.d(this.a);
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.v0.o.h.a.l
        public void a(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) || this.a.f21765b == null) {
                return;
            }
            this.a.f21765b.a(iCaptureResult);
        }

        @Override // c.a.v0.o.h.a.l
        public void b(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture) == null) {
            }
        }

        @Override // c.a.v0.o.h.a.l
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f21765b == null) {
                return;
            }
            this.a.f21765b.c();
        }

        @Override // c.a.v0.o.h.a.l
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.a.p.post(new RunnableC1609a(this, i));
            }
        }

        @Override // c.a.v0.o.h.a.l
        public void e(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) || this.a.n == null) {
                return;
            }
            if ((this.a.n.f() || this.a.h0()) && this.a.n.a()) {
                this.a.n.t(i, i2, i3, i4);
            }
        }

        @Override // c.a.v0.o.h.a.l
        public void f(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == this.a.n.o()) {
                return;
            }
            this.a.X();
        }

        @Override // c.a.v0.o.h.a.l
        public void onBeautyEnableChanged(c.a.z.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || this.a.f21766c == null) {
                return;
            }
            this.a.f21766c.onBeautyEnableChanged(aVar);
        }

        @Override // c.a.v0.o.h.a.l
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.a.u = z;
                if (this.a.f21766c != null) {
                    this.a.f21766c.onChangeGender(z);
                }
            }
        }

        @Override // c.a.v0.o.h.a.l
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture) == null) {
            }
        }

        @Override // c.a.v0.o.h.a.l
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) || this.a.f21766c == null) {
                return;
            }
            this.a.f21766c.onLuaMessage(hashMap);
        }
    }

    /* renamed from: c.a.v0.o.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1610b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnTouchListenerC1610b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? (this.a.U(motionEvent) || this.a.C == null || !this.a.C.s(this.a.f21768e, motionEvent)) ? false : true : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21773b;

        public c(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21773b = bVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21773b.v.setWaitingDrawFrame(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21774b;

        public d(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21774b = bVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21774b.f21765b == null) {
                return;
            }
            this.f21774b.f21765b.h(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f21765b == null) {
                return;
            }
            this.a.f21765b.g(this.a.i, this.a.j);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f21765b == null) {
                    return;
                }
                this.a.a.f21765b.onStartSuccess();
            }
        }

        /* renamed from: c.a.v0.o.e.b$f$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1611b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public RunnableC1611b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f21765b == null) {
                    return;
                }
                this.a.a.f21765b.onStopSuccess();
            }
        }

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.v0.o.f.a.b
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a.f21765b == null) {
                return;
            }
            this.a.f21765b.b(j);
        }

        @Override // c.a.v0.o.f.a.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.t(i, str);
            }
        }

        @Override // c.a.v0.o.f.a.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.J != null) {
                    this.a.J.e(7);
                }
                this.a.p.post(new a(this));
            }
        }

        @Override // c.a.v0.o.f.a.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.p.post(new RunnableC1611b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                this.a.f21768e.requestRender();
                if (this.a.f21767d != null) {
                    this.a.f21767d.onFrameAvailable(surfaceTexture);
                }
                if (this.a.u0 != null) {
                    this.a.u0.n();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f21775b;

            public a(h hVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21775b = hVar;
                this.a = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21775b.a.f21765b == null) {
                    return;
                }
                this.f21775b.a.f21765b.b(this.a);
            }
        }

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.v0.o.f.a.e
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.p.post(new a(this, j));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.a.v0.o.g.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.v0.o.g.c
        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || this.a.C == null) {
                return;
            }
            this.a.C.r(c.a.v0.r.j.e(d2));
        }

        @Override // c.a.v0.o.g.c
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f21777c;

        public j(b bVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21777c = bVar;
            this.a = i;
            this.f21776b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21777c.f21765b == null) {
                return;
            }
            this.f21777c.f21765b.onError(this.a, this.f21776b);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f21779c;

        public k(b bVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21779c = bVar;
            this.a = i;
            this.f21778b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21779c.f21765b == null) {
                return;
            }
            this.f21779c.f21765b.onError(this.a, this.f21778b);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements c.a.v0.o.g.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.v0.o.g.c
        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || this.a.C == null) {
                return;
            }
            this.a.C.r(c.a.v0.r.j.e(d2));
        }

        @Override // c.a.v0.o.g.c
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.u0 == null) {
                return;
            }
            this.a.u0.o();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderStarted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.u0 == null) {
                return;
            }
            this.a.u0.p();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void renderFps(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public n(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onRelease();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onSetup(z, duMixInput, duMixOutput);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements b.InterfaceC1616b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        public void a() {
            c.a.v0.o.i.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = 1;
                if (b.w0.a() != 1) {
                    bVar = b.w0;
                } else {
                    bVar = b.w0;
                    i = 4;
                }
                bVar.b(i);
            }
        }

        @Override // c.a.v0.o.i.b.InterfaceC1616b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.k();
                        return;
                    } else if (i == 3) {
                        this.a.l();
                        b.w0.c(null);
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                this.a.j();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.w0.b(2);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.w0.b(3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1081840690, "Lc/a/v0/o/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1081840690, "Lc/a/v0/o/e/b;");
                return;
            }
        }
        w0 = new c.a.v0.o.i.b();
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
        this.f21769f = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f21770g = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.f21771h = 720;
        this.p = new Handler(Looper.getMainLooper());
        this.t = false;
        this.x = new CopyOnWriteArrayList();
        this.G = new float[16];
        this.I = 1.0f;
        this.L = 0.0f;
        this.M = new c.a.v0.o.d.d();
        this.P = false;
        this.Q = false;
        this.S = false;
        this.U = -100;
        this.V = null;
        this.W = null;
        this.Y = 0.0f;
        this.Z = 0.0f;
        this.g0 = 0.0f;
        this.h0 = 0.0f;
        this.q0 = false;
        this.s0 = true;
        this.v0 = new l(this);
        this.a = context;
        this.u0 = new c.a.v0.f.b.b();
        f();
        this.T = new c.a.v0.o.e.c(this.a);
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

    public void A(b.InterfaceC1607b interfaceC1607b, int i2, int i3, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{interfaceC1607b, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str}) == null) {
            this.q = false;
            if (!Q(str)) {
                t(1101, "设置输出路径错误outputDir:" + str);
                return;
            }
            this.r = i3;
            this.s = i2;
            this.n = interfaceC1607b;
            interfaceC1607b.g(this.f21769f, this.f21770g, i2, z);
            if (!(this.A instanceof c.a.v0.o.d.b)) {
                this.A = new c.a.v0.o.d.a();
            }
            g();
            this.x.add(new ResolutionRenderer());
            F(this.x);
            ArrayList arrayList = new ArrayList();
            try {
                c.a.v0.o.h.a aVar = new c.a.v0.o.h.a(this.f21768e.getContext().getApplicationContext(), new g(this));
                this.C = aVar;
                aVar.j(new m(this));
                this.C.i(new n(this));
                this.C.f(this.n.o() ? 1 : 0);
                this.C.p(new a(this));
                arrayList.add(this.C);
                arrayList.add(new AEffectProcessor());
            } catch (Exception unused) {
            }
            L(arrayList);
            this.t = true;
            b.e eVar = this.f21765b;
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public void B(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.H = cVar;
        }
    }

    public void C(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f21766c = dVar;
        }
    }

    public void D(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f21765b = eVar;
        }
    }

    public void F(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.x = list;
            this.v.setMediaRenderer(list);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.t0 = z;
        }
    }

    public boolean H(Sticker sticker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sticker, str)) == null) {
            c.a.v0.o.h.a aVar = this.C;
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
            this.i0 = i2;
            this.j0 = i3;
        }
    }

    public void L(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.w = list;
            this.v.setEffectProcessor(list);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.n;
            if (interfaceC1607b != null) {
                return interfaceC1607b.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f21768e.queueEvent(new c(this, z));
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
            this.m = str;
            File file = new File(this.m);
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
            this.S = z;
        }
    }

    public boolean U(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            c.a.v0.o.d.a aVar = this.A;
            return (aVar instanceof c.a.v0.o.d.e) && ((c.a.v0.o.d.e) aVar).j(motionEvent) && !b();
        }
        return invokeL.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && r0()) {
            this.o = true;
            this.n.i(true ^ M());
            v(this.y, this.z);
            if (this.w != null) {
                boolean M = M();
                for (IEffectProcessor iEffectProcessor : this.w) {
                    if (iEffectProcessor instanceof c.a.v0.o.h.a) {
                        ((c.a.v0.o.h.a) iEffectProcessor).f(M ? 1 : 0);
                    }
                }
            }
            P(false);
        }
    }

    public void Y(boolean z) {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (aVar = this.C) == null) {
            return;
        }
        aVar.J(z);
    }

    @Override // c.a.v0.o.b.f
    public void a(byte[] bArr, int i2) {
        c.a.v0.o.d.f fVar;
        c.a.v0.o.d.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, bArr, i2) == null) || i2 == 2 || bArr == null) {
            return;
        }
        c.a.v0.f.b.a aVar = this.V;
        if (aVar != null) {
            aVar.b();
        }
        if (this.P && (fVar2 = this.B) != null && fVar2.r() && this.M.e()) {
            this.M.c(bArr);
        }
        if (this.S && (fVar = this.B) != null && fVar.r()) {
            this.T.h(bArr);
        }
        b.InterfaceC1607b interfaceC1607b = this.n;
        if (interfaceC1607b != null) {
            interfaceC1607b.d(bArr);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.v0.f.b.b bVar = this.u0;
            if (bVar != null) {
                bVar.r();
            }
            if (this.B == null) {
                c.a.v0.o.d.f fVar = new c.a.v0.o.d.f();
                this.B = fVar;
                if (this.s0) {
                    fVar.l(this.r * 2);
                    this.B.o(60);
                    this.B.q(0);
                } else {
                    fVar.l(this.r);
                }
                this.B.k(this.t0);
                this.B.b(this.L);
                this.B.f(new f(this));
                this.B.g(new h(this));
                this.B.i(new i(this));
            }
            this.B.e(this.y);
            this.B.c(this.f21771h);
            VideoFollowData videoFollowData = this.K;
            if (videoFollowData != null && VideoFollowData.isLeftRightFollowType(videoFollowData.getFollowType()) && this.K.getOritation() == 0) {
                this.B.d(this.i, this.j / 2);
            } else {
                int i2 = (int) (this.i * this.r0);
                if (i2 == 0) {
                    i2 = this.j;
                }
                int i3 = i2 % 16;
                if (i3 != 0) {
                    i2 += 16 - i3;
                }
                this.B.d(this.i, i2);
            }
            this.B.t(this.I);
            this.B.h(this.A);
            this.B.s(this.U);
            this.B.m(this.o0);
            this.B.p(this.q0);
            o();
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.m + "part_" + currentTimeMillis + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.l = str;
            this.B.j(str);
            if (this.P) {
                this.N = this.n.b();
                String str2 = this.m + "origin_part_" + currentTimeMillis + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                this.O = str2;
                if (this.M.f(this.i, this.j, this.N, this.r, 48000, 1, str2)) {
                    this.M.b(M());
                }
            }
            if (this.S) {
                this.T.e(this.i, this.j, this.N, this.m, M());
                this.T.l();
            }
            c.a.v0.o.e.a aVar = this.J;
            if (aVar != null) {
                aVar.e(6);
            }
            return (this.B == null || this.f21765b == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.v0.o.d.a aVar = this.A;
            if (aVar instanceof c.a.v0.o.d.e) {
                return ((c.a.v0.o.d.e) aVar).k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (aVar = this.C) == null) {
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
        c.a.v0.o.e.a aVar;
        c.a.v0.f.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.B.r()) {
                try {
                    this.B.a();
                    if (this.P) {
                        this.M.j();
                    }
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aVar = this.J;
                if (aVar != null) {
                    aVar.e(10);
                }
                n();
                bVar = this.u0;
                if (bVar != null) {
                    bVar.s();
                }
                return z;
            }
            z = false;
            aVar = this.J;
            if (aVar != null) {
            }
            n();
            bVar = this.u0;
            if (bVar != null) {
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aVar = this.C) == null) {
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
            c.a.v0.f.a.b("aps_RecordMng_load", jSONObject.toString());
            b.InterfaceC1607b interfaceC1607b = this.n;
            if (interfaceC1607b != null && !interfaceC1607b.f() && (surfaceTexture = this.y) != null) {
                v(surfaceTexture, this.z);
            }
            m0(true);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            o oVar = new o(this);
            this.R = oVar;
            w0.c(oVar);
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.o0 = z;
            n();
            if (this.o0) {
                return;
            }
            o();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x.clear();
            this.x.add(this.A);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cameraW", this.i);
                jSONObject.put("cameraH", this.j);
                jSONObject.put("glSfW", this.f21768e.getMeasuredWidth());
                jSONObject.put("glSfH", this.f21768e.getMeasuredHeight());
                jSONObject.put("sW", v.e());
                jSONObject.put("sH", v.d());
                jSONObject.put("vW:", this.f21768e.getWidth());
                jSONObject.put("vH:", this.f21768e.getHeight());
                if (this.n.e() != null) {
                    jSONObject.put("preSizes", this.n.e());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.v0.f.a.b("camera_view_size", jSONObject.toString());
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.v0.o.d.f fVar = this.B;
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
            b.InterfaceC1607b interfaceC1607b = this.n;
            return interfaceC1607b != null && interfaceC1607b.f();
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.n == null || (i() && !this.o)) {
                return false;
            }
            this.o = false;
            b.e eVar = this.f21765b;
            if (eVar != null) {
                eVar.e();
            }
            boolean k2 = this.n.k(this.C.g0(), this);
            this.p.post(new d(this, k2));
            if (!k2) {
                t(1108, "camera预览失败2.cameraTextureId:1width:" + this.n.v() + "height:" + this.n.r());
                return k2;
            }
            this.C.f(this.n.o() ? 1 : 0);
            this.j = this.n.r();
            int v = this.n.v();
            this.i = v;
            K(v, this.j);
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    if (iEffectProcessor instanceof c.a.v0.o.h.a) {
                        ((c.a.v0.o.h.a) iEffectProcessor).g(this.i, this.j);
                    }
                }
            }
            this.p.post(new e(this));
            return k2;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (interfaceC1607b = this.n) == null) {
            return;
        }
        interfaceC1607b.q();
    }

    public void k0() {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.C) == null) {
            return;
        }
        aVar.z();
    }

    public final void l() {
        b.InterfaceC1607b interfaceC1607b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (interfaceC1607b = this.n) == null) {
            return;
        }
        interfaceC1607b.release();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.k0 == null) {
            return;
        }
        this.v.setWaitingDrawFrame(true);
        Bitmap N = N(this.l0, this.m0);
        int i2 = this.i0;
        int i3 = this.j0;
        float f2 = this.r0;
        if (f2 != 0.0f && N != null) {
            int i4 = this.m0;
            int i5 = this.l0;
            N = c.a.v0.r.d.d(N, 0, (int) ((((i4 - ((int) (i5 * f2))) / 2) * 0.466f) / 0.5f), i5, (int) (i5 * f2), true);
            i3 = (int) (i2 * this.r0);
        }
        this.k0.a(c.a.v0.r.d.g(N, i2, i3, true));
        this.k0 = null;
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loc", "recordMng.onLoad");
                jSONObject.put("success", "success");
                if (c.a.z.a.j.a.f22219h != null) {
                    jSONObject.put("assets", c.a.z.a.j.a.f22219h);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.v0.f.a.b(z ? "aps_RecordMng_onLoad_succ" : "aps_RecordMng_onLoad_fail", jSONObject.toString());
            b.c cVar = this.H;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.o0 && !h0()) {
            if (this.p0 == null) {
                c.a.v0.o.c.a aVar = new c.a.v0.o.c.a();
                this.p0 = aVar;
                aVar.d(this.v0);
            }
            if (this.p0.h()) {
                return;
            }
            this.p0.c();
        }
    }

    public final void o() {
        c.a.v0.o.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (aVar = this.p0) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            c.a.v0.o.e.a aVar = this.J;
            if (aVar != null) {
                aVar.f();
            }
            this.v.onDestroy();
            SurfaceTexture surfaceTexture = this.F;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.F = null;
            }
            int i2 = this.E;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.E = 0;
            }
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onDestroy();
                }
            }
            List<IMediaRenderer> list2 = this.x;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onDestroy();
                }
            }
            o oVar = this.R;
            if (oVar != null) {
                oVar.c();
                this.R = null;
            }
            c.a.v0.f.b.b bVar = this.u0;
            if (bVar != null) {
                bVar.m();
            }
            this.a = null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, gl10) == null) {
            this.F.updateTexImage();
            this.F.getTransformMatrix(this.G);
            this.v.setUpdateTexture(this.E, this.G, 0);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnDrawFrameFrequencyListener
    public void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gLViewPortLocation) == null) {
            c.a.v0.f.b.a aVar = this.W;
            if (aVar != null) {
                aVar.b();
            }
            z(gLViewPortLocation);
            m();
            c.a.v0.o.d.f fVar = this.B;
            if (fVar != null) {
                fVar.n();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048616, this, i2, str) == null) || this.f21765b == null) {
            return;
        }
        this.p.post(new k(this, i2, str));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, surfaceTexture) == null) && this.k) {
            System.nanoTime();
            this.k = false;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            c.a.v0.f.b.a aVar = this.V;
            if (aVar != null) {
                aVar.a();
                this.V = null;
            }
            c.a.v0.f.b.a aVar2 = this.W;
            if (aVar2 != null) {
                aVar2.a();
                this.W = null;
            }
            if (this.t) {
                h();
                List<IEffectProcessor> list = this.w;
                if (list != null) {
                    for (IEffectProcessor iEffectProcessor : list) {
                        iEffectProcessor.onPause();
                    }
                }
                o oVar = this.R;
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
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.t) {
            System.nanoTime();
            this.k = true;
            SurfaceTexture g0 = this.C.g0();
            this.y = g0;
            v(g0, this.z);
            this.C.B(this.i, this.j);
            this.f21768e.onResume();
            this.v.onResume();
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onResume();
                }
            }
            List<IMediaRenderer> list2 = this.x;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onResume();
                }
            }
            c.a.v0.o.e.a aVar = this.J;
            if (aVar != null) {
                aVar.c();
            }
            this.f21768e.requestRender();
            n();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048620, this, gl10, i2, i3) == null) {
            this.l0 = i2;
            this.m0 = i3;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, gl10, eGLConfig) == null) || this.v.getFullScreenEXT() == null) {
            return;
        }
        this.E = this.v.getFullScreenEXT().createTextureObject();
        this.F = new SurfaceTexture(this.E);
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public void q(float f2) {
        List<IMediaRenderer> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048623, this, f2) == null) || (list = this.x) == null) {
            return;
        }
        this.r0 = f2;
        for (IMediaRenderer iMediaRenderer : list) {
            iMediaRenderer.setResolutionRatio(f2);
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public void r(int i2) {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (aVar = this.C) == null) {
            return;
        }
        aVar.A(i2);
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            b.InterfaceC1607b interfaceC1607b = this.n;
            return interfaceC1607b != null && interfaceC1607b.f();
        }
        return invokeV.booleanValue;
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            this.f21769f = i2;
            this.f21770g = i3;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            this.I = f2;
            c.a.v0.o.d.f fVar = this.B;
            if (fVar != null) {
                fVar.t(f2);
            }
            c.a.v0.o.e.a aVar = this.J;
            if (aVar != null) {
                aVar.d(f2);
            }
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048629, this, i2, str) == null) || this.q) {
            return;
        }
        this.q = true;
        if (this.f21765b != null) {
            this.p.post(new j(this, i2, str));
        }
    }

    public void u(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onFrameAvailableListener) == null) {
            this.f21767d = onFrameAvailableListener;
        }
    }

    public synchronized void v(SurfaceTexture surfaceTexture, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, surfaceTexture, i2) == null) {
            synchronized (this) {
                this.z = i2;
                this.y = this.C.g0();
                if (surfaceTexture != null && this.t && this.R != null) {
                    this.R.a();
                }
            }
        }
    }

    public void w(GLSurfaceView gLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, gLSurfaceView) == null) {
            this.f21768e = gLSurfaceView;
            MediaGLRenderer mediaGLRenderer = new MediaGLRenderer();
            this.v = mediaGLRenderer;
            mediaGLRenderer.setRendererListener(this);
            this.v.setOnDrawFrameFrequencyListener(this);
            this.v.setOnMediaGLRendererStatusListener(this);
            this.v.setTextureReader(this.n0);
            this.v.setGlClearColor(0.102f, 0.102f, 0.102f, 0.0f);
            this.f21768e.setRenderer(this.v);
            this.f21768e.setOnTouchListener(new View$OnTouchListenerC1610b(this));
        }
    }

    public void x(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, duMixCallback) == null) {
            this.D = duMixCallback;
        }
    }

    public void y(Filter filter) {
        c.a.v0.o.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, filter) == null) || (aVar = this.C) == null) {
            return;
        }
        aVar.n(filter);
    }

    public final void z(GLViewPortLocation gLViewPortLocation) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, gLViewPortLocation) == null) || (fArr = this.X) == null) {
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
        GLES20.glClearColor(this.Y, this.Z, this.g0, this.h0);
        GLES20.glClear(16640);
        int i2 = gLViewPortLocation.height;
        GLES20.glScissor(0, (int) (i2 * f5), gLViewPortLocation.width, i2);
        GLES20.glClearColor(this.Y, this.Z, this.g0, this.h0);
        GLES20.glClear(16640);
        int i3 = gLViewPortLocation.height;
        float f6 = f5 - f3;
        GLES20.glScissor(0, (int) (i3 * f3), (int) (gLViewPortLocation.width * f2), (int) (i3 * f6));
        GLES20.glClearColor(this.Y, this.Z, this.g0, this.h0);
        GLES20.glClear(16640);
        int i4 = gLViewPortLocation.width;
        int i5 = gLViewPortLocation.height;
        GLES20.glScissor((int) (i4 * f4), (int) (i5 * f3), (int) (i4 * (1.0f - f4)), (int) (i5 * f6));
        GLES20.glClearColor(this.Y, this.Z, this.g0, this.h0);
        GLES20.glClear(16640);
        GLES20.glDisable(3089);
    }
}
