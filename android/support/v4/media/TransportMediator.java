package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
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
    final TransportPerformer jo;
    final Object jp;
    final b jq;
    final ArrayList<TransportStateListener> jr;
    final a js;
    final KeyEvent.Callback jt;
    final AudioManager mAudioManager;
    final Context mContext;
    final View mView;

    static boolean j(int i) {
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
        this.jr = new ArrayList<>();
        this.js = new a() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.a
            public void a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.jt);
            }

            @Override // android.support.v4.media.a
            public void k(int i) {
                TransportMediator.this.jo.onAudioFocusChange(i);
            }
        };
        this.jt = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.j(i)) {
                    return TransportMediator.this.jo.onMediaButtonDown(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (TransportMediator.j(i)) {
                    return TransportMediator.this.jo.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.jo = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.jp = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jq = new b(this.mContext, this.mAudioManager, this.mView, this.js);
        } else {
            this.jq = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.jq != null) {
            return this.jq.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.jt, this.jp, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.jr.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.jr.remove(transportStateListener);
    }

    private TransportStateListener[] aM() {
        if (this.jr.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.jr.size()];
        this.jr.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    private void aN() {
        TransportStateListener[] aM = aM();
        if (aM != null) {
            for (TransportStateListener transportStateListener : aM) {
                transportStateListener.onPlayingChanged(this);
            }
        }
    }

    private void aO() {
        TransportStateListener[] aM = aM();
        if (aM != null) {
            for (TransportStateListener transportStateListener : aM) {
                transportStateListener.onTransportControlsChanged(this);
            }
        }
    }

    private void aP() {
        if (this.jq != null) {
            this.jq.a(this.jo.onIsPlaying(), this.jo.onGetCurrentPosition(), this.jo.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        aP();
        aN();
        aO();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.jq != null) {
            this.jq.startPlaying();
        }
        this.jo.onStart();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.jq != null) {
            this.jq.pausePlaying();
        }
        this.jo.onPause();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.jq != null) {
            this.jq.stopPlaying();
        }
        this.jo.onStop();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.jo.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.jo.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.jo.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.jo.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.jo.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.jo.onGetTransportControlFlags();
    }

    public void destroy() {
        this.jq.destroy();
    }
}
