package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.a;
import c.b.b.q.i0;
import c.b.b.q.w;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class d implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<ParticleEmitter> f27139e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27140f;

    public d() {
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
        this.f27139e = new c.b.b.q.a<>(8);
    }

    public void a(c.b.b.m.a aVar, c.b.b.m.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, aVar2) == null) {
            i(aVar);
            g(aVar2);
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f27140f) {
            int i2 = this.f27139e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                a.b<g> it = this.f27139e.get(i3).g().iterator();
                while (it.hasNext()) {
                    it.next().f().dispose();
                }
            }
        }
    }

    public void f(c.b.b.m.a aVar, h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, hVar, str) == null) {
            i(aVar);
            h(hVar, str);
        }
    }

    public void g(c.b.b.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f27140f = true;
            w wVar = new w(this.f27139e.f27361f);
            int i2 = this.f27139e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                ParticleEmitter particleEmitter = this.f27139e.get(i3);
                if (particleEmitter.f().f27361f != 0) {
                    c.b.b.q.a<g> aVar2 = new c.b.b.q.a<>();
                    a.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace(FileUtil.WINDOWS_SEPARATOR, '/')).getName();
                        g gVar = (g) wVar.c(name);
                        if (gVar == null) {
                            gVar = new g(j(aVar.a(name)));
                            wVar.i(name, gVar);
                        }
                        aVar2.a(gVar);
                    }
                    particleEmitter.u(aVar2);
                }
            }
        }
    }

    public void h(h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, hVar, str) == null) {
            int i2 = this.f27139e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                ParticleEmitter particleEmitter = this.f27139e.get(i3);
                if (particleEmitter.f().f27361f != 0) {
                    c.b.b.q.a<g> aVar = new c.b.b.q.a<>();
                    a.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace(FileUtil.WINDOWS_SEPARATOR, '/')).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        g a = hVar.a(name);
                        if (a != null) {
                            aVar.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(aVar);
                }
            }
        }
    }

    public void i(c.b.b.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, aVar) != null) {
            return;
        }
        InputStream m = aVar.m();
        this.f27139e.clear();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(m), 512);
                do {
                    try {
                        this.f27139e.a(k(bufferedReader2));
                    } catch (IOException e2) {
                        e = e2;
                        throw new GdxRuntimeException("Error loading effect: " + aVar, e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        i0.a(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                i0.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    public Texture j(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? new Texture(aVar, false) : (Texture) invokeL.objValue;
    }

    public ParticleEmitter k(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bufferedReader)) == null) ? new ParticleEmitter(bufferedReader) : (ParticleEmitter) invokeL.objValue;
    }

    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            int i2 = this.f27139e.f27361f;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f27139e.get(i3).update(f2);
            }
        }
    }
}
