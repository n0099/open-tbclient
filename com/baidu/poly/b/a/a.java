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
    private com.baidu.poly.b.a.a.a ahW;

    public a(Context context) {
        File ac = ac(context, "bitmap");
        if (!ac.exists()) {
            ac.mkdirs();
        }
        try {
            this.ahW = com.baidu.poly.b.a.a.a.a(ac, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap l(String str, int i, int i2) throws IOException {
        if (this.ahW == null) {
            return null;
        }
        a.c m12do = this.ahW.m12do(com.baidu.poly.b.b.b.dq(str));
        if (m12do != null) {
            FileInputStream fileInputStream = (FileInputStream) m12do.bO(0);
            if (i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return com.baidu.poly.b.b.a.a(fileInputStream.getFD(), i, i2);
        }
        return null;
    }

    public void dl(String str) {
        if (this.ahW != null) {
            try {
                a.C0112a dp = this.ahW.dp(com.baidu.poly.b.b.b.dq(str));
                if (dp != null) {
                    if (d.a(str, dp.bL(0))) {
                        dp.commit();
                    } else {
                        dp.abort();
                    }
                    this.ahW.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File ac(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
