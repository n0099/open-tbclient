package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes11.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    Fragment dnN;
    l dnO;
    j dnP;
    l dnQ;
    Fragment dnR;
    p dnS;
    boolean dnT;
    boolean dnU;
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mInLayout;
    View mInnerView;
    int mNextAnim;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    int mStateAfterAnimating;
    String mTag;
    int mTargetRequestCode;
    View mView;
    String mWho;
    private static final com.baidu.swan.support.v4.b.f<String, Class<?>> dnM = new com.baidu.swan.support.v4.b.f<>();
    static final Object USE_DEFAULT_TRANSITION = new Object();
    int mState = 0;
    int mIndex = -1;
    int mTargetIndex = -1;
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Object mEnterTransition = null;
    Object mReturnTransition = USE_DEFAULT_TRANSITION;
    Object mExitTransition = null;
    Object mReenterTransition = USE_DEFAULT_TRANSITION;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
    SharedElementCallback dnV = null;
    SharedElementCallback dnW = null;

    /* loaded from: classes11.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.swan.support.v4.app.Fragment.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: D */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: jp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle mState;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.mState = parcel.readBundle();
            if (classLoader != null && this.mState != null) {
                this.mState.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    /* loaded from: classes11.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static Fragment ae(Context context, String str) {
        return b(context, str, null);
    }

    public static Fragment b(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class<?> cls = dnM.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                dnM.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = bundle;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupportFragmentClass(Context context, String str) {
        try {
            Class<?> cls = dnM.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                dnM.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            this.mWho = fragment.mWho + ":" + this.mIndex;
        } else {
            this.mWho = "android:fragment:" + this.mIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        com.baidu.swan.support.v4.b.c.buildShortClassTag(this, sb);
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public void a(Fragment fragment, int i) {
        this.dnN = fragment;
        this.mTargetRequestCode = i;
    }

    public final Fragment aHu() {
        return this.dnN;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        if (this.dnP == null) {
            return null;
        }
        return this.dnP.getContext();
    }

    public final FragmentActivity aHv() {
        if (this.dnP == null) {
            return null;
        }
        return (FragmentActivity) this.dnP.getActivity();
    }

    public final Resources getResources() {
        if (this.dnP == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return this.dnP.getContext().getResources();
    }

    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    public final String getString(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final k aHw() {
        if (this.dnQ == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 5) {
                this.dnQ.dispatchResume();
            } else if (this.mState >= 4) {
                this.dnQ.dispatchStart();
            } else if (this.mState >= 2) {
                this.dnQ.dispatchActivityCreated();
            } else if (this.mState >= 1) {
                this.dnQ.dispatchCreate();
            }
        }
        return this.dnQ;
    }

    public final boolean isAdded() {
        return this.dnP != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public void onHiddenChanged(boolean z) {
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 4) {
            this.dnO.g(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = !z;
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        if (this.dnP == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.dnP.b(this, strArr, i);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = this.dnP.onGetLayoutInflater();
        aHw();
        com.baidu.swan.support.v4.c.a.a(onGetLayoutInflater, this.dnQ.aHC());
        return onGetLayoutInflater;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Activity activity = this.dnP == null ? null : this.dnP.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Activity activity = this.dnP == null ? null : this.dnP.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreate(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.dnT) {
            this.dnT = true;
            if (!this.dnU) {
                this.dnU = true;
                this.dnS = this.dnP.d(this.mWho, this.dnT, false);
            }
            if (this.dnS != null) {
                this.dnS.aHD();
            }
        }
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.dnU) {
            this.dnU = true;
            this.dnS = this.dnP.d(this.mWho, this.dnT, false);
        }
        if (this.dnS != null) {
            this.dnS.doDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mResumed = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.dnO = null;
        this.dnQ = null;
        this.dnP = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.dnS = null;
        this.dnT = false;
        this.dnU = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        aHv().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Object getEnterTransition() {
        return this.mEnterTransition;
    }

    public Object getReturnTransition() {
        return this.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mReturnTransition;
    }

    public Object getExitTransition() {
        return this.mExitTransition;
    }

    public Object getReenterTransition() {
        return this.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mReenterTransition;
    }

    public Object getSharedElementEnterTransition() {
        return this.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mSharedElementReturnTransition;
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.mAllowEnterTransitionOverlap == null) {
            return true;
        }
        return this.mAllowEnterTransitionOverlap.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.mAllowReturnTransitionOverlap == null) {
            return true;
        }
        return this.mAllowReturnTransitionOverlap.booleanValue();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.dnO != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.dnO);
        }
        if (this.dnP != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.dnP);
        }
        if (this.dnR != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.dnR);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.dnN != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.dnN);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.mAnimatingAway);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.mStateAfterAnimating);
        }
        if (this.dnS != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.dnS.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.dnQ != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.dnQ + ":");
            this.dnQ.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void instantiateChildFragmentManager() {
        this.dnQ = new l();
        this.dnQ.a(this.dnP, new h() { // from class: com.baidu.swan.support.v4.app.Fragment.1
            @Override // com.baidu.swan.support.v4.app.h
            @Nullable
            public View onFindViewById(int i) {
                if (Fragment.this.mView == null) {
                    throw new IllegalStateException("Fragment does not have a view");
                }
                return Fragment.this.mView.findViewById(i);
            }

            @Override // com.baidu.swan.support.v4.app.h
            public boolean onHasView() {
                return Fragment.this.mView != null;
            }
        }, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        Parcelable parcelable;
        if (this.dnQ != null) {
            this.dnQ.noteStateNotSaved();
        }
        this.mCalled = false;
        onCreate(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.dnQ == null) {
                instantiateChildFragmentManager();
            }
            this.dnQ.restoreAllState(parcelable, null);
            this.dnQ.dispatchCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dnQ != null) {
            this.dnQ.noteStateNotSaved();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        if (this.dnQ != null) {
            this.dnQ.noteStateNotSaved();
        }
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (this.dnQ != null) {
            this.dnQ.dispatchActivityCreated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStart() {
        if (this.dnQ != null) {
            this.dnQ.noteStateNotSaved();
            this.dnQ.execPendingActions();
        }
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.dnQ != null) {
            this.dnQ.dispatchStart();
        }
        if (this.dnS != null) {
            this.dnS.aHH();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performResume() {
        if (this.dnQ != null) {
            this.dnQ.noteStateNotSaved();
            this.dnQ.execPendingActions();
        }
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.dnQ != null) {
            this.dnQ.dispatchResume();
            this.dnQ.execPendingActions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.dnQ != null) {
            this.dnQ.dispatchConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        if (this.dnQ != null) {
            this.dnQ.dispatchLowMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        if (this.dnQ != null) {
            return z | this.dnQ.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        if (this.dnQ != null) {
            return z | this.dnQ.dispatchPrepareOptionsMenu(menu);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.dnQ != null && this.dnQ.dispatchOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (this.dnQ != null && this.dnQ.dispatchContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.dnQ != null) {
                this.dnQ.dispatchOptionsMenuClosed(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        Parcelable saveAllState;
        onSaveInstanceState(bundle);
        if (this.dnQ != null && (saveAllState = this.dnQ.saveAllState()) != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPause() {
        if (this.dnQ != null) {
            this.dnQ.dispatchPause();
        }
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStop() {
        if (this.dnQ != null) {
            this.dnQ.dispatchStop();
        }
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performReallyStop() {
        if (this.dnQ != null) {
            this.dnQ.dispatchReallyStop();
        }
        if (this.dnT) {
            this.dnT = false;
            if (!this.dnU) {
                this.dnU = true;
                this.dnS = this.dnP.d(this.mWho, this.dnT, false);
            }
            if (this.dnS != null) {
                if (!this.mRetaining) {
                    this.dnS.doStop();
                } else {
                    this.dnS.aHE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroyView() {
        if (this.dnQ != null) {
            this.dnQ.dispatchDestroyView();
        }
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        if (this.dnS != null) {
            this.dnS.aHG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroy() {
        if (this.dnQ != null) {
            this.dnQ.dispatchDestroy();
        }
        this.mCalled = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
