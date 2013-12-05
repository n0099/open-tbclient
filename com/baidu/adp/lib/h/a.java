package com.baidu.adp.lib.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f501a = null;
    private volatile Hashtable<Integer, Bitmap> b = new Hashtable<>();
    private Context c = null;
    private Bitmap.Config d = Bitmap.Config.RGB_565;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f501a == null) {
                f501a = new a();
            }
            aVar = f501a;
        }
        return aVar;
    }

    public void a(Context context) {
        this.c = context;
    }

    private a() {
    }

    public Bitmap a(int i) {
        Bitmap bitmap = this.b.get(Integer.valueOf(i));
        if (bitmap == null && (bitmap = a(this.c, i)) != null) {
            this.b.put(Integer.valueOf(i), bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public Bitmap a(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Exception e) {
            e.a(e.getMessage());
            return null;
        }
    }

    public byte[] a(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
