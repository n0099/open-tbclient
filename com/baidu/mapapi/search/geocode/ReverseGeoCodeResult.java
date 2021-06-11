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
    public String f7253a;

    /* renamed from: b  reason: collision with root package name */
    public String f7254b;

    /* renamed from: c  reason: collision with root package name */
    public AddressComponent f7255c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7256d;

    /* renamed from: e  reason: collision with root package name */
    public int f7257e;

    /* renamed from: f  reason: collision with root package name */
    public List<PoiInfo> f7258f;

    /* renamed from: g  reason: collision with root package name */
    public String f7259g;

    /* renamed from: h  reason: collision with root package name */
    public List<PoiRegionsInfo> f7260h;

    /* renamed from: i  reason: collision with root package name */
    public int f7261i;

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
        this.f7253a = parcel.readString();
        this.f7254b = parcel.readString();
        this.f7255c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.f7256d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7258f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7259g = parcel.readString();
        this.f7260h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.f7261i;
    }

    public String getAddress() {
        return this.f7254b;
    }

    public AddressComponent getAddressDetail() {
        return this.f7255c;
    }

    public String getBusinessCircle() {
        return this.f7253a;
    }

    public int getCityCode() {
        return this.f7257e;
    }

    public LatLng getLocation() {
        return this.f7256d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f7258f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.f7260h;
    }

    public String getSematicDescription() {
        return this.f7259g;
    }

    public void setAdcode(int i2) {
        this.f7261i = i2;
    }

    public void setAddress(String str) {
        this.f7254b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.f7255c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.f7253a = str;
    }

    public void setCityCode(int i2) {
        this.f7257e = i2;
    }

    public void setLocation(LatLng latLng) {
        this.f7256d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f7258f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.f7260h = list;
    }

    public void setSematicDescription(String str) {
        this.f7259g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
        stringBuffer.append("businessCircle = ");
        stringBuffer.append(this.f7253a);
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f7254b);
        stringBuffer.append("; location = ");
        stringBuffer.append(this.f7256d);
        stringBuffer.append("; sematicDescription = ");
        stringBuffer.append(this.f7259g);
        if (this.f7255c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
            stringBuffer.append("streetNumber = ");
            stringBuffer.append(this.f7255c.streetNumber);
            stringBuffer.append("; street = ");
            stringBuffer.append(this.f7255c.street);
            stringBuffer.append("; town = ");
            stringBuffer.append(this.f7255c.town);
            stringBuffer.append("; district = ");
            stringBuffer.append(this.f7255c.district);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.f7255c.city);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.f7255c.province);
            stringBuffer.append("; countryName = ");
            stringBuffer.append(this.f7255c.countryName);
            stringBuffer.append("; countryCode = ");
            stringBuffer.append(this.f7255c.countryCode);
            stringBuffer.append("; adcode = ");
            stringBuffer.append(this.f7255c.adcode);
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.f7255c.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.f7255c.distance);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        List<PoiRegionsInfo> list = this.f7260h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i2 = 0; i2 < this.f7260h.size(); i2++) {
                PoiRegionsInfo poiRegionsInfo = this.f7260h.get(i2);
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
        List<PoiInfo> list2 = this.f7258f;
        if (list2 != null && !list2.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i3 = 0; i3 < this.f7258f.size(); i3++) {
                PoiInfo poiInfo = this.f7258f.get(i3);
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
        parcel.writeString(this.f7253a);
        parcel.writeString(this.f7254b);
        parcel.writeParcelable(this.f7255c, 0);
        parcel.writeValue(this.f7256d);
        parcel.writeTypedList(this.f7258f);
        parcel.writeString(this.f7259g);
        parcel.writeTypedList(this.f7260h);
    }
}
