package android.support.v4.media;

import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private final int yV;
    private final int yW;
    private int yX;
    private Callback yY;
    private Object yZ;

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.yV = i;
        this.yW = i2;
        this.yX = i3;
    }

    public final int getCurrentVolume() {
        return this.yX;
    }

    public final int getVolumeControl() {
        return this.yV;
    }

    public final int getMaxVolume() {
        return this.yW;
    }

    public final void setCurrentVolume(int i) {
        this.yX = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.c(volumeProvider, i);
        }
        if (this.yY != null) {
            this.yY.onVolumeChanged(this);
        }
    }

    public void onSetVolumeTo(int i) {
    }

    public void onAdjustVolume(int i) {
    }

    public void setCallback(Callback callback) {
        this.yY = callback;
    }

    public Object getVolumeProvider() {
        if (this.yZ != null || Build.VERSION.SDK_INT < 21) {
            return this.yZ;
        }
        this.yZ = VolumeProviderCompatApi21.a(this.yV, this.yW, this.yX, new VolumeProviderCompatApi21.Delegate() { // from class: android.support.v4.media.VolumeProviderCompat.1
            @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
            public void onSetVolumeTo(int i) {
                VolumeProviderCompat.this.onSetVolumeTo(i);
            }

            @Override // android.support.v4.media.VolumeProviderCompatApi21.Delegate
            public void onAdjustVolume(int i) {
                VolumeProviderCompat.this.onAdjustVolume(i);
            }
        });
        return this.yZ;
    }
}
