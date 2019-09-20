package com.baidu.poly.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.mobstat.Config;
import com.baidu.poly.b.a.a.a;
import com.baidu.poly.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.poly.b.a.a.a ahU;

    public a(Context context) {
        File O = O(context, "bitmap");
        if (!O.exists()) {
            O.mkdirs();
        }
        try {
            this.ahU = com.baidu.poly.b.a.a.a.a(O, 1, 1, Config.FULL_TRACE_LOG_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap j(String str, int i, int i2) throws IOException {
        if (this.ahU == null) {
            return null;
        }
        a.c cV = this.ahU.cV(com.baidu.poly.b.b.b.cX(str));
        if (cV != null) {
            FileInputStream fileInputStream = (FileInputStream) cV.bI(0);
            if (i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return com.baidu.poly.b.b.a.a(fileInputStream.getFD(), i, i2);
        }
        return null;
    }

    public void cS(String str) {
        if (this.ahU != null) {
            try {
                a.C0096a cW = this.ahU.cW(com.baidu.poly.b.b.b.cX(str));
                if (cW != null) {
                    if (d.a(str, cW.bF(0))) {
                        cW.commit();
                    } else {
                        cW.abort();
                    }
                    this.ahU.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File O(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }
}
