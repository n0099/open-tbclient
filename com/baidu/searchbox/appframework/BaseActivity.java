package com.baidu.searchbox.appframework;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.appframework.ext.IActionBarExtObject;
import com.baidu.searchbox.appframework.ext.ICommonMenuExtObject;
import com.baidu.searchbox.appframework.ext.IToolBarExtObject;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.tieba.y;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class BaseActivity extends FragmentActivity implements NightModeChangeListener, IActionBarExtObject, IToolBarExtObject, ICommonMenuExtObject {
    public static final int INVALID_ANIM = 0;
    public static final String KEY_WINDOWS_ANIMATING_NEED_DRAW = "winAccelerate";
    public static final String TAG = "BaseActivity";
    public static final String WINDOWS_ANIMATING_NEED_DRAW = "1";
    public static final String WINDOWS_ANIMATING_NEED_NOT_DRAW = "0";
    public static int sNextEnterAnimWhenFinishing;
    public static int sNextEnterAnimWhenStarting;
    public static int sNextExitAnimWhenFinishing;
    public static int sNextExitAnimWhenStarting;
    public Object mActionBarExtObject;
    public Object mCommonMenuExtObject;
    public ImmersionHelper mImmersionHelper;
    public SlideHelper mSlideHelper;
    public SlideInterceptor mSlideInterceptor;
    public SlidingPaneLayout.PanelSlideListener mSlideListener;
    public Object mSuspensionBallExtObject;
    public SlidingPaneLayout.PanelSlideListener mSuspensionBallSlideListener;
    public Object mToolBarExtObject;
    public WeakReference<Activity> preActivity;
    public static final boolean DEBUG = LibAppFrameworkConfig.GLOBAL_DEBUG;
    public static boolean sHasMultiWindowShow = false;
    public static ArrayList<OnNewIntentCallback> onNewIntentCallbacks = new ArrayList<>();
    public int mEnterAnimWhenStarting = 0;
    public int mExitAnimWhenStarting = 0;
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;
    public boolean mEnableDrawDuringWindowsAnimating = true;
    public boolean mEnableSliding = false;
    public boolean mSlideCancelActivityTransparent = true;
    public boolean mEnableTaskRootSlide = false;
    public boolean mForceActivityTransparent = false;
    public boolean mEnableImmersion = ImmersionHelper.SUPPORT_IMMERSION;
    public final Object tagObject = new Object();

    /* loaded from: classes3.dex */
    public interface OnNewIntentCallback {
        void execute(Object obj);
    }

    @Override // com.baidu.searchbox.appframework.ext.IBaseExtObject
    public Context getExtContext() {
        return this;
    }

    public String getFrom() {
        return "tool";
    }

    public String getPage() {
        return null;
    }

    public String getSource() {
        return null;
    }

    public void onFontSizeChange() {
    }

    private void registerFontSizeEvent() {
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.appframework.BaseActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                BaseActivity.this.onFontSizeChange();
            }
        });
    }

    private void startEnterActivityAnim() {
        if (this.mEnterAnimWhenStarting != 0 || this.mExitAnimWhenStarting != 0) {
            overridePendingTransition(this.mEnterAnimWhenStarting, this.mExitAnimWhenStarting);
            this.mEnterAnimWhenStarting = 0;
            this.mExitAnimWhenStarting = 0;
        }
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    private void unRegisterFontSizeEvent() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void applyImmersion() {
        if (this.mEnableImmersion) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.setImmersion();
        }
    }

    public void doBackStatistic() {
        AppFrameworkRuntime.backPressUBC(null, getFrom(), getPage(), getSource());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (DEBUG) {
            Log.d("BaseActivity", "finish: ");
        }
        startExitActivityAnim();
    }

    @Override // com.baidu.searchbox.appframework.ext.IActionBarExtObject
    public Object getActionBarExtObject() {
        return this.mActionBarExtObject;
    }

    @Override // com.baidu.searchbox.appframework.ext.ICommonMenuExtObject
    public Object getCommonMenuExtObject() {
        return this.mCommonMenuExtObject;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources skinResources;
        if (SkinResourcesRuntime.getSkinResourceContext() != null && (skinResources = SkinResourcesRuntime.getSkinResourceContext().getSkinResources()) != null) {
            return skinResources;
        }
        return super.getResources();
    }

    public SlideHelper getSlideHelper() {
        return this.mSlideHelper;
    }

    public Object getSuspensionBallExtObject() {
        return this.mSuspensionBallExtObject;
    }

    public SlidingPaneLayout.PanelSlideListener getSuspensionBallSlideListener() {
        return this.mSuspensionBallSlideListener;
    }

    @Override // com.baidu.searchbox.appframework.ext.IToolBarExtObject
    public Object getToolBarExtObject() {
        return this.mToolBarExtObject;
    }

    public boolean immersionEnabled() {
        return this.mEnableImmersion;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (DEBUG) {
            Log.d("BaseActivity", "onAttachedToWindow: ");
        }
        startEnterActivityAnim();
        handleDrawDuringWindowsAnimating();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (DEBUG) {
            Log.d("BaseActivity", "onBackPressed: ");
        }
        doBackStatistic();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.tagObject);
        unRegisterFontSizeEvent();
        super.onDestroy();
        if (DEBUG) {
            Log.d("BaseActivity", "onDestroy: ");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (DEBUG) {
            Log.d("BaseActivity", "onDetachedFromWindow: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d("BaseActivity", "onPause: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (DEBUG) {
            Log.d("BaseActivity", "onPostResume: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d("BaseActivity", "onResume: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (DEBUG) {
            Log.d("BaseActivity", "onStart: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (DEBUG) {
            Log.d("BaseActivity", "onStop: ");
        }
    }

    public void resetActivityAnim() {
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

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.searchbox.appframework.BaseActivity.2
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setNavigationBarColor() {
        if (DeviceUtils.OSInfo.hasLollipop()) {
            getWindow().setNavigationBarColor(getResources().getColor(com.baidu.tieba.R.color.navigation_bar_color));
        }
    }

    public void slideBackStatistic() {
        AppFrameworkRuntime.slideBackUBC(null, getFrom(), getPage(), getSource());
    }

    public static void addOnNewIntentCallback(OnNewIntentCallback onNewIntentCallback) {
        ArrayList<OnNewIntentCallback> arrayList = onNewIntentCallbacks;
        if (arrayList != null && onNewIntentCallback != null) {
            synchronized (arrayList) {
                Iterator<OnNewIntentCallback> it = onNewIntentCallbacks.iterator();
                while (it.hasNext()) {
                    if (onNewIntentCallback.equals(it.next())) {
                        return;
                    }
                }
                onNewIntentCallbacks.add(onNewIntentCallback);
            }
        }
    }

    public static void deleteOnNewIntentCallback(OnNewIntentCallback onNewIntentCallback) {
        ArrayList<OnNewIntentCallback> arrayList = onNewIntentCallbacks;
        if (arrayList != null && onNewIntentCallback != null) {
            synchronized (arrayList) {
                onNewIntentCallbacks.remove(onNewIntentCallback);
            }
        }
    }

    private void handleDispatchDoneAnimating(View view2) {
        try {
            ViewParent parent = view2.getRootView().getParent();
            Method declaredMethod = parent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(parent, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHasMultiWindowShow(boolean z) {
        sHasMultiWindowShow = z;
    }

    public void applyImmersion(int i) {
        if (this.mEnableImmersion) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.setImmersion(i);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        if (DeviceUtil.OSInfo.hasMarshMallow()) {
            return super.checkSelfPermission(str);
        }
        return 0;
    }

    public void enableDrawDuringWindowsAnimating(boolean z) {
        this.mEnableDrawDuringWindowsAnimating = z;
    }

    public void forceActivityTransparent(boolean z) {
        this.mForceActivityTransparent = z;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (DEBUG) {
            Log.d("BaseActivity", "onAttachFragment: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        super.onConfigurationChanged(configuration);
        if (DEBUG) {
            Log.d("BaseActivity", "onConfigurationChanged: ");
        }
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            if (configuration.orientation != 2) {
                z = true;
            } else {
                z = false;
            }
            slideHelper.setCanSlide(z);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (z && !sHasMultiWindowShow) {
            Toast.makeText(getApplicationContext(), (int) com.baidu.tieba.R.string.androidn_multiwindow_user_toast, 1).show();
            setHasMultiWindowShow(true);
        } else if (!z && !DeviceUtil.isMateX()) {
            setHasMultiWindowShow(false);
        }
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    @CallSuper
    public void onNightModeChanged(boolean z) {
        if (DEBUG) {
            Log.d("BaseActivity", "onNightModeChanged isNightMode: " + z + " BaseActivity: " + this);
        }
        setNavigationBarColor();
        if (this.mEnableImmersion) {
            applyImmersion();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (DEBUG) {
            Log.d("BaseActivity", "onPostCreate");
        }
        applySliding();
        applyImmersion();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (DEBUG) {
            Log.d("BaseActivity", "onRestoreInstanceState: ");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (DEBUG) {
            Log.d("BaseActivity", "onSaveInstanceState: ");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (DEBUG) {
            Log.d("BaseActivity", "onWindowFocusChanged:" + z);
        }
    }

    @Override // com.baidu.searchbox.appframework.ext.IActionBarExtObject
    public Object setActionBarExtObject(Object obj) {
        this.mActionBarExtObject = obj;
        return obj;
    }

    @Override // com.baidu.searchbox.appframework.ext.ICommonMenuExtObject
    public Object setCommonMenuExtObject(Object obj) {
        this.mCommonMenuExtObject = obj;
        return obj;
    }

    public void setEnableImmersion(boolean z) {
        boolean z2;
        ImmersionHelper immersionHelper;
        if (!z && this.mEnableImmersion && (immersionHelper = this.mImmersionHelper) != null) {
            immersionHelper.disable();
            this.mImmersionHelper = null;
        }
        if (ImmersionHelper.SUPPORT_IMMERSION && z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mEnableImmersion = z2;
    }

    public void setEnableSliding(boolean z) {
        this.mEnableSliding = z;
    }

    public void setEnableTaskRootSlide(boolean z) {
        this.mEnableTaskRootSlide = z;
    }

    public void setImmersionHelper(ImmersionHelper immersionHelper) {
        ImmersionHelper immersionHelper2 = this.mImmersionHelper;
        this.mImmersionHelper = immersionHelper;
        if (immersionHelper2 != null) {
            immersionHelper.setImmersion();
        }
    }

    public void setSlideCancelActivityTransparent(boolean z) {
        this.mSlideCancelActivityTransparent = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.mSlideListener = panelSlideListener;
    }

    public void setSuspensionBallExtObject(Object obj) {
        this.mSuspensionBallExtObject = obj;
    }

    public void setSuspensionBallSlideListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.mSuspensionBallSlideListener = panelSlideListener;
    }

    @Override // com.baidu.searchbox.appframework.ext.IToolBarExtObject
    public Object setToolBarExtObject(Object obj) {
        this.mToolBarExtObject = obj;
        return obj;
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        if (DeviceUtil.OSInfo.hasMarshMallow() && super.shouldShowRequestPermissionRationale(str)) {
            return true;
        }
        return false;
    }

    private void setPreActivityPosition(Activity activity, float f) {
        View decorView;
        if (activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setX(f);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"NewApi"})
    public void requestPermission(String[] strArr, int i) {
        if (DeviceUtil.OSInfo.hasMarshMallow()) {
            super.requestPermissions(strArr, i);
        }
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.mEnableSliding = z;
        this.mSlideInterceptor = slideInterceptor;
    }

    public void setEnterPendingTransition(int i, int i2) {
        this.mEnterAnimWhenStarting = i;
        this.mExitAnimWhenStarting = i2;
    }

    private void applySliding() {
        if (this.mEnableSliding) {
            boolean z = true;
            boolean z2 = false;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            }
            if (this.mEnableTaskRootSlide || !isTaskRoot()) {
                z2 = z;
            }
            if (DEBUG && (getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e("BaseActivity", "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            final int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this);
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.mSlideHelper.setCanSlide(z2);
            this.mSlideHelper.setNightMode(NightModeHelper.getNightModeSwitcherState());
            this.mSlideHelper.forceActivityTransparent(this.mForceActivityTransparent);
            this.mSlideHelper.attachActivity(this);
            this.mSlideHelper.setSlideInterceptor(this.mSlideInterceptor);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.searchbox.appframework.BaseActivity.3
                public boolean translucent = true;

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view2) {
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelClosed(view2);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelClosed(view2);
                    }
                    if (!BaseActivity.this.mSlideCancelActivityTransparent && !BaseActivity.this.mForceActivityTransparent && this.translucent) {
                        this.translucent = false;
                        SlideUtil.convertFromTranslucent(BaseActivity.this, null);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view2) {
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelOpened(view2);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelOpened(view2);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                    BaseActivity.this.mSlideHelper.setShadowDrawable(null);
                    BaseActivity.this.finish();
                    BaseActivity.this.overridePendingTransition(0, 0);
                    BaseActivity.this.slideBackStatistic();
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view2, float f) {
                    View maskView = BaseActivity.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f2 = 1.0f - f;
                        if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        maskView.setAlpha(f2);
                    }
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelSlide(view2, f);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelSlide(view2, f);
                    }
                    if (!BaseActivity.this.mSlideCancelActivityTransparent && !BaseActivity.this.mForceActivityTransparent && !this.translucent) {
                        this.translucent = true;
                        SlideUtil.convertToTranslucent(BaseActivity.this, null);
                    }
                    float f3 = displayWidth >> 2;
                    BaseActivity.this.setPreDecorPosition((f * f3) - f3);
                }
            });
        }
    }

    private void handleDrawDuringWindowsAnimating() {
        String str;
        if (getIntent() != null && getIntent().hasExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW)) {
            str = getIntent().getStringExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW);
        } else {
            str = "0";
        }
        if ((this.mEnableDrawDuringWindowsAnimating || TextUtils.equals("1", str)) && findViewById(16908290) != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.appframework.BaseActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.this;
                    baseActivity.setDrawDuringWindowsAnimating(baseActivity.getWindow().getDecorView());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawDuringWindowsAnimating(View view2) {
        if (Build.VERSION.SDK_INT > 23) {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int d = y.d(this);
        NightModeHelper.subscribeNightModeChangeEvent(this.tagObject, this);
        super.onCreate(bundle);
        y.a(this, d);
        if (DEBUG) {
            Log.d("BaseActivity", "onCreate: ");
        }
        if (SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            return;
        }
        resetActivityAnim();
        NightModeHelper.subscribeNightModeChangeEvent(this.tagObject, this);
        registerFontSizeEvent();
        BaseRouter.invokeNextScheme(this, getIntent());
        setNavigationBarColor();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        ArrayList arrayList;
        super.onNewIntent(intent);
        if (DEBUG) {
            Log.d("BaseActivity", "onNewIntent: ");
        }
        resetActivityAnim();
        startEnterActivityAnim();
        BaseRouter.invokeNextScheme(this, intent);
        ArrayList<OnNewIntentCallback> arrayList2 = onNewIntentCallbacks;
        if (arrayList2 != null) {
            synchronized (arrayList2) {
                arrayList = new ArrayList(onNewIntentCallbacks);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OnNewIntentCallback) it.next()).execute(intent);
            }
        }
    }

    public static void setNextPendingTransition(int i, int i2, int i3, int i4) {
        sNextEnterAnimWhenStarting = i;
        sNextExitAnimWhenStarting = i2;
        sNextEnterAnimWhenFinishing = i3;
        sNextExitAnimWhenFinishing = i4;
    }

    public void setPendingTransition(int i, int i2, int i3, int i4) {
        this.mEnterAnimWhenStarting = i;
        this.mExitAnimWhenStarting = i2;
        this.mEnterAnimWhenFinishing = i3;
        this.mExitAnimWhenFinishing = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreDecorPosition(float f) {
        try {
            if (this.preActivity == null || this.preActivity.get() == null) {
                this.preActivity = new WeakReference<>(BdBoxActivityManager.getPenultimateActivity());
            }
            if (this.preActivity.get() != null) {
                Activity realTopActivity = BdBoxActivityManager.getRealTopActivity();
                Activity activity = this.preActivity.get();
                if (realTopActivity != null && activity != null && realTopActivity.getLocalClassName().equals(activity.getLocalClassName())) {
                    setPreActivityPosition(activity, 0.0f);
                } else {
                    setPreActivityPosition(activity, f);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (DEBUG) {
            Log.d("BaseActivity", "onActivityResult: ");
        }
    }
}
