package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class ImageAssetManager {
    public static /* synthetic */ Interceptable $ic;
    public static final Object bitmapHashLock;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    @Nullable
    public ImageAssetDelegate delegate;
    public final Map<String, LottieImageAsset> imageAssets;
    public String imagesFolder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-749831252, "Lcom/airbnb/lottie/manager/ImageAssetManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-749831252, "Lcom/airbnb/lottie/manager/ImageAssetManager;");
                return;
            }
        }
        bitmapHashLock = new Object();
    }

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, str, imageAssetDelegate, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.imagesFolder.charAt(str2.length() - 1) != '/') {
                this.imagesFolder += '/';
            }
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.imageAssets = map;
        setDelegate(imageAssetDelegate);
    }

    private Bitmap putBitmap(String str, @Nullable Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, bitmap)) == null) {
            synchronized (bitmapHashLock) {
                this.imageAssets.get(str).setBitmap(bitmap);
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Nullable
    public Bitmap bitmapForId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
            if (lottieImageAsset == null) {
                return null;
            }
            Bitmap bitmap = lottieImageAsset.getBitmap();
            if (bitmap != null) {
                return bitmap;
            }
            ImageAssetDelegate imageAssetDelegate = this.delegate;
            if (imageAssetDelegate != null) {
                Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
                if (fetchBitmap != null) {
                    putBitmap(str, fetchBitmap);
                }
                return fetchBitmap;
            }
            String fileName = lottieImageAsset.getFileName();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            if (fileName.startsWith(WebGLImageLoader.DATA_URL) && fileName.indexOf("base64,") > 0) {
                try {
                    byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                    return putBitmap(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                } catch (IllegalArgumentException e2) {
                    Logger.warning("data URL did not have correct base64 format.", e2);
                    return null;
                }
            }
            try {
                if (!TextUtils.isEmpty(this.imagesFolder)) {
                    AssetManager assets = this.context.getAssets();
                    return putBitmap(str, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(assets.open(this.imagesFolder + fileName), null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e3) {
                Logger.warning("Unable to open asset.", e3);
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public boolean hasSameContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? (context == null && this.context == null) || this.context.equals(context) : invokeL.booleanValue;
    }

    public void setDelegate(@Nullable ImageAssetDelegate imageAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageAssetDelegate) == null) {
            this.delegate = imageAssetDelegate;
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bitmap)) == null) {
            if (bitmap == null) {
                LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
                Bitmap bitmap2 = lottieImageAsset.getBitmap();
                lottieImageAsset.setBitmap(null);
                return bitmap2;
            }
            Bitmap bitmap3 = this.imageAssets.get(str).getBitmap();
            putBitmap(str, bitmap);
            return bitmap3;
        }
        return (Bitmap) invokeLL.objValue;
    }
}
