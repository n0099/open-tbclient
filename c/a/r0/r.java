package c.a.r0;

import android.text.TextUtils;
import c.a.d.f.p.t;
import c.a.d.f.p.v;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
                try {
                    PublicKey e2 = v.e(c.a.d.f.p.e.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
                    if (e2 == null) {
                        TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "publicKeyCode is null").param("obj_source", file.getName()));
                        return false;
                    }
                    byte[] b2 = b(str);
                    if (b2 != null && b2.length > 0) {
                        byte[] b3 = v.b(e2, b2);
                        if (b3 != null && b3.length > 0) {
                            String trim = new String(b3, "UTF-8").trim();
                            String b4 = t.b(new FileInputStream(file));
                            if (b4 != null) {
                                b4 = b4.trim();
                            }
                            if (!TextUtils.isEmpty(b4) && !TextUtils.isEmpty(trim)) {
                                if (b4.equalsIgnoreCase(trim)) {
                                    return true;
                                }
                                TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "apkMd5 != serverMD5").param("obj_source", file.getName()));
                                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                                return false;
                            }
                            TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "apkMd5 or serverMD5 is null").param("obj_source", file.getName()));
                            return false;
                        }
                        TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "des is null").param("obj_source", file.getName()));
                        return false;
                    }
                    TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "server_data is null").param("obj_source", file.getName()));
                    return false;
                } catch (Exception e3) {
                    StatisticItem statisticItem = new StatisticItem("c10836");
                    TiebaStatic.log(statisticItem.param("obj_type", "exception:" + e3.getMessage()).param("obj_source", file.getName()));
                    BdLog.e("download MD5 RSA ERROR！Exception:" + e3.getMessage() + " ; file:" + file.getName());
                    return false;
                }
            }
            TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "checkRSA input args is null"));
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                char[] charArray = str.toCharArray();
                int length = charArray.length / 2;
                byte[] bArr = new byte[length];
                if (charArray.length % 2 != 0) {
                    return null;
                }
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i4 >= charArray.length || i3 >= length) {
                        break;
                    }
                    bArr[i3] = (byte) ((c(charArray[i2]) << 4) | c(charArray[i4]));
                    i3++;
                    i2 = i4 + 1;
                }
                return bArr;
            }
            throw new IllegalArgumentException("binary string is null");
        }
        return (byte[]) invokeL.objValue;
    }

    public static int c(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) {
            int digit = Character.digit(c2, 16);
            if (digit != -1) {
                return digit;
            }
            throw new RuntimeException("Illegal hexadecimal character " + c2);
        }
        return invokeCommon.intValue;
    }
}
