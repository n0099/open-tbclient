package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.cd5;
import com.baidu.tieba.dq9;
import com.baidu.tieba.gg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XiubaTbJsBridge implements dq9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERFACE_NAME = "XiubaJSBridge";
    public static final String METHOD_CHECK_APK_INSTALL = "checkAPKInstall";
    public static final String METHOD_DOWNLOAD_APK = "downLoadAPK";
    public static final String METHOD_TOUCH_CLOSE = "touch_close";
    public static final String METHOD_TOUCH_OPEN = "touch_open";
    public static final String XIUBA_PACKAGE = "com.xiu8.baidu.activity";
    public static final int XIUBA_VERSION_FIRST = 3;
    public static final int XIUBA_VERSION_SECOND = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener downloadListener;
    public final CustomMessageListener installListener;
    public WebView mBaseWebView;
    public final TbPageContext<?> mTbPageContext;
    public TbWebView tbWebView;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XiubaTbJsBridge a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(XiubaTbJsBridge xiubaTbJsBridge, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiubaTbJsBridge, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xiubaTbJsBridge;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (data = customResponsedMessage.getData()) != null && (data instanceof Intent) && "com.xiu8.baidu.activity".equals(XiubaTbJsBridge.getPackageName((Intent) data))) {
                this.a.callInstallListener();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ XiubaTbJsBridge b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(XiubaTbJsBridge xiubaTbJsBridge, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiubaTbJsBridge, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xiubaTbJsBridge;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof DownloadMessage)) {
                return;
            }
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() != null && downloadMessage.getData().size() > 0) {
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null && "com.xiu8.baidu.activity".equals(downloadData.getId())) {
                        if (downloadData.getStatus() == 5) {
                            if (!this.a) {
                                this.a = true;
                                this.b.callDownloadListener(1);
                            }
                        } else if (downloadData.getStatus() != 0 && downloadData.getStatus() != 3) {
                            if (downloadData.getStatus() == 2 || downloadData.getStatus() == 4) {
                                this.b.callDownloadListener(0);
                                this.a = false;
                            }
                        } else {
                            this.b.callDownloadListener(2);
                            this.a = false;
                        }
                    }
                }
            }
        }
    }

    public XiubaTbJsBridge(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.installListener = new a(this, 2002501);
        b bVar = new b(this, 2001118);
        this.downloadListener = bVar;
        this.mTbPageContext = tbPageContext;
        tbPageContext.registerListener(bVar);
        this.mTbPageContext.registerListener(this.installListener);
    }

    public static String md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer("");
                for (int i = 0; i < digest.length; i++) {
                    int i2 = digest[i];
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    if (i2 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i2));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private boolean validateGameUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                String authority = url.getAuthority();
                if (!StringUtils.isNull(protocol) && !StringUtils.isNULL(authority) && protocol.equals("https")) {
                    if (authority.endsWith("bdstatic.com")) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getPackageName(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            if (split != null && split.length == 2) {
                return split[1];
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    private String isEnableWebViewTouch(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, bool)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002503, bool));
            return "";
        }
        return (String) invokeL.objValue;
    }

    private void startDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            cd5.q().z("com.xiu8.baidu.activity", str, TbadkCoreApplication.getInst().getResources().getString(R.string.xiuba_apk_name), -1, -1);
        }
    }

    public void setBaseWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) {
            this.mBaseWebView = webView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDownloadListener(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            JSResultData.Result result = new JSResultData.Result();
            jSResultData.setResult(result);
            result.setDownload(i);
            JSONObject jsonWithObject = OrmObject.jsonWithObject(jSResultData);
            if (this.mTbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            WebView webView = this.mBaseWebView;
            if (webView != null) {
                webView.loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            TbWebView tbWebView = this.tbWebView;
            if (tbWebView != null) {
                tbWebView.loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callInstallListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            JSResultData.Result result = new JSResultData.Result();
            jSResultData.setResult(result);
            result.setInstall(1);
            JSONObject jsonWithObject = OrmObject.jsonWithObject(jSResultData);
            if (this.mTbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            WebView webView = this.mBaseWebView;
            if (webView != null) {
                webView.loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            TbWebView tbWebView = this.tbWebView;
            if (tbWebView != null) {
                tbWebView.loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    private JSONObject checkAPKInstall(String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{str, Long.valueOf(j), str2})) == null) {
            if (str != null && str2 != null) {
                String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
                JSResultData jSResultData = new JSResultData();
                if (!TextUtils.isEmpty(str2) && str2.equals(substring)) {
                    jSResultData.setStatus(1);
                    jSResultData.setErrorCode("0");
                    jSResultData.setErrorMsg("");
                    JSResultData.Result result = new JSResultData.Result();
                    jSResultData.setResult(result);
                    String installApkVersionName = UtilHelper.getInstallApkVersionName(TbadkCoreApplication.getInst(), str);
                    if (installApkVersionName != null) {
                        if (isInstall(installApkVersionName)) {
                            result.setIsInstall(1);
                            result.setApkVersion(installApkVersionName);
                        } else {
                            result.setIsInstall(0);
                            result.setApkVersion("");
                        }
                    } else {
                        result.setIsInstall(0);
                        result.setApkVersion("");
                    }
                    return OrmObject.jsonWithObject(jSResultData);
                }
            }
            return null;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    private String downLoadAPK(String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{str, Long.valueOf(j), str2})) == null) {
            if (str != null && str2 != null) {
                String substring = md5(md5(JSResultData.AUTH_KEY + str + j).substring(0, 16)).substring(8, 24);
                JSResultData jSResultData = new JSResultData();
                if (!TextUtils.isEmpty(str2) && str2.equals(substring) && validateGameUrl(str)) {
                    startDownload(str);
                    jSResultData.setStatus(1);
                    jSResultData.setErrorCode("0");
                    jSResultData.setErrorMsg("");
                    return OrmObject.jsonStrWithObject(jSResultData);
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    private boolean isInstall(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            if (!StringUtils.isNull(str) && (split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) != null && split.length != 0) {
                int e = gg.e(split[0], 0);
                if (e > 3) {
                    return true;
                }
                if (split.length >= 2 && e == 3 && gg.e(split[1], 0) >= 2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.dq9
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
            if ("XiubaJSBridge".equals(str)) {
                if ("checkAPKInstall".equals(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        jsPromptResult.confirm(checkAPKInstall(jSONObject.optString("apkName"), jSONObject.optLong("tk"), jSONObject.optString("sign")).toString());
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                } else if ("downLoadAPK".equals(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        jsPromptResult.confirm(downLoadAPK(jSONObject2.optString("url"), jSONObject2.optLong("tk"), jSONObject2.optString("sign")));
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } else if ("touch_close".equals(str2)) {
                    try {
                        jsPromptResult.confirm(isEnableWebViewTouch(Boolean.FALSE));
                        return false;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } else if ("touch_open".equals(str2)) {
                    try {
                        jsPromptResult.confirm(isEnableWebViewTouch(Boolean.TRUE));
                        return false;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public void setBaseWebView(TbWebView tbWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbWebView) == null) {
            this.tbWebView = tbWebView;
        }
    }
}
