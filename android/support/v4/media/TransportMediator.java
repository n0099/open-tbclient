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
    final TransportPerformer jn;
    final Object jo;
    final b jp;
    final ArrayList<TransportStateListener> jq;
    final a jr;
    final KeyEvent.Callback js;
    final AudioManager mAudioManager;
    final Context mContext;
    final View mView;

    static boolean j(int i) {
        switch (i) {
            case 79:
            case TbConfig.POST_IMAGE_QUALITY /* 85 */:
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
        this.jq = new ArrayList<>();
        this.jr = new a() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.a
            public void a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.js);
            }

            @Override // android.support.v4.media.a
            public void k(int i) {
                TransportMediator.this.jn.onAudioFocusChange(i);
            }
        };
        this.js = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.j(i)) {
                    return TransportMediator.this.jn.onMediaButtonDown(i, keyEvent);
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
                    return TransportMediator.this.jn.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.jn = transportPerformer;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.jo = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jp = new b(this.mContext, this.mAudioManager, this.mView, this.jr);
        } else {
            this.jp = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.jp != null) {
            return this.jp.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.js, this.jo, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.jq.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.jq.remove(transportStateListener);
    }

    private TransportStateListener[] aM() {
        if (this.jq.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.jq.size()];
        this.jq.toArray(transportStateListenerArr);
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
        if (this.jp != null) {
            this.jp.a(this.jn.onIsPlaying(), this.jn.onGetCurrentPosition(), this.jn.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        aP();
        aN();
        aO();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.jp != null) {
            this.jp.startPlaying();
        }
        this.jn.onStart();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.jp != null) {
            this.jp.pausePlaying();
        }
        this.jn.onPause();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.jp != null) {
            this.jp.stopPlaying();
        }
        this.jn.onStop();
        aP();
        aN();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.jn.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.jn.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.jn.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.jn.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.jn.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.jn.onGetTransportControlFlags();
    }

    public void destroy() {
        this.jp.destroy();
    }
}
