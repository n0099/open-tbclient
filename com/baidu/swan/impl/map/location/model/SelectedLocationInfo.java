package com.baidu.swan.impl.map.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class SelectedLocationInfo implements Parcelable {
    private static final String ADDRESS = "address";
    public static final Parcelable.Creator<SelectedLocationInfo> CREATOR = new Parcelable.Creator<SelectedLocationInfo>() { // from class: com.baidu.swan.impl.map.location.model.SelectedLocationInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: D */
        public SelectedLocationInfo createFromParcel(Parcel parcel) {
            return new SelectedLocationInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: md */
        public SelectedLocationInfo[] newArray(int i) {
            return new SelectedLocationInfo[i];
        }
    };
    private static final String LATITUDE = "latitude";
    public static final String LOCATION_KEY = "SelectedLocationInfo";
    private static final String LONGITUDE = "longitude";
    private static final String NAME = "name";
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
            jSONObject.put(ADDRESS, this.mAddress);
            jSONObject.put(LATITUDE, this.mLatitude);
            jSONObject.put(LONGITUDE, this.mLongitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
