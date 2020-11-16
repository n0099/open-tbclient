package com.baidu.poly.a.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.poly.a.d.d;
import com.baidu.poly.a.f.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.poly.a.f.a caq;

    public a(Context context) {
        File K = K(context, "bitmap");
        if (!K.exists()) {
            K.mkdirs();
        }
        try {
            this.caq = com.baidu.poly.a.f.a.a(K, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.caq != null) {
            try {
                a.c jt = this.caq.jt(com.baidu.poly.a.g.b.g(str));
                if (jt != null) {
                    if (d.a(str, jt.gI(0))) {
                        jt.commit();
                    } else {
                        jt.abort();
                    }
                    this.caq.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap l(String str, int i, int i2) {
        if (this.caq == null) {
            return null;
        }
        a.e js = this.caq.js(com.baidu.poly.a.g.b.g(str));
        if (js != null) {
            FileInputStream fileInputStream = (FileInputStream) js.gL(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File K(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
