package c.a.p0.e0.c;

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
import c.a.p0.e0.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes2.dex */
public class b implements c.a.p0.e0.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13744b;

    /* renamed from: c  reason: collision with root package name */
    public int f13745c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f13746d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f13747e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13748f;

    /* renamed from: g  reason: collision with root package name */
    public Camera f13749g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Parameters f13750h;
    public c.a.p0.e0.c.e i;
    public Rect j;
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f13751b;

        /* renamed from: c.a.p0.e0.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1035a implements Camera.PictureCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1035a(a aVar) {
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

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                    this.a.f13751b.J(false);
                    this.a.f13751b.f13746d.set(false);
                    d.b bVar = this.a.a;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13751b = bVar;
            this.a = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f13751b.f13749g.takePicture(null, null, new C1035a(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f13751b.J(false);
                    this.f13751b.f13746d.set(false);
                }
            }
        }
    }

    /* renamed from: c.a.p0.e0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1036b implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.p0.e0.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ byte[] a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C1036b f13752b;

            public a(C1036b c1036b, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1036b, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13752b = c1036b;
                this.a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f13752b.a.D(this.a);
                }
            }
        }

        public C1036b(b bVar) {
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

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) && !this.a.f13747e.get() && b.s(this.a) % 5 == 0 && bArr.length == this.a.f13750h.getPreviewSize().width * this.a.f13750h.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(this.a.s);
                c.a.p0.e0.c.c.c(new a(this, bArr));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TextureView.SurfaceTextureListener {
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

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i, i2) == null) {
                this.a.r = surfaceTexture;
                this.a.C();
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
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i, i2) == null) {
                b bVar = this.a;
                bVar.E(bVar.k.getWidth(), this.a.k.getHeight());
                this.a.J(false);
                this.a.G();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) {
                this.a.G();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes2.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a) {
                    if (this.a.f13749g != null && !this.a.f13746d.get()) {
                        try {
                            this.a.f13749g.autoFocus(new a(this));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class f extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextureView a;

        /* renamed from: b  reason: collision with root package name */
        public float f13753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f13754c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13754c = bVar;
            this.f13753b = 0.75f;
        }

        public final void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i < i2) {
                    i2 = (int) (i * this.f13753b);
                } else {
                    i = (int) (i2 * this.f13753b);
                }
                int width = (getWidth() - i) / 2;
                int height = (getHeight() - i2) / 2;
                this.f13754c.j.left = width;
                this.f13754c.j.top = height;
                this.f13754c.j.right = width + i;
                this.f13754c.j.bottom = height + i2;
            }
        }

        public void e(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f13753b = f2;
                requestLayout();
                d(getWidth(), getHeight());
            }
        }

        public void f(TextureView textureView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textureView) == null) {
                this.a = textureView;
                removeAllViews();
                addView(textureView);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                super.onLayout(z, i, i2, i3, i4);
                this.a.layout(this.f13754c.j.left, this.f13754c.j.top, this.f13754c.j.right, this.f13754c.j.bottom);
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
                super.onSizeChanged(i, i2, i3, i4);
                d(i, i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f13744b = 0;
        this.f13746d = new AtomicBoolean(false);
        this.f13747e = new AtomicBoolean(false);
        this.j = new Rect();
        this.m = 0;
        this.o = 0;
        this.q = 0;
        this.s = null;
        this.t = new C1036b(this);
        this.u = new c(this);
        this.v = new e(this);
        this.f13748f = context;
        this.k = new f(this, context);
        F();
    }

    public static /* synthetic */ int s(b bVar) {
        int i = bVar.o;
        bVar.o = i + 1;
        return i;
    }

    public final Camera.Size A(List<Camera.Size> list) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            int width = this.k.a.getWidth();
            int height = this.k.a.getHeight();
            float f2 = this.k.f13753b;
            Camera.Size size = list.get(0);
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size2 : list) {
                int i3 = size2.width;
                if (i3 >= width && (i2 = size2.height) >= height && i3 * height == i2 * width) {
                    arrayList.add(size2);
                } else {
                    int i4 = size2.height;
                    if (i4 >= width && (i = size2.width) >= height && i * width == i4 * height) {
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
            int i = this.a;
            if (i != 90) {
                return i != 270 ? 90 : 180;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f13749g == null) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                        Camera.getCameraInfo(i, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            this.f13744b = i;
                        }
                    }
                    this.f13749g = Camera.open(this.f13744b);
                }
                if (this.f13750h == null) {
                    Camera.Parameters parameters = this.f13749g.getParameters();
                    this.f13750h = parameters;
                    parameters.setPreviewFormat(17);
                }
                E(this.k.getWidth(), this.k.getHeight());
                this.f13749g.setPreviewTexture(this.r);
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || this.f13749g == null || bArr == null || this.p == null) {
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

    public final void E(int i, int i2) {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || this.f13750h == null || (camera = this.f13749g) == null || i <= 0) {
            return;
        }
        try {
            Camera.Size A = A(camera.getParameters().getSupportedPreviewSizes());
            this.p = A;
            this.f13750h.setPreviewSize(A.width, A.height);
            this.k.e((this.p.width * 1.0f) / this.p.height);
            this.f13749g.setDisplayOrientation(B());
            K();
            this.f13749g.setParameters(this.f13750h);
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
            Camera camera = this.f13749g;
            if (camera == null || this.q != 1) {
                return;
            }
            camera.addCallbackBuffer(this.s);
            this.f13749g.setPreviewCallback(this.t);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextureView textureView = new TextureView(this.f13748f);
            this.k.a = textureView;
            this.k.f(textureView);
            this.l = this.k;
            textureView.setSurfaceTextureListener(this.u);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.e0.c.c.b(new d(this));
        }
    }

    public final void J(boolean z) {
        c.a.p0.e0.c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (ContextCompat.checkSelfPermission(this.f13748f, "android.permission.CAMERA") != 0) {
                if (!z || (eVar = this.i) == null) {
                    return;
                }
                eVar.a();
                return;
            }
            Camera camera = this.f13749g;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (camera = this.f13749g) == null) {
            return;
        }
        camera.stopPreview();
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 0) {
                this.f13750h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i == 1) {
                this.f13750h.setFlashMode("torch");
            } else if (i != 2) {
                this.f13750h.setFlashMode("auto");
            } else {
                this.f13750h.setFlashMode("auto");
            }
            this.f13749g.setParameters(this.f13750h);
        }
    }

    @Override // c.a.p0.e0.c.d
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.p0.e0.c.d
    public void b(d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || this.f13746d.get()) {
            return;
        }
        int i = this.a;
        if (i == 0) {
            this.f13750h.setRotation(90);
        } else if (i == 90) {
            this.f13750h.setRotation(0);
        } else if (i == 270) {
            this.f13750h.setRotation(180);
        }
        try {
            Camera.Size A = A(this.f13749g.getParameters().getSupportedPictureSizes());
            this.f13750h.setPictureSize(A.width, A.height);
            this.f13749g.setParameters(this.f13750h);
            this.f13746d.set(true);
            x();
            c.a.p0.e0.c.c.c(new a(this, bVar));
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            J(false);
            this.f13746d.set(false);
        }
    }

    @Override // c.a.p0.e0.c.d
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a = i;
            if (i == 0) {
                this.m = 90;
            } else if (i == 90) {
                this.m = 0;
            } else if (i != 270) {
                this.m = 0;
            } else {
                this.m = 180;
            }
            this.k.requestLayout();
        }
    }

    @Override // c.a.p0.e0.c.d
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f13745c : invokeV.intValue;
    }

    @Override // c.a.p0.e0.c.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f13746d.set(false);
        }
    }

    @Override // c.a.p0.e0.c.d
    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : (Rect) invokeV.objValue;
    }

    @Override // c.a.p0.e0.c.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            J(true);
        }
    }

    @Override // c.a.p0.e0.c.d
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.f13745c == i) {
            return;
        }
        this.f13745c = i;
        L(i);
    }

    @Override // c.a.p0.e0.c.d
    public void i(c.a.p0.e0.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.i = eVar;
        }
    }

    @Override // c.a.p0.e0.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f13749g != null) {
                K();
            }
            h(0);
        }
    }

    @Override // c.a.p0.e0.c.d
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f13746d.set(false);
            if (this.f13749g != null) {
                this.k.a.setSurfaceTextureListener(this.u);
                if (this.k.a.isAvailable()) {
                    J(false);
                    return;
                }
                return;
            }
            F();
        }
    }

    @Override // c.a.p0.e0.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            J(false);
        }
    }

    @Override // c.a.p0.e0.c.d
    public void stop() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (camera = this.f13749g) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        K();
        Camera camera2 = this.f13749g;
        this.f13749g = null;
        camera2.release();
        this.f13749g = null;
        this.s = null;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f13749g.cancelAutoFocus();
            c.a.p0.e0.c.c.a();
        }
    }

    public final void y() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (camera = this.f13749g) != null && this.q == 1) {
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
