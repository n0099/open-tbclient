package com.baidu.mobads.container.gray;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.jar.JarFile;
/* loaded from: classes5.dex */
public class RemoteVersionUtil {
    public static /* synthetic */ Interceptable $ic;
    public static volatile RemoteVersionUtil instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String XAD_APK_NAME_DOWNLOADED;
    public String XAD_APK_NAME_PREFIX;
    public String XAD_APK_NAME_RUNNING;
    public String __DIR_OF_DOWNLOAD_XAD_APK__;
    public String mApkSaveDir;
    public Context mAppContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2130043412, "Lcom/baidu/mobads/container/gray/RemoteVersionUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2130043412, "Lcom/baidu/mobads/container/gray/RemoteVersionUtil;");
        }
    }

    public RemoteVersionUtil(Context context) {
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
        this.__DIR_OF_DOWNLOAD_XAD_APK__ = "baidu_sdk_remote";
        this.XAD_APK_NAME_PREFIX = "__xadsdk__remote__final__";
        this.XAD_APK_NAME_DOWNLOADED = this.XAD_APK_NAME_PREFIX + "downloaded__.jar";
        this.XAD_APK_NAME_RUNNING = this.XAD_APK_NAME_PREFIX + "running__.jar";
        this.mApkSaveDir = null;
        this.mAppContext = context;
        initDownloadedPath();
    }

    private String getDownloadedApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return this.mApkSaveDir + this.XAD_APK_NAME_DOWNLOADED;
        }
        return (String) invokeV.objValue;
    }

    public static RemoteVersionUtil getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (instance == null) {
                synchronized (RemoteVersionUtil.class) {
                    if (instance == null) {
                        instance = new RemoteVersionUtil(context);
                    }
                }
            }
            return instance;
        }
        return (RemoteVersionUtil) invokeL.objValue;
    }

    private double getRemoteVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            try {
                File file = new File(str);
                if (isFileExistsAndCanRead(file)) {
                    JarFile jarFile = new JarFile(file);
                    double parseDouble = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    jarFile.close();
                    if (parseDouble > 0.0d) {
                        return parseDouble;
                    }
                }
            } catch (Throwable unused) {
            }
            return 0.0d;
        }
        return invokeL.doubleValue;
    }

    private String getRunningApkPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            return this.mApkSaveDir + this.XAD_APK_NAME_RUNNING;
        }
        return (String) invokeV.objValue;
    }

    private void initDownloadedPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                if (TextUtils.isEmpty(this.mApkSaveDir)) {
                    File dir = this.mAppContext.getDir(this.__DIR_OF_DOWNLOAD_XAD_APK__, 0);
                    this.mApkSaveDir = dir.getAbsolutePath() + "/";
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean isFileExistsAndCanRead(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists() && file.canRead()) {
                        return file.length() > 0;
                    }
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public double getDownloadedVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getRemoteVersion(getDownloadedApkPath()) : invokeV.doubleValue;
    }

    public double getRunningVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getRemoteVersion(getRunningApkPath()) : invokeV.doubleValue;
    }
}
