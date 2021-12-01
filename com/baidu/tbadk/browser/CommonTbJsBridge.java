package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.d.f.p.q;
import c.a.q0.a.x;
import c.a.q0.d1.t;
import c.a.q0.d1.w;
import c.a.q0.s.s.g;
import c.a.q0.t.d.f;
import c.a.r0.k0.h;
import c.a.r0.l4.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.common.util.TriState;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@c.a.f.a.a
/* loaded from: classes9.dex */
public class CommonTbJsBridge implements c.a.r0.t3.n0.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANGE_SKIN_TYPE = "changeSkinType";
    public static final String CHECK_APP_INSTALL = "checkAppInstall";
    public static final String CLICK_GO_BACK_TO_H5 = "clickGoBackToH5";
    public static final String CLOSE_NATIVE_MASK = "closeNativeMask";
    public static final String COMPLETE_TASK = "completeTask";
    public static final String DELETE_OFFLINE_BUNDLE = "deleteOfflineBundle";
    public static final String DisableSlideBack = "disableSlideBack";
    public static final String FETCH_OFFLINE_USER_INFO = "getOfflineUserInfo";
    public static final String FINISH_TEST_ANSWER = "finishTestAnswer";
    public static final String FINISH_THIS_PAGE = "finishThisPage";
    public static final String GAME_PUSH = "gamePush";
    public static final String GAME_PUSH_STATUS = "gamePushStatus";
    public static final String GAME_SHARE = "gameShare";
    public static final String GENERAL_PREFERENCES = "generalPreferences";
    public static final String GET_APIS = "getAPIs";
    public static final String GET_CLIPPER_INFORMATION = "getClipperInformation";
    public static final String GET_DEVICE_INFO = "getDeviceInfo";
    public static final String GET_MODAL_DATA = "getModalData";
    public static final String GET_PHOTO_ALBUM = "getPhotoAlbum";
    public static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    public static final String GET_ZID = "getZid";
    public static final String GO_BACK_FROM_NATIVE = "goBackFromNative";
    public static final String GO_TO_BAR_DETAIL_PAGE = "jumpBarDetail";
    public static final String GO_TO_GOODS_SHOP = "goToGoodsShop";
    public static final String GO_TO_HOT_TREND = "goToHotTrend";
    public static final String GO_TO_MY_LIVE = "goToMyLive";
    public static final String GO_TO_MY_POST = "goToMyPost";
    public static final String GO_TO_NOTIFICATIONSETTING = "goToNotificationSetting";
    public static final String GO_TO_PB = "goToPB";
    public static final String HAS_NOTIFICATION_PERMISSION = "hasNotificationPermission";
    public static final String HIDE_WEBVIEW_LOADING = "hideWebLoading";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String IS_DISABLE_GO_BACK = "isDisableGoBack";
    public static final String JS_CHARGE_IBEAN_CALLBACK = "jsChargeIbeanCallback";
    public static final String JUMP_TO_HTML_PAGE = "jumpToHTMLPage";
    public static final String LOAD_THIRD_PARTY_LOGIN = "loadThirdPartyLogin";
    public static final String LOGIN_RESULT_TO_H5 = "loginResultToH5";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String ORIGINAL_THREAD = "1";
    public static final String PERSON_PAGE_REFRESH = "personPageRefresh";
    public static final String PERSON_PAGE_SHARE = "registerShareData";
    public static final String PLAY_SOUND = "playSound";
    public static final String PLAY_VIBRATE = "playVibrate";
    public static final String RESULT_THIRD_PARTY_LOGIN = "thirdPartyLoginResultToH5";
    public static final String RE_HIDE = "rehide";
    public static final String RE_SHOW = "reshow";
    public static final String SAVE_IMAGE = "saveImage";
    public static final String SET_CLIPPER_INFORMATION = "setClipperInformation";
    public static final String SET_SHARE_INFO = "registerShareDataNew";
    public static final String SHARE = "share";
    public static final String SHARE_SUCCCESS_NOTIFICATION = "ShareSuccessNotification";
    public static final String SHOW_TIP_TOAST = "showTipToast";
    public static final String SPRING_FESTIVAL_TIMER = "springFestivalTimer";
    public static final String START_ACCELEROMETER = "startAccelerometer";
    public static final String START_APP = "startApp";
    public static final String START_DOWNLOAD_CSS = "startDownloadCss";
    public static final String START_LOAD_TIME_INTERVAL = "startLoadTimeInterval";
    public static final String START_LOGIN_MODULE = "startLoginModule";
    public static final String SWITCH_OFFLINE_BUNDLE_STATUS = "switchOfflineBundleStatus";
    public static final String SWITCH_OFFLINE_INTERFACE = "switchOfflineInterface";
    public static final String SWITCH_URL_HOST = "switchUrlHost";
    public static final String TAG = "CommonTbJsBridge";
    public static final String THREAD_FLOOR = "2";
    public static final String THREAD_MEZZANINE_FLOOR = "3";
    public static final String TOAST_POPUPVIEW = "toastPopupView";
    public static final String UPDATE_OFFLINE_BUNDLE = "updateOfflineBundle";
    public static String tempUrl;
    public transient /* synthetic */ FieldHolder $fh;
    public final String SHOW_MORE_FORUM_ICON;
    @NonNull
    public final JSONObject emptyParams4CallJs;
    public c.a.r0.t3.n0.a jsPromptBridge;
    public final Context mContext;
    public long mLastLoadUrlTime;
    public PermissionJudgePolicy mPermissionJudgement;
    public JsPromptResult mResult;
    public x mShakeController;
    public WebView mWebView;
    public String shakeCallbackjsMethod;
    public ShareItem shareItem;

    /* loaded from: classes9.dex */
    public class a implements x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonTbJsBridge a;

        public a(CommonTbJsBridge commonTbJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonTbJsBridge;
        }

        @Override // c.a.q0.a.x.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a.shakeCallbackjsMethod)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                this.a.callJsMethod(this.a.shakeCallbackjsMethod, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends t.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonTbJsBridge a;

        public b(CommonTbJsBridge commonTbJsBridge) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonTbJsBridge;
        }

        @Override // c.a.q0.d1.t.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.a.jsPromptBridge == null) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", -1);
            this.a.jsPromptBridge.h(this.a.mWebView, "saveImageSuccess", linkedHashMap);
        }

        @Override // c.a.q0.d1.t.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.a.jsPromptBridge == null) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", 0);
            this.a.jsPromptBridge.h(this.a.mWebView, "saveImageSuccess", linkedHashMap);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends t.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonTbJsBridge f40823b;

        public c(CommonTbJsBridge commonTbJsBridge, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40823b = commonTbJsBridge;
            this.a = i2;
        }

        @Override // c.a.q0.d1.t.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            }
        }

        @Override // c.a.q0.d1.t.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                if (this.f40823b.shareItem != null) {
                    this.f40823b.shareItem.Z = 1;
                    this.f40823b.shareItem.x = str;
                }
                if (this.a != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f40823b.mContext, this.a, this.f40823b.shareItem, true));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public d(CommonTbJsBridge commonTbJsBridge, IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1434736678, "Lcom/baidu/tbadk/browser/CommonTbJsBridge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1434736678, "Lcom/baidu/tbadk/browser/CommonTbJsBridge;");
                return;
            }
        }
        tempUrl = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonTbJsBridge(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (WebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsMethod(String str, JSONObject jSONObject) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, str, jSONObject) == null) || (webView = this.mWebView) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')");
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || k.isEmpty(str) || (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(currentActivityPageContext, new String[]{str});
    }

    private String generalSharePreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            c.a.q0.s.e0.b.j().v("key_bawu_task_toast", -1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private String getAPIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 0);
                jSONObject.put("message", TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
                if (OpenJsSdkSwitch.isOn()) {
                    jSONObject.put("data", new JSONArray(DescriptionTableInfo.getDescriptionTable()));
                } else {
                    jSONObject.put("data", new JSONArray());
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    private x getShakeController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.mShakeController == null) {
                this.mShakeController = new x(this.mContext, new a(this));
            }
            return this.mShakeController;
        }
        return (x) invokeV.objValue;
    }

    private ShareItem getShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.shareItem : (ShareItem) invokeV.objValue;
    }

    private void goToGameShare(String str) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, str) == null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                BdLog.e(e2);
                jSONObject = null;
            }
            if (jSONObject != null) {
                GameShareData gameShareData = new GameShareData();
                gameShareData.parseJson(jSONObject);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameShareActivityConfig(this.mContext, gameShareData)));
            }
        }
    }

    private void hideWebviewLoading(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
        }
    }

    private boolean isLegalSchema(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, list, str)) == null) {
            if (!StringUtils.isNull(str) && !ListUtils.isEmpty(list)) {
                for (String str2 : list) {
                    if (str.startsWith(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private String jumpToPbPage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, str, str2)) == null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str, null, str2);
            createNormalCfg.setStartFrom(5);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            return null;
        }
        return (String) invokeLL.objValue;
    }

    private String loadThirdPartyLogin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            if (k.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return jumpLoginActivity(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String parseSpringFestivalTimer(String str) {
        int i2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("open");
                String optString = jSONObject.optString("method_name");
                c.a.q0.u.k kVar = new c.a.q0.u.k();
                kVar.g(optBoolean);
                kVar.f(optString);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, kVar));
                i2 = 1;
            } catch (JSONException e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                return jSONObject2.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String refreshPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
            return "";
        }
        return (String) invokeV.objValue;
    }

    private boolean requestPermission(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, activity, intentConfig)) == null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgement.setOnPermissionsGrantedListener(new d(this, intentConfig));
            return this.mPermissionJudgement.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    private void setShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, shareItem) == null) {
            this.shareItem = shareItem;
        }
    }

    private void shareLoacalImage(String str, int i2) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65561, this, str, i2) == null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(currentActivity)) {
            return;
        }
        t tVar = new t(currentActivity, str, new c(this, i2));
        tVar.p(1);
        tVar.execute(new String[0]);
    }

    private void showRightShare(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
        }
    }

    private String startAcceleromter(String str) {
        int i2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, str)) == null) {
            try {
                this.shakeCallbackjsMethod = new JSONObject(str).optString("method_name");
                if (!getShakeController().d()) {
                    getShakeController().f();
                }
                i2 = 1;
            } catch (JSONException e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                return jSONObject.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c changeSkinTypeInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hashMap)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (hashMap == null) {
                return cVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(CHANGE_SKIN_TYPE, jSONObject);
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public c.a.r0.t3.n0.d.c checkAppInstall(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            int isInstalledPackage = !StringUtils.isNull(str) ? UtilHelper.isInstalledPackage(this.mContext, str) : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, isInstalledPackage);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c closeNativeMask(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(i2 == 1)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeI.objValue;
    }

    public c.a.r0.t3.n0.d.c dealClickGoBackToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(CLICK_GO_BACK_TO_H5, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c dealGoBackFromNative(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            callJsMethod(GO_BACK_FROM_NATIVE, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public void dealJsChargeIbeanCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            callJsMethod(JS_CHARGE_IBEAN_CALLBACK, this.emptyParams4CallJs);
        }
    }

    @Override // c.a.r0.t3.n0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        boolean z;
        JSONObject jSONObject;
        boolean z2;
        JSONObject jSONObject2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, str, str2, str3, jsPromptResult)) == null) {
            CommonTbJsBridge commonTbJsBridge = this;
            if ("CommonJSBridge".equals(str)) {
                if ("startLoginModule".equals(str2)) {
                    try {
                        jsPromptResult.confirm(commonTbJsBridge.startLoginModule(new JSONObject(str3).optString("cssUrl")).a());
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (HIDE_WEBVIEW_LOADING.equals(str2)) {
                    try {
                        String optString = new JSONObject(str3).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            commonTbJsBridge.hideWebviewLoading(optString);
                        }
                        jsPromptResult.confirm();
                        return true;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (PERSON_PAGE_REFRESH.equals(str2)) {
                    try {
                        jsPromptResult.confirm(refreshPage());
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (FINISH_THIS_PAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(finishPage().a());
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                if (PERSON_PAGE_SHARE.equals(str2)) {
                    try {
                        commonTbJsBridge.showRightShare(str3);
                        jsPromptResult.confirm();
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (GAME_SHARE.equals(str2)) {
                    try {
                        commonTbJsBridge.goToGameShare(str3);
                        jsPromptResult.confirm();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    return true;
                } else if (GET_ZID.equals(str2)) {
                    jsPromptResult.confirm(getZid().a());
                    return true;
                } else if (SET_SHARE_INFO.equals(str2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        jsPromptResult.confirm(setShareInfo(jSONObject3.optString("title"), jSONObject3.optString("desc"), jSONObject3.optString("img"), jSONObject3.optString("url"), jSONObject3.optString("topic"), jSONObject3.optString("wbtitle"), jSONObject3.optString("wbcontent"), jSONObject3.optString("isShowMoreForum"), jSONObject3.optInt("shareimg"), jSONObject3.optString("extdata")).a());
                        return true;
                    } catch (JSONException e8) {
                        BdLog.e(e8);
                        return true;
                    }
                } else if ("share".equals(str2)) {
                    try {
                        jSONObject = new JSONObject(str3);
                        z = true;
                    } catch (JSONException e9) {
                        e = e9;
                        z = true;
                    }
                    try {
                        jsPromptResult.confirm(share(jSONObject.optInt("channel"), jSONObject.optInt("shareimg"), jSONObject.optString("img"), jSONObject.optString("isShowMoreForum"), jSONObject.optString("url"), jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("topic"), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optInt("weixin_disable"), jSONObject.optString("extdata")).a());
                    } catch (JSONException e10) {
                        e = e10;
                        BdLog.e(e);
                        return z;
                    }
                    return z;
                } else if (GET_CLIPPER_INFORMATION.equals(str2)) {
                    jsPromptResult.confirm(getClipperInformation().a());
                    return true;
                } else if (SET_CLIPPER_INFORMATION.equals(str2)) {
                    try {
                        z2 = true;
                    } catch (JSONException e11) {
                        e = e11;
                        z2 = true;
                    }
                    try {
                        jsPromptResult.confirm(setClipperInformation(new JSONObject(str3).optString(DocumentOpenUtil.TXT)).a());
                    } catch (JSONException e12) {
                        e = e12;
                        BdLog.e(e);
                        return z2;
                    }
                    return z2;
                } else {
                    commonTbJsBridge = this;
                    if (CHECK_APP_INSTALL.equals(str2)) {
                        try {
                            jsPromptResult.confirm(commonTbJsBridge.checkAppInstall(new JSONObject(str3).optString("pkgName")).a());
                        } catch (JSONException e13) {
                            BdLog.e(e13);
                        }
                        return true;
                    } else if (START_APP.equals(str2)) {
                        jsPromptResult.confirm(commonTbJsBridge.startApp(str3));
                        return true;
                    } else if (LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                        jsPromptResult.confirm(commonTbJsBridge.loadThirdPartyLogin(str3));
                    } else if (HAS_NOTIFICATION_PERMISSION.equals(str2)) {
                        jsPromptResult.confirm(hasNotificationPermission().a());
                        return true;
                    } else if (GO_TO_NOTIFICATIONSETTING.equals(str2)) {
                        goToNotificationSetting();
                    } else if (START_DOWNLOAD_CSS.equals(str2)) {
                        try {
                            jsPromptResult.confirm(commonTbJsBridge.startDownloadCss(new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                        } catch (JSONException e14) {
                            BdLog.e(e14);
                        }
                    } else if (SPRING_FESTIVAL_TIMER.equals(str2)) {
                        jsPromptResult.confirm(commonTbJsBridge.parseSpringFestivalTimer(str3));
                    } else if (IS_DISABLE_GO_BACK.equals(str2)) {
                        jsPromptResult.confirm(setDisableGoBack().a());
                    } else if (PLAY_VIBRATE.equals(str2)) {
                        jsPromptResult.confirm(playVibrate().a());
                    } else if (PLAY_SOUND.equals(str2)) {
                        try {
                            jsPromptResult.confirm(commonTbJsBridge.playSound(new JSONObject(str3).optString("soundUrl")).a());
                        } catch (JSONException e15) {
                            BdLog.e(e15);
                        }
                    } else if (START_ACCELEROMETER.equals(str2)) {
                        jsPromptResult.confirm(commonTbJsBridge.startAcceleromter(str3));
                    } else if (DisableSlideBack.equals(str2)) {
                        try {
                            jsPromptResult.confirm(commonTbJsBridge.disableBack(new JSONObject(str3).optInt(PackageTable.DISABLE)).a());
                        } catch (JSONException e16) {
                            BdLog.e(e16);
                        }
                    } else {
                        if (TOAST_POPUPVIEW.equals(str2)) {
                            try {
                                JSONObject jSONObject4 = new JSONObject(str3);
                                jsPromptResult.confirm(showLowerHairHint(jSONObject4.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject4.optInt("ahead_type"), jSONObject4.optString("message"), jSONObject4.optString("btn_text"), jSONObject4.optInt("toast_duration"), jSONObject4.optString("schema"), jSONObject4.optString("token"), jSONObject4.optDouble("opacity"), jSONObject4.optString(BigdayActivityConfig.IMG_URL), jSONObject4.optString("url"), jSONObject4.optInt("mission_id"), jSONObject4.optString("btn_color"), jSONObject4.optString("message_color"), jSONObject4.optString("btn_text_color"), jSONObject4.optInt("status"), jSONObject4.optInt(FINISH_THIS_PAGE)).a());
                            } catch (JSONException e17) {
                                BdLog.e(e17);
                            }
                        } else if (GAME_PUSH.equals(str2)) {
                            try {
                                jSONObject2 = new JSONObject(str3);
                            } catch (JSONException e18) {
                                e = e18;
                            }
                            try {
                                jsPromptResult.confirm(gamePush(jSONObject2.optString("gameId"), jSONObject2.optString("gameName"), jSONObject2.optString("gameTime"), jSONObject2.optString("gameType")).a());
                            } catch (JSONException e19) {
                                e = e19;
                                e.printStackTrace();
                                return true;
                            }
                            return true;
                        } else if (GAME_PUSH_STATUS.equals(str2)) {
                            jsPromptResult.confirm(handleGamePushStatus().a());
                            return true;
                        } else if (GO_TO_MY_POST.equals(str2)) {
                            try {
                                jsPromptResult.confirm(handleGoToMyPost(new JSONObject(str3).optString("uid")).a());
                            } catch (JSONException e20) {
                                BdLog.e(e20);
                            }
                            return true;
                        } else if (GO_TO_MY_LIVE.equals(str2)) {
                            try {
                                jsPromptResult.confirm(handleGoToMyLive(new JSONObject(str3).optString("uid")).a());
                            } catch (JSONException e21) {
                                BdLog.e(e21);
                            }
                            return true;
                        } else if (SAVE_IMAGE.equals(str2)) {
                            try {
                                jsPromptResult.confirm(handleSaveImage(new JSONObject(str3).optString("imgUrl")).a());
                            } catch (JSONException e22) {
                                BdLog.e(e22);
                            }
                            return true;
                        } else if (GET_PHOTO_ALBUM.equals(str2)) {
                            jsPromptResult.confirm(handleGetPhotoAlbum().a());
                            return true;
                        } else if ("getSupplementInfo".equals(str2)) {
                            jsPromptResult.confirm(getSupplementInfo().a());
                            return true;
                        } else if ("getDeviceInfo".equals(str2)) {
                            jsPromptResult.confirm(getDeviceInfo().a());
                            return true;
                        } else if (GENERAL_PREFERENCES.equals(str2)) {
                            jsPromptResult.confirm(generalSharePreferences());
                        } else if (COMPLETE_TASK.equals(str2)) {
                            try {
                                JSONObject jSONObject5 = new JSONObject(str3);
                                jsPromptResult.confirm(sendCompleteTaskReqMsg(jSONObject5.optString("activityId"), jSONObject5.optString("missionId")).a());
                            } catch (JSONException e23) {
                                BdLog.e(e23);
                            }
                        } else if (GET_MODAL_DATA.equals(str2)) {
                            jsPromptResult.confirm(getGetModalData().a());
                        } else if (SHOW_TIP_TOAST.equals(str2)) {
                            try {
                                JSONObject jSONObject6 = new JSONObject(str3);
                                jsPromptResult.confirm(showTipToast(jSONObject6.optString("content"), jSONObject6.optString("linkUrl"), jSONObject6.optString("key"), jSONObject6.optInt("maxTimes"), jSONObject6.optInt(FINISH_THIS_PAGE)).a());
                            } catch (JSONException e24) {
                                BdLog.e(e24);
                            }
                        } else if (JUMP_TO_HTML_PAGE.equals(str2)) {
                            try {
                                JSONObject jSONObject7 = new JSONObject(str3);
                                jsPromptResult.confirm(jumpToHtmlPage(jSONObject7.optString("url"), jSONObject7.optInt("finish_this_page", 1)).toString());
                            } catch (JSONException e25) {
                                BdLog.e(e25);
                            }
                        } else if (CLOSE_NATIVE_MASK.equals(str2)) {
                            try {
                                z3 = false;
                                try {
                                    jsPromptResult.confirm(closeNativeMask(new JSONObject(str3).optInt("result", 0)).a());
                                    return false;
                                } catch (JSONException e26) {
                                    e = e26;
                                    e.printStackTrace();
                                    return z3;
                                }
                            } catch (JSONException e27) {
                                e = e27;
                                z3 = false;
                            }
                        } else if (GO_TO_HOT_TREND.equals(str2)) {
                            jumpToHotTrendPage();
                            jsPromptResult.confirm();
                            return false;
                        } else if (GO_TO_PB.equals(str2)) {
                            try {
                                JSONObject jSONObject8 = new JSONObject(str3);
                                String optString2 = jSONObject8.optString("tid");
                                String optString3 = jSONObject8.optString("fr");
                                if (!StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                                    jumpToPbPage(optString2, optString3);
                                }
                                jsPromptResult.confirm();
                                return true;
                            } catch (JSONException e28) {
                                e28.printStackTrace();
                                return false;
                            }
                        } else if (GET_APIS.equals(str2)) {
                            jsPromptResult.confirm(getAPIs());
                            return true;
                        } else if (START_LOAD_TIME_INTERVAL.equals(str2)) {
                            jsPromptResult.confirm(getStartLoadTimeInterval().a());
                            return true;
                        } else if (FINISH_TEST_ANSWER.equals(str2)) {
                            try {
                                jsPromptResult.confirm(finishTestAnswer(new JSONObject(str3).optLong("testId")).a());
                            } catch (JSONException e29) {
                                e29.printStackTrace();
                            }
                            return true;
                        } else {
                            return false;
                        }
                        return false;
                    }
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public void dealSpringFestivalTimer(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, jSONObject) == null) {
            callJsMethod(str, jSONObject);
        }
    }

    public c.a.r0.t3.n0.d.c deleteOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                c.a.r0.f3.b.q().i();
                c.a.r0.f3.c.a().g(null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c disableBack(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            Context context = this.mContext;
            if (context instanceof TbWebViewActivity) {
                if (i2 == 0) {
                    ((TbWebViewActivity) context).setSwipeBackEnabled(true);
                } else {
                    ((TbWebViewActivity) context).setSwipeBackEnabled(false);
                }
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeI.objValue;
    }

    public c.a.r0.t3.n0.d.c finishPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c finishTestAnswer(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(j2)));
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
            cVar.o(FINISH_TEST_ANSWER);
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeJ.objValue;
    }

    public c.a.r0.t3.n0.d.c gamePush(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, str2, str3, str4)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gameId", str);
                jSONObject.put("gameName", str2);
                jSONObject.put("gameTime", str3);
                jSONObject.put("gameType", str4);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, jSONObject2));
                return cVar;
            }
            cVar.p();
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeLLLL.objValue;
    }

    public c.a.r0.t3.n0.d.c getClipperInformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            String clipBoardContent = UtilHelper.getClipBoardContent();
            int i2 = !k.isEmpty(clipBoardContent) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                jSONObject.put("data", clipBoardContent);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return (c.a.r0.t3.n0.d.c) invokeV.objValue;
        }
        c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
        StringBuffer stringBuffer = new StringBuffer(1024);
        String imei = TbadkCoreApplication.getInst().getImei();
        stringBuffer.append("imei=");
        stringBuffer.append(imei);
        String androidId = TbadkCoreApplication.getInst().getAndroidId();
        stringBuffer.append("androidId=");
        stringBuffer.append(androidId);
        String iMsi = TbadkCoreApplication.getInst().getIMsi();
        if (iMsi == null) {
            iMsi = "";
        }
        stringBuffer.append("imsi=");
        stringBuffer.append(iMsi);
        String str = Build.MODEL;
        stringBuffer.append("model=");
        stringBuffer.append(Build.MODEL);
        String str2 = Build.BRAND;
        stringBuffer.append("brand=");
        stringBuffer.append(str2);
        stringBuffer.append("platform=");
        stringBuffer.append("Android");
        String packageName = TbadkCoreApplication.getInst().getPackageName();
        stringBuffer.append("pkgName=");
        stringBuffer.append(packageName);
        String str3 = "" + j.I();
        stringBuffer.append("network=");
        stringBuffer.append(str3);
        String str4 = "" + j.f();
        stringBuffer.append("carrier=");
        stringBuffer.append(str4);
        String devicesManufacturer = DeviceInfoUtil.getDevicesManufacturer();
        stringBuffer.append("manufacturer=");
        stringBuffer.append(devicesManufacturer);
        String str5 = Build.HARDWARE;
        stringBuffer.append("hardware=");
        stringBuffer.append(str5);
        String str6 = Build.BOARD;
        stringBuffer.append("board=");
        stringBuffer.append(str6);
        String str7 = DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst()) ? "1" : "0";
        stringBuffer.append("imu=");
        stringBuffer.append(str7);
        stringBuffer.append("tiebaclient!!!");
        String c2 = q.c(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", imei);
                jSONObject.put("androidId", androidId);
                jSONObject.put(BaseStatisContent.IMSI, iMsi);
                jSONObject.put("model", str);
                jSONObject.put("brand", str2);
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                jSONObject.put("pkgName", packageName);
                jSONObject.put("network", str3);
                jSONObject.put("carrier", str4);
                jSONObject.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                jSONObject.put(HttpConstants.HTTP_HARDWARE, str5);
                jSONObject.put(HttpConstants.HTTP_BOARD, str6);
                jSONObject.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str7);
                jSONObject.put("sign", c2);
                cVar = cVar;
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e = e2;
                cVar = cVar;
                BdLog.e(e);
                cVar.o("");
                return cVar;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public c.a.r0.t3.n0.d.c getGetModalData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = null;
            int i2 = 0;
            try {
                String f2 = f.c().f();
                if (!TextUtils.isEmpty(f2)) {
                    jSONObject = new JSONObject(f2);
                    i2 = 1;
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                jSONObject2.put("user_info", jSONObject);
                cVar.o(jSONObject2.toString());
            } catch (JSONException e3) {
                BdLog.e(e3);
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getHdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                jSONObject.put("hdid", TbadkCoreApplication.getInst().getHdid());
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getOfflineUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", TbConfig.getVersion());
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccountId());
                jSONObject.put("hybridVersion", c.a.r0.f3.b.q().C());
                jSONObject.put("hybridOffline", QuickWebViewSwitch.getInOn() ? 1 : 0);
                jSONObject.put("offlineApiHost", tempUrl);
                if (TbDebugSingleton.getInstance().getUrlSwitchMap() != null && !TextUtils.isEmpty(TbDebugSingleton.getInstance().getUrlSwitchMap().f12416b)) {
                    jSONObject.put("hostArr", TbDebugSingleton.getInstance().getUrlSwitchMap().f12416b);
                }
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getPhotoAlbumResult(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                jSONObject.put("imageUrl", hashMap.get("url"));
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c getStartLoadTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loadUrlTime", this.mLastLoadUrlTime);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getSupplementInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            StringBuffer stringBuffer = new StringBuffer(1024);
            String imei = TbadkCoreApplication.getInst().getImei();
            stringBuffer.append("imei=");
            stringBuffer.append(imei);
            String cuid = TbadkCoreApplication.getInst().getCuid();
            stringBuffer.append("cuid=");
            stringBuffer.append(cuid);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            stringBuffer.append("shoubai_cuid=");
            stringBuffer.append(cuidGalaxy2);
            String str = Build.BRAND;
            stringBuffer.append("brand=");
            stringBuffer.append(str);
            stringBuffer.append("client_type=");
            stringBuffer.append("Android");
            String version = TbConfig.getVersion();
            stringBuffer.append("client_version=");
            stringBuffer.append(version);
            String zid = TbadkCoreApplication.getInst().getZid();
            stringBuffer.append("zid=");
            stringBuffer.append(zid);
            stringBuffer.append("tiebaclient!!!");
            String c2 = q.c(stringBuffer.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", imei);
                jSONObject.put("cuid", cuid);
                jSONObject.put("shoubai_cuid", cuidGalaxy2);
                jSONObject.put("brand", str);
                jSONObject.put("client_type", "Android");
                jSONObject.put("client_version", version);
                jSONObject.put("zid", zid);
                jSONObject.put("sign", c2);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                cVar.o("");
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            String zid = TbadkCoreApplication.getInst().getZid();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                jSONObject.put("zid", zid);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c goToEditPost(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if ("1".equals(str)) {
                WriteActivityConfig.newInstance(this.mContext).setType(9).setForumWriteData(new ForumWriteData(str6, str7, null, null)).setIsSaveDraft(false).setContent(str5).setFrom("frs").setCallFrom("2").send();
            } else if ("2".equals(str)) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str2, null, null);
                createNormalCfg.setJumpToCommentArea(true);
                createNormalCfg.showOpenEditorTips(str5);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            } else if ("3".equals(str)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.mContext).createSubPbActivityConfig(str2, str4, "mention", false, "", false, str4, 0);
                createSubPbActivityConfig.showOpenEditorTips(str5);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public c.a.r0.t3.n0.d.c goToNotificationSetting() {
        InterceptResult invokeV;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            if (currentActivity == null) {
                return cVar;
            }
            currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c goToVideoImmersivePage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        InterceptResult invokeCommon;
        String str18;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.thread_id = str;
            videoItemData.post_id = str2;
            videoItemData.title = str3;
            UserItemData userItemData = new UserItemData();
            userItemData.user_name = str4;
            userItemData.name_show = str5;
            userItemData.portrait = str6;
            videoItemData.author_info = userItemData;
            videoItemData.thumbnail_url = str7;
            videoItemData.video_url = str8;
            videoItemData.video_width = str9;
            videoItemData.video_height = str10;
            videoItemData.video_duration = c.a.d.f.m.b.e(str11, 0);
            if (c.a.d.f.m.b.g(str10, 0L) > c.a.d.f.m.b.g(str9, 0L)) {
                z = true;
                str18 = str12;
            } else {
                str18 = str12;
                z = false;
            }
            videoItemData.comment_num = str18;
            videoItemData.agree_num = str13;
            videoItemData.share_num = str14;
            videoItemData.forum_id = str15;
            videoItemData.forum_name = str16;
            arrayList.add(videoItemData);
            w.d(this.mContext, arrayList, videoItemData.nid, z, 0, null, "from_nani_video", "personalize_page", "", VideoPlayActivityConfig.FROM_H5_SEARCH, "", "1".equals(str17), false);
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public c.a.r0.t3.n0.d.c handleGamePushStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            String p = c.a.q0.s.e0.b.j().p("key_match_id_list_football", "");
            String p2 = c.a.q0.s.e0.b.j().p("key_match_id_list_basketball", "");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("football", PreferencesUtil.LEFT_MOUNT + p + PreferencesUtil.RIGHT_MOUNT);
                jSONObject.put("basketball", PreferencesUtil.LEFT_MOUNT + p2 + PreferencesUtil.RIGHT_MOUNT);
                cVar.o(jSONObject.toString());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c handleGetPhotoAlbum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) TbadkCoreApplication.getInst().getCurrentActivity(), new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setCanEditImage(false);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WEB_VIEW);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c handleGoToBarDetail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.mContext, str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE)));
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c handleGoToMyLive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mContext, str, "", "", 0, true)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c handleGoToMyPost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mContext, str, 0, null)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c handleSaveImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                cVar.p();
                return cVar;
            }
            this.mPermissionJudgement.appendRequestPermission((Activity) context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                cVar.q("权限申请");
                return cVar;
            }
            new t((Activity) this.mContext, str, new b(this)).execute(new String[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c hasNotificationPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            int areNotificationsEnabled = Build.VERSION.SDK_INT >= 19 ? NotificationManagerCompat.from(this.mContext).areNotificationsEnabled() : 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, areNotificationsEnabled);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c jumpLoginActivity(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048609, this, i2, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = new JSONObject();
            if (this.mContext == null) {
                try {
                    jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                cVar.o(jSONObject.toString());
                return cVar;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i2, str);
            WebView webView = this.mWebView;
            if (webView != null) {
                loginActivityConfig.setUrl(webView.getOriginalUrl());
            }
            ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e3) {
                BdLog.e(e3);
            }
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeIL.objValue;
    }

    public c.a.r0.t3.n0.d.c jumpToHotTrendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            c.a.q0.s.b0.b.g(this.mContext, 16, false);
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c jumpToHtmlPage(String str, int i2) {
        InterceptResult invokeLI;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, str, i2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (!TextUtils.isEmpty(str) && (context = this.mContext) != null) {
                c.a.q0.m.a.m(context, str);
                if (i2 == 1) {
                    Context context2 = this.mContext;
                    if (context2 instanceof Activity) {
                        ((Activity) context2).finish();
                    }
                }
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeLI.objValue;
    }

    public c.a.r0.t3.n0.d.c jumpToVideo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, str, str2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (WriteActivityConfig.isAsyncWriting()) {
                return cVar;
            }
            int a2 = i.a();
            if (i.c(a2)) {
                i.e(this.mContext, a2, 0);
            }
            if (i.b()) {
                i.i(null, null, null, null, 0, Boolean.TRUE, str, str2);
            } else if (!i.b() && str != null) {
                i.m(false, false, null, null, null, null, 0, Boolean.TRUE, str, str2);
            } else {
                i.l(false, false, null, null, null, null, 0, Boolean.TRUE);
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeLL.objValue;
    }

    public void onDestroy() {
        x xVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (xVar = this.mShakeController) != null && xVar.d()) {
            this.mShakeController.c();
        }
    }

    public c.a.r0.t3.n0.d.c onUserLoginChanged(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, hashMap)) == null) {
            if (hashMap == null || hashMap.get("isLogin") == null || !((Boolean) hashMap.get("isLogin")).booleanValue()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(LOGIN_RESULT_TO_H5, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c playSound(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (j.z()) {
                getShakeController().i(str);
                i2 = 1;
            } else {
                Context context = this.mContext;
                if (context != null) {
                    l.L(context, R.string.neterror);
                }
                i2 = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c playVibrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            boolean g2 = getShakeController().g();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, g2 ? 1 : 0);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public c.a.r0.t3.n0.d.c reHide(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RE_HIDE, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c reShow(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RE_SHOW, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c saveImageSuccess(HashMap<String, Integer> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, hashMap)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (hashMap != null && hashMap.get("result").intValue() == -1) {
                cVar.q("图片保存错误");
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c sendCompleteTaskReqMsg(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, str, str2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            int i2 = 0;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                    completeTaskReqMsg.completeId = jSONObject.toString();
                    completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                    MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                    i2 = 1;
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                cVar.o(jSONObject2.toString());
                return cVar;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeLL.objValue;
    }

    public c.a.r0.t3.n0.d.c setClipperInformation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            c.a.d.f.p.a.a(str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c setDisableGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            Context context = this.mContext;
            int i2 = 1;
            if (context instanceof TbWebViewActivity) {
                ((TbWebViewActivity) context).isDisableGoBack = true;
            } else {
                i2 = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public void setJsPromptBridge(c.a.r0.t3.n0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, aVar) == null) {
            this.jsPromptBridge = aVar;
        }
    }

    public void setLastLoadUrlTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) {
            this.mLastLoadUrlTime = j2;
        }
    }

    public c.a.r0.t3.n0.d.c setShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i2), str9})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", str);
                jSONObject.put("desc", str2);
                jSONObject.put("img", str3);
                jSONObject.put("url", str4);
                jSONObject.put("topic", str5);
                jSONObject.put("wbtitle", str6);
                jSONObject.put("wbcontent", str7);
                jSONObject.put("isShowMoreForum", str8);
                jSONObject.put("shareimg", i2);
                jSONObject.put("extdata", str9);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            String jSONObject2 = jSONObject.toString();
            if (k.isEmpty(jSONObject2)) {
                i3 = 0;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
                i3 = 1;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MiPushCommandMessage.KEY_RESULT_CODE, i3);
                cVar.o(jSONObject3.toString());
                return cVar;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public c.a.r0.t3.n0.d.c share(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4, String str9) {
        InterceptResult invokeCommon;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i4), str9})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", i2);
                jSONObject.put("shareimg", i3);
                jSONObject.put("img", str);
                jSONObject.put("isShowMoreForum", str2);
                jSONObject.put("url", str3);
                jSONObject.put("title", str4);
                jSONObject.put("desc", str5);
                jSONObject.put("topic", str6);
                jSONObject.put("wbtitle", str7);
                jSONObject.put("wbcontent", str8);
                jSONObject.put("weixin_disable", i4);
                jSONObject.put("extdata", str9);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            String jSONObject2 = jSONObject.toString();
            int i5 = 1;
            if (k.isEmpty(jSONObject2) || (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject2)) == null) {
                i5 = 0;
            } else {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.E = 17;
                }
                if ("1".equals(str2) && shareItem != null) {
                    shareItem.w = str;
                    shareItem.t = str3;
                    shareItem.r = str4 + " " + str5;
                    shareItem.m = true;
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    h.c().l(shareDialogConfig);
                    cVar.o("");
                    return cVar;
                } else if (i2 == 0) {
                    if (shareItem != null && !k.isEmpty(str) && i3 == 1) {
                        setShareItem(shareItem);
                        shareLoacalImage(str, i2);
                    }
                    showShareDialog(shareItem);
                } else if (shareItem != null && !k.isEmpty(str) && i3 == 1) {
                    setShareItem(shareItem);
                    shareLoacalImage(str, i2);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, i2, shareItem, true));
                }
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MiPushCommandMessage.KEY_RESULT_CODE, i5);
                cVar.o(jSONObject3.toString());
                return cVar;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public c.a.r0.t3.n0.d.c shareSuccessNotification(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, hashMap)) == null) {
            int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
            ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", shareItem.r);
                jSONObject2.put("desc", shareItem.s);
                jSONObject2.put("img", shareItem.v);
                jSONObject2.put("url", shareItem.t);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", intValue);
                jSONObject3.put("shareData", jSONObject2);
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                jSONObject.put("data", jSONObject3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(SHARE_SUCCCESS_NOTIFICATION, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c showLowerHairHint(int i2, int i3, String str, String str2, int i4, String str3, String str4, double d2, String str5, String str6, int i5, String str7, String str8, String str9, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, Integer.valueOf(i4), str3, str4, Double.valueOf(d2), str5, str6, Integer.valueOf(i5), str7, str8, str9, Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            c.a.q0.a.d0.a aVar = new c.a.q0.a.d0.a();
            aVar.f11606c = i2;
            aVar.f11607d = i3;
            aVar.f11608e = str;
            aVar.f11609f = str2;
            aVar.f11612i = i4;
            aVar.l = str3;
            aVar.n = d2;
            aVar.f11613j = str5;
            aVar.f11614k = str6;
            aVar.f11605b = i5;
            aVar.o = str7;
            aVar.p = str8;
            aVar.q = str9;
            if (i2 == c.a.q0.a.d0.a.y) {
                g.h(TbadkCoreApplication.getInst().getCurrentActivity(), aVar).j();
            } else if (i2 == c.a.q0.a.d0.a.z) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                c.a.q0.s.o.b bVar = new c.a.q0.s.o.b(currentActivity);
                if (currentActivity != null) {
                    bVar.d(currentActivity, aVar);
                    bVar.i();
                }
            } else if (i2 == c.a.q0.a.d0.a.A) {
                if (i3 == c.a.q0.a.d0.a.D) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), aVar.l) && !k.isEmpty(aVar.f11614k)) {
                        dealJump(aVar.f11614k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                    }
                } else if (i3 == c.a.q0.a.d0.a.E && !k.isEmpty(str6)) {
                    dealJump(aVar.f11614k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == c.a.q0.a.d0.a.C) {
                if (i7 == 1) {
                    Context context = this.mContext;
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
                c.a.q0.k0.h.i(new TopToastEvent(i6, str));
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public void showShareDialog(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, shareItem) == null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
        if (shareItem.Z != 0) {
            shareDialogConfig.hideMode |= 32;
        }
        shareDialogConfig.setIsSupportNightMode(true);
        shareDialogConfig.setIsCopyLink(true);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public c.a.r0.t3.n0.d.c showTipToast(String str, String str2, String str3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            int i4 = 0;
            i4 = 0;
            if (!TextUtils.isEmpty(str)) {
                Context context = this.mContext;
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = "showToast_" + str3;
                        int k2 = c.a.q0.s.e0.b.j().k(str4, 0);
                        if (k2 < i2) {
                            c.a.q0.s.e0.b.j().v(str4, k2);
                            c.a.q0.k0.h.i(new TipEvent(activity.getIntent(), str, str2, i3 == 1));
                        }
                    } else {
                        c.a.q0.k0.h.i(new TipEvent(activity.getIntent(), str, str2, i3 == 1));
                    }
                    if (i3 == 1) {
                        activity.finish();
                    }
                    i4 = 1;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i4);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return cVar;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeCommon.objValue;
    }

    public c.a.r0.t3.n0.d.c springFestivalTimeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, hashMap)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            if (hashMap != null && hashMap.get("result") != null) {
                cVar.o(hashMap.get("result"));
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public String startApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (!k.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return startApp(jSONObject.optString("pkgName"), jSONObject.optString("schema")).a();
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                return jSONObject2.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c startDownloadCss(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            JSONObject jSONObject = new JSONObject();
            if (!k.isEmpty(str)) {
                try {
                    if (k.isEmpty(str)) {
                        jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                        cVar.o(jSONObject.toString());
                        return cVar;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                        cVar.o(jSONObject.toString());
                        return cVar;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    c.a.q0.w.f.k().l(downloadData);
                    jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c startLoginModule(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            WebView webView = this.mWebView;
            if (webView == null) {
                ViewHelper.checkUpIsLogin(this.mContext);
            } else {
                ViewHelper.checkUpIsLoginFromH5(this.mContext, webView.getOriginalUrl(), str);
            }
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            cVar.o(OrmObject.jsonStrWithObject(jSResultData));
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c switchOfflineBundleStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                QuickWebViewSwitch.setState(i2 == 1 ? TriState.YES : TriState.NO);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeI.objValue;
    }

    public c.a.r0.t3.n0.d.c switchOfflineInterface(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                if (StringUtils.isNull(str)) {
                    str = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
                }
                tempUrl = str;
                c.a.q0.t.j.c.a().g(true);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, tempUrl + "?cmd=309485");
                tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c switchUrlHost(ArrayList<JSONObject> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, arrayList)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                c.a.q0.m.d dVar = new c.a.q0.m.d();
                dVar.a = new LinkedHashMap();
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        JSONObject jSONObject = arrayList.get(i2);
                        if (jSONObject != null) {
                            dVar.a.put(jSONObject.optString("path"), jSONObject.optString("host"));
                        }
                    }
                    if (dVar.a.size() > 0) {
                        dVar.f12416b = new JSONObject().put("hostArr", new JSONArray((Collection) arrayList)).toString();
                        TbDebugSingleton.getInstance().setUrlSwitchMap(dVar);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c thirdPartyLoginResultToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                jSONObject.put("socialType", hashMap.get("social_type"));
                jSONObject.put("activityId", hashMap.get("activityId"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RESULT_THIRD_PARTY_LOGIN, jSONObject);
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            cVar.o(jSONObject.toString());
            return cVar;
        }
        return (c.a.r0.t3.n0.d.c) invokeL.objValue;
    }

    public c.a.r0.t3.n0.d.c updateOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
            try {
                c.a.r0.f3.b.q().i();
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.r0.t3.n0.d.c) invokeV.objValue;
    }

    public CommonTbJsBridge(Context context, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.SHOW_MORE_FORUM_ICON = "1";
        this.emptyParams4CallJs = new JSONObject();
        this.mLastLoadUrlTime = 0L;
        this.mContext = context;
        this.mWebView = webView;
    }

    public void dealSpringFestivalTimer(HashMap hashMap) {
        c.a.r0.t3.n0.a aVar;
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) || (aVar = this.jsPromptBridge) == null || (webView = this.mWebView) == null || hashMap == null) {
            return;
        }
        aVar.h(webView, "getPageLeaveTime", hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a.r0.t3.n0.d.c startApp(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048632, this, str, str2)) != null) {
            return (c.a.r0.t3.n0.d.c) invokeLL.objValue;
        }
        c.a.r0.t3.n0.d.c cVar = new c.a.r0.t3.n0.d.c();
        List<String> a2 = c.a.q0.t.c.j.a();
        try {
            if (isLegalSchema(a2, str2)) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str2));
                try {
                    this.mContext.startActivity(intent);
                    z = true;
                } catch (ActivityNotFoundException unused) {
                }
                if (!z && isLegalSchema(a2, str) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(str)) != null) {
                    this.mContext.startActivity(launchIntentForPackage);
                    z = true;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, z ? 1 : 0);
                cVar.o(jSONObject.toString());
                return cVar;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, z ? 1 : 0);
            cVar.o(jSONObject2.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
        z = false;
        if (!z) {
            this.mContext.startActivity(launchIntentForPackage);
            z = true;
        }
    }
}
