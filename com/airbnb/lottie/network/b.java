package com.airbnb.lottie.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.Pair;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.l;
import com.airbnb.lottie.m;
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
/* loaded from: classes4.dex */
public class b {
    private final Context appContext;
    private final a jN;
    private final String url;

    public static m<e> H(Context context, String str) {
        return new b(context, str).dv();
    }

    private b(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.jN = new a(this.appContext, str);
    }

    private m<e> dv() {
        return new m<>(new Callable<l<e>>() { // from class: com.airbnb.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: bo */
            public l<e> call() throws Exception {
                return b.this.dw();
            }
        });
    }

    @WorkerThread
    public l<e> dw() {
        e dx = dx();
        if (dx != null) {
            return new l<>(dx);
        }
        d.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return dy();
    }

    @WorkerThread
    @Nullable
    private e dx() {
        l<e> c;
        Pair<FileExtension, InputStream> du = this.jN.du();
        if (du == null) {
            return null;
        }
        FileExtension fileExtension = du.first;
        InputStream inputStream = du.second;
        if (fileExtension == FileExtension.Zip) {
            c = f.a(new ZipInputStream(inputStream), this.url);
        } else {
            c = f.c(inputStream, this.url);
        }
        if (c.getValue() != null) {
            return c.getValue();
        }
        return null;
    }

    @WorkerThread
    private l<e> dy() {
        try {
            return dz();
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    @WorkerThread
    private l dz() throws IOException {
        FileExtension fileExtension;
        l<e> a;
        d.debug("Fetching " + this.url);
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
                    return new l((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
                }
            }
        } else {
            String contentType = httpURLConnection.getContentType();
            char c = 65535;
            switch (contentType.hashCode()) {
                case -1248325150:
                    if (contentType.equals("application/zip")) {
                        c = 0;
                        break;
                    }
                    break;
                case -43840953:
                    if (contentType.equals("application/json")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    d.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    a = f.a(new ZipInputStream(new FileInputStream(this.jN.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
                    break;
                default:
                    d.debug("Received json response.");
                    fileExtension = FileExtension.Json;
                    a = f.c(new FileInputStream(new File(this.jN.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                    break;
            }
            if (a.getValue() != null) {
                this.jN.a(fileExtension);
            }
            d.debug("Completed fetch from network. Success: " + (a.getValue() != null));
            return a;
        }
    }
}
