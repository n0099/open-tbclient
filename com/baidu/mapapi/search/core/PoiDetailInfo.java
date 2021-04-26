package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public class PoiDetailInfo implements Parcelable {
    public static final Parcelable.Creator<PoiDetailInfo> CREATOR = new f();
    public String address;
    public String area;
    public int checkinNum;
    public String city;
    public int commentNum;
    public int detail;
    public String detailUrl;
    public int discountNum;
    public int distance;
    public double environmentRating;
    public double facilityRating;
    public int favoriteNum;
    public int grouponNum;
    public double hygieneRating;
    public int imageNum;
    public LatLng location;
    public String name;
    public LatLng naviLocation;
    public double overallRating;
    public List<PoiChildrenInfo> poiChildrenInfoList;
    public double price;
    public String province;
    public double serviceRating;
    public String shopHours;
    public String streetId;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    public String telephone;
    public String type;
    public String uid;

    public PoiDetailInfo() {
    }

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

    public void setCheckinNum(int i2) {
        this.checkinNum = i2;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCommentNum(int i2) {
        this.commentNum = i2;
    }

    public void setDetail(String str) {
        try {
            this.detail = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            this.detail = 0;
        }
    }

    public void setDetailUrl(String str) {
        this.detailUrl = str;
    }

    public void setDiscountNum(int i2) {
        this.discountNum = i2;
    }

    public void setDistance(int i2) {
        this.distance = i2;
    }

    public void setEnvironmentRating(double d2) {
        this.environmentRating = d2;
    }

    public void setFacilityRating(double d2) {
        this.facilityRating = d2;
    }

    public void setFavoriteNum(int i2) {
        this.favoriteNum = i2;
    }

    public void setGrouponNum(int i2) {
        this.grouponNum = i2;
    }

    public void setHygieneRating(double d2) {
        this.hygieneRating = d2;
    }

    public void setImageNum(int i2) {
        this.imageNum = i2;
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

    public void setOverallRating(double d2) {
        this.overallRating = d2;
    }

    public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
        this.poiChildrenInfoList = list;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setServiceRating(double d2) {
        this.serviceRating = d2;
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

    public void setTasteRating(double d2) {
        this.tasteRating = d2;
    }

    public void setTechnologyRating(double d2) {
        this.technologyRating = d2;
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
        stringBuffer.append("name = ");
        stringBuffer.append(this.name);
        stringBuffer.append("; location = ");
        LatLng latLng = this.location;
        if (latLng != null) {
            stringBuffer.append(latLng.toString());
        } else {
            stringBuffer.append(StringUtil.NULL_STRING);
        }
        stringBuffer.append("; address = ");
        stringBuffer.append(this.address);
        stringBuffer.append("; province = ");
        stringBuffer.append(this.province);
        stringBuffer.append("; city = ");
        stringBuffer.append(this.city);
        stringBuffer.append("; area = ");
        stringBuffer.append(this.area);
        stringBuffer.append("; telephone = ");
        stringBuffer.append(this.telephone);
        stringBuffer.append("; uid = ");
        stringBuffer.append(this.uid);
        stringBuffer.append("; detail = ");
        stringBuffer.append(this.detail);
        stringBuffer.append("; distance = ");
        stringBuffer.append(this.distance);
        stringBuffer.append("; type = ");
        stringBuffer.append(this.type);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.tag);
        stringBuffer.append("; naviLocation = ");
        LatLng latLng2 = this.naviLocation;
        if (latLng2 != null) {
            stringBuffer.append(latLng2.toString());
        } else {
            stringBuffer.append(StringUtil.NULL_STRING);
        }
        stringBuffer.append("; detailUrl = ");
        stringBuffer.append(this.detailUrl);
        stringBuffer.append("; price = ");
        stringBuffer.append(this.price);
        stringBuffer.append("; shopHours = ");
        stringBuffer.append(this.shopHours);
        stringBuffer.append("; overallRating = ");
        stringBuffer.append(this.overallRating);
        stringBuffer.append("; tasteRating = ");
        stringBuffer.append(this.tasteRating);
        stringBuffer.append("; serviceRating = ");
        stringBuffer.append(this.serviceRating);
        stringBuffer.append("; environmentRating = ");
        stringBuffer.append(this.environmentRating);
        stringBuffer.append("; facilityRating = ");
        stringBuffer.append(this.facilityRating);
        stringBuffer.append("; hygieneRating = ");
        stringBuffer.append(this.hygieneRating);
        stringBuffer.append("; technologyRating = ");
        stringBuffer.append(this.technologyRating);
        stringBuffer.append("; imageNum = ");
        stringBuffer.append(this.imageNum);
        stringBuffer.append("; grouponNum = ");
        stringBuffer.append(this.grouponNum);
        stringBuffer.append("; discountNum = ");
        stringBuffer.append(this.discountNum);
        stringBuffer.append("; commentNum = ");
        stringBuffer.append(this.commentNum);
        stringBuffer.append("; favoriteNum = ");
        stringBuffer.append(this.favoriteNum);
        stringBuffer.append("; checkinNum = ");
        stringBuffer.append(this.checkinNum);
        List<PoiChildrenInfo> list = this.poiChildrenInfoList;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.poiChildrenInfoList.size(); i2++) {
                stringBuffer.append("; The ");
                stringBuffer.append(i2);
                stringBuffer.append(" poiChildrenInfo is: ");
                PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i2);
                if (poiChildrenInfo != null) {
                    stringBuffer.append(poiChildrenInfo.toString());
                } else {
                    stringBuffer.append(StringUtil.NULL_STRING);
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.location, i2);
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
        parcel.writeParcelable(this.naviLocation, i2);
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
