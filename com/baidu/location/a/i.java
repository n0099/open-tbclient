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
import com.tencent.tauth.AuthActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    private static long j = 12000;
    private BDLocation Yl;
    private LocationClient Zd;
    public e Ze;
    private a Zf;
    private f Zg;
    private Context b;
    private WebView c;
    private List<b> f;
    private boolean g;
    private long h;
    private boolean l;

    /* loaded from: classes2.dex */
    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        private void a(String str) {
            if (i.this.l) {
                i.this.Zf.removeCallbacks(i.this.Zg);
                i.this.l = false;
            }
            if (i.this.f == null || i.this.f.size() <= 0) {
                return;
            }
            Iterator it = i.this.f.iterator();
            while (it.hasNext()) {
                try {
                    b bVar = (b) it.next();
                    if (bVar.b() != null) {
                        i.this.c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception e) {
                    return;
                }
            }
        }

        private String d(BDLocation bDLocation) {
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
                    if (i.this.f != null) {
                        i.this.f.add(bVar);
                    }
                    if (i.this.Zd == null) {
                        return;
                    }
                    if (i.this.Zd.requestLocation() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - i.this.h;
                        if (i.this.Yl != null && currentTimeMillis <= 10000) {
                            Message obtainMessage = i.this.Zf.obtainMessage(2);
                            obtainMessage.obj = i.this.Yl;
                            obtainMessage.sendToTarget();
                            z = false;
                            if (z) {
                                return;
                            }
                            if (i.this.l) {
                                i.this.Zf.removeCallbacks(i.this.Zg);
                                i.this.l = false;
                            }
                            if (i.this.Zg == null) {
                                i.this.Zg = new f();
                            }
                            i.this.Zf.postDelayed(i.this.Zg, i.j);
                            i.this.l = true;
                            return;
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    break;
                case 2:
                    a(d((BDLocation) message.obj));
                    return;
                case 3:
                    if (i.this.f == null) {
                        i.this.f = new ArrayList();
                    } else {
                        i.this.f.clear();
                    }
                    i.this.Zd.registerLocationListener(i.this.Ze);
                    return;
                case 4:
                    if (i.this.f != null) {
                        i.this.f.clear();
                        i.this.f = null;
                    }
                    i.this.Zd.unRegisterLocationListener(i.this.Ze);
                    i.this.h = 0L;
                    i.this.Yl = null;
                    if (i.this.Zg != null && i.this.l) {
                        i.this.Zf.removeCallbacks(i.this.Zg);
                    }
                    i.this.l = false;
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
    /* loaded from: classes2.dex */
    public class b {
        private String b;
        private String c;
        private long d;

        b(String str) {
            this.b = null;
            this.c = null;
            this.d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.has(AuthActivity.ACTION_KEY)) {
                    this.b = jSONObject.getString(AuthActivity.ACTION_KEY);
                }
                if (jSONObject != null && jSONObject.has("callback")) {
                    this.c = jSONObject.getString("callback");
                }
                if (jSONObject != null && jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = i.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception e) {
                this.b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* loaded from: classes2.dex */
    private static final class c {
        private static final i Zh = new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !i.this.g) {
                return;
            }
            b bVar = new b(str);
            if (bVar.a() == null || !bVar.a().equals("requestLoc") || i.this.Zf == null) {
                return;
            }
            Message obtainMessage = i.this.Zf.obtainMessage(1);
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
            if (!i.this.g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType != 61 && locType != 161 && locType != 66) {
                i.this.Zf.obtainMessage(5).sendToTarget();
                return;
            }
            if (coorType != null) {
                if (coorType.equals("gcj02")) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                } else if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, BDLocation.BDLOCATION_BD09_TO_GCJ02), "gcj2wgs");
                } else if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL)) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                }
            }
            i.this.h = System.currentTimeMillis();
            i.this.Yl = new BDLocation(bDLocation2);
            Message obtainMessage = i.this.Zf.obtainMessage(2);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.l = false;
            i.this.Zf.obtainMessage(6).sendToTarget();
        }
    }

    private i() {
        this.b = null;
        this.Zd = null;
        this.Ze = new e();
        this.Zf = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.Yl = null;
        this.Zg = null;
        this.l = false;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public static i rw() {
        return c.Zh;
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            this.b = context;
            this.c = webView;
            this.Zd = locationClient;
            this.Zf = new a(Looper.getMainLooper());
            this.Zf.obtainMessage(3).sendToTarget();
            webView.getSettings().setJavaScriptEnabled(true);
            a(this.c);
            this.g = true;
        }
    }

    public void b() {
        if (this.g) {
            this.Zf.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }
}
