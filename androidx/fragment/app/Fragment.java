package androidx.fragment.app;

import android.animation.Animator;
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
    public FragmentManager mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
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
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public FragmentViewLifecycleOwner mViewLifecycleOwner;
    public MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    public String mWho;

    /* loaded from: classes.dex */
    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048641, this, i, i2, intent) == null) {
        }
    }

    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, fragment) == null) {
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048649, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Animator) invokeCommon.objValue;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, menu, menuInflater) == null) {
        }
    }

    public void onDestroyOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
        }
    }

    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, menu) == null) {
        }
    }

    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, menu) == null) {
        }
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048669, this, i, strArr, iArr) == null) {
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, bundle) == null) {
        }
    }

    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048674, this, view2, bundle) == null) {
        }
    }

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SavedState(parcel, null);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) {
                        return new SavedState(parcel, classLoader);
                    }
                    return (SavedState) invokeLL.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mState = bundle;
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeBundle(this.mState);
            }
        }
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        View view2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_STOP && (view2 = this.this$0.mView) != null) {
                            view2.cancelPendingInputEvents();
                        }
                    }
                });
            }
        }
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
            if (animationInfo != null && (bool = animationInfo.mAllowEnterTransitionOverlap) != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean getAllowReturnTransitionOverlap() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo != null && (bool = animationInfo.mAllowReturnTransitionOverlap) != null) {
                return bool.booleanValue();
            }
            return true;
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

    public final Bundle getArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mArguments;
        }
        return (Bundle) invokeV.objValue;
    }

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

    @Deprecated
    public final FragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mFragmentManager;
        }
        return (FragmentManager) invokeV.objValue;
    }

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mFragmentId;
        }
        return invokeV.intValue;
    }

    public final LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            LayoutInflater layoutInflater = this.mLayoutInflater;
            if (layoutInflater == null) {
                return performGetLayoutInflater(null);
            }
            return layoutInflater;
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mLifecycleRegistry;
        }
        return (Lifecycle) invokeV.objValue;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return LoaderManager.getInstance(this);
        }
        return (LoaderManager) invokeV.objValue;
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

    public final Fragment getParentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mParentFragment;
        }
        return (Fragment) invokeV.objValue;
    }

    public Object getReenterTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mReenterTransition;
            if (obj == USE_DEFAULT_TRANSITION) {
                return getExitTransition();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return requireContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public final boolean getRetainInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mRetainInstance;
        }
        return invokeV.booleanValue;
    }

    public Object getReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mReturnTransition;
            if (obj == USE_DEFAULT_TRANSITION) {
                return getEnterTransition();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mSavedStateRegistryController.getSavedStateRegistry();
        }
        return (SavedStateRegistry) invokeV.objValue;
    }

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

    public Object getSharedElementReturnTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            AnimationInfo animationInfo = this.mAnimationInfo;
            if (animationInfo == null) {
                return null;
            }
            Object obj = animationInfo.mSharedElementReturnTransition;
            if (obj == USE_DEFAULT_TRANSITION) {
                return getSharedElementEnterTransition();
            }
            return obj;
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

    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mTag;
        }
        return (String) invokeV.objValue;
    }

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
            if (fragmentManager != null && (str = this.mTargetWho) != null) {
                return fragmentManager.findActiveFragment(str);
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public final int getTargetRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mTargetRequestCode;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mUserVisibleHint;
        }
        return invokeV.booleanValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mView;
        }
        return (View) invokeV.objValue;
    }

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

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mViewLifecycleOwnerLiveData;
        }
        return (LiveData) invokeV.objValue;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
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

    public final boolean hasOptionsMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mHasMenu;
        }
        return invokeV.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public final boolean isAdded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.mHost != null && this.mAdded) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isDetached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mDetached;
        }
        return invokeV.booleanValue;
    }

    public final boolean isHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mHidden;
        }
        return invokeV.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.mBackStackNesting > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isInLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.mInLayout;
        }
        return invokeV.booleanValue;
    }

    public final boolean isMenuVisible() {
        InterceptResult invokeV;
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mRemoving;
        }
        return invokeV.booleanValue;
    }

    public final boolean isRemovingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.mState >= 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public void noteStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.mCalled = true;
        }
    }

    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.mCalled = true;
        }
    }

    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.mCalled = true;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            this.mCalled = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            this.mCalled = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.mCalled = true;
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.mCalled = true;
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.mCalled = true;
        }
    }

    public void performLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            onLowMemory();
            this.mChildFragmentManager.dispatchLowMemory();
        }
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

    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = true;
        }
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return getParentFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    public Fragment() {
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.fragment.app.FragmentContainer
                public View onFindViewById(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                        View view2 = this.this$0.mView;
                        if (view2 != null) {
                            return view2.findViewById(i);
                        }
                        throw new IllegalStateException("Fragment " + this + " does not have a view");
                    }
                    return (View) invokeI.objValue;
                }

                @Override // androidx.fragment.app.FragmentContainer
                public boolean onHasView() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (this.this$0.mView != null) {
                            return true;
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
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
                if (!this.mChildFragmentManager.isDestroyed()) {
                    this.mChildFragmentManager.dispatchDestroy();
                    this.mChildFragmentManager = new FragmentManagerImpl();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Fragment(int i) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContentLayoutId = i;
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

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
                this.mFragmentManager.performPendingDeferredStart(this);
            }
            this.mUserVisibleHint = z;
            if (this.mState < 3 && !z) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mDeferStart = z2;
            if (this.mSavedFragmentState != null) {
                this.mSavedUserVisibleHint = Boolean.valueOf(z);
            }
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            return instantiate(context, str, null);
        }
        return (Fragment) invokeLL.objValue;
    }

    public final String getString(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048613, this, i, objArr)) == null) {
            return getResources().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
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

    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048739, this, intent, i) == null) {
            startActivityForResult(intent, i, null);
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
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
            } catch (IllegalAccessException e) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
            } catch (java.lang.InstantiationException e2) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            } catch (NoSuchMethodException e3) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
            } catch (InvocationTargetException e4) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
            }
        }
        return (Fragment) invokeLLL.objValue;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
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

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public Fragment findFragmentByWho(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str.equals(this.mWho)) {
                return this;
            }
            return this.mChildFragmentManager.findFragmentByWho(str);
        }
        return (Fragment) invokeL.objValue;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
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

    public final String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            return getResources().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public final CharSequence getText(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            return getResources().getText(i);
        }
        return (CharSequence) invokeI.objValue;
    }

    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            this.mCalled = true;
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, activity) == null) {
            this.mCalled = true;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, configuration) == null) {
            this.mCalled = true;
        }
    }

    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            this.mCalled = true;
            restoreChildFragmentState(bundle);
            if (!this.mChildFragmentManager.isStateAtLeast(1)) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, bundle)) == null) {
            return getLayoutInflater(bundle);
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void onViewStateRestored(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            this.mCalled = true;
        }
    }

    public void performConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, configuration) == null) {
            onConfigurationChanged(configuration);
            this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, menuItem)) == null) {
            if (!this.mHidden) {
                if (onContextItemSelected(menuItem) || this.mChildFragmentManager.dispatchContextItemSelected(menuItem)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, bundle)) == null) {
            LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
            this.mLayoutInflater = onGetLayoutInflater;
            return onGetLayoutInflater;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void performMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z) == null) {
            onMultiWindowModeChanged(z);
            this.mChildFragmentManager.dispatchMultiWindowModeChanged(z);
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, menuItem)) == null) {
            if (!this.mHidden) {
                if ((this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void performOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048690, this, menu) == null) && !this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            onPictureInPictureModeChanged(z);
            this.mChildFragmentManager.dispatchPictureInPictureModeChanged(z);
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
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

    public void performSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            onSaveInstanceState(bundle);
            this.mSavedStateRegistryController.performSave(bundle);
            Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, saveAllState);
            }
        }
    }

    public void registerForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, view2) == null) {
            view2.setOnCreateContextMenuListener(this);
        }
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048710, this, bundle) == null) && bundle != null && (parcelable = bundle.getParcelable(FragmentActivity.FRAGMENTS_TAG)) != null) {
            this.mChildFragmentManager.restoreSaveState(parcelable);
            this.mChildFragmentManager.dispatchCreate();
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

    public void setAnimatingAway(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, view2) == null) {
            ensureAnimationInfo().mAnimatingAway = view2;
        }
    }

    public void setAnimator(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, animator) == null) {
            ensureAnimationInfo().mAnimator = animator;
        }
    }

    public void setArguments(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            if (this.mFragmentManager != null && isStateSaved()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
            this.mArguments = bundle;
        }
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, sharedElementCallback) == null) {
            ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
        }
    }

    public void setEnterTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, obj) == null) {
            ensureAnimationInfo().mEnterTransition = obj;
        }
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, sharedElementCallback) == null) {
            ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
        }
    }

    public void setExitTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, obj) == null) {
            ensureAnimationInfo().mExitTransition = obj;
        }
    }

    public void setHasOptionsMenu(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048721, this, z) == null) && this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setHideReplaced(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            ensureAnimationInfo().mIsHideReplaced = z;
        }
    }

    public void setInitialSavedState(SavedState savedState) {
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
        if ((interceptable == null || interceptable.invokeZ(1048724, this, z) == null) && this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextAnim(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i) == null) {
            if (this.mAnimationInfo == null && i == 0) {
                return;
            }
            ensureAnimationInfo().mNextAnim = i;
        }
    }

    public void setNextTransition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i) == null) {
            if (this.mAnimationInfo == null && i == 0) {
                return;
            }
            ensureAnimationInfo();
            this.mAnimationInfo.mNextTransition = i;
        }
    }

    public void setReenterTransition(Object obj) {
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
            if (fragmentManager != null) {
                if (z) {
                    fragmentManager.addRetainedFragment(this);
                    return;
                } else {
                    fragmentManager.removeRetainedFragment(this);
                    return;
                }
            }
            this.mRetainInstanceChangedWhileDetached = true;
        }
    }

    public void setReturnTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, obj) == null) {
            ensureAnimationInfo().mReturnTransition = obj;
        }
    }

    public void setSharedElementEnterTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, obj) == null) {
            ensureAnimationInfo().mSharedElementEnterTransition = obj;
        }
    }

    public void setSharedElementReturnTransition(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, obj) == null) {
            ensureAnimationInfo().mSharedElementReturnTransition = obj;
        }
    }

    public void setStateAfterAnimating(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i) == null) {
            ensureAnimationInfo().mStateAfterAnimating = i;
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
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

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, intent) == null) {
            startActivity(intent, null);
        }
    }

    public void unregisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, view2) == null) {
            view2.setOnCreateContextMenuListener(null);
        }
    }

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

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
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

    public final boolean isVisible() {
        InterceptResult invokeV;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (isAdded() && !isHidden() && (view2 = this.mView) != null && view2.getWindowToken() != null && this.mView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public final View requireView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            View view2 = getView();
            if (view2 != null) {
                return view2;
            }
            throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
        return (View) invokeV.objValue;
    }

    public void onAttach(Context context) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            this.mCalled = true;
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                activity = null;
            } else {
                activity = fragmentHostCallback.getActivity();
            }
            if (activity != null) {
                this.mCalled = false;
                onAttach(activity);
            }
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048650, this, contextMenu, view2, contextMenuInfo) == null) {
            requireActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048652, this, layoutInflater, viewGroup, bundle)) == null) {
            int i = this.mContentLayoutId;
            if (i != 0) {
                return layoutInflater.inflate(i, viewGroup, false);
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048659, this, activity, attributeSet, bundle) == null) {
            this.mCalled = true;
        }
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048660, this, context, attributeSet, bundle) == null) {
            this.mCalled = true;
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                activity = null;
            } else {
                activity = fragmentHostCallback.getActivity();
            }
            if (activity != null) {
                this.mCalled = false;
                onInflate(activity, attributeSet, bundle);
            }
        }
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

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048700, this, j, timeUnit) == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                handler = fragmentManager.mHost.getHandler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
        }
    }

    public final void requestPermissions(String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048702, this, strArr, i) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onRequestPermissionsFromFragment(this, strArr, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
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

    public void setTargetFragment(Fragment fragment, int i) {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048734, this, fragment, i) == null) {
            FragmentManager fragmentManager2 = this.mFragmentManager;
            if (fragment != null) {
                fragmentManager = fragment.mFragmentManager;
            } else {
                fragmentManager = null;
            }
            if (fragmentManager2 != null && fragmentManager != null && fragmentManager2 != fragmentManager) {
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
            this.mTargetRequestCode = i;
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048740, this, intent, i, bundle) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onStartActivityFromFragment(this, intent, i, bundle);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048741, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                fragmentHostCallback.onStartIntentSenderFromFragment(this, intentSender, i, intent, i2, i3, i4, bundle);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(getClass().getSimpleName());
            sb.append("{");
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
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
