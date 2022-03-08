package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HorizontalScreenLoginActivity extends LoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public static int I;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class AndroidBug5497Workaround {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public View f36656b;

        /* renamed from: c  reason: collision with root package name */
        public WebView f36657c;

        /* renamed from: d  reason: collision with root package name */
        public int f36658d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout.LayoutParams f36659e;

        public AndroidBug5497Workaround(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
            this.f36656b = childAt;
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AndroidBug5497Workaround a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.b();
                    }
                }
            });
            this.f36659e = (FrameLayout.LayoutParams) this.f36656b.getLayoutParams();
            this.f36657c = a((ViewGroup) this.f36656b);
            this.a = activity.getWindowManager().getDefaultDisplay().getWidth();
        }

        public static void assistActivity(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity) == null) {
                new AndroidBug5497Workaround(activity);
            }
        }

        private WebView a(ViewGroup viewGroup) {
            InterceptResult invokeL;
            WebView a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, viewGroup)) == null) {
                if (viewGroup == null) {
                    return null;
                }
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof WebView) {
                        return (WebView) childAt;
                    }
                    if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                        return a;
                    }
                }
                return null;
            }
            return (WebView) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (a = a()) == this.f36658d) {
                return;
            }
            int i2 = this.a;
            int i3 = i2 - a;
            int i4 = i2 / 4;
            if (i3 > i4) {
                this.f36659e.height = i2 - i3;
            } else {
                this.f36659e.height = i2;
            }
            this.f36656b.requestLayout();
            if (i3 > i4) {
                if (this.f36657c.getUrl() != null && (this.f36657c.getUrl().endsWith("/sms_login_new") || this.f36657c.getUrl().contains("sms_login") || this.f36657c.getUrl().contains("act=bind_mobile"))) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AndroidBug5497Workaround a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.a.f36657c.scrollTo(0, HorizontalScreenLoginActivity.I);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }, 200L);
                }
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AndroidBug5497Workaround a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.a.f36657c.scrollTo(0, 0);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }, 200L);
            }
            this.f36658d = a;
        }

        private int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Rect rect = new Rect();
                this.f36656b.getWindowVisibleDisplayFrame(rect);
                return rect.bottom - rect.top;
            }
            return invokeV.intValue;
        }
    }

    public HorizontalScreenLoginActivity() {
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

    @Override // com.baidu.sapi2.activity.LoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            ViewUtility.setOrientationToUndefined(this);
            super.onCreate(bundle);
            try {
                setContentView(R.layout.layout_sapi_sdk_horizontal_screen_webview_with_title_bar);
                AndroidBug5497Workaround.assistActivity(this);
                init();
                setupViews();
                ((LoginActivity) this).sapiWebView.setVerticalScrollBarEnabled(false);
                ((LoginActivity) this).sapiWebView.setVerticalFadingEdgeEnabled(false);
                ((LoginActivity) this).sapiWebView.setFocusEdittextCoordinateYCallBack(new SapiJsCallBacks.FocusEdittextCoordinateYCallBack(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HorizontalScreenLoginActivity a;

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

                    @Override // com.baidu.sapi2.SapiJsCallBacks.FocusEdittextCoordinateYCallBack
                    public void onCallback(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            int unused = HorizontalScreenLoginActivity.I = (int) (i2 * this.a.getResources().getDisplayMetrics().density);
                        }
                    }
                });
                ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
                SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
                if (sapiWebView instanceof RoundWebview) {
                    RoundWebview roundWebview = (RoundWebview) sapiWebView;
                    roundWebview.a(getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius));
                    roundWebview.setLayerType(1, null);
                }
            } catch (Throwable th) {
                reportWebviewError(th);
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
                loginFail(this.webAuthResult);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
        }
    }
}
