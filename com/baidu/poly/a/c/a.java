package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a bmI;
    private static e bmJ;
    private static com.baidu.poly.a.d.b bmK;
    private static com.baidu.poly.a.d.a bmL;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bmK = new com.baidu.poly.a.d.b();
        bmL = new com.baidu.poly.a.d.a(context);
        bmJ = new e();
    }

    public static com.baidu.poly.a.d.b KT() {
        if (bmK == null) {
            bmK = new com.baidu.poly.a.d.b();
        }
        return bmK;
    }

    public static a aI(Context context) {
        if (bmI == null) {
            synchronized (a.class) {
                if (bmI == null) {
                    bmI = new a(context);
                }
            }
        }
        return bmI;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap fH = bmK.fH(str);
        if (fH != null) {
            imageView.setImageBitmap(fH);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, bmJ, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aJ(Context context) {
        if (bmL == null) {
            bmL = new com.baidu.poly.a.d.a(context);
        }
        return bmL;
    }
}
