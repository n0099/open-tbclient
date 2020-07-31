package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.scheme.actions.k.j;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static final Parcelable.Creator<PrefetchEvent> CREATOR = new Parcelable.Creator<PrefetchEvent>() { // from class: com.baidu.swan.apps.core.prefetch.PrefetchEvent.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: o */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            return new PrefetchEvent(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fr */
        public PrefetchEvent[] newArray(int i) {
            return new PrefetchEvent[i];
        }
    };
    private static final String EVENT_KEY_APP_CONFIG = "appConfig";
    private static final String EVENT_KEY_APP_ID = "appId";
    private static final String EVENT_KEY_APP_PATH = "appPath";
    private static final String EVENT_KEY_PAGE_URL = "pageUrl";
    private static final String EVENT_KEY_SCENE = "scene";
    private static final String EVENT_KEY_SCHEMA = "schema";
    private static final String EVENT_KEY_STATE = "state";
    public static final String STATE_CLICK = "click";
    public static final String STATE_SHOW = "show";
    public String appConfig;
    public String appId;
    public String appPath;
    public String pageUrl;
    public String scene;
    public String schema;
    public String state;

    public PrefetchEvent() {
    }

    private PrefetchEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.schema = parcel.readString();
        this.state = parcel.readString();
        this.appPath = parcel.readString();
        this.scene = parcel.readString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.schema) || !isStateValid()) ? false : true;
    }

    private boolean isStateValid() {
        return TextUtils.equals(this.state, "click") || TextUtils.equals(this.state, "show");
    }

    public String toString() {
        return "PrefetchEvent{appId='" + this.appId + "', pageUrl='" + this.pageUrl + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.schema);
        parcel.writeString(this.state);
        parcel.writeString(this.appPath);
        parcel.writeString(this.scene);
    }

    public static b d(@NonNull PrefetchEvent prefetchEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put(EVENT_KEY_APP_ID, prefetchEvent.appId);
        hashMap.put(EVENT_KEY_SCHEMA, prefetchEvent.schema);
        hashMap.put("state", prefetchEvent.state);
        if (!TextUtils.isEmpty(prefetchEvent.appPath)) {
            hashMap.put(EVENT_KEY_APP_PATH, prefetchEvent.appPath);
        }
        if (!TextUtils.isEmpty(prefetchEvent.scene)) {
            hashMap.put("scene", prefetchEvent.scene);
        }
        if (!TextUtils.isEmpty(prefetchEvent.appConfig)) {
            hashMap.put(EVENT_KEY_APP_CONFIG, prefetchEvent.appConfig);
        }
        com.baidu.swan.apps.ad.g.b.b(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            hashMap.put(EVENT_KEY_PAGE_URL, prefetchEvent.pageUrl);
            j.g(prefetchEvent.pageUrl, hashMap);
        } else if (com.baidu.swan.apps.b.DEBUG) {
            Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
        }
        com.baidu.swan.apps.ad.g.b.b(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            j.g(prefetchEvent.pageUrl, hashMap);
        }
        return new b(hashMap);
    }

    /* loaded from: classes7.dex */
    public static class a {
        private PrefetchEvent cfo = new PrefetchEvent();

        public a kd(@NonNull String str) {
            this.cfo.appId = str;
            return this;
        }

        public a ke(@NonNull String str) {
            this.cfo.schema = str;
            return this;
        }

        public a kf(String str) {
            this.cfo.state = str;
            return this;
        }

        public a kg(@NonNull String str) {
            this.cfo.scene = str;
            return this;
        }

        public PrefetchEvent acz() {
            return this.cfo;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.baidu.swan.apps.event.a.b {
        public b(@Nullable Map<String, String> map) {
            super("prefetch", map);
        }
    }
}
