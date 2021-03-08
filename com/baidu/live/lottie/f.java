package com.baidu.live.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.baidu.live.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes9.dex */
public class f {
    private static final Map<String, n<e>> Du = new HashMap();

    public static n<e> G(Context context, String str) {
        return com.baidu.live.lottie.network.b.J(context, str);
    }

    public static n<e> H(Context context, final String str) {
        final Context app = g.getApp() != null ? g.getApp() : context.getApplicationContext();
        return c(str, new Callable<m<e>>() { // from class: com.baidu.live.lottie.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: Nh */
            public m<e> call() {
                return f.I(app, str);
            }
        });
    }

    @WorkerThread
    public static m<e> I(Context context, String str) {
        m<e> f;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                f = e(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                f = f(context.getAssets().open(str), str2);
            }
            return f;
        } catch (IOException e) {
            return new m<>(e);
        }
    }

    public static n<e> p(Context context, @RawRes final int i) {
        final Context app = g.getApp() != null ? g.getApp() : context.getApplicationContext();
        return c(X(i), new Callable<m<e>>() { // from class: com.baidu.live.lottie.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: Nh */
            public m<e> call() {
                return f.q(app, i);
            }
        });
    }

    @WorkerThread
    public static m<e> q(Context context, @RawRes int i) {
        try {
            return f(context.getResources().openRawResource(i), X(i));
        } catch (Resources.NotFoundException e) {
            return new m<>(e);
        }
    }

    private static String X(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static n<e> e(final InputStream inputStream, @Nullable final String str) {
        return c(str, new Callable<m<e>>() { // from class: com.baidu.live.lottie.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: Nh */
            public m<e> call() {
                return f.f(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static m<e> f(InputStream inputStream, @Nullable String str) {
        return c(inputStream, str, true);
    }

    @WorkerThread
    private static m<e> c(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return f(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.baidu.live.lottie.d.f.closeQuietly(inputStream);
            }
        }
    }

    public static n<e> e(final JsonReader jsonReader, @Nullable final String str) {
        return c(str, new Callable<m<e>>() { // from class: com.baidu.live.lottie.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: Nh */
            public m<e> call() {
                return f.f(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static m<e> f(JsonReader jsonReader, @Nullable String str) {
        try {
            e i = t.i(jsonReader);
            com.baidu.live.lottie.model.g.Nu().a(str, i);
            return new m<>(i);
        } catch (Exception e) {
            return new m<>(e);
        }
    }

    @WorkerThread
    public static m<e> e(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return f(zipInputStream, str);
        } finally {
            com.baidu.live.lottie.d.f.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static m<e> f(ZipInputStream zipInputStream, @Nullable String str) {
        e eVar;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            e eVar2 = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                    eVar = eVar2;
                } else if (nextEntry.getName().contains(".json")) {
                    eVar = c(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(".png")) {
                    hashMap.put(nextEntry.getName().split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    eVar = eVar2;
                } else {
                    zipInputStream.closeEntry();
                    eVar = eVar2;
                }
                nextEntry = zipInputStream.getNextEntry();
                eVar2 = eVar;
            }
            if (eVar2 == null) {
                return new m<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                i a2 = a(eVar2, (String) entry.getKey());
                if (a2 != null) {
                    a2.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, i> entry2 : eVar2.hY().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new m<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.baidu.live.lottie.model.g.Nu().a(str, eVar2);
            return new m<>(eVar2);
        } catch (IOException e) {
            return new m<>(e);
        }
    }

    @Nullable
    private static i a(e eVar, String str) {
        for (i iVar : eVar.hY().values()) {
            if (iVar.getFileName().equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    private static n<e> c(@Nullable final String str, Callable<m<e>> callable) {
        final e hu = com.baidu.live.lottie.model.g.Nu().hu(str);
        if (hu != null) {
            return new n<>(new Callable<m<e>>() { // from class: com.baidu.live.lottie.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: Nh */
                public m<e> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new m<>(e.this);
                }
            });
        }
        if (Du.containsKey(str)) {
            return Du.get(str);
        }
        n<e> nVar = new n<>(callable);
        nVar.a(new j<e>() { // from class: com.baidu.live.lottie.f.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.lottie.j
            public void onResult(e eVar) {
                if (str != null) {
                    com.baidu.live.lottie.model.g.Nu().a(str, eVar);
                }
                f.Du.remove(str);
            }
        });
        nVar.c(new j<Throwable>() { // from class: com.baidu.live.lottie.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.lottie.j
            /* renamed from: f */
            public void onResult(Throwable th) {
                f.Du.remove(str);
            }
        });
        Du.put(str, nVar);
        return nVar;
    }
}
