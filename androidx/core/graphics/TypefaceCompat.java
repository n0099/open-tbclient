package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TypefaceCompat {
    public static /* synthetic */ Interceptable $ic;
    public static final LruCache<String, Typeface> sTypefaceCache;
    public static final TypefaceCompatBaseImpl sTypefaceCompatImpl;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-689883948, "Landroidx/core/graphics/TypefaceCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-689883948, "Landroidx/core/graphics/TypefaceCompat;");
                return;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i >= 24 && TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
        }
        sTypefaceCache = new LruCache<>(16);
    }

    public TypefaceCompat() {
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

    public static Typeface create(Context context, Typeface typeface, int i) {
        InterceptResult invokeLLI;
        Typeface bestFontFromFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, typeface, i)) == null) {
            if (context != null) {
                if (Build.VERSION.SDK_INT < 21 && (bestFontFromFamily = getBestFontFromFamily(context, typeface, i)) != null) {
                    return bestFontFromFamily;
                }
                return Typeface.create(typeface, i);
            }
            throw new IllegalArgumentException("Context cannot be null");
        }
        return (Typeface) invokeLLI.objValue;
    }

    public static Typeface findFromCache(Resources resources, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, resources, i, i2)) == null) {
            return sTypefaceCache.get(createResourceUid(resources, i, i2));
        }
        return (Typeface) invokeLII.objValue;
    }

    public static Typeface getBestFontFromFamily(Context context, Typeface typeface, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, context, typeface, i)) == null) {
            FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = sTypefaceCompatImpl.getFontFamily(typeface);
            if (fontFamily == null) {
                return null;
            }
            return sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i);
        }
        return (Typeface) invokeLLI.objValue;
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, context, cancellationSignal, fontInfoArr, i)) == null) {
            return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
        }
        return (Typeface) invokeLLLI.objValue;
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        InterceptResult invokeCommon;
        Typeface createFromFontFamilyFilesResourceEntry;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, familyResourceEntry, resources, Integer.valueOf(i), Integer.valueOf(i2), fontCallback, handler, Boolean.valueOf(z)})) == null) {
            if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
                FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
                boolean z2 = false;
                if (!z ? fontCallback == null : providerResourceEntry.getFetchStrategy() == 0) {
                    z2 = true;
                }
                if (z) {
                    i3 = providerResourceEntry.getTimeout();
                } else {
                    i3 = -1;
                }
                createFromFontFamilyFilesResourceEntry = FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), fontCallback, handler, z2, i3, i2);
            } else {
                createFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i2);
                if (fontCallback != null) {
                    if (createFromFontFamilyFilesResourceEntry != null) {
                        fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                    } else {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                }
            }
            if (createFromFontFamilyFilesResourceEntry != null) {
                sTypefaceCache.put(createResourceUid(resources, i, i2), createFromFontFamilyFilesResourceEntry);
            }
            return createFromFontFamilyFilesResourceEntry;
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, resources, Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i2);
            if (createFromResourcesFontFile != null) {
                sTypefaceCache.put(createResourceUid(resources, i, i2), createFromResourcesFontFile);
            }
            return createFromResourcesFontFile;
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static String createResourceUid(Resources resources, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, resources, i, i2)) == null) {
            return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
        }
        return (String) invokeLII.objValue;
    }
}
