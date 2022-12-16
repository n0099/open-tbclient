package com.baidu.searchbox.util;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.x10;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CuidCookieSync {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "CuidCookie";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-414336132, "Lcom/baidu/searchbox/util/CuidCookieSync;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-414336132, "Lcom/baidu/searchbox/util/CuidCookieSync;");
                return;
            }
        }
        DEBUG = LibBLCConfig.GLOBAL_DEBUG;
    }

    public CuidCookieSync() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void setCUIDToSystemWebView(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, str, str2) { // from class: com.baidu.searchbox.util.CuidCookieSync.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CuidCookieSync this$0;
                public final /* synthetic */ String val$cookieValue;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$url = str;
                    this.val$cookieValue = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            CookieManager.getInstance().setCookie(this.val$url, this.val$cookieValue);
                            if (DeviceUtil.OSInfo.hasLollipop()) {
                                CookieManager.getInstance().flush();
                                return;
                            }
                            CookieSyncManager.createInstance(AppRuntime.getAppContext());
                            CookieSyncManager.getInstance().sync();
                        } catch (Exception e) {
                            if (CuidCookieSync.DEBUG) {
                                e.printStackTrace();
                            }
                            this.this$0.errorUBC("setCUIDToSystemWebView MissingWebViewPackageException");
                        }
                    }
                }
            }, "setCUIDToSystemWebView", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorUBC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("from", "search");
                hashMap.put("page", "browser");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                hashMap.put("ext", jSONObject.toString());
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("811", hashMap);
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "searchErrorUBC  error", e);
                }
            }
        }
    }

    public void setCUIDCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IBaiduIdentityContext baiduIdentityContext = BaiduIdentityRuntime.getBaiduIdentityContext();
            if (!new CT().isDefaultCtv()) {
                String cookieStr = UrlUtil.getCookieStr(AppConfig.getCookieHost(), "BAIDUCUID", x10.a(BaiduIdentityManager.getInstance().getEnUid()), 31449600L);
                baiduIdentityContext.setCookieManualNoBdussOperate("www.baidu.com", cookieStr, true);
                if (baiduIdentityContext.isBlinkEnable()) {
                    setCUIDToSystemWebView("www.baidu.com", cookieStr);
                }
            }
        }
    }
}
