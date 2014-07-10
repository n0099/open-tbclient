package com.baidu.adp.lib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private volatile SparseArray<Bitmap> b = new SparseArray<>();
    private Context c = null;
    private Bitmap.Config d = Bitmap.Config.RGB_565;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public synchronized void a(Context context) {
        this.c = context;
    }

    private b() {
    }

    public Bitmap a(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public Bitmap a(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public byte[] a(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
