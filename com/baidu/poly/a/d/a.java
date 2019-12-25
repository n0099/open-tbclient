package com.baidu.poly.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.poly.a.c.d;
import com.baidu.poly.a.e.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.poly.a.e.a aLj;

    public a(Context context) {
        File Y = Y(context, "bitmap");
        if (!Y.exists()) {
            Y.mkdirs();
        }
        try {
            this.aLj = com.baidu.poly.a.e.a.a(Y, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void e(String str) {
        if (this.aLj != null) {
            try {
                a.c ew = this.aLj.ew(com.baidu.poly.a.f.b.h(str));
                if (ew != null) {
                    if (d.a(str, ew.dc(0))) {
                        ew.commit();
                    } else {
                        ew.abort();
                    }
                    this.aLj.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.aLj == null) {
            return null;
        }
        a.e ev = this.aLj.ev(com.baidu.poly.a.f.b.h(str));
        if (ev != null) {
            FileInputStream fileInputStream = (FileInputStream) ev.df(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.f.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File Y(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
