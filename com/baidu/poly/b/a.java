package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static com.baidu.poly.b.a.b agA;
    private static com.baidu.poly.b.a.a agB;
    private static a agx;
    private static ThreadPoolExecutor agy;
    private static e agz;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        agy = g.tA();
        agA = new com.baidu.poly.b.a.b();
        agB = new com.baidu.poly.b.a.a(context);
        agz = new e();
    }

    public static a bg(Context context) {
        if (agx == null) {
            synchronized (a.class) {
                if (agx == null) {
                    agx = new a(context);
                }
            }
        }
        return agx;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap cZ = agA.cZ(str);
        if (cZ != null) {
            imageView.setImageBitmap(cZ);
            return;
        }
        agy.execute(new h(this.context, agz, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b ty() {
        if (agA == null) {
            agA = new com.baidu.poly.b.a.b();
        }
        return agA;
    }

    public static com.baidu.poly.b.a.a bh(Context context) {
        if (agB == null) {
            agB = new com.baidu.poly.b.a.a(context);
        }
        return agB;
    }
}
