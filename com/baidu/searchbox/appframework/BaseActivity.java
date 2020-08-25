package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;
import com.android.a.a.a;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.appframework.ext.IActionBarExtObject;
import com.baidu.searchbox.appframework.ext.ICommonMenuExtObject;
import com.baidu.searchbox.appframework.ext.IToolBarExtObject;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.searchbox.suspensionball.SuspensionBallAnimFinishListener;
import com.baidu.searchbox.suspensionball.SuspensionBallHelper;
import com.baidu.searchbox.suspensionball.SuspensionBallManager;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.searchbox.widget.OnTranslucentListener;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlideUtil;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes18.dex */
public class BaseActivity extends FragmentActivity implements IActionBarExtObject, ICommonMenuExtObject, IToolBarExtObject, NightModeChangeListener {
    protected static final int INVALID_ANIM = 0;
    public static final String KEY_WINDOWS_ANIMATING_NEED_DRAW = "winAccelerate";
    private static final String TAG = "BaseActivity";
    private static final String WINDOWS_ANIMATING_NEED_DRAW = "1";
    private static final String WINDOWS_ANIMATING_NEED_NOT_DRAW = "0";
    private static int sNextEnterAnimWhenFinishing;
    private static int sNextEnterAnimWhenStarting;
    private static int sNextExitAnimWhenFinishing;
    private static int sNextExitAnimWhenStarting;
    private Object mActionBarExtObject;
    private Object mCommonMenuExtObject;
    protected ImmersionHelper mImmersionHelper;
    private SlideHelper mSlideHelper;
    private SlideInterceptor mSlideInterceptor;
    private SlidingPaneLayout.PanelSlideListener mSlideListener;
    private SuspensionBallHelper mSuspensionBallHelper;
    private Object mToolBarExtObject;
    private WeakReference<Activity> preActivity;
    private static final boolean DEBUG = LibAppFrameworkConfig.GLOBAL_DEBUG;
    private static boolean sHasMultiWindowShow = false;
    private static ArrayList<OnNewIntentCallback> onNewIntentCallbacks = new ArrayList<>();
    private int mEnterAnimWhenStarting = 0;
    private int mExitAnimWhenStarting = 0;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;
    private boolean mEnableDrawDuringWindowsAnimating = true;
    private boolean mEnableSliding = false;
    private boolean mForceActivityTransparent = false;
    private boolean mEnableImmersion = ImmersionHelper.SUPPORT_IMMERSION;
    private final Object tagObject = new Object();

