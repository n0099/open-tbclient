package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.a65;
import com.baidu.tieba.b96;
import com.baidu.tieba.bi8;
import com.baidu.tieba.easterEgg.EasterEggBridge;
import com.baidu.tieba.ej;
import com.baidu.tieba.en4;
import com.baidu.tieba.eo8;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.fy4;
import com.baidu.tieba.gj5;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.k35;
import com.baidu.tieba.kj5;
import com.baidu.tieba.ky4;
import com.baidu.tieba.li5;
import com.baidu.tieba.m15;
import com.baidu.tieba.mb5;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.mg8;
import com.baidu.tieba.mp8;
import com.baidu.tieba.n39;
import com.baidu.tieba.nb7;
import com.baidu.tieba.ni;
import com.baidu.tieba.nn4;
import com.baidu.tieba.np8;
import com.baidu.tieba.nr4;
import com.baidu.tieba.o55;
import com.baidu.tieba.q56;
import com.baidu.tieba.qo;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.qv4;
import com.baidu.tieba.r45;
import com.baidu.tieba.ri5;
import com.baidu.tieba.rp4;
import com.baidu.tieba.rp8;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.te8;
import com.baidu.tieba.th8;
import com.baidu.tieba.ue8;
import com.baidu.tieba.vh8;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.w35;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wp4;
import com.baidu.tieba.xi;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.common.util.TriState;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
@qo
/* loaded from: classes3.dex */
public class CommonTbJsBridge implements np8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANGE_POST_WALL = "postFakeTheWall";
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
    public static final String GET_APP_STORAGE = "getAppStorage";
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
    public static final int H5_PERSONALIZED_REC_SWITCH_UNSET = -1;
    public static final String HAS_NOTIFICATION_PERMISSION = "hasNotificationPermission";
    public static final String HIDE_WEBVIEW_LOADING = "hideWebLoading";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String IS_DISABLE_GO_BACK = "isDisableGoBack";
    public static final String JS_CHARGE_IBEAN_CALLBACK = "jsChargeIbeanCallback";
    public static final String JUMP_TO_HTML_PAGE = "jumpToHTMLPage";
    public static final String LOAD_THIRD_PARTY_LOGIN = "loadThirdPartyLogin";
    public static final String LOGIN_RESULT_TO_H5 = "loginResultToH5";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
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
    public static final String SELECT_PHOTO_ALBUM = "selectPhotoAlbum";
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
    public mp8 jsPromptBridge;
    public final Context mContext;
    public int mH5PersonalizedRecSwitch;
    public long mLastLoadUrlTime;
    public PermissionJudgePolicy mPermissionJudgement;
    public JsPromptResult mResult;
    public en4 mShakeController;
    public WebView mWebView;
    public String shakeCallbackjsMethod;
    public ShareItem shareItem;

    private void hideWebviewLoading(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements en4.b {
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

        @Override // com.baidu.tieba.en4.b
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

    /* loaded from: classes3.dex */
    public class b extends InsertGalleryAsyncTask.a {
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

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.jsPromptBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(TiebaStatic.LogFields.RESULT, -1);
                this.a.jsPromptBridge.h(this.a.mWebView, "saveImageSuccess", linkedHashMap);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.a.jsPromptBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(TiebaStatic.LogFields.RESULT, 0);
                this.a.jsPromptBridge.h(this.a.mWebView, "saveImageSuccess", linkedHashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements vh8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CommonTbJsBridge d;

        public c(CommonTbJsBridge commonTbJsBridge, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = commonTbJsBridge;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.tieba.vh8.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(HashMap<String, String> hashMap) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            Class<?> cls = null;
            try {
                if (TextUtils.isEmpty(this.a)) {
                    jSONObject2 = new JSONObject();
                } else {
                    jSONObject2 = new JSONObject(this.a);
                }
            } catch (Exception e) {
                e = e;
                jSONObject = null;
            }
            try {
                jSONObject2.put("page", this.b);
                jSONObject2.put("refre", this.c);
                jSONObject2.put("from", 0);
            } catch (Exception e2) {
                jSONObject = jSONObject2;
                e = e2;
                e.printStackTrace();
                jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                }
            }
            if (jSONObject2 == null) {
                try {
                    cls = Class.forName(hashMap.get(this.b));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (cls == null) {
                    return;
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (cls2.isAssignableFrom(th8.class)) {
                        try {
                            ((th8) cls.newInstance()).dispatch(jSONObject2, this.d.mContext);
                            return;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends gj5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public d(CommonTbJsBridge commonTbJsBridge, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gj5
        /* renamed from: a */
        public ImMessageCenterPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return nb7.f().i(this.a);
            }
            return (ImMessageCenterPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements li5<ImMessageCenterPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ArrayList b;

        public e(CommonTbJsBridge commonTbJsBridge, String str, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTbJsBridge, str, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.li5
        /* renamed from: a */
        public void onReturnDataInUI(ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterPojo) == null) {
                if (imMessageCenterPojo != null) {
                    PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), wg.g(imMessageCenterPojo.getGid(), 0L), imMessageCenterPojo.getGroup_name(), imMessageCenterPojo.getNameShow(), this.a, 0);
                    personalChatActivityConfig.setRequestCode(12019);
                    personalChatActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    personalChatActivityConfig.setIsReportSelect(true);
                    personalChatActivityConfig.setSelectList(this.b);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig));
                    return;
                }
                PersonalChatActivityConfig personalChatActivityConfig2 = new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), 0L, "", "", this.a, 0);
                personalChatActivityConfig2.setRequestCode(12019);
                personalChatActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
                personalChatActivityConfig2.setIsReportSelect(true);
                personalChatActivityConfig2.setSelectList(this.b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalChatActivityConfig2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends InsertGalleryAsyncTask.a {
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

        public f(CommonTbJsBridge commonTbJsBridge, int i) {
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
                    this.b.shareItem.h0 = 1;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ky4.k().w("key_bawu_task_toast", -1);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public rp8 deleteOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                te8.q().i();
                ue8.a().i(null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 getClipperInformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            rp8 rp8Var = new rp8();
            String clipBoardContent = UtilHelper.getClipBoardContent();
            int i = !wi.isEmpty(clipBoardContent) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", clipBoardContent);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 getHdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("hdid", TbadkCoreApplication.getInst().getHdid());
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            rp8 rp8Var = new rp8();
            String zid = TbadkCoreApplication.getInst().getZid();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("zid", zid);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 hasNotificationPermission() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            rp8 rp8Var = new rp8();
            if (Build.VERSION.SDK_INT >= 19) {
                i = NotificationManagerCompat.from(this.mContext).areNotificationsEnabled();
            } else {
                i = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 playVibrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            rp8 rp8Var = new rp8();
            boolean g = getShakeController().g();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", g ? 1 : 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 setDisableGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            rp8 rp8Var = new rp8();
            Context context = this.mContext;
            int i = 1;
            if (context instanceof TbWebViewActivity) {
                ((TbWebViewActivity) context).isDisableGoBack = true;
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 updateOfflineBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                te8.q().i();
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (rp8) invokeV.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, str)) == null) {
            if (!wi.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return jumpLoginActivity(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public rp8 changeSkinTypeInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            if (hashMap == null) {
                return rp8Var;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(CHANGE_SKIN_TYPE, jSONObject);
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public rp8 checkAppInstall(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            rp8 rp8Var = new rp8();
            if (!StringUtils.isNull(str)) {
                i = UtilHelper.isInstalledPackage(this.mContext, str);
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 checkInstallGameApk(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            rp8 rp8Var = new rp8();
            if (!StringUtils.isNull(str)) {
                if (UtilHelper.isInstalledPackage(this.mContext, str)) {
                    i = 1;
                } else {
                    i = 2;
                }
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                rp8Var.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 dealClickGoBackToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(CLICK_GO_BACK_TO_H5, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 finishTestAnswer(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            rp8 rp8Var = new rp8();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(j)));
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
            rp8Var.o(FINISH_TEST_ANSWER);
            return rp8Var;
        }
        return (rp8) invokeJ.objValue;
    }

    public rp8 getPhotoAlbumResult(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("imageUrl", hashMap.get("url"));
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 orderGameApkResult(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", hashMap.get("id"));
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("name", hashMap.get("name"));
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 postWriteWallData(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            if (hashMap == null) {
                return rp8Var;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("threadInfo", hashMap.get("threadInfo"));
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(CHANGE_POST_WALL, jSONObject);
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 reHide(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RE_HIDE, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 reShow(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RE_SHOW, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 setClipperInformation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            rp8 rp8Var = new rp8();
            ni.a(str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 setSearchHistory(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            try {
                rp8Var.o(new JSONArray(hashMap.get("data").toString()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 startLoginModule(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, str)) == null) {
            rp8 rp8Var = new rp8();
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
            rp8Var.o(OrmObject.jsonStrWithObject(jSResultData));
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 switchOfflineBundleStatus(int i) {
        InterceptResult invokeI;
        boolean z;
        TriState triState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i)) == null) {
            rp8 rp8Var = new rp8();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            try {
                if (z) {
                    triState = TriState.YES;
                } else {
                    triState = TriState.NO;
                }
                QuickWebViewSwitch.setState(triState);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (rp8) invokeI.objValue;
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
        this.emptyParams4CallJs = new JSONObject();
        this.mLastLoadUrlTime = 0L;
        this.mH5PersonalizedRecSwitch = -1;
        this.mContext = context;
        this.mWebView = webView;
    }

    private void shareLoacalImage(String str, int i) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65558, this, str, i) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
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
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, str, new f(this, i));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    public rp8 finishPage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            rp8 rp8Var = new rp8();
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
                if (wi.isEquals(str, "FictionalCharacterDetailsPage")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                    hashMap.put("source", str2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.mContext, "FictionalCharacterDetailsPage", hashMap)));
                }
            }
            return rp8Var;
        }
        return (rp8) invokeLL.objValue;
    }

    public rp8 handleGoToBarDetail(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, str, i)) == null) {
            rp8 rp8Var = new rp8();
            if (!TextUtils.isEmpty(str)) {
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.mContext, str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE);
                if (i == 1 || i == 2 || i == 3) {
                    forumDetailActivityConfig.setSelectHostTab(i);
                }
                forumDetailActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            return rp8Var;
        }
        return (rp8) invokeLI.objValue;
    }

    public rp8 jumpLoginActivity(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i, str)) == null) {
            rp8 rp8Var = new rp8();
            JSONObject jSONObject = new JSONObject();
            if (this.mContext == null) {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            WebView webView = this.mWebView;
            if (webView != null) {
                loginActivityConfig.setUrl(webView.getOriginalUrl());
            }
            ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e3) {
                BdLog.e(e3);
            }
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeIL.objValue;
    }

    public rp8 putAppStorage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, str, str2)) == null) {
            rp8 rp8Var = new rp8();
            ky4 k = ky4.k();
            k.y("key_local_app_storage_" + str, str2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeLL.objValue;
    }

    public rp8 reportUserTheme(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, str, arrayList)) == null) {
            rp8 rp8Var = new rp8();
            ReportThemeActivityConfig reportThemeActivityConfig = new ReportThemeActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), str, arrayList);
            reportThemeActivityConfig.setRequestCode(12018);
            reportThemeActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, reportThemeActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeLL.objValue;
    }

    public rp8 sendCompleteTaskReqMsg(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, str, str2)) == null) {
            rp8 rp8Var = new rp8();
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
                jSONObject2.put("resultCode", i);
                rp8Var.o(jSONObject2.toString());
                return rp8Var;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return rp8Var;
            }
        }
        return (rp8) invokeLL.objValue;
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, str) == null) && !wi.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(currentActivityPageContext, new String[]{str});
        }
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

    private void setShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, shareItem) == null) {
            this.shareItem = shareItem;
        }
    }

    private void showRightShare(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
        }
    }

    public rp8 dealGoBackFromNative(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            callJsMethod(GO_BACK_FROM_NATIVE, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public void dealSpringFestivalTimer(HashMap hashMap) {
        mp8 mp8Var;
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) && (mp8Var = this.jsPromptBridge) != null && (webView = this.mWebView) != null && hashMap != null) {
            mp8Var.h(webView, "getPageLeaveTime", hashMap);
        }
    }

    public rp8 disableBack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            rp8 rp8Var = new rp8();
            Context context = this.mContext;
            if (context instanceof TbWebViewActivity) {
                if (i == 0) {
                    ((TbWebViewActivity) context).setSwipeBackEnabled(true);
                } else {
                    ((TbWebViewActivity) context).setSwipeBackEnabled(false);
                }
            }
            return rp8Var;
        }
        return (rp8) invokeI.objValue;
    }

    public rp8 openMXDYab(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            return new rp8();
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 openVipSuccessInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, hashMap)) == null) {
            callJsMethod(OPEN_VIP_SUCCESS, new JSONObject());
            return new rp8();
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 personlizedSwitchChange(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            try {
                this.mH5PersonalizedRecSwitch = Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return new rp8();
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 saveImageSuccess(HashMap<String, Integer> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            if (hashMap != null && hashMap.get(TiebaStatic.LogFields.RESULT).intValue() == -1) {
                rp8Var.q("图片保存错误");
            }
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public void setJsPromptBridge(mp8 mp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, mp8Var) == null) {
            this.jsPromptBridge = mp8Var;
        }
    }

    public void setLastLoadUrlTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j) == null) {
            this.mLastLoadUrlTime = j;
        }
    }

    public rp8 springFestivalTimeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            if (hashMap != null && hashMap.get(TiebaStatic.LogFields.RESULT) != null) {
                rp8Var.o(hashMap.get(TiebaStatic.LogFields.RESULT));
            }
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 updateSearchForumInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, str)) == null) {
            bi8.d().f(str);
            return new rp8();
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 handlePortal(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048613, this, str, str2, str3)) == null) {
            rp8 rp8Var = new rp8();
            vh8.c().b(new c(this, str3, str, str2));
            return rp8Var;
        }
        return (rp8) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsMethod(String str, JSONObject jSONObject) {
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, this, str, jSONObject) != null) || (webView = this.mWebView) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')");
    }

    public rp8 selectPrivateMsg(String str, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048639, this, str, arrayList)) == null) {
            rp8 rp8Var = new rp8();
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                for (int i = 0; i < arrayList.size(); i++) {
                    JSONObject jSONObject = arrayList.get(i);
                    String optString = jSONObject.optString("reportContent");
                    if (!TextUtils.isEmpty(optString)) {
                        optString = new String(Base64.decode(optString, 2), StandardCharsets.UTF_8);
                    }
                    arrayList2.add(new ReportPrivateMsgData(jSONObject.optString("msgId"), optString, jSONObject.optString(FileMetaUtil.CREATE_TIME)));
                }
            }
            kj5.c(new d(this, str), new e(this, str, arrayList2));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                rp8Var.o(jSONObject2.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public rp8 startApp(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, str, str2)) == null) {
            rp8 rp8Var = new rp8();
            List<String> a2 = m15.a();
            int i = 0;
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
                    if (z) {
                        i = 1;
                    }
                    jSONObject.put("resultCode", i);
                    rp8Var.o(jSONObject.toString());
                    return rp8Var;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (z) {
                }
                jSONObject2.put("resultCode", i);
                rp8Var.o(jSONObject2.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
            z = false;
            if (!z) {
                this.mContext.startActivity(launchIntentForPackage);
                z = true;
            }
        } else {
            return (rp8) invokeLL.objValue;
        }
    }

    private String getAPIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 0);
                jSONObject.put("message", TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10e7));
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

    public rp8 goToNotificationSetting() {
        InterceptResult invokeV;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            if (currentActivity == null) {
                return rp8Var;
            }
            currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            return rp8Var;
        }
        return (rp8) invokeV.objValue;
    }

    private en4 getShakeController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (this.mShakeController == null) {
                this.mShakeController = new en4(this.mContext, new a(this));
            }
            return this.mShakeController;
        }
        return (en4) invokeV.objValue;
    }

    private String refreshPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void dealJsChargeIbeanCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            callJsMethod(JS_CHARGE_IBEAN_CALLBACK, this.emptyParams4CallJs);
        }
    }

    public rp8 getStartLoadTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loadUrlTime", this.mLastLoadUrlTime);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public int getmH5PersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mH5PersonalizedRecSwitch;
        }
        return invokeV.intValue;
    }

    public rp8 jumpToHotTrendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            rp8 rp8Var = new rp8();
            fy4.g(this.mContext, 16, false);
            return rp8Var;
        }
        return (rp8) invokeV.objValue;
    }

    public void onDestroy() {
        en4 en4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (en4Var = this.mShakeController) != null && en4Var.d()) {
            this.mShakeController.c();
        }
    }

    private boolean isLegalSchema(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, list, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str, null, str2);
            createNormalCfg.setStartFrom(5);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public rp8 jumpForumRulesEditPage(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ForumRuleEditActivityConfig forumRuleEditActivityConfig = new ForumRuleEditActivityConfig(this.mContext, str, str2, null, 0, null);
                forumRuleEditActivityConfig.setRequestCode(25070);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumRuleEditActivityConfig));
            }
            return new rp8();
        }
        return (rp8) invokeLL.objValue;
    }

    public rp8 jumpToHtmlPage(String str, int i) {
        InterceptResult invokeLI;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048619, this, str, i)) == null) {
            rp8 rp8Var = new rp8();
            if (!TextUtils.isEmpty(str) && (context = this.mContext) != null) {
                rp4.o(context, str);
                if (i == 1) {
                    Context context2 = this.mContext;
                    if (context2 instanceof Activity) {
                        ((Activity) context2).finish();
                    }
                }
            }
            return rp8Var;
        }
        return (rp8) invokeLI.objValue;
    }

    public rp8 openThirdPartApp(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i, str)) == null) {
            rp8 rp8Var = new rp8();
            if (i == 1) {
                if (eo8.b(this.mContext, "com.tencent.mobileqq")) {
                    w35.e(8, this.mContext);
                } else {
                    Context context = this.mContext;
                    BdToast.b(context, context.getText(R.string.obfuscated_res_0x7f0f119c)).i();
                }
            }
            return rp8Var;
        }
        return (rp8) invokeIL.objValue;
    }

    public rp8 orderGameApk(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048626, this, str, str2)) == null) {
            rp8 rp8Var = new rp8();
            Context context = this.mContext;
            if (context instanceof BdBaseActivity) {
                ItemCardHelper.v(((BdBaseActivity) context).getUniqueId(), str, str2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeLL.objValue;
    }

    public rp8 updateTailStyle(int i, String str) {
        InterceptResult invokeIL;
        SmallTailThemeData smallTailThemeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048664, this, i, str)) == null) {
            if (i == 1) {
                smallTailThemeData = new SmallTailThemeData();
                smallTailThemeData.setPropsId(str);
            } else {
                smallTailThemeData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921748, smallTailThemeData));
            return new rp8();
        }
        return (rp8) invokeIL.objValue;
    }

    private String parseSpringFestivalTimer(String str) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("open");
                String optString = jSONObject.optString(EasterEggBridge.KEY_METHOD_NAME);
                o55 o55Var = new o55();
                o55Var.g(optBoolean);
                o55Var.f(optString);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, o55Var));
                i = 1;
            } catch (JSONException e2) {
                e2.printStackTrace();
                i = 0;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                return jSONObject2.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private String startAcceleromter(String str) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, str)) == null) {
            try {
                this.shakeCallbackjsMethod = new JSONObject(str).optString(EasterEggBridge.KEY_METHOD_NAME);
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
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public rp8 closeNativeMask(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            rp8 rp8Var = new rp8();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(z)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return rp8Var;
        }
        return (rp8) invokeI.objValue;
    }

    public rp8 getAppStorage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            rp8 rp8Var = new rp8();
            ky4 k = ky4.k();
            String q = k.q("key_local_app_storage_" + str, "");
            int i = !wi.isEmpty(q) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", q);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 getToReportThemePage(HashMap<String, ArrayList<String>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                ArrayList<String> arrayList = hashMap.get("tid");
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
                }
                jSONObject.put("resultCode", 1);
                jSONObject.put("threadArray", jSONArray);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 handleGoToMyLive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            rp8 rp8Var = new rp8();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mContext, str, "", "", 0, true)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 handleGoToMyPost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            rp8 rp8Var = new rp8();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mContext, str, 0, null)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 onUserLoginChanged(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, hashMap)) == null) {
            if (hashMap == null || hashMap.get("isLogin") == null || !((Boolean) hashMap.get("isLogin")).booleanValue()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(LOGIN_RESULT_TO_H5, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 playSound(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            rp8 rp8Var = new rp8();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                getShakeController().i(str);
                i = 1;
            } else {
                Context context = this.mContext;
                if (context != null) {
                    xi.O(context, R.string.obfuscated_res_0x7f0f0c7f);
                }
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public void showShareDialog(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, shareItem) != null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
        if (shareItem.h0 != 0) {
            shareDialogConfig.hideMode |= 32;
        }
        shareDialogConfig.setIsSupportNightMode(true);
        shareDialogConfig.setIsCopyLink(true);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public String startApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, str)) == null) {
            if (!wi.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return startApp(jSONObject.optString("pkgName"), jSONObject.optString("schema")).a();
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                return jSONObject2.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public rp8 thirdPartyLoginResultToH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
                jSONObject.put("socialType", hashMap.get("social_type"));
                jSONObject.put("activityId", hashMap.get("activityId"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(RESULT_THIRD_PARTY_LOGIN, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.np8
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str)) {
                if ("startLoginModule".equals(str2)) {
                    try {
                        jsPromptResult.confirm(startLoginModule(new JSONObject(str3).optString("cssUrl")).a());
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (HIDE_WEBVIEW_LOADING.equals(str2)) {
                    try {
                        String optString = new JSONObject(str3).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            hideWebviewLoading(optString);
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
                        JSONObject jSONObject = new JSONObject(str3);
                        jsPromptResult.confirm(finishPage(jSONObject.optString("nextPage"), jSONObject.optString("source")).a());
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                if (PERSON_PAGE_SHARE.equals(str2)) {
                    try {
                        showRightShare(str3);
                        jsPromptResult.confirm();
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (GET_ZID.equals(str2)) {
                    jsPromptResult.confirm(getZid().a());
                    return true;
                } else if (SET_SHARE_INFO.equals(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        jsPromptResult.confirm(setShareInfo(jSONObject2.optString("title"), jSONObject2.optString("desc"), jSONObject2.optString("img"), jSONObject2.optString("url"), jSONObject2.optString("topic"), jSONObject2.optString("wbtitle"), jSONObject2.optString("wbcontent"), jSONObject2.optString("isShowMoreForum"), jSONObject2.optInt("shareimg"), jSONObject2.optString("extdata")).a());
                        return true;
                    } catch (JSONException e7) {
                        BdLog.e(e7);
                        return true;
                    }
                } else if ("share".equals(str2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        jsPromptResult.confirm(share(jSONObject3.optInt("channel"), jSONObject3.optInt("shareimg"), jSONObject3.optString("img"), jSONObject3.optString("isShowMoreForum"), jSONObject3.optString("url"), jSONObject3.optString("title"), jSONObject3.optString("desc"), jSONObject3.optString("topic"), jSONObject3.optString("wbtitle"), jSONObject3.optString("wbcontent"), jSONObject3.optInt("weixin_disable"), jSONObject3.optString("extdata"), jSONObject3.optInt("source"), jSONObject3.optString("topicid")).a());
                        return true;
                    } catch (JSONException e8) {
                        BdLog.e(e8);
                        return true;
                    }
                } else if (GET_CLIPPER_INFORMATION.equals(str2)) {
                    jsPromptResult.confirm(getClipperInformation().a());
                    return true;
                } else if (SET_CLIPPER_INFORMATION.equals(str2)) {
                    try {
                        try {
                            jsPromptResult.confirm(setClipperInformation(new JSONObject(str3).optString("txt")).a());
                        } catch (JSONException e9) {
                            e = e9;
                            BdLog.e(e);
                            return true;
                        }
                    } catch (JSONException e10) {
                        e = e10;
                    }
                    return true;
                } else if (CHECK_APP_INSTALL.equals(str2)) {
                    try {
                        jsPromptResult.confirm(checkAppInstall(new JSONObject(str3).optString("pkgName")).a());
                    } catch (JSONException e11) {
                        BdLog.e(e11);
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
                    } catch (JSONException e12) {
                        BdLog.e(e12);
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
                    } catch (JSONException e13) {
                        BdLog.e(e13);
                    }
                } else if (START_ACCELEROMETER.equals(str2)) {
                    jsPromptResult.confirm(startAcceleromter(str3));
                } else if (DisableSlideBack.equals(str2)) {
                    try {
                        jsPromptResult.confirm(disableBack(new JSONObject(str3).optInt(PackageTable.DISABLE)).a());
                    } catch (JSONException e14) {
                        BdLog.e(e14);
                    }
                } else if (TOAST_POPUPVIEW.equals(str2)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(str3);
                        jsPromptResult.confirm(showLowerHairHint(jSONObject4.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject4.optInt("ahead_type"), jSONObject4.optString("message"), jSONObject4.optString("btn_text"), jSONObject4.optInt("toast_duration"), jSONObject4.optString("schema"), jSONObject4.optString("token"), jSONObject4.optDouble(NativeConstants.OPACITY), jSONObject4.optString(BigdayActivityConfig.IMG_URL), jSONObject4.optString("url"), jSONObject4.optInt("mission_id"), jSONObject4.optString("btn_color"), jSONObject4.optString("message_color"), jSONObject4.optString("btn_text_color"), jSONObject4.optInt("status"), jSONObject4.optInt(FINISH_THIS_PAGE)).a());
                    } catch (JSONException e15) {
                        BdLog.e(e15);
                    }
                } else if (GAME_PUSH.equals(str2)) {
                    try {
                        JSONObject jSONObject5 = new JSONObject(str3);
                        try {
                            jsPromptResult.confirm(gamePush(jSONObject5.optString("gameId"), jSONObject5.optString("gameName"), jSONObject5.optString("gameTime"), jSONObject5.optString("gameType")).a());
                        } catch (JSONException e16) {
                            e = e16;
                            e.printStackTrace();
                            return true;
                        }
                    } catch (JSONException e17) {
                        e = e17;
                    }
                    return true;
                } else if (GAME_PUSH_STATUS.equals(str2)) {
                    jsPromptResult.confirm(handleGamePushStatus().a());
                    return true;
                } else if (GO_TO_MY_POST.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleGoToMyPost(new JSONObject(str3).optString("uid")).a());
                    } catch (JSONException e18) {
                        BdLog.e(e18);
                    }
                    return true;
                } else if (GO_TO_MY_LIVE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleGoToMyLive(new JSONObject(str3).optString("uid")).a());
                    } catch (JSONException e19) {
                        BdLog.e(e19);
                    }
                    return true;
                } else if (SAVE_IMAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(handleSaveImage(new JSONObject(str3).optString("imgUrl")).a());
                    } catch (JSONException e20) {
                        BdLog.e(e20);
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
                        JSONObject jSONObject6 = new JSONObject(str3);
                        jsPromptResult.confirm(sendCompleteTaskReqMsg(jSONObject6.optString("activityId"), jSONObject6.optString("missionId")).a());
                    } catch (JSONException e21) {
                        BdLog.e(e21);
                    }
                } else if (GET_MODAL_DATA.equals(str2)) {
                    try {
                        jsPromptResult.confirm(getGetModalData(new JSONObject(str3).optString("url")).a());
                    } catch (JSONException e22) {
                        BdLog.e(e22);
                    }
                } else if (SHOW_TIP_TOAST.equals(str2)) {
                    try {
                        JSONObject jSONObject7 = new JSONObject(str3);
                        jsPromptResult.confirm(showTipToast(jSONObject7.optString("content"), jSONObject7.optString("linkUrl"), jSONObject7.optString("key"), jSONObject7.optInt("maxTimes"), jSONObject7.optInt(FINISH_THIS_PAGE)).a());
                    } catch (JSONException e23) {
                        BdLog.e(e23);
                    }
                } else if (JUMP_TO_HTML_PAGE.equals(str2)) {
                    try {
                        JSONObject jSONObject8 = new JSONObject(str3);
                        jsPromptResult.confirm(jumpToHtmlPage(jSONObject8.optString("url"), jSONObject8.optInt("finish_this_page", 1)).toString());
                    } catch (JSONException e24) {
                        BdLog.e(e24);
                    }
                } else if (CLOSE_NATIVE_MASK.equals(str2)) {
                    try {
                        z = false;
                        try {
                            jsPromptResult.confirm(closeNativeMask(new JSONObject(str3).optInt(TiebaStatic.LogFields.RESULT, 0)).a());
                            return false;
                        } catch (JSONException e25) {
                            e = e25;
                            e.printStackTrace();
                            return z;
                        }
                    } catch (JSONException e26) {
                        e = e26;
                        z = false;
                    }
                } else if (GO_TO_HOT_TREND.equals(str2)) {
                    jumpToHotTrendPage();
                    jsPromptResult.confirm();
                    return false;
                } else if (GO_TO_PB.equals(str2)) {
                    try {
                        JSONObject jSONObject9 = new JSONObject(str3);
                        String optString2 = jSONObject9.optString("tid");
                        String optString3 = jSONObject9.optString("fr");
                        if (!StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                            jumpToPbPage(optString2, optString3);
                        }
                        jsPromptResult.confirm();
                        return true;
                    } catch (JSONException e27) {
                        e27.printStackTrace();
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
                    } catch (JSONException e28) {
                        e28.printStackTrace();
                    }
                    return true;
                } else if (GET_APP_STORAGE.equals(str2)) {
                    try {
                        jsPromptResult.confirm(getAppStorage(new JSONObject(str3).optString("key")).a());
                    } catch (JSONException e29) {
                        BdLog.e(e29);
                    }
                    return true;
                } else if (!PUT_APP_STORAGE.equals(str2)) {
                    return false;
                } else {
                    try {
                        JSONObject jSONObject10 = new JSONObject(str3);
                        jsPromptResult.confirm(putAppStorage(jSONObject10.optString("key"), jSONObject10.optString("data")).a());
                    } catch (JSONException e30) {
                        BdLog.e(e30);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public void dealSpringFestivalTimer(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject) == null) {
            callJsMethod(str, jSONObject);
        }
    }

    public rp8 gamePush(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, str, str2, str3, str4)) == null) {
            rp8 rp8Var = new rp8();
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
                return rp8Var;
            }
            rp8Var.p();
            return rp8Var;
        }
        return (rp8) invokeLLLL.objValue;
    }

    public rp8 getDeviceInfo() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            rp8 rp8Var = new rp8();
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
            String g = zi.g();
            stringBuffer.append("model=");
            stringBuffer.append(zi.g());
            String str2 = Build.BRAND;
            stringBuffer.append("brand=");
            stringBuffer.append(str2);
            stringBuffer.append("platform=");
            stringBuffer.append("Android");
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            stringBuffer.append("pkgName=");
            stringBuffer.append(packageName);
            String str3 = "" + BdNetTypeUtil.netType();
            stringBuffer.append("network=");
            stringBuffer.append(str3);
            String str4 = "" + BdNetTypeUtil.curOperatorType();
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
            if (DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst())) {
                str = "1";
            } else {
                str = "0";
            }
            stringBuffer.append("imu=");
            stringBuffer.append(str);
            stringBuffer.append("tiebaclient!!!");
            String c2 = ej.c(stringBuffer.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("imei", imei);
                    jSONObject.put("androidId", androidId);
                    jSONObject.put(BaseStatisContent.IMSI, iMsi);
                    jSONObject.put("model", g);
                    jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, str2);
                    jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                    jSONObject.put("pkgName", packageName);
                    jSONObject.put("network", str3);
                    jSONObject.put("carrier", str4);
                    jSONObject.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                    jSONObject.put(HttpConstants.HTTP_HARDWARE, str5);
                    jSONObject.put(HttpConstants.HTTP_BOARD, str6);
                    jSONObject.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str);
                    jSONObject.put("sign", c2);
                    rp8Var = rp8Var;
                    rp8Var.o(jSONObject.toString());
                    return rp8Var;
                } catch (JSONException e2) {
                    e = e2;
                    rp8Var = rp8Var;
                    BdLog.e(e);
                    rp8Var.o("");
                    return rp8Var;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            return (rp8) invokeV.objValue;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|4|5|(5:7|(1:11)|13|14|15)(5:20|(2:22|23)|13|14|15)|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
        com.baidu.adp.lib.util.BdLog.e(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public rp8 getGetModalData(String str) {
        InterceptResult invokeL;
        String f2;
        JSONObject newGodDataJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            rp8 rp8Var = new rp8();
            JSONObject jSONObject = null;
            int i = 0;
            try {
                f2 = k35.c().f();
                newGodDataJson = TbSingleton.getInstance().getNewGodDataJson();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (!wi.isEmpty(str)) {
                int indexOf = str.indexOf(WebViewActivityConfig.TAG_NEW_GOD_INVITE);
                if (newGodDataJson != null && indexOf != -1) {
                    jSONObject = newGodDataJson;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                jSONObject2.put("user_info", jSONObject);
                rp8Var.o(jSONObject2.toString());
                return rp8Var;
            }
            if (!TextUtils.isEmpty(f2)) {
                jSONObject = new JSONObject(f2);
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            jSONObject22.put("user_info", jSONObject);
            rp8Var.o(jSONObject22.toString());
            return rp8Var;
            i = 1;
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("resultCode", i);
            jSONObject222.put("user_info", jSONObject);
            rp8Var.o(jSONObject222.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 getSelectPhotoAlbumResult(HashMap<String, List<HashMap>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, hashMap)) == null) {
            JSONArray jSONArray = null;
            if (hashMap == null) {
                return null;
            }
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                List<HashMap> list = hashMap.get("array");
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 < list.size()) {
                        HashMap hashMap2 = list.get(i2);
                        String str = (String) hashMap2.get("url");
                        if (TextUtils.isEmpty(str)) {
                            break;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("identifier", hashMap2.get("identifier"));
                        jSONObject2.put("imageUrl", str);
                        jSONArray2.put(jSONObject2);
                        i2++;
                    } else {
                        i = 1;
                        jSONArray = jSONArray2;
                        break;
                    }
                }
                jSONObject.put("resultCode", i);
                jSONObject.put("imageArray", jSONArray);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 handleSaveImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            rp8 rp8Var = new rp8();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                rp8Var.p();
                return rp8Var;
            }
            this.mPermissionJudgement.appendRequestPermission((Activity) context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
                rp8Var.q("权限申请");
                return rp8Var;
            }
            new InsertGalleryAsyncTask((Activity) this.mContext, str, new b(this)).execute(new String[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 refreshTailInH5(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            if (hashMap == null) {
                return rp8Var;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TailEditActivityConfig.TAIL_ID, hashMap.get("tailId"));
                jSONObject.put(TailEditActivityConfig.TAIL_COLOR, hashMap.get("tailColor"));
                jSONObject.put(TailEditActivityConfig.TAIL_CONTENT, hashMap.get("tailContent"));
                if (this.mContext != null) {
                    jSONObject.put("font_key_name", this.mContext.getString(R.string.obfuscated_res_0x7f0f13b3));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(REFRESH_TAIL, jSONObject);
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 shareSuccessNotification(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, hashMap)) == null) {
            int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
            ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", shareItem.v);
                jSONObject2.put("desc", shareItem.w);
                jSONObject2.put("img", shareItem.z);
                jSONObject2.put("url", shareItem.x);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", intValue);
                jSONObject3.put("shareData", jSONObject2);
                jSONObject.put("resultCode", 1);
                jSONObject.put("data", jSONObject3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            callJsMethod(SHARE_SUCCCESS_NOTIFICATION, jSONObject);
            rp8 rp8Var = new rp8();
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 startDownloadCss(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, str)) == null) {
            rp8 rp8Var = new rp8();
            JSONObject jSONObject = new JSONObject();
            if (!wi.isEmpty(str)) {
                try {
                    if (wi.isEmpty(str)) {
                        jSONObject.put("resultCode", 0);
                        rp8Var.o(jSONObject.toString());
                        return rp8Var;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put("resultCode", 0);
                        rp8Var.o(jSONObject.toString());
                        return rp8Var;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    a65.k().l(downloadData);
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            rp8Var.o(jSONObject.toString());
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 switchOfflineInterface(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, str)) == null) {
            rp8 rp8Var = new rp8();
            try {
                if (StringUtils.isNull(str)) {
                    str = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
                }
                tempUrl = str;
                r45.a().g(true);
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, tempUrl + "?cmd=309485");
                tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 switchUrlHost(ArrayList<JSONObject> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, arrayList)) == null) {
            rp8 rp8Var = new rp8();
            try {
                wp4 wp4Var = new wp4();
                wp4Var.a = new LinkedHashMap();
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        JSONObject jSONObject = arrayList.get(i);
                        if (jSONObject != null) {
                            wp4Var.a.put(jSONObject.optString("path"), jSONObject.optString("host"));
                        }
                    }
                    if (wp4Var.a.size() > 0) {
                        wp4Var.b = new JSONObject().put("hostArr", new JSONArray((Collection) arrayList)).toString();
                        TbDebugSingleton.getInstance().setUrlSwitchMap(wp4Var);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                rp8Var.o(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return rp8Var;
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 getOfflineUserInfo() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            rp8 rp8Var = new rp8();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", TbConfig.getVersion());
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccountId());
                jSONObject.put("hybridVersion", te8.q().D());
                if (QuickWebViewSwitch.getInOn()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("hybridOffline", i);
                jSONObject.put("offlineApiHost", tempUrl);
                if (TbDebugSingleton.getInstance().getUrlSwitchMap() != null && !TextUtils.isEmpty(TbDebugSingleton.getInstance().getUrlSwitchMap().b)) {
                    jSONObject.put("hostArr", TbDebugSingleton.getInstance().getUrlSwitchMap().b);
                }
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return rp8Var;
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 getSelectPrivateImResult(HashMap<String, List<ReportPrivateMsgData>> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, hashMap)) == null) {
            rp8 rp8Var = new rp8();
            List<ReportPrivateMsgData> list = hashMap.get("private_msg");
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < list.size(); i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("msgId", list.get(i).getMsgId());
                    String content = list.get(i).getContent();
                    if (!TextUtils.isEmpty(content)) {
                        jSONObject2.put("reportContent", new String(Base64.encode(content.getBytes(StandardCharsets.UTF_8), 2), StandardCharsets.UTF_8));
                    } else {
                        jSONObject2.put("reportContent", "");
                    }
                    jSONObject2.put(FileMetaUtil.CREATE_TIME, list.get(i).getTime());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("resultCode", 1);
                jSONObject.put("msgArray", jSONArray);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeL.objValue;
    }

    public rp8 getSupplementInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            rp8 rp8Var = new rp8();
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
            String c2 = ej.c(stringBuffer.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", imei);
                jSONObject.put("cuid", cuid);
                jSONObject.put("shoubai_cuid", cuidGalaxy2);
                jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, str);
                jSONObject.put("client_type", "Android");
                jSONObject.put("client_version", version);
                jSONObject.put("zid", zid);
                jSONObject.put("sign", c2);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                rp8Var.o("");
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 goToEditPost(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            rp8 rp8Var = new rp8();
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
            return rp8Var;
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 goToVideoImmersivePage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        InterceptResult invokeCommon;
        String str18;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17})) == null) {
            rp8 rp8Var = new rp8();
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
            videoItemData.video_duration = wg.e(str11, 0);
            if (wg.g(str10, 0L) > wg.g(str9, 0L)) {
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
            ri5.d(this.mContext, arrayList, videoItemData.nid, z, 0, null, "from_nani_video", "personalize_page", "", VideoPlayActivityConfig.FROM_H5_SEARCH, "", "1".equals(str17), false, wg.g(str15, 0L));
            return rp8Var;
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 handleGamePushStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            rp8 rp8Var = new rp8();
            String q = ky4.k().q("key_match_id_list_football", "");
            String q2 = ky4.k().q("key_match_id_list_basketball", "");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("football", PreferencesUtil.LEFT_MOUNT + q + PreferencesUtil.RIGHT_MOUNT);
                jSONObject.put("basketball", PreferencesUtil.LEFT_MOUNT + q2 + PreferencesUtil.RIGHT_MOUNT);
                rp8Var.o(jSONObject.toString());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return rp8Var;
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 handleGetPhotoAlbum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            rp8 rp8Var = new rp8();
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) TbadkCoreApplication.getInst().getCurrentActivity(), new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setCanEditImage(false);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WEB_VIEW);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeV.objValue;
    }

    public rp8 jumpToVideo(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, str, str2, str3)) == null) {
            rp8 rp8Var = new rp8();
            if (WriteActivityConfig.isAsyncWriting()) {
                return rp8Var;
            }
            int a2 = n39.a();
            if (n39.c(a2)) {
                n39.e(this.mContext, a2, 0);
            }
            if (n39.b()) {
                n39.h(null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            } else {
                n39.k(false, false, null, null, null, null, 0, Boolean.TRUE, str, str2, str3);
            }
            return rp8Var;
        }
        return (rp8) invokeLLL.objValue;
    }

    public rp8 selectPhotoAlbum(int i, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048638, this, i, arrayList)) == null) {
            rp8 rp8Var = new rp8();
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.setMaxImagesAllowed(i);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    JSONObject jSONObject = arrayList.get(i2);
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    try {
                        imageFileInfo.setFilePath(jSONObject.getString("identifier"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    writeImagesInfo.addChooseFile(imageFileInfo);
                }
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.setRequestCode(12017);
            albumFloatActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WEB_VIEW);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 6);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setResourceType(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                rp8Var.o(jSONObject2.toString());
                return rp8Var;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return rp8Var;
            }
        }
        return (rp8) invokeIL.objValue;
    }

    public rp8 setShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i), str9})) == null) {
            rp8 rp8Var = new rp8();
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
            if (!wi.isEmpty(jSONObject2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
                i2 = 1;
            } else {
                i2 = 0;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("resultCode", i2);
                rp8Var.o(jSONObject3.toString());
                return rp8Var;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return rp8Var;
            }
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 share(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, int i4, String str10) {
        InterceptResult invokeCommon;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Integer.valueOf(i4), str10})) == null) {
            rp8 rp8Var = new rp8();
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
            int i5 = 1;
            if (!wi.isEmpty(jSONObject2) && (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject2)) != null) {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.I = 17;
                    shareItem.g = true;
                    if (i4 == 1) {
                        shareItem.z0 = str10;
                    }
                }
                if ("1".equals(str2) && shareItem != null) {
                    shareItem.A = str;
                    shareItem.x = str3;
                    shareItem.v = str4 + " " + str5;
                    shareItem.q = true;
                    if (i4 == 1) {
                        shareItem.z0 = str10;
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    q56.c().l(shareDialogConfig);
                    rp8Var.o("");
                    return rp8Var;
                } else if (i == 0) {
                    if (shareItem != null && !wi.isEmpty(str) && i2 == 1) {
                        setShareItem(shareItem);
                        shareLoacalImage(str, i);
                    }
                    showShareDialog(shareItem);
                } else if (shareItem != null && !wi.isEmpty(str) && i2 == 1) {
                    setShareItem(shareItem);
                    shareLoacalImage(str, i);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, i, shareItem, true));
                }
            } else {
                i5 = 0;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("resultCode", i5);
                rp8Var.o(jSONObject3.toString());
                return rp8Var;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return rp8Var;
            }
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 showLowerHairHint(int i, int i2, String str, String str2, int i3, String str3, String str4, double d2, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048649, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, str4, Double.valueOf(d2), str5, str6, Integer.valueOf(i4), str7, str8, str9, Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            rp8 rp8Var = new rp8();
            nn4 nn4Var = new nn4();
            nn4Var.c = i;
            nn4Var.d = i2;
            nn4Var.e = str;
            nn4Var.f = str2;
            nn4Var.i = i3;
            nn4Var.l = str3;
            nn4Var.n = d2;
            nn4Var.j = str5;
            nn4Var.k = str6;
            nn4Var.b = i4;
            nn4Var.o = str7;
            nn4Var.p = str8;
            nn4Var.q = str9;
            if (i == nn4.y) {
                qv4.h(TbadkCoreApplication.getInst().getCurrentActivity(), nn4Var).j();
            } else if (i == nn4.z) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                nr4 nr4Var = new nr4(currentActivity);
                if (currentActivity != null) {
                    nr4Var.d(currentActivity, nn4Var);
                    nr4Var.i();
                }
            } else if (i == nn4.A) {
                if (i2 == nn4.D) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), nn4Var.l) && !wi.isEmpty(nn4Var.k)) {
                        dealJump(nn4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                    }
                } else if (i2 == nn4.E && !wi.isEmpty(str6)) {
                    dealJump(nn4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i == nn4.C) {
                if (i6 == 1) {
                    Context context = this.mContext;
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
                mb5.i(new TopToastEvent(i5, str));
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 showTipToast(String str, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048651, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            rp8 rp8Var = new rp8();
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            i3 = 0;
            if (!TextUtils.isEmpty(str)) {
                Context context = this.mContext;
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = "showToast_" + str3;
                        int l = ky4.k().l(str4, 0);
                        if (l < i) {
                            ky4.k().w(str4, l);
                            Intent intent = activity.getIntent();
                            if (i2 == 1) {
                                z = true;
                            }
                            mb5.i(new TipEvent(intent, str, str2, z));
                        }
                    } else {
                        Intent intent2 = activity.getIntent();
                        if (i2 == 1) {
                            z2 = true;
                        }
                        mb5.i(new TipEvent(intent2, str, str2, z2));
                    }
                    if (i2 == 1) {
                        activity.finish();
                    }
                    i3 = 1;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i3);
                rp8Var.o(jSONObject.toString());
                return rp8Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return rp8Var;
            }
        }
        return (rp8) invokeCommon.objValue;
    }

    public rp8 startDownloadGameApk(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), str11})) == null) {
            rp8 rp8Var = new rp8();
            b96 b96Var = new b96();
            ItemData itemData = new ItemData();
            itemData.buttonLink = str;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = str3;
            itemData.pkgName = str3;
            itemData.mIconUrl = str4;
            itemData.mIconSize = 1.0d;
            int i2 = 1;
            itemData.buttonLinkType = 1;
            itemData.forumName = str5;
            ApkDetail.Builder builder = new ApkDetail.Builder();
            builder.authority_url = str9;
            builder.developer = str7;
            builder.privacy_url = str8;
            builder.size = str10;
            builder.version = str6;
            builder.version_code = Integer.valueOf(i);
            builder.pkg_source = 2;
            itemData.itemId = wg.g(str2, 0L);
            itemData.apkDetail = builder.build(true);
            b96Var.a = itemData;
            b96Var.b = 3;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921627, b96Var));
            DownloadData downloadData = new DownloadData(str3 + ".v" + str6);
            downloadData.setUrl(str);
            downloadData.setName(str3);
            downloadData.setType(12);
            boolean s = mg8.l().s(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!s) {
                    i2 = 2;
                }
                jSONObject.put("resultCode", i2);
                rp8Var.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return rp8Var;
        }
        return (rp8) invokeCommon.objValue;
    }
}
