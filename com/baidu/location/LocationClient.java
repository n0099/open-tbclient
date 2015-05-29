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
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class LocationClient implements a0, n {
    private static final int j1 = 1000;
    private static final int j5 = 3;
    private static final int j6 = 8;
    private static final int j9 = 9;
    private static final int jS = 10;
    private static final String jU = "baidu_location_Client";
    private static final int jX = 1;
    private static final int kb = 7;
    private static final int ki = 5;
    private static final int kj = 12;
    private static final int kl = 6;
    private static final int km = 2;
    private static final int kv = 11;
    private static final int ky = 4;
    private ab j0;
    private boolean kc;
    private Context ke;
    private LocationClientOption kh;
    private String kr;
    private long ko = 0;
    private String kx = null;
    private boolean kn = false;
    private Messenger kf = null;
    private a jT = new a();
    private final Messenger kd = new Messenger(this.jT);
    private ArrayList kz = null;
    private BDLocation ku = null;
    private boolean j8 = false;
    private boolean ks = false;
    private boolean ka = false;
    private b jY = null;
    private boolean jR = false;
    private final Object jV = new Object();
    private long kg = 0;
    private long kp = 0;
    private boolean kt = false;
    private BDLocationListener j7 = null;
    private String kw = null;
    private boolean j4 = false;
    private Boolean j3 = false;
    private Boolean jZ = false;
    private Boolean kk = true;
    private ServiceConnection kq = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationClient.this.kf = new Messenger(iBinder);
            if (LocationClient.this.kf == null) {
                return;
            }
            LocationClient.this.kn = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = LocationClient.this.kd;
                obtain.setData(LocationClient.this.cL());
                LocationClient.this.kf.send(obtain);
                LocationClient.this.kn = true;
                if (LocationClient.this.kh != null) {
                    if (LocationClient.this.kk.booleanValue()) {
                    }
                    LocationClient.this.jT.obtainMessage(4).sendToTarget();
                }
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LocationClient.this.kf = null;
            LocationClient.this.kn = false;
        }
    };
    private long j2 = 0;
    private BDErrorReport jW = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    LocationClient.this.cM();
                    return;
                case 2:
                    LocationClient.this.cN();
                    return;
                case 3:
                    LocationClient.this.n(message);
                    return;
                case 4:
                    LocationClient.this.o(message);
                    return;
                case 5:
                    LocationClient.this.r(message);
                    return;
                case 6:
                    LocationClient.this.m(message);
                    return;
                case 7:
                    return;
                case 8:
                    LocationClient.this.s(message);
                    return;
                case 9:
                    LocationClient.this.l(message);
                    return;
                case 10:
                    LocationClient.this.q(message);
                    return;
                case 11:
                    LocationClient.this.cO();
                    return;
                case 12:
                    LocationClient.this.cP();
                    return;
                case 21:
                    LocationClient.this.m41if(message, 21);
                    return;
                case 26:
                    LocationClient.this.m41if(message, 26);
                    return;
                case 27:
                    LocationClient.this.p(message);
                    return;
                case a0.A /* 54 */:
                    if (LocationClient.this.kh.f21goto) {
                        LocationClient.this.jR = true;
                        return;
                    }
                    return;
                case 55:
                    if (LocationClient.this.kh.f21goto) {
                        LocationClient.this.jR = false;
                        return;
                    }
                    return;
                case a0.b /* 204 */:
                    LocationClient.this.m36goto(false);
                    return;
                case a0.P /* 205 */:
                    LocationClient.this.m36goto(true);
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
            synchronized (LocationClient.this.jV) {
                LocationClient.this.ka = false;
                if (LocationClient.this.kf == null || LocationClient.this.kd == null) {
                    return;
                }
                if (LocationClient.this.kz == null || LocationClient.this.kz.size() < 1) {
                    return;
                }
                LocationClient.this.jT.obtainMessage(4).sendToTarget();
            }
        }
    }

    public LocationClient(Context context) {
        this.kh = new LocationClientOption();
        this.ke = null;
        this.j0 = null;
        this.ke = context;
        this.kh = new LocationClientOption();
        this.j0 = new ab(this.ke, this);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.kh = new LocationClientOption();
        this.ke = null;
        this.j0 = null;
        this.ke = context;
        this.kh = locationClientOption;
        this.j0 = new ab(this.ke, this);
    }

    private Bundle cK() {
        if (this.kh == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("num", this.kh.f24long);
        bundle.putFloat("distance", this.kh.c);
        bundle.putBoolean("extraInfo", this.kh.e);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle cL() {
        if (this.kh == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.kx);
        bundle.putString("prodName", this.kh.f22if);
        bundle.putString("coorType", this.kh.f18do);
        bundle.putString("addrType", this.kh.f19else);
        bundle.putBoolean("openGPS", this.kh.f20for);
        bundle.putBoolean("location_change_notify", this.kh.f21goto);
        bundle.putInt("scanSpan", this.kh.f23int);
        bundle.putInt("timeOut", this.kh.d);
        bundle.putInt("priority", this.kh.h);
        bundle.putBoolean("map", this.j3.booleanValue());
        bundle.putBoolean("import", this.jZ.booleanValue());
        bundle.putBoolean("needDirect", this.kh.g);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        if (this.kn) {
            return;
        }
        c.m263else();
        this.kx = this.ke.getPackageName();
        this.kw = this.kx + "_bdls_v2.9";
        Intent intent = new Intent(this.ke, f.class);
        try {
            intent.putExtra("debug_dev", this.kc);
        } catch (Exception e) {
        }
        if (this.kh == null) {
            this.kh = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.kh.b);
        intent.putExtra("kill_process", this.kh.f17char);
        try {
            this.ke.bindService(intent, this.kq, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.kn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN() {
        if (!this.kn || this.kf == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.kd;
        try {
            this.kf.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.ke.unbindService(this.kq);
        } catch (Exception e2) {
        }
        synchronized (this.jV) {
            try {
                if (this.ka) {
                    this.jT.removeCallbacks(this.jY);
                    this.ka = false;
                }
            } catch (Exception e3) {
            }
        }
        this.j0.bm();
        this.kf = null;
        c.m258char();
        this.j4 = false;
        this.kn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO() {
        if (this.kf == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.kd;
            this.kf.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.kd;
            this.kf.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: else  reason: not valid java name */
    private void m31else(int i) {
        if (this.j8 || ((this.kh.f21goto && this.ku.getLocType() == 61) || this.ku.getLocType() == 66 || this.ku.getLocType() == 67 || this.j4)) {
            Iterator it = this.kz.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onReceiveLocation(this.ku);
            }
            if (this.ku.getLocType() == 66 || this.ku.getLocType() == 67) {
                return;
            }
            this.j8 = false;
            this.kp = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public void m36goto(boolean z) {
        if (this.jW != null) {
            this.jW.onReportResult(z);
        }
        this.jW = null;
        this.j2 = 0L;
    }

    /* renamed from: goto  reason: not valid java name */
    private boolean m37goto(int i) {
        if (this.kf == null || !this.kn) {
            return false;
        }
        try {
            this.kf.send(Message.obtain((Handler) null, i));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m41if(Message message, int i) {
        Bundle data = message.getData();
        data.setClassLoader(BDLocation.class.getClassLoader());
        this.ku = (BDLocation) data.getParcelable("locStr");
        if (this.ku.getLocType() == 61) {
            this.kg = System.currentTimeMillis();
        }
        m31else(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.j0.m126do((BDNotifyListener) message.obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.kz == null || !this.kz.contains(bDLocationListener)) {
            return;
        }
        this.kz.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message.obj;
        if (this.kh.equals(locationClientOption)) {
            return;
        }
        if (this.kh.f23int != locationClientOption.f23int) {
            try {
                synchronized (this.jV) {
                    if (this.ka) {
                        this.jT.removeCallbacks(this.jY);
                        this.ka = false;
                    }
                    if (locationClientOption.f23int >= 1000 && !this.ka) {
                        if (this.jY == null) {
                            this.jY = new b();
                        }
                        this.jT.postDelayed(this.jY, locationClientOption.f23int);
                        this.ka = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        this.kh = new LocationClientOption(locationClientOption);
        if (this.kf != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.kd;
                obtain.setData(cL());
                this.kf.send(obtain);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Message message) {
        if (this.kf == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.kg > 3000 || !this.kh.f21goto) && (!this.j4 || System.currentTimeMillis() - this.kp > 20000)) {
            Message obtain = Message.obtain((Handler) null, 22);
            try {
                obtain.replyTo = this.kd;
                obtain.arg1 = message.arg1;
                this.kf.send(obtain);
                this.ko = System.currentTimeMillis();
                this.j8 = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.jV) {
            if (this.kh != null && this.kh.f23int >= 1000 && !this.ka) {
                if (this.jY == null) {
                    this.jY = new b();
                }
                this.jT.postDelayed(this.jY, this.kh.f23int);
                this.ka = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Message message) {
        Bundle data = message.getData();
        data.setClassLoader(BDLocation.class.getClassLoader());
        BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
        if (this.j7 != null) {
            if (this.kh != null && this.kh.a() && bDLocation.getLocType() == 65) {
                return;
            }
            this.j7.onReceiveLocation(bDLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.j0.m127for((BDNotifyListener) message.obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
        if (this.kz == null) {
            this.kz = new ArrayList();
        }
        this.kz.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Message message) {
        if (message == null || message.obj == null) {
            return;
        }
        this.j7 = (BDLocationListener) message.obj;
    }

    public void cancleError() {
        m37goto(a0.f37long);
    }

    public String getAccessKey() {
        try {
            this.kr = w.a(this.ke);
            if (TextUtils.isEmpty(this.kr)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s;SHA1=%s", this.kr, w.m362if(this.ke));
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.ku;
    }

    public LocationClientOption getLocOption() {
        return this.kh;
    }

    public String getVersion() {
        return n.U;
    }

    public boolean isStarted() {
        return this.kn;
    }

    public boolean notifyError() {
        return m37goto(a0.t);
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.jT.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.jT.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.jT.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.jT.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int reportErrorWithInfo(BDErrorReport bDErrorReport) {
        if (this.kf == null || !this.kn) {
            return 1;
        }
        if (bDErrorReport == null) {
            return 2;
        }
        if (System.currentTimeMillis() - this.j2 >= 50000 || this.jW == null) {
            Bundle errorInfo = bDErrorReport.getErrorInfo();
            if (errorInfo == null) {
                return 3;
            }
            try {
                Message obtain = Message.obtain((Handler) null, (int) a0.f35if);
                obtain.replyTo = this.kd;
                obtain.setData(errorInfo);
                this.kf.send(obtain);
                this.jW = bDErrorReport;
                this.j2 = System.currentTimeMillis();
                return 0;
            } catch (Exception e) {
                return 1;
            }
        }
        return 4;
    }

    public int requestLocation() {
        if (this.kf == null || this.kd == null) {
            return 1;
        }
        if (this.kz == null || this.kz.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.ko < 1000) {
            return 6;
        }
        Message obtainMessage = this.jT.obtainMessage(4);
        obtainMessage.arg1 = 1;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.jT.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.kf == null || this.kd == null) {
            return 1;
        }
        if (this.kz == null || this.kz.size() < 1) {
            return 2;
        }
        this.jT.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void setDebug(boolean z) {
        this.kc = z;
    }

    public void setForBaiduMap(boolean z) {
        this.j3 = Boolean.valueOf(z);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption != null) {
            switch (locationClientOption.h) {
                case 1:
                    if (locationClientOption.f23int != 0 && locationClientOption.f23int < 1000) {
                        Log.w(a0.i, String.format("scanSpan time %d less than 1 second, location services may not star", Integer.valueOf(locationClientOption.f23int)));
                        break;
                    }
                    break;
                case 2:
                    if (locationClientOption.f23int > 1000 && locationClientOption.f23int < 3000) {
                        locationClientOption.f23int = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                        Log.w(a0.i, String.format("scanSpan time %d less than 3 second, location services may not star", Integer.valueOf(locationClientOption.f23int)));
                        break;
                    }
                    break;
                case 3:
                    if (locationClientOption.f23int != 0 && locationClientOption.f23int < 1000) {
                        Log.w(a0.i, String.format("scanSpan time %d less than 1 second, location services may not star", Integer.valueOf(locationClientOption.f23int)));
                        break;
                    } else if (locationClientOption.f23int == 0) {
                        locationClientOption.f23int = 1000;
                        break;
                    }
                    break;
            }
        } else {
            locationClientOption = new LocationClientOption();
        }
        Message obtainMessage = this.jT.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.jT.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        cN();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.jT.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.kf == null || this.kd == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.kf.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
