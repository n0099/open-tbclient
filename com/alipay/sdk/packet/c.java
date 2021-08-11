package com.alipay.sdk.packet;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f35790a;

    /* renamed from: b  reason: collision with root package name */
    public String f35791b;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35790a = z;
        this.f35791b = k.a(24);
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bArr, str2)) == null) ? com.alipay.sdk.encrypt.e.b(str, bArr, str2) : (byte[]) invokeLLL.objValue;
    }

    public d a(b bVar, boolean z, String str) {
        InterceptResult invokeCommon;
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bVar, Boolean.valueOf(z), str})) == null) {
            if (bVar == null) {
                return null;
            }
            byte[] bytes = bVar.a().getBytes();
            byte[] bytes2 = bVar.b().getBytes();
            if (z) {
                try {
                    bytes2 = com.alipay.sdk.encrypt.b.a(bytes2);
                } catch (Exception unused) {
                    z = false;
                }
            }
            if (this.f35790a) {
                a2 = a(bytes, a(this.f35791b, com.alipay.sdk.cons.a.f35712e), a(this.f35791b, bytes2, str));
            } else {
                a2 = a(bytes, bytes2);
            }
            return new d(z, a2);
        }
        return (d) invokeCommon.objValue;
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
                byteArrayInputStream = new ByteArrayInputStream(dVar.b());
                try {
                    try {
                        byte[] bArr = new byte[5];
                        byteArrayInputStream.read(bArr);
                        byte[] bArr2 = new byte[a(new String(bArr))];
                        byteArrayInputStream.read(bArr2);
                        str2 = new String(bArr2);
                    } catch (Exception e2) {
                        e = e2;
                        str2 = null;
                    }
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int a2 = a(new String(bArr3));
                        if (a2 > 0) {
                            byte[] bArr4 = new byte[a2];
                            byteArrayInputStream.read(bArr4);
                            if (this.f35790a) {
                                bArr4 = b(this.f35791b, bArr4, str);
                            }
                            if (dVar.a()) {
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
                    } catch (Exception e3) {
                        e = e3;
                        com.alipay.sdk.util.c.a(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        str3 = null;
                        if (str2 == null) {
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
            } catch (Exception e4) {
                e = e4;
                byteArrayInputStream = null;
                str2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream2 != null) {
                }
                throw th;
            }
            if (str2 == null || str3 != null) {
                return new b(str2, str3);
            }
            return null;
        }
        return (b) invokeLL.objValue;
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? com.alipay.sdk.encrypt.d.a(str, str2) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr, str2)) == null) ? com.alipay.sdk.encrypt.e.a(str, bArr, str2) : (byte[]) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[]... bArr) {
        InterceptResult invokeL;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        r0 = null;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        } catch (Throwable th) {
            th = th;
            dataOutputStream = null;
            if (byteArrayOutputStream2 != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
        try {
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                try {
                    for (byte[] bArr3 : bArr) {
                        dataOutputStream.write(a(bArr3.length).getBytes());
                        dataOutputStream.write(bArr3);
                    }
                    dataOutputStream.flush();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.alipay.sdk.util.c.a(e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
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
        } catch (Exception e4) {
            e = e4;
            dataOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
        try {
            dataOutputStream.close();
        } catch (Exception unused5) {
            return bArr2;
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? String.format(Locale.getDefault(), "%05d", Integer.valueOf(i2)) : (String) invokeI.objValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? Integer.parseInt(str) : invokeL.intValue;
    }
}
