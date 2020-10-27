package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a bWh;
    private static e bWi;
    private static com.baidu.poly.a.e.b bWj;
    private static com.baidu.poly.a.e.a bWk;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bWj = new com.baidu.poly.a.e.b();
        bWk = new com.baidu.poly.a.e.a(context);
        bWi = new e();
    }

    public static com.baidu.poly.a.e.b Yy() {
        if (bWj == null) {
            bWj = new com.baidu.poly.a.e.b();
        }
        return bWj;
    }

    public static a aQ(Context context) {
        if (bWh == null) {
            synchronized (a.class) {
                if (bWh == null) {
                    bWh = new a(context);
                }
            }
        }
        return bWh;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jk = bWj.jk(str);
        if (jk != null) {
            imageView.setImageBitmap(jk);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bWi, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aR(Context context) {
        if (bWk == null) {
            bWk = new com.baidu.poly.a.e.a(context);
        }
        return bWk;
    }
}
