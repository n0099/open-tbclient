package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a agE;
    private static ThreadPoolExecutor agF;
    private static e agG;
    private static com.baidu.poly.b.a.b agH;
    private static com.baidu.poly.b.a.a agI;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        agF = g.tz();
        agH = new com.baidu.poly.b.a.b();
        agI = new com.baidu.poly.b.a.a(context);
        agG = new e();
    }

    public static a bg(Context context) {
        if (agE == null) {
            synchronized (a.class) {
                if (agE == null) {
                    agE = new a(context);
                }
            }
        }
        return agE;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap db = agH.db(str);
        if (db != null) {
            imageView.setImageBitmap(db);
            return;
        }
        agF.execute(new h(this.context, agG, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b tx() {
        if (agH == null) {
            agH = new com.baidu.poly.b.a.b();
        }
        return agH;
    }

    public static com.baidu.poly.b.a.a bh(Context context) {
        if (agI == null) {
            agI = new com.baidu.poly.b.a.a(context);
        }
        return agI;
    }
}
