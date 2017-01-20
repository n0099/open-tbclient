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
    final View bK;
    final c bL;
    final String bM;
    final IntentFilter bN;
    PendingIntent bS;
    RemoteControlClient bT;
    boolean bU;
    boolean bW;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener bO = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener bP = new f(this);
    final BroadcastReceiver bQ = new g(this);
    AudioManager.OnAudioFocusChangeListener bR = new h(this);
    int bV = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.bK = view;
        this.bL = cVar;
        this.bM = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.bM);
        this.mIntent.setPackage(context.getPackageName());
        this.bN = new IntentFilter();
        this.bN.addAction(this.bM);
        this.bK.getViewTreeObserver().addOnWindowAttachListener(this.bO);
        this.bK.getViewTreeObserver().addOnWindowFocusChangeListener(this.bP);
    }

    public Object getRemoteControlClient() {
        return this.bT;
    }

    public void destroy() {
        J();
        this.bK.getViewTreeObserver().removeOnWindowAttachListener(this.bO);
        this.bK.getViewTreeObserver().removeOnWindowFocusChangeListener(this.bP);
    }

    void G() {
        if (!this.bW) {
            this.bW = true;
            this.mAudioManager.requestAudioFocus(this.bR, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.bV != 3) {
            this.bV = 3;
            this.bT.setPlaybackState(3);
        }
        if (this.bU) {
            G();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.bT != null) {
            this.bT.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.bT.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.bV == 3) {
            this.bV = 2;
            this.bT.setPlaybackState(2);
        }
        H();
    }

    public void stopPlaying() {
        if (this.bV != 1) {
            this.bV = 1;
            this.bT.setPlaybackState(1);
        }
        H();
    }

    void H() {
        if (this.bW) {
            this.bW = false;
            this.mAudioManager.abandonAudioFocus(this.bR);
        }
    }

    void I() {
        H();
        if (this.bU) {
            this.bU = false;
            this.mAudioManager.unregisterRemoteControlClient(this.bT);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.bS);
        }
    }

    void J() {
        I();
        if (this.bS != null) {
            this.mContext.unregisterReceiver(this.bQ);
            this.bS.cancel();
            this.bS = null;
            this.bT = null;
        }
    }
}
