package c.a.r0.x.c;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.x.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes4.dex */
public class b implements c.a.r0.x.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28268a;

    /* renamed from: b  reason: collision with root package name */
    public int f28269b;

    /* renamed from: c  reason: collision with root package name */
    public int f28270c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f28271d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f28272e;

    /* renamed from: f  reason: collision with root package name */
    public Context f28273f;

    /* renamed from: g  reason: collision with root package name */
    public Camera f28274g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Parameters f28275h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.x.c.e f28276i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f28277j;
    public f k;
    public View l;
    public int m;
    public d.a n;
    public int o;
    public Camera.Size p;
    public int q;
    public SurfaceTexture r;
    public byte[] s;
    public Camera.PreviewCallback t;
    public TextureView.SurfaceTextureListener u;
    public Comparator<Camera.Size> v;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b f28278e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f28279f;

        /* renamed from: c.a.r0.x.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1331a implements Camera.PictureCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f28280a;

            public C1331a(a aVar) {
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
                this.f28280a = aVar;
            }

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                    this.f28280a.f28279f.J(false);
                    this.f28280a.f28279f.f28271d.set(false);
                    d.b bVar = this.f28280a.f28278e;
                    if (bVar != null) {
                        bVar.a(bArr);
                    }
                }
            }
        }

        public a(b bVar, d.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28279f = bVar;
            this.f28278e = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f28279f.f28274g.takePicture(null, null, new C1331a(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f28279f.J(false);
                    this.f28279f.f28271d.set(false);
                }
            }
        }
    }

    /* renamed from: c.a.r0.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1332b implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28281e;

        /* renamed from: c.a.r0.x.c.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f28282e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1332b f28283f;

            public a(C1332b c1332b, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1332b, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28283f = c1332b;
                this.f28282e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28283f.f28281e.D(this.f28282e);
                }
            }
        }

        public C1332b(b bVar) {
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
            this.f28281e = bVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) && !this.f28281e.f28272e.get() && b.s(this.f28281e) % 5 == 0 && bArr.length == this.f28281e.f28275h.getPreviewSize().width * this.f28281e.f28275h.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(this.f28281e.s);
                c.a.r0.x.c.c.c(new a(this, bArr));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28284e;

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
            this.f28284e = bVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) {
                this.f28284e.r = surfaceTexture;
                this.f28284e.C();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
                b bVar = this.f28284e;
                bVar.E(bVar.k.getWidth(), this.f28284e.k.getHeight());
                this.f28284e.J(false);
                this.f28284e.G();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) {
                this.f28284e.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28285e;

        /* loaded from: classes4.dex */
        public class a implements Camera.AutoFocusCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) {
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
            this.f28285e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f28285e) {
                    if (this.f28285e.f28274g != null && !this.f28285e.f28271d.get()) {
                        try {
                            this.f28285e.f28274g.autoFocus(new a(this));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) ? Long.signum((size.width * size.height) - (size2.width * size2.height)) : invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextureView f28286e;

        /* renamed from: f  reason: collision with root package name */
        public float f28287f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f28288g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28288g = bVar;
            this.f28287f = 0.75f;
        }

        public final void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i2 < i3) {
                    i3 = (int) (i2 * this.f28287f);
                } else {
                    i2 = (int) (i3 * this.f28287f);
                }
                int width = (getWidth() - i2) / 2;
                int height = (getHeight() - i3) / 2;
                this.f28288g.f28277j.left = width;
                this.f28288g.f28277j.top = height;
                this.f28288g.f28277j.right = width + i2;
                this.f28288g.f28277j.bottom = height + i3;
            }
        }

        public void e(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f28287f = f2;
                requestLayout();
                d(getWidth(), getHeight());
            }
        }

        public void f(TextureView textureView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textureView) == null) {
                this.f28286e = textureView;
                removeAllViews();
                addView(textureView);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                this.f28286e.layout(this.f28288g.f28277j.left, this.f28288g.f28277j.top, this.f28288g.f28277j.right, this.f28288g.f28277j.bottom);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
                super.onSizeChanged(i2, i3, i4, i5);
                d(i2, i3);
            }
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28268a = 0;
        this.f28269b = 0;
        this.f28271d = new AtomicBoolean(false);
        this.f28272e = new AtomicBoolean(false);
        this.f28277j = new Rect();
        this.m = 0;
        this.o = 0;
        this.q = 0;
        this.s = null;
        this.t = new C1332b(this);
        this.u = new c(this);
        this.v = new e(this);
        this.f28273f = context;
        this.k = new f(this, context);
        F();
    }

    public static /* synthetic */ int s(b bVar) {
        int i2 = bVar.o;
        bVar.o = i2 + 1;
        return i2;
    }

    public final Camera.Size A(List<Camera.Size> list) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            int width = this.k.f28286e.getWidth();
            int height = this.k.f28286e.getHeight();
            float f2 = this.k.f28287f;
            Camera.Size size = list.get(0);
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size2 : list) {
                int i4 = size2.width;
                if (i4 >= width && (i3 = size2.height) >= height && i4 * height == i3 * width) {
                    arrayList.add(size2);
                } else {
                    int i5 = size2.height;
                    if (i5 >= width && (i2 = size2.width) >= height && i2 * width == i5 * height) {
                        arrayList.add(size2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return (Camera.Size) Collections.min(arrayList, this.v);
            }
            float f3 = f2;
            for (Camera.Size size3 : list) {
                if (size3 != null) {
                    float abs = Math.abs(f2 - ((size3.width * 1.0f) / size3.height));
                    if (abs < f3) {
                        size = size3;
                        f3 = abs;
                    }
                }
            }
            return size;
        }
        return (Camera.Size) invokeL.objValue;
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f28268a;
            if (i2 != 90) {
                return i2 != 270 ? 90 : 180;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f28274g == null) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                        Camera.getCameraInfo(i2, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            this.f28269b = i2;
                        }
                    }
                    this.f28274g = Camera.open(this.f28269b);
                }
                if (this.f28275h == null) {
                    Camera.Parameters parameters = this.f28274g.getParameters();
                    this.f28275h = parameters;
                    parameters.setPreviewFormat(17);
                }
                E(this.k.getWidth(), this.k.getHeight());
                this.f28274g.setPreviewTexture(this.r);
                G();
                J(false);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0068 -> B:37:0x006b). Please submit an issue!!! */
    public final void D(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || this.f28274g == null || bArr == null || this.p == null) {
            return;
        }
        Camera.Size size = this.p;
        YuvImage yuvImage = new YuvImage(bArr, 17, size.width, size.height, null);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.p.width, this.p.height), 80, byteArrayOutputStream);
                if (this.n.a(byteArrayOutputStream.toByteArray(), z()) == 0) {
                    y();
                }
                byteArrayOutputStream.close();
            } catch (OutOfMemoryError unused) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (OutOfMemoryError unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void E(int i2, int i3) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f28275h == null || (camera = this.f28274g) == null || i2 <= 0) {
            return;
        }
        try {
            Camera.Size A = A(camera.getParameters().getSupportedPreviewSizes());
            this.p = A;
            this.f28275h.setPreviewSize(A.width, A.height);
            this.k.e((this.p.width * 1.0f) / this.p.height);
            this.f28274g.setDisplayOrientation(B());
            K();
            this.f28274g.setParameters(this.f28275h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            H();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.s == null) {
                this.s = new byte[((this.l.getWidth() * this.l.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
            }
            Camera camera = this.f28274g;
            if (camera == null || this.q != 1) {
                return;
            }
            camera.addCallbackBuffer(this.s);
            this.f28274g.setPreviewCallback(this.t);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextureView textureView = new TextureView(this.f28273f);
            this.k.f28286e = textureView;
            this.k.f(textureView);
            this.l = this.k;
            textureView.setSurfaceTextureListener(this.u);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.x.c.c.b(new d(this));
        }
    }

    public final void J(boolean z) {
        c.a.r0.x.c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (ContextCompat.checkSelfPermission(this.f28273f, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                if (!z || (eVar = this.f28276i) == null) {
                    return;
                }
                eVar.a();
                return;
            }
            Camera camera = this.f28274g;
            if (camera == null) {
                C();
                return;
            }
            camera.startPreview();
            I();
        }
    }

    public final void K() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (camera = this.f28274g) == null) {
            return;
        }
        camera.stopPreview();
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 0) {
                this.f28275h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i2 == 1) {
                this.f28275h.setFlashMode("torch");
            } else if (i2 != 2) {
                this.f28275h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            } else {
                this.f28275h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.f28274g.setParameters(this.f28275h);
        }
    }

    @Override // c.a.r0.x.c.d
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.r0.x.c.d
    public void b(d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || this.f28271d.get()) {
            return;
        }
        int i2 = this.f28268a;
        if (i2 == 0) {
            this.f28275h.setRotation(90);
        } else if (i2 == 90) {
            this.f28275h.setRotation(0);
        } else if (i2 == 270) {
            this.f28275h.setRotation(180);
        }
        try {
            Camera.Size A = A(this.f28274g.getParameters().getSupportedPictureSizes());
            this.f28275h.setPictureSize(A.width, A.height);
            this.f28274g.setParameters(this.f28275h);
            this.f28271d.set(true);
            x();
            c.a.r0.x.c.c.c(new a(this, bVar));
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            J(false);
            this.f28271d.set(false);
        }
    }

    @Override // c.a.r0.x.c.d
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f28268a = i2;
            if (i2 == 0) {
                this.m = 90;
            } else if (i2 == 90) {
                this.m = 0;
            } else if (i2 != 270) {
                this.m = 0;
            } else {
                this.m = 180;
            }
            this.k.requestLayout();
        }
    }

    @Override // c.a.r0.x.c.d
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f28270c : invokeV.intValue;
    }

    @Override // c.a.r0.x.c.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f28271d.set(false);
        }
    }

    @Override // c.a.r0.x.c.d
    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f28277j : (Rect) invokeV.objValue;
    }

    @Override // c.a.r0.x.c.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            J(true);
        }
    }

    @Override // c.a.r0.x.c.d
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f28270c == i2) {
            return;
        }
        this.f28270c = i2;
        L(i2);
    }

    @Override // c.a.r0.x.c.d
    public void i(c.a.r0.x.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f28276i = eVar;
        }
    }

    @Override // c.a.r0.x.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f28274g != null) {
                K();
            }
            h(0);
        }
    }

    @Override // c.a.r0.x.c.d
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f28271d.set(false);
            if (this.f28274g != null) {
                this.k.f28286e.setSurfaceTextureListener(this.u);
                if (this.k.f28286e.isAvailable()) {
                    J(false);
                    return;
                }
                return;
            }
            F();
        }
    }

    @Override // c.a.r0.x.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            J(false);
        }
    }

    @Override // c.a.r0.x.c.d
    public void stop() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (camera = this.f28274g) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        K();
        Camera camera2 = this.f28274g;
        this.f28274g = null;
        camera2.release();
        this.f28274g = null;
        this.s = null;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f28274g.cancelAutoFocus();
            c.a.r0.x.c.c.a();
        }
    }

    public final void y() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (camera = this.f28274g) != null && this.q == 1) {
            camera.setPreviewCallback(null);
            K();
        }
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.m : invokeV.intValue;
    }
}
