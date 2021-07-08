package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_KEY = 0;
    public static final String TAG = "TypefaceCompatBaseImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    /* loaded from: classes.dex */
    public interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    public TypefaceCompatBaseImpl() {
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
        this.mFontFamilies = new ConcurrentHashMap<>();
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, typeface, fontFamilyFilesResourceEntry) == null) {
            long uniqueKey = getUniqueKey(typeface);
            if (uniqueKey != 0) {
                this.mFontFamilies.put(Long.valueOf(uniqueKey), fontFamilyFilesResourceEntry);
            }
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, fontFamilyFilesResourceEntry, i2)) == null) ? (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i2, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this) { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TypefaceCompatBaseImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fontFileResourceEntry)) == null) ? fontFileResourceEntry.getWeight() : invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fontFileResourceEntry)) == null) ? fontFileResourceEntry.isItalic() : invokeL.booleanValue;
            }
        }) : (FontResourcesParserCompat.FontFileResourceEntry) invokeLI.objValue;
    }

    public static <T> T findBestFont(T[] tArr, int i2, StyleExtractor<T> styleExtractor) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, tArr, i2, styleExtractor)) == null) {
            int i3 = (i2 & 1) == 0 ? 400 : 700;
            boolean z = (i2 & 2) != 0;
            T t = null;
            int i4 = Integer.MAX_VALUE;
            for (T t2 : tArr) {
                int abs = (Math.abs(styleExtractor.getWeight(t2) - i3) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
                if (t == null || i4 > abs) {
                    t = t2;
                    i4 = abs;
                }
            }
            return t;
        }
        return (T) invokeLIL.objValue;
    }

    public static long getUniqueKey(@Nullable Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, typeface)) == null) {
            if (typeface == null) {
                return 0L;
            }
            try {
                Field declaredField = Typeface.class.getDeclaredField("native_instance");
                declaredField.setAccessible(true);
                return ((Number) declaredField.get(typeface)).longValue();
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Could not retrieve font from family.", e2);
                return 0L;
            } catch (NoSuchFieldException e3) {
                Log.e(TAG, "Could not retrieve font from family.", e3);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, fontFamilyFilesResourceEntry, resources, i2)) == null) {
            FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i2);
            if (findBestEntry == null) {
                return null;
            }
            Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i2);
            addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
            return createFromResourcesFontFile;
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLLLI;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cancellationSignal, fontInfoArr, i2)) == null) {
            InputStream inputStream2 = null;
            if (fontInfoArr.length < 1) {
                return null;
            }
            try {
                inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i2).getUri());
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                Typeface createFromInputStream = createFromInputStream(context, inputStream);
                TypefaceCompatUtil.closeQuietly(inputStream);
                return createFromInputStream;
            } catch (IOException unused2) {
                TypefaceCompatUtil.closeQuietly(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                TypefaceCompatUtil.closeQuietly(inputStream2);
                throw th;
            }
        }
        return (Typeface) invokeLLLI.objValue;
    }

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, inputStream)) == null) {
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                    return Typeface.createFromFile(tempFile.getPath());
                }
                return null;
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return (Typeface) invokeLL.objValue;
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, resources, Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, resources, i2)) {
                    return Typeface.createFromFile(tempFile.getPath());
                }
                return null;
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return (Typeface) invokeCommon.objValue;
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fontInfoArr, i2)) == null) ? (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i2, new StyleExtractor<FontsContractCompat.FontInfo>(this) { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TypefaceCompatBaseImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fontInfo)) == null) ? fontInfo.getWeight() : invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fontInfo)) == null) ? fontInfo.isItalic() : invokeL.booleanValue;
            }
        }) : (FontsContractCompat.FontInfo) invokeLI.objValue;
    }

    @Nullable
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, typeface)) == null) {
            long uniqueKey = getUniqueKey(typeface);
            if (uniqueKey == 0) {
                return null;
            }
            return this.mFontFamilies.get(Long.valueOf(uniqueKey));
        }
        return (FontResourcesParserCompat.FontFamilyFilesResourceEntry) invokeL.objValue;
    }
}
