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
    public List<PoiDetailInfo> a;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PoiDetailSearchResult() {
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.a;
    }

    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.a = list;
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public String toString() {
        List<PoiDetailInfo> list = this.a;
        if (list != null && !list.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
            for (int i = 0; i < this.a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                PoiDetailInfo poiDetailInfo = this.a.get(i);
                if (poiDetailInfo != null) {
                    stringBuffer.append(poiDetailInfo.toString());
                } else {
                    stringBuffer.append(StringUtil.NULL_STRING);
                }
            }
            return stringBuffer.toString();
        }
        return "PoiDetailSearchResult is null";
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
