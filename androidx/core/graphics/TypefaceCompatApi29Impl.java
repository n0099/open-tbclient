package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TypefaceCompatApi29Impl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        InterceptResult invokeLLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, fontFamilyFilesResourceEntry, resources, i)) == null) {
            FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
            int length = entries.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i4];
                try {
                    Font.Builder weight = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                    if (!fontFileResourceEntry.isItalic()) {
                        i5 = 0;
                    }
                    Font build = weight.setSlant(i5).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i4++;
            }
            if (builder == null) {
                return null;
            }
            if ((i & 1) != 0) {
                i2 = 700;
            } else {
                i2 = 400;
            }
            if ((i & 2) != 0) {
                i3 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i2, i3)).build();
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InterceptResult invokeLLLI;
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cancellationSignal, fontInfoArr, i)) == null) {
            ContentResolver contentResolver = context.getContentResolver();
            int length = fontInfoArr.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                FontsContractCompat.FontInfo fontInfo = fontInfoArr[i4];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.getUri(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor == null) {
                        i4++;
                    }
                } else {
                    Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fontInfo.getWeight());
                    if (!fontInfo.isItalic()) {
                        i5 = 0;
                    }
                    Font build = weight.setSlant(i5).setTtcIndex(fontInfo.getTtcIndex()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                    if (openFileDescriptor == null) {
                        i4++;
                    }
                }
                openFileDescriptor.close();
                i4++;
            }
            if (builder == null) {
                return null;
            }
            if ((i & 1) != 0) {
                i2 = 700;
            } else {
                i2 = 400;
            }
            if ((i & 2) != 0) {
                i3 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i2, i3)).build();
        }
        return (Typeface) invokeLLLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, inputStream)) == null) {
            throw new RuntimeException("Do not use this function in API 29 or later.");
        }
        return (Typeface) invokeLL.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fontInfoArr, i)) == null) {
            throw new RuntimeException("Do not use this function in API 29 or later.");
        }
        return (FontsContractCompat.FontInfo) invokeLI.objValue;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, resources, Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            try {
                Font build = new Font.Builder(resources, i).build();
                return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
            } catch (IOException unused) {
                return null;
            }
        }
        return (Typeface) invokeCommon.objValue;
    }
}
