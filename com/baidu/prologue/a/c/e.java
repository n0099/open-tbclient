package com.baidu.prologue.a.c;

import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.prologue.service.network.Request;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes9.dex */
public final class e {

    /* loaded from: classes9.dex */
    public interface a {
        void Vi();
    }

    public static void c(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
        FileChannel channel = fileOutputStream.getChannel();
        long j = 4194304;
        long j2 = 0;
        while (j > 0) {
            try {
                j = channel.transferFrom(newChannel, j2, ImageUploadStrategy.FILE_SIZE_4M);
                j2 += j;
            } finally {
                l.d(fileOutputStream);
            }
        }
    }

    public static void a(final File file, String str, final a aVar) {
        new Request.a(com.baidu.prologue.a.b.b.getAppContext(), str).Wd().Wc().a(new com.baidu.prologue.service.network.l() { // from class: com.baidu.prologue.a.c.e.1
            @Override // com.baidu.prologue.service.network.l
            public void a(long j, InputStream inputStream) {
                try {
                    e.c(inputStream, file);
                    if (aVar != null) {
                        aVar.Vi();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.prologue.service.network.l
            public void n(Throwable th) {
            }
        });
    }

    public static int o(File file) {
        int o;
        int i = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    if (file2.isFile()) {
                        o = file2.delete() ? 1 : 0;
                    } else {
                        o = o(file2);
                    }
                    i2++;
                    i3 = o + i3;
                }
                i = i3;
            }
            if (!file.delete()) {
                g.bKo.e("FileUtil", "delete dir " + file.getAbsolutePath() + " failed.");
            }
        }
        return i;
    }
}
