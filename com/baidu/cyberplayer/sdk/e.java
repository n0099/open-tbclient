package com.baidu.cyberplayer.sdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.afx.recode.TextureRender;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes10.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f33506b;

    /* renamed from: c  reason: collision with root package name */
    public FloatBuffer f33507c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33508d;

    /* renamed from: e  reason: collision with root package name */
    public final String f33509e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f33510f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f33511g;

    /* renamed from: h  reason: collision with root package name */
    public int f33512h;

    /* renamed from: i  reason: collision with root package name */
    public int f33513i;

    /* renamed from: j  reason: collision with root package name */
    public int f33514j;
    public int k;
    public int l;
    public int m;
    public SurfaceTexture n;
    public Surface o;
    public boolean p;
    public final Object q;
    public final Object r;
    public boolean s;
    public f t;
    public boolean u;
    public float v;
    public int w;
    public int x;
    public i.a y;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33506b = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f33508d = TextureRender.VERTEX_SHADER;
        this.f33509e = TextureRender.FRAGMENT_SHADER;
        this.f33510f = new float[16];
        this.f33511g = new float[16];
        this.p = false;
        this.q = new Object();
        this.r = new Object();
        this.u = false;
        this.v = 1.0f;
        this.w = 0;
        this.x = 0;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.f33506b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f33507c = asFloatBuffer;
        asFloatBuffer.put(this.f33506b).position(0);
        Matrix.setIdentityM(this.f33511g, 0);
        this.s = false;
        this.t = new f();
    }

    private int a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i2);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    CyberLog.e("CyberRender", "Could not compile shader " + i2 + ":");
                    CyberLog.e("CyberRender", GLES20.glGetShaderInfoLog(glCreateShader));
                    GLES20.glDeleteShader(glCreateShader);
                    return 0;
                }
                return glCreateShader;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }

    private int a(String str, String str2) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            int a3 = a(35633, str);
            if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            if (glCreateProgram != 0) {
                GLES20.glAttachShader(glCreateProgram, a3);
                a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a2);
                a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    CyberLog.e("CyberRender", "Could not link program: ");
                    CyberLog.e("CyberRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                    return 0;
                }
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    public static void a(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, surfaceTexture) == null) || surfaceTexture == null) {
            return;
        }
        try {
            surfaceTexture.setOnFrameAvailableListener(null);
            surfaceTexture.release();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                CyberLog.e("CyberRender", str + ": glError " + glGetError);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65541, this, i2, i3, i4, i5) == null) {
            CyberLog.i("CyberRender", "drawSmallScreen called width:" + i4 + " height:" + i5);
            GLES20.glViewport(i2, i3, i4, i5);
            e();
            CyberLog.i("CyberRender", "drawSmallScreen called end");
        }
    }

    private void c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(65542, this, i2, i3, i4, i5) == null) || this.y == null) {
            return;
        }
        this.y.a(i4, i5, d(i2, i3, i4, i5));
    }

    private Buffer d(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65543, this, i2, i3, i4, i5)) == null) {
            CyberLog.i("CyberRender", "=> getFrame width:" + i4 + " height:" + i5);
            IntBuffer wrap = IntBuffer.wrap(new int[i4 * i5]);
            wrap.position(0);
            GLES20.glPixelStorei(3333, 4);
            GLES20.glReadPixels(i2, i3, i4, i5, GeneratedTexture.FORMAT, 5121, wrap);
            return wrap;
        }
        return (Buffer) invokeIIII.objValue;
    }

    private void e() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (i2 = this.f33512h) == 0) {
            return;
        }
        GLES20.glUseProgram(i2);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f33513i);
        this.f33507c.position(0);
        GLES20.glVertexAttribPointer(this.l, 3, 5126, false, 20, (Buffer) this.f33507c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.l);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f33507c.position(3);
        GLES20.glVertexAttribPointer(this.m, 3, 5126, false, 20, (Buffer) this.f33507c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.m);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f33510f, 0);
        float[] c2 = this.t.c();
        if (this.t.f()) {
            float[] e2 = this.t.e();
            Matrix.translateM(this.f33510f, 0, e2[0], e2[1], 0.0f);
        }
        Matrix.scaleM(this.f33510f, 0, c2[0], c2[1], 0.0f);
        Matrix.rotateM(this.f33510f, 0, this.t.g(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.f33514j, 1, false, this.f33510f, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.f33511g, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            a(this.n);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            this.f33513i = iArr[0];
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f33513i);
            this.n = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            i();
            a("detachGL");
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this.q) {
                try {
                    if (this.p) {
                        if (this.n != null) {
                            this.n.updateTexImage();
                            this.n.getTransformMatrix(this.f33511g);
                        }
                        this.p = false;
                        if (!this.s) {
                            this.s = true;
                            if (this.y != null) {
                                this.y.a(System.currentTimeMillis());
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.n != null) {
                this.n.attachToGLContext(this.f33513i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.n != null) {
                this.n.detachFromGLContext();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.u && this.s) {
            synchronized (this.r) {
                if (this.u) {
                    if (this.v > 1.0f) {
                        this.v = 1.0f;
                    }
                    int i2 = this.w;
                    int i3 = this.x;
                    this.u = false;
                    CyberLog.i("CyberRender", "drawScreenSnapshot called");
                    int j2 = this.t.j();
                    int k = this.t.k();
                    int round = Math.round(j2 * this.v);
                    int round2 = Math.round(k * this.v);
                    if (round <= 0 || round2 <= 0) {
                        return;
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called mSurfaceWidth:" + j2 + " mSurfaceHeight:" + k + " snapWidth:" + round + " snapHeight:" + round2);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    b(i2, i3, round, round2);
                    c(i2, i3, round, round2);
                    if (round != j2 || round2 != k) {
                        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
                        GLES20.glClear(16640);
                    }
                    GLES20.glViewport(0, 0, this.t.j(), this.t.k());
                    a aVar = this.a;
                    if (aVar != null) {
                        aVar.a();
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called end x:" + i2 + " y:" + i3);
                }
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                a(this.n);
                this.n = null;
                if (this.o != null) {
                    this.o.release();
                }
                this.o = null;
            }
        }
    }

    public void a(float f2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this.r) {
                this.u = true;
                this.v = f2;
                this.w = i2;
                this.x = i3;
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.t.c(i2)) {
            this.t.b();
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) && this.t.a(i2, i3, i4, i5)) {
            this.t.b();
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void a(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.y = aVar;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.a();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && this.t.b(i2)) {
            this.t.b();
        }
    }

    public synchronized Surface c() {
        InterceptResult invokeV;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                a();
                f();
                if (this.n != null) {
                    this.o = new Surface(this.n);
                }
                this.p = false;
                this.s = false;
                surface = this.o;
            }
            return surface;
        }
        return (Surface) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && this.t.a(i2)) {
            this.t.b();
        }
    }

    public synchronized SurfaceTexture d() {
        InterceptResult invokeV;
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                surfaceTexture = this.n;
            }
            return surfaceTexture;
        }
        return (SurfaceTexture) invokeV.objValue;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gl10) == null) {
            h();
            g();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            e();
            i();
            j();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) {
            synchronized (this.q) {
                if (surfaceTexture != this.n) {
                    return;
                }
                this.p = true;
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, gl10, i2, i3) == null) {
            GLES20.glViewport(0, 0, i2, i3);
            this.t.a(i2, i3);
            this.t.b();
            i.a aVar = this.y;
            if (aVar != null) {
                aVar.a(i2, i3);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, gl10, eGLConfig) == null) {
            int a2 = a(TextureRender.VERTEX_SHADER, TextureRender.FRAGMENT_SHADER);
            this.f33512h = a2;
            if (a2 == 0) {
                return;
            }
            this.l = GLES20.glGetAttribLocation(a2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.l == -1) {
                str = "CyberRender";
                str2 = "Could not get attrib location for aPosition";
            } else {
                this.m = GLES20.glGetAttribLocation(this.f33512h, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.m == -1) {
                    str = "CyberRender";
                    str2 = "Could not get attrib location for aTextureCoord";
                } else {
                    this.f33514j = GLES20.glGetUniformLocation(this.f33512h, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f33514j == -1) {
                        str = "CyberRender";
                        str2 = "Could not get attrib location for uMVPMatrix";
                    } else {
                        this.k = GLES20.glGetUniformLocation(this.f33512h, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f33514j != -1) {
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            i.a aVar = this.y;
                            if (aVar == null || !aVar.a(0)) {
                                return;
                            }
                            synchronized (this.q) {
                                this.p = false;
                            }
                            return;
                        }
                        str = "CyberRender";
                        str2 = "Could not get attrib location for uSTMatrix";
                    }
                }
            }
            CyberLog.e(str, str2);
        }
    }
}
