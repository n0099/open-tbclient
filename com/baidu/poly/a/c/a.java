package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class a implements c {
    private static a aKZ;
    private static e aLa;
    private static com.baidu.poly.a.d.b aLb;
    private static com.baidu.poly.a.d.a aLc;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aLb = new com.baidu.poly.a.d.b();
        aLc = new com.baidu.poly.a.d.a(context);
        aLa = new e();
    }

    public static com.baidu.poly.a.d.b BI() {
        if (aLb == null) {
            aLb = new com.baidu.poly.a.d.b();
        }
        return aLb;
    }

    public static a aS(Context context) {
        if (aKZ == null) {
            synchronized (a.class) {
                if (aKZ == null) {
                    aKZ = new a(context);
                }
            }
        }
        return aKZ;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap eu = aLb.eu(str);
        if (eu != null) {
            imageView.setImageBitmap(eu);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aLa, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aT(Context context) {
        if (aLc == null) {
            aLc = new com.baidu.poly.a.d.a(context);
        }
        return aLc;
    }
}
