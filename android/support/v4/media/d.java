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
    final AudioManager lD;
    final View lK;
    final c lL;
    final String lM;
    final IntentFilter lN;
    PendingIntent lS;
    RemoteControlClient lT;
    boolean lU;
    boolean lW;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener lO = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener lP = new f(this);
    final BroadcastReceiver lQ = new g(this);
    AudioManager.OnAudioFocusChangeListener lR = new h(this);
    int lV = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.lD = audioManager;
        this.lK = view;
        this.lL = cVar;
        this.lM = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.lM);
        this.mIntent.setPackage(context.getPackageName());
        this.lN = new IntentFilter();
        this.lN.addAction(this.lM);
        this.lK.getViewTreeObserver().addOnWindowAttachListener(this.lO);
        this.lK.getViewTreeObserver().addOnWindowFocusChangeListener(this.lP);
    }

    public Object getRemoteControlClient() {
        return this.lT;
    }

    public void destroy() {
        dr();
        this.lK.getViewTreeObserver().removeOnWindowAttachListener(this.lO);
        this.lK.getViewTreeObserver().removeOnWindowFocusChangeListener(this.lP);
    }

    void dn() {
        if (!this.lW) {
            this.lW = true;
            this.lD.requestAudioFocus(this.lR, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.lV != 3) {
            this.lV = 3;
            this.lT.setPlaybackState(3);
        }
        if (this.lU) {
            dn();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.lT != null) {
            this.lT.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.lT.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.lV == 3) {
            this.lV = 2;
            this.lT.setPlaybackState(2);
        }
        dp();
    }

    public void stopPlaying() {
        if (this.lV != 1) {
            this.lV = 1;
            this.lT.setPlaybackState(1);
        }
        dp();
    }

    void dp() {
        if (this.lW) {
            this.lW = false;
            this.lD.abandonAudioFocus(this.lR);
        }
    }

    void dq() {
        dp();
        if (this.lU) {
            this.lU = false;
            this.lD.unregisterRemoteControlClient(this.lT);
            this.lD.unregisterMediaButtonEventReceiver(this.lS);
        }
    }

    void dr() {
        dq();
        if (this.lS != null) {
            this.mContext.unregisterReceiver(this.lQ);
            this.lS.cancel();
            this.lS = null;
            this.lT = null;
        }
    }
}
