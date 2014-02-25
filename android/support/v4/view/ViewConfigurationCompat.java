package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL;

    /* loaded from: classes.dex */
    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);
    }

    /* loaded from: classes.dex */
    class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }
    }

    /* loaded from: classes.dex */
    class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return IMPL.getScaledPagingTouchSlop(viewConfiguration);
    }
}
