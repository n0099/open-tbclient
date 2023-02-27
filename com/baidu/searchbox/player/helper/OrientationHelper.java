package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes2.dex */
public class OrientationHelper extends OrientationEventListener {
    public static final int ORIENTATION_CIRCLE_ANGLE = 360;
    public static final int ORIENTATION_DIVIDE_ANGLE = 23;
    public static final int ORIENTATION_LANDSCAPE_ANGLE_LEFT = 270;
    public static final int ORIENTATION_LANDSCAPE_ANGLE_RIGHT = 90;
    public static final int ORIENTATION_PORTRAIT_ANGLE_BOTTOM = 180;
    public static final int ORIENTATION_PORTRAIT_ANGLE_TOP = 0;
    public int mLastOrientation;
    public IOrientationChange mListener;

    /* loaded from: classes2.dex */
    public interface IOrientationChange {
        void onOrientationChanged(int i);
    }

    public OrientationHelper(Context context) {
        this(context, 3);
    }

    public static boolean isLandscape(int i) {
        if (Math.abs(i - 90) > 23 && Math.abs(i - 270) > 23) {
            return false;
        }
        return true;
    }

    public static boolean isPortrait(int i) {
        if ((i >= 0 && i <= 23) || ((337 <= i && i < 360) || Math.abs(i - 180) <= 23)) {
            return true;
        }
        return false;
    }

    public static boolean isReverseLandscape(int i) {
        if (Math.abs(i - 90) <= 23) {
            return true;
        }
        return false;
    }

    public static boolean isSystemOrientationLocked(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        IOrientationChange iOrientationChange;
        this.mLastOrientation = i;
        if (i != -1 && (iOrientationChange = this.mListener) != null) {
            iOrientationChange.onOrientationChanged(i);
        }
    }

    public void setListener(IOrientationChange iOrientationChange) {
        this.mListener = iOrientationChange;
    }

    public OrientationHelper(Context context, int i) {
        super(context, i);
    }

    public boolean enableSensor() {
        try {
            super.enable();
            return true;
        } catch (Exception e) {
            BdVideoLog.w("enableSensor()", e);
            return false;
        }
    }

    public int getLastOrientation() {
        return this.mLastOrientation;
    }
}
