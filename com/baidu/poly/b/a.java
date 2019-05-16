package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class a implements c {
    private static a agN;
    private static ThreadPoolExecutor agO;
    private static e agP;
    private static com.baidu.poly.b.a.b agQ;
    private static com.baidu.poly.b.a.a agR;
    private Context context;

    private a(Context context) {
        this.context = context.getApplicationContext();
        agO = g.uk();
        agQ = new com.baidu.poly.b.a.b();
        agR = new com.baidu.poly.b.a.a(context);
        agP = new e();
    }

    public static a aA(Context context) {
        if (agN == null) {
            synchronized (a.class) {
                if (agN == null) {
                    agN = new a(context);
                }
            }
        }
        return agN;
    }

    @Override // com.baidu.poly.b.c
    public void a(ImageView imageView, String str) {
        a(imageView, str, 0, 0);
    }

    public void a(ImageView imageView, String str, int i, int i2) {
        imageView.setTag(str);
        Bitmap cN = agQ.cN(str);
        if (cN != null) {
            imageView.setImageBitmap(cN);
            return;
        }
        agO.execute(new h(this.context, agP, str, imageView, i, i2));
    }

    public static com.baidu.poly.b.a.b ui() {
        if (agQ == null) {
            agQ = new com.baidu.poly.b.a.b();
        }
        return agQ;
    }

    public static com.baidu.poly.b.a.a aB(Context context) {
        if (agR == null) {
            agR = new com.baidu.poly.b.a.a(context);
        }
        return agR;
    }
}
