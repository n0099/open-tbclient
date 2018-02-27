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
    final ArrayList<TransportStateListener> sA;
    final TransportPerformer yv;
    final Object yw;
    final h yx;
    final g yy;
    final KeyEvent.Callback yz;

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
        this.sA = new ArrayList<>();
        this.yy = new g() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.g
            public void a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.yz);
            }

            @Override // android.support.v4.media.g
            public void ak(int i) {
                TransportMediator.this.yv.onAudioFocusChange(i);
            }

            @Override // android.support.v4.media.g
            public long du() {
                return TransportMediator.this.yv.onGetCurrentPosition();
            }

            @Override // android.support.v4.media.g
            public void l(long j) {
                TransportMediator.this.yv.onSeekTo(j);
            }
        };
        this.yz = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.aj(i)) {
                    return TransportMediator.this.yv.onMediaButtonDown(i, keyEvent);
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
                    return TransportMediator.this.yv.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.yv = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.yw = this.mView.getKeyDispatcherState();
        if (Build.VERSION.SDK_INT >= 18) {
            this.yx = new h(this.mContext, this.mAudioManager, this.mView, this.yy);
        } else {
            this.yx = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.yx != null) {
            return this.yx.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this.yz, (KeyEvent.DispatcherState) this.yw, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.sA.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.sA.remove(transportStateListener);
    }

    private TransportStateListener[] dq() {
        if (this.sA.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.sA.size()];
        this.sA.toArray(transportStateListenerArr);
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
        if (this.yx != null) {
            this.yx.a(this.yv.onIsPlaying(), this.yv.onGetCurrentPosition(), this.yv.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        dt();
        dr();
        ds();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.yx != null) {
            this.yx.startPlaying();
        }
        this.yv.onStart();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.yx != null) {
            this.yx.pausePlaying();
        }
        this.yv.onPause();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.yx != null) {
            this.yx.stopPlaying();
        }
        this.yv.onStop();
        dt();
        dr();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.yv.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.yv.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.yv.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.yv.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.yv.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.yv.onGetTransportControlFlags();
    }

    public void destroy() {
        this.yx.destroy();
    }
}
