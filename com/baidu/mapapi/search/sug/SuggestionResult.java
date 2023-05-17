package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SuggestionResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<SuggestionResult> CREATOR = new a();
    public ArrayList<SuggestionInfo> a;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes3.dex */
    public static class SuggestionInfo implements Parcelable {
        public static final Parcelable.Creator<SuggestionInfo> CREATOR = new b();
        public int a;
        public String address;
        public String city;
        public String district;
        public String key;
        public List<PoiChildrenInfo> poiChildrenInfoList;
        public LatLng pt;
        public String tag;
        public String uid;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SuggestionInfo() {
        }

        public int getAdCode() {
            return this.a;
        }

        public String getAddress() {
            return this.address;
        }

        public String getCity() {
            return this.city;
        }

        public String getDistrict() {
            return this.district;
        }

        public String getKey() {
            return this.key;
        }

        public List<PoiChildrenInfo> getPoiChildrenInfoList() {
            return this.poiChildrenInfoList;
        }

        public LatLng getPt() {
            return this.pt;
        }

        public String getTag() {
            return this.tag;
        }

        public String getUid() {
            return this.uid;
        }

        public SuggestionInfo(Parcel parcel) {
            this.key = parcel.readString();
            this.city = parcel.readString();
            this.district = parcel.readString();
            this.pt = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.uid = parcel.readString();
            this.tag = parcel.readString();
            this.address = parcel.readString();
            this.poiChildrenInfoList = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
        }

        public void setAdCode(int i) {
            this.a = i;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setDistrict(String str) {
            this.district = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
            this.poiChildrenInfoList = list;
        }

        public void setPt(LatLng latLng) {
            this.pt = latLng;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("SuggestionInfo: ");
            stringBuffer.append("key = ");
            stringBuffer.append(this.key);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.city);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.district);
            stringBuffer.append("; pt = ");
            LatLng latLng = this.pt;
            if (latLng != null) {
                stringBuffer.append(latLng.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; uid = ");
            stringBuffer.append(this.uid);
            stringBuffer.append("; tag = ");
            stringBuffer.append(this.tag);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.address);
            stringBuffer.append("; childrenInfo = ");
            List<PoiChildrenInfo> list = this.poiChildrenInfoList;
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < this.poiChildrenInfoList.size(); i++) {
                    stringBuffer.append(" ");
                    stringBuffer.append(i);
                    stringBuffer.append(" ");
                    PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i);
                    if (poiChildrenInfo == null) {
                        stringBuffer.append(StringUtil.NULL_STRING);
                    } else {
                        stringBuffer.append(poiChildrenInfo.toString());
                    }
                }
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            return stringBuffer.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            parcel.writeString(this.city);
            parcel.writeString(this.district);
            parcel.writeParcelable(this.pt, i);
            parcel.writeString(this.uid);
            parcel.writeString(this.tag);
            parcel.writeString(this.address);
            parcel.writeTypedList(this.poiChildrenInfoList);
        }
    }

    public SuggestionResult() {
    }

    public List<SuggestionInfo> getAllSuggestions() {
        return this.a;
    }

    public SuggestionResult(Parcel parcel) {
        this.a = parcel.readArrayList(SuggestionInfo.class.getClassLoader());
    }

    public void setSuggestionInfo(ArrayList<SuggestionInfo> arrayList) {
        this.a = arrayList;
    }

    public SuggestionResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
    }
}
