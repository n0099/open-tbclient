package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a bzc;
    private static e bzd;
    private static com.baidu.poly.a.d.b bze;
    private static com.baidu.poly.a.d.a bzf;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bze = new com.baidu.poly.a.d.b();
        bzf = new com.baidu.poly.a.d.a(context);
        bzd = new e();
    }

    public static com.baidu.poly.a.d.b NX() {
        if (bze == null) {
            bze = new com.baidu.poly.a.d.b();
        }
        return bze;
    }

    public static a aH(Context context) {
        if (bzc == null) {
            synchronized (a.class) {
                if (bzc == null) {
                    bzc = new a(context);
                }
            }
        }
        return bzc;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap gC = bze.gC(str);
        if (gC != null) {
            imageView.setImageBitmap(gC);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, bzd, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aI(Context context) {
        if (bzf == null) {
            bzf = new com.baidu.poly.a.d.a(context);
        }
        return bzf;
    }
}
