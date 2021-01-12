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
    private com.baidu.poly.a.f.a cjg;

    public a(Context context) {
        File a2 = a(context, "bitmap");
        if (!a2.exists()) {
            a2.mkdirs();
        }
        try {
            this.cjg = com.baidu.poly.a.f.a.b(a2, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.cjg != null) {
            try {
                a.c iL = this.cjg.iL(com.baidu.poly.a.g.b.g(str));
                if (iL != null) {
                    if (d.a(str, iL.fy(0))) {
                        iL.commit();
                    } else {
                        iL.abort();
                    }
                    this.cjg.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap m(String str, int i, int i2) {
        if (this.cjg == null) {
            return null;
        }
        a.e iK = this.cjg.iK(com.baidu.poly.a.g.b.g(str));
        if (iK != null) {
            FileInputStream fileInputStream = (FileInputStream) iK.fB(0);
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
