package com.airbnb.lottie.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.Pair;
import com.airbnb.lottie.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
class a {
    private final Context appContext;
    private final String url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    @Nullable
    public Pair<FileExtension, InputStream> du() {
        FileExtension fileExtension;
        try {
            File R = R(this.url);
            if (R == null) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(R);
                if (R.getAbsolutePath().endsWith(".zip")) {
                    fileExtension = FileExtension.Zip;
                } else {
                    fileExtension = FileExtension.Json;
                }
                d.debug("Cache hit for " + this.url + " at " + R.getAbsolutePath());
                return new Pair<>(fileExtension, fileInputStream);
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.appContext.getCacheDir(), a(this.url, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FileExtension fileExtension) {
        File file = new File(this.appContext.getCacheDir(), a(this.url, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        d.debug("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            d.warn("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    @Nullable
    private File R(String str) throws FileNotFoundException {
        File file = new File(this.appContext.getCacheDir(), a(str, FileExtension.Json, false));
        if (!file.exists()) {
            File file2 = new File(this.appContext.getCacheDir(), a(str, FileExtension.Zip, false));
            if (!file2.exists()) {
                return null;
            }
            return file2;
        }
        return file;
    }

    private static String a(String str, FileExtension fileExtension, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? fileExtension.extension : fileExtension.tempExtension());
    }
}
