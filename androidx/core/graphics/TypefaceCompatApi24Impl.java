package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    public static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    public static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    public static final String TAG = "TypefaceCompatApi24Impl";
    public static final Method sAddFontWeightStyle;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class<?> sFontFamily;
    public static final Constructor<?> sFontFamilyCtor;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        Class<?> cls;
        Method method;
        Method method2;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1929059654, "Landroidx/core/graphics/TypefaceCompatApi24Impl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1929059654, "Landroidx/core/graphics/TypefaceCompatApi24Impl;");
                return;
            }
        }
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(TAG, e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    public TypefaceCompatApi24Impl() {
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

    public static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{obj, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            try {
                return ((Boolean) sAddFontWeightStyle.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static Typeface createFromFamiliesWithDefault(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            try {
                Object newInstance = Array.newInstance(sFontFamily, 1);
                Array.set(newInstance, 0, obj);
                return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        }
        return (Typeface) invokeL.objValue;
    }

    public static boolean isUsable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (sAddFontWeightStyle == null) {
                Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            return sAddFontWeightStyle != null;
        }
        return invokeV.booleanValue;
    }

    public static Object newFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                return sFontFamilyCtor.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        InterceptResult invokeLLLI;
        FontResourcesParserCompat.FontFileResourceEntry[] entries;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, fontFamilyFilesResourceEntry, resources, i2)) == null) {
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                ByteBuffer copyToDirectBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, fontFileResourceEntry.getResourceId());
                if (copyToDirectBuffer == null || !addFontWeightStyle(newFamily, copyToDirectBuffer, fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                    return null;
                }
            }
            return createFromFamiliesWithDefault(newFamily);
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cancellationSignal, fontInfoArr, i2)) == null) {
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                Uri uri = fontInfo.getUri();
                ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
                if (byteBuffer == null) {
                    byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                    simpleArrayMap.put(uri, byteBuffer);
                }
                if (byteBuffer == null || !addFontWeightStyle(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                    return null;
                }
            }
            Typeface createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily);
            if (createFromFamiliesWithDefault == null) {
                return null;
            }
            return Typeface.create(createFromFamiliesWithDefault, i2);
        }
        return (Typeface) invokeLLLI.objValue;
    }
}
