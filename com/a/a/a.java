package com.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes19.dex */
public class a {
    private Context mContext;
    private Handler mHandler;
    ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.a.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.mHandler.obtainMessage(1, OpenDeviceIdentifierService.Stub.asInterface(iBinder)).sendToTarget();
            a.this.mHandler.removeMessages(2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }
    };
    private b ptF;

    /* loaded from: classes19.dex */
    public interface b {
        void bj(String str, boolean z);

        void g(int i, Exception exc);
    }

    private a(Context context, b bVar, Handler handler) {
        this.mContext = context;
        this.ptF = bVar;
        this.mHandler = new HandlerC0008a(handler == null ? Looper.getMainLooper() : handler.getLooper());
    }

    /* renamed from: com.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private class HandlerC0008a extends Handler {
        public HandlerC0008a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    a.this.ptF.g(-1, null);
                    return;
                case 1:
                    OpenDeviceIdentifierService openDeviceIdentifierService = (OpenDeviceIdentifierService) message.obj;
                    try {
                        try {
                            a.this.ptF.bj(openDeviceIdentifierService.getOaid(), openDeviceIdentifierService.isOaidTrackLimited());
                            try {
                                a.this.mContext.unbindService(a.this.mServiceConnection);
                                return;
                            } catch (Exception e) {
                                a.this.ptF.g(-4, e);
                                return;
                            }
                        } catch (RemoteException e2) {
                            a.this.ptF.g(-3, e2);
                            try {
                                a.this.mContext.unbindService(a.this.mServiceConnection);
                                return;
                            } catch (Exception e3) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            a.this.mContext.unbindService(a.this.mServiceConnection);
                        } catch (Exception e4) {
                            a.this.ptF.g(-4, e4);
                        }
                        throw th;
                    }
                case 2:
                    a.this.ptF.g(-2, null);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, b bVar) {
        a(context, bVar, null);
    }

    public static void a(Context context, b bVar, Handler handler) {
        new a(context.getApplicationContext(), bVar, handler).esL();
    }

    private void esL() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.mContext.bindService(intent, this.mServiceConnection, 1)) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 10000L);
        } else {
            this.mHandler.sendEmptyMessage(0);
        }
    }
}
