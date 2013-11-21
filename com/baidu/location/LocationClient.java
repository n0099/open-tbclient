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
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class LocationClient {
    private static final int B = 4;
    private static final int b = 8;
    private static final int f = 9;

    /* renamed from: for  reason: not valid java name */
    private static final String f64for = "baidu_location_Client";

    /* renamed from: goto  reason: not valid java name */
    private static final int f65goto = 1000;
    private static final int h = 7;

    /* renamed from: if  reason: not valid java name */
    private static final int f66if = 10;
    private static final int m = 5;
    private static final int n = 12;
    private static final int o = 6;
    private static final int p = 2;
    private static final int s = 6000;

    /* renamed from: try  reason: not valid java name */
    private static final int f67try = 1;

    /* renamed from: void  reason: not valid java name */
    private static final int f68void = 3;
    private static final int y = 11;

    /* renamed from: else  reason: not valid java name */
    private i f73else;
    private Context j;
    private LocationClientOption l;
    private String e = "3.1";
    private long r = 0;

    /* renamed from: char  reason: not valid java name */
    private long f71char = 0;
    private String A = null;
    private boolean q = false;
    private Messenger k = null;

    /* renamed from: do  reason: not valid java name */
    private a f72do = new a();
    private final Messenger i = new Messenger(this.f72do);
    private ArrayList C = null;
    private BDLocation x = null;
    private boolean d = false;
    private boolean v = false;
    private boolean g = false;

    /* renamed from: byte  reason: not valid java name */
    private b f69byte = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f902a = false;

    /* renamed from: int  reason: not valid java name */
    private boolean f74int = false;

    /* renamed from: new  reason: not valid java name */
    private final Object f76new = new Object();
    private boolean w = false;
    private BDLocationListener c = null;
    private String z = null;
    private String u = "http://loc.map.baidu.com/sdk.php";

    /* renamed from: long  reason: not valid java name */
    private Boolean f75long = false;

    /* renamed from: case  reason: not valid java name */
    private Boolean f70case = false;
    private ServiceConnection t = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationClient.this.k = new Messenger(iBinder);
            if (LocationClient.this.k == null) {
                j.a(LocationClient.f64for, "server not connected");
                return;
            }
            LocationClient.this.q = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = LocationClient.this.i;
                obtain.setData(LocationClient.this.m35if());
                LocationClient.this.k.send(obtain);
                LocationClient.this.q = true;
                LocationClient.this.f74int = true;
                j.a(LocationClient.f64for, "bindService ...");
                if (LocationClient.this.l != null) {
                    LocationClient.this.f72do.obtainMessage(4).sendToTarget();
                }
            } catch (RemoteException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LocationClient.this.k = null;
            LocationClient.this.q = false;
            j.a(LocationClient.f64for, "unbindservice...");
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
                    LocationClient.this.m30for();
                    return;
                case 2:
                    LocationClient.this.m40int();
                    return;
                case 3:
                    LocationClient.this.m36if(message);
                    return;
                case 4:
                    LocationClient.this.m19byte();
                    return;
                case 5:
                    LocationClient.this.m31for(message);
                    return;
                case 6:
                    LocationClient.this.a(message);
                    return;
                case 7:
                    LocationClient.this.m24do();
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
                    LocationClient.this.m44new();
                    return;
                case 12:
                    LocationClient.this.m46try();
                    return;
                case 21:
                    LocationClient.this.a(message, 21);
                    return;
                case DERTags.VISIBLE_STRING /* 26 */:
                    LocationClient.this.a(message, 26);
                    return;
                case DERTags.GENERAL_STRING /* 27 */:
                    LocationClient.this.m25do(message);
                    return;
                case 54:
                    if (LocationClient.this.l.f89void) {
                        LocationClient.this.f902a = true;
                        return;
                    }
                    return;
                case 55:
                    if (LocationClient.this.l.f89void) {
                        LocationClient.this.f902a = false;
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
            synchronized (LocationClient.this.f76new) {
                LocationClient.this.g = false;
                if (LocationClient.this.k == null || LocationClient.this.i == null) {
                    return;
                }
                if (LocationClient.this.C == null || LocationClient.this.C.size() < 1) {
                    return;
                }
                j.a(LocationClient.f64for, "request location ...");
                LocationClient.this.f72do.obtainMessage(4).sendToTarget();
            }
        }
    }

    public LocationClient(Context context) {
        this.l = new LocationClientOption();
        this.j = null;
        this.f73else = null;
        this.j = context;
        this.l = new LocationClientOption();
        this.f73else = new i(this.j, this);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.l = new LocationClientOption();
        this.j = null;
        this.f73else = null;
        this.j = context;
        this.l = locationClientOption;
        this.f73else = new i(this.j, this);
    }

    private Bundle a() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", this.l.f906a);
        bundle.putFloat("distance", this.l.f80do);
        bundle.putBoolean("extraInfo", this.l.f84if);
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
        if (this.d || ((this.l.f89void && this.x.getLocType() == 61) || this.x.getLocType() == 66 || this.x.getLocType() == 67)) {
            if (this.l != null && this.l.isDisableCache() && this.x.getLocType() == 65) {
                return;
            }
            Iterator it2 = this.C.iterator();
            while (it2.hasNext()) {
                ((BDLocationListener) it2.next()).onReceiveLocation(this.x);
            }
            if (this.f74int && j.f241try && this.x.getLocType() == 65) {
                this.f74int = false;
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
        j.a(f64for, "on receive new location : " + string);
        j.m256if(f64for, "on receive new location : " + string);
        this.x = new BDLocation(string);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m19byte() {
        if (this.k == null) {
            j.a(f64for, "server not connected");
            return;
        }
        if (!this.f902a || !this.l.f89void) {
            Message obtain = Message.obtain((Handler) null, 22);
            try {
                obtain.replyTo = this.i;
                this.k.send(obtain);
                this.r = System.currentTimeMillis();
                this.d = true;
                j.a(f64for, "send request to server...");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        synchronized (this.f76new) {
            if (this.l != null && this.l.f85int >= 1000 && !this.g) {
                if (this.f69byte == null) {
                    this.f69byte = new b();
                }
                this.f72do.postDelayed(this.f69byte, this.l.f85int);
                this.g = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m24do() {
        if (this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 25);
        try {
            obtain.replyTo = this.i;
            obtain.setData(a());
            this.k.send(obtain);
            this.f71char = System.currentTimeMillis();
            this.v = true;
            j.a(f64for, "send poi request to server...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m25do(Message message) {
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
    public void m30for() {
        if (this.q) {
            return;
        }
        j.m252for();
        this.A = this.j.getPackageName();
        this.z = this.A + "_bdls_v2.9";
        j.a(f64for, this.z);
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
    public void m31for(Message message) {
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
    public Bundle m35if() {
        if (this.l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.A);
        bundle.putString("prodName", this.l.f87new);
        bundle.putString("coorType", this.l.f88try);
        bundle.putString("addrType", this.l.f79char);
        bundle.putString("Url", this.u);
        bundle.putBoolean("openGPS", this.l.f78case);
        bundle.putBoolean("location_change_notify", this.l.f89void);
        bundle.putInt("scanSpan", this.l.f85int);
        bundle.putInt("timeOut", this.l.f86long);
        bundle.putInt("priority", this.l.f83goto);
        bundle.putBoolean("map", this.f75long.booleanValue());
        bundle.putBoolean("import", this.f70case.booleanValue());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m36if(Message message) {
        j.a(f64for, "onSetOption...");
        if (message == null || message.obj == null) {
            j.a(f64for, "setOption, but msg.obj is null");
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.l.equals(locationClientOption)) {
            return;
        }
        if (this.l.f85int != locationClientOption.f85int) {
            try {
                synchronized (this.f76new) {
                    if (this.g) {
                        this.f72do.removeCallbacks(this.f69byte);
                        this.g = false;
                    }
                    if (locationClientOption.f85int >= 1000 && !this.g) {
                        if (this.f69byte == null) {
                            this.f69byte = new b();
                        }
                        this.f72do.postDelayed(this.f69byte, locationClientOption.f85int);
                        this.g = true;
                    }
                }
            } catch (Exception e) {
                j.a(f64for, "set location excpetion...");
            }
        }
        this.l = new LocationClientOption(locationClientOption);
        if (this.k == null) {
            j.a(f64for, "server not connected");
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 15);
            obtain.replyTo = this.i;
            obtain.setData(m35if());
            this.k.send(obtain);
            j.a(f64for, "change option ...");
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m40int() {
        if (!this.q || this.k == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.i;
        try {
            this.k.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.j.unbindService(this.t);
        synchronized (this.f76new) {
            try {
                if (this.g) {
                    this.f72do.removeCallbacks(this.f69byte);
                    this.g = false;
                }
            } catch (Exception e2) {
            }
        }
        this.f73else.m248if();
        this.k = null;
        j.m257int();
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m44new() {
        if (this.k == null) {
            j.a(f64for, "server not connected");
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
    public void m46try() {
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
        this.f73else.m247if((BDNotifyListener) message.obj);
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
        this.f73else.m246do((BDNotifyListener) message.obj);
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f72do.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f72do.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f72do.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f72do.obtainMessage(10);
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
            return 6;
        }
        j.a(f64for, "request location ...");
        this.f72do.obtainMessage(4).sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.f72do.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.C == null || this.C.size() < 1) {
            return 2;
        }
        this.f72do.obtainMessage(12).sendToTarget();
        return 0;
    }

    public int requestPoi() {
        if (this.k == null || this.i == null) {
            return 1;
        }
        if (this.C == null || this.C.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f71char < 6000) {
            return 6;
        }
        if (this.l.f906a >= 1) {
            j.a(f64for, "request location ...");
            this.f72do.obtainMessage(7).sendToTarget();
            return 0;
        }
        return 7;
    }

    public void setForBaiduMap(boolean z) {
        this.f75long = Boolean.valueOf(z);
        j.f241try = z;
    }

    public void setForPreImport(boolean z) {
        this.f70case = Boolean.valueOf(z);
        j.v = z;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        Message obtainMessage = this.f72do.obtainMessage(3);
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
        this.f72do.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.f72do.obtainMessage(2).sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f72do.obtainMessage(6);
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
