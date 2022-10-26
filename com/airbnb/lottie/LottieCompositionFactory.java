package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LottieCompositionFactory {
    public static final Map taskCache = new HashMap();

    public static LottieTask cache(final String str, Callable callable) {
        final LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            lottieComposition = LottieCompositionCache.getInstance().get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask(new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public LottieResult call() {
                    return new LottieResult(LottieComposition.this);
                }
            });
        }
        if (str != null && taskCache.containsKey(str)) {
            return (LottieTask) taskCache.get(str);
        }
        LottieTask lottieTask = new LottieTask(callable);
        if (str != null) {
            lottieTask.addListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.airbnb.lottie.LottieListener
                public void onResult(LottieComposition lottieComposition2) {
                    LottieCompositionFactory.taskCache.remove(str);
                }
            });
            lottieTask.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.airbnb.lottie.LottieListener
                public void onResult(Throwable th) {
                    LottieCompositionFactory.taskCache.remove(str);
                }
            });
            taskCache.put(str, lottieTask);
        }
        return lottieTask;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        new NetworkCache(context).clear();
    }

    public static boolean isNightMode(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieResult fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @Deprecated
    public static LottieTask fromJson(final JSONObject jSONObject, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        });
    }

    public static LottieTask fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromJsonReaderSync(JsonReader.this, str);
            }
        });
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    public static LottieTask fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static LottieResult fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @Deprecated
    public static LottieResult fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask fromRawRes(Context context, int i) {
        return fromRawRes(context, i, rawResCacheKey(context, i));
    }

    public static LottieResult fromRawResSync(Context context, int i) {
        return fromRawResSync(context, i, rawResCacheKey(context, i));
    }

    public static LottieTask fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieResult fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask fromZipStream(final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static LottieResult fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    public static String rawResCacheKey(Context context, int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (isNightMode(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static LottieTask fromAsset(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
            }
        });
    }

    public static LottieResult fromAssetSync(Context context, String str, String str2) {
        try {
            if (str.endsWith(".zip")) {
                return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult((Throwable) e);
        }
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static LottieResult fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, parse);
                }
                LottieResult lottieResult = new LottieResult(parse);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Exception e) {
                LottieResult lottieResult2 = new LottieResult((Throwable) e);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask fromRawRes(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return LottieCompositionFactory.fromRawResSync(context2, i, str);
            }
        });
    }

    public static LottieResult fromRawResSync(Context context, int i, String str) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i), str);
        } catch (Resources.NotFoundException e) {
            return new LottieResult((Throwable) e);
        }
    }

    public static LottieTask fromUrl(final Context context, final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public LottieResult call() {
                return NetworkFetcher.fetchSync(context, str, str2);
            }
        });
    }

    public static LottieResult fromUrlSync(Context context, String str, String str2) {
        return NetworkFetcher.fetchSync(context, str, str2);
    }

    public static LottieResult fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = (LottieComposition) fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry entry2 : lottieComposition.getImages().entrySet()) {
                if (((LottieImageAsset) entry2.getValue()).getBitmap() == null) {
                    return new LottieResult((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) entry2.getValue()).getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult(lottieComposition);
        } catch (IOException e) {
            return new LottieResult((Throwable) e);
        }
    }
}
