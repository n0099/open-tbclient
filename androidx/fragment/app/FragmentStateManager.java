package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FragmentStateManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FragmentManager";
    public static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    public static final String TARGET_STATE_TAG = "android:target_state";
    public static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    public static final String VIEW_STATE_TAG = "android:view_state";
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentLifecycleCallbacksDispatcher mDispatcher;
    @NonNull
    public final Fragment mFragment;
    public int mFragmentManagerState;

    /* renamed from: androidx.fragment.app.FragmentStateManager$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-99163697, "Landroidx/fragment/app/FragmentStateManager$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-99163697, "Landroidx/fragment/app/FragmentStateManager$1;");
                    return;
                }
            }
            int[] iArr = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentLifecycleCallbacksDispatcher, fragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFragmentManagerState = -1;
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
    }

    private Bundle saveBasicState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Bundle bundle = new Bundle();
            this.mFragment.performSaveInstanceState(bundle);
            this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (this.mFragment.mView != null) {
                saveViewState();
            }
            if (this.mFragment.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
            }
            if (!this.mFragment.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public void activityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
            }
            Fragment fragment = this.mFragment;
            fragment.performActivityCreated(fragment.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment2 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
        }
    }

    public void attach(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentHostCallback, fragmentManager, fragment) == null) {
            Fragment fragment2 = this.mFragment;
            fragment2.mHost = fragmentHostCallback;
            fragment2.mParentFragment = fragment;
            fragment2.mFragmentManager = fragmentManager;
            this.mDispatcher.dispatchOnFragmentPreAttached(fragment2, fragmentHostCallback.getContext(), false);
            this.mFragment.performAttach();
            Fragment fragment3 = this.mFragment;
            Fragment fragment4 = fragment3.mParentFragment;
            if (fragment4 == null) {
                fragmentHostCallback.onAttachFragment(fragment3);
            } else {
                fragment4.onAttachFragment(fragment3);
            }
            this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, fragmentHostCallback.getContext(), false);
        }
    }

    public int computeMaxState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.mFragmentManagerState;
            Fragment fragment = this.mFragment;
            if (fragment.mFromLayout) {
                if (fragment.mInLayout) {
                    i = Math.max(i, 1);
                } else if (i < 2) {
                    i = Math.min(i, fragment.mState);
                } else {
                    i = Math.min(i, 1);
                }
            }
            if (!this.mFragment.mAdded) {
                i = Math.min(i, 1);
            }
            Fragment fragment2 = this.mFragment;
            if (fragment2.mRemoving) {
                if (fragment2.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, -1);
                }
            }
            Fragment fragment3 = this.mFragment;
            if (fragment3.mDeferStart && fragment3.mState < 3) {
                i = Math.min(i, 2);
            }
            int i2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return Math.min(i, -1);
                    }
                    return Math.min(i, 1);
                }
                return Math.min(i, 3);
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void create() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
            }
            Fragment fragment = this.mFragment;
            if (!fragment.mIsCreated) {
                this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
                Fragment fragment2 = this.mFragment;
                fragment2.performCreate(fragment2.mSavedFragmentState);
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment3 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
                return;
            }
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.mFragment.mState = 1;
        }
    }

    public void createView(@NonNull FragmentContainer fragmentContainer) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fragmentContainer) == null) || this.mFragment.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
        }
        ViewGroup viewGroup = null;
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (i != -1) {
                    viewGroup = (ViewGroup) fragmentContainer.onFindViewById(i);
                    if (viewGroup == null) {
                        Fragment fragment2 = this.mFragment;
                        if (!fragment2.mRestored) {
                            try {
                                str = fragment2.getResources().getResourceName(this.mFragment.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + str + ") for fragment " + this.mFragment);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
                }
            }
        }
        Fragment fragment3 = this.mFragment;
        fragment3.mContainer = viewGroup;
        fragment3.performCreateView(fragment3.performGetLayoutInflater(fragment3.mSavedFragmentState), viewGroup, this.mFragment.mSavedFragmentState);
        View view2 = this.mFragment.mView;
        if (view2 != null) {
            boolean z = false;
            view2.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.mFragment;
            fragment4.mView.setTag(R$id.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                viewGroup.addView(this.mFragment.mView);
            }
            Fragment fragment5 = this.mFragment;
            if (fragment5.mHidden) {
                fragment5.mView.setVisibility(8);
            }
            ViewCompat.requestApplyInsets(this.mFragment.mView);
            Fragment fragment6 = this.mFragment;
            fragment6.onViewCreated(fragment6.mView, fragment6.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment7 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            Fragment fragment8 = this.mFragment;
            if (fragment8.mView.getVisibility() == 0 && this.mFragment.mContainer != null) {
                z = true;
            }
            fragment8.mIsNewlyAdded = z;
        }
    }

    public void destroy(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fragmentHostCallback, fragmentManagerViewModel) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
            }
            Fragment fragment = this.mFragment;
            boolean z = true;
            boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
            if (z2 || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
                if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                    z = fragmentManagerViewModel.isCleared();
                } else if (fragmentHostCallback.getContext() instanceof Activity) {
                    z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
                }
                if (z2 || z) {
                    fragmentManagerViewModel.clearNonConfigState(this.mFragment);
                }
                this.mFragment.performDestroy();
                this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
                return;
            }
            this.mFragment.mState = 0;
        }
    }

    public void detach(@NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fragmentManagerViewModel) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
            }
            this.mFragment.performDetach();
            boolean z = false;
            this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
            Fragment fragment = this.mFragment;
            fragment.mState = -1;
            fragment.mHost = null;
            fragment.mParentFragment = null;
            fragment.mFragmentManager = null;
            if (fragment.mRemoving && !fragment.isInBackStack()) {
                z = true;
            }
            if (z || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
                }
                this.mFragment.initState();
            }
        }
    }

    public void ensureInflatedView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Fragment fragment = this.mFragment;
            if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
                }
                Fragment fragment2 = this.mFragment;
                fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
                View view2 = this.mFragment.mView;
                if (view2 != null) {
                    view2.setSaveFromParentEnabled(false);
                    Fragment fragment3 = this.mFragment;
                    fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                    Fragment fragment4 = this.mFragment;
                    if (fragment4.mHidden) {
                        fragment4.mView.setVisibility(8);
                    }
                    Fragment fragment5 = this.mFragment;
                    fragment5.onViewCreated(fragment5.mView, fragment5.mSavedFragmentState);
                    FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                    Fragment fragment6 = this.mFragment;
                    fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment6, fragment6.mView, fragment6.mSavedFragmentState, false);
                }
            }
        }
    }

    @NonNull
    public Fragment getFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFragment : (Fragment) invokeV.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
            }
            this.mFragment.performPause();
            this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
        }
    }

    public void restoreState(@NonNull ClassLoader classLoader) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, classLoader) == null) || (bundle = this.mFragment.mSavedFragmentState) == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.mFragment;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment fragment2 = this.mFragment;
        fragment2.mTargetWho = fragment2.mSavedFragmentState.getString(TARGET_STATE_TAG);
        Fragment fragment3 = this.mFragment;
        if (fragment3.mTargetWho != null) {
            fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
        }
        Fragment fragment4 = this.mFragment;
        Boolean bool = fragment4.mSavedUserVisibleHint;
        if (bool != null) {
            fragment4.mUserVisibleHint = bool.booleanValue();
            this.mFragment.mSavedUserVisibleHint = null;
        } else {
            fragment4.mUserVisibleHint = fragment4.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        }
        Fragment fragment5 = this.mFragment;
        if (fragment5.mUserVisibleHint) {
            return;
        }
        fragment5.mDeferStart = true;
    }

    public void restoreViewState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.mFragment);
            }
            Fragment fragment = this.mFragment;
            if (fragment.mView != null) {
                fragment.restoreViewState(fragment.mSavedFragmentState);
            }
            this.mFragment.mSavedFragmentState = null;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto RESUMED: " + this.mFragment);
            }
            this.mFragment.performResume();
            this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
            Fragment fragment = this.mFragment;
            fragment.mSavedFragmentState = null;
            fragment.mSavedViewState = null;
        }
    }

    @Nullable
    public Fragment.SavedState saveInstanceState() {
        InterceptResult invokeV;
        Bundle saveBasicState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
                return null;
            }
            return new Fragment.SavedState(saveBasicState);
        }
        return (Fragment.SavedState) invokeV.objValue;
    }

    @NonNull
    public FragmentState saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FragmentState fragmentState = new FragmentState(this.mFragment);
            if (this.mFragment.mState > -1 && fragmentState.mSavedFragmentState == null) {
                Bundle saveBasicState = saveBasicState();
                fragmentState.mSavedFragmentState = saveBasicState;
                if (this.mFragment.mTargetWho != null) {
                    if (saveBasicState == null) {
                        fragmentState.mSavedFragmentState = new Bundle();
                    }
                    fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                    int i = this.mFragment.mTargetRequestCode;
                    if (i != 0) {
                        fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i);
                    }
                }
            } else {
                fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
            }
            return fragmentState;
        }
        return (FragmentState) invokeV.objValue;
    }

    public void saveViewState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.mFragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.mFragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.mFragment.mSavedViewState = sparseArray;
        }
    }

    public void setFragmentManagerState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mFragmentManagerState = i;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
            }
            this.mFragment.performStart();
            this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
            }
            this.mFragment.performStop();
            this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentLifecycleCallbacksDispatcher, classLoader, fragmentFactory, fragmentState};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFragmentManagerState = -1;
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.mFragment.setArguments(fragmentState.mArguments);
        Fragment fragment = this.mFragment;
        fragment.mWho = fragmentState.mWho;
        fragment.mFromLayout = fragmentState.mFromLayout;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.mFragmentId;
        fragment.mContainerId = fragmentState.mContainerId;
        fragment.mTag = fragmentState.mTag;
        fragment.mRetainInstance = fragmentState.mRetainInstance;
        fragment.mRemoving = fragmentState.mRemoving;
        fragment.mDetached = fragmentState.mDetached;
        fragment.mHidden = fragmentState.mHidden;
        fragment.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            this.mFragment.mSavedFragmentState = bundle2;
        } else {
            this.mFragment.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.mFragment);
        }
    }

    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentLifecycleCallbacksDispatcher, fragment, fragmentState};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFragmentManagerState = -1;
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.mFragment;
        fragment3.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment3.mSavedFragmentState = bundle;
        } else {
            fragment3.mSavedFragmentState = new Bundle();
        }
    }
}
