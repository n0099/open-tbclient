package c.a.r0.b4.j.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.p.b;
import c.a.x0.t.h;
import c.a.x0.t.u;
import c.a.x0.t.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b extends c.a.r0.b4.j.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b X;
    public static g Y;
    public static g Z;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageReader A;
    public g B;
    public Range<Integer> C;
    public String D;
    public String E;
    public MediaRecorder F;
    public File G;
    public boolean H;
    public b.a I;
    public Rect J;
    public float K;
    public int L;
    public boolean M;
    public MeteringRectangle[] N;
    public MeteringRectangle[] O;
    public MeteringRectangle[] P;
    public f Q;
    public int R;
    public boolean S;
    public CameraConstrainedHighSpeedCaptureSession T;
    public CameraCaptureSession.StateCallback U;
    public CameraDevice.StateCallback V;
    public CameraCaptureSession.CaptureCallback W;
    public boolean r;
    public CameraManager s;
    public CameraDevice t;
    public CameraCaptureSession u;
    public Semaphore v;
    public CaptureRequest.Builder w;
    public HandlerThread x;
    public Handler y;
    public CameraCharacteristics z;

    /* loaded from: classes3.dex */
    public class a extends CameraCaptureSession.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16243a;

        /* renamed from: c.a.r0.b4.j.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0776a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0776a(a aVar) {
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
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
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
            this.f16243a = bVar;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraCaptureSession) == null) {
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(api = 23)
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession) == null) {
                this.f16243a.u = cameraCaptureSession;
                this.f16243a.T = (CameraConstrainedHighSpeedCaptureSession) cameraCaptureSession;
                this.f16243a.N();
                u.a().post(new RunnableC0776a(this));
            }
        }
    }

    /* renamed from: c.a.r0.b4.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0777b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0777b(b bVar) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(b.Z != null);
                sb.append("|");
                sb.append(b.Y != null);
                c.a.x0.f.a.b("camera_hfps", sb.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CameraDevice.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16244a;

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
            this.f16244a = bVar;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraDevice) == null) {
                this.f16244a.v.release();
                cameraDevice.close();
                this.f16244a.t = null;
                if (this.f16244a.I != null) {
                    this.f16244a.I.a("StateCallback onDisconnected");
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraDevice, i2) == null) {
                this.f16244a.v.release();
                cameraDevice.close();
                this.f16244a.t = null;
                if (this.f16244a.I != null) {
                    b.a aVar = this.f16244a.I;
                    aVar.a("StateCallback onError error = " + i2);
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cameraDevice) == null) {
                this.f16244a.t = cameraDevice;
                boolean m0 = this.f16244a.m0();
                this.f16244a.v.release();
                if (m0 || this.f16244a.I == null) {
                    return;
                }
                this.f16244a.I.a("StateCallback nOpened startPreviewSession fail");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CameraCaptureSession.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16245a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f16246e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f16247f;

            public a(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16247f = dVar;
                this.f16246e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16246e || this.f16247f.f16245a.I == null) {
                    return;
                }
                this.f16247f.f16245a.I.a("CameraCaptureSession.StateCallback onConfigured fail");
            }
        }

        /* renamed from: c.a.r0.b4.j.a.b$d$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0778b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f16248e;

            public RunnableC0778b(d dVar) {
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
                        return;
                    }
                }
                this.f16248e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16248e.f16245a.I == null) {
                    return;
                }
                this.f16248e.f16245a.I.a("CameraCaptureSession.StateCallback onConfigureFailed");
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
            this.f16245a = bVar;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraCaptureSession) == null) {
                u.a().post(new RunnableC0778b(this));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession) == null) {
                this.f16245a.u = cameraCaptureSession;
                u.a().post(new a(this, this.f16245a.N()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CameraCaptureSession.CaptureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16249a;

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
            this.f16249a = bVar;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cameraCaptureSession, captureRequest, totalCaptureResult) == null) {
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                this.f16249a.p0(totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession, captureRequest, captureResult) == null) {
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                this.f16249a.p0(captureResult);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2021060802, "Lc/a/r0/b4/j/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2021060802, "Lc/a/r0/b4/j/a/b;");
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = true;
        this.v = new Semaphore(1);
        this.H = false;
        this.P = new MeteringRectangle[]{new MeteringRectangle(0, 0, 0, 0, 0)};
        this.R = -1;
        this.S = false;
        this.U = new a(this);
        this.V = new c(this);
        this.W = new e(this);
        this.f16233a = tbPageContext;
        a0();
        l0();
    }

    public static b U(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            if (X == null) {
                synchronized (b.class) {
                    if (X == null) {
                        X = new b(tbPageContext);
                    } else if (tbPageContext != null) {
                        X.f16233a = tbPageContext;
                    }
                }
            }
            return X;
        }
        return (b) invokeL.objValue;
    }

    public final Rect I(int i2, int i3, float f2, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            int i8 = (int) (i2 * f2);
            int i9 = (int) (i3 * f2);
            int a2 = c.a.r0.b4.j.a.h.a.a(Math.abs(i4 - i8) / 2, 0, Math.abs(i6 - i8));
            int a3 = c.a.r0.b4.j.a.h.a.a(Math.abs(i5 - i9) / 2, 0, Math.abs(i7 - i9));
            RectF rectF = new RectF(a2, a3, a2 + i8, a3 + i9);
            this.Q.c(rectF);
            Rect rect = new Rect();
            c.a.r0.b4.j.a.h.a.f(rectF, rect);
            return rect;
        }
        return (Rect) invokeCommon.objValue;
    }

    public final void J(Range<Integer>[] rangeArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rangeArr) == null) {
            Range<Integer> range = null;
            this.C = null;
            if (rangeArr != null) {
                int i2 = Integer.MAX_VALUE;
                int length = rangeArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    Range<Integer> range2 = rangeArr[i3];
                    if (range2 != null) {
                        if (this.k >= range2.getLower().intValue() && this.k <= range2.getUpper().intValue()) {
                            range = range2;
                            break;
                        }
                        int abs = Math.abs(range2.getLower().intValue() - this.k);
                        int abs2 = Math.abs(range2.getUpper().intValue() - this.k);
                        if (abs <= abs2 && abs < i2) {
                            range = range2;
                            i2 = abs;
                        } else if (abs2 <= abs && abs2 < i2) {
                            range = range2;
                            i2 = abs2;
                        }
                    }
                    i3++;
                }
                this.C = range;
            }
            if (this.C == null) {
                this.C = new Range<>(30, 30);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                try {
                    this.v.acquire();
                    M();
                    if (this.t != null) {
                        this.t.close();
                        this.t = null;
                    }
                    L();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("Interrupted while trying to lock camera closing.");
                }
            } finally {
                this.v.release();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaRecorder mediaRecorder = this.F;
            if (mediaRecorder != null) {
                mediaRecorder.release();
                this.F = null;
            }
            File file = this.G;
            if (file == null || !file.exists()) {
                return;
            }
            FileUtils.delete(this.G);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageReader imageReader = this.A;
            if (imageReader != null) {
                imageReader.close();
                this.A = null;
            }
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.u = null;
            }
            this.H = false;
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return invokeV.booleanValue;
        }
        boolean z = false;
        if (!c0()) {
            return false;
        }
        try {
            i0(this.w);
            if (this.S && Build.VERSION.SDK_INT >= 23) {
                this.T.setRepeatingBurst(this.T.createHighSpeedRequestList(this.w.build()), null, this.y);
            } else {
                this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
            }
            this.H = true;
            try {
                c.a.r0.b4.j.a.c.f16251b.k(2);
                return true;
            } catch (Exception e2) {
                e = e2;
                z = true;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final void O(MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, meteringRectangle, meteringRectangle2, z) == null) {
            try {
                CameraCaptureSession cameraCaptureSession = this.u;
                CaptureRequest.Builder builder = this.w;
                if (z && !this.n) {
                    meteringRectangle2 = null;
                }
                cameraCaptureSession.setRepeatingRequest(W(builder, meteringRectangle, meteringRectangle2), this.W, this.y);
                this.w.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                this.u.capture(this.w.build(), this.W, this.y);
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final g P(CameraCharacteristics cameraCharacteristics) {
        InterceptResult invokeL;
        Range<Integer>[] highSpeedVideoFpsRanges;
        Size[] highSpeedVideoSizesFor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cameraCharacteristics)) == null) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Range<Integer> range : streamConfigurationMap.getHighSpeedVideoFpsRanges()) {
                if (range.getLower().equals(range.getUpper())) {
                    for (Size size : streamConfigurationMap.getHighSpeedVideoSizesFor(range)) {
                        g gVar = new g(size.getWidth(), size.getHeight());
                        gVar.h(range.getUpper().intValue());
                        if (gVar.f(0)) {
                            arrayList.add(gVar);
                        } else if (gVar.f(1)) {
                            arrayList.add(gVar);
                        } else if (gVar.f(2)) {
                            arrayList.add(gVar);
                        }
                    }
                }
            }
            if (h.e(arrayList)) {
                return null;
            }
            Collections.sort(arrayList);
            return (g) arrayList.get(arrayList.size() - 1);
        }
        return (g) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && c0()) {
            try {
                this.w.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(X(1)));
                this.w.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f16234b && c.a.r0.b4.j.a.a.o) {
                return 0;
            }
            return (this.f16234b || !c.a.r0.b4.j.a.a.p) ? -1 : 1;
        }
        return invokeV.intValue;
    }

    public final String S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 == 0) {
                return this.D;
            }
            if (1 == i2) {
                return this.E;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final g T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (i2 == 0) {
                return Z;
            }
            if (1 == i2) {
                return Y;
            }
            return null;
        }
        return (g) invokeI.objValue;
    }

    public final Size V(Size[] sizeArr, int i2, int i3) {
        InterceptResult invokeLII;
        Size size;
        Size size2;
        Size size3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, sizeArr, i2, i3)) == null) {
            Size[] sizeArr2 = sizeArr;
            int i4 = i2;
            if (sizeArr2 != null) {
                int i5 = i4 * i3;
                int i6 = Integer.MAX_VALUE;
                float f2 = i4 / i3;
                float f3 = 2.1474836E9f;
                float f4 = Float.MAX_VALUE;
                int length = sizeArr2.length;
                int i7 = 0;
                size = null;
                size2 = null;
                while (i7 < length) {
                    size3 = sizeArr2[i7];
                    if (size3 != null) {
                        if (size3.getWidth() == i4 && size3.getHeight() == i3) {
                            break;
                        }
                        int abs = Math.abs(i5 - (size3.getWidth() * size3.getHeight()));
                        if (abs < i6) {
                            size = size3;
                            i6 = abs;
                        }
                        float abs2 = Math.abs((size3.getWidth() / size3.getHeight()) - f2);
                        if (abs2 - f4 <= 0.001d) {
                            float f5 = abs;
                            if (f5 < f3) {
                                f3 = f5;
                                f4 = abs2;
                                size2 = size3;
                            }
                        }
                    }
                    i7++;
                    sizeArr2 = sizeArr;
                    i4 = i2;
                }
            } else {
                size = null;
                size2 = null;
            }
            size3 = null;
            if (size3 != null) {
                return size3;
            }
            if (size2 != null) {
                return size2;
            }
            if (size != null) {
                return size;
            }
            return null;
        }
        return (Size) invokeLII.objValue;
    }

    public final CaptureRequest W(CaptureRequest.Builder builder, MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, builder, meteringRectangle, meteringRectangle2)) == null) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(X(1)));
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            MeteringRectangle[] meteringRectangleArr = this.N;
            if (meteringRectangleArr == null) {
                this.N = new MeteringRectangle[]{meteringRectangle};
            } else {
                meteringRectangleArr[0] = meteringRectangle;
            }
            if (meteringRectangle2 != null) {
                MeteringRectangle[] meteringRectangleArr2 = this.O;
                if (meteringRectangleArr2 == null) {
                    this.O = new MeteringRectangle[]{meteringRectangle2};
                } else {
                    meteringRectangleArr2[0] = meteringRectangle2;
                }
            }
            if (f0(true)) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, this.N);
            }
            if (meteringRectangle2 != null && f0(false)) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.O);
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            return builder.build();
        }
        return (CaptureRequest) invokeLLL.objValue;
    }

    public final int X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int[] iArr = (int[]) this.z.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return i2;
                }
            }
            return iArr[0];
        }
        return invokeI.intValue;
    }

    public final File Y() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            File CreateFileIfNotFoundInCache = FileHelper.CreateFileIfNotFoundInCache("miniHighSpeed");
            if (!CreateFileIfNotFoundInCache.exists()) {
                CreateFileIfNotFoundInCache.mkdirs();
            }
            return new File(CreateFileIfNotFoundInCache, "/HIGH_SPEED_VIDEO_" + System.currentTimeMillis() + ".mp4");
        }
        return (File) invokeV.objValue;
    }

    public final Rect Z(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f2)) == null) {
            try {
                this.L = (int) MathUtils.clamp(f2, 1.0f, this.K);
                int width = this.J.width() / 2;
                int height = this.J.height() / 2;
                int width2 = (int) ((this.J.width() * 0.5f) / this.L);
                int height2 = (int) ((this.J.height() * 0.5f) / this.L);
                return new Rect(width - width2, height - height2, width + width2, height + height2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Rect) invokeF.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        r8.r = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0() {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (pageActivity = this.f16233a.getPageActivity()) == null || pageActivity.isFinishing()) {
            return;
        }
        CameraManager cameraManager = (CameraManager) pageActivity.getSystemService("camera");
        this.s = cameraManager;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int length = cameraIdList.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = cameraIdList[i2];
                CameraCharacteristics cameraCharacteristics = this.s.getCameraCharacteristics(str);
                if (d0(cameraCharacteristics) < 0) {
                    break;
                }
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
                if (intValue == 0) {
                    c.a.r0.b4.j.a.a.o = true;
                    this.D = str;
                } else if (intValue == 1 && TextUtils.isEmpty(this.E)) {
                    c.a.r0.b4.j.a.a.p = true;
                    this.E = str;
                }
                i2++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.r = false;
        }
        boolean z = (!c.a.r0.b4.j.a.a.o || DeviceInfoUtil.isHuaweiMateX() || DeviceInfoUtil.isOppN5207()) ? false : true;
        c.a.r0.b4.j.a.a.o = z;
        if (!z && !c.a.r0.b4.j.a.a.p) {
            this.r = false;
        }
        String S = S(1);
        if (!TextUtils.isEmpty(S)) {
            try {
                Y = P(this.s.getCameraCharacteristics(S));
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
        }
        String S2 = S(0);
        if (!TextUtils.isEmpty(S2)) {
            try {
                Z = P(this.s.getCameraCharacteristics(S2));
            } catch (CameraAccessException e3) {
                e3.printStackTrace();
            }
        }
        if (Z == null && Y == null) {
            return;
        }
        u.a().postDelayed(new RunnableC0777b(this), 2000L);
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 35;
        }
        return invokeV.intValue;
    }

    public final void b0(CameraCharacteristics cameraCharacteristics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cameraCharacteristics) == null) {
            this.z = cameraCharacteristics;
            Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
            if (bool != null) {
                bool.booleanValue();
            }
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.J = rect;
            if (rect == null) {
                this.K = 1.0f;
                this.M = false;
                return;
            }
            Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            float floatValue = (f2 == null || f2.floatValue() < 1.0f) ? 1.0f : f2.floatValue();
            this.K = floatValue;
            this.M = Float.compare(floatValue, 1.0f) > 0;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048596, this, i2, i3, i4, i5) == null) && c0()) {
            O(new MeteringRectangle(I(i2, i3, 1.0f, i4, i5, v.e(), v.d()), 1000), new MeteringRectangle(I(i2, i3, 1.5f, i4, i5, v.e(), v.d()), 1000), false);
        }
    }

    public final boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.w == null || this.u == null || this.t == null) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bArr) == null) {
        }
    }

    public final int d0(CameraCharacteristics cameraCharacteristics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cameraCharacteristics)) == null) {
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? c.a.r0.b4.j.a.a.q : (String) invokeV.objValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.S && (gVar = this.B) != null && gVar.c() >= 60 : invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public final boolean f0(boolean z) {
        InterceptResult invokeZ;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            if (z) {
                intValue = ((Integer) this.z.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
            } else {
                intValue = ((Integer) this.z.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue();
            }
            return intValue > 0;
        }
        return invokeZ.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void g(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            this.f16238f = Math.max(i2, i3);
            this.f16239g = Math.min(i2, i3);
            this.f16235c = i2 > i3;
            this.k = i4;
            i(z);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if ((this.f16235c && this.f16236d < this.f16237e) || (!this.f16235c && this.f16236d > this.f16237e)) {
                this.f16240h = this.f16237e;
                this.f16241i = this.f16236d;
            } else {
                this.f16240h = this.f16236d;
                this.f16241i = this.f16237e;
            }
            j0();
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int R = R();
            this.f16242j = R;
            String S = S(R);
            if (S != null) {
                try {
                    if (this.v.tryAcquire(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                        CameraCharacteristics cameraCharacteristics = this.s.getCameraCharacteristics(S);
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                        if (streamConfigurationMap != null) {
                            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                            b0(cameraCharacteristics);
                            this.B = null;
                            if (this.S) {
                                g T = T(this.f16242j);
                                this.B = T;
                                if (T != null) {
                                    k0(T);
                                    this.C = new Range<>(Integer.valueOf(this.B.c()), Integer.valueOf(this.B.c()));
                                }
                            }
                            if (this.B == null) {
                                this.S = false;
                                J((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
                                Size V = V(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), this.f16238f, this.f16239g);
                                this.B = new g(V.getWidth(), V.getHeight(), this.C.getUpper().intValue());
                            }
                            this.f16236d = this.B.e();
                            this.f16237e = this.B.d();
                            g0();
                            this.s.openCamera(S, this.V, this.y);
                            return true;
                        }
                        throw new RuntimeException("Cannot get available preview/video sizes");
                    }
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                } catch (CameraAccessException | InterruptedException | NullPointerException | Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f16234b = (z && x()) || !(z || w());
        }
    }

    public final void i0(CaptureRequest.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, builder) == null) {
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.C);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.Q = new f(this.z, new RectF(new Rect(0, 0, this.f16236d, this.f16237e)));
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public boolean k(SurfaceTexture surfaceTexture, b.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, surfaceTexture, fVar)) == null) {
            if (this.r) {
                this.l = surfaceTexture;
                if (this.x == null) {
                    l0();
                }
                K();
                return h0();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void k0(g gVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, gVar) == null) {
            if (DeviceInfoUtil.isXiaomi10()) {
                this.F = new MediaRecorder();
            }
            MediaRecorder mediaRecorder = this.F;
            if (mediaRecorder == null) {
                return;
            }
            mediaRecorder.reset();
            CamcorderProfile b2 = gVar.b();
            this.F.setAudioSource(1);
            this.F.setVideoSource(2);
            this.F.setProfile(b2);
            File Y2 = Y();
            this.G = Y2;
            if (Y2 != null) {
                this.F.setOutputFile(Y2.getAbsolutePath());
            }
            this.F.setOrientationHint(0);
            this.F.prepare();
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && c0() && this.M) {
            if (i2 >= 1 || i2 <= -1) {
                float f2 = this.K;
                if (f2 <= 1.0f) {
                    return;
                }
                float f3 = this.L + i2;
                if (f3 <= f2) {
                    f2 = f3 < 0.0f ? 0.0f : f3;
                }
                Rect Z2 = Z(f2);
                if (Z2 != null) {
                    try {
                        this.w.set(CaptureRequest.SCALER_CROP_REGION, Z2);
                        this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            HandlerThread handlerThread = new HandlerThread("CameraBackground");
            this.x = handlerThread;
            handlerThread.start();
            this.y = new Handler(this.x.getLooper());
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.t == null || this.l == null || this.B == null) {
                return false;
            }
            try {
                M();
                SurfaceTexture surfaceTexture = this.l;
                surfaceTexture.setDefaultBufferSize(this.B.e(), this.B.d());
                this.w = this.t.createCaptureRequest(1);
                Surface surface = new Surface(surfaceTexture);
                this.w.addTarget(surface);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(surface);
                if (this.A != null) {
                    Surface surface2 = this.A.getSurface();
                    this.w.addTarget(surface2);
                    arrayList.add(surface2);
                }
                if (this.F != null) {
                    arrayList.add(this.F.getSurface());
                    this.w.addTarget(this.F.getSurface());
                }
                if (this.S && Build.VERSION.SDK_INT >= 23) {
                    this.t.createConstrainedHighSpeedCaptureSession(arrayList, this.U, this.y);
                } else {
                    this.t.createCaptureSession(arrayList, new d(this), this.y);
                }
                return true;
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            HandlerThread handlerThread = this.x;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            try {
                if (this.x != null) {
                    this.x.join();
                }
                this.x = null;
                this.y = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f16234b : invokeV.booleanValue;
    }

    public final void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            if (i2 == 2) {
                Q();
            } else if (i2 != 4) {
            } else {
                Q();
            }
        }
    }

    public final void p0(CaptureResult captureResult) {
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, captureResult) == null) || (num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)) == null || this.R == num.intValue()) {
            return;
        }
        this.R = num.intValue();
        o0(num.intValue());
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.t == null) {
            return;
        }
        K();
        this.t = null;
        this.K = 0.0f;
        this.L = 0;
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            synchronized (this) {
                X = null;
                this.f16233a = null;
                this.l = null;
                this.I = null;
                n0();
            }
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void s(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, aVar) == null) {
            this.I = aVar;
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void t(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048624, this, i2, i3, i4, i5) != null) || !c0()) {
        }
    }

    @Override // c.a.x0.p.b.InterfaceC1428b
    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
        }
    }

    @Override // c.a.r0.b4.j.a.a
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (e0()) {
                return Y != null;
            }
            return super.w();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.b4.j.a.a
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (e0()) {
                return Z != null;
            }
            return super.x();
        }
        return invokeV.booleanValue;
    }
}
