package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    public static long j = 12000;

    /* renamed from: a  reason: collision with root package name */
    public e f6791a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6792b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f6793c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f6794d;

    /* renamed from: e  reason: collision with root package name */
    public a f6795e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f6796f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6797g;

    /* renamed from: h  reason: collision with root package name */
    public long f6798h;

    /* renamed from: i  reason: collision with root package name */
    public BDLocation f6799i;
    public f k;
    public boolean l;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        private void a(String str) {
            if (k.this.l) {
                k.this.f6795e.removeCallbacks(k.this.k);
                k.this.l = false;
            }
            if (k.this.f6796f == null || k.this.f6796f.size() <= 0) {
                return;
            }
            Iterator it = k.this.f6796f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        k.this.f6793c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            String str = null;
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (k.this.f6796f != null) {
                        k.this.f6796f.add(bVar);
                    }
                    if (k.this.f6794d == null) {
                        return;
                    }
                    if (k.this.f6794d.requestLocation() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - k.this.f6798h;
                        if (k.this.f6799i != null && currentTimeMillis <= 10000) {
                            Message obtainMessage = k.this.f6795e.obtainMessage(2);
                            obtainMessage.obj = k.this.f6799i;
                            obtainMessage.sendToTarget();
                            z = false;
                            if (z) {
                                return;
                            }
                            if (k.this.l) {
                                k.this.f6795e.removeCallbacks(k.this.k);
                                k.this.l = false;
                            }
                            if (k.this.k == null) {
                                k kVar = k.this;
                                kVar.k = new f();
                            }
                            k.this.f6795e.postDelayed(k.this.k, k.j);
                            k.this.l = true;
                            return;
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    break;
                case 2:
                    a(a((BDLocation) message.obj));
                    return;
                case 3:
                    if (k.this.f6796f == null) {
                        k.this.f6796f = new ArrayList();
                    } else {
                        k.this.f6796f.clear();
                    }
                    k.this.f6794d.registerLocationListener(k.this.f6791a);
                    return;
                case 4:
                    if (k.this.f6796f != null) {
                        k.this.f6796f.clear();
                        k.this.f6796f = null;
                    }
                    k.this.f6794d.unRegisterLocationListener(k.this.f6791a);
                    k.this.f6798h = 0L;
                    k.this.f6799i = null;
                    if (k.this.k != null && k.this.l) {
                        k.this.f6795e.removeCallbacks(k.this.k);
                    }
                    k.this.l = false;
                    return;
                case 5:
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorcode", 0);
                        str = jSONObject.toString();
                    } catch (Exception unused) {
                    }
                    if (str == null) {
                        return;
                    }
                    break;
                case 6:
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorcode", 2);
                        str = jSONObject2.toString();
                    } catch (Exception unused2) {
                    }
                    if (str == null) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            a(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public String f6802b;

        /* renamed from: c  reason: collision with root package name */
        public String f6803c;

        /* renamed from: d  reason: collision with root package name */
        public long f6804d;

        public b(String str) {
            this.f6802b = null;
            this.f6803c = null;
            this.f6804d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f6802b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.f6803c = jSONObject.getString("callback");
                }
                if (jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = k.j = j;
                    }
                }
                this.f6804d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f6802b = null;
                this.f6803c = null;
            }
        }

        public String a() {
            return this.f6802b;
        }

        public String b() {
            return this.f6803c;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final k f6805a = new k();
    }

    /* loaded from: classes2.dex */
    public class d {
        public d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !k.this.f6797g) {
                return;
            }
            b bVar = new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || k.this.f6795e == null) {
                return;
            }
            Message obtainMessage = k.this.f6795e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            if (!k.this.f6797g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType == 61 || locType == 161 || locType == 66) {
                if (coorType != null) {
                    if (coorType.equals("gcj02")) {
                        bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                    } else {
                        if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                            str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                        } else if (coorType.equals("bd09ll")) {
                            str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                        }
                        bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                    }
                }
                k.this.f6798h = System.currentTimeMillis();
                k.this.f6799i = new BDLocation(bDLocation2);
                obtainMessage = k.this.f6795e.obtainMessage(2);
                obtainMessage.obj = bDLocation2;
            } else {
                obtainMessage = k.this.f6795e.obtainMessage(5);
            }
            obtainMessage.sendToTarget();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.l = false;
            k.this.f6795e.obtainMessage(6).sendToTarget();
        }
    }

    public k() {
        this.f6792b = null;
        this.f6794d = null;
        this.f6791a = new e();
        this.f6795e = null;
        this.f6796f = null;
        this.f6797g = false;
        this.f6798h = 0L;
        this.f6799i = null;
        this.k = null;
        this.l = false;
    }

    public static k a() {
        return c.f6805a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.f6797g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.f6792b = context;
            this.f6793c = webView;
            this.f6794d = locationClient;
            a aVar = new a(Looper.getMainLooper());
            this.f6795e = aVar;
            aVar.obtainMessage(3).sendToTarget();
            webView.getSettings().setJavaScriptEnabled(true);
            a(this.f6793c);
            this.f6797g = true;
        }
    }

    public void b() {
        if (this.f6797g) {
            this.f6795e.obtainMessage(4).sendToTarget();
            this.f6797g = false;
        }
    }
}
