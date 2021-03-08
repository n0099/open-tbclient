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
/* loaded from: classes14.dex */
public class a {
    private com.baidu.poly.a.f.a coX;

    public a(Context context) {
        File a2 = a(context, "bitmap");
        if (!a2.exists()) {
            a2.mkdirs();
        }
        try {
            this.coX = com.baidu.poly.a.f.a.b(a2, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.coX != null) {
            try {
                a.c jw = this.coX.jw(com.baidu.poly.a.g.b.g(str));
                if (jw != null) {
                    if (d.a(str, jw.fF(0))) {
                        jw.commit();
                    } else {
                        jw.abort();
                    }
                    this.coX.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap m(String str, int i, int i2) {
        if (this.coX == null) {
            return null;
        }
        a.e jv = this.coX.jv(com.baidu.poly.a.g.b.g(str));
        if (jv != null) {
            FileInputStream fileInputStream = (FileInputStream) jv.fI(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File a(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
