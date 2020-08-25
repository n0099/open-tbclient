package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a bEW;
    private static e bEX;
    private static com.baidu.poly.a.e.b bEY;
    private static com.baidu.poly.a.e.a bEZ;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bEY = new com.baidu.poly.a.e.b();
        bEZ = new com.baidu.poly.a.e.a(context);
        bEX = new e();
    }

    public static com.baidu.poly.a.e.b TY() {
        if (bEY == null) {
            bEY = new com.baidu.poly.a.e.b();
        }
        return bEY;
    }

    public static a aN(Context context) {
        if (bEW == null) {
            synchronized (a.class) {
                if (bEW == null) {
                    bEW = new a(context);
                }
            }
        }
        return bEW;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap hV = bEY.hV(str);
        if (hV != null) {
            imageView.setImageBitmap(hV);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bEX, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aO(Context context) {
        if (bEZ == null) {
            bEZ = new com.baidu.poly.a.e.a(context);
        }
        return bEZ;
    }
}
