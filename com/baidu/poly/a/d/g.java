package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes14.dex */
public class g implements Runnable {
    private ImageView coT;
    private Handler coU;
    private int coV;
    private int coW;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.coU = handler;
        this.url = str;
        this.coT = imageView;
        this.coV = i;
        this.coW = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap l(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.bM(this.context).m(str, i, i2);
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
            a.adr().d(str, bitmap2);
            return bitmap2;
        }
        a.bM(this.context).d(str);
        bitmap = a.bM(this.context).m(str, i, i2);
        if (bitmap == null) {
            bitmap = d.c(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap l = l(this.url, this.coV, this.coW);
        if (this.coU != null) {
            this.coU.obtainMessage(1, new f(this.coT, this.url, l)).sendToTarget();
        }
    }
}
