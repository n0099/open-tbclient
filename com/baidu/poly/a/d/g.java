package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import java.io.IOException;
/* loaded from: classes19.dex */
public class g implements Runnable {
    private ImageView cgN;
    private Handler cgO;
    private int cgP;
    private int cgQ;
    private Context context;
    private String url;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        this.context = context.getApplicationContext();
        this.cgO = handler;
        this.url = str;
        this.cgN = imageView;
        this.cgP = i;
        this.cgQ = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap l(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = a.bx(this.context).m(str, i, i2);
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
            a.adw().e(str, bitmap2);
            return bitmap2;
        }
        a.bx(this.context).d(str);
        bitmap = a.bx(this.context).m(str, i, i2);
        if (bitmap == null) {
            bitmap = d.jW(str);
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap l = l(this.url, this.cgP, this.cgQ);
        if (this.cgO != null) {
            this.cgO.obtainMessage(1, new f(this.cgN, this.url, l)).sendToTarget();
        }
    }
}
