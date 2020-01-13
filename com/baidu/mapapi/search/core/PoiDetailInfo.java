package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes6.dex */
public class PoiDetailInfo implements Parcelable {
    public static final Parcelable.Creator<PoiDetailInfo> CREATOR = new f();
    private String address;
    private String area;
    public int checkinNum;
    private String city;
    public int commentNum;
    private int detail;
    public String detailUrl;
    public int discountNum;
    public int distance;
    public double environmentRating;
    public double facilityRating;
    public int favoriteNum;
    public int grouponNum;
    public double hygieneRating;
    public int imageNum;
    private LatLng location;
    private String name;
    public LatLng naviLocation;
    public double overallRating;
    private List<PoiChildrenInfo> poiChildrenInfoList;
    public double price;
    private String province;
    public double serviceRating;
    public String shopHours;
    private String streetId;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    private String telephone;
    public String type;
    private String uid;

    public PoiDetailInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiDetailInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.area = parcel.readString();
        this.telephone = parcel.readString();
        this.uid = parcel.readString();
        this.streetId = parcel.readString();
        this.detail = parcel.readInt();
        this.distance = parcel.readInt();
        this.type = parcel.readString();
        this.tag = parcel.readString();
        this.naviLocation = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.detailUrl = parcel.readString();
        this.price = parcel.readDouble();
        this.shopHours = parcel.readString();
        this.overallRating = parcel.readDouble();
        this.tasteRating = parcel.readDouble();
        this.serviceRating = parcel.readDouble();
        this.environmentRating = parcel.readDouble();
        this.facilityRating = parcel.readDouble();
        this.hygieneRating = parcel.readDouble();
        this.technologyRating = parcel.readDouble();
        this.imageNum = parcel.readInt();
        this.grouponNum = parcel.readInt();
        this.discountNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.favoriteNum = parcel.readInt();
        this.checkinNum = parcel.readInt();
        this.poiChildrenInfoList = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
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

    public int getCheckinNum() {
        return this.checkinNum;
    }

