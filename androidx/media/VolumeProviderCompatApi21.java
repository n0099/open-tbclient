package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: classes.dex */
public class VolumeProviderCompatApi21 {

    /* loaded from: classes.dex */
    public interface Delegate {
        void onAdjustVolume(int i2);

        void onSetVolumeTo(int i2);
    }

    public static Object createVolumeProvider(int i2, int i3, int i4, final Delegate delegate) {
        return new VolumeProvider(i2, i3, i4) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i5) {
                delegate.onAdjustVolume(i5);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i5) {
                delegate.onSetVolumeTo(i5);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i2) {
        ((VolumeProvider) obj).setCurrentVolume(i2);
    }
}
