package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class a implements c {
    private static a ciW;
    private static e ciX;
    private static com.baidu.poly.a.e.b ciY;
    private static com.baidu.poly.a.e.a ciZ;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        ciY = new com.baidu.poly.a.e.b();
        ciZ = new com.baidu.poly.a.e.a(context);
        ciX = new e();
    }

    public static com.baidu.poly.a.e.b abA() {
        if (ciY == null) {
            ciY = new com.baidu.poly.a.e.b();
        }
        return ciY;
    }

    public static a bJ(Context context) {
        if (ciW == null) {
            synchronized (a.class) {
                if (ciW == null) {
                    ciW = new a(context);
                }
            }
        }
        return ciW;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap iJ = ciY.iJ(str);
        if (iJ != null) {
            imageView.setImageBitmap(iJ);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, ciX, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a bK(Context context) {
        if (ciZ == null) {
            ciZ = new com.baidu.poly.a.e.a(context);
        }
        return ciZ;
    }
}
