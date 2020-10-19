package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private ImageView bNQ;
    private Handler bNR;
    private int bNS;
    private int bNT;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.bNR = handler;
        this.url = str;
        this.bNQ = imageView;
        this.bNS = i;
        this.bNT = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap j(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.aR(this.context).k(str, i, i2);
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
            a.WE().e(str, bitmap2);
            return bitmap2;
        }
        a.aR(this.context).d(str);
        bitmap = a.aR(this.context).k(str, i, i2);
        if (bitmap == null) {
            bitmap = d.iP(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap j = j(this.url, this.bNS, this.bNT);
        if (this.bNR != null) {
            this.bNR.obtainMessage(1, new f(this.bNQ, this.url, j)).sendToTarget();
        }
    }
}
