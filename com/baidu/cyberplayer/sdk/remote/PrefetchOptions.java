package com.baidu.cyberplayer.sdk.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class PrefetchOptions implements Parcelable {
    public static final Parcelable.Creator<PrefetchOptions> CREATOR = new Parcelable.Creator<PrefetchOptions>() { // from class: com.baidu.cyberplayer.sdk.remote.PrefetchOptions.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrefetchOptions[] newArray(int i) {
            return new PrefetchOptions[0];
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrefetchOptions createFromParcel(Parcel parcel) {
            return new PrefetchOptions(parcel);
        }
    };
    public Map<String, String> options = new HashMap();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PrefetchOptions() {
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public PrefetchOptions(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.options = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void setOption(String str, int i) {
        if (str == null) {
            return;
        }
        if (this.options == null) {
            this.options = new HashMap();
        }
        this.options.put(str, String.valueOf(i));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.options);
    }

    public void setOption(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.options == null) {
                this.options = new HashMap();
            }
            this.options.put(str, str2);
        }
    }
}
