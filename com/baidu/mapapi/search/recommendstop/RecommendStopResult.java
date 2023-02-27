package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendStopResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();
    public List<RecommendStopInfo> a;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RecommendStopResult() {
    }

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.a;
    }

    public RecommendStopResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(RecommendStopInfo.CREATOR);
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.a = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecommendStopResult: ");
        List<RecommendStopInfo> list = this.a;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                RecommendStopInfo recommendStopInfo = this.a.get(i);
                if (recommendStopInfo == null) {
                    stringBuffer.append(StringUtil.NULL_STRING);
                } else {
                    stringBuffer.append(recommendStopInfo.toString());
                }
            }
        } else {
            stringBuffer.append(StringUtil.NULL_STRING);
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
