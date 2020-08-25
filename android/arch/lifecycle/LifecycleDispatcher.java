package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class LifecycleDispatcher {
    private static AtomicBoolean yZ = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        if (!yZ.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }

    @VisibleForTesting
    /* loaded from: classes20.dex */
    static class a extends d {
        private final b za = new b();

        a() {
        }

        @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.za, true);
            }
            ReportFragment.j(activity);
        }

        @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, Lifecycle.State.CREATED);
            }
        }

        @Override // android.arch.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if (activity instanceof FragmentActivity) {
                LifecycleDispatcher.a((FragmentActivity) activity, Lifecycle.State.CREATED);
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class DestructionReportFragment extends Fragment {
        @Override // android.support.v4.app.Fragment
        public void onPause() {
            super.onPause();
            a(Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            a(Lifecycle.Event.ON_STOP);
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            a(Lifecycle.Event.ON_DESTROY);
        }

        protected void a(Lifecycle.Event event) {
            LifecycleDispatcher.a(getParentFragment(), event);
        }
    }

    private static void a(FragmentManager fragmentManager, Lifecycle.State state) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    a(fragment, state);
                    if (fragment.isAdded()) {
                        a(fragment.getChildFragmentManager(), state);
                    }
                }
            }
        }
    }

    private static void a(Object obj, Lifecycle.State state) {
        if (obj instanceof l) {
            ((l) obj).hy().a(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(FragmentActivity fragmentActivity, Lifecycle.State state) {
        a((Object) fragmentActivity, state);
        a(fragmentActivity.getSupportFragmentManager(), state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Fragment fragment, Lifecycle.Event event) {
        if (fragment instanceof l) {
            ((l) fragment).hy().b(event);
        }
    }

    @VisibleForTesting
    /* loaded from: classes20.dex */
    static class b extends FragmentManager.FragmentLifecycleCallbacks {
        b() {
        }

        @Override // android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_CREATE);
            if ((fragment instanceof l) && fragment.getChildFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragment.getChildFragmentManager().beginTransaction().add(new DestructionReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            }
        }

        @Override // android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_START);
        }

        @Override // android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
            LifecycleDispatcher.a(fragment, Lifecycle.Event.ON_RESUME);
        }
    }
}
