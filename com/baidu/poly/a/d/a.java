package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class a implements c {
    private static a bHb;
    private static e bHc;
    private static com.baidu.poly.a.e.b bHd;
    private static com.baidu.poly.a.e.a bHe;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bHd = new com.baidu.poly.a.e.b();
        bHe = new com.baidu.poly.a.e.a(context);
        bHc = new e();
    }

    public static com.baidu.poly.a.e.b UH() {
        if (bHd == null) {
            bHd = new com.baidu.poly.a.e.b();
        }
        return bHd;
    }

    public static a aM(Context context) {
        if (bHb == null) {
            synchronized (a.class) {
                if (bHb == null) {
                    bHb = new a(context);
                }
            }
        }
        return bHb;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap ip = bHd.ip(str);
        if (ip != null) {
            imageView.setImageBitmap(ip);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bHc, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aN(Context context) {
        if (bHe == null) {
            bHe = new com.baidu.poly.a.e.a(context);
        }
        return bHe;
    }
}
