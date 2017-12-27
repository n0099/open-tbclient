package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes2.dex */
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
    final AudioManager mAudioManager;
    final Context mContext;
    final View mView;
    final ArrayList<TransportStateListener> sB;
    final TransportPerformer yB;
    final Object yC;
    final h yD;
    final g yE;
    final KeyEvent.Callback yF;

    static boolean aj(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case KEYCODE_MEDIA_PLAY /* 126 */:
            case 127:
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
        this.sB = new ArrayList<>();
        this.yE = new g() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.g
            public void a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.yF);
            }

            @Override // android.support.v4.media.g
            public void ak(int i) {
                TransportMediator.this.yB.onAudioFocusChange(i);
            }

            @Override // android.support.v4.media.g
            public long du() {
                return TransportMediator.this.yB.onGetCurrentPosition();
            }

            @Override // android.support.v4.media.g
            public void l(long j) {
                TransportMediator.this.yB.onSeekTo(j);
            }
        };
        this.yF = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.aj(i)) {
                    return TransportMediator.this.yB.onMediaButtonDown(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (TransportMediator.aj(i)) {
                    return TransportMediator.this.yB.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.yB = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.yC = this.mView.getKeyDispatcherState();
        if (Build.VERSION.SDK_INT >= 18) {
            this.yD = new h(this.mContext, this.mAudioManager, this.mView, this.yE);
        } else {
            this.yD = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.yD != null) {
            return this.yD.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this.yF, (KeyEvent.DispatcherState) this.yC, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.sB.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.sB.remove(transportStateListener);
    }

    private TransportStateListener[] dq() {
        if (this.sB.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.sB.size()];
        this.sB.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    private void dr() {
        TransportStateListener[] dq = dq();
        if (dq != null) {
            for (TransportStateListener transportStateListener : dq) {
                transportStateListener.onPlayingChanged(this);
            }
        }
    }

    private void ds() {
        TransportStateListener[] dq = dq();
        if (dq != null) {
            for (TransportStateListener transportStateListener : dq) {
                transportStateListener.onTransportControlsChanged(this);
            }
        }
    }

    private void dt() {
        if (this.yD != null) {
            this.yD.a(this.yB.onIsPlaying(), this.yB.onGetCurrentPosition(), this.yB.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        dt();
        dr();
        ds();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.yD != null) {
            this.yD.startPlaying();
        }
        this.yB.onStart();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.yD != null) {
            this.yD.pausePlaying();
        }
        this.yB.onPause();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.yD != null) {
            this.yD.stopPlaying();
        }
        this.yB.onStop();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.yB.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.yB.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.yB.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.yB.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.yB.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.yB.onGetTransportControlFlags();
    }

    public void destroy() {
        this.yD.destroy();
    }
}
