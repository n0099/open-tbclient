package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class a implements c {
    private static a cag;
    private static e cah;
    private static com.baidu.poly.a.e.b cai;
    private static com.baidu.poly.a.e.a caj;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        cai = new com.baidu.poly.a.e.b();
        caj = new com.baidu.poly.a.e.a(context);
        cah = new e();
    }

    public static a aQ(Context context) {
        if (cag == null) {
            synchronized (a.class) {
                if (cag == null) {
                    cag = new a(context);
                }
            }
        }
        return cag;
    }

    public static com.baidu.poly.a.e.b aao() {
        if (cai == null) {
            cai = new com.baidu.poly.a.e.b();
        }
        return cai;
    }

    @Override // com.baidu.poly.a.d.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap jr = cai.jr(str);
        if (jr != null) {
            imageView.setImageBitmap(jr);
        } else {
            com.baidu.poly.c.a.execute(new g(this.context, cah, str, imageView, i, i2));
        }
    }

    public static com.baidu.poly.a.e.a aR(Context context) {
        if (caj == null) {
            caj = new com.baidu.poly.a.e.a(context);
        }
        return caj;
    }
}
