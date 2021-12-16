package c.a.q0.w;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException unused) {
                i2 = 0;
            }
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                d.d(byteArrayOutputStream);
                return byteArray;
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                byte[] a = a(inputStream);
                if (a != null) {
                    String str = new String(a);
                    if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                        str = str.substring(1);
                    }
                    d.d(inputStream);
                    return str;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.d(inputStream);
                throw th;
            }
            d.d(inputStream);
            return null;
        }
        return (String) invokeL.objValue;
    }
}
