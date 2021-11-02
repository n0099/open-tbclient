package b.a.p0.f.i.r;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9900a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9901b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1734367122, "Lb/a/p0/f/i/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1734367122, "Lb/a/p0/f/i/r/a;");
                return;
            }
        }
        f9900a = new byte[]{48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, UtilsBlink.VER_TYPE_SEPARATOR, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
        f9901b = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = f9900a;
            if (i2 >= bArr.length) {
                return;
            }
            f9901b[bArr[i2]] = (byte) i2;
            i2++;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
                str = str + "$";
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(bytes.length / 3) * 4];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bytes.length) {
                byte[] bArr2 = f9900a;
                bArr[i3] = bArr2[(bytes[i2] & 252) >> 2];
                int i4 = i2 + 1;
                bArr[i3 + 1] = bArr2[((bytes[i2] & 3) << 4) + ((bytes[i4] & 240) >> 4)];
                int i5 = i2 + 2;
                bArr[i3 + 2] = bArr2[((bytes[i4] & 15) << 2) + ((bytes[i5] & ExifInterface.MARKER_SOF0) >> 6)];
                bArr[i3 + 3] = bArr2[bytes[i5] & 63];
                i2 += 3;
                i3 += 4;
            }
            return new String(bArr);
        }
        return (String) invokeL.objValue;
    }
}
