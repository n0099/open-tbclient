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
    private com.baidu.poly.a.f.a bHl;

    public a(Context context) {
        File J = J(context, "bitmap");
        if (!J.exists()) {
            J.mkdirs();
        }
        try {
            this.bHl = com.baidu.poly.a.f.a.a(J, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void d(String str) {
        if (this.bHl != null) {
            try {
                a.c ir = this.bHl.ir(com.baidu.poly.a.g.b.g(str));
                if (ir != null) {
                    if (d.a(str, ir.fX(0))) {
                        ir.commit();
                    } else {
                        ir.abort();
                    }
                    this.bHl.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap k(String str, int i, int i2) {
        if (this.bHl == null) {
            return null;
        }
        a.e iq = this.bHl.iq(com.baidu.poly.a.g.b.g(str));
        if (iq != null) {
            FileInputStream fileInputStream = (FileInputStream) iq.ga(0);
            if (i > 0 && i2 > 0) {
                return com.baidu.poly.a.g.a.a(fileInputStream.getFD(), i, i2);
            }
            return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
        }
        return null;
    }

    public File J(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
