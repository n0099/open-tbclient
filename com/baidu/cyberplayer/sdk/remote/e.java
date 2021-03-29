package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
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
        public e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Uri f5012a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f5013b;

    public e(Uri uri, Map<String, String> map) {
        this.f5012a = uri;
        this.f5013b = map;
    }

    public e(Parcel parcel) {
        this.f5012a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f5013b = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f5013b.put(parcel.readString(), parcel.readString());
        }
    }

    public Uri a() {
        return this.f5012a;
    }

    public Map<String, String> b() {
        return this.f5013b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5012a, i);
        Map<String, String> map = this.f5013b;
        if (map == null || map.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f5013b.size());
        for (Map.Entry<String, String> entry : this.f5013b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
