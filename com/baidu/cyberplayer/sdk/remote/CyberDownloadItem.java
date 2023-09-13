package com.baidu.cyberplayer.sdk.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class CyberDownloadItem implements Parcelable {
    public static final Parcelable.Creator<CyberDownloadItem> CREATOR = new Parcelable.Creator<CyberDownloadItem>() { // from class: com.baidu.cyberplayer.sdk.remote.CyberDownloadItem.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CyberDownloadItem createFromParcel(Parcel parcel) {
            return new CyberDownloadItem(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CyberDownloadItem[] newArray(int i) {
            return new CyberDownloadItem[i];
        }
    };
    public String mExtra;
    public HashMap<String, String> mHeaders;
    public long mOffset;
    public HashMap<String, String> mOptions;
    public long mSize;
    public String mUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public long getOffset() {
        return this.mOffset;
    }

    public HashMap<String, String> getOptions() {
        return this.mOptions;
    }

    public long getSize() {
        return this.mSize;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public CyberDownloadItem(Parcel parcel) {
        this.mUrl = parcel.readString();
        this.mSize = parcel.readLong();
        this.mOffset = parcel.readLong();
        this.mHeaders = new HashMap<>();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.mHeaders.put(parcel.readString(), parcel.readString());
        }
        this.mOptions = new HashMap<>();
        int readInt2 = parcel.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.mOptions.put(parcel.readString(), parcel.readString());
        }
        this.mExtra = parcel.readString();
    }

    public CyberDownloadItem(String str, long j, long j2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str2) {
        this.mUrl = str;
        this.mSize = j;
        this.mOffset = j2;
        this.mHeaders = hashMap;
        this.mOptions = hashMap2;
        this.mExtra = str2;
    }

    public void setCustomHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHeaders == null) {
                this.mHeaders = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.mHeaders;
            hashMap.put(str.substring(0, 1).toUpperCase() + str.substring(1), str2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUrl);
        parcel.writeLong(this.mSize);
        parcel.writeLong(this.mOffset);
        HashMap<String, String> hashMap = this.mHeaders;
        if (hashMap != null && hashMap.size() > 0) {
            parcel.writeInt(this.mHeaders.size());
            for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        } else {
            parcel.writeInt(0);
        }
        HashMap<String, String> hashMap2 = this.mOptions;
        if (hashMap2 != null && hashMap2.size() > 0) {
            parcel.writeInt(this.mOptions.size());
            for (Map.Entry<String, String> entry2 : this.mOptions.entrySet()) {
                parcel.writeString(entry2.getKey());
                parcel.writeString(entry2.getValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.mExtra);
    }
}
