package com.baidu.fsg.face.base.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5609a = 480;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5610b = 480;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5611c = 192;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5612d = 728;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5613e = 750;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5614f = 1335;

    /* renamed from: g  reason: collision with root package name */
    public static final String f5615g = "LivenessFaceUtil";

    public static void a(int[] iArr, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setStrokeWidth(4.0f);
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(-16711936);
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = i << 1;
            canvas.drawCircle(iArr[i2], iArr[i2 + 1], 2.0f, paint);
        }
        Rect a2 = a(iArr);
        canvas.drawRect(a2, paint);
        Point point = new Point();
        point.set(a2.centerX(), a2.centerY());
        paint.setColor(-65536);
        canvas.drawCircle(point.x, point.y, 5.0f, paint);
        bitmap.getWidth();
        bitmap.getHeight();
        Point point2 = new Point();
        point2.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
        paint.setColor(-65536);
        canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
        int width = ((bitmap.getWidth() * 480) / 750) / 2;
        int i3 = point2.x;
        int i4 = point2.y;
        canvas.drawRect(i3 - width, i4 - width, i3 + width, i4 + width, paint);
        int width2 = ((bitmap.getWidth() * 192) / 750) / 2;
        int i5 = point2.x;
        int i6 = point2.y;
        canvas.drawRect(i5 - width2, i6 - width2, i5 + width2, i6 + width2, paint);
    }

    public static boolean b(b bVar) {
        return (bVar == null || bVar.f5602a == null || bVar.f5603b == null) ? false : true;
    }

    public static boolean c(int[] iArr, b bVar) {
        if (bVar != null) {
            return a(iArr).width() < ((int) (((float) a(bVar).width()) / 4.0f));
        }
        return false;
    }

    public static boolean b(int[] iArr, b bVar) {
        if (b(bVar)) {
            return a(iArr).width() > ((int) (((float) (a(bVar).width() * 3)) / 5.0f));
        }
        return false;
    }

    public static boolean a(int[] iArr, b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar).contains(a(iArr));
    }

    public static Rect a(b bVar) {
        Rect rect = new Rect();
        if (b(bVar)) {
            int i = bVar.f5602a.left;
            Rect rect2 = bVar.f5603b;
            int i2 = rect2.left;
            if (i - i2 < 0) {
                rect.left = 0;
            } else {
                rect.left = (int) (((i - i2) / rect2.width()) * bVar.f5605d);
            }
            int i3 = bVar.f5602a.top;
            Rect rect3 = bVar.f5603b;
            int i4 = rect3.top;
            if (i3 > i4) {
                rect.top = 0;
            } else {
                rect.top = (int) (((i4 - i3) / rect3.height()) * bVar.f5604c);
            }
            int i5 = bVar.f5602a.right;
            Rect rect4 = bVar.f5603b;
            int i6 = rect4.right;
            if (i5 > i6) {
                rect.right = bVar.f5605d;
            } else {
                rect.right = bVar.f5605d - ((int) (((i6 - i5) / rect4.width()) * bVar.f5605d));
            }
            int i7 = bVar.f5602a.bottom;
            Rect rect5 = bVar.f5603b;
            int i8 = rect5.bottom;
            if (i7 > i8) {
                rect.bottom = bVar.f5604c;
            } else {
                rect.bottom = bVar.f5604c - ((int) (((i8 - i7) / rect5.height()) * bVar.f5604c));
            }
            return rect;
        }
        return rect;
    }

    public static Rect a(int[] iArr) {
        Point point = new Point();
        Point point2 = new Point();
        if (iArr.length > 2) {
            point.x = iArr[0];
            point.y = iArr[1];
            point2.x = iArr[0];
            point2.y = iArr[1];
        }
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = i << 1;
            float f2 = iArr[i2];
            float f3 = iArr[i2 + 1];
            if (f2 < point.x) {
                point.x = (int) f2;
            }
            if (f3 < point.y) {
                point.y = (int) f3;
            }
            if (f2 > point2.x) {
                point2.x = (int) f2;
            }
            if (f3 > point2.y) {
                point2.y = (int) f3;
            }
        }
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    public static void a(Bitmap bitmap) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe");
            file.mkdirs();
            File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
