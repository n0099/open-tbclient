package com.baidu.location.a;

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
/* loaded from: classes6.dex */
public class k {
    private static long j = 12000;

    /* renamed from: a  reason: collision with root package name */
    public e f2562a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2563b;
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
    /* loaded from: classes6.dex */
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
            if (k.this.l) {
                k.this.e.removeCallbacks(k.this.k);
                k.this.l = false;
            }
            if (k.this.f == null || k.this.f.size() <= 0) {
                return;
            }
            Iterator it = k.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        k.this.c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
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
                    if (k.this.f != null) {
                        k.this.f.add(bVar);
                    }
                    if (k.this.d == null) {
                        return;
                    }
                    if (k.this.d.requestLocation() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - k.this.h;
                        if (k.this.i != null && currentTimeMillis <= 10000) {
                            Message obtainMessage = k.this.e.obtainMessage(2);
                            obtainMessage.obj = k.this.i;
                            obtainMessage.sendToTarget();
                            z = false;
                            if (z) {
                                return;
                            }
                            if (k.this.l) {
                                k.this.e.removeCallbacks(k.this.k);
                                k.this.l = false;
                            }
                            if (k.this.k == null) {
                                k.this.k = new f();
                            }
                            k.this.e.postDelayed(k.this.k, k.j);
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
                    if (k.this.f == null) {
                        k.this.f = new ArrayList();
                    } else {
                        k.this.f.clear();
                    }
                    k.this.d.registerLocationListener(k.this.f2562a);
                    return;
                case 4:
                    if (k.this.f != null) {
                        k.this.f.clear();
                        k.this.f = null;
                    }
                    k.this.d.unRegisterLocationListener(k.this.f2562a);
                    k.this.h = 0L;
                    k.this.i = null;
                    if (k.this.k != null && k.this.l) {
                        k.this.e.removeCallbacks(k.this.k);
                    }
                    k.this.l = false;
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
    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        private String f2566b;
        private String c;
        private long d;

        b(String str) {
            this.f2566b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.has("action")) {
                    this.f2566b = jSONObject.getString("action");
                }
                if (jSONObject != null && jSONObject.has(BuyTBeanActivityConfig.CALLBACK)) {
                    this.c = jSONObject.getString(BuyTBeanActivityConfig.CALLBACK);
                }
                if (jSONObject != null && jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = k.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception e) {
                this.f2566b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.f2566b;
        }

        public String b() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private static final k f2567a = new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !k.this.g) {
                return;
            }
            b bVar = new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || k.this.e == null) {
                return;
            }
            Message obtainMessage = k.this.e.obtainMessage(1);
            obtainMessage.obj = bVar;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BDAbstractLocationListener {
        public e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (!k.this.g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType != 61 && locType != 161 && locType != 66) {
                k.this.e.obtainMessage(5).sendToTarget();
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
            k.this.h = System.currentTimeMillis();
            k.this.i = new BDLocation(bDLocation2);
            Message obtainMessage = k.this.e.obtainMessage(2);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.l = false;
            k.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private k() {
        this.f2563b = null;
        this.d = null;
        this.f2562a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public static k a() {
        return c.f2567a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.f2563b = context;
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
