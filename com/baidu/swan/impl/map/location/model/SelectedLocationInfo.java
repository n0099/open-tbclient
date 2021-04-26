package com.baidu.swan.impl.map.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SelectedLocationInfo implements Parcelable {
    public static final String ADDRESS = "address";
    public static final Parcelable.Creator<SelectedLocationInfo> CREATOR = new a();
    public static final String LATITUDE = "latitude";
    public static final String LOCATION_KEY = "SelectedLocationInfo";
    public static final String LONGITUDE = "longitude";
    public static final String NAME = "name";
    public String mAddress;
    public double mLatitude;
    public double mLongitude;
    public String mName;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SelectedLocationInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SelectedLocationInfo createFromParcel(Parcel parcel) {
            return new SelectedLocationInfo(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SelectedLocationInfo[] newArray(int i2) {
            return new SelectedLocationInfo[i2];
        }
    }

    public /* synthetic */ SelectedLocationInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            jSONObject.put("address", this.mAddress);
            jSONObject.put("latitude", this.mLatitude);
            jSONObject.put("longitude", this.mLongitude);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
    }

    public SelectedLocationInfo(String str, String str2, LatLng latLng) {
        this.mName = str;
        this.mAddress = str2;
        if (latLng == null) {
            return;
        }
        this.mLatitude = latLng.latitude;
        this.mLongitude = latLng.longitude;
    }

    public SelectedLocationInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
    }
}