    public String getCity() {
        return this.city;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public int getDetail() {
        return this.detail;
    }

    public String getDetailUrl() {
        return this.detailUrl;
    }

    public int getDiscountNum() {
        return this.discountNum;
    }

    public int getDistance() {
        return this.distance;
    }

    public double getEnvironmentRating() {
        return this.environmentRating;
    }

    public double getFacilityRating() {
        return this.facilityRating;
    }

    public int getFavoriteNum() {
        return this.favoriteNum;
    }

    public int getGrouponNum() {
        return this.grouponNum;
    }

    public double getHygieneRating() {
        return this.hygieneRating;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public LatLng getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public LatLng getNaviLocation() {
        return this.naviLocation;
    }

    public double getOverallRating() {
        return this.overallRating;
    }

    public List<PoiChildrenInfo> getPoiChildrenInfoList() {
        return this.poiChildrenInfoList;
    }

    public double getPrice() {
        return this.price;
    }

    public String getProvince() {
        return this.province;
    }

    public double getServiceRating() {
        return this.serviceRating;
    }

    public String getShopHours() {
        return this.shopHours;
    }

    public String getStreetId() {
        return this.streetId;
    }

    public String getTag() {
        return this.tag;
    }

    public double getTasteRating() {
        return this.tasteRating;
    }

    public double getTechnologyRating() {
        return this.technologyRating;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getType() {
        return this.type;
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

    public void setCheckinNum(int i) {
        this.checkinNum = i;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCommentNum(int i) {
        this.commentNum = i;
    }

    public void setDetail(String str) {
        try {
            this.detail = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            this.detail = 0;
        }
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setDiscountNum(int i) {
        this.discountNum = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setEnvironmentRating(double d) {
        this.environmentRating = d;
    }

    public void setFacilityRating(double d) {
        this.facilityRating = d;
    }

    public void setFavoriteNum(int i) {
        this.favoriteNum = i;
    }

    public void setGrouponNum(int i) {
        this.grouponNum = i;
    }

    public void setHygieneRating(double d) {
        this.hygieneRating = d;
    }

    public void setImageNum(int i) {
        this.imageNum = i;
    }

    public void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNaviLocation(LatLng latLng) {
        this.naviLocation = latLng;
    }

    public void setOverallRating(double d) {
        this.overallRating = d;
    }

    public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
        this.poiChildrenInfoList = list;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setServiceRating(double d) {
        this.serviceRating = d;
    }

    public void setShopHours(String str) {
        this.shopHours = str;
    }

    public void setStreetId(String str) {
        this.streetId = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTasteRating(double d) {
        this.tasteRating = d;
    }

    public void setTechnologyRating(double d) {
        this.technologyRating = d;
    }

    public void setTelephone(String str) {
        this.telephone = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiDetailInfo: ");
        stringBuffer.append("name = ").append(this.name);
        stringBuffer.append("; location = ");
        if (this.location != null) {
            stringBuffer.append(this.location.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; address = ").append(this.address);
        stringBuffer.append("; province = ").append(this.province);
        stringBuffer.append("; city = ").append(this.city);
        stringBuffer.append("; area = ").append(this.area);
        stringBuffer.append("; telephone = ").append(this.telephone);
        stringBuffer.append("; uid = ").append(this.uid);
        stringBuffer.append("; detail = ").append(this.detail);
        stringBuffer.append("; distance = ").append(this.distance);
        stringBuffer.append("; type = ").append(this.type);
        stringBuffer.append("; tag = ").append(this.tag);
        stringBuffer.append("; naviLocation = ");
        if (this.naviLocation != null) {
            stringBuffer.append(this.naviLocation.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; detailUrl = ").append(this.detailUrl);
        stringBuffer.append("; price = ").append(this.price);
        stringBuffer.append("; shopHours = ").append(this.shopHours);
        stringBuffer.append("; overallRating = ").append(this.overallRating);
        stringBuffer.append("; tasteRating = ").append(this.tasteRating);
        stringBuffer.append("; serviceRating = ").append(this.serviceRating);
        stringBuffer.append("; environmentRating = ").append(this.environmentRating);
        stringBuffer.append("; facilityRating = ").append(this.facilityRating);
        stringBuffer.append("; hygieneRating = ").append(this.hygieneRating);
        stringBuffer.append("; technologyRating = ").append(this.technologyRating);
        stringBuffer.append("; imageNum = ").append(this.imageNum);
        stringBuffer.append("; grouponNum = ").append(this.grouponNum);
        stringBuffer.append("; discountNum = ").append(this.discountNum);
        stringBuffer.append("; commentNum = ").append(this.commentNum);
        stringBuffer.append("; favoriteNum = ").append(this.favoriteNum);
        stringBuffer.append("; checkinNum = ").append(this.checkinNum);
        if (this.poiChildrenInfoList != null && !this.poiChildrenInfoList.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.poiChildrenInfoList.size()) {
                    break;
                }
                stringBuffer.append("; The ").append(i2).append(" poiChildrenInfo is: ");
                PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i2);
                if (poiChildrenInfo != null) {
                    stringBuffer.append(poiChildrenInfo.toString());
                } else {
                    stringBuffer.append("null");
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.location, i);
        parcel.writeString(this.address);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.area);
        parcel.writeString(this.telephone);
        parcel.writeString(this.uid);
        parcel.writeString(this.streetId);
        parcel.writeInt(this.detail);
        parcel.writeInt(this.distance);
        parcel.writeString(this.type);
        parcel.writeString(this.tag);
        parcel.writeParcelable(this.naviLocation, i);
        parcel.writeString(this.detailUrl);
        parcel.writeDouble(this.price);
        parcel.writeString(this.shopHours);
        parcel.writeDouble(this.overallRating);
        parcel.writeDouble(this.tasteRating);
        parcel.writeDouble(this.serviceRating);
        parcel.writeDouble(this.environmentRating);
        parcel.writeDouble(this.facilityRating);
        parcel.writeDouble(this.hygieneRating);
        parcel.writeDouble(this.technologyRating);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.grouponNum);
        parcel.writeInt(this.discountNum);
        parcel.writeInt(this.commentNum);
        parcel.writeInt(this.favoriteNum);
        parcel.writeInt(this.checkinNum);
        parcel.writeTypedList(this.poiChildrenInfoList);
    }
}
