package c.a.t0.l0.c;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.p.b;
import c.a.a1.t.j;
import c.a.t0.l0.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements c.a.t0.l0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19330b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19331c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19332d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f19333e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.a1.p.b f19334f;

    /* renamed from: g  reason: collision with root package name */
    public AspectGLSurfaceView f19335g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f19336h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC1197a f19337i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19338j;
    public c.a.b0.a.d k;
    public b.e l;
    public j.a m;
    public b.d n;
    public c.a.t0.e0.c.a o;
    public c.a.t0.e0.b.a p;

    /* loaded from: classes7.dex */
    public class a extends c.a.b0.a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.b0.a.d, com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                super.onCaseCreate(z, str, str2);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, duMixErrorType, str, str2) == null) {
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
            }
        }
    }

    /* renamed from: c.a.t0.l0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1198b implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1198b(b bVar) {
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

        @Override // c.a.a1.p.b.e
        public void a(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) {
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || this.a.f19337i == null) {
                return;
            }
            this.a.f19337i.b(j2);
        }

        @Override // c.a.a1.p.b.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.a1.p.b.e
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.a1.p.b.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // c.a.a1.p.b.e
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // c.a.a1.p.b.e
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
                return;
            }
            this.a.f19335g.setAspectRatio(i2 / i3, 1);
        }

        @Override // c.a.a1.p.b.e
        public void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.a.f19332d = true;
                if (this.a.f19336h != null) {
                    this.a.f19336h.b();
                }
            }
        }

        @Override // c.a.a1.p.f.a.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.a.f19334f != null && this.a.f19336h != null) {
                    this.a.f19336h.a(this.a.f19334f.b());
                }
                this.a.f19332d = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
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

        @Override // c.a.a1.t.j.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f19334f == null) {
                return;
            }
            this.a.f19334f.n();
        }

        @Override // c.a.a1.t.j.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.a.f19334f == null) {
                return;
            }
            this.a.f19334f.o(z);
        }

        @Override // c.a.a1.t.j.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void g(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i2) != null) || i2 < 3000) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.f19334f == null) {
                return;
            }
            this.a.f19334f.j();
        }

        @Override // c.a.a1.t.j.a
        public void i() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.f19334f == null) {
                return;
            }
            this.a.f19334f.h();
        }

        @Override // c.a.a1.t.j.a
        public void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            }
        }

        @Override // c.a.a1.t.j.a
        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.a.f19334f == null) {
                return;
            }
            this.a.f19334f.D(i2);
        }

        @Override // c.a.a1.t.j.a
        public void onRecordEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f19339e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f19340f;

            public a(d dVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19340f = dVar;
                this.f19339e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j.j(this.f19339e, this.f19340f.a.m);
                }
            }
        }

        public d(b bVar) {
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

        @Override // c.a.a1.p.b.d
        public void onBeautyEnableChanged(c.a.b0.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            }
        }

        @Override // c.a.a1.p.b.d
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.a.f19334f == null || this.a.f19334f.d()) {
            }
        }

        @Override // c.a.a1.p.b.d
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                c.a.d.f.m.e.a().post(new a(this, hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.a.t0.e0.c.a {
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

        @Override // c.a.t0.e0.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.a.f19334f != null) {
                    this.a.f19334f.x(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.t0.e0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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

        @Override // c.a.t0.e0.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.a.f19334f != null) {
                    this.a.f19334f.z(f2);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.a.a1.c {
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

        @Override // c.a.a1.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.t0.n4.m.b(this.a.f19333e.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.t0.k4.c.f19030d : (String) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public c.a.a1.j.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.a1.j.a) invokeV.objValue;
        }

        @Override // c.a.a1.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19341e;

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
            this.f19341e = bVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) && this.f19341e.f19330b) {
                this.f19341e.f19330b = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements b.c {
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

        @Override // c.a.a1.p.b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.f19334f != null && z) {
                this.a.f19334f.g();
            }
        }
    }

    public b(TbPageContext tbPageContext, AspectGLSurfaceView aspectGLSurfaceView, boolean z, a.b bVar, a.InterfaceC1197a interfaceC1197a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aspectGLSurfaceView, Boolean.valueOf(z), bVar, interfaceC1197a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f19330b = true;
        this.f19331c = false;
        this.f19332d = false;
        this.k = new a(this);
        this.l = new C1198b(this);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
        this.p = new f(this);
        this.f19333e = tbPageContext;
        this.f19335g = aspectGLSurfaceView;
        this.f19338j = z;
        this.f19336h = bVar;
        this.f19337i = interfaceC1197a;
        p();
    }

    @Override // c.a.t0.l0.c.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (qmFilterItem == null) {
                this.f19334f.l(null);
                return true;
            } else if (this.f19334f != null) {
                if (!StringUtils.isNull(qmFilterItem.localPath) && !"origin".equals(qmFilterItem.localPath)) {
                    Filter filter = new Filter();
                    filter.setDataType(1);
                    filter.setLevel((c.a.d.f.m.b.d(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f);
                    filter.setFile(new File(qmFilterItem.localPath));
                    this.f19334f.l(filter);
                } else {
                    this.f19334f.l(null);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            if (qmStickerItem == null) {
                this.f19334f.y(null, "");
                return true;
            } else if (this.f19334f != null) {
                if ("nosticker".equals(qmStickerItem.localPath)) {
                    this.f19334f.y(null, "");
                } else {
                    Sticker sticker = new Sticker();
                    sticker.setMaxVersion(qmStickerItem.sdkVersionMax);
                    sticker.setMiniVersion(qmStickerItem.sdkVersionMin);
                    sticker.setFile(new File(qmStickerItem.localPath));
                    this.f19334f.y(sticker, "");
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19332d : invokeV.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.C();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public c.a.t0.e0.c.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : (c.a.t0.e0.c.a) invokeV.objValue;
    }

    @Override // c.a.t0.l0.c.a
    public c.a.t0.e0.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (c.a.t0.e0.b.a) invokeV.objValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean onDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean onPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean onResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.f19331c) {
                q();
                this.f19331c = true;
                return true;
            }
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (c.a.t0.j4.a.a() && this.f19335g != null) {
                r();
                this.f19335g.initDefault(2, 0);
                return true;
            }
            this.f19333e.getPageActivity().finish();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.a1.p.b bVar = new c.a.a1.p.b(this.f19333e.getPageActivity());
            this.f19334f = bVar;
            bVar.k(this.k);
            this.f19334f.m(this.f19335g);
            this.f19334f.r(this.l);
            this.f19334f.q(this.n);
            int i2 = 720;
            int i3 = 1280;
            if (this.a == 1) {
                i2 = 1280;
                i3 = 720;
            }
            this.f19334f.i(i2, i3);
            c.a.t0.n4.k.a.e D = c.a.t0.n4.k.a.e.D(this.f19333e);
            D.h(true);
            D.m(true);
            D.j(true);
            D.u(this.f19333e.getPageActivity().getWindowManager().getDefaultDisplay().getRotation());
            this.f19334f.c(D, 30, 5000000, this.f19338j, FileHelper.getVideoTmpDir());
            this.f19334f.t(false);
            this.f19334f.w(true);
            this.f19334f.v(true);
            this.f19334f.s(false);
            this.f19334f.u(false);
            this.f19334f.p(new h(this));
            this.f19334f.e(new i(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.a1.b.c().h(TbadkCoreApplication.getInst());
            c.a.a1.b.c().j(FileHelper.getCacheDir());
            c.a.a1.b.c().k(new g(this));
        }
    }

    @Override // c.a.t0.l0.c.a
    public boolean startRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.l0.c.a
    public boolean stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.a1.p.b bVar = this.f19334f;
            if (bVar != null) {
                bVar.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
