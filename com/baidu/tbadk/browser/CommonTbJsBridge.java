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
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.tencent.connect.common.Constants;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.h0.a.w;
import d.b.h0.f0.h;
import d.b.h0.r.o.a;
import d.b.h0.r.s.i;
import d.b.h0.s.d.f;
import d.b.h0.t.l;
import d.b.h0.z0.q;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@d.b.e.a.a
/* loaded from: classes3.dex */
public class CommonTbJsBridge implements d.b.i0.d3.l0.b {
    public static final String CHANGE_SKIN_TYPE = "changeSkinType";
    public static final String CHECK_APP_INSTALL = "checkAppInstall";
    public static final String CLICK_GO_BACK_TO_H5 = "clickGoBackToH5";
    public static final String CLOSE_NATIVE_MASK = "closeNativeMask";
    public static final String COMPLETE_TASK = "completeTask";
    public static final String DELETE_OFFLINE_BUNDLE = "deleteOfflineBundle";
    public static final String DisableSlideBack = "disableSlideBack";
    public static final String FETCH_OFFLINE_USER_INFO = "getOfflineUserInfo";
    public static final String FINISH_THIS_PAGE = "finishThisPage";
    public static final String GAME_PUSH = "gamePush";
    public static final String GAME_PUSH_STATUS = "gamePushStatus";
    public static final String GAME_SHARE = "gameShare";
    public static final String GENERAL_PREFERENCES = "generalPreferences";
    public static final String GET_APIS = "getAPIs";
    public static final String GET_CLIPPER_INFORMATION = "getClipperInformation";
    public static final String GET_DEVICE_INFO = "getDeviceInfo";
    public static final String GET_MODAL_DATA = "getModalData";
    public static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    public static final String GET_ZID = "getZid";
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
    public static final String JUMP_TO_HTML_PAGE = "jumpToHTMLPage";
    public static final String LOAD_THIRD_PARTY_LOGIN = "loadThirdPartyLogin";
    public static final String LOGIN_RESULT_TO_H5 = "loginResultToH5";
    public static final String ORIGINAL_THREAD = "1";
    public static final String PERSON_PAGE_REFRESH = "personPageRefresh";
    public static final String PERSON_PAGE_SHARE = "registerShareData";
    public static final String PLAY_SOUND = "playSound";
    public static final String PLAY_VIBRATE = "playVibrate";
    public static final String RESULT_THIRD_PARTY_LOGIN = "thirdPartyLoginResultToH5";
    public static final String RE_SHOW = "reshow";
    public static final String SAVE_IMAGE = "saveImage";
    public static final String SET_CLIPPER_INFORMATION = "setClipperInformation";
    public static final String SET_SHARE_INFO = "registerShareDataNew";
    public static final String SHARE = "share";
    public static final String SHARE_SUCCCESS_NOTIFICATION = "ShareSuccessNotification";
    public static final String SHOW_ALERTVIEW = "showAlertView";
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
    public static String tempUrl = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
    public final String SHOW_MORE_FORUM_ICON;
    public d.b.i0.d3.l0.a jsPromptBridge;
    public final Context mContext;
    public long mLastLoadUrlTime;
    public PermissionJudgePolicy mPermissionJudgement;
    public JsPromptResult mResult;
    public w mShakeController;
    public WebView mWebView;
    public String shakeCallbackjsMethod;
    public ShareItem shareItem;

    /* loaded from: classes3.dex */
    public class a implements w.b {
        public a() {
        }

