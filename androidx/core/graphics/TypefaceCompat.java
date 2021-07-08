package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"NewApi"})
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
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i2 >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i2 >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i2 >= 24 && TypefaceCompatApi24Impl.isUsable()) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static Typeface create(@NonNull Context context, @Nullable Typeface typeface, int i2) {
        InterceptResult invokeLLI;
        Typeface bestFontFromFamily;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, typeface, i2)) == null) {
            if (context != null) {
                return (Build.VERSION.SDK_INT >= 21 || (bestFontFromFamily = getBestFontFromFamily(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : bestFontFromFamily;
            }
            throw new IllegalArgumentException("Context cannot be null");
        }
        return (Typeface) invokeLLI.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, context, cancellationSignal, fontInfoArr, i2)) == null) ? sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i2) : (Typeface) invokeLLLI.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        InterceptResult invokeCommon;
        Typeface createFromFontFamilyFilesResourceEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, familyResourceEntry, resources, Integer.valueOf(i2), Integer.valueOf(i3), fontCallback, handler, Boolean.valueOf(z)})) == null) {
            if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
                FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
                boolean z2 = false;
                if (!z ? fontCallback == null : providerResourceEntry.getFetchStrategy() == 0) {
                    z2 = true;
                }
                createFromFontFamilyFilesResourceEntry = FontsContractCompat.getFontSync(context, providerResourceEntry.getRequest(), fontCallback, handler, z2, z ? providerResourceEntry.getTimeout() : -1, i3);
            } else {
                createFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
                if (fontCallback != null) {
                    if (createFromFontFamilyFilesResourceEntry != null) {
                        fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, handler);
                    } else {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                }
            }
            if (createFromFontFamilyFilesResourceEntry != null) {
                sTypefaceCache.put(createResourceUid(resources, i2, i3), createFromFontFamilyFilesResourceEntry);
            }
            return createFromFontFamilyFilesResourceEntry;
        }
        return (Typeface) invokeCommon.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, resources, Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i2, str, i3);
            if (createFromResourcesFontFile != null) {
                sTypefaceCache.put(createResourceUid(resources, i2, i3), createFromResourcesFontFile);
            }
            return createFromResourcesFontFile;
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static String createResourceUid(Resources resources, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, resources, i2, i3)) == null) {
            return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
        }
        return (String) invokeLII.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface findFromCache(@NonNull Resources resources, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, resources, i2, i3)) == null) ? sTypefaceCache.get(createResourceUid(resources, i2, i3)) : (Typeface) invokeLII.objValue;
    }

    @Nullable
    public static Typeface getBestFontFromFamily(Context context, Typeface typeface, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, context, typeface, i2)) == null) {
            FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = sTypefaceCompatImpl.getFontFamily(typeface);
            if (fontFamily == null) {
                return null;
            }
            return sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i2);
        }
        return (Typeface) invokeLLI.objValue;
    }
}
