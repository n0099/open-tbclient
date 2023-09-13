package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bi2;
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
import com.baidu.tieba.f73;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hb3;
import com.baidu.tieba.hf2;
import com.baidu.tieba.il2;
import com.baidu.tieba.m43;
import com.baidu.tieba.rr1;
import com.baidu.tieba.se3;
import com.baidu.tieba.uw2;
import com.baidu.tieba.vh2;
import com.baidu.tieba.ze3;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
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
    public static final String EVENT_USER_ACTION_APIS = "userActionApis";
    public static final String KEY_CLICK_PREFETCH = "click_prefetch";
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
    public String userActionApis;
    public String version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public PrefetchEvent a = new PrefetchEvent();

        public PrefetchEvent b() {
            return this.a;
        }

        public b a(@NonNull String str) {
            this.a.appId = str;
            return this;
        }

        public b c(@NonNull String str) {
            this.a.scene = str;
            return this;
        }

        public b d(@NonNull String str) {
            this.a.schema = str;
            return this;
        }

        public b e(String str) {
            this.a.state = str;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends il2 {
        public c(@Nullable Map<String, String> map, String str) {
            super(str, map);
        }

        public Map<String, String> t() {
            return this.c;
        }

        public boolean u() {
            return TextUtils.equals(this.a, PrefetchEvent.MODULE);
        }

        @NonNull
        public String toString() {
            Map<String, String> map = this.c;
            if (map != null && map.size() > 0) {
                StringBuilder sb = new StringBuilder();
                Set<Map.Entry<String, String>> entrySet = this.c.entrySet();
                int size = entrySet.size();
                int i = 0;
                for (Map.Entry<String, String> entry : entrySet) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    i++;
                    if (i < size) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            return "";
        }
    }

    public PrefetchEvent() {
    }

    private boolean isStateValid() {
        if (!TextUtils.equals(this.state, "click") && !TextUtils.equals(this.state, "show")) {
            return false;
        }
        return true;
    }

    public static void recordClickPrefetchEvent() {
        HybridUbcFlow p = m43.p("startup");
        if (p != null) {
            p.F(new UbcFlowEvent(KEY_CLICK_PREFETCH));
        }
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.schema) && isStateValid()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
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
        public PrefetchEvent[] newArray(int i) {
            return new PrefetchEvent[i];
        }
    }

    public PrefetchEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.schema = parcel.readString();
        this.state = parcel.readString();
        this.scene = parcel.readString();
    }

    public /* synthetic */ PrefetchEvent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static c createMessage(@NonNull PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        String str;
        if (hf2.n(pMSAppInfo)) {
            str = MODULE;
        } else {
            str = "preload";
        }
        return createMessage(prefetchEvent, str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.schema);
        parcel.writeString(this.state);
        parcel.writeString(this.scene);
    }

    public static c createFromAppReadyEvent(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        ew2.a W = gb3.K().q().W();
        if (!hf2.a(W.f0())) {
            return null;
        }
        recordClickPrefetchEvent();
        HashMap hashMap = new HashMap(map);
        hashMap.put("appKey", W.H());
        hashMap.put("schema", W.W());
        hashMap.put("state", "click");
        hashMap.put("scene", SCENE_FROM_APP_READY);
        hashMap.put("version", W.v1());
        hashMap.remove(EVENT_DATA_WEBVIEW_ID);
        hashMap.remove(EVENT_DATA_EXTRA_DATA);
        hashMap.remove(EVENT_DATA_SHOW_PERFORMANCE_PANEL);
        hashMap.remove(EVENT_DATA_DEBUG_PRELOAD);
        return new c(hashMap, MODULE);
    }

    public static c createFromReLaunch(String str) {
        hb3 b0;
        if (!TextUtils.equals(str, "relaunch") || (b0 = hb3.b0()) == null) {
            return null;
        }
        PMSAppInfo f0 = b0.W().f0();
        if (!hf2.a(f0)) {
            return null;
        }
        recordClickPrefetchEvent();
        PrefetchEvent prefetchEvent = new PrefetchEvent();
        prefetchEvent.appId = b0.getAppId();
        prefetchEvent.state = "click";
        prefetchEvent.scene = str;
        prefetchEvent.schema = b0.W().W();
        prefetchEvent.pageUrl = se3.d(uw2.T(), b0.W(), b0.Q());
        prefetchEvent.appConfig = b0.Q().n;
        prefetchEvent.appPath = du2.e.i(b0.getAppId(), b0.k0()).getPath() + File.separator;
        prefetchEvent.pageType = b0.Q().h(prefetchEvent.pageUrl);
        prefetchEvent.rootPath = vh2.c(b0, prefetchEvent.pageUrl);
        prefetchEvent.isT7Available = bi2.U().p0();
        prefetchEvent.sConsole = String.valueOf(b0.W().m0());
        prefetchEvent.version = b0.k0();
        if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
            prefetchEvent.userActionApis = f0.userActionApis;
        }
        return createMessage(prefetchEvent, MODULE);
    }

    public static c createMessage(@NonNull PrefetchEvent prefetchEvent, String str) {
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
            hashMap.put("root", prefetchEvent.rootPath);
        }
        if (!TextUtils.isEmpty(prefetchEvent.pageType)) {
            hashMap.put("pageType", prefetchEvent.pageType);
        }
        if (!TextUtils.isEmpty(prefetchEvent.sConsole)) {
            hashMap.put(EVENT_DATA_DEBUG_SCONSOLE, prefetchEvent.sConsole);
        }
        hashMap.put(EVENT_DATA_T7_AVAILABLE, String.valueOf(prefetchEvent.isT7Available));
        f73.a(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            hashMap.put(EVENT_KEY_PAGE_URL, prefetchEvent.pageUrl);
            ze3.a(prefetchEvent.pageUrl, hashMap);
        } else if (rr1.a) {
            Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
        }
        if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
            hashMap.put(EVENT_USER_ACTION_APIS, prefetchEvent.userActionApis);
        }
        return new c(hashMap, str);
    }

    public String toString() {
        return "PrefetchEvent{appId='" + this.appId + "', pageUrl='" + this.pageUrl + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
    }
}
