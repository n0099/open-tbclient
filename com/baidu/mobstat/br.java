package com.baidu.mobstat;

import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes4.dex */
public final class br {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658338, "Lcom/baidu/mobstat/br;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658338, "Lcom/baidu/mobstat/br;");
                return;
            }
        }
        a = new String[]{"h9YLQoINGWyOBYYk", "30212102dicudiab", "dm1VEmW651QTz4MD"};
    }

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -79, 21, -34, -73, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, -48, -29, 119, 8, -81, -27, -81, -127, -98, -68, -45, -22, ByteCompanionObject.MAX_VALUE, -82, 126, -122, 87, 8, 122, -21, 108, 69, -10, 70, -1, ContentUtil.GZIP_HEAD_2, 11, 90, -11, -5, -4, -53, 90, 78, 94, -62, 45, 28, -121, -10, 34, -31, -95, 54, -76, -88, 20, 30, -4, Cea608Decoder.CTRL_END_OF_CAPTION, -68, 60, 18, -102, 111, 86, -109, -49, -114, -41, 27, -72, 83, 59, -26, -89, -114, -12, -78, 86, 84, -111, -23, 118, 122, 72, 68, 124, 3, -122, -24, -14, 75, -73, -20, -21, -122, 49, -101, 53, -109, -61, 8, 10, 82, 0, -100, -94, -62, -83, Base64.INTERNAL_PADDING, -93, ContentUtil.GZIP_HEAD_1, 40, 66, -80, ByteCompanionObject.MAX_VALUE, -25, -39, -64, -7, 34, -76, 119, 108, -33, -26, -29, -15, ContentUtil.GZIP_HEAD_1, 69, -89, 91, 2, 3, 1, 0, 1} : (byte[]) invokeV.objValue;
    }
}
