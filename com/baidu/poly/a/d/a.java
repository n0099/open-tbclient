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
    private com.baidu.poly.a.e.a aQP;

    public a(Context context) {
        File aa = aa(context, "bitmap");
        if (!aa.exists()) {
            aa.mkdirs();
        }
        try {
            this.aQP = com.baidu.poly.a.e.a.a(aa, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void e(String str) {
        if (this.aQP != null) {
            try {
                a.c eO = this.aQP.eO(com.baidu.poly.a.f.b.h(str));
                if (eO != null) {
                    if (d.a(str, eO.du(0))) {
                        eO.commit();
                    } else {
                        eO.abort();
                    }
                    this.aQP.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.aQP == null) {
            return null;
        }
        a.e eN = this.aQP.eN(com.baidu.poly.a.f.b.h(str));
        if (eN != null) {
            FileInputStream fileInputStream = (FileInputStream) eN.dx(0);
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
