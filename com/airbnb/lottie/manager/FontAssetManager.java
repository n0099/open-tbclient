package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FontAssetManager {
    public final AssetManager assetManager;
    @Nullable
    public FontAssetDelegate delegate;
    public final MutablePair<String> tempPair = new MutablePair<>();
    public final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    public final Map<String, Typeface> fontFamilies = new HashMap();
    public String defaultFontFileExtension = ".ttf";

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    private Typeface getFontFamily(String str) {
        String fontPath;
        Typeface typeface = this.fontFamilies.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate = this.delegate;
        Typeface fetchFont = fontAssetDelegate != null ? fontAssetDelegate.fetchFont(str) : null;
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (fontAssetDelegate2 != null && fetchFont == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            fetchFont = Typeface.createFromAsset(this.assetManager, fontPath);
        }
        if (fetchFont == null) {
            fetchFont = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.defaultFontFileExtension);
        }
        this.fontFamilies.put(str, fetchFont);
        return fetchFont;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface getTypeface(String str, String str2) {
        this.tempPair.set(str, str2);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceForStyle = typefaceForStyle(getFontFamily(str), str2);
        this.fontMap.put(this.tempPair, typefaceForStyle);
        return typefaceForStyle;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}
