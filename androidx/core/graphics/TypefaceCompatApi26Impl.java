package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABORT_CREATION_METHOD = "abortCreation";
    public static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    public static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    public static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    public static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    public static final String FREEZE_METHOD = "freeze";
    public static final int RESOLVE_BY_FONT_TABLE = -1;
    public static final String TAG = "TypefaceCompatApi26Impl";
    public transient /* synthetic */ FieldHolder $fh;
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class<?> mFontFamily;
    public final Constructor<?> mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Class<?> cls = null;
        try {
            Class<?> obtainFontFamily = obtainFontFamily();
            constructor = obtainFontFamilyCtor(obtainFontFamily);
            method2 = obtainAddFontFromAssetManagerMethod(obtainFontFamily);
            method3 = obtainAddFontFromBufferMethod(obtainFontFamily);
            method4 = obtainFreezeMethod(obtainFontFamily);
            method5 = obtainAbortCreationMethod(obtainFontFamily);
            method = obtainCreateFromFamiliesWithDefaultMethod(obtainFontFamily);
            cls = obtainFontFamily;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            String str = "Unable to collect necessary methods for class " + e2.getClass().getName();
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method2;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method4;
        this.mAbortCreation = method5;
        this.mCreateFromFamiliesWithDefault = method;
    }

    private void abortCreation(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, obj) == null) {
            try {
                this.mAbortCreation.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i2, int i3, int i4, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{context, obj, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})) == null) {
            try {
                return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{obj, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            try {
                return ((Boolean) this.mAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean freeze(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj)) == null) {
            try {
                return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Method method = this.mAddFontFromAssetManager;
            return this.mAddFontFromAssetManager != null;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    private Object newFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            try {
                return this.mFontFamilyCtor.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                Object newInstance = Array.newInstance(this.mFontFamily, 1);
                Array.set(newInstance, 0, obj);
                return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        }
        return (Typeface) invokeL.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        InterceptResult invokeLLLI;
        FontResourcesParserCompat.FontFileResourceEntry[] entries;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fontFamilyFilesResourceEntry, resources, i2)) == null) {
            if (!isFontFamilyPrivateAPIAvailable()) {
                return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i2);
            }
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                    abortCreation(newFamily);
                    return null;
                }
            }
            if (freeze(newFamily)) {
                return createFromFamiliesWithDefault(newFamily);
            }
            return null;
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLLLI;
        Typeface createFromFamiliesWithDefault;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, cancellationSignal, fontInfoArr, i2)) == null) {
            if (fontInfoArr.length < 1) {
                return null;
            }
            if (!isFontFamilyPrivateAPIAvailable()) {
                FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i2);
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), r.f42062a, cancellationSignal);
                    if (openFileDescriptor == null) {
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return null;
                    }
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight()).setItalic(findBestInfo.isItalic()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } catch (IOException unused) {
                    return null;
                }
            }
            Map<Uri, ByteBuffer> prepareFontData = FontsContractCompat.prepareFontData(context, fontInfoArr, cancellationSignal);
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            boolean z = false;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = prepareFontData.get(fontInfo.getUri());
                if (byteBuffer != null) {
                    if (!addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic() ? 1 : 0)) {
                        abortCreation(newFamily);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                abortCreation(newFamily);
                return null;
            } else if (freeze(newFamily) && (createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily)) != null) {
                return Typeface.create(createFromFamiliesWithDefault, i2);
            } else {
                return null;
            }
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, resources, Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            if (!isFontFamilyPrivateAPIAvailable()) {
                return super.createFromResourcesFontFile(context, resources, i2, str, i3);
            }
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, null)) {
                abortCreation(newFamily);
                return null;
            } else if (freeze(newFamily)) {
                return createFromFamiliesWithDefault(newFamily);
            } else {
                return null;
            }
        }
        return (Typeface) invokeCommon.objValue;
    }

    public Method obtainAbortCreationMethod(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? cls.getMethod(ABORT_CREATION_METHOD, new Class[0]) : (Method) invokeL.objValue;
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            Class<?> cls2 = Integer.TYPE;
            return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
        }
        return (Method) invokeL.objValue;
    }

    public Method obtainAddFontFromBufferMethod(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) {
            Class<?> cls2 = Integer.TYPE;
            return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
        }
        return (Method) invokeL.objValue;
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        }
        return (Method) invokeL.objValue;
    }

    public Class<?> obtainFontFamily() throws ClassNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Class.forName("android.graphics.FontFamily") : (Class) invokeV.objValue;
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cls)) == null) ? cls.getConstructor(new Class[0]) : (Constructor) invokeL.objValue;
    }

    public Method obtainFreezeMethod(Class<?> cls) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) ? cls.getMethod(FREEZE_METHOD, new Class[0]) : (Method) invokeL.objValue;
    }
}
