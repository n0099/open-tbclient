package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.l.a;
import d.a.r0.s.c.i;
import d.a.r0.z0.p0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] ALLOWED_NATIVE_SCHEME;
    public static final String BOOLEAN_VALUE_CONFIG = "1";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final String KEY_NO_MENU = "nomenu";
    public static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    public static final String KEY_NO_SHARE = "noshare";
    public static final String KEY_SHOW_FRS_TAB_AD = "showad";
    public static final String QUERY_NO_SHARE = "noshare=1";
    public static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    public static final String SHARE_END = "\"";
    public static final String SHARE_IMG_START = "<img src=\"";
    public static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    public static final String SHOUBAI_SCHEME = "baiduboxapp";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 10000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public final String SHOW_MORE_FORUM_ICON;
    public boolean isNeedRefresh;
    public boolean mAutoChangeStyle;
    public p0.b mCookieInfo;
    public boolean mEnableJs;
    public boolean mFixTitle;
    public boolean mIsFromPush;
    public boolean mIsFromSchema;
    public boolean mIsShowNavBar;
    public boolean mIsTranslucent;
    public HashMap<String, f> mJsInterfaces;
    public boolean mNeedCookie;
    public boolean mNoMenu;
    public boolean mNoShare;
    public final View.OnClickListener mOnRefreshClickListener;
    public final Runnable mRunnable;
    public boolean mShareResultToFe;
    public final Runnable mShareRunnable;
    public String mSource;
    public Timer mTimer;
    public String mUrl;
    public String mUrlTitle;
    public d.a.r0.l.e mView;
    public final CustomMessageListener webviewLoginListener;

    /* loaded from: classes4.dex */
    public final class InJavaScriptLocalObj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity this$0;

        public InJavaScriptLocalObj(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseWebViewActivity;
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && "yes".equals(str)) {
                this.this$0.setFullScreen();
            }
        }

        @JavascriptInterface
        public void getSource(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.this$0.mSource = str;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseWebViewActivity f12110e;

        public a(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12110e = baseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f12110e.getShareInfo())) {
                    BaseWebViewActivity baseWebViewActivity = this.f12110e;
                    ThreadAchievementShareDialogView threadAchievementShareDialogView = new ThreadAchievementShareDialogView(baseWebViewActivity, baseWebViewActivity.getShareInfo());
                    ThreadAchievementShareInfo threadAchievementShareInfo = threadAchievementShareDialogView.f12156e;
                    if (threadAchievementShareInfo != null && threadAchievementShareInfo.getParams() != null) {
                        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f12110e);
                        if (threadAchievementShareDialogView.h(this.f12110e.getPageContext(), aVar)) {
                            aVar.setContentViewSize(2);
                            aVar.setContentView(threadAchievementShareDialogView);
                            aVar.create(this.f12110e.getPageContext()).show();
                            return;
                        }
                        return;
                    }
                }
                ShareItem createShareContent = this.f12110e.createShareContent(null, null, null, null);
                if (createShareContent != null) {
                    this.f12110e.mView.I(createShareContent);
                    StatisticItem statisticItem = new StatisticItem("c10898");
                    statisticItem.param("obj_source", 3);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseWebViewActivity f12111a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseWebViewActivity baseWebViewActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity, Integer.valueOf(i2)};
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
            this.f12111a = baseWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f12111a.onWebViewLogin(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseWebViewActivity f12112e;

        public c(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12112e = baseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12112e.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseWebViewActivity f12113e;

        public d(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12113e = baseWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!j.z()) {
                    this.f12113e.showToast(R.string.neterror);
                    return;
                }
                d.a.r0.l.e eVar = this.f12113e.mView;
                if (eVar != null) {
                    eVar.i();
                }
                this.f12113e.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseWebViewActivity f12114e;

        public e(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12114e = baseWebViewActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = 555;
                this.f12114e.mHandler.sendMessage(message);
                if (this.f12114e.mTimer != null) {
                    this.f12114e.mTimer.cancel();
                    this.f12114e.mTimer.purge();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        Object a(TbPageContext<?> tbPageContext);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1618561678, "Lcom/baidu/tbadk/browser/BaseWebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1618561678, "Lcom/baidu/tbadk/browser/BaseWebViewActivity;");
                return;
            }
        }
        ALLOWED_NATIVE_SCHEME = new String[]{SHOUBAI_SCHEME, "com.baidu.nani"};
    }

    public BaseWebViewActivity() {
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
        this.SHOW_MORE_FORUM_ICON = "1";
        this.mShareRunnable = new a(this);
        this.webviewLoginListener = new b(this, 2921024);
        this.mRunnable = new c(this);
        this.mOnRefreshClickListener = new d(this);
        this.mAutoChangeStyle = true;
        this.mShareResultToFe = false;
        this.isNeedRefresh = true;
        this.mIsFromSchema = false;
        this.mJsInterfaces = null;
        this.mIsTranslucent = false;
    }

    private String findSubString(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
                return null;
            }
            int length = indexOf + str.length();
            String str3 = this.mSource;
            String substring = str3.substring(length, str3.length());
            int indexOf2 = substring.indexOf(str2);
            if (indexOf2 < 0) {
                return null;
            }
            return substring.substring(0, indexOf2);
        }
        return (String) invokeLL.objValue;
    }

    private String getShareInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            String shareInfo = getShareInfo();
            if (k.isEmpty(shareInfo)) {
                return "";
            }
            try {
                return new JSONObject(shareInfo).optString("url");
            } catch (JSONException e2) {
                BdLog.e(e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    private void initData() {
        Intent intent;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        String uri2 = uri != null ? uri.toString() : null;
        if (uri != null && !StringUtils.isNull(uri2) && uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            String decode = Uri.decode(uri.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return;
            }
            if (decode.startsWith("//")) {
                decode = decode.substring(2);
            }
            if (StringUtils.isNull(decode) || (paramPair = UrlManager.getParamPair(decode)) == null) {
                return;
            }
            this.mUrl = paramPair.get("url");
            this.mIsShowNavBar = true;
            this.mEnableJs = true;
        } else {
            this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            this.mFixTitle = intent.getBooleanExtra(WebViewActivityConfig.TAG_FIX_TITLE, false);
            this.mUrl = parseWebViewUrl(this.mUrl);
            this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
            this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
            this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
            this.mNoShare = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_SHARE, false);
            this.mNoMenu = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_MENU, false);
        }
        this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
        if (isTranslucent()) {
            this.mView.t(false);
        } else {
            this.mView.t(this.mIsShowNavBar);
        }
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.mUrl)) {
            l.M(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
            this.mView.B(false);
        }
        if (this.mUrl.contains("custompagestyle") && this.mUrl.contains(OpenFlutter.EXTRA_TRANSPARANT)) {
            this.mView.z();
        }
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean isNeedUpdateCookie() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            a.b d2 = d.a.r0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
            String str2 = "";
            if (d2 != null) {
                String str3 = d2.f55783a;
                if (str3 == null) {
                    str3 = "";
                }
                str = d2.f55784b;
                if (str == null) {
                    str = "";
                }
                str2 = str3;
            } else {
                str = "";
            }
            boolean z = true;
            p0.b bVar = new p0.b(str2, str);
            p0.b bVar2 = this.mCookieInfo;
            if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
                z = false;
            }
            this.mCookieInfo = bVar;
            return z;
        }
        return invokeV.booleanValue;
    }

    public static Intent parseIntentFromUrl(Context context, String str) {
        InterceptResult invokeLL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context == null || str == null || (parse = Uri.parse(str)) == null) {
                return null;
            }
            List<String> a2 = i.a();
            if (ListUtils.isEmpty(a2)) {
                return null;
            }
            String scheme = parse.getScheme();
            boolean z = false;
            Iterator<String> it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(scheme)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        return intent;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    private String parseWebViewUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) ? (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str) : (String) invokeL.objValue;
    }

    private void updateShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, shareItem) == null) || shareItem == null) {
            return;
        }
        String shareInfo = getShareInfo();
        if (k.isEmpty(shareInfo)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(shareInfo);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("topic");
            String optString6 = jSONObject.optString("wbtitle");
            String optString7 = jSONObject.optString("wbcontent");
            String optString8 = jSONObject.optString("isShowMoreForum");
            if (!k.isEmpty(optString)) {
                shareItem.r = optString;
            }
            if (!k.isEmpty(optString4)) {
                shareItem.t = optString4;
            }
            if (!k.isEmpty(optString2)) {
                shareItem.s = optString2;
            }
            if (!k.isEmpty(optString3)) {
                shareItem.v = Uri.parse(optString3);
                shareItem.w = optString3;
            }
            if (!k.isEmpty(optString5)) {
                shareItem.O = optString5;
            }
            if (!k.isEmpty(optString6)) {
                shareItem.P = optString6;
            }
            if (!k.isEmpty(optString7)) {
                shareItem.Q = optString7;
            }
            shareItem.W = jSONObject.optInt("shareimg");
            if (!k.isEmpty(optString8) && "1".equals(optString8)) {
                shareItem.m = true;
                shareItem.r = optString + " " + optString2;
            }
            String optString9 = jSONObject.optString("extdata");
            if (StringUtils.isNull(optString9)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString9);
                String optString10 = jSONObject2.optString("activityid");
                String optString11 = jSONObject2.optString("missionid");
                if (StringUtils.isNull(optString10) || StringUtils.isNull(optString11)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(optString10, optString11);
                shareItem.S = jSONObject3.toString();
            } catch (JSONException unused) {
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mJsInterfaces == null) {
                this.mJsInterfaces = new HashMap<>();
            }
            for (String str : this.mJsInterfaces.keySet()) {
                addJavascriptInterface(this.mJsInterfaces.get(str).a(getPageContext()), str);
            }
            addJavascriptInterface(new InJavaScriptLocalObj(this), "local_obj");
        }
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || getWebView() == null) {
            return;
        }
        try {
            WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, str4)) == null) {
            ShareItem shareItem = new ShareItem();
            if (StringUtils.isNull(this.mUrlTitle, true)) {
                shareItem.r = getResources().getString(R.string.share_from_tieba);
            } else {
                shareItem.r = this.mUrlTitle;
            }
            shareItem.t = this.mUrl;
            if (StringUtils.isNull(this.mSource, true)) {
                shareItem.s = this.mUrl;
            } else {
                String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
                if (StringUtils.isNull(findSubString, true)) {
                    shareItem.s = this.mUrl;
                } else {
                    shareItem.s = findSubString;
                }
                String findSubString2 = findSubString("<img src=\"", "\"");
                if (!StringUtils.isNull(findSubString2, true)) {
                    shareItem.v = Uri.parse(findSubString2);
                }
                String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
                if (!StringUtils.isNull(findSubString3, true)) {
                    shareItem.t = findSubString3;
                }
            }
            updateShareItem(shareItem);
            if (!TextUtils.isEmpty(str)) {
                shareItem.r = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                shareItem.t = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                shareItem.s = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                shareItem.v = Uri.parse(str4);
            }
            shareItem.f12827g = true;
            shareItem.q = this.mUrl;
            shareItem.E = 13;
            Bundle bundle = new Bundle();
            bundle.putString(TiebaStatic.Params.OBJ_URL, shareItem.t);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            setResult(-1);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a012" : (String) invokeV.objValue;
    }

    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract View getWebView();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            if (message.what == 555) {
                onReceivedError(-2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void hideCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mView.h();
        }
    }

    public void hideNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mView.i();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mView.j();
        }
    }

    public abstract void initCookie();

    public abstract void initWebView();

    public boolean isNeedRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isNeedRefresh : invokeV.booleanValue;
    }

    public boolean isNeedShowADItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? !parseUrlParam(KEY_SHOW_FRS_TAB_AD) : invokeV.booleanValue;
    }

    public boolean isNeedShowMenuItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mNoMenu) {
                return false;
            }
            return parseUrlParam("nomenu");
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? parseUrlParam("nonavigationbar") : invokeV.booleanValue;
    }

    public boolean isNeedShowShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mNoShare || TextUtils.isEmpty(this.mUrl)) {
                return false;
            }
            return !this.mUrl.contains(QUERY_NO_SHARE);
        }
        return invokeV.booleanValue;
    }

    public boolean isTranslucent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsTranslucent : invokeV.booleanValue;
    }

    public abstract void loadUrl(String str);

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (!this.mAutoChangeStyle) {
                i2 = 0;
            }
            this.mView.n(i2);
            if (getWebView() instanceof BaseWebView) {
                ((BaseWebView) getWebView()).onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            super.onClick(view);
            int id = view.getId();
            if (id == R.id.webview_more_pop_item_share_friend_layout) {
                this.mView.e();
                loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                d.a.c.e.m.e.a().post(this.mShareRunnable);
                this.mShareResultToFe = true;
            } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
                this.mView.e();
                String shareInfoUrl = getShareInfoUrl();
                Activity pageActivity = getPageContext().getPageActivity();
                if (k.isEmpty(shareInfoUrl)) {
                    shareInfoUrl = this.mUrl;
                }
                d.a.r0.l.a.j(pageActivity, shareInfoUrl);
            } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
                this.mView.e();
                String shareInfoUrl2 = getShareInfoUrl();
                String str = this.mUrl;
                if (str != null && str.contains(Config.LAUNCH_REFERER) && (split = this.mUrl.split("&")) != null && split.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!split[i2].contains(Config.LAUNCH_REFERER) && !split[i2].contains("cuid_galaxy2")) {
                            if (i2 != 0) {
                                sb.append("&");
                            }
                            sb.append(split[i2]);
                        }
                    }
                    str = sb.toString();
                }
                if (k.isEmpty(shareInfoUrl2)) {
                    shareInfoUrl2 = str;
                }
                d.a.c.e.p.a.a(shareInfoUrl2);
                l.M(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
            } else if (id == R.id.root_view) {
                if (isTranslucent()) {
                    finish();
                }
            } else if (id == R.id.widget_navi_share_button) {
                if (this.mView.x) {
                    loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                    d.a.c.e.m.e.a().post(this.mShareRunnable);
                    this.mShareResultToFe = true;
                    return;
                }
                showShare();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.KEY_IS_FROM_SCHEMA, false) && !d.a.c.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false) && !d.a.c.a.b.f().h("MainTabActivity")) {
                this.mIsFromPush = getIntent().getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false);
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            initWebView();
            this.mView = new d.a.r0.l.e(this);
            initData();
            this.mView.l();
            this.mView.x(this.mOnRefreshClickListener);
            this.mView.s(this.mIsLogin);
            this.mView.s(isNeedShowMenuItem());
            if (!StringUtils.isNull(this.mUrlTitle)) {
                this.mView.w(this.mUrlTitle);
            }
            if (!this.mView.m() && UtilHelper.canUseStyleImmersiveSticky() && !isTranslucent()) {
                ViewHelper.addStateBarViewSpace(this.mView.f55374b, R.color.CAM_X0303, false);
            }
            if (!this.mIsTranslucent) {
                adjustResizeForSoftInput();
            }
            registerListener(this.webviewLoginListener);
            if (isNeedShowADItem()) {
                this.mView.r(true);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mRunnable);
            }
            if (getWebView() != null) {
                getWebView().setVisibility(8);
            }
            webViewDestory();
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            stopLoadTimer();
            d.a.r0.l.e eVar = this.mView;
            if (eVar != null) {
                eVar.o();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, keyEvent)) == null) {
            if (i2 == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, intent) == null) {
            super.onNewIntent(intent);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            if (getWebView() == null) {
            }
        }
    }

    public abstract void onReceivedError(int i2);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            if (getWebView() == null || getWebView() == null || !isNeedUpdateCookie()) {
                return;
            }
            initCookie();
            if (isNeedRefresh()) {
                this.mHandler.postDelayed(this.mRunnable, 100L);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onStop();
            clearAnimatable();
            clearAnimation();
            dismissAllDialog();
            dismissAllPopupWindow();
            hideListMenu();
            d.a.r0.l.e eVar = this.mView;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.onUserChanged(z);
            d.a.r0.l.e eVar = this.mView;
            if (eVar != null) {
                eVar.s(z);
            }
        }
    }

    public void onWebViewLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
        }
    }

    public boolean parseUrlParam(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(str)) {
                try {
                    String query = new URL(this.mUrl).getQuery();
                    if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                        return true;
                    }
                    for (String str2 : split) {
                        String[] split2 = str2.split("=");
                        if (split2 != null && split2.length == 2) {
                            String str3 = split2[0];
                            String str4 = split2[1];
                            if (str.equalsIgnoreCase(str3) && "1".equalsIgnoreCase(str4)) {
                                return false;
                            }
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            hideCrashTip();
            if (URLUtil.isNetworkUrl(this.mUrl)) {
                showProgressBar();
                loadUrl(this.mUrl);
                return;
            }
            Intent parseIntentFromUrl = parseIntentFromUrl(getApplicationContext(), this.mUrl);
            if (parseIntentFromUrl != null) {
                try {
                    startActivity(parseIntentFromUrl);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void refreshIgnoreFormat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            hideCrashTip();
            showProgressBar();
            loadUrl(this.mUrl);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.releaseResouce();
            finish();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void setIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.mIsTranslucent = z;
        }
    }

    public void setNavBarVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.mView.t(z);
        }
    }

    public void showCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.mView.C();
        }
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.mView.F();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.mView.H();
        }
    }

    public void showShare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    public void showTipToast(boolean z, String str) {
        d.a.r0.l.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048624, this, z, str) == null) || (eVar = this.mView) == null) {
            return;
        }
        eVar.J(z, str);
    }

    public void startLoadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer.purge();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new e(this), 10000L);
        }
    }

    public void stopLoadTimer() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (timer = this.mTimer) == null) {
            return;
        }
        timer.cancel();
        this.mTimer.purge();
        this.mTimer = null;
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    public void finish(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, intent) == null) {
            setResult(i2, intent);
            super.finish();
        }
    }
}
