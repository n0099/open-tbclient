package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public class b {
    private final a IJ;
    private final Context appContext;
    private final String url;

    public static l<d> v(Context context, String str) {
        return new b(context, str).kk();
    }

    private b(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.IJ = new a(this.appContext, str);
    }

    private l<d> kk() {
        return new l<>(new Callable<k<d>>() { // from class: com.airbnb.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ib */
            public k<d> call() throws Exception {
                return b.this.kl();
            }
        });
    }

    @WorkerThread
    public k<d> kl() {
        d km = km();
        if (km != null) {
            return new k<>(km);
        }
        c.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return kn();
    }

    @Nullable
    @WorkerThread
    private d km() {
        k<d> c;
        Pair<FileExtension, InputStream> kj = this.IJ.kj();
        if (kj == null) {
            return null;
        }
        FileExtension fileExtension = kj.first;
        InputStream inputStream = kj.second;
        if (fileExtension == FileExtension.Zip) {
            c = e.c(new ZipInputStream(inputStream), this.url);
        } else {
            c = e.c(inputStream, this.url);
        }
        if (c.getValue() != null) {
            return c.getValue();
        }
        return null;
    }

    @WorkerThread
    private k<d> kn() {
        try {
            return ko();
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    @WorkerThread
    private k ko() throws IOException {
        FileExtension fileExtension;
        k<d> c;
        c.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine).append('\n');
                } else {
                    return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
                }
            }
        } else {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            switch (contentType.hashCode()) {
                case -1248325150:
                    if (contentType.equals("application/zip")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -43840953:
                    if (contentType.equals(HttpHelper.CONTENT_JSON)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    c = e.c(new ZipInputStream(new FileInputStream(this.IJ.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
                    break;
                default:
                    c.debug("Received json response.");
                    fileExtension = FileExtension.Json;
                    c = e.c(new FileInputStream(new File(this.IJ.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                    break;
            }
            if (c.getValue() != null) {
                this.IJ.a(fileExtension);
            }
            c.debug("Completed fetch from network. Success: " + (c.getValue() != null));
            return c;
        }
    }
}
