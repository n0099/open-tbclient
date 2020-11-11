package com.baidu.fsg.face.base.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v4.internal.view.SupportMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final int f1585a = 480;
    static final int b = 480;
    static final int c = 192;
    static final int d = 728;
    static final int e = 750;
    static final int f = 1335;
    private static final String g = "LivenessFaceUtil";

    public static void a(int[] iArr, Bitmap bitmap) {
        Point point;
        Point point2;
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setStrokeWidth(4.0f);
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(-16711936);
        for (int i = 0; i < iArr.length / 2; i++) {
            canvas.drawCircle(iArr[i << 1], iArr[(i << 1) + 1], 2.0f, paint);
        }
        Rect a2 = a(iArr);
        canvas.drawRect(a2, paint);
        new Point().set(a2.centerX(), a2.centerY());
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(point.x, point.y, 5.0f, paint);
        int[] iArr2 = {bitmap.getWidth(), bitmap.getHeight()};
        new Point().set(bitmap.getWidth() / 2, (bitmap.getHeight() * d) / f);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
        int width = ((bitmap.getWidth() * 480) / 750) / 2;
        canvas.drawRect(point2.x - width, point2.y - width, point2.x + width, width + point2.y, paint);
        int width2 = ((bitmap.getWidth() * 192) / 750) / 2;
        canvas.drawRect(point2.x - width2, point2.y - width2, point2.x + width2, width2 + point2.y, paint);
    }

    public static boolean a(int[] iArr, b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar).contains(a(iArr));
    }

    private static Rect a(b bVar) {
        Rect rect = new Rect();
        if (b(bVar)) {
            if (bVar.f1583a.left - bVar.b.left < 0) {
                rect.left = 0;
            } else {
                rect.left = (int) (((bVar.f1583a.left - bVar.b.left) / bVar.b.width()) * bVar.d);
            }
            if (bVar.f1583a.top > bVar.b.top) {
                rect.top = 0;
            } else {
                rect.top = (int) (((bVar.b.top - bVar.f1583a.top) / bVar.b.height()) * bVar.c);
            }
            if (bVar.f1583a.right > bVar.b.right) {
                rect.right = bVar.d;
            } else {
                rect.right = bVar.d - ((int) (((bVar.b.right - bVar.f1583a.right) / bVar.b.width()) * bVar.d));
            }
            if (bVar.f1583a.bottom > bVar.b.bottom) {
                rect.bottom = bVar.c;
            } else {
                rect.bottom = bVar.c - ((int) (((bVar.b.bottom - bVar.f1583a.bottom) / bVar.b.height()) * bVar.c));
            }
        }
        return rect;
    }

    private static boolean b(b bVar) {
        return (bVar == null || bVar.f1583a == null || bVar.b == null) ? false : true;
    }

    public static boolean b(int[] iArr, b bVar) {
        if (b(bVar)) {
            Rect a2 = a(iArr);
            if (a2.width() > ((int) ((a(bVar).width() * 3) / 5.0f))) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(int[] iArr, b bVar) {
        if (bVar != null) {
            Rect a2 = a(iArr);
            if (a2.width() < ((int) (a(bVar).width() / 4.0f))) {
                return true;
            }
        }
        return false;
    }

    private static Rect a(int[] iArr) {
        Point point = new Point();
        Point point2 = new Point();
        if (iArr.length > 2) {
            point.x = iArr[0];
            point.y = iArr[1];
            point2.x = iArr[0];
            point2.y = iArr[1];
        }
        for (int i = 0; i < iArr.length / 2; i++) {
            float f2 = iArr[i << 1];
            float f3 = iArr[(i << 1) + 1];
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
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/awe");
            file.mkdirs();
            File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (fileOutputStream != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
