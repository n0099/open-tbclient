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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a98;
import com.repackage.at4;
import com.repackage.b98;
import com.repackage.bm4;
import com.repackage.bt4;
import com.repackage.c98;
import com.repackage.cm4;
import com.repackage.dt4;
import com.repackage.fr4;
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.ht4;
import com.repackage.jl8;
import com.repackage.kl8;
import com.repackage.ll8;
import com.repackage.lt4;
import com.repackage.mg;
import com.repackage.nd5;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.p55;
import com.repackage.pg;
import com.repackage.vl4;
import com.repackage.vz4;
import com.repackage.wl4;
import com.repackage.wt4;
import com.repackage.ys4;
import com.repackage.z88;
import com.repackage.zp8;
import com.repackage.zs4;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static final String KEY_TASK_CENTER_PREFIX_URL = "https://haokan.baidu.com/activity/";
    public static final int MAX_NUM_UPLOAD_CHAR = 100;
    public static final HashMap<String, String> mShareToTypes;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean firstEnter;
    public CustomMessageListener htmlLoadMessageListener;
    public boolean isDisableGoBack;
    public boolean isShowFullScreen;
    public jl8 jsBridge;
    public ll8 jsCallback;
    public boolean loadMyself;
    public String mBid;
    public CommonTbJsBridge mCommonTbJsBridge;
    public ys4 mHybridBridge;
    public String mModuleName;
    public int mOfflineErrorType;
    public u mOnDialogItemClickListener;
    public String mPageFrom;
    public String mPageTranslucent;
    public String mPageType;
    public PermissionJudgePolicy mPermissionJudgement;
    public z88 mProxy;
    public final CustomMessageListener mSelfLoadJsListener;
    public final CustomMessageListener mSetShareInfoListener;
    public String mShareInfo;
    public ShareItem mShareItem;
    public final CustomMessageListener mSharePage;
    public String mShareParams;
    public boolean mShowShareItem;
    public final CustomMessageListener mSpringFestivalTimerListener;
    public p55 mTipsEventListener;
    public p55 mTopToastEventListener;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageAboveL;
    public String mVersion;
    public BridgeWebView mWebView;
    public WebViewBroadcastReceiver mWebViewCloseReceiver;
    @NonNull
    public final YYPayResultCallback4CallJs mYYyPayResultCallback4CallJs;
    public vz4 timerData;

    /* loaded from: classes2.dex */
    public static class YYPayResultCallback4CallJs implements LifecycleObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final b a;
        public final CustomMessageListener b;

        /* loaded from: classes2.dex */
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                this.a.a.a();
            }
        }

        /* loaded from: classes2.dex */
        public interface b {
            void a();
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

        public static void j() {
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

    /* loaded from: classes2.dex */
    public class a extends at4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbWebViewActivity tbWebViewActivity, ys4 ys4Var) {
            super(ys4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, ys4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ys4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        @bt4(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.c.mShowShareItem = false;
            }
            TbWebViewActivity tbWebViewActivity = this.c;
            tbWebViewActivity.mView.B(tbWebViewActivity.mShowShareItem);
        }

        @Override // com.repackage.at4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends at4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbWebViewActivity tbWebViewActivity, ys4 ys4Var) {
            super(ys4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, ys4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ys4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        @bt4(isAsync = false, value = "gameComment")
        private void goToGameComment(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameCommentActivityConfig(this.c.getPageContext().getPageActivity(), jSONObject.optInt("score"), jSONObject.optInt("forum_id"))));
        }

        @Override // com.repackage.at4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_GAME_COMMENT" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends at4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbWebViewActivity tbWebViewActivity, ys4 ys4Var) {
            super(ys4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, ys4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ys4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        @bt4(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameSubPbActivityConfig(this.c.getPageContext().getPageActivity(), mg.e(optString, 0), jSONObject.optString("comment_id"))));
            }
        }

        @Override // com.repackage.at4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public d(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (TextUtils.isEmpty(this.a.mUrl) || !this.a.mUrl.contains("haokan.baidu.com/activity/")) {
                    return this.a.handleLongClick();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements BaseWebView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public e(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.j
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.mView.p(i, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public f(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
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

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public g(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mView.t();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbWebViewActivity tbWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i)};
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
            this.a = tbWebViewActivity;
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

    /* loaded from: classes2.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(TbWebViewActivity tbWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i)};
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
            this.a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.mShareParams = (String) customResponsedMessage.getData();
                this.a.showRightShareIcon();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TbWebViewActivity b;

        public j(TbWebViewActivity tbWebViewActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbWebViewActivity;
            this.a = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mView.L(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements ll8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public k(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // com.repackage.ll8
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.a.jsBridge != null) {
                    return this.a.jsBridge.b(this.a.mWebView, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class l implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public l(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
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
                        this.a.mShareItem.O = optString5;
                        this.a.mShareItem.P = optString6;
                        this.a.mShareItem.Q = optString7;
                        this.a.mShareItem.b0 = jSONObject.optInt("shareimg");
                        this.a.mShareItem.j0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    this.a.mShareItem.S = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
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

    /* loaded from: classes2.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(TbWebViewActivity tbWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i)};
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
            this.a = tbWebViewActivity;
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

    /* loaded from: classes2.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(TbWebViewActivity tbWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i)};
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
            this.a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof vz4)) {
                return;
            }
            this.a.timerData = (vz4) customResponsedMessage.getData();
            if (this.a.timerData.c()) {
                this.a.handlerWebViewResume();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(TbWebViewActivity tbWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i)};
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
            this.a = tbWebViewActivity;
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

    /* loaded from: classes2.dex */
    public class p implements YYPayResultCallback4CallJs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public p(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.YYPayResultCallback4CallJs.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mCommonTbJsBridge == null) {
                return;
            }
            this.a.mCommonTbJsBridge.dealJsChargeIbeanCallback();
        }
    }

    /* loaded from: classes2.dex */
    public class q extends p55<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        public q(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.i55
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                } else if (tipEvent.pageId <= 0 || this.c.getPageId() != tipEvent.pageId) {
                    return true;
                } else {
                    DefaultNavigationBarCoverTip.s(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class r extends p55<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        public r(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.i55
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.c.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class s extends at4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(TbWebViewActivity tbWebViewActivity, ys4 ys4Var) {
            super(ys4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, ys4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ys4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        @bt4(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            }
        }

        @Override // com.repackage.at4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class t extends at4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity c;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShareItem a;
            public final /* synthetic */ t b;

            public a(t tVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = tVar;
                this.a = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.c.mView.L(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(TbWebViewActivity tbWebViewActivity, ys4 ys4Var) {
            super(ys4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, ys4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ys4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tbWebViewActivity;
        }

        @bt4(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                TbWebViewActivity tbWebViewActivity = this.c;
                tbWebViewActivity.mShareResultToFe = true;
                tbWebViewActivity.mBid = optString5;
            }
            pg.a().post(new a(this, this.c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // com.repackage.at4
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class u implements fr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public List<Integer> c;
        public final /* synthetic */ TbWebViewActivity d;

        /* loaded from: classes2.dex */
        public class a extends InsertGalleryAsyncTask.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(u uVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {uVar};
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
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                }
            }

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f1372);
                }
            }
        }

        public u(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tbWebViewActivity;
            this.a = 1;
            this.c = new ArrayList();
        }

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) || fr4Var != this.d.getListMenu() || i >= this.c.size() || i < 0) {
                return;
            }
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
            fr4Var.e();
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.c.clear();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f1070));
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

    /* loaded from: classes2.dex */
    public class v extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TbWebViewActivity b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v a;

            public a(v vVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = vVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.mView.r();
                }
            }
        }

        public v(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbWebViewActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                TbWebViewActivity tbWebViewActivity = this.b;
                BridgeWebView bridgeWebView = tbWebViewActivity.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.a = false;
                tbWebViewActivity.mUrl = str;
                bridgeWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.b.mWebView.getTitle();
                if (!this.b.mFixTitle && !StringUtils.isNull(title)) {
                    this.b.mUrlTitle = title;
                }
                if (!this.b.isShowFullScreen) {
                    TbWebViewActivity tbWebViewActivity2 = this.b;
                    tbWebViewActivity2.mView.z(tbWebViewActivity2.mUrlTitle);
                }
                if (this.b.isTranslucent()) {
                    this.b.mView.w(false);
                } else {
                    TbWebViewActivity tbWebViewActivity3 = this.b;
                    tbWebViewActivity3.mView.w(tbWebViewActivity3.mIsShowNavBar);
                }
                TbWebViewActivity tbWebViewActivity4 = this.b;
                tbWebViewActivity4.mView.B(tbWebViewActivity4.isNeedShowShareItem());
                if (!StringUtils.isNull(this.b.mUrl) && this.b.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.b.mView.x(8);
                }
                this.b.hideProgressBar();
                this.b.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                TbWebViewActivity tbWebViewActivity = this.b;
                if (tbWebViewActivity.mWebView == null) {
                    return;
                }
                this.a = true;
                tbWebViewActivity.mUrl = str;
                tbWebViewActivity.showProgressBar();
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
                cm4.a("TbWebViewActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            bm4 bm4Var;
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
                    TbWebViewActivity tbWebViewActivity = this.b;
                    tbWebViewActivity.mUrl = str;
                    if (tbWebViewActivity.isShowFullScreen) {
                        this.b.isShowFullScreen = false;
                        this.b.runOnUiThread(new a(this));
                    }
                    this.b.hideCrashTip();
                    if (URLUtil.isNetworkUrl(this.b.mUrl)) {
                        this.b.showProgressBar();
                        if (this.b.isShowFullScreen && (bm4Var = this.b.mView) != null) {
                            bm4Var.t();
                        }
                        return false;
                    }
                    TbWebViewActivity tbWebViewActivity2 = this.b;
                    tbWebViewActivity2.tryDeeplink(tbWebViewActivity2.mUrl);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class w implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbWebViewActivity a;

        public w(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbWebViewActivity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.a.startActivity(intent);
            }
        }

        public /* synthetic */ w(TbWebViewActivity tbWebViewActivity, k kVar) {
            this(tbWebViewActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1959008939, "Lcom/baidu/tbadk/browser/TbWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1959008939, "Lcom/baidu/tbadk/browser/TbWebViewActivity;");
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

    public TbWebViewActivity() {
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
        this.mOfflineErrorType = 0;
        this.mModuleName = "none";
        this.mVersion = "0.0.0.0";
        this.firstEnter = true;
        this.jsCallback = new k(this);
        this.mShowShareItem = true;
        this.mPageType = "normal";
        this.mPageTranslucent = "normal";
        this.isDisableGoBack = false;
        this.loadMyself = false;
        this.mSetShareInfoListener = new m(this, 2016566);
        this.mSpringFestivalTimerListener = new n(this, 2156673);
        this.mSelfLoadJsListener = new o(this, 2921434);
        this.mYYyPayResultCallback4CallJs = new YYPayResultCallback4CallJs(new p(this));
        this.mTipsEventListener = new q(this);
        this.mTopToastEventListener = new r(this);
        this.isShowFullScreen = false;
        this.htmlLoadMessageListener = new h(this, 2921023);
        this.mSharePage = new i(this, 2921331);
    }

    private kl8 buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, kl8.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (kl8) runTask.getData();
        }
        return (kl8) invokeV.objValue;
    }

    private void checkH5PersonlizedSwitch() {
        CommonTbJsBridge commonTbJsBridge;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (commonTbJsBridge = this.mCommonTbJsBridge) == null || (i2 = commonTbJsBridge.getmH5PersonalizedRecSwitch()) == -1 || i2 == TbSingleton.getInstance().getPersonalizedRecSwitch()) {
            return;
        }
        TbSingleton.getInstance().personalizedRecSwitchChanged = true;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
    }

    private void chooseImageFromAlbum(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (stringExtra != null) {
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < writeImagesInfo.getChosedFiles().size(); i2++) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("url", writeImagesInfo.getChosedFiles().get(i2).serverPicInfo.originPic.picUrl);
                linkedHashMap2.put("identifier", writeImagesInfo.getChosedFiles().get(i2).getFilePath());
                linkedList.add(linkedHashMap2);
            }
            linkedHashMap.put("array", linkedList);
            if (this.mCommonTbJsBridge != null) {
                this.jsBridge.i(this.mWebView, CommonTbJsBridge.SELECT_PHOTO_ALBUM, linkedHashMap);
            }
        }
    }

    private void choosePrivateIm(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, this, intent) == null) || intent == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH);
        HashMap hashMap = new HashMap();
        hashMap.put("private_msg", parcelableArrayListExtra);
        if (this.mCommonTbJsBridge != null) {
            this.jsBridge.i(this.mWebView, "goToSelectPrivateMsgPage", hashMap);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, str)) == null) {
            HashMap hashMap = new HashMap();
            String str5 = null;
            try {
                URL url = new URL(str);
                c98 c2 = b98.a().c(url.getPath());
                if (c2 == null) {
                    try {
                        if (b98.a().b() != null) {
                            this.mOfflineErrorType = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    int i2 = 2;
                    int i3 = 0;
                    try {
                        if (!c2.e) {
                            this.mOfflineErrorType = 4;
                            lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.b, "hybridVersion", this.mVersion, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String s2 = a98.q().s(c2.b);
                            if (!TextUtils.isEmpty(c2.b) && !TextUtils.isEmpty(c2.c) && !TextUtils.isEmpty(s2)) {
                                this.mModuleName = a98.z(true, c2.b);
                                this.mVersion = a98.z(false, s2);
                                String str6 = a98.q().p() + "/" + c2.b + "/" + s2 + "/";
                                String str7 = c2.c;
                                if (!c2.c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str7 = c2.c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str8 = str6 + str7;
                                File file = new File(str8);
                                ArrayList<String> arrayList = c2.d;
                                if (!str8.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.mOfflineErrorType = 2;
                                        lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str9 : arrayList) {
                                            if (StringUtils.isNull(str9)) {
                                                lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "static file path is null");
                                                this.mOfflineErrorType = 1;
                                                return null;
                                            } else if (!new File(str6, str9).exists()) {
                                                this.mOfflineErrorType = 1;
                                                lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "bundle incomplete");
                                                return null;
                                            }
                                        }
                                    }
                                }
                                String query = url.getQuery();
                                str2 = "file://" + str6 + str7;
                                try {
                                    if (!TextUtils.isEmpty(query)) {
                                        str2 = str2 + "?" + query;
                                    }
                                    if (c2.a != null && c2.a.size() != 0) {
                                        String str10 = "&";
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
                                        hashMap.put("{is_yy_user}", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                                        Iterator<String> it3 = c2.a.iterator();
                                        while (it3.hasNext()) {
                                            String next = it3.next();
                                            StringBuilder sb = new StringBuilder();
                                            String query2 = new URL(next).getQuery();
                                            if (TextUtils.isEmpty(query2)) {
                                                it = it3;
                                                str3 = str10;
                                            } else {
                                                String[] split3 = query2.split(str10);
                                                if (split3 != null) {
                                                    int length2 = split3.length;
                                                    boolean z = true;
                                                    while (i3 < length2) {
                                                        String str11 = split3[i3];
                                                        if (z) {
                                                            z = false;
                                                        } else {
                                                            sb.append(str10);
                                                        }
                                                        String[] split4 = str11.split("=");
                                                        if (split4 != null) {
                                                            it2 = it3;
                                                            str4 = str10;
                                                            if (split4.length == 2) {
                                                                String str12 = (String) hashMap.get(split4[1]);
                                                                if (str12 == null) {
                                                                    str12 = split4[1];
                                                                    if (str12.contains("{") && str12.contains("}")) {
                                                                        str12 = null;
                                                                    }
                                                                }
                                                                sb.append(split4[0]);
                                                                sb.append("=");
                                                                if (!TextUtils.isEmpty(str12)) {
                                                                    sb.append(str12);
                                                                }
                                                                i3++;
                                                                it3 = it2;
                                                                str10 = str4;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            str4 = str10;
                                                        }
                                                        i3++;
                                                        it3 = it2;
                                                        str10 = str4;
                                                    }
                                                }
                                                it = it3;
                                                str3 = str10;
                                                String sb2 = sb.toString();
                                                if (!TextUtils.isEmpty(sb2)) {
                                                    next = next.replace(query2, sb2);
                                                }
                                            }
                                            QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                                            quickWebViewBridgeData.type = SharedPreferenceManager.OPERATION_GET_PERFIX;
                                            quickWebViewBridgeData.url = next;
                                            quickWebViewBridgeData.module = c2.b;
                                            quickWebViewBridgeData.begin = System.currentTimeMillis();
                                            if (this.mProxy != null) {
                                                this.mProxy.i(quickWebViewBridgeData, null);
                                            }
                                            it3 = it;
                                            str10 = str3;
                                            i3 = 0;
                                        }
                                        return str2;
                                    }
                                    return str2;
                                } catch (MalformedURLException unused2) {
                                    str5 = str2;
                                    return str5;
                                }
                            }
                            return null;
                        } catch (MalformedURLException unused3) {
                            str2 = null;
                        }
                    } catch (MalformedURLException unused4) {
                        str5 = null;
                    }
                }
            } catch (MalformedURLException unused5) {
            }
            return str5;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        InterceptResult invokeV;
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null || (hitTestResult = bridgeWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.mOnDialogItemClickListener == null) {
                this.mOnDialogItemClickListener = new u(this);
            }
            this.mOnDialogItemClickListener.c(hitTestResult.getExtra());
            createListMenu(this.mOnDialogItemClickListener.b(), this.mOnDialogItemClickListener);
            showListMenu();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void handleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65563, this, intent, i2) == null) && this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent == null) {
                return;
            }
            String str = mShareToTypes.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z = i2 == -1;
            hashMap.put("bid", this.mBid);
            hashMap.put("result", Boolean.valueOf(z));
            hashMap.put("channel", str);
            zs4 j2 = zs4.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            ys4 ys4Var = this.mHybridBridge;
            if (ys4Var != null) {
                ys4Var.c(j2);
            }
            if (StringUtils.isNull(this.mUrl) || !this.mUrl.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1) {
                return;
            }
            this.mWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    private void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65564, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                zs4 j2 = zs4.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void handlerWebViewPause() {
        vz4 vz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && (vz4Var = this.timerData) != null && vz4Var.c()) {
            this.timerData.d();
            wt4.k().x(wt4.o("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        vz4 vz4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || (vz4Var = this.timerData) == null || !vz4Var.c() || this.timerData.b() || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            this.timerData.e(true);
            long currentTimeMillis = System.currentTimeMillis();
            long m2 = wt4.k().m(wt4.o("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(m2);
            if (m2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put("resultCode", 1);
            this.mCommonTbJsBridge.dealSpringFestivalTimer(this.timerData.a(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void handlerWebViewResumeByNew() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long m2 = wt4.k().m(wt4.o("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(m2);
            if (m2 == 0) {
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

    private void newHandleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65568, this, intent, i2) == null) && this.mShareItem != null && i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap.put("shareItem", this.mShareItem);
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
                }
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    if (this.jsBridge != null) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                        linkedHashMap2.put("shareItem", this.mShareItem);
                        this.jsBridge.i(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
                    }
                }
            }
        }
    }

    private void parserIntent() {
        Intent intent;
        Uri parse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mPageTranslucent = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.loadMyself = intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        String stringExtra = intent.getStringExtra("tag_url");
        if (TextUtils.isEmpty(stringExtra) || (parse = Uri.parse(stringExtra)) == null) {
            return;
        }
        try {
            this.mPageType = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.mPageFrom = nd5.d(stringExtra, "page_from");
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

    private void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new l(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    private void selectReportThemeTid(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, intent) == null) || intent == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65572, this, str) == null) || ni.isEmpty(str)) {
            return;
        }
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
        completeTaskReqMsg.completeId = str;
        sendMessage(completeTaskReqMsg);
    }

    private void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65573, this, str) == null) && "live".equals(this.mPageFrom)) {
            Intent intent = new Intent();
            intent.putExtra("DetailLifecycle", str);
            intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
            sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
    }

    private void showRightMoreIcon(int i2) {
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65574, this, i2) == null) || (bm4Var = this.mView) == null) {
            return;
        }
        bm4Var.x(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, this) == null) || (bm4Var = this.mView) == null) {
            return;
        }
        bm4Var.y();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        BridgeWebView bridgeWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) || (bridgeWebView = this.mWebView) == null) {
            return;
        }
        bridgeWebView.addJavascriptInterface(obj, str);
    }

    public void addJsPromptInterface(kl8 kl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kl8Var) == null) || kl8Var == null) {
            return;
        }
        this.jsBridge.a(kl8Var);
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

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mWebView == null) {
                this.mWebView = new BridgeWebView(getPageContext().getPageActivity());
                if (isTranslucent()) {
                    this.mWebView.setBackgroundColor(0);
                }
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.mWebView.getSettings().setAllowFileAccess(true);
                this.mWebView.getSettings().setDatabaseEnabled(true);
                this.mWebView.getSettings().setDomStorageEnabled(true);
                if (!isTranslucent()) {
                    this.mWebView.getSettings().setSupportZoom(true);
                    this.mWebView.getSettings().setBuiltInZoomControls(true);
                    this.mWebView.getSettings().setUseWideViewPort(true);
                }
                this.mWebView.getSettings().setTextZoom(100);
                this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                if (!isTranslucent()) {
                    this.mWebView.setInitialScale(100);
                    this.mWebView.setScrollBarStyle(33554432);
                }
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mWebView.setWebViewClient(new v(this));
                this.mWebView.setDownloadListener(new w(this, null));
                TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
                tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
                this.mWebView.setWebChromeClient(tbWebChromeClient);
                zp8.b().f(this, this.mWebView, tbWebChromeClient);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                }
                CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                ys4 n2 = dt4.n(isHybridBridgeEnabled, this.mWebView, null);
                this.mHybridBridge = n2;
                if (isHybridBridgeEnabled) {
                    n2.d(new s(this, n2));
                    n2.d(new ft4(n2));
                    n2.d(new ht4(n2));
                    n2.d(new gt4(n2));
                    n2.d(new t(this, n2));
                    n2.d(new a(this, n2));
                    n2.d(new b(this, n2));
                    n2.d(new c(this, n2));
                    n2.d(new wl4(n2));
                }
                this.mWebView.setOnLongClickListener(new d(this));
                this.mWebView.setOnScrollChangeListener(new e(this));
            }
            return this.mWebView;
        }
        return (View) invokeV.objValue;
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
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mShareInfo : (String) invokeV.objValue;
    }

    public ValueCallback<Uri> getUploadMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mUploadMessage : (ValueCallback) invokeV.objValue;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mUploadMessageAboveL : (ValueCallback) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mWebView : (View) invokeV.objValue;
    }

    public void handleError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                this.mUrl = bridgeWebView.getUrl();
                this.mWebView.stopLoading();
            }
            hideProgressBar();
            if (isTranslucent()) {
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

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            vl4.f(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void jumpToEditHeadActivity(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
        writeImagesInfo.parseJson(stringExtra);
        writeImagesInfo.updateQuality();
        if (ListUtils.isEmpty(writeImagesInfo.getChosedFiles()) || writeImagesInfo.getChosedFiles().get(0) == null) {
            return;
        }
        EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) this, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, true);
        editHeadActivityConfig.setWaterMaskType(3);
        editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
        editHeadActivityConfig.setNeedPaste(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            String str2 = str;
            if (this.isShowFullScreen && (bm4Var = this.mView) != null) {
                bm4Var.t();
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().a;
                String str3 = null;
                for (String str4 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str4) && str2.contains(str4)) {
                        str3 = str4;
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(hashMap.get(str3))) {
                    String str5 = hashMap.get(str3);
                    Uri parse = Uri.parse(str);
                    String str6 = (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost())) ? "" : parse.getScheme() + "://" + parse.getHost();
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        str2 = str2.replace(str6, str5);
                    }
                }
            }
            if (!str2.contains("javascript:")) {
                lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                String substring = str2.length() > 100 ? str2.substring(0, 100) : str2;
                if (QuickWebViewSwitch.getInOn()) {
                    String localUrlByUrl = getLocalUrlByUrl(str2);
                    if (!TextUtils.isEmpty(localUrlByUrl)) {
                        lt4.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "success");
                        str2 = localUrlByUrl;
                        z = true;
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", a98.h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                        this.mOfflineErrorType = 0;
                        this.mModuleName = "none";
                        this.mVersion = "0.0.0.0";
                        lt4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.mOfflineErrorType = 5;
                }
                z = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", a98.h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mModuleName = "none";
                this.mVersion = "0.0.0.0";
                lt4.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.mWebView != null) {
                if (this.mCommonTbJsBridge != null) {
                    this.mCommonTbJsBridge.setLastLoadUrlTime(System.currentTimeMillis());
                }
                if (this.loadMyself) {
                    this.mWebView.loadUrl(str2);
                } else {
                    CompatibleUtile.getInstance().loadUrl(this.mWebView, str2);
                }
            }
        }
    }

    public boolean needDealClickGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.isDisableGoBack || this.mCommonTbJsBridge == null) {
                return false;
            }
            this.jsBridge.i(this.mWebView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
            this.isDisableGoBack = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        BridgeWebView bridgeWebView;
        Uri[] uriArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i2, i3, intent) == null) {
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
                        getUploadMessage().onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                        setUploadMessage(null);
                    }
                }
            } else if (i2 == 1001) {
                if (this.mHybridBridge != null) {
                    HashMap hashMap = new HashMap(4);
                    hashMap.put("errNo", "0");
                    hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "success");
                    zs4 j2 = zs4.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                    ys4 ys4Var = this.mHybridBridge;
                    if (ys4Var != null) {
                        ys4Var.c(j2);
                    }
                }
            } else if (i2 == 11043) {
                if (-1 != i3 || this.mCommonTbJsBridge == null || intent == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("social_type", 0);
                String stringExtra = intent.getStringExtra("activity_id");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("social_type", Integer.valueOf(intExtra));
                linkedHashMap.put("activityId", stringExtra);
                this.jsBridge.i(this.mWebView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap);
            } else if (i2 == 12002) {
                jumpToEditHeadActivity(intent);
            } else if (i2 == 12009) {
                if (intent == null) {
                    return;
                }
                Serializable serializableExtra = intent.getSerializableExtra("pic_info");
                if (serializableExtra instanceof PhotoUrlData) {
                    PhotoUrlData photoUrlData = (PhotoUrlData) serializableExtra;
                    if (this.mCommonTbJsBridge != null) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("url", photoUrlData.getOriginPic());
                        this.jsBridge.i(this.mWebView, "GetPhotoAlbum", linkedHashMap2);
                    }
                }
            } else if (i2 == 12015) {
                handleUploadResult(intent, i3);
            } else if (i2 == 21002) {
                if (i3 != -1 || this.mHybridBridge == null) {
                    return;
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("errNo", "0");
                hashMap2.put(StatConstants.KEY_EXT_ERR_MSG, "success");
                zs4 j3 = zs4.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
                ys4 ys4Var2 = this.mHybridBridge;
                if (ys4Var2 != null) {
                    ys4Var2.c(j3);
                }
            } else if (i2 == 24007) {
                handleShareResult(intent, i3);
                newHandleShareResult(intent, i3);
            } else if (i2 == 25042) {
                if (-1 == i3) {
                    finish();
                }
            } else if (i2 == 25045) {
                BridgeWebView bridgeWebView2 = this.mWebView;
                if (bridgeWebView2 != null) {
                    bridgeWebView2.reload();
                }
            } else if (i2 != 220010) {
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
            } else {
                if (-1 != i3 || (bridgeWebView = this.mWebView) == null) {
                    return;
                }
                bridgeWebView.reload();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.jsBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.jsBridge.i(this.mWebView, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            this.mYYyPayResultCallback4CallJs.onCreate();
            parserIntent();
            setIsTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageTranslucent) || TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType));
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            this.jsBridge = new jl8();
            this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
            this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(this.mCommonTbJsBridge);
            this.jsBridge.a(new UegTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
            z88 z88Var = new z88(this.mWebView);
            this.mProxy = z88Var;
            z88Var.l(this.jsBridge);
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
            sendDetailBroadcast("onStart");
            registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
            registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            z88 z88Var = this.mProxy;
            if (z88Var != null) {
                z88Var.h();
                this.mProxy = null;
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
            this.mWebView.setVisibility(8);
            unRegisterResponsedEventListener();
            this.mYYyPayResultCallback4CallJs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast("onStart");
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
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
            jl8 jl8Var = this.jsBridge;
            if (jl8Var != null) {
                jl8Var.i(this.mWebView, CommonTbJsBridge.RE_HIDE, null);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            handleError();
        }
    }

    public void onReceivedTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            handleError();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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
            jl8 jl8Var = this.jsBridge;
            if (jl8Var != null) {
                jl8Var.i(this.mWebView, CommonTbJsBridge.RE_SHOW, null);
                if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.firstEnter) {
                    this.jsBridge.i(this.mWebView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.firstEnter = false;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || this.jsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isLogin", Boolean.valueOf(z));
        this.jsBridge.i(this.mWebView, CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
        setRefreshPage(false);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.onWebViewLogin(z);
            if (this.mWebView != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("no", z ? "1" : "0");
                    loadUrl("javascript:tiebaClientLoginCallBack(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void refreshTitle(String str) {
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || this.mFixTitle) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.mUrlTitle = str;
        }
        if (this.isShowFullScreen || (bm4Var = this.mView) == null) {
            return;
        }
        bm4Var.z(this.mUrlTitle);
    }

    public void removePromptInterface(kl8 kl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, kl8Var) == null) || kl8Var == null) {
            return;
        }
        this.jsBridge.h(kl8Var);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.isShowFullScreen = true;
            if (1 == 0 || this.mView == null) {
                return;
            }
            runOnUiThread(new g(this));
        }
    }

    public void setRefreshPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isNeedRefresh = z;
        }
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, valueCallback) == null) {
            this.mUploadMessage = valueCallback;
        }
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, valueCallback) == null) {
            this.mUploadMessageAboveL = valueCallback;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || StringUtils.isNull(this.mShareParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mShareParams);
            pg.a().post(new j(this, createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            jl8 jl8Var = this.jsBridge;
            if (jl8Var != null) {
                jl8Var.g();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                pg.a().postDelayed(new f(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null && bridgeWebView.canGoBack()) {
                this.mWebView.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
