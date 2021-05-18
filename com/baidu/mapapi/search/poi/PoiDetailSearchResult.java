package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public List<PoiDetailInfo> f7322a;

    public PoiDetailSearchResult() {
    }

    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f7322a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f7322a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f7322a = list;
    }

    public String toString() {
        List<PoiDetailInfo> list = this.f7322a;
        if (list == null || list.isEmpty()) {
            return "PoiDetailSearchResult is null";
        }
        StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
        for (int i2 = 0; i2 < this.f7322a.size(); i2++) {
            stringBuffer.append(" ");
            stringBuffer.append(i2);
            stringBuffer.append(" ");
            PoiDetailInfo poiDetailInfo = this.f7322a.get(i2);
            stringBuffer.append(poiDetailInfo != null ? poiDetailInfo.toString() : StringUtil.NULL_STRING);
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.f7322a);
    }
}
