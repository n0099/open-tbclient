package android.support.v13.app;

import android.app.Fragment;
import android.os.Build;
/* loaded from: classes.dex */
public class FragmentCompat {
    static final FragmentCompatImpl IMPL;

    /* loaded from: classes.dex */
    interface FragmentCompatImpl {
        void setMenuVisibility(Fragment fragment, boolean z);

        void setUserVisibleHint(Fragment fragment, boolean z);
    }

    /* loaded from: classes.dex */
    class BaseFragmentCompatImpl implements FragmentCompatImpl {
        BaseFragmentCompatImpl() {
        }

        @Override // android.support.v13.app.FragmentCompat.FragmentCompatImpl
        public void setMenuVisibility(Fragment fragment, boolean z) {
        }

        @Override // android.support.v13.app.FragmentCompat.FragmentCompatImpl
        public void setUserVisibleHint(Fragment fragment, boolean z) {
        }
    }

    /* loaded from: classes.dex */
    class ICSFragmentCompatImpl extends BaseFragmentCompatImpl {
        ICSFragmentCompatImpl() {
        }

        @Override // android.support.v13.app.FragmentCompat.BaseFragmentCompatImpl, android.support.v13.app.FragmentCompat.FragmentCompatImpl
        public void setMenuVisibility(Fragment fragment, boolean z) {
            FragmentCompatICS.setMenuVisibility(fragment, z);
        }
    }

    /* loaded from: classes.dex */
    class ICSMR1FragmentCompatImpl extends ICSFragmentCompatImpl {
        ICSMR1FragmentCompatImpl() {
        }

        @Override // android.support.v13.app.FragmentCompat.BaseFragmentCompatImpl, android.support.v13.app.FragmentCompat.FragmentCompatImpl
        public void setUserVisibleHint(Fragment fragment, boolean z) {
            FragmentCompatICSMR1.setUserVisibleHint(fragment, z);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 15) {
            IMPL = new ICSMR1FragmentCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ICSFragmentCompatImpl();
        } else {
            IMPL = new BaseFragmentCompatImpl();
        }
    }

    public static void setMenuVisibility(Fragment fragment, boolean z) {
        IMPL.setMenuVisibility(fragment, z);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        IMPL.setUserVisibleHint(fragment, z);
    }
}
