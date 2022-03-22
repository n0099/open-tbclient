package com.baidu.ar.arplay.core.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.AssetUriLoader;
import java.io.IOException;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public class ARPFilter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ARPFilter";
    public transient /* synthetic */ FieldHolder $fh;
    public SoftReference<Context> softContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1158758278, "Lcom/baidu/ar/arplay/core/renderer/ARPFilter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1158758278, "Lcom/baidu/ar/arplay/core/renderer/ARPFilter;");
        }
    }

    public ARPFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.softContext = null;
    }

    private native void nativeAdjustFilterWithAssetTextureParam(String str, String str2, Bitmap bitmap);

    private native String nativeAdjustFilterWithCasePathParam(String str);

    private native void nativeAdjustFilterWithFloatArrayParam(String str, String str2, float[] fArr);

    private native void nativeAdjustFilterWithFloatParam(String str, String str2, float f2);

    private native void nativeAdjustFilterWithIntParam(String str, String str2, int i);

    private native String nativeAdjustFilterWithJsonPathParam(String str);

    private native void nativeAdjustFilterWithStringParam(String str, String str2, String str3);

    private native void nativeDisableCaseLutTexture();

    private native void nativeDisableFilterByAuthCode(int i);

    private native void nativeSetAuthPic(Bitmap bitmap, float[] fArr);

    private native void nativeSetWatermark(String str, Bitmap bitmap, float[] fArr);

    public String adjustFilterWithCasePathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? nativeAdjustFilterWithCasePathParam(str) : (String) invokeL.objValue;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, fArr, Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithFloatArrayParam(str, str2, fArr);
        }
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Float.valueOf(f2), Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithFloatParam(str, str2, f2);
        }
    }

    public void adjustFilterWithIntParam(String str, String str2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            nativeAdjustFilterWithIntParam(str, str2, i);
        }
    }

    public String adjustFilterWithJsonPathParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? nativeAdjustFilterWithJsonPathParam(str) : (String) invokeL.objValue;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        SoftReference<Context> softReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Long.valueOf(j)}) == null) {
            if (!str3.contains(AssetUriLoader.ASSET_PATH_SEGMENT) || (softReference = this.softContext) == null || softReference.get() == null || this.softContext.get().getAssets() == null) {
                nativeAdjustFilterWithStringParam(str, str2, str3);
                return;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(this.softContext.get().getAssets().open(str3.substring(str3.lastIndexOf(AssetUriLoader.ASSET_PATH_SEGMENT) + 13 + 1)));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (bitmap != null) {
                String str4 = "texture_width";
                String str5 = "texture_height";
                String str6 = "texture_byte_array";
                if (str2.contains("/")) {
                    String substring = str2.substring(0, str2.lastIndexOf("/") + 1);
                    str4 = substring + "texture_width";
                    str5 = substring + "texture_height";
                    str6 = substring + "texture_byte_array";
                }
                nativeAdjustFilterWithFloatParam(str, str4, bitmap.getWidth());
                nativeAdjustFilterWithFloatParam(str, str5, bitmap.getHeight());
                nativeAdjustFilterWithAssetTextureParam(str, str6, bitmap);
                bitmap.recycle();
            }
        }
    }

    public void destroy() {
        SoftReference<Context> softReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (softReference = this.softContext) == null) {
            return;
        }
        softReference.clear();
        this.softContext = null;
    }

    public void disableCaseLutTexture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            nativeDisableCaseLutTexture();
        }
    }

    public void disableFilterByAuthCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            nativeDisableFilterByAuthCode(i);
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bitmap, fArr) == null) {
            nativeSetAuthPic(bitmap, fArr);
        }
    }

    public void setContext(SoftReference<Context> softReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, softReference) == null) || softReference == null) {
            return;
        }
        this.softContext = softReference;
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bitmap, fArr) == null) {
            nativeSetWatermark(str, bitmap, fArr);
        }
    }
}
