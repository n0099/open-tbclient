package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.scheme.actions.k.j;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static final Parcelable.Creator<PrefetchEvent> CREATOR = new Parcelable.Creator<PrefetchEvent>() { // from class: com.baidu.swan.apps.core.prefetch.PrefetchEvent.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: q */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            return new PrefetchEvent(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gX */
        public PrefetchEvent[] newArray(int i) {
            return new PrefetchEvent[i];
        }
    };
    private static final String EVENT_KEY_APP_CONFIG = "appConfig";
    private static final String EVENT_KEY_APP_KEY = "appKey";
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

    public static b a(@NonNull PrefetchEvent prefetchEvent, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", prefetchEvent.appId);
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
        com.baidu.swan.apps.ac.g.b.c(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            hashMap.put(EVENT_KEY_PAGE_URL, prefetchEvent.pageUrl);
            j.f(prefetchEvent.pageUrl, hashMap);
        } else if (com.baidu.swan.apps.b.DEBUG) {
            Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
        }
        String str = "preload";
        if (bundle != null) {
            str = bundle.getString("swan_app_prefetch_event_name");
            if (TextUtils.isEmpty(str)) {
                str = "preload";
            }
        }
        return new b(hashMap, str);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private PrefetchEvent cTL = new PrefetchEvent();

        public a mE(@NonNull String str) {
            this.cTL.appId = str;
            return this;
        }

        public a mF(@NonNull String str) {
            this.cTL.schema = str;
            return this;
        }

        public a mG(String str) {
            this.cTL.state = str;
            return this;
        }

        public a mH(@NonNull String str) {
            this.cTL.scene = str;
            return this;
        }

        public PrefetchEvent aqL() {
            return this.cTL;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.baidu.swan.apps.event.a.b {
        b(@Nullable Map<String, String> map, String str) {
            super(str, map);
        }
    }
}
