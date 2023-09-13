package com.baidu.cyberplayer.sdk.remote;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class RemoteDataSource implements Parcelable {
    public static final Parcelable.Creator<RemoteDataSource> CREATOR = new Parcelable.Creator<RemoteDataSource>() { // from class: com.baidu.cyberplayer.sdk.remote.RemoteDataSource.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteDataSource createFromParcel(Parcel parcel) {
            return new RemoteDataSource(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteDataSource[] newArray(int i) {
            return new RemoteDataSource[i];
        }
    };
    public Map<String, String> mHeaders;
    public Uri mUri;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public RemoteDataSource(Uri uri) {
        this(uri, null);
    }

    public RemoteDataSource(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
    }

    public RemoteDataSource(Parcel parcel) {
        this.mUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mHeaders = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.mHeaders.put(parcel.readString(), parcel.readString());
        }
    }

    public RemoteDataSource(String str) {
        this(Uri.parse(str), null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mUri, i);
        Map<String, String> map = this.mHeaders;
        if (map != null && map.size() > 0) {
            parcel.writeInt(this.mHeaders.size());
            for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }
}
