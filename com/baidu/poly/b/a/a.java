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
    private com.baidu.poly.b.a.a.a agJ;

    public a(Context context) {
        File ac = ac(context, "bitmap");
        if (!ac.exists()) {
            ac.mkdirs();
        }
        try {
            this.agJ = com.baidu.poly.b.a.a.a.a(ac, 1, 1, 10485760L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap k(String str, int i, int i2) throws IOException {
        if (this.agJ == null) {
            return null;
        }
        a.c db = this.agJ.db(com.baidu.poly.b.b.b.dd(str));
        if (db != null) {
            FileInputStream fileInputStream = (FileInputStream) db.bI(0);
            if (i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return com.baidu.poly.b.b.a.a(fileInputStream.getFD(), i, i2);
        }
        return null;
    }

    public void cY(String str) {
        if (this.agJ != null) {
            try {
                a.C0051a dc = this.agJ.dc(com.baidu.poly.b.b.b.dd(str));
                if (dc != null) {
                    if (d.a(str, dc.bF(0))) {
                        dc.commit();
                    } else {
                        dc.abort();
                    }
                    this.agJ.flush();
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
