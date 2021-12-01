package com.baidu.sofire.utility;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.protect.crypto.WBAESCipherImplement;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class WbEncryptUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUF_LEN = 1024;
    public static c.a.h0.a.a mWbaes;
    public transient /* synthetic */ FieldHolder $fh;

    public WbEncryptUtil() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    public static byte[] loadAssertFile(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                inputStream = context.getAssets().open(str);
            } catch (Throwable unused) {
                inputStream = null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable unused2) {
                try {
                    c.a();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                            c.a();
                        }
                    }
                    return new byte[0];
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                            c.a();
                        }
                    }
                }
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static synchronized void loadKey(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (WbEncryptUtil.class) {
                if (mWbaes == null) {
                    c.a.h0.a.a c2 = WBAESCipherImplement.c();
                    byte[] loadAssertFile = loadAssertFile(context, "pass-key.face-android");
                    if (loadAssertFile != null && loadAssertFile.length > 0) {
                        mWbaes = c2;
                        c2.a(loadAssertFile);
                    }
                }
            }
        }
    }

    public static int wbEncrypt(Context context, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, bArr, bArr2)) == null) {
            if (bArr != null && bArr.length > 0) {
                if (mWbaes == null) {
                    loadKey(context);
                }
                if (mWbaes == null) {
                    return -1;
                }
                int length = 16 - (bArr.length % 16);
                byte b2 = (byte) length;
                int length2 = bArr.length + length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                for (int i2 = 0; i2 < length; i2++) {
                    bArr3[bArr.length + i2] = b2;
                }
                if (bArr2.length < length2) {
                    return -1;
                }
                try {
                    mWbaes.b(bArr3, bArr2, length2);
                    return length2;
                } catch (Throwable unused) {
                    c.a();
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static byte[] wbEncrypt(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return new byte[0];
            }
            if (mWbaes == null) {
                loadKey(context);
            }
            if (mWbaes == null) {
                return new byte[0];
            }
            int length = 16 - (bArr.length % 16);
            byte b2 = (byte) length;
            int length2 = bArr.length + length;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            for (int i2 = 0; i2 < length; i2++) {
                bArr2[bArr.length + i2] = b2;
            }
            byte[] bArr3 = new byte[length2];
            try {
                mWbaes.b(bArr2, bArr3, length2);
            } catch (com.baidu.protect.crypto.b unused) {
                c.a();
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
