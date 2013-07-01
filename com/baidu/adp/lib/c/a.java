package com.baidu.adp.lib.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f135a = null;
    private volatile Hashtable b = new Hashtable();
    private Context c = null;
    private Bitmap.Config d = Bitmap.Config.RGB_565;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f135a == null) {
                f135a = new a();
            }
            aVar = f135a;
        }
        return aVar;
    }

    public void a(Context context) {
        this.c = context;
    }

    private a() {
    }

    public Bitmap a(int i) {
        Bitmap bitmap = (Bitmap) this.b.get(Integer.valueOf(i));
        if (bitmap == null && (bitmap = a(this.c, i)) != null) {
            this.b.put(Integer.valueOf(i), bitmap);
        }
        return bitmap;
    }

    public Bitmap a(Context context, int i) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 16 || this.d == null) {
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            } else {
                options.inPreferredConfig = this.d;
            }
            bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
            return bitmap;
        } catch (Exception e) {
            b.a(e.getMessage());
            return bitmap;
        }
    }
}
