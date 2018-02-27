package android.support.design.widget;

import android.graphics.PorterDuff;
import android.os.Build;
import android.support.design.widget.s;
/* loaded from: classes2.dex */
class z {
    static final s.d sR = new s.d() { // from class: android.support.design.widget.z.1
        @Override // android.support.design.widget.s.d
        public s cE() {
            return new s(Build.VERSION.SDK_INT >= 12 ? new u() : new t());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s cE() {
        return sR.cE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            default:
                return mode;
        }
    }
}
