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
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.o0.r.s.b;
import d.a.o0.z0.p0;
import d.a.o0.z0.q;
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
/* loaded from: classes3.dex */
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
    public d.a.p0.h3.l0.a jsBridge;
    public d.a.p0.h3.l0.c jsCallback;
    public boolean loadMyself;
    public String mBid;
    public CommonTbJsBridge mCommonTbJsBridge;
    public d.a.o0.r.y.l mHybridBridge;
    public String mModuleName;
    public int mOfflineErrorType;
    public s mOnDialogItemClickListener;
    public String mPageFrom;
    public String mPageTranslucent;
    public String mPageType;
    public PermissionJudgePolicy mPermissionJudgement;
    public d.a.p0.u2.a mProxy;
    public final CustomMessageListener mSelfLoadJsListener;
    public final CustomMessageListener mSetShareInfoListener;
    public String mShareInfo;
    public ShareItem mShareItem;
    public final CustomMessageListener mSharePage;
    public String mShareParams;
    public boolean mShowShareItem;
    public final CustomMessageListener mSpringFestivalTimerListener;
    public d.a.o0.f0.i mTipsEventListener;
    public d.a.o0.f0.i mTopToastEventListener;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageAboveL;
    public String mVersion;
    public BridgeWebView mWebView;
    public WebViewBroadcastReceiver mWebViewCloseReceiver;
    public d.a.o0.t.l timerData;

    /* loaded from: classes3.dex */
    public class a extends d.a.o0.r.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12141c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbWebViewActivity tbWebViewActivity, d.a.o0.r.y.l lVar) {
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
                    super((d.a.o0.r.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12141c = tbWebViewActivity;
        }

        @d.a.o0.r.y.o(isAsync = false, value = "gameComment")
        private void goToGameComment(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameCommentActivityConfig(this.f12141c.getPageContext().getPageActivity(), jSONObject.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE), jSONObject.optInt("forum_id"))));
        }

        @Override // d.a.o0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_GAME_COMMENT" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.o0.r.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12142c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbWebViewActivity tbWebViewActivity, d.a.o0.r.y.l lVar) {
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
                    super((d.a.o0.r.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12142c = tbWebViewActivity;
        }

        @d.a.o0.r.y.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) && jSONObject != null && ViewHelper.checkUpIsLogin(this.f12142c.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameSubPbActivityConfig(this.f12142c.getPageContext().getPageActivity(), d.a.c.e.m.b.d(optString, 0), jSONObject.optString("comment_id"))));
            }
        }

        @Override // d.a.o0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_COMMENT_FLOOR" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12143e;

        public c(TbWebViewActivity tbWebViewActivity) {
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
            this.f12143e = tbWebViewActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (TextUtils.isEmpty(this.f12143e.mUrl) || !this.f12143e.mUrl.contains("haokan.baidu.com/activity/")) {
                    return this.f12143e.handleLongClick();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12144e;

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
            this.f12144e = tbWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f12144e.mWebView != null) {
                        this.f12144e.mWebView.destroy();
                        this.f12144e.mWebView = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12145e;

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
            this.f12145e = tbWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12145e.mView.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12146a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TbWebViewActivity tbWebViewActivity, int i2) {
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
            this.f12146a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.f12146a.mUrl.contains(str) || str.contains(this.f12146a.mUrl)) {
                    this.f12146a.hideProgressBar();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12147a;

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
            this.f12147a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f12147a.mShareParams = (String) customResponsedMessage.getData();
                this.f12147a.showRightShareIcon();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f12148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12149f;

        public h(TbWebViewActivity tbWebViewActivity, ShareItem shareItem) {
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
            this.f12149f = tbWebViewActivity;
            this.f12148e = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12149f.mView.I(this.f12148e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12150e;

        public i(TbWebViewActivity tbWebViewActivity) {
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
            this.f12150e = tbWebViewActivity;
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
                        this.f12150e.mShareItem = this.f12150e.createShareContent(optString, optString4, optString2, optString3);
                        this.f12150e.mShareItem.O = optString5;
                        this.f12150e.mShareItem.P = optString6;
                        this.f12150e.mShareItem.Q = optString7;
                        this.f12150e.mShareItem.W = jSONObject.optInt("shareimg");
                        this.f12150e.mShareItem.d0 = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString8);
                                String optString9 = jSONObject2.optString("activityid");
                                String optString10 = jSONObject2.optString("missionid");
                                if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(optString9, optString10);
                                    this.f12150e.mShareItem.S = jSONObject3.toString();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return new CustomResponsedMessage<>(2016568, this.f12150e.mShareItem);
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.a.p0.h3.l0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12151a;

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
            this.f12151a = tbWebViewActivity;
        }

        @Override // d.a.p0.h3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                if (this.f12151a.jsBridge != null) {
                    return this.f12151a.jsBridge.b(this.f12151a.mWebView, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12152a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(TbWebViewActivity tbWebViewActivity, int i2) {
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
            this.f12152a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f12152a.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12153a;

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
            this.f12153a = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.o0.t.l)) {
                return;
            }
            this.f12153a.timerData = (d.a.o0.t.l) customResponsedMessage.getData();
            if (this.f12153a.timerData.c()) {
                this.f12153a.handlerWebViewResume();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12154a;

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
            this.f12154a = tbWebViewActivity;
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
                this.f12154a.mWebView.loadUrl(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends d.a.o0.f0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12155c;

        public n(TbWebViewActivity tbWebViewActivity) {
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
            this.f12155c = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.s(this.f12155c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                } else if (tipEvent.pageId <= 0 || this.f12155c.getPageId() != tipEvent.pageId) {
                    return true;
                } else {
                    DefaultNavigationBarCoverTip.s(this.f12155c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends d.a.o0.f0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12156c;

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
            this.f12156c = tbWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.f0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.f12156c.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends d.a.o0.r.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12157c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(TbWebViewActivity tbWebViewActivity, d.a.o0.r.y.l lVar) {
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
                    super((d.a.o0.r.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12157c = tbWebViewActivity;
        }

        @d.a.o0.r.y.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            }
        }

        @Override // d.a.o0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Performance" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class q extends d.a.o0.r.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12158c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f12159e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ q f12160f;

            public a(q qVar, ShareItem shareItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, shareItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12160f = qVar;
                this.f12159e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f12160f.f12158c.mView.I(this.f12159e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(TbWebViewActivity tbWebViewActivity, d.a.o0.r.y.l lVar) {
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
                    super((d.a.o0.r.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12158c = tbWebViewActivity;
        }

        @d.a.o0.r.y.o(isAsync = false, value = "share")
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
                TbWebViewActivity tbWebViewActivity = this.f12158c;
                tbWebViewActivity.mShareResultToFe = true;
                tbWebViewActivity.mBid = optString5;
            }
            d.a.c.e.m.e.a().post(new a(this, this.f12158c.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // d.a.o0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class r extends d.a.o0.r.y.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12161c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(TbWebViewActivity tbWebViewActivity, d.a.o0.r.y.l lVar) {
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
                    super((d.a.o0.r.y.l) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12161c = tbWebViewActivity;
        }

        @d.a.o0.r.y.o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                this.f12161c.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                this.f12161c.mShowShareItem = false;
            }
            TbWebViewActivity tbWebViewActivity = this.f12161c;
            tbWebViewActivity.mView.y(tbWebViewActivity.mShowShareItem);
        }

        @Override // d.a.o0.r.y.n
        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12162a;

        /* renamed from: b  reason: collision with root package name */
        public String f12163b;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f12164c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12165d;

        /* loaded from: classes3.dex */
        public class a extends q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.z0.q.a
            public void onError(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                }
            }

            @Override // d.a.o0.z0.q.a
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }
            }
        }

        public s(TbWebViewActivity tbWebViewActivity) {
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
            this.f12165d = tbWebViewActivity;
            this.f12162a = 1;
            this.f12164c = new ArrayList();
        }

        @Override // d.a.o0.r.s.b.c
        public void a(d.a.o0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) || bVar != this.f12165d.getListMenu() || i2 >= this.f12164c.size() || i2 < 0) {
                return;
            }
            if (this.f12164c.get(i2).intValue() == 1) {
                if (this.f12165d.mPermissionJudgement == null) {
                    this.f12165d.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.f12165d.mPermissionJudgement.clearRequestPermissionList();
                this.f12165d.mPermissionJudgement.appendRequestPermission(this.f12165d, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (this.f12165d.mPermissionJudgement.startRequestPermission(this.f12165d)) {
                    return;
                }
                new d.a.o0.z0.q(this.f12165d.getActivity(), this.f12163b, new a(this)).execute(new String[0]);
            }
            bVar.e();
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f12164c.clear();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f12165d.getPageContext().getString(R.string.save_to_local));
                this.f12164c.add(Integer.valueOf(this.f12162a));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f12163b = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12166a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12167b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f12168e;

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
                        return;
                    }
                }
                this.f12168e = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f12168e.f12167b.mView.p();
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
            this.f12167b = tbWebViewActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                TbWebViewActivity tbWebViewActivity = this.f12167b;
                BridgeWebView bridgeWebView = tbWebViewActivity.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.f12166a = false;
                tbWebViewActivity.mUrl = str;
                bridgeWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = this.f12167b.mWebView.getTitle();
                if (!this.f12167b.mFixTitle && !StringUtils.isNull(title)) {
                    this.f12167b.mUrlTitle = title;
                }
                if (!this.f12167b.isShowFullScreen) {
                    TbWebViewActivity tbWebViewActivity2 = this.f12167b;
                    tbWebViewActivity2.mView.w(tbWebViewActivity2.mUrlTitle);
                }
                if (this.f12167b.isTranslucent()) {
                    this.f12167b.mView.t(false);
                } else {
                    TbWebViewActivity tbWebViewActivity3 = this.f12167b;
                    tbWebViewActivity3.mView.t(tbWebViewActivity3.mIsShowNavBar);
                }
                TbWebViewActivity tbWebViewActivity4 = this.f12167b;
                tbWebViewActivity4.mView.y(tbWebViewActivity4.isNeedShowShareItem());
                if (!StringUtils.isNull(this.f12167b.mUrl) && this.f12167b.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.f12167b.mView.u(8);
                }
                this.f12167b.hideProgressBar();
                this.f12167b.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                TbWebViewActivity tbWebViewActivity = this.f12167b;
                if (tbWebViewActivity.mWebView == null) {
                    return;
                }
                this.f12166a = true;
                tbWebViewActivity.mUrl = str;
                tbWebViewActivity.showProgressBar();
                this.f12167b.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                BridgeWebView bridgeWebView = this.f12167b.mWebView;
                if (bridgeWebView == null) {
                    return;
                }
                this.f12166a = false;
                bridgeWebView.stopLoading();
                this.f12167b.stopLoadTimer();
                this.f12167b.onReceivedError(i2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            d.a.o0.l.e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (RedirectInterceptionSwitch.isOn() && this.f12166a && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                    if (URLUtil.isNetworkUrl(str) || !str.startsWith("tiebaclient://")) {
                        return false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                    return true;
                }
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f12167b.getPageContext(), new String[]{str, this.f12167b.mUrl});
                if (dealOneLinkWithOutJumpWebView == 1) {
                    this.f12167b.finish();
                    return true;
                } else if (dealOneLinkWithOutJumpWebView == 0) {
                    return true;
                } else {
                    if (dealOneLinkWithOutJumpWebView == 2) {
                        return false;
                    }
                    TbWebViewActivity tbWebViewActivity = this.f12167b;
                    tbWebViewActivity.mUrl = str;
                    if (tbWebViewActivity.isShowFullScreen) {
                        this.f12167b.isShowFullScreen = false;
                        this.f12167b.runOnUiThread(new a(this));
                    }
                    this.f12167b.hideCrashTip();
                    if (URLUtil.isNetworkUrl(this.f12167b.mUrl)) {
                        this.f12167b.showProgressBar();
                        if (this.f12167b.isShowFullScreen && (eVar = this.f12167b.mView) != null) {
                            eVar.q();
                        }
                        return false;
                    }
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.f12167b.getApplicationContext(), this.f12167b.mUrl);
                    if (parseIntentFromUrl != null) {
                        try {
                            this.f12167b.startActivity(parseIntentFromUrl);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class u implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbWebViewActivity f12169a;

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
            this.f12169a = tbWebViewActivity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                this.f12169a.startActivity(intent);
            }
        }

        public /* synthetic */ u(TbWebViewActivity tbWebViewActivity, j jVar) {
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
        this.jsCallback = new j(this);
        this.mShowShareItem = true;
        this.mPageType = "normal";
        this.mPageTranslucent = "normal";
        this.isDisableGoBack = false;
        this.loadMyself = false;
        this.mSetShareInfoListener = new k(this, 2016566);
        this.mSpringFestivalTimerListener = new l(this, 2156673);
        this.mSelfLoadJsListener = new m(this, 2921434);
        this.mTipsEventListener = new n(this);
        this.mTopToastEventListener = new o(this);
        this.isShowFullScreen = false;
        this.htmlLoadMessageListener = new f(this, 2921023);
        this.mSharePage = new g(this, 2921331);
    }

    private d.a.p0.h3.l0.b buildGameDownloadJSPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.p0.h3.l0.b.class, getPageContext());
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (d.a.p0.h3.l0.b) runTask.getData();
        }
        return (d.a.p0.h3.l0.b) invokeV.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            HashMap hashMap = new HashMap();
            String str5 = null;
            try {
                URL url = new URL(str);
                d.a.p0.u2.d.a c2 = d.a.p0.u2.c.a().c(url.getPath());
                if (c2 == null) {
                    try {
                        if (d.a.p0.u2.c.a().b() != null) {
                            this.mOfflineErrorType = 3;
                        }
                        return null;
                    } catch (MalformedURLException unused) {
                    }
                } else {
                    try {
                        if (!c2.f64167e) {
                            this.mOfflineErrorType = 4;
                            d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.f64164b, "hybridResult", "processing bundle");
                            return null;
                        }
                        try {
                            String s2 = d.a.p0.u2.b.q().s(c2.f64164b);
                            if (!TextUtils.isEmpty(c2.f64164b) && !TextUtils.isEmpty(c2.f64165c) && !TextUtils.isEmpty(s2)) {
                                this.mModuleName = c2.f64164b;
                                this.mVersion = s2;
                                String str6 = d.a.p0.u2.b.q().p() + "/" + c2.f64164b + "/" + s2 + "/";
                                String str7 = c2.f64165c;
                                if (!c2.f64165c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                    str7 = c2.f64165c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                                }
                                String str8 = str6 + str7;
                                File file = new File(str8);
                                ArrayList<String> arrayList = c2.f64166d;
                                if (!str8.contains("/android_asset/")) {
                                    if (!file.exists()) {
                                        this.mOfflineErrorType = 2;
                                        d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "path not found");
                                        return null;
                                    } else if (ListUtils.isEmpty(arrayList)) {
                                        return null;
                                    } else {
                                        for (String str9 : arrayList) {
                                            if (StringUtils.isNull(str9)) {
                                                d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "static file path is null");
                                                this.mOfflineErrorType = 1;
                                                return null;
                                            } else if (!new File(str6, str9).exists()) {
                                                this.mOfflineErrorType = 1;
                                                d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.mModuleName, "hybridResult", "bundle incomplete");
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
                                    if (c2.f64163a != null && c2.f64163a.size() != 0) {
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
                                        Iterator<String> it3 = c2.f64163a.iterator();
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
                                            quickWebViewBridgeData.module = c2.f64164b;
                                            quickWebViewBridgeData.begin = System.currentTimeMillis();
                                            if (this.mProxy != null) {
                                                this.mProxy.f(quickWebViewBridgeData, null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView == null || (hitTestResult = bridgeWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.mOnDialogItemClickListener == null) {
                this.mOnDialogItemClickListener = new s(this);
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
        if ((interceptable == null || interceptable.invokeLI(65559, this, intent, i2) == null) && this.mShareResultToFe) {
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
            d.a.o0.r.y.m j2 = d.a.o0.r.y.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            d.a.o0.r.y.l lVar = this.mHybridBridge;
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
        if ((interceptable == null || interceptable.invokeLI(65560, this, intent, i2) == null) && i2 == -1 && intent != null) {
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
                d.a.o0.r.y.m j2 = d.a.o0.r.y.m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.c(j2);
                }
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void handlerWebViewPause() {
        d.a.o0.t.l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65561, this) == null) && (lVar = this.timerData) != null && lVar.c()) {
            this.timerData.d();
            d.a.o0.r.d0.b.j().w(d.a.o0.r.d0.b.n("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        d.a.o0.t.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (lVar = this.timerData) == null || !lVar.c() || this.timerData.b() || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            this.timerData.e(true);
            long currentTimeMillis = System.currentTimeMillis();
            long l2 = d.a.o0.r.d0.b.j().l(d.a.o0.r.d0.b.n("key_spring_festival_timer"), 0L);
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
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long l2 = d.a.o0.r.d0.b.j().l(d.a.o0.r.d0.b.n("key_spring_festival_timer"), 0L);
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
        if ((interceptable == null || interceptable.invokeLI(65564, this, intent, i2) == null) && this.mShareItem != null && i2 == -1) {
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
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || (intent = getIntent()) == null) {
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
            this.mPageFrom = p0.d(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.mWebViewCloseReceiver = webViewBroadcastReceiver;
                webViewBroadcastReceiver.register(this);
            }
        } catch (Exception unused2) {
        }
        try {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (d.a.o0.a.g.c(uri)) {
                d.a.o0.a.g.b().i(uri);
            }
        } catch (Exception unused3) {
        }
    }

    private void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new i(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    private void sendCompleteTask(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, str) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
        completeTaskReqMsg.completeId = str;
        sendMessage(completeTaskReqMsg);
    }

    private void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65568, this, str) == null) && "live".equals(this.mPageFrom)) {
            Intent intent = new Intent();
            intent.putExtra("DetailLifecycle", str);
            intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
            sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
    }

    private void showRightMoreIcon(int i2) {
        d.a.o0.l.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65569, this, i2) == null) || (eVar = this.mView) == null) {
            return;
        }
        eVar.u(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        d.a.o0.l.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || (eVar = this.mView) == null) {
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

    public void addJsPromptInterface(d.a.p0.h3.l0.b bVar) {
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
                this.mWebView.setWebViewClient(new t(this));
                this.mWebView.setDownloadListener(new u(this, null));
                TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
                tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
                this.mWebView.setWebChromeClient(tbWebChromeClient);
                d.a.p0.m3.c.b().f(this, this.mWebView, tbWebChromeClient);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                }
                CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
                boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
                d.a.o0.r.y.l o2 = d.a.o0.r.y.q.o(isHybridBridgeEnabled, this.mWebView, null);
                this.mHybridBridge = o2;
                if (isHybridBridgeEnabled) {
                    o2.d(new p(this, o2));
                    o2.d(new d.a.o0.r.y.s.a(o2));
                    o2.d(new d.a.o0.r.y.s.c(o2));
                    o2.d(new d.a.o0.r.y.s.b(o2));
                    o2.d(new q(this, o2));
                    o2.d(new r(this, o2));
                    o2.d(new a(this, o2));
                    o2.d(new b(this, o2));
                    o2.d(new d.a.o0.l.b(o2));
                }
                this.mWebView.setOnLongClickListener(new c(this));
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
            d.a.o0.l.a.f(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        d.a.o0.l.e eVar;
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
                HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().f52076a;
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
                d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str2);
                if (QuickWebViewSwitch.getInOn()) {
                    String localUrlByUrl = getLocalUrlByUrl(str2);
                    if (!TextUtils.isEmpty(localUrlByUrl)) {
                        d.a.o0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "success");
                        str2 = localUrlByUrl;
                        z = true;
                        String substring = str2.length() <= 100 ? str2.substring(0, 100) : str2;
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", d.a.p0.u2.b.f64137h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                        this.mOfflineErrorType = 0;
                        this.mVersion = "0.0.0.0";
                        this.mModuleName = "";
                        d.a.o0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.mOfflineErrorType = 5;
                }
                z = false;
                if (str2.length() <= 100) {
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", d.a.p0.u2.b.f64137h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mVersion = "0.0.0.0";
                this.mModuleName = "";
                d.a.o0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
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
                    d.a.o0.r.y.m j2 = d.a.o0.r.y.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                    d.a.o0.r.y.l lVar = this.mHybridBridge;
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
                d.a.o0.r.y.m j3 = d.a.o0.r.y.m.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
                d.a.o0.r.y.l lVar2 = this.mHybridBridge;
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
            parserIntent();
            setIsTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageTranslucent) || TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType));
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            MessageManager.getInstance().runTask(2001308, (Class) null);
            this.jsBridge = new d.a.p0.h3.l0.a();
            this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
            this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
            this.jsBridge.a(this.mCommonTbJsBridge);
            this.jsBridge.a(new UegTbJsBridge(getPageContext()));
            this.jsBridge.a(buildGameDownloadJSPrompt());
            this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
            d.a.p0.u2.a aVar = new d.a.p0.u2.a(this.mWebView);
            this.mProxy = aVar;
            aVar.h(this.jsBridge);
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
            sendDetailBroadcast(MissionEvent.MESSAGE_START);
            registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
            registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            d.a.p0.u2.a aVar = this.mProxy;
            if (aVar != null) {
                aVar.e();
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
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast(MissionEvent.MESSAGE_START);
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
            callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
            registerGetShareContentTask();
            d.a.p0.h3.l0.a aVar = this.jsBridge;
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
        d.a.o0.l.e eVar;
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

    public void removePromptInterface(d.a.p0.h3.l0.b bVar) {
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
            runOnUiThread(new e(this));
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
            d.a.c.e.m.e.a().post(new h(this, createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"))));
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
            d.a.p0.h3.l0.a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.f();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(new d(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
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
