package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.WorkerThread;
import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.c.t;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes10.dex */
public class f {
    private static final Map<String, m<e>> Bs = new HashMap();

    public static m<e> s(Context context, String str) {
        return com.airbnb.lottie.network.b.v(context, str);
    }

    public static m<e> t(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable<l<e>>() { // from class: com.airbnb.lottie.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: iF */
            public l<e> call() {
                return f.u(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static l<e> u(Context context, String str) {
        l<e> c;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                c = a(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                c = c(context.getAssets().open(str), str2);
            }
            return c;
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    public static m<e> d(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(U(i), new Callable<l<e>>() { // from class: com.airbnb.lottie.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: iF */
            public l<e> call() {
                return f.e(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static l<e> e(Context context, @RawRes int i) {
        try {
            return c(context.getResources().openRawResource(i), U(i));
        } catch (Resources.NotFoundException e) {
            return new l<>(e);
        }
    }

    private static String U(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static m<e> b(final InputStream inputStream, @Nullable final String str) {
        return a(str, new Callable<l<e>>() { // from class: com.airbnb.lottie.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: iF */
            public l<e> call() {
                return f.c(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static l<e> c(InputStream inputStream, @Nullable String str) {
        return a(inputStream, str, true);
    }

    @WorkerThread
    private static l<e> a(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.airbnb.lottie.d.f.closeQuietly(inputStream);
            }
        }
    }

    public static m<e> n(final String str, @Nullable final String str2) {
        return a(str2, new Callable<l<e>>() { // from class: com.airbnb.lottie.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: iF */
            public l<e> call() {
                return f.o(str, str2);
            }
        });
    }

    @WorkerThread
    public static l<e> o(String str, @Nullable String str2) {
        return b(new JsonReader(new StringReader(str)), str2);
    }

    public static m<e> a(final JsonReader jsonReader, @Nullable final String str) {
        return a(str, new Callable<l<e>>() { // from class: com.airbnb.lottie.f.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: iF */
            public l<e> call() {
                return f.b(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static l<e> b(JsonReader jsonReader, @Nullable String str) {
        try {
            e d = t.d(jsonReader);
            com.airbnb.lottie.model.g.jC().a(str, d);
            return new l<>(d);
        } catch (Exception e) {
            return new l<>(e);
        }
    }

    @WorkerThread
    public static l<e> a(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            com.airbnb.lottie.d.f.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static l<e> b(ZipInputStream zipInputStream, @Nullable String str) {
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
                    eVar = a(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX)) {
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
                return new l<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                h a2 = a(eVar2, (String) entry.getKey());
                if (a2 != null) {
                    a2.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, h> entry2 : eVar2.iC().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new l<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.airbnb.lottie.model.g.jC().a(str, eVar2);
            return new l<>(eVar2);
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    @Nullable
    private static h a(e eVar, String str) {
        for (h hVar : eVar.iC().values()) {
            if (hVar.getFileName().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    private static m<e> a(@Nullable final String str, Callable<l<e>> callable) {
        final e bm = com.airbnb.lottie.model.g.jC().bm(str);
        if (bm != null) {
            return new m<>(new Callable<l<e>>() { // from class: com.airbnb.lottie.f.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: iF */
                public l<e> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new l<>(e.this);
                }
            });
        }
        if (Bs.containsKey(str)) {
            return Bs.get(str);
        }
        m<e> mVar = new m<>(callable);
        mVar.a(new i<e>() { // from class: com.airbnb.lottie.f.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(e eVar) {
                if (str != null) {
                    com.airbnb.lottie.model.g.jC().a(str, eVar);
                }
                f.Bs.remove(str);
            }
        });
        mVar.c(new i<Throwable>() { // from class: com.airbnb.lottie.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.i
            public void onResult(Throwable th) {
                f.Bs.remove(str);
            }
        });
        Bs.put(str, mVar);
        return mVar;
    }
}
