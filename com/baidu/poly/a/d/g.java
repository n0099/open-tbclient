package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes3.dex */
public class g implements Runnable {
    private ImageView cjc;
    private Handler cjd;
    private int cje;
    private int cjf;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.cjd = handler;
        this.url = str;
        this.cjc = imageView;
        this.cje = i;
        this.cjf = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap l(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.bK(this.context).m(str, i, i2);
            try {
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                bitmap = bitmap2;
                if (bitmap == null) {
                }
                return bitmap;
            }
        } catch (IOException e2) {
            e = e2;
        }
        if (bitmap2 != null) {
            a.abA().e(str, bitmap2);
            return bitmap2;
        }
        a.bK(this.context).d(str);
        bitmap = a.bK(this.context).m(str, i, i2);
        if (bitmap == null) {
            bitmap = d.iH(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap l = l(this.url, this.cje, this.cjf);
        if (this.cjd != null) {
            this.cjd.obtainMessage(1, new f(this.cjc, this.url, l)).sendToTarget();
        }
    }
}
