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
/* loaded from: classes10.dex */
public class a {
    private com.baidu.poly.a.e.a aMb;

    public a(Context context) {
        File aa = aa(context, "bitmap");
        if (!aa.exists()) {
            aa.mkdirs();
        }
        try {
            this.aMb = com.baidu.poly.a.e.a.a(aa, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void e(String str) {
        if (this.aMb != null) {
            try {
                a.c ez = this.aMb.ez(com.baidu.poly.a.f.b.h(str));
                if (ez != null) {
                    if (d.a(str, ez.dd(0))) {
                        ez.commit();
                    } else {
                        ez.abort();
                    }
                    this.aMb.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.aMb == null) {
            return null;
        }
        a.e ey = this.aMb.ey(com.baidu.poly.a.f.b.h(str));
        if (ey != null) {
            FileInputStream fileInputStream = (FileInputStream) ey.dg(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.f.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File aa(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
