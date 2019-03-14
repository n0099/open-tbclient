package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class h implements Runnable {
    private ImageView agE;
    private Handler agH;
    private int agI;
    private int agJ;
    private Context context;
    private String url;

    public h(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.agH = handler;
        this.url = str;
        this.agE = imageView;
        this.agI = i;
        this.agJ = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap j = j(this.url, this.agI, this.agJ);
        if (this.agH != null) {
            this.agH.obtainMessage(1, new f(this.agE, this.url, j)).sendToTarget();
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
            a.ty().b(str, k);
            return k;
        }
        a.bh(this.context).cY(str);
        bitmap = a.bh(this.context).k(str, i, i2);
        if (bitmap != null) {
            return d.cX(str);
        }
        return bitmap;
    }
}
