package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes14.dex */
public class a implements c {
    private static a coN;
    private static e coO;
    private static com.baidu.poly.a.e.b coP;
    private static com.baidu.poly.a.e.a coQ;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        coP = new com.baidu.poly.a.e.b();
        coQ = new com.baidu.poly.a.e.a(context);
        coO = new e();
    }

    public static com.baidu.poly.a.e.b adr() {
        if (coP == null) {
            coP = new com.baidu.poly.a.e.b();
        }
        return coP;
    }

    public static a bL(Context context) {
        if (coN == null) {
            synchronized (a.class) {
                if (coN == null) {
                    coN = new a(context);
                }
            }
        }
        return coN;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap ju = coP.ju(str);
        if (ju != null) {
            imageView.setImageBitmap(ju);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, coO, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a bM(Context context) {
        if (coQ == null) {
            coQ = new com.baidu.poly.a.e.a(context);
        }
        return coQ;
    }
}
