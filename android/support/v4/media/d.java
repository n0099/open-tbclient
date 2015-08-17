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
    final View lJ;
    final c lK;
    final String lL;
    final IntentFilter lM;
    PendingIntent lR;
    RemoteControlClient lS;
    boolean lT;
    boolean lV;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener lN = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener lO = new f(this);
    final BroadcastReceiver lP = new g(this);
    AudioManager.OnAudioFocusChangeListener lQ = new h(this);
    int lU = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.lD = audioManager;
        this.lJ = view;
        this.lK = cVar;
        this.lL = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.lL);
        this.mIntent.setPackage(context.getPackageName());
        this.lM = new IntentFilter();
        this.lM.addAction(this.lL);
        this.lJ.getViewTreeObserver().addOnWindowAttachListener(this.lN);
        this.lJ.getViewTreeObserver().addOnWindowFocusChangeListener(this.lO);
    }

    public Object getRemoteControlClient() {
        return this.lS;
    }

    public void destroy() {
        dr();
        this.lJ.getViewTreeObserver().removeOnWindowAttachListener(this.lN);
        this.lJ.getViewTreeObserver().removeOnWindowFocusChangeListener(this.lO);
    }

    void dn() {
        if (!this.lV) {
            this.lV = true;
            this.lD.requestAudioFocus(this.lQ, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.lU != 3) {
            this.lU = 3;
            this.lS.setPlaybackState(3);
        }
        if (this.lT) {
            dn();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.lS != null) {
            this.lS.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.lS.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.lU == 3) {
            this.lU = 2;
            this.lS.setPlaybackState(2);
        }
        dp();
    }

    public void stopPlaying() {
        if (this.lU != 1) {
            this.lU = 1;
            this.lS.setPlaybackState(1);
        }
        dp();
    }

    void dp() {
        if (this.lV) {
            this.lV = false;
            this.lD.abandonAudioFocus(this.lQ);
        }
    }

    void dq() {
        dp();
        if (this.lT) {
            this.lT = false;
            this.lD.unregisterRemoteControlClient(this.lS);
            this.lD.unregisterMediaButtonEventReceiver(this.lR);
        }
    }

    void dr() {
        dq();
        if (this.lR != null) {
            this.mContext.unregisterReceiver(this.lP);
            this.lR.cancel();
            this.lR = null;
            this.lS = null;
        }
    }
}
