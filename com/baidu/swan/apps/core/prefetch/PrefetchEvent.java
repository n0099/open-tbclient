package com.baidu.swan.apps.core.prefetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.process.SwanAppIPCData;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class PrefetchEvent extends SwanAppIPCData {
    public static final Parcelable.Creator<PrefetchEvent> CREATOR = new Parcelable.Creator<PrefetchEvent>() { // from class: com.baidu.swan.apps.core.prefetch.PrefetchEvent.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: n */
        public PrefetchEvent createFromParcel(Parcel parcel) {
            return new PrefetchEvent(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: eP */
        public PrefetchEvent[] newArray(int i) {
            return new PrefetchEvent[i];
        }
    };
    public static final String STATE_CLICK = "click";
    public static final String STATE_SHOW = "show";
    public String appConfig;
    public String appId;
    public String appPath;
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
        return "PrefetchEvent{appId='" + this.appId + "', schema='" + this.schema + "', state='" + this.state + "', appPath='" + this.appPath + "', scene='" + this.scene + "'}";
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
        hashMap.put("appId", prefetchEvent.appId);
        hashMap.put("schema", prefetchEvent.schema);
        hashMap.put("state", prefetchEvent.state);
        if (!TextUtils.isEmpty(prefetchEvent.appPath)) {
            hashMap.put("appPath", prefetchEvent.appPath);
        }
        if (!TextUtils.isEmpty(prefetchEvent.scene)) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, prefetchEvent.scene);
        }
        if (!TextUtils.isEmpty(prefetchEvent.appConfig)) {
            hashMap.put("appConfig", prefetchEvent.appConfig);
        }
        return new b(hashMap);
    }

    /* loaded from: classes11.dex */
    public static class a {
        private PrefetchEvent bPo = new PrefetchEvent();

        public a iy(@NonNull String str) {
            this.bPo.appId = str;
            return this;
        }

        public a iz(@NonNull String str) {
            this.bPo.schema = str;
            return this;
        }

        public a iA(String str) {
            this.bPo.state = str;
            return this;
        }

        public a iB(@NonNull String str) {
            this.bPo.scene = str;
            return this;
        }

        public PrefetchEvent XD() {
            return this.bPo;
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends com.baidu.swan.apps.n.a.b {
        public b(@Nullable Map<String, String> map) {
            super("prefetch", map);
        }
    }
}
