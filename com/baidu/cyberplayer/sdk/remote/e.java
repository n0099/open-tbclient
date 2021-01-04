package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
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
    private Uri f1850a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f1851b;

    public e(Uri uri, Map<String, String> map) {
        this.f1850a = uri;
        this.f1851b = map;
    }

    protected e(Parcel parcel) {
        this.f1850a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1851b = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f1851b.put(parcel.readString(), parcel.readString());
        }
    }

    public Uri a() {
        return this.f1850a;
    }

    public Map<String, String> b() {
        return this.f1851b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1850a, i);
        if (this.f1851b == null || this.f1851b.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.f1851b.size());
        for (Map.Entry<String, String> entry : this.f1851b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
