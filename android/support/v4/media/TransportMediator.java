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
    final TransportPerformer bD;
    final AudioManager bE;
    final Object bF;
    final d bG;
    final ArrayList<TransportStateListener> bH;
    final c bI;
    final KeyEvent.Callback bJ;
    final Context mContext;
    final View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(int i) {
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
        this.bH = new ArrayList<>();
        this.bI = new a(this);
        this.bJ = new b(this);
        this.mContext = activity != null ? activity : view.getContext();
        this.bD = transportPerformer;
        this.bE = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.bF = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.bG = new d(this.mContext, this.bE, this.mView, this.bI);
        } else {
            this.bG = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.bG != null) {
            return this.bG.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.bJ, this.bF, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener transportStateListener) {
        this.bH.add(transportStateListener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.bH.remove(transportStateListener);
    }

    private TransportStateListener[] C() {
        if (this.bH.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.bH.size()];
        this.bH.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    private void D() {
        TransportStateListener[] C = C();
        if (C != null) {
            for (TransportStateListener transportStateListener : C) {
                transportStateListener.onPlayingChanged(this);
            }
        }
    }

    private void E() {
        TransportStateListener[] C = C();
        if (C != null) {
            for (TransportStateListener transportStateListener : C) {
                transportStateListener.onTransportControlsChanged(this);
            }
        }
    }

    private void F() {
        if (this.bG != null) {
            this.bG.a(this.bD.onIsPlaying(), this.bD.onGetCurrentPosition(), this.bD.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        F();
        D();
        E();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.bG != null) {
            this.bG.startPlaying();
        }
        this.bD.onStart();
        F();
        D();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.bG != null) {
            this.bG.pausePlaying();
        }
        this.bD.onPause();
        F();
        D();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.bG != null) {
            this.bG.stopPlaying();
        }
        this.bD.onStop();
        F();
        D();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.bD.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.bD.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long j) {
        this.bD.onSeekTo(j);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.bD.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.bD.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.bD.onGetTransportControlFlags();
    }

    public void destroy() {
        this.bG.destroy();
    }
}
