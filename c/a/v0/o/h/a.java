package c.a.v0.o.h;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.r.u;
import c.a.z.a.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor;
import com.baidu.ugc.utils.SafeConcurrentHashMap;
import com.faceunity.gles.GeneratedTexture;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a extends BaseEffectProcessor implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static a.l K = null;
    public static String L = "500001";
    public static float M = 0.35f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean A;
    public boolean B;
    public float[] C;
    public ICallbackWith<ICaptureResult> D;
    public boolean E;
    public ARRenderFpsCallback F;
    public boolean G;
    public int H;
    public volatile int I;
    public float[] J;
    public c.a.z.a.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.z.a.f.a f21822b;

    /* renamed from: c  reason: collision with root package name */
    public Context f21823c;

    /* renamed from: d  reason: collision with root package name */
    public int f21824d;

    /* renamed from: e  reason: collision with root package name */
    public Sticker f21825e;

    /* renamed from: f  reason: collision with root package name */
    public Filter f21826f;

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<BeautyType, Object> f21827g;

    /* renamed from: h  reason: collision with root package name */
    public int f21828h;
    public int i;
    public c.a.v0.f.b.a j;
    public int k;
    public int[] l;
    public SurfaceTexture m;
    public int n;
    public SurfaceTexture o;
    public SurfaceTexture.OnFrameAvailableListener p;
    public FullFrameRect q;
    public l r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public DuMixCallback x;
    public boolean y;
    public boolean z;

    /* renamed from: c.a.v0.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1613a implements DefinedLuaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1613a(a aVar) {
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

        @Override // com.baidu.ar.DefinedLuaListener
        public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, hashMap) == null) {
            }
        }

        @Override // com.baidu.ar.DefinedLuaListener
        public void onRequireSwitchCamera(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.r == null) {
                return;
            }
            this.a.r.f(i);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LuaMsgListener {
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

        @Override // com.baidu.ar.lua.LuaMsgListener
        public List<String> getMsgKeyListened() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("event_name");
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.ar.lua.LuaMsgListener
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onLuaMessage(hashMap);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.z.a.a.l
        public void onHolderChanged(a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements FilterStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.v0.o.h.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1614a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public RunnableC1614a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.r.onBeautyEnableChanged(this.a.a.f21822b);
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

        @Override // com.baidu.ar.filter.FilterStateListener
        public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, str) == null) {
                Boolean bool4 = null;
                if (hashMap != null) {
                    bool4 = hashMap.get(FilterNode.makeupFilter);
                    bool2 = hashMap.get(FilterNode.lutFilter);
                    bool3 = hashMap.get(FilterNode.skinFilter);
                    bool = hashMap.get(FilterNode.faceFilter);
                } else {
                    bool = null;
                    bool2 = null;
                    bool3 = null;
                }
                boolean z = false;
                this.a.f21822b.d(bool4 == null || bool4.booleanValue());
                this.a.f21822b.c(bool2 == null || bool2.booleanValue());
                this.a.f21822b.a(bool3 == null || bool3.booleanValue());
                this.a.f21822b.b((bool == null || bool.booleanValue()) ? true : true);
                if (this.a.r != null) {
                    u.a().post(new RunnableC1614a(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.v0.o.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1615a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public RunnableC1615a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.h0();
                }
            }
        }

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

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.x != null) {
                    this.a.x.onRelease();
                }
                this.a.u = false;
                this.a.o = new SurfaceTexture(0);
                this.a.o.detachFromGLContext();
                if (this.a.r == null || this.a.o == null) {
                    return;
                }
                this.a.r.b(this.a.o);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
                this.a.u = z;
                if (this.a.x != null) {
                    this.a.x.onSetup(z, duMixInput, duMixOutput);
                }
                this.a.v = false;
                if (!z) {
                    a aVar = this.a;
                    aVar.h(1571, "onSetup返回失败：" + z);
                }
                ThreadPool.a().e(new RunnableC1615a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r.onBeautyEnableChanged(this.a.f21822b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public g(a aVar, int i) {
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
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.r.k.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ICallbackWith<ICaptureResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.callback.ICallbackWith
        /* renamed from: a */
        public void run(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) && iCaptureResult != null && this.a.z) {
                this.a.y = false;
                if (this.a.r != null) {
                    this.a.r.a(iCaptureResult);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ICaptureAbilityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
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

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y = false;
                this.a.z = false;
                if (this.a.a != null) {
                    this.a.a.T0(null);
                }
            }
        }

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.y = true;
                this.a.z = false;
                if (this.a.a != null) {
                    this.a.a.T0(this.a.D);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements FaceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public j(a aVar) {
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

        @Override // com.baidu.ar.face.FaceListener
        public void onFaceResult(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.v && obj != null && (obj instanceof FaceResultData)) {
                FaceResultData faceResultData = (FaceResultData) obj;
                int[] faceIds = faceResultData.getFaceIds();
                if (faceIds != null) {
                    this.a.H = faceIds.length;
                }
                boolean z = this.a.f21824d == 1;
                float[] faceBoxes = faceResultData.getFaceBoxes();
                if (faceBoxes != null && faceBoxes.length <= 4 && faceIds != null) {
                    a aVar = this.a;
                    float[] v = aVar.v(aVar.f21828h, this.a.i, z, faceBoxes[0], faceBoxes[1], faceBoxes[2], faceBoxes[3]);
                    int i = (int) (v[0] - v[2]);
                    int i2 = (int) (v[1] - v[3]);
                    int i3 = ((int) (v[0] + v[2])) / 2;
                    int i4 = ((int) (v[1] + v[3])) / 2;
                    if (this.a.r != null) {
                        this.a.r.e(i, i2, i3, i4);
                    }
                }
                this.a.k(faceResultData);
                float[] genders = faceResultData.getGenders();
                if (genders == null) {
                    return;
                }
                this.a.G = genders[0] > 0.8f;
                if (this.a.r != null) {
                    this.a.r.onChangeGender(this.a.G);
                }
                if (faceIds == null) {
                }
            }
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onStickerLoadingFinished(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onTriggerFired(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DuMixStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public k(a aVar) {
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

        @Override // com.baidu.ar.DuMixStateListener
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(ICaptureResult iCaptureResult);

        void b(SurfaceTexture surfaceTexture);

        void c();

        void d(int i);

        void e(int i, int i2, int i3, int i4);

        void f(int i);

        void onBeautyEnableChanged(c.a.z.a.f.a aVar);

        void onChangeGender(boolean z);

        void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture);

        void onLuaMessage(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes3.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f21829b;

        public m(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f21829b = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21829b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1081930032, "Lc/a/v0/o/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1081930032, "Lc/a/v0/o/h/a;");
                return;
            }
        }
        K = new c();
    }

    public a(Context context, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onFrameAvailableListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21822b = new c.a.z.a.f.a();
        this.f21824d = 1;
        this.f21827g = new SafeConcurrentHashMap();
        new SafeConcurrentHashMap();
        this.l = new int[1];
        this.s = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.t = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.w = true;
        this.A = false;
        this.G = false;
        this.H = 0;
        this.J = new float[16];
        this.f21823c = context;
        this.p = onFrameAvailableListener;
        this.m = new SurfaceTexture(0);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        this.o = surfaceTexture;
        surfaceTexture.detachFromGLContext();
    }

    public static float[] u(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            float f4 = (i6 == 90 || i6 == 270) ? (i3 * 1.0f) / i4 : (i3 * 1.0f) / i5;
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.translateM(fArr, 0, i2 / 2.0f, i3 / 2.0f, 1.0f);
            Matrix.rotateM(fArr, 0, i6 % 360, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr, 0, Math.round(f2 * f4) / 2.0f, Math.round(f4 * f3) / 2.0f, 1.0f);
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21822b.d(i2 == 1);
            if (this.r != null) {
                u.a().post(new f(this));
            }
        }
    }

    public void B(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (c.a.v0.r.c.a) {
                c.a.v0.r.c.c("DuAr_ARProcessor", "initSourceSize[" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + PreferencesUtil.RIGHT_MOUNT);
            }
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            this.s = i3;
            this.t = i2;
        }
    }

    public void C(BeautyType beautyType, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, beautyType, f2) == null) {
            this.f21827g.put(beautyType, Float.valueOf(f2));
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public void D(String str) {
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.b1(str);
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.A = z;
            if (f0() && this.a != null && this.A) {
                this.a.K0();
            }
        }
    }

    public boolean F(Sticker sticker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sticker)) == null) {
            int i2 = !sticker.isSupport(c.a.z.a.a.a0()) ? R.string.obfuscated_res_0x7f0f11d9 : 0;
            if (TextUtils.isEmpty(sticker.getPath()) || !new File(sticker.getPath()).exists()) {
                i2 = R.string.obfuscated_res_0x7f0f11ce;
            }
            if (!c.a.z.a.a.k1(sticker.getPath())) {
                i2 = R.string.obfuscated_res_0x7f0f11cf;
            }
            if (i2 != 0) {
                u.a().post(new g(this, i2));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int H(FaceResultData faceResultData) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, faceResultData)) == null) {
            if (faceResultData != null && faceResultData.isTracked()) {
                if (faceResultData.getFaceCount() > 1) {
                    return 6;
                }
                float[] normalizedFaceBoxes = faceResultData.getNormalizedFaceBoxes();
                if (normalizedFaceBoxes != null && this.C != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < normalizedFaceBoxes.length && (i3 = i4 + 3) < normalizedFaceBoxes.length; i4 += 4) {
                        int i5 = i4 + 1;
                        arrayList.add(new float[]{normalizedFaceBoxes[i4], normalizedFaceBoxes[i5] + normalizedFaceBoxes[i3], normalizedFaceBoxes[i4] + normalizedFaceBoxes[i4 + 2], normalizedFaceBoxes[i5]});
                    }
                    while (i2 < arrayList.size()) {
                        float f2 = ((float[]) arrayList.get(i2))[0];
                        float f3 = ((float[]) arrayList.get(i2))[3];
                        float f4 = ((float[]) arrayList.get(i2))[2];
                        float f5 = ((float[]) arrayList.get(i2))[1];
                        float f6 = (f2 + f4) / 2.0f;
                        float[] fArr = this.C;
                        if (f6 >= fArr[0] && f6 <= fArr[2]) {
                            float f7 = (f3 + f5) / 2.0f;
                            i2 = (f7 >= fArr[1] && f7 <= fArr[3]) ? i2 + 1 : 0;
                        }
                        float[] fArr2 = this.C;
                        return (f4 < fArr2[0] || f2 > fArr2[2] || f5 < fArr2[1] || f3 > fArr2[3]) ? 1 : 4;
                    }
                }
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void I(Sticker sticker) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sticker) == null) && f0()) {
            if (sticker == null) {
                this.a.O();
            } else if (F(sticker)) {
                Sticker.AbilityModel abilityModel = sticker.getAbilityModel();
                if (abilityModel != null) {
                    this.a.d1(abilityModel.getPath());
                }
                int arType = sticker.getArType();
                this.a.j0(ARType.valueOf(arType), sticker.getPath(), sticker.getId());
            }
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.w = z;
        }
    }

    public void P(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            BeautyType beautyType = BeautyType.lutIntensity;
            Object obj = this.f21827g.get(beautyType);
            if ((obj instanceof Float) && ((Float) obj).floatValue() == f2) {
                return;
            }
            this.f21827g.put(beautyType, Float.valueOf(f2));
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public final void T(boolean z) {
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.u && (aVar = this.a) != null) {
            if (z) {
                aVar.i1();
            } else {
                aVar.j1();
            }
        }
    }

    public Sticker W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21825e : (Sticker) invokeV.objValue;
    }

    public Sticker X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (c.a.z.a.b.g() != null) {
                c.a.z.a.b.g();
                return c.a.z.a.c.f();
            }
            return null;
        }
        return (Sticker) invokeV.objValue;
    }

    public Filter a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21826f : (Filter) invokeV.objValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.z = false;
        }
    }

    public final File d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, file)) == null) {
            if (file == null) {
                return null;
            }
            if (file.isFile()) {
                return file;
            }
            File[] listFiles = file.listFiles();
            for (int i2 = 0; listFiles != null && i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (name.substring(name.lastIndexOf(".") + 1).toLowerCase().equals("png")) {
                    return listFiles[i2];
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            GLES20.glDeleteFramebuffers(1, this.l, 0);
            GLES20.glDeleteTextures(1, new int[]{this.k}, 0);
            this.k = 0;
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.y = true;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.f21824d == i2) {
            return;
        }
        this.f21824d = i2;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u && c.a.z.a.a.M(this.a, K) : invokeV.booleanValue;
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        if (i2 == this.mPreviewWidth && i3 == this.mPreviewHeight) {
            return;
        }
        this.mPreviewWidth = i2;
        this.mPreviewHeight = i3;
        onARDrawerCreated(this.m, this, i2, i3);
    }

    public SurfaceTexture g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.o : (SurfaceTexture) invokeV.objValue;
    }

    public final void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.E) {
                I(X());
                return;
            }
            i0();
            I(W());
            n(a0());
            o0();
            k0();
        }
    }

    public void i(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, duMixCallback) == null) {
            this.x = duMixCallback;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && f0()) {
            if (c.a.z.a.b.g() != null) {
                c.a.z.a.b.g();
                D(c.a.z.a.c.d(true));
            }
            j0();
            E(this.A);
        }
    }

    public void j(ARRenderFpsCallback aRRenderFpsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aRRenderFpsCallback) == null) {
            this.F = aRRenderFpsCallback;
        }
    }

    public final void j0() {
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.f1(c.a.z.a.b.f());
    }

    public void k(FaceResultData faceResultData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, faceResultData) == null) {
            if (!this.y || faceResultData == null) {
                l lVar = this.r;
                if (lVar != null) {
                    lVar.d(5);
                    return;
                }
                return;
            }
            int H = this.B ? H(faceResultData) : x(faceResultData);
            l lVar2 = this.r;
            if (lVar2 != null) {
                lVar2.d(H);
            }
            if (this.B) {
                return;
            }
            if (H == 0) {
                this.z = true;
                str = "capture_timer_start";
            } else {
                this.z = false;
                str = "capture_timer_clear";
            }
            r(c.a.v0.r.j.d(str));
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            D(m0());
            l(BeautyType.blackEyeCircle, 1);
            m(BeautyType.blackEyeCircle, m0());
            C(BeautyType.blackEyeCircle, 0.5f);
            D(n0());
            l(BeautyType.laughLine, 1);
            m(BeautyType.laughLine, n0());
            C(BeautyType.laughLine, 0.6f);
        }
    }

    public void l(BeautyType beautyType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, beautyType, i2) == null) {
            this.f21827g.put(beautyType, Integer.valueOf(i2));
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.M0(beautyType, i2);
            }
        }
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            String e2 = c.a.z.a.b.g() != null ? c.a.z.a.c.e() : null;
            if (TextUtils.isEmpty(e2) || e2.charAt(e2.length() - 1) == File.separatorChar) {
                return e2;
            }
            return e2 + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public void m(BeautyType beautyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, beautyType, str) == null) {
            this.f21827g.put(beautyType, str);
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.P0(beautyType, str);
            }
        }
    }

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return l0() + "blackeyecircle/open";
        }
        return (String) invokeV.objValue;
    }

    public void n(Filter filter) {
        String str;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, filter) == null) {
            this.f21826f = filter;
            if (filter == null && !this.w) {
                f2 = 0.0f;
                str = null;
            } else if (filter == null || L.equals(filter.getParam())) {
                if (c.a.z.a.b.g() != null) {
                    c.a.z.a.b.g();
                    str = c.a.z.a.c.c();
                } else {
                    str = null;
                }
                f2 = M;
            } else {
                File d2 = d(filter.getFile());
                str = d2 != null ? d2.getAbsolutePath() : null;
                f2 = filter.getLevel();
            }
            Object obj = this.f21827g.get(BeautyType.lutFile);
            String str2 = obj instanceof String ? (String) obj : null;
            if (str != null && !str.equals(str2)) {
                this.f21827g.put(BeautyType.lutFile, str);
                c.a.z.a.a aVar = this.a;
                if (aVar != null && str != null) {
                    aVar.P0(BeautyType.lutFile, str);
                }
            }
            P(f2);
        }
    }

    public final String n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return l0() + "laughline/open";
        }
        return (String) invokeV.objValue;
    }

    public void o(Sticker sticker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sticker) == null) {
            this.f21825e = sticker;
            I(sticker);
        }
    }

    public final void o0() {
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.R0(this.f21827g);
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048614, this, surfaceTexture, i2, i3) == null) {
        }
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048615, this, surfaceTexture, onFrameAvailableListener, i2, i3) == null) {
            if (i2 == 0 || i3 == 0) {
                i2 = this.f21828h;
                i3 = this.i;
            }
            int i4 = i2;
            int i5 = i3;
            c.a.z.a.a aVar = this.a;
            if (aVar == null) {
                c.a.v0.r.c.c("DuAr_ARProcessor", "onARDrawerCreated Effect == null");
                return;
            }
            aVar.V0(new C1613a(this));
            this.a.L(new b(this));
            this.a.t0(surfaceTexture, onFrameAvailableListener, i4, i5, p0(), q0());
            this.a.a1(new d(this));
        }
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, surfaceTexture, i2, i3) == null) {
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.v0(surfaceTexture, i2, i3);
            } else {
                c.a.v0.r.c.c("DuAr_ARProcessor", "onCameraDrawerCreated Effect == null");
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.u = false;
            SurfaceTexture surfaceTexture = this.m;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.m = null;
            }
            c.a.z.a.a aVar = this.a;
            if (aVar != null) {
                aVar.B0();
                this.a = null;
            }
            FullFrameRect fullFrameRect = this.q;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
            }
            if (this.B) {
                T(false);
            }
            super.onDestroy();
            this.f21823c = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, surfaceTexture) == null) {
            if (!this.v) {
                this.v = true;
                c.a.v0.f.b.a aVar = this.j;
                if (aVar != null) {
                    aVar.c();
                }
            }
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.p;
            if (onFrameAvailableListener != null) {
                onFrameAvailableListener.onFrameAvailable(surfaceTexture);
            }
            c.a.v0.f.b.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            c.a.v0.f.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
            super.onPause();
            c.a.z.a.a aVar2 = this.a;
            if (aVar2 != null) {
                aVar2.y0();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(c.a.z.b.a.e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048620, this, eVar, i2, fArr)) == null) {
            SurfaceTexture surfaceTexture = this.m;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.m.getTransformMatrix(fArr);
            }
            if (this.k == 0) {
                this.k = this.q.createTexture2DObject();
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.f21828h, this.i, 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.l, 0);
            }
            GLES20.glBindFramebuffer(36160, this.l[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.k, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.f21828h, this.i);
            float[] fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
            if ((this.mPreviewWidth != 0 || this.mPreviewHeight != 0) && (this.I == 90 || this.I == 270)) {
                Matrix.multiplyMM(fArr2, 0, this.J, 0, u(this.f21828h, this.i, this.mPreviewWidth, this.mPreviewHeight, this.I), 0);
            }
            this.q.setVertexPoint(fArr2);
            this.q.drawFrame(this.n, GlUtil.IDENTITY_MATRIX);
            Matrix.setIdentityM(fArr2, 0);
            this.q.setVertexPoint(fArr2);
            GLES20.glBindFramebuffer(36160, 0);
            return this.k;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onResume();
            if (c.a.z.a.a.M(this.a, K)) {
                this.a.F0();
                return;
            }
            l lVar = this.r;
            if (lVar != null) {
                lVar.c();
            }
            this.a = c.a.z.a.a.V(this.f21823c, K, c.a.z.a.b.b());
            E(this.A);
            this.D = new h(this);
            this.a.S0(new i(this));
            this.a.X0(new j(this));
            this.a.W0(new k(this));
            SurfaceTexture surfaceTexture = this.o;
            if (surfaceTexture != null && this.m != null) {
                onCameraDrawerCreated(surfaceTexture, this.s, this.t);
                int i3 = this.mPreviewWidth;
                if (i3 != 0 && (i2 = this.mPreviewHeight) != 0) {
                    onARDrawerCreated(this.m, this, i3, i2);
                }
            }
            ARRenderFpsCallback aRRenderFpsCallback = this.F;
            if (aRRenderFpsCallback != null) {
                this.a.J0(aRRenderFpsCallback);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, fullFrameRect, fullFrameRect2) == null) {
            this.q = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR));
        }
    }

    public void p(l lVar) {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, lVar) == null) {
            this.r = lVar;
            if (lVar == null || (surfaceTexture = this.o) == null) {
                return;
            }
            lVar.b(surfaceTexture);
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? 1 == this.f21824d : invokeV.booleanValue;
    }

    public final DuMixCallback q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? new e(this) : (DuMixCallback) invokeV.objValue;
    }

    public void r(HashMap<String, Object> hashMap) {
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, hashMap) == null) || (aVar = this.a) == null || hashMap == null) {
            return;
        }
        aVar.I0(hashMap);
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            e();
        }
    }

    public boolean s(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        c.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048629, this, view, motionEvent)) == null) {
            Sticker W = W();
            return (W != null && W.isTouchAble()) && (aVar = this.a) != null && aVar.x0(view, motionEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048630, this, i2, i3) == null) {
            if (this.f21828h != i2 || this.i != i3) {
                e();
                Matrix.orthoM(this.J, 0, 0.0f, i2, 0.0f, i3, -1.0f, 1.0f);
            }
            this.f21828h = i2;
            this.i = i3;
            onARDrawerChanged(this.m, i2, i3);
        }
    }

    public final float[] v(int i2, int i3, boolean z, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            m mVar = new m(i2, i3);
            m mVar2 = new m(180, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            PointF pointF = new PointF(f2, f3);
            float b2 = mVar.b() / mVar2.b();
            float a = mVar.a() / mVar2.a();
            float f6 = pointF.x;
            float f7 = pointF.y;
            return new float[]{(f4 + f6) * a, (f5 + f7) * b2, f6 * a, f7 * b2};
        }
        return (float[]) invokeCommon.objValue;
    }

    public final int x(FaceResultData faceResultData) {
        InterceptResult invokeL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, faceResultData)) == null) {
            if (faceResultData == null) {
                return 5;
            }
            boolean z2 = true;
            if (faceResultData.isTracked()) {
                float[] normalizedFaceBoxes = faceResultData.getNormalizedFaceBoxes();
                if (normalizedFaceBoxes != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < normalizedFaceBoxes.length && (i2 = i3 + 3) < normalizedFaceBoxes.length; i3 += 4) {
                        int i4 = i3 + 1;
                        arrayList.add(new float[]{normalizedFaceBoxes[i3], normalizedFaceBoxes[i4] + normalizedFaceBoxes[i2], normalizedFaceBoxes[i3] + normalizedFaceBoxes[i3 + 2], normalizedFaceBoxes[i4]});
                    }
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        float f2 = ((float[]) arrayList.get(i5))[0];
                        float f3 = ((float[]) arrayList.get(i5))[1];
                        float f4 = ((float[]) arrayList.get(i5))[2];
                        float f5 = ((float[]) arrayList.get(i5))[3];
                        if (f2 < 0.0f || f4 > 1.0f || f3 > 0.75f || f5 < 0.1f) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    return 4;
                }
                List<float[]> headPoses = faceResultData.getHeadPoses();
                if (headPoses != null) {
                    for (float[] fArr : headPoses) {
                        if (fArr.length < 3) {
                            break;
                        }
                        float f6 = fArr[0];
                        float f7 = fArr[1];
                        float f8 = fArr[2];
                        if (Math.abs(f6) > 20.0f) {
                            break;
                        } else if (Math.abs(f7) > 30.0f) {
                            break;
                        }
                    }
                }
                z2 = false;
                return z2 ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            int i2 = 1;
            r(c.a.v0.r.j.c((this.H == 1 && this.G) ? 0 : 0));
        }
    }
}
