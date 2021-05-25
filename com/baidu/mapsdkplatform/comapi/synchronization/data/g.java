package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7817a = "g";

    /* renamed from: b  reason: collision with root package name */
    public RoleOptions f7818b;

    /* renamed from: c  reason: collision with root package name */
    public DisplayOptions f7819c;

    /* renamed from: d  reason: collision with root package name */
    public BlockingQueue<SyncResponseResult> f7820d;

    /* renamed from: e  reason: collision with root package name */
    public i f7821e;

    /* renamed from: f  reason: collision with root package name */
    public String f7822f;

    /* renamed from: g  reason: collision with root package name */
    public String f7823g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.c.a f7824h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f7825i;
    public b j;
    public volatile int k;
    public k l;
    public boolean m;
    public float n;
    public long o;
    public int p;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f7826a = new g(null);
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100000:
                    SyncResponseResult b2 = g.this.b((String) message.obj);
                    if (b2 == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f7817a, "parser response data is null");
                        return;
                    }
                    g.this.a(b2);
                    g.this.j();
                    g.this.b(b2);
                    return;
                case CustomerServiceMenu.TRANSFER_RECORD /* 100001 */:
                    g.this.k();
                    return;
                default:
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f7817a, "Undefined message type");
                    return;
            }
        }
    }

    public g() {
        this.f7820d = new LinkedBlockingQueue();
        this.f7822f = String.valueOf(0);
        this.f7823g = String.valueOf(0);
        this.f7824h = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.k = 0;
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.p = 0;
    }

    public /* synthetic */ g(h hVar) {
        this();
    }

    private f a(int i2) {
        if (this.f7818b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "RoleOptions is null");
            return null;
        }
        f fVar = new f();
        fVar.a(this.f7818b.getOrderId());
        fVar.b(this.f7818b.getDriverId());
        fVar.c(this.f7818b.getUserId());
        fVar.a(i2);
        if (this.m) {
            this.f7822f = String.valueOf(0);
            this.f7823g = String.valueOf(0);
        }
        fVar.d(this.f7822f);
        fVar.e(this.f7823g);
        return fVar;
    }

    public static g a() {
        return a.f7826a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SyncResponseResult syncResponseResult) {
        if (this.f7820d == null) {
            this.f7820d = new LinkedBlockingQueue();
        }
        if (this.m) {
            this.m = false;
            this.f7820d.clear();
        }
        try {
            this.f7820d.put(syncResponseResult);
        } catch (InterruptedException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "InterruptedException happened when put item into queue", e2);
            Thread.currentThread().interrupt();
        }
    }

    private void a(String str) {
        com.baidu.mapsdkplatform.comapi.synchronization.c.a aVar = this.f7824h;
        if (aVar == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "HttpClient cannot be null");
        } else {
            aVar.a(str, new h(this));
        }
    }

    private void a(String str, SyncResponseResult syncResponseResult) {
        LatLng latLng;
        String[] split = str.split(";");
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "There's no section route data");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Section start position latlng invalid: " + split[0]);
            return;
        }
        LatLng latLng2 = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get startPosition failed", e2);
            latLng = null;
        }
        for (int i2 = 1; i2 < split.length; i2++) {
            RouteLineInfo.RouteSectionInfo routeSectionInfo = new RouteLineInfo.RouteSectionInfo();
            routeSectionInfo.a(latLng);
            String[] split3 = split[i2].split(",");
            if (2 != split3.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Section position latlng invalid: " + split[i2]);
            } else {
                try {
                    latLng2 = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                } catch (NumberFormatException e3) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get endPosition failed", e3);
                }
                routeSectionInfo.b(latLng2);
                syncResponseResult.a().a(routeSectionInfo);
                latLng = latLng2;
            }
        }
    }

    private void a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        double d2;
        JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
        if (optJSONObject == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Invalid driver position data");
            return;
        }
        syncResponseResult.c().setTimeStamp(optJSONObject.optString("t"));
        String optString = optJSONObject.optString("p");
        if (optString == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "No position info data");
            return;
        }
        String[] split = optString.split(";");
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Position info array is empty");
            return;
        }
        int i2 = 0;
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Position latlng invalid");
            return;
        }
        LatLng latLng = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get driver position failed", e2);
        }
        syncResponseResult.c().setPoint(latLng);
        double d3 = 0.0d;
        try {
            d2 = Double.valueOf(split[1]).doubleValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get angle failed", e3);
            d2 = 0.0d;
        }
        syncResponseResult.c().setAngle(d2);
        try {
            d3 = Double.valueOf(split[2]).doubleValue();
        } catch (NumberFormatException e4) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get speed failed", e4);
        }
        syncResponseResult.c().setSpeed(d3);
        try {
            i2 = Integer.valueOf(split[3]).intValue();
        } catch (NumberFormatException e5) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get orderStateInPosition failed", e5);
        }
        syncResponseResult.c().setOrderStateInPosition(i2);
    }

    private void a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
        if (optJSONObject != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "parser route data");
            b(optJSONObject, syncResponseResult);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("traffic");
        if (optJSONObject2 != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "parser traffic data");
            c(optJSONObject2, syncResponseResult);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("positions");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            this.l.c(2004, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_DRIVER_POSITION_FAILED);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "parser driver position data");
            a(optJSONArray, syncResponseResult);
        }
        String optString = jSONObject.optString("run");
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "parser travelled distance and elapsed time data");
            c(optString, syncResponseResult);
        }
        String optString2 = jSONObject.optString("remain");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "parser remain distance and estimated time data");
            d(optString2, syncResponseResult);
        }
        syncResponseResult.a(jSONObject.optInt("s"));
        syncResponseResult.a(jSONObject.optString("mtime"));
        syncResponseResult.b(jSONObject.optString("ext"));
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("status")) {
            k kVar = this.l;
            if (kVar != null) {
                kVar.c(2003, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED);
            }
            return false;
        }
        int optInt = jSONObject.optInt("status");
        String optString = jSONObject.optString("message");
        if (optInt != 0) {
            k kVar2 = this.l;
            if (kVar2 != null) {
                kVar2.c(optInt, optString);
            }
            return false;
        }
        k kVar3 = this.l;
        if (kVar3 != null) {
            kVar3.b(optInt, optString);
            return true;
        }
        return true;
    }

    public static /* synthetic */ int b(g gVar) {
        int i2 = gVar.k;
        gVar.k = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SyncResponseResult b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Response result is null");
            return null;
        }
        SyncResponseResult syncResponseResult = new SyncResponseResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!a(jSONObject)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "Response result is invalid");
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                a(optJSONObject, syncResponseResult);
                return syncResponseResult;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "No route and traffic and driver data");
            return null;
        } catch (JSONException unused) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "JSONException happened when parser");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SyncResponseResult syncResponseResult) {
        float d2 = syncResponseResult.d();
        long e2 = syncResponseResult.e();
        int i2 = this.p;
        if (1 == i2 || 2 == i2 || 4 == i2) {
            if (this.p != 1 && this.m) {
                this.n = 0.0f;
                this.o = 0L;
                e2 = 0;
                d2 = 0.0f;
            }
            if (0.0f != d2) {
                this.n = d2;
            }
            if (0 != e2) {
                this.o = e2;
            }
        } else {
            this.n = 0.0f;
            this.o = 0L;
        }
        k kVar = this.l;
        if (kVar != null) {
            kVar.a(this.n, this.o);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[LOOP:1: B:26:0x0070->B:28:0x0074, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str, SyncResponseResult syncResponseResult) {
        int i2;
        int i3;
        int i4;
        int i5;
        String[] split = str.split(";");
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "There's no section traffic data");
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str2 : split) {
            String[] split2 = str2.split(",");
            if (3 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "section traffic data is invalid: " + str2);
            } else {
                try {
                    i2 = Integer.valueOf(split2[0]).intValue();
                    try {
                        i3 = Integer.valueOf(split2[1]).intValue();
                    } catch (NumberFormatException e2) {
                        e = e2;
                        i3 = 0;
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get traffic status info failed", e);
                        i4 = 0;
                        while (i5 < i2 + i3) {
                        }
                        syncResponseResult.b().a(arrayList);
                    }
                } catch (NumberFormatException e3) {
                    e = e3;
                    i2 = 0;
                }
                try {
                    i4 = Integer.valueOf(split2[2]).intValue();
                } catch (NumberFormatException e4) {
                    e = e4;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get traffic status info failed", e);
                    i4 = 0;
                    while (i5 < i2 + i3) {
                    }
                    syncResponseResult.b().a(arrayList);
                }
                for (i5 = i2; i5 < i2 + i3; i5++) {
                    arrayList.add(Integer.valueOf(i4));
                }
                syncResponseResult.b().a(arrayList);
            }
        }
    }

    private void b(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.a().a(jSONObject.optInt("c") != 0);
        this.f7822f = jSONObject.optString("f");
        syncResponseResult.a().a(this.f7822f);
        String optString = jSONObject.optString("d");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        a(optString, syncResponseResult);
    }

    private void c(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "The travelled data is null or invalid");
            return;
        }
        float f2 = 0.0f;
        try {
            f2 = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get travelledDistance failed", e2);
        }
        syncResponseResult.a(f2);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get elapsedTime failed", e3);
        }
        syncResponseResult.a(j);
    }

    private void c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.b().a(jSONObject.optInt("c") != 0);
        this.f7823g = jSONObject.optString("f");
        syncResponseResult.b().a(this.f7823g);
        String optString = jSONObject.optString("d");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        b(optString, syncResponseResult);
    }

    private void d(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7817a, "The remain data is null or invalid: ");
            return;
        }
        float f2 = 0.0f;
        try {
            f2 = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get remainDistance failed", e2);
        }
        syncResponseResult.b(f2);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7817a, "Get estimatedTime failed", e3);
        }
        syncResponseResult.b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        i iVar = this.f7821e;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        i iVar = this.f7821e;
        if (iVar != null) {
            iVar.b();
        }
    }

    public void a(int i2, boolean z) {
        String str;
        String str2;
        this.m = z;
        this.p = i2;
        f a2 = a(i2);
        if (a2 == null) {
            str = f7817a;
            str2 = "Data request option is null";
        } else {
            String a3 = new m(a2).a();
            if (a3 != null) {
                a(a3);
                return;
            } else {
                str = f7817a;
                str2 = "send url string is null";
            }
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
    }

    public synchronized void a(View view) {
        if (this.f7819c != null) {
            this.f7819c.setStartPositionInfoWindowView(view);
            return;
        }
        if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    public synchronized void a(DisplayOptions displayOptions) {
        this.f7819c = displayOptions;
    }

    public synchronized void a(RoleOptions roleOptions) {
        this.f7818b = roleOptions;
    }

    public void a(i iVar) {
        this.f7821e = iVar;
    }

    public void a(k kVar) {
        this.l = kVar;
    }

    public void b() {
        HandlerThread handlerThread = new HandlerThread("SyncDataStorage");
        this.f7825i = handlerThread;
        handlerThread.start();
        this.j = new b(this.f7825i.getLooper());
    }

    public synchronized void b(View view) {
        if (this.f7819c != null) {
            this.f7819c.setEndPositionInfoWindowView(view);
            return;
        }
        if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    public void c() {
        if (this.f7821e != null) {
            this.f7821e = null;
        }
    }

    public synchronized void c(View view) {
        if (this.f7819c != null) {
            this.f7819c.setCarInfoWindowView(view);
            return;
        }
        if (this.l != null) {
            this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    public int d() {
        return this.k;
    }

    public RoleOptions e() {
        return this.f7818b;
    }

    public DisplayOptions f() {
        return this.f7819c;
    }

    public BlockingQueue<SyncResponseResult> g() {
        return this.f7820d;
    }

    public void h() {
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.j.removeCallbacksAndMessages(null);
        this.f7825i.quit();
    }
}
