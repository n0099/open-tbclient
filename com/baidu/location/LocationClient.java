package com.baidu.location;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tieba.util.NetWorkErr;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class LocationClient {
    private static final int b = 8;
    private static final int f = 9;

    /* renamed from: for  reason: not valid java name */
    private static final String f27for = "baidu_location_Client";

    /* renamed from: goto  reason: not valid java name */
    private static final int f28goto = 1000;
    private static final int h = 7;

    /* renamed from: if  reason: not valid java name */
    private static final int f29if = 10;
    private static final int m = 5;
    private static final int n = 6;
    private static final int o = 2;
    private static final int r = 6000;

    /* renamed from: try  reason: not valid java name */
    private static final int f30try = 1;

    /* renamed from: void  reason: not valid java name */
    private static final int f31void = 3;
    private static final int x = 11;
    private static final int z = 4;
    private ArrayList A;
    private boolean a;

    /* renamed from: byte  reason: not valid java name */
    private b f32byte;
    private BDLocationListener c;

    /* renamed from: case  reason: not valid java name */
    private Boolean f33case;

    /* renamed from: char  reason: not valid java name */
    private long f34char;
    private boolean d;

    /* renamed from: do  reason: not valid java name */
    private a f35do;
    private String e;

    /* renamed from: else  reason: not valid java name */
    private i f36else;
    private boolean g;
    private final Messenger i;

    /* renamed from: int  reason: not valid java name */
    private boolean f37int;
    private Context j;
    private Messenger k;
    private LocationClientOption l;

    /* renamed from: long  reason: not valid java name */
    private Boolean f38long;

    /* renamed from: new  reason: not valid java name */
    private final Object f39new;
    private boolean p;
    private long q;
    private ServiceConnection s;
    private String t;
    private boolean u;
    private boolean v;
    private BDLocation w;
    private String y;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    LocationClient.this.m12for();
                    return;
                case 2:
                    LocationClient.this.m22int();
                    return;
                case 3:
                    LocationClient.this.m18if(message);
                    return;
                case 4:
                    LocationClient.this.m27try();
                    return;
                case 5:
                    LocationClient.this.m13for(message);
                    return;
                case 6:
                    LocationClient.this.a(message);
                    return;
                case 7:
                    LocationClient.this.m6do();
                    return;
                case 8:
                    LocationClient.this.onRegisterNotifyLocationListener(message);
                    return;
                case 9:
                    LocationClient.this.onRegisterNotify(message);
                    return;
                case 10:
                    LocationClient.this.onRemoveNotifyEvent(message);
                    return;
                case 11:
                    LocationClient.this.m25new();
                    return;
                case NetWorkErr.USER_CANNOT_LOGIN /* 21 */:
                    LocationClient.this.a(message, 21);
                    return;
                case NetWorkErr.REGIST_SMSCODE_ERROR /* 26 */:
                    LocationClient.this.a(message, 26);
                    return;
                case NetWorkErr.REGIST_NAME_ERROR /* 27 */:
                    LocationClient.this.m7do(message);
                    return;
                case 54:
                    if (LocationClient.this.l.f52void) {
                        LocationClient.this.a = true;
                        return;
                    }
                    return;
                case 55:
                    if (LocationClient.this.l.f52void) {
                        LocationClient.this.a = false;
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.f39new) {
                LocationClient.this.g = false;
                if (LocationClient.this.k == null || LocationClient.this.i == null) {
                    return;
                }
                if (LocationClient.this.A == null || LocationClient.this.A.size() < 1) {
                    return;
                }
                j.a(LocationClient.f27for, "request location ...");
                LocationClient.this.f35do.obtainMessage(4).sendToTarget();
            }
        }
    }

    public LocationClient(Context context) {
        this.e = "2.6";
        this.q = 0L;
        this.f34char = 0L;
        this.y = null;
        this.l = new LocationClientOption();
        this.p = false;
        this.j = null;
        this.k = null;
        this.f35do = new a();
        this.i = new Messenger(this.f35do);
        this.A = null;
        this.w = null;
        this.d = false;
        this.u = false;
        this.g = false;
        this.f32byte = null;
        this.a = false;
        this.f37int = false;
        this.f39new = new Object();
        this.f36else = null;
        this.v = false;
        this.c = null;
        this.t = "http://loc.map.baidu.com/sdk.php";
        this.f38long = false;
        this.f33case = false;
        this.s = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.k = new Messenger(iBinder);
                if (LocationClient.this.k == null) {
                    j.a(LocationClient.f27for, "server not connected");
                    return;
                }
                Log.d("baidu_location_client", "baidu location connected ...");
                try {
                    Message obtain = Message.obtain((Handler) null, 11);
                    obtain.replyTo = LocationClient.this.i;
                    obtain.setData(LocationClient.this.m17if());
                    LocationClient.this.k.send(obtain);
                    LocationClient.this.p = true;
                    LocationClient.this.f37int = true;
                    j.a(LocationClient.f27for, "bindService ...");
                    if (LocationClient.this.l != null) {
                        LocationClient.this.f35do.obtainMessage(4).sendToTarget();
                    }
                } catch (RemoteException e) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.k = null;
                LocationClient.this.p = false;
                j.a(LocationClient.f27for, "unbindservice...");
            }
        };
        this.j = context;
        this.l = new LocationClientOption();
        this.f36else = new i(this.j, this);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.e = "2.6";
        this.q = 0L;
        this.f34char = 0L;
        this.y = null;
        this.l = new LocationClientOption();
        this.p = false;
        this.j = null;
        this.k = null;
        this.f35do = new a();
        this.i = new Messenger(this.f35do);
        this.A = null;
        this.w = null;
        this.d = false;
        this.u = false;
        this.g = false;
        this.f32byte = null;
        this.a = false;
        this.f37int = false;
        this.f39new = new Object();
        this.f36else = null;
        this.v = false;
        this.c = null;
        this.t = "http://loc.map.baidu.com/sdk.php";
        this.f38long = false;
        this.f33case = false;
        this.s = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.k = new Messenger(iBinder);
                if (LocationClient.this.k == null) {
                    j.a(LocationClient.f27for, "server not connected");
                    return;
                }
                Log.d("baidu_location_client", "baidu location connected ...");
                try {
                    Message obtain = Message.obtain((Handler) null, 11);
                    obtain.replyTo = LocationClient.this.i;
                    obtain.setData(LocationClient.this.m17if());
                    LocationClient.this.k.send(obtain);
                    LocationClient.this.p = true;
                    LocationClient.this.f37int = true;
                    j.a(LocationClient.f27for, "bindService ...");
                    if (LocationClient.this.l != null) {
                        LocationClient.this.f35do.obtainMessage(4).sendToTarget();
                    }
                } catch (RemoteException e) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.k = null;
                LocationClient.this.p = false;
                j.a(LocationClient.f27for, "unbindservice...");
            }
        };
        this.j = context;
        this.l = locationClientOption;
    }

    private Bundle a() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", this.l.a);
        bundle.putFloat("distance", this.l.f43do);
        bundle.putBoolean("extraInfo", this.l.f47if);
        return bundle;
    }

    private void a(int i) {
        if (i == 26 && this.u) {
            Iterator it = this.A.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onReceivePoi(this.w);
            }
            this.u = false;
        }
        if (this.d || (this.l.f52void && this.w.getLocType() == 61)) {
            if (this.l != null && this.l.isDisableCache() && this.w.getLocType() == 65) {
                return;
            }
            Iterator it2 = this.A.iterator();
            while (it2.hasNext()) {
                ((BDLocationListener) it2.next()).onReceiveLocation(this.w);
            }
            if (this.f37int && j.f181do && this.w.getLocType() == 65) {
                this.f37int = false;
            } else {
                this.d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.A == null || !this.A.contains(bDLocationListener)) {
            return;
        }
        this.A.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        String string = message.getData().getString("locStr");
        j.a(f27for, "on receive new location : " + string);
        j.m188if(f27for, "on receive new location : " + string);
        this.w = new BDLocation(string);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m6do() {
        if (this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 25);
        try {
            obtain.replyTo = this.i;
            obtain.setData(a());
            this.k.send(obtain);
            this.f34char = System.currentTimeMillis();
            this.u = true;
            j.a(f27for, "send poi request to server...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m7do(Message message) {
        BDLocation bDLocation = new BDLocation(message.getData().getString("locStr"));
        if (this.c != null) {
            if (this.l != null && this.l.isDisableCache() && bDLocation.getLocType() == 65) {
                return;
            }
            this.c.onReceiveLocation(bDLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m12for() {
        if (this.p) {
            return;
        }
        j.m184for();
        this.y = this.j.getPackageName();
        Intent intent = new Intent();
        if (this.l == null) {
            this.l = new LocationClientOption();
        }
        intent.setAction(this.l.f40byte);
        this.j.bindService(intent, this.s, 1);
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m13for(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.A == null) {
            this.A = new ArrayList();
        }
        this.A.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public Bundle m17if() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.y);
        bundle.putString("prodName", this.l.f50new);
        bundle.putString("coorType", this.l.f51try);
        bundle.putString("Url", this.t);
        bundle.putBoolean("openGPS", this.l.f41case);
        bundle.putBoolean("location_change_notify", this.l.f52void);
        bundle.putInt("scanSpan", this.l.f48int);
        bundle.putInt("timeOut", this.l.f49long);
        bundle.putInt("priority", this.l.f46goto);
        bundle.putBoolean("map", this.f38long.booleanValue());
        bundle.putBoolean("import", this.f33case.booleanValue());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m18if(Message message) {
        j.a(f27for, "onSetOption...");
        if (message == null || message.obj == null) {
            j.a(f27for, "setOption, but msg.obj is null");
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.l.equals(locationClientOption)) {
            return;
        }
        if (this.l.f48int != locationClientOption.f48int) {
            try {
                synchronized (this.f39new) {
                    if (this.g) {
                        this.f35do.removeCallbacks(this.f32byte);
                        this.g = false;
                    }
                    if (locationClientOption.f48int >= 1000 && !this.g) {
                        if (this.f32byte == null) {
                            this.f32byte = new b();
                        }
                        this.f35do.postDelayed(this.f32byte, locationClientOption.f48int);
                        this.g = true;
                    }
                }
            } catch (Exception e) {
                j.a(f27for, "set location excpetion...");
            }
        }
        this.l = new LocationClientOption(locationClientOption);
        if (this.k == null) {
            j.a(f27for, "server not connected");
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 15);
            obtain.replyTo = this.i;
            obtain.setData(m17if());
            this.k.send(obtain);
            j.a(f27for, "change option ...");
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m22int() {
        if (!this.p || this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.i;
        try {
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.j.unbindService(this.s);
        synchronized (this.f39new) {
            try {
                if (this.g) {
                    this.f35do.removeCallbacks(this.f32byte);
                    this.g = false;
                }
            } catch (Exception e2) {
            }
        }
        this.f36else.m181if();
        this.k = null;
        j.m189int();
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m25new() {
        if (this.k == null) {
            j.a(f27for, "server not connected");
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.i;
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m27try() {
        if (this.k == null) {
            j.a(f27for, "server not connected");
            return;
        }
        if (!this.a || !this.l.f52void) {
            Message obtain = Message.obtain((Handler) null, 22);
            try {
                obtain.replyTo = this.i;
                this.k.send(obtain);
                this.q = System.currentTimeMillis();
                this.d = true;
                j.a(f27for, "send request to server...");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        synchronized (this.f39new) {
            if (this.l != null && this.l.f48int >= 1000 && !this.g) {
                if (this.f32byte == null) {
                    this.f32byte = new b();
                }
                this.f35do.postDelayed(this.f32byte, this.l.f48int);
                this.g = true;
            }
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.w;
    }

    public String getVersion() {
        return this.e;
    }

    public boolean isStarted() {
        return this.p;
    }

    public void onRegisterNotify(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.f36else.m180if((BDNotifyListener) message.obj);
    }

    public void onRegisterNotifyLocationListener(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.c = (BDLocationListener) message.obj;
    }

    public void onRemoveNotifyEvent(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.f36else.m179do((BDNotifyListener) message.obj);
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f35do.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f35do.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f35do.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f35do.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int requestLocation() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.A == null || this.A.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.q < 1000) {
            return 6;
        }
        j.a(f27for, "request location ...");
        this.f35do.obtainMessage(4).sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.f35do.obtainMessage(11).sendToTarget();
    }

    public int requestPoi() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.A == null || this.A.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f34char < 6000) {
            return 6;
        }
        if (this.l.a >= 1) {
            j.a(f27for, "request location ...");
            this.f35do.obtainMessage(7).sendToTarget();
            return 0;
        }
        return 7;
    }

    public void setForBaiduMap(boolean z2) {
        this.f38long = Boolean.valueOf(z2);
        j.f181do = z2;
    }

    public void setForPreImport(boolean z2) {
        this.f33case = Boolean.valueOf(z2);
        j.c = z2;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        Message obtainMessage = this.f35do.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void setTestUrl(String str) {
        if (str == null) {
            this.t = "http://220.181.3.9:8091/loc_addr_all.php";
        } else {
            this.t = str;
        }
    }

    public void start() {
        this.f35do.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.f35do.obtainMessage(2).sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f35do.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.k == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }
}
