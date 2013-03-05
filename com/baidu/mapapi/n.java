package com.baidu.mapapi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
/* loaded from: classes.dex */
class n {
    private static Constructor a = null;
    private static final int b = Integer.parseInt(Build.VERSION.SDK);

    /* loaded from: classes.dex */
    enum a {
        DOUGLAS_METHOD,
        GRID_METHOD,
        DOUGLAS_MOBILE
    }

    n() {
    }

    private static double a(int i, a aVar) {
        switch (aVar) {
            case DOUGLAS_METHOD:
                double log = Math.log(Math.pow(2.6d, i));
                return 100.0d + (log * 2.6d * log);
            case DOUGLAS_MOBILE:
                return Math.pow(2.0d, i) * 4.0d;
            case GRID_METHOD:
                return 100.0d + (Math.log(Math.pow(2.6d, i)) * 65.0d);
            default:
                return 100.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ArrayList arrayList, ArrayList arrayList2, int i, ArrayList arrayList3) {
        if (arrayList == null || arrayList2 == null || arrayList3 == null) {
            return -1;
        }
        arrayList3.clear();
        a(arrayList, arrayList2, arrayList3, a(18 - i, a.DOUGLAS_MOBILE));
        return 0;
    }

    static int a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, double d) {
        int size = arrayList.size();
        if (size < 2) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = 1;
        }
        a(arrayList2, iArr, 0, size - 1, d);
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (iArr[i3] > 0) {
                arrayList3.add(arrayList.get(i3));
                i2++;
            }
        }
        return i2;
    }

    static int a(ArrayList arrayList, int[] iArr, int i, int i2, double d) {
        if (i2 > i + 1) {
            double d2 = d * d * 100.0d * 100.0d;
            long j = -1;
            int i3 = i + 1;
            int i4 = 0;
            while (i3 < i2) {
                long a2 = a((GeoPoint) arrayList.get(i3), (GeoPoint) arrayList.get(i), (GeoPoint) arrayList.get(i2));
                if (a2 > j) {
                    i4 = i3;
                } else {
                    a2 = j;
                }
                i3++;
                j = a2;
            }
            if (j >= d2) {
                a(arrayList, iArr, i, i4, d);
                a(arrayList, iArr, i4, i2, d);
            } else {
                for (int i5 = i + 1; i5 < i2; i5++) {
                    iArr[i5] = 0;
                }
            }
        }
        return 0;
    }

    static long a(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        long longitudeE6 = geoPoint.getLongitudeE6();
        long latitudeE6 = geoPoint.getLatitudeE6();
        long longitudeE62 = geoPoint2.getLongitudeE6();
        long latitudeE62 = geoPoint2.getLatitudeE6();
        long longitudeE63 = geoPoint3.getLongitudeE6();
        long latitudeE63 = geoPoint3.getLatitudeE6();
        long j = longitudeE62 - longitudeE63;
        long j2 = latitudeE62 - latitudeE63;
        long j3 = (j * j) + (j2 * j2);
        if (j3 == 0) {
            long j4 = longitudeE6 - longitudeE62;
            long j5 = latitudeE6 - latitudeE62;
            return (j4 * j4) + (j5 * j5);
        }
        double d = (((latitudeE62 - latitudeE6) * (latitudeE62 - latitudeE63)) - ((longitudeE62 - longitudeE6) * (longitudeE63 - longitudeE62))) / j3;
        if (d <= 1.0d && d >= 0.0d) {
            long j6 = ((latitudeE62 - latitudeE6) * (-(longitudeE62 - longitudeE63))) - ((longitudeE62 - longitudeE6) * (latitudeE63 - latitudeE62));
            return (long) (j6 * (j6 / j3));
        }
        long j7 = longitudeE6 - longitudeE62;
        long j8 = longitudeE6 - longitudeE63;
        long j9 = latitudeE6 - latitudeE62;
        long j10 = latitudeE6 - latitudeE63;
        long j11 = (j9 * j9) + (j7 * j7);
        long j12 = (j10 * j10) + (j8 * j8);
        return j11 >= j12 ? j12 : j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            if (b < 4) {
                return new BitmapDrawable(decodeStream);
            }
            Resources resources = context.getResources();
            if (a == null) {
                a = Class.forName("android.graphics.drawable.BitmapDrawable").getConstructor(Resources.class, Bitmap.class);
            }
            return (Drawable) a.newInstance(resources, decodeStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(Context context, String str, float f) {
        try {
            InputStream open = context.getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            if (b < 4) {
                return new BitmapDrawable(createBitmap);
            }
            Resources resources = context.getResources();
            if (a == null) {
                a = Class.forName("android.graphics.drawable.BitmapDrawable").getConstructor(Resources.class, Bitmap.class);
            }
            return (Drawable) a.newInstance(resources, createBitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Point point, Point point2, int i, int i2) {
        if (point.x > 0 || point2.x > 0) {
            if (point.x < i || point2.x < i) {
                if (point.y > 0 || point2.y > 0) {
                    return point.y < i2 || point2.y < i2;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
