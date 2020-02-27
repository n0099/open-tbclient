package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private ImageView aQw;
    private Handler aQx;
    private int aQy;
    private int aQz;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.aQx = handler;
        this.url = str;
        this.aQw = imageView;
        this.aQy = i;
        this.aQz = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap j(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.aX(this.context).k(str, i, i2);
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
            a.EA().e(str, bitmap2);
            return bitmap2;
        }
        a.aX(this.context).e(str);
        bitmap = a.aX(this.context).k(str, i, i2);
        if (bitmap == null) {
            bitmap = d.eL(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap j = j(this.url, this.aQy, this.aQz);
        if (this.aQx != null) {
            this.aQx.obtainMessage(1, new f(this.aQw, this.url, j)).sendToTarget();
        }
    }
}
