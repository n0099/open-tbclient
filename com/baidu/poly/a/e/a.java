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
/* loaded from: classes4.dex */
public class a {
    private com.baidu.poly.a.f.a cnw;

    public a(Context context) {
        File a2 = a(context, "bitmap");
        if (!a2.exists()) {
            a2.mkdirs();
        }
        try {
            this.cnw = com.baidu.poly.a.f.a.b(a2, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.cnw != null) {
            try {
                a.c jq = this.cnw.jq(com.baidu.poly.a.g.b.g(str));
                if (jq != null) {
                    if (d.a(str, jq.fE(0))) {
                        jq.commit();
                    } else {
                        jq.abort();
                    }
                    this.cnw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap m(String str, int i, int i2) {
        if (this.cnw == null) {
            return null;
        }
        a.e jp = this.cnw.jp(com.baidu.poly.a.g.b.g(str));
        if (jp != null) {
            FileInputStream fileInputStream = (FileInputStream) jp.fH(0);
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
