package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.a.a;
import c.a.e0.a.b;
import c.a.e0.a.d;
import c.a.e0.a.e;
import c.a.e0.a.f;
import c.a.e0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RemoteProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38029f = ":pass";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38030b;
    public View bottomBackView;

    /* renamed from: c  reason: collision with root package name */
    public String f38031c;
    public SapiConfiguration configuration;

    /* renamed from: d  reason: collision with root package name */
    public String f38032d;
    public View dividerLine;

    /* renamed from: e  reason: collision with root package name */
    public WebView f38033e;
    public ImageView mBottomBackBtnIv;
    public TextView mBottomBackTvText;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public View noNetworkView;
    public ProgressBar progressBar;

    public RemoteProcessWebviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.a = getIntent().getBooleanExtra(EXTRA_IS_DARK_MODE, false);
            this.f38030b = getIntent().getBooleanExtra(EXTRA_SHOW_BOTTOM_BACK, false);
            this.f38031c = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
            this.f38032d = getIntent().getStringExtra("external_url");
        }
    }

    private void c() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.a) {
                setTheme(h.SDKDarkTheme);
            }
            this.f38033e = (WebView) findViewById(e.webview);
            this.mTitle = (TextView) findViewById(e.title);
            ImageView imageView = (ImageView) findViewById(e.title_btn_left_iv);
            this.mLeftBtnIv = imageView;
            imageView.setOnClickListener(this);
            this.mLeftBtnLayout = (LinearLayout) findViewById(e.title_left_btn_layout);
            this.dividerLine = findViewById(e.title_divider_line);
            this.mTitleBgLayout = (RelativeLayout) findViewById(e.sapi_title_bg_layout);
            this.mTitle.setText(this.f38031c);
            if (this.f38030b) {
                if (this.bottomBackView == null && (viewStub = (ViewStub) findViewById(e.stub_bottom_back)) != null) {
                    this.bottomBackView = viewStub.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(e.sapi_bottom_back);
                    this.mBottomBackTvText = (TextView) findViewById(e.sapi_textview_back);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(e.sapi_layout_bottom_back);
                    this.mBottomDividerLine = (ImageView) findViewById(e.sapi_sdk_bottom_divider_line);
                    this.mBottomBackBtnIv.setOnClickListener(this);
                    this.mBottomBackTvText.setOnClickListener(this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                    ViewUtility.setViewClickAlpha(this.mBottomBackTvText, 0.2f);
                    this.mBottomBackTvText.setVisibility(this.configuration.isShowBottomBackText ? 0 : 8);
                }
                this.mLeftBtnIv.setVisibility(8);
            }
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null) {
                ViewUtility.enlargedViews(this.mLeftBtnIv, sapiConfiguration.textZoom);
                ViewUtility.enlargedViews(this.mTitle, this.configuration.textZoom);
                ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.configuration.textZoom);
                ViewUtility.enlargedViews(this.mBottomBackTvText, this.configuration.textZoom);
            }
            if (this.a) {
                this.mTitleBgLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                this.mLeftBtnIv.setImageResource(d.sapi_sdk_btn_back_dark_mode);
                this.mTitle.setTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                this.dividerLine.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                ImageView imageView2 = this.mBottomBackBtnIv;
                if (imageView2 != null) {
                    imageView2.setImageResource(d.sapi_sdk_btn_back_dark_mode);
                }
                RelativeLayout relativeLayout = this.mBottomBgLayout;
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                }
                TextView textView = this.mBottomBackTvText;
                if (textView != null) {
                    textView.setTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                }
                ImageView imageView3 = this.mBottomDividerLine;
                if (imageView3 != null) {
                    imageView3.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                }
            }
            a();
            this.f38033e.loadUrl(this.f38032d);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            a(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                String curProcessName = SapiUtils.getCurProcessName(this);
                if (!TextUtils.isEmpty(curProcessName) && curProcessName.endsWith(f38029f)) {
                    try {
                        WebView.setDataDirectorySuffix(curProcessName);
                    } catch (Throwable unused) {
                    }
                }
            }
            super.onCreate(bundle);
            if (this.configuration == null) {
                this.configuration = SapiAccountManager.getInstance().getConfignation();
            }
            setContentView(f.layout_sapi_sdk_normal_webview_with_title_bar);
            a(true);
            b();
            c();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            try {
                Process.killProcess(Process.myPid());
            } catch (Throwable unused) {
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            WebSettings settings = this.f38033e.getSettings();
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Exception unused) {
            }
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            settings.setDomStorageEnabled(true);
            this.f38033e.setScrollBarStyle(0);
            settings.setSaveFormData(false);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            try {
                ProgressBar progressBar = new ProgressBar(this, null, 16842872);
                this.progressBar = progressBar;
                progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(this, 2.0f), 0, 0));
                this.progressBar.setBackgroundColor(getResources().getColor(b.sapi_sdk_explain_camera_detail_color));
                this.f38033e.addView(this.progressBar);
            } catch (Throwable th) {
                Log.e(th);
            }
            this.f38033e.setWebChromeClient(new WebChromeClient(this) { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RemoteProcessWebviewActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLLL = interceptable2.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("errno", "0");
                        } catch (JSONException unused2) {
                        }
                        jsPromptResult.confirm(jSONObject.toString());
                        return true;
                    }
                    return invokeLLLLL.booleanValue;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2) == null) {
                        ProgressBar progressBar2 = this.a.progressBar;
                        if (progressBar2 != null) {
                            if (i2 == 100) {
                                progressBar2.setVisibility(8);
                            } else {
                                if (progressBar2.getVisibility() == 8) {
                                    this.a.progressBar.setVisibility(0);
                                }
                                this.a.progressBar.setProgress(i2);
                            }
                        }
                        super.onProgressChanged(webView, i2);
                    }
                }
            });
            this.f38033e.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.sapi2.activity.RemoteProcessWebviewActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RemoteProcessWebviewActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, webView, str, bitmap) == null) {
                        super.onPageStarted(webView, str, bitmap);
                        if (SapiUtils.hasActiveNetwork(this.a)) {
                            return;
                        }
                        RemoteProcessWebviewActivity remoteProcessWebviewActivity = this.a;
                        if (remoteProcessWebviewActivity.noNetworkView == null) {
                            remoteProcessWebviewActivity.noNetworkView = com.baidu.sapi2.utils.b.a(remoteProcessWebviewActivity, remoteProcessWebviewActivity.f38033e);
                            this.a.f38033e.addView(this.a.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
                        }
                        this.a.noNetworkView.setVisibility(0);
                    }
                }
            });
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            int i2 = a.sapi_sdk_slide_right_in;
            int i3 = a.sapi_sdk_slide_right_out;
            if (z) {
                overridePendingTransition(i2, a.sapi_sdk_slide_left_out);
            } else {
                overridePendingTransition(a.sapi_sdk_slide_left_in, i3);
            }
        }
    }
}
