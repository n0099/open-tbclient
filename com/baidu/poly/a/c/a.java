package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a aQr;
    private static e aQs;
    private static com.baidu.poly.a.d.b aQt;
    private static com.baidu.poly.a.d.a aQu;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aQt = new com.baidu.poly.a.d.b();
        aQu = new com.baidu.poly.a.d.a(context);
        aQs = new e();
    }

    public static com.baidu.poly.a.d.b EC() {
        if (aQt == null) {
            aQt = new com.baidu.poly.a.d.b();
        }
        return aQt;
    }

    public static a aW(Context context) {
        if (aQr == null) {
            synchronized (a.class) {
                if (aQr == null) {
                    aQr = new a(context);
                }
            }
        }
        return aQr;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap eN = aQt.eN(str);
        if (eN != null) {
            imageView.setImageBitmap(eN);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aQs, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aX(Context context) {
        if (aQu == null) {
            aQu = new com.baidu.poly.a.d.a(context);
        }
        return aQu;
    }
}
