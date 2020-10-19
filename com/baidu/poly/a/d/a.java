package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a bNK;
    private static e bNL;
    private static com.baidu.poly.a.e.b bNM;
    private static com.baidu.poly.a.e.a bNN;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bNM = new com.baidu.poly.a.e.b();
        bNN = new com.baidu.poly.a.e.a(context);
        bNL = new e();
    }

    public static com.baidu.poly.a.e.b WE() {
        if (bNM == null) {
            bNM = new com.baidu.poly.a.e.b();
        }
        return bNM;
    }

    public static a aQ(Context context) {
        if (bNK == null) {
            synchronized (a.class) {
                if (bNK == null) {
                    bNK = new a(context);
                }
            }
        }
        return bNK;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap iR = bNM.iR(str);
        if (iR != null) {
            imageView.setImageBitmap(iR);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bNL, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aR(Context context) {
        if (bNN == null) {
            bNN = new com.baidu.poly.a.e.a(context);
        }
        return bNN;
    }
}
