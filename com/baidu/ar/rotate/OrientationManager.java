package com.baidu.ar.rotate;

import android.content.Context;
import android.view.OrientationEventListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OrientationManager extends OrientationEventListener {
    private static Orientation a = Orientation.UNKNOWN;
    private static boolean d = false;
    private Orientation b;
    private List<OrientationListener> c;

    /* loaded from: classes3.dex */
    public interface OrientationListener {
        void onRotateOrientation(Orientation orientation);
    }

    public OrientationManager(Context context) {
        super(context);
        this.b = Orientation.PORTRAIT;
        this.c = new ArrayList();
    }

    private static Orientation a(int i) {
        if ((i < 0 || i > 10) && (i < 350 || i > 359)) {
            if (i < 80 || i > 100) {
                if (i < 170 || i > 190) {
                    if (i < 260 || i > 280) {
                        return null;
                    }
                    return Orientation.LANDSCAPE_REVERSE;
                }
                return Orientation.PORTRAIT_REVERSE;
            }
            return Orientation.LANDSCAPE;
        }
        return Orientation.PORTRAIT;
    }

    private static Orientation[] b(int i) {
        return (i <= 0 || i >= 90) ? (i <= 90 || i >= 180) ? (i <= 180 || i >= 270) ? new Orientation[]{Orientation.LANDSCAPE_REVERSE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT_REVERSE, Orientation.LANDSCAPE_REVERSE} : new Orientation[]{Orientation.LANDSCAPE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
    }

    private static Orientation c(int i) {
        return ((i < 0 || i > 45) && (i < 315 || i >= 360)) ? (i <= 45 || i >= 135) ? (i < 135 || i > 225) ? (i <= 225 || i >= 315) ? Orientation.PORTRAIT : Orientation.LANDSCAPE_REVERSE : Orientation.PORTRAIT_REVERSE : Orientation.LANDSCAPE : Orientation.PORTRAIT;
    }

    public static Orientation calcOrientation(int i, Orientation orientation) {
        if (d) {
            i = (i + 90) % 360;
        }
        Orientation a2 = a(i);
        if (a2 != null) {
            return a2;
        }
        Orientation[] b = b(i);
        return (orientation == b[0] || orientation == b[1]) ? orientation : c(i);
    }

    public static Orientation getGlobalOrientation() {
        return a;
    }

    public static void setGlobalOrientation(Orientation orientation) {
        a = orientation;
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        if (orientationListener == null || this.c.contains(orientationListener)) {
            return;
        }
        this.c.add(orientationListener);
    }

    public void destroy() {
        this.c.clear();
    }

    public void notifyOrientationChanged() {
        notifyOrientationChanged(this.b);
    }

    public void notifyOrientationChanged(Orientation orientation) {
        setGlobalOrientation(orientation);
        for (OrientationListener orientationListener : this.c) {
            orientationListener.onRotateOrientation(orientation);
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        Orientation calcOrientation;
        if (i == -1 || (calcOrientation = calcOrientation(i, this.b)) == null || this.b == calcOrientation) {
            return;
        }
        this.b = calcOrientation;
        notifyOrientationChanged(this.b);
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        if (orientationListener == null || !this.c.contains(orientationListener)) {
            return;
        }
        this.c.remove(orientationListener);
    }

    public void setScreenOrientationLandscape(boolean z) {
        d = z;
    }
}
