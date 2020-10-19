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
    private com.baidu.poly.a.f.a bNU;

    public a(Context context) {
        File M = M(context, "bitmap");
        if (!M.exists()) {
            M.mkdirs();
        }
        try {
            this.bNU = com.baidu.poly.a.f.a.a(M, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.bNU != null) {
            try {
                a.c iT = this.bNU.iT(com.baidu.poly.a.g.b.g(str));
                if (iT != null) {
                    if (d.a(str, iT.gr(0))) {
                        iT.commit();
                    } else {
                        iT.abort();
                    }
                    this.bNU.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.bNU == null) {
            return null;
        }
        a.e iS = this.bNU.iS(com.baidu.poly.a.g.b.g(str));
        if (iS != null) {
            FileInputStream fileInputStream = (FileInputStream) iS.gu(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File M(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
