package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class PoiInfo implements Parcelable {
    public static final Parcelable.Creator<PoiInfo> CREATOR = new g();
    public String address;
    public String area;
    public String city;
    public int detail;
    public boolean hasCaterDetails;
    public boolean isPano;
    public LatLng location;
    public String name;
    public String phoneNum;
    public PoiDetailInfo poiDetailInfo;
    public String postCode;
    public String province;
    public String street_id;
    public POITYPE type;
    public String uid;

    /* loaded from: classes4.dex */
    public enum POITYPE {
        POINT(0),
        BUS_STATION(1),
        BUS_LINE(2),
        SUBWAY_STATION(3),
        SUBWAY_LINE(4);
        
        private int a;

        POITYPE(int i) {
            this.a = i;
        }

        public static POITYPE fromInt(int i) {
            switch (i) {
                case 0:
                    return POINT;
                case 1:
                    return BUS_STATION;
                case 2:
                    return BUS_LINE;
                case 3:
                    return SUBWAY_STATION;
                case 4:
                    return SUBWAY_LINE;
                default:
                    return null;
            }
        }

        public int getInt() {
            return this.a;
        }
    }

    public PoiInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.uid = parcel.readString();
        this.address = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.area = parcel.readString();
        this.street_id = parcel.readString();
        this.phoneNum = parcel.readString();
        this.postCode = parcel.readString();
        this.detail = ((Integer) parcel.readValue(Integer.class.getClassLoader())).intValue();
        this.type = (POITYPE) parcel.readValue(POITYPE.class.getClassLoader());
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.hasCaterDetails = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.isPano = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.poiDetailInfo = (PoiDetailInfo) parcel.readParcelable(PoiDetailInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getArea() {
        return this.area;
    }

    public String getCity() {
        return this.city;
    }

    public int getDetail() {
        return this.detail;
    }

    public LatLng getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public PoiDetailInfo getPoiDetailInfo() {
        return this.poiDetailInfo;
    }

    public String getProvince() {
        return this.province;
    }

    public String getStreetId() {
        return this.street_id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setDetail(int i) {
        this.detail = i;
    }

    public void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public void setPoiDetailInfo(PoiDetailInfo poiDetailInfo) {
        this.poiDetailInfo = poiDetailInfo;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setStreetId(String str) {
        this.street_id = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiInfo: ");
        stringBuffer.append("name = ").append(this.name);
        stringBuffer.append("; uid = ").append(this.uid);
        stringBuffer.append("; address = ").append(this.address);
        stringBuffer.append("; province = ").append(this.province);
        stringBuffer.append("; city = ").append(this.city);
        stringBuffer.append("; area = ").append(this.area);
        stringBuffer.append("; street_id = ").append(this.street_id);
        stringBuffer.append("; phoneNum = ").append(this.phoneNum);
        stringBuffer.append("; postCode = ").append(this.postCode);
        stringBuffer.append("; detail = ").append(this.detail);
        stringBuffer.append("; location = ");
        if (this.location != null) {
            stringBuffer.append(this.location.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; hasCaterDetails = ").append(this.hasCaterDetails);
        stringBuffer.append("; isPano = ").append(this.isPano);
        stringBuffer.append("; poiDetailInfo = ");
        if (this.poiDetailInfo != null) {
            stringBuffer.append(this.poiDetailInfo.toString());
        } else {
            stringBuffer.append("null");
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.uid);
        parcel.writeString(this.address);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.area);
        parcel.writeString(this.street_id);
        parcel.writeString(this.phoneNum);
        parcel.writeString(this.postCode);
        parcel.writeValue(Integer.valueOf(this.detail));
        parcel.writeValue(this.type);
        parcel.writeParcelable(this.location, 1);
        parcel.writeValue(Boolean.valueOf(this.hasCaterDetails));
        parcel.writeValue(Boolean.valueOf(this.isPano));
        parcel.writeParcelable(this.poiDetailInfo, 1);
    }
}
