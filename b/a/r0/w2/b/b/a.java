package b.a.r0.w2.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f25386a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-232021506, "Lb/a/r0/w2/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-232021506, "Lb/a/r0/w2/b/b/a;");
                return;
            }
        }
        f25386a = new EnumMap(DecodeHintType.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.PDF_417);
        f25386a.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        f25386a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        f25386a.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i2 = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i3 = options.outHeight / 800;
                if (i3 > 0) {
                    i2 = i3;
                }
                options.inSampleSize = i2;
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(str, options);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String b(Bitmap bitmap) {
        InterceptResult invokeL;
        RGBLuminanceSource rGBLuminanceSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] iArr = new int[width * height];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                rGBLuminanceSource = new RGBLuminanceSource(width, height, iArr);
            } catch (Exception e2) {
                e = e2;
                rGBLuminanceSource = null;
            }
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), f25386a).getText();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (rGBLuminanceSource != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), f25386a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? b(a(str)) : (String) invokeL.objValue;
    }
}
