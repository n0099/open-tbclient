package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.ClipData;
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
import c.a.q0.d1.r;
import c.a.q0.d1.u0;
import c.a.q0.s.s.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.livesdk.api.share.Share;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public c.a.r0.j3.m0.a jsBridge;
    public c.a.r0.j3.m0.c jsCallback;
    public boolean loadMyself;
    public String mBid;
    public CommonTbJsBridge mCommonTbJsBridge;
    public c.a.q0.s.y.l mHybridBridge;
    public String mModuleName;
    public int mOfflineErrorType;
    public t mOnDialogItemClickListener;
    public String mPageFrom;
    public String mPageTranslucent;
    public String mPageType;
    public PermissionJudgePolicy mPermissionJudgement;
    public c.a.r0.w2.a mProxy;
    public final CustomMessageListener mSelfLoadJsListener;
    public final CustomMessageListener mSetShareInfoListener;
    public String mShareInfo;
    public ShareItem mShareItem;
    public final CustomMessageListener mSharePage;
    public String mShareParams;
    public boolean mShowShareItem;
    public final CustomMessageListener mSpringFestivalTimerListener;
    public c.a.q0.j0.i mTipsEventListener;
    public c.a.q0.j0.i mTopToastEventListener;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageAboveL;
    public String mVersion;
    public BridgeWebView mWebView;
    public WebViewBroadcastReceiver mWebViewCloseReceiver;
    @NonNull
    public final YYPayResultCallback4CallJs mYYyPayResultCallback4CallJs;
    public c.a.q0.u.k timerData;

    /* loaded from: classes6.dex */
    public static class YYPayResultCallback4CallJs implements LifecycleObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public final b f47306e;

        /* renamed from: f  reason: collision with root package name */
        public final CustomMessageListener f47307f;

        /* loaded from: classes6.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ YYPayResultCallback4CallJs f47308a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(YYPayResultCallback4CallJs yYPayResultCallback4CallJs, int i2) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {yYPayResultCallback4CallJs, Integer.valueOf(i2)};
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
                this.f47308a = yYPayResultCallback4CallJs;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                this.f47308a.f47306e.a();
            }
        }

        /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47307f = new a(this, 2001456);
            this.f47306e = bVar;
        }

        public static void sendYYPayResultCallback4CallJs() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001456));
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().registerListener(this.f47307f);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f47307f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends c.a.q0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47309c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbWebViewActivity tbWebViewActivity, c.a.q0.s.y.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.q0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47309c = tbWebViewActivity;
        }

        @c.a.q0.s.y.o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.f47309c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.f47309c.mShowShareItem = false;
            }
            TbWebViewActivity tbWebViewActivity = this.f47309c;
            tbWebViewActivity.mView.y(tbWebViewActivity.mShowShareItem);
        }

        @Override // c.a.q0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.q0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47310c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbWebViewActivity tbWebViewActivity, c.a.q0.s.y.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.q0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47310c = tbWebViewActivity;
        }

        @c.a.q0.s.y.o(isAsync = false, value = "gameComment")
        private void goToGameComment(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameCommentActivityConfig(this.f47310c.getPageContext().getPageActivity(), jSONObject.optInt("score"), jSONObject.optInt("forum_id"))));
        }

        @Override // c.a.q0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_GAME_COMMENT" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.q0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47311c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbWebViewActivity tbWebViewActivity, c.a.q0.s.y.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.q0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47311c = tbWebViewActivity;
        }

        @c.a.q0.s.y.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.f47311c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameSubPbActivityConfig(this.f47311c.getPageContext().getPageActivity(), c.a.e.e.m.b.e(optString, 0), jSONObject.optString("comment_id"))));
            }
        }

        @Override // c.a.q0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47312e;

        public d(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47312e = tbWebViewActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (TextUtils.isEmpty(this.f47312e.mUrl) || !this.f47312e.mUrl.contains("haokan.baidu.com/activity/")) {
                    return this.f47312e.handleLongClick();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47313e;

        public e(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47313e = tbWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f47313e.mWebView != null) {
                        this.f47313e.mWebView.destroy();
                        this.f47313e.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47314e;

        public f(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47314e = tbWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47314e.mView.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47315a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbWebViewActivity tbWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i2)};
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
            this.f47315a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.f47315a.mUrl.contains(str) || str.contains(this.f47315a.mUrl)) {
                    this.f47315a.hideProgressBar();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TbWebViewActivity tbWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i2)};
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
            this.f47316a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f47316a.mShareParams = (String) customResponsedMessage.getData();
                this.f47316a.showRightShareIcon();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f47317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47318f;

        public i(TbWebViewActivity tbWebViewActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47318f = tbWebViewActivity;
            this.f47317e = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47318f.mView.I(this.f47317e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47319e;

        public j(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47319e = tbWebViewActivity;
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
                        this.f47319e.mShareItem = this.f47319e.createShareContent(optString, optString4, optString2, optString3);
                        this.f47319e.mShareItem.O = optString5;
                        this.f47319e.mShareItem.P = optString6;
                        this.f47319e.mShareItem.Q = optString7;
                        this.f47319e.mShareItem.Z = jSONObject.optInt("shareimg");
                        this.f47319e.mShareItem.h0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    this.f47319e.mShareItem.S = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return new CustomResponsedMessage<>(2016568, this.f47319e.mShareItem);
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements c.a.r0.j3.m0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47320a;

        public k(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47320a = tbWebViewActivity;
        }

        @Override // c.a.r0.j3.m0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f47320a.jsBridge != null) {
                    return this.f47320a.jsBridge.b(this.f47320a.mWebView, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47321a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(TbWebViewActivity tbWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i2)};
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
            this.f47321a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f47321a.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47322a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(TbWebViewActivity tbWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i2)};
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
            this.f47322a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.q0.u.k)) {
                return;
            }
            this.f47322a.timerData = (c.a.q0.u.k) customResponsedMessage.getData();
            if (this.f47322a.timerData.c()) {
                this.f47322a.handlerWebViewResume();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47323a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(TbWebViewActivity tbWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, Integer.valueOf(i2)};
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
            this.f47323a = tbWebViewActivity;
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
                this.f47323a.mWebView.loadUrl(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements YYPayResultCallback4CallJs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47324a;

        public o(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47324a = tbWebViewActivity;
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.YYPayResultCallback4CallJs.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47324a.mCommonTbJsBridge == null) {
                return;
            }
            this.f47324a.mCommonTbJsBridge.dealJsChargeIbeanCallback();
        }
    }

    /* loaded from: classes6.dex */
    public class p extends c.a.q0.j0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47325g;

        public p(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47325g = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.makeText(this.f47325g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                    return true;
                } else if (tipEvent.pageId <= 0 || this.f47325g.getPageId() != tipEvent.pageId) {
                    return true;
                } else {
                    DefaultNavigationBarCoverTip.makeText(this.f47325g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class q extends c.a.q0.j0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47326g;

        public q(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47326g = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.f47326g.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r extends c.a.q0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47327c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(TbWebViewActivity tbWebViewActivity, c.a.q0.s.y.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.q0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47327c = tbWebViewActivity;
        }

        @c.a.q0.s.y.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            }
        }

        @Override // c.a.q0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s extends c.a.q0.s.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47328c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f47329e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f47330f;

            public a(s sVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47330f = sVar;
                this.f47329e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47330f.f47328c.mView.I(this.f47329e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(TbWebViewActivity tbWebViewActivity, c.a.q0.s.y.l lVar) {
            super(lVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.q0.s.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47328c = tbWebViewActivity;
        }

        @c.a.q0.s.y.o(isAsync = false, value = "share")
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
                TbWebViewActivity tbWebViewActivity = this.f47328c;
                tbWebViewActivity.mShareResultToFe = true;
                tbWebViewActivity.mBid = optString5;
            }
            c.a.e.e.m.e.a().post(new a(this, this.f47328c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // c.a.q0.s.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class t implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47331a;

        /* renamed from: b  reason: collision with root package name */
        public String f47332b;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f47333c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47334d;

        /* loaded from: classes6.dex */
        public class a extends r.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.q0.d1.r.a
            public void onError(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                }
            }

            @Override // c.a.q0.d1.r.a
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    c.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }
            }
        }

        public t(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47334d = tbWebViewActivity;
            this.f47331a = 1;
            this.f47333c = new ArrayList();
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || bVar != this.f47334d.getListMenu() || i2 >= this.f47333c.size() || i2 < 0) {
                return;
            }
            if (this.f47333c.get(i2).intValue() == 1) {
                if (this.f47334d.mPermissionJudgement == null) {
                    this.f47334d.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.f47334d.mPermissionJudgement.clearRequestPermissionList();
                this.f47334d.mPermissionJudgement.appendRequestPermission(this.f47334d, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.f47334d.mPermissionJudgement.startRequestPermission(this.f47334d)) {
                    return;
                }
                new c.a.q0.d1.r(this.f47334d.getActivity(), this.f47332b, new a(this)).execute(new String[0]);
            }
            bVar.e();
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f47333c.clear();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f47334d.getPageContext().getString(R.string.save_to_local));
                this.f47333c.add(Integer.valueOf(this.f47331a));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f47332b = str;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f47335a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47336b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u f47337e;

            public a(u uVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {uVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47337e = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47337e.f47336b.mView.p();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47336b = tbWebViewActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                TbWebViewActivity tbWebViewActivity = this.f47336b;
                BridgeWebView bridgeWebView = tbWebViewActivity.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.f47335a = false;
                tbWebViewActivity.mUrl = str;
                bridgeWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.f47336b.mWebView.getTitle();
                if (!this.f47336b.mFixTitle && !StringUtils.isNull(title)) {
                    this.f47336b.mUrlTitle = title;
                }
                if (!this.f47336b.isShowFullScreen) {
                    TbWebViewActivity tbWebViewActivity2 = this.f47336b;
                    tbWebViewActivity2.mView.w(tbWebViewActivity2.mUrlTitle);
                }
                if (this.f47336b.isTranslucent()) {
                    this.f47336b.mView.t(false);
                } else {
                    TbWebViewActivity tbWebViewActivity3 = this.f47336b;
                    tbWebViewActivity3.mView.t(tbWebViewActivity3.mIsShowNavBar);
                }
                TbWebViewActivity tbWebViewActivity4 = this.f47336b;
                tbWebViewActivity4.mView.y(tbWebViewActivity4.isNeedShowShareItem());
                if (!StringUtils.isNull(this.f47336b.mUrl) && this.f47336b.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.f47336b.mView.u(8);
                }
                this.f47336b.hideProgressBar();
                this.f47336b.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                TbWebViewActivity tbWebViewActivity = this.f47336b;
                if (tbWebViewActivity.mWebView == null) {
                    return;
                }
                this.f47335a = true;
                tbWebViewActivity.mUrl = str;
                tbWebViewActivity.showProgressBar();
                this.f47336b.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                BridgeWebView bridgeWebView = this.f47336b.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.f47335a = false;
                bridgeWebView.stopLoading();
                this.f47336b.stopLoadTimer();
                this.f47336b.onReceivedError(i2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                c.a.q0.m.f.a("TbWebViewActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            c.a.q0.m.e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (RedirectInterceptionSwitch.isOn() && this.f47335a && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                    if (URLUtil.isNetworkUrl(str) || !str.startsWith("tiebaclient://")) {
                        return false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                    return true;
                }
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f47336b.getPageContext(), new String[]{str, this.f47336b.mUrl});
                if (dealOneLinkWithOutJumpWebView == 1) {
                    this.f47336b.finish();
                    return true;
                } else if (dealOneLinkWithOutJumpWebView == 0) {
                    return true;
                } else {
                    if (dealOneLinkWithOutJumpWebView == 2) {
                        return false;
                    }
                    TbWebViewActivity tbWebViewActivity = this.f47336b;
                    tbWebViewActivity.mUrl = str;
                    if (tbWebViewActivity.isShowFullScreen) {
                        this.f47336b.isShowFullScreen = false;
                        this.f47336b.runOnUiThread(new a(this));
                    }
                    this.f47336b.hideCrashTip();
                    if (URLUtil.isNetworkUrl(this.f47336b.mUrl)) {
                        this.f47336b.showProgressBar();
                        if (this.f47336b.isShowFullScreen && (eVar = this.f47336b.mView) != null) {
                            eVar.q();
                        }
                        return false;
                    }
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.f47336b.getApplicationContext(), this.f47336b.mUrl);
                    if (parseIntentFromUrl != null) {
                        try {
                            this.f47336b.startActivity(parseIntentFromUrl);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class v implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f47338a;

        public v(TbWebViewActivity tbWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47338a = tbWebViewActivity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.f47338a.startActivity(intent);
            }
        }

        public /* synthetic */ v(TbWebViewActivity tbWebViewActivity, k kVar) {
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
        this.mModuleName = "";
        this.mVersion = "0.0.0.0";
        this.firstEnter = true;
        this.jsCallback = new k(this);
        this.mShowShareItem = true;
        this.mPageType = "normal";
        this.mPageTranslucent = "normal";
        this.isDisableGoBack = false;
        this.loadMyself = false;
        this.mSetShareInfoListener = new l(this, 2016566);
        this.mSpringFestivalTimerListener = new m(this, 2156673);
        this.mSelfLoadJsListener = new n(this, 2921434);
        this.mYYyPayResultCallback4CallJs = new YYPayResultCallback4CallJs(new o(this));
        this.mTipsEventListener = new p(this);
        this.mTopToastEventListener = new q(this);
        this.isShowFullScreen = false;
        this.htmlLoadMessageListener = new g(this, 2921023);
        this.mSharePage = new h(this, 2921331);
    }

    private c.a.r0.j3.m0.b buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, c.a.r0.j3.m0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (c.a.r0.j3.m0.b) runTask.getData();
        }
        return (c.a.r0.j3.m0.b) invokeV.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, str)) == null) {
            HashMap hashMap = new HashMap();
            String str5 = null;
            try {
                URL url = new URL(str);
                c.a.r0.w2.d.a c2 = c.a.r0.w2.c.a().c(url.getPath());
                if (c2 == null) {
                    try {
                        if (c.a.r0.w2.c.a().b() != null) {
                            this.mOfflineErrorType = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    try {
                        if (!c2.f28169e) {
                            this.mOfflineErrorType = 4;
                            c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.f28166b, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String s2 = c.a.r0.w2.b.q().s(c2.f28166b);
                            if (!TextUtils.isEmpty(c2.f28166b) && !TextUtils.isEmpty(c2.f28167c) && !TextUtils.isEmpty(s2)) {
                                this.mModuleName = c2.f28166b;
                                this.mVersion = s2;
                                String str6 = c.a.r0.w2.b.q().p() + "/" + c2.f28166b + "/" + s2 + "/";
                                String str7 = c2.f28167c;
                                if (!c2.f28167c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str7 = c2.f28167c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str8 = str6 + str7;
                                File file = new File(str8);
                                ArrayList<String> arrayList = c2.f28168d;
                                if (!str8.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.mOfflineErrorType = 2;
                                        c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str9 : arrayList) {
                                            if (StringUtils.isNull(str9)) {
                                                c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "static file path is null");
                                                this.mOfflineErrorType = 1;
                                                return null;
                                            } else if (!new File(str6, str9).exists()) {
                                                this.mOfflineErrorType = 1;
                                                c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.mModuleName, "hybridResult", "bundle incomplete");
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
                                    if (c2.f28165a != null && c2.f28165a.size() != 0) {
                                        String str10 = "&";
                                        if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                            for (String str11 : split) {
                                                String[] split2 = str11.split("=");
                                                if (split2 != null && split2.length == 2) {
                                                    hashMap.put(StringUtil.ARRAY_START + split2[0] + "}", split2[1]);
                                                }
                                            }
                                        }
                                        hashMap.put("{client_version}", TbConfig.getVersion());
                                        hashMap.put("{client_type}", "2");
                                        hashMap.put("{is_yy_user}", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                                        Iterator<String> it3 = c2.f28165a.iterator();
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
                                                    int length = split3.length;
                                                    int i2 = 0;
                                                    boolean z = true;
                                                    while (i2 < length) {
                                                        String str12 = split3[i2];
                                                        if (z) {
                                                            z = false;
                                                        } else {
                                                            sb.append(str10);
                                                        }
                                                        String[] split4 = str12.split("=");
                                                        if (split4 != null) {
                                                            it2 = it3;
                                                            str4 = str10;
                                                            if (split4.length == 2) {
                                                                String str13 = (String) hashMap.get(split4[1]);
                                                                if (str13 == null) {
                                                                    str13 = split4[1];
                                                                    if (str13.contains(StringUtil.ARRAY_START) && str13.contains("}")) {
                                                                        str13 = null;
                                                                    }
                                                                }
                                                                sb.append(split4[0]);
                                                                sb.append("=");
                                                                if (!TextUtils.isEmpty(str13)) {
                                                                    sb.append(str13);
                                                                }
                                                                i2++;
                                                                it3 = it2;
                                                                str10 = str4;
                                                            }
                                                        } else {
                                                            it2 = it3;
                                                            str4 = str10;
                                                        }
                                                        i2++;
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
                                            quickWebViewBridgeData.type = "get";
                                            quickWebViewBridgeData.url = next;
                                            quickWebViewBridgeData.module = c2.f28166b;
                                            quickWebViewBridgeData.begin = System.currentTimeMillis();
                                            if (this.mProxy != null) {
                                                this.mProxy.i(quickWebViewBridgeData, null);
                                            }
                                            it3 = it;
                                            str10 = str3;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null || (hitTestResult = bridgeWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.mOnDialogItemClickListener == null) {
                this.mOnDialogItemClickListener = new t(this);
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
        if ((interceptable == null || interceptable.invokeLI(65560, this, intent, i2) == null) && this.mShareResultToFe) {
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
            c.a.q0.s.y.m j2 = c.a.q0.s.y.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            c.a.q0.s.y.l lVar = this.mHybridBridge;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.mUrl) || !this.mUrl.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1) {
                return;
            }
            this.mWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    private void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65561, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                c.a.q0.s.y.m j2 = c.a.q0.s.y.m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void handlerWebViewPause() {
        c.a.q0.u.k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && (kVar = this.timerData) != null && kVar.c()) {
            this.timerData.d();
            c.a.q0.s.d0.b.j().w(c.a.q0.s.d0.b.n("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        c.a.q0.u.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (kVar = this.timerData) == null || !kVar.c() || this.timerData.b() || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            this.timerData.e(true);
            long currentTimeMillis = System.currentTimeMillis();
            long l2 = c.a.q0.s.d0.b.j().l(c.a.q0.s.d0.b.n("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(l2);
            if (l2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            this.mCommonTbJsBridge.dealSpringFestivalTimer(this.timerData.a(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void handlerWebViewResumeByNew() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long l2 = c.a.q0.s.d0.b.j().l(c.a.q0.s.d0.b.n("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(l2);
            if (l2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", jSONObject.toString());
            this.mCommonTbJsBridge.dealSpringFestivalTimer(linkedHashMap);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void newHandleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65565, this, intent, i2) == null) && this.mShareItem != null && i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap.put("shareItem", this.mShareItem);
                    this.jsBridge.h(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
                }
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    if (this.jsBridge != null) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                        linkedHashMap2.put("shareItem", this.mShareItem);
                        this.jsBridge.h(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
                    }
                }
            }
        }
    }

    private void parserIntent() {
        Intent intent;
        Uri parse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mPageTranslucent = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.loadMyself = intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        if (TextUtils.isEmpty(stringExtra) || (parse = Uri.parse(stringExtra)) == null) {
            return;
        }
        try {
            this.mPageType = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.mPageFrom = u0.d(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.mWebViewCloseReceiver = webViewBroadcastReceiver;
                webViewBroadcastReceiver.register(this);
            }
        } catch (Exception unused2) {
        }
        try {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (c.a.q0.a.g.c(uri)) {
                c.a.q0.a.g.b().i(uri);
            }
        } catch (Exception unused3) {
        }
    }

    private void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new j(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    private void sendCompleteTask(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
        completeTaskReqMsg.completeId = str;
        sendMessage(completeTaskReqMsg);
    }

    private void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65569, this, str) == null) && "live".equals(this.mPageFrom)) {
            Intent intent = new Intent();
            intent.putExtra("DetailLifecycle", str);
            intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
            sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
    }

    private void showRightMoreIcon(int i2) {
        c.a.q0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65570, this, i2) == null) || (eVar = this.mView) == null) {
            return;
        }
        eVar.u(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        c.a.q0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65571, this) == null) || (eVar = this.mView) == null) {
            return;
        }
        eVar.v();
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

    public void addJsPromptInterface(c.a.r0.j3.m0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.jsBridge.a(bVar);
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
                this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                if (!isTranslucent()) {
                    this.mWebView.setInitialScale(100);
                    this.mWebView.setScrollBarStyle(33554432);
                }
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mWebView.setWebViewClient(new u(this));
                this.mWebView.setDownloadListener(new v(this, null));
                TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
                tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
                this.mWebView.setWebChromeClient(tbWebChromeClient);
                c.a.r0.o3.c.b().f(this, this.mWebView, tbWebChromeClient);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                }
                CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                c.a.q0.s.y.l o2 = c.a.q0.s.y.q.o(isHybridBridgeEnabled, this.mWebView, null);
                this.mHybridBridge = o2;
                if (isHybridBridgeEnabled) {
                    o2.d(new r(this, o2));
                    o2.d(new c.a.q0.s.y.s.a(o2));
                    o2.d(new c.a.q0.s.y.s.c(o2));
                    o2.d(new c.a.q0.s.y.s.b(o2));
                    o2.d(new s(this, o2));
                    o2.d(new a(this, o2));
                    o2.d(new b(this, o2));
                    o2.d(new c(this, o2));
                    o2.d(new c.a.q0.m.b(o2));
                }
                this.mWebView.setOnLongClickListener(new d(this));
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
            c.a.q0.m.a.f(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        c.a.q0.m.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            String str2 = str;
            if (this.isShowFullScreen && (eVar = this.mView) != null) {
                eVar.q();
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().f13566a;
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
                c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                String substring = str2.length() > 100 ? str2.substring(0, 100) : str2;
                if (QuickWebViewSwitch.getInOn()) {
                    String localUrlByUrl = getLocalUrlByUrl(str2);
                    if (!TextUtils.isEmpty(localUrlByUrl)) {
                        c.a.q0.s.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "success");
                        str2 = localUrlByUrl;
                        z = true;
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", c.a.r0.w2.b.f28139h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                        this.mOfflineErrorType = 0;
                        this.mVersion = "0.0.0.0";
                        this.mModuleName = "";
                        c.a.q0.s.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.mOfflineErrorType = 5;
                }
                z = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", c.a.r0.w2.b.f28139h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mVersion = "0.0.0.0";
                this.mModuleName = "";
                c.a.q0.s.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!this.isDisableGoBack || this.mCommonTbJsBridge == null) {
                return false;
            }
            this.jsBridge.h(this.mWebView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
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
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, intent) == null) {
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
                    hashMap.put("errMsg", "success");
                    c.a.q0.s.y.m j2 = c.a.q0.s.y.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                    c.a.q0.s.y.l lVar = this.mHybridBridge;
                    if (lVar != null) {
                        lVar.c(j2);
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
                this.jsBridge.h(this.mWebView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap);
            } else if (i2 == 12015) {
                handleUploadResult(intent, i3);
            } else if (i2 == 21002) {
                if (i3 != -1 || this.mHybridBridge == null) {
                    return;
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("errNo", "0");
                hashMap2.put("errMsg", "success");
                c.a.q0.s.y.m j3 = c.a.q0.s.y.m.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
                c.a.q0.s.y.l lVar2 = this.mHybridBridge;
                if (lVar2 != null) {
                    lVar2.c(j3);
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
            } else if (i2 == 220010 && -1 == i3 && (bridgeWebView = this.mWebView) != null) {
                bridgeWebView.reload();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.jsBridge != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                this.jsBridge.h(this.mWebView, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            this.mYYyPayResultCallback4CallJs.onCreate();
            parserIntent();
            setIsTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageTranslucent) || TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType));
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            this.jsBridge = new c.a.r0.j3.m0.a();
            this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
            this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(this.mCommonTbJsBridge);
            this.jsBridge.a(new UegTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
            c.a.r0.w2.a aVar = new c.a.r0.w2.a(this.mWebView);
            this.mProxy = aVar;
            aVar.l(this.jsBridge);
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            c.a.r0.w2.a aVar = this.mProxy;
            if (aVar != null) {
                aVar.h();
                this.mProxy = null;
            }
            CommonTbJsBridge commonTbJsBridge = this.mCommonTbJsBridge;
            if (commonTbJsBridge != null) {
                commonTbJsBridge.onDestroy();
            }
            WebViewBroadcastReceiver webViewBroadcastReceiver = this.mWebViewCloseReceiver;
            if (webViewBroadcastReceiver != null) {
                webViewBroadcastReceiver.unregister();
            }
            unRegisterResponsedEventListener();
            this.mYYyPayResultCallback4CallJs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast("onStart");
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            handleError();
        }
    }

    public void onReceivedTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            handleError();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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
            c.a.r0.j3.m0.a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.h(this.mWebView, CommonTbJsBridge.RE_SHOW, null);
                if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.firstEnter) {
                    this.jsBridge.h(this.mWebView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.firstEnter = false;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.jsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isLogin", Boolean.valueOf(z));
        this.jsBridge.h(this.mWebView, CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
        setRefreshPage(false);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
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
        c.a.q0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || this.mFixTitle) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.mUrlTitle = str;
        }
        if (this.isShowFullScreen || (eVar = this.mView) == null) {
            return;
        }
        eVar.w(this.mUrlTitle);
    }

    public void removePromptInterface(c.a.r0.j3.m0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        this.jsBridge.g(bVar);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.isShowFullScreen = true;
            if (1 == 0 || this.mView == null) {
                return;
            }
            runOnUiThread(new f(this));
        }
    }

    public void setRefreshPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isNeedRefresh = z;
        }
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, valueCallback) == null) {
            this.mUploadMessage = valueCallback;
        }
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, valueCallback) == null) {
            this.mUploadMessageAboveL = valueCallback;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || StringUtils.isNull(this.mShareParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mShareParams);
            c.a.e.e.m.e.a().post(new i(this, createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            c.a.r0.j3.m0.a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.f();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                c.a.e.e.m.e.a().postDelayed(new e(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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
