package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.controller.OAdBasicNetworkBroadcastReceiver;
import com.baidu.mobads.container.components.controller.OAdBasicNetworkController;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class OAdRemoteDownloadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_OUTPUT_FOLDER = "";
    public static final String TAG = "OAdRemoteDownloadManager";
    public static OAdRemoteDownloadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, IDownloader> mAdsApkDownloaderMap;
    public Context mContext;
    public OAdBasicNetworkController networkController;
    public AtomicBoolean restartDownloadAppBefore;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1310824050, "Lcom/baidu/mobads/container/components/downloader/OAdRemoteDownloadManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1310824050, "Lcom/baidu/mobads/container/components/downloader/OAdRemoteDownloadManager;");
        }
    }

    public OAdRemoteDownloadManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdsApkDownloaderMap = new HashMap<>();
        this.restartDownloadAppBefore = new AtomicBoolean(false);
        this.mContext = context;
    }

    public static OAdRemoteDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (sInstance == null) {
                sInstance = new OAdRemoteDownloadManager(context);
            }
            return sInstance;
        }
        return (OAdRemoteDownloadManager) invokeL.objValue;
    }

    public synchronized IDownloader createAdsApkDownloader(URL url, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        OAdRemoteApkDownloader oAdRemoteApkDownloader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{url, str, str2, Integer.valueOf(i2), str3})) == null) {
            synchronized (this) {
                oAdRemoteApkDownloader = new OAdRemoteApkDownloader(this.mContext, url, str, str2, i2, str3);
                putAdsApkDownloader(str3, oAdRemoteApkDownloader);
                try {
                    if (this.networkController == null) {
                        this.networkController = new OAdBasicNetworkController(this.mContext);
                        this.networkController.setBroadcastReceiver(new OAdBasicNetworkBroadcastReceiver(this.networkController));
                        this.networkController.addEventListener(OAdBasicNetworkController.NETWORK_CHANGED, new IOAdEventListener(this) { // from class: com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ OAdRemoteDownloadManager this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.baidu.mobads.sdk.api.IOAdEventListener
                            public void run(IOAdEvent iOAdEvent) {
                                NetworkInfo activeNetworkInfo;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iOAdEvent) == null) {
                                    try {
                                        RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "网络状态已经改变");
                                        activeNetworkInfo = ((ConnectivityManager) this.this$0.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
                                    } catch (Exception e2) {
                                        RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e2);
                                        return;
                                    }
                                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                                        String typeName = activeNetworkInfo.getTypeName();
                                        int type = activeNetworkInfo.getType();
                                        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                                        remoteXAdLogger.d(OAdRemoteDownloadManager.TAG, "当前网络名称：" + typeName + "; 网络类型：" + type);
                                        ArrayList<IDownloader> allAdsApkDownloaderes = this.this$0.getAllAdsApkDownloaderes();
                                        if (allAdsApkDownloaderes != null) {
                                            for (IDownloader iDownloader : allAdsApkDownloaderes) {
                                                if (type == 1) {
                                                    if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR || iDownloader.getState() == IDownloader.DownloadStatus.PAUSED) {
                                                        try {
                                                            iDownloader.resume();
                                                        } catch (Exception e3) {
                                                            RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e3);
                                                        }
                                                    }
                                                } else if (type == 0) {
                                                    RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "mobile net work");
                                                    if (!iDownloader.isDownloadOnlyWifi()) {
                                                        if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR || iDownloader.getState() == IDownloader.DownloadStatus.PAUSED) {
                                                            try {
                                                                iDownloader.resume();
                                                            } catch (Exception e4) {
                                                                RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e4);
                                                            }
                                                        }
                                                    } else {
                                                        try {
                                                            iDownloader.setPausedManually(false);
                                                            iDownloader.pause();
                                                        } catch (Exception e5) {
                                                            RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e5);
                                                        }
                                                    }
                                                }
                                                RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, e2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    RemoteXAdLogger.getInstance().d(OAdRemoteDownloadManager.TAG, "没有可用网络");
                                }
                            }
                        });
                        this.networkController.startListener();
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(TAG, e2);
                }
            }
            return oAdRemoteApkDownloader;
        }
        return (IDownloader) invokeCommon.objValue;
    }

    public IDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{url, str, str2, Boolean.valueOf(z)})) == null) ? new FileDownloader(url, str, str2, z) : (IDownloader) invokeCommon.objValue;
    }

    public IDownloader getAdsApkDownloader(String str) {
        InterceptResult invokeL;
        IDownloader iDownloader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this.mAdsApkDownloaderMap) {
                iDownloader = this.mAdsApkDownloaderMap.get(str);
            }
            return iDownloader;
        }
        return (IDownloader) invokeL.objValue;
    }

    public ArrayList<IDownloader> getAllAdsApkDownloaderes() {
        InterceptResult invokeV;
        ArrayList<IDownloader> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mAdsApkDownloaderMap) {
                Collection<IDownloader> values = this.mAdsApkDownloaderMap.values();
                if (values.size() > 0) {
                    arrayList = new ArrayList<>();
                    for (IDownloader iDownloader : values) {
                        arrayList.add(iDownloader);
                    }
                } else {
                    arrayList = null;
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void putAdsApkDownloader(String str, IDownloader iDownloader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, iDownloader) == null) {
            synchronized (this.mAdsApkDownloaderMap) {
                this.mAdsApkDownloaderMap.put(str, iDownloader);
            }
        }
    }

    public Boolean removeAdsApkDownloader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this.mAdsApkDownloaderMap) {
                this.mAdsApkDownloaderMap.remove(str);
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }

    public void removeAllAdsApkDownloaderes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.mAdsApkDownloaderMap) {
                this.mAdsApkDownloaderMap.clear();
            }
        }
    }
}
