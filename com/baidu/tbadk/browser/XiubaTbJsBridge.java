package com.baidu.tbadk.browser;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class XiubaTbJsBridge implements c.a.r0.j3.m0.b {
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
    public BaseWebView mBaseWebView;
    public final TbPageContext<?> mTbPageContext;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XiubaTbJsBridge f47441a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(XiubaTbJsBridge xiubaTbJsBridge, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiubaTbJsBridge, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47441a = xiubaTbJsBridge;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (data = customResponsedMessage.getData()) != null && (data instanceof Intent) && "com.xiu8.baidu.activity".equals(XiubaTbJsBridge.getPackageName((Intent) data))) {
                this.f47441a.callInstallListener();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f47442a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ XiubaTbJsBridge f47443b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(XiubaTbJsBridge xiubaTbJsBridge, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xiubaTbJsBridge, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47443b = xiubaTbJsBridge;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
                DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
                if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0) {
                    return;
                }
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null && "com.xiu8.baidu.activity".equals(downloadData.getId())) {
                        if (downloadData.getStatus() == 5) {
                            if (!this.f47442a) {
                                this.f47442a = true;
                                this.f47443b.callDownloadListener(1);
                            }
                        } else if (downloadData.getStatus() == 0 || downloadData.getStatus() == 3) {
                            this.f47443b.callDownloadListener(2);
                            this.f47442a = false;
                        } else if (downloadData.getStatus() == 2 || downloadData.getStatus() == 4) {
                            this.f47443b.callDownloadListener(0);
                            this.f47442a = false;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void callDownloadListener(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            JSResultData.Result result = new JSResultData.Result();
            jSResultData.setResult(result);
            result.setDownload(i2);
            JSONObject jsonWithObject = OrmObject.jsonWithObject(jSResultData);
            if (this.mTbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) this.mTbPageContext.getOrignalPage()).loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            BaseWebView baseWebView = this.mBaseWebView;
            if (baseWebView != null) {
                baseWebView.loadUrl("javascript:addEventLisener('download'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callInstallListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
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
            BaseWebView baseWebView = this.mBaseWebView;
            if (baseWebView != null) {
                baseWebView.loadUrl("javascript:addEventLisener('install'," + jsonWithObject + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    private JSONObject checkAPKInstall(String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Long.valueOf(j2), str2})) == null) {
            if (str != null && str2 != null) {
                String substring = md5(md5(JSResultData.AUTH_KEY + str + j2).substring(0, 16)).substring(8, 24);
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

    private String downLoadAPK(String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{str, Long.valueOf(j2), str2})) == null) {
            if (str != null && str2 != null) {
                String substring = md5(md5(JSResultData.AUTH_KEY + str + j2).substring(0, 16)).substring(8, 24);
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

    public static String getPackageName(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            return (split == null || split.length != 2) ? dataString : split[1];
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

    private boolean isInstall(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            if (!StringUtils.isNull(str) && (split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) != null && split.length != 0) {
                int e2 = c.a.e.e.m.b.e(split[0], 0);
                if (e2 > 3) {
                    return true;
                }
                if (split.length >= 2 && e2 == 3 && c.a.e.e.m.b.e(split[1], 0) >= 2) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
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
                for (int i2 = 0; i2 < digest.length; i2++) {
                    int i3 = digest[i2];
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    if (i3 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i3));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private void startDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            c.q().z("com.xiu8.baidu.activity", str, TbadkCoreApplication.getInst().getResources().getString(R.string.xiuba_apk_name), -1, -1);
        }
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
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.j3.m0.b
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } else if ("downLoadAPK".equals(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        jsPromptResult.confirm(downLoadAPK(jSONObject2.optString("url"), jSONObject2.optLong("tk"), jSONObject2.optString("sign")));
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } else if ("touch_close".equals(str2)) {
                    try {
                        jsPromptResult.confirm(isEnableWebViewTouch(Boolean.FALSE));
                        return false;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } else if ("touch_open".equals(str2)) {
                    try {
                        jsPromptResult.confirm(isEnableWebViewTouch(Boolean.TRUE));
                        return false;
                    } catch (Exception e5) {
                        e5.printStackTrace();
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

    public void setBaseWebView(BaseWebView baseWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseWebView) == null) {
            this.mBaseWebView = baseWebView;
        }
    }
}
