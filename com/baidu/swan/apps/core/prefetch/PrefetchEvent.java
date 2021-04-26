package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppIPCData;
import d.a.h0.a.k;
import d.a.h0.a.t1.k.p0.j;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static final Parcelable.Creator<PrefetchEvent> CREATOR = new a();
    public static final String EVENT_KEY_APP_CONFIG = "appConfig";
    public static final String EVENT_KEY_APP_KEY = "appKey";
    public static final String EVENT_KEY_APP_PATH = "appPath";
    public static final String EVENT_KEY_PAGE_URL = "pageUrl";
    public static final String EVENT_KEY_SCENE = "scene";
    public static final String EVENT_KEY_SCHEMA = "schema";
    public static final String EVENT_KEY_STATE = "state";
    public static final String STATE_CLICK = "click";
    public static final String STATE_SHOW = "show";
    public String appConfig;
    public String appId;
    public String appPath;
    public String pageUrl;
    public String scene;
    public String schema;
    public String state;

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
        public PrefetchEvent f11687a = new PrefetchEvent();

        public b a(@NonNull String str) {
            this.f11687a.appId = str;
            return this;
        }

        public PrefetchEvent b() {
            return this.f11687a;
        }

        public b c(@NonNull String str) {
            this.f11687a.scene = str;
            return this;
        }

        public b d(@NonNull String str) {
            this.f11687a.schema = str;
            return this;
        }

        public b e(String str) {
            this.f11687a.state = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.h0.a.k0.b.b {
        public c(@Nullable Map<String, String> map, String str) {
            super(str, map);
        }
    }

    public /* synthetic */ PrefetchEvent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static c a(@NonNull PrefetchEvent prefetchEvent, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", prefetchEvent.appId);
        hashMap.put("schema", prefetchEvent.schema);
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
        d.a.h0.a.l1.g.b.a(hashMap, "prefetch event");
        if (!TextUtils.isEmpty(prefetchEvent.pageUrl)) {
            hashMap.put("pageUrl", prefetchEvent.pageUrl);
            j.a(prefetchEvent.pageUrl, hashMap);
        } else if (k.f43101a) {
            Log.e("PrefetchEvent", "page url is empty, it's impossible !!!");
        }
        String str = "preload";
        if (bundle != null) {
            String string = bundle.getString("swan_app_prefetch_event_name");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
        }
        return new c(hashMap, str);
    }

    public final boolean b() {
        return TextUtils.equals(this.state, STATE_CLICK) || TextUtils.equals(this.state, "show");
    }

    public boolean c() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.schema) || !b()) ? false : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PrefetchEvent{appId='" + this.appId + "', pageUrl='" + this.pageUrl + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.appId);
        parcel.writeString(this.schema);
        parcel.writeString(this.state);
        parcel.writeString(this.appPath);
        parcel.writeString(this.scene);
    }

    public PrefetchEvent() {
    }

    public PrefetchEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.schema = parcel.readString();
        this.state = parcel.readString();
        this.appPath = parcel.readString();
        this.scene = parcel.readString();
    }
}
