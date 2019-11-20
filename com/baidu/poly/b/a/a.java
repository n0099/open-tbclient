package com.baidu.poly.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.poly.b.a.a.a;
import com.baidu.poly.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.poly.b.a.a.a aBa;

    public a(Context context) {
        File N = N(context, "bitmap");
        if (!N.exists()) {
            N.mkdirs();
        }
        try {
            this.aBa = com.baidu.poly.b.a.a.a.a(N, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap j(String str, int i, int i2) throws IOException {
        if (this.aBa == null) {
            return null;
        }
        a.c dF = this.aBa.dF(com.baidu.poly.b.b.b.dH(str));
        if (dF != null) {
            FileInputStream fileInputStream = (FileInputStream) dF.cE(0);
            if (i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return com.baidu.poly.b.b.a.a(fileInputStream.getFD(), i, i2);
        }
        return null;
    }

    public void dC(String str) {
        if (this.aBa != null) {
            try {
                a.C0128a dG = this.aBa.dG(com.baidu.poly.b.b.b.dH(str));
                if (dG != null) {
                    if (d.a(str, dG.cB(0))) {
                        dG.commit();
                    } else {
                        dG.abort();
                    }
                    this.aBa.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
