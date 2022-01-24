package com.baidu.fsg.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class ResUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANIM = "anim";
    public static final String a = "id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f33893b = "string";

    /* renamed from: c  reason: collision with root package name */
    public static final String f33894c = "layout";

    /* renamed from: d  reason: collision with root package name */
    public static final String f33895d = "style";

    /* renamed from: e  reason: collision with root package name */
    public static final String f33896e = "drawable";

    /* renamed from: f  reason: collision with root package name */
    public static final String f33897f = "color";

    /* renamed from: g  reason: collision with root package name */
    public static final String f33898g = "array";

    /* renamed from: h  reason: collision with root package name */
    public static final String f33899h = "attr";

    /* renamed from: i  reason: collision with root package name */
    public static final String f33900i = "dimen";

    /* renamed from: j  reason: collision with root package name */
    public static final String f33901j = "xml";
    public static final String k = "integer";
    public static final String l = "raw";
    public static Context m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(495609329, "Lcom/baidu/fsg/base/utils/ResUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(495609329, "Lcom/baidu/fsg/base/utils/ResUtils;");
        }
    }

    public ResUtils() {
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

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (context != null) {
                if (str == null || str.trim().length() == 0) {
                    throw new NullPointerException("the type is null or empty");
                }
                if (str2 == null || str2.trim().length() == 0) {
                    throw new NullPointerException("the attrNme is null or empty");
                }
                Resources resources = context.getResources();
                String packageName = context.getPackageName();
                if (ChannelUtils.isSpecailPackage()) {
                    packageName = "com.baidu.wallet";
                }
                if (ApollonConstants.DEBUG) {
                    String str3 = "context instance is " + context;
                    String str4 = "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context;
                }
                return resources.getIdentifier(str2, str, packageName);
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLL.intValue;
    }

    public static int a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, str3)) == null) {
            if (context != null) {
                if (str2 == null || str2.trim().length() == 0) {
                    throw new NullPointerException("the type is null or empty");
                }
                if (str3 == null || str3.trim().length() == 0) {
                    throw new NullPointerException("the attrNme is null or empty");
                }
                Resources resources = context.getResources();
                if (ChannelUtils.isSpecailPackage()) {
                    str = "com.baidu.wallet";
                }
                if (ApollonConstants.DEBUG) {
                    String str4 = "context instance is " + context;
                    String str5 = "packake name is " + str + " attrName is " + str3 + ", context instance is " + context;
                }
                return resources.getIdentifier(str3, str2, str);
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLLL.intValue;
    }

    public static String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, z)) == null) {
            if (bArr == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                stringBuffer.append(hexString.toUpperCase());
                if (z && i2 != bArr.length - 1) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static byte[] a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            String str2 = "name =" + str;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str3 = "concreteGetSign 读取的文件内容是=" + str;
            try {
                InputStream open = context.getAssets().open(str);
                if (open != null) {
                    int available = open.available();
                    StringBuilder sb = new StringBuilder();
                    sb.append("concreteGetSign 读取的文件的长度是=");
                    sb.append(available);
                    sb.toString();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        open.read(bArr);
                        open.close();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("concreteGetSign 读取文件的16进制: ");
                        sb2.append(a(bArr, true));
                        sb2.toString();
                        return bArr;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static int anim(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) ? a(context, "anim", str) : invokeLL.intValue;
    }

    public static int anim(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) ? a(context, str, "anim", str2) : invokeLLL.intValue;
    }

    public static int array(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? a(context, "array", str) : invokeLL.intValue;
    }

    public static int attr(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? a(context, "attr", str) : invokeLL.intValue;
    }

    public static int color(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? a(context, "color", str) : invokeLL.intValue;
    }

    public static int dimen(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) ? a(context, "dimen", str) : invokeLL.intValue;
    }

    public static int drawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? a(context, "drawable", str) : invokeLL.intValue;
    }

    public static Animation getAnimation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) ? AnimationUtils.loadAnimation(context, anim(context, str)) : (Animation) invokeLL.objValue;
    }

    public static Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? m : (Context) invokeV.objValue;
    }

    public static int getColor(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
            LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(context, str));
            return context.getResources().getColor(color(context, str));
        }
        return invokeLL.intValue;
    }

    public static float getDimension(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) ? context.getResources().getDimension(dimen(context, str)) : invokeLL.floatValue;
    }

    public static Drawable getDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) ? context.getResources().getDrawable(drawable(context, str)) : (Drawable) invokeLL.objValue;
    }

    public static int getInteger(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) ? context.getResources().getInteger(integer(context, str)) : invokeLL.intValue;
    }

    public static String getString(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            if (context != null && context.getResources() != null) {
                try {
                    return context.getResources().getString(string(context, str));
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) ? context.getResources().getStringArray(array(context, str)) : (String[]) invokeLL.objValue;
    }

    public static int id(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? a(context, "id", str) : invokeLL.intValue;
    }

    public static int integer(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) ? a(context, "integer", str) : invokeLL.intValue;
    }

    public static int layout(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) ? a(context, "layout", str) : invokeLL.intValue;
    }

    public static int raw(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) ? a(context, "raw", str) : invokeLL.intValue;
    }

    public static byte[] readAssets(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, str)) == null) ? a(context, str) : (byte[]) invokeLL.objValue;
    }

    public static void saveToSDCard(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, null, bArr) == null) || bArr == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "rim.license");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void setApplicationContext(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, context) == null) || context == null) {
            return;
        }
        m = context.getApplicationContext();
    }

    public static int string(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, str)) == null) ? a(context, "string", str) : invokeLL.intValue;
    }

    public static String string(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            try {
                return m.getString(a(m, "string", str));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int style(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, str)) == null) ? a(context, "style", str) : invokeLL.intValue;
    }

    public static int xml(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, context, str)) == null) ? a(context, "xml", str) : invokeLL.intValue;
    }
}
