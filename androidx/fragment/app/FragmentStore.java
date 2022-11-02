package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentStore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, FragmentStateManager> mActive;
    public final ArrayList<Fragment> mAdded;

    public FragmentStore() {
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
        this.mAdded = new ArrayList<>();
        this.mActive = new HashMap<>();
    }

    public void burpActive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mActive.values().removeAll(Collections.singleton(null));
        }
    }

    public int getActiveFragmentCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mActive.size();
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<Fragment> getFragments() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mAdded.isEmpty()) {
                return Collections.emptyList();
            }
            synchronized (this.mAdded) {
                arrayList = new ArrayList(this.mAdded);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void resetActiveFragments() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mActive.clear();
        }
    }

    public void addFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            if (!this.mAdded.contains(fragment)) {
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment);
                }
                fragment.mAdded = true;
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        InterceptResult invokeL;
        Fragment findFragmentByWho;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                if (fragmentStateManager != null && (findFragmentByWho = fragmentStateManager.getFragment().findFragmentByWho(str)) != null) {
                    return findFragmentByWho;
                }
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public Fragment findFragmentUnder(@NonNull Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fragment)) == null) {
            ViewGroup viewGroup = fragment.mContainer;
            View view2 = fragment.mView;
            if (viewGroup != null && view2 != null) {
                for (int indexOf = this.mAdded.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                    Fragment fragment2 = this.mAdded.get(indexOf);
                    if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                        return fragment2;
                    }
                }
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public boolean containsActiveFragment(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.mActive.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Fragment findActiveFragment(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            FragmentStateManager fragmentStateManager = this.mActive.get(str);
            if (fragmentStateManager != null) {
                return fragmentStateManager.getFragment();
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    @Nullable
    public FragmentStateManager getFragmentStateManager(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return this.mActive.get(str);
        }
        return (FragmentStateManager) invokeL.objValue;
    }

    public void makeActive(@NonNull FragmentStateManager fragmentStateManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fragmentStateManager) == null) {
            this.mActive.put(fragmentStateManager.getFragment().mWho, fragmentStateManager);
        }
    }

    public void removeFragment(@NonNull Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fragment) == null) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            fragment.mAdded = false;
        }
    }

    public void dispatchStateChange(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Iterator<Fragment> it = this.mAdded.iterator();
            while (it.hasNext()) {
                FragmentStateManager fragmentStateManager = this.mActive.get(it.next().mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.setFragmentManagerState(i);
                }
            }
            for (FragmentStateManager fragmentStateManager2 : this.mActive.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.setFragmentManagerState(i);
                }
            }
        }
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = this.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.getFragment();
                    if (fragment2.mFragmentId == i) {
                        return fragment2;
                    }
                }
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str != null) {
                for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.mAdded.get(size);
                    if (fragment != null && str.equals(fragment.mTag)) {
                        return fragment;
                    }
                }
            }
            if (str != null) {
                for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                    if (fragmentStateManager != null) {
                        Fragment fragment2 = fragmentStateManager.getFragment();
                        if (str.equals(fragment2.mTag)) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public void makeInactive(@NonNull FragmentStateManager fragmentStateManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fragmentStateManager) == null) {
            Fragment fragment = fragmentStateManager.getFragment();
            for (FragmentStateManager fragmentStateManager2 : this.mActive.values()) {
                if (fragmentStateManager2 != null) {
                    Fragment fragment2 = fragmentStateManager2.getFragment();
                    if (fragment.mWho.equals(fragment2.mTargetWho)) {
                        fragment2.mTarget = fragment;
                        fragment2.mTargetWho = null;
                    }
                }
            }
            this.mActive.put(fragment.mWho, null);
            String str = fragment.mTargetWho;
            if (str != null) {
                fragment.mTarget = findActiveFragment(str);
            }
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, fileDescriptor, printWriter, strArr) == null) {
            String str2 = str + "    ";
            if (!this.mActive.isEmpty()) {
                printWriter.print(str);
                printWriter.print("Active Fragments:");
                for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                    printWriter.print(str);
                    if (fragmentStateManager != null) {
                        Fragment fragment = fragmentStateManager.getFragment();
                        printWriter.println(fragment);
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    } else {
                        printWriter.println(StringUtil.NULL_STRING);
                    }
                }
            }
            int size = this.mAdded.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i = 0; i < size; i++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(this.mAdded.get(i).toString());
                }
            }
        }
    }

    @NonNull
    public List<Fragment> getActiveFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                if (fragmentStateManager != null) {
                    arrayList.add(fragmentStateManager.getFragment());
                } else {
                    arrayList.add(null);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void restoreAddedFragments(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.mAdded.clear();
            if (list != null) {
                for (String str : list) {
                    Fragment findActiveFragment = findActiveFragment(str);
                    if (findActiveFragment != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + findActiveFragment);
                        }
                        addFragment(findActiveFragment);
                    } else {
                        throw new IllegalStateException("No instantiated fragment for (" + str + SmallTailInfo.EMOTION_SUFFIX);
                    }
                }
            }
        }
    }

    @NonNull
    public ArrayList<FragmentState> saveActiveFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ArrayList<FragmentState> arrayList = new ArrayList<>(this.mActive.size());
            for (FragmentStateManager fragmentStateManager : this.mActive.values()) {
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.getFragment();
                    FragmentState saveState = fragmentStateManager.saveState();
                    arrayList.add(saveState);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Saved state of " + fragment + ": " + saveState.mSavedFragmentState);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public ArrayList<String> saveAddedFragments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.mAdded) {
                if (this.mAdded.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.mAdded.size());
                Iterator<Fragment> it = this.mAdded.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    arrayList.add(next.mWho);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                    }
                }
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
