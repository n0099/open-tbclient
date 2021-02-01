package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
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
    private Uri f1799a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f1800b;

    public e(Uri uri, Map<String, String> map) {
        this.f1799a = uri;
        this.f1800b = map;
    }

    protected e(Parcel parcel) {
        this.f1799a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1800b = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f1800b.put(parcel.readString(), parcel.readString());
        }
    }

    public Uri a() {
        return this.f1799a;
    }

    public Map<String, String> b() {
        return this.f1800b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1799a, i);
        if (this.f1800b == null || this.f1800b.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f1800b.size());
        for (Map.Entry<String, String> entry : this.f1800b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
