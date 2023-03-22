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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.DelayLoadUrlSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.gi;
import com.baidu.tieba.gt4;
import com.baidu.tieba.gu4;
import com.baidu.tieba.hi;
import com.baidu.tieba.jg;
import com.baidu.tieba.mt4;
import com.baidu.tieba.n65;
import com.baidu.tieba.oq5;
import com.baidu.tieba.uv4;
import com.baidu.tieba.w8;
import com.baidu.tieba.xh;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BOOLEAN_VALUE_CONFIG = "1";
    public static final String BUNDLE_NEED_BLACKLIST = "need_scheme_blacklist";
    public static final String BUNDLE_NEED_EXTRA_PARAM = "need_add_extra_param";
    public static final String CUSTOM_FULL_SCREEN = "customfullscreen";
    public static final String CUSTOM_FULL_SCREEN_EQUAL = "customfullscreen=";
    public static final String KEY_NO_CLOSE = "noclose";
    public static final String KEY_NO_MENU = "nomenu";
    public static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    public static final String KEY_NO_SHARE = "noshare";
    public static final String KEY_SHOW_FRS_TAB_AD = "showad";
    public static final String QUERY_NO_SHARE = "noshare=1";
    public static final String QUERY_OPACITY = "opacity=0";
    public static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    public static final String SHARE_END = "\"";
    public static final String SHARE_IMG_START = "<img src=\"";
    public static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 20000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public final String SHOW_MORE_FORUM_ICON;
    public final long createdTime;
    public final DelayLoadUrlSwitch delayLoadUrlSwitch;
    public boolean isAutoPlayVideo;
    public boolean isCustomFullScreen;
    public boolean isDisableGoBack;
    public boolean isNeedRefresh;
    public boolean isNeedViewShowLoading;
    public boolean mAutoChangeStyle;
    public Bundle mBundle;
    public oq5.b mCookieInfo;
    public boolean mCustomJump;
    public String mDialogName;
    public boolean mEnableJs;
    public boolean mFixTitle;
    public boolean mIsFromSchema;
    public boolean mIsShowNavBar;
    public boolean mIsTranslucent;
    public HashMap<String, f> mJsInterfaces;
    public boolean mNeedCookie;
    public boolean mNoClose;
    public boolean mNoHelp;
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
    public mt4 mView;
    public final CustomMessageListener webviewLoginListener;

    /* loaded from: classes3.dex */
    public interface f {
        Object a(TbPageContext<?> tbPageContext);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a012" : (String) invokeV.objValue;
    }

    public String getShareInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public abstract View getWebView();

    public abstract void initCookie();

    public abstract void initWebView();

    public abstract void loadUrl(String str);

    public abstract boolean needDealClickGoBack();

    public abstract void onReceivedError(int i);

    public void onWebViewLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
        }
    }

    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    public abstract void setSkinOverly();

    public void showShare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        public a(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.getShareInfo())) {
                    BaseWebViewActivity baseWebViewActivity = this.a;
                    ThreadAchievementShareDialogView threadAchievementShareDialogView = new ThreadAchievementShareDialogView(baseWebViewActivity, baseWebViewActivity.getShareInfo());
                    ThreadAchievementShareInfo threadAchievementShareInfo = threadAchievementShareDialogView.a;
                    if (threadAchievementShareInfo != null && threadAchievementShareInfo.getParams() != null) {
                        zz4 zz4Var = new zz4(this.a);
                        if (threadAchievementShareDialogView.h(this.a.getPageContext(), zz4Var)) {
                            zz4Var.setContentViewSize(2);
                            zz4Var.setContentView(threadAchievementShareDialogView);
                            zz4Var.create(this.a.getPageContext()).show();
                            return;
                        }
                        return;
                    }
                }
                ShareItem createShareContent = this.a.createShareContent(null, null, null, null);
                if (createShareContent != null) {
                    this.a.mView.S(createShareContent);
                    StatisticItem statisticItem = new StatisticItem("c10898");
                    statisticItem.param("obj_source", 3);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseWebViewActivity baseWebViewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity, Integer.valueOf(i)};
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
            this.a = baseWebViewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921024 || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.onWebViewLogin(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        public c(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        public d(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    return;
                }
                mt4 mt4Var = this.a.mView;
                if (mt4Var != null) {
                    mt4Var.m();
                }
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseWebViewActivity a;

        public e(BaseWebViewActivity baseWebViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseWebViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseWebViewActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
                this.a.mHandler.sendMessage(message);
                if (this.a.mTimer != null) {
                    this.a.mTimer.cancel();
                    this.a.mTimer.purge();
                }
            }
        }
    }

    public BaseWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.SHOW_MORE_FORUM_ICON = "1";
        this.isDisableGoBack = false;
        this.delayLoadUrlSwitch = new DelayLoadUrlSwitch();
        this.createdTime = System.currentTimeMillis();
        this.mShareRunnable = new a(this);
        this.webviewLoginListener = new b(this, 2921024);
        this.mRunnable = new c(this);
        this.mOnRefreshClickListener = new d(this);
        this.isAutoPlayVideo = false;
        this.mAutoChangeStyle = true;
        this.mShareResultToFe = false;
        this.isNeedRefresh = true;
        this.mIsFromSchema = false;
        this.mJsInterfaces = null;
        this.mIsTranslucent = false;
        this.isNeedViewShowLoading = true;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (isTranslucent()) {
                this.mView.D(false);
            } else {
                this.mView.D(this.mIsShowNavBar);
            }
            if (TextUtils.isEmpty(this.mUrl)) {
                return;
            }
            if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
                this.mView.M(false);
            }
            if (this.mUrl.contains("custompagestyle") && this.mUrl.contains("transparent")) {
                this.mView.K();
            }
            if (this.mUrl.contains(QUERY_OPACITY)) {
                this.mView.o(this.mUrl);
            }
        }
    }

    public void copyLink() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String shareInfoUrl = getShareInfoUrl();
            String str = this.mUrl;
            if (str != null && str.contains(Config.LAUNCH_REFERER) && (split = this.mUrl.split("&")) != null && split.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].contains(Config.LAUNCH_REFERER) && !split[i].contains("cuid_galaxy2")) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(split[i]);
                    }
                }
                str = sb.toString();
            }
            if (gi.isEmpty(shareInfoUrl)) {
                shareInfoUrl = str;
            }
            xh.a(shareInfoUrl);
            hi.Q(this, getResources().getString(R.string.copy_pb_url_success));
        }
    }

    private String parseWebViewUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            if (str != null && !str.startsWith("http://") && !str.startsWith("https://")) {
                return "http://".concat(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void callHiddenWebViewMethod(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, message)) == null) {
            if (message.what == 555) {
                onReceivedError(-2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            super.onChangeSkinType(i);
            if (!this.mAutoChangeStyle) {
                i = 0;
            }
            this.mView.s(i);
            if (getWebView() instanceof BaseWebView) {
                ((BaseWebView) getWebView()).onChangeSkinType();
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, intent) == null) {
            super.onNewIntent(intent);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            refresh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            super.onUserChanged(z);
            mt4 mt4Var = this.mView;
            if (mt4Var != null) {
                mt4Var.C(z);
            }
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mAutoChangeStyle = z;
        }
    }

    public void setIsTranslucent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mIsTranslucent = z;
        }
    }

    public void setNeedViewShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isNeedViewShowLoading = z;
            mt4 mt4Var = this.mView;
            if (mt4Var != null) {
                mt4Var.H(z);
            }
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mSource = str;
        }
    }

    public void tryDeeplink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            Bundle bundle = this.mBundle;
            if (bundle != null && bundle.getBoolean("need_scheme_blacklist")) {
                UrlSchemaJumpHelper.tryDeeplinkFromWebview(str, getActivity());
                return;
            }
            Intent parseIntentFromUrl = parseIntentFromUrl(getApplicationContext(), str);
            if (parseIntentFromUrl != null) {
                try {
                    startActivity(parseIntentFromUrl);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private boolean checkIsFullscreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (StringUtils.isNull(this.mUrl)) {
                return false;
            }
            String str = this.mUrl;
            if (!gi.isEquals(oq5.c(str, CUSTOM_FULL_SCREEN), "=")) {
                try {
                    str = URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return StringHelper.equals(oq5.c(str, CUSTOM_FULL_SCREEN_EQUAL), "1");
        }
        return invokeV.booleanValue;
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
            addJavascriptInterface(new gu4(), "local_obj");
        }
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

    public static Intent parseIntentFromUrl(Context context, String str) {
        InterceptResult invokeLL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            if (context == null || str == null || (parse = Uri.parse(str)) == null) {
                return null;
            }
            List<String> a2 = n65.a();
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
            if (!z) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return null;
                }
                return intent;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    private String getShareInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            String shareInfo = getShareInfo();
            if (!gi.isEmpty(shareInfo)) {
                try {
                    return new JSONObject(shareInfo).optString("url");
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void hideCrashTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mView.l();
        }
    }

    public void hideNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mView.m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mView.n();
        }
    }

    public boolean isNeedCustomMoreJump() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mCustomJump;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.isNeedRefresh;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowADItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return !parseUrlParam(KEY_SHOW_FRS_TAB_AD, null);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowCloseItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mNoClose) {
                return false;
            }
            return parseUrlParam(KEY_NO_CLOSE, null);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowMenuItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mNoMenu) {
                return false;
            }
            return parseUrlParam(KEY_NO_MENU, null);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return parseUrlParam(KEY_NO_NAVIGATIONBAR, this.mUrl);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!this.mNoShare && !TextUtils.isEmpty(this.mUrl)) {
                return !this.mUrl.contains(QUERY_NO_SHARE);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedShowTitleHelp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return !this.mNoHelp;
        }
        return invokeV.booleanValue;
    }

    public boolean isTranslucent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mIsTranslucent;
        }
        return invokeV.booleanValue;
    }

    public boolean needDelayLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.delayLoadUrlSwitch.isOn();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStop();
            clearAnimatable();
            clearAnimation();
            dismissAllDialog();
            dismissAllPopupWindow();
            hideListMenu();
            mt4 mt4Var = this.mView;
            if (mt4Var != null) {
                mt4Var.h();
            }
        }
    }

    public void openInBrowser() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            String shareInfoUrl = getShareInfoUrl();
            Activity pageActivity = getPageContext().getPageActivity();
            if (gi.isEmpty(shareInfoUrl)) {
                shareInfoUrl = this.mUrl;
            }
            gt4.o(pageActivity, shareInfoUrl);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            hideCrashTip();
            if (!URLUtil.isNetworkUrl(this.mUrl) && !URLUtil.isFileUrl(this.mUrl)) {
                tryDeeplink(this.mUrl);
                return;
            }
            loadUrl(this.mUrl);
            showProgressBar();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.releaseResouce();
            finish();
        }
    }

    public void shareFriend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            jg.a().post(this.mShareRunnable);
            this.mShareResultToFe = true;
        }
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.mView.P();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.mView.R();
        }
    }

    public void startLoadTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer.purge();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new e(this), 20000L);
        }
    }

    public void stopLoadTimer() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (timer = this.mTimer) != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    private String getSkinUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(TbConfig.TIEBA_ADDRESS) && !str.contains("skin=")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String str2 = "?";
                if (str.contains("?")) {
                    str2 = "&";
                }
                sb.append(str2);
                sb.append("skin=");
                sb.append(SkinManager.getCurrentSkinTypeString());
                return sb.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private void initData() {
        Intent intent;
        String str;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, this) != null) || (intent = getIntent()) == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        boolean z = false;
        if (uri != null && !StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            String decode = Uri.decode(uri.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return;
            }
            if (decode.startsWith(ResourceConstants.CMT)) {
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
            this.isAutoPlayVideo = intent.getBooleanExtra(WebViewActivityConfig.TAG_AUTO_PLAY_VIDEO, false);
            this.mCustomJump = intent.getBooleanExtra(WebViewActivityConfig.TAG_CUSTOM_MORE_JUMP, false);
            this.mUrl = parseWebViewUrl(this.mUrl);
            this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
            this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
            this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
            this.mNoShare = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_SHARE, false);
            this.mNoMenu = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_MENU, false);
            this.mNoClose = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_CLOSE, false);
            this.mNoHelp = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_HELP, true);
            this.mBundle = intent.getBundleExtra(WebViewActivityConfig.TAG_BUNDLE);
        }
        if (this.mIsShowNavBar && isNeedShowNavigationBar()) {
            z = true;
        }
        this.mIsShowNavBar = z;
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.mUrl)) {
            hi.Q(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (checkIsFullscreen()) {
            this.isCustomFullScreen = true;
        }
        this.mUrl = getSkinUrl(this.mUrl);
        if (needDelayLoadUrl()) {
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    private boolean isNeedUpdateCookie() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            uv4.b c2 = uv4.b().c(TbadkCoreApplication.getCurrentBduss());
            String str2 = "";
            if (c2 == null) {
                str = "";
            } else {
                String str3 = c2.a;
                if (str3 == null) {
                    str3 = "";
                }
                str = c2.b;
                if (str == null) {
                    str = "";
                }
                str2 = str3;
            }
            boolean z = true;
            oq5.b bVar = new oq5.b(str2, str);
            oq5.b bVar2 = this.mCookieInfo;
            if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
                z = false;
            }
            this.mCookieInfo = bVar;
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            setResult(-1);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
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
            mt4 mt4Var = this.mView;
            if (mt4Var != null) {
                mt4Var.u();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            if (getWebView() != null && getWebView() != null && isNeedUpdateCookie()) {
                initCookie();
                if (isNeedRefresh()) {
                    this.mHandler.postDelayed(this.mRunnable, 100L);
                }
            }
        }
    }

    private void updateShareItem(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, this, shareItem) != null) || shareItem == null) {
            return;
        }
        String shareInfo = getShareInfo();
        if (gi.isEmpty(shareInfo)) {
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
            if (!gi.isEmpty(optString)) {
                shareItem.v = optString;
            }
            if (!gi.isEmpty(optString4)) {
                shareItem.x = optString4;
            }
            if (!gi.isEmpty(optString2)) {
                shareItem.w = optString2;
            }
            if (!gi.isEmpty(optString3)) {
                shareItem.z = Uri.parse(optString3);
                shareItem.A = optString3;
            }
            if (!gi.isEmpty(optString5)) {
                shareItem.T = optString5;
            }
            if (!gi.isEmpty(optString6)) {
                shareItem.U = optString6;
            }
            if (!gi.isEmpty(optString7)) {
                shareItem.V = optString7;
            }
            shareItem.k0 = jSONObject.optInt("shareimg");
            if (!gi.isEmpty(optString8) && "1".equals(optString8)) {
                shareItem.q = true;
                shareItem.v = optString + " " + optString2;
            }
            String optString9 = jSONObject.optString("extdata");
            if (!StringUtils.isNull(optString9)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    String optString10 = jSONObject2.optString("activityid");
                    String optString11 = jSONObject2.optString("missionid");
                    if (!StringUtils.isNull(optString10) && !StringUtils.isNull(optString11)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(optString10, optString11);
                        shareItem.X = jSONObject3.toString();
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !w8.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.KEY_IS_FROM_SCHEMA, false) && !w8.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            initData();
            initWebView();
            mt4 mt4Var = new mt4(this);
            this.mView = mt4Var;
            mt4Var.q();
            initView();
            setSkinOverly();
            this.mView.I(this.mOnRefreshClickListener);
            this.mView.C(this.mIsLogin);
            this.mView.C(isNeedShowMenuItem());
            this.mView.w(isNeedShowCloseItem());
            this.mView.A(isNeedShowTitleHelp());
            this.mView.y(isNeedCustomMoreJump());
            this.mView.H(this.isNeedViewShowLoading);
            if (!StringUtils.isNull(this.mUrlTitle)) {
                this.mView.G(this.mUrlTitle);
            }
            if (!this.mView.r() && UtilHelper.canUseStyleImmersiveSticky() && !isTranslucent() && !this.isCustomFullScreen) {
                ViewHelper.addStateBarViewSpace(this.mView.b, R.color.CAM_X0303, false);
            }
            if (!this.mIsTranslucent) {
                adjustResizeForSoftInput();
            }
            registerListener(this.webviewLoginListener);
            if (isNeedShowADItem()) {
                this.mView.z(true);
            }
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, str4)) == null) {
            ShareItem shareItem = new ShareItem();
            if (StringUtils.isNull(this.mUrlTitle, true)) {
                shareItem.v = getResources().getString(R.string.share_from_tieba);
            } else {
                shareItem.v = this.mUrlTitle;
            }
            shareItem.x = this.mUrl;
            if (StringUtils.isNull(this.mSource, true)) {
                shareItem.w = this.mUrl;
            } else {
                String findSubString = findSubString(SHARE_CONTENT_START, "\"");
                if (StringUtils.isNull(findSubString, true)) {
                    shareItem.w = this.mUrl;
                } else {
                    shareItem.w = findSubString;
                }
                String findSubString2 = findSubString(SHARE_IMG_START, "\"");
                if (!StringUtils.isNull(findSubString2, true)) {
                    shareItem.z = Uri.parse(findSubString2);
                }
                String findSubString3 = findSubString(SHARE_URL_START, "\"");
                if (!StringUtils.isNull(findSubString3, true)) {
                    shareItem.x = findSubString3;
                }
            }
            updateShareItem(shareItem);
            if (!TextUtils.isEmpty(str)) {
                shareItem.v = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                shareItem.x = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                shareItem.w = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                shareItem.z = Uri.parse(str4);
            }
            shareItem.g = true;
            shareItem.u = this.mUrl;
            shareItem.I = 13;
            Bundle bundle = new Bundle();
            bundle.putString(TiebaStatic.Params.OBJ_URL, shareItem.x);
            shareItem.l(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLLLL.objValue;
    }

    public void finish(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, intent) == null) {
            setResult(i, intent);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i, keyEvent)) == null) {
            if (i == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            super.onClick(view2);
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091e45) {
                if (isTranslucent()) {
                    finish();
                }
            } else if (id == R.id.widget_navi_share_button) {
                if (this.mView.A) {
                    loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                    jg.a().post(this.mShareRunnable);
                    this.mShareResultToFe = true;
                    return;
                }
                showShare();
            }
        }
    }

    public boolean parseUrlParam(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, str, str2)) == null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(str)) {
                if (StringUtils.isNull(str2)) {
                    str2 = this.mUrl;
                } else if (!gi.isEquals(oq5.c(str2, KEY_NO_NAVIGATIONBAR), "=")) {
                    try {
                        str2 = URLDecoder.decode(str2.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                try {
                    String query = new URL(str2).getQuery();
                    if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                        return true;
                    }
                    for (String str3 : split) {
                        String[] split2 = str3.split("=");
                        if (split2 != null && split2.length == 2) {
                            String str4 = split2[0];
                            String str5 = split2[1];
                            if (str.equalsIgnoreCase(str4) && "1".equalsIgnoreCase(str5)) {
                                return false;
                            }
                        }
                    }
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void showTipToast(boolean z, String str, int i) {
        mt4 mt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i)}) == null) && (mt4Var = this.mView) != null) {
            mt4Var.T(z, str, i);
        }
    }
}
