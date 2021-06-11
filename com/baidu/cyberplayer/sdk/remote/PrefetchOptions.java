package com.baidu.cyberplayer.sdk.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class PrefetchOptions implements Parcelable {
    public static final Parcelable.Creator<PrefetchOptions> CREATOR = new Parcelable.Creator<PrefetchOptions>() { // from class: com.baidu.cyberplayer.sdk.remote.PrefetchOptions.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrefetchOptions createFromParcel(Parcel parcel) {
            return new PrefetchOptions(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrefetchOptions[] newArray(int i2) {
            return new PrefetchOptions[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f4935a = new HashMap();

    public PrefetchOptions() {
    }

    public PrefetchOptions(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getOptions() {
        return this.f4935a;
    }

    public void readFromParcel(Parcel parcel) {
        this.f4935a = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void setOption(String str, int i2) {
        if (str == null) {
            return;
        }
        if (this.f4935a == null) {
            this.f4935a = new HashMap();
        }
        this.f4935a.put(str, String.valueOf(i2));
    }

    public void setOption(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.f4935a == null) {
            this.f4935a = new HashMap();
        }
        this.f4935a.put(str, str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.f4935a);
    }
}
