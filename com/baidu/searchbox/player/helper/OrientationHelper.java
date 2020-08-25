package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes9.dex */
public class OrientationHelper extends OrientationEventListener {
    private static final int ORIENTATION_CIRCLE_ANGLE = 360;
    private static final int ORIENTATION_DIVIDE_ANGLE = 23;
    private static final int ORIENTATION_LANDSCAPE_ANGLE_LEFT = 270;
    private static final int ORIENTATION_LANDSCAPE_ANGLE_RIGHT = 90;
    private static final int ORIENTATION_PORTRAIT_ANGLE_BOTTOM = 180;
    private static final int ORIENTATION_PORTRAIT_ANGLE_TOP = 0;
    private int mLastOrientation;
    private IOrientationChange mListener;

    /* loaded from: classes9.dex */
    public interface IOrientationChange {
        void onOrientationChanged(int i);
    }

    public OrientationHelper(Context context) {
        this(context, 3);
    }

    public OrientationHelper(Context context, int i) {
        super(context, i);
    }

    public void setListener(IOrientationChange iOrientationChange) {
        this.mListener = iOrientationChange;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        this.mLastOrientation = i;
        if (i != -1 && this.mListener != null) {
            this.mListener.onOrientationChanged(i);
        }
    }

    public int getLastOrientation() {
        return this.mLastOrientation;
    }

    public static boolean isSystemOrientationLocked(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 0;
    }

    public static boolean isPortrait(int i) {
        return (i >= 0 && i <= 23) || (337 <= i && i < 360) || Math.abs(i + (-180)) <= 23;
    }

    public static boolean isLandscape(int i) {
        return Math.abs(i + (-90)) <= 23 || Math.abs(i + (-270)) <= 23;
    }

    public static boolean isReverseLandscape(int i) {
        return Math.abs(i + (-90)) <= 23;
    }

    public boolean enableSensor() {
        try {
            super.enable();
            return true;
        } catch (Exception e) {
            BdVideoLog.e(e.getMessage());
            return false;
        }
    }
}
