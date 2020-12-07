package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes19.dex */
public class a implements c {
    private static a cgH;
    private static e cgI;
    private static com.baidu.poly.a.e.b cgJ;
    private static com.baidu.poly.a.e.a cgK;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        cgJ = new com.baidu.poly.a.e.b();
        cgK = new com.baidu.poly.a.e.a(context);
        cgI = new e();
    }

    public static com.baidu.poly.a.e.b adw() {
        if (cgJ == null) {
            cgJ = new com.baidu.poly.a.e.b();
        }
        return cgJ;
    }

    public static a bw(Context context) {
        if (cgH == null) {
            synchronized (a.class) {
                if (cgH == null) {
                    cgH = new a(context);
                }
            }
        }
        return cgH;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jY = cgJ.jY(str);
        if (jY != null) {
            imageView.setImageBitmap(jY);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, cgI, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a bx(Context context) {
        if (cgK == null) {
            cgK = new com.baidu.poly.a.e.a(context);
        }
        return cgK;
    }
}
