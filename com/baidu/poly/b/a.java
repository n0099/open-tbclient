package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static e agA;
    private static com.baidu.poly.b.a.b agB;
    private static com.baidu.poly.b.a.a agC;
    private static a agy;
    private static ThreadPoolExecutor agz;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        agz = g.tA();
        agB = new com.baidu.poly.b.a.b();
        agC = new com.baidu.poly.b.a.a(context);
        agA = new e();
    }

    public static a bg(Context context) {
        if (agy == null) {
            synchronized (a.class) {
                if (agy == null) {
                    agy = new a(context);
                }
            }
        }
        return agy;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap cZ = agB.cZ(str);
        if (cZ != null) {
            imageView.setImageBitmap(cZ);
            return;
        }
        agz.execute(new h(this.context, agA, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b ty() {
        if (agB == null) {
            agB = new com.baidu.poly.b.a.b();
        }
        return agB;
    }

    public static com.baidu.poly.b.a.a bh(Context context) {
        if (agC == null) {
            agC = new com.baidu.poly.b.a.a(context);
        }
        return agC;
    }
}
