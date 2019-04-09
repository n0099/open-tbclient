package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class h implements Runnable {
    private ImageView agK;
    private Handler agN;
    private int agO;
    private int agP;
    private Context context;
    private String url;

    public h(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.agN = handler;
        this.url = str;
        this.agK = imageView;
        this.agO = i;
        this.agP = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap j = j(this.url, this.agO, this.agP);
        if (this.agN != null) {
            this.agN.obtainMessage(1, new f(this.agK, this.url, j)).sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap j(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap k;
        Bitmap bitmap2 = null;
        try {
            k = a.bh(this.context).k(str, i, i2);
            try {
            } catch (IOException e) {
                bitmap2 = k;
                e = e;
                e.printStackTrace();
                bitmap = bitmap2;
                if (bitmap != null) {
                }
            }
        } catch (IOException e2) {
            e = e2;
        }
        if (k != null) {
            a.tx().b(str, k);
            return k;
        }
        a.bh(this.context).da(str);
        bitmap = a.bh(this.context).k(str, i, i2);
        if (bitmap != null) {
            return d.cZ(str);
        }
        return bitmap;
    }
}
