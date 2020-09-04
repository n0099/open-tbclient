package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a bFa;
    private static e bFb;
    private static com.baidu.poly.a.e.b bFc;
    private static com.baidu.poly.a.e.a bFd;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        bFc = new com.baidu.poly.a.e.b();
        bFd = new com.baidu.poly.a.e.a(context);
        bFb = new e();
    }

    public static com.baidu.poly.a.e.b TY() {
        if (bFc == null) {
            bFc = new com.baidu.poly.a.e.b();
        }
        return bFc;
    }

    public static a aN(Context context) {
        if (bFa == null) {
            synchronized (a.class) {
                if (bFa == null) {
                    bFa = new a(context);
                }
            }
        }
        return bFa;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap hW = bFc.hW(str);
        if (hW != null) {
            imageView.setImageBitmap(hW);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, bFb, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aO(Context context) {
        if (bFd == null) {
            bFd = new com.baidu.poly.a.e.a(context);
        }
        return bFd;
    }
}
