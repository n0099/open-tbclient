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
/* loaded from: classes3.dex */
public class a {
    private com.baidu.poly.a.f.a cnU;

    public a(Context context) {
        File a2 = a(context, "bitmap");
        if (!a2.exists()) {
            a2.mkdirs();
        }
        try {
            this.cnU = com.baidu.poly.a.f.a.b(a2, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.cnU != null) {
            try {
                a.c jW = this.cnU.jW(com.baidu.poly.a.g.b.g(str));
                if (jW != null) {
                    if (d.a(str, jW.hf(0))) {
                        jW.commit();
                    } else {
                        jW.abort();
                    }
                    this.cnU.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap m(String str, int i, int i2) {
        if (this.cnU == null) {
            return null;
        }
        a.e jV = this.cnU.jV(com.baidu.poly.a.g.b.g(str));
        if (jV != null) {
            FileInputStream fileInputStream = (FileInputStream) jV.hi(0);
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
