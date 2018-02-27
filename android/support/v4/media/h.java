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
    final View yB;
    final g yC;
    final String yD;
    final IntentFilter yE;
    PendingIntent yL;
    RemoteControlClient yM;
    boolean yN;
    boolean yP;
    final ViewTreeObserver.OnWindowAttachListener yF = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.h.1
        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            h.this.dv();
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            h.this.dA();
        }
    };
    final ViewTreeObserver.OnWindowFocusChangeListener yG = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.h.2
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            if (!z) {
                h.this.dz();
            } else {
                h.this.dw();
            }
        }
    };
    final BroadcastReceiver yH = new BroadcastReceiver() { // from class: android.support.v4.media.h.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                h.this.yC.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener yI = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.h.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            h.this.yC.ak(i);
        }
    };
    final RemoteControlClient.OnGetPlaybackPositionListener yJ = new RemoteControlClient.OnGetPlaybackPositionListener() { // from class: android.support.v4.media.h.5
        @Override // android.media.RemoteControlClient.OnGetPlaybackPositionListener
        public long onGetPlaybackPosition() {
            return h.this.yC.du();
        }
    };
    final RemoteControlClient.OnPlaybackPositionUpdateListener yK = new RemoteControlClient.OnPlaybackPositionUpdateListener() { // from class: android.support.v4.media.h.6
        @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
        public void onPlaybackPositionUpdate(long j) {
            h.this.yC.l(j);
        }
    };
    int yO = 0;

    public h(Context context, AudioManager audioManager, View view, g gVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.yB = view;
        this.yC = gVar;
        this.yD = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.yD);
        this.mIntent.setPackage(context.getPackageName());
        this.yE = new IntentFilter();
        this.yE.addAction(this.yD);
        this.yB.getViewTreeObserver().addOnWindowAttachListener(this.yF);
        this.yB.getViewTreeObserver().addOnWindowFocusChangeListener(this.yG);
    }

    public Object getRemoteControlClient() {
        return this.yM;
    }

    public void destroy() {
        dA();
        this.yB.getViewTreeObserver().removeOnWindowAttachListener(this.yF);
        this.yB.getViewTreeObserver().removeOnWindowFocusChangeListener(this.yG);
    }

    void dv() {
        this.mContext.registerReceiver(this.yH, this.yE);
        this.yL = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        this.yM = new RemoteControlClient(this.yL);
        this.yM.setOnGetPlaybackPositionListener(this.yJ);
        this.yM.setPlaybackPositionUpdateListener(this.yK);
    }

    void dw() {
        if (!this.yN) {
            this.yN = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.yL);
            this.mAudioManager.registerRemoteControlClient(this.yM);
            if (this.yO == 3) {
                dx();
            }
        }
    }

    void dx() {
        if (!this.yP) {
            this.yP = true;
            this.mAudioManager.requestAudioFocus(this.yI, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.yO != 3) {
            this.yO = 3;
            this.yM.setPlaybackState(3);
        }
        if (this.yN) {
            dx();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.yM != null) {
            this.yM.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.yM.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.yO == 3) {
            this.yO = 2;
            this.yM.setPlaybackState(2);
        }
        dy();
    }

    public void stopPlaying() {
        if (this.yO != 1) {
            this.yO = 1;
            this.yM.setPlaybackState(1);
        }
        dy();
    }

    void dy() {
        if (this.yP) {
            this.yP = false;
            this.mAudioManager.abandonAudioFocus(this.yI);
        }
    }

    void dz() {
        dy();
        if (this.yN) {
            this.yN = false;
            this.mAudioManager.unregisterRemoteControlClient(this.yM);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.yL);
        }
    }

    void dA() {
        dz();
        if (this.yL != null) {
            this.mContext.unregisterReceiver(this.yH);
            this.yL.cancel();
            this.yL = null;
            this.yM = null;
        }
    }
}
