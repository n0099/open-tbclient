package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class a implements c {
    private static a aLR;
    private static e aLS;
    private static com.baidu.poly.a.d.b aLT;
    private static com.baidu.poly.a.d.a aLU;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aLT = new com.baidu.poly.a.d.b();
        aLU = new com.baidu.poly.a.d.a(context);
        aLS = new e();
    }

    public static com.baidu.poly.a.d.b Ce() {
        if (aLT == null) {
            aLT = new com.baidu.poly.a.d.b();
        }
        return aLT;
    }

    public static a aS(Context context) {
        if (aLR == null) {
            synchronized (a.class) {
                if (aLR == null) {
                    aLR = new a(context);
                }
            }
        }
        return aLR;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap ex = aLT.ex(str);
        if (ex != null) {
            imageView.setImageBitmap(ex);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aLS, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aT(Context context) {
        if (aLU == null) {
            aLU = new com.baidu.poly.a.d.a(context);
        }
        return aLU;
    }
}
