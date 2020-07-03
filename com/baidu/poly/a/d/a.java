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
/* loaded from: classes11.dex */
public class a {
    private com.baidu.poly.a.e.a bzm;

    public a(Context context) {
        File G = G(context, "bitmap");
        if (!G.exists()) {
            G.mkdirs();
        }
        try {
            this.bzm = com.baidu.poly.a.e.a.a(G, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.bzm != null) {
            try {
                a.c gE = this.bzm.gE(com.baidu.poly.a.f.b.g(str));
                if (gE != null) {
                    if (d.a(str, gE.dT(0))) {
                        gE.commit();
                    } else {
                        gE.abort();
                    }
                    this.bzm.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.bzm == null) {
            return null;
        }
        a.e gD = this.bzm.gD(com.baidu.poly.a.f.b.g(str));
        if (gD != null) {
            FileInputStream fileInputStream = (FileInputStream) gD.dW(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.f.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File G(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
