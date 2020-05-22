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
    private com.baidu.poly.a.e.a buu;

    public a(Context context) {
        File G = G(context, "bitmap");
        if (!G.exists()) {
            G.mkdirs();
        }
        try {
            this.buu = com.baidu.poly.a.e.a.a(G, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.buu != null) {
            try {
                a.c gw = this.buu.gw(com.baidu.poly.a.f.b.g(str));
                if (gw != null) {
                    if (d.a(str, gw.dG(0))) {
                        gw.commit();
                    } else {
                        gw.abort();
                    }
                    this.buu.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.buu == null) {
            return null;
        }
        a.e gv = this.buu.gv(com.baidu.poly.a.f.b.g(str));
        if (gv != null) {
            FileInputStream fileInputStream = (FileInputStream) gv.dJ(0);
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
