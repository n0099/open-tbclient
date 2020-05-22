package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a buk;
    private static e bul;
    private static com.baidu.poly.a.d.b bum;
    private static com.baidu.poly.a.d.a bun;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bum = new com.baidu.poly.a.d.b();
        bun = new com.baidu.poly.a.d.a(context);
        bul = new e();
    }

    public static com.baidu.poly.a.d.b MO() {
        if (bum == null) {
            bum = new com.baidu.poly.a.d.b();
        }
        return bum;
    }

    public static a aG(Context context) {
        if (buk == null) {
            synchronized (a.class) {
                if (buk == null) {
                    buk = new a(context);
                }
            }
        }
        return buk;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap gu = bum.gu(str);
        if (gu != null) {
            imageView.setImageBitmap(gu);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, bul, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aH(Context context) {
        if (bun == null) {
            bun = new com.baidu.poly.a.d.a(context);
        }
        return bun;
    }
}
