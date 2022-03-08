package c.a.t0.q0;

import c.a.t0.b0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(984618617, "Lc/a/t0/q0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(984618617, "Lc/a/t0/q0/e;");
                return;
            }
        }
        a = b0.m();
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    i2 = inputStream.read(bArr, 0, 1024);
                } catch (IOException e2) {
                    if (a) {
                        e2.toString();
                    }
                    i2 = 0;
                }
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                if (a) {
                    e3.toString();
                }
            }
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, SGET, MOVE_EXCEPTION, INVOKE, INVOKE, IF, SGET, MOVE_EXCEPTION] complete} */
    public static String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                try {
                    byte[] a2 = a(inputStream);
                    if (a2 != null) {
                        String str = new String(a2);
                        if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                            str = str.substring(1);
                        }
                        return str;
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (Exception e2) {
                            e = e2;
                            if (!a) {
                                return null;
                            }
                            e.toString();
                            return null;
                        }
                    } else {
                        return null;
                    }
                } catch (Exception unused) {
                    boolean z = a;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (Exception e3) {
                            e = e3;
                            if (!a) {
                                return null;
                            }
                            e.toString();
                            return null;
                        }
                    }
                    return null;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        if (a) {
                            e4.toString();
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }
}
