package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();
    public String a;
    public int b;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShareUrlResult() {
    }

    public String getUrl() {
        return this.a;
    }

    public ShareUrlResult(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
    }
}
