package com.baidu.location;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import java.util.List;
/* loaded from: classes.dex */
public class GeofenceClient implements a0, n {
    public static final String BUNDLE_FOR_GEOFENCE_ID = "geofence_id";
    private static final int bl = 1;
    private static long bp = a3.jw;
    private Context bh;
    private OnGeofenceTriggerListener bi;
    private boolean bn = false;
    private Messenger bm = null;
    private a bo = new a();
    private Messenger bk = new Messenger(this.bo);
    private ServiceConnection bj = new ServiceConnection() { // from class: com.baidu.location.GeofenceClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GeofenceClient.this.bm = new Messenger(iBinder);
            if (GeofenceClient.this.bm == null) {
                return;
            }
            GeofenceClient.this.bn = true;
            GeofenceClient.this.startGeofenceScann();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            GeofenceClient.this.bm = null;
            GeofenceClient.this.bn = false;
        }
    };

    /* loaded from: classes.dex */
    public interface OnAddBDGeofencesResultListener {
        void onAddBDGeofencesResult(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface OnGeofenceTriggerListener {
        void onGeofenceExit(String str);

        void onGeofenceTrigger(String str);
    }

    /* loaded from: classes.dex */
    public interface OnRemoveBDGeofencesResultListener {
        void onRemoveBDGeofencesByRequestIdsResult(int i, String[] strArr);
    }

    /* loaded from: classes.dex */
    class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    GeofenceClient.this.d();
                    return;
                case a0.f38new /* 208 */:
                    if (data != null) {
                        GeofenceClient.this.m13for(data.getString(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID));
                        return;
                    }
                    return;
                case a0.c /* 209 */:
                    if (data != null) {
                        GeofenceClient.this.m18int(data.getString(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public GeofenceClient(Context context) {
        this.bh = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.bn) {
            return;
        }
        Intent intent = new Intent(this.bh, f.class);
        intent.putExtra("interval", bp);
        try {
            this.bh.bindService(intent, this.bj, 1);
        } catch (Exception e) {
            this.bn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long e() {
        return bp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m13for(String str) {
        if (this.bi != null) {
            this.bi.onGeofenceTrigger(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m18int(String str) {
        if (this.bi != null) {
            this.bi.onGeofenceExit(str);
        }
    }

    /* renamed from: void  reason: not valid java name */
    private void m19void() {
        try {
            Message obtain = Message.obtain((Handler) null, (int) a0.J);
            obtain.replyTo = this.bk;
            this.bm.send(obtain);
        } catch (Exception e) {
        }
    }

    public void addBDGeofence(BDGeofence bDGeofence, OnAddBDGeofencesResultListener onAddBDGeofencesResultListener) {
        aq.a(bDGeofence, "geofence is null");
        if (bDGeofence != null) {
            aq.m188if(bDGeofence instanceof at, "BDGeofence must be created using BDGeofence.Builder");
        }
        ax.m233for(this.bh).m249if((at) bDGeofence, onAddBDGeofencesResultListener);
    }

    public boolean isStarted() {
        return this.bn;
    }

    public void registerGeofenceTriggerListener(OnGeofenceTriggerListener onGeofenceTriggerListener) {
        if (this.bi == null) {
            this.bi = onGeofenceTriggerListener;
        }
    }

    public void removeBDGeofences(List list, OnRemoveBDGeofencesResultListener onRemoveBDGeofencesResultListener) {
        ax.m233for(this.bh).m250if(list, onRemoveBDGeofencesResultListener);
    }

    public void setInterval(long j) {
        if (j > bp) {
            bp = j;
        }
    }

    public void start() {
        aq.a(this.bi, "OnGeofenceTriggerListener not register!");
        this.bo.obtainMessage(1).sendToTarget();
    }

    public void startGeofenceScann() {
        if (this.bn) {
            try {
                Message obtain = Message.obtain((Handler) null, (int) a0.j);
                obtain.replyTo = this.bk;
                this.bm.send(obtain);
            } catch (Exception e) {
            }
        }
    }

    public void stop() {
        m19void();
    }
}
