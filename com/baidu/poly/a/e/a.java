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
/* loaded from: classes9.dex */
public class a {
    private com.baidu.poly.a.f.a bzA;

    public a(Context context) {
        File G = G(context, "bitmap");
        if (!G.exists()) {
            G.mkdirs();
        }
        try {
            this.bzA = com.baidu.poly.a.f.a.a(G, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.bzA != null) {
            try {
                a.c gD = this.bzA.gD(com.baidu.poly.a.g.b.g(str));
                if (gD != null) {
                    if (d.a(str, gD.dS(0))) {
                        gD.commit();
                    } else {
                        gD.abort();
                    }
                    this.bzA.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.bzA == null) {
            return null;
        }
        a.e gC = this.bzA.gC(com.baidu.poly.a.g.b.g(str));
        if (gC != null) {
            FileInputStream fileInputStream = (FileInputStream) gC.dV(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
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
