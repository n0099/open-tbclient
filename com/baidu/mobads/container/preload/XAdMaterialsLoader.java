package com.baidu.mobads.container.preload;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.NetUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdMaterialsLoader implements Observer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MATERIAL_SETTING_URL = "https://mobads.baidu.com/ads/preload.php";
    public static volatile XAdMaterialsLoader instance;
    public static AtomicBoolean mMaterialDownloading;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public String mAppId;
    public int materialLogType;
    public List<XAdMaterialsInfo> materialsInfos;
    public String outputFolder;

    /* loaded from: classes2.dex */
    public static class MyTask extends BaseTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public XAdMaterialsLoader mLoader;

        public MyTask(XAdMaterialsLoader xAdMaterialsLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xAdMaterialsLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLoader = xAdMaterialsLoader;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.mLoader.loadSetting();
                return null;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040339758, "Lcom/baidu/mobads/container/preload/XAdMaterialsLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040339758, "Lcom/baidu/mobads/container/preload/XAdMaterialsLoader;");
                return;
            }
        }
        mMaterialDownloading = new AtomicBoolean(false);
    }

    public XAdMaterialsLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.materialLogType = 413;
    }

    public static XAdMaterialsLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (instance == null) {
                synchronized (XAdMaterialsLoader.class) {
                    if (instance == null) {
                        instance = new XAdMaterialsLoader();
                    }
                }
            }
            return instance;
        }
        return (XAdMaterialsLoader) invokeV.objValue;
    }

    private String getOutputFolderPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            return context.getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
        }
        return (String) invokeL.objValue;
    }

    private boolean isDownload(XAdMaterialsInfo xAdMaterialsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, xAdMaterialsInfo)) == null) ? xAdMaterialsInfo.getAppsid().equals(this.mAppId) && stringToLong(xAdMaterialsInfo.getExpired()) <= System.currentTimeMillis() : invokeL.booleanValue;
    }

    private boolean isMaterialExists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.outputFolder);
            sb.append(str);
            return new File(sb.toString()).exists();
        }
        return invokeL.booleanValue;
    }

    private void loadMateContent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.materialsInfos = XAdMaterialsInfo.fromJsonArray(new JSONObject(str).optJSONArray("preload"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            loadMateContent(NetUtils.doGet(AdURIUtils.replaceURLWithSupportProtocol(MATERIAL_SETTING_URL)));
            startLoadMaterials();
        }
    }

    private void startLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, str2) == null) {
            try {
                SendLogUtil.START_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
                IDownloader createSimpleFileDownloader = OAdRemoteDownloadManager.getInstance(this.mAppContext).createSimpleFileDownloader(new URL(str), this.outputFolder, str2, true);
                createSimpleFileDownloader.addObserver(this);
                createSimpleFileDownloader.start();
            } catch (Exception unused) {
            }
        }
    }

    private void startLoadMaterials() {
        List<XAdMaterialsInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (list = this.materialsInfos) == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.materialsInfos.size(); i2++) {
            XAdMaterialsInfo xAdMaterialsInfo = this.materialsInfos.get(i2);
            String url = xAdMaterialsInfo.getUrl();
            String md5 = EncryptUtils.getMD5(url);
            if (isDownload(xAdMaterialsInfo) && isMaterialExists(md5)) {
                SendLogUtil.START_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
                SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
                SendLogUtil.sendLog(this.mAppContext, this.materialLogType, "material_has_loaded", url);
            }
            if (isDownload(xAdMaterialsInfo) && !isMaterialExists(md5)) {
                startLoad(url, md5);
            }
        }
    }

    private long stringToLong(String str) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            try {
                date = new SimpleDateFormat("yyyyMMdd").parse(str);
            } catch (Exception unused) {
                date = null;
            }
            if (date == null) {
                return 0L;
            }
            return date.getTime();
        }
        return invokeL.longValue;
    }

    public void startLoadRemoteSetting(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || mMaterialDownloading.get()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.outputFolder = getOutputFolderPath(applicationContext);
        this.mAppId = DeviceUtils.getInstance().getAppId(this.mAppContext);
        mMaterialDownloading.set(true);
        TaskScheduler.getInstance().submitWithDelay(new MyTask(this), 2L, TimeUnit.SECONDS);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IDownloader iDownloader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observable, obj) == null) || (iDownloader = (IDownloader) observable) == null) {
            return;
        }
        if (iDownloader.getState() == IDownloader.DownloadStatus.COMPLETED) {
            SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
            SendLogUtil.sendLog(this.mAppContext, this.materialLogType, "success", iDownloader.getURL());
        } else if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR) {
            SendLogUtil.END_REQUEST_TIME = String.valueOf(System.currentTimeMillis());
            SendLogUtil.sendLog(this.mAppContext, this.materialLogType, SmsLoginView.f.l, iDownloader.getURL());
        }
    }
}
