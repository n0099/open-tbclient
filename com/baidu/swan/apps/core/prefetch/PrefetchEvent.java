package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static final boolean COMBINE_PREFETCH_ON = true;
    public static final Parcelable.Creator<PrefetchEvent> CREATOR = new a();
    public static final String EVENT_DATA_DEBUG_PRELOAD = "masterPreload";
    public static final String EVENT_DATA_DEBUG_SCONSOLE = "devhook";
    public static final String EVENT_DATA_EXTRA_DATA = "extraData";
    public static final String EVENT_DATA_PAGE_TYPE = "pageType";
    public static final String EVENT_DATA_ROOT_PATH = "root";
    public static final String EVENT_DATA_SHOW_PERFORMANCE_PANEL = "showPerformancePanel";
    public static final String EVENT_DATA_T7_AVAILABLE = "isT7Available";
    public static final String EVENT_DATA_WEBVIEW_ID = "wvID";
    public static final String EVENT_KEY_APP_CONFIG = "appConfig";
    public static final String EVENT_KEY_APP_KEY = "appKey";
    public static final String EVENT_KEY_APP_PATH = "appPath";
    public static final String EVENT_KEY_PAGE_URL = "pageUrl";
    public static final String EVENT_KEY_SCENE = "scene";
    public static final String EVENT_KEY_SCHEMA = "schema";
    public static final String EVENT_KEY_STATE = "state";
    public static final String EVENT_KEY_VERSION = "version";
    public static final String MODULE = "prefetch";
    public static final String SCENE_FROM_APP_READY = "fromAppReady";
    public static final String STATE_CLICK = "click";
    public static final String STATE_SHOW = "show";
    public String appConfig;
    public String appId;
    public String appPath;
    public boolean isT7Available;
    public String pageType;
    public String pageUrl;
    public String rootPath;
    public String sConsole;
    public String scene;
    public String schema;
    public String state;
    public String version;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<PrefetchEvent> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            return new PrefetchEvent(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PrefetchEvent[] newArray(int i2) {
            return new PrefetchEvent[i2];
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public PrefetchEvent f10737a = new PrefetchEvent();

        public b a(@NonNull String str) {
            this.f10737a.appId = str;
            return this;
        }

        public PrefetchEvent b() {
            return this.f10737a;
        }

        public b c(@NonNull String str) {
            this.f10737a.scene = str;
            return this;
        }

        public b d(@NonNull String str) {
            this.f10737a.schema = str;
            return this;
        }

        public b e(String str) {
            this.f10737a.state = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.l0.a.o0.d.b {
        public c(@Nullable Map<String, String> map, String str) {
            super(str, map);
        }

        public Map<String, String> h() {
            return this.f43912c;
        }

        public boolean i() {
            return TextUtils.equals(this.f43905a, PrefetchEvent.MODULE);
        }

        @NonNull
        public String toString() {
            Map<String, String> map = this.f43912c;
            if (map == null || map.size() <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Set<Map.Entry<String, String>> entrySet = this.f43912c.entrySet();
            int size = entrySet.size();
            int i2 = 0;
            for (Map.Entry<String, String> entry : entrySet) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                i2++;
                if (i2 < size) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    public /* synthetic */ PrefetchEvent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static c a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        b.a L = d.g().r().L();
        if (d.a.l0.a.h0.o.e.a.k(L.f0()) && d.a.l0.a.h0.o.e.a.a()) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("appKey", L.H());
            hashMap.put("schema", L.W());
            hashMap.put("state", STATE_CLICK);
            hashMap.put("scene", SCENE_FROM_APP_READY);
            hashMap.remove(EVENT_DATA_WEBVIEW_ID);
            hashMap.remove(EVENT_DATA_EXTRA_DATA);
            hashMap.remove(EVENT_DATA_SHOW_PERFORMANCE_PANEL);
            hashMap.remove(EVENT_DATA_T7_AVAILABLE);
            hashMap.remove(EVENT_DATA_DEBUG_PRELOAD);
            return new c(hashMap, MODULE);
        }
        return null;
    }

    public static c b(String str) {
        e Q;
        if (TextUtils.equals(str, "relaunch") && (Q = e.Q()) != null && d.a.l0.a.h0.o.e.a.k(Q.L().f0()) && d.a.l0.a.h0.o.e.a.a()) {
            PrefetchEvent prefetchEvent = new PrefetchEvent();
            prefetchEvent.appId = Q.getAppId();
            prefetchEvent.state = STATE_CLICK;
            prefetchEvent.scene = str;
            prefetchEvent.schema = Q.L().W();
            prefetchEvent.pageUrl = d.a.l0.a.c2.f.p0.c.c(f.V(), Q.L(), Q.F());
            prefetchEvent.appConfig = Q.F().m;
            prefetchEvent.appPath = e.C0561e.i(Q.getAppId(), Q.Z()).getPath() + File.separator;
            prefetchEvent.pageType = Q.F().g(prefetchEvent.pageUrl);
            prefetchEvent.rootPath = d.a.l0.a.h0.u.a.c(Q, prefetchEvent.pageUrl);
            prefetchEvent.isT7Available = g.N().f0();
            prefetchEvent.sConsole = String.valueOf(Q.L().l0());
            return d(prefetchEvent, MODULE);
        }
        return null;
    }

    public static c c(@NonNull PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        return d(prefetchEvent, d.a.l0.a.h0.o.e.a.k(pMSAppInfo) ? MODULE : "preload");
    }

    public static c d(@NonNull PrefetchEvent prefetchEvent, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", prefetchEvent.appId);
        hashMap.put("schema", prefetchEvent.schema);
        hashMap.put("state", prefetchEvent.state);
        hashMap.put("version", prefetchEvent.version);
        if (!TextUtils.isEmpty(prefetchEvent.scene)) {
            hashMap.put("scene", prefetchEvent.scene);
        }
        if (!TextUtils.isEmpty(prefetchEvent.appPath)) {
            hashMap.put(EVENT_KEY_APP_PATH, prefetchEvent.appPath);
        }
        if (!TextUtils.isEmpty(prefetchEvent.appConfig)) {
            hashMap.put(EVENT_KEY_APP_CONFIG, prefetchEvent.appConfig);
        }
        if (!TextUtils.isEmpty(prefetchEvent.rootPath)) {
            hashMap.put(EVENT_DATA_ROOT_PATH, prefetchEvent.rootPath);
        }
        if (!TextUtils.isEmpty(prefetchEvent.pageType)) {
            hashMap.put("pageType", prefetchEvent.pageType);
        }
        if (!TextUtils.isEmpty(prefetchEvent.sConsole)) {
            hashMap.put(EVENT_DATA_DEBUG_SCONSOLE, prefetchEvent.sConsole);
        }
        hashMap.put(EVENT_DATA_T7_AVAILABLE, String.valueOf(prefetchEvent.isT7Available));
        d.a.l0.a.t1.g.b.a(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            hashMap.put("pageUrl", prefetchEvent.pageUrl);
            j.a(prefetchEvent.pageUrl, hashMap);
        } else if (k.f43199a) {
            Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
        }
        return new c(hashMap, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return TextUtils.equals(this.state, STATE_CLICK) || TextUtils.equals(this.state, "show");
    }

    public boolean f() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.schema) || !e()) ? false : true;
    }

    public String toString() {
        return "PrefetchEvent{appId='" + this.appId + "', pageUrl='" + this.pageUrl + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.appId);
        parcel.writeString(this.schema);
        parcel.writeString(this.state);
        parcel.writeString(this.scene);
    }

    public PrefetchEvent() {
    }

    public PrefetchEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.schema = parcel.readString();
        this.state = parcel.readString();
        this.scene = parcel.readString();
    }
}
