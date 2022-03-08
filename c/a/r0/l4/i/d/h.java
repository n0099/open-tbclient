package c.a.r0.l4.i.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
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
    public static int q;
    public static int r;
    public static int[] s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceTexture f19062e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f19063f;

    /* renamed from: g  reason: collision with root package name */
    public Object f19064g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19065h;

    /* renamed from: i  reason: collision with root package name */
    public Context f19066i;

    /* renamed from: j  reason: collision with root package name */
    public String f19067j;
    public int k;
    public int l;
    public FullFrameRect m;
    public FullFrameRect n;
    public int o;
    public final float[] p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350691456, "Lc/a/r0/l4/i/d/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350691456, "Lc/a/r0/l4/i/d/h;");
                return;
            }
        }
        s = new int[]{0, 0, 0};
    }

    public h(Context context, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19064g = new Object();
        this.f19067j = "normal";
        this.p = new float[16];
        this.f19066i = context;
        this.f19067j = str;
        this.k = i2;
        this.l = i3;
        f();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f19064g) {
                while (!this.f19065h) {
                    try {
                        this.f19064g.wait(500L);
                        if (!this.f19065h) {
                            throw new RuntimeException("Surface frame wait timed out");
                        }
                    } catch (InterruptedException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                this.f19065h = false;
            }
            b("before updateTexImage");
            this.f19062e.updateTexImage();
        }
    }

    public void b(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        String str2 = str + ": glError " + glGetError;
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19062e.updateTexImage();
            this.f19062e.getTransformMatrix(this.p);
            faceunity.fuItemSetParam(q, TbFileVideoActivityConfig.FILTER_NAME, this.f19067j);
            faceunity.fuItemSetParam(q, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(q, "tooth_whiten", 0.0d);
            this.m.drawFrame(faceunity.fuBeautifyImage(this.o, 1, this.k, this.l, 0, s), this.p);
        }
    }

    public Surface d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19063f : (Surface) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19063f.release();
            this.f19063f = null;
            this.f19062e = null;
            FullFrameRect fullFrameRect = this.m;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
                this.m = null;
            }
            faceunity.fuDestroyItem(r);
            int[] iArr = s;
            r = 0;
            iArr[1] = 0;
            faceunity.fuDestroyItem(q);
            int[] iArr2 = s;
            q = 0;
            iArr2[0] = 0;
            faceunity.fuOnDeviceLost();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.n = fullFrameRect;
            this.o = fullFrameRect.createTextureObject();
            this.f19062e = new SurfaceTexture(this.o);
            this.f19063f = new Surface(this.f19062e);
            int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f19066i);
            q = upFaceUnity;
            s[0] = upFaceUnity;
            this.f19062e.setOnFrameAvailableListener(this);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
            synchronized (this.f19064g) {
                if (!this.f19065h) {
                    this.f19065h = true;
                    this.f19064g.notifyAll();
                } else {
                    throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                }
            }
        }
    }
}
