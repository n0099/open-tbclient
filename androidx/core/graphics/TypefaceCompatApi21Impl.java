package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    public static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    public static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    public static final String TAG = "TypefaceCompatApi21Impl";
    public static Method sAddFontWeightStyle;
    public static Method sCreateFromFamiliesWithDefault;
    public static Class<?> sFontFamily;
    public static Constructor<?> sFontFamilyCtor;
    public static boolean sHasInitBeenCalled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1843172201, "Landroidx/core/graphics/TypefaceCompatApi21Impl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1843172201, "Landroidx/core/graphics/TypefaceCompatApi21Impl;");
        }
    }

    public TypefaceCompatApi21Impl() {
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

    public static boolean addFontWeightStyle(Object obj, String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{obj, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            init();
            try {
                return ((Boolean) sAddFontWeightStyle.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static Typeface createFromFamiliesWithDefault(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            init();
            try {
                Object newInstance = Array.newInstance(sFontFamily, 1);
                Array.set(newInstance, 0, obj);
                return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Typeface) invokeL.objValue;
    }

    private File getFile(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parcelFileDescriptor)) == null) {
            try {
                String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
                if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                    return new File(readlink);
                }
            } catch (ErrnoException unused) {
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static void init() {
        Method method;
        Class<?> cls;
        Method method2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || sHasInitBeenCalled) {
            return;
        }
        sHasInitBeenCalled = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            method = null;
            cls = null;
            method2 = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    public static Object newFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            init();
            try {
                return sFontFamilyCtor.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeV.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        InterceptResult invokeLLLI;
        FontResourcesParserCompat.FontFileResourceEntry[] entries;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, fontFamilyFilesResourceEntry, resources, i2)) == null) {
            Object newFamily = newFamily();
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                File tempFile = TypefaceCompatUtil.getTempFile(context);
                if (tempFile == null) {
                    return null;
                }
                try {
                    if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                        return null;
                    }
                    if (!addFontWeightStyle(newFamily, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                        return null;
                    }
                    tempFile.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    tempFile.delete();
                }
            }
            return createFromFamiliesWithDefault(newFamily);
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cancellationSignal, fontInfoArr, i2)) == null) {
            if (fontInfoArr.length < 1) {
                return null;
            }
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(fontInfoArr, i2).getUri(), r.f40168a, cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                File file = getFile(openFileDescriptor);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface createFromInputStream = super.createFromInputStream(context, fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromInputStream;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        return (Typeface) invokeLLLI.objValue;
    }
}
