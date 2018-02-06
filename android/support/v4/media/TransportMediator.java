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
    final TransportPerformer yA;
    final Object yB;
    final h yC;
    final g yD;
    final KeyEvent.Callback yE;

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
        this.sB = new ArrayList<>();
        this.yD = new g() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.g
            public void a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.yE);
            }

            @Override // android.support.v4.media.g
            public void ak(int i) {
                TransportMediator.this.yA.onAudioFocusChange(i);
            }

            @Override // android.support.v4.media.g
            public long du() {
                return TransportMediator.this.yA.onGetCurrentPosition();
            }

            @Override // android.support.v4.media.g
            public void l(long j) {
                TransportMediator.this.yA.onSeekTo(j);
            }
        };
        this.yE = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.aj(i)) {
                    return TransportMediator.this.yA.onMediaButtonDown(i, keyEvent);
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
                    return TransportMediator.this.yA.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.yA = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.yB = this.mView.getKeyDispatcherState();
        if (Build.VERSION.SDK_INT >= 18) {
            this.yC = new h(this.mContext, this.mAudioManager, this.mView, this.yD);
        } else {
            this.yC = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.yC != null) {
            return this.yC.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this.yE, (KeyEvent.DispatcherState) this.yB, this);
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
        if (this.yC != null) {
            this.yC.a(this.yA.onIsPlaying(), this.yA.onGetCurrentPosition(), this.yA.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        dt();
        dr();
        ds();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.yC != null) {
            this.yC.startPlaying();
        }
        this.yA.onStart();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.yC != null) {
            this.yC.pausePlaying();
        }
        this.yA.onPause();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.yC != null) {
            this.yC.stopPlaying();
        }
        this.yA.onStop();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.yA.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.yA.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.yA.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.yA.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.yA.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.yA.onGetTransportControlFlags();
    }

    public void destroy() {
        this.yC.destroy();
    }
}
