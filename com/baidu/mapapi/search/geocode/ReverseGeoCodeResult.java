package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes20.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR = new b();
    private String a;
    private String b;
    private AddressComponent c;
    private LatLng d;
    private int e;
    private List<PoiInfo> f;
    private String g;
    private List<PoiRegionsInfo> h;
    private int i;

    /* loaded from: classes20.dex */
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

        /* JADX INFO: Access modifiers changed from: protected */
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
        public void writeToParcel(Parcel parcel, int i) {
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

    /* loaded from: classes20.dex */
    public static class PoiRegionsInfo implements Parcelable {
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR = new d();
        public String directionDesc;
        public String regionName;
        public String regionTag;

        public PoiRegionsInfo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
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
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.directionDesc);
            parcel.writeString(this.regionName);
            parcel.writeString(this.regionTag);
        }
    }

    public ReverseGeoCodeResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdcode() {
        return this.i;
    }

    public String getAddress() {
        return this.b;
    }

    public AddressComponent getAddressDetail() {
        return this.c;
    }

    public String getBusinessCircle() {
        return this.a;
    }

    public int getCityCode() {
        return this.e;
    }

    public LatLng getLocation() {
        return this.d;
    }

    public List<PoiInfo> getPoiList() {
        return this.f;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        return this.h;
    }

    public String getSematicDescription() {
        return this.g;
    }

    public void setAdcode(int i) {
        this.i = i;
    }

    public void setAddress(String str) {
        this.b = str;
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        this.c = addressComponent;
    }

    public void setBusinessCircle(String str) {
        this.a = str;
    }

    public void setCityCode(int i) {
        this.e = i;
    }

    public void setLocation(LatLng latLng) {
        this.d = latLng;
    }

    public void setPoiList(List<PoiInfo> list) {
        this.f = list;
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        this.h = list;
    }

    public void setSematicDescription(String str) {
        this.g = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
        stringBuffer.append("businessCircle = ").append(this.a);
        stringBuffer.append("; address = ").append(this.b);
        stringBuffer.append("; location = ").append(this.d);
        stringBuffer.append("; sematicDescription = ").append(this.g);
        if (this.c != null) {
            stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
            stringBuffer.append("streetNumber = ").append(this.c.streetNumber);
            stringBuffer.append("; street = ").append(this.c.street);
            stringBuffer.append("; town = ").append(this.c.town);
            stringBuffer.append("; district = ").append(this.c.district);
            stringBuffer.append("; city = ").append(this.c.city);
            stringBuffer.append("; province = ").append(this.c.province);
            stringBuffer.append("; countryName = ").append(this.c.countryName);
            stringBuffer.append("; countryCode = ").append(this.c.countryCode);
            stringBuffer.append("; adcode = ").append(this.c.adcode);
            stringBuffer.append("; direction = ").append(this.c.direction);
            stringBuffer.append("; distance = ").append(this.c.distance);
            stringBuffer.append("\n#AddressComponent Info END# \n");
        }
        if (this.h != null && !this.h.isEmpty()) {
            stringBuffer.append("\n#PoiRegions Info  BEGIN#");
            for (int i = 0; i < this.h.size(); i++) {
                PoiRegionsInfo poiRegionsInfo = this.h.get(i);
                if (poiRegionsInfo != null) {
                    stringBuffer.append("\ndirectionDesc = ").append(poiRegionsInfo.getDirectionDesc());
                    stringBuffer.append("; regionName = ").append(poiRegionsInfo.getRegionName());
                    stringBuffer.append("; regionTag = ").append(poiRegionsInfo.getRegionTag());
                }
            }
            stringBuffer.append("\n#PoiRegions Info  END# \n");
        }
        if (this.f != null && !this.f.isEmpty()) {
            stringBuffer.append("\n #PoiList Info  BEGIN#");
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                PoiInfo poiInfo = this.f.get(i2);
                if (poiInfo != null) {
                    stringBuffer.append("\n address = ").append(poiInfo.getAddress());
                    stringBuffer.append("; phoneNumber = ").append(poiInfo.getPhoneNum());
                    stringBuffer.append("; uid = ").append(poiInfo.getUid());
                    stringBuffer.append("; postCode = ").append(poiInfo.getPostCode());
                    stringBuffer.append("; name = ").append(poiInfo.getName());
                    stringBuffer.append("; location = ").append(poiInfo.getLocation());
                    stringBuffer.append("; city = ").append(poiInfo.getCity());
                    stringBuffer.append("; direction = ").append(poiInfo.getDirection());
                    stringBuffer.append("; distance = ").append(poiInfo.getDistance());
                    if (poiInfo.getParentPoi() != null) {
                        stringBuffer.append("\n parentPoiAddress = ").append(poiInfo.getParentPoi().getParentPoiAddress());
                        stringBuffer.append("; parentPoiDirection = ").append(poiInfo.getParentPoi().getParentPoiDirection());
                        stringBuffer.append("; parentPoiDistance = ").append(poiInfo.getParentPoi().getParentPoiDistance());
                        stringBuffer.append("; parentPoiName = ").append(poiInfo.getParentPoi().getParentPoiName());
                        stringBuffer.append("; parentPoiTag = ").append(poiInfo.getParentPoi().getParentPoiTag());
                        stringBuffer.append("; parentPoiUid = ").append(poiInfo.getParentPoi().getParentPoiUid());
                        stringBuffer.append("; parentPoiLocation = ").append(poiInfo.getParentPoi().getParentPoiLocation());
                    }
                }
            }
            stringBuffer.append("\n #PoiList Info  END# \n");
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, 0);
        parcel.writeValue(this.d);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeTypedList(this.h);
    }
}
