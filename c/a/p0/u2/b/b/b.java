package c.a.p0.u2.b.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<EncodeHintType, Object> f24628a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1680779460, "Lc/a/p0/u2/b/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1680779460, "Lc/a/p0/u2/b/b/b;");
                return;
            }
        }
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        f24628a = enumMap;
        enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) "utf-8");
        f24628a.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        f24628a.put(EncodeHintType.MARGIN, 0);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bitmap, bitmap2)) == null) {
            if (bitmap == null || bitmap2 == null) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = bitmap2.getWidth();
            int height2 = bitmap2.getHeight();
            float f2 = ((width * 1.0f) / 5.0f) / width2;
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f2, f2, width / 2, height / 2);
                canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
                canvas.save();
                canvas.restore();
                return createBitmap;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) ? c(str, i2, -16777216, -1, null) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap c(String str, int i2, int i3, int i4, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bitmap})) == null) {
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i2, i2, f24628a);
                int[] iArr = new int[i2 * i2];
                for (int i5 = 0; i5 < i2; i5++) {
                    for (int i6 = 0; i6 < i2; i6++) {
                        if (encode.get(i6, i5)) {
                            iArr[(i5 * i2) + i6] = i3;
                        } else {
                            iArr[(i5 * i2) + i6] = i4;
                        }
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i2);
                return a(createBitmap, bitmap);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
