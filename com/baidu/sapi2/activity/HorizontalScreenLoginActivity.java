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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.a.c;
import d.a.b0.a.f;
/* loaded from: classes2.dex */
public class HorizontalScreenLoginActivity extends LoginActivity {
    public static /* synthetic */ Interceptable $ic;
    public static int H;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class AndroidBug5497Workaround {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f9770a;

        /* renamed from: b  reason: collision with root package name */
        public View f9771b;

        /* renamed from: c  reason: collision with root package name */
        public WebView f9772c;

        /* renamed from: d  reason: collision with root package name */
        public int f9773d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout.LayoutParams f9774e;

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
            this.f9771b = childAt;
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AndroidBug5497Workaround f9775a;

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
                    this.f9775a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9775a.b();
                    }
                }
            });
            this.f9774e = (FrameLayout.LayoutParams) this.f9771b.getLayoutParams();
            this.f9772c = a((ViewGroup) this.f9771b);
            this.f9770a = activity.getWindowManager().getDefaultDisplay().getWidth();
        }

        public static void assistActivity(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity) == null) {
                new AndroidBug5497Workaround(activity);
            }
        }

        private WebView a(ViewGroup viewGroup) {
            InterceptResult invokeL;
            WebView a2;
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
                    if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                        return a2;
                    }
                }
                return null;
            }
            return (WebView) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (a2 = a()) == this.f9773d) {
                return;
            }
            int i2 = this.f9770a;
            int i3 = i2 - a2;
            int i4 = i2 / 4;
            if (i3 > i4) {
                this.f9774e.height = i2 - i3;
            } else {
                this.f9774e.height = i2;
            }
            this.f9771b.requestLayout();
            if (i3 > i4) {
                if (this.f9772c.getUrl() != null && (this.f9772c.getUrl().endsWith("/sms_login_new") || this.f9772c.getUrl().contains("sms_login") || this.f9772c.getUrl().contains("act=bind_mobile"))) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.AndroidBug5497Workaround.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AndroidBug5497Workaround f9776a;

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
                            this.f9776a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f9776a.f9772c.scrollTo(0, HorizontalScreenLoginActivity.H);
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

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AndroidBug5497Workaround f9777a;

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
                        this.f9777a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f9777a.f9772c.scrollTo(0, 0);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }, 200L);
            }
            this.f9773d = a2;
        }

        private int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Rect rect = new Rect();
                this.f9771b.getWindowVisibleDisplayFrame(rect);
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
                setContentView(f.layout_sapi_sdk_horizontal_screen_webview_with_title_bar);
                AndroidBug5497Workaround.assistActivity(this);
                init();
                setupViews();
                ((LoginActivity) this).sapiWebView.setVerticalScrollBarEnabled(false);
                ((LoginActivity) this).sapiWebView.setVerticalFadingEdgeEnabled(false);
                ((LoginActivity) this).sapiWebView.setFocusEdittextCoordinateYCallBack(new SapiJsCallBacks.FocusEdittextCoordinateYCallBack(this) { // from class: com.baidu.sapi2.activity.HorizontalScreenLoginActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ HorizontalScreenLoginActivity f9769a;

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
                        this.f9769a = this;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.FocusEdittextCoordinateYCallBack
                    public void onCallback(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            int unused = HorizontalScreenLoginActivity.H = (int) (i2 * this.f9769a.getResources().getDisplayMetrics().density);
                        }
                    }
                });
                ((LoginActivity) this).sapiWebView.setOverScrollMode(2);
                SapiWebView sapiWebView = ((LoginActivity) this).sapiWebView;
                if (sapiWebView instanceof RoundWebview) {
                    RoundWebview roundWebview = (RoundWebview) sapiWebView;
                    roundWebview.a(getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius), getResources().getDimension(c.sapi_sdk_webview_radius));
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
