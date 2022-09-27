package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.core.util.LogWriter;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class FragmentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<BackStackRecord> mBackStack;
    public ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    public final AtomicInteger mBackStackIndex;
    public FragmentContainer mContainer;
    public ArrayList<Fragment> mCreatedMenus;
    public int mCurState;
    public boolean mDestroyed;
    public Runnable mExecCommit;
    public boolean mExecutingActions;
    public ConcurrentHashMap<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals;
    public FragmentFactory mFragmentFactory;
    public final FragmentStore mFragmentStore;
    public final FragmentTransition.Callback mFragmentTransitionCallback;
    public boolean mHavePendingDeferredStart;
    public FragmentHostCallback<?> mHost;
    public FragmentFactory mHostFragmentFactory;
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    public final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final OnBackPressedCallback mOnBackPressedCallback;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public Fragment mParent;
    public final ArrayList<OpGenerator> mPendingActions;
    public ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    @Nullable
    public Fragment mPrimaryNav;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList<Fragment> mTmpAddedFragments;
    public ArrayList<Boolean> mTmpIsPop;
    public ArrayList<BackStackRecord> mTmpRecords;

    /* loaded from: classes.dex */
    public interface BackStackEntry {
        @Nullable
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Nullable
        @Deprecated
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    /* loaded from: classes.dex */
    public static abstract class FragmentLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FragmentLifecycleCallbacks() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, fragmentManager, fragment, bundle) == null) {
            }
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager, fragment, context) == null) {
            }
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fragmentManager, fragment, bundle) == null) {
            }
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, fragmentManager, fragment, context) == null) {
            }
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, fragmentManager, fragment, bundle) == null) {
            }
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048585, this, fragmentManager, fragment, bundle) == null) {
            }
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, fragmentManager, fragment) == null) {
            }
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view2, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048588, this, fragmentManager, fragment, view2, bundle) == null) {
            }
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, fragmentManager, fragment) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class PopBackStackState implements OpGenerator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFlags;
        public final int mId;
        public final String mName;
        public final /* synthetic */ FragmentManager this$0;

        public PopBackStackState(@Nullable FragmentManager fragmentManager, String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fragmentManager;
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, arrayList, arrayList2)) == null) {
                Fragment fragment = this.this$0.mPrimaryNav;
                if (fragment == null || this.mId >= 0 || this.mName != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                    return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mIsBack;
        public int mNumPostponed;
        public final BackStackRecord mRecord;

        public StartEnterTransitionListener(@NonNull BackStackRecord backStackRecord, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backStackRecord, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void cancelTransaction() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BackStackRecord backStackRecord = this.mRecord;
                backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, false, false);
            }
        }

        public void completeTransaction() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = this.mNumPostponed > 0;
                for (Fragment fragment : this.mRecord.mManager.getFragments()) {
                    fragment.setOnStartEnterTransitionListener(null);
                    if (z && fragment.isPostponed()) {
                        fragment.startPostponedEnterTransition();
                    }
                }
                BackStackRecord backStackRecord = this.mRecord;
                backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, !z, true);
            }
        }

        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNumPostponed == 0 : invokeV.booleanValue;
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = this.mNumPostponed - 1;
                this.mNumPostponed = i;
                if (i != 0) {
                    return;
                }
                this.mRecord.mManager.scheduleCommit();
            }
        }

        @Override // androidx.fragment.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mNumPostponed++;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2012222705, "Landroidx/fragment/app/FragmentManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2012222705, "Landroidx/fragment/app/FragmentManager;");
        }
    }

    public FragmentManager() {
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
        this.mPendingActions = new ArrayList<>();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        this.mOnBackPressedCallback = new OnBackPressedCallback(this, false) { // from class: androidx.fragment.app.FragmentManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Boolean) newInitContext2.callArgs[0]).booleanValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.handleOnBackPressed();
                }
            }
        };
        this.mBackStackIndex = new AtomicInteger();
        this.mExitAnimationCancellationSignals = new ConcurrentHashMap<>();
        this.mFragmentTransitionCallback = new FragmentTransition.Callback(this) { // from class: androidx.fragment.app.FragmentManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentManager this$0;

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

            @Override // androidx.fragment.app.FragmentTransition.Callback
            public void onComplete(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, fragment, cancellationSignal) == null) || cancellationSignal.isCanceled()) {
                    return;
                }
                this.this$0.removeCancellationSignal(fragment, cancellationSignal);
            }

            @Override // androidx.fragment.app.FragmentTransition.Callback
            public void onStart(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment, cancellationSignal) == null) {
                    this.this$0.addCancellationSignal(fragment, cancellationSignal);
                }
            }
        };
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new FragmentFactory(this) { // from class: androidx.fragment.app.FragmentManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentManager this$0;

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

            @Override // androidx.fragment.app.FragmentFactory
            @NonNull
            public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, classLoader, str)) == null) {
                    FragmentHostCallback<?> fragmentHostCallback = this.this$0.mHost;
                    return fragmentHostCallback.instantiate(fragmentHostCallback.getContext(), str, null);
                }
                return (Fragment) invokeLL.objValue;
            }
        };
        this.mExecCommit = new Runnable(this) { // from class: androidx.fragment.app.FragmentManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentManager this$0;

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
                    this.this$0.execPendingActions(true);
                }
            }
        };
    }

    private void addAddedFragments(@NonNull ArraySet<Fragment> arraySet) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, arraySet) == null) || (i = this.mCurState) < 1) {
            return;
        }
        int min = Math.min(i, 3);
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment.mState < min) {
                moveToState(fragment, min);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    private void cancelExitAnimation(@NonNull Fragment fragment) {
        HashSet<CancellationSignal> hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, fragment) == null) || (hashSet = this.mExitAnimationCancellationSignals.get(fragment)) == null) {
            return;
        }
        Iterator<CancellationSignal> it = hashSet.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        hashSet.clear();
        destroyFragmentView(fragment);
        this.mExitAnimationCancellationSignals.remove(fragment);
    }

    private void checkStateLoss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mExecutingActions = false;
            this.mTmpIsPop.clear();
            this.mTmpRecords.clear();
        }
    }

    private void completeShowHideFragment(@NonNull Fragment fragment) {
        Animator animator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fragment) == null) {
            if (fragment.mView != null) {
                FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, fragment, !fragment.mHidden);
                if (loadAnimation != null && (animator = loadAnimation.animator) != null) {
                    animator.setTarget(fragment.mView);
                    if (fragment.mHidden) {
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        } else {
                            ViewGroup viewGroup = fragment.mContainer;
                            View view2 = fragment.mView;
                            viewGroup.startViewTransition(view2);
                            loadAnimation.animator.addListener(new AnimatorListenerAdapter(this, viewGroup, view2, fragment) { // from class: androidx.fragment.app.FragmentManager.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ FragmentManager this$0;
                                public final /* synthetic */ View val$animatingView;
                                public final /* synthetic */ ViewGroup val$container;
                                public final /* synthetic */ Fragment val$fragment;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, viewGroup, view2, fragment};
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
                                    this.val$container = viewGroup;
                                    this.val$animatingView = view2;
                                    this.val$fragment = fragment;
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                                        this.val$container.endViewTransition(this.val$animatingView);
                                        animator2.removeListener(this);
                                        Fragment fragment2 = this.val$fragment;
                                        View view3 = fragment2.mView;
                                        if (view3 == null || !fragment2.mHidden) {
                                            return;
                                        }
                                        view3.setVisibility(8);
                                    }
                                }
                            });
                        }
                    } else {
                        fragment.mView.setVisibility(0);
                    }
                    loadAnimation.animator.start();
                } else {
                    if (loadAnimation != null) {
                        fragment.mView.startAnimation(loadAnimation.animation);
                        loadAnimation.animation.start();
                    }
                    fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    }
                }
            }
            if (fragment.mAdded && isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mHiddenChanged = false;
            fragment.onHiddenChanged(fragment.mHidden);
        }
    }

    private void destroyFragmentView(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, fragment) == null) {
            fragment.performDestroyView();
            this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
            fragment.mContainer = null;
            fragment.mView = null;
            fragment.mViewLifecycleOwner = null;
            fragment.mViewLifecycleOwnerLiveData.setValue(null);
            fragment.mInLayout = false;
        }
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment fragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, fragment) == null) && fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private void dispatchStateChange(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            try {
                this.mExecutingActions = true;
                this.mFragmentStore.dispatchStateChange(i);
                moveToState(i, false);
                this.mExecutingActions = false;
                execPendingActions(true);
            } catch (Throwable th) {
                this.mExecutingActions = false;
                throw th;
            }
        }
    }

    private void doPendingDeferredStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            DEBUG = z;
        }
    }

    private void endAnimatingAwayFragments() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.mExitAnimationCancellationSignals.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.mExitAnimationCancellationSignals.keySet()) {
            cancelExitAnimation(fragment);
            moveToState(fragment, fragment.getStateAfterAnimating());
        }
    }

    private void ensureExecReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            if (!this.mExecutingActions) {
                if (this.mHost == null) {
                    if (this.mDestroyed) {
                        throw new IllegalStateException("FragmentManager has been destroyed");
                    }
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                } else if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
                    if (!z) {
                        checkStateLoss();
                    }
                    if (this.mTmpRecords == null) {
                        this.mTmpRecords = new ArrayList<>();
                        this.mTmpIsPop = new ArrayList<>();
                    }
                    this.mExecutingActions = true;
                    try {
                        executePostponedTransaction(null, null);
                        return;
                    } finally {
                        this.mExecutingActions = false;
                    }
                } else {
                    throw new IllegalStateException("Must be called from main thread of fragment host");
                }
            }
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
    }

    public static void executeOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65550, null, arrayList, arrayList2, i, i2) == null) {
            while (i < i2) {
                BackStackRecord backStackRecord = arrayList.get(i);
                if (arrayList2.get(i).booleanValue()) {
                    backStackRecord.bumpBackStackNesting(-1);
                    backStackRecord.executePopOps(i == i2 + (-1));
                } else {
                    backStackRecord.bumpBackStackNesting(1);
                    backStackRecord.executeOps();
                }
                i++;
            }
        }
    }

    private void executeOpsTogether(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65551, this, arrayList, arrayList2, i, i2) == null) {
            int i4 = i;
            boolean z = arrayList.get(i4).mReorderingAllowed;
            ArrayList<Fragment> arrayList3 = this.mTmpAddedFragments;
            if (arrayList3 == null) {
                this.mTmpAddedFragments = new ArrayList<>();
            } else {
                arrayList3.clear();
            }
            this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
            Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
            boolean z2 = false;
            for (int i5 = i4; i5 < i2; i5++) {
                BackStackRecord backStackRecord = arrayList.get(i5);
                if (!arrayList2.get(i5).booleanValue()) {
                    primaryNavigationFragment = backStackRecord.expandOps(this.mTmpAddedFragments, primaryNavigationFragment);
                } else {
                    primaryNavigationFragment = backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, primaryNavigationFragment);
                }
                z2 = z2 || backStackRecord.mAddToBackStack;
            }
            this.mTmpAddedFragments.clear();
            if (!z) {
                FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i2, false, this.mFragmentTransitionCallback);
            }
            executeOps(arrayList, arrayList2, i, i2);
            if (z) {
                ArraySet<Fragment> arraySet = new ArraySet<>();
                addAddedFragments(arraySet);
                int postponePostponableTransactions = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
                makeRemovedFragmentsInvisible(arraySet);
                i3 = postponePostponableTransactions;
            } else {
                i3 = i2;
            }
            if (i3 != i4 && z) {
                FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i3, true, this.mFragmentTransitionCallback);
                moveToState(this.mCurState, true);
            }
            while (i4 < i2) {
                BackStackRecord backStackRecord2 = arrayList.get(i4);
                if (arrayList2.get(i4).booleanValue() && backStackRecord2.mIndex >= 0) {
                    backStackRecord2.mIndex = -1;
                }
                backStackRecord2.runOnCommitRunnables();
                i4++;
            }
            if (z2) {
                reportBackStackChanged();
            }
        }
    }

    private void executePostponedTransaction(@Nullable ArrayList<BackStackRecord> arrayList, @Nullable ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, arrayList, arrayList2) == null) {
            ArrayList<StartEnterTransitionListener> arrayList3 = this.mPostponedTransactions;
            int size = arrayList3 == null ? 0 : arrayList3.size();
            int i = 0;
            while (i < size) {
                StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
                if (arrayList != null && !startEnterTransitionListener.mIsBack && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                    this.mPostponedTransactions.remove(i);
                    i--;
                    size--;
                    startEnterTransitionListener.cancelTransaction();
                } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                    this.mPostponedTransactions.remove(i);
                    i--;
                    size--;
                    if (arrayList != null && !startEnterTransitionListener.mIsBack && (indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                        startEnterTransitionListener.cancelTransaction();
                    } else {
                        startEnterTransitionListener.completeTransaction();
                    }
                }
                i++;
            }
        }
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, view2)) == null) {
            F f = (F) findViewFragment(view2);
            if (f != null) {
                return f;
            }
            throw new IllegalStateException("View " + view2 + " does not have a Fragment set");
        }
        return (F) invokeL.objValue;
    }

    @NonNull
    public static FragmentManager findFragmentManager(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, view2)) == null) {
            Fragment findViewFragment = findViewFragment(view2);
            if (findViewFragment != null) {
                return findViewFragment.getChildFragmentManager();
            }
            Context context = view2.getContext();
            FragmentActivity fragmentActivity = null;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view2 + " is not within a subclass of FragmentActivity.");
        }
        return (FragmentManager) invokeL.objValue;
    }

    @Nullable
    public static Fragment findViewFragment(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, view2)) == null) {
            while (view2 != null) {
                Fragment viewFragment = getViewFragment(view2);
                if (viewFragment != null) {
                    return viewFragment;
                }
                ViewParent parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    private void forcePostponedTransactions() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || this.mPostponedTransactions == null) {
            return;
        }
        while (!this.mPostponedTransactions.isEmpty()) {
            this.mPostponedTransactions.remove(0).completeTransaction();
        }
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, arrayList, arrayList2)) == null) {
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    return false;
                }
                int size = this.mPendingActions.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
                }
                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    private FragmentManagerViewModel getChildNonConfig(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, this, fragment)) == null) ? this.mNonConfig.getChildNonConfig(fragment) : (FragmentManagerViewModel) invokeL.objValue;
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, fragment)) == null) {
            if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
                View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
                if (onFindViewById instanceof ViewGroup) {
                    return (ViewGroup) onFindViewById;
                }
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Nullable
    public static Fragment getViewFragment(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, view2)) == null) {
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f090acd);
            if (tag instanceof Fragment) {
                return (Fragment) tag;
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public static boolean isLoggingEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i)) == null) ? DEBUG || Log.isLoggable("FragmentManager", i) : invokeI.booleanValue;
    }

    private boolean isMenuAvailable(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, this, fragment)) == null) ? (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.checkForMenus() : invokeL.booleanValue;
    }

    private void makeInactive(@NonNull FragmentStateManager fragmentStateManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, fragmentStateManager) == null) {
            Fragment fragment = fragmentStateManager.getFragment();
            if (this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Removed fragment from active set " + fragment);
                }
                this.mFragmentStore.makeInactive(fragmentStateManager);
                removeRetainedFragment(fragment);
            }
        }
    }

    private void makeRemovedFragmentsInvisible(@NonNull ArraySet<Fragment> arraySet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, arraySet) == null) {
            int size = arraySet.size();
            for (int i = 0; i < size; i++) {
                Fragment valueAt = arraySet.valueAt(i);
                if (!valueAt.mAdded) {
                    View requireView = valueAt.requireView();
                    valueAt.mPostponedAlpha = requireView.getAlpha();
                    requireView.setAlpha(0.0f);
                }
            }
        }
    }

    private int postponePostponableTransactions(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i, int i2, @NonNull ArraySet<Fragment> arraySet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{arrayList, arrayList2, Integer.valueOf(i), Integer.valueOf(i2), arraySet})) == null) {
            int i3 = i2;
            for (int i4 = i2 - 1; i4 >= i; i4--) {
                BackStackRecord backStackRecord = arrayList.get(i4);
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2)) {
                    if (this.mPostponedTransactions == null) {
                        this.mPostponedTransactions = new ArrayList<>();
                    }
                    StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                    this.mPostponedTransactions.add(startEnterTransitionListener);
                    backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                    if (booleanValue) {
                        backStackRecord.executeOps();
                    } else {
                        backStackRecord.executePopOps(false);
                    }
                    i3--;
                    if (i4 != i3) {
                        arrayList.remove(i4);
                        arrayList.add(i3, backStackRecord);
                    }
                    addAddedFragments(arraySet);
                }
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65567, this, arrayList, arrayList2) == null) || arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            executePostponedTransaction(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).mReorderingAllowed) {
                    if (i2 != i) {
                        executeOpsTogether(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).mReorderingAllowed) {
                            i2++;
                        }
                    }
                    executeOpsTogether(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                executeOpsTogether(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    private void reportBackStackChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || this.mBackStackChangeListeners == null) {
            return;
        }
        for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
            this.mBackStackChangeListeners.get(i).onBackStackChanged();
        }
    }

    public static int reverseTransit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65569, null, i)) == null) {
            if (i != 4097) {
                if (i != 4099) {
                    return i != 8194 ? 0 : 4097;
                }
                return 4099;
            }
            return 8194;
        }
        return invokeI.intValue;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment fragment) {
        ViewGroup fragmentContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, this, fragment) == null) || (fragmentContainer = getFragmentContainer(fragment)) == null) {
            return;
        }
        if (fragmentContainer.getTag(R.id.obfuscated_res_0x7f09260c) == null) {
            fragmentContainer.setTag(R.id.obfuscated_res_0x7f09260c, fragment);
        }
        ((Fragment) fragmentContainer.getTag(R.id.obfuscated_res_0x7f09260c)).setNextAnim(fragment.getNextAnim());
    }

    private void startPendingDeferredFragments() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
                if (fragment != null) {
                    performPendingDeferredStart(fragment);
                }
            }
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, runtimeException) == null) {
            Log.e("FragmentManager", runtimeException.getMessage());
            Log.e("FragmentManager", "Activity state:");
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                try {
                    fragmentHostCallback.onDump(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                } catch (Exception e) {
                    Log.e("FragmentManager", "Failed dumping state", e);
                }
            } else {
                try {
                    dump(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
                } catch (Exception e2) {
                    Log.e("FragmentManager", "Failed dumping state", e2);
                }
            }
            throw runtimeException;
        }
    }

    private void updateOnBackPressedCallbackEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            synchronized (this.mPendingActions) {
                boolean z = true;
                if (!this.mPendingActions.isEmpty()) {
                    this.mOnBackPressedCallback.setEnabled(true);
                } else {
                    this.mOnBackPressedCallback.setEnabled((getBackStackEntryCount() <= 0 || !isPrimaryNavigation(this.mParent)) ? false : false);
                }
            }
        }
    }

    public void addBackStackState(BackStackRecord backStackRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, backStackRecord) == null) {
            if (this.mBackStack == null) {
                this.mBackStack = new ArrayList<>();
            }
            this.mBackStack.add(backStackRecord);
        }
    }

    public void addCancellationSignal(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment, cancellationSignal) == null) {
            if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
                this.mExitAnimationCancellationSignals.put(fragment, new HashSet<>());
            }
            this.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
        }
    }

    public void addFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "add: " + fragment);
            }
            makeActive(fragment);
            if (fragment.mDetached) {
                return;
            }
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onBackStackChangedListener) == null) {
            if (this.mBackStackChangeListeners == null) {
                this.mBackStackChangeListeners = new ArrayList<>();
            }
            this.mBackStackChangeListeners.add(onBackStackChangedListener);
        }
    }

    public void addRetainedFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fragment) == null) {
            if (isStateSaved()) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                }
            } else if (this.mNonConfig.addRetainedFragment(fragment) && isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public int allocBackStackIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBackStackIndex.getAndIncrement() : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v6, resolved type: androidx.activity.OnBackPressedDispatcherOwner */
    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentContainer fragmentContainer, @Nullable Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, fragmentHostCallback, fragmentContainer, fragment) == null) {
            if (this.mHost == null) {
                this.mHost = fragmentHostCallback;
                this.mContainer = fragmentContainer;
                this.mParent = fragment;
                if (fragment != null) {
                    updateOnBackPressedCallbackEnabled();
                }
                if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                    OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                    this.mOnBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                    Fragment fragment2 = onBackPressedDispatcherOwner;
                    if (fragment != null) {
                        fragment2 = fragment;
                    }
                    this.mOnBackPressedDispatcher.addCallback(fragment2, this.mOnBackPressedCallback);
                }
                if (fragment != null) {
                    this.mNonConfig = fragment.mFragmentManager.getChildNonConfig(fragment);
                    return;
                } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                    this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore());
                    return;
                } else {
                    this.mNonConfig = new FragmentManagerViewModel(false);
                    return;
                }
            }
            throw new IllegalStateException("Already attached");
        }
    }

    public void attachFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "attach: " + fragment);
            }
            if (fragment.mDetached) {
                fragment.mDetached = false;
                if (fragment.mAdded) {
                    return;
                }
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new BackStackRecord(this) : (FragmentTransaction) invokeV.objValue;
    }

    public boolean checkForMenus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean z = false;
            for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
                if (fragment != null) {
                    z = isMenuAvailable(fragment);
                    continue;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void completeExecute(@NonNull BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{backStackRecord, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                backStackRecord.executePopOps(z3);
            } else {
                backStackRecord.executeOps();
            }
            ArrayList arrayList = new ArrayList(1);
            ArrayList arrayList2 = new ArrayList(1);
            arrayList.add(backStackRecord);
            arrayList2.add(Boolean.valueOf(z));
            if (z2) {
                FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true, this.mFragmentTransitionCallback);
            }
            if (z3) {
                moveToState(this.mCurState, true);
            }
            for (Fragment fragment : this.mFragmentStore.getActiveFragments()) {
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    public void detachFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "detach: " + fragment);
            }
            if (fragment.mDetached) {
                return;
            }
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.mFragmentStore.removeFragment(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    public void dispatchActivityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mStateSaved = false;
            this.mStopped = false;
            dispatchStateChange(2);
        }
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, configuration) == null) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, menuItem)) == null) {
            if (this.mCurState < 1) {
                return false;
            }
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void dispatchCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mStateSaved = false;
            this.mStopped = false;
            dispatchStateChange(1);
        }
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, menu, menuInflater)) == null) {
            if (this.mCurState < 1) {
                return false;
            }
            ArrayList<Fragment> arrayList = null;
            boolean z = false;
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null && isParentMenuVisible(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    z = true;
                }
            }
            if (this.mCreatedMenus != null) {
                for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                    Fragment fragment2 = this.mCreatedMenus.get(i);
                    if (arrayList == null || !arrayList.contains(fragment2)) {
                        fragment2.onDestroyOptionsMenu();
                    }
                }
            }
            this.mCreatedMenus = arrayList;
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void dispatchDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mDestroyed = true;
            execPendingActions(true);
            endAnimatingAwayFragments();
            dispatchStateChange(-1);
            this.mHost = null;
            this.mContainer = null;
            this.mParent = null;
            if (this.mOnBackPressedDispatcher != null) {
                this.mOnBackPressedCallback.remove();
                this.mOnBackPressedDispatcher = null;
            }
        }
    }

    public void dispatchDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            dispatchStateChange(1);
        }
    }

    public void dispatchLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, menuItem)) == null) {
            if (this.mCurState < 1) {
                return false;
            }
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, menu) == null) || this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            dispatchStateChange(3);
        }
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, menu)) == null) {
            boolean z = false;
            if (this.mCurState < 1) {
                return false;
            }
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            updateOnBackPressedCallbackEnabled();
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        }
    }

    public void dispatchResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mStateSaved = false;
            this.mStopped = false;
            dispatchStateChange(4);
        }
    }

    public void dispatchStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mStateSaved = false;
            this.mStopped = false;
            dispatchStateChange(3);
        }
    }

    public void dispatchStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mStopped = true;
            dispatchStateChange(2);
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048606, this, str, fileDescriptor, printWriter, strArr) == null) {
            String str2 = str + "    ";
            this.mFragmentStore.dump(str, fileDescriptor, printWriter, strArr);
            ArrayList<Fragment> arrayList = this.mCreatedMenus;
            if (arrayList != null && (size2 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i = 0; i < size2; i++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(this.mCreatedMenus.get(i).toString());
                }
            }
            ArrayList<BackStackRecord> arrayList2 = this.mBackStack;
            if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i2 = 0; i2 < size; i2++) {
                    BackStackRecord backStackRecord = this.mBackStack.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(str2, printWriter);
                }
            }
            printWriter.print(str);
            printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
            synchronized (this.mPendingActions) {
                int size3 = this.mPendingActions.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i3 = 0; i3 < size3; i3++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i3);
                        printWriter.print(": ");
                        printWriter.println(this.mPendingActions.get(i3));
                    }
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.mHost);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.mContainer);
            if (this.mParent != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.mParent);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.mCurState);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.mStateSaved);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            if (this.mNeedMenuInvalidate) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.mNeedMenuInvalidate);
            }
        }
    }

    public void enqueueAction(@NonNull OpGenerator opGenerator, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, opGenerator, z) == null) {
            if (!z) {
                if (this.mHost == null) {
                    if (this.mDestroyed) {
                        throw new IllegalStateException("FragmentManager has been destroyed");
                    }
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                checkStateLoss();
            }
            synchronized (this.mPendingActions) {
                if (this.mHost == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                    return;
                }
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
            }
        }
    }

    public boolean execPendingActions(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            ensureExecReady(z);
            boolean z2 = false;
            while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                    cleanupExec();
                    z2 = true;
                } catch (Throwable th) {
                    cleanupExec();
                    throw th;
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.burpActive();
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public void execSingleAction(@NonNull OpGenerator opGenerator, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048609, this, opGenerator, z) == null) {
            if (z && (this.mHost == null || this.mDestroyed)) {
                return;
            }
            ensureExecReady(z);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.burpActive();
        }
    }

    public boolean executePendingTransactions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            boolean execPendingActions = execPendingActions(true);
            forcePostponedTransactions();
            return execPendingActions;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public Fragment findActiveFragment(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? this.mFragmentStore.findActiveFragment(str) : (Fragment) invokeL.objValue;
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) ? this.mFragmentStore.findFragmentById(i) : (Fragment) invokeI.objValue;
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? this.mFragmentStore.findFragmentByTag(str) : (Fragment) invokeL.objValue;
    }

    public Fragment findFragmentByWho(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) ? this.mFragmentStore.findFragmentByWho(str) : (Fragment) invokeL.objValue;
    }

    public int getActiveFragmentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mFragmentStore.getActiveFragmentCount() : invokeV.intValue;
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mFragmentStore.getActiveFragments() : (List) invokeV.objValue;
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) ? this.mBackStack.get(i) : (BackStackEntry) invokeI.objValue;
    }

    public int getBackStackEntryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ArrayList<BackStackRecord> arrayList = this.mBackStack;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, bundle, str)) == null) {
            String string = bundle.getString(str);
            if (string == null) {
                return null;
            }
            Fragment findActiveFragment = findActiveFragment(string);
            if (findActiveFragment == null) {
                throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
            }
            return findActiveFragment;
        }
        return (Fragment) invokeLL.objValue;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            FragmentFactory fragmentFactory = this.mFragmentFactory;
            if (fragmentFactory != null) {
                return fragmentFactory;
            }
            Fragment fragment = this.mParent;
            if (fragment != null) {
                return fragment.mFragmentManager.getFragmentFactory();
            }
            return this.mHostFragmentFactory;
        }
        return (FragmentFactory) invokeV.objValue;
    }

    @NonNull
    public List<Fragment> getFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mFragmentStore.getFragments() : (List) invokeV.objValue;
    }

    @NonNull
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mLayoutInflaterFactory : (LayoutInflater.Factory2) invokeV.objValue;
    }

    @NonNull
    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mLifecycleCallbacksDispatcher : (FragmentLifecycleCallbacksDispatcher) invokeV.objValue;
    }

    @Nullable
    public Fragment getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mParent : (Fragment) invokeV.objValue;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mPrimaryNav : (Fragment) invokeV.objValue;
    }

    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, fragment)) == null) ? this.mNonConfig.getViewModelStore(fragment) : (ViewModelStore) invokeL.objValue;
    }

    public void handleOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            execPendingActions(true);
            if (this.mOnBackPressedCallback.isEnabled()) {
                popBackStackImmediate();
            } else {
                this.mOnBackPressedDispatcher.onBackPressed();
            }
        }
    }

    public void hideFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "hide: " + fragment);
            }
            if (fragment.mHidden) {
                return;
            }
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mDestroyed : invokeV.booleanValue;
    }

    public boolean isParentMenuVisible(@Nullable Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, fragment)) == null) {
            if (fragment == null) {
                return true;
            }
            return fragment.isMenuVisible();
        }
        return invokeL.booleanValue;
    }

    public boolean isPrimaryNavigation(@Nullable Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, fragment)) == null) {
            if (fragment == null) {
                return true;
            }
            FragmentManager fragmentManager = fragment.mFragmentManager;
            return fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && isPrimaryNavigation(fragmentManager.mParent);
        }
        return invokeL.booleanValue;
    }

    public boolean isStateAtLeast(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) ? this.mCurState >= i : invokeI.booleanValue;
    }

    public boolean isStateSaved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mStateSaved || this.mStopped : invokeV.booleanValue;
    }

    public void makeActive(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, fragment) == null) || this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            return;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment);
        fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                addRetainedFragment(fragment);
            } else {
                removeRetainedFragment(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        fragmentStateManager.setFragmentManagerState(this.mCurState);
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void moveFragmentToExpectedState(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, fragment) == null) {
            if (!this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
                if (isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.mCurState + "since it is not added to " + this);
                    return;
                }
                return;
            }
            moveToState(fragment);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = this.mFragmentStore.findFragmentUnder(fragment);
                if (findFragmentUnder != null) {
                    View view2 = findFragmentUnder.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view2);
                    int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, fragment, true);
                    if (loadAnimation != null) {
                        Animation animation = loadAnimation.animation;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            loadAnimation.animator.setTarget(fragment.mView);
                            loadAnimation.animator.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r2 != 3) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void moveToState(@NonNull Fragment fragment, int i) {
        Fragment findActiveFragment;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048638, this, fragment, i) == null) {
            FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
            int i2 = 1;
            if (fragmentStateManager == null) {
                fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment);
                fragmentStateManager.setFragmentManagerState(1);
            }
            int min = Math.min(i, fragmentStateManager.computeMaxState());
            int i3 = fragment.mState;
            FragmentAnim.AnimationOrAnimator animationOrAnimator = null;
            if (i3 <= min) {
                if (i3 < min && !this.mExitAnimationCancellationSignals.isEmpty()) {
                    cancelExitAnimation(fragment);
                }
                int i4 = fragment.mState;
                if (i4 != -1) {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                            }
                            if (min > 2) {
                                fragmentStateManager.start();
                            }
                            if (min > 3) {
                                fragmentStateManager.resume();
                            }
                        }
                        if (min > -1) {
                            fragmentStateManager.ensureInflatedView();
                        }
                        if (min > 1) {
                            fragmentStateManager.createView(this.mContainer);
                            fragmentStateManager.activityCreated();
                            fragmentStateManager.restoreViewState();
                        }
                        if (min > 2) {
                        }
                        if (min > 3) {
                        }
                    }
                } else if (min > -1) {
                    if (isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
                    }
                    Fragment fragment2 = fragment.mTarget;
                    if (fragment2 != null) {
                        if (fragment2.equals(findActiveFragment(fragment2.mWho))) {
                            Fragment fragment3 = fragment.mTarget;
                            if (fragment3.mState < 1) {
                                moveToState(fragment3, 1);
                            }
                            fragment.mTargetWho = fragment.mTarget.mWho;
                            fragment.mTarget = null;
                        } else {
                            throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                        }
                    }
                    String str = fragment.mTargetWho;
                    if (str != null) {
                        Fragment findActiveFragment2 = findActiveFragment(str);
                        if (findActiveFragment2 != null) {
                            if (findActiveFragment2.mState < 1) {
                                moveToState(findActiveFragment2, 1);
                            }
                        } else {
                            throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTargetWho + " that does not belong to this FragmentManager!");
                        }
                    }
                    fragmentStateManager.attach(this.mHost, this, this.mParent);
                }
                if (min > 0) {
                    fragmentStateManager.create();
                }
                if (min > -1) {
                }
                if (min > 1) {
                }
                if (min > 2) {
                }
                if (min > 3) {
                }
            } else if (i3 > min) {
                if (i3 != 0) {
                    boolean z = false;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    if (min < 4) {
                                        fragmentStateManager.pause();
                                    }
                                }
                            }
                            if (min < 3) {
                                fragmentStateManager.stop();
                            }
                        }
                        if (min < 2) {
                            if (isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && this.mHost.onShouldSaveFragmentState(fragment) && fragment.mSavedViewState == null) {
                                fragmentStateManager.saveViewState();
                            }
                            View view2 = fragment.mView;
                            if (view2 != null && (viewGroup = fragment.mContainer) != null) {
                                viewGroup.endViewTransition(view2);
                                fragment.mView.clearAnimation();
                                if (!fragment.isRemovingParent()) {
                                    if (this.mCurState > -1 && !this.mDestroyed && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                        animationOrAnimator = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, fragment, false);
                                    }
                                    fragment.mPostponedAlpha = 0.0f;
                                    ViewGroup viewGroup2 = fragment.mContainer;
                                    View view3 = fragment.mView;
                                    if (animationOrAnimator != null) {
                                        fragment.setStateAfterAnimating(min);
                                        FragmentAnim.animateRemoveFragment(fragment, animationOrAnimator, this.mFragmentTransitionCallback);
                                    }
                                    viewGroup2.removeView(view3);
                                    if (viewGroup2 != fragment.mContainer) {
                                        return;
                                    }
                                }
                            }
                            if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
                                destroyFragmentView(fragment);
                            } else {
                                fragment.setStateAfterAnimating(min);
                            }
                        }
                    }
                    if (min < 1) {
                        if (fragment.mRemoving && !fragment.isInBackStack()) {
                            z = true;
                        }
                        if (!z && !this.mNonConfig.shouldDestroy(fragment)) {
                            String str2 = fragment.mTargetWho;
                            if (str2 != null && (findActiveFragment = findActiveFragment(str2)) != null && findActiveFragment.getRetainInstance()) {
                                fragment.mTarget = findActiveFragment;
                            }
                        } else {
                            makeInactive(fragmentStateManager);
                        }
                        if (this.mExitAnimationCancellationSignals.get(fragment) != null) {
                            fragment.setStateAfterAnimating(min);
                            if (i2 < 0) {
                                fragmentStateManager.detach(this.mNonConfig);
                            }
                            min = i2;
                        } else {
                            fragmentStateManager.destroy(this.mHost, this.mNonConfig);
                        }
                    }
                }
                i2 = min;
                if (i2 < 0) {
                }
                min = i2;
            }
            if (fragment.mState != min) {
                if (isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + min + " found " + fragment.mState);
                }
                fragment.mState = min;
            }
        }
    }

    public void noteStateNotSaved() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? beginTransaction() : (FragmentTransaction) invokeV.objValue;
    }

    public void performPendingDeferredStart(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048641, this, fragment) == null) && fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            moveToState(fragment, this.mCurState);
        }
    }

    public void popBackStack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            enqueueAction(new PopBackStackState(this, null, -1, 0), false);
        }
    }

    public boolean popBackStackImmediate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? popBackStackImmediate(null, -1, 0) : invokeV.booleanValue;
    }

    public boolean popBackStackState(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{arrayList, arrayList2, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
            if (arrayList3 == null) {
                return false;
            }
            if (str == null && i < 0 && (i2 & 1) == 0) {
                int size = arrayList3.size() - 1;
                if (size < 0) {
                    return false;
                }
                arrayList.add(this.mBackStack.remove(size));
                arrayList2.add(Boolean.TRUE);
            } else {
                if (str != null || i >= 0) {
                    int size2 = this.mBackStack.size() - 1;
                    while (size2 >= 0) {
                        BackStackRecord backStackRecord = this.mBackStack.get(size2);
                        if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                    if (size2 < 0) {
                        return false;
                    }
                    if ((i2 & 1) != 0) {
                        while (true) {
                            size2--;
                            if (size2 < 0) {
                                break;
                            }
                            BackStackRecord backStackRecord2 = this.mBackStack.get(size2);
                            if (str == null || !str.equals(backStackRecord2.getName())) {
                                if (i < 0 || i != backStackRecord2.mIndex) {
                                    break;
                                }
                            }
                        }
                    }
                    i3 = size2;
                } else {
                    i3 = -1;
                }
                if (i3 == this.mBackStack.size() - 1) {
                    return false;
                }
                for (int size3 = this.mBackStack.size() - 1; size3 > i3; size3--) {
                    arrayList.add(this.mBackStack.remove(size3));
                    arrayList2.add(Boolean.TRUE);
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048649, this, bundle, str, fragment) == null) {
            if (fragment.mFragmentManager != this) {
                throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
            }
            bundle.putString(str, fragment.mWho);
        }
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048650, this, fragmentLifecycleCallbacks, z) == null) {
            this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z);
        }
    }

    public void removeCancellationSignal(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        HashSet<CancellationSignal> hashSet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048651, this, fragment, cancellationSignal) == null) && (hashSet = this.mExitAnimationCancellationSignals.get(fragment)) != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.mExitAnimationCancellationSignals.remove(fragment);
            if (fragment.mState < 3) {
                destroyFragmentView(fragment);
                moveToState(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    public void removeFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
            }
            boolean z = !fragment.isInBackStack();
            if (!fragment.mDetached || z) {
                this.mFragmentStore.removeFragment(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mRemoving = true;
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048653, this, onBackStackChangedListener) == null) || (arrayList = this.mBackStackChangeListeners) == null) {
            return;
        }
        arrayList.remove(onBackStackChangedListener);
    }

    public void removeRetainedFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, fragment) == null) {
            if (isStateSaved()) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                }
            } else if (this.mNonConfig.removeRetainedFragment(fragment) && isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        }
    }

    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048655, this, parcelable, fragmentManagerNonConfig) == null) {
            if (this.mHost instanceof ViewModelStoreOwner) {
                throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
            }
            this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
            restoreSaveState(parcelable);
        }
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, parcelable) == null) || parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        this.mFragmentStore.resetActiveFragments();
        Iterator<FragmentState> it = fragmentManagerState.mActive.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment findRetainedFragmentByWho = this.mNonConfig.findRetainedFragmentByWho(next.mWho);
                if (findRetainedFragmentByWho != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + findRetainedFragmentByWho);
                    }
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, findRetainedFragmentByWho, next);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mHost.getContext().getClassLoader(), getFragmentFactory(), next);
                }
                Fragment fragment = fragmentStateManager.getFragment();
                fragment.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment.mWho + "): " + fragment);
                }
                fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
                this.mFragmentStore.makeActive(fragmentStateManager);
                fragmentStateManager.setFragmentManagerState(this.mCurState);
            }
        }
        for (Fragment fragment2 : this.mNonConfig.getRetainedFragments()) {
            if (!this.mFragmentStore.containsActiveFragment(fragment2.mWho)) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment2 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                moveToState(fragment2, 1);
                fragment2.mRemoving = true;
                moveToState(fragment2, -1);
            }
        }
        this.mFragmentStore.restoreAddedFragments(fragmentManagerState.mAdded);
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i >= backStackStateArr.length) {
                    break;
                }
                BackStackRecord instantiate = backStackStateArr[i].instantiate(this);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + instantiate.mIndex + "): " + instantiate);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    instantiate.dump(GlideException.IndentedAppendable.INDENT, printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(instantiate);
                i++;
            }
        } else {
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        String str = fragmentManagerState.mPrimaryNavActiveWho;
        if (str != null) {
            Fragment findActiveFragment = findActiveFragment(str);
            this.mPrimaryNav = findActiveFragment;
            dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
        }
    }

    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.mHost instanceof ViewModelStoreOwner) {
                throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
            }
            return this.mNonConfig.getSnapshot();
        }
        return (FragmentManagerNonConfig) invokeV.objValue;
    }

    public Parcelable saveAllState() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            forcePostponedTransactions();
            endAnimatingAwayFragments();
            execPendingActions(true);
            this.mStateSaved = true;
            ArrayList<FragmentState> saveActiveFragments = this.mFragmentStore.saveActiveFragments();
            BackStackState[] backStackStateArr = null;
            if (saveActiveFragments.isEmpty()) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "saveAllState: no fragments!");
                }
                return null;
            }
            ArrayList<String> saveAddedFragments = this.mFragmentStore.saveAddedFragments();
            ArrayList<BackStackRecord> arrayList = this.mBackStack;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i = 0; i < size; i++) {
                    backStackStateArr[i] = new BackStackState(this.mBackStack.get(i));
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = saveActiveFragments;
            fragmentManagerState.mAdded = saveAddedFragments;
            fragmentManagerState.mBackStack = backStackStateArr;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment = this.mPrimaryNav;
            if (fragment != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
            }
            return fragmentManagerState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, fragment)) == null) {
            FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
            if (fragmentStateManager == null || !fragmentStateManager.getFragment().equals(fragment)) {
                throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
            }
            return fragmentStateManager.saveInstanceState();
        }
        return (Fragment.SavedState) invokeL.objValue;
    }

    public void scheduleCommit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            synchronized (this.mPendingActions) {
                boolean z = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? false : true;
                boolean z2 = this.mPendingActions.size() == 1;
                if (z || z2) {
                    this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                    this.mHost.getHandler().post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            }
        }
    }

    public void setExitAnimationOrder(@NonNull Fragment fragment, boolean z) {
        ViewGroup fragmentContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048661, this, fragment, z) == null) && (fragmentContainer = getFragmentContainer(fragment)) != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
        }
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, fragmentFactory) == null) {
            this.mFragmentFactory = fragmentFactory;
        }
    }

    public void setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048663, this, fragment, state) == null) {
            if (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
                fragment.mMaxState = state;
                return;
            }
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
    }

    public void setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, fragment) == null) {
            if (fragment != null && (!fragment.equals(findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
            Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        }
    }

    public void showFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, fragment) == null) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "show: " + fragment);
            }
            if (fragment.mHidden) {
                fragment.mHidden = false;
                fragment.mHiddenChanged = !fragment.mHiddenChanged;
            }
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("FragmentManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            Fragment fragment = this.mParent;
            if (fragment != null) {
                sb.append(fragment.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
                sb.append("}");
            } else {
                FragmentHostCallback<?> fragmentHostCallback = this.mHost;
                if (fragmentHostCallback != null) {
                    sb.append(fragmentHostCallback.getClass().getSimpleName());
                    sb.append("{");
                    sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                    sb.append("}");
                } else {
                    sb.append(StringUtil.NULL_STRING);
                }
            }
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, fragmentLifecycleCallbacks) == null) {
            this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
        }
    }

    public void popBackStack(@Nullable String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048644, this, str, i) == null) {
            enqueueAction(new PopBackStackState(this, str, -1, i), false);
        }
    }

    public boolean popBackStackImmediate(@Nullable String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048647, this, str, i)) == null) ? popBackStackImmediate(str, -1, i) : invokeLI.booleanValue;
    }

    public void popBackStack(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048643, this, i, i2) == null) {
            if (i >= 0) {
                enqueueAction(new PopBackStackState(this, null, i, i2), false);
                return;
            }
            throw new IllegalArgumentException("Bad id: " + i);
        }
    }

    public boolean popBackStackImmediate(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048646, this, i, i2)) == null) {
            if (i >= 0) {
                return popBackStackImmediate(null, i, i2);
            }
            throw new IllegalArgumentException("Bad id: " + i);
        }
        return invokeII.booleanValue;
    }

    private boolean popBackStackImmediate(@Nullable String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65565, this, str, i, i2)) == null) {
            execPendingActions(false);
            ensureExecReady(true);
            Fragment fragment = this.mPrimaryNav;
            if (fragment == null || i >= 0 || str != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
                if (popBackStackState) {
                    this.mExecutingActions = true;
                    try {
                        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                    } finally {
                        cleanupExec();
                    }
                }
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                this.mFragmentStore.burpActive();
                return popBackStackState;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    public void moveToState(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, fragment) == null) {
            moveToState(fragment, this.mCurState);
        }
    }

    public void moveToState(int i, boolean z) {
        FragmentHostCallback<?> fragmentHostCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (this.mHost == null && i != -1) {
                throw new IllegalStateException("No activity");
            }
            if (z || i != this.mCurState) {
                this.mCurState = i;
                for (Fragment fragment : this.mFragmentStore.getFragments()) {
                    moveFragmentToExpectedState(fragment);
                }
                for (Fragment fragment2 : this.mFragmentStore.getActiveFragments()) {
                    if (fragment2 != null && !fragment2.mIsNewlyAdded) {
                        moveFragmentToExpectedState(fragment2);
                    }
                }
                startPendingDeferredFragments();
                if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 4) {
                    fragmentHostCallback.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }
}
