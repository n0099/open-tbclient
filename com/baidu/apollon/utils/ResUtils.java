package com.baidu.apollon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ResUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANIM = "anim";

    /* renamed from: a  reason: collision with root package name */
    public static final String f4125a = "id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f4126b = "string";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4127c = "layout";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4128d = "style";

    /* renamed from: e  reason: collision with root package name */
    public static final String f4129e = "drawable";

    /* renamed from: f  reason: collision with root package name */
    public static final String f4130f = "color";

    /* renamed from: g  reason: collision with root package name */
    public static final String f4131g = "array";

    /* renamed from: h  reason: collision with root package name */
    public static final String f4132h = "attr";

    /* renamed from: i  reason: collision with root package name */
    public static final String f4133i = "dimen";
    public static final String j = "xml";
    public static final String k = "integer";
    public static final String l = "raw";
    public static Context mContext;
    public static String resourcePackageName;
    public transient /* synthetic */ FieldHolder $fh;

    public ResUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            if (mContext != null) {
                if (str != null && str.trim().length() != 0) {
                    if (str2 != null && str2.trim().length() != 0) {
                        Resources resources = mContext.getResources();
                        String packageName = mContext.getPackageName();
                        if (ChannelUtils.isSpecailPackage()) {
                            packageName = "com.baidu.wallet";
                        }
                        if (ApollonConstants.DEBUG) {
                            Log.d("Apollon ResUtils", "context instance is " + context);
                            Log.d("Apollon ResUtils", "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context);
                        }
                        int identifier = resources.getIdentifier(str2, str, packageName);
                        return identifier <= 0 ? resources.getIdentifier(str2, str, resourcePackageName) : identifier;
                    }
                    throw new NullPointerException("the attrNme is null or empty");
                }
                throw new NullPointerException("the type is null or empty");
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLL.intValue;
    }

    public static int anim(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) ? a(mContext, "anim", str) : invokeLL.intValue;
    }

    public static int array(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) ? a(mContext, "array", str) : invokeLL.intValue;
    }

    public static int attr(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? a(mContext, "attr", str) : invokeLL.intValue;
    }

    public static int color(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? a(mContext, "color", str) : invokeLL.intValue;
    }

    public static int dimen(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? a(mContext, "dimen", str) : invokeLL.intValue;
    }

    public static int drawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? a(mContext, "drawable", str) : invokeLL.intValue;
    }

    public static Animation getAnimation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            Context context2 = mContext;
            return AnimationUtils.loadAnimation(context2, anim(context2, str));
        }
        return (Animation) invokeLL.objValue;
    }

    public static int getColor(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(mContext, str));
            return mContext.getResources().getColor(color(mContext, str));
        }
        return invokeLL.intValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? mContext : (Context) invokeV.objValue;
    }

    public static float getDimension(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) ? mContext.getResources().getDimension(dimen(mContext, str)) : invokeLL.floatValue;
    }

    public static Drawable getDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? mContext.getResources().getDrawable(drawable(mContext, str)) : (Drawable) invokeLL.objValue;
    }

    public static int getInteger(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) ? mContext.getResources().getInteger(integer(mContext, str)) : invokeLL.intValue;
    }

    public static String getResourcePackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? resourcePackageName : (String) invokeV.objValue;
    }

    public static String getString(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            Context context2 = mContext;
            if (context2 != null && context2.getResources() != null) {
                try {
                    return mContext.getResources().getString(string(mContext, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String[] getStringArray(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) ? mContext.getResources().getStringArray(array(mContext, str)) : (String[]) invokeLL.objValue;
    }

    public static int id(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) ? a(mContext, "id", str) : invokeLL.intValue;
    }

    public static int integer(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) ? a(mContext, "integer", str) : invokeLL.intValue;
    }

    public static int layout(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? a(mContext, "layout", str) : invokeLL.intValue;
    }

    public static int raw(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) ? a(mContext, "raw", str) : invokeLL.intValue;
    }

    public static void setApplicationContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, context) == null) {
            mContext = context;
        }
    }

    public static void setResourcePackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            resourcePackageName = str;
        }
    }

    public static int string(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, str)) == null) ? a(mContext, "string", str) : invokeLL.intValue;
    }

    public static int style(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) ? a(mContext, "style", str) : invokeLL.intValue;
    }

    public static int xml(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, str)) == null) ? a(mContext, "xml", str) : invokeLL.intValue;
    }

    public static int anim(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) ? a(mContext, str, "anim", str2) : invokeLLL.intValue;
    }

    public static int a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, str3)) == null) {
            if (mContext != null) {
                if (str2 != null && str2.trim().length() != 0) {
                    if (str3 != null && str3.trim().length() != 0) {
                        Resources resources = mContext.getResources();
                        if (ChannelUtils.isSpecailPackage()) {
                            str = "com.baidu.wallet";
                        }
                        if (ApollonConstants.DEBUG) {
                            Log.d("Apollon ResUtils", "context instance is " + context);
                            Log.d("Apollon ResUtils", "packake name is " + str + " attrName is " + str3 + ", context instance is " + context);
                        }
                        int identifier = resources.getIdentifier(str3, str2, str);
                        return identifier <= 0 ? resources.getIdentifier(str3, str2, resourcePackageName) : identifier;
                    }
                    throw new NullPointerException("the attrNme is null or empty");
                }
                throw new NullPointerException("the type is null or empty");
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLLL.intValue;
    }
}
