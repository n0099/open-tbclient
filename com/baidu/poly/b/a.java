package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a ahT;
    private static ThreadPoolExecutor ahU;
    private static e ahV;
    private static com.baidu.poly.b.a.b ahW;
    private static com.baidu.poly.b.a.a ahX;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        ahU = g.uy();
        ahW = new com.baidu.poly.b.a.b();
        ahX = new com.baidu.poly.b.a.a(context);
        ahV = new e();
    }

    public static a bo(Context context) {
        if (ahT == null) {
            synchronized (a.class) {
                if (ahT == null) {
                    ahT = new a(context);
                }
            }
        }
        return ahT;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap dn = ahW.dn(str);
        if (dn != null) {
            imageView.setImageBitmap(dn);
            return;
        }
        ahU.execute(new h(this.context, ahV, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b uw() {
        if (ahW == null) {
            ahW = new com.baidu.poly.b.a.b();
        }
        return ahW;
    }

    public static com.baidu.poly.b.a.a bp(Context context) {
        if (ahX == null) {
            ahX = new com.baidu.poly.b.a.a(context);
        }
        return ahX;
    }
}
