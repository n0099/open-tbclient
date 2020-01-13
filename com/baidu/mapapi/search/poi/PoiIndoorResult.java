package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes6.dex */
public class PoiIndoorResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiIndoorResult> CREATOR = new e();
    private List<PoiIndoorInfo> a;
    public int pageNum;
    public int poiNum;

    public PoiIndoorResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiIndoorResult(Parcel parcel) {
        super(parcel);
        this.poiNum = parcel.readInt();
        this.pageNum = parcel.readInt();
    }

    public PoiIndoorResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPoiNum() {
        return this.poiNum;
    }

    public List<PoiIndoorInfo> getmArrayPoiInfo() {
        return this.a;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public void setPoiNum(int i) {
        this.poiNum = i;
    }

    public void setmArrayPoiInfo(List<PoiIndoorInfo> list) {
        this.a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.poiNum);
        parcel.writeInt(this.pageNum);
    }
}
