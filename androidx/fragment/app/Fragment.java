package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVITY_CREATED = 2;
    public static final int ATTACHED = 0;
    public static final int CREATED = 1;
    public static final int INITIALIZING = -1;
    public static final int RESUMED = 4;
    public static final int STARTED = 3;
    public static final Object USE_DEFAULT_TRANSITION;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAdded;
    public AnimationInfo mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    @NonNull
    public FragmentManager mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    @LayoutRes
    public int mContentLayoutId;
    public ViewModelProvider.Factory mDefaultFactory;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManager mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public FragmentHostCallback<?> mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    public Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public LifecycleRegistry mLifecycleRegistry;
    public Lifecycle.State mMaxState;
    public boolean mMenuVisible;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public SavedStateRegistryController mSavedStateRegistryController;
    @Nullable
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    @Nullable
    public FragmentViewLifecycleOwner mViewLifecycleOwner;
    public MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    @NonNull
    public String mWho;

    /* loaded from: classes.dex */
    public static class AnimationInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean mAllowEnterTransitionOverlap;
        public Boolean mAllowReturnTransitionOverlap;
        public View mAnimatingAway;
        public Animator mAnimator;
        public Object mEnterTransition;
        public SharedElementCallback mEnterTransitionCallback;
        public boolean mEnterTransitionPostponed;
        public Object mExitTransition;
        public SharedElementCallback mExitTransitionCallback;
        public boolean mIsHideReplaced;
        public int mNextAnim;
        public int mNextTransition;
        public Object mReenterTransition;
        public Object mReturnTransition;
        public Object mSharedElementEnterTransition;
        public Object mSharedElementReturnTransition;
        public OnStartEnterTransitionListener mStartEnterTransitionListener;
        public int mStateAfterAnimating;

        public AnimationInfo() {
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
            this.mEnterTransition = null;
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = obj;
            this.mExitTransition = null;
            this.mReenterTransition = obj;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = obj;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
        }
    }

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1488152840, "Landroidx/fragment/app/Fragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1488152840, "Landroidx/fragment/app/Fragment;");
                return;
            }
        }
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable(this) { // from class: androidx.fragment.app.Fragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Fragment this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.startPostponedEnterTransition();
                }
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData<>();
        initLifecycle();
    }

    private AnimationInfo ensureAnimationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mAnimationInfo == null) {
                this.mAnimationInfo = new AnimationInfo();
            }
            return this.mAnimationInfo;
        }
        return (AnimationInfo) invokeV.objValue;
    }

    private void initLifecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
            this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
            if (Build.VERSION.SDK_INT >= 19) {
                this.mLifecycleRegistry.addObserver(new LifecycleEventObserver(this) { // from class: androidx.fragment.app.Fragment.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Fragment this$0;

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
                        this.this$0 = this;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        View view;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_STOP && (view = this.this$0.mView) != null) {
                            view.cancelPendingInputEvents();
                        }
                    }
                });
            }
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) ? instantiate(context, str, null) : (Fragment) invokeLL.objValue;
    }

    public void callStartTransitionListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            OnStartEnterTransitionListener onStartEnterTransitionListener = null;
            if (animationInfo != null) {
                animationInfo.mEnterTransitionPostponed = false;
                OnStartEnterTransitionListener onStartEnterTransitionListener2 = animationInfo.mStartEnterTransitionListener;
                animationInfo.mStartEnterTransitionListener = null;
                onStartEnterTransitionListener = onStartEnterTransitionListener2;
            }
            if (onStartEnterTransitionListener != null) {
                onStartEnterTransitionListener.onStartEnterTransition();
            }
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
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
            printWriter.print(" mWho=");
            printWriter.print(this.mWho);
            printWriter.print(" mBackStackNesting=");
            printWriter.println(this.mBackStackNesting);
            printWriter.print(str);
            printWriter.print("mAdded=");
            printWriter.print(this.mAdded);
            printWriter.print(" mRemoving=");
            printWriter.print(this.mRemoving);
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
            printWriter.print(" mUserVisibleHint=");
            printWriter.println(this.mUserVisibleHint);
            if (this.mFragmentManager != null) {
                printWriter.print(str);
                printWriter.print("mFragmentManager=");
                printWriter.println(this.mFragmentManager);
            }
            if (this.mHost != null) {
                printWriter.print(str);
                printWriter.print("mHost=");
                printWriter.println(this.mHost);
            }
            if (this.mParentFragment != null) {
                printWriter.print(str);
                printWriter.print("mParentFragment=");
                printWriter.println(this.mParentFragment);
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
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                printWriter.print(str);
                printWriter.print("mTarget=");
                printWriter.print(targetFragment);
                printWriter.print(" mTargetRequestCode=");
                printWriter.println(this.mTargetRequestCode);
            }
            if (getNextAnim() != 0) {
                printWriter.print(str);
                printWriter.print("mNextAnim=");
                printWriter.println(getNextAnim());
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
            if (getAnimatingAway() != null) {
                printWriter.print(str);
                printWriter.print("mAnimatingAway=");
                printWriter.println(getAnimatingAway());
                printWriter.print(str);
                printWriter.print("mStateAfterAnimating=");
                printWriter.println(getStateAfterAnimating());
            }
            if (getContext() != null) {
                LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
            }
            printWriter.print(str);
            printWriter.println("Child " + this.mChildFragmentManager + ":");
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.dump(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? str.equals(this.mWho) ? this : this.mChildFragmentManager.findFragmentByWho(str) : (Fragment) invokeL.objValue;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                return null;
            }
            return (FragmentActivity) fragmentHostCallback.getActivity();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public boolean getAllowEnterTransitionOverlap() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null || (bool = animationInfo.mAllowEnterTransitionOverlap) == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean getAllowReturnTransitionOverlap() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null || (bool = animationInfo.mAllowReturnTransitionOverlap) == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public View getAnimatingAway() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mAnimatingAway;
        }
        return (View) invokeV.objValue;
    }

    public Animator getAnimator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mAnimator;
        }
        return (Animator) invokeV.objValue;
    }

    @Nullable
    public final Bundle getArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mArguments : (Bundle) invokeV.objValue;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mHost != null) {
                return this.mChildFragmentManager;
            }
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return (FragmentManager) invokeV.objValue;
    }

    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                return null;
            }
            return fragmentHostCallback.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.mFragmentManager != null) {
                if (this.mDefaultFactory == null) {
                    this.mDefaultFactory = new SavedStateViewModelFactory(requireActivity().getApplication(), this, getArguments());
                }
                return this.mDefaultFactory;
            }
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        return (ViewModelProvider.Factory) invokeV.objValue;
    }

    @Nullable
    public Object getEnterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mEnterTransition;
        }
        return invokeV.objValue;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mEnterTransitionCallback;
        }
        return (SharedElementCallback) invokeV.objValue;
    }

    @Nullable
    public Object getExitTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mExitTransition;
        }
        return invokeV.objValue;
    }

    public SharedElementCallback getExitTransitionCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mExitTransitionCallback;
        }
        return (SharedElementCallback) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mFragmentManager : (FragmentManager) invokeV.objValue;
    }

    @Nullable
    public final Object getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                return null;
            }
            return fragmentHostCallback.onGetHost();
        }
        return invokeV.objValue;
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mFragmentId : invokeV.intValue;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            LayoutInflater layoutInflater = this.mLayoutInflater;
            return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mLifecycleRegistry : (Lifecycle) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? LoaderManager.getInstance(this) : (LoaderManager) invokeV.objValue;
    }

    public int getNextAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return 0;
            }
            return animationInfo.mNextAnim;
        }
        return invokeV.intValue;
    }

    public int getNextTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return 0;
            }
            return animationInfo.mNextTransition;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final Fragment getParentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mParentFragment : (Fragment) invokeV.objValue;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                return fragmentManager;
            }
            throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
        }
        return (FragmentManager) invokeV.objValue;
    }

    @Nullable
    public Object getReenterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mReenterTransition;
            return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
        }
        return invokeV.objValue;
    }

    @NonNull
    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? requireContext().getResources() : (Resources) invokeV.objValue;
    }

    public final boolean getRetainInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mRetainInstance : invokeV.booleanValue;
    }

    @Nullable
    public Object getReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mReturnTransition;
            return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
        }
        return invokeV.objValue;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mSavedStateRegistryController.getSavedStateRegistry() : (SavedStateRegistry) invokeV.objValue;
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            return animationInfo.mSharedElementEnterTransition;
        }
        return invokeV.objValue;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mSharedElementReturnTransition;
            return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
        }
        return invokeV.objValue;
    }

    public int getStateAfterAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return 0;
            }
            return animationInfo.mStateAfterAnimating;
        }
        return invokeV.intValue;
    }

    @NonNull
    public final String getString(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? getResources().getString(i2) : (String) invokeI.objValue;
    }

    @Nullable
    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mTag : (String) invokeV.objValue;
    }

    @Nullable
    public final Fragment getTargetFragment() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Fragment fragment = this.mTarget;
            if (fragment != null) {
                return fragment;
            }
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null || (str = this.mTargetWho) == null) {
                return null;
            }
            return fragmentManager.findActiveFragment(str);
        }
        return (Fragment) invokeV.objValue;
    }

    public final int getTargetRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mTargetRequestCode : invokeV.intValue;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? getResources().getText(i2) : (CharSequence) invokeI.objValue;
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mUserVisibleHint : invokeV.booleanValue;
    }

    @Nullable
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mView : (View) invokeV.objValue;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
            if (fragmentViewLifecycleOwner != null) {
                return fragmentViewLifecycleOwner;
            }
            throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        }
        return (LifecycleOwner) invokeV.objValue;
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mViewLifecycleOwnerLiveData : (LiveData) invokeV.objValue;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                return fragmentManager.getViewModelStore(this);
            }
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        return (ViewModelStore) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mHasMenu : invokeV.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public void initState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            initLifecycle();
            this.mWho = UUID.randomUUID().toString();
            this.mAdded = false;
            this.mRemoving = false;
            this.mFromLayout = false;
            this.mInLayout = false;
            this.mRestored = false;
            this.mBackStackNesting = 0;
            this.mFragmentManager = null;
            this.mChildFragmentManager = new FragmentManagerImpl();
            this.mHost = null;
            this.mFragmentId = 0;
            this.mContainerId = 0;
            this.mTag = null;
            this.mHidden = false;
            this.mDetached = false;
        }
    }

    public final boolean isAdded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mHost != null && this.mAdded : invokeV.booleanValue;
    }

    public final boolean isDetached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mDetached : invokeV.booleanValue;
    }

    public final boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mHidden : invokeV.booleanValue;
    }

    public boolean isHideReplaced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return false;
            }
            return animationInfo.mIsHideReplaced;
        }
        return invokeV.booleanValue;
    }

    public final boolean isInBackStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mBackStackNesting > 0 : invokeV.booleanValue;
    }

    public final boolean isInLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mInLayout : invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        InterceptResult invokeV;
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment)) : invokeV.booleanValue;
    }

    public boolean isPostponed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return false;
            }
            return animationInfo.mEnterTransitionPostponed;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRemoving() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mRemoving : invokeV.booleanValue;
    }

    public final boolean isRemovingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Fragment parentFragment = getParentFragment();
            return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
        }
        return invokeV.booleanValue;
    }

    public final boolean isResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mState >= 4 : invokeV.booleanValue;
    }

    public final boolean isStateSaved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                return false;
            }
            return fragmentManager.isStateSaved();
        }
        return invokeV.booleanValue;
    }

    public final boolean isVisible() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true : invokeV.booleanValue;
    }

    public void noteStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
    }

    @CallSuper
    @MainThread
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            this.mCalled = true;
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048641, this, i2, i3, intent) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            this.mCalled = true;
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
            if (activity != null) {
                this.mCalled = false;
                onAttach(activity);
            }
        }
    }

    @MainThread
    public void onAttachFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, fragment) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, configuration) == null) {
            this.mCalled = true;
        }
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            this.mCalled = true;
            restoreChildFragmentState(bundle);
            if (this.mChildFragmentManager.isStateAtLeast(1)) {
                return;
            }
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048649, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            return null;
        }
        return (Animator) invokeCommon.objValue;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048650, this, contextMenu, view, contextMenuInfo) == null) {
            requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @MainThread
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, menu, menuInflater) == null) {
        }
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048652, this, layoutInflater, viewGroup, bundle)) == null) {
            int i2 = this.mContentLayoutId;
            if (i2 != 0) {
                return layoutInflater.inflate(i2, viewGroup, false);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.mCalled = true;
        }
    }

    @MainThread
    public void onDestroyOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.mCalled = true;
        }
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.mCalled = true;
        }
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, bundle)) == null) ? getLayoutInflater(bundle) : (LayoutInflater) invokeL.objValue;
    }

    @MainThread
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
        }
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048660, this, context, attributeSet, bundle) == null) {
            this.mCalled = true;
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
            if (activity != null) {
                this.mCalled = false;
                onInflate(activity, attributeSet, bundle);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            this.mCalled = true;
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
        }
    }

    @MainThread
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @MainThread
    public void onOptionsMenuClosed(@NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, menu) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            this.mCalled = true;
        }
    }

    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
        }
    }

    @MainThread
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, menu) == null) {
        }
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
        }
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048669, this, i2, strArr, iArr) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.mCalled = true;
        }
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, bundle) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.mCalled = true;
        }
    }

    @CallSuper
    @MainThread
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.mCalled = true;
        }
    }

    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048674, this, view, bundle) == null) {
        }
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            this.mCalled = true;
        }
    }

    public void performActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, bundle) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mState = 2;
            this.mCalled = false;
            onActivityCreated(bundle);
            if (this.mCalled) {
                this.mChildFragmentManager.dispatchActivityCreated();
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void performAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer(this) { // from class: androidx.fragment.app.Fragment.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Fragment this$0;

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
                    this.this$0 = this;
                }

                @Override // androidx.fragment.app.FragmentContainer
                @Nullable
                public View onFindViewById(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                        View view = this.this$0.mView;
                        if (view != null) {
                            return view.findViewById(i2);
                        }
                        throw new IllegalStateException("Fragment " + this + " does not have a view");
                    }
                    return (View) invokeI.objValue;
                }

                @Override // androidx.fragment.app.FragmentContainer
                public boolean onHasView() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mView != null : invokeV.booleanValue;
                }
            }, this);
            this.mState = 0;
            this.mCalled = false;
            onAttach(this.mHost.getContext());
            if (this.mCalled) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void performConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, configuration) == null) {
            onConfigurationChanged(configuration);
            this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }

    public boolean performContextItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, menuItem)) == null) {
            if (this.mHidden) {
                return false;
            }
            return onContextItemSelected(menuItem) || this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void performCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mState = 1;
            this.mCalled = false;
            this.mSavedStateRegistryController.performRestore(bundle);
            onCreate(bundle);
            this.mIsCreated = true;
            if (this.mCalled) {
                this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    public boolean performCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048681, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.mHidden) {
                return false;
            }
            if (this.mHasMenu && this.mMenuVisible) {
                z = true;
                onCreateOptionsMenu(menu, menuInflater);
            }
            return z | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return invokeLL.booleanValue;
    }

    public void performCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048682, this, layoutInflater, viewGroup, bundle) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mPerformedCreateView = true;
            this.mViewLifecycleOwner = new FragmentViewLifecycleOwner();
            View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
            this.mView = onCreateView;
            if (onCreateView != null) {
                this.mViewLifecycleOwner.initialize();
                this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            } else if (!this.mViewLifecycleOwner.isInitialized()) {
                this.mViewLifecycleOwner = null;
            } else {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
        }
    }

    public void performDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.mChildFragmentManager.dispatchDestroy();
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            this.mState = 0;
            this.mCalled = false;
            this.mIsCreated = false;
            onDestroy();
            if (this.mCalled) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void performDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.mChildFragmentManager.dispatchDestroyView();
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            }
            this.mState = 1;
            this.mCalled = false;
            onDestroyView();
            if (this.mCalled) {
                LoaderManager.getInstance(this).markForRedelivery();
                this.mPerformedCreateView = false;
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void performDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.mState = -1;
            this.mCalled = false;
            onDetach();
            this.mLayoutInflater = null;
            if (this.mCalled) {
                if (this.mChildFragmentManager.isDestroyed()) {
                    return;
                }
                this.mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = new FragmentManagerImpl();
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, bundle)) == null) {
            LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
            this.mLayoutInflater = onGetLayoutInflater;
            return onGetLayoutInflater;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void performLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            onLowMemory();
            this.mChildFragmentManager.dispatchLowMemory();
        }
    }

    public void performMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z) == null) {
            onMultiWindowModeChanged(z);
            this.mChildFragmentManager.dispatchMultiWindowModeChanged(z);
        }
    }

    public boolean performOptionsItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, menuItem)) == null) {
            if (this.mHidden) {
                return false;
            }
            return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void performOptionsMenuClosed(@NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, menu) == null) || this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    public void performPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.mChildFragmentManager.dispatchPause();
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            this.mState = 3;
            this.mCalled = false;
            onPause();
            if (this.mCalled) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            onPictureInPictureModeChanged(z);
            this.mChildFragmentManager.dispatchPictureInPictureModeChanged(z);
        }
    }

    public boolean performPrepareOptionsMenu(@NonNull Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, menu)) == null) {
            boolean z = false;
            if (this.mHidden) {
                return false;
            }
            if (this.mHasMenu && this.mMenuVisible) {
                z = true;
                onPrepareOptionsMenu(menu);
            }
            return z | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    public void performPrimaryNavigationFragmentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            boolean isPrimaryNavigation = this.mFragmentManager.isPrimaryNavigation(this);
            Boolean bool = this.mIsPrimaryNavigationFragment;
            if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
                this.mIsPrimaryNavigationFragment = Boolean.valueOf(isPrimaryNavigation);
                onPrimaryNavigationFragmentChanged(isPrimaryNavigation);
                this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
            }
        }
    }

    public void performResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions(true);
            this.mState = 4;
            this.mCalled = false;
            onResume();
            if (this.mCalled) {
                this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                if (this.mView != null) {
                    this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                }
                this.mChildFragmentManager.dispatchResume();
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public void performSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            onSaveInstanceState(bundle);
            this.mSavedStateRegistryController.performSave(bundle);
            Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }

    public void performStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions(true);
            this.mState = 3;
            this.mCalled = false;
            onStart();
            if (this.mCalled) {
                this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                if (this.mView != null) {
                    this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
                }
                this.mChildFragmentManager.dispatchStart();
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    public void performStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            this.mChildFragmentManager.dispatchStop();
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            }
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mState = 2;
            this.mCalled = false;
            onStop();
            if (this.mCalled) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = true;
        }
    }

    public void registerForContextMenu(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, view) == null) {
            view.setOnCreateContextMenuListener(this);
        }
    }

    public final void requestPermissions(@NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048702, this, strArr, i2) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onRequestPermissionsFromFragment(this, strArr, i2);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                return activity;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
        }
        return (FragmentActivity) invokeV.objValue;
    }

    @NonNull
    public final Bundle requireArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
        }
        return (Bundle) invokeV.objValue;
    }

    @NonNull
    public final Context requireContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            Context context = getContext();
            if (context != null) {
                return context;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to a context.");
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? getParentFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    @NonNull
    public final Object requireHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            Object host = getHost();
            if (host != null) {
                return host;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to a host.");
        }
        return invokeV.objValue;
    }

    @NonNull
    public final Fragment requireParentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                if (getContext() == null) {
                    throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
                }
                throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
            }
            return parentFragment;
        }
        return (Fragment) invokeV.objValue;
    }

    @NonNull
    public final View requireView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            View view = getView();
            if (view != null) {
                return view;
            }
            throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
        return (View) invokeV.objValue;
    }

    public void restoreChildFragmentState(@Nullable Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, bundle) == null) || bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveState(parcelable);
        this.mChildFragmentManager.dispatchCreate();
    }

    public final void restoreViewState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = this.mSavedViewState;
            if (sparseArray != null) {
                this.mView.restoreHierarchyState(sparseArray);
                this.mSavedViewState = null;
            }
            this.mCalled = false;
            onViewStateRestored(bundle);
            if (this.mCalled) {
                if (this.mView != null) {
                    this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
            ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(z);
        }
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z) == null) {
            ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(z);
        }
    }

    public void setAnimatingAway(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, view) == null) {
            ensureAnimationInfo().mAnimatingAway = view;
        }
    }

    public void setAnimator(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, animator) == null) {
            ensureAnimationInfo().mAnimator = animator;
        }
    }

    public void setArguments(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            if (this.mFragmentManager != null && isStateSaved()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
            this.mArguments = bundle;
        }
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, sharedElementCallback) == null) {
            ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
        }
    }

    public void setEnterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, obj) == null) {
            ensureAnimationInfo().mEnterTransition = obj;
        }
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, sharedElementCallback) == null) {
            ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
        }
    }

    public void setExitTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, obj) == null) {
            ensureAnimationInfo().mExitTransition = obj;
        }
    }

    public void setHasOptionsMenu(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048721, this, z) == null) || this.mHasMenu == z) {
            return;
        }
        this.mHasMenu = z;
        if (!isAdded() || isHidden()) {
            return;
        }
        this.mHost.onSupportInvalidateOptionsMenu();
    }

    public void setHideReplaced(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            ensureAnimationInfo().mIsHideReplaced = z;
        }
    }

    public void setInitialSavedState(@Nullable SavedState savedState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, savedState) == null) {
            if (this.mFragmentManager == null) {
                this.mSavedFragmentState = (savedState == null || (r5 = savedState.mState) == null) ? null : null;
                return;
            }
            throw new IllegalStateException("Fragment already added");
        }
    }

    public void setMenuVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048724, this, z) == null) || this.mMenuVisible == z) {
            return;
        }
        this.mMenuVisible = z;
        if (this.mHasMenu && isAdded() && !isHidden()) {
            this.mHost.onSupportInvalidateOptionsMenu();
        }
    }

    public void setNextAnim(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i2) == null) {
            if (this.mAnimationInfo == null && i2 == 0) {
                return;
            }
            ensureAnimationInfo().mNextAnim = i2;
        }
    }

    public void setNextTransition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i2) == null) {
            if (this.mAnimationInfo == null && i2 == 0) {
                return;
            }
            ensureAnimationInfo();
            this.mAnimationInfo.mNextTransition = i2;
        }
    }

    public void setOnStartEnterTransitionListener(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, onStartEnterTransitionListener) == null) {
            ensureAnimationInfo();
            OnStartEnterTransitionListener onStartEnterTransitionListener2 = this.mAnimationInfo.mStartEnterTransitionListener;
            if (onStartEnterTransitionListener == onStartEnterTransitionListener2) {
                return;
            }
            if (onStartEnterTransitionListener != null && onStartEnterTransitionListener2 != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            }
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo.mEnterTransitionPostponed) {
                animationInfo.mStartEnterTransitionListener = onStartEnterTransitionListener;
            }
            if (onStartEnterTransitionListener != null) {
                onStartEnterTransitionListener.startListening();
            }
        }
    }

    public void setReenterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, obj) == null) {
            ensureAnimationInfo().mReenterTransition = obj;
        }
    }

    public void setRetainInstance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
            this.mRetainInstance = z;
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager == null) {
                this.mRetainInstanceChangedWhileDetached = true;
            } else if (z) {
                fragmentManager.addRetainedFragment(this);
            } else {
                fragmentManager.removeRetainedFragment(this);
            }
        }
    }

    public void setReturnTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, obj) == null) {
            ensureAnimationInfo().mReturnTransition = obj;
        }
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, obj) == null) {
            ensureAnimationInfo().mSharedElementEnterTransition = obj;
        }
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, obj) == null) {
            ensureAnimationInfo().mSharedElementReturnTransition = obj;
        }
    }

    public void setStateAfterAnimating(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            ensureAnimationInfo().mStateAfterAnimating = i2;
        }
    }

    public void setTargetFragment(@Nullable Fragment fragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048734, this, fragment, i2) == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
            if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
                throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
            }
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
                if (fragment2 == this) {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            } else {
                this.mTargetWho = null;
                this.mTarget = fragment;
            }
            this.mTargetRequestCode = i2;
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
                this.mFragmentManager.performPendingDeferredStart(this);
            }
            this.mUserVisibleHint = z;
            this.mDeferStart = this.mState < 3 && !z;
            if (this.mSavedFragmentState != null) {
                this.mSavedUserVisibleHint = Boolean.valueOf(z);
            }
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048736, this, str)) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, intent) == null) {
            startActivity(intent, null);
        }
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048739, this, intent, i2) == null) {
            startActivityForResult(intent, i2, null);
        }
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048741, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onStartIntentSenderFromFragment(this, intentSender, i2, intent, i3, i4, i5, bundle);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null && fragmentManager.mHost != null) {
                if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper()) {
                    this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Runnable(this) { // from class: androidx.fragment.app.Fragment.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Fragment this$0;

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
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.callStartTransitionListener();
                            }
                        }
                    });
                    return;
                } else {
                    callStartTransitionListener();
                    return;
                }
            }
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(getClass().getSimpleName());
            sb.append(StringUtil.ARRAY_START);
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("}");
            sb.append(" (");
            sb.append(this.mWho);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            if (this.mFragmentId != 0) {
                sb.append(" id=0x");
                sb.append(Integer.toHexString(this.mFragmentId));
            }
            if (this.mTag != null) {
                sb.append(" ");
                sb.append(this.mTag);
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void unregisterForContextMenu(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, view) == null) {
            view.setOnCreateContextMenuListener(null);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1387893136, "Landroidx/fragment/app/Fragment$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1387893136, "Landroidx/fragment/app/Fragment$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }
            };
        }

        public SavedState(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mState = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                parcel.writeBundle(this.mState);
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, bundle)) == null) {
            try {
                Fragment newInstance = FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (bundle != null) {
                    bundle.setClassLoader(newInstance.getClass().getClassLoader());
                    newInstance.setArguments(bundle);
                }
                return newInstance;
            } catch (IllegalAccessException e2) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            } catch (java.lang.InstantiationException e3) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
            } catch (NoSuchMethodException e4) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
            } catch (InvocationTargetException e5) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
            }
        }
        return (Fragment) invokeLLL.objValue;
    }

    @NonNull
    public final String getString(@StringRes int i2, @Nullable Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i2, objArr)) == null) ? getResources().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public final void postponeEnterTransition(long j2, @NonNull TimeUnit timeUnit) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048700, this, j2, timeUnit) == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                handler = fragmentManager.mHost.getHandler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
        }
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048738, this, intent, bundle) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048740, this, intent, i2, bundle) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onStartActivityFromFragment(this, intent, i2, bundle);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bundle)) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
                LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
                return onGetLayoutInflater;
            }
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        return (LayoutInflater) invokeL.objValue;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, activity) == null) {
            this.mCalled = true;
        }
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048659, this, activity, attributeSet, bundle) == null) {
            this.mCalled = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @ContentView
    public Fragment(@LayoutRes int i2) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContentLayoutId = i2;
    }
}
