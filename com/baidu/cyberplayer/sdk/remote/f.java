package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.baidu.cyberplayer.sdk.remote.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    };
    public Uri a;
    public Map<String, String> b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri a() {
        return this.a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public f(Uri uri, Map<String, String> map) {
        this.a = uri;
        this.b = map;
    }

    public f(Parcel parcel) {
        this.a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.b = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.b.put(parcel.readString(), parcel.readString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        Map<String, String> map = this.b;
        if (map != null && map.size() > 0) {
            parcel.writeInt(this.b.size());
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }
}
