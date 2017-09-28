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
/* loaded from: classes.dex */
class b implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener {
    PendingIntent jC;
    RemoteControlClient jD;
    boolean jE;
    boolean jG;
    final View ju;
    final a jv;
    final String jw;
    final IntentFilter jx;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener jy = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.b.1
    };
    final ViewTreeObserver.OnWindowFocusChangeListener jz = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.b.2
    };
    final BroadcastReceiver jA = new BroadcastReceiver() { // from class: android.support.v4.media.b.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                b.this.jv.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener jB = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.b.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            b.this.jv.k(i);
        }
    };
    int jF = 0;

    public b(Context context, AudioManager audioManager, View view, a aVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.ju = view;
        this.jv = aVar;
        this.jw = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.jw);
        this.mIntent.setPackage(context.getPackageName());
        this.jx = new IntentFilter();
        this.jx.addAction(this.jw);
        this.ju.getViewTreeObserver().addOnWindowAttachListener(this.jy);
        this.ju.getViewTreeObserver().addOnWindowFocusChangeListener(this.jz);
    }

    public Object getRemoteControlClient() {
        return this.jD;
    }

    public void destroy() {
        aT();
        this.ju.getViewTreeObserver().removeOnWindowAttachListener(this.jy);
        this.ju.getViewTreeObserver().removeOnWindowFocusChangeListener(this.jz);
    }

    void aQ() {
        if (!this.jG) {
            this.jG = true;
            this.mAudioManager.requestAudioFocus(this.jB, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.jF != 3) {
            this.jF = 3;
            this.jD.setPlaybackState(3);
        }
        if (this.jE) {
            aQ();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.jD != null) {
            this.jD.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.jD.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.jF == 3) {
            this.jF = 2;
            this.jD.setPlaybackState(2);
        }
        aR();
    }

    public void stopPlaying() {
        if (this.jF != 1) {
            this.jF = 1;
            this.jD.setPlaybackState(1);
        }
        aR();
    }

    void aR() {
        if (this.jG) {
            this.jG = false;
            this.mAudioManager.abandonAudioFocus(this.jB);
        }
    }

    void aS() {
        aR();
        if (this.jE) {
            this.jE = false;
            this.mAudioManager.unregisterRemoteControlClient(this.jD);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.jC);
        }
    }

    void aT() {
        aS();
        if (this.jC != null) {
            this.mContext.unregisterReceiver(this.jA);
            this.jC.cancel();
            this.jC = null;
            this.jD = null;
        }
    }
}
