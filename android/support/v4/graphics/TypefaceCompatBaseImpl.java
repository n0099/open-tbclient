package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v7.widget.ActivityChooserView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
@RequiresApi(14)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
class TypefaceCompatBaseImpl implements TypefaceCompat.TypefaceCompatImpl {
    private static final String CACHE_FILE_PREFIX = "cached_font_";
    private static final String TAG = "TypefaceCompatBaseImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    private static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        T t;
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t2 = null;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t3 = tArr[i4];
            int abs = (styleExtractor.isItalic(t3) == z ? 0 : 1) + (Math.abs(styleExtractor.getWeight(t3) - i2) * 2);
            if (t2 == null || i3 > abs) {
                i3 = abs;
                t = t3;
            } else {
                t = t2;
            }
            i4++;
            t2 = t;
        }
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [102=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile != null) {
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                    typeface = Typeface.createFromFile(tempFile.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                tempFile.delete();
            }
        }
        return typeface;
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InputStream inputStream;
        Throwable th;
        Typeface typeface = null;
        if (fontInfoArr.length >= 1) {
            try {
                inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
            } catch (IOException e) {
                inputStream = null;
            } catch (Throwable th2) {
                inputStream = null;
                th = th2;
            }
            try {
                typeface = createFromInputStream(context, inputStream);
                TypefaceCompatUtil.closeQuietly(inputStream);
            } catch (IOException e2) {
                TypefaceCompatUtil.closeQuietly(inputStream);
                return typeface;
            } catch (Throwable th3) {
                th = th3;
                TypefaceCompatUtil.closeQuietly(inputStream);
                throw th;
            }
        }
        return typeface;
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: android.support.v4.graphics.TypefaceCompatBaseImpl.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (findBestEntry == null) {
            return null;
        }
        return TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=4] */
    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile != null) {
            try {
                if (TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                    typeface = Typeface.createFromFile(tempFile.getPath());
                }
            } catch (RuntimeException e) {
            } finally {
                tempFile.delete();
            }
        }
        return typeface;
    }
}
