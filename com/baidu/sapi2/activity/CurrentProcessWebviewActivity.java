package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CurrentProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public View bottomBackView;
    public String c;
    public SapiConfiguration configuration;
    public String d;
    public View dividerLine;
    public WebView e;
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

    public CurrentProcessWebviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
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

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.configuration == null) {
                this.configuration = SapiAccountManager.getInstance().getConfignation();
            }
            setContentView(R.layout.obfuscated_res_0x7f0d0500);
            a(true);
            b();
            c();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            WebSettings settings = this.e.getSettings();
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Exception unused) {
            }
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            settings.setDomStorageEnabled(true);
            this.e.setScrollBarStyle(0);
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
                this.progressBar.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060a02));
                this.e.addView(this.progressBar);
            } catch (Throwable th) {
                Log.e(th);
            }
            this.e.setWebChromeClient(new WebChromeClient(this) { // from class: com.baidu.sapi2.activity.CurrentProcessWebviewActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CurrentProcessWebviewActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                public void onProgressChanged(WebView webView, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i) == null) {
                        ProgressBar progressBar2 = this.a.progressBar;
                        if (progressBar2 != null) {
                            if (i == 100) {
                                progressBar2.setVisibility(8);
                            } else {
                                if (progressBar2.getVisibility() == 8) {
                                    this.a.progressBar.setVisibility(0);
                                }
                                this.a.progressBar.setProgress(i);
                            }
                        }
                        super.onProgressChanged(webView, i);
                    }
                }
            });
            this.e.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.sapi2.activity.CurrentProcessWebviewActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CurrentProcessWebviewActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        if (!SapiUtils.hasActiveNetwork(this.a)) {
                            CurrentProcessWebviewActivity currentProcessWebviewActivity = this.a;
                            if (currentProcessWebviewActivity.noNetworkView == null) {
                                currentProcessWebviewActivity.noNetworkView = b.a(currentProcessWebviewActivity, currentProcessWebviewActivity.e);
                                this.a.e.addView(this.a.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
                            }
                            this.a.noNetworkView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                overridePendingTransition(R.anim.obfuscated_res_0x7f01011c, R.anim.obfuscated_res_0x7f01011b);
            } else {
                overridePendingTransition(R.anim.obfuscated_res_0x7f01011a, R.anim.obfuscated_res_0x7f01011d);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.a = getIntent().getBooleanExtra("is_dark_mode", false);
            this.b = getIntent().getBooleanExtra("show_bottom_back", false);
            this.c = getIntent().getStringExtra("external_title");
            this.d = getIntent().getStringExtra("external_url");
        }
    }

    private void c() {
        ViewStub viewStub;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.a) {
                setTheme(R.style.obfuscated_res_0x7f10017c);
            }
            this.e = (WebView) findViewById(R.id.obfuscated_res_0x7f092642);
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f092203);
            ImageView imageView = (ImageView) findViewById(R.id.title_btn_left_iv);
            this.mLeftBtnIv = imageView;
            imageView.setOnClickListener(this);
            this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.title_left_btn_layout);
            this.dividerLine = findViewById(R.id.title_divider_line);
            this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.sapi_title_bg_layout);
            this.mTitle.setText(this.c);
            if (this.b) {
                if (this.bottomBackView == null && (viewStub = (ViewStub) findViewById(R.id.stub_bottom_back)) != null) {
                    this.bottomBackView = viewStub.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(R.id.sapi_bottom_back);
                    this.mBottomBackTvText = (TextView) findViewById(R.id.sapi_textview_back);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.sapi_layout_bottom_back);
                    this.mBottomDividerLine = (ImageView) findViewById(R.id.sapi_sdk_bottom_divider_line);
                    this.mBottomBackBtnIv.setOnClickListener(this);
                    this.mBottomBackTvText.setOnClickListener(this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                    ViewUtility.setViewClickAlpha(this.mBottomBackTvText, 0.2f);
                    TextView textView = this.mBottomBackTvText;
                    if (this.configuration.isShowBottomBackText) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    textView.setVisibility(i);
                }
                this.mLeftBtnIv.setVisibility(8);
            }
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null) {
                ViewUtility.enlargedViews(this.mLeftBtnIv, sapiConfiguration.getTextZoom());
                ViewUtility.enlargedViews(this.mTitle, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackTvText, this.configuration.getTextZoom());
            }
            if (this.a) {
                this.mTitleBgLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                this.mLeftBtnIv.setImageResource(R.drawable.obfuscated_res_0x7f081041);
                this.mTitle.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609df));
                this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                this.dividerLine.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                ImageView imageView2 = this.mBottomBackBtnIv;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.obfuscated_res_0x7f081041);
                }
                RelativeLayout relativeLayout = this.mBottomBgLayout;
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                }
                TextView textView2 = this.mBottomBackTvText;
                if (textView2 != null) {
                    textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609df));
                }
                ImageView imageView3 = this.mBottomDividerLine;
                if (imageView3 != null) {
                    imageView3.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609e2));
                }
            }
            a();
            this.e.loadUrl(this.d);
        }
    }
}
