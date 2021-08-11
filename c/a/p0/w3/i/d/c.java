package c.a.p0.w3.i.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f27926a;

        /* renamed from: b  reason: collision with root package name */
        public int f27927b;

        /* renamed from: c  reason: collision with root package name */
        public int f27928c;

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27926a = i2;
            this.f27927b = i3;
        }
    }

    public static boolean a(Bitmap bitmap, ArrayList<a> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bitmap, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0 || bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int i2 = next.f27926a;
                int i3 = next.f27927b;
                if (i2 >= bitmap.getWidth() || i3 >= bitmap.getHeight()) {
                    return false;
                }
                int pixel = bitmap.getPixel(i2, i3);
                if (sparseArray.get(pixel) != null) {
                    return false;
                }
                next.f27928c = pixel;
                sparseArray.put(pixel, next);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i2, i3)) == null) {
            Bitmap bitmap = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, 17, i2, i3, null).compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
                bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.close();
                return bitmap;
            } catch (Throwable th) {
                th.printStackTrace();
                return bitmap;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(UtilHelper.getUriFromFile(new File(str), intent, context));
                context.sendBroadcast(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(byte[] bArr, int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, bArr, iArr, i2, i3) == null) {
            int i4 = i2 * i3;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = 0;
                while (i8 < i2) {
                    int i9 = iArr[i6];
                    int i10 = (iArr[i6] & 16711680) >> 16;
                    int i11 = (iArr[i6] & 65280) >> 8;
                    int i12 = 255;
                    int i13 = (iArr[i6] & 255) >> 0;
                    int i14 = (((((i10 * 66) + (i11 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                    int i15 = (((((i10 * (-38)) - (i11 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                    int i16 = (((((i10 * 112) - (i11 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                    int i17 = i5 + 1;
                    if (i14 < 0) {
                        i14 = 0;
                    } else if (i14 > 255) {
                        i14 = 255;
                    }
                    bArr[i5] = (byte) i14;
                    if (i7 % 2 == 0 && i6 % 2 == 0) {
                        int i18 = i4 + 1;
                        if (i16 < 0) {
                            i16 = 0;
                        } else if (i16 > 255) {
                            i16 = 255;
                        }
                        bArr[i4] = (byte) i16;
                        i4 = i18 + 1;
                        if (i15 < 0) {
                            i12 = 0;
                        } else if (i15 <= 255) {
                            i12 = i15;
                        }
                        bArr[i18] = (byte) i12;
                    }
                    i6++;
                    i8++;
                    i5 = i17;
                }
            }
        }
    }

    public static byte[] e(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) ? g(bitmap.getWidth(), bitmap.getHeight(), bitmap) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.util.ArrayList<c.a.p0.w3.i.d.c$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<a> f(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap)) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                SparseArray sparseArray = new SparseArray();
                int i2 = 0;
                loop0: for (int i3 = 0; i3 < width; i3++) {
                    for (int i4 = 0; i4 < height; i4++) {
                        int pixel = bitmap.getPixel(i3, i4);
                        a aVar = new a(i3, i4);
                        if (sparseArray.get(pixel) == null) {
                            sparseArray.put(pixel, aVar);
                            i2++;
                        }
                        if (i2 == 3) {
                            break loop0;
                        }
                    }
                }
                ArrayList<a> arrayList = new ArrayList<>();
                for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                    arrayList.add(sparseArray.valueAt(i5));
                }
                return arrayList;
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeL.objValue;
    }

    public static byte[] g(int i2, int i3, Bitmap bitmap) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, bitmap)) == null) {
            int i4 = i2 * i3;
            try {
                int[] iArr = new int[i4];
                bitmap.getPixels(iArr, 0, i2, 0, 0, i2, i3);
                byte[] bArr = new byte[(i4 * 3) / 2];
                d(bArr, iArr, i2, i3);
                return bArr;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static Bitmap h(Bitmap bitmap, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, bitmap, f2)) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(f2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeLF.objValue;
    }
}
