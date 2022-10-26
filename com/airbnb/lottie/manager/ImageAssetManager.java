package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageAssetManager {
    public static final Object bitmapHashLock = new Object();
    public final Context context;
    public ImageAssetDelegate delegate;
    public final Map imageAssets;
    public String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map map) {
        String str2;
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.imagesFolder.charAt(str2.length() - 1) != '/') {
                this.imagesFolder += WebvttCueParser.CHAR_SLASH;
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

    private Bitmap putBitmap(String str, Bitmap bitmap) {
        synchronized (bitmapHashLock) {
            ((LottieImageAsset) this.imageAssets.get(str)).setBitmap(bitmap);
        }
        return bitmap;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = (LottieImageAsset) this.imageAssets.get(str);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(null);
            return bitmap2;
        }
        Bitmap bitmap3 = ((LottieImageAsset) this.imageAssets.get(str)).getBitmap();
        putBitmap(str, bitmap);
        return bitmap3;
    }

    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = (LottieImageAsset) this.imageAssets.get(str);
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
            } catch (IllegalArgumentException e) {
                Logger.warning("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.imagesFolder)) {
                AssetManager assets = this.context.getAssets();
                return putBitmap(str, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(assets.open(this.imagesFolder + fileName), null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e2) {
            Logger.warning("Unable to open asset.", e2);
            return null;
        }
    }

    public boolean hasSameContext(Context context) {
        if ((context == null && this.context == null) || this.context.equals(context)) {
            return true;
        }
        return false;
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }
}
