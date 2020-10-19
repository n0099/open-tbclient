package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
/* loaded from: classes8.dex */
public class ab {
    @NonNull
    @MainThread
    public static z c(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity instanceof aa ? fragmentActivity.getViewModelStore() : HolderFragment.a(fragmentActivity).getViewModelStore();
    }
}