    /* loaded from: classes18.dex */
    public interface OnNewIntentCallback {
        void execute(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = a.releaseFixedOrientation(this);
        super.onCreate(bundle);
        a.fixedOrientation(this, releaseFixedOrientation);
        if (DEBUG) {
            Log.d(TAG, "onCreate: ");
        }
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            resetActivityAnim();
            NightModeHelper.subscribeNightModeChangeEvent(this.tagObject, this);
            BaseRouter.invokeNextScheme(this, getIntent());
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (DEBUG) {
            Log.d(TAG, "onPostCreate");
        }
        applySliding();
        applyImmersion();
        initSuspensionBallHelper();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (DEBUG) {
            Log.d(TAG, "onWindowFocusChanged:" + z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (DEBUG) {
            Log.d(TAG, "onStart: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d(TAG, "onResume: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        ArrayList arrayList;
        super.onNewIntent(intent);
        if (DEBUG) {
            Log.d(TAG, "onNewIntent: ");
        }
        resetActivityAnim();
        startEnterActivityAnim();
        BaseRouter.invokeNextScheme(this, intent);
        if (onNewIntentCallbacks != null) {
            synchronized (onNewIntentCallbacks) {
                arrayList = new ArrayList(onNewIntentCallbacks);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OnNewIntentCallback) it.next()).execute(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (DEBUG) {
            Log.d(TAG, "onPostResume: ");
        }
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (DEBUG) {
            Log.d(TAG, "onAttachFragment: ");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (DEBUG) {
            Log.d(TAG, "onBackPressed: ");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (DEBUG) {
            Log.d(TAG, "onAttachedToWindow: ");
        }
        startEnterActivityAnim();
        handleDrawDuringWindowsAnimating();
        if (this.mSuspensionBallHelper != null) {
            this.mSuspensionBallHelper.handleSuspensionPage(getIsSuspensionBallPage());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (DEBUG) {
            Log.d(TAG, "onDetachedFromWindow: ");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (DEBUG) {
            Log.d(TAG, "onConfigurationChanged: ");
        }
        if (this.mSlideHelper != null) {
            this.mSlideHelper.setCanSlide(configuration.orientation != 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (DEBUG) {
            Log.d(TAG, "onActivityResult: ");
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (DEBUG) {
            Log.d(TAG, "onRestoreInstanceState: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (DEBUG) {
            Log.d(TAG, "onSaveInstanceState: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Log.d(TAG, "onPause: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (DEBUG) {
            Log.d(TAG, "onStop: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.tagObject);
        super.onDestroy();
        if (DEBUG) {
            Log.d(TAG, "onDestroy: ");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        doSuspensionBallExitAnim(new SuspensionBallAnimFinishListener() { // from class: com.baidu.searchbox.appframework.BaseActivity.1
            @Override // com.baidu.searchbox.suspensionball.SuspensionBallAnimFinishListener
            public void onFinish() {
                BaseActivity.super.finish();
                if (BaseActivity.DEBUG) {
                    Log.d(BaseActivity.TAG, "finish: ");
                }
                BaseActivity.this.startExitActivityAnim();
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources skinResources = SkinResourcesRuntime.getSkinResourceContext().getSkinResources();
        return skinResources != null ? skinResources : super.getResources();
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    @CallSuper
    public void onNightModeChanged(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "onNightModeChanged isNightMode: " + z + " BaseActivity: " + this);
        }
        if (this.mEnableImmersion) {
            applyImmersion();
        }
    }

    public void setEnableSliding(boolean z) {
        this.mEnableSliding = z;
    }

    public void setEnableSliding(boolean z, SlideInterceptor slideInterceptor) {
        this.mEnableSliding = z;
        this.mSlideInterceptor = slideInterceptor;
    }

    public void forceActivityTransparent(boolean z) {
        this.mForceActivityTransparent = z;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        this.mSlideListener = panelSlideListener;
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() { // from class: com.baidu.searchbox.appframework.BaseActivity.2
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
            }
        });
    }

    private void applySliding() {
        if (this.mEnableSliding) {
            boolean z = true;
            if (getResources().getConfiguration().orientation == 2) {
                z = false;
            }
            if (DEBUG && (getWindow().getAttributes().flags & 67108864) == 0) {
                Log.e(TAG, "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar");
            }
            final int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(this);
            this.mSlideHelper = new SlideHelper();
            this.mSlideHelper.attachSlideView(this, findViewById(16908290));
            this.mSlideHelper.setCanSlide(z);
            this.mSlideHelper.forceActivityTransparent(this.mForceActivityTransparent);
            this.mSlideHelper.attachActivity(this);
            this.mSlideHelper.setSlideInterceptor(this.mSlideInterceptor);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.searchbox.appframework.BaseActivity.3
                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelSlide(View view, float f) {
                    View maskView = BaseActivity.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        maskView.setAlpha(1.0f - f >= 0.0f ? 1.0f - f : 0.0f);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelSlide(view, f);
                    }
                    float f2 = displayWidth >> 2;
                    BaseActivity.this.setPreDecorPosition((f * f2) - f2);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelOpened(View view) {
                    if (BaseActivity.this.mSuspensionBallHelper != null) {
                        BaseActivity.this.mSuspensionBallHelper.setFinishFromSlide(true);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelOpened(view);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                    BaseActivity.this.mSlideHelper.setShadowDrawable(null);
                    BaseActivity.this.finish();
                    BaseActivity.this.overridePendingTransition(0, 0);
                }

                @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
                public void onPanelClosed(View view) {
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelClosed(view);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                }
            });
        }
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

    private void setPreActivityPosition(Activity activity, float f) {
        ViewGroup viewGroup;
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null && (viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290)) != null) {
            viewGroup.setX(f);
        }
    }

    public static void setNextPendingTransition(int i, int i2, int i3, int i4) {
        sNextEnterAnimWhenStarting = i;
        sNextExitAnimWhenStarting = i2;
        sNextEnterAnimWhenFinishing = i3;
        sNextExitAnimWhenFinishing = i4;
    }

    protected void setPendingTransition(int i, int i2, int i3, int i4) {
        this.mEnterAnimWhenStarting = i;
        this.mExitAnimWhenStarting = i2;
        this.mEnterAnimWhenFinishing = i3;
        this.mExitAnimWhenFinishing = i4;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        if (DeviceUtil.OSInfo.hasMarshMallow()) {
            return super.checkSelfPermission(str);
        }
        return 0;
    }

    public void requestPermission(String[] strArr, int i) {
        if (DeviceUtil.OSInfo.hasMarshMallow()) {
            super.requestPermissions(strArr, i);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        return DeviceUtil.OSInfo.hasMarshMallow() && super.shouldShowRequestPermissionRationale(str);
    }

    public static void setHasMultiWindowShow(boolean z) {
        sHasMultiWindowShow = z;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (z && !sHasMultiWindowShow) {
            Toast.makeText(getApplicationContext(), R.string.androidn_multiwindow_user_toast, 1).show();
            setHasMultiWindowShow(true);
        } else if (!z) {
            setHasMultiWindowShow(false);
        }
    }

    public void enableDrawDuringWindowsAnimating(boolean z) {
        this.mEnableDrawDuringWindowsAnimating = z;
    }

    public void setEnableImmersion(boolean z) {
        if (!z && this.mEnableImmersion && this.mImmersionHelper != null) {
            this.mImmersionHelper.disable();
            this.mImmersionHelper = null;
        }
        this.mEnableImmersion = ImmersionHelper.SUPPORT_IMMERSION && z;
    }

    protected boolean immersionEnabled() {
        return this.mEnableImmersion;
    }

    public SlideHelper getSlideHelper() {
        return this.mSlideHelper;
    }

    protected void applyImmersion(int i) {
        if (this.mEnableImmersion) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.setImmersion(i);
        }
    }

    protected void applyImmersion() {
        if (this.mEnableImmersion) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.setImmersion();
        }
    }

    protected void setImmersionHelper(ImmersionHelper immersionHelper) {
        ImmersionHelper immersionHelper2 = this.mImmersionHelper;
        this.mImmersionHelper = immersionHelper;
        if (immersionHelper2 != null) {
            this.mImmersionHelper.setImmersion();
        }
    }

    private void handleDrawDuringWindowsAnimating() {
        String str = "0";
        if (getIntent() != null && getIntent().hasExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW)) {
            str = getIntent().getStringExtra(KEY_WINDOWS_ANIMATING_NEED_DRAW);
        }
        if ((this.mEnableDrawDuringWindowsAnimating || TextUtils.equals("1", str)) && findViewById(16908290) != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.appframework.BaseActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity.this.setDrawDuringWindowsAnimating(BaseActivity.this.getWindow().getDecorView());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawDuringWindowsAnimating(View view) {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                ViewParent parent = view.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleDispatchDoneAnimating(View view) {
        try {
            ViewParent parent = view.getRootView().getParent();
            Method declaredMethod = parent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(parent, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetActivityAnim() {
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

    private void startEnterActivityAnim() {
        if (this.mEnterAnimWhenStarting != 0 || this.mExitAnimWhenStarting != 0) {
            overridePendingTransition(this.mEnterAnimWhenStarting, this.mExitAnimWhenStarting);
            this.mEnterAnimWhenStarting = 0;
            this.mExitAnimWhenStarting = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    public static void addOnNewIntentCallback(OnNewIntentCallback onNewIntentCallback) {
        if (onNewIntentCallbacks != null && onNewIntentCallback != null) {
            synchronized (onNewIntentCallbacks) {
                Iterator<OnNewIntentCallback> it = onNewIntentCallbacks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (onNewIntentCallback.equals(it.next())) {
                            break;
                        }
                    } else {
                        onNewIntentCallbacks.add(onNewIntentCallback);
                        break;
                    }
                }
            }
        }
    }

    public static void deleteOnNewIntentCallback(OnNewIntentCallback onNewIntentCallback) {
        if (onNewIntentCallbacks != null && onNewIntentCallback != null) {
            synchronized (onNewIntentCallbacks) {
                onNewIntentCallbacks.remove(onNewIntentCallback);
            }
        }
    }

    private void initSuspensionBallHelper() {
        if (getIsSuspensionBallPage()) {
            if (this.mSuspensionBallHelper == null) {
                this.mSuspensionBallHelper = new SuspensionBallHelper();
            }
            this.mSuspensionBallHelper.initSuspensionBallClipAnimHelper(this, this.mSlideHelper, getIsSuspensionBallPage());
        }
    }

    protected void doSuspensionBallExitAnim(SuspensionBallAnimFinishListener suspensionBallAnimFinishListener) {
        if (getIsSuspensionBallPage()) {
            if (this.mSuspensionBallHelper == null) {
                this.mSuspensionBallHelper = new SuspensionBallHelper();
            }
            this.mSuspensionBallHelper.doSuspensionBallExitAnim(this, this.mSlideHelper, suspensionBallAnimFinishListener);
        } else if (suspensionBallAnimFinishListener != null) {
            suspensionBallAnimFinishListener.onFinish();
        }
    }

    protected boolean getIsSuspensionBallPage() {
        return SuspensionBallManager.getInstance().isClickFromSuspension(getIntent());
    }

    @Override // com.baidu.searchbox.appframework.ext.IActionBarExtObject
    public Object getActionBarExtObject() {
        return this.mActionBarExtObject;
    }

    @Override // com.baidu.searchbox.appframework.ext.IActionBarExtObject
    public Object setActionBarExtObject(Object obj) {
        this.mActionBarExtObject = obj;
        return obj;
    }

    @Override // com.baidu.searchbox.appframework.ext.IToolBarExtObject
    public Object getToolBarExtObject() {
        return this.mToolBarExtObject;
    }

    @Override // com.baidu.searchbox.appframework.ext.IToolBarExtObject
    public Object setToolBarExtObject(Object obj) {
        this.mToolBarExtObject = obj;
        return obj;
    }

    @Override // com.baidu.searchbox.appframework.ext.ICommonMenuExtObject
    public Object getCommonMenuExtObject() {
        return this.mCommonMenuExtObject;
    }

    @Override // com.baidu.searchbox.appframework.ext.ICommonMenuExtObject
    public Object setCommonMenuExtObject(Object obj) {
        this.mCommonMenuExtObject = obj;
        return obj;
    }

    @Override // com.baidu.searchbox.appframework.ext.IBaseExtObject
    public Context getExtContext() {
        return this;
    }
}
