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
    final TransportPerformer lC;
    final AudioManager lD;
    final Object lE;
    final d lF;
    final c lG;
    final KeyEvent.Callback lH;
    final Context mContext;
    final ArrayList<TransportStateListener> mListeners;
    final View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(int i) {
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
        this.mListeners = new ArrayList<>();
        this.lG = new a(this);
        this.lH = new b(this);
        this.mContext = activity != null ? activity : view.getContext();
        this.lC = transportPerformer;
        this.lD = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.lE = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.lF = new d(this.mContext, this.lD, this.mView, this.lG);
        } else {
            this.lF = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.lF != null) {
            return this.lF.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.lH, this.lE, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.mListeners.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.mListeners.remove(transportStateListener);
    }

    private TransportStateListener[] dj() {
        if (this.mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.mListeners.size()];
        this.mListeners.toArray(transportStateListenerArr);
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
        if (this.lF != null) {
            this.lF.a(this.lC.onIsPlaying(), this.lC.onGetCurrentPosition(), this.lC.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        dm();
        dk();
        dl();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.lF != null) {
            this.lF.startPlaying();
        }
        this.lC.onStart();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.lF != null) {
            this.lF.pausePlaying();
        }
        this.lC.onPause();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.lF != null) {
            this.lF.stopPlaying();
        }
        this.lC.onStop();
        dm();
        dk();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.lC.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.lC.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.lC.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.lC.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.lC.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.lC.onGetTransportControlFlags();
    }

    public void destroy() {
        this.lF.destroy();
    }
}
