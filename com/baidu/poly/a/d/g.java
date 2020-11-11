package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes6.dex */
public class g implements Runnable {
    private ImageView cbX;
    private Handler cbY;
    private int cbZ;
    private int cca;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.cbY = handler;
        this.url = str;
        this.cbX = imageView;
        this.cbZ = i;
        this.cca = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap k(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.aR(this.context).l(str, i, i2);
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
            a.aaX().e(str, bitmap2);
            return bitmap2;
        }
        a.aR(this.context).d(str);
        bitmap = a.aR(this.context).l(str, i, i2);
        if (bitmap == null) {
            bitmap = d.jv(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap k = k(this.url, this.cbZ, this.cca);
        if (this.cbY != null) {
            this.cbY.obtainMessage(1, new f(this.cbX, this.url, k)).sendToTarget();
        }
    }
}
