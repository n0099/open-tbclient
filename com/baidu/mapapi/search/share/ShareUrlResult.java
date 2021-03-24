package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7334a;

    /* renamed from: b  reason: collision with root package name */
    public int f7335b;

    public ShareUrlResult() {
    }

    public ShareUrlResult(Parcel parcel) {
        this.f7334a = parcel.readString();
        this.f7335b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f7334a;
    }

    public void setType(int i) {
        this.f7335b = i;
    }

    public void setUrl(String str) {
        this.f7334a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7334a);
        parcel.writeInt(this.f7335b);
    }
}
