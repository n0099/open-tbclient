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
    final View lI;
    final c lJ;
    final String lK;
    final IntentFilter lL;
    PendingIntent lQ;
    RemoteControlClient lR;
    boolean lS;
    boolean lU;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener lM = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener lN = new f(this);
    final BroadcastReceiver lO = new g(this);
    AudioManager.OnAudioFocusChangeListener lP = new h(this);
    int lT = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.lI = view;
        this.lJ = cVar;
        this.lK = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.lK);
        this.mIntent.setPackage(context.getPackageName());
        this.lL = new IntentFilter();
        this.lL.addAction(this.lK);
        this.lI.getViewTreeObserver().addOnWindowAttachListener(this.lM);
        this.lI.getViewTreeObserver().addOnWindowFocusChangeListener(this.lN);
    }

    public Object getRemoteControlClient() {
        return this.lR;
    }

    public void destroy() {
        dr();
        this.lI.getViewTreeObserver().removeOnWindowAttachListener(this.lM);
        this.lI.getViewTreeObserver().removeOnWindowFocusChangeListener(this.lN);
    }

    void dn() {
        if (!this.lU) {
            this.lU = true;
            this.mAudioManager.requestAudioFocus(this.lP, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.lT != 3) {
            this.lT = 3;
            this.lR.setPlaybackState(3);
        }
        if (this.lS) {
            dn();
        }
    }

    public void a(boolean z, long j, int i) {
        if (this.lR != null) {
            this.lR.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.lR.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.lT == 3) {
            this.lT = 2;
            this.lR.setPlaybackState(2);
        }
        dp();
    }

    public void stopPlaying() {
        if (this.lT != 1) {
            this.lT = 1;
            this.lR.setPlaybackState(1);
        }
        dp();
    }

    void dp() {
        if (this.lU) {
            this.lU = false;
            this.mAudioManager.abandonAudioFocus(this.lP);
        }
    }

    void dq() {
        dp();
        if (this.lS) {
            this.lS = false;
            this.mAudioManager.unregisterRemoteControlClient(this.lR);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.lQ);
        }
    }

    void dr() {
        dq();
        if (this.lQ != null) {
            this.mContext.unregisterReceiver(this.lO);
            this.lQ.cancel();
            this.lQ = null;
            this.lR = null;
        }
    }
}
