package c.a.p0.n4.i.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.recode.OutputSurface;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.FaceUnityUtils;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
/* loaded from: classes2.dex */
public class h implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public static int n;
    public static int[] o;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f16658b;

    /* renamed from: c  reason: collision with root package name */
    public Object f16659c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16660d;

    /* renamed from: e  reason: collision with root package name */
    public Context f16661e;

    /* renamed from: f  reason: collision with root package name */
    public String f16662f;

    /* renamed from: g  reason: collision with root package name */
    public int f16663g;

    /* renamed from: h  reason: collision with root package name */
    public int f16664h;
    public FullFrameRect i;
    public FullFrameRect j;
    public int k;
    public final float[] l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772584388, "Lc/a/p0/n4/i/d/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1772584388, "Lc/a/p0/n4/i/d/h;");
                return;
            }
        }
        o = new int[]{0, 0, 0};
    }

    public h(Context context, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16659c = new Object();
        this.f16662f = "normal";
        this.l = new float[16];
        this.f16661e = context;
        this.f16662f = str;
        this.f16663g = i;
        this.f16664h = i2;
        f();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f16659c) {
                while (!this.f16660d) {
                    try {
                        this.f16659c.wait(500L);
                        if (!this.f16660d) {
                            throw new RuntimeException("Surface frame wait timed out");
                        }
                    } catch (InterruptedException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                this.f16660d = false;
            }
            b("before updateTexImage");
            this.a.updateTexImage();
        }
    }

    public void b(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        Log.e(OutputSurface.TAG, str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.updateTexImage();
            this.a.getTransformMatrix(this.l);
            faceunity.fuItemSetParam(m, TbFileVideoActivityConfig.FILTER_NAME, this.f16662f);
            faceunity.fuItemSetParam(m, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(m, "tooth_whiten", 0.0d);
            this.i.drawFrame(faceunity.fuBeautifyImage(this.k, 1, this.f16663g, this.f16664h, 0, o), this.l);
        }
    }

    public Surface d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16658b : (Surface) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16658b.release();
            this.f16658b = null;
            this.a = null;
            FullFrameRect fullFrameRect = this.i;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
                this.i = null;
            }
            faceunity.fuDestroyItem(n);
            int[] iArr = o;
            n = 0;
            iArr[1] = 0;
            faceunity.fuDestroyItem(m);
            int[] iArr2 = o;
            m = 0;
            iArr2[0] = 0;
            faceunity.fuOnDeviceLost();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            Log.d(OutputSurface.TAG, "onSurfaceCreated: ");
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.j = fullFrameRect;
            this.k = fullFrameRect.createTextureObject();
            this.a = new SurfaceTexture(this.k);
            this.f16658b = new Surface(this.a);
            int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f16661e);
            m = upFaceUnity;
            o[0] = upFaceUnity;
            this.a.setOnFrameAvailableListener(this);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
            Log.d(OutputSurface.TAG, "new frame available");
            synchronized (this.f16659c) {
                if (!this.f16660d) {
                    this.f16660d = true;
                    this.f16659c.notifyAll();
                } else {
                    throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                }
            }
        }
    }
}
