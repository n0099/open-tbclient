package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes7.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private List<PoiDetailInfo> f2120a;

    public PoiDetailSearchResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f2120a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f2120a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f2120a = list;
    }

    public String toString() {
        if (this.f2120a == null || this.f2120a.isEmpty()) {
            return "PoiDetailSearchResult is null";
        }
        StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2120a.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append(" ").append(i2).append(" ");
            PoiDetailInfo poiDetailInfo = this.f2120a.get(i2);
            if (poiDetailInfo != null) {
                stringBuffer.append(poiDetailInfo.toString());
            } else {
                stringBuffer.append("null");
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f2120a);
    }
}
