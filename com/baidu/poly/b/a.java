package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a ahI;
    private static ThreadPoolExecutor ahJ;
    private static e ahK;
    private static com.baidu.poly.b.a.b ahL;
    private static com.baidu.poly.b.a.a ahM;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        ahJ = g.uO();
        ahL = new com.baidu.poly.b.a.b();
        ahM = new com.baidu.poly.b.a.a(context);
        ahK = new e();
    }

    public static a aA(Context context) {
        if (ahI == null) {
            synchronized (a.class) {
                if (ahI == null) {
                    ahI = new a(context);
                }
            }
        }
        return ahI;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap cT = ahL.cT(str);
        if (cT != null) {
            imageView.setImageBitmap(cT);
            return;
        }
        ahJ.execute(new h(this.context, ahK, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b uM() {
        if (ahL == null) {
            ahL = new com.baidu.poly.b.a.b();
        }
        return ahL;
    }

    public static com.baidu.poly.b.a.a aB(Context context) {
        if (ahM == null) {
            ahM = new com.baidu.poly.b.a.a(context);
        }
        return ahM;
    }
}