        @Override // d.b.h0.a.w.b
        public void a() {
            if (TextUtils.isEmpty(CommonTbJsBridge.this.shakeCallbackjsMethod)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                CommonTbJsBridge.this.callJsMethod(CommonTbJsBridge.this.shakeCallbackjsMethod, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends q.a {
        public b() {
        }

        @Override // d.b.h0.z0.q.a
        public void onError(int i, String str) {
            if (CommonTbJsBridge.this.jsPromptBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", -1);
                CommonTbJsBridge.this.jsPromptBridge.h(CommonTbJsBridge.this.mWebView, "saveImageSuccess", linkedHashMap);
            }
        }

        @Override // d.b.h0.z0.q.a
        public void onSuccess(String str) {
            if (CommonTbJsBridge.this.jsPromptBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", 0);
                CommonTbJsBridge.this.jsPromptBridge.h(CommonTbJsBridge.this.mWebView, "saveImageSuccess", linkedHashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends q.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f12757a;

        public c(int i) {
            this.f12757a = i;
        }

        @Override // d.b.h0.z0.q.a
        public void onError(int i, String str) {
        }

        @Override // d.b.h0.z0.q.a
        public void onSuccess(String str) {
            if (new File(str).exists()) {
                if (CommonTbJsBridge.this.shareItem != null) {
                    CommonTbJsBridge.this.shareItem.V = 1;
                    CommonTbJsBridge.this.shareItem.x = str;
                }
                if (this.f12757a != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(CommonTbJsBridge.this.mContext, this.f12757a, CommonTbJsBridge.this.shareItem, true));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.c {
        public d() {
        }

        @Override // d.b.h0.r.o.a.c
        public void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
                if (CommonTbJsBridge.this.mResult != null) {
                    CommonTbJsBridge.this.mResult.confirm(jSONObject.toString());
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }

        @Override // d.b.h0.r.o.a.c
        public void onCancel() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                if (CommonTbJsBridge.this.mResult != null) {
                    CommonTbJsBridge.this.mResult.confirm(jSONObject.toString());
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
    }

    public CommonTbJsBridge(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsMethod(String str, JSONObject jSONObject) {
        WebView webView = this.mWebView;
        if (webView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')");
    }

    private String closeNativeMask(String str) {
        int i = 1;
        try {
            if (!StringUtils.isNull(str)) {
                try {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(new JSONObject(str).optInt("result", 0) == 1)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            return jSONObject2.toString();
        } catch (JSONException e3) {
            BdLog.e(e3);
            return null;
        }
        i = 0;
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (k.isEmpty(str) || (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(currentActivityPageContext, new String[]{str});
    }

    private String generalSharePreferences() {
        d.b.h0.r.d0.b.j().v("key_bawu_task_toast", -1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            return jSONObject.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    private String getAPIs() {
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

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    private String getGetModalData() {
        JSONObject jSONObject;
        String f2;
        int i = 0;
        try {
            f2 = f.c().f();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        try {
            if (!TextUtils.isEmpty(f2)) {
                jSONObject = new JSONObject(f2);
                i = 1;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
                jSONObject2.put("user_info", jSONObject);
                return jSONObject2.toString();
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            jSONObject22.put("user_info", jSONObject);
            return jSONObject22.toString();
        } catch (JSONException e3) {
            BdLog.e(e3);
            return null;
        }
        jSONObject = null;
    }

    private w getShakeController() {
        if (this.mShakeController == null) {
            this.mShakeController = new w(this.mContext, new a());
        }
        return this.mShakeController;
    }

    private ShareItem getShareItem() {
        return this.shareItem;
    }

    private void goToGameShare(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            BdLog.e(e2);
            jSONObject = null;
        }
        if (jSONObject != null) {
            GameShareData gameShareData = new GameShareData();
            gameShareData.a(jSONObject);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameShareActivityConfig(this.mContext, gameShareData)));
        }
    }

    private String handleGamePush(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, str));
        return "1";
    }

    private String handleGamePushStatus() {
        String p = d.b.h0.r.d0.b.j().p("key_match_id_list_football", "");
        String p2 = d.b.h0.r.d0.b.j().p("key_match_id_list_basketball", "");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("football", "[" + p + "]");
            jSONObject.put("basketball", "[" + p2 + "]");
            return jSONObject.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    private void hideWebviewLoading(String str) {
    }

    private boolean isLegalSchema(List<String> list, String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(list)) {
            for (String str2 : list) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String jumpToPbPage(String str, String str2) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str, null, str2);
        createNormalCfg.setStartFrom(5);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        return null;
    }

    private String loadThirdPartyLogin(String str) {
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

    private String parseSpringFestivalTimer(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("open");
            String optString = jSONObject.optString("method_name");
            l lVar = new l();
            lVar.g(optBoolean);
            lVar.f(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, lVar));
            i = 1;
        } catch (JSONException e2) {
            e2.printStackTrace();
            i = 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            return jSONObject2.toString();
        } catch (JSONException e3) {
            BdLog.e(e3);
            return null;
        }
    }

    private String refreshPage() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
        return "";
    }

    private void setShareItem(ShareItem shareItem) {
        this.shareItem = shareItem;
    }

    private void shareLoacalImage(String str, int i) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(currentActivity)) {
            return;
        }
        q qVar = new q(currentActivity, str, new c(i));
        qVar.p(1);
        qVar.execute(new String[0]);
    }

    private void showRightShare(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
    }

    private String startAcceleromter(String str) {
        int i;
        try {
            this.shakeCallbackjsMethod = new JSONObject(str).optString("method_name");
            if (!getShakeController().d()) {
                getShakeController().f();
            }
            i = 1;
        } catch (JSONException e2) {
            e2.printStackTrace();
            i = 0;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            return jSONObject.toString();
        } catch (JSONException e3) {
            BdLog.e(e3);
            return null;
        }
    }

    public d.b.i0.d3.l0.d.c changeSkinTypeInH5(HashMap hashMap) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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
        cVar.l(jSONObject.toString());
        return cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public d.b.i0.d3.l0.d.c checkAppInstall(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        int isInstalledPackage = !StringUtils.isNull(str) ? UtilHelper.isInstalledPackage(this.mContext, str) : 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, isInstalledPackage);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c dealClickGoBackToH5(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callJsMethod(CLICK_GO_BACK_TO_H5, jSONObject);
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        cVar.l(jSONObject.toString());
        return cVar;
    }

    @Override // d.b.i0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        boolean z;
        boolean z2;
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
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(setShareInfo(jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("img"), jSONObject.optString("url"), jSONObject.optString("topic"), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optString("isShowMoreForum"), jSONObject.optInt("shareimg"), jSONObject.optString("extdata")).a());
                    return true;
                } catch (JSONException e8) {
                    BdLog.e(e8);
                    return true;
                }
            } else if ("share".equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    z = true;
                    try {
                        jsPromptResult.confirm(share(jSONObject2.optInt("channel"), jSONObject2.optInt("shareimg"), jSONObject2.optString("img"), jSONObject2.optString("isShowMoreForum"), jSONObject2.optString("url"), jSONObject2.optString("title"), jSONObject2.optString("desc"), jSONObject2.optString("topic"), jSONObject2.optString("wbtitle"), jSONObject2.optString("wbcontent"), jSONObject2.optInt("weixin_disable"), jSONObject2.optString("extdata")).a());
                    } catch (JSONException e9) {
                        e = e9;
                        BdLog.e(e);
                        return z;
                    }
                } catch (JSONException e10) {
                    e = e10;
                    z = true;
                }
                return z;
            } else if (GET_CLIPPER_INFORMATION.equals(str2)) {
                jsPromptResult.confirm(getClipperInformation().a());
                return true;
            } else if (SET_CLIPPER_INFORMATION.equals(str2)) {
                try {
                    z2 = true;
                    try {
                        jsPromptResult.confirm(setClipperInformation(new JSONObject(str3).optString(DocumentOpenUtil.TXT)).a());
                    } catch (JSONException e11) {
                        e = e11;
                        BdLog.e(e);
                        return z2;
                    }
                } catch (JSONException e12) {
                    e = e12;
                    z2 = true;
                }
                return z2;
            } else {
                commonTbJsBridge = this;
                if (CHECK_APP_INSTALL.equals(str2)) {
                    try {
                        jsPromptResult.confirm(commonTbJsBridge.checkAppInstall(new JSONObject(str3).optString(PushClientConstants.TAG_PKG_NAME)).a());
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
                        jsPromptResult.confirm(commonTbJsBridge.startDownloadCss(new JSONObject(str3).optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL)).a());
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
                } else if (SHOW_ALERTVIEW.equals(str2)) {
                    try {
                        commonTbJsBridge.mResult = jsPromptResult;
                        JSONObject jSONObject3 = new JSONObject(str3);
                        showAlertView(jSONObject3.optString("title"), jSONObject3.optString("sub_title"), jSONObject3.optInt("btn_corner"), jSONObject3.optInt("btn_borderWidth"), jSONObject3.optString("cancel_btn_text"), jSONObject3.optString("cancel_btn_color"), jSONObject3.optString("cancel_btn_borderColor"), jSONObject3.optString("confirm_btn_text"), jSONObject3.optString("confirm_btn_color"), jSONObject3.optString("confirm_btn_borderColor"), jSONObject3.optString("confirm_btn_url"));
                    } catch (JSONException e16) {
                        BdLog.e(e16);
                    }
                } else if (START_ACCELEROMETER.equals(str2)) {
                    jsPromptResult.confirm(commonTbJsBridge.startAcceleromter(str3));
                } else if (DisableSlideBack.equals(str2)) {
                    try {
                        jsPromptResult.confirm(commonTbJsBridge.disableBack(new JSONObject(str3).optInt(PackageTable.DISABLE)).a());
                    } catch (JSONException e17) {
                        BdLog.e(e17);
                    }
                } else if (TOAST_POPUPVIEW.equals(str2)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(str3);
                        jsPromptResult.confirm(showLowerHairHint(jSONObject4.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject4.optInt("ahead_type"), jSONObject4.optString("message"), jSONObject4.optString("btn_text"), jSONObject4.optInt("toast_duration"), jSONObject4.optString("schema"), jSONObject4.optString("token"), jSONObject4.optDouble("opacity"), jSONObject4.optString(BigdayActivityConfig.IMG_URL), jSONObject4.optString("url"), jSONObject4.optInt("mission_id"), jSONObject4.optString("btn_color"), jSONObject4.optString("message_color"), jSONObject4.optString("btn_text_color"), jSONObject4.optInt("status"), jSONObject4.optInt(FINISH_THIS_PAGE)).a());
                    } catch (JSONException e18) {
                        BdLog.e(e18);
                    }
                    return false;
                } else if (GAME_PUSH.equals(str2)) {
                    jsPromptResult.confirm(handleGamePush(str3));
                    return true;
                } else if (GAME_PUSH_STATUS.equals(str2)) {
                    jsPromptResult.confirm(handleGamePushStatus());
                    return true;
                } else if (GO_TO_MY_POST.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleGoToMyPost(new JSONObject(str3).optString("uid")).a());
                    } catch (JSONException e19) {
                        BdLog.e(e19);
                    }
                    return true;
                } else if (GO_TO_MY_LIVE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleGoToMyLive(new JSONObject(str3).optString("uid")).a());
                    } catch (JSONException e20) {
                        BdLog.e(e20);
                    }
                    return true;
                } else if (SAVE_IMAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleSaveImage(new JSONObject(str3).optString("imgUrl")).a());
                    } catch (JSONException e21) {
                        BdLog.e(e21);
                    }
                    return true;
                } else if ("getSupplementInfo".equals(str2)) {
                    jsPromptResult.confirm(getSupplementInfo().a());
                    return true;
                } else if ("getDeviceInfo".equals(str2)) {
                    jsPromptResult.confirm(getDeviceInfo().a());
                    return true;
                } else if (GENERAL_PREFERENCES.equals(str2)) {
                    jsPromptResult.confirm(generalSharePreferences());
                    return false;
                } else if (COMPLETE_TASK.equals(str2)) {
                    try {
                        JSONObject jSONObject5 = new JSONObject(str3);
                        jsPromptResult.confirm(sendCompleteTaskReqMsg(jSONObject5.optString("activityId"), jSONObject5.optString("missionId")).a());
                        return false;
                    } catch (JSONException e22) {
                        BdLog.e(e22);
                        return false;
                    }
                } else if (GET_MODAL_DATA.equals(str2)) {
                    jsPromptResult.confirm(getGetModalData());
                    return false;
                } else if (SHOW_TIP_TOAST.equals(str2)) {
                    try {
                        JSONObject jSONObject6 = new JSONObject(str3);
                        jsPromptResult.confirm(showTipToast(jSONObject6.optString("content"), jSONObject6.optString("linkUrl"), jSONObject6.optString("key"), jSONObject6.optInt("maxTimes"), jSONObject6.optInt(FINISH_THIS_PAGE)).a());
                        return false;
                    } catch (JSONException e23) {
                        BdLog.e(e23);
                        return false;
                    }
                } else if (JUMP_TO_HTML_PAGE.equals(str2)) {
                    try {
                        JSONObject jSONObject7 = new JSONObject(str3);
                        jsPromptResult.confirm(jumpToHtmlPage(jSONObject7.optString("url"), jSONObject7.optInt("finish_this_page", 1)).toString());
                        return false;
                    } catch (JSONException e24) {
                        BdLog.e(e24);
                        return false;
                    }
                } else if (CLOSE_NATIVE_MASK.equals(str2)) {
                    jsPromptResult.confirm(closeNativeMask(str3));
                    return false;
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
                    } catch (JSONException e25) {
                        e25.printStackTrace();
                        return false;
                    }
                } else if (GET_APIS.equals(str2)) {
                    jsPromptResult.confirm(getAPIs());
                    return true;
                } else if (START_LOAD_TIME_INTERVAL.equals(str2)) {
                    jsPromptResult.confirm(getStartLoadTimeInterval().a());
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void dealSpringFestivalTimer(String str, JSONObject jSONObject) {
        callJsMethod(str, jSONObject);
    }

    public d.b.i0.d3.l0.d.c disableBack(int i) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        Context context = this.mContext;
        if (context instanceof TbWebViewActivity) {
            if (i == 0) {
                ((TbWebViewActivity) context).setSwipeBackEnabled(true);
            } else {
                ((TbWebViewActivity) context).setSwipeBackEnabled(false);
            }
        }
        return cVar;
    }

    public d.b.i0.d3.l0.d.c finishPage() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
        return cVar;
    }

    public d.b.i0.d3.l0.d.c getClipperInformation() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        String clipBoardContent = UtilHelper.getClipBoardContent();
        int i = !k.isEmpty(clipBoardContent) ? 1 : 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            jSONObject.put("data", clipBoardContent);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c getDeviceInfo() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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
        stringBuffer.append(NetWork.SIGN_SUFFIX);
        String c2 = d.b.c.e.p.q.c(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", imei);
                jSONObject.put("androidId", androidId);
                jSONObject.put("imsi", iMsi);
                jSONObject.put("model", str);
                jSONObject.put("brand", str2);
                jSONObject.put(Constants.PARAM_PLATFORM, "Android");
                jSONObject.put(PushClientConstants.TAG_PKG_NAME, packageName);
                jSONObject.put("network", str3);
                jSONObject.put("carrier", str4);
                jSONObject.put("manufacturer", devicesManufacturer);
                jSONObject.put("hardware", str5);
                jSONObject.put("board", str6);
                jSONObject.put("imu", str7);
                jSONObject.put("sign", c2);
                cVar = cVar;
                cVar.l(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                e = e2;
                cVar = cVar;
                BdLog.e(e);
                cVar.l("");
                return cVar;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public d.b.i0.d3.l0.d.c getStartLoadTimeInterval() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("loadUrlTime", this.mLastLoadUrlTime);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c getSupplementInfo() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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
        stringBuffer.append(NetWork.SIGN_SUFFIX);
        String c2 = d.b.c.e.p.q.c(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("cuid", cuid);
            jSONObject.put(AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            jSONObject.put("brand", str);
            jSONObject.put("client_type", "Android");
            jSONObject.put("client_version", version);
            jSONObject.put("zid", zid);
            jSONObject.put("sign", c2);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            cVar.l("");
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c getZid() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        String zid = TbadkCoreApplication.getInst().getZid();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            jSONObject.put("zid", zid);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c goToEditPost(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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

    public d.b.i0.d3.l0.d.c goToNotificationSetting() {
        Activity currentActivity;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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

    public d.b.i0.d3.l0.d.c handleGoToBarDetail(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.mContext, str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE)));
        }
        return cVar;
    }

    public d.b.i0.d3.l0.d.c handleGoToMyLive(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mContext, str, "", "", 0, true)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c handleGoToMyPost(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mContext, str, 0, null)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c handleSaveImage(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            cVar.m();
            return cVar;
        }
        this.mPermissionJudgement.appendRequestPermission((Activity) context, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
            cVar.n("权限申请");
            return cVar;
        }
        new q((Activity) this.mContext, str, new b()).execute(new String[0]);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c hasNotificationPermission() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        int areNotificationsEnabled = Build.VERSION.SDK_INT >= 19 ? NotificationManagerCompat.from(this.mContext).areNotificationsEnabled() : 1;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, areNotificationsEnabled);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c jumpLoginActivity(int i, String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        JSONObject jSONObject = new JSONObject();
        if (this.mContext == null) {
            try {
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            cVar.l(jSONObject.toString());
            return cVar;
        }
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
        loginActivityConfig.setThirdPartyLoginForResult(i, str);
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
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public d.b.i0.d3.l0.d.c jumpToHotTrendPage() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        d.b.h0.r.a0.b.g(this.mContext, 16, false);
        return cVar;
    }

    public d.b.i0.d3.l0.d.c jumpToHtmlPage(String str, int i) {
        Context context;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        if (!TextUtils.isEmpty(str) && (context = this.mContext) != null) {
            d.b.h0.l.a.l(context, str);
            if (i == 1) {
                Context context2 = this.mContext;
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
            }
        }
        return cVar;
    }

    public void onDestroy() {
        w wVar = this.mShakeController;
        if (wVar == null || !wVar.d()) {
            return;
        }
        this.mShakeController.c();
    }

    public d.b.i0.d3.l0.d.c onUserLoginChanged(HashMap hashMap) {
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
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public d.b.i0.d3.l0.d.c playSound(String str) {
        int i;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        if (j.z()) {
            getShakeController().i(str);
            i = 1;
        } else {
            Context context = this.mContext;
            if (context != null) {
                d.b.c.e.p.l.K(context, R.string.neterror);
            }
            i = 0;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c playVibrate() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        boolean g2 = getShakeController().g();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, g2 ? 1 : 0);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c reShow(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callJsMethod(RE_SHOW, jSONObject);
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public d.b.i0.d3.l0.d.c saveImageSuccess(HashMap<String, Integer> hashMap) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        if (hashMap != null && hashMap.get("result").intValue() == -1) {
            cVar.n("图片保存错误");
        }
        return cVar;
    }

    public d.b.i0.d3.l0.d.c sendCompleteTaskReqMsg(String str, String str2) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        int i = 0;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, str2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            cVar.l(jSONObject2.toString());
            return cVar;
        } catch (JSONException e3) {
            BdLog.e(e3);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c setClipperInformation(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        d.b.c.e.p.a.a(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c setDisableGoBack() {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        Context context = this.mContext;
        int i = 1;
        if (context instanceof TbWebViewActivity) {
            ((TbWebViewActivity) context).isDisableGoBack = true;
        } else {
            i = 0;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public void setJsPromptBridge(d.b.i0.d3.l0.a aVar) {
        this.jsPromptBridge = aVar;
    }

    public void setLastLoadUrlTime(long j) {
        this.mLastLoadUrlTime = j;
    }

    public d.b.i0.d3.l0.d.c setShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        int i2;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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
            jSONObject.put("shareimg", i);
            jSONObject.put("extdata", str9);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        String jSONObject2 = jSONObject.toString();
        if (k.isEmpty(jSONObject2)) {
            i2 = 0;
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
            i2 = 1;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MiPushCommandMessage.KEY_RESULT_CODE, i2);
            cVar.l(jSONObject3.toString());
            return cVar;
        } catch (JSONException e3) {
            BdLog.e(e3);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c share(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9) {
        CustomResponsedMessage runTask;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", i);
            jSONObject.put("shareimg", i2);
            jSONObject.put("img", str);
            jSONObject.put("isShowMoreForum", str2);
            jSONObject.put("url", str3);
            jSONObject.put("title", str4);
            jSONObject.put("desc", str5);
            jSONObject.put("topic", str6);
            jSONObject.put("wbtitle", str7);
            jSONObject.put("wbcontent", str8);
            jSONObject.put("weixin_disable", i3);
            jSONObject.put("extdata", str9);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        String jSONObject2 = jSONObject.toString();
        int i4 = 1;
        if (k.isEmpty(jSONObject2) || (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject2)) == null) {
            i4 = 0;
        } else {
            ShareItem shareItem = (ShareItem) runTask.getData();
            if (shareItem != null) {
                shareItem.D = 17;
            }
            if ("1".equals(str2) && shareItem != null) {
                shareItem.w = str;
                shareItem.t = str3;
                shareItem.r = str4 + " " + str5;
                shareItem.m = true;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                d.b.i0.b0.f.b().k(shareDialogConfig);
                cVar.l("");
                return cVar;
            } else if (i == 0) {
                if (shareItem != null && !k.isEmpty(str) && i2 == 1) {
                    setShareItem(shareItem);
                    shareLoacalImage(str, i);
                }
                showShareDialog(shareItem);
            } else if (shareItem != null && !k.isEmpty(str) && i2 == 1) {
                setShareItem(shareItem);
                shareLoacalImage(str, i);
            } else {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, i, shareItem, true));
            }
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MiPushCommandMessage.KEY_RESULT_CODE, i4);
            cVar.l(jSONObject3.toString());
            return cVar;
        } catch (JSONException e3) {
            BdLog.e(e3);
            return cVar;
        }
    }

    public d.b.i0.d3.l0.d.c shareSuccessNotification(HashMap hashMap) {
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
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public d.b.i0.d3.l0.d.c showAlertView(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        d.b.h0.a.b0.a aVar = new d.b.h0.a.b0.a();
        aVar.y = str;
        aVar.z = str2;
        aVar.A = str3;
        aVar.B = str6;
        d.b.h0.r.o.a aVar2 = new d.b.h0.r.o.a(TbadkCoreApplication.getInst().getCurrentActivity());
        aVar2.g(new d());
        aVar2.f(aVar);
        aVar2.d();
        aVar2.h();
        return cVar;
    }

    public d.b.i0.d3.l0.d.c showLowerHairHint(int i, int i2, String str, String str2, int i3, String str3, String str4, double d2, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        d.b.h0.a.b0.a aVar = new d.b.h0.a.b0.a();
        aVar.f49905c = i;
        aVar.f49906d = i2;
        aVar.f49907e = str;
        aVar.f49908f = str2;
        aVar.i = i3;
        aVar.l = str3;
        aVar.n = d2;
        aVar.j = str5;
        aVar.k = str6;
        aVar.f49904b = i4;
        aVar.o = str7;
        aVar.p = str8;
        aVar.q = str9;
        if (i == d.b.h0.a.b0.a.C) {
            i.i(TbadkCoreApplication.getInst().getCurrentActivity(), aVar).k();
        } else if (i == d.b.h0.a.b0.a.D) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            d.b.h0.r.o.c cVar2 = new d.b.h0.r.o.c(currentActivity);
            if (currentActivity != null) {
                cVar2.d(currentActivity, aVar);
                cVar2.i();
            }
        } else if (i == d.b.h0.a.b0.a.E) {
            if (i2 == d.b.h0.a.b0.a.H) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), aVar.l) && !k.isEmpty(aVar.k)) {
                    dealJump(aVar.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i2 == d.b.h0.a.b0.a.I && !k.isEmpty(str6)) {
                dealJump(aVar.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
            }
        } else if (i == d.b.h0.a.b0.a.G) {
            if (i6 == 1) {
                Context context = this.mContext;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
            h.i(new TopToastEvent(i5, str));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
        if (shareItem.V != 0) {
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

    public d.b.i0.d3.l0.d.c showTipToast(String str, String str2, String str3, int i, int i2) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        int i3 = 0;
        i3 = 0;
        if (!TextUtils.isEmpty(str)) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "showToast_" + str3;
                    int k = d.b.h0.r.d0.b.j().k(str4, 0);
                    if (k < i) {
                        d.b.h0.r.d0.b.j().v(str4, k);
                        h.i(new TipEvent(activity.getIntent(), str, str2, i2 == 1));
                    }
                } else {
                    h.i(new TipEvent(activity.getIntent(), str, str2, i2 == 1));
                }
                if (i2 == 1) {
                    activity.finish();
                }
                i3 = 1;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, i3);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public String startApp(String str) {
        if (!k.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return startApp(jSONObject.optString(PushClientConstants.TAG_PKG_NAME), jSONObject.optString("schema")).a();
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

    public d.b.i0.d3.l0.d.c startDownloadCss(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        JSONObject jSONObject = new JSONObject();
        if (!k.isEmpty(str)) {
            try {
                if (k.isEmpty(str)) {
                    jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                    cVar.l(jSONObject.toString());
                    return cVar;
                }
                String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                    jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 0);
                    cVar.l(jSONObject.toString());
                    return cVar;
                }
                DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                downloadData.setPath(customLoginCssStoragePath);
                d.b.h0.v.d.j().k(downloadData);
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public d.b.i0.d3.l0.d.c startLoginModule(String str) {
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
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
        cVar.l(OrmObject.jsonStrWithObject(jSResultData));
        return cVar;
    }

    public d.b.i0.d3.l0.d.c thirdPartyLoginResultToH5(HashMap hashMap) {
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
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        cVar.l(jSONObject.toString());
        return cVar;
    }

    public CommonTbJsBridge(Context context, WebView webView) {
        this.SHOW_MORE_FORUM_ICON = "1";
        this.mLastLoadUrlTime = 0L;
        this.mContext = context;
        this.mWebView = webView;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d.b.i0.d3.l0.d.c startApp(String str, String str2) {
        boolean z;
        Intent launchIntentForPackage;
        d.b.i0.d3.l0.d.c cVar = new d.b.i0.d3.l0.d.c();
        List<String> a2 = d.b.h0.s.c.i.a();
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
                cVar.l(jSONObject.toString());
                return cVar;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MiPushCommandMessage.KEY_RESULT_CODE, z ? 1 : 0);
            cVar.l(jSONObject2.toString());
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
