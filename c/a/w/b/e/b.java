package c.a.w.b.e;

import android.opengl.GLES20;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.w.b.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class b extends a implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f21858b;

    /* renamed from: c  reason: collision with root package name */
    public String f21859c;

    /* renamed from: d  reason: collision with root package name */
    public d f21860d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.w.b.f.c f21861e;

    /* renamed from: f  reason: collision with root package name */
    public int f21862f;

    /* renamed from: g  reason: collision with root package name */
    public int f21863g;

    /* renamed from: h  reason: collision with root package name */
    public int f21864h;
    public int i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1863675506, "Lc/a/w/b/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1863675506, "Lc/a/w/b/e/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21858b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        this.f21859c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
        new LinkedList();
    }

    @Override // c.a.w.b.e.c
    public void a(c.a.w.b.f.a aVar, c.a.w.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, bVar) == null) {
            d dVar = this.f21860d;
            if (dVar != null && dVar.e()) {
                l();
                d(this.f21860d);
                c(aVar, bVar);
                g(aVar, bVar);
                j();
                k(this.f21860d);
                f();
                return;
            }
            Log.e(k, "onDraw filter has not been setup!!!");
        }
    }

    @Override // c.a.w.b.e.c
    public void b(d dVar, c.a.w.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, cVar) == null) {
            this.f21860d = dVar;
            this.f21861e = cVar;
            e(this.f21858b, this.f21859c);
            if (this.a != -1) {
                h();
                return;
            }
            throw new RuntimeException("Unable to create program");
        }
    }

    public void c(c.a.w.b.f.a aVar, c.a.w.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, bVar) == null) {
            GLES20.glUniformMatrix4fv(this.f21863g, 1, false, bVar.b(), 0);
            GLES20.glUniformMatrix4fv(this.f21864h, 1, false, bVar.c(), 0);
            GLES20.glEnableVertexAttribArray(this.f21862f);
            GLES20.glVertexAttribPointer(this.f21862f, aVar.a(), 5126, false, aVar.f(), (Buffer) aVar.d());
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glVertexAttribPointer(this.i, aVar.a(), 5126, false, aVar.c(), (Buffer) aVar.b());
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(dVar.getType(), dVar.c());
            GLES20.glUniform1i(this.j, 0);
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (this.f21860d.getType() != 36197) {
                str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
            }
            this.a = c.a.w.b.h.a.c(str, str2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GLES20.glUseProgram(0);
        }
    }

    public void g(c.a.w.b.f.a aVar, c.a.w.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, bVar) == null) {
            if (bVar.e()) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (bVar.d()) {
                GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                GLES20.glBlendFunc(770, 771);
            }
            GLES20.glDrawArrays(5, 0, aVar.e());
            if (bVar.d()) {
                GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = GLES20.glGetUniformLocation(this.a, "uTexture");
            this.f21862f = GLES20.glGetAttribLocation(this.a, "aPosition");
            this.f21863g = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
            this.f21864h = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
            this.i = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GLES20.glDeleteProgram(this.a);
            this.a = -1;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            GLES20.glDisableVertexAttribArray(this.f21862f);
            GLES20.glDisableVertexAttribArray(this.i);
        }
    }

    public void k(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            GLES20.glBindTexture(dVar.getType(), 0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GLES20.glUseProgram(this.a);
        }
    }

    @Override // c.a.w.b.e.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i();
        }
    }
}
