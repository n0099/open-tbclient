package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes4.dex */
public class BitmapDescriptorFactory {
    static final /* synthetic */ boolean a;

    static {
        a = !BitmapDescriptorFactory.class.desiredAssertionStatus();
    }

    public static BitmapDescriptor fromAsset(String str) {
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
            BitmapDescriptor fromBitmap = fromBitmap(a2);
            if (a || a2 != null) {
                a2.recycle();
                return fromBitmap;
            }
            throw new AssertionError();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
                fromBitmap = fromBitmap(bitmap);
            } else if (densityDpi <= 320 || densityDpi > 480) {
                fromBitmap = fromBitmap(a2);
                bitmap = null;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                bitmap = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
                fromBitmap = fromBitmap(bitmap);
            }
            a2.recycle();
            if (bitmap != null) {
                bitmap.recycle();
            }
            return fromBitmap;
        } catch (Exception e) {
            e.printStackTrace();
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
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            Context context = BMapManager.getContext();
            if (context != null) {
                FileInputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                if (decodeStream != null) {
                    BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
                    decodeStream.recycle();
                    return fromBitmap;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static BitmapDescriptor fromPath(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null || decodeFile == null) {
            return null;
        }
        BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
        decodeFile.recycle();
        return fromBitmap;
    }

    public static BitmapDescriptor fromResource(int i) {
        Bitmap decodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (decodeResource = BitmapFactory.decodeResource(context.getResources(), i)) == null) {
            return null;
        }
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
}
