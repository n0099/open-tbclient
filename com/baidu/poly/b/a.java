package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a aBg;
    private static ThreadPoolExecutor aBh;
    private static e aBi;
    private static com.baidu.poly.b.a.b aBj;
    private static com.baidu.poly.b.a.a aBk;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aBh = g.zI();
        aBj = new com.baidu.poly.b.a.b();
        aBk = new com.baidu.poly.b.a.a(context);
        aBi = new e();
    }

    public static a aE(Context context) {
        if (aBg == null) {
            synchronized (a.class) {
                if (aBg == null) {
                    aBg = new a(context);
                }
            }
        }
        return aBg;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap dD = aBj.dD(str);
        if (dD != null) {
            imageView.setImageBitmap(dD);
            return;
        }
        aBh.execute(new h(this.context, aBi, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b zG() {
        if (aBj == null) {
            aBj = new com.baidu.poly.b.a.b();
        }
        return aBj;
    }

    public static com.baidu.poly.b.a.a aF(Context context) {
        if (aBk == null) {
            aBk = new com.baidu.poly.b.a.a(context);
        }
        return aBk;
    }
}
