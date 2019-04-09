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
    private com.baidu.poly.b.a.a.a agQ;

    public a(Context context) {
        File ac = ac(context, "bitmap");
        if (!ac.exists()) {
            ac.mkdirs();
        }
        try {
            this.agQ = com.baidu.poly.b.a.a.a.a(ac, 1, 1, Config.FULL_TRACE_LOG_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap k(String str, int i, int i2) throws IOException {
        if (this.agQ == null) {
            return null;
        }
        a.c dd = this.agQ.dd(com.baidu.poly.b.b.b.df(str));
        if (dd != null) {
            FileInputStream fileInputStream = (FileInputStream) dd.bH(0);
            if (i <= 0 || i2 <= 0) {
                return BitmapFactory.decodeFileDescriptor(fileInputStream.getFD());
            }
            return com.baidu.poly.b.b.a.a(fileInputStream.getFD(), i, i2);
        }
        return null;
    }

    public void da(String str) {
        if (this.agQ != null) {
            try {
                a.C0080a de = this.agQ.de(com.baidu.poly.b.b.b.df(str));
                if (de != null) {
                    if (d.a(str, de.bE(0))) {
                        de.commit();
                    } else {
                        de.abort();
                    }
                    this.agQ.flush();
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
