package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes10.dex */
public class ReportFragment extends Fragment {
    private a ze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static void j(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReportFragment k(Activity activity) {
        return (ReportFragment) activity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.ze);
        a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        b(this.ze);
        a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.ze);
        a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.ze = null;
    }

    private void a(Lifecycle.Event event) {
        Activity activity = getActivity();
        if (activity instanceof l) {
            ((l) activity).gk().b(event);
        } else if (activity instanceof j) {
            Lifecycle lifecycle = ((j) activity).getLifecycle();
            if (lifecycle instanceof k) {
                ((k) lifecycle).b(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(a aVar) {
        this.ze = aVar;
    }
}
