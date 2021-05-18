package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BitmapDescriptorFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f6910a = !BitmapDescriptorFactory.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public static final String f6911b = "BaiduMapSDK-" + BitmapDescriptorFactory.class.getSimpleName();

    public static BitmapDescriptor fromAsset(String str) {
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
            BitmapDescriptor fromBitmap = fromBitmap(a2);
            if (!f6910a && a2 == null) {
                throw new AssertionError();
            }
            a2.recycle();
            return fromBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #0 {Exception -> 0x0063, blocks: (B:5:0x0008, B:8:0x000f, B:10:0x0017, B:11:0x0031, B:16:0x005a, B:18:0x005f, B:14:0x003a, B:15:0x0055), top: B:23:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BitmapDescriptor fromAssetWithDpi(String str) {
        BitmapDescriptor fromBitmap;
        Bitmap bitmap;
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
            if (a2 == null) {
                return null;
            }
            int densityDpi = SysOSUtil.getDensityDpi();
            if (densityDpi > 480) {
                Matrix matrix = new Matrix();
                matrix.postScale(2.0f, 2.0f);
                bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
            } else if (densityDpi <= 320) {
                fromBitmap = fromBitmap(a2);
                bitmap = null;
                a2.recycle();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                return fromBitmap;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
            }
            fromBitmap = fromBitmap(bitmap);
            a2.recycle();
            if (bitmap != null) {
            }
            return fromBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) {
        Context context;
        String str2;
        String str3;
        if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
            return null;
        }
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            if (decodeStream != null) {
                BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                decodeStream.recycle();
                return fromBitmap;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            str2 = f6911b;
            str3 = "FileNotFoundException happened";
            Log.e(str2, str3, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            str2 = f6911b;
            str3 = "IOException happened";
            Log.e(str2, str3, e);
            return null;
        }
        return null;
    }

    public static BitmapDescriptor fromFileWithDpi(String str, int i2) {
        Context context;
        String str2;
        String str3;
        if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
            return null;
        }
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            if (decodeStream != null) {
                if (i2 <= 0) {
                    i2 = SysOSUtil.getDensityDpi();
                }
                decodeStream.setDensity(i2);
                BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                decodeStream.recycle();
                return fromBitmap;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            str2 = f6911b;
            str3 = "FileNotFoundException happened";
            Log.e(str2, str3, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            str2 = f6911b;
            str3 = "IOException happened";
            Log.e(str2, str3, e);
            return null;
        }
        return null;
    }

    public static BitmapDescriptor fromPath(String str) {
        Bitmap decodeFile;
        if (TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
        decodeFile.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromPathWithDpi(String str, int i2) {
        Bitmap decodeFile;
        if (TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        if (i2 <= 0) {
            i2 = SysOSUtil.getDensityDpi();
        }
        decodeFile.setDensity(i2);
        BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
        decodeFile.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromResource(int i2) {
        Bitmap decodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i2)) == null) {
            return null;
        }
        BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
        decodeResource.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromResourceWithDpi(int i2, int i3) {
        Bitmap decodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i2)) == null) {
            return null;
        }
        if (i3 <= 0) {
            i3 = SysOSUtil.getDensityDpi();
        }
        decodeResource.setDensity(i3);
        BitmapDescriptor fromBitmap = fromBitmap(decodeResource);
        decodeResource.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromView(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
        if (drawingCache != null) {
            drawingCache.recycle();
        }
        view.destroyDrawingCache();
        return fromBitmap;
    }

    public static BitmapDescriptor fromViewWithDpi(View view, int i2) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            Log.e(f6911b, "Get bitmap failed");
            return null;
        }
        if (i2 <= 0) {
            i2 = SysOSUtil.getDensityDpi();
        }
        drawingCache.setDensity(i2);
        BitmapDescriptor fromBitmap = fromBitmap(drawingCache);
        if (drawingCache != null) {
            drawingCache.recycle();
        }
        view.destroyDrawingCache();
        return fromBitmap;
    }
}
