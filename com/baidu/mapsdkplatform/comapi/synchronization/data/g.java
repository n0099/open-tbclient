package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2263a = g.class.getSimpleName();
    private RoleOptions b;
    private DisplayOptions c;
    private BlockingQueue<SyncResponseResult> d;
    private i e;
    private String f;
    private String g;
    private com.baidu.mapsdkplatform.comapi.synchronization.c.a h;
    private HandlerThread i;
    private b j;
    private volatile int k;
    private k l;
    private boolean m;
    private float n;
    private long o;
    private int p;

    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f2264a = new g(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100000:
                    SyncResponseResult b = g.this.b((String) message.obj);
                    if (b == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f2263a, "parser response data is null");
                        return;
                    }
                    g.this.a(b);
                    g.this.j();
                    g.this.b(b);
                    return;
                case 100001:
                    g.this.k();
                    return;
                default:
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f2263a, "Undefined message type");
                    return;
            }
        }
    }

    private g() {
        this.d = new LinkedBlockingQueue();
        this.f = String.valueOf(0);
        this.g = String.valueOf(0);
        this.h = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.k = 0;
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.p = 0;
    }

    /* synthetic */ g(h hVar) {
        this();
    }

    private f a(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "RoleOptions is null");
            return null;
        }
        f fVar = new f();
        fVar.a(this.b.getOrderId());
        fVar.b(this.b.getDriverId());
        fVar.c(this.b.getUserId());
        fVar.a(i);
        if (this.m) {
            this.f = String.valueOf(0);
            this.g = String.valueOf(0);
        }
        fVar.d(this.f);
        fVar.e(this.g);
        return fVar;
    }

    public static g a() {
        return a.f2264a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SyncResponseResult syncResponseResult) {
        if (this.d == null) {
            this.d = new LinkedBlockingQueue();
        }
        if (this.m) {
            this.m = false;
            this.d.clear();
        }
        try {
            this.d.put(syncResponseResult);
        } catch (InterruptedException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "InterruptedException happened when put item into queue", e);
            Thread.currentThread().interrupt();
        }
    }

    private void a(String str) {
        if (this.h == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "HttpClient cannot be null");
        } else {
            this.h.a(str, new h(this));
        }
    }

    private void a(String str, SyncResponseResult syncResponseResult) {
        LatLng latLng;
        LatLng latLng2 = null;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "There's no section route data");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Section start position latlng invalid: " + split[0]);
            return;
        }
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get startPosition failed", e);
            latLng = null;
        }
        int i = 1;
        while (i < split.length) {
            RouteLineInfo.RouteSectionInfo routeSectionInfo = new RouteLineInfo.RouteSectionInfo();
            routeSectionInfo.a(latLng);
            String[] split3 = split[i].split(",");
            if (2 != split3.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Section position latlng invalid: " + split[i]);
            } else {
                try {
                    latLng = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                } catch (NumberFormatException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get endPosition failed", e2);
                    latLng = latLng2;
                }
                routeSectionInfo.b(latLng);
                syncResponseResult.a().a(routeSectionInfo);
                latLng2 = latLng;
            }
            i++;
            latLng = latLng;
        }
    }

    private void a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        LatLng latLng;
        double d;
        int i;
        double d2 = 0.0d;
        JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
        if (optJSONObject == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Invalid driver position data");
            return;
        }
        syncResponseResult.c().setTimeStamp(optJSONObject.optString("t"));
        String optString = optJSONObject.optString("p");
        if (optString == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "No position info data");
            return;
        }
        String[] split = optString.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Position info array is empty");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Position latlng invalid");
            return;
        }
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get driver position failed", e);
            latLng = null;
        }
        syncResponseResult.c().setPoint(latLng);
        try {
            d = Double.valueOf(split[1]).doubleValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get angle failed", e2);
            d = 0.0d;
        }
        syncResponseResult.c().setAngle(d);
        try {
            d2 = Double.valueOf(split[2]).doubleValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get speed failed", e3);
        }
        syncResponseResult.c().setSpeed(d2);
        try {
            i = Integer.valueOf(split[3]).intValue();
        } catch (NumberFormatException e4) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get orderStateInPosition failed", e4);
            i = 0;
        }
        syncResponseResult.c().setOrderStateInPosition(i);
    }

    private void a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        JSONObject optJSONObject = jSONObject.optJSONObject("route");
        if (optJSONObject != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "parser route data");
            b(optJSONObject, syncResponseResult);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("traffic");
        if (optJSONObject2 != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "parser traffic data");
            c(optJSONObject2, syncResponseResult);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("positions");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "parser driver position data");
            a(optJSONArray, syncResponseResult);
        }
        String optString = jSONObject.optString("run");
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "parser travelled distance and elapsed time data");
            c(optString, syncResponseResult);
        }
        String optString2 = jSONObject.optString("remain");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "parser remain distance and estimated time data");
            d(optString2, syncResponseResult);
        }
        syncResponseResult.a(jSONObject.optInt("s"));
        syncResponseResult.a(jSONObject.optString("mtime"));
        syncResponseResult.b(jSONObject.optString("ext"));
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("status")) {
            if (this.l != null) {
                this.l.c(2003, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED);
                return false;
            }
            return false;
        }
        int optInt = jSONObject.optInt("status");
        String optString = jSONObject.optString("message");
        if (optInt == 0) {
            if (this.l != null) {
                this.l.b(optInt, optString);
            }
            return true;
        } else if (this.l != null) {
            this.l.c(optInt, optString);
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(g gVar) {
        int i = gVar.k;
        gVar.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SyncResponseResult b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Response result is null");
            return null;
        }
        SyncResponseResult syncResponseResult = new SyncResponseResult();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "JSONException happened when parser");
            syncResponseResult = null;
        }
        if (!a(jSONObject)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Response result is invalid");
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null || optJSONObject.length() <= 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "No route and traffic and driver data");
            return null;
        }
        a(optJSONObject, syncResponseResult);
        return syncResponseResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SyncResponseResult syncResponseResult) {
        float d = syncResponseResult.d();
        long e = syncResponseResult.e();
        if (1 == this.p || 2 == this.p || 4 == this.p) {
            if (this.p != 1 && this.m) {
                this.n = 0.0f;
                this.o = 0L;
                e = 0;
                d = 0.0f;
            }
            if (0.0f != d) {
                this.n = d;
            }
            if (0 != e) {
                this.o = e;
            }
        } else {
            this.n = 0.0f;
            this.o = 0L;
        }
        if (this.l != null) {
            this.l.a(this.n, this.o);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[LOOP:1: B:19:0x0069->B:21:0x006d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str, SyncResponseResult syncResponseResult) {
        int i;
        int i2;
        int i3;
        int i4;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "There's no section traffic data");
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str2 : split) {
            String[] split2 = str2.split(",");
            if (3 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "section traffic data is invalid: " + str2);
            } else {
                try {
                    i2 = Integer.valueOf(split2[0]).intValue();
                    try {
                        i = Integer.valueOf(split2[1]).intValue();
                        try {
                            i3 = Integer.valueOf(split2[2]).intValue();
                        } catch (NumberFormatException e) {
                            e = e;
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get traffic status info failed", e);
                            i3 = 0;
                            while (i4 < i2 + i) {
                            }
                            syncResponseResult.b().a(arrayList);
                        }
                    } catch (NumberFormatException e2) {
                        e = e2;
                        i = 0;
                    }
                } catch (NumberFormatException e3) {
                    e = e3;
                    i = 0;
                    i2 = 0;
                }
                for (i4 = i2; i4 < i2 + i; i4++) {
                    arrayList.add(Integer.valueOf(i3));
                }
                syncResponseResult.b().a(arrayList);
            }
        }
    }

    private void b(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.a().a(jSONObject.optInt("c") != 0);
        this.f = jSONObject.optString("f");
        syncResponseResult.a().a(this.f);
        String optString = jSONObject.optString("d");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        a(optString, syncResponseResult);
    }

    private void c(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "The travelled data is null or invalid");
            return;
        }
        float f = 0.0f;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get travelledDistance failed", e);
        }
        syncResponseResult.a(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get elapsedTime failed", e2);
        }
        syncResponseResult.a(j);
    }

    private void c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.b().a(jSONObject.optInt("c") != 0);
        this.g = jSONObject.optString("f");
        syncResponseResult.b().a(this.g);
        String optString = jSONObject.optString("d");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        b(optString, syncResponseResult);
    }

    private void d(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "The remain data is null or invalid: ");
            return;
        }
        float f = 0.0f;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get remainDistance failed", e);
        }
        syncResponseResult.b(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f2263a, "Get estimatedTime failed", e2);
        }
        syncResponseResult.b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.e != null) {
            this.e.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        this.m = z;
        this.p = i;
        f a2 = a(i);
        if (a2 == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "Data request option is null");
            return;
        }
        String a3 = new m(a2).a();
        if (a3 == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f2263a, "send url string is null");
        } else {
            a(a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(View view) {
        if (this.c != null) {
            this.c.setStartPositionInfoWindowView(view);
        } else if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(DisplayOptions displayOptions) {
        this.c = displayOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(RoleOptions roleOptions) {
        this.b = roleOptions;
    }

    public void a(i iVar) {
        this.e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        this.l = kVar;
    }

    public void b() {
        this.i = new HandlerThread("SyncDataStorage");
        this.i.start();
        this.j = new b(this.i.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(View view) {
        if (this.c != null) {
            this.c.setEndPositionInfoWindowView(view);
        } else if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    public void c() {
        if (this.e != null) {
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(View view) {
        if (this.c != null) {
            this.c.setCarInfoWindowView(view);
        } else if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.k;
    }

    public RoleOptions e() {
        return this.b;
    }

    public DisplayOptions f() {
        return this.c;
    }

    public BlockingQueue<SyncResponseResult> g() {
        return this.d;
    }

    public void h() {
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.j.removeCallbacksAndMessages(null);
        this.i.quit();
    }
}
