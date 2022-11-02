package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    public static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    public static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    public static final String TAG = "FragmentActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCreated;
    public final LifecycleRegistry mFragmentLifecycleRegistry;
    public final FragmentController mFragments;
    public int mNextCandidateRequestIndex;
    public SparseArrayCompat<String> mPendingFragmentActivityResults;
    public boolean mRequestedPermissionsFromFragment;
    public boolean mResumed;
    public boolean mStartedActivityFromFragment;
    public boolean mStartedIntentSenderFromFragment;
    public boolean mStopped;

    public void onAttachFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fragment) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HostCallbacks(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fragmentActivity;
        }

        @Override // androidx.lifecycle.LifecycleOwner
        @NonNull
        public Lifecycle getLifecycle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.mFragmentLifecycleRegistry;
            }
            return (Lifecycle) invokeV.objValue;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.this$0.getOnBackPressedDispatcher();
            }
            return (OnBackPressedDispatcher) invokeV.objValue;
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        @NonNull
        public ViewModelStore getViewModelStore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.getViewModelStore();
            }
            return (ViewModelStore) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.this$0;
            }
            return (FragmentActivity) invokeV.objValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
            }
            return (LayoutInflater) invokeV.objValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Window window = this.this$0.getWindow();
                if (window == null) {
                    return 0;
                }
                return window.getAttributes().windowAnimations;
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Window window = this.this$0.getWindow();
                if (window != null && window.peekDecorView() != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.this$0.getWindow() != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                this.this$0.supportInvalidateOptionsMenu();
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onAttachFragment(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fragment) == null) {
                this.this$0.onAttachFragment(fragment);
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        @Nullable
        public View onFindViewById(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return this.this$0.findViewById(i);
            }
            return (View) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fragment)) == null) {
                return !this.this$0.isFinishing();
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, str);
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, fileDescriptor, printWriter, strArr) == null) {
                this.this$0.dump(str, fileDescriptor, printWriter, strArr);
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048592, this, fragment, intent, i, bundle) == null) {
                this.this$0.startActivityFromFragment(fragment, intent, i, bundle);
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048588, this, fragment, strArr, i) == null) {
                this.this$0.requestPermissionsFromFragment(fragment, strArr, i);
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048591, this, fragment, intent, i) == null) {
                this.this$0.startActivityFromFragment(fragment, intent, i);
            }
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onStartIntentSenderFromFragment(@NonNull Fragment fragment, IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{fragment, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
                this.this$0.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
            }
        }
    }

    public FragmentActivity() {
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
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStart();
            this.mStopped = false;
            if (!this.mCreated) {
                this.mCreated = true;
                this.mFragments.dispatchActivityCreated();
            }
            this.mFragments.noteStateNotSaved();
            this.mFragments.execPendingActions();
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.mFragments.dispatchStart();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @ContentView
    public FragmentActivity(@LayoutRes int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
    }

    private int allocateRequestIndex(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, fragment)) == null) {
            if (this.mPendingFragmentActivityResults.size() < 65534) {
                while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
                    this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
                }
                int i = this.mNextCandidateRequestIndex;
                this.mPendingFragmentActivityResults.put(i, fragment.mWho);
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
                return i;
            }
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        return invokeL.intValue;
    }

    public static void checkForValidRequestCode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65539, null, i) != null) || (i & (-65536)) == 0) {
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mFragments.noteStateNotSaved();
            this.mFragments.dispatchConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mFragments.dispatchMultiWindowModeChanged(z);
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            super.onNewIntent(intent);
            this.mFragments.noteStateNotSaved();
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mFragments.dispatchPictureInPictureModeChanged(z);
        }
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, sharedElementCallback) == null) {
            ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
        }
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sharedElementCallback) == null) {
            ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
        }
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i) == null) && !this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }

    private void markFragmentsCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            do {
            } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
        }
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFragments.getSupportFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return LoaderManager.getInstance(this);
        }
        return (LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            this.mFragments.dispatchDestroy();
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onLowMemory();
            this.mFragments.dispatchLowMemory();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            this.mResumed = false;
            this.mFragments.dispatchPause();
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPostResume();
            onResumeFragments();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.mResumed = true;
            this.mFragments.noteStateNotSaved();
            this.mFragments.execPendingActions();
        }
    }

    public void onResumeFragments() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mFragments.dispatchResume();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mFragments.noteStateNotSaved();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            this.mStopped = true;
            markFragmentsCreated();
            this.mFragments.dispatchStop();
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
    }

    public void supportFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            invalidateOptionsMenu();
        }
    }

    public void supportPostponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            ActivityCompat.postponeEnterTransition(this);
        }
    }

    public void supportStartPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            ActivityCompat.startPostponedEnterTransition(this);
        }
    }

    public static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, fragmentManager, state)) == null) {
            boolean z = false;
            for (Fragment fragment : fragmentManager.getFragments()) {
                if (fragment != null) {
                    if (fragment.getHost() != null) {
                        z |= markState(fragment.getChildFragmentManager(), state);
                    }
                    FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
                    if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        fragment.mViewLifecycleOwner.setCurrentState(state);
                        z = true;
                    }
                    if (fragment.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        fragment.mLifecycleRegistry.setCurrentState(state);
                        z = true;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public final View dispatchFragmentsOnCreateView(@Nullable View view2, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, view2, str, context, attributeSet)) == null) {
            return this.mFragments.onCreateView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view2, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, view2, str, context, attributeSet)) == null) {
            View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view2, str, context, attributeSet);
            if (dispatchFragmentsOnCreateView == null) {
                return super.onCreateView(view2, str, context, attributeSet);
            }
            return dispatchFragmentsOnCreateView;
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + GlideException.IndentedAppendable.INDENT;
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                LoaderManager.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Activity
    @CallSuper
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            this.mFragments.noteStateNotSaved();
            int i3 = i >> 16;
            if (i3 != 0) {
                int i4 = i3 - 1;
                String str = this.mPendingFragmentActivityResults.get(i4);
                this.mPendingFragmentActivityResults.remove(i4);
                if (str == null) {
                    Log.w(TAG, "Activity result delivered for unknown Fragment.");
                    return;
                }
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho == null) {
                    Log.w(TAG, "Activity result no fragment exists for who: " + str);
                    return;
                }
                findFragmentByWho.onActivityResult(i & 65535, i2, intent);
                return;
            }
            ActivityCompat.PermissionCompatDelegate permissionCompatDelegate = ActivityCompat.getPermissionCompatDelegate();
            if (permissionCompatDelegate != null && permissionCompatDelegate.onActivityResult(this, i, i2, intent)) {
                return;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.mFragments.attachHost(null);
            if (bundle != null) {
                this.mFragments.restoreSaveState(bundle.getParcelable(FRAGMENTS_TAG));
                if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                    this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                    int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                    String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                    if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                        this.mPendingFragmentActivityResults = new SparseArrayCompat<>(intArray.length);
                        for (int i = 0; i < intArray.length; i++) {
                            this.mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                        }
                    } else {
                        Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                    }
                }
            }
            if (this.mPendingFragmentActivityResults == null) {
                this.mPendingFragmentActivityResults = new SparseArrayCompat<>();
                this.mNextCandidateRequestIndex = 0;
            }
            super.onCreate(bundle);
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            this.mFragments.dispatchCreate();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            markFragmentsCreated();
            this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            Parcelable saveAllState = this.mFragments.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
            }
            if (this.mPendingFragmentActivityResults.size() > 0) {
                bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
                int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
                String[] strArr = new String[this.mPendingFragmentActivityResults.size()];
                for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++) {
                    iArr[i] = this.mPendingFragmentActivityResults.keyAt(i);
                    strArr[i] = this.mPendingFragmentActivityResults.valueAt(i);
                }
                bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
                bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, @NonNull Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, menu)) == null) {
            if (i == 0) {
                return super.onCreatePanelMenu(i, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            }
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, menuItem)) == null) {
            if (super.onMenuItemSelected(i, menuItem)) {
                return true;
            }
            if (i != 0) {
                if (i != 6) {
                    return false;
                }
                return this.mFragments.dispatchContextItemSelected(menuItem);
            }
            return this.mFragments.dispatchOptionsItemSelected(menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, @NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, menu) == null) {
            if (i == 0) {
                this.mFragments.dispatchOptionsMenuClosed(menu);
            }
            super.onPanelClosed(i, menu);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public boolean onPrepareOptionsPanel(@Nullable View view2, @NonNull Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, view2, menu)) == null) {
            return super.onPreparePanel(0, view2, menu);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, intent, i) == null) {
            if (!this.mStartedActivityFromFragment && i != -1) {
                checkForValidRequestCode(i);
            }
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, context, attributeSet)) == null) {
            View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
            if (dispatchFragmentsOnCreateView == null) {
                return super.onCreateView(str, context, attributeSet);
            }
            return dispatchFragmentsOnCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, @Nullable View view2, @NonNull Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048597, this, i, view2, menu)) == null) {
            if (i == 0) {
                return onPrepareOptionsPanel(view2, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
            }
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048609, this, intent, i, bundle) == null) {
            if (!this.mStartedActivityFromFragment && i != -1) {
                checkForValidRequestCode(i);
            }
            super.startActivityForResult(intent, i, bundle);
        }
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, fragment, intent, i) == null) {
            startActivityFromFragment(fragment, intent, i, (Bundle) null);
        }
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048598, this, i, strArr, iArr) == null) {
            this.mFragments.noteStateNotSaved();
            int i2 = (i >> 16) & 65535;
            if (i2 != 0) {
                int i3 = i2 - 1;
                String str = this.mPendingFragmentActivityResults.get(i3);
                this.mPendingFragmentActivityResults.remove(i3);
                if (str == null) {
                    Log.w(TAG, "Activity result delivered for unknown Fragment.");
                    return;
                }
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho == null) {
                    Log.w(TAG, "Activity result no fragment exists for who: " + str);
                    return;
                }
                findFragmentByWho.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void requestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048605, this, fragment, strArr, i) == null) {
            if (i == -1) {
                ActivityCompat.requestPermissions(this, strArr, i);
                return;
            }
            checkForValidRequestCode(i);
            try {
                this.mRequestedPermissionsFromFragment = true;
                ActivityCompat.requestPermissions(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
            } finally {
                this.mRequestedPermissionsFromFragment = false;
            }
        }
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048611, this, fragment, intent, i, bundle) == null) {
            this.mStartedActivityFromFragment = true;
            try {
                if (i == -1) {
                    ActivityCompat.startActivityForResult(this, intent, -1, bundle);
                    return;
                }
                checkForValidRequestCode(i);
                ActivityCompat.startActivityForResult(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!this.mStartedIntentSenderFromFragment && i != -1) {
                checkForValidRequestCode(i);
            }
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            if (!this.mStartedIntentSenderFromFragment && i != -1) {
                checkForValidRequestCode(i);
            }
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{fragment, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            this.mStartedIntentSenderFromFragment = true;
            try {
                if (i == -1) {
                    ActivityCompat.startIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
                    return;
                }
                checkForValidRequestCode(i);
                ActivityCompat.startIntentSenderForResult(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        }
    }
}
