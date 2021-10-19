package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class SlideActiviy extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "SlideActivity";
    public static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    public static final String ADDRESS_PAGE_NAME = "address";
    public static final boolean B = true;
    public static final String EXTRAS_ACTION = "action";
    public static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    public static final String INVOICE_PAGE_NAME = "invoice";
    public static final String SLIDE_ACTION_QUIT = "quit";
    public transient /* synthetic */ FieldHolder $fh;
    public SlideHelper mSlideHelper;
    public boolean t;
    public boolean u;
    public boolean v;
    public SlideInterceptor w;
    public SlidingPaneLayout.PanelSlideListener x;
    public boolean y;
    public WeakReference<Activity> z;

    /* loaded from: classes5.dex */
    public class PassSlideInterceptor implements SlideInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SlideActiviy f44769a;

        public PassSlideInterceptor(SlideActiviy slideActiviy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideActiviy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44769a = slideActiviy;
        }

        @Override // com.baidu.searchbox.widget.SlideInterceptor
        public boolean isSlidable(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) ? this.f44769a.y : invokeL.booleanValue;
        }
    }

    public SlideActiviy() {
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
        this.t = false;
        this.u = false;
        this.v = false;
        this.y = true;
    }

    public void finishActivityAfterSlideOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            finish();
        }
    }

    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.v = z;
        }
    }

    public void loadSlideWebview(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            Log.d(A, "onConfigurationChanged: ");
            SlideHelper slideHelper = this.mSlideHelper;
            if (slideHelper != null) {
                slideHelper.setCanSlide(configuration.orientation != 2);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            ViewUtility.setOrientationToUndefined(this);
            super.onCreate(bundle);
            if (this.configuration.supportGestureSlide) {
                this.t = true;
            } else {
                this.t = false;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            Log.d(A, "onDetachedFromWindow: ");
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onPostCreate(bundle);
            Log.d(A, "onPostCreate");
            a();
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPostResume();
            Log.d(A, "onPostResume: ");
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            Log.d(A, "onResume: ");
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            Log.d(A, "onStart: ");
        }
    }

    public void setCurrentActivityNoTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SlideUtil.convertFromTranslucent(this, new OnTranslucentListener(this) { // from class: com.baidu.sapi2.activity.SlideActiviy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SlideActiviy f44766a;

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
                    this.f44766a = this;
                }

                @Override // com.baidu.searchbox.widget.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    }
                }
            });
        }
    }

    public void setEnableSliding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.t = z;
        }
    }

    public void setEnableTaskRootSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.u = z;
        }
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, panelSlideListener) == null) {
            this.x = panelSlideListener;
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.setupViews();
            this.sapiWebView.setLoadSlideWebViewCallback(new SapiWebView.LoadSlideWebViewCallback(this) { // from class: com.baidu.sapi2.activity.SlideActiviy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SlideActiviy f44764a;

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
                    this.f44764a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback
                public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, loadSlideWebViewResult) == null) {
                        this.f44764a.loadSlideWebview(loadSlideWebViewResult.page, loadSlideWebViewResult.url, loadSlideWebViewResult.adapter);
                    }
                }
            });
            this.sapiWebView.setStopSlideWebviewCallback(new SapiJsCallBacks.StopSlideWebviewCallback(this) { // from class: com.baidu.sapi2.activity.SlideActiviy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SlideActiviy f44765a;

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
                    this.f44765a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback
                public void onStopSlide(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            Log.d(SlideActiviy.A, "Slide should be opened now");
                            this.f44765a.y = false;
                        } else {
                            Log.d(SlideActiviy.A, "Slide should be closed now");
                            this.f44765a.y = true;
                        }
                        SlideActiviy slideActiviy = this.f44765a;
                        slideActiviy.w = new PassSlideInterceptor();
                        SlideActiviy slideActiviy2 = this.f44765a;
                        slideActiviy2.mSlideHelper.setSlideInterceptor(slideActiviy2.w);
                    }
                }
            });
        }
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, slideInterceptor) == null) {
            this.t = z;
            this.w = slideInterceptor;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.t) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.u && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                Log.e(A, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.v);
            this.mSlideHelper.setSlideInterceptor(this.w);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener(this, i2) { // from class: com.baidu.sapi2.activity.SlideActiviy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f44767a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SlideActiviy f44768b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f44768b = this;
                    this.f44767a = i2;
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f44768b.x != null) {
                            this.f44768b.x.onPanelClosed(view);
                        }
                        this.f44768b.a(0.0f);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        if (this.f44768b.x != null) {
                            this.f44768b.x.onPanelOpened(view);
                        }
                        this.f44768b.a(0.0f);
                        this.f44768b.mSlideHelper.setShadowDrawable(null);
                        this.f44768b.finishActivityAfterSlideOver();
                        this.f44768b.overridePendingTransition(0, 0);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                        View maskView = this.f44768b.mSlideHelper.getMaskView();
                        if (maskView != null) {
                            float f3 = 1.0f - f2;
                            if (f3 < 0.0f) {
                                f3 = 0.0f;
                            }
                            maskView.setAlpha(f3);
                        }
                        if (this.f44768b.x != null) {
                            this.f44768b.x.onPanelSlide(view, f2);
                        }
                        float f4 = this.f44767a >> 2;
                        this.f44768b.a((f2 * f4) - f4);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            try {
                if (this.z == null || this.z.get() == null) {
                    this.z = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
                }
                if (this.z.get() != null) {
                    Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                    Activity activity = this.z.get();
                    if (realTopActivity != null && activity != null && realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
                        a(activity, 0.0f);
                    } else {
                        a(activity, f2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(Activity activity, float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, f2) == null) || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) == null) {
            return;
        }
        viewGroup.setX(f2);
    }
}
