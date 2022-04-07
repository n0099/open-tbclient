package com.baidu.sofire.utility;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.protect.crypto.facect.Cipher;
import com.baidu.protect.crypto.facect.WBAESException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class WbEncryptUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUF_LEN = 1024;
    public static final String TAG = "WbaesLib";
    public static Cipher mWbaes;
    public static String sKeyPath;
    public transient /* synthetic */ FieldHolder $fh;

    public WbEncryptUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void handleException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, th) == null) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static byte[] loadAssertFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
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
            } catch (Throwable th) {
                try {
                    handleException(th);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            handleException(th2);
                        }
                    }
                    return new byte[0];
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            handleException(th3);
                        }
                    }
                }
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static synchronized void loadKey(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (WbEncryptUtil.class) {
                if (mWbaes == null) {
                    Cipher cipher = Cipher.getInstance("WBAES", null);
                    byte[] loadPathFile = !TextUtils.isEmpty(sKeyPath) ? loadPathFile(sKeyPath) : null;
                    if (loadPathFile == null || loadPathFile.length <= 0) {
                        loadPathFile = loadAssertFile(context, "pass-key.face-android");
                    }
                    if (loadPathFile != null && loadPathFile.length > 0) {
                        mWbaes = cipher;
                        cipher.initKeyFromMemory(loadPathFile, null);
                    }
                }
            }
        }
    }

    public static byte[] loadPathFile(String str) {
        InterceptResult invokeL;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        handleException(th2);
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        handleException(th);
                        return new byte[0];
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th4) {
                                handleException(th4);
                            }
                        }
                    }
                }
            }
            return new byte[0];
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
    }

    public static void setKeyPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            sKeyPath = str;
        }
    }

    public static int wbEncrypt(Context context, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, bArr, bArr2)) == null) {
            if (bArr != null && bArr.length > 0) {
                if (mWbaes == null) {
                    loadKey(context);
                }
                if (mWbaes == null) {
                    return -1;
                }
                int length = 16 - (bArr.length % 16);
                byte b = (byte) length;
                int length2 = bArr.length + length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                for (int i = 0; i < length; i++) {
                    bArr3[bArr.length + i] = b;
                }
                if (bArr2.length < length2) {
                    return -1;
                }
                try {
                    mWbaes.encrypt(bArr3, bArr2, length2);
                    return length2;
                } catch (Throwable th) {
                    handleException(th);
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static byte[] wbEncrypt(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, bArr)) == null) {
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
            byte b = (byte) length;
            int length2 = bArr.length + length;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            for (int i = 0; i < length; i++) {
                bArr2[bArr.length + i] = b;
            }
            byte[] bArr3 = new byte[length2];
            try {
                mWbaes.encrypt(bArr2, bArr3, length2);
            } catch (WBAESException e) {
                handleException(e);
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
