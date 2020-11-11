package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a cbR;
    private static e cbS;
    private static com.baidu.poly.a.e.b cbT;
    private static com.baidu.poly.a.e.a cbU;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        cbT = new com.baidu.poly.a.e.b();
        cbU = new com.baidu.poly.a.e.a(context);
        cbS = new e();
    }

    public static a aQ(Context context) {
        if (cbR == null) {
            synchronized (a.class) {
                if (cbR == null) {
                    cbR = new a(context);
                }
            }
        }
        return cbR;
    }

    public static com.baidu.poly.a.e.b aaX() {
        if (cbT == null) {
            cbT = new com.baidu.poly.a.e.b();
        }
        return cbT;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jx = cbT.jx(str);
        if (jx != null) {
            imageView.setImageBitmap(jx);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, cbS, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aR(Context context) {
        if (cbU == null) {
            cbU = new com.baidu.poly.a.e.a(context);
        }
        return cbU;
    }
}
