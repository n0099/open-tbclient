package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class a implements c {
    private static a bzq;
    private static e bzr;
    private static com.baidu.poly.a.e.b bzs;
    private static com.baidu.poly.a.e.a bzt;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bzs = new com.baidu.poly.a.e.b();
        bzt = new com.baidu.poly.a.e.a(context);
        bzr = new e();
    }

    public static com.baidu.poly.a.e.b Of() {
        if (bzs == null) {
            bzs = new com.baidu.poly.a.e.b();
        }
        return bzs;
    }

    public static a aI(Context context) {
        if (bzq == null) {
            synchronized (a.class) {
                if (bzq == null) {
                    bzq = new a(context);
                }
            }
        }
        return bzq;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap gB = bzs.gB(str);
        if (gB != null) {
            imageView.setImageBitmap(gB);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bzr, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aJ(Context context) {
        if (bzt == null) {
            bzt = new com.baidu.poly.a.e.a(context);
        }
        return bzt;
    }
}
