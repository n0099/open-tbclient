package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(r0, r1 != null ? r1.getContext().getClassLoader() : null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((FragmentFactory) objArr2[0], (ClassLoader) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
        FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    public static boolean isFragmentPostponed(FragmentTransaction.Op op) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, op)) == null) {
            Fragment fragment = op.mFragment;
            return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void bumpBackStackNesting(int i2) {
        FragmentTransaction.Op op;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            int size = this.mOps.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.mOps.get(i3).mFragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        String str2 = "Bump nesting of " + op.mFragment + " to " + op.mFragment.mBackStackNesting;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? commitInternal(false) : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? commitInternal(true) : invokeV.intValue;
    }

    public int commitInternal(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (!this.mCommitted) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    String str = "Commit: " + this;
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    dump(GlideException.IndentedAppendable.INDENT, printWriter);
                    printWriter.close();
                }
                this.mCommitted = true;
                if (this.mAddToBackStack) {
                    this.mIndex = this.mManager.allocBackStackIndex();
                } else {
                    this.mIndex = -1;
                }
                this.mManager.enqueueAction(this, z);
                return this.mIndex;
            }
            throw new IllegalStateException("commit already called");
        }
        return invokeZ.intValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            disallowAddToBackStack();
            this.mManager.execSingleAction(this, false);
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            disallowAddToBackStack();
            this.mManager.execSingleAction(this, true);
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fragment)) == null) {
            FragmentManager fragmentManager = fragment.mFragmentManager;
            if (fragmentManager != null && fragmentManager != this.mManager) {
                throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
            }
            return super.detach(fragment);
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int i2, Fragment fragment, @Nullable String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), fragment, str, Integer.valueOf(i3)}) == null) {
            super.doAddOp(i2, fragment, str, i3);
            fragment.mFragmentManager = this.mManager;
        }
    }

    public void dump(String str, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, printWriter) == null) {
            dump(str, printWriter, true);
        }
    }

    public void executeOps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int size = this.mOps.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.mOps.get(i2);
                Fragment fragment = op.mFragment;
                if (fragment != null) {
                    fragment.setNextTransition(this.mTransition);
                }
                switch (op.mCmd) {
                    case 1:
                        fragment.setNextAnim(op.mEnterAnim);
                        this.mManager.setExitAnimationOrder(fragment, false);
                        this.mManager.addFragment(fragment);
                        break;
                    case 2:
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                    case 3:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.removeFragment(fragment);
                        break;
                    case 4:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.hideFragment(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.mEnterAnim);
                        this.mManager.setExitAnimationOrder(fragment, false);
                        this.mManager.showFragment(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.mExitAnim);
                        this.mManager.detachFragment(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.mEnterAnim);
                        this.mManager.setExitAnimationOrder(fragment, false);
                        this.mManager.attachFragment(fragment);
                        break;
                    case 8:
                        this.mManager.setPrimaryNavigationFragment(fragment);
                        break;
                    case 9:
                        this.mManager.setPrimaryNavigationFragment(null);
                        break;
                    case 10:
                        this.mManager.setMaxLifecycle(fragment, op.mCurrentMaxState);
                        break;
                }
                if (!this.mReorderingAllowed && op.mCmd != 1 && fragment != null) {
                    this.mManager.moveFragmentToExpectedState(fragment);
                }
            }
            if (this.mReorderingAllowed) {
                return;
            }
            FragmentManager fragmentManager = this.mManager;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    public void executePopOps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            for (int size = this.mOps.size() - 1; size >= 0; size--) {
                FragmentTransaction.Op op = this.mOps.get(size);
                Fragment fragment = op.mFragment;
                if (fragment != null) {
                    fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                }
                switch (op.mCmd) {
                    case 1:
                        fragment.setNextAnim(op.mPopExitAnim);
                        this.mManager.setExitAnimationOrder(fragment, true);
                        this.mManager.removeFragment(fragment);
                        break;
                    case 2:
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                    case 3:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.addFragment(fragment);
                        break;
                    case 4:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.showFragment(fragment);
                        break;
                    case 5:
                        fragment.setNextAnim(op.mPopExitAnim);
                        this.mManager.setExitAnimationOrder(fragment, true);
                        this.mManager.hideFragment(fragment);
                        break;
                    case 6:
                        fragment.setNextAnim(op.mPopEnterAnim);
                        this.mManager.attachFragment(fragment);
                        break;
                    case 7:
                        fragment.setNextAnim(op.mPopExitAnim);
                        this.mManager.setExitAnimationOrder(fragment, true);
                        this.mManager.detachFragment(fragment);
                        break;
                    case 8:
                        this.mManager.setPrimaryNavigationFragment(null);
                        break;
                    case 9:
                        this.mManager.setPrimaryNavigationFragment(fragment);
                        break;
                    case 10:
                        this.mManager.setMaxLifecycle(fragment, op.mOldMaxState);
                        break;
                }
                if (!this.mReorderingAllowed && op.mCmd != 3 && fragment != null) {
                    this.mManager.moveFragmentToExpectedState(fragment);
                }
            }
            if (this.mReorderingAllowed || !z) {
                return;
            }
            FragmentManager fragmentManager = this.mManager;
            fragmentManager.moveToState(fragmentManager.mCurState, true);
        }
    }

    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, arrayList, fragment)) == null) {
            Fragment fragment2 = fragment;
            int i2 = 0;
            while (i2 < this.mOps.size()) {
                FragmentTransaction.Op op = this.mOps.get(i2);
                int i3 = op.mCmd;
                if (i3 != 1) {
                    if (i3 == 2) {
                        Fragment fragment3 = op.mFragment;
                        int i4 = fragment3.mContainerId;
                        boolean z = false;
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            Fragment fragment4 = arrayList.get(size);
                            if (fragment4.mContainerId == i4) {
                                if (fragment4 == fragment3) {
                                    z = true;
                                } else {
                                    if (fragment4 == fragment2) {
                                        this.mOps.add(i2, new FragmentTransaction.Op(9, fragment4));
                                        i2++;
                                        fragment2 = null;
                                    }
                                    FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4);
                                    op2.mEnterAnim = op.mEnterAnim;
                                    op2.mPopEnterAnim = op.mPopEnterAnim;
                                    op2.mExitAnim = op.mExitAnim;
                                    op2.mPopExitAnim = op.mPopExitAnim;
                                    this.mOps.add(i2, op2);
                                    arrayList.remove(fragment4);
                                    i2++;
                                }
                            }
                        }
                        if (z) {
                            this.mOps.remove(i2);
                            i2--;
                        } else {
                            op.mCmd = 1;
                            arrayList.add(fragment3);
                        }
                    } else if (i3 == 3 || i3 == 6) {
                        arrayList.remove(op.mFragment);
                        Fragment fragment5 = op.mFragment;
                        if (fragment5 == fragment2) {
                            this.mOps.add(i2, new FragmentTransaction.Op(9, fragment5));
                            i2++;
                            fragment2 = null;
                        }
                    } else if (i3 != 7) {
                        if (i3 == 8) {
                            this.mOps.add(i2, new FragmentTransaction.Op(9, fragment2));
                            i2++;
                            fragment2 = op.mFragment;
                        }
                    }
                    i2++;
                }
                arrayList.add(op.mFragment);
                i2++;
            }
            return fragment2;
        }
        return (Fragment) invokeLL.objValue;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, arrayList, arrayList2)) == null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                String str = "Run: " + this;
            }
            arrayList.add(this);
            arrayList2.add(Boolean.FALSE);
            if (this.mAddToBackStack) {
                this.mManager.addBackStackState(this);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.mBreadCrumbShortTitleRes != 0) {
                return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
            }
            return this.mBreadCrumbShortTitleText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mBreadCrumbShortTitleRes : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mBreadCrumbTitleRes != 0) {
                return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
            }
            return this.mBreadCrumbTitleText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mBreadCrumbTitleRes : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mIndex : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fragment)) == null) {
            FragmentManager fragmentManager = fragment.mFragmentManager;
            if (fragmentManager != null && fragmentManager != this.mManager) {
                throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
            }
            return super.hide(fragment);
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    public boolean interactsWith(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            int size = this.mOps.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.mOps.get(i3).mFragment;
                int i4 = fragment != null ? fragment.mContainerId : 0;
                if (i4 != 0 && i4 == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mOps.isEmpty() : invokeV.booleanValue;
    }

    public boolean isPostponed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            for (int i2 = 0; i2 < this.mOps.size(); i2++) {
                if (isFragmentPostponed(this.mOps.get(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, fragment)) == null) {
            FragmentManager fragmentManager = fragment.mFragmentManager;
            if (fragmentManager != null && fragmentManager != this.mManager) {
                throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
            }
            return super.remove(fragment);
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    public void runOnCommitRunnables() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.mCommitRunnables == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mCommitRunnables.size(); i2++) {
            this.mCommitRunnables.get(i2).run();
        }
        this.mCommitRunnables = null;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, fragment, state)) == null) {
            if (fragment.mFragmentManager == this.mManager) {
                if (state.isAtLeast(Lifecycle.State.CREATED)) {
                    return super.setMaxLifecycle(fragment, state);
                }
                throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
            }
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
        }
        return (FragmentTransaction) invokeLL.objValue;
    }

    public void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onStartEnterTransitionListener) == null) {
            for (int i2 = 0; i2 < this.mOps.size(); i2++) {
                FragmentTransaction.Op op = this.mOps.get(i2);
                if (isFragmentPostponed(op)) {
                    op.mFragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        InterceptResult invokeL;
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, fragment)) == null) {
            if (fragment != null && (fragmentManager = fragment.mFragmentManager) != null && fragmentManager != this.mManager) {
                throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
            }
            return super.setPrimaryNavigationFragment(fragment);
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, fragment)) == null) {
            FragmentManager fragmentManager = fragment.mFragmentManager;
            if (fragmentManager != null && fragmentManager != this.mManager) {
                throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
            }
            return super.show(fragment);
        }
        return (FragmentTransaction) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("BackStackEntry{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this.mIndex >= 0) {
                sb.append(" #");
                sb.append(this.mIndex);
            }
            if (this.mName != null) {
                sb.append(" ");
                sb.append(this.mName);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, arrayList, fragment)) == null) {
            for (int size = this.mOps.size() - 1; size >= 0; size--) {
                FragmentTransaction.Op op = this.mOps.get(size);
                int i2 = op.mCmd;
                if (i2 != 1) {
                    if (i2 != 3) {
                        switch (i2) {
                            case 8:
                                fragment = null;
                                break;
                            case 9:
                                fragment = op.mFragment;
                                break;
                            case 10:
                                op.mCurrentMaxState = op.mOldMaxState;
                                break;
                        }
                    }
                    arrayList.add(op.mFragment);
                }
                arrayList.remove(op.mFragment);
            }
            return fragment;
        }
        return (Fragment) invokeLL.objValue;
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, printWriter, z) == null) {
            if (z) {
                printWriter.print(str);
                printWriter.print("mName=");
                printWriter.print(this.mName);
                printWriter.print(" mIndex=");
                printWriter.print(this.mIndex);
                printWriter.print(" mCommitted=");
                printWriter.println(this.mCommitted);
                if (this.mTransition != 0) {
                    printWriter.print(str);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(this.mTransition));
                }
                if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.mEnterAnim));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(this.mExitAnim));
                }
                if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(this.mPopExitAnim));
                }
                if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(this.mBreadCrumbTitleText);
                }
                if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                    printWriter.print(str);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(this.mBreadCrumbShortTitleText);
                }
            }
            if (this.mOps.isEmpty()) {
                return;
            }
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.mOps.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.mOps.get(i2);
                switch (op.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.mCmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.mFragment);
                if (z) {
                    if (op.mEnterAnim != 0 || op.mExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.mExitAnim));
                    }
                    if (op.mPopEnterAnim != 0 || op.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.mPopExitAnim));
                    }
                }
            }
        }
    }

    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048598, this, arrayList, i2, i3)) == null) {
            if (i3 == i2) {
                return false;
            }
            int size = this.mOps.size();
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                Fragment fragment = this.mOps.get(i5).mFragment;
                int i6 = fragment != null ? fragment.mContainerId : 0;
                if (i6 != 0 && i6 != i4) {
                    for (int i7 = i2; i7 < i3; i7++) {
                        BackStackRecord backStackRecord = arrayList.get(i7);
                        int size2 = backStackRecord.mOps.size();
                        for (int i8 = 0; i8 < size2; i8++) {
                            Fragment fragment2 = backStackRecord.mOps.get(i8).mFragment;
                            if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                                return true;
                            }
                        }
                    }
                    i4 = i6;
                }
            }
            return false;
        }
        return invokeLII.booleanValue;
    }
}
