package c.a.y.b.e;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import c.a.y.b.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class b extends a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f26703b;

    /* renamed from: c  reason: collision with root package name */
    public String f26704c;

    /* renamed from: d  reason: collision with root package name */
    public d f26705d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.y.b.f.c f26706e;

    /* renamed from: f  reason: collision with root package name */
    public int f26707f;

    /* renamed from: g  reason: collision with root package name */
    public int f26708g;

    /* renamed from: h  reason: collision with root package name */
    public int f26709h;

    /* renamed from: i  reason: collision with root package name */
    public int f26710i;

    /* renamed from: j  reason: collision with root package name */
    public int f26711j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1621945164, "Lc/a/y/b/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1621945164, "Lc/a/y/b/e/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26703b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        this.f26704c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
        new LinkedList();
    }

    @Override // c.a.y.b.e.c
    public void a(c.a.y.b.f.a aVar, c.a.y.b.g.b bVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, aVar, bVar) == null) && (dVar = this.f26705d) != null && dVar.f()) {
            l();
            d(this.f26705d);
            c(aVar, bVar);
            g(aVar, bVar);
            j();
            k(this.f26705d);
            f();
        }
    }

    @Override // c.a.y.b.e.c
    public void b(d dVar, c.a.y.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, cVar) == null) {
            this.f26705d = dVar;
            this.f26706e = cVar;
            e(this.f26703b, this.f26704c);
            if (this.a != -1) {
                h();
                return;
            }
            throw new RuntimeException("Unable to create program");
        }
    }

    public void c(c.a.y.b.f.a aVar, c.a.y.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, bVar) == null) {
            GLES20.glUniformMatrix4fv(this.f26708g, 1, false, bVar.b(), 0);
            GLES20.glUniformMatrix4fv(this.f26709h, 1, false, bVar.c(), 0);
            GLES20.glEnableVertexAttribArray(this.f26707f);
            GLES20.glVertexAttribPointer(this.f26707f, aVar.a(), 5126, false, aVar.f(), (Buffer) aVar.d());
            GLES20.glEnableVertexAttribArray(this.f26710i);
            GLES20.glVertexAttribPointer(this.f26710i, aVar.a(), 5126, false, aVar.c(), (Buffer) aVar.b());
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(dVar.getType(), dVar.c());
            GLES20.glUniform1i(this.f26711j, 0);
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (this.f26705d.getType() != 36197) {
                str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
            }
            this.a = c.a.y.b.h.a.c(str, str2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GLES20.glUseProgram(0);
        }
    }

    public void g(c.a.y.b.f.a aVar, c.a.y.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, bVar) == null) {
            if (bVar.f()) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (bVar.e()) {
                GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
            }
            GLES20.glDrawArrays(5, 0, aVar.e());
            if (bVar.e()) {
                GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26711j = GLES20.glGetUniformLocation(this.a, "uTexture");
            this.f26707f = GLES20.glGetAttribLocation(this.a, "aPosition");
            this.f26708g = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
            this.f26709h = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
            this.f26710i = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
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
            GLES20.glDisableVertexAttribArray(this.f26707f);
            GLES20.glDisableVertexAttribArray(this.f26710i);
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

    @Override // c.a.y.b.e.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i();
        }
    }
}
