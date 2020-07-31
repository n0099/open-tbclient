package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes10.dex */
public class PoiChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new e();
    private String address;
    private LatLng location;
    private String name;
    private String showName;
    private String tag;
    private String uid;

    public PoiChildrenInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiChildrenInfo(Parcel parcel) {
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.showName = parcel.readString();
        this.tag = parcel.readString();
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public LatLng getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getShowName() {
        return this.showName;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setLocation(LatLng latLng) {
        this.location = latLng;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: ");
        stringBuffer.append("uid = ").append(this.uid);
        stringBuffer.append("; name = ").append(this.name);
        stringBuffer.append("; showName = ").append(this.showName);
        stringBuffer.append("; tag = ").append(this.tag);
        stringBuffer.append("; location = ");
        if (this.location != null) {
            stringBuffer.append(this.location.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; address = ").append(this.address);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.showName);
        parcel.writeString(this.tag);
        parcel.writeParcelable(this.location, i);
        parcel.writeString(this.address);
    }
}
