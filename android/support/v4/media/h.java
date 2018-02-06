package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes2.dex */
class h {
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final View yG;
    final g yH;
    final String yI;
    final IntentFilter yJ;
    PendingIntent yQ;
    RemoteControlClient yR;
    boolean yS;
    boolean yU;
    final ViewTreeObserver.OnWindowAttachListener yK = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.h.1
        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            h.this.dv();
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            h.this.dA();
        }
    };
    final ViewTreeObserver.OnWindowFocusChangeListener yL = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.h.2
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (!z) {
                h.this.dz();
            } else {
                h.this.dw();
            }
        }
    };
    final BroadcastReceiver yM = new BroadcastReceiver() { // from class: android.support.v4.media.h.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                h.this.yH.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener yN = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.h.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            h.this.yH.ak(i);
        }
    };
    final RemoteControlClient.OnGetPlaybackPositionListener yO = new RemoteControlClient.OnGetPlaybackPositionListener() { // from class: android.support.v4.media.h.5
        @Override // android.media.RemoteControlClient.OnGetPlaybackPositionListener
        public long onGetPlaybackPosition() {
            return h.this.yH.du();
        }
    };
    final RemoteControlClient.OnPlaybackPositionUpdateListener yP = new RemoteControlClient.OnPlaybackPositionUpdateListener() { // from class: android.support.v4.media.h.6
        @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
        public void onPlaybackPositionUpdate(long j) {
            h.this.yH.l(j);
        }
    };
    int yT = 0;

    public h(Context context, AudioManager audioManager, View view, g gVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.yG = view;
        this.yH = gVar;
        this.yI = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.yI);
        this.mIntent.setPackage(context.getPackageName());
        this.yJ = new IntentFilter();
        this.yJ.addAction(this.yI);
        this.yG.getViewTreeObserver().addOnWindowAttachListener(this.yK);
        this.yG.getViewTreeObserver().addOnWindowFocusChangeListener(this.yL);
    }

    public Object getRemoteControlClient() {
        return this.yR;
    }

    public void destroy() {
        dA();
        this.yG.getViewTreeObserver().removeOnWindowAttachListener(this.yK);
        this.yG.getViewTreeObserver().removeOnWindowFocusChangeListener(this.yL);
    }

    void dv() {
        this.mContext.registerReceiver(this.yM, this.yJ);
        this.yQ = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        this.yR = new RemoteControlClient(this.yQ);
        this.yR.setOnGetPlaybackPositionListener(this.yO);
        this.yR.setPlaybackPositionUpdateListener(this.yP);
    }

    void dw() {
        if (!this.yS) {
            this.yS = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.yQ);
            this.mAudioManager.registerRemoteControlClient(this.yR);
            if (this.yT == 3) {
                dx();
            }
        }
    }

    void dx() {
        if (!this.yU) {
            this.yU = true;
            this.mAudioManager.requestAudioFocus(this.yN, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.yT != 3) {
            this.yT = 3;
            this.yR.setPlaybackState(3);
        }
        if (this.yS) {
            dx();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.yR != null) {
            this.yR.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.yR.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.yT == 3) {
            this.yT = 2;
            this.yR.setPlaybackState(2);
        }
        dy();
    }

    public void stopPlaying() {
        if (this.yT != 1) {
            this.yT = 1;
            this.yR.setPlaybackState(1);
        }
        dy();
    }

    void dy() {
        if (this.yU) {
            this.yU = false;
            this.mAudioManager.abandonAudioFocus(this.yN);
        }
    }

    void dz() {
        dy();
        if (this.yS) {
            this.yS = false;
            this.mAudioManager.unregisterRemoteControlClient(this.yR);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.yQ);
        }
    }

    void dA() {
        dz();
        if (this.yQ != null) {
            this.mContext.unregisterReceiver(this.yM);
            this.yQ.cancel();
            this.yQ = null;
            this.yR = null;
        }
    }
}
