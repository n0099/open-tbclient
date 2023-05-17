package com.baidu.android.ext.widget.iconfont;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class TypefaceCache {
    public static /* synthetic */ Interceptable $ic;
    public static final LruCache<String, Typeface> sCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1119119688, "Lcom/baidu/android/ext/widget/iconfont/TypefaceCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1119119688, "Lcom/baidu/android/ext/widget/iconfont/TypefaceCache;");
                return;
            }
        }
        sCache = new LruCache<>(10);
    }

    public TypefaceCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Typeface getCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return sCache.get(str);
        }
        return (Typeface) invokeL.objValue;
    }

    public static Typeface getTypeface(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            if (i > 0 && context != null) {
                return getTypeface(context, context.getResources().getString(i));
            }
            return null;
        }
        return (Typeface) invokeLI.objValue;
    }

    public static Typeface getTypeface(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            Typeface typeface = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Typeface cache = getCache(str);
            if (cache == null && context != null) {
                synchronized (TypefaceCache.class) {
                    Typeface cache2 = getCache(str);
                    if (cache2 == null) {
                        try {
                            typeface = Typeface.createFromAsset(context.getResources().getAssets(), str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (typeface != null) {
                            sCache.put(str, typeface);
                        }
                    } else {
                        typeface = cache2;
                    }
                }
                return typeface;
            }
            return cache;
        }
        return (Typeface) invokeLL.objValue;
    }
}
