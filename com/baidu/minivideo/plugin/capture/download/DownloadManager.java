package com.baidu.minivideo.plugin.capture.download;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.base.DownloadStatusDelivery;
import com.baidu.minivideo.plugin.capture.download.base.Downloader;
import com.baidu.minivideo.plugin.capture.download.core.DownloadResponseImpl;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import com.baidu.minivideo.plugin.capture.download.core.DownloaderImpl;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class DownloadManager implements Downloader.OnDownloaderDestroyedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownloadManager";
    public static DownloadManager sDownloadManager;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadConfig mConfig;
    public DownloadStatusDelivery mDelivery;
    public Map<String, Downloader> mDownloaderMap;
    public ExecutorService mExecutorService;
    public Handler mHandler;

    public DownloadManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDownloaderMap = new LinkedHashMap();
        init(new DownloadConfig());
    }

    private String createKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public static DownloadManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sDownloadManager == null) {
                synchronized (DownloadManager.class) {
                    if (sDownloadManager == null) {
                        sDownloadManager = new DownloadManager();
                    }
                }
            }
            return sDownloadManager;
        }
        return (DownloadManager) invokeV.objValue;
    }

    private void init(@NonNull DownloadConfig downloadConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, downloadConfig) == null) {
            if (downloadConfig.getThreadNum() <= downloadConfig.getMaxThreadNum()) {
                this.mConfig = downloadConfig;
                this.mExecutorService = Executors.newFixedThreadPool(downloadConfig.getMaxThreadNum());
                this.mDelivery = new DownloadStatusDeliveryImpl(this.mHandler);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    private boolean isDownloadRequestRunning(String str) {
        InterceptResult invokeL;
        Downloader downloader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (!this.mDownloaderMap.containsKey(str) || (downloader = this.mDownloaderMap.get(str)) == null) {
                return false;
            }
            if (downloader.isRunning()) {
                LogUtils.w("DownloadInfo has been started!");
                return true;
            }
            throw new IllegalStateException("Downloader instance with same tag has not been destroyed!");
        }
        return invokeL.booleanValue;
    }

    public void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String createKey = createKey(str);
            if (this.mDownloaderMap.containsKey(createKey)) {
                Downloader downloader = this.mDownloaderMap.get(createKey);
                if (downloader != null) {
                    downloader.cancel();
                }
                this.mDownloaderMap.remove(createKey);
            }
        }
    }

    public void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (Downloader downloader : this.this$0.mDownloaderMap.values()) {
                            if (downloader != null && downloader.isRunning()) {
                                downloader.cancel();
                            }
                        }
                    }
                }
            });
        }
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public void download(DownloadRequest downloadRequest, String str, DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, downloadRequest, str, downloadCallback) == null) {
            String createKey = createKey(str);
            if (isDownloadRequestRunning(createKey)) {
                return;
            }
            DownloaderImpl downloaderImpl = new DownloaderImpl(downloadRequest, new DownloadResponseImpl(this.mDelivery, downloadCallback), this.mExecutorService, createKey, this.mConfig, this);
            this.mDownloaderMap.put(createKey, downloaderImpl);
            downloaderImpl.start();
        }
    }

    public boolean isRunning(String str) {
        InterceptResult invokeL;
        Downloader downloader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String createKey = createKey(str);
            if (!this.mDownloaderMap.containsKey(createKey) || (downloader = this.mDownloaderMap.get(createKey)) == null) {
                return false;
            }
            return downloader.isRunning();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.download.base.Downloader.OnDownloaderDestroyedListener
    public void onDestroyed(String str, Downloader downloader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, downloader) == null) {
            this.mHandler.post(new Runnable(this, str) { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;
                public final /* synthetic */ String val$key;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$key = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mDownloaderMap.containsKey(this.val$key)) {
                        this.this$0.mDownloaderMap.remove(this.val$key);
                    }
                }
            });
        }
    }

    public void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String createKey = createKey(str);
            if (this.mDownloaderMap.containsKey(createKey)) {
                Downloader downloader = this.mDownloaderMap.get(createKey);
                if (downloader != null && downloader.isRunning()) {
                    downloader.pause();
                }
                this.mDownloaderMap.remove(createKey);
            }
        }
    }

    public void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.minivideo.plugin.capture.download.DownloadManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (Downloader downloader : this.this$0.mDownloaderMap.values()) {
                            if (downloader != null && downloader.isRunning()) {
                                downloader.pause();
                            }
                        }
                    }
                }
            });
        }
    }

    public void download(String str, String str2, String str3, DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, downloadCallback) == null) {
            download(new DownloadRequest.Builder().setUri(str).setFolder(new File(str2)).setName(str3).build(), str, downloadCallback);
        }
    }
}
