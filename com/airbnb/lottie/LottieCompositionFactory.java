package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, LottieTask<LottieComposition>> taskCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(864896725, "Lcom/airbnb/lottie/LottieCompositionFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(864896725, "Lcom/airbnb/lottie/LottieCompositionFactory;");
                return;
            }
        }
        taskCache = new HashMap();
    }

    public LottieCompositionFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LottieTask<LottieComposition> cache(@Nullable String str, Callable<LottieResult<LottieComposition>> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, callable)) == null) {
            LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
            if (lottieComposition != null) {
                return new LottieTask<>(new Callable<LottieResult<LottieComposition>>(lottieComposition) { // from class: com.airbnb.lottie.LottieCompositionFactory.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieComposition val$cachedComposition;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {lottieComposition};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$cachedComposition = lottieComposition;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public LottieResult<LottieComposition> call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LottieResult<>(this.val$cachedComposition) : (LottieResult) invokeV.objValue;
                    }
                });
            }
            if (str != null && taskCache.containsKey(str)) {
                return taskCache.get(str);
            }
            LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
            if (str != null) {
                lottieTask.addListener(new LottieListener<LottieComposition>(str) { // from class: com.airbnb.lottie.LottieCompositionFactory.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$cacheKey;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$cacheKey = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.airbnb.lottie.LottieListener
                    public void onResult(LottieComposition lottieComposition2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition2) == null) {
                            LottieCompositionFactory.taskCache.remove(this.val$cacheKey);
                        }
                    }
                });
                lottieTask.addFailureListener(new LottieListener<Throwable>(str) { // from class: com.airbnb.lottie.LottieCompositionFactory.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$cacheKey;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$cacheKey = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.airbnb.lottie.LottieListener
                    public void onResult(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                            LottieCompositionFactory.taskCache.remove(this.val$cacheKey);
                        }
                    }
                });
                taskCache.put(str, lottieTask);
            }
            return lottieTask;
        }
        return (LottieTask) invokeLL.objValue;
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            taskCache.clear();
            LottieCompositionCache.getInstance().clear();
            new NetworkCache(context).clear();
        }
    }

    @Nullable
    public static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, lottieComposition, str)) == null) {
            for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
                if (lottieImageAsset.getFileName().equals(str)) {
                    return lottieImageAsset;
                }
            }
            return null;
        }
        return (LottieImageAsset) invokeLL.objValue;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            return fromAsset(context, str, "asset_" + str);
        }
        return (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            return fromAssetSync(context, str, "asset_" + str);
        }
        return (LottieResult) invokeLL.objValue;
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) ? cache(str, new Callable<LottieResult<LottieComposition>>(jSONObject, str) { // from class: com.airbnb.lottie.LottieCompositionFactory.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ JSONObject val$json;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jSONObject, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$json = jSONObject;
                this.val$cacheKey = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromJsonSync(this.val$json, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLL.objValue;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, inputStream, str)) == null) ? cache(str, new Callable<LottieResult<LottieComposition>>(inputStream, str) { // from class: com.airbnb.lottie.LottieCompositionFactory.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ InputStream val$stream;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {inputStream, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$stream = inputStream;
                this.val$cacheKey = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(this.val$stream, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, inputStream, str)) == null) ? fromJsonInputStreamSync(inputStream, str, true) : (LottieResult) invokeLL.objValue;
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, jsonReader, str)) == null) ? cache(str, new Callable<LottieResult<LottieComposition>>(jsonReader, str) { // from class: com.airbnb.lottie.LottieCompositionFactory.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ JsonReader val$reader;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jsonReader, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$reader = jsonReader;
                this.val$cacheKey = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromJsonReaderSync(this.val$reader, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, jsonReader, str)) == null) ? fromJsonReaderSyncInternal(jsonReader, str, true) : (LottieResult) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, @Nullable String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65552, null, jsonReader, str, z)) == null) {
            try {
                try {
                    LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                    if (str != null) {
                        LottieCompositionCache.getInstance().put(str, parse);
                    }
                    LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
                    if (z) {
                        Utils.closeQuietly(jsonReader);
                    }
                    return lottieResult;
                } catch (Exception e2) {
                    LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e2);
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
        return (LottieResult) invokeLLZ.objValue;
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, str2)) == null) ? cache(str2, new Callable<LottieResult<LottieComposition>>(str, str2) { // from class: com.airbnb.lottie.LottieCompositionFactory.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ String val$json;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$json = str;
                this.val$cacheKey = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromJsonStringSync(this.val$json, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) ? fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2) : (LottieResult) invokeLL.objValue;
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, jSONObject, str)) == null) ? fromJsonStringSync(jSONObject.toString(), str) : (LottieResult) invokeLL.objValue;
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, context, i2)) == null) ? fromRawRes(context, i2, rawResCacheKey(context, i2)) : (LottieTask) invokeLI.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, context, i2)) == null) ? fromRawResSync(context, i2, rawResCacheKey(context, i2)) : (LottieResult) invokeLI.objValue;
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            return fromUrl(context, str, "url_" + str);
        }
        return (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) ? fromUrlSync(context, str, str) : (LottieResult) invokeLL.objValue;
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, zipInputStream, str)) == null) ? cache(str, new Callable<LottieResult<LottieComposition>>(zipInputStream, str) { // from class: com.airbnb.lottie.LottieCompositionFactory.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ ZipInputStream val$inputStream;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {zipInputStream, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$inputStream = zipInputStream;
                this.val$cacheKey = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromZipStreamSync(this.val$inputStream, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, zipInputStream, str)) == null) {
            try {
                return fromZipStreamSyncInternal(zipInputStream, str);
            } finally {
                Utils.closeQuietly(zipInputStream);
            }
        }
        return (LottieResult) invokeLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, @Nullable String str) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, zipInputStream, str)) == null) {
            HashMap hashMap = new HashMap();
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                LottieComposition lottieComposition = null;
                while (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (name.contains("__MACOSX")) {
                        zipInputStream.closeEntry();
                    } else if (nextEntry.getName().contains(".json")) {
                        lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                    } else {
                        if (!name.contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) && !name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                        hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                if (lottieComposition == null) {
                    return new LottieResult<>(new IllegalArgumentException("Unable to parse composition"));
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                    if (findImageAssetForFileName != null) {
                        findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                    }
                }
                for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                    if (entry2.getValue().getBitmap() == null) {
                        return new LottieResult<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                    }
                }
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, lottieComposition);
                }
                return new LottieResult<>(lottieComposition);
            } catch (IOException e2) {
                return new LottieResult<>(e2);
            }
        }
        return (LottieResult) invokeLL.objValue;
    }

    public static boolean isNightMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) ? (context.getResources().getConfiguration().uiMode & 48) == 32 : invokeL.booleanValue;
    }

    public static String rawResCacheKey(Context context, @RawRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, context, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("rawRes");
            sb.append(isNightMode(context) ? "_night_" : "_day_");
            sb.append(i2);
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static void setMaxCacheSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, null, i2) == null) {
            LottieCompositionCache.getInstance().resize(i2);
        }
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, inputStream, str, z)) == null) {
            try {
                return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
            } finally {
                if (z) {
                    Utils.closeQuietly(inputStream);
                }
            }
        }
        return (LottieResult) invokeLLZ.objValue;
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i2, @Nullable String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65557, null, context, i2, str)) == null) ? cache(str, new Callable<LottieResult<LottieComposition>>(new WeakReference(context), context.getApplicationContext(), i2, str) { // from class: com.airbnb.lottie.LottieCompositionFactory.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$appContext;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ WeakReference val$contextRef;
            public final /* synthetic */ int val$rawRes;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6, r7, Integer.valueOf(i2), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$contextRef = r6;
                this.val$appContext = r7;
                this.val$rawRes = i2;
                this.val$cacheKey = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context context2 = (Context) this.val$contextRef.get();
                    if (context2 == null) {
                        context2 = this.val$appContext;
                    }
                    return LottieCompositionFactory.fromRawResSync(context2, this.val$rawRes, this.val$cacheKey);
                }
                return (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLIL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i2, @Nullable String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65559, null, context, i2, str)) == null) {
            try {
                return fromJsonInputStreamSync(context.getResources().openRawResource(i2), str);
            } catch (Resources.NotFoundException e2) {
                return new LottieResult<>(e2);
            }
        }
        return (LottieResult) invokeLIL.objValue;
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, context, str, str2)) == null) ? cache(str2, new Callable<LottieResult<LottieComposition>>(context, str, str2) { // from class: com.airbnb.lottie.LottieCompositionFactory.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ String val$url;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$url = str;
                this.val$cacheKey = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? NetworkFetcher.fetchSync(this.val$context, this.val$url, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, str, str2)) == null) ? NetworkFetcher.fetchSync(context, str, str2) : (LottieResult) invokeLLL.objValue;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) ? cache(str2, new Callable<LottieResult<LottieComposition>>(context.getApplicationContext(), str, str2) { // from class: com.airbnb.lottie.LottieCompositionFactory.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$appContext;
            public final /* synthetic */ String val$cacheKey;
            public final /* synthetic */ String val$fileName;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6, str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$appContext = r6;
                this.val$fileName = str;
                this.val$cacheKey = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LottieCompositionFactory.fromAssetSync(this.val$appContext, this.val$fileName, this.val$cacheKey) : (LottieResult) invokeV.objValue;
            }
        }) : (LottieTask) invokeLLL.objValue;
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, str, str2)) == null) {
            try {
                if (str.endsWith(".zip")) {
                    return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
                }
                return fromJsonInputStreamSync(context.getAssets().open(str), str2);
            } catch (IOException e2) {
                return new LottieResult<>(e2);
            }
        }
        return (LottieResult) invokeLLL.objValue;
    }
}
