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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class LocationClient {
    private static final int B = 4;
    private static final int b = 8;
    private static final int f = 9;

    /* renamed from: for  reason: not valid java name */
    private static final String f28for = "baidu_location_Client";

    /* renamed from: goto  reason: not valid java name */
    private static final int f29goto = 1000;
    private static final int h = 7;

    /* renamed from: if  reason: not valid java name */
    private static final int f30if = 10;
    private static final int m = 5;
    private static final int n = 12;
    private static final int o = 6;
    private static final int p = 2;
    private static final int s = 6000;

    /* renamed from: try  reason: not valid java name */
    private static final int f31try = 1;

    /* renamed from: void  reason: not valid java name */
    private static final int f32void = 3;
    private static final int y = 11;

    /* renamed from: else  reason: not valid java name */
    private i f37else;
    private Context j;
    private LocationClientOption l;
    private String e = "3.1";
    private long r = 0;

    /* renamed from: char  reason: not valid java name */
    private long f35char = 0;
    private String A = null;
    private boolean q = false;
    private Messenger k = null;

    /* renamed from: do  reason: not valid java name */
    private a f36do = new a();
    private final Messenger i = new Messenger(this.f36do);
    private ArrayList C = null;
    private BDLocation x = null;
    private boolean d = false;
    private boolean v = false;
    private boolean g = false;

    /* renamed from: byte  reason: not valid java name */
    private b f33byte = null;
    private boolean a = false;

    /* renamed from: int  reason: not valid java name */
    private boolean f38int = false;

    /* renamed from: new  reason: not valid java name */
    private final Object f40new = new Object();
    private boolean w = false;
    private BDLocationListener c = null;
    private String z = null;
    private String u = "http://loc.map.baidu.com/sdk.php";

    /* renamed from: long  reason: not valid java name */
    private Boolean f39long = false;

    /* renamed from: case  reason: not valid java name */
    private Boolean f34case = false;
    private ServiceConnection t = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationClient.this.k = new Messenger(iBinder);
            if (LocationClient.this.k == null) {
                j.a(LocationClient.f28for, "server not connected");
                return;
            }
            LocationClient.this.q = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            try {
                Message obtain = Message.obtain((Handler) null, (int) LocationClient.y);
                obtain.replyTo = LocationClient.this.i;
                obtain.setData(LocationClient.this.m18if());
                LocationClient.this.k.send(obtain);
                LocationClient.this.q = true;
                LocationClient.this.f38int = true;
                j.a(LocationClient.f28for, "bindService ...");
                if (LocationClient.this.l != null) {
                    LocationClient.this.f36do.obtainMessage(LocationClient.B).sendToTarget();
                }
            } catch (RemoteException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LocationClient.this.k = null;
            LocationClient.this.q = false;
            j.a(LocationClient.f28for, "unbindservice...");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    LocationClient.this.m13for();
                    return;
                case 2:
                    LocationClient.this.m23int();
                    return;
                case 3:
                    LocationClient.this.m19if(message);
                    return;
                case LocationClient.B /* 4 */:
                    LocationClient.this.m2byte();
                    return;
                case LocationClient.m /* 5 */:
                    LocationClient.this.m14for(message);
                    return;
                case LocationClient.o /* 6 */:
                    LocationClient.this.a(message);
                    return;
                case LocationClient.h /* 7 */:
                    LocationClient.this.m7do();
                    return;
                case LocationClient.b /* 8 */:
                    LocationClient.this.onRegisterNotifyLocationListener(message);
                    return;
                case LocationClient.f /* 9 */:
                    LocationClient.this.onRegisterNotify(message);
                    return;
                case LocationClient.f30if /* 10 */:
                    LocationClient.this.onRemoveNotifyEvent(message);
                    return;
                case LocationClient.y /* 11 */:
                    LocationClient.this.m27new();
                    return;
                case LocationClient.n /* 12 */:
                    LocationClient.this.m29try();
                    return;
                case 21:
                    LocationClient.this.a(message, 21);
                    return;
                case 26:
                    LocationClient.this.a(message, 26);
                    return;
                case 27:
                    LocationClient.this.m8do(message);
                    return;
                case 54:
                    if (LocationClient.this.l.f53void) {
                        LocationClient.this.a = true;
                        return;
                    }
                    return;
                case 55:
                    if (LocationClient.this.l.f53void) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.f40new) {
                LocationClient.this.g = false;
                if (LocationClient.this.k == null || LocationClient.this.i == null) {
                    return;
                }
                if (LocationClient.this.C == null || LocationClient.this.C.size() < 1) {
                    return;
                }
                j.a(LocationClient.f28for, "request location ...");
                LocationClient.this.f36do.obtainMessage(LocationClient.B).sendToTarget();
            }
        }
    }

    public LocationClient(Context context) {
        this.l = new LocationClientOption();
        this.j = null;
        this.f37else = null;
        this.j = context;
        this.l = new LocationClientOption();
        this.f37else = new i(this.j, this);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.l = new LocationClientOption();
        this.j = null;
        this.f37else = null;
        this.j = context;
        this.l = locationClientOption;
        this.f37else = new i(this.j, this);
    }

    private Bundle a() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", this.l.a);
        bundle.putFloat("distance", this.l.f44do);
        bundle.putBoolean("extraInfo", this.l.f48if);
        return bundle;
    }

    private void a(int i) {
        if (i == 26 && this.v) {
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onReceivePoi(this.x);
            }
            this.v = false;
        }
        if (this.d || ((this.l.f53void && this.x.getLocType() == 61) || this.x.getLocType() == 66 || this.x.getLocType() == 67)) {
            if (this.l != null && this.l.isDisableCache() && this.x.getLocType() == 65) {
                return;
            }
            Iterator it2 = this.C.iterator();
            while (it2.hasNext()) {
                ((BDLocationListener) it2.next()).onReceiveLocation(this.x);
            }
            if (this.f38int && j.f205try && this.x.getLocType() == 65) {
                this.f38int = false;
            } else if (this.x.getLocType() == 66 || this.x.getLocType() == 67) {
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
        if (this.C == null || !this.C.contains(bDLocationListener)) {
            return;
        }
        this.C.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        String string = message.getData().getString("locStr");
        j.a(f28for, "on receive new location : " + string);
        j.m239if(f28for, "on receive new location : " + string);
        this.x = new BDLocation(string);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m2byte() {
        if (this.k == null) {
            j.a(f28for, "server not connected");
            return;
        }
        if (!this.a || !this.l.f53void) {
            Message obtain = Message.obtain((Handler) null, 22);
            try {
                obtain.replyTo = this.i;
                this.k.send(obtain);
                this.r = System.currentTimeMillis();
                this.d = true;
                j.a(f28for, "send request to server...");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        synchronized (this.f40new) {
            if (this.l != null && this.l.f49int >= 1000 && !this.g) {
                if (this.f33byte == null) {
                    this.f33byte = new b();
                }
                this.f36do.postDelayed(this.f33byte, this.l.f49int);
                this.g = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m7do() {
        if (this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 25);
        try {
            obtain.replyTo = this.i;
            obtain.setData(a());
            this.k.send(obtain);
            this.f35char = System.currentTimeMillis();
            this.v = true;
            j.a(f28for, "send poi request to server...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m8do(Message message) {
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
    public void m13for() {
        if (this.q) {
            return;
        }
        j.m235for();
        this.A = this.j.getPackageName();
        this.z = this.A + "_bdls_v2.9";
        j.a(f28for, this.z);
        Intent intent = new Intent(this.j, f.class);
        if (this.l == null) {
            this.l = new LocationClientOption();
        }
        try {
            this.j.bindService(intent, this.t, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m14for(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public Bundle m18if() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.A);
        bundle.putString("prodName", this.l.f51new);
        bundle.putString("coorType", this.l.f52try);
        bundle.putString("addrType", this.l.f43char);
        bundle.putString("Url", this.u);
        bundle.putBoolean("openGPS", this.l.f42case);
        bundle.putBoolean("location_change_notify", this.l.f53void);
        bundle.putInt("scanSpan", this.l.f49int);
        bundle.putInt("timeOut", this.l.f50long);
        bundle.putInt("priority", this.l.f47goto);
        bundle.putBoolean("map", this.f39long.booleanValue());
        bundle.putBoolean("import", this.f34case.booleanValue());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m19if(Message message) {
        j.a(f28for, "onSetOption...");
        if (message == null || message.obj == null) {
            j.a(f28for, "setOption, but msg.obj is null");
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.l.equals(locationClientOption)) {
            return;
        }
        if (this.l.f49int != locationClientOption.f49int) {
            try {
                synchronized (this.f40new) {
                    if (this.g) {
                        this.f36do.removeCallbacks(this.f33byte);
                        this.g = false;
                    }
                    if (locationClientOption.f49int >= 1000 && !this.g) {
                        if (this.f33byte == null) {
                            this.f33byte = new b();
                        }
                        this.f36do.postDelayed(this.f33byte, locationClientOption.f49int);
                        this.g = true;
                    }
                }
            } catch (Exception e) {
                j.a(f28for, "set location excpetion...");
            }
        }
        this.l = new LocationClientOption(locationClientOption);
        if (this.k == null) {
            j.a(f28for, "server not connected");
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 15);
            obtain.replyTo = this.i;
            obtain.setData(m18if());
            this.k.send(obtain);
            j.a(f28for, "change option ...");
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m23int() {
        if (!this.q || this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, (int) n);
        obtain.replyTo = this.i;
        try {
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.j.unbindService(this.t);
        synchronized (this.f40new) {
            try {
                if (this.g) {
                    this.f36do.removeCallbacks(this.f33byte);
                    this.g = false;
                }
            } catch (Exception e2) {
            }
        }
        this.f37else.m231if();
        this.k = null;
        j.m240int();
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m27new() {
        if (this.k == null) {
            j.a(f28for, "server not connected");
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
    public void m29try() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.i;
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.x;
    }

    public LocationClientOption getLocOption() {
        return this.l;
    }

    public String getVersion() {
        return this.e;
    }

    public boolean isStarted() {
        return this.q;
    }

    public void onRegisterNotify(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.f37else.m230if((BDNotifyListener) message.obj);
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
        this.f37else.m229do((BDNotifyListener) message.obj);
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f36do.obtainMessage(m);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f36do.obtainMessage(f);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f36do.obtainMessage(b);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f36do.obtainMessage(f30if);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int requestLocation() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.C == null || this.C.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.r < 1000) {
            return o;
        }
        j.a(f28for, "request location ...");
        this.f36do.obtainMessage(B).sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.f36do.obtainMessage(y).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.C == null || this.C.size() < 1) {
            return 2;
        }
        this.f36do.obtainMessage(n).sendToTarget();
        return 0;
    }

    public int requestPoi() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.C == null || this.C.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f35char < 6000) {
            return o;
        }
        if (this.l.a >= 1) {
            j.a(f28for, "request location ...");
            this.f36do.obtainMessage(h).sendToTarget();
            return 0;
        }
        return h;
    }

    public void setForBaiduMap(boolean z) {
        this.f39long = Boolean.valueOf(z);
        j.f205try = z;
    }

    public void setForPreImport(boolean z) {
        this.f34case = Boolean.valueOf(z);
        j.v = z;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        Message obtainMessage = this.f36do.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void setTestUrl(String str) {
        if (str == null) {
            this.u = "http://220.181.3.9:8091/loc_addr_all.php";
        } else {
            this.u = str;
        }
    }

    public void start() {
        this.f36do.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.f36do.obtainMessage(2).sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f36do.obtainMessage(o);
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
