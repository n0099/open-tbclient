package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class a implements c {
    private static a cnK;
    private static e cnL;
    private static com.baidu.poly.a.e.b cnM;
    private static com.baidu.poly.a.e.a cnN;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        cnM = new com.baidu.poly.a.e.b();
        cnN = new com.baidu.poly.a.e.a(context);
        cnL = new e();
    }

    public static com.baidu.poly.a.e.b aft() {
        if (cnM == null) {
            cnM = new com.baidu.poly.a.e.b();
        }
        return cnM;
    }

    public static a bK(Context context) {
        if (cnK == null) {
            synchronized (a.class) {
                if (cnK == null) {
                    cnK = new a(context);
                }
            }
        }
        return cnK;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jU = cnM.jU(str);
        if (jU != null) {
            imageView.setImageBitmap(jU);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, cnL, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a bL(Context context) {
        if (cnN == null) {
            cnN = new com.baidu.poly.a.e.a(context);
        }
        return cnN;
    }
}
