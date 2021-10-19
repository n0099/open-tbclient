package c.a.z.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends GZIPOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                ((GZIPOutputStream) this).def.setLevel(i2);
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            byte[] bArr2 = new byte[bArr.length];
            byte[] bArr3 = {26, 31, -22, -104, 118, 81, -16, 6, 90, -75, ByteCompanionObject.MIN_VALUE, -40, 85, 92, 106, 114, -20, 34, 116, 13, -70, -77, 122, -71, -84, -25, -42, 99, 42, 100, 19, -37, -99, 32, -17, 70, -124, -24, -114, -120, 24, 73, -103, 3, -44, 1, 52, 91, 17, 40, -21, 66, -91, 21, 16, -59, 80, 49, StandardMessageCodec.LIST, -123, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, -92, 68, 102, Constants.SHORT_PING_CMD_TYPE, -6, -72, -89, -107, 10, 126, -102, -98, -52, -64, 120, -32, -55, -80, 98, 55, -85, 36, 47, -101, 84, -90, 121, 125, -28, 46, -63, 83, -113, 61, -67, -57, -15, 22, -19, 94, 28, -46, 97, 43, ByteCompanionObject.MAX_VALUE, -9, 20, 112, -54, 11, -68, -2, -112, -79, -47, -13, 109, 27, -116, -96, -115, -18, -100, 5, Base64.INTERNAL_PADDING, 67, 48, 82, -23, 88, -66, -38, 50, 23, -4, -48, -58, -51, -29, -78, 115, -122, 69, -34, -86, 74, -50, -87, -1, -121, 124, 71, -126, 7, 62, 56, -94, 77, -110, -27, 30, -83, -62, 0, 18, 39, 104, 29, 78, 25, -41, 2, -65, -8, -3, 89, 41, -56, 58, -45, 79, 14, 96, 72, -26, -14, -82, 15, 108, -30, -97, -108, -109, 54, -73, -11, 38, -61, -33, 59, -49, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, -95, 9, 87, 110, -125, -105, 86, UtilsBlink.VER_TYPE_SEPARATOR, 60, -81, -39, -43, -31, -53, 63, -88, 76, -10, 8, 53, 93, 75, -60, 111, 105, -127, 103, -111, -93, 95, 64, -69, -106, -7, 113, 4, -5, -74, 44, -117, -12, -35, 51, 119, 65, PublicSuffixDatabase.EXCEPTION_MARKER, -36, 107, -119, 57, -118, -76, 37};
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                i2 = (i2 + 1) & 255;
                i3 = (bArr3[i2] + i3) & 255;
                byte b2 = bArr3[i2];
                bArr3[i2] = bArr3[i3];
                bArr3[i3] = b2;
                bArr2[i4] = (byte) (bArr[i4] ^ bArr3[(bArr3[i2] + bArr3[i3]) & 255]);
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a aVar = new a(byteArrayOutputStream);
            aVar.a(9);
            aVar.write(bArr);
            aVar.close();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
