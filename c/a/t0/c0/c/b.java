package c.a.t0.c0.c;

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
import c.a.t0.c0.c.d;
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
/* loaded from: classes7.dex */
public class b implements c.a.t0.c0.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f15680b;

    /* renamed from: c  reason: collision with root package name */
    public int f15681c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f15682d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f15683e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15684f;

    /* renamed from: g  reason: collision with root package name */
    public Camera f15685g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Parameters f15686h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.c0.c.e f15687i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f15688j;

    /* renamed from: k  reason: collision with root package name */
    public f f15689k;
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b f15690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f15691f;

        /* renamed from: c.a.t0.c0.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0969a implements Camera.PictureCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0969a(a aVar) {
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

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                    this.a.f15691f.J(false);
                    this.a.f15691f.f15682d.set(false);
                    d.b bVar = this.a.f15690e;
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
            this.f15691f = bVar;
            this.f15690e = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f15691f.f15685g.takePicture(null, null, new C0969a(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f15691f.J(false);
                    this.f15691f.f15682d.set(false);
                }
            }
        }
    }

    /* renamed from: c.a.t0.c0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0970b implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15692e;

        /* renamed from: c.a.t0.c0.c.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f15693e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0970b f15694f;

            public a(C0970b c0970b, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0970b, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15694f = c0970b;
                this.f15693e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15694f.f15692e.D(this.f15693e);
                }
            }
        }

        public C0970b(b bVar) {
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
            this.f15692e = bVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) && !this.f15692e.f15683e.get() && b.s(this.f15692e) % 5 == 0 && bArr.length == this.f15692e.f15686h.getPreviewSize().width * this.f15692e.f15686h.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(this.f15692e.s);
                c.a.t0.c0.c.c.c(new a(this, bArr));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15695e;

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
            this.f15695e = bVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) {
                this.f15695e.r = surfaceTexture;
                this.f15695e.C();
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
                b bVar = this.f15695e;
                bVar.E(bVar.f15689k.getWidth(), this.f15695e.f15689k.getHeight());
                this.f15695e.J(false);
                this.f15695e.G();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, surfaceTexture) == null) {
                this.f15695e.G();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15696e;

        /* loaded from: classes7.dex */
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
            this.f15696e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f15696e) {
                    if (this.f15696e.f15685g != null && !this.f15696e.f15682d.get()) {
                        try {
                            this.f15696e.f15685g.autoFocus(new a(this));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class f extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextureView f15697e;

        /* renamed from: f  reason: collision with root package name */
        public float f15698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15699g;

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
            this.f15699g = bVar;
            this.f15698f = 0.75f;
        }

        public final void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i2 < i3) {
                    i3 = (int) (i2 * this.f15698f);
                } else {
                    i2 = (int) (i3 * this.f15698f);
                }
                int width = (getWidth() - i2) / 2;
                int height = (getHeight() - i3) / 2;
                this.f15699g.f15688j.left = width;
                this.f15699g.f15688j.top = height;
                this.f15699g.f15688j.right = width + i2;
                this.f15699g.f15688j.bottom = height + i3;
            }
        }

        public void e(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f15698f = f2;
                requestLayout();
                d(getWidth(), getHeight());
            }
        }

        public void f(TextureView textureView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textureView) == null) {
                this.f15697e = textureView;
                removeAllViews();
                addView(textureView);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                this.f15697e.layout(this.f15699g.f15688j.left, this.f15699g.f15688j.top, this.f15699g.f15688j.right, this.f15699g.f15688j.bottom);
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
        this.a = 0;
        this.f15680b = 0;
        this.f15682d = new AtomicBoolean(false);
        this.f15683e = new AtomicBoolean(false);
        this.f15688j = new Rect();
        this.m = 0;
        this.o = 0;
        this.q = 0;
        this.s = null;
        this.t = new C0970b(this);
        this.u = new c(this);
        this.v = new e(this);
        this.f15684f = context;
        this.f15689k = new f(this, context);
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
            int width = this.f15689k.f15697e.getWidth();
            int height = this.f15689k.f15697e.getHeight();
            float f2 = this.f15689k.f15698f;
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
            int i2 = this.a;
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
                if (this.f15685g == null) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                        Camera.getCameraInfo(i2, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            this.f15680b = i2;
                        }
                    }
                    this.f15685g = Camera.open(this.f15680b);
                }
                if (this.f15686h == null) {
                    Camera.Parameters parameters = this.f15685g.getParameters();
                    this.f15686h = parameters;
                    parameters.setPreviewFormat(17);
                }
                E(this.f15689k.getWidth(), this.f15689k.getHeight());
                this.f15685g.setPreviewTexture(this.r);
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || this.f15685g == null || bArr == null || this.p == null) {
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
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f15686h == null || (camera = this.f15685g) == null || i2 <= 0) {
            return;
        }
        try {
            Camera.Size A = A(camera.getParameters().getSupportedPreviewSizes());
            this.p = A;
            this.f15686h.setPreviewSize(A.width, A.height);
            this.f15689k.e((this.p.width * 1.0f) / this.p.height);
            this.f15685g.setDisplayOrientation(B());
            K();
            this.f15685g.setParameters(this.f15686h);
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
            Camera camera = this.f15685g;
            if (camera == null || this.q != 1) {
                return;
            }
            camera.addCallbackBuffer(this.s);
            this.f15685g.setPreviewCallback(this.t);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextureView textureView = new TextureView(this.f15684f);
            this.f15689k.f15697e = textureView;
            this.f15689k.f(textureView);
            this.l = this.f15689k;
            textureView.setSurfaceTextureListener(this.u);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.t0.c0.c.c.b(new d(this));
        }
    }

    public final void J(boolean z) {
        c.a.t0.c0.c.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (ContextCompat.checkSelfPermission(this.f15684f, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                if (!z || (eVar = this.f15687i) == null) {
                    return;
                }
                eVar.a();
                return;
            }
            Camera camera = this.f15685g;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (camera = this.f15685g) == null) {
            return;
        }
        camera.stopPreview();
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 0) {
                this.f15686h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (i2 == 1) {
                this.f15686h.setFlashMode("torch");
            } else if (i2 != 2) {
                this.f15686h.setFlashMode("auto");
            } else {
                this.f15686h.setFlashMode("auto");
            }
            this.f15685g.setParameters(this.f15686h);
        }
    }

    @Override // c.a.t0.c0.c.d
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.t0.c0.c.d
    public void b(d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || this.f15682d.get()) {
            return;
        }
        int i2 = this.a;
        if (i2 == 0) {
            this.f15686h.setRotation(90);
        } else if (i2 == 90) {
            this.f15686h.setRotation(0);
        } else if (i2 == 270) {
            this.f15686h.setRotation(180);
        }
        try {
            Camera.Size A = A(this.f15685g.getParameters().getSupportedPictureSizes());
            this.f15686h.setPictureSize(A.width, A.height);
            this.f15685g.setParameters(this.f15686h);
            this.f15682d.set(true);
            x();
            c.a.t0.c0.c.c.c(new a(this, bVar));
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            J(false);
            this.f15682d.set(false);
        }
    }

    @Override // c.a.t0.c0.c.d
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.a = i2;
            if (i2 == 0) {
                this.m = 90;
            } else if (i2 == 90) {
                this.m = 0;
            } else if (i2 != 270) {
                this.m = 0;
            } else {
                this.m = 180;
            }
            this.f15689k.requestLayout();
        }
    }

    @Override // c.a.t0.c0.c.d
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f15681c : invokeV.intValue;
    }

    @Override // c.a.t0.c0.c.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f15682d.set(false);
        }
    }

    @Override // c.a.t0.c0.c.d
    public Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f15688j : (Rect) invokeV.objValue;
    }

    @Override // c.a.t0.c0.c.d
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            J(true);
        }
    }

    @Override // c.a.t0.c0.c.d
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f15681c == i2) {
            return;
        }
        this.f15681c = i2;
        L(i2);
    }

    @Override // c.a.t0.c0.c.d
    public void i(c.a.t0.c0.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f15687i = eVar;
        }
    }

    @Override // c.a.t0.c0.c.d
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f15685g != null) {
                K();
            }
            h(0);
        }
    }

    @Override // c.a.t0.c0.c.d
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f15682d.set(false);
            if (this.f15685g != null) {
                this.f15689k.f15697e.setSurfaceTextureListener(this.u);
                if (this.f15689k.f15697e.isAvailable()) {
                    J(false);
                    return;
                }
                return;
            }
            F();
        }
    }

    @Override // c.a.t0.c0.c.d
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            J(false);
        }
    }

    @Override // c.a.t0.c0.c.d
    public void stop() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (camera = this.f15685g) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        K();
        Camera camera2 = this.f15685g;
        this.f15685g = null;
        camera2.release();
        this.f15685g = null;
        this.s = null;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f15685g.cancelAutoFocus();
            c.a.t0.c0.c.c.a();
        }
    }

    public final void y() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (camera = this.f15685g) != null && this.q == 1) {
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
