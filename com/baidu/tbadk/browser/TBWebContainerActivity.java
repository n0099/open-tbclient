package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.SensorEvent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.livesdk.api.share.Share;
import com.baidu.mobads.sdk.internal.ci;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TBWebContainerActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.data.ResponeDelAllUserDataHttpResMsg;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.hybrid.NamedBridgeHandler;
import com.baidu.tbadk.core.hybrid.WebViewBridge;
import com.baidu.tbadk.core.hybrid.handlers.ClipboardBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.FocusFeedBridgeHandler;
import com.baidu.tbadk.core.hybrid.handlers.ImageOperateBridgeHandler;
import com.baidu.tbadk.core.keyboardheight.KeyboardLifecycleHelper;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RefreshRateManager;
import com.baidu.tbadk.core.util.SensorAccelerometerManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.b35;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.c35;
import com.baidu.tieba.ce6;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d35;
import com.baidu.tieba.dfa;
import com.baidu.tieba.efa;
import com.baidu.tieba.fr4;
import com.baidu.tieba.h35;
import com.baidu.tieba.hh6;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ifa;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jr4;
import com.baidu.tieba.mfa;
import com.baidu.tieba.mt4;
import com.baidu.tieba.ns4;
import com.baidu.tieba.os4;
import com.baidu.tieba.pi6;
import com.baidu.tieba.ps4;
import com.baidu.tieba.qi6;
import com.baidu.tieba.qs4;
import com.baidu.tieba.qy9;
import com.baidu.tieba.ut4;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.wo6;
import com.baidu.tieba.wr5;
import com.baidu.tieba.wt4;
import com.baidu.tieba.y75;
import com.baidu.tieba.yg6;
import com.baidu.tieba.zh6;
import com.baidu.tieba.zo6;
import com.baidu.tieba.zu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TBWebContainerActivity extends BaseWebViewActivity implements LifecycleOwner {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> U;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public Map<String, Object> C;
    public ps4 D;
    public dfa E;
    public final ItemCardHelper.c F;
    public final CustomMessageListener G;
    public final CustomMessageListener H;
    public final NetMessageListener I;
    public final CustomMessageListener J;
    public final SensorAccelerometerManager.OnSensorEventListener K;
    public final RefreshRateManager.OnRefreshRateListener L;
    public zo6 M;
    public ResponsedEventListener N;
    public ResponsedEventListener O;
    public final Runnable P;
    public boolean Q;
    public CustomMessageListener R;
    public CustomMessageListener S;

    /* renamed from: T  reason: collision with root package name */
    public final CustomMessageListener f1077T;
    public TbWebView a;
    public LifecycleRegistry b;
    public ValueCallback<Uri> c;
    public ValueCallback<Uri[]> d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public ShareItem l;
    public PermissionJudgePolicy m;
    public u n;
    public qy9 o;
    public boolean p;
    public WebViewBroadcastReceiver q;
    public boolean r;
    public ShareItem s;
    public b35 t;
    public boolean u;
    public final Stack<String> v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean needDelayLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class u implements iz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ TBWebContainerActivity b;

        /* loaded from: classes4.dex */
        public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
            public void onError(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                }
            }

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

            @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
                }
            }
        }

        public u(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebContainerActivity;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) && iz4Var == this.b.getListMenu()) {
                if (i == 0) {
                    if (this.b.m == null) {
                        this.b.m = new PermissionJudgePolicy();
                    }
                    this.b.m.clearRequestPermissionList();
                    this.b.m.appendRequestPermission(this.b, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.b.m.startRequestPermission(this.b)) {
                        return;
                    }
                    new InsertGalleryAsyncTask(this.b.getActivity(), this.a, new a(this)).execute(new String[0]);
                }
                iz4Var.e();
            }
        }

        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.b.getPageContext().getString(R.string.save_to_local));
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends ResponsedEventListener<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public a(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lk5
        /* renamed from: g */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (!tipEvent.isCloseCurrentPage) {
                    DefaultNavigationBarCoverTip.q(this.a.getActivity(), tipEvent.message, tipEvent.linkUrl).s();
                    return true;
                } else if (tipEvent.pageId > 0 && this.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.q(this.a.getActivity(), tipEvent.message, tipEvent.linkUrl).s();
                    return true;
                } else {
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public b(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lk5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                this.a.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent(), topToastEvent.getToastDelay());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public c(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            TBWebContainerActivity tBWebContainerActivity;
            jr4 jr4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jr4Var = (tBWebContainerActivity = this.a).mView) != null) {
                jr4Var.S(tBWebContainerActivity.s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public d(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mView.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
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

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.l != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("shareChannel", 1);
                linkedHashMap.put("shareStatus", 2);
                hh6.a().d(this.a.a, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public g(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
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

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            this.a.e = (String) customResponsedMessage.getData();
            this.a.showRightShareIcon();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TBWebContainerActivity b;

        public i(TBWebContainerActivity tBWebContainerActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebContainerActivity;
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

    /* loaded from: classes4.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public j(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
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
                        this.a.l = this.a.createShareContent(optString, optString4, optString2, optString3);
                        this.a.l.topic = optString5;
                        this.a.l.wbtitle = optString6;
                        this.a.l.wbcontent = optString7;
                        this.a.l.shareType = jSONObject.optInt("shareimg");
                        this.a.l.weixinDisable = jSONObject.optInt("weixin_disable");
                        String optString8 = jSONObject.optString("extdata");
                        if (!StringUtils.isNull(optString8)) {
                            this.a.addShareExtData(this.a.l, optString8);
                        }
                        this.a.l.groupData = GroupInfoData.fromJsonH5(jSONObject);
                        this.a.l.setShareCommonInfoData(ShareIMCommonCardData.fromJsonH5(jSONObject));
                        return new CustomResponsedMessage<>(2016568, this.a.l);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.f = (String) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
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
                this.a.a.loadUrl(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(TBWebContainerActivity tBWebContainerActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !(responsedMessage instanceof ResponeDelAllUserDataHttpResMsg)) {
                return;
            }
            zu4.c().e(responsedMessage.hasError(), responsedMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(TBWebContainerActivity tBWebContainerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, Integer.valueOf(i)};
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
            this.a = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                hh6.a().d(this.a.a, "writePostSuccess", new HashMap<>());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements SensorAccelerometerManager.OnSensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public o(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.tbadk.core.util.SensorAccelerometerManager.OnSensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, sensorEvent) != null) || sensorEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_X, Float.valueOf(-sensorEvent.values[0]));
            hashMap.put(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Y, Float.valueOf(sensorEvent.values[1]));
            hashMap.put(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Z, Float.valueOf(sensorEvent.values[2]));
            hh6.a().d(this.a.a, "deviceMotion", hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements RefreshRateManager.OnRefreshRateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public p(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.tbadk.core.util.RefreshRateManager.OnRefreshRateListener
        public void onRefreshChanged(float f) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeF(1048576, this, f) != null) || f <= 0.0f) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(CommonTbJsBridge.DEVICE_DISPLAY_REFRESH, Float.valueOf(f));
            hh6.a().d(this.a.a, "deviceRefreshRate", hashMap);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements h35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity a;

        public q(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBWebContainerActivity;
        }

        @Override // com.baidu.tieba.h35
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                boolean z = true;
                if (i2 == 1 && i > 0) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i);
                    this.a.onKeyboardHeightChanged(i);
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("height", i);
                    hh6.a().i(this.a.a, "h5Page.keyboardHeightChange", jSONObject);
                } catch (Exception unused) {
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("height", Integer.valueOf(Math.max(i, 0)));
                hashMap.put("animationDuration", Float.valueOf(1.0f));
                hh6.a().d(this.a.a, "keyboardHeightChange", hashMap);
                TBWebContainerActivity tBWebContainerActivity = this.a;
                if (i <= 0) {
                    z = false;
                }
                tBWebContainerActivity.onKeyboardVisibilityChanged(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends zo6<ns4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBWebContainerActivity b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(TBWebContainerActivity tBWebContainerActivity, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tBWebContainerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo6
        public void onEvent(@NonNull ns4 ns4Var) {
            TbWebView tbWebView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ns4Var) == null) && (tbWebView = this.b.a) != null && tbWebView.getInnerWebView() == ns4Var.c()) {
                if (ns4Var.b() && this.b.D == null) {
                    TBWebContainerActivity tBWebContainerActivity = this.b;
                    tBWebContainerActivity.o1(tBWebContainerActivity.getPageContext(), this.b.mView.b, ns4Var.a());
                }
                if (this.b.D != null && this.b.D.a() != null) {
                    if (ns4Var.b()) {
                        this.b.D.w(ns4Var.a());
                        this.b.D.a().j();
                    } else if (this.b.D.a().y()) {
                        this.b.D.a().q();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class s extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<TBWebContainerActivity> a;

        public s(TBWebContainerActivity tBWebContainerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tBWebContainerActivity);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            dfa l1;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) {
                if (!y75.a(str) && str2.startsWith("tiebaapp")) {
                    ifa ifaVar = new ifa();
                    ifaVar.w(mfa.b(str2));
                    ifaVar.y(301);
                    hh6.a().e(webView, "javascript:" + ifaVar.c() + "('" + ifaVar.d() + "')", null);
                }
                TBWebContainerActivity tBWebContainerActivity = this.a.get();
                if (tBWebContainerActivity != null && (l1 = tBWebContainerActivity.l1()) != null && !l1.b()) {
                    return tBWebContainerActivity.l1().d(str2, jsPromptResult);
                }
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            TBWebContainerActivity tBWebContainerActivity;
            String url;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i) == null) {
                super.onProgressChanged(webView, i);
                if (i >= 80 && (tBWebContainerActivity = this.a.get()) != null) {
                    if (webView == null) {
                        url = null;
                    } else {
                        url = webView.getUrl();
                    }
                    tBWebContainerActivity.hideLoadingOnPageFinished(url);
                    tBWebContainerActivity.stopLoadTimer();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                TBWebContainerActivity tBWebContainerActivity = this.a.get();
                if (tBWebContainerActivity != null) {
                    tBWebContainerActivity.refreshTitle(str);
                    if (Build.VERSION.SDK_INT >= 23 || StringUtils.isNull(str)) {
                        return;
                    }
                    if (str.contains(ci.b) || str.contains("500") || str.contains("Error")) {
                        tBWebContainerActivity.onReceivedTitle();
                    }
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, valueCallback, fileChooserParams)) == null) {
                TBWebContainerActivity tBWebContainerActivity = this.a.get();
                if (tBWebContainerActivity != null) {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    if (fileChooserParams.getMode() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                    }
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    tBWebContainerActivity.setUploadMessageAboveL(valueCallback);
                    tBWebContainerActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
                }
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class t extends pi6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public final /* synthetic */ TBWebContainerActivity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(TBWebContainerActivity tBWebContainerActivity) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBWebContainerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((WebViewClient) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tBWebContainerActivity;
        }

        public /* synthetic */ void c() {
            this.c.mView.v();
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.b = false;
                this.c.mUrl = str;
                String title = webView.getTitle();
                if (!this.c.mFixTitle && !StringUtils.isNull(title)) {
                    this.c.mUrlTitle = title;
                }
                if (!this.c.Q) {
                    TBWebContainerActivity tBWebContainerActivity = this.c;
                    tBWebContainerActivity.mView.G(tBWebContainerActivity.mUrlTitle);
                }
                if (this.c.isTranslucent()) {
                    this.c.mView.D(false);
                } else {
                    TBWebContainerActivity tBWebContainerActivity2 = this.c;
                    tBWebContainerActivity2.mView.D(tBWebContainerActivity2.mIsShowNavBar);
                }
                TBWebContainerActivity tBWebContainerActivity3 = this.c;
                tBWebContainerActivity3.mView.J(tBWebContainerActivity3.isNeedShowShareItem());
                if (!StringUtils.isNull(this.c.mUrl) && this.c.mUrl.contains(TBWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    this.c.mView.E(8);
                }
                TBWebContainerActivity tBWebContainerActivity4 = this.c;
                tBWebContainerActivity4.hideLoadingOnPageFinished(tBWebContainerActivity4.mUrl);
                this.c.stopLoadTimer();
                TBWebContainerActivity tBWebContainerActivity5 = this.c;
                jr4 jr4Var = tBWebContainerActivity5.mView;
                if (jr4Var != null) {
                    jr4Var.o(tBWebContainerActivity5.mUrl);
                }
                if (this.c.w) {
                    this.c.v.add(str);
                }
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.b = true;
                TBWebContainerActivity tBWebContainerActivity = this.c;
                tBWebContainerActivity.mUrl = str;
                tBWebContainerActivity.showProgressBar();
                this.c.startLoadTimer();
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 23) {
                    this.b = false;
                    webView.stopLoading();
                    this.c.stopLoadTimer();
                    this.c.onReceivedError(i);
                }
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                    this.b = false;
                    webView.stopLoading();
                    this.c.stopLoadTimer();
                    this.c.onReceivedError(webResourceError.getErrorCode());
                }
            }
        }

        @Override // com.baidu.tieba.pi6, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            jr4 jr4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
                Log.e("newHybrid", "shouldOverrideUrlLoading:" + str);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (this.b && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                    if (!URLUtil.isNetworkUrl(str)) {
                        if (str.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                            return true;
                        } else if (!TextUtils.isEmpty(UrlManager.getInstance().getSchemaKeyByUrl(str))) {
                            this.c.tryDeeplink(str);
                            return true;
                        }
                    }
                    return false;
                }
                int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.c.getPageContext(), new String[]{str, this.c.mUrl});
                if (dealOneLinkWithOutJumpWebView == 1) {
                    this.c.finish();
                    return true;
                } else if (dealOneLinkWithOutJumpWebView == 0) {
                    return true;
                } else {
                    if (dealOneLinkWithOutJumpWebView == 2) {
                        return false;
                    }
                    TBWebContainerActivity tBWebContainerActivity = this.c;
                    tBWebContainerActivity.mUrl = str;
                    if (tBWebContainerActivity.Q) {
                        this.c.Q = false;
                        yg6.a().c(new Runnable() { // from class: com.baidu.tieba.yq4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    TBWebContainerActivity.t.this.c();
                                }
                            }
                        });
                    }
                    this.c.hideCrashTip();
                    if (URLUtil.isNetworkUrl(str)) {
                        this.c.showProgressBar();
                        if (this.c.Q && (jr4Var = this.c.mView) != null) {
                            jr4Var.x();
                        }
                        return false;
                    }
                    TBWebContainerActivity tBWebContainerActivity2 = this.c;
                    tBWebContainerActivity2.tryDeeplink(tBWebContainerActivity2.mUrl);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2139411097, "Lcom/baidu/tbadk/browser/TBWebContainerActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2139411097, "Lcom/baidu/tbadk/browser/TBWebContainerActivity;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        U = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        U.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        U.put(Share.QQDENGLU, "qq_zone");
        U.put(Share.SINAWEIBO, "sina_weibo");
        U.put(Share.QQWEIBO, "qq_weibo");
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return;
            }
            tbWebView.onResume();
            this.b.setCurrentState(Lifecycle.State.RESUMED);
            registerGetShareContentTask();
            ItemCardHelper.w(this.F);
            hh6.a().d(this.a, CommonTbJsBridge.RE_SHOW, null);
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.g) {
                hh6.a().d(this.a, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
            }
            this.g = false;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && !StringUtils.isNull(this.e)) {
            try {
                JSONObject jSONObject = new JSONObject(this.e);
                ShareItem createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"));
                this.s.groupData = GroupInfoData.fromJsonH5(jSONObject);
                SafeHandler.getInst().post(new i(this, createShareContent));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return false;
            }
            if (this.w) {
                if (this.v.isEmpty() || this.v.size() == 1) {
                    return false;
                }
                this.v.pop();
                this.a.loadUrl(this.v.pop());
                return true;
            }
            qi6 controller = tbWebView.getController();
            if (!controller.a()) {
                return false;
            }
            controller.c();
            return true;
        }
        return invokeV.booleanValue;
    }

    public TBWebContainerActivity() {
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
        this.a = null;
        this.g = true;
        this.i = "normal";
        this.j = "normal";
        this.p = false;
        this.u = false;
        this.v = new Stack<>();
        this.x = 0;
        this.y = 0;
        this.A = "";
        this.B = true;
        this.F = new g(this);
        this.G = new k(this, 2016566);
        this.H = new l(this, 2921434);
        this.I = new m(this, CmdConfigHttp.CMD_HTTP_ONEKEY_DELETION_HISTORY, 309736);
        this.J = new n(this, 2921786);
        this.K = new o(this);
        this.L = new p(this);
        this.M = new r(this, ns4.class);
        this.N = new a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = false;
        this.R = new e(this, 2921023);
        this.S = new f(this, 2921798);
        this.f1077T = new h(this, 2921331);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            sendFinishMessage();
            super.onDestroy();
            qy9 qy9Var = this.o;
            if (qy9Var != null) {
                qy9Var.h();
                this.o = null;
            }
            if (this.P != null) {
                SafeHandler.getInst().removeCallbacks(this.P);
            }
            mt4.a();
            WebViewBroadcastReceiver webViewBroadcastReceiver = this.q;
            if (webViewBroadcastReceiver != null) {
                webViewBroadcastReceiver.unregister();
            }
            wt4.e().g();
            ps4 ps4Var = this.D;
            if (ps4Var != null) {
                ps4Var.l();
                this.D = null;
            }
            dfa dfaVar = this.E;
            if (dfaVar != null) {
                dfaVar.h();
                this.E = null;
            }
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                tbWebView.onDestroy();
                this.a = null;
            }
            this.b.setCurrentState(Lifecycle.State.DESTROYED);
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(this.f1077T);
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.H);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.S);
            unRegisterResponsedEventListener();
            SensorAccelerometerManager.getSensor().setSensorEventListener(null);
            SensorAccelerometerManager.getSensor().stop();
            RefreshRateManager.getInstance().setRefreshRateListener(null);
            RefreshRateManager.getInstance().stop();
        }
    }

    public /* synthetic */ boolean r1(WebView webView, View view2) {
        if (!TextUtils.isEmpty(this.mUrl) && this.mUrl.contains("haokan.baidu.com/activity/")) {
            return false;
        }
        return m1(webView);
    }

    public void t1(@NonNull TbWebView tbWebView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, tbWebView, str) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(BaseWebView.NOT_USER_SKIN_OVERLAY)) {
                tbWebView.setBackgroundColor(0);
                return;
            }
            EMManager.from(tbWebView).setBackGroundColor(R.color.CAM_X0503);
            tbWebView.setWebViewSkinOverly(str, R.color.CAM_X0503);
        }
    }

    public void addJsPromptInterface(efa efaVar) {
        dfa dfaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, efaVar) == null) && efaVar != null && (dfaVar = this.E) != null) {
            dfaVar.a(efaVar);
        }
    }

    public final void choosePrivateIm(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("private_msg", parcelableArrayListExtra);
        hh6.a().d(this.a, "goToSelectPrivateMsgPage", hashMap);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void loadUrl(String str) {
        TbWebView tbWebView;
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (this.Q && (jr4Var = this.mView) != null) {
                jr4Var.x();
            }
            if (!StringUtils.isNull(str) && (tbWebView = this.a) != null) {
                tbWebView.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        ps4 ps4Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (ps4Var = this.D) != null && ps4Var.a() != null) {
            if (z) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
            } else {
                i2 = 0;
            }
            this.D.a().setPadding(0, 0, 0, i2);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, intent) == null) {
            super.onNewIntent(intent);
            sendDetailBroadcast("onStart");
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            handleError();
        }
    }

    public void refreshTitle(String str) {
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, str) != null) || this.mFixTitle) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.mUrlTitle = str;
        }
        if (!this.Q && (jr4Var = this.mView) != null) {
            jr4Var.G(this.mUrlTitle);
        }
    }

    public final void selectReportThemeTid(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, intent) != null) || intent == null) {
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ReportThemeActivityConfig.REPORT_TID_LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (stringArrayListExtra != null) {
            linkedHashMap.put("tid", stringArrayListExtra);
        }
        hh6.a().d(this.a, "goToReportThreadPage", linkedHashMap);
    }

    public final void sendCompleteTask(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, str) == null) && !ad.isEmpty(str)) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
            completeTaskReqMsg.completeId = str;
            sendMessage(completeTaskReqMsg);
        }
    }

    public final void sendDetailBroadcast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, str) != null) || !"live".equals(this.k)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("DetailLifecycle", str);
        intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
        sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setNeedViewShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            super.setNeedViewShowLoading(z);
        }
    }

    public void setRefreshPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.isNeedRefresh = z;
        }
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, valueCallback) == null) {
            this.d = valueCallback;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, broadcastReceiver) == null) {
            try {
                super.unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
            }
        }
    }

    public final void chooseImageFromAlbum(Intent intent) {
        String stringExtra;
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
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
        hh6.a().d(this.a, "selectPhotoAlbum", linkedHashMap2);
    }

    public void jumpToEditHeadActivity(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, intent) != null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.finish();
            sendDetailBroadcast(MissionEvent.MESSAGE_STOP);
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                hi6.d(tbWebView);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.r) {
                return "a077";
            }
            if (!StringUtils.isNull(this.A)) {
                return this.A;
            }
            return super.getCurrentPageKey();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (Lifecycle) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public ValueCallback<Uri> getUploadMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return (ValueCallback) invokeV.objValue;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (ValueCallback) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            BrowserHelper.initCookie(getApplicationContext());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            createWebView();
            if (!TextUtils.isEmpty(this.mUrl)) {
                loadUrl(this.mUrl);
            }
        }
    }

    public dfa l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.E;
        }
        return (dfa) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean needDealClickGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (!this.p) {
                return false;
            }
            hh6.a().d(this.a, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
            this.p = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    public void onReceivedTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            handleError();
        }
    }

    public final void registerGetShareContentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new j(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.Q = true;
            if (1 != 0 && this.mView != null) {
                runOnUiThread(new d(this));
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setSkinOverly() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (tbWebView = this.a) != null) {
            t1(tbWebView, this.mUrl);
        }
    }

    public final void showRightShareIcon() {
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (jr4Var = this.mView) != null) {
            jr4Var.F();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new TbWebView(getPageContext().getPageActivity());
                this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.a.setWebViewClient(new t(this));
                this.a.setWebChromeClient(new s(this));
                this.a.setDownloadListener(new ut4(this));
                this.a.s(this.createdTime);
                q1();
                this.a.F(new ce6() { // from class: com.baidu.tieba.xq4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ce6
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            TBWebContainerActivity.this.s1((WebView) obj);
                        }
                    }
                });
            }
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            boolean z = false;
            if (this.a.getWebViewClient() instanceof t) {
                TbWebView tbWebView = this.a;
                this.t = WebViewBridge.o(isHybridBridgeEnabled, tbWebView, tbWebView.getWebViewClient(), this.a.getChromeClient());
                z = true;
            }
            if (isHybridBridgeEnabled && z) {
                this.a.setWebViewClient(new t(this));
                this.a.setWebChromeClient(new s(this));
                b35 b35Var = this.t;
                b35Var.d(new NamedBridgeHandler(this, b35Var) { // from class: com.baidu.tbadk.browser.TBWebContainerActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBWebContainerActivity this$0;

                    @d35(isAsync = false, value = "trackFPS")
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
                        super(b35Var);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, b35Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }
                });
                b35 b35Var2 = this.t;
                b35Var2.d(new ClipboardBridgeHandler(b35Var2));
                b35 b35Var3 = this.t;
                b35Var3.d(new ImageOperateBridgeHandler(b35Var3));
                b35 b35Var4 = this.t;
                b35Var4.d(new FocusFeedBridgeHandler(b35Var4));
                b35 b35Var5 = this.t;
                b35Var5.d(new NamedBridgeHandler(this, b35Var5) { // from class: com.baidu.tbadk.browser.TBWebContainerActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBWebContainerActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_Share" : (String) invokeV2.objValue;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(b35Var5);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, b35Var5};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @d35(isAsync = false, value = "share")
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
                            TBWebContainerActivity tBWebContainerActivity = this.this$0;
                            tBWebContainerActivity.mShareResultToFe = true;
                            tBWebContainerActivity.h = optString5;
                        }
                        TBWebContainerActivity tBWebContainerActivity2 = this.this$0;
                        tBWebContainerActivity2.s = tBWebContainerActivity2.createShareContent(optString, optString4, optString2, optString3);
                        this.this$0.s.groupData = GroupInfoData.fromJsonH5(jSONObject);
                        SafeHandler.getInst().post(this.this$0.P);
                    }
                });
                b35 b35Var6 = this.t;
                b35Var6.d(new NamedBridgeHandler(this, b35Var6) { // from class: com.baidu.tbadk.browser.TBWebContainerActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBWebContainerActivity this$0;

                    @Override // com.baidu.tbadk.core.hybrid.NamedBridgeHandler
                    public String scope() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? "TBHY_COMMON_UISwitch" : (String) invokeV2.objValue;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(b35Var6);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, b35Var6};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((b35) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @d35(isAsync = false, value = "viewHideSwitch")
                    private void viewHideSwitch(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeL(65537, this, jSONObject) != null) || jSONObject == null) {
                            return;
                        }
                        String optString = jSONObject.optJSONObject("share").optString("value");
                        if (!"1".equals(optString)) {
                            if ("0".equals(optString)) {
                                this.this$0.B = false;
                            }
                        } else {
                            this.this$0.B = true;
                        }
                        TBWebContainerActivity tBWebContainerActivity = this.this$0;
                        tBWebContainerActivity.mView.J(tBWebContainerActivity.B);
                    }
                });
                b35 b35Var7 = this.t;
                b35Var7.d(new HybridUtilsBridgeHandler(b35Var7));
            }
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public final void parserIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        this.j = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.x = intent.getIntExtra(WebViewActivityConfig.TAG_LOADING_STYLE, 0);
        this.y = intent.getIntExtra(WebViewActivityConfig.TAG_SHOW_LOADING_SWITCH, 0);
        this.mDialogName = intent.getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME);
        intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        this.u = intent.getBooleanExtra(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false);
        this.w = intent.getBooleanExtra(TbWebViewActivityConfig.KEY_USE_CUSTOM_HISTORY_STACK, false);
        this.z = intent.getBooleanExtra(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false);
        this.C = WebViewActivityConfig.getPageData(intent);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.A = WebviewHelper.getMatchStringFromURL(stringExtra, "page_key=");
        if (wr5.a(stringExtra).booleanValue()) {
            this.r = true;
            setNeedViewShowLoading(false);
            getPageStayDurationItem().setTopicId(wr5.d(stringExtra));
        }
        if (ad.isEquals(WebviewHelper.getMatchStringFromURL(stringExtra, WebViewActivityConfig.PAGE_TYPE), WebViewActivityConfig.TAG_NEW_GOD_INVITE)) {
            setNeedViewShowLoading(false);
        }
        Uri parse = Uri.parse(stringExtra);
        if (parse == null) {
            return;
        }
        if (isHideLoadingByH5(stringExtra)) {
            setNeedViewShowLoading(true);
        }
        try {
            this.i = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.k = WebviewHelper.getParamFromURL(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.q = webViewBroadcastReceiver;
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

    public void handleError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                this.mUrl = tbWebView.getUrl();
                this.a.getController().e();
            }
            hideProgressBar();
            if (isTranslucent()) {
                if (this.z) {
                    finish();
                    return;
                }
                TbWebView tbWebView2 = this.a;
                if (tbWebView2 != null) {
                    tbWebView2.setVisibility(8);
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
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPause();
            TbWebView tbWebView = this.a;
            if (tbWebView == null) {
                return;
            }
            tbWebView.onPause();
            this.b.setCurrentState(Lifecycle.State.STARTED);
            MessageManager.getInstance().unRegisterTask(2016568);
            ItemCardHelper.w(null);
            hh6.a().d(this.a, CommonTbJsBridge.RE_HIDE, null);
        }
    }

    public final void handleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, intent, i2) != null) || !this.mShareResultToFe) {
            return;
        }
        boolean z = false;
        this.mShareResultToFe = false;
        if (intent == null) {
            return;
        }
        String str = U.get(intent.getStringExtra("share_to"));
        HashMap hashMap = new HashMap();
        if (i2 == -1) {
            z = true;
        }
        hashMap.put(MapBundleKey.MapObjKey.OBJ_BID, this.h);
        hashMap.put("result", Boolean.valueOf(z));
        hashMap.put("channel", str);
        c35 j2 = c35.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
        b35 b35Var = this.t;
        if (b35Var != null) {
            b35Var.c(j2);
        }
        if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1) {
            this.a.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    public final void handleUploadResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, intent, i2) != null) || i2 != -1 || intent == null) {
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
            c35 j2 = c35.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.t != null) {
                this.t.c(j2);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final void newHandleShareResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048602, this, intent, i2) != null) || this.l == null) {
            return;
        }
        if (i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                linkedHashMap.put("shareStatus", Integer.valueOf(intExtra));
                linkedHashMap.put("shareItem", this.l);
                hh6.a().d(this.a, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
            }
            if (intExtra == 3 && (intExtra2 == 8 || intExtra2 == 6 || intExtra2 == 4)) {
                sendCompleteTask(stringExtra);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                linkedHashMap2.put("shareStatus", 1);
                linkedHashMap2.put("shareItem", this.l);
                hh6.a().d(this.a, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
            }
            if (intExtra == 2) {
                sendCompleteTask(stringExtra);
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("shareChannel", Integer.valueOf(intExtra2));
                linkedHashMap3.put("shareStatus", Integer.valueOf(intExtra));
                linkedHashMap3.put("shareItem", this.l);
                hh6.a().d(this.a, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap3);
            }
        } else if (i2 == 0) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("shareChannel", 1);
            linkedHashMap4.put("shareStatus", 2);
            linkedHashMap4.put("shareItem", this.l);
            hh6.a().d(this.a, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap4);
        }
    }

    public final boolean m1(View view2) {
        InterceptResult invokeL;
        WebView.HitTestResult hitTestResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view2)) == null) {
            if (!(view2 instanceof WebView) || (hitTestResult = ((WebView) view2).getHitTestResult()) == null || hitTestResult.getType() != 5) {
                return false;
            }
            if (this.n == null) {
                this.n = new u(this);
            }
            this.n.c(hitTestResult.getExtra());
            createListMenu(this.n.b(), this.n, false);
            showListMenu();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.a != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
                hh6.a().d(this.a, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                EMManager.from(this.a).setBackGroundColor(R.color.CAM_X0503);
            }
            ps4 ps4Var = this.D;
            if (ps4Var != null && ps4Var.a() != null) {
                this.D.a().z(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onWebViewLogin(z);
            if (this.a != null) {
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

    public /* synthetic */ void s1(final WebView webView) {
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.zq4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? TBWebContainerActivity.this.r1(webView, view2) : invokeL.booleanValue;
            }
        });
        this.a.setOnScrollChangeListener(new fr4(this));
        WebSettings settings = webView.getSettings();
        if (isTranslucent()) {
            webView.setBackgroundColor(0);
        } else {
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            webView.setInitialScale(100);
            webView.setScrollBarStyle(33554432);
        }
        settings.setMediaPlaybackRequiresUserGesture(!this.isAutoPlayVideo);
        if (this.u) {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
            settings.setLoadWithOverviewMode(true);
        }
        if (this.mEnableJs) {
            addJavascriptInterface();
        }
        CompatibleUtile.getInstance().removeJavascriptInterface(webView);
    }

    public void o1(TbPageContext tbPageContext, ViewGroup viewGroup, @NonNull os4 os4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, tbPageContext, viewGroup, os4Var) == null) {
            ps4 ps4Var = (ps4) new qs4(os4Var).a(tbPageContext.getPageActivity());
            this.D = ps4Var;
            ps4Var.i(tbPageContext);
            this.D.a().z(TbadkCoreApplication.getInst().getSkinType());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            viewGroup.addView(this.D.a(), layoutParams);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        TbWebView tbWebView;
        Uri[] uriArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, intent) == null) {
            ps4 ps4Var = this.D;
            if (ps4Var != null) {
                ps4Var.k(i2, i3, intent);
            }
            Uri uri = null;
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
                        } else {
                            getUploadMessageAboveL().onReceiveValue(new Uri[0]);
                        }
                        setUploadMessageAboveL(null);
                    } else if (getUploadMessage() != null) {
                        if (intent != null && i3 == -1) {
                            uri = intent.getData();
                        }
                        getUploadMessage().onReceiveValue(uri);
                    }
                } else if (getUploadMessageAboveL() != null) {
                    getUploadMessageAboveL().onReceiveValue(new Uri[0]);
                    setUploadMessageAboveL(null);
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
                                                            if (i2 != 25077) {
                                                                if (i2 != 25078) {
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
                                                                }
                                                                HashMap<String, Object> hashMap = new HashMap<>();
                                                                if (intent != null) {
                                                                    hashMap.put(WalletPayResultActivityConfig.PAY_RESULT, intent.getStringExtra(WalletPayResultActivityConfig.PAY_RESULT));
                                                                    hh6.a().d(this.a, "tbPayResult", hashMap);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (i3 == -1 && intent != null) {
                                                                String stringExtra = intent.getStringExtra("key");
                                                                if (!TextUtils.isEmpty(stringExtra)) {
                                                                    Serializable serializableExtra = intent.getSerializableExtra("data");
                                                                    if (serializableExtra instanceof JSONLikeSerializable) {
                                                                        hh6.a().i(this.a, stringExtra, ((JSONLikeSerializable) serializableExtra).toJsonObject());
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (i3 == -1 && intent != null) {
                                                            HashMap<String, Object> hashMap2 = new HashMap<>();
                                                            hashMap2.put("tailId", intent.getStringExtra("tailId"));
                                                            hashMap2.put("tailColor", intent.getStringExtra("tailColor"));
                                                            hashMap2.put("tailContent", intent.getStringExtra("tailContent"));
                                                            hh6.a().d(this.a, CommonTbJsBridge.REFRESH_TAIL, hashMap2);
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i3 == -1) {
                                                        hh6.a().d(this.a, CommonTbJsBridge.OPEN_VIP_SUCCESS, null);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (-1 == i3 && (tbWebView = this.a) != null) {
                                                    tbWebView.getController().d();
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            hh6.a().d(this.a, CommonTbJsBridge.RE_SHOW, null);
                                            return;
                                        }
                                        TbWebView tbWebView2 = this.a;
                                        if (tbWebView2 != null) {
                                            tbWebView2.getController().d();
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
                            } else if (i3 == -1 && this.t != null) {
                                HashMap hashMap3 = new HashMap(4);
                                hashMap3.put("errNo", "0");
                                hashMap3.put(StatConstants.KEY_EXT_ERR_MSG, "success");
                                c35 j2 = c35.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap3, 0L, false);
                                b35 b35Var = this.t;
                                if (b35Var != null) {
                                    b35Var.c(j2);
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
                        Serializable serializableExtra2 = intent.getSerializableExtra("pic_info");
                        if (serializableExtra2 instanceof PhotoUrlData) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("url", ((PhotoUrlData) serializableExtra2).getOriginPic());
                            hh6.a().d(this.a, "GetPhotoAlbum", linkedHashMap);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                jumpToEditHeadActivity(intent);
            } else if (-1 == i3) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("social_type", 0);
                    String stringExtra2 = intent.getStringExtra("activity_id");
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("social_type", Integer.valueOf(intExtra));
                    linkedHashMap2.put("activityId", stringExtra2);
                    linkedHashMap2.put("isLogin", Boolean.TRUE);
                    linkedHashMap2.put("resultCode", 1);
                    hh6.a().d(this.a, "commonLogin", linkedHashMap2);
                    hh6.a().d(this.a, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap2);
                    return;
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("resultCode", 0);
                linkedHashMap3.put("isLogin", Boolean.FALSE);
                hh6.a().d(this.a, "commonLogin", linkedHashMap3);
            } else {
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("resultCode", 0);
                linkedHashMap4.put("isLogin", Boolean.FALSE);
                hh6.a().d(this.a, "commonLogin", linkedHashMap4);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            parserIntent();
            boolean equals = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.j);
            boolean equals2 = TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.i);
            if (!equals && !equals2) {
                z = false;
            } else {
                z = true;
            }
            setIsTranslucent(z);
            if (isTranslucent()) {
                setNeedViewShowLoading(false);
                getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f100153);
            }
            setIsAddSwipeBackLayout(!isTranslucent());
            super.onCreate(bundle);
            setSwipeBackEnabled(true);
            jr4 jr4Var = this.mView;
            if (jr4Var != null) {
                if (this.y == 1) {
                    jr4Var.H(true);
                }
                this.mView.B(this.x);
            }
            MessageManager.getInstance().runTask(2001308, (Class) null);
            if (this.mNeedCookie) {
                initCookie();
            }
            registerListener(this.R);
            registerListener(this.f1077T);
            registerListener(this.G);
            this.H.setSelfListener(true);
            registerListener(this.H);
            registerListener(this.I);
            registerListener(this.J);
            registerListener(this.S);
            sendDetailBroadcast("onStart");
            registerResponsedEventListener(TopToastEvent.class, this.O);
            registerResponsedEventListener(TipEvent.class, this.N);
            LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
            this.b = lifecycleRegistry;
            lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
            getLifecycle().addObserver(SensorAccelerometerManager.getSensor());
            getLifecycle().addObserver(RefreshRateManager.getInstance());
            SensorAccelerometerManager.getSensor().setSensorEventListener(this.K);
            RefreshRateManager.getInstance().setRefreshRateListener(this.L);
            getLifecycle().addObserver(new KeyboardLifecycleHelper(this, new q(this)));
            wo6.b().b(getPageContext(), this.M);
            this.E = new dfa();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isLogin", Boolean.valueOf(z));
            hh6.a().d(this.a, "commonLogin", linkedHashMap);
            hh6.a().d(this.a, CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
            setRefreshPage(false);
        }
    }

    public void orderGameApkResult(@NonNull String str, int i2, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048617, this, str, i2, str2) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", str);
            hashMap.put("resultCode", Integer.valueOf(i2));
            hashMap.put("name", str2);
            hh6.a().d(this.a, "orderGameApkResult", hashMap);
        }
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.a != null && !zh6.b(this.C)) {
            for (Map.Entry<String, Object> entry : this.C.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                    if (entry.getValue() instanceof JSONLikeSerializable) {
                        JSONLikeSerializable jSONLikeSerializable = (JSONLikeSerializable) entry.getValue();
                        if (jSONLikeSerializable.isJsonArray()) {
                            this.a.J(entry.getKey(), jSONLikeSerializable.toJsonArray());
                        } else {
                            this.a.J(entry.getKey(), jSONLikeSerializable.toJsonObject());
                        }
                    } else {
                        this.a.J(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    public final void sendFinishMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
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
}
