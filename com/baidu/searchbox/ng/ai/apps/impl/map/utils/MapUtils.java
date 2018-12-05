package com.baidu.searchbox.ng.ai.apps.impl.map.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.e;
import com.facebook.common.b.f;
import com.facebook.common.references.a;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.e.b;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class MapUtils {
    public static final String MODEL_TAG = "map";

    /* loaded from: classes4.dex */
    public interface ImgLoadCallBack {
        void onLoaded(Bitmap bitmap);
    }

    public static int convertColorSafe(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.w("map", "color string is empty, use default " + Integer.toHexString(i));
            return i;
        }
        try {
            if (str.charAt(0) == '#') {
                String substring = str.substring(1);
                if (substring.length() != 6 && substring.length() != 8) {
                    throw new IllegalArgumentException("char count not right");
                }
                if (substring.length() == 6) {
                    i2 = (int) (Long.parseLong(substring, 16) | (-16777216));
                } else {
                    i2 = (int) Long.parseLong(substring.substring(6) + substring.substring(0, 6), 16);
                }
            } else {
                i2 = Color.parseColor(str);
            }
        } catch (IllegalArgumentException e) {
            AiAppsLog.w("map", "parse color error, use default " + Integer.toHexString(i));
            i2 = i;
        }
        return i2;
    }

    public static double convertPxToLatLng(double d, BaiduMap baiduMap, boolean z) {
        MapStatus mapStatus = baiduMap.getMapStatus();
        if (mapStatus == null || mapStatus.winRound == null || mapStatus.bound == null) {
            return 0.0d;
        }
        double d2 = mapStatus.winRound.bottom - mapStatus.winRound.top;
        double d3 = mapStatus.winRound.right - mapStatus.winRound.left;
        double d4 = mapStatus.bound.northeast.latitude - mapStatus.bound.southwest.latitude;
        double d5 = mapStatus.bound.northeast.longitude - mapStatus.bound.southwest.longitude;
        if (z) {
            return (d / d2) * d4;
        }
        return d5 * (d / d3);
    }

    public static Bitmap getBitmapFromPath(String str, boolean z) {
        Bitmap bitmap = null;
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            String relativeToPath = StorageUtil.relativeToPath(str, aiApp, aiApp.getVersion());
            if (!TextUtils.isEmpty(relativeToPath)) {
                bitmap = loadBitmapFromSDCard(relativeToPath);
            }
        }
        if (bitmap == null && z) {
            Bitmap decodeResource = BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), e.f.pin_red);
            AiAppsLog.w("map", "file not exist, use default");
            return decodeResource;
        }
        return bitmap;
    }

    public static Bitmap reSizeBitmap(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        return bitmap2;
    }

    public static float dp2px(double d) {
        return (float) (AiAppsUIUtils.getDensity(AppRuntime.getAppContext()) * d);
    }

    public static void loadImg(Uri uri, final ImgLoadCallBack imgLoadCallBack, int i, int i2) {
        c.bTX().e(ImageRequestBuilder.G(uri).bZS(), AppRuntime.getAppContext()).a(new b() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils.1
            @Override // com.facebook.imagepipeline.e.b
            protected void onNewResultImpl(Bitmap bitmap) {
                ImgLoadCallBack.this.onLoaded(Bitmap.createBitmap(bitmap));
            }

            @Override // com.facebook.datasource.a
            protected void onFailureImpl(com.facebook.datasource.b<a<com.facebook.imagepipeline.f.b>> bVar) {
                ImgLoadCallBack.this.onLoaded(null);
            }
        }, f.bTa());
    }

    public static Bitmap loadBitmapFromSDCard(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, new BitmapFactory.Options());
            com.baidu.g.a.closeSafely(fileInputStream);
            return decodeStream;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
