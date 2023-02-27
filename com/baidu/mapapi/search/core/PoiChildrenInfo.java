package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new f();
    public String a;
    public String b;
    public String c;
    public String d;
    public LatLng e;
    public String f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PoiChildrenInfo() {
    }

    public String getAddress() {
        return this.f;
    }

    public LatLng getLocation() {
        return this.e;
    }

    public String getName() {
        return this.b;
    }

    public String getShowName() {
        return this.c;
    }

    public String getTag() {
        return this.d;
    }

    public String getUid() {
        return this.a;
    }

    public PoiChildrenInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f = parcel.readString();
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setLocation(LatLng latLng) {
        this.e = latLng;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setShowName(String str) {
        this.c = str;
    }

    public void setTag(String str) {
        this.d = str;
    }

    public void setUid(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: ");
        stringBuffer.append("uid = ");
        stringBuffer.append(this.a);
        stringBuffer.append("; name = ");
        stringBuffer.append(this.b);
        stringBuffer.append("; showName = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; location = ");
        LatLng latLng = this.e;
        if (latLng != null) {
            stringBuffer.append(latLng.toString());
        } else {
            stringBuffer.append(StringUtil.NULL_STRING);
        }
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeString(this.f);
    }
}
