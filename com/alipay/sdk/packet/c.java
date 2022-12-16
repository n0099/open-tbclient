package com.alipay.sdk.packet;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
        this.b = l.a(24);
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return Integer.parseInt(str);
        }
        return invokeL.intValue;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
        }
        return (String) invokeI.objValue;
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            return com.alipay.sdk.encrypt.d.a(str, str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr, str2)) == null) {
            return com.alipay.sdk.encrypt.e.a(str, bArr, str2);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, bArr, str2)) == null) {
            return com.alipay.sdk.encrypt.e.b(str, bArr, str2);
        }
        return (byte[]) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[]... bArr) {
        InterceptResult invokeL;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            r0 = null;
            byte[] bArr2 = null;
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    try {
                        try {
                            for (byte[] bArr3 : bArr) {
                                dataOutputStream.write(a(bArr3.length).getBytes());
                                dataOutputStream.write(bArr3);
                            }
                            dataOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                            bArr2 = byteArray;
                        } catch (Exception e) {
                            e = e;
                            com.alipay.sdk.util.c.a(e);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                if (byteArrayOutputStream2 != null) {
                }
                if (dataOutputStream != null) {
                }
                throw th;
            }
            try {
                dataOutputStream.close();
            } catch (Exception unused5) {
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(d dVar, String str) {
        InterceptResult invokeLL;
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, str)) == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(dVar.a());
                try {
                    try {
                        byte[] bArr = new byte[5];
                        byteArrayInputStream.read(bArr);
                        byte[] bArr2 = new byte[a(new String(bArr))];
                        byteArrayInputStream.read(bArr2);
                        str2 = new String(bArr2);
                    } catch (Exception e) {
                        e = e;
                        str2 = null;
                    }
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int a = a(new String(bArr3));
                        if (a > 0) {
                            byte[] bArr4 = new byte[a];
                            byteArrayInputStream.read(bArr4);
                            if (this.a) {
                                bArr4 = a(this.b, bArr4, str);
                            }
                            if (dVar.b()) {
                                bArr4 = com.alipay.sdk.encrypt.b.b(bArr4);
                            }
                            str3 = new String(bArr4);
                        } else {
                            str3 = null;
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.alipay.sdk.util.c.a(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        str3 = null;
                        if (str2 != null) {
                        }
                        return new b(str2, str3);
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayInputStream = null;
                str2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream2 != null) {
                }
                throw th;
            }
            if (str2 != null && str3 == null) {
                return null;
            }
            return new b(str2, str3);
        }
        return (b) invokeLL.objValue;
    }

    public d a(b bVar, boolean z, String str) {
        InterceptResult invokeCommon;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Boolean.valueOf(z), str})) == null) {
            if (bVar == null) {
                return null;
            }
            byte[] bytes = bVar.b().getBytes();
            byte[] bytes2 = bVar.a().getBytes();
            if (z) {
                try {
                    bytes2 = com.alipay.sdk.encrypt.b.a(bytes2);
                } catch (Exception unused) {
                    z = false;
                }
            }
            if (this.a) {
                a = a(bytes, a(this.b, com.alipay.sdk.cons.a.e), b(this.b, bytes2, str));
            } else {
                a = a(bytes, bytes2);
            }
            return new d(z, a);
        }
        return (d) invokeCommon.objValue;
    }
}
