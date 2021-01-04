package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class e {
    private static final Map<String, l<d>> BX = new HashMap();

    public static l<d> s(Context context, String str) {
        return com.airbnb.lottie.network.b.v(context, str);
    }

    public static l<d> t(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return b(str, new Callable<k<d>>() { // from class: com.airbnb.lottie.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ic */
            public k<d> call() {
                return e.u(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static k<d> u(Context context, String str) {
        k<d> c;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                c = c(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                c = c(context.getAssets().open(str), str2);
            }
            return c;
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    public static l<d> d(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return b(X(i), new Callable<k<d>>() { // from class: com.airbnb.lottie.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ic */
            public k<d> call() {
                return e.e(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static k<d> e(Context context, @RawRes int i) {
        try {
            return c(context.getResources().openRawResource(i), X(i));
        } catch (Resources.NotFoundException e) {
            return new k<>(e);
        }
    }

    private static String X(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static l<d> b(final InputStream inputStream, @Nullable final String str) {
        return b(str, new Callable<k<d>>() { // from class: com.airbnb.lottie.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ic */
            public k<d> call() {
                return e.c(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static k<d> c(InputStream inputStream, @Nullable String str) {
        return b(inputStream, str, true);
    }

    @WorkerThread
    private static k<d> b(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return d(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.airbnb.lottie.d.f.closeQuietly(inputStream);
            }
        }
    }

    public static l<d> n(final String str, @Nullable final String str2) {
        return b(str2, new Callable<k<d>>() { // from class: com.airbnb.lottie.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ic */
            public k<d> call() {
                return e.o(str, str2);
            }
        });
    }

    @WorkerThread
    public static k<d> o(String str, @Nullable String str2) {
        return d(new JsonReader(new StringReader(str)), str2);
    }

    public static l<d> c(final JsonReader jsonReader, @Nullable final String str) {
        return b(str, new Callable<k<d>>() { // from class: com.airbnb.lottie.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: ic */
            public k<d> call() {
                return e.d(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static k<d> d(JsonReader jsonReader, @Nullable String str) {
        try {
            d f = t.f(jsonReader);
            com.airbnb.lottie.model.g.jb().a(str, f);
            return new k<>(f);
        } catch (Exception e) {
            return new k<>(e);
        }
    }

    @WorkerThread
    public static k<d> c(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return d(zipInputStream, str);
        } finally {
            com.airbnb.lottie.d.f.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static k<d> d(ZipInputStream zipInputStream, @Nullable String str) {
        d dVar;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar2 = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                    dVar = dVar2;
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = b(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(".png")) {
                    hashMap.put(nextEntry.getName().split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    dVar = dVar2;
                } else {
                    zipInputStream.closeEntry();
                    dVar = dVar2;
                }
                nextEntry = zipInputStream.getNextEntry();
                dVar2 = dVar;
            }
            if (dVar2 == null) {
                return new k<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a2 = a(dVar2, (String) entry.getKey());
                if (a2 != null) {
                    a2.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, g> entry2 : dVar2.hZ().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new k<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.airbnb.lottie.model.g.jb().a(str, dVar2);
            return new k<>(dVar2);
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    @Nullable
    private static g a(d dVar, String str) {
        for (g gVar : dVar.hZ().values()) {
            if (gVar.getFileName().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static l<d> b(@Nullable final String str, Callable<k<d>> callable) {
        final d bm = com.airbnb.lottie.model.g.jb().bm(str);
        if (bm != null) {
            return new l<>(new Callable<k<d>>() { // from class: com.airbnb.lottie.e.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: ic */
                public k<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new k<>(d.this);
                }
            });
        }
        if (BX.containsKey(str)) {
            return BX.get(str);
        }
        l<d> lVar = new l<>(callable);
        lVar.a(new h<d>() { // from class: com.airbnb.lottie.e.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            public void onResult(d dVar) {
                if (str != null) {
                    com.airbnb.lottie.model.g.jb().a(str, dVar);
                }
                e.BX.remove(str);
            }
        });
        lVar.c(new h<Throwable>() { // from class: com.airbnb.lottie.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            public void onResult(Throwable th) {
                e.BX.remove(str);
            }
        });
        BX.put(str, lVar);
        return lVar;
    }
}
