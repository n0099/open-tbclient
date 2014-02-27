package com.baidu.adp.lib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class a {
    private static a a = null;
    private volatile Hashtable<Integer, Bitmap> b = new Hashtable<>();
    private Context c = null;
    private Bitmap.Config d = Bitmap.Config.RGB_565;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(Context context) {
        this.c = context;
    }

    private a() {
    }

    public final Bitmap a(int i) {
        Bitmap bitmap = this.b.get(Integer.valueOf(i));
        if (bitmap == null && (bitmap = a(this.c, i)) != null) {
            this.b.put(Integer.valueOf(i), bitmap);
        }
        return bitmap;
    }

    public static Bitmap a(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap a(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Exception e) {
            e.b(e.getMessage());
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
