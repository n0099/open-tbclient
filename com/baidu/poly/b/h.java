package com.baidu.poly.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes2.dex */
public class h implements Runnable {
    private ImageView agT;
    private Handler agW;
    private int agX;
    private int agY;
    private Context context;
    private String url;

    public h(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.agW = handler;
        this.url = str;
        this.agT = imageView;
        this.agX = i;
        this.agY = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap i = i(this.url, this.agX, this.agY);
        if (this.agW != null) {
            this.agW.obtainMessage(1, new f(this.agT, this.url, i)).sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap i(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap j;
        Bitmap bitmap2 = null;
        try {
            j = a.aB(this.context).j(str, i, i2);
            try {
            } catch (IOException e) {
                bitmap2 = j;
                e = e;
                e.printStackTrace();
                bitmap = bitmap2;
                if (bitmap != null) {
                }
            }
        } catch (IOException e2) {
            e = e2;
        }
        if (j != null) {
            a.ui().b(str, j);
            return j;
        }
        a.aB(this.context).cL(str);
        bitmap = a.aB(this.context).j(str, i, i2);
        if (bitmap != null) {
            return d.cK(str);
        }
        return bitmap;
    }
}
