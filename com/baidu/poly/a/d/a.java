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
    private com.baidu.poly.a.e.a aQA;

    public a(Context context) {
        File aa = aa(context, "bitmap");
        if (!aa.exists()) {
            aa.mkdirs();
        }
        try {
            this.aQA = com.baidu.poly.a.e.a.a(aa, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void e(String str) {
        if (this.aQA != null) {
            try {
                a.c eP = this.aQA.eP(com.baidu.poly.a.f.b.h(str));
                if (eP != null) {
                    if (d.a(str, eP.du(0))) {
                        eP.commit();
                    } else {
                        eP.abort();
                    }
                    this.aQA.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.aQA == null) {
            return null;
        }
        a.e eO = this.aQA.eO(com.baidu.poly.a.f.b.h(str));
        if (eO != null) {
            FileInputStream fileInputStream = (FileInputStream) eO.dx(0);
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
