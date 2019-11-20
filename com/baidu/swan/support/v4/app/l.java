package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.baidu.swan.support.v4.app.e;
import com.baidu.swan.support.v4.app.k;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends k implements com.baidu.swan.support.v4.c.e {
    static final Interpolator ACCELERATE_CUBIC;
    static final Interpolator ACCELERATE_QUINT;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC;
    static final Interpolator DECELERATE_QUINT;
    static final boolean bMW;
    j bMJ;
    Runnable[] bMX;
    ArrayList<Fragment> bMY;
    ArrayList<Integer> bMZ;
    h bNa;
    Fragment bNb;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<e> mBackStack;
    ArrayList<k.a> mBackStackChangeListeners;
    ArrayList<e> mBackStackIndices;
    ArrayList<Fragment> mCreatedMenus;
    boolean mDestroyed;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    ArrayList<Runnable> mPendingActions;
    boolean mStateSaved;
    int mCurState = 0;
    Bundle mStateBundle = null;
    SparseArray<Parcelable> mStateArray = null;
    Runnable mExecCommit = new Runnable() { // from class: com.baidu.swan.support.v4.app.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.execPendingActions();
        }
    };

    /* loaded from: classes2.dex */
    static class b {
        public static final int[] Fragment = {16842755, 16842960, 16842961};
    }

    static {
        bMW = Build.VERSION.SDK_INT >= 11;
        DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
        DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
        ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
        ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements Animation.AnimationListener {
        private boolean bNe = false;
        private View mView;

        public a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            this.bNe = l.a(this.mView, animation);
            if (this.bNe) {
                this.mView.post(new Runnable() { // from class: com.baidu.swan.support.v4.app.l.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.support.v4.c.f.setLayerType(a.this.mView, 2, null);
                    }
                });
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.bNe) {
                this.mView.post(new Runnable() { // from class: com.baidu.swan.support.v4.app.l.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.support.v4.c.f.setLayerType(a.this.mView, 0, null);
                    }
                });
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    static boolean a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    static boolean a(View view, Animation animation) {
        return com.baidu.swan.support.v4.c.f.getLayerType(view) == 0 && com.baidu.swan.support.v4.c.f.hasOverlappingRendering(view) && a(animation);
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new com.baidu.swan.support.v4.b.d("FragmentManager"));
        if (this.bMJ != null) {
            try {
                this.bMJ.onDump("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        try {
            printWriter.close();
        } catch (Exception e3) {
            if (DEBUG) {
                Log.e("FragmentManager", "pw close exception");
            }
        }
        throw runtimeException;
    }

    @Override // com.baidu.swan.support.v4.app.k
    public m abY() {
        return new e(this);
    }

    @Override // com.baidu.swan.support.v4.app.k
    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    @Override // com.baidu.swan.support.v4.app.k
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return a(this.bMJ.getHandler(), (String) null, -1, 0);
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public Fragment d(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.bMY.size()) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.bMY.get(i);
        if (fragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    @Override // com.baidu.swan.support.v4.app.k
    public List<Fragment> getFragments() {
        return this.bMY;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.bNb != null) {
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bNb, sb);
        } else {
            com.baidu.swan.support.v4.b.c.buildShortClassTag(this.bMJ, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // com.baidu.swan.support.v4.app.k
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.bMY != null && (size6 = this.bMY.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.bMY.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.mAdded != null && (size5 = this.mAdded.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.mAdded.get(i2).toString());
            }
        }
        if (this.mCreatedMenus != null && (size4 = this.mCreatedMenus.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i3).toString());
            }
        }
        if (this.mBackStack != null && (size3 = this.mBackStack.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                e eVar = this.mBackStack.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(eVar.toString());
                eVar.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null && (size2 = this.mBackStackIndices.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((e) this.mBackStackIndices.get(i5));
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null && (size = this.mPendingActions.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((Runnable) this.mPendingActions.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.bMJ);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.bNa);
        if (this.bNb != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.bNb);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
        if (this.bMZ != null && this.bMZ.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.bMZ.toArray()));
        }
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    Animation a(Fragment fragment, int i, boolean z, int i2) {
        int transitToStyleIndex;
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation == null) {
            if (fragment.mNextAnim == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.bMJ.getContext(), fragment.mNextAnim)) == null) {
                if (i != 0 && (transitToStyleIndex = transitToStyleIndex(i, z)) >= 0) {
                    switch (transitToStyleIndex) {
                        case 1:
                            return a(this.bMJ.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return a(this.bMJ.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return a(this.bMJ.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return a(this.bMJ.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return a(this.bMJ.getContext(), 0.0f, 1.0f);
                        case 6:
                            return a(this.bMJ.getContext(), 1.0f, 0.0f);
                        default:
                            if (i2 == 0 && this.bMJ.onHasWindowAnimations()) {
                                i2 = this.bMJ.onGetWindowAnimations();
                            }
                            return i2 == 0 ? null : null;
                    }
                }
                return null;
            }
            return loadAnimation;
        }
        return onCreateAnimation;
    }

    public void g(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            a(fragment, this.mCurState, 0, 0, false);
        }
    }

    private void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            animation.setAnimationListener(new a(view, animation));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0319  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(final Fragment fragment, int i, int i2, int i3, boolean z) {
        ViewGroup viewGroup;
        if ((!fragment.mAdded || fragment.mDetached) && i > 1) {
            i = 1;
        }
        if (fragment.mRemoving && i > fragment.mState) {
            i = fragment.mState;
        }
        if (fragment.mDeferStart && fragment.mState < 4 && i > 3) {
            i = 3;
        }
        if (fragment.mState < i) {
            if (!fragment.mFromLayout || fragment.mInLayout) {
                if (fragment.mAnimatingAway != null) {
                    fragment.mAnimatingAway = null;
                    a(fragment, fragment.mStateAfterAnimating, 0, 0, true);
                }
                switch (fragment.mState) {
                    case 0:
                        if (DEBUG) {
                            Log.v("FragmentManager", "moveto CREATED: " + fragment);
                        }
                        if (fragment.mSavedFragmentState != null) {
                            fragment.mSavedFragmentState.setClassLoader(this.bMJ.getContext().getClassLoader());
                            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            fragment.bMH = d(fragment.mSavedFragmentState, "android:target_state");
                            if (fragment.bMH != null) {
                                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                            }
                            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                            if (!fragment.mUserVisibleHint) {
                                fragment.mDeferStart = true;
                                if (i > 3) {
                                    i = 3;
                                }
                            }
                        }
                        fragment.bMJ = this.bMJ;
                        fragment.bML = this.bNb;
                        fragment.bMI = this.bNb != null ? this.bNb.bMK : this.bMJ.abX();
                        fragment.mCalled = false;
                        fragment.onAttach(this.bMJ.getContext());
                        if (!fragment.mCalled) {
                            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                        }
                        if (fragment.bML == null) {
                            this.bMJ.d(fragment);
                        }
                        if (!fragment.mRetaining) {
                            fragment.performCreate(fragment.mSavedFragmentState);
                        }
                        fragment.mRetaining = false;
                        if (fragment.mFromLayout) {
                            fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
                            if (fragment.mView != null) {
                                fragment.mInnerView = fragment.mView;
                                if (Build.VERSION.SDK_INT >= 11) {
                                    com.baidu.swan.support.v4.c.f.setSaveFromParentEnabled(fragment.mView, false);
                                } else {
                                    fragment.mView = q.aL(fragment.mView);
                                }
                                if (fragment.mHidden) {
                                    fragment.mView.setVisibility(8);
                                }
                                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                            } else {
                                fragment.mInnerView = null;
                            }
                        }
                    case 1:
                        if (i > 1) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            if (!fragment.mFromLayout) {
                                if (fragment.mContainerId != 0) {
                                    viewGroup = (ViewGroup) this.bNa.onFindViewById(fragment.mContainerId);
                                    if (viewGroup == null && !fragment.mRestored) {
                                        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + fragment.getResources().getResourceName(fragment.mContainerId) + ") for fragment " + fragment));
                                    }
                                } else {
                                    viewGroup = null;
                                }
                                fragment.mContainer = viewGroup;
                                fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), viewGroup, fragment.mSavedFragmentState);
                                if (fragment.mView != null) {
                                    fragment.mInnerView = fragment.mView;
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        com.baidu.swan.support.v4.c.f.setSaveFromParentEnabled(fragment.mView, false);
                                    } else {
                                        fragment.mView = q.aL(fragment.mView);
                                    }
                                    if (viewGroup != null) {
                                        Animation a2 = a(fragment, i2, true, i3);
                                        if (a2 != null) {
                                            b(fragment.mView, a2);
                                            fragment.mView.startAnimation(a2);
                                        }
                                        viewGroup.addView(fragment.mView);
                                    }
                                    if (fragment.mHidden) {
                                        fragment.mView.setVisibility(8);
                                    }
                                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                } else {
                                    fragment.mInnerView = null;
                                }
                            }
                            fragment.performActivityCreated(fragment.mSavedFragmentState);
                            if (fragment.mView != null) {
                                fragment.restoreViewState(fragment.mSavedFragmentState);
                            }
                            fragment.mSavedFragmentState = null;
                        }
                        break;
                    case 2:
                    case 3:
                        if (i > 3) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "moveto STARTED: " + fragment);
                            }
                            fragment.performStart();
                        }
                    case 4:
                        if (i > 4) {
                            if (DEBUG) {
                                Log.v("FragmentManager", "moveto RESUMED: " + fragment);
                            }
                            fragment.mResumed = true;
                            fragment.performResume();
                            fragment.mSavedFragmentState = null;
                            fragment.mSavedViewState = null;
                            break;
                        }
                        break;
                }
            } else {
                return;
            }
        } else if (fragment.mState > i) {
            switch (fragment.mState) {
                case 1:
                    if (i < 1) {
                        if (this.mDestroyed && fragment.mAnimatingAway != null) {
                            View view = fragment.mAnimatingAway;
                            fragment.mAnimatingAway = null;
                            view.clearAnimation();
                        }
                        if (fragment.mAnimatingAway != null) {
                            fragment.mStateAfterAnimating = i;
                            i = 1;
                            break;
                        } else {
                            if (DEBUG) {
                                Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                            }
                            if (!fragment.mRetaining) {
                                fragment.performDestroy();
                            }
                            fragment.mCalled = false;
                            fragment.onDetach();
                            if (!fragment.mCalled) {
                                throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                            }
                            if (!z) {
                                if (!fragment.mRetaining) {
                                    j(fragment);
                                    break;
                                } else {
                                    fragment.bMJ = null;
                                    fragment.bML = null;
                                    fragment.bMI = null;
                                    fragment.bMK = null;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (i < 2) {
                        if (DEBUG) {
                            Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                        }
                        if (fragment.mView != null && this.bMJ.e(fragment) && fragment.mSavedViewState == null) {
                            k(fragment);
                        }
                        fragment.performDestroyView();
                        if (fragment.mView != null && fragment.mContainer != null) {
                            Animation a3 = (this.mCurState <= 0 || this.mDestroyed) ? null : a(fragment, i2, false, i3);
                            if (a3 != null) {
                                fragment.mAnimatingAway = fragment.mView;
                                fragment.mStateAfterAnimating = i;
                                a3.setAnimationListener(new a(fragment.mView, a3) { // from class: com.baidu.swan.support.v4.app.l.2
                                    @Override // com.baidu.swan.support.v4.app.l.a, android.view.animation.Animation.AnimationListener
                                    public void onAnimationEnd(Animation animation) {
                                        super.onAnimationEnd(animation);
                                        if (fragment.mAnimatingAway != null) {
                                            fragment.mAnimatingAway = null;
                                            l.this.a(fragment, fragment.mStateAfterAnimating, 0, 0, false);
                                        }
                                    }
                                });
                                fragment.mView.startAnimation(a3);
                            }
                            fragment.mContainer.removeView(fragment.mView);
                        }
                        fragment.mContainer = null;
                        fragment.mView = null;
                        fragment.mInnerView = null;
                    }
                    if (i < 1) {
                    }
                    break;
                case 3:
                    if (i < 3) {
                        if (DEBUG) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.performReallyStop();
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
                case 4:
                    if (i < 4) {
                        if (DEBUG) {
                            Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                        }
                        fragment.performStop();
                    }
                    if (i < 3) {
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
                case 5:
                    if (i < 5) {
                        if (DEBUG) {
                            Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                        }
                        fragment.performPause();
                        fragment.mResumed = false;
                    }
                    if (i < 4) {
                    }
                    if (i < 3) {
                    }
                    if (i < 2) {
                    }
                    if (i < 1) {
                    }
                    break;
            }
        }
        fragment.mState = i;
    }

    void h(Fragment fragment) {
        a(fragment, this.mCurState, 0, 0, false);
    }

    void moveToState(int i, boolean z) {
        c(i, 0, 0, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, int i2, int i3, boolean z) {
        if (this.bMJ == null && i != 0) {
            throw new IllegalStateException("No host");
        }
        if (z || this.mCurState != i) {
            this.mCurState = i;
            if (this.bMY != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.bMY.size()) {
                    Fragment fragment = this.bMY.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.bMM != null) {
                            z2 |= fragment.bMM.hasRunningLoaders();
                        }
                    }
                    i4++;
                    z2 = z2;
                }
                if (!z2) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.bMJ != null && this.mCurState == 5) {
                    this.bMJ.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    void startPendingDeferredFragments() {
        if (this.bMY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bMY.size()) {
                    Fragment fragment = this.bMY.get(i2);
                    if (fragment != null) {
                        g(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void i(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.bMZ == null || this.bMZ.size() <= 0) {
                if (this.bMY == null) {
                    this.bMY = new ArrayList<>();
                }
                fragment.b(this.bMY.size(), this.bNb);
                this.bMY.add(fragment);
            } else {
                fragment.b(this.bMZ.remove(this.bMZ.size() - 1).intValue(), this.bNb);
                this.bMY.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void j(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.bMY.set(fragment.mIndex, null);
            if (this.bMZ == null) {
                this.bMZ = new ArrayList<>();
            }
            this.bMZ.add(Integer.valueOf(fragment.mIndex));
            this.bMJ.inactivateFragment(fragment.mWho);
            fragment.initState();
        }
    }

    public void c(Fragment fragment, boolean z) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList<>();
        }
        if (DEBUG) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        i(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (z) {
                h(fragment);
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a2 = a(fragment, i, false, i2);
                if (a2 != null) {
                    b(fragment.mView, a2);
                    fragment.mView.startAnimation(a2);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void c(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    b(fragment.mView, a2);
                    fragment.mView.startAnimation(a2);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.mAdded != null) {
                    if (DEBUG) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList<>();
                }
                if (this.mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                a(fragment, this.mCurState, i, i2, false);
            }
        }
    }

    public Fragment gN(int i) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = this.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.bMY != null) {
            for (int size2 = this.bMY.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.bMY.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment lj(String str) {
        if (this.mAdded != null && str != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (this.bMY != null && str != null) {
            for (int size2 = this.bMY.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.bMY.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    public void a(Runnable runnable, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (this.mDestroyed || this.bMJ == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.mPendingActions == null) {
                this.mPendingActions = new ArrayList<>();
            }
            this.mPendingActions.add(runnable);
            if (this.mPendingActions.size() == 1) {
                this.bMJ.getHandler().removeCallbacks(this.mExecCommit);
                this.bMJ.getHandler().post(this.mExecCommit);
            }
        }
    }

    public int a(e eVar) {
        int size;
        synchronized (this) {
            if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList<>();
                }
                size = this.mBackStackIndices.size();
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
                }
                this.mBackStackIndices.add(eVar);
            } else {
                size = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1).intValue();
                if (DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + eVar);
                }
                this.mBackStackIndices.set(size, eVar);
            }
        }
        return size;
    }

    public void a(int i, e eVar) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (i < size) {
                if (DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + eVar);
                }
                this.mBackStackIndices.set(i, eVar);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList<>();
                    }
                    if (DEBUG) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + eVar);
                }
                this.mBackStackIndices.add(eVar);
            }
        }
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList<>();
            }
            if (DEBUG) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:
        r6.mExecutingActions = true;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
        if (r1 >= r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        r6.bMX[r1].run();
        r6.bMX[r1] = null;
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean execPendingActions() {
        if (this.mExecutingActions) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.bMJ.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean z = false;
        while (true) {
            synchronized (this) {
                if (this.mPendingActions == null || this.mPendingActions.size() == 0) {
                    break;
                }
                int size = this.mPendingActions.size();
                if (this.bMX == null || this.bMX.length < size) {
                    this.bMX = new Runnable[size];
                }
                this.mPendingActions.toArray(this.bMX);
                this.mPendingActions.clear();
                this.bMJ.getHandler().removeCallbacks(this.mExecCommit);
            }
            this.mExecutingActions = false;
            z = true;
        }
        if (this.mHavePendingDeferredStart) {
            boolean z2 = false;
            for (int i = 0; i < this.bMY.size(); i++) {
                Fragment fragment = this.bMY.get(i);
                if (fragment != null && fragment.bMM != null) {
                    z2 |= fragment.bMM.hasRunningLoaders();
                }
            }
            if (!z2) {
                this.mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            }
        }
        return z;
    }

    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mBackStackChangeListeners.size()) {
                    this.mBackStackChangeListeners.get(i2).onBackStackChanged();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(eVar);
        reportBackStackChanged();
    }

    boolean a(Handler handler, String str, int i, int i2) {
        if (this.mBackStack == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            e remove = this.mBackStack.remove(size);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            remove.b(sparseArray, sparseArray2);
            remove.a(true, (e.b) null, sparseArray, sparseArray2);
            reportBackStackChanged();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    e eVar = this.mBackStack.get(size2);
                    if ((str != null && str.equals(eVar.getName())) || (i >= 0 && i == eVar.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        e eVar2 = this.mBackStack.get(size2);
                        if ((str == null || !str.equals(eVar2.getName())) && (i < 0 || i != eVar2.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.mBackStack.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.mBackStack.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray<Fragment> sparseArray3 = new SparseArray<>();
            SparseArray<Fragment> sparseArray4 = new SparseArray<>();
            for (int i4 = 0; i4 <= size4; i4++) {
                ((e) arrayList.get(i4)).b(sparseArray3, sparseArray4);
            }
            e.b bVar = null;
            int i5 = 0;
            while (i5 <= size4) {
                if (DEBUG) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i5));
                }
                i5++;
                bVar = ((e) arrayList.get(i5)).a(i5 == size4, bVar, sparseArray3, sparseArray4);
            }
            reportBackStackChanged();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Fragment> abZ() {
        ArrayList<Fragment> arrayList = null;
        if (this.bMY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.bMY.size()) {
                    break;
                }
                Fragment fragment = this.bMY.get(i2);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.bMH != null ? fragment.bMH.mIndex : -1;
                    if (DEBUG) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    void k(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray<>();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    Bundle l(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            k(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable saveAllState() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (bMW) {
            this.mStateSaved = true;
        }
        if (this.bMY == null || this.bMY.size() <= 0) {
            return null;
        }
        int size3 = this.bMY.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = this.bMY.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = l(fragment);
                    if (fragment.bMH != null) {
                        if (fragment.bMH.mIndex < 0) {
                            throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.bMH));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        a(fragmentState.mSavedFragmentState, "android:target_state", fragment.bMH);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            if (DEBUG) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        if (this.mAdded == null || (size2 = this.mAdded.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.mAdded.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.mAdded.get(i2));
                }
            }
        }
        if (this.mBackStack != null && (size = this.mBackStack.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.mBackStack.get(i3));
                if (DEBUG) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.mBackStack.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.bNg = fragmentStateArr;
        fragmentManagerState.mAdded = iArr;
        fragmentManagerState.bNh = backStackStateArr;
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.bNg != null) {
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Fragment fragment = list.get(i);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.bNg[fragment.mIndex];
                        fragmentState.bNi = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.bMH = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.bMJ.getContext().getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                }
                this.bMY = new ArrayList<>(fragmentManagerState.bNg.length);
                if (this.bMZ != null) {
                    this.bMZ.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.bNg.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.bNg[i2];
                    if (fragmentState2 != null) {
                        Fragment a2 = fragmentState2.a(this.bMJ, this.bNb);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a2);
                        }
                        this.bMY.add(a2);
                        fragmentState2.bNi = null;
                    } else {
                        this.bMY.add(null);
                        if (this.bMZ == null) {
                            this.bMZ = new ArrayList<>();
                        }
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.bMZ.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        Fragment fragment2 = list.get(i3);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.bMY.size()) {
                                fragment2.bMH = this.bMY.get(fragment2.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                                fragment2.bMH = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    this.mAdded = new ArrayList<>(fragmentManagerState.mAdded.length);
                    for (int i4 = 0; i4 < fragmentManagerState.mAdded.length; i4++) {
                        Fragment fragment3 = this.bMY.get(fragmentManagerState.mAdded[i4]);
                        if (fragment3 == null) {
                            throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i4]));
                        }
                        fragment3.mAdded = true;
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.mAdded.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.mAdded.add(fragment3);
                    }
                } else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.bNh != null) {
                    this.mBackStack = new ArrayList<>(fragmentManagerState.bNh.length);
                    for (int i5 = 0; i5 < fragmentManagerState.bNh.length; i5++) {
                        e a3 = fragmentManagerState.bNh[i5].a(this);
                        if (DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a3.mIndex + "): " + a3);
                            a3.dump("  ", new PrintWriter(new com.baidu.swan.support.v4.b.d("FragmentManager")), false);
                        }
                        this.mBackStack.add(a3);
                        if (a3.mIndex >= 0) {
                            a(a3.mIndex, a3);
                        }
                    }
                    return;
                }
                this.mBackStack = null;
            }
        }
    }

    public void a(j jVar, h hVar, Fragment fragment) {
        if (this.bMJ != null) {
            throw new IllegalStateException("Already attached");
        }
        this.bMJ = jVar;
        this.bNa = hVar;
        this.bNb = fragment;
    }

    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        moveToState(1, false);
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        moveToState(2, false);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        moveToState(4, false);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        moveToState(5, false);
    }

    public void dispatchPause() {
        moveToState(4, false);
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        moveToState(3, false);
    }

    public void dispatchReallyStop() {
        moveToState(2, false);
    }

    public void dispatchDestroyView() {
        moveToState(1, false);
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        moveToState(0, false);
        this.bMJ = null;
        this.bNa = null;
        this.bNb = null;
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dispatchLowMemory() {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performLowMemory();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<Fragment> arrayList = null;
        if (this.mAdded != null) {
            int i = 0;
            z = false;
            while (i < this.mAdded.size()) {
                Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                Fragment fragment2 = this.mCreatedMenus.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mAdded != null) {
            boolean z = false;
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int transitToStyleIndex(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    @Override // com.baidu.swan.support.v4.c.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.Fragment);
            String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string2 = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.isSupportFragmentClass(this.bMJ.getContext(), string)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
                }
                Fragment gN = resourceId != -1 ? gN(resourceId) : null;
                if (gN == null && string2 != null) {
                    gN = lj(string2);
                }
                if (gN == null && id != -1) {
                    gN = gN(id);
                }
                if (DEBUG) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + gN);
                }
                if (gN == null) {
                    Fragment aa = Fragment.aa(context, string);
                    aa.mFromLayout = true;
                    aa.mFragmentId = resourceId != 0 ? resourceId : id;
                    aa.mContainerId = id;
                    aa.mTag = string2;
                    aa.mInLayout = true;
                    aa.bMI = this;
                    aa.bMJ = this.bMJ;
                    aa.onInflate(this.bMJ.getContext(), attributeSet, aa.mSavedFragmentState);
                    c(aa, true);
                    fragment = aa;
                } else if (gN.mInLayout) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
                } else {
                    gN.mInLayout = true;
                    if (!gN.mRetaining) {
                        gN.onInflate(this.bMJ.getContext(), attributeSet, gN.mSavedFragmentState);
                    }
                    fragment = gN;
                }
                if (this.mCurState < 1 && fragment.mFromLayout) {
                    a(fragment, 1, 0, 0, false);
                } else {
                    h(fragment);
                }
                if (fragment.mView == null) {
                    throw new IllegalStateException("Fragment " + string + " did not create a view.");
                }
                if (resourceId != 0) {
                    fragment.mView.setId(resourceId);
                }
                if (fragment.mView.getTag() == null) {
                    fragment.mView.setTag(string2);
                }
                return fragment.mView;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.support.v4.c.e aca() {
        return this;
    }
}
