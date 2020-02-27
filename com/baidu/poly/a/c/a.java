package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a aQq;
    private static e aQr;
    private static com.baidu.poly.a.d.b aQs;
    private static com.baidu.poly.a.d.a aQt;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aQs = new com.baidu.poly.a.d.b();
        aQt = new com.baidu.poly.a.d.a(context);
        aQr = new e();
    }

    public static com.baidu.poly.a.d.b EA() {
        if (aQs == null) {
            aQs = new com.baidu.poly.a.d.b();
        }
        return aQs;
    }

    public static a aW(Context context) {
        if (aQq == null) {
            synchronized (a.class) {
                if (aQq == null) {
                    aQq = new a(context);
                }
            }
        }
        return aQq;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap eN = aQs.eN(str);
        if (eN != null) {
            imageView.setImageBitmap(eN);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aQr, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aX(Context context) {
        if (aQt == null) {
            aQt = new com.baidu.poly.a.d.a(context);
        }
        return aQt;
    }
}
