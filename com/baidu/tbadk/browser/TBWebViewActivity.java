package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.data.ResponeDelAllUserDataHttpResMsg;
import com.baidu.tbadk.core.account.data.ResponseDelAllUserDataSocketMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.hybrid.handlers.ClipboardBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.FocusFeedBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ah5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cq9;
import com.baidu.tieba.dq9;
import com.baidu.tieba.eq9;
import com.baidu.tieba.f55;
import com.baidu.tieba.fv9;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.j45;
import com.baidu.tieba.jg;
import com.baidu.tieba.k45;
import com.baidu.tieba.l45;
import com.baidu.tieba.lr5;
import com.baidu.tieba.ps5;
import com.baidu.tieba.pt4;
import com.baidu.tieba.pw4;
import com.baidu.tieba.qc5;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.t37;
import com.baidu.tieba.u45;
import com.baidu.tieba.ug6;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.vp6;
import com.baidu.tieba.w05;
import com.baidu.tieba.wc9;
import com.baidu.tieba.wj5;
import com.baidu.tieba.ws5;
import com.baidu.tieba.xc9;
import com.baidu.tieba.xs5;
import com.baidu.tieba.xt4;
import com.baidu.tieba.yc9;
import com.baidu.tieba.yf6;
import com.baidu.tieba.ys5;
import com.baidu.tieba.za;
import com.baidu.tieba.zc9;
import com.baidu.tieba.zt4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TBWebViewActivity extends BaseWebViewActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static final String KEY_TASK_CENTER_PREFIX_URL = "https://haokan.baidu.com/activity/";
    public static final int MAX_NUM_UPLOAD_CHAR = 100;
    public static final HashMap<String, String> mShareToTypes;
    public transient /* synthetic */ FieldHolder $fh;
    public String currentPageKey;
    public final za delAllUserDataListener;
    public boolean firstEnter;
    public final Stack<String> historyStack;
    public CustomMessageListener htmlLoadMessageListener;
    public boolean isNewHotTopicView;
    public boolean isShowFullScreen;
    public cq9 jsBridge;
    public eq9 jsCallback;
    public boolean loadMyself;
    public String mBid;
    public CommonTbJsBridge mCommonTbJsBridge;
    public CustomMessageListener mDialogStatusListener;
    public v mDownloadStatusCallback;
    public j45 mHybridBridge;
    public final CustomMessageListener mInstallListener;
    public int mLoadingStyle;
    public int mLoadingSwitch;
    public String mModuleName;
    public int mOfflineErrorType;
    public w mOnDialogItemClickListener;
    public final ItemCardHelper.c mOrderCallback;
    public String mPageFrom;
    public String mPageTranslucent;
    public String mPageType;
    public PermissionJudgePolicy mPermissionJudgement;
    public wc9 mProxy;
    public final CustomMessageListener mSelfLoadJsListener;
    public final CustomMessageListener mSetShareInfoListener;
    public String mShareInfo;
    public ShareItem mShareItem;
    public final CustomMessageListener mSharePage;
    public String mShareParams;
    public boolean mShowShareItem;
    public final CustomMessageListener mSpringFestivalTimerListener;
    public wj5 mTipsEventListener;
    public wj5 mTopToastEventListener;
    public boolean mTranslucentAutoClose;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageAboveL;
    public String mVersion;
    public BridgeWebView mWebView;
    public WebViewBroadcastReceiver mWebViewCloseReceiver;
    public final CustomMessageListener mWritePostNotificationH5SuccessListener;
    @NonNull
    public final YYPayResultCallback4CallJs mYYyPayResultCallback4CallJs;
    public boolean needTextAutoSize;
    public final Runnable shareDialogRunnable;
    public ShareItem shareItem;
    public qc5 timerData;
    public boolean useCustomHistoryStack;
    public boolean useWebPool;
    public Runnable viewDesRunnable;
    public ws5 webContainer;

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class YYPayResultCallback4CallJs implements LifecycleObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final b a;
        public final CustomMessageListener b;

        /* loaded from: classes3.dex */
        public interface b {
            void a();
        }

        /* loaded from: classes3.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ YYPayResultCallback4CallJs a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(YYPayResultCallback4CallJs yYPayResultCallback4CallJs, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {yYPayResultCallback4CallJs, Integer.valueOf(i)};
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
                this.a = yYPayResultCallback4CallJs;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                    return;
                }
                this.a.a.a();
            }
        }

        public YYPayResultCallback4CallJs(@NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new a(this, 2001456);
            this.a = bVar;
        }

        public static void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001456));
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(this.b);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements w05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public List<Integer> c;
        public final /* synthetic */ TBWebViewActivity d;

        /* loaded from: classes3.dex */
        public class a extends InsertGalleryAsyncTask.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                }
            }

            public a(w wVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    ii.P(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }
            }
        }

        public w(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tBWebViewActivity;
            this.a = 1;
            this.c = new ArrayList();
        }

        @Override // com.baidu.tieba.w05.c
        public void a(w05 w05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, w05Var, i, view2) == null) && w05Var == this.d.getListMenu() && i < this.c.size() && i >= 0) {
                if (this.c.get(i).intValue() == 1) {
                    if (this.d.mPermissionJudgement == null) {
                        this.d.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.d.mPermissionJudgement.clearRequestPermissionList();
                    this.d.mPermissionJudgement.appendRequestPermission(this.d, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.d.mPermissionJudgement.startRequestPermission(this.d)) {
                        return;
                    }
                    new InsertGalleryAsyncTask(this.d.getActivity(), this.b, new a(this)).execute(new String[0]);
                }
                w05Var.e();
            }
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.c.clear();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.d.getPageContext().getString(R.string.save_to_local));
                this.c.add(Integer.valueOf(this.a));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.b = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TBWebViewActivity b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x a;

            public a(x xVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = xVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.mView.v();
                }
            }
        }

        public x(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebViewActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                TBWebViewActivity tBWebViewActivity = this.b;
                BridgeWebView bridgeWebView = tBWebViewActivity.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.a = false;
                tBWebViewActivity.mUrl = str;
                bridgeWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.b.mWebView.getTitle();
                if (!this.b.mFixTitle && !StringUtils.isNull(title)) {
                    this.b.mUrlTitle = title;
                }
                if (!this.b.isShowFullScreen) {
                    TBWebViewActivity tBWebViewActivity2 = this.b;
                    tBWebViewActivity2.mView.G(tBWebViewActivity2.mUrlTitle);
                }
                if (this.b.isTranslucent()) {
                    this.b.mView.D(false);
                } else {
                    TBWebViewActivity tBWebViewActivity3 = this.b;
                    tBWebViewActivity3.mView.D(tBWebViewActivity3.mIsShowNavBar);
                }
                TBWebViewActivity tBWebViewActivity4 = this.b;
                tBWebViewActivity4.mView.J(tBWebViewActivity4.isNeedShowShareItem());
                if (!StringUtils.isNull(this.b.mUrl) && this.b.mUrl.contains(TBWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.b.mView.E(8);
                }
                this.b.hideProgressBar();
                this.b.stopLoadTimer();
                TBWebViewActivity tBWebViewActivity5 = this.b;
                xt4 xt4Var = tBWebViewActivity5.mView;
                if (xt4Var != null) {
                    xt4Var.o(tBWebViewActivity5.mUrl);
                }
                if (this.b.useCustomHistoryStack) {
                    this.b.historyStack.add(str);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                TBWebViewActivity tBWebViewActivity = this.b;
                if (tBWebViewActivity.mWebView == null) {
                    return;
                }
                this.a = true;
                tBWebViewActivity.mUrl = str;
                if (!tBWebViewActivity.isNewHotTopicView) {
                    this.b.showProgressBar();
                }
                this.b.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                BridgeWebView bridgeWebView = this.b.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.a = false;
                bridgeWebView.stopLoading();
                this.b.stopLoadTimer();
                this.b.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                zt4.a("TbWebViewActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            xt4 xt4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (RedirectInterceptionSwitch.isOn() && this.a && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                    if (!URLUtil.isNetworkUrl(str)) {
                        if (str.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                            return true;
                        } else if (!TextUtils.isEmpty(UrlManager.getInstance().getSchemaKeyByUrl(str))) {
                            this.b.tryDeeplink(str);
                            return true;
                        }
                    }
                    return false;
                }
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.b.getPageContext(), new String[]{str, this.b.mUrl});
                if (dealOneLinkWithOutJumpWebView == 1) {
                    this.b.finish();
                    return true;
                } else if (dealOneLinkWithOutJumpWebView == 0) {
                    return true;
                } else {
                    if (dealOneLinkWithOutJumpWebView == 2) {
                        return false;
                    }
                    TBWebViewActivity tBWebViewActivity = this.b;
                    tBWebViewActivity.mUrl = str;
                    if (tBWebViewActivity.isShowFullScreen) {
                        this.b.isShowFullScreen = false;
                        this.b.runOnUiThread(new a(this));
                    }
                    this.b.hideCrashTip();
                    if (URLUtil.isNetworkUrl(this.b.mUrl)) {
                        if (!this.b.isNewHotTopicView) {
                            this.b.showProgressBar();
                        }
                        if (this.b.isShowFullScreen && (xt4Var = this.b.mView) != null) {
                            xt4Var.x();
                        }
                        return false;
                    }
                    TBWebViewActivity tBWebViewActivity2 = this.b;
                    tBWebViewActivity2.tryDeeplink(tBWebViewActivity2.mUrl);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends wj5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity c;

        public a(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.c.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent(), topToastEvent.getToastDelay());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public b(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (!TextUtils.isEmpty(this.a.mUrl) && this.a.mUrl.contains("haokan.baidu.com/activity/")) {
                    return false;
                }
                return this.a.handleLongClick();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public c(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.mView.t(i, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public d(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            TBWebViewActivity tBWebViewActivity;
            xt4 xt4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xt4Var = (tBWebViewActivity = this.a).mView) != null) {
                xt4Var.S(tBWebViewActivity.shareItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public e(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.mWebView != null) {
                        this.a.mWebView.destroy();
                        this.a.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public f(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mView.x();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.mUrl.contains(str) || str.contains(this.a.mUrl)) {
                    this.a.hideProgressBar();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements eq9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public h(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tieba.eq9
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.jsBridge != null) {
                    return this.a.jsBridge.c(this.a.mWebView, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.mShareItem != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("shareChannel", 1);
                linkedHashMap.put("shareStatus", 2);
                yf6.a().d(this.a.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.a.mShareParams = (String) customResponsedMessage.getData();
            this.a.showRightShareIcon();
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                String g = ah5.g((Intent) data);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("resultCode", 1);
                linkedHashMap.put("pkgName", g);
                if (this.a.jsBridge != null) {
                    this.a.jsBridge.i(this.a.mWebView, CommonTbJsBridge.INSTALL_APK_RESULT, linkedHashMap);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TBWebViewActivity b;

        public l(TBWebViewActivity tBWebViewActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebViewActivity;
            this.a = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mView.S(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public m(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject(customMessage.getData());
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        String optString5 = jSONObject.optString("topic");
                        String optString6 = jSONObject.optString("wbtitle");
                        String optString7 = jSONObject.optString("wbcontent");
                        this.a.mShareItem = this.a.createShareContent(optString, optString4, optString2, optString3);
                        this.a.mShareItem.T = optString5;
                        this.a.mShareItem.U = optString6;
                        this.a.mShareItem.V = optString7;
                        this.a.mShareItem.k0 = jSONObject.optInt("shareimg");
                        this.a.mShareItem.s0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    this.a.mShareItem.X = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        this.a.mShareItem.L0 = GroupInfoData.fromJsonH5(jSONObject);
                        return new CustomResponsedMessage<>(2016568, this.a.mShareItem);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public n(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.orderGameApkResult(String.valueOf(j), 0, null);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.orderGameApkResult(String.valueOf(j), 1, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof qc5)) {
                this.a.timerData = (qc5) customResponsedMessage.getData();
                if (!this.a.timerData.c()) {
                    return;
                }
                this.a.handlerWebViewResume();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.mWebView.loadUrl(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(TBWebViewActivity tBWebViewActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (!(responsedMessage instanceof ResponeDelAllUserDataHttpResMsg) && !(responsedMessage instanceof ResponseDelAllUserDataSocketMessage)) {
                    return;
                }
                pw4.c().e(responsedMessage.hasError(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(TBWebViewActivity tBWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity, Integer.valueOf(i)};
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
            this.a = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.jsBridge.i(this.a.mWebView, "writePostSuccess", new HashMap());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements YYPayResultCallback4CallJs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public t(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tbadk.browser.TBWebViewActivity.YYPayResultCallback4CallJs.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mCommonTbJsBridge != null) {
                this.a.mCommonTbJsBridge.dealJsChargeIbeanCallback();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends wj5<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity c;

        public u(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                } else if (tipEvent.pageId > 0 && this.c.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                } else {
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v implements t37 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public v(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        @Override // com.baidu.tieba.t37
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        @Override // com.baidu.tieba.t37
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        @Override // com.baidu.tieba.t37
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        @Override // com.baidu.tieba.t37
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        @Override // com.baidu.tieba.t37
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048580, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        @Override // com.baidu.tieba.t37
        public void f(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048581, this, downloadData) != null) {
                return;
            }
            this.a.notifyFileDownloadStatus(downloadData);
        }

        public /* synthetic */ v(TBWebViewActivity tBWebViewActivity, h hVar) {
            this(tBWebViewActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class y implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebViewActivity a;

        public y(TBWebViewActivity tBWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebViewActivity;
        }

        public /* synthetic */ y(TBWebViewActivity tBWebViewActivity, h hVar) {
            this(tBWebViewActivity);
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) != null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                return;
            }
            this.a.startActivity(intent);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1602771595, "Lcom/baidu/tbadk/browser/TBWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1602771595, "Lcom/baidu/tbadk/browser/TBWebViewActivity;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        mShareToTypes = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        mShareToTypes.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        mShareToTypes.put(Share.QQDENGLU, "qq_zone");
        mShareToTypes.put(Share.SINAWEIBO, "sina_weibo");
        mShareToTypes.put(Share.QQWEIBO, "qq_weibo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        InterceptResult invokeV;
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null || (hitTestResult = bridgeWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.mOnDialogItemClickListener == null) {
                this.mOnDialogItemClickListener = new w(this);
            }
            this.mOnDialogItemClickListener.c(hitTestResult.getExtra());
            createListMenu(this.mOnDialogItemClickListener.b(), this.mOnDialogItemClickListener, false);
            showListMenu();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void handlerWebViewResumeByNew() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65574, this) != null) || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long o2 = f55.m().o(f55.q("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(o2);
            if (o2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put("resultCode", 1);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", jSONObject.toString());
            this.mCommonTbJsBridge.dealSpringFestivalTimer(linkedHashMap);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void notifyH5Show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            this.mView.n();
            StringBuilder sb = new StringBuilder();
            sb.append("(function() {");
            sb.append("var event = new CustomEvent('webViewDidAppear', {'detail': {appearURL: ");
            sb.append(JSONObject.quote(this.mUrl));
            sb.append("}});");
            sb.append("document.dispatchEvent(event)");
            sb.append("})();");
            PrintStream printStream = System.out;
            printStream.println("steven js " + sb.toString());
            this.mWebView.evaluateJavascript(sb.toString(), null);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && !StringUtils.isNull(this.mShareParams)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mShareParams);
                ShareItem createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"));
                this.shareItem.L0 = GroupInfoData.fromJsonH5(jSONObject);
                jg.a().post(new l(this, createShareContent));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null) {
                return false;
            }
            if (this.useCustomHistoryStack) {
                if (this.historyStack.isEmpty() || this.historyStack.size() == 1) {
                    return false;
                }
                this.historyStack.pop();
                this.mWebView.loadUrl(this.historyStack.pop());
                return true;
            } else if (!bridgeWebView.canGoBack()) {
                return false;
            } else {
                this.mWebView.goBack();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public TBWebViewActivity() {
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
        this.mWebView = null;
        this.webContainer = null;
        this.mOfflineErrorType = 0;
        this.mModuleName = "none";
        this.mVersion = "0.0.0.0";
        this.firstEnter = true;
        this.jsCallback = new h(this);
        this.mShowShareItem = true;
        this.mPageType = "normal";
        this.mPageTranslucent = "normal";
        this.loadMyself = false;
        this.needTextAutoSize = false;
        this.historyStack = new Stack<>();
        this.mLoadingStyle = 0;
        this.mLoadingSwitch = 0;
        this.useWebPool = false;
        this.currentPageKey = "";
        this.mOrderCallback = new n(this);
        this.mSetShareInfoListener = new o(this, 2016566);
        this.mSpringFestivalTimerListener = new p(this, 2156673);
        this.mSelfLoadJsListener = new q(this, 2921434);
        this.delAllUserDataListener = new r(this, CmdConfigHttp.CMD_HTTP_ONEKEY_DELETION_HISTORY, 309736);
        this.mWritePostNotificationH5SuccessListener = new s(this, 2921786);
        this.mYYyPayResultCallback4CallJs = new YYPayResultCallback4CallJs(new t(this));
        this.mTipsEventListener = new u(this);
        this.mTopToastEventListener = new a(this);
        this.shareDialogRunnable = new d(this);
        this.isShowFullScreen = false;
        this.viewDesRunnable = new e(this);
        this.htmlLoadMessageListener = new g(this, 2921023);
        this.mDialogStatusListener = new i(this, 2921798);
        this.mSharePage = new j(this, 2921331);
        this.mInstallListener = new k(this, 2002504);
    }

    private void parserIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65578, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.mPageTranslucent = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.mLoadingStyle = intent.getIntExtra(WebViewActivityConfig.TAG_LOADING_STYLE, 0);
        this.mLoadingSwitch = intent.getIntExtra(WebViewActivityConfig.TAG_SHOW_LOADING_SWITCH, 0);
        this.mDialogName = intent.getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME);
        this.loadMyself = intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        this.needTextAutoSize = intent.getBooleanExtra(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false);
        this.useCustomHistoryStack = intent.getBooleanExtra(TbWebViewActivityConfig.KEY_USE_CUSTOM_HISTORY_STACK, false);
        this.mTranslucentAutoClose = intent.getBooleanExtra(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.currentPageKey = ps5.c(stringExtra, "page_key=");
        if (lr5.a(stringExtra).booleanValue()) {
            this.isNewHotTopicView = true;
            setNeedViewShowLoading(false);
            getPageStayDurationItem().D(lr5.c(stringExtra));
        }
        if (hi.isEquals(ps5.c(stringExtra, WebViewActivityConfig.PAGE_TYPE), WebViewActivityConfig.TAG_NEW_GOD_INVITE)) {
            setNeedViewShowLoading(false);
        }
        Uri parse = Uri.parse(stringExtra);
        if (parse == null) {
            return;
        }
        try {
            this.mPageType = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.mPageFrom = ps5.d(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.mWebViewCloseReceiver = webViewBroadcastReceiver;
                webViewBroadcastReceiver.register(this);
            }
        } catch (Exception unused2) {
        }
        try {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                BdUniDispatchSchemeController.getInstance().parseWebViewScheme(uri);
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            sendFinishMessage();
            super.onDestroy();
            wc9 wc9Var = this.mProxy;
            if (wc9Var != null) {
                wc9Var.h();
                this.mProxy = null;
            }
            if (this.shareDialogRunnable != null) {
                jg.a().removeCallbacks(this.shareDialogRunnable);
            }
            if (this.viewDesRunnable != null) {
                jg.a().removeCallbacks(this.viewDesRunnable);
            }
            checkH5PersonlizedSwitch();
            CommonTbJsBridge commonTbJsBridge = this.mCommonTbJsBridge;
            if (commonTbJsBridge != null) {
                commonTbJsBridge.onDestroy();
            }
            WebViewBroadcastReceiver webViewBroadcastReceiver = this.mWebViewCloseReceiver;
            if (webViewBroadcastReceiver != null) {
                webViewBroadcastReceiver.unregister();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.setVisibility(8);
                this.mWebView.destroy();
                this.mWebView = null;
            }
            unRegisterResponsedEventListener();
            MessageManager.getInstance().unRegisterListener(this.htmlLoadMessageListener);
            MessageManager.getInstance().unRegisterListener(this.mSharePage);
            MessageManager.getInstance().unRegisterListener(this.mSetShareInfoListener);
            MessageManager.getInstance().unRegisterListener(this.mSpringFestivalTimerListener);
            MessageManager.getInstance().unRegisterListener(this.mSelfLoadJsListener);
            MessageManager.getInstance().unRegisterListener(this.delAllUserDataListener);
            MessageManager.getInstance().unRegisterListener(this.mInstallListener);
            MessageManager.getInstance().unRegisterListener(this.mWritePostNotificationH5SuccessListener);
            MessageManager.getInstance().unRegisterListener(this.mDialogStatusListener);
            this.mYYyPayResultCallback4CallJs.onDestroy();
            if (this.webContainer != null) {
                ys5.d(getApplicationContext(), this.webContainer.b, null);
            }
            CommonTbJsBridge commonTbJsBridge2 = this.mCommonTbJsBridge;
            if (commonTbJsBridge2 != null && this.mDownloadStatusCallback != null) {
                commonTbJsBridge2.getTbDownloadManager().g(this.mDownloadStatusCallback);
            }
        }
    }

    private void choosePrivateIm(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65567, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH);
        HashMap hashMap = new HashMap();
        hashMap.put("private_msg", parcelableArrayListExtra);
        if (this.mCommonTbJsBridge != null) {
            this.jsBridge.i(this.mWebView, "goToSelectPrivateMsgPage", hashMap);
        }
    }

    private void selectReportThemeTid(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65580, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (stringArrayListExtra != null) {
            linkedHashMap.put("tid", stringArrayListExtra);
        }
        if (this.mCommonTbJsBridge != null) {
            this.jsBridge.i(this.mWebView, "goToReportThreadPage", linkedHashMap);
        }
    }

    private void sendCompleteTask(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65581, this, str) == null) && !hi.isEmpty(str)) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
            completeTaskReqMsg.completeId = str;
            sendMessage(completeTaskReqMsg);
        }
    }

    private void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65582, this, str) != null) || !"live".equals(this.mPageFrom)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("DetailLifecycle", str);
        intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
        sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
    }

    public void addJsPromptInterface(dq9 dq9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq9Var) == null) && dq9Var != null) {
            this.jsBridge.a(dq9Var);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.jsBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.jsBridge.i(this.mWebView, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast("onStart");
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            handleError();
        }
    }

    public void refreshTitle(String str) {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, str) != null) || this.mFixTitle) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.mUrlTitle = str;
        }
        if (!this.isShowFullScreen && (xt4Var = this.mView) != null) {
            xt4Var.G(this.mUrlTitle);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setNeedViewShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            super.setNeedViewShowLoading(z);
        }
    }

    public void setRefreshPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isNeedRefresh = z;
        }
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, valueCallback) == null) {
            this.mUploadMessage = valueCallback;
        }
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, valueCallback) == null) {
            this.mUploadMessageAboveL = valueCallback;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        BridgeWebView bridgeWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) && (bridgeWebView = this.mWebView) != null) {
            bridgeWebView.addJavascriptInterface(obj, str);
        }
    }

    private dq9 buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, dq9.class, getPageContext());
            if (runTask != null && runTask.getData() != null) {
                return (dq9) runTask.getData();
            }
            return null;
        }
        return (dq9) invokeV.objValue;
    }

    private void checkH5PersonlizedSwitch() {
        CommonTbJsBridge commonTbJsBridge;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && (commonTbJsBridge = this.mCommonTbJsBridge) != null && (i2 = commonTbJsBridge.getmH5PersonalizedRecSwitch()) != -1 && i2 != TbSingleton.getInstance().getPersonalizedRecSwitch()) {
            TbSingleton.getInstance().personalizedRecSwitchChanged = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
        }
    }

    public void handleError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                this.mUrl = bridgeWebView.getUrl();
                this.mWebView.stopLoading();
            }
            hideProgressBar();
            if (isTranslucent()) {
                if (this.mTranslucentAutoClose) {
                    finish();
                    return;
                }
                BridgeWebView bridgeWebView2 = this.mWebView;
                if (bridgeWebView2 != null) {
                    bridgeWebView2.setVisibility(8);
                    return;
                }
                return;
            }
            showNoDataView();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null) {
                return;
            }
            try {
                bridgeWebView.onPause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            handlerWebViewPause();
            callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
            MessageManager.getInstance().unRegisterTask(2016568);
            ItemCardHelper.w(null);
            cq9 cq9Var = this.jsBridge;
            if (cq9Var != null) {
                cq9Var.i(this.mWebView, CommonTbJsBridge.RE_HIDE, null);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            cq9 cq9Var = this.jsBridge;
            if (cq9Var != null) {
                cq9Var.h();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                jg.a().postDelayed(this.viewDesRunnable, ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    private void chooseImageFromAlbum(Intent intent) {
        String stringExtra;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65566, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(stringExtra);
        writeImagesInfo.updateQuality();
        LinkedList linkedList = new LinkedList();
        if (writeImagesInfo.getChosedFiles() != null) {
            Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ImageUploadResult.picInfo picinfo = next.serverPicInfo;
                    if (picinfo != null && (picDetailedInfo = picinfo.originPic) != null) {
                        linkedHashMap.put("url", picDetailedInfo.picUrl);
                    }
                    linkedHashMap.put("identifier", next.getFilePath());
                    linkedList.add(linkedHashMap);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("array", linkedList);
        if (this.mCommonTbJsBridge != null) {
            this.jsBridge.i(this.mWebView, "selectPhotoAlbum", linkedHashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFileDownloadStatus(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65576, this, downloadData) == null) && downloadData != null && vp6.e(downloadData.getSource()) && this.jsBridge != null && this.mCommonTbJsBridge != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("status", Integer.valueOf(downloadData.getStatus()));
            linkedHashMap.put("source", Integer.valueOf(downloadData.getSource()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, downloadData.getStatusMsg());
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, Long.valueOf(downloadData.getLength()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, Long.valueOf(downloadData.getSize()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_URL, downloadData.getUrl());
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME, downloadData.getName());
            this.jsBridge.i(this.mWebView, CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT, linkedHashMap);
        }
    }

    public void jumpToEditHeadActivity(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
        writeImagesInfo.parseJson(stringExtra);
        writeImagesInfo.updateQuality();
        if (!ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, true);
            editHeadActivityConfig.setWaterMaskType(3);
            editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
            editHeadActivityConfig.setNeedPaste(false);
            editHeadActivityConfig.setUserGrowthTask(TbSingleton.getInstance().getUserGrowthTaskListData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
        }
    }

    private String getLocalUrlByUrl(String str) {
        InterceptResult invokeL;
        String str2;
        Iterator<String> it;
        String str3;
        Iterator<String> it2;
        String str4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) {
            String str5 = str;
            HashMap hashMap = new HashMap();
            String str6 = null;
            try {
                URL url = new URL(str5);
                zc9 d2 = yc9.a().d(url.getPath());
                if (d2 == null) {
                    try {
                        if (yc9.a().b() != null) {
                            this.mOfflineErrorType = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    int i2 = 2;
                    int i3 = 0;
                    try {
                        if (!d2.e) {
                            this.mOfflineErrorType = 4;
                            u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str5, "hybridName", d2.b, "hybridVersion", this.mVersion, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String p2 = xc9.n().p(d2.b);
                            if (!TextUtils.isEmpty(d2.b) && !TextUtils.isEmpty(d2.c) && !TextUtils.isEmpty(p2)) {
                                this.mModuleName = xc9.y(true, d2.b);
                                this.mVersion = xc9.y(false, p2);
                                String str7 = xc9.n().m() + "/" + d2.b + "/" + p2 + "/";
                                String str8 = d2.c;
                                if (!d2.c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str8 = d2.c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str9 = str7 + str8;
                                File file = new File(str9);
                                ArrayList<String> arrayList = d2.d;
                                if (!str9.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.mOfflineErrorType = 2;
                                        u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "path not found");
                                        d2.e = false;
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        d2.e = false;
                                        return null;
                                    } else {
                                        for (String str10 : arrayList) {
                                            if (StringUtils.isNull(str10)) {
                                                u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "static file path is null");
                                                this.mOfflineErrorType = 1;
                                                d2.e = false;
                                                return null;
                                            } else if (!new File(str7, str10).exists()) {
                                                this.mOfflineErrorType = 1;
                                                u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str10, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "bundle incomplete");
                                                d2.e = false;
                                                return null;
                                            }
                                        }
                                    }
                                }
                                String query = url.getQuery();
                                if (!d2.f) {
                                    str5 = "file://" + str7 + str8;
                                    try {
                                        if (!TextUtils.isEmpty(query)) {
                                            str5 = str5 + "?" + query;
                                        }
                                    } catch (MalformedURLException unused2) {
                                        str6 = str5;
                                        return str6;
                                    }
                                }
                                if (d2.a != null && d2.a.size() != 0) {
                                    String str11 = "&";
                                    if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                        int length = split.length;
                                        int i4 = 0;
                                        while (i4 < length) {
                                            String[] split2 = split[i4].split("=");
                                            if (split2 != null && split2.length == i2) {
                                                hashMap.put("{" + split2[0] + "}", split2[1]);
                                            }
                                            i4++;
                                            i2 = 2;
                                        }
                                    }
                                    hashMap.put("{client_version}", TbConfig.getVersion());
                                    hashMap.put("{client_type}", "2");
                                    if (TbSingleton.getInstance().getSyncYYSwitch()) {
                                        str2 = "1";
                                    } else {
                                        str2 = "0";
                                    }
                                    hashMap.put("{is_yy_user}", str2);
                                    Iterator<String> it3 = d2.a.iterator();
                                    while (it3.hasNext()) {
                                        String next = it3.next();
                                        StringBuilder sb = new StringBuilder();
                                        String query2 = new URL(next).getQuery();
                                        if (!TextUtils.isEmpty(query2)) {
                                            String[] split3 = query2.split(str11);
                                            if (split3 != null) {
                                                int length2 = split3.length;
                                                boolean z = true;
                                                while (i3 < length2) {
                                                    String str12 = split3[i3];
                                                    if (!z) {
                                                        sb.append(str11);
                                                    } else {
                                                        z = false;
                                                    }
                                                    String[] split4 = str12.split("=");
                                                    if (split4 != null) {
                                                        it2 = it3;
                                                        str4 = str11;
                                                        if (split4.length == 2) {
                                                            String str13 = (String) hashMap.get(split4[1]);
                                                            if (str13 == null) {
                                                                str13 = split4[1];
                                                                if (str13.contains("{") && str13.contains("}")) {
                                                                    str13 = null;
                                                                }
                                                            }
                                                            sb.append(split4[0]);
                                                            sb.append("=");
                                                            if (!TextUtils.isEmpty(str13)) {
                                                                sb.append(str13);
                                                            }
                                                            i3++;
                                                            it3 = it2;
                                                            str11 = str4;
                                                        }
                                                    } else {
                                                        it2 = it3;
                                                        str4 = str11;
                                                    }
                                                    i3++;
                                                    it3 = it2;
                                                    str11 = str4;
                                                }
                                            }
                                            it = it3;
                                            str3 = str11;
                                            String sb2 = sb.toString();
                                            if (!TextUtils.isEmpty(sb2)) {
                                                next = next.replace(query2, sb2);
                                            }
                                        } else {
                                            it = it3;
                                            str3 = str11;
                                        }
                                        QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                                        quickWebViewBridgeData.type = "get";
                                        quickWebViewBridgeData.url = next;
                                        quickWebViewBridgeData.module = d2.b;
                                        quickWebViewBridgeData.begin = System.currentTimeMillis();
                                        if (this.mProxy != null) {
                                            this.mProxy.j(quickWebViewBridgeData, null);
                                        }
                                        it3 = it;
                                        str11 = str3;
                                        i3 = 0;
                                    }
                                    return str5;
                                }
                                return str5;
                            }
                            d2.e = false;
                            return null;
                        } catch (MalformedURLException unused3) {
                            str5 = null;
                        }
                    } catch (MalformedURLException unused4) {
                        str6 = null;
                    }
                }
            } catch (MalformedURLException unused5) {
            }
            return str6;
        }
        return (String) invokeL.objValue;
    }

    private void handleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65570, this, intent, i2) != null) || !this.mShareResultToFe) {
            return;
        }
        boolean z = false;
        this.mShareResultToFe = false;
        if (intent == null) {
            return;
        }
        String str = mShareToTypes.get(intent.getStringExtra("share_to"));
        HashMap hashMap = new HashMap();
        if (i2 == -1) {
            z = true;
        }
        hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.mBid);
        hashMap.put("result", Boolean.valueOf(z));
        hashMap.put("channel", str);
        k45 j2 = k45.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
        j45 j45Var = this.mHybridBridge;
        if (j45Var != null) {
            j45Var.c(j2);
        }
        if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1) {
            this.mWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    private void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65571, this, intent, i2) != null) || i2 != -1 || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("originalUrl", next.serverPicInfo.originPic.picUrl);
                    jSONObject.put("originalWidth", next.serverPicInfo.originPic.width);
                    jSONObject.put("originalHeight", next.serverPicInfo.originPic.height);
                    jSONObject.put("photoUrl", next.serverPicInfo.bigPic.picUrl);
                    jSONObject.put("photoWidth", next.serverPicInfo.bigPic.width);
                    jSONObject.put("photoHeight", next.serverPicInfo.bigPic.height);
                    jSONObject.put("photoThumbUrl", next.serverPicInfo.smallPic.picUrl);
                    jSONObject.put("filePath", next.getFilePath());
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put(TbConfig.LOCAL_PIC_DIR, jSONArray);
            k45 j2 = k45.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.mHybridBridge != null) {
                this.mHybridBridge.c(j2);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void newHandleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65575, this, intent, i2) != null) || this.mShareItem == null) {
            return;
        }
        if (i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap.put("shareStatus", Integer.valueOf(intExtra));
                    linkedHashMap.put("shareItem", this.mShareItem);
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
                }
            }
            if (intExtra == 3 && (intExtra2 == 8 || intExtra2 == 6 || intExtra2 == 4)) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap2.put("shareStatus", 1);
                    linkedHashMap2.put("shareItem", this.mShareItem);
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
                }
            }
            if (intExtra == 2) {
                sendCompleteTask(stringExtra);
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("shareChannel", Integer.valueOf(intExtra2));
                linkedHashMap3.put("shareStatus", Integer.valueOf(intExtra));
                linkedHashMap3.put("shareItem", this.mShareItem);
                yf6.a().d(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap3);
            }
        } else if (i2 == 0) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("shareChannel", 1);
            linkedHashMap4.put("shareStatus", 2);
            linkedHashMap4.put("shareItem", this.mShareItem);
            yf6.a().d(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap4);
        }
    }

    private void handlerWebViewPause() {
        qc5 qc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65572, this) == null) && (qc5Var = this.timerData) != null && qc5Var.c()) {
            this.timerData.d();
            f55.m().A(f55.q("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    private void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new m(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65584, this) == null) && (xt4Var = this.mView) != null) {
            xt4Var.F();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (isTranslucent()) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!isTranslucent() && !this.mIsFromSchema) {
                super.enterExitAnimation();
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.finish();
            sendDetailBroadcast(MissionEvent.MESSAGE_STOP);
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                ug6.d(bridgeWebView);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tieba.fm5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.isNewHotTopicView) {
                return "a077";
            }
            if (!StringUtils.isNull(this.currentPageKey)) {
                return this.currentPageKey;
            }
            return super.getCurrentPageKey();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mShareInfo;
        }
        return (String) invokeV.objValue;
    }

    public ValueCallback<Uri> getUploadMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mUploadMessage;
        }
        return (ValueCallback) invokeV.objValue;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mUploadMessageAboveL;
        }
        return (ValueCallback) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mWebView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            pt4.j(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean needDealClickGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.isDisableGoBack || this.mCommonTbJsBridge == null) {
                return false;
            }
            this.jsBridge.i(this.mWebView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
            this.isDisableGoBack = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    public void onReceivedTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            handleError();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.isShowFullScreen = true;
            if (1 != 0 && this.mView != null) {
                runOnUiThread(new f(this));
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setSkinOverly() {
        BridgeWebView bridgeWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (bridgeWebView = this.mWebView) != null) {
            bridgeWebView.setWebViewSkinOverly(this.mUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        qc5 qc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65573, this) != null) || (qc5Var = this.timerData) == null || !qc5Var.c() || this.timerData.b() || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            this.timerData.e(true);
            long currentTimeMillis = System.currentTimeMillis();
            long o2 = f55.m().o(f55.q("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(o2);
            if (o2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put("resultCode", 1);
            this.mCommonTbJsBridge.dealSpringFestivalTimer(this.timerData.a(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void sendFinishMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains(UrlSchemaHelper.SIGN_FRS_DIALOG)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921738, null));
            }
            if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains(UrlSchemaHelper.VIRTUAL_IMAGE_MAIN_URL)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921504, null));
            }
            if (!TextUtils.isEmpty(this.mDialogName)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921753, this.mDialogName));
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            if (this.mWebView == null) {
                return;
            }
            try {
                if (getUploadMessageAboveL() != null) {
                    getUploadMessageAboveL().onReceiveValue(null);
                    setUploadMessageAboveL(null);
                }
                this.mWebView.onResume();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            handlerWebViewResume();
            handlerWebViewResumeByNew();
            callHiddenWebViewMethod("onResume");
            registerGetShareContentTask();
            ItemCardHelper.w(this.mOrderCallback);
            cq9 cq9Var = this.jsBridge;
            if (cq9Var != null) {
                cq9Var.i(this.mWebView, CommonTbJsBridge.RE_SHOW, null);
                if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.firstEnter) {
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.firstEnter = false;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mWebView == null) {
                String a2 = ys5.a(this.mUrl);
                if (a2 != null) {
                    ws5 c2 = xs5.b().c(this, a2);
                    this.webContainer = c2;
                    if (c2 != null && c2.a()) {
                        WebView webView = this.webContainer.a;
                        if (webView instanceof BridgeWebView) {
                            BridgeWebView bridgeWebView = (BridgeWebView) webView;
                            this.mWebView = bridgeWebView;
                            bridgeWebView.setVisibility(4);
                            this.useWebPool = true;
                        }
                    }
                }
                if (!this.useWebPool || this.mWebView == null) {
                    this.mWebView = new BridgeWebView(getPageContext().getPageActivity());
                }
                ys5.b(this.mWebView);
                this.mWebView.setWebViewClient(new x(this));
                this.mWebView.setDownloadListener(new y(this, null));
                this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(!this.isAutoPlayVideo);
                if (isTranslucent()) {
                    this.mWebView.setBackgroundColor(0);
                }
                if (!isTranslucent()) {
                    this.mWebView.getSettings().setSupportZoom(true);
                    this.mWebView.getSettings().setBuiltInZoomControls(true);
                    this.mWebView.getSettings().setUseWideViewPort(true);
                }
                if (this.needTextAutoSize) {
                    this.mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
                    this.mWebView.getSettings().setLoadWithOverviewMode(true);
                }
                if (!isTranslucent()) {
                    this.mWebView.setInitialScale(100);
                    this.mWebView.setScrollBarStyle(33554432);
                }
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
                tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
                this.mWebView.setWebChromeClient(tbWebChromeClient);
                fv9.b().g(this, this.mWebView, tbWebChromeClient);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                }
                CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                BridgeWebView bridgeWebView2 = this.mWebView;
                j45 m2 = WebViewBridge.m(isHybridBridgeEnabled, bridgeWebView2, bridgeWebView2.getWebViewClient(), this.mWebView.getChromeClient());
                this.mHybridBridge = m2;
                if (isHybridBridgeEnabled) {
                    m2.d(new NamedBridgeHandler(this, m2) { // from class: com.baidu.tbadk.browser.TBWebViewActivity.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TBWebViewActivity this$0;

                        @l45(isAsync = false, value = "trackFPS")
                        private void trackFPS() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                            }
                        }

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV2.objValue;
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(m2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, m2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((j45) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }
                    });
                    m2.d(new ClipboardBridgeHandler(m2));
                    m2.d(new ImageOperateBridgeHandler(m2));
                    m2.d(new FocusFeedBridgeHandler(m2));
                    m2.d(new NamedBridgeHandler(this, m2) { // from class: com.baidu.tbadk.browser.TBWebViewActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TBWebViewActivity this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV2.objValue;
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(m2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, m2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((j45) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @l45(isAsync = false, value = "share")
                        private void share(JSONObject jSONObject) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                                return;
                            }
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_BID);
                            if (!StringUtils.isNULL(optString5)) {
                                TBWebViewActivity tBWebViewActivity = this.this$0;
                                tBWebViewActivity.mShareResultToFe = true;
                                tBWebViewActivity.mBid = optString5;
                            }
                            TBWebViewActivity tBWebViewActivity2 = this.this$0;
                            tBWebViewActivity2.shareItem = tBWebViewActivity2.createShareContent(optString, optString4, optString2, optString3);
                            this.this$0.shareItem.L0 = GroupInfoData.fromJsonH5(jSONObject);
                            jg.a().post(this.this$0.shareDialogRunnable);
                        }
                    });
                    m2.d(new NamedBridgeHandler(this, m2) { // from class: com.baidu.tbadk.browser.TBWebViewActivity.13
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TBWebViewActivity this$0;

                        @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                        public String scope() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV2.objValue;
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(m2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, m2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((j45) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @l45(isAsync = false, value = "viewHideSwitch")
                        private void viewHideSwitch(JSONObject jSONObject) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                                return;
                            }
                            String optString = jSONObject.optJSONObject("share").optString("value");
                            if (!"1".equals(optString)) {
                                if ("0".equals(optString)) {
                                    this.this$0.mShowShareItem = false;
                                }
                            } else {
                                this.this$0.mShowShareItem = true;
                            }
                            TBWebViewActivity tBWebViewActivity = this.this$0;
                            tBWebViewActivity.mView.J(tBWebViewActivity.mShowShareItem);
                        }
                    });
                    m2.d(new HybridUtilsBridgeHandler(m2));
                }
                this.mWebView.setOnLongClickListener(new b(this));
                this.mWebView.setOnScrollChangeListener(new c(this));
                BridgeWebView bridgeWebView3 = this.mWebView;
                if (bridgeWebView3 != null) {
                    bridgeWebView3.setBackgroundColor(0);
                }
                BridgeWebView bridgeWebView4 = this.mWebView;
                if (bridgeWebView4 != null) {
                    bridgeWebView4.registerPerformanceTracker(new TbChannelJsInterface(this.createdTime));
                }
            }
            return this.mWebView;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0166  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        String str2;
        boolean z;
        String str3;
        String str4;
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            String str5 = str;
            if (this.mWebView.getVisibility() != 0) {
                this.mWebView.setVisibility(0);
            }
            if (this.isShowFullScreen && (xt4Var = this.mView) != null) {
                xt4Var.x();
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().a;
                String str6 = null;
                for (String str7 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str7) && str5.contains(str7)) {
                        str6 = str7;
                    }
                }
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(hashMap.get(str6))) {
                    String str8 = hashMap.get(str6);
                    Uri parse = Uri.parse(str);
                    if (!TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getHost())) {
                        str4 = parse.getScheme() + "://" + parse.getHost();
                    } else {
                        str4 = "";
                    }
                    if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str4)) {
                        str5 = str5.replace(str4, str8);
                    }
                }
            }
            if (!str5.contains("javascript:")) {
                u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str5);
                if (str5.length() > 100) {
                    str2 = str5.substring(0, 100);
                } else {
                    str2 = str5;
                }
                if (QuickWebViewSwitch.getInOn() && !xc9.s(str5)) {
                    String localUrlByUrl = getLocalUrlByUrl(str5);
                    if (!TextUtils.isEmpty(localUrlByUrl)) {
                        u45.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "success");
                        str5 = localUrlByUrl;
                        z = true;
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
                        if (!z) {
                            str3 = "1";
                        } else {
                            str3 = "2";
                        }
                        TiebaStatic.log(statisticItem.param("obj_locate", str3).param("obj_source", str2).param("obj_type", this.mOfflineErrorType).param("obj_name", xc9.h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                        this.mOfflineErrorType = 0;
                        this.mModuleName = "none";
                        this.mVersion = "0.0.0.0";
                        u45.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str2, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.mOfflineErrorType = 5;
                }
                z = false;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL);
                if (!z) {
                }
                TiebaStatic.log(statisticItem2.param("obj_locate", str3).param("obj_source", str2).param("obj_type", this.mOfflineErrorType).param("obj_name", xc9.h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mModuleName = "none";
                this.mVersion = "0.0.0.0";
                u45.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", str2, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.mWebView != null) {
                if (this.mCommonTbJsBridge != null) {
                    this.mCommonTbJsBridge.setLastLoadUrlTime(System.currentTimeMillis());
                }
                if (this.useWebPool) {
                    notifyH5Show();
                } else if (this.loadMyself) {
                    this.mWebView.loadUrl(str5);
                } else {
                    CompatibleUtile.getInstance().loadUrl(this.mWebView, str5);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        BridgeWebView bridgeWebView;
        Uri uri;
        Uri[] uriArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
            if (i2 == 1) {
                if (i3 == -1) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (getUploadMessageAboveL() == null) {
                            return;
                        }
                        if (intent != null) {
                            String dataString = intent.getDataString();
                            ClipData clipData = intent.getClipData();
                            if (clipData != null) {
                                uriArr = new Uri[clipData.getItemCount()];
                                for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                                    uriArr[i4] = clipData.getItemAt(i4).getUri();
                                }
                            } else {
                                uriArr = null;
                            }
                            if (dataString != null) {
                                uriArr = new Uri[]{Uri.parse(dataString)};
                            }
                        } else {
                            uriArr = null;
                        }
                        if (uriArr != null) {
                            getUploadMessageAboveL().onReceiveValue(uriArr);
                        }
                        setUploadMessageAboveL(null);
                    } else if (getUploadMessage() != null) {
                        if (intent != null && i3 == -1) {
                            uri = intent.getData();
                        } else {
                            uri = null;
                        }
                        getUploadMessage().onReceiveValue(uri);
                        setUploadMessage(null);
                    }
                }
            } else if (i2 != 11043) {
                if (i2 != 12002) {
                    if (i2 != 12009) {
                        if (i2 != 12015) {
                            if (i2 != 21002) {
                                if (i2 != 24007) {
                                    if (i2 != 25042) {
                                        if (i2 != 25045) {
                                            if (i2 != 25070) {
                                                if (i2 != 220010) {
                                                    if (i2 != 25073) {
                                                        if (i2 != 25074) {
                                                            switch (i2) {
                                                                case 12017:
                                                                    chooseImageFromAlbum(intent);
                                                                    return;
                                                                case 12018:
                                                                    selectReportThemeTid(intent);
                                                                    return;
                                                                case 12019:
                                                                    choosePrivateIm(intent);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                        } else if (i3 == -1 && intent != null) {
                                                            HashMap hashMap = new HashMap();
                                                            hashMap.put("tailId", intent.getStringExtra("tailId"));
                                                            hashMap.put("tailColor", intent.getStringExtra("tailColor"));
                                                            hashMap.put("tailContent", intent.getStringExtra("tailContent"));
                                                            this.jsBridge.i(this.mWebView, CommonTbJsBridge.REFRESH_TAIL, hashMap);
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i3 == -1) {
                                                        this.jsBridge.i(this.mWebView, CommonTbJsBridge.OPEN_VIP_SUCCESS, null);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (-1 == i3 && (bridgeWebView = this.mWebView) != null) {
                                                    bridgeWebView.reload();
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.jsBridge.i(this.mWebView, CommonTbJsBridge.RE_SHOW, null);
                                            return;
                                        }
                                        BridgeWebView bridgeWebView2 = this.mWebView;
                                        if (bridgeWebView2 != null) {
                                            bridgeWebView2.reload();
                                            return;
                                        }
                                        return;
                                    } else if (-1 == i3) {
                                        finish();
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                handleShareResult(intent, i3);
                                newHandleShareResult(intent, i3);
                                return;
                            } else if (i3 == -1 && this.mHybridBridge != null) {
                                HashMap hashMap2 = new HashMap(4);
                                hashMap2.put("errNo", "0");
                                hashMap2.put(StatConstants.KEY_EXT_ERR_MSG, "success");
                                k45 j2 = k45.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
                                j45 j45Var = this.mHybridBridge;
                                if (j45Var != null) {
                                    j45Var.c(j2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        handleUploadResult(intent, i3);
                        return;
                    } else if (intent != null) {
                        Serializable serializableExtra = intent.getSerializableExtra("pic_info");
                        if (serializableExtra instanceof PhotoUrlData) {
                            PhotoUrlData photoUrlData = (PhotoUrlData) serializableExtra;
                            if (this.mCommonTbJsBridge != null) {
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                linkedHashMap.put("url", photoUrlData.getOriginPic());
                                this.jsBridge.i(this.mWebView, "GetPhotoAlbum", linkedHashMap);
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                jumpToEditHeadActivity(intent);
            } else if (-1 == i3) {
                if (this.mCommonTbJsBridge != null && intent != null) {
                    int intExtra = intent.getIntExtra("social_type", 0);
                    String stringExtra = intent.getStringExtra("activity_id");
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("social_type", Integer.valueOf(intExtra));
                    linkedHashMap2.put("activityId", stringExtra);
                    linkedHashMap2.put("isLogin", Boolean.TRUE);
                    linkedHashMap2.put("resultCode", 1);
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap2);
                    this.jsBridge.i(this.mWebView, "commonLogin", linkedHashMap2);
                    return;
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("resultCode", 0);
                linkedHashMap3.put("isLogin", Boolean.FALSE);
                this.jsBridge.i(this.mWebView, "commonLogin", linkedHashMap3);
            } else {
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("resultCode", 0);
                linkedHashMap4.put("isLogin", Boolean.FALSE);
                this.jsBridge.i(this.mWebView, "commonLogin", linkedHashMap4);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            this.mYYyPayResultCallback4CallJs.onCreate();
            parserIntent();
            boolean equals = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageTranslucent);
            boolean equals2 = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType);
            if (!equals && !equals2) {
                z = false;
            } else {
                z = true;
            }
            setIsTranslucent(z);
            if (isTranslucent()) {
                setNeedViewShowLoading(false);
                getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f100146);
            }
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            xt4 xt4Var = this.mView;
            if (xt4Var != null) {
                if (this.mLoadingSwitch == 1) {
                    xt4Var.H(true);
                }
                this.mView.B(this.mLoadingStyle);
            }
            MessageManager.getInstance().runTask(2001308, (Class) null);
            this.jsBridge = new cq9();
            this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
            this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(this.mCommonTbJsBridge);
            this.jsBridge.a(new UegTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
            wc9 wc9Var = new wc9(this.mWebView);
            this.mProxy = wc9Var;
            wc9Var.n(this.jsBridge);
            this.jsBridge.a(new SingleQuickWebViewBridge(this, this.mProxy));
            if (this.mNeedCookie) {
                initCookie();
            }
            registerListener(this.htmlLoadMessageListener);
            registerListener(this.mSharePage);
            registerListener(this.mSetShareInfoListener);
            registerListener(this.mSpringFestivalTimerListener);
            this.mSelfLoadJsListener.setSelfListener(true);
            registerListener(this.mSelfLoadJsListener);
            registerListener(this.delAllUserDataListener);
            registerListener(this.mInstallListener);
            registerListener(this.mWritePostNotificationH5SuccessListener);
            registerListener(this.mDialogStatusListener);
            sendDetailBroadcast("onStart");
            registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
            registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
            this.mDownloadStatusCallback = new v(this, null);
            this.mCommonTbJsBridge.getTbDownloadManager().a(this.mDownloadStatusCallback);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || this.jsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isLogin", Boolean.valueOf(z));
        this.jsBridge.i(this.mWebView, CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
        this.jsBridge.i(this.mWebView, "commonLogin", linkedHashMap);
        setRefreshPage(false);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            super.onWebViewLogin(z);
            if (this.mWebView != null) {
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    str = "1";
                } else {
                    str = "0";
                }
                try {
                    jSONObject.put("no", str);
                    loadUrl("javascript:tiebaClientLoginCallBack(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void orderGameApkResult(@NonNull String str, int i2, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048606, this, str, i2, str2) == null) && this.mCommonTbJsBridge != null && this.jsBridge != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", str);
            hashMap.put("resultCode", Integer.valueOf(i2));
            hashMap.put("name", str2);
            this.jsBridge.i(this.mWebView, "orderGameApkResult", hashMap);
        }
    }
}
