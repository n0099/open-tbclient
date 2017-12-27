package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;
/* loaded from: classes2.dex */
public abstract class TransportPerformer {
    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public abstract boolean onIsPlaying();

    public abstract void onPause();

    public abstract void onSeekTo(long j);

    public abstract void onStart();

    public abstract void onStop();

    public int onGetBufferPercentage() {
        return 100;
    }

    public int onGetTransportControlFlags() {
        return 60;
    }

    public boolean onMediaButtonDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 79:
            case 85:
                if (onIsPlaying()) {
                    onPause();
                    break;
                } else {
                    onStart();
                    break;
                }
            case 86:
                onStop();
                break;
            case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
                onStart();
                break;
            case 127:
                onPause();
                break;
        }
        return true;
    }

    public boolean onMediaButtonUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public void onAudioFocusChange(int i) {
        int i2 = 0;
        switch (i) {
            case -1:
                i2 = 127;
                break;
        }
        if (i2 != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            onMediaButtonDown(i2, new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0));
            onMediaButtonUp(i2, new KeyEvent(uptimeMillis, uptimeMillis, 1, i2, 0));
        }
    }
}
