package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.auth.AliAuthHttpProxy;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.bz9;
import com.baidu.tieba.cb8;
import com.baidu.tieba.dh5;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.ha7;
import com.baidu.tieba.hy4;
import com.baidu.tieba.i95;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.ip;
import com.baidu.tieba.iy4;
import com.baidu.tieba.jy4;
import com.baidu.tieba.ky4;
import com.baidu.tieba.ly4;
import com.baidu.tieba.ml6;
import com.baidu.tieba.my4;
import com.baidu.tieba.n95;
import com.baidu.tieba.ny4;
import com.baidu.tieba.oy4;
import com.baidu.tieba.pr6;
import com.baidu.tieba.py4;
import com.baidu.tieba.qy4;
import com.baidu.tieba.ry4;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sy4;
import com.baidu.tieba.ty4;
import com.baidu.tieba.ui;
import com.baidu.tieba.uy4;
import com.baidu.tieba.vy4;
import com.baidu.tieba.wy9;
import com.baidu.tieba.xy9;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ip
/* loaded from: classes4.dex */
public class CommonTbJsBridge implements xy9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANGE_POST_WALL = "postFakeTheWall";
    public static final String CHANGE_SKIN_TYPE = "changeSkinType";
    public static final String CHECK_APP_INSTALL = "checkAppInstall";
    public static final String CLICK_GO_BACK_TO_H5 = "clickGoBackToH5";
    public static final String CLOSE_NATIVE_MASK = "closeNativeMask";
    public static final String COMPLETE_TASK = "completeTask";
    public static final String DELETE_OFFLINE_BUNDLE = "deleteOfflineBundle";
    public static final String DEVICE_DISPLAY_REFRESH = "deviceDisplayRefresh";
    public static final String DisableSlideBack = "disableSlideBack";
    public static final String FETCH_OFFLINE_USER_INFO = "getOfflineUserInfo";
    public static final String FILE_DOWNLOAD_CURRENT_SIZE = "currentSize";
    public static final String FILE_DOWNLOAD_FILE_NAME = "fileName";
    public static final String FILE_DOWNLOAD_SOURCE = "source";
    public static final String FILE_DOWNLOAD_STATUS = "status";
    public static final String FILE_DOWNLOAD_STATUS_MSG = "statusMsg";
    public static final String FILE_DOWNLOAD_STATUS_RESULT = "fileDownloadStatusResult";
    public static final String FILE_DOWNLOAD_TOTAL_SIZE = "totalSize";
    public static final String FILE_DOWNLOAD_URL = "fileUrl";
    public static final String FINISH_TEST_ANSWER = "finishTestAnswer";
    public static final String FINISH_THIS_PAGE = "finishThisPage";
    public static final String GAME_PUSH = "gamePush";
    public static final String GAME_PUSH_STATUS = "gamePushStatus";
    public static final String GAME_SHARE = "gameShare";
    public static final String GENERAL_PREFERENCES = "generalPreferences";
    public static final String GET_APIS = "getAPIs";
    public static final String GET_APP_STORAGE = "getAppStorage";
    public static final String GET_CLIPPER_INFORMATION = "getClipperInformation";
    public static final String GET_DEVICE_INFO = "getDeviceInfo";
    public static final String GET_HISTORY_FORUM_DATA = "getHistoryForumData";
    public static final String GET_MODAL_DATA = "getModalData";
    public static final String GET_PHOTO_ALBUM = "getPhotoAlbum";
    public static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    public static final String GET_ZID = "getZid";
    public static final String GO_BACK_FROM_NATIVE = "goBackFromNative";
    public static final String GO_TO_GOODS_SHOP = "goToGoodsShop";
    public static final String GO_TO_HOT_TREND = "goToHotTrend";
    public static final String GO_TO_MY_LIVE = "goToMyLive";
    public static final String GO_TO_MY_POST = "goToMyPost";
    public static final String GO_TO_NOTIFICATIONSETTING = "goToNotificationSetting";
    public static final String GO_TO_PB = "goToPB";
    public static final int H5_PERSONALIZED_REC_SWITCH_UNSET = -1;
    public static final String HAS_NOTIFICATION_PERMISSION = "hasNotificationPermission";
    public static final String HIDE_WEBVIEW_LOADING = "hideWebLoading";
    public static final String INSTALL_APK_RESULT = "installApkResult";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String IS_DISABLE_GO_BACK = "isDisableGoBack";
    public static final String JS_CHARGE_IBEAN_CALLBACK = "jsChargeIbeanCallback";
    public static final String JUMP_TO_HTML_PAGE = "jumpToHTMLPage";
    public static final String KEY_GROUP_CHAT_CHANGE_AVATAR = "setChatGroupAvatar";
    public static final String KEY_GROUP_CHAT_CHANGE_NAME = "setChatGroupName";
    public static final String KEY_GROUP_CHAT_CREATE = "createChatGroup";
    public static final String KEY_GROUP_CHAT_DISSLOVE = "dissolveChatGroup";
    public static final String KEY_GROUP_CHAT_MANAGE = "setChatGroupManager";
    public static final String KEY_GROUP_CHAT_NOTIFY_REFTESH = "browsedChatGroupAnnouncement";
    public static final String KEY_SPRING_FESTIVAL_PICK_FORUM = "springPickBa";
    public static final String LOAD_THIRD_PARTY_LOGIN = "loadThirdPartyLogin";
    public static final String LOGIN_RESULT_TO_H5 = "loginResultToH5";
    public static final String OPEN_VIP_SUCCESS = "openVipSuccess";
    public static final String ORIGINAL_THREAD = "1";
    public static final String PERSON_PAGE_REFRESH = "personPageRefresh";
    public static final String PERSON_PAGE_SHARE = "registerShareData";
    public static final String PLAY_SOUND = "playSound";
    public static final String PLAY_VIBRATE = "playVibrate";
    public static final String PUT_APP_STORAGE = "putAppStorage";
    public static final String QQpackageName = "com.tencent.mobileqq";
    public static final String REFRESH_TAIL = "refreshTail";
    public static final String RESULT_THIRD_PARTY_LOGIN = "thirdPartyLoginResultToH5";
    public static final String RE_HIDE = "rehide";
    public static final String RE_SHOW = "reshow";
    public static final String SAVE_IMAGE = "saveImage";
    public static final String SENSOR_GYROSCOPE_EVENT_X = "sensorGyroscopeEventX";
    public static final String SENSOR_GYROSCOPE_EVENT_Y = "sensorGyroscopeEventY";
    public static final String SENSOR_GYROSCOPE_EVENT_Z = "sensorGyroscopeEventZ";
    public static final String SET_CLIPPER_INFORMATION = "setClipperInformation";
    public static final String SET_SHARE_INFO = "registerShareDataNew";
    public static final String SHARE = "share";
    public static final String SHARE_SUCCCESS_NOTIFICATION = "ShareSuccessNotification";
    public static final String SHOW_TIP_TOAST = "showTipToast";
    public static final String SPRING_FESTIVAL_TIMER = "springFestivalTimer";
    public static final String START_ACCELEROMETER = "startAccelerometer";
    public static final String START_ALL_LOGIN_MODULE = "shartAllLoginModule";
    public static final String START_APP = "startApp";
    public static final String START_DOWNLOAD_CSS = "startDownloadCss";
    public static final String START_LOAD_TIME_INTERVAL = "startLoadTimeInterval";
    public static final String START_LOGIN_MODULE = "startLoginModule";
    public static final String SWITCH_OFFLINE_BUNDLE_STATUS = "switchOfflineBundleStatus";
    public static final String SWITCH_OFFLINE_INTERFACE = "switchOfflineInterface";
    public static final String SWITCH_URL_HOST = "switchUrlHost";
    public static final String THREAD_FLOOR = "2";
    public static final String THREAD_MEZZANINE_FLOOR = "3";
    public static final String TOAST_POPUPVIEW = "toastPopupView";
    public static final String UPDATE_OFFLINE_BUNDLE = "updateOfflineBundle";
    public static String tempUrl;
    public transient /* synthetic */ FieldHolder $fh;
    public final String ONLY_THIRD_SHARE;
    public final String SHOW_MORE_FORUM_ICON;
    public hy4 accountJsBridgePlugin;
    public iy4 activityJsBridgePlugin;
    public final AliAuthHttpProxy aliHttpProxy;
    public jy4 clipperJsBridgePlugin;
    public ky4 deviceJsBridgePlugin;
    @NonNull
    public final JSONObject emptyParams4CallJs;
    public ly4 hostJsBridgePlugin;
    public my4 hybridDebugJsBridgePlugin;
    public ny4 hybridJsBridgePlugin;
    public wy9 jsPromptBridge;
    public oy4 logJsBridgePlugin;
    public final Context mContext;
    public int mH5PersonalizedRecSwitch;
    public long mLastLoadUrlTime;
    public PermissionJudgePolicy mPermissionJudgement;
    public yu4 mShakeController;
    public volatile ha7 mTbDownloadManager;
    public WebView mWebView;
    public py4 navigationBarJsBridgePlugin;
    public qy4 paymentJsBridgePlugin;
    public ry4 routerJsBridgePlugin;
    public String shakeCallbackjsMethod;
    public ShareItem shareItem;
    public sy4 shareJsBridgePlugin;
    public ty4 subscriptionJsBridgePlugin;
    public uy4 systemJsBridgePlugin;
    public vy4 toastJsBridgePlugin;

    /* loaded from: classes4.dex */
    public class a implements yu4.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonTbJsBridge;
        }

        @Override // com.baidu.tieba.yu4.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.a.shakeCallbackjsMethod)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 1);
                    this.a.callJsMethod(this.a.shakeCallbackjsMethod, jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ CommonTbJsBridge b;

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public b(CommonTbJsBridge commonTbJsBridge, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonTbJsBridge;
            this.a = i;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                if (this.b.shareItem != null) {
                    this.b.shareItem.k0 = 1;
                    this.b.shareItem.B = str;
                }
                if (this.a != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.mContext, this.a, this.b.shareItem, true));
                }
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

    private String generalSharePreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            n95.m().z("key_bawu_task_toast", -1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                return jSONObject.toString();
            } catch (JSONException e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (WebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private String loadThirdPartyLogin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            if (!ui.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return jumpLoginActivity(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public bz9 changeSkinTypeInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            if (hashMap == null) {
                return bz9Var;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callJsMethod(CHANGE_SKIN_TYPE, jSONObject);
            bz9Var.o(jSONObject.toString());
            return bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public CommonTbJsBridge(Context context, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.SHOW_MORE_FORUM_ICON = "1";
        this.ONLY_THIRD_SHARE = "1";
        this.emptyParams4CallJs = new JSONObject();
        this.mLastLoadUrlTime = 0L;
        this.mH5PersonalizedRecSwitch = -1;
        this.mTbDownloadManager = null;
        this.accountJsBridgePlugin = new hy4();
        this.routerJsBridgePlugin = new ry4();
        this.toastJsBridgePlugin = new vy4();
        this.subscriptionJsBridgePlugin = new ty4();
        this.systemJsBridgePlugin = new uy4();
        this.hostJsBridgePlugin = new ly4();
        this.paymentJsBridgePlugin = new qy4();
        this.logJsBridgePlugin = new oy4();
        this.clipperJsBridgePlugin = new jy4();
        this.activityJsBridgePlugin = new iy4();
        this.shareJsBridgePlugin = new sy4();
        this.hybridJsBridgePlugin = new ny4();
        this.navigationBarJsBridgePlugin = new py4();
        this.deviceJsBridgePlugin = new ky4();
        this.hybridDebugJsBridgePlugin = new my4();
        this.mContext = context;
        this.mWebView = webView;
        this.aliHttpProxy = new AliAuthHttpProxy(webView);
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, str) == null) && !ui.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(currentActivityPageContext, new String[]{str});
        }
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, activity)) == null) {
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

    private void setShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, shareItem) == null) {
            this.shareItem = shareItem;
        }
    }

    private void showRightShare(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
        }
    }

    public bz9 checkAppInstall(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.systemJsBridgePlugin.d(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 checkAuthState(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.accountJsBridgePlugin.d(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 checkInstallGameApk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.systemJsBridgePlugin.e(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 closeNativeMask(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.systemJsBridgePlugin.f(this.mWebView, i);
        }
        return (bz9) invokeI.objValue;
    }

    public bz9 dealClickGoBackToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.g(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 dealGoBackFromNative(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.h(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public void dealSpringFestivalTimer(HashMap hashMap) {
        wy9 wy9Var;
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) && (wy9Var = this.jsPromptBridge) != null && (webView = this.mWebView) != null && hashMap != null) {
            wy9Var.i(webView, "getPageLeaveTime", hashMap);
        }
    }

    public bz9 deviceMotion(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hashMap)) == null) {
            return this.deviceJsBridgePlugin.e(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 deviceRefreshRate(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, hashMap)) == null) {
            return this.deviceJsBridgePlugin.f(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 deviceRefreshRateParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return this.deviceJsBridgePlugin.g(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 disableBack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            return this.systemJsBridgePlugin.i(this.mWebView, i);
        }
        return (bz9) invokeI.objValue;
    }

    public bz9 finishTestAnswer(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            return this.activityJsBridgePlugin.c(this.mWebView, j);
        }
        return (bz9) invokeJ.objValue;
    }

    public bz9 getAppStorage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return this.systemJsBridgePlugin.l(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getGetModalData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return this.toastJsBridgePlugin.e(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getPhotoAlbumResult(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.p(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getSelectPhotoAlbumResult(HashMap<String, List<HashMap>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.q(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getSelectPrivateImResult(HashMap<String, List<ReportPrivateMsgData>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.d(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getToReportThemePage(HashMap<String, ArrayList<String>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.e(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 handleSaveImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            return this.systemJsBridgePlugin.u(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 nativeNetworkProxy(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, hashMap)) == null) {
            return this.hybridJsBridgePlugin.k(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 newThirdPartyLoginResultToH5(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, hashMap)) == null) {
            return this.accountJsBridgePlugin.r(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 notifyApkInstallResult(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.A(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 notifyFileDownloadStatusResult(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.B(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 openMXDYab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            return this.paymentJsBridgePlugin.c(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 openVipSuccessInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, hashMap)) == null) {
            return this.paymentJsBridgePlugin.d(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 orderGameApkResult(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.D(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 personlizedSwitchChange(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, str)) == null) {
            return this.activityJsBridgePlugin.d(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 playSound(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) {
            return this.systemJsBridgePlugin.E(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 postWriteWallData(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, hashMap)) == null) {
            return this.activityJsBridgePlugin.e(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 preheatWeb(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, arrayList)) == null) {
            return this.hostJsBridgePlugin.f(this.mWebView, arrayList);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 reHide(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.o(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 reShow(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.p(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 realNameAuthResult(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, hashMap)) == null) {
            return this.accountJsBridgePlugin.n(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 refreshTailInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.q(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 replyPost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            return this.routerJsBridgePlugin.r(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 replyPostResult(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, hashMap)) == null) {
            return this.routerJsBridgePlugin.s(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 saveImageSuccess(HashMap<String, Integer> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, hashMap)) == null) {
            return this.systemJsBridgePlugin.H(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 setClipperInformation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, str)) == null) {
            return this.clipperJsBridgePlugin.d(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public void setJsPromptBridge(wy9 wy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, wy9Var) == null) {
            this.jsPromptBridge = wy9Var;
            this.aliHttpProxy.m(wy9Var);
        }
    }

    public void setLastLoadUrlTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048672, this, j) == null) {
            this.mLastLoadUrlTime = j;
        }
    }

    public bz9 setSearchHistory(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, hashMap)) == null) {
            return this.hybridJsBridgePlugin.o(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 shareSuccessNotification(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, hashMap)) == null) {
            return this.shareJsBridgePlugin.h(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 springFestivalTimeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, hashMap)) == null) {
            return this.logJsBridgePlugin.c(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 startDownloadCss(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, str)) == null) {
            return this.accountJsBridgePlugin.p(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 startLoginModule(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, str)) == null) {
            return this.accountJsBridgePlugin.q(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 switchOfflineBundleStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048688, this, i)) == null) {
            return this.hybridDebugJsBridgePlugin.f(this.mWebView, i);
        }
        return (bz9) invokeI.objValue;
    }

    public bz9 switchOfflineInterface(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, str)) == null) {
            return this.hybridDebugJsBridgePlugin.g(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 switchUrlHost(ArrayList<JSONObject> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, arrayList)) == null) {
            return this.hybridDebugJsBridgePlugin.h(this.mWebView, arrayList);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 updateSearchForumInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, str)) == null) {
            return this.activityJsBridgePlugin.h(this.mWebView, str);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 writePostSuccess(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, hashMap)) == null) {
            return this.activityJsBridgePlugin.k(this.mWebView, hashMap);
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 getFileDownloadProgress(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, str, str2, str3)) == null) {
            return this.systemJsBridgePlugin.m(this.mWebView, str, str2, str3);
        }
        return (bz9) invokeLLL.objValue;
    }

    public bz9 getFileDownloadStatus(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, str, str2, str3)) == null) {
            return this.systemJsBridgePlugin.n(this.mWebView, str, str2, str3);
        }
        return (bz9) invokeLLL.objValue;
    }

    public bz9 handlePortal(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048627, this, str, str2, str3)) == null) {
            return this.routerJsBridgePlugin.i(this.mWebView, str, str2, str3);
        }
        return (bz9) invokeLLL.objValue;
    }

    public bz9 jumpToVideo(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048635, this, str, str2, str3)) == null) {
            return this.routerJsBridgePlugin.l(this.mWebView, str, str2, str3);
        }
        return (bz9) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsMethod(String str, JSONObject jSONObject) {
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, this, str, jSONObject) != null) || (webView = this.mWebView) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')");
    }

    private String getAPIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
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
            } catch (JSONException e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private yu4 getShakeController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.mShakeController == null) {
                this.mShakeController = new yu4(this.mContext, new a(this));
            }
            return this.mShakeController;
        }
        return (yu4) invokeV.objValue;
    }

    private String refreshPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
            return "";
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ void a() {
        this.jsPromptBridge.i(this.mWebView, "commonLogin", new HashMap<String, Object>(this) { // from class: com.baidu.tbadk.browser.CommonTbJsBridge.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CommonTbJsBridge this$0;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                put("resultCode", 2);
                put("hasLogin", Boolean.TRUE);
            }
        });
    }

    public void dealJsChargeIbeanCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            callJsMethod(JS_CHARGE_IBEAN_CALLBACK, this.emptyParams4CallJs);
        }
    }

    public bz9 deleteOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.hybridDebugJsBridgePlugin.c(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getAlipayUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.aliHttpProxy.l();
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getClipperInformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.clipperJsBridgePlugin.c(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.deviceJsBridgePlugin.h(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getHdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.deviceJsBridgePlugin.i(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getHistoryForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.systemJsBridgePlugin.o(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getOfflineUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.hybridDebugJsBridgePlugin.d(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getStartLoadTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.systemJsBridgePlugin.r(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 getSupplementInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.deviceJsBridgePlugin.j(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public ha7 getTbDownloadManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.mTbDownloadManager == null) {
                synchronized (CommonTbJsBridge.class) {
                    if (this.mTbDownloadManager == null) {
                        this.mTbDownloadManager = new ha7();
                    }
                }
            }
            return this.mTbDownloadManager;
        }
        return (ha7) invokeV.objValue;
    }

    public bz9 getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.deviceJsBridgePlugin.k(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public int getmH5PersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mH5PersonalizedRecSwitch;
        }
        return invokeV.intValue;
    }

    public bz9 goToNotificationSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.systemJsBridgePlugin.s(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 handleGamePushStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.subscriptionJsBridgePlugin.e(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 handleGetPhotoAlbum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.systemJsBridgePlugin.t(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 hasNotificationPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.systemJsBridgePlugin.v(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 jumpToHotTrendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            bz9 bz9Var = new bz9();
            i95.g(this.mContext, 16, false);
            return bz9Var;
        }
        return (bz9) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.aliHttpProxy.k();
            yu4 yu4Var = this.mShakeController;
            if (yu4Var != null && yu4Var.d()) {
                this.mShakeController.c();
            }
        }
    }

    public bz9 playVibrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.systemJsBridgePlugin.F(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 setDisableGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.navigationBarJsBridgePlugin.c(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 toOneKeyDeletion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.activityJsBridgePlugin.g(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 updateOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.hybridDebugJsBridgePlugin.i(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    public bz9 wakeKeyboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.systemJsBridgePlugin.M(this.mWebView);
        }
        return (bz9) invokeV.objValue;
    }

    private boolean isLegalSchema(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, list, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, str, str2)) == null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str, null, str2);
            createNormalCfg.setStartFrom(5);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void showGroupShareDialog(ShareItem shareItem, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048677, this, shareItem, i) == null) && shareItem != null && shareItem.L0 != null) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            shareItem.M0 = z;
            shareItem.o0 = true;
            shareItem.R = 11;
            pr6.c().l(new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null));
            cb8.b(shareItem.L0);
        }
    }

    private String parseSpringFestivalTimer(String str) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("open");
                String optString = jSONObject.optString("method_name");
                dh5 dh5Var = new dh5();
                dh5Var.g(optBoolean);
                dh5Var.f(optString);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, dh5Var));
                i = 1;
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String startAcceleromter(String str) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            try {
                this.shakeCallbackjsMethod = new JSONObject(str).optString("method_name");
                if (!getShakeController().d()) {
                    getShakeController().f();
                }
                i = 1;
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public bz9 handleGoToMyLive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            bz9 bz9Var = new bz9();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mContext, str, "", "", 0, true)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return bz9Var;
            }
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 handleGoToMyPost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            bz9 bz9Var = new bz9();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mContext, str, 0, null)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return bz9Var;
            }
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 onUserLoginChanged(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, hashMap)) == null) {
            if (hashMap == null || hashMap.get("isLogin") == null || !((Boolean) hashMap.get("isLogin")).booleanValue()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callJsMethod(LOGIN_RESULT_TO_H5, jSONObject);
            bz9 bz9Var = new bz9();
            bz9Var.o(jSONObject.toString());
            return bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public String startApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, str)) == null) {
            if (!ui.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return startApp(jSONObject.optString("pkgName"), jSONObject.optString("schema")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public bz9 thirdPartyLoginResultToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
                jSONObject.put("socialType", hashMap.get("social_type"));
                jSONObject.put("activityId", hashMap.get("activityId"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callJsMethod(RESULT_THIRD_PARTY_LOGIN, jSONObject);
            bz9 bz9Var = new bz9();
            bz9Var.o(jSONObject.toString());
            return bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    private void shareLoacalImage(String str, int i) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65555, this, str, i) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
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
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, str, new b(this, i));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    public void showShareDialog(ShareItem shareItem, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048679, this, shareItem, z) != null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
        shareDialogConfig.setIsSupportNightMode(true);
        if (!z) {
            if (shareItem.k0 != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsCopyLink(true);
        }
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // com.baidu.tieba.xy9
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        JSONObject jSONObject;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str)) {
                if ("startLoginModule".equals(str2)) {
                    try {
                        jsPromptResult.confirm(startLoginModule(new JSONObject(str3).optString("cssUrl")).a());
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (START_ALL_LOGIN_MODULE.equals(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        jsPromptResult.confirm(startAllLoginModule(jSONObject2.optString("type"), jSONObject2.optString("addObserverNotify"), jSONObject2.optString("activityId"), jSONObject2.optString("cssUrl")).a());
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (HIDE_WEBVIEW_LOADING.equals(str2)) {
                    jsPromptResult.confirm();
                    return true;
                }
                if (PERSON_PAGE_REFRESH.equals(str2)) {
                    try {
                        jsPromptResult.confirm(refreshPage());
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (FINISH_THIS_PAGE.equals(str2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        jsPromptResult.confirm(finishPage(jSONObject3.optString("nextPage"), jSONObject3.optString("source")).a());
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (PERSON_PAGE_SHARE.equals(str2)) {
                    try {
                        showRightShare(str3);
                        jsPromptResult.confirm();
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                if (GET_ZID.equals(str2)) {
                    jsPromptResult.confirm(getZid().a());
                    return true;
                } else if (SET_SHARE_INFO.equals(str2)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(str3);
                        jsPromptResult.confirm(setShareInfo(jSONObject4.optString("title"), jSONObject4.optString("desc"), jSONObject4.optString("img"), jSONObject4.optString("url"), jSONObject4.optString("topic"), jSONObject4.optString("wbtitle"), jSONObject4.optString("wbcontent"), jSONObject4.optString("isShowMoreForum"), jSONObject4.optInt("shareimg"), jSONObject4.optString("extdata")).a());
                        return true;
                    } catch (JSONException e6) {
                        BdLog.e(e6);
                        return true;
                    }
                } else if ("share".equals(str2)) {
                    try {
                        JSONObject jSONObject5 = new JSONObject(str3);
                        jsPromptResult.confirm(share(jSONObject5.optInt("channel"), jSONObject5.optInt("shareimg"), jSONObject5.optString("img"), jSONObject5.optString("isShowMoreForum"), jSONObject5.optString("url"), jSONObject5.optString("title"), jSONObject5.optString("desc"), jSONObject5.optString("topic"), jSONObject5.optString("wbtitle"), jSONObject5.optString("wbcontent"), jSONObject5.optInt("weixin_disable"), jSONObject5.optString("extdata"), jSONObject5.optInt("source"), jSONObject5.optString("topicid"), jSONObject5.optString("disableSafari"), jSONObject5.optLong("roomId"), jSONObject5.optInt("filterRooms"), jSONObject5.optInt("roomMemberCount"), jSONObject5.optLong("fid"), jSONObject5.optString("forumName"), jSONObject5.optString("onlyThirdShare"), jSONObject5.optString("addObserverNotify"), jSONObject5.optString("panelTitle"), jSONObject5.optJSONObject("shareIMCard")).a());
                        return true;
                    } catch (JSONException e7) {
                        BdLog.e(e7);
                        return true;
                    }
                } else if (GET_CLIPPER_INFORMATION.equals(str2)) {
                    jsPromptResult.confirm(getClipperInformation().a());
                    return true;
                } else if (SET_CLIPPER_INFORMATION.equals(str2)) {
                    try {
                        try {
                            jsPromptResult.confirm(setClipperInformation(new JSONObject(str3).optString("txt")).a());
                        } catch (JSONException e8) {
                            e = e8;
                            BdLog.e(e);
                            return true;
                        }
                    } catch (JSONException e9) {
                        e = e9;
                    }
                    return true;
                } else if (CHECK_APP_INSTALL.equals(str2)) {
                    try {
                        jsPromptResult.confirm(checkAppInstall(new JSONObject(str3).optString("pkgName")).a());
                    } catch (JSONException e10) {
                        BdLog.e(e10);
                    }
                    return true;
                } else if (START_APP.equals(str2)) {
                    jsPromptResult.confirm(startApp(str3));
                    return true;
                } else if (LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                    jsPromptResult.confirm(loadThirdPartyLogin(str3));
                } else if (HAS_NOTIFICATION_PERMISSION.equals(str2)) {
                    jsPromptResult.confirm(hasNotificationPermission().a());
                    return true;
                } else if (GO_TO_NOTIFICATIONSETTING.equals(str2)) {
                    goToNotificationSetting();
                } else if (START_DOWNLOAD_CSS.equals(str2)) {
                    try {
                        jsPromptResult.confirm(startDownloadCss(new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                    } catch (JSONException e11) {
                        BdLog.e(e11);
                    }
                } else if (SPRING_FESTIVAL_TIMER.equals(str2)) {
                    jsPromptResult.confirm(parseSpringFestivalTimer(str3));
                } else if (IS_DISABLE_GO_BACK.equals(str2)) {
                    jsPromptResult.confirm(setDisableGoBack().a());
                } else if (PLAY_VIBRATE.equals(str2)) {
                    jsPromptResult.confirm(playVibrate().a());
                } else if (PLAY_SOUND.equals(str2)) {
                    try {
                        jsPromptResult.confirm(playSound(new JSONObject(str3).optString("soundUrl")).a());
                    } catch (JSONException e12) {
                        BdLog.e(e12);
                    }
                } else if (START_ACCELEROMETER.equals(str2)) {
                    jsPromptResult.confirm(startAcceleromter(str3));
                } else if (DisableSlideBack.equals(str2)) {
                    try {
                        jsPromptResult.confirm(disableBack(new JSONObject(str3).optInt(PackageTable.DISABLE)).a());
                    } catch (JSONException e13) {
                        BdLog.e(e13);
                    }
                } else if (TOAST_POPUPVIEW.equals(str2)) {
                    try {
                        JSONObject jSONObject6 = new JSONObject(str3);
                        jsPromptResult.confirm(showLowerHairHint(jSONObject6.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject6.optInt("ahead_type"), jSONObject6.optString("message"), jSONObject6.optString("btn_text"), jSONObject6.optInt("toast_duration"), jSONObject6.optString("schema"), jSONObject6.optString("token"), jSONObject6.optDouble(NativeConstants.OPACITY), jSONObject6.optString(BigdayActivityConfig.IMG_URL), jSONObject6.optString("url"), jSONObject6.optInt("mission_id"), jSONObject6.optString("btn_color"), jSONObject6.optString("message_color"), jSONObject6.optString("btn_text_color"), jSONObject6.optInt("status"), jSONObject6.optInt(FINISH_THIS_PAGE)).a());
                    } catch (JSONException e14) {
                        BdLog.e(e14);
                    }
                } else if (GAME_PUSH.equals(str2)) {
                    try {
                        jSONObject = new JSONObject(str3);
                    } catch (JSONException e15) {
                        e = e15;
                    }
                    try {
                        jsPromptResult.confirm(gamePush(jSONObject.optString("gameId"), jSONObject.optString("gameName"), jSONObject.optString("gameTime"), jSONObject.optString("gameType")).a());
                    } catch (JSONException e16) {
                        e = e16;
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
                    } catch (JSONException e17) {
                        BdLog.e(e17);
                    }
                    return true;
                } else if (GO_TO_MY_LIVE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleGoToMyLive(new JSONObject(str3).optString("uid")).a());
                    } catch (JSONException e18) {
                        BdLog.e(e18);
                    }
                    return true;
                } else if (SAVE_IMAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleSaveImage(new JSONObject(str3).optString("imgUrl")).a());
                    } catch (JSONException e19) {
                        BdLog.e(e19);
                    }
                    return true;
                } else if (GET_PHOTO_ALBUM.equals(str2)) {
                    jsPromptResult.confirm(handleGetPhotoAlbum().a());
                    return true;
                } else if ("getSupplementInfo".equals(str2)) {
                    jsPromptResult.confirm(getSupplementInfo().a());
                    return true;
                } else if (GET_DEVICE_INFO.equals(str2)) {
                    jsPromptResult.confirm(getDeviceInfo().a());
                    return true;
                } else if (GENERAL_PREFERENCES.equals(str2)) {
                    jsPromptResult.confirm(generalSharePreferences());
                } else if (COMPLETE_TASK.equals(str2)) {
                    try {
                        JSONObject jSONObject7 = new JSONObject(str3);
                        jsPromptResult.confirm(sendCompleteTaskReqMsg(jSONObject7.optString("activityId"), jSONObject7.optString("missionId")).a());
                    } catch (JSONException e20) {
                        BdLog.e(e20);
                    }
                } else if (GET_MODAL_DATA.equals(str2)) {
                    try {
                        jsPromptResult.confirm(getGetModalData(new JSONObject(str3).optString("url")).a());
                    } catch (JSONException e21) {
                        BdLog.e(e21);
                    }
                } else if (SHOW_TIP_TOAST.equals(str2)) {
                    try {
                        JSONObject jSONObject8 = new JSONObject(str3);
                        jsPromptResult.confirm(showTipToast(jSONObject8.optString("content"), jSONObject8.optString(GameAssistConstKt.KEY_LINKURL), jSONObject8.optString("key"), jSONObject8.optInt("maxTimes"), jSONObject8.optInt(FINISH_THIS_PAGE)).a());
                    } catch (JSONException e22) {
                        BdLog.e(e22);
                    }
                } else if (JUMP_TO_HTML_PAGE.equals(str2)) {
                    try {
                        JSONObject jSONObject9 = new JSONObject(str3);
                        jsPromptResult.confirm(jumpToHtmlPage(jSONObject9.optString("url"), jSONObject9.optInt("finish_this_page", 1)).toString());
                    } catch (JSONException e23) {
                        BdLog.e(e23);
                    }
                } else if (CLOSE_NATIVE_MASK.equals(str2)) {
                    try {
                        z = false;
                        try {
                            jsPromptResult.confirm(closeNativeMask(new JSONObject(str3).optInt("result", 0)).a());
                            return false;
                        } catch (JSONException e24) {
                            e = e24;
                            e.printStackTrace();
                            return z;
                        }
                    } catch (JSONException e25) {
                        e = e25;
                        z = false;
                    }
                } else if (GO_TO_HOT_TREND.equals(str2)) {
                    jumpToHotTrendPage();
                    jsPromptResult.confirm();
                    return false;
                } else if (GO_TO_PB.equals(str2)) {
                    try {
                        JSONObject jSONObject10 = new JSONObject(str3);
                        String optString = jSONObject10.optString("tid");
                        String optString2 = jSONObject10.optString("fr");
                        if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                            jumpToPbPage(optString, optString2);
                        }
                        jsPromptResult.confirm();
                        return true;
                    } catch (JSONException e26) {
                        e26.printStackTrace();
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
                    } catch (JSONException e27) {
                        e27.printStackTrace();
                    }
                    return true;
                } else if (GET_APP_STORAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(getAppStorage(new JSONObject(str3).optString("key")).a());
                    } catch (JSONException e28) {
                        BdLog.e(e28);
                    }
                    return true;
                } else if (PUT_APP_STORAGE.equals(str2)) {
                    try {
                        JSONObject jSONObject11 = new JSONObject(str3);
                        jsPromptResult.confirm(putAppStorage(jSONObject11.optString("key"), jSONObject11.optString("data")).a());
                    } catch (JSONException e29) {
                        BdLog.e(e29);
                    }
                    return true;
                } else if (!GET_HISTORY_FORUM_DATA.equals(str2)) {
                    return false;
                } else {
                    jsPromptResult.confirm(getHistoryForumData().a());
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public void dealSpringFestivalTimer(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, jSONObject) == null) {
            callJsMethod(str, jSONObject);
        }
    }

    public bz9 deviceGyroscopeParams(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            return this.deviceJsBridgePlugin.d(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 finishPage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            return this.routerJsBridgePlugin.c(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    @NonNull
    public bz9 getViewPosition(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, str, str2)) == null) {
            return this.subscriptionJsBridgePlugin.d(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 handleGoToBarDetail(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048624, this, str, i)) == null) {
            return this.routerJsBridgePlugin.h(this.mWebView, str, i);
        }
        return (bz9) invokeLI.objValue;
    }

    public bz9 jumpForumRulesEditPage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, str, str2)) == null) {
            return this.routerJsBridgePlugin.j(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 jumpLoginActivity(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048632, this, i, str)) == null) {
            return this.accountJsBridgePlugin.g(this.mWebView, i, str);
        }
        return (bz9) invokeIL.objValue;
    }

    public bz9 jumpToHtmlPage(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048634, this, str, i)) == null) {
            return this.routerJsBridgePlugin.k(this.mWebView, str, i);
        }
        return (bz9) invokeLI.objValue;
    }

    public bz9 openThirdPartApp(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048646, this, i, str)) == null) {
            return this.routerJsBridgePlugin.n(this.mWebView, i, str);
        }
        return (bz9) invokeIL.objValue;
    }

    public bz9 operateNotifyDataChanged(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, str, str2)) == null) {
            return this.subscriptionJsBridgePlugin.f(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 orderGameApk(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048649, this, str, str2)) == null) {
            return this.systemJsBridgePlugin.C(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 putAppStorage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048656, this, str, str2)) == null) {
            return this.systemJsBridgePlugin.G(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 reportUserTheme(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048664, this, str, arrayList)) == null) {
            return this.routerJsBridgePlugin.t(this.mWebView, str, arrayList);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 selectPhotoAlbum(int i, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048666, this, i, arrayList)) == null) {
            return this.systemJsBridgePlugin.I(this.mWebView, i, arrayList);
        }
        return (bz9) invokeIL.objValue;
    }

    public bz9 selectPrivateMsg(String str, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048667, this, str, arrayList)) == null) {
            return this.routerJsBridgePlugin.u(this.mWebView, str, arrayList);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 sendCompleteTaskReqMsg(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048668, this, str, str2)) == null) {
            return this.activityJsBridgePlugin.f(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 startApp(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048683, this, str, str2)) == null) {
            return this.systemJsBridgePlugin.K(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 updateTailStyle(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048695, this, i, str)) == null) {
            return this.activityJsBridgePlugin.i(this.mWebView, i, str);
        }
        return (bz9) invokeIL.objValue;
    }

    public bz9 worldCupRaiseSuccess(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048697, this, str, str2)) == null) {
            return this.activityJsBridgePlugin.j(this.mWebView, str, str2);
        }
        return (bz9) invokeLL.objValue;
    }

    public bz9 fileDownloadDelete(String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4})) == null) {
            return this.systemJsBridgePlugin.j(this.mWebView, str, str2, str3, i, str4);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 fileDownloadPause(String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4})) == null) {
            return this.systemJsBridgePlugin.k(this.mWebView, str, str2, str3, i, str4);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 launchApk(String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{str, str2, str3, Integer.valueOf(i), str4})) == null) {
            return this.systemJsBridgePlugin.z(this.mWebView, str, str2, str3, i, str4);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 showTipToast(String str, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048680, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return this.toastJsBridgePlugin.g(this.mWebView, str, str2, str3, i, i2);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 gamePush(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, str, str2, str3, str4)) == null) {
            return this.subscriptionJsBridgePlugin.c(this.mWebView, str, str2, str3, str4);
        }
        return (bz9) invokeLLLL.objValue;
    }

    public bz9 nativeNetworkProxy(String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048637, this, str, str2, str3, jSONObject)) == null) {
            return this.hybridJsBridgePlugin.j(this.mWebView, str, str2, str3, jSONObject);
        }
        return (bz9) invokeLLLL.objValue;
    }

    public bz9 goToEditPost(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            return this.routerJsBridgePlugin.f(this.mWebView, str, str2, str3, str4, str5, str6, str7);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 goToVideoImmersivePage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17})) == null) {
            return this.routerJsBridgePlugin.g(this.mWebView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 installGameApk(String str, String str2, String str3, String str4, int i, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i), str5})) == null) {
            return this.systemJsBridgePlugin.w(this.mWebView, str, str2, str3, str4, i, str5);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 notifyAliAuthResult(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, hashMap)) == null) {
            bz9 bz9Var = new bz9();
            int i2 = -1;
            try {
                i2 = Integer.parseInt(hashMap.get("status"));
                bz9Var.y(i2);
                bz9Var.u(hashMap.get("message"));
                if (i2 == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("avatar", hashMap.get("avatar"));
                    jSONObject.put("nick_name", hashMap.get("nick_name"));
                    jSONObject.put("alipay_user_id", hashMap.get("alipay_user_id"));
                    bz9Var.o(jSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GET_ALI_PAY_USER_INFO);
            if (i2 == 0) {
                i = 0;
            } else {
                i = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_param1", i));
            return bz9Var;
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 realNameAuth(String str, boolean z, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)})) == null) {
            return this.accountJsBridgePlugin.m(this.mWebView, str, z, str2, i);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 startAllLoginModule(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048682, this, str, str2, str3, str4)) == null) {
            bz9 bz9Var = new bz9();
            if (TbadkCoreApplication.isLogin()) {
                ml6.a().d(new Runnable() { // from class: com.baidu.tieba.lx4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            CommonTbJsBridge.this.a();
                        }
                    }
                }, 100L);
                return bz9Var;
            }
            return this.accountJsBridgePlugin.o(this.mWebView, str, str2, str3, str4);
        }
        return (bz9) invokeLLLL.objValue;
    }

    public bz9 setShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048674, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9})) == null) {
            return this.shareJsBridgePlugin.d(this.mWebView, str, str2, str3, str4, str5, str6, str7, str8, i, str9);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 share(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, int i4, String str10, String str11, long j, int i5, int i6, long j2, String str12, String str13, String str14, String str15, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Integer.valueOf(i4), str10, str11, Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2), str12, str13, str14, str15, jSONObject})) == null) {
            return this.shareJsBridgePlugin.f(this.mWebView, i, i2, str, str2, str3, str4, str5, str6, str7, str8, i3, str9, i4, str10, str11, j, i5, i6, j2, str12, str13, str14, str15, jSONObject);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 showLowerHairHint(int i, int i2, String str, String str2, int i3, String str3, String str4, double d, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048678, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, str4, Double.valueOf(d), str5, str6, Integer.valueOf(i4), str7, str8, str9, Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            return this.toastJsBridgePlugin.f(this.mWebView, i, i2, str, str2, i3, str3, str4, d, str5, str6, i4, str7, str8, str9, i5, i6);
        }
        return (bz9) invokeCommon.objValue;
    }

    public bz9 startDownloadGameApk(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, int i2, String str12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048686, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), str11, Integer.valueOf(i2), str12})) == null) {
            return this.systemJsBridgePlugin.L(this.mWebView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i, str11, i2, str12);
        }
        return (bz9) invokeCommon.objValue;
    }
}
