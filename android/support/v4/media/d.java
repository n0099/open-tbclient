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
    final View aD;
    final c aE;
    final String aF;
    final IntentFilter aG;
    PendingIntent aL;
    RemoteControlClient aM;
    boolean aN;
    boolean aP;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener aH = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener aI = new f(this);
    final BroadcastReceiver aJ = new g(this);
    AudioManager.OnAudioFocusChangeListener aK = new h(this);
    int aO = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.aD = view;
        this.aE = cVar;
        this.aF = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.aF);
        this.mIntent.setPackage(context.getPackageName());
        this.aG = new IntentFilter();
        this.aG.addAction(this.aF);
        this.aD.getViewTreeObserver().addOnWindowAttachListener(this.aH);
        this.aD.getViewTreeObserver().addOnWindowFocusChangeListener(this.aI);
    }

    public Object getRemoteControlClient() {
        return this.aM;
    }

    public void destroy() {
        T();
        this.aD.getViewTreeObserver().removeOnWindowAttachListener(this.aH);
        this.aD.getViewTreeObserver().removeOnWindowFocusChangeListener(this.aI);
    }

    void Q() {
        if (!this.aP) {
            this.aP = true;
            this.mAudioManager.requestAudioFocus(this.aK, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.aO != 3) {
            this.aO = 3;
            this.aM.setPlaybackState(3);
        }
        if (this.aN) {
            Q();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.aM != null) {
            this.aM.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.aM.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.aO == 3) {
            this.aO = 2;
            this.aM.setPlaybackState(2);
        }
        R();
    }

    public void stopPlaying() {
        if (this.aO != 1) {
            this.aO = 1;
            this.aM.setPlaybackState(1);
        }
        R();
    }

    void R() {
        if (this.aP) {
            this.aP = false;
            this.mAudioManager.abandonAudioFocus(this.aK);
        }
    }

    void S() {
        R();
        if (this.aN) {
            this.aN = false;
            this.mAudioManager.unregisterRemoteControlClient(this.aM);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.aL);
        }
    }

    void T() {
        S();
        if (this.aL != null) {
            this.mContext.unregisterReceiver(this.aJ);
            this.aL.cancel();
            this.aL = null;
            this.aM = null;
        }
    }
}
