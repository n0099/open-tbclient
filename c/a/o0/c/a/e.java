package c.a.o0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f10290a;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public static int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null) {
                int i2 = 0;
                for (byte b2 : bArr) {
                    i2 = (i2 << 8) | (b2 & 255);
                }
                return i2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(bArr[i2] > 0 ? bArr[i2] : bArr[i2] & 255);
                sb.append(",");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f10290a == null) {
                synchronized (e.class) {
                    if (f10290a == null) {
                        f10290a = new e();
                    }
                }
            }
            return f10290a;
        }
        return (e) invokeV.objValue;
    }

    public static byte[] g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)} : (byte[]) invokeI.objValue;
    }

    public byte[] b(c.a.o0.c.a.i.g gVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, str)) == null) {
            if (gVar == null) {
                return null;
            }
            try {
                c.a.o0.c.a.i.e a2 = c.a.o0.c.a.i.e.f10306j.a();
                a2.r((byte) 23);
                byte[] i2 = gVar.i();
                if (i2 != null && i2.length > 0 && i2.length <= 32767) {
                    a2.q((short) i2.length);
                    a2.o(i2);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, gVar.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(c.a.o0.n.j.j.b.c().b().longValue());
                return c.a.o0.c.a.j.b.b(a2);
            } catch (Exception e2) {
                if (a.f10283a) {
                    e2.printStackTrace();
                    String str2 = "exception=" + e2.getMessage();
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public c.a.o0.c.a.i.f c(c.a.o0.c.a.i.g gVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, bArr)) == null) {
            c.a.o0.c.a.i.f fVar = new c.a.o0.c.a.i.f();
            try {
                c.a.o0.c.a.i.e a2 = c.a.o0.c.a.j.b.a(bArr);
                byte i2 = a2.i();
                if (i2 == 21) {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.f10283a) {
                            String str2 = "bdtls ubc application alert : " + str;
                        }
                        f.b(gVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            fVar.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            fVar.d(2);
                        } else {
                            fVar.d(-1);
                        }
                        if (a.f10283a) {
                            if (parseFrom.getDescription() != null) {
                                if (a.f10283a) {
                                    String str3 = "BdtlsPostRequest response alert message=" + str;
                                }
                            } else {
                                boolean z = a.f10283a;
                            }
                        }
                    } else {
                        fVar.d(-1);
                    }
                } else if (i2 == 23) {
                    fVar.c(new String(AES.aesDecrypt(a2.a(), gVar.c())));
                    fVar.d(1);
                }
            } catch (Exception e2) {
                if (a.f10283a) {
                    e2.printStackTrace();
                    String str4 = "exception=" + e2.getMessage();
                }
                fVar.d(-1);
            }
            return fVar;
        }
        return (c.a.o0.c.a.i.f) invokeLL.objValue;
    }

    public byte[] e(c.a.o0.c.a.i.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            try {
                byte[] b2 = c.a.o0.c.a.j.a.b(gVar, new c.a.o0.c.a.i.d());
                if (b2 == null) {
                    return null;
                }
                c.a.o0.c.a.i.e a2 = c.a.o0.c.a.i.e.f10306j.a();
                a2.r((byte) 22);
                a2.q((short) b2.length);
                a2.l(c.a.o0.n.j.j.b.c().b().longValue());
                a2.o(b2);
                return c.a.o0.c.a.j.b.b(a2);
            } catch (Exception e2) {
                if (a.f10283a) {
                    e2.printStackTrace();
                    String str = "exception=" + e2.getMessage();
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
