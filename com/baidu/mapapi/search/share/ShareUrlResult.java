package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes7.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f2152a;
    private int b;

    public ShareUrlResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareUrlResult(Parcel parcel) {
        this.f2152a = parcel.readString();
        this.b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f2152a;
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setUrl(String str) {
        this.f2152a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2152a);
        parcel.writeInt(this.b);
    }
}
