package com.baidu.pano.platform.comjni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.pano.platform.c.c;
import com.baidu.pano.platform.c.d;
import com.baidu.pano.platform.c.f;
import com.baidu.pano.platform.c.g;
import com.baidu.pano.platform.c.h;
import com.baidu.pano.platform.c.i;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes5.dex */
public class AppFunctionProcessor {
    public static Object doGetSync(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        g.a("url:" + str);
        if (isPanoramaRequest(str)) {
            str = str + ETAG.ITEM_SEPARATOR + f.a((Context) obj).toString();
        }
        g.a("finalUrl:" + str);
        return c.a((Context) obj).a(str);
    }

    public static Object FileGet(String str) {
        return null;
    }

    public static Object ImageFunction(byte[] bArr) {
        Bitmap byte2Bitmap = byte2Bitmap(bArr);
        if (byte2Bitmap != null) {
            return byte2Bitmap;
        }
        return null;
    }

    public static Object DrawText(Object obj, String str, float f, int i, int i2, int i3) {
        int measureText;
        if (obj == null) {
            return null;
        }
        Context context = (Context) obj;
        int a = h.a(f, context);
        int a2 = h.a(d.a(i3), context);
        int a3 = h.a(d.b(i3), context);
        int a4 = h.a(d.c(i3), context);
        int a5 = h.a(d.d(i3), context);
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(a);
        int indexOf = str.indexOf(10, 0);
        if (indexOf == -1) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Bitmap createBitmap = Bitmap.createBitmap(((int) paint.measureText(str)) + a2 + a4, ((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) + a3 + a5, Bitmap.Config.ARGB_8888);
            canvas.setBitmap(createBitmap);
            canvas.drawColor(i2);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(i);
            canvas.drawText(str, a2 + 0, (0.0f - fontMetrics.ascent) + a3, paint);
            return createBitmap;
        }
        int i4 = indexOf + 1;
        int i5 = 2;
        int measureText2 = (int) paint.measureText(str.substring(0, indexOf));
        while (true) {
            int indexOf2 = str.indexOf(10, i4);
            if (indexOf2 <= 0) {
                break;
            }
            int measureText3 = (int) paint.measureText(str.substring(i4, indexOf2));
            if (measureText3 > measureText2) {
                measureText2 = measureText3;
            }
            i4 = indexOf2 + 1;
            i5++;
        }
        if (i4 != str.length() && (measureText = (int) paint.measureText(str.substring(i4, str.length()))) > measureText2) {
            measureText2 = measureText;
        }
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        int ceil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
        int i6 = measureText2 + a2 + a4;
        Bitmap createBitmap2 = Bitmap.createBitmap(i6, (i5 * ceil) + a3 + a5, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap2);
        canvas.drawColor(i2);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int indexOf3 = str.indexOf(10, i7);
            if (indexOf3 <= 0) {
                break;
            }
            String substring = str.substring(i7, indexOf3);
            int measureText4 = ((int) paint.measureText(substring)) + a2 + a4;
            i7 = indexOf3 + 1;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(i);
            canvas.drawText(substring, ((i6 - measureText4) / 2) + a2, ((i8 * ceil) - fontMetrics2.ascent) + a3, paint);
            i8++;
        }
        if (i7 != str.length()) {
            String substring2 = str.substring(i7, str.length());
            int measureText5 = a4 + ((int) paint.measureText(substring2)) + a2;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(i);
            canvas.drawText(substring2, a2 + ((i6 - measureText5) / 2), ((i8 * ceil) - fontMetrics2.ascent) + a3, paint);
        }
        return createBitmap2;
    }

    private static Bitmap byte2Bitmap(byte[] bArr) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        for (int i = 1; i <= 4; i++) {
            try {
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (OutOfMemoryError e) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        options.inSampleSize++;
                        System.gc();
                        break;
                }
            }
            return bitmap;
        }
        return bitmap;
    }

    private static boolean isPanoramaRequest(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(i.b) || str.contains(i.a) || str.contains(i.f) || str.contains(i.e) || str.contains(i.d) || str.contains(i.c);
    }
}
