package com.baidu.mobads.container.landingpage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.landingpage.NativeActionBar;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.EuiLeakFixUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AppPriActivity implements IActivityImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIONBAR_VIEW_ID = 1010;
    public static final String PRIVACY_LINK = "privacy_link";
    public static final String TAG = "AppPriActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public RemoteXAdLogger mAdLogger;
    public LinearLayout mLlContainer;
    public NativeActionBar mNativeActionBar;
    public RelativeLayout mRlContainer;
    public XMyWebView mXMyWebView;
    public Activity proxyActivity;
    public RelativeLayout wvTool;

    /* loaded from: classes7.dex */
    public class CustomProgressBar extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Paint mPaint;
        public int mProgress;
        public int mScreenWidth;
        public final /* synthetic */ AppPriActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomProgressBar(AppPriActivity appPriActivity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appPriActivity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = appPriActivity;
            this.mProgress = 0;
            this.mScreenWidth = 0;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setColor(Color.parseColor("#483D8B"));
            this.mScreenWidth = ScreenUtils.getScreenRect(appPriActivity.proxyActivity.getApplicationContext()).width();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                canvas.drawRect(0.0f, 0.0f, (this.mScreenWidth * this.mProgress) / 100, getLayoutParams().height, this.mPaint);
            }
        }

        public void setProgress(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.mProgress) {
                return;
            }
            this.mProgress = i2;
            postInvalidate();
        }
    }

    public AppPriActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
    }

    private void addGlobalViews(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            this.wvTool = new RelativeLayout(this.proxyActivity);
            this.mLlContainer = new LinearLayout(this.proxyActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.mLlContainer.setOrientation(1);
            this.wvTool.addView(this.mLlContainer, layoutParams);
            initActionBar();
            this.mLlContainer.addView(this.mNativeActionBar, new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(this.proxyActivity, 46)));
            this.mRlContainer = initFrame(str);
            this.mLlContainer.addView(this.mRlContainer, new RelativeLayout.LayoutParams(-1, -1));
            this.wvTool.setBackgroundColor(-1);
            this.proxyActivity.setContentView(this.wvTool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.proxyActivity.finish();
        }
    }

    private void initActionBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            NativeActionBar nativeActionBar = new NativeActionBar(this.proxyActivity);
            this.mNativeActionBar = nativeActionBar;
            nativeActionBar.setId(1010);
            this.mNativeActionBar.setmGButtonClickListener(new NativeActionBar.OnGButtonClickListener(this) { // from class: com.baidu.mobads.container.landingpage.AppPriActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppPriActivity this$0;

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
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.container.landingpage.NativeActionBar.OnGButtonClickListener
                public void onGoBackBttonClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.finishActivity();
                    }
                }
            });
        }
    }

    @TargetApi(3)
    private RelativeLayout initFrame(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            CustomProgressBar customProgressBar = new CustomProgressBar(this, this.proxyActivity);
            XMyWebView.ParameterInfo parameterInfo = new XMyWebView.ParameterInfo();
            parameterInfo.mCloseHardwareAccelerated = false;
            XMyWebView create = XMyWebView.create(this.proxyActivity, RemoteXAdLogger.getInstance(), true, true, parameterInfo);
            this.mXMyWebView = create;
            create.curUrl = str;
            create.getSettings().setUseWideViewPort(true);
            this.mXMyWebView.getSettings().setBuiltInZoomControls(true);
            try {
                this.mXMyWebView.loadUrl(str);
            } catch (Exception unused) {
            }
            try {
                WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.mXMyWebView.getSettings(), Boolean.FALSE);
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            this.mXMyWebView.setWebChromeClient(new WebChromeClient(this, customProgressBar) { // from class: com.baidu.mobads.container.landingpage.AppPriActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppPriActivity this$0;
                public final /* synthetic */ CustomProgressBar val$prgBar;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, customProgressBar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$prgBar = customProgressBar;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    CustomProgressBar customProgressBar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) || (customProgressBar2 = this.val$prgBar) == null) {
                        return;
                    }
                    customProgressBar2.setProgress(i2);
                    if (i2 > 50) {
                        this.val$prgBar.setVisibility(i2 >= 100 ? 4 : 0);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onReceivedTitle(WebView webView, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str2) == null) {
                        super.onReceivedTitle(webView, str2);
                        if (this.this$0.mNativeActionBar != null) {
                            this.this$0.mNativeActionBar.setTitle(str2);
                        }
                    }
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(this.proxyActivity);
            relativeLayout.addView(this.mXMyWebView, new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(customProgressBar, new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(this.proxyActivity.getApplicationContext(), 2)));
            return relativeLayout;
        }
        return (RelativeLayout) invokeL.objValue;
    }

    private void sendLpBroadcast() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.proxyActivity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("lp_close");
        this.proxyActivity.sendBroadcast(intent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || (intent = this.proxyActivity.getIntent()) == null) {
            return;
        }
        addGlobalViews(intent.getStringExtra(PRIVACY_LINK));
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.mXMyWebView != null) {
                    this.mXMyWebView.removeAllViews();
                    ((ViewGroup) this.mXMyWebView.getParent()).removeView(this.mXMyWebView);
                    this.mXMyWebView.stopLoading();
                    this.mXMyWebView.destroy();
                    this.mXMyWebView = null;
                }
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            sendLpBroadcast();
            try {
                EuiLeakFixUtils.fixLeakCanaryOnEui(this.proxyActivity.getApplicationContext());
            } catch (Throwable th) {
                this.mAdLogger.d(TAG, th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            this.proxyActivity = activity;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) {
        }
    }
}
