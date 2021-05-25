package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.baidu.cyberplayer.sdk.remote.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public e[] newArray(int i2) {
            return new e[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Uri f4928a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f4929b;

    public e(Uri uri, Map<String, String> map) {
        this.f4928a = uri;
        this.f4929b = map;
    }

    public e(Parcel parcel) {
        this.f4928a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4929b = new HashMap();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f4929b.put(parcel.readString(), parcel.readString());
        }
    }

    public Uri a() {
        return this.f4928a;
    }

    public Map<String, String> b() {
        return this.f4929b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f4928a, i2);
        Map<String, String> map = this.f4929b;
        if (map == null || map.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f4929b.size());
        for (Map.Entry<String, String> entry : this.f4929b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
