package c.b.b.n.k;

import c.b.b.j.f.n;
import c.b.b.q.i0;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes3.dex */
public class f extends n<e, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f27279b;

    /* renamed from: c  reason: collision with root package name */
    public com.badlogic.gdx.math.a f27280c;

    /* loaded from: classes3.dex */
    public static class a extends c.b.b.j.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f27281b;

        /* renamed from: c  reason: collision with root package name */
        public int f27282c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f27283d;

        public a() {
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
            this.f27281b = "i ";
            this.f27282c = 1024;
            this.f27283d = new String[]{"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.b.b.j.f.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.b.b.j.f.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27279b = new a();
        this.f27280c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.a
    /* renamed from: d */
    public c.b.b.q.a<c.b.b.j.a> a(String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar, aVar2)) == null) {
            if (aVar2 == null) {
                aVar2 = this.f27279b;
            }
            try {
                BufferedReader q = aVar.q(aVar2.f27282c);
                while (true) {
                    String readLine = q.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(aVar2.f27281b)) {
                            str2 = readLine.substring(aVar2.f27281b.length());
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                q.close();
                if (str2 == null && (strArr = aVar2.f27283d) != null) {
                    for (String str3 : strArr) {
                        c.b.b.m.a s = aVar.s(aVar.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 != null) {
                    c.b.b.q.a<c.b.b.j.a> aVar3 = new c.b.b.q.a<>(1);
                    aVar3.a(new c.b.b.j.a(aVar.s(str2), Texture.class));
                    return aVar3;
                }
                return null;
            } catch (IOException e2) {
                throw new GdxRuntimeException("Error reading " + str, e2);
            }
        }
        return (c.b.b.q.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.n
    /* renamed from: e */
    public e c(c.b.b.j.e eVar, String str, c.b.b.m.a aVar, a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, eVar, str, aVar, aVar2)) == null) ? f(new i((Texture) eVar.i(eVar.n(str).first())), aVar) : (e) invokeLLLL.objValue;
    }

    public e f(i iVar, c.b.b.m.a aVar) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, iVar, aVar)) == null) {
            BufferedReader q = aVar.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            i0.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + aVar);
                        }
                    } catch (IOException e2) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + aVar, e2);
                    }
                } finally {
                    i0.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i2 = 0; i2 < length; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            return new e(iVar, fArr, this.f27280c.c(fArr).f());
        }
        return (e) invokeLL.objValue;
    }
}
