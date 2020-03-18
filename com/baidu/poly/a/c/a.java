package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class a implements c {
    private static a aQF;
    private static e aQG;
    private static com.baidu.poly.a.d.b aQH;
    private static com.baidu.poly.a.d.a aQI;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        aQH = new com.baidu.poly.a.d.b();
        aQI = new com.baidu.poly.a.d.a(context);
        aQG = new e();
    }

    public static com.baidu.poly.a.d.b EI() {
        if (aQH == null) {
            aQH = new com.baidu.poly.a.d.b();
        }
        return aQH;
    }

    public static a aV(Context context) {
        if (aQF == null) {
            synchronized (a.class) {
                if (aQF == null) {
                    aQF = new a(context);
                }
            }
        }
        return aQF;
    }

    @Override // com.baidu.poly.a.c.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap eM = aQH.eM(str);
        if (eM != null) {
            imageView.setImageBitmap(eM);
        } else {
            com.baidu.poly.b.a.execute(new g(this.context, aQG, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.d.a aW(Context context) {
        if (aQI == null) {
            aQI = new com.baidu.poly.a.d.a(context);
        }
        return aQI;
    }
}
