package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class ZipUtils {
    private static ZipUtils a;

    /* renamed from: a  reason: collision with other field name */
    private ZipEntry f19a = null;

    /* loaded from: classes.dex */
    class a extends ZipInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) {
            long j2 = 0;
            if (j < 0) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = new byte[(int) Math.min(j, 2048L)];
            while (j2 != j) {
                long j3 = j - j2;
                if (bArr.length <= j3) {
                    j3 = bArr.length;
                }
                int read = read(bArr, 0, (int) j3);
                if (read <= 0) {
                    return j2;
                }
                j2 += read;
            }
            return j2;
        }
    }

    private ZipUtils() {
    }

    public static ZipUtils getInstance() {
        if (a == null) {
            a = new ZipUtils();
        }
        return a;
    }

    private void a(ZipInputStream zipInputStream) {
        try {
            try {
                this.f19a = zipInputStream.getNextEntry();
                while (this.f19a != null && this.f19a.isDirectory()) {
                    this.f19a = zipInputStream.getNextEntry();
                }
                if (this.f19a == null) {
                    b(zipInputStream);
                }
            } catch (IOException e) {
                throw new RuntimeException("could not get next zip entry", e);
            } catch (RuntimeException e2) {
                if (this.f19a == null) {
                    b(zipInputStream);
                }
            }
        } catch (Throwable th) {
            if (this.f19a == null) {
                b(zipInputStream);
            }
            throw th;
        }
    }

    private void b(ZipInputStream zipInputStream) {
        if (zipInputStream != null) {
            try {
                zipInputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public boolean unZip(Context context, String str, String str2) {
        try {
            a aVar = new a(new BufferedInputStream(new FileInputStream(str)));
            a(aVar);
            while (this.f19a != null) {
                byte[] bArr = new byte[4096];
                String name = this.f19a.getName();
                File file = new File(str2 + name);
                context.deleteFile(name);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                for (int read = aVar.read(bArr, 0, 4096); read > 0; read = aVar.read(bArr, 0, 4096)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                a(aVar);
                bufferedOutputStream.close();
            }
            aVar.close();
            return true;
        } catch (ZipException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
