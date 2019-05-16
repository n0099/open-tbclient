package com.baidu.swan.impl.map.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectedLocationInfo implements Parcelable {
    public static final Parcelable.Creator<SelectedLocationInfo> CREATOR = new Parcelable.Creator<SelectedLocationInfo>() { // from class: com.baidu.swan.impl.map.location.model.SelectedLocationInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: p */
        public SelectedLocationInfo createFromParcel(Parcel parcel) {
            return new SelectedLocationInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fp */
        public SelectedLocationInfo[] newArray(int i) {
            return new SelectedLocationInfo[i];
        }
    };
    public String mAddress;
    public double mLatitude;
    public double mLongitude;
    public String mName;

    public SelectedLocationInfo(String str, String str2, LatLng latLng) {
        this.mName = str;
        this.mAddress = str2;
        if (latLng != null) {
            this.mLatitude = latLng.latitude;
            this.mLongitude = latLng.longitude;
        }
    }

    private SelectedLocationInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            jSONObject.put("address", this.mAddress);
            jSONObject.put("latitude", this.mLatitude);
            jSONObject.put("longitude", this.mLongitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
