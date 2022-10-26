package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
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
/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_KEY = 0;
    public static final String TAG = "TypefaceCompatBaseImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    /* loaded from: classes.dex */
    public interface StyleExtractor {
        int getWeight(Object obj);

        boolean isItalic(Object obj);
    }

    public TypefaceCompatBaseImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, fontFamilyFilesResourceEntry, i)) == null) {
            return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>(this) { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.2
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fontFileResourceEntry)) == null) {
                        return fontFileResourceEntry.getWeight();
                    }
                    return invokeL.intValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
                public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fontFileResourceEntry)) == null) {
                        return fontFileResourceEntry.isItalic();
                    }
                    return invokeL.booleanValue;
                }
            });
        }
        return (FontResourcesParserCompat.FontFileResourceEntry) invokeLI.objValue;
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fontInfoArr, i)) == null) {
            return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i, new StyleExtractor<FontsContractCompat.FontInfo>(this) { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fontInfo)) == null) {
                        return fontInfo.getWeight();
                    }
                    return invokeL.intValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
                public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fontInfo)) == null) {
                        return fontInfo.isItalic();
                    }
                    return invokeL.booleanValue;
                }
            });
        }
        return (FontsContractCompat.FontInfo) invokeLI.objValue;
    }

    public static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        InterceptResult invokeLIL;
        int i2;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, tArr, i, styleExtractor)) == null) {
            if ((i & 1) == 0) {
                i2 = 400;
            } else {
                i2 = 700;
            }
            if ((i & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            T t = null;
            int i4 = Integer.MAX_VALUE;
            for (T t2 : tArr) {
                int abs = Math.abs(styleExtractor.getWeight(t2) - i2) * 2;
                if (styleExtractor.isItalic(t2) == z) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                int i5 = abs + i3;
                if (t == null || i4 > i5) {
                    t = t2;
                    i4 = i5;
                }
            }
            return t;
        }
        return (T) invokeLIL.objValue;
    }

    public static long getUniqueKey(Typeface typeface) {
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
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Could not retrieve font from family.", e);
                return 0L;
            } catch (NoSuchFieldException e2) {
                Log.e(TAG, "Could not retrieve font from family.", e2);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, fontFamilyFilesResourceEntry, resources, i)) == null) {
            FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
            if (findBestEntry == null) {
                return null;
            }
            Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i);
            addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
            return createFromResourcesFontFile;
        }
        return (Typeface) invokeLLLI.objValue;
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InterceptResult invokeLLLI;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cancellationSignal, fontInfoArr, i)) == null) {
            InputStream inputStream2 = null;
            if (fontInfoArr.length < 1) {
                return null;
            }
            try {
                inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
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
                if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                    return null;
                }
                return Typeface.createFromFile(tempFile.getPath());
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return (Typeface) invokeLL.objValue;
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, resources, Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                    return null;
                }
                return Typeface.createFromFile(tempFile.getPath());
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return (Typeface) invokeCommon.objValue;
    }

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
