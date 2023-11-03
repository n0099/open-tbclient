package com.baidu.browser.sailor;

import android.content.Context;
import android.net.http.SslError;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.tieba.hs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes3.dex */
public class BdSailorClient extends WebKitClient implements INoProGuard, ISailorUrlPushService, hs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DownloadTaskType {
        public static final /* synthetic */ DownloadTaskType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DownloadTaskType BROWSER;
        public static final DownloadTaskType ZEUS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(198774903, "Lcom/baidu/browser/sailor/BdSailorClient$DownloadTaskType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(198774903, "Lcom/baidu/browser/sailor/BdSailorClient$DownloadTaskType;");
                    return;
                }
            }
            ZEUS = new DownloadTaskType(BdSailorConfig.SAILOR_BASE_ZEUS, 0);
            DownloadTaskType downloadTaskType = new DownloadTaskType("BROWSER", 1);
            BROWSER = downloadTaskType;
            $VALUES = new DownloadTaskType[]{ZEUS, downloadTaskType};
        }

        public DownloadTaskType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DownloadTaskType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DownloadTaskType) Enum.valueOf(DownloadTaskType.class, str) : (DownloadTaskType) invokeL.objValue;
        }

        public static DownloadTaskType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DownloadTaskType[]) $VALUES.clone() : (DownloadTaskType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface IDownloadTaskListener extends INoProGuard {
        void onDownloadCancel(String str, long j, long j2, String str2);

        void onDownloadFail(String str, long j, String str2, String str3);

        void onDownloadPause(String str, long j, long j2, String str2);

        void onDownloadStart(String str, long j, String str2);

        void onDownloadSuccess(String str, String str2, long j);

        void onDownloading(String str, long j, long j2);
    }

    public BdSailorClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void checkErrorPageWifiBtnShow(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webView) == null) {
        }
    }

    public String getApplicationVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String getErrorPageInfo(Context context, int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i), str, str2, str3})) == null) {
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public String getErrpgSearchUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public String getLocationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getProcessedUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    public String getSslErrorInfo(Context context, SslError sslError) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, sslError)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public boolean getSwitchByKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public String getUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void invokeWifiPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public boolean isNeedUpdate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onAddToLauncher(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public boolean onDownloadTask(String str, String str2, String str3, String str4, DownloadTaskType downloadTaskType, IDownloadTaskListener iDownloadTaskListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, str2, str3, str4, downloadTaskType, iDownloadTaskListener})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onGetABTestPolicy(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
        }
    }

    public void onSailorStatistics(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
        }
    }

    public void onShareWebPage(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
        }
    }

    public void onShouldInsertToHistory(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public boolean onStartLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public void onStopLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void statWifiErrorPageShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public void updateFingerprint(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
        }
    }

    public void updateSearchUrlProtocol(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, context, z) == null) {
        }
    }
}
