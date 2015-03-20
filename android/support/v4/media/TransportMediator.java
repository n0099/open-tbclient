package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.location.a0;
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
    final TransportPerformer lB;
    final Object lC;
    final d lD;
    final ArrayList<TransportStateListener> lE;
    final c lF;
    final KeyEvent.Callback lG;
    final AudioManager mAudioManager;
    final Context mContext;
    final View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case TbConfig.PHOTO_DELAY_TIME /* 90 */:
            case a0.v /* 91 */:
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
        this.lE = new ArrayList<>();
        this.lF = new a(this);
        this.lG = new b(this);
        this.mContext = activity != null ? activity : view.getContext();
        this.lB = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.lC = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.lD = new d(this.mContext, this.mAudioManager, this.mView, this.lF);
        } else {
            this.lD = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.lD != null) {
            return this.lD.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.lG, this.lC, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.lE.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.lE.remove(transportStateListener);
    }

    private TransportStateListener[] dj() {
        if (this.lE.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.lE.size()];
        this.lE.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    private void dk() {
        TransportStateListener[] dj = dj();
        if (dj != null) {
            for (TransportStateListener transportStateListener : dj) {
                transportStateListener.onPlayingChanged(this);
            }
        }
    }

    private void dl() {
        TransportStateListener[] dj = dj();
        if (dj != null) {
            for (TransportStateListener transportStateListener : dj) {
                transportStateListener.onTransportControlsChanged(this);
            }
        }
    }

    private void dm() {
        if (this.lD != null) {
            this.lD.a(this.lB.onIsPlaying(), this.lB.onGetCurrentPosition(), this.lB.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        dm();
        dk();
        dl();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.lD != null) {
            this.lD.startPlaying();
        }
        this.lB.onStart();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.lD != null) {
            this.lD.pausePlaying();
        }
        this.lB.onPause();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.lD != null) {
            this.lD.stopPlaying();
        }
        this.lB.onStop();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.lB.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.lB.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.lB.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.lB.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.lB.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.lB.onGetTransportControlFlags();
    }

    public void destroy() {
        this.lD.destroy();
    }
}
