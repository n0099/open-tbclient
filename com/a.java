package com;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a implements ab {
    private String a;
    private int c;
    private int d;
    private Map e = new HashMap();
    private ab kq;

    public a(String str, int i, int i2, ab abVar) {
        this.a = str;
        this.c = i;
        this.d = i2;
        this.kq = abVar;
    }

    @Override // com.ab
    public void a(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = new File(c(str));
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            this.e.put(str, 1);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th2) {
            fileOutputStream2 = fileOutputStream;
            th = th2;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public Bitmap b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(c(str), options);
        options.inSampleSize = AsyncImageLoader.computeSampleSize(options, -1, this.d);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(c(str), options);
        if (decodeFile != null) {
            Integer num = (Integer) this.e.get(str);
            if (num == null) {
                num = 0;
            }
            if (num.intValue() + 1 < this.c || this.kq == null) {
                this.e.put(str, Integer.valueOf(num.intValue() + 1));
                return decodeFile;
            }
            this.kq.a(str, decodeFile);
            this.e.remove(str);
            return decodeFile;
        }
        return null;
    }

    public String c(String str) {
        return this.a + "/" + str + ".png";
    }

    public a o(String str) {
        this.a = str;
        return this;
    }

    public a p(int i) {
        this.d = i;
        return this;
    }

    public a q(int i) {
        this.c = i;
        return this;
    }
}
