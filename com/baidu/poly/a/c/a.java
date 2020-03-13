package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a aQs;
    private static e aQt;
    private static com.baidu.poly.a.d.b aQu;
    private static com.baidu.poly.a.d.a aQv;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aQu = new com.baidu.poly.a.d.b();
        aQv = new com.baidu.poly.a.d.a(context);
        aQt = new e();
    }

    public static com.baidu.poly.a.d.b EC() {
        if (aQu == null) {
            aQu = new com.baidu.poly.a.d.b();
        }
        return aQu;
    }

    public static a aW(Context context) {
        if (aQs == null) {
            synchronized (a.class) {
                if (aQs == null) {
                    aQs = new a(context);
                }
            }
        }
        return aQs;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap eN = aQu.eN(str);
        if (eN != null) {
            imageView.setImageBitmap(eN);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aQt, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aX(Context context) {
        if (aQv == null) {
            aQv = new com.baidu.poly.a.d.a(context);
        }
        return aQv;
    }
}
