package com.baidu.live.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.live.lottie.d;
import com.baidu.live.lottie.e;
import com.baidu.live.lottie.f;
import com.baidu.live.lottie.m;
import com.baidu.live.lottie.n;
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
/* loaded from: classes9.dex */
public class b {
    private final Context appContext;
    private final a bvW;
    private final String url;

    public static n<e> J(Context context, String str) {
        return new b(context, str).Ol();
    }

    private b(Context context, String str) {
        this.appContext = context.getApplicationContext();
        this.url = str;
        this.bvW = new a(this.appContext, str);
    }

    private n<e> Ol() {
        return new n<>(new Callable<m<e>>() { // from class: com.baidu.live.lottie.network.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: Nh */
            public m<e> call() throws Exception {
                return b.this.Om();
            }
        });
    }

    @WorkerThread
    public m<e> Om() {
        e On = On();
        if (On != null) {
            return new m<>(On);
        }
        d.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return Oo();
    }

    @Nullable
    @WorkerThread
    private e On() {
        m<e> f;
        Pair<FileExtension, InputStream> kj = this.bvW.kj();
        if (kj == null) {
            return null;
        }
        FileExtension fileExtension = kj.first;
        InputStream inputStream = kj.second;
        if (fileExtension == FileExtension.Zip) {
            f = f.e(new ZipInputStream(inputStream), this.url);
        } else {
            f = f.f(inputStream, this.url);
        }
        if (f.getValue() != null) {
            return f.getValue();
        }
        return null;
    }

    @WorkerThread
    private m<e> Oo() {
        try {
            return Op();
        } catch (IOException e) {
            return new m<>(e);
        }
    }

    @WorkerThread
    private m Op() throws IOException {
        FileExtension fileExtension;
        m<e> e;
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
                    return new m((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
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
                    if (contentType.equals(HttpHelper.CONTENT_JSON)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    d.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    e = f.e(new ZipInputStream(new FileInputStream(this.bvW.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
                    break;
                default:
                    d.debug("Received json response.");
                    fileExtension = FileExtension.Json;
                    e = f.f(new FileInputStream(new File(this.bvW.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                    break;
            }
            if (e.getValue() != null) {
                this.bvW.a(fileExtension);
            }
            d.debug("Completed fetch from network. Success: " + (e.getValue() != null));
            return e;
        }
    }
}
