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
/* loaded from: classes2.dex */
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

    public void loadSlideWebview(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class PassSlideInterceptor implements SlideInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SlideActiviy a;

        public PassSlideInterceptor(SlideActiviy slideActiviy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideActiviy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = slideActiviy;
        }

        @Override // com.baidu.searchbox.widget.SlideInterceptor
        public boolean isSlidable(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.y) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public SlideActiviy() {
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

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            Log.d(A, "onDetachedFromWindow: ");
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
                public final /* synthetic */ SlideActiviy a;

                @Override // com.baidu.searchbox.widget.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    }
                }

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
            });
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
                public final /* synthetic */ SlideActiviy a;

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

                @Override // com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback
                public void loadSlideWebview(SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, loadSlideWebViewResult) == null) {
                        this.a.loadSlideWebview(loadSlideWebViewResult.page, loadSlideWebViewResult.url, loadSlideWebViewResult.adapter);
                    }
                }
            });
            this.sapiWebView.setStopSlideWebviewCallback(new SapiJsCallBacks.StopSlideWebviewCallback(this) { // from class: com.baidu.sapi2.activity.SlideActiviy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SlideActiviy a;

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

                @Override // com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback
                public void onStopSlide(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            Log.d(SlideActiviy.A, "Slide should be opened now");
                            this.a.y = false;
                        } else {
                            Log.d(SlideActiviy.A, "Slide should be closed now");
                            this.a.y = true;
                        }
                        SlideActiviy slideActiviy = this.a;
                        slideActiviy.w = new PassSlideInterceptor();
                        SlideActiviy slideActiviy2 = this.a;
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
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.t) {
            int i = 0;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            } else {
                z = true;
            }
            if (!this.u && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                Log.e(A, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.widthPixels;
            }
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.v);
            this.mSlideHelper.setSlideInterceptor(this.w);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener(this, i) { // from class: com.baidu.sapi2.activity.SlideActiviy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ SlideActiviy b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = i;
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view2, float f) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                        View maskView = this.b.mSlideHelper.getMaskView();
                        if (maskView != null) {
                            float f2 = 1.0f - f;
                            if (f2 < 0.0f) {
                                f2 = 0.0f;
                            }
                            maskView.setAlpha(f2);
                        }
                        if (this.b.x != null) {
                            this.b.x.onPanelSlide(view2, f);
                        }
                        float f3 = this.a >> 2;
                        this.b.a((f * f3) - f3);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.b.x != null) {
                            this.b.x.onPanelClosed(view2);
                        }
                        this.b.a(0.0f);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        if (this.b.x != null) {
                            this.b.x.onPanelOpened(view2);
                        }
                        this.b.a(0.0f);
                        this.b.mSlideHelper.setShadowDrawable(null);
                        this.b.finishActivityAfterSlideOver();
                        this.b.overridePendingTransition(0, 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f) == null) {
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
                        a(activity, f);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(Activity activity, float f) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, f) == null) && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) != null) {
            viewGroup.setX(f);
        }
    }

    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.v = z;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            boolean z = true;
            Log.d(A, "onConfigurationChanged: ");
            SlideHelper slideHelper = this.mSlideHelper;
            if (slideHelper != null) {
                if (configuration.orientation == 2) {
                    z = false;
                }
                slideHelper.setCanSlide(z);
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

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onPostCreate(bundle);
            Log.d(A, "onPostCreate");
            a();
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
}
