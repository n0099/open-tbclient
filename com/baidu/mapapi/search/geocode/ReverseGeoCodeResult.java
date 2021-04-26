package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public String f7493a;

    /* renamed from: b  reason: collision with root package name */
    public String f7494b;

    /* renamed from: c  reason: collision with root package name */
    public AddressComponent f7495c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7496d;

    /* renamed from: e  reason: collision with root package name */
    public int f7497e;

    /* renamed from: f  reason: collision with root package name */
    public List<PoiInfo> f7498f;

    /* renamed from: g  reason: collision with root package name */
    public String f7499g;

    /* renamed from: h  reason: collision with root package name */
    public List<PoiRegionsInfo> f7500h;

    /* loaded from: classes2.dex */
    public static class AddressComponent implements Parcelable {
        public static final Parcelable.Creator<AddressComponent> CREATOR = new c();
        public int adcode;
        public String city;
        public int countryCode;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;

        public AddressComponent() {
        }

        public AddressComponent(Parcel parcel) {
            this.streetNumber = parcel.readString();
            this.street = parcel.readString();
            this.town = parcel.readString();
            this.district = parcel.readString();
            this.city = parcel.readString();
            this.province = parcel.readString();
            this.countryName = parcel.readString();
            this.countryCode = parcel.readInt();
            this.adcode = parcel.readInt();
            this.direction = parcel.readString();
            this.distance = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirection() {
            return this.direction;
        }

        public String getDistance() {
            return this.distance;
        }

        public String getTown() {
            return this.town;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public void setDistance(String str) {
            this.distance = str;
        }

        public void setTown(String str) {
            this.town = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.streetNumber);
            parcel.writeString(this.street);
            parcel.writeString(this.town);
            parcel.writeString(this.district);
            parcel.writeString(this.city);
            parcel.writeString(this.province);
            parcel.writeString(this.countryName);
            parcel.writeInt(this.countryCode);
            parcel.writeInt(this.adcode);
            parcel.writeString(this.direction);
            parcel.writeString(this.distance);
        }
    }

    /* loaded from: classes2.dex */
    public static class PoiRegionsInfo implements Parcelable {
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new d();
        public String directionDesc;
        public String regionName;
        public String regionTag;

        public PoiRegionsInfo() {
        }

        public PoiRegionsInfo(Parcel parcel) {
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDirectionDesc() {
            return this.directionDesc;
        }

        public String getRegionName() {
            return this.regionName;
        }

        public String getRegionTag() {
            return this.regionTag;
        }

        public void setDirectionDesc(String str) {
            this.directionDesc = str;
        }

        public void setRegionName(String str) {
            this.regionName = str;
        }

        public void setRegionTag(String str) {
            this.regionTag = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.directionDesc);
            parcel.writeString(this.regionName);
            parcel.writeString(this.regionTag);
        }
    }

    public ReverseGeoCodeResult() {
    }

    public ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        this.f7493a = parcel.readString();
        this.f7494b = parcel.readString();
        this.f7495c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.f7496d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7498f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7499g = parcel.readString();
        this.f7500h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.f7495c.adcode;
    }

    public String getAddress() {
        return this.f7494b;
    }

    public AddressComponent getAddressDetail() {
        return this.f7495c;
    }

    public String getBusinessCircle() {
        return this.f7493a;
    }

    public int getCityCode() {
        return this.f7497e;
    }

    public LatLng getLocation() {
        return this.f7496d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f7498f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.f7500h;
    }

    public String getSematicDescription() {
        return this.f7499g;
    }

    public void setAdcode(int i2) {
        this.f7495c.adcode = i2;
    }

    public void setAddress(String str) {
        this.f7494b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.f7495c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.f7493a = str;
    }

    public void setCityCode(int i2) {
        this.f7497e = i2;
    }

    public void setLocation(LatLng latLng) {
        this.f7496d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f7498f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.f7500h = list;
    }

    public void setSematicDescription(String str) {
        this.f7499g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
        stringBuffer.append("businessCircle = ");
        stringBuffer.append(this.f7493a);
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f7494b);
        stringBuffer.append("; location = ");
        stringBuffer.append(this.f7496d);
        stringBuffer.append("; sematicDescription = ");
        stringBuffer.append(this.f7499g);
        if (this.f7495c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
            stringBuffer.append("streetNumber = ");
            stringBuffer.append(this.f7495c.streetNumber);
            stringBuffer.append("; street = ");
            stringBuffer.append(this.f7495c.street);
            stringBuffer.append("; town = ");
            stringBuffer.append(this.f7495c.town);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.f7495c.district);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.f7495c.city);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.f7495c.province);
            stringBuffer.append("; countryName = ");
            stringBuffer.append(this.f7495c.countryName);
            stringBuffer.append("; countryCode = ");
            stringBuffer.append(this.f7495c.countryCode);
            stringBuffer.append("; adcode = ");
            stringBuffer.append(this.f7495c.adcode);
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.f7495c.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.f7495c.distance);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        List<PoiRegionsInfo> list = this.f7500h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i2 = 0; i2 < this.f7500h.size(); i2++) {
                PoiRegionsInfo poiRegionsInfo = this.f7500h.get(i2);
                if (poiRegionsInfo != null) {
                    stringBuffer.append("\ndirectionDesc = ");
                    stringBuffer.append(poiRegionsInfo.getDirectionDesc());
                    stringBuffer.append("; regionName = ");
                    stringBuffer.append(poiRegionsInfo.getRegionName());
                    stringBuffer.append("; regionTag = ");
                    stringBuffer.append(poiRegionsInfo.getRegionTag());
                }
            }
            stringBuffer.append("\n#PoiRegions Info  END# \n");
        }
        List<PoiInfo> list2 = this.f7498f;
        if (list2 != null && !list2.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i3 = 0; i3 < this.f7498f.size(); i3++) {
                PoiInfo poiInfo = this.f7498f.get(i3);
                if (poiInfo != null) {
                    stringBuffer.append("\n address = ");
                    stringBuffer.append(poiInfo.getAddress());
                    stringBuffer.append("; phoneNumber = ");
                    stringBuffer.append(poiInfo.getPhoneNum());
                    stringBuffer.append("; uid = ");
                    stringBuffer.append(poiInfo.getUid());
                    stringBuffer.append("; postCode = ");
                    stringBuffer.append(poiInfo.getPostCode());
                    stringBuffer.append("; name = ");
                    stringBuffer.append(poiInfo.getName());
                    stringBuffer.append("; location = ");
                    stringBuffer.append(poiInfo.getLocation());
                    stringBuffer.append("; city = ");
                    stringBuffer.append(poiInfo.getCity());
                    stringBuffer.append("; direction = ");
                    stringBuffer.append(poiInfo.getDirection());
                    stringBuffer.append("; distance = ");
                    stringBuffer.append(poiInfo.getDistance());
                    if (poiInfo.getParentPoi() != null) {
                        stringBuffer.append("\n parentPoiAddress = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiAddress());
                        stringBuffer.append("; parentPoiDirection = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDirection());
                        stringBuffer.append("; parentPoiDistance = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiDistance());
                        stringBuffer.append("; parentPoiName = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiName());
                        stringBuffer.append("; parentPoiTag = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiTag());
                        stringBuffer.append("; parentPoiUid = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiUid());
                        stringBuffer.append("; parentPoiLocation = ");
                        stringBuffer.append(poiInfo.getParentPoi().getParentPoiLocation());
                    }
                }
            }
            stringBuffer.append("\n #PoiList Info  END# \n");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.f7493a);
        parcel.writeString(this.f7494b);
        parcel.writeParcelable(this.f7495c, 0);
        parcel.writeValue(this.f7496d);
        parcel.writeTypedList(this.f7498f);
        parcel.writeString(this.f7499g);
        parcel.writeTypedList(this.f7500h);
    }
}
