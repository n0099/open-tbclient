package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PaintCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EM_STRING = "m";
    public static final String TOFU_STRING = "\udfffd";
    public static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2129091465, "Landroidx/core/graphics/PaintCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2129091465, "Landroidx/core/graphics/PaintCompat;");
                return;
            }
        }
        sRectThreadLocal = new ThreadLocal<>();
    }

    public PaintCompat() {
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

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, paint, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return paint.hasGlyph(str);
            }
            int length = str.length();
            if (length == 1 && Character.isWhitespace(str.charAt(0))) {
                return true;
            }
            float measureText = paint.measureText(TOFU_STRING);
            float measureText2 = paint.measureText("m");
            float measureText3 = paint.measureText(str);
            float f2 = 0.0f;
            if (measureText3 == 0.0f) {
                return false;
            }
            if (str.codePointCount(0, str.length()) > 1) {
                if (measureText3 > measureText2 * 2.0f) {
                    return false;
                }
                int i2 = 0;
                while (i2 < length) {
                    int charCount = Character.charCount(str.codePointAt(i2)) + i2;
                    f2 += paint.measureText(str, i2, charCount);
                    i2 = charCount;
                }
                if (measureText3 >= f2) {
                    return false;
                }
            }
            if (measureText3 != measureText) {
                return true;
            }
            Pair<Rect, Rect> obtainEmptyRects = obtainEmptyRects();
            paint.getTextBounds(TOFU_STRING, 0, 2, obtainEmptyRects.first);
            paint.getTextBounds(str, 0, length, obtainEmptyRects.second);
            return !obtainEmptyRects.first.equals(obtainEmptyRects.second);
        }
        return invokeLL.booleanValue;
    }

    public static Pair<Rect, Rect> obtainEmptyRects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Pair<Rect, Rect> pair = sRectThreadLocal.get();
            if (pair == null) {
                Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
                sRectThreadLocal.set(pair2);
                return pair2;
            }
            pair.first.setEmpty();
            pair.second.setEmpty();
            return pair;
        }
        return (Pair) invokeV.objValue;
    }

    public static boolean setBlendMode(@NonNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, paint, blendModeCompat)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                paint.setBlendMode(blendModeCompat != null ? BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat) : null);
                return true;
            } else if (blendModeCompat != null) {
                PorterDuff.Mode obtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
                paint.setXfermode(obtainPorterDuffFromCompat != null ? new PorterDuffXfermode(obtainPorterDuffFromCompat) : null);
                return obtainPorterDuffFromCompat != null;
            } else {
                paint.setXfermode(null);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
