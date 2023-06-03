package com.baidu.searchbox.appframework.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.logs.LogPrinters;
import com.baidu.searchbox.appframework.AppFrameworkRuntime;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.LibAppFrameworkConfig;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
/* loaded from: classes3.dex */
public class BaseFragment extends Fragment implements NightModeChangeListener {
    public static final boolean DEBUG_BASE = LibAppFrameworkConfig.GLOBAL_DEBUG;
    public static final int FIRST_CHILD_INDEX = 0;
    public static final String IMMERSION_LAYOUT_TAG = "IMMERSION_LAYOUT_TAG";
    public static final int INITIAL_POS = 0;
    public static final String TAG_BASE = "Base";
    public BaseActivity mActivity;
    public Application mApp;
    public ImmersionHelper mImmersionHelper;
    public SlideHelper mSlideHelper;
    public final Object tagObject = new Object();
    public boolean mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;

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
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.appframework.fragment.BaseFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                BaseFragment.this.onFontSizeChange();
            }
        });
    }

    private void unRegisterFontSizeEvent() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void applyImmersion() {
        ImmersionHelper immersionHelper = this.mImmersionHelper;
        if (immersionHelper != null) {
            immersionHelper.setImmersion();
        }
    }

    public void finishAfterSlide() {
        setPreDecorPosition(0.0f);
    }

    public boolean immersionEnabled() {
        return this.mImmersionEnabled;
    }

    public boolean onBackPressed() {
        AppFrameworkRuntime.backPressUBC(null, getFrom(), getPage(), getSource());
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.tagObject);
        unRegisterFontSizeEvent();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        this.mActivity = null;
        this.mApp = null;
        super.onDetach();
    }

    public void onPanelClosed() {
        setPreDecorPosition(0.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ImmersionHelper immersionHelper;
        super.onResume();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        if (immersionEnabled() && (immersionHelper = this.mImmersionHelper) != null) {
            immersionHelper.resetWithCurImmersion();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onStop();
    }

    public static void logFragmentStack(FragmentManager fragmentManager) {
        if (DEBUG_BASE) {
            StringBuilder sb = new StringBuilder();
            if (fragmentManager != null) {
                int backStackEntryCount = fragmentManager.getBackStackEntryCount();
                sb.append("FragmentStatck[count=");
                sb.append(backStackEntryCount);
                sb.append(", [");
                for (int i = 0; i < backStackEntryCount; i++) {
                    FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                    sb.append("(id=");
                    sb.append(backStackEntryAt.getId());
                    sb.append(", name=");
                    sb.append(backStackEntryAt.getName());
                    sb.append(") ");
                }
                sb.append("]]");
                Log.i("FragmentStatck", sb.toString());
                return;
            }
            Log.i("FragmentStatck", "FragmentManager fmr == null");
        }
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

    public View enableSliding(View view2) {
        SlideInterceptor slideInterceptor;
        if (view2 instanceof SlideInterceptor) {
            slideInterceptor = (SlideInterceptor) view2;
        } else {
            slideInterceptor = null;
        }
        return enableSliding(view2, slideInterceptor);
    }

    public View initImmersion(View view2) {
        return initImmersionAndApply(view2, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        BaseActivity baseActivity = (BaseActivity) activity;
        this.mActivity = baseActivity;
        this.mApp = baseActivity.getApplication();
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        NightModeHelper.subscribeNightModeChangeEvent(this.tagObject, this);
        registerFontSizeEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
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

    public void onPanelSlide(float f) {
        float displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) >> 2;
        setPreDecorPosition((f * displayWidth) - displayWidth);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        super.onViewStateRestored(bundle);
    }

    public void setEnableImmerison(boolean z) {
        BaseActivity baseActivity;
        boolean z2 = false;
        if (z && (baseActivity = this.mActivity) != null) {
            baseActivity.setEnableImmersion(false);
        }
        if (ImmersionHelper.SUPPORT_IMMERSION && z) {
            z2 = true;
        }
        this.mImmersionEnabled = z2;
    }

    public void showShadow(boolean z) {
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.showShadow(z);
        }
    }

    public View enableSliding(View view2, SlideInterceptor slideInterceptor) {
        boolean z;
        if (getResources().getConfiguration().orientation == 2) {
            z = false;
        } else {
            z = true;
        }
        SlideHelper slideHelper = new SlideHelper();
        this.mSlideHelper = slideHelper;
        View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
        this.mSlideHelper.setFadeColor(0);
        this.mSlideHelper.setCanSlide(z);
        this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() { // from class: com.baidu.searchbox.appframework.fragment.BaseFragment.3
            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelClosed(View view3) {
                BaseFragment.this.onPanelClosed();
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelOpened(View view3) {
                BaseFragment.this.finishAfterSlide();
                AppFrameworkRuntime.slideBackUBC(null, BaseFragment.this.getFrom(), BaseFragment.this.getPage(), BaseFragment.this.getSource());
            }

            @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
            public void onPanelSlide(View view3, float f) {
                View maskView = BaseFragment.this.mSlideHelper.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                BaseFragment.this.onPanelSlide(f);
            }
        });
        return wrapSlideView;
    }

    public View initImmersionAndApply(View view2, boolean z) {
        if (view2 == null) {
            return null;
        }
        if (IMMERSION_LAYOUT_TAG.equals(view2.getTag())) {
            return view2;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        if (viewGroup != null) {
            if (IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                return viewGroup;
            }
            viewGroup.removeView(view2);
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return initImmersionAndApply(frameLayout, view2, z);
    }

    public View initImmersion(FrameLayout frameLayout, View view2) {
        return initImmersionAndApply(frameLayout, view2, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
            return false;
        }
        return false;
    }

    public View initImmersionAndApply(FrameLayout frameLayout, View view2, boolean z) {
        frameLayout.setTag(IMMERSION_LAYOUT_TAG);
        frameLayout.addView(view2);
        this.mImmersionHelper = new ImmersionHelper(this.mActivity, frameLayout);
        if (z) {
            applyImmersion();
        }
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        if (this.mImmersionEnabled && onCreateView != null) {
            return initImmersion(onCreateView);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (DEBUG_BASE) {
            Log.d(TAG_BASE, LogPrinters.getClassFileLineMethod(BaseFragment.class.getSimpleName()));
        }
        if (immersionEnabled() && this.mImmersionHelper != null && configuration.orientation == 1) {
            getActivity().getWindow().clearFlags(1024);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.appframework.fragment.BaseFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    ImmersionHelper immersionHelper = BaseFragment.this.mImmersionHelper;
                    if (immersionHelper != null) {
                        immersionHelper.resetWithCurImmersion();
                    }
                }
            }, 200L);
        }
    }
}
