package com.baidu.mobads.container.remote.tdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.NetUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XSecurityDexLoader implements Observer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SECURITY_SETTING_URL = "https://mobads.baidu.com/ads/sec.php";
    public static final String __DIR_OF_DOWNLOAD_XAD_APK__ = "baidu_ad_sdk";
    public static volatile XSecurityDexLoader instance;
    public transient /* synthetic */ FieldHolder $fh;
    public File file;
    public String fileName;
    public String mAppsid;
    public DexClassLoader mClassLoader;
    public Context mContext;
    public String mCurAppSid;
    public String mSecurityDexUrl;
    public AtomicBoolean mSecurityDownloading;
    public String mSign;
    public String mTdid;
    public String mZid;
    public String optimizedDirectory;
    public String outputFolder;

    /* loaded from: classes3.dex */
    public static class MyTask extends BaseTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public XSecurityDexLoader mLoader;

        public MyTask(XSecurityDexLoader xSecurityDexLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xSecurityDexLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLoader = xSecurityDexLoader;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1501863247, "Lcom/baidu/mobads/container/remote/tdid/XSecurityDexLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1501863247, "Lcom/baidu/mobads/container/remote/tdid/XSecurityDexLoader;");
        }
    }

    public XSecurityDexLoader() {
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
        this.mSecurityDownloading = new AtomicBoolean(false);
        this.mAppsid = "";
        this.fileName = "security_sdk_dex.jar";
        this.mClassLoader = null;
        this.outputFolder = null;
        this.optimizedDirectory = null;
        this.mZid = "";
        this.mTdid = "";
    }

    private String calcApkFileMD5Sum(File file) {
        InterceptResult invokeL;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, file)) != null) {
            return (String) invokeL.objValue;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (new DigestInputStream(fileInputStream2, messageDigest).read(new byte[4096]) != -1) {
                }
                String str = "";
                for (int i2 = 0; i2 < messageDigest.digest().length; i2++) {
                    str = str + Integer.toString((digest[i2] & 255) + 256, 16).substring(1);
                }
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (Exception unused3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean checkVrJarMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            File file = this.file;
            if (file == null || !file.exists()) {
                return false;
            }
            return this.mSign.equals(calcApkFileMD5Sum(this.file));
        }
        return invokeV.booleanValue;
    }

    private void deleteFile() {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && (file = this.file) != null && file.exists()) {
            this.file.delete();
        }
    }

    private DexClassLoader getClassLoader(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            if (this.mClassLoader == null) {
                initFile(context);
                loadVrDex();
            }
            return this.mClassLoader;
        }
        return (DexClassLoader) invokeL.objValue;
    }

    public static XSecurityDexLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (instance == null) {
                synchronized (XSecurityDexLoader.class) {
                    if (instance == null) {
                        instance = new XSecurityDexLoader();
                    }
                }
            }
            return instance;
        }
        return (XSecurityDexLoader) invokeV.objValue;
    }

    private void getOutputFolderPath(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, context) == null) && TextUtils.isEmpty(this.outputFolder)) {
            File dir = this.mContext.getDir(__DIR_OF_DOWNLOAD_XAD_APK__, 0);
            this.outputFolder = dir.getAbsolutePath() + "/";
        }
    }

    private String getTdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            if (context == null) {
                return this.mTdid;
            }
            if (!TextUtils.isEmpty(this.mTdid)) {
                return this.mTdid;
            }
            DexClassLoader classLoader = getClassLoader(context);
            if (classLoader != null) {
                try {
                    Method declaredMethod = classLoader.loadClass("com.sofire.zlu.FH").getDeclaredMethod("gd", Context.class);
                    declaredMethod.setAccessible(true);
                    this.mTdid = (String) declaredMethod.invoke(null, context.getApplicationContext());
                } catch (Exception unused) {
                    this.mTdid = "";
                }
            }
            return this.mTdid;
        }
        return (String) invokeL.objValue;
    }

    private String getZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, context)) == null) {
            if (context == null) {
                return this.mZid;
            }
            if (!TextUtils.isEmpty(this.mZid)) {
                return this.mZid;
            }
            DexClassLoader classLoader = getClassLoader(context);
            if (classLoader != null) {
                try {
                    Method declaredMethod = classLoader.loadClass("com.sofire.zlu.FH").getDeclaredMethod("gzfi", Context.class, String.class, Integer.TYPE, String.class);
                    declaredMethod.setAccessible(true);
                    this.mZid = (String) declaredMethod.invoke(null, context.getApplicationContext(), null, 0, null);
                } catch (Exception unused) {
                    this.mZid = "";
                }
            }
            return this.mZid;
        }
        return (String) invokeL.objValue;
    }

    private void initFile(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.optimizedDirectory = applicationContext.getFilesDir().getAbsolutePath();
            getOutputFolderPath(context);
            this.file = new File(this.outputFolder + this.fileName);
        }
    }

    private boolean isAppsidEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (TextUtils.isEmpty(this.mCurAppSid) || TextUtils.isEmpty(this.mAppsid)) {
                return false;
            }
            return this.mAppsid.equals("all") || this.mAppsid.contains(this.mCurAppSid);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                loadSettingJSON(NetUtils.doGet(AdURIUtils.replaceURLWithSupportProtocol(SECURITY_SETTING_URL)));
            } catch (Exception unused) {
            }
            if (CommonUtils.isWifi(this.mContext.getApplicationContext()) && isAppsidEnabled() && !checkVrJarMd5()) {
                deleteFile();
                startLoad(this.mSecurityDexUrl, this.fileName);
            }
        }
    }

    private void loadSettingJSON(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mAppsid = jSONObject.optString("appsid");
            String optString = jSONObject.optString("url");
            this.mSecurityDexUrl = optString;
            this.mSecurityDexUrl = AdURIUtils.replaceURLWithSupportProtocol(optString);
            this.mSign = jSONObject.optString("sign");
        } catch (Exception unused) {
        }
    }

    private void loadVrDex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                synchronized (XSecurityDexLoader.class) {
                    this.mClassLoader = new DexClassLoader(this.file.getAbsolutePath(), this.optimizedDirectory, null, this.mContext.getClass().getClassLoader());
                }
            } catch (Exception unused) {
                this.mClassLoader = null;
            }
        }
    }

    private void startLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, str, str2) == null) {
            try {
                IDownloader createSimpleFileDownloader = OAdRemoteDownloadManager.getInstance(this.mContext).createSimpleFileDownloader(new URL(str), this.outputFolder, str2, true);
                createSimpleFileDownloader.addObserver(this);
                createSimpleFileDownloader.start();
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject getSecurityInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("zid", getZid(context));
                jSONObject.put("tdid", getTdid(context));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void startTdidUpgrade(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || this.mSecurityDownloading.get()) {
            return;
        }
        this.mSecurityDownloading.set(true);
        this.mContext = context;
        this.mCurAppSid = DeviceUtils.getInstance().getAppId(this.mContext.getApplicationContext());
        getOutputFolderPath(this.mContext.getApplicationContext());
        this.file = new File(this.outputFolder + this.fileName);
        this.optimizedDirectory = this.mContext.getFilesDir().getAbsolutePath();
        TaskScheduler.getInstance().submitWithDelay(new MyTask(this), 1500L, TimeUnit.MILLISECONDS);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IDownloader iDownloader;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, observable, obj) == null) || (iDownloader = (IDownloader) observable) == null || TextUtils.isEmpty(this.mSecurityDexUrl) || !this.mSecurityDexUrl.equals(iDownloader.getURL())) {
            return;
        }
        if (iDownloader.getState() == IDownloader.DownloadStatus.COMPLETED) {
            if (checkVrJarMd5()) {
                loadVrDex();
            } else {
                deleteFile();
            }
        } else if (iDownloader.getState() == IDownloader.DownloadStatus.ERROR) {
            deleteFile();
        }
    }
}
