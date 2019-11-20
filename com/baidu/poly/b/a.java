package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a aAO;
    private static ThreadPoolExecutor aAP;
    private static e aAQ;
    private static com.baidu.poly.b.a.b aAR;
    private static com.baidu.poly.b.a.a aAS;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aAP = g.zJ();
        aAR = new com.baidu.poly.b.a.b();
        aAS = new com.baidu.poly.b.a.a(context);
        aAQ = new e();
    }

    public static a aE(Context context) {
        if (aAO == null) {
            synchronized (a.class) {
                if (aAO == null) {
                    aAO = new a(context);
                }
            }
        }
        return aAO;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap dD = aAR.dD(str);
        if (dD != null) {
            imageView.setImageBitmap(dD);
            return;
        }
        aAP.execute(new h(this.context, aAQ, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b zH() {
        if (aAR == null) {
            aAR = new com.baidu.poly.b.a.b();
        }
        return aAR;
    }

    public static com.baidu.poly.b.a.a aF(Context context) {
        if (aAS == null) {
            aAS = new com.baidu.poly.b.a.a(context);
        }
        return aAS;
    }
}
