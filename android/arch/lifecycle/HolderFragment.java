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
/* loaded from: classes14.dex */
public class HolderFragment extends Fragment implements aa {
    private static final a yS = new a();
    private z mViewModelStore = new z();

    public HolderFragment() {
        setRetainInstance(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        yS.a(this);
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
        return yS.a(fragmentActivity);
    }

    /* loaded from: classes14.dex */
    static class a {
        private Map<Activity, HolderFragment> yT = new HashMap();
        private Map<Fragment, HolderFragment> yU = new HashMap();
        private Application.ActivityLifecycleCallbacks yV = new d() { // from class: android.arch.lifecycle.HolderFragment.a.1
            @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (((HolderFragment) a.this.yT.remove(activity)) != null) {
                    Log.e("ViewModelStores", "Failed to save a ViewModel for " + activity);
                }
            }
        };
        private boolean yW = false;
        private FragmentManager.FragmentLifecycleCallbacks yX = new FragmentManager.FragmentLifecycleCallbacks() { // from class: android.arch.lifecycle.HolderFragment.a.2
            @Override // android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentDestroyed(fragmentManager, fragment);
                if (((HolderFragment) a.this.yU.remove(fragment)) != null) {
                    Log.e("ViewModelStores", "Failed to save a ViewModel for " + fragment);
                }
            }
        };

        a() {
        }

        void a(Fragment fragment) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                this.yU.remove(parentFragment);
                parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.yX);
                return;
            }
            this.yT.remove(fragment.getActivity());
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
                HolderFragment holderFragment = this.yT.get(fragmentActivity);
                if (holderFragment == null) {
                    if (!this.yW) {
                        this.yW = true;
                        fragmentActivity.getApplication().registerActivityLifecycleCallbacks(this.yV);
                    }
                    HolderFragment b = b(supportFragmentManager);
                    this.yT.put(fragmentActivity, b);
                    return b;
                }
                return holderFragment;
            }
            return a;
        }
    }
}
