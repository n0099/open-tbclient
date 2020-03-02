package com.baidu.poly.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes11.dex */
public class g implements Runnable {
    private int aQA;
    private ImageView aQx;
    private Handler aQy;
    private int aQz;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.aQy = handler;
        this.url = str;
        this.aQx = imageView;
        this.aQz = i;
        this.aQA = i2;
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
            a.EC().e(str, bitmap2);
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
        Bitmap j = j(this.url, this.aQz, this.aQA);
        if (this.aQy != null) {
            this.aQy.obtainMessage(1, new f(this.aQx, this.url, j)).sendToTarget();
        }
    }
}
