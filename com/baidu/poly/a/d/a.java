package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class a implements c {
    private static a cnl;
    private static e cnm;
    private static com.baidu.poly.a.e.b cnn;
    private static com.baidu.poly.a.e.a cno;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        cnn = new com.baidu.poly.a.e.b();
        cno = new com.baidu.poly.a.e.a(context);
        cnm = new e();
    }

    public static com.baidu.poly.a.e.b ado() {
        if (cnn == null) {
            cnn = new com.baidu.poly.a.e.b();
        }
        return cnn;
    }

    public static a bM(Context context) {
        if (cnl == null) {
            synchronized (a.class) {
                if (cnl == null) {
                    cnl = new a(context);
                }
            }
        }
        return cnl;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jo = cnn.jo(str);
        if (jo != null) {
            imageView.setImageBitmap(jo);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, cnm, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a bN(Context context) {
        if (cno == null) {
            cno = new com.baidu.poly.a.e.a(context);
        }
        return cno;
    }
}
