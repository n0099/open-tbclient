package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class HolderFragment extends Fragment implements aa {
    private static final a bO = new a();
    private z mViewModelStore = new z();

    public HolderFragment() {
        setRetainInstance(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bO.a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mViewModelStore.clear();
    }

    @Override // android.support.v4.app.Fragment, android.arch.lifecycle.aa
    @NonNull
    public z getViewModelStore() {
        return this.mViewModelStore;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static HolderFragment a(FragmentActivity fragmentActivity) {
        return bO.a(fragmentActivity);
    }

    /* loaded from: classes5.dex */
    static class a {
        private Map<Activity, HolderFragment> bP = new HashMap();
        private Map<Fragment, HolderFragment> bS = new HashMap();
        private Application.ActivityLifecycleCallbacks bT = new d() { // from class: android.arch.lifecycle.HolderFragment.a.1
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (((HolderFragment) a.this.bP.remove(activity)) != null) {
                    Log.e("ViewModelStores", "Failed to save a ViewModel for " + activity);
                }
            }
        };
        private boolean bV = false;
        private FragmentManager.FragmentLifecycleCallbacks bW = new FragmentManager.FragmentLifecycleCallbacks() { // from class: android.arch.lifecycle.HolderFragment.a.2
            @Override // android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentDestroyed(fragmentManager, fragment);
                if (((HolderFragment) a.this.bS.remove(fragment)) != null) {
                    Log.e("ViewModelStores", "Failed to save a ViewModel for " + fragment);
                }
            }
        };

        a() {
        }

        void a(Fragment fragment) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                this.bS.remove(parentFragment);
                parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.bW);
                return;
            }
            this.bP.remove(fragment.getActivity());
        }

        private static HolderFragment a(FragmentManager fragmentManager) {
            if (fragmentManager.isDestroyed()) {
                throw new IllegalStateException("Can't access ViewModels from onDestroy");
            }
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag("android.arch.lifecycle.state.StateProviderHolderFragment");
            if (findFragmentByTag != null && !(findFragmentByTag instanceof HolderFragment)) {
                throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
            }
            return (HolderFragment) findFragmentByTag;
        }

        private static HolderFragment b(FragmentManager fragmentManager) {
            HolderFragment holderFragment = new HolderFragment();
            fragmentManager.beginTransaction().add(holderFragment, "android.arch.lifecycle.state.StateProviderHolderFragment").commitAllowingStateLoss();
            return holderFragment;
        }

        HolderFragment a(FragmentActivity fragmentActivity) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            HolderFragment a = a(supportFragmentManager);
            if (a == null) {
                HolderFragment holderFragment = this.bP.get(fragmentActivity);
                if (holderFragment == null) {
                    if (!this.bV) {
                        this.bV = true;
                        fragmentActivity.getApplication().registerActivityLifecycleCallbacks(this.bT);
                    }
                    HolderFragment b = b(supportFragmentManager);
                    this.bP.put(fragmentActivity, b);
                    return b;
                }
                return holderFragment;
            }
            return a;
        }
    }
}
