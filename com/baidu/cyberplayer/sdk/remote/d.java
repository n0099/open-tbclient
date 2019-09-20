package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.baidu.cyberplayer.sdk.remote.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    private Uri a;
    private Map<String, String> b;

    public d(Uri uri, Map<String, String> map) {
        this.a = uri;
        this.b = map;
    }

    protected d(Parcel parcel) {
        this.a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.b = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.b.put(parcel.readString(), parcel.readString());
        }
    }

    public Uri a() {
        return this.a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        if (this.b == null || this.b.size() <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.b.size());
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
