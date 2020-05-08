package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a bmN;
    private static e bmO;
    private static com.baidu.poly.a.d.b bmP;
    private static com.baidu.poly.a.d.a bmQ;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bmP = new com.baidu.poly.a.d.b();
        bmQ = new com.baidu.poly.a.d.a(context);
        bmO = new e();
    }

    public static com.baidu.poly.a.d.b KS() {
        if (bmP == null) {
            bmP = new com.baidu.poly.a.d.b();
        }
        return bmP;
    }

    public static a aw(Context context) {
        if (bmN == null) {
            synchronized (a.class) {
                if (bmN == null) {
                    bmN = new a(context);
                }
            }
        }
        return bmN;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap fH = bmP.fH(str);
        if (fH != null) {
            imageView.setImageBitmap(fH);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, bmO, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a ax(Context context) {
        if (bmQ == null) {
            bmQ = new com.baidu.poly.a.d.a(context);
        }
        return bmQ;
    }
}
