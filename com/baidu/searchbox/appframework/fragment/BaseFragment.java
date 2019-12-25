package com.baidu.searchbox.appframework.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.logs.LogPrinters;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.LibAppFrameworkConfig;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import java.lang.reflect.Field;
/* loaded from: classes11.dex */
public class BaseFragment extends Fragment implements NightModeChangeListener {
    private static final boolean DEBUG_BASE = LibAppFrameworkConfig.GLOBAL_DEBUG;
    private static final int FIRST_CHILD_INDEX = 0;
    protected static final String IMMERSION_LAYOUT_TAG = "IMMERSION_LAYOUT_TAG";
    private static final int INITIAL_POS = 0;
    private static final String TAG_BASE = "Base";
    protected BaseActivity mActivity;
    protected Application mApp;
    protected ImmersionHelper mImmersionHelper;
    protected SlideHelper mSlideHelper;
    private final Object tagObject = new Object();
    private boolean mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
        this.mApp = this.mActivity.getApplication();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        NightModeHelper.subscribeNightModeChangeEvent(this.tagObject, this);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        if (this.mImmersionEnabled && onCreateView != null) {
            return initImmersion(onCreateView);
        }
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        if (immersionEnabled() && this.mImmersionHelper != null) {
            this.mImmersionHelper.resetWithCurImmersion();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        if (immersionEnabled() && this.mImmersionHelper != null && configuration.orientation == 1) {
            getActivity().getWindow().clearFlags(1024);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.appframework.fragment.BaseFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseFragment.this.mImmersionHelper.resetWithCurImmersion();
                }
            }, 200L);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onViewStateRestored(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.tagObject);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
        }
        this.mActivity = null;
        this.mApp = null;
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(getClass().getSimpleName()));
            return false;
        }
        return false;
    }

    public static void logFragmentStack(FragmentManager fragmentManager) {
        if (DEBUG_BASE) {
            StringBuilder sb = new StringBuilder();
            if (fragmentManager != null) {
                int backStackEntryCount = fragmentManager.getBackStackEntryCount();
                sb.append("FragmentStatck[count=").append(backStackEntryCount).append(", [");
                for (int i = 0; i < backStackEntryCount; i++) {
                    FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                    sb.append("(id=").append(backStackEntryAt.getId()).append(", name=").append(backStackEntryAt.getName()).append(") ");
                }
                sb.append("]]");
                Log.i("FragmentStatck", sb.toString());
                return;
            }
            Log.i("FragmentStatck", "FragmentManager fmr == null");
        }
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    @CallSuper
    public void onNightModeChanged(boolean z) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, "onNightModeChanged: " + z + " BaseFragment: " + this);
        }
        if (this.mImmersionEnabled) {
            applyImmersion();
        }
    }

    protected void setEnableImmerison(boolean z) {
        boolean z2 = false;
        if (z) {
            this.mActivity.setEnableImmersion(false);
        }
        if (ImmersionHelper.SUPPORT_IMMERSION && z) {
            z2 = true;
        }
        this.mImmersionEnabled = z2;
    }

    protected View initImmersion(View view) {
        if (view == null) {
            return null;
        }
        if (!IMMERSION_LAYOUT_TAG.equals(view.getTag())) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return initImmersion(frameLayout, view);
        }
        return view;
    }

    protected View initImmersion(FrameLayout frameLayout, View view) {
        frameLayout.setTag(IMMERSION_LAYOUT_TAG);
        frameLayout.addView(view);
        this.mImmersionHelper = new ImmersionHelper(this.mActivity, frameLayout);
        applyImmersion();
        return frameLayout;
    }

    protected void applyImmersion() {
        if (this.mImmersionHelper != null) {
            this.mImmersionHelper.setImmersion();
        }
    }

    protected boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    protected View enableSliding(View view) {
        SlideInterceptor slideInterceptor = null;
        if (view instanceof SlideInterceptor) {
            slideInterceptor = (SlideInterceptor) view;
        }
        return enableSliding(view, slideInterceptor);
    }

    protected View enableSliding(View view, SlideInterceptor slideInterceptor) {
        boolean z = getResources().getConfiguration().orientation != 2;
        this.mSlideHelper = new SlideHelper();
        View wrapSlideView = this.mSlideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        this.mSlideHelper.setCanSlide(z);
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.searchbox.appframework.fragment.BaseFragment.2
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view2, float f) {
                View maskView = BaseFragment.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                BaseFragment.this.onPanelSlide(f);
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view2) {
                BaseFragment.this.finishAfterSlide();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view2) {
                BaseFragment.this.onPanelClosed();
            }
        });
        return wrapSlideView;
    }

    public void finishAfterSlide() {
        setPreDecorPosition(0.0f);
    }

    public void onPanelSlide(float f) {
        float displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) >> 2;
        setPreDecorPosition((f * displayWidth) - displayWidth);
    }

    public void onPanelClosed() {
        setPreDecorPosition(0.0f);
    }

    private void setPreDecorPosition(float f) {
        ViewGroup viewGroup;
        View childAt;
        try {
            ViewGroup viewGroup2 = (ViewGroup) this.mActivity.findViewById(16908290);
            if (viewGroup2 != null && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null && (childAt = viewGroup.getChildAt(0)) != null) {
                childAt.setTranslationX(f);
            }
        } catch (Throwable th) {
            if (AppConfig.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    public void showShadow(boolean z) {
        if (this.mSlideHelper != null) {
            this.mSlideHelper.showShadow(z);
        }
    }
}
