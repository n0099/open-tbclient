package com.alipay.sdk.packet;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.n;
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
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1938a;

    /* renamed from: b  reason: collision with root package name */
    public String f1939b;

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
        this.f1938a = z;
        this.f1939b = n.a(24);
    }

    public static byte[] b(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bArr)) == null) ? com.alipay.sdk.encrypt.e.b(str, bArr) : (byte[]) invokeLL.objValue;
    }

    public d a(b bVar, boolean z) {
        InterceptResult invokeLZ;
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, z)) == null) {
            if (bVar == null) {
                return null;
            }
            byte[] bytes = bVar.a().getBytes();
            byte[] bytes2 = bVar.b().getBytes();
            if (z) {
                try {
                    bytes2 = com.alipay.sdk.encrypt.c.a(bytes2);
                } catch (Exception unused) {
                    z = false;
                }
            }
            if (this.f1938a) {
                a2 = a(bytes, a(this.f1939b, com.alipay.sdk.cons.a.f1867c), a(this.f1939b, bytes2));
            } else {
                a2 = a(bytes, bytes2);
            }
            return new d(z, a2);
        }
        return (d) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(d dVar) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(dVar.b());
                try {
                    try {
                        byte[] bArr = new byte[5];
                        byteArrayInputStream.read(bArr);
                        byte[] bArr2 = new byte[a(new String(bArr))];
                        byteArrayInputStream.read(bArr2);
                        str = new String(bArr2);
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    }
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int a2 = a(new String(bArr3));
                        if (a2 > 0) {
                            byte[] bArr4 = new byte[a2];
                            byteArrayInputStream.read(bArr4);
                            if (this.f1938a) {
                                bArr4 = b(this.f1939b, bArr4);
                            }
                            if (dVar.a()) {
                                bArr4 = com.alipay.sdk.encrypt.c.b(bArr4);
                            }
                            str2 = new String(bArr4);
                        } else {
                            str2 = null;
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
                        str2 = null;
                        if (str == null) {
                        }
                        return new b(str, str2);
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
                str = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream2 != null) {
                }
                throw th;
            }
            if (str == null || str2 != null) {
                return new b(str, str2);
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? com.alipay.sdk.encrypt.d.a(str, str2) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) ? com.alipay.sdk.encrypt.e.a(str, bArr) : (byte[]) invokeLL.objValue;
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
