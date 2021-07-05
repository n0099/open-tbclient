package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FontAssetManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AssetManager assetManager;
    public String defaultFontFileExtension;
    @Nullable
    public FontAssetDelegate delegate;
    public final Map<String, Typeface> fontFamilies;
    public final Map<MutablePair<String>, Typeface> fontMap;
    public final MutablePair<String> tempPair;

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, fontAssetDelegate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tempPair = new MutablePair<>();
        this.fontMap = new HashMap();
        this.fontFamilies = new HashMap();
        this.defaultFontFileExtension = ".ttf";
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    private Typeface getFontFamily(String str) {
        InterceptResult invokeL;
        String fontPath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
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
        return (Typeface) invokeL.objValue;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, typeface, str)) == null) {
            boolean contains = str.contains("Italic");
            boolean contains2 = str.contains("Bold");
            int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
            return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
        }
        return (Typeface) invokeLL.objValue;
    }

    public Typeface getTypeface(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.tempPair.set(str, str2);
            Typeface typeface = this.fontMap.get(this.tempPair);
            if (typeface != null) {
                return typeface;
            }
            Typeface typefaceForStyle = typefaceForStyle(getFontFamily(str), str2);
            this.fontMap.put(this.tempPair, typefaceForStyle);
            return typefaceForStyle;
        }
        return (Typeface) invokeLL.objValue;
    }

    public void setDefaultFontFileExtension(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.defaultFontFileExtension = str;
        }
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fontAssetDelegate) == null) {
            this.delegate = fontAssetDelegate;
        }
    }
}
