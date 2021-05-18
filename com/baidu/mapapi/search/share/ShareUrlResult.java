package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7449a;

    /* renamed from: b  reason: collision with root package name */
    public int f7450b;

    public ShareUrlResult() {
    }

    public ShareUrlResult(Parcel parcel) {
        this.f7449a = parcel.readString();
        this.f7450b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f7449a;
    }

    public void setType(int i2) {
        this.f7450b = i2;
    }

    public void setUrl(String str) {
        this.f7449a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7449a);
        parcel.writeInt(this.f7450b);
    }
}
