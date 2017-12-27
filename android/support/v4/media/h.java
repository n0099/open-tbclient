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
    final View yH;
    final g yI;
    final String yJ;
    final IntentFilter yK;
    PendingIntent yR;
    RemoteControlClient yS;
    boolean yT;
    boolean yV;
    final ViewTreeObserver.OnWindowAttachListener yL = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.h.1
        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            h.this.dv();
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            h.this.dA();
        }
    };
    final ViewTreeObserver.OnWindowFocusChangeListener yM = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.h.2
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (!z) {
                h.this.dz();
            } else {
                h.this.dw();
            }
        }
    };
    final BroadcastReceiver yN = new BroadcastReceiver() { // from class: android.support.v4.media.h.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                h.this.yI.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener yO = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.h.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            h.this.yI.ak(i);
        }
    };
    final RemoteControlClient.OnGetPlaybackPositionListener yP = new RemoteControlClient.OnGetPlaybackPositionListener() { // from class: android.support.v4.media.h.5
        @Override // android.media.RemoteControlClient.OnGetPlaybackPositionListener
        public long onGetPlaybackPosition() {
            return h.this.yI.du();
        }
    };
    final RemoteControlClient.OnPlaybackPositionUpdateListener yQ = new RemoteControlClient.OnPlaybackPositionUpdateListener() { // from class: android.support.v4.media.h.6
        @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
        public void onPlaybackPositionUpdate(long j) {
            h.this.yI.l(j);
        }
    };
    int yU = 0;

    public h(Context context, AudioManager audioManager, View view, g gVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.yH = view;
        this.yI = gVar;
        this.yJ = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.yJ);
        this.mIntent.setPackage(context.getPackageName());
        this.yK = new IntentFilter();
        this.yK.addAction(this.yJ);
        this.yH.getViewTreeObserver().addOnWindowAttachListener(this.yL);
        this.yH.getViewTreeObserver().addOnWindowFocusChangeListener(this.yM);
    }

    public Object getRemoteControlClient() {
        return this.yS;
    }

    public void destroy() {
        dA();
        this.yH.getViewTreeObserver().removeOnWindowAttachListener(this.yL);
        this.yH.getViewTreeObserver().removeOnWindowFocusChangeListener(this.yM);
    }

    void dv() {
        this.mContext.registerReceiver(this.yN, this.yK);
        this.yR = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        this.yS = new RemoteControlClient(this.yR);
        this.yS.setOnGetPlaybackPositionListener(this.yP);
        this.yS.setPlaybackPositionUpdateListener(this.yQ);
    }

    void dw() {
        if (!this.yT) {
            this.yT = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.yR);
            this.mAudioManager.registerRemoteControlClient(this.yS);
            if (this.yU == 3) {
                dx();
            }
        }
    }

    void dx() {
        if (!this.yV) {
            this.yV = true;
            this.mAudioManager.requestAudioFocus(this.yO, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.yU != 3) {
            this.yU = 3;
            this.yS.setPlaybackState(3);
        }
        if (this.yT) {
            dx();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.yS != null) {
            this.yS.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.yS.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.yU == 3) {
            this.yU = 2;
            this.yS.setPlaybackState(2);
        }
        dy();
    }

    public void stopPlaying() {
        if (this.yU != 1) {
            this.yU = 1;
            this.yS.setPlaybackState(1);
        }
        dy();
    }

    void dy() {
        if (this.yV) {
            this.yV = false;
            this.mAudioManager.abandonAudioFocus(this.yO);
        }
    }

    void dz() {
        dy();
        if (this.yT) {
            this.yT = false;
            this.mAudioManager.unregisterRemoteControlClient(this.yS);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.yR);
        }
    }

    void dA() {
        dz();
        if (this.yR != null) {
            this.mContext.unregisterReceiver(this.yN);
            this.yR.cancel();
            this.yR = null;
            this.yS = null;
        }
    }
}
