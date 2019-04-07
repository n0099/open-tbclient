package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a agD;
    private static ThreadPoolExecutor agE;
    private static e agF;
    private static com.baidu.poly.b.a.b agG;
    private static com.baidu.poly.b.a.a agH;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        agE = g.tz();
        agG = new com.baidu.poly.b.a.b();
        agH = new com.baidu.poly.b.a.a(context);
        agF = new e();
    }

    public static a bg(Context context) {
        if (agD == null) {
            synchronized (a.class) {
                if (agD == null) {
                    agD = new a(context);
                }
            }
        }
        return agD;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap db = agG.db(str);
        if (db != null) {
            imageView.setImageBitmap(db);
            return;
        }
        agE.execute(new h(this.context, agF, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b tx() {
        if (agG == null) {
            agG = new com.baidu.poly.b.a.b();
        }
        return agG;
    }

    public static com.baidu.poly.b.a.a bh(Context context) {
        if (agH == null) {
            agH = new com.baidu.poly.b.a.a(context);
        }
        return agH;
    }
}
