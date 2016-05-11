package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.view.View;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener {
    final AudioManager bE;
    final View bL;
    final c bM;
    final String bN;
    final IntentFilter bO;
    PendingIntent bT;
    RemoteControlClient bU;
    boolean bV;
    boolean bX;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener bP = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener bQ = new f(this);
    final BroadcastReceiver bR = new g(this);
    AudioManager.OnAudioFocusChangeListener bS = new h(this);
    int bW = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.bE = audioManager;
        this.bL = view;
        this.bM = cVar;
        this.bN = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.bN);
        this.mIntent.setPackage(context.getPackageName());
        this.bO = new IntentFilter();
        this.bO.addAction(this.bN);
        this.bL.getViewTreeObserver().addOnWindowAttachListener(this.bP);
        this.bL.getViewTreeObserver().addOnWindowFocusChangeListener(this.bQ);
    }

    public Object getRemoteControlClient() {
        return this.bU;
    }

    public void destroy() {
        J();
        this.bL.getViewTreeObserver().removeOnWindowAttachListener(this.bP);
        this.bL.getViewTreeObserver().removeOnWindowFocusChangeListener(this.bQ);
    }

    void G() {
        if (!this.bX) {
            this.bX = true;
            this.bE.requestAudioFocus(this.bS, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.bW != 3) {
            this.bW = 3;
            this.bU.setPlaybackState(3);
        }
        if (this.bV) {
            G();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.bU != null) {
            this.bU.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.bU.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.bW == 3) {
            this.bW = 2;
            this.bU.setPlaybackState(2);
        }
        H();
    }

    public void stopPlaying() {
        if (this.bW != 1) {
            this.bW = 1;
            this.bU.setPlaybackState(1);
        }
        H();
    }

    void H() {
        if (this.bX) {
            this.bX = false;
            this.bE.abandonAudioFocus(this.bS);
        }
    }

    void I() {
        H();
        if (this.bV) {
            this.bV = false;
            this.bE.unregisterRemoteControlClient(this.bU);
            this.bE.unregisterMediaButtonEventReceiver(this.bT);
        }
    }

    void J() {
        I();
        if (this.bT != null) {
            this.mContext.unregisterReceiver(this.bR);
            this.bT.cancel();
            this.bT = null;
            this.bU = null;
        }
    }
}
