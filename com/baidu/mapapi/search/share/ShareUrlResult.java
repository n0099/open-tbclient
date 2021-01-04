package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes15.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f3054a;

    /* renamed from: b  reason: collision with root package name */
    private int f3055b;

    public ShareUrlResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareUrlResult(Parcel parcel) {
        this.f3054a = parcel.readString();
        this.f3055b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f3054a;
    }

    public void setType(int i) {
        this.f3055b = i;
    }

    public void setUrl(String str) {
        this.f3054a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3054a);
        parcel.writeInt(this.f3055b);
    }
}
