package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {
    private static long j = 12000;

    /* renamed from: a  reason: collision with root package name */
    public e f2639a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2640b;
    private WebView c;
    private LocationClient d;
    private a e;
    private List<b> f;
    private boolean g;
    private long h;
    private BDLocation i;
    private f k;
    private boolean l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        a(Looper looper) {
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
            } catch (Exception e) {
                return null;
            }
        }

        private void a(String str) {
            if (n.this.l) {
                n.this.e.removeCallbacks(n.this.k);
                n.this.l = false;
            }
            if (n.this.f == null || n.this.f.size() <= 0) {
                return;
            }
            Iterator it = n.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        n.this.c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception e) {
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            String str;
            boolean z;
            String str2 = null;
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (n.this.f != null) {
                        n.this.f.add(bVar);
                    }
                    if (n.this.d == null) {
                        return;
                    }
                    if (n.this.d.requestLocation() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - n.this.h;
                        if (n.this.i != null && currentTimeMillis <= 10000) {
                            Message obtainMessage = n.this.e.obtainMessage(2);
                            obtainMessage.obj = n.this.i;
                            obtainMessage.sendToTarget();
                            z = false;
                            if (z) {
                                return;
                            }
                            if (n.this.l) {
                                n.this.e.removeCallbacks(n.this.k);
                                n.this.l = false;
                            }
                            if (n.this.k == null) {
                                n.this.k = new f();
                            }
                            n.this.e.postDelayed(n.this.k, n.j);
                            n.this.l = true;
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
                    if (n.this.f == null) {
                        n.this.f = new ArrayList();
                    } else {
                        n.this.f.clear();
                    }
                    n.this.d.registerLocationListener(n.this.f2639a);
                    return;
                case 4:
                    if (n.this.f != null) {
                        n.this.f.clear();
                        n.this.f = null;
                    }
                    n.this.d.unRegisterLocationListener(n.this.f2639a);
                    n.this.h = 0L;
                    n.this.i = null;
                    if (n.this.k != null && n.this.l) {
                        n.this.e.removeCallbacks(n.this.k);
                    }
                    n.this.l = false;
                    n.this.c.removeJavascriptInterface("BaiduLocAssistant");
                    return;
                case 5:
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorcode", 0);
                        str2 = jSONObject.toString();
                    } catch (Exception e) {
                    }
                    if (str2 != null) {
                        a(str2);
                        return;
                    }
                    return;
                case 6:
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorcode", 2);
                        str = jSONObject2.toString();
                    } catch (Exception e2) {
                        str = null;
                    }
                    if (str != null) {
                        a(str);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        private String f2643b;
        private String c;
        private long d;

        b(String str) {
            this.f2643b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.has("action")) {
                    this.f2643b = jSONObject.getString("action");
                }
                if (jSONObject != null && jSONObject.has(BuyTBeanActivityConfig.CALLBACK)) {
                    this.c = jSONObject.getString(BuyTBeanActivityConfig.CALLBACK);
                }
                if (jSONObject != null && jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = n.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception e) {
                this.f2643b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.f2643b;
        }

        public String b() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private static final n f2644a = new n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !n.this.g) {
                return;
            }
            b bVar = new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || n.this.e == null) {
                return;
            }
            Message obtainMessage = n.this.e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (!n.this.g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType != 61 && locType != 161 && locType != 66) {
                n.this.e.obtainMessage(5).sendToTarget();
                return;
            }
            if (coorType != null) {
                if (coorType.equals("gcj02")) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                } else if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, BDLocation.BDLOCATION_BD09_TO_GCJ02), "gcj2wgs");
                } else if (coorType.equals("bd09ll")) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                }
            }
            n.this.h = System.currentTimeMillis();
            n.this.i = new BDLocation(bDLocation2);
            Message obtainMessage = n.this.e.obtainMessage(2);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.l = false;
            n.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private n() {
        this.f2640b = null;
        this.d = null;
        this.f2639a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public static n a() {
        return c.f2644a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.f2640b = context;
            this.c = webView;
            this.d = locationClient;
            this.e = new a(Looper.getMainLooper());
            this.e.obtainMessage(3).sendToTarget();
            webView.getSettings().setJavaScriptEnabled(true);
            a(this.c);
            this.g = true;
        }
    }

    public void b() {
        if (this.g) {
            this.e.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }
}
