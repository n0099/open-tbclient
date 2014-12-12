package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TransportMediator extends TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final c aA;
    final KeyEvent.Callback aB;
    final TransportPerformer ax;
    final Object ay;
    final d az;
    final AudioManager mAudioManager;
    final Context mContext;
    final ArrayList<TransportStateListener> mListeners;
    final View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(int i) {
        switch (i) {
            case 79:
            case TbConfig.BUILD_NUMBER /* 85 */:
            case 86:
            case 87:
            case 88:
            case 89:
            case TbConfig.PHOTO_DELAY_TIME /* 90 */:
            case 91:
            case KEYCODE_MEDIA_PLAY /* 126 */:
            case KEYCODE_MEDIA_PAUSE /* 127 */:
            case KEYCODE_MEDIA_RECORD /* 130 */:
                return true;
            default:
                return false;
        }
    }

    public TransportMediator(Activity activity, TransportPerformer transportPerformer) {
        this(activity, null, transportPerformer);
    }

    public TransportMediator(View view, TransportPerformer transportPerformer) {
        this(null, view, transportPerformer);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer transportPerformer) {
        this.mListeners = new ArrayList<>();
        this.aA = new a(this);
        this.aB = new b(this);
        this.mContext = activity != null ? activity : view.getContext();
        this.ax = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.ay = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.az = new d(this.mContext, this.mAudioManager, this.mView, this.aA);
        } else {
            this.az = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.az != null) {
            return this.az.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.aB, this.ay, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.mListeners.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.mListeners.remove(transportStateListener);
    }

    private TransportStateListener[] M() {
        if (this.mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.mListeners.size()];
        this.mListeners.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    private void N() {
        TransportStateListener[] M = M();
        if (M != null) {
            for (TransportStateListener transportStateListener : M) {
                transportStateListener.onPlayingChanged(this);
            }
        }
    }

    private void O() {
        TransportStateListener[] M = M();
        if (M != null) {
            for (TransportStateListener transportStateListener : M) {
                transportStateListener.onTransportControlsChanged(this);
            }
        }
    }

    private void P() {
        if (this.az != null) {
            this.az.a(this.ax.onIsPlaying(), this.ax.onGetCurrentPosition(), this.ax.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        P();
        N();
        O();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.az != null) {
            this.az.startPlaying();
        }
        this.ax.onStart();
        P();
        N();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.az != null) {
            this.az.pausePlaying();
        }
        this.ax.onPause();
        P();
        N();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.az != null) {
            this.az.stopPlaying();
        }
        this.ax.onStop();
        P();
        N();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.ax.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.ax.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.ax.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.ax.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.ax.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.ax.onGetTransportControlFlags();
    }

    public void destroy() {
        this.az.destroy();
    }
}
