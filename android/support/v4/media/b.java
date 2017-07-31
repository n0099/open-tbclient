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
    PendingIntent jD;
    RemoteControlClient jE;
    boolean jF;
    boolean jH;
    final View jv;
    final a jw;
    final String jx;
    final IntentFilter jy;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener jz = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.b.1
    };
    final ViewTreeObserver.OnWindowFocusChangeListener jA = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.b.2
    };
    final BroadcastReceiver jB = new BroadcastReceiver() { // from class: android.support.v4.media.b.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                b.this.jw.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener jC = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.b.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            b.this.jw.k(i);
        }
    };
    int jG = 0;

    public b(Context context, AudioManager audioManager, View view, a aVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.jv = view;
        this.jw = aVar;
        this.jx = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.jx);
        this.mIntent.setPackage(context.getPackageName());
        this.jy = new IntentFilter();
        this.jy.addAction(this.jx);
        this.jv.getViewTreeObserver().addOnWindowAttachListener(this.jz);
        this.jv.getViewTreeObserver().addOnWindowFocusChangeListener(this.jA);
    }

    public Object getRemoteControlClient() {
        return this.jE;
    }

    public void destroy() {
        aT();
        this.jv.getViewTreeObserver().removeOnWindowAttachListener(this.jz);
        this.jv.getViewTreeObserver().removeOnWindowFocusChangeListener(this.jA);
    }

    void aQ() {
        if (!this.jH) {
            this.jH = true;
            this.mAudioManager.requestAudioFocus(this.jC, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.jG != 3) {
            this.jG = 3;
            this.jE.setPlaybackState(3);
        }
        if (this.jF) {
            aQ();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.jE != null) {
            this.jE.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.jE.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.jG == 3) {
            this.jG = 2;
            this.jE.setPlaybackState(2);
        }
        aR();
    }

    public void stopPlaying() {
        if (this.jG != 1) {
            this.jG = 1;
            this.jE.setPlaybackState(1);
        }
        aR();
    }

    void aR() {
        if (this.jH) {
            this.jH = false;
            this.mAudioManager.abandonAudioFocus(this.jC);
        }
    }

    void aS() {
        aR();
        if (this.jF) {
            this.jF = false;
            this.mAudioManager.unregisterRemoteControlClient(this.jE);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.jD);
        }
    }

    void aT() {
        aS();
        if (this.jD != null) {
            this.mContext.unregisterReceiver(this.jB);
            this.jD.cancel();
            this.jD = null;
            this.jE = null;
        }
    }
}
