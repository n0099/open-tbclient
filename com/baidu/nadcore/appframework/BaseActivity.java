package com.baidu.nadcore.appframework;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.nadcore.widget.SlideHelper;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg0;
import com.repackage.hm0;
import com.repackage.m11;
import com.repackage.o41;
import com.repackage.p41;
import com.repackage.ty0;
import com.repackage.u01;
import com.repackage.vi0;
import com.repackage.x11;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class BaseActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int INVALID_ANIM = 0;
    public static final String KEY_WINDOWS_ANIMATING_NEED_DRAW = "winAccelerate";
    public static final String TAG = "BaseActivity";
    public static final String WINDOWS_ANIMATING_NEED_DRAW = "1";
    public static final String WINDOWS_ANIMATING_NEED_NOT_DRAW = "0";
    public static ArrayList<d> onNewIntentCallbacks;
    public static boolean sHasMultiWindowShow;
    public static int sNextEnterAnimWhenFinishing;
    public static int sNextEnterAnimWhenStarting;
    public static int sNextExitAnimWhenFinishing;
    public static int sNextExitAnimWhenStarting;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mActionBarExtObject;
    public Object mCommonMenuExtObject;
    public boolean mEnableDrawDuringWindowsAnimating;
    public boolean mEnableSliding;
    public boolean mEnableTaskRootSlide;
    public int mEnterAnimWhenFinishing;
    public int mEnterAnimWhenStarting;
    public int mExitAnimWhenFinishing;
    public int mExitAnimWhenStarting;
    public boolean mForceActivityTransparent;
    public boolean mSlideCancelActivityTransparent;
    public SlideHelper mSlideHelper;
    public SlideInterceptor mSlideInterceptor;
    public SlidingPaneLayout.e mSlideListener;
    public Object mSuspensionBallExtObject;
    public SlidingPaneLayout.e mSuspensionBallSlideListener;
    public Object mToolBarExtObject;
    public WeakReference<Activity> preActivity;
    public final Object tagObject;

    /* loaded from: classes2.dex */
    public class a implements o41 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        public a(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivity;
        }

        @Override // com.repackage.o41
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SlidingPaneLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseActivity c;

        public b(BaseActivity baseActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseActivity;
            this.b = i;
            this.a = true;
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.mSuspensionBallSlideListener != null) {
                    this.c.mSuspensionBallSlideListener.onPanelClosed(view2);
                }
                if (this.c.mSlideListener != null) {
                    this.c.mSlideListener.onPanelClosed(view2);
                }
                if (!this.c.mSlideCancelActivityTransparent && !this.c.mForceActivityTransparent && this.a) {
                    this.a = false;
                    p41.c(this.c, null);
                }
                this.c.setPreDecorPosition(0.0f);
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.c.mSuspensionBallSlideListener != null) {
                    this.c.mSuspensionBallSlideListener.onPanelOpened(view2);
                }
                if (this.c.mSlideListener != null) {
                    this.c.mSlideListener.onPanelOpened(view2);
                }
                this.c.setPreDecorPosition(0.0f);
                this.c.mSlideHelper.setShadowDrawable(null);
                this.c.finish();
                this.c.overridePendingTransition(0, 0);
            }
        }

        @Override // com.baidu.nadcore.widget.SlidingPaneLayout.e
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                View maskView = this.c.mSlideHelper.getMaskView();
                if (maskView != null) {
                    float f2 = 1.0f - f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    maskView.setAlpha(f2);
                }
                if (this.c.mSuspensionBallSlideListener != null) {
                    this.c.mSuspensionBallSlideListener.onPanelSlide(view2, f);
                }
                if (this.c.mSlideListener != null) {
                    this.c.mSlideListener.onPanelSlide(view2, f);
                }
                if (!this.c.mSlideCancelActivityTransparent && !this.c.mForceActivityTransparent && !this.a) {
                    this.a = true;
                    p41.d(this.c, null);
                }
                float f3 = this.b >> 2;
                this.c.setPreDecorPosition((f * f3) - f3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity a;

        public c(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseActivity baseActivity = this.a;
                baseActivity.setDrawDuringWindowsAnimating(baseActivity.getWindow().getDecorView());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(115536470, "Lcom/baidu/nadcore/appframework/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(115536470, "Lcom/baidu/nadcore/appframework/BaseActivity;");
                return;
            }
        }
        onNewIntentCallbacks = new ArrayList<>();
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnterAnimWhenStarting = 0;
        this.mExitAnimWhenStarting = 0;
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
        this.mEnableDrawDuringWindowsAnimating = true;
        this.mEnableSliding = false;
        this.mSlideCancelActivityTransparent = true;
        this.mEnableTaskRootSlide = false;
        this.mForceActivityTransparent = false;
        this.tagObject = new Object();
    }

    public static void addOnNewIntentCallback(d dVar) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || (arrayList = onNewIntentCallbacks) == null || dVar == null) {
            return;
        }
        synchronized (arrayList) {
            Iterator<d> it = onNewIntentCallbacks.iterator();
            while (it.hasNext()) {
                if (dVar.equals(it.next())) {
                    return;
                }
            }
            ty0.b(onNewIntentCallbacks, dVar);
        }
    }

    private void applySliding() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mEnableSliding) {
            boolean z = false;
            boolean z2 = getResources().getConfiguration().orientation != 2;
            if (this.mEnableTaskRootSlide || !isTaskRoot()) {
                z = z2;
            }
            int e = m11.c.e(this);
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.mForceActivityTransparent);
            this.mSlideHelper.attachActivity(this);
            this.mSlideHelper.setSlideInterceptor(this.mSlideInterceptor);
            this.mSlideHelper.setSlideListener(new b(this, e));
        }
    }

    public static void deleteOnNewIntentCallback(d dVar) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, dVar) == null) || (arrayList = onNewIntentCallbacks) == null || dVar == null) {
            return;
        }
        synchronized (arrayList) {
            onNewIntentCallbacks.remove(dVar);
        }
    }

    private void handleDispatchDoneAnimating(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, view2) == null) {
            try {
                ViewParent parent = view2.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleDrawDuringWindowsAnimating() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            String stringExtra = (getIntent() == null || !getIntent().hasExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW)) ? "0" : getIntent().getStringExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW);
            if ((this.mEnableDrawDuringWindowsAnimating || TextUtils.equals("1", stringExtra)) && findViewById(16908290) != null) {
                vi0.b(new c(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawDuringWindowsAnimating(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, view2) == null) || Build.VERSION.SDK_INT > 23) {
            return;
        }
        try {
            ViewParent parent = view2.getRootView().getParent();
            Method declaredMethod = parent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(parent, Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHasMultiWindowShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            sHasMultiWindowShow = z;
        }
    }

    public static void setNextPendingTransition(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65552, null, i, i2, i3, i4) == null) {
            sNextEnterAnimWhenStarting = i;
            sNextExitAnimWhenStarting = i2;
            sNextEnterAnimWhenFinishing = i3;
            sNextExitAnimWhenFinishing = i4;
        }
    }

    private void setPreActivityPosition(Activity activity, float f) {
        View decorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65553, this, activity, f) == null) || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        decorView.setX(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreDecorPosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65554, this, f) == null) {
            try {
                if (this.preActivity == null || this.preActivity.get() == null) {
                    this.preActivity = new WeakReference<>(hm0.d());
                }
                if (this.preActivity.get() != null) {
                    Activity e = hm0.e();
                    Activity activity = this.preActivity.get();
                    if (e != null && activity != null && e.getLocalClassName().equals(activity.getLocalClassName())) {
                        setPreActivityPosition(activity, 0.0f);
                    } else {
                        setPreActivityPosition(activity, f);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void startEnterActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (this.mEnterAnimWhenStarting == 0 && this.mExitAnimWhenStarting == 0) {
                return;
            }
            overridePendingTransition(this.mEnterAnimWhenStarting, this.mExitAnimWhenStarting);
            this.mEnterAnimWhenStarting = 0;
            this.mExitAnimWhenStarting = 0;
        }
    }

    private void startExitActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            if (this.mEnterAnimWhenFinishing == 0 && this.mExitAnimWhenFinishing == 0) {
                return;
            }
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (m11.b.d()) {
                return super.checkSelfPermission(str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void enableDrawDuringWindowsAnimating(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mEnableDrawDuringWindowsAnimating = z;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            startExitActivityAnim();
        }
    }

    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mForceActivityTransparent = z;
        }
    }

    public Object getActionBarExtObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActionBarExtObject : invokeV.objValue;
    }

    public Object getCommonMenuExtObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCommonMenuExtObject : invokeV.objValue;
    }

    public Context getExtContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getResources() : (Resources) invokeV.objValue;
    }

    public SlideHelper getSlideHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSlideHelper : (SlideHelper) invokeV.objValue;
    }

    public Object getSuspensionBallExtObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSuspensionBallExtObject : invokeV.objValue;
    }

    public SlidingPaneLayout.e getSuspensionBallSlideListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSuspensionBallSlideListener : (SlidingPaneLayout.e) invokeV.objValue;
    }

    public Object getToolBarExtObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mToolBarExtObject : invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onAttachedToWindow();
            startEnterActivityAnim();
            handleDrawDuringWindowsAnimating();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            SlideHelper slideHelper = this.mSlideHelper;
            if (slideHelper != null) {
                slideHelper.setCanSlide(configuration.orientation != 2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            int d2 = x11.d(this);
            super.onCreate(bundle);
            x11.a(this, d2);
            if (dg0.a(this)) {
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            resetActivityAnim();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, keyEvent)) == null) {
            if (i == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onMultiWindowModeChanged(z);
            if (z && !sHasMultiWindowShow) {
                u01.a().c(getApplicationContext(), R.string.obfuscated_res_0x7f0f0b55, 1);
                setHasMultiWindowShow(true);
            } else if (z || m11.a()) {
            } else {
                setHasMultiWindowShow(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, intent) == null) {
            super.onNewIntent(intent);
            resetActivityAnim();
            startEnterActivityAnim();
            ArrayList<d> arrayList2 = onNewIntentCallbacks;
            if (arrayList2 != null) {
                synchronized (arrayList2) {
                    arrayList = new ArrayList(onNewIntentCallbacks);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(intent);
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onPostCreate(bundle);
            applySliding();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    @SuppressLint({"NewApi"})
    public void requestPermission(String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048608, this, strArr, i) == null) && m11.b.d()) {
            super.requestPermissions(strArr, i);
        }
    }

    public void resetActivityAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (sNextEnterAnimWhenStarting != 0 || sNextExitAnimWhenStarting != 0) {
                this.mEnterAnimWhenStarting = sNextEnterAnimWhenStarting;
                this.mExitAnimWhenStarting = sNextExitAnimWhenStarting;
            }
            if (sNextEnterAnimWhenFinishing != 0 || sNextExitAnimWhenFinishing != 0) {
                this.mEnterAnimWhenFinishing = sNextEnterAnimWhenFinishing;
                this.mExitAnimWhenFinishing = sNextExitAnimWhenFinishing;
            }
            setNextPendingTransition(0, 0, 0, 0);
        }
    }

    public Object setActionBarExtObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) {
            this.mActionBarExtObject = obj;
            return obj;
        }
        return invokeL.objValue;
    }

    public Object setCommonMenuExtObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, obj)) == null) {
            this.mCommonMenuExtObject = obj;
            return obj;
        }
        return invokeL.objValue;
    }

    public void setCurrentActivityNoTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            p41.c(this, new a(this));
        }
    }

    public void setEnableSliding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.mEnableSliding = z;
        }
    }

    public void setEnableTaskRootSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.mEnableTaskRootSlide = z;
        }
    }

    public void setPendingTransition(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048616, this, i, i2, i3, i4) == null) {
            this.mEnterAnimWhenStarting = i;
            this.mExitAnimWhenStarting = i2;
            this.mEnterAnimWhenFinishing = i3;
            this.mExitAnimWhenFinishing = i4;
        }
    }

    public void setSlideCancelActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.mSlideCancelActivityTransparent = z;
        }
    }

    public void setSlideExtraListener(SlidingPaneLayout.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, eVar) == null) {
            this.mSlideListener = eVar;
        }
    }

    public void setSuspensionBallExtObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, obj) == null) {
            this.mSuspensionBallExtObject = obj;
        }
    }

    public void setSuspensionBallSlideListener(SlidingPaneLayout.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, eVar) == null) {
            this.mSuspensionBallSlideListener = eVar;
        }
    }

    public Object setToolBarExtObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, obj)) == null) {
            this.mToolBarExtObject = obj;
            return obj;
        }
        return invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) ? m11.b.d() && super.shouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048614, this, z, slideInterceptor) == null) {
            this.mEnableSliding = z;
            this.mSlideInterceptor = slideInterceptor;
        }
    }
}
