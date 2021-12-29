package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.ActivityStackManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public class NaSlideActiviy extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f39319g = "NaSlideActivity";

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f39320h = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39321b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39322c;
    public SapiConfiguration configuration;

    /* renamed from: d  reason: collision with root package name */
    public SlideInterceptor f39323d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingPaneLayout.PanelSlideListener f39324e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Activity> f39325f;
    public SlideHelper mSlideHelper;

    public NaSlideActiviy() {
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
        this.a = false;
        this.f39321b = false;
        this.f39322c = false;
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
                declaredField.setAccessible(false);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
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
            this.f39322c = z;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            Log.d(f39319g, "onConfigurationChanged: ");
            SlideHelper slideHelper = this.mSlideHelper;
            if (slideHelper != null) {
                slideHelper.setCanSlide(configuration.orientation != 2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.Window, android.app.Activity] */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (Build.VERSION.SDK_INT == 26) {
                b();
            }
            super.onCreate(bundle);
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.supportGestureSlide) {
                this.a = true;
            } else {
                this.a = false;
            }
            ?? window = getWindow();
            if (window != 0) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            LogUtil.logActivity(window, "onCreate");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onPostCreate(bundle);
            Log.d(f39319g, "onPostCreate");
            a();
        }
    }

    public void setCurrentActivityNoTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SlideUtil.convertFromTranslucent(this, new OnTranslucentListener(this) { // from class: com.baidu.sapi2.activity.NaSlideActiviy.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NaSlideActiviy a;

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
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a = z;
        }
    }

    public void setEnableTaskRootSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f39321b = z;
        }
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, panelSlideListener) == null) {
            this.f39324e = panelSlideListener;
        }
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, slideInterceptor) == null) {
            this.a = z;
            this.f39323d = slideInterceptor;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.a) {
            boolean z = getResources().getConfiguration().orientation != 2;
            if (!this.f39321b && isTaskRoot()) {
                z = false;
            }
            if ((getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                Log.e(f39319g, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideActivity(this);
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.f39322c);
            this.mSlideHelper.setSlideInterceptor(this.f39323d);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener(this, i2) { // from class: com.baidu.sapi2.activity.NaSlideActiviy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NaSlideActiviy f39326b;

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
                    this.f39326b = this;
                    this.a = i2;
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f39326b.f39324e != null) {
                            this.f39326b.f39324e.onPanelClosed(view);
                        }
                        this.f39326b.a(0.0f);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        if (this.f39326b.f39324e != null) {
                            this.f39326b.f39324e.onPanelOpened(view);
                        }
                        this.f39326b.a(0.0f);
                        this.f39326b.mSlideHelper.setShadowDrawable(null);
                        this.f39326b.finishActivityAfterSlideOver();
                        this.f39326b.overridePendingTransition(0, 0);
                    }
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                        View maskView = this.f39326b.mSlideHelper.getMaskView();
                        if (maskView != null) {
                            float f3 = 1.0f - f2;
                            if (f3 < 0.0f) {
                                f3 = 0.0f;
                            }
                            maskView.setAlpha(f3);
                        }
                        if (this.f39326b.f39324e != null) {
                            this.f39326b.f39324e.onPanelSlide(view, f2);
                        }
                        float f4 = this.a >> 2;
                        this.f39326b.a((f2 * f4) - f4);
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
                if (this.f39325f == null || this.f39325f.get() == null) {
                    this.f39325f = new WeakReference<>(ActivityStackManager.getInstance().getPenultimateActivity());
                }
                if (this.f39325f.get() != null) {
                    Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
                    Activity activity = this.f39325f.get();
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, f2) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        activity.getWindow().getDecorView();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        if (viewGroup != null) {
            viewGroup.setX(f2);
        }
    }
}
