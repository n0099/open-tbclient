package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class NetworkFetcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;
    @Nullable
    public final NetworkCache networkCache;
    public final String url;

    public NetworkFetcher(Context context, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.url = str;
        if (str2 == null) {
            this.networkCache = null;
        } else {
            this.networkCache = new NetworkCache(applicationContext);
        }
    }

    @Nullable
    @WorkerThread
    private LottieComposition fetchFromCache() {
        InterceptResult invokeV;
        Pair<FileExtension, InputStream> fetch;
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            NetworkCache networkCache = this.networkCache;
            if (networkCache == null || (fetch = networkCache.fetch(this.url)) == null) {
                return null;
            }
            FileExtension fileExtension = fetch.first;
            InputStream inputStream = fetch.second;
            if (fileExtension == FileExtension.ZIP) {
                fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
            } else {
                fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
            }
            if (fromJsonInputStreamSync.getValue() != null) {
                return fromJsonInputStreamSync.getValue();
            }
            return null;
        }
        return (LottieComposition) invokeV.objValue;
    }

    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                return fetchFromNetworkInternal();
            } catch (IOException e2) {
                return new LottieResult<>(e2);
            }
        }
        return (LottieResult) invokeV.objValue;
    }

    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetworkInternal() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Logger.debug("Fetching " + this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            try {
                httpURLConnection.connect();
                if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                    LottieResult<LottieComposition> resultFromConnection = getResultFromConnection(httpURLConnection);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(resultFromConnection.getValue() != null);
                    Logger.debug(sb.toString());
                    return resultFromConnection;
                }
                String errorFromConnection = getErrorFromConnection(httpURLConnection);
                return new LottieResult<>(new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + errorFromConnection));
            } catch (Exception e2) {
                return new LottieResult<>(e2);
            } finally {
                httpURLConnection.disconnect();
            }
        }
        return (LottieResult) invokeV.objValue;
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, context, str, str2)) == null) ? new NetworkFetcher(context, str, str2).fetchSync() : (LottieResult) invokeLLL.objValue;
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, httpURLConnection)) == null) {
            httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            sb.append('\n');
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            bufferedReader.close();
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeL;
        FileExtension fileExtension;
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, httpURLConnection)) == null) {
            String contentType = httpURLConnection.getContentType();
            if (contentType == null) {
                contentType = "application/json";
            }
            if (contentType.contains("application/zip")) {
                Logger.debug("Handling zip response.");
                fileExtension = FileExtension.ZIP;
                NetworkCache networkCache = this.networkCache;
                if (networkCache == null) {
                    fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(httpURLConnection.getInputStream()), null);
                } else {
                    fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension))), this.url);
                }
            } else {
                Logger.debug("Received json response.");
                fileExtension = FileExtension.JSON;
                NetworkCache networkCache2 = this.networkCache;
                if (networkCache2 == null) {
                    fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(httpURLConnection.getInputStream(), null);
                } else {
                    fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(networkCache2.writeTempCacheFile(this.url, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
                }
            }
            if (this.networkCache != null && fromJsonInputStreamSync.getValue() != null) {
                this.networkCache.renameTempFile(this.url, fileExtension);
            }
            return fromJsonInputStreamSync;
        }
        return (LottieResult) invokeL.objValue;
    }

    @WorkerThread
    public LottieResult<LottieComposition> fetchSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LottieComposition fetchFromCache = fetchFromCache();
            if (fetchFromCache != null) {
                return new LottieResult<>(fetchFromCache);
            }
            Logger.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
            return fetchFromNetwork();
        }
        return (LottieResult) invokeV.objValue;
    }
}
