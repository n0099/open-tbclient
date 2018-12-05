package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class h implements Runnable {
    private ImageView ahQ;
    private Handler ahT;
    private int ahU;
    private int ahV;
    private Context context;
    private String url;

    public h(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.ahT = handler;
        this.url = str;
        this.ahQ = imageView;
        this.ahU = i;
        this.ahV = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap k = k(this.url, this.ahU, this.ahV);
        if (this.ahT != null) {
            this.ahT.obtainMessage(1, new f(this.ahQ, this.url, k)).sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap k(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap l;
        Bitmap bitmap2 = null;
        try {
            l = a.bp(this.context).l(str, i, i2);
            try {
            } catch (IOException e) {
                bitmap2 = l;
                e = e;
                e.printStackTrace();
                bitmap = bitmap2;
                if (bitmap != null) {
                }
            }
        } catch (IOException e2) {
            e = e2;
        }
        if (l != null) {
            a.us().b(str, l);
            return l;
        }
        a.bp(this.context).dl(str);
        bitmap = a.bp(this.context).l(str, i, i2);
        if (bitmap != null) {
            return d.dk(str);
        }
        return bitmap;
    }
}
