package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int OP_ADD = 1;
    public static final int OP_ATTACH = 7;
    public static final int OP_DETACH = 6;
    public static final int OP_HIDE = 4;
    public static final int OP_NULL = 0;
    public static final int OP_REMOVE = 3;
    public static final int OP_REPLACE = 2;
    public static final int OP_SET_MAX_LIFECYCLE = 10;
    public static final int OP_SET_PRIMARY_NAV = 8;
    public static final int OP_SHOW = 5;
    public static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAddToBackStack;
    public boolean mAllowAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    public final ClassLoader mClassLoader;
    public ArrayList<Runnable> mCommitRunnables;
    public int mEnterAnim;
    public int mExitAnim;
    public final FragmentFactory mFragmentFactory;
    @Nullable
    public String mName;
    public ArrayList<Op> mOps;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public boolean mReorderingAllowed;
    public ArrayList<String> mSharedElementSourceNames;
    public ArrayList<String> mSharedElementTargetNames;
    public int mTransition;

    /* loaded from: classes.dex */
    public static final class Op {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCmd;
        public Lifecycle.State mCurrentMaxState;
        public int mEnterAnim;
        public int mExitAnim;
        public Fragment mFragment;
        public Lifecycle.State mOldMaxState;
        public int mPopEnterAnim;
        public int mPopExitAnim;

        public Op() {
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

        public Op(int i, Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), fragment};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCmd = i;
            this.mFragment = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.mOldMaxState = state;
            this.mCurrentMaxState = state;
        }

        public Op(int i, @NonNull Fragment fragment, Lifecycle.State state) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), fragment, state};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mCmd = i;
            this.mFragment = fragment;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
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
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, bundle)) == null) {
            FragmentFactory fragmentFactory = this.mFragmentFactory;
            if (fragmentFactory != null) {
                ClassLoader classLoader = this.mClassLoader;
                if (classLoader != null) {
                    Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                    if (bundle != null) {
                        instantiate.setArguments(bundle);
                    }
                    return instantiate;
                }
                throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
            }
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        return (Fragment) invokeLL.objValue;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, cls, bundle, str)) == null) ? add(createFragment(cls, bundle), str) : (FragmentTransaction) invokeLLL.objValue;
    }

    public void addOp(Op op) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, op) == null) {
            this.mOps.add(op);
            op.mEnterAnim = this.mEnterAnim;
            op.mExitAnim = this.mExitAnim;
            op.mPopEnterAnim = this.mPopEnterAnim;
            op.mPopExitAnim = this.mPopExitAnim;
        }
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, str)) == null) {
            if (FragmentTransition.supportsTransition()) {
                String transitionName = ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    if (this.mSharedElementSourceNames == null) {
                        this.mSharedElementSourceNames = new ArrayList<>();
                        this.mSharedElementTargetNames = new ArrayList<>();
                    } else if (!this.mSharedElementTargetNames.contains(str)) {
                        if (this.mSharedElementSourceNames.contains(transitionName)) {
                            throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                        }
                    } else {
                        throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                    }
                    this.mSharedElementSourceNames.add(transitionName);
                    this.mSharedElementTargetNames.add(str);
                } else {
                    throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                }
            }
            return this;
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.mAllowAddToBackStack) {
                this.mAddToBackStack = true;
                this.mName = str;
                return this;
            }
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fragment)) == null) {
            addOp(new Op(7, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fragment)) == null) {
            addOp(new Op(6, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.mAddToBackStack) {
                this.mAllowAddToBackStack = false;
                return this;
            }
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return (FragmentTransaction) invokeV.objValue;
    }

    public void doAddOp(int i, Fragment fragment, @Nullable String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), fragment, str, Integer.valueOf(i2)}) == null) {
            Class<?> cls = fragment.getClass();
            int modifiers = cls.getModifiers();
            if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
                if (str != null) {
                    String str2 = fragment.mTag;
                    if (str2 != null && !str.equals(str2)) {
                        throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                    }
                    fragment.mTag = str;
                }
                if (i != 0) {
                    if (i != -1) {
                        int i3 = fragment.mFragmentId;
                        if (i3 != 0 && i3 != i) {
                            throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                        }
                        fragment.mFragmentId = i;
                        fragment.mContainerId = i;
                    } else {
                        throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                    }
                }
                addOp(new Op(i2, fragment));
                return;
            }
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            addOp(new Op(4, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    public boolean isAddToBackStackAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mAllowAddToBackStack : invokeV.booleanValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mOps.isEmpty() : invokeV.booleanValue;
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, fragment)) == null) {
            addOp(new Op(3, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048600, this, i, cls, bundle)) == null) ? replace(i, cls, bundle, null) : (FragmentTransaction) invokeILL.objValue;
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, runnable)) == null) {
            disallowAddToBackStack();
            if (this.mCommitRunnables == null) {
                this.mCommitRunnables = new ArrayList<>();
            }
            this.mCommitRunnables.add(runnable);
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) ? setReorderingAllowed(z) : (FragmentTransaction) invokeZ.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            this.mBreadCrumbShortTitleRes = i;
            this.mBreadCrumbShortTitleText = null;
            return this;
        }
        return (FragmentTransaction) invokeI.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            this.mBreadCrumbTitleRes = i;
            this.mBreadCrumbTitleText = null;
            return this;
        }
        return (FragmentTransaction) invokeI.objValue;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i, i2)) == null) ? setCustomAnimations(i, i2, 0, 0) : (FragmentTransaction) invokeII.objValue;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, fragment, state)) == null) {
            addOp(new Op(10, fragment, state));
            return this;
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, fragment)) == null) {
            addOp(new Op(8, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.mReorderingAllowed = z;
            return this;
        }
        return (FragmentTransaction) invokeZ.objValue;
    }

    @NonNull
    public FragmentTransaction setTransition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            this.mTransition = i;
            return this;
        }
        return (FragmentTransaction) invokeI.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) ? this : (FragmentTransaction) invokeI.objValue;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, fragment)) == null) {
            addOp(new Op(5, fragment));
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, fragment, str)) == null) {
            doAddOp(0, fragment, str, 1);
            return this;
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, fragment)) == null) ? replace(i, fragment, (String) null) : (FragmentTransaction) invokeIL.objValue;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048609, this, i, i2, i3, i4)) == null) {
            this.mEnterAnim = i;
            this.mExitAnim = i2;
            this.mPopEnterAnim = i3;
            this.mPopExitAnim = i4;
            return this;
        }
        return (FragmentTransaction) invokeIIII.objValue;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, cls, bundle)) == null) ? add(i, createFragment(cls, bundle)) : (FragmentTransaction) invokeILL.objValue;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), cls, bundle, str})) == null) ? replace(i, createFragment(cls, bundle), str) : (FragmentTransaction) invokeCommon.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, charSequence)) == null) {
            this.mBreadCrumbShortTitleRes = 0;
            this.mBreadCrumbShortTitleText = charSequence;
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, charSequence)) == null) {
            this.mBreadCrumbTitleRes = 0;
            this.mBreadCrumbTitleText = charSequence;
            return this;
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, fragment)) == null) {
            doAddOp(i, fragment, null, 1);
            return this;
        }
        return (FragmentTransaction) invokeIL.objValue;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048599, this, i, fragment, str)) == null) {
            if (i != 0) {
                doAddOp(i, fragment, str, 2);
                return this;
            }
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        return (FragmentTransaction) invokeILL.objValue;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), cls, bundle, str})) == null) ? add(i, createFragment(cls, bundle), str) : (FragmentTransaction) invokeCommon.objValue;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fragment, str)) == null) {
            doAddOp(i, fragment, str, 1);
            return this;
        }
        return (FragmentTransaction) invokeILL.objValue;
    }

    public FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentFactory, classLoader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    public FragmentTransaction add(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, viewGroup, fragment, str)) == null) {
            fragment.mContainer = viewGroup;
            return add(viewGroup.getId(), fragment, str);
        }
        return (FragmentTransaction) invokeLLL.objValue;
    }
}
