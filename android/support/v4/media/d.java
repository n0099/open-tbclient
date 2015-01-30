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
    final View aE;
    final c aF;
    final String aG;
    final IntentFilter aH;
    PendingIntent aM;
    RemoteControlClient aN;
    boolean aO;
    boolean aQ;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener aI = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener aJ = new f(this);
    final BroadcastReceiver aK = new g(this);
    AudioManager.OnAudioFocusChangeListener aL = new h(this);
    int aP = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.aE = view;
        this.aF = cVar;
        this.aG = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.aG);
        this.mIntent.setPackage(context.getPackageName());
        this.aH = new IntentFilter();
        this.aH.addAction(this.aG);
        this.aE.getViewTreeObserver().addOnWindowAttachListener(this.aI);
        this.aE.getViewTreeObserver().addOnWindowFocusChangeListener(this.aJ);
    }

    public Object getRemoteControlClient() {
        return this.aN;
    }

    public void destroy() {
        T();
        this.aE.getViewTreeObserver().removeOnWindowAttachListener(this.aI);
        this.aE.getViewTreeObserver().removeOnWindowFocusChangeListener(this.aJ);
    }

    void Q() {
        if (!this.aQ) {
            this.aQ = true;
            this.mAudioManager.requestAudioFocus(this.aL, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.aP != 3) {
            this.aP = 3;
            this.aN.setPlaybackState(3);
        }
        if (this.aO) {
            Q();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.aN != null) {
            this.aN.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.aN.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.aP == 3) {
            this.aP = 2;
            this.aN.setPlaybackState(2);
        }
        R();
    }

    public void stopPlaying() {
        if (this.aP != 1) {
            this.aP = 1;
            this.aN.setPlaybackState(1);
        }
        R();
    }

    void R() {
        if (this.aQ) {
            this.aQ = false;
            this.mAudioManager.abandonAudioFocus(this.aL);
        }
    }

    void S() {
        R();
        if (this.aO) {
            this.aO = false;
            this.mAudioManager.unregisterRemoteControlClient(this.aN);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.aM);
        }
    }

    void T() {
        S();
        if (this.aM != null) {
            this.mContext.unregisterReceiver(this.aK);
            this.aM.cancel();
            this.aM = null;
            this.aN = null;
        }
    }
}
