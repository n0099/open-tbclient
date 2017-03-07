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
    PendingIntent jD;
    RemoteControlClient jE;
    boolean jF;
    boolean jH;
    final View jv;
    final c jw;
    final String jx;
    final IntentFilter jy;
    final AudioManager mAudioManager;
    final Context mContext;
    final Intent mIntent;
    final ViewTreeObserver.OnWindowAttachListener jz = new e(this);
    final ViewTreeObserver.OnWindowFocusChangeListener jA = new f(this);
    final BroadcastReceiver jB = new g(this);
    AudioManager.OnAudioFocusChangeListener jC = new h(this);
    int jG = 0;

    public d(Context context, AudioManager audioManager, View view, c cVar) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.jv = view;
        this.jw = cVar;
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
