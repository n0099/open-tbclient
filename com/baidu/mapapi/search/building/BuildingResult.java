package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class BuildingResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BuildingResult> CREATOR = new a();
    public List<BuildingInfo> a;
    public int b;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BuildingResult() {
    }

    public List<BuildingInfo> getBuildingList() {
        return this.a;
    }

    public int getRelation() {
        return this.b;
    }

    public BuildingResult(Parcel parcel) {
        this.a = parcel.createTypedArrayList(BuildingInfo.CREATOR);
    }

    public void setBuildingList(List<BuildingInfo> list) {
        this.a = list;
    }

    public void setRelation(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BuidingResult: ");
        List<BuildingInfo> list = this.a;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                BuildingInfo buildingInfo = this.a.get(i);
                if (buildingInfo == null) {
                    stringBuffer.append(StringUtil.NULL_STRING);
                } else {
                    stringBuffer.append(buildingInfo.toString());
                }
            }
        } else {
            stringBuffer.append(StringUtil.NULL_STRING);
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
    }
}
