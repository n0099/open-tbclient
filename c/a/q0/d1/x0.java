package c.a.q0.d1;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class x0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Context context, Uri uri, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, uri, i2)) == null) {
            try {
                return BitmapHelper.subSampleBitmap(context, uri, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap b(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i2)) == null) {
            try {
                return BitmapHelper.loadResizedBitmap(str, i2, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap c(int i2, Context context, Uri uri, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), context, uri, str, Integer.valueOf(i3)})) == null) {
            if (i2 == 12001) {
                return d(i3);
            }
            if (!TextUtils.isEmpty(str)) {
                return b(context, str, i3);
            }
            return a(context, uri, i3);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            try {
                int e2 = e(FileHelper.getFileDireciory(SelectImageHelper.TMP_IMAGE_NAME));
                Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(SelectImageHelper.TMP_IMAGE_NAME, i2);
                return (e2 == 0 || subSampleBitmap == null) ? subSampleBitmap : BitmapHelper.rotateBitmapBydegree(subSampleBitmap, e2);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeI.objValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        return attributeInt != 8 ? 0 : 270;
                    }
                    return 90;
                }
                return 180;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
