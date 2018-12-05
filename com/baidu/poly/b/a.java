package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a ahK;
    private static ThreadPoolExecutor ahL;
    private static e ahM;
    private static com.baidu.poly.b.a.b ahN;
    private static com.baidu.poly.b.a.a ahO;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        ahL = g.uu();
        ahN = new com.baidu.poly.b.a.b();
        ahO = new com.baidu.poly.b.a.a(context);
        ahM = new e();
    }

    public static a bo(Context context) {
        if (ahK == null) {
            synchronized (a.class) {
                if (ahK == null) {
                    ahK = new a(context);
                }
            }
        }
        return ahK;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap dm = ahN.dm(str);
        if (dm != null) {
            imageView.setImageBitmap(dm);
            return;
        }
        ahL.execute(new h(this.context, ahM, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b us() {
        if (ahN == null) {
            ahN = new com.baidu.poly.b.a.b();
        }
        return ahN;
    }

    public static com.baidu.poly.b.a.a bp(Context context) {
        if (ahO == null) {
            ahO = new com.baidu.poly.b.a.a(context);
        }
        return ahO;
    }
}
