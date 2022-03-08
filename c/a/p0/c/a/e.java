package c.a.p0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c.a.i.h;
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
    public static volatile e a;
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
            if (a == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e();
                    }
                }
            }
            return a;
        }
        return (e) invokeV.objValue;
    }

    public static byte[] g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)} : (byte[]) invokeI.objValue;
    }

    public byte[] b(h hVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hVar, str)) == null) {
            if (hVar == null) {
                return null;
            }
            try {
                c.a.p0.c.a.i.f a2 = c.a.p0.c.a.i.f.f9708j.a();
                a2.r((byte) 23);
                byte[] i2 = hVar.i();
                if (i2 != null && i2.length > 0 && i2.length <= 32767) {
                    a2.q((short) i2.length);
                    a2.o(i2);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, hVar.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(c.a.p0.q.j.j.b.e().d().longValue());
                return c.a.p0.c.a.j.b.b(a2);
            } catch (Exception e2) {
                if (a.a) {
                    e2.printStackTrace();
                    String str2 = "exception=" + e2.getMessage();
                    return null;
                }
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public c.a.p0.c.a.i.g c(h hVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bArr)) == null) {
            c.a.p0.c.a.i.g gVar = new c.a.p0.c.a.i.g();
            try {
                c.a.p0.c.a.i.f a2 = c.a.p0.c.a.j.b.a(bArr);
                byte i2 = a2.i();
                if (i2 == 21) {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.a) {
                            String str2 = "bdtls ubc application alert : " + str;
                        }
                        f.b(hVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            gVar.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            gVar.d(2);
                        } else {
                            gVar.d(-1);
                        }
                        if (a.a) {
                            if (parseFrom.getDescription() != null) {
                                if (a.a) {
                                    String str3 = "BdtlsPostRequest response alert message=" + str;
                                }
                            } else {
                                boolean z = a.a;
                            }
                        }
                    } else {
                        gVar.d(-1);
                    }
                } else if (i2 == 23) {
                    gVar.c(new String(AES.aesDecrypt(a2.a(), hVar.c())));
                    gVar.d(1);
                }
            } catch (Exception e2) {
                if (a.a) {
                    e2.printStackTrace();
                    String str4 = "exception=" + e2.getMessage();
                }
                gVar.d(-1);
            }
            return gVar;
        }
        return (c.a.p0.c.a.i.g) invokeLL.objValue;
    }

    public byte[] e(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
            if (hVar == null) {
                return null;
            }
            try {
                byte[] b2 = c.a.p0.c.a.j.a.b(hVar, new c.a.p0.c.a.i.e());
                if (b2 == null) {
                    return null;
                }
                c.a.p0.c.a.i.f a2 = c.a.p0.c.a.i.f.f9708j.a();
                a2.r((byte) 22);
                a2.q((short) b2.length);
                a2.l(c.a.p0.q.j.j.b.e().d().longValue());
                a2.o(b2);
                return c.a.p0.c.a.j.b.b(a2);
            } catch (Exception e2) {
                if (a.a) {
                    e2.printStackTrace();
                    String str = "exception=" + e2.getMessage();
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
