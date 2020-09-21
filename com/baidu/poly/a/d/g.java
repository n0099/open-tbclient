package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes9.dex */
public class g implements Runnable {
    private ImageView bHh;
    private Handler bHi;
    private int bHj;
    private int bHk;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.bHi = handler;
        this.url = str;
        this.bHh = imageView;
        this.bHj = i;
        this.bHk = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap j(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.aN(this.context).k(str, i, i2);
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
            a.UH().e(str, bitmap2);
            return bitmap2;
        }
        a.aN(this.context).d(str);
        bitmap = a.aN(this.context).k(str, i, i2);
        if (bitmap == null) {
            bitmap = d.in(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap j = j(this.url, this.bHj, this.bHk);
        if (this.bHi != null) {
            this.bHi.obtainMessage(1, new f(this.bHh, this.url, j)).sendToTarget();
        }
    }
}
