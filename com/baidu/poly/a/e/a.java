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
    private com.baidu.poly.a.f.a bWr;

    public a(Context context) {
        File N = N(context, "bitmap");
        if (!N.exists()) {
            N.mkdirs();
        }
        try {
            this.bWr = com.baidu.poly.a.f.a.a(N, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.bWr != null) {
            try {
                a.c jm = this.bWr.jm(com.baidu.poly.a.g.b.g(str));
                if (jm != null) {
                    if (d.a(str, jm.gC(0))) {
                        jm.commit();
                    } else {
                        jm.abort();
                    }
                    this.bWr.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap l(String str, int i, int i2) {
        if (this.bWr == null) {
            return null;
        }
        a.e jl = this.bWr.jl(com.baidu.poly.a.g.b.g(str));
        if (jl != null) {
            FileInputStream fileInputStream = (FileInputStream) jl.gF(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File N(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
