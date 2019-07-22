package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a ahm;
    private static ThreadPoolExecutor ahn;
    private static e aho;
    private static com.baidu.poly.b.a.b ahp;
    private static com.baidu.poly.b.a.a ahq;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        ahn = g.uK();
        ahp = new com.baidu.poly.b.a.b();
        ahq = new com.baidu.poly.b.a.a(context);
        aho = new e();
    }

    public static a aA(Context context) {
        if (ahm == null) {
            synchronized (a.class) {
                if (ahm == null) {
                    ahm = new a(context);
                }
            }
        }
        return ahm;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap cR = ahp.cR(str);
        if (cR != null) {
            imageView.setImageBitmap(cR);
            return;
        }
        ahn.execute(new h(this.context, aho, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b uI() {
        if (ahp == null) {
            ahp = new com.baidu.poly.b.a.b();
        }
        return ahp;
    }

    public static com.baidu.poly.b.a.a aB(Context context) {
        if (ahq == null) {
            ahq = new com.baidu.poly.b.a.a(context);
        }
        return ahq;
    }
}
